/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.edit.IImageKeys;
import org.eclipse.egf.model.provider.FactoryComponentEditPlugin;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage;
import org.eclipse.egf.pattern.ui.editor.page.ExternalSelectionManager;
import org.eclipse.egf.pattern.ui.editor.page.IExternalSelectionProvider;
import org.eclipse.egf.pattern.ui.editor.page.PatternImplementationPage;
import org.eclipse.egf.pattern.ui.editor.page.PatternInheritancePage;
import org.eclipse.egf.pattern.ui.editor.page.PatternOverviewPage;
import org.eclipse.egf.pattern.ui.editor.page.PatternProductionPage;
import org.eclipse.egf.pattern.ui.editor.page.PatternSpecificationPage;
import org.eclipse.egf.pattern.ui.editor.util.PatternEditorPageLinkListener;
import org.eclipse.egf.pattern.ui.internal.editor.DefaultPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.PatternEditorContentOutlinePage;
import org.eclipse.egf.pattern.util.PatternValidator;
import org.eclipse.egf.pattern.validation.PatternValidationHelper;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


/**
 * Pattern editor.<br>
 * @author Guillaume Brocard
 */
public class PatternEditor extends SharedHeaderFormEditor implements ISelectionListener {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternEditor.class.getPackage().getName());
  
  /**
   * Editor id.
   */
  public static final String ID = PatternEditor.class.getName();
  
  /**
   * Page links listener.
   */
  private PatternEditorPageLinkListener _pageLinksListener;
  
  /**
   * Pattern pages.<br>
   * Key is being the index of the page in the editor.
   */
  private HashMap<Integer, AbstractPatternPage> _pages;
  
  /**
   * Collection of modification listeners.
   */
  private Collection<IPatternModificationListener> _modificationListeners;
  
  /**
   * Content outline page.
   */
  private IContentOutlinePage _contentOutlinePage;
  
  /**
   * External selection provider.
   */
  private ExternalSelectionManager _externalSelectionProvider;

  /**
   * @see org.eclipse.ui.forms.editor.SharedHeaderFormEditor#dispose()
   */
  @Override
  public void dispose() {
    // Dispose pages.
    super.dispose();
    // Unregister as selection listener.
    getEditorSite().getPage().removeSelectionListener(this);
    // Release external selection manager.
    if (_externalSelectionProvider != null) {
      _externalSelectionProvider.dispose();
      _externalSelectionProvider = null;
    }
    // Clear registered modification listeners.
    if (_modificationListeners != null) {
      _modificationListeners.clear();
      _modificationListeners = null;
    }
    // Release pages.
    if (_pages != null) {
      _pages.clear();
      _pages = null;
    }
  }

  /**
   * Add a modification listener to this editor.
   * @param listener_p
   */
  public void addPatternModificationListener(IPatternModificationListener listener_p) {
    if (_modificationListeners == null) {
      _modificationListeners = new HashSet<IPatternModificationListener>(1);
    }
    _modificationListeners.add(listener_p);
  }

  /**
   * Remove a modification listener.
   * @param listener_p
   */
  public void removePatternModificationListener(IPatternModificationListener listener_p) {
    if (_modificationListeners != null) {
      _modificationListeners.remove(listener_p);
    }
  }

  /**
   * Get modification listeners.
   * @return
   */
  public IPatternModificationListener[] getModificationListeners() {
    IPatternModificationListener[] result = null;
    if (_modificationListeners != null) {
      result = _modificationListeners.toArray(new IPatternModificationListener[_modificationListeners.size()]);
    }
    if (result == null) {
      result = new IPatternModificationListener[0];
    }
    return result;
  }

  /**
   * Send given notification to all registered listeners.
   * @param notification_p
   */
  public void sendNotification(IPatternModificationNotification notification_p) {
    // Precondition.
    Assert.isNotNull(notification_p);
    // Set pattern data scope.
    if (notification_p instanceof DefaultPatternModificationNotification) {
      ((DefaultPatternModificationNotification) notification_p).setPatternData(getPatternData(null));
    }
    // Get listeners.
    IPatternModificationListener[] listeners = getModificationListeners();
    // Send notification.
    for (IPatternModificationListener patternModificationListener : listeners) {
      try {
        patternModificationListener.notifyChanged(notification_p);
      } catch (Exception e_p) {
        StringBuilder loggerMessage = new StringBuilder("PatternEditor.sendNotification(..) _ "); //$NON-NLS-1$
        loggerMessage.append("Unhandled exception !"); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), e_p);
      }
    }
  }

  /**
   * Get pattern data.
   * @param editorInput_p If null, try and resolve it locally.
   * @return
   */
  public PatternData getPatternData(IEditorInput editorInput_p) {
    PatternData result = null;
    IEditorInput editorInput = editorInput_p;
    // If given editor input is null, then try to get it locally.
    if (editorInput == null) {
      editorInput = getEditorInput();
    }
    // Adapt to PatternData.
    if (editorInput != null) {
      result = (PatternData) editorInput.getAdapter(PatternData.class);
    }
    return result;
  }

  /**
   * Get pattern handler.
   * @return
   */
  public PatternHandler getPatternHandler() {
    return (PatternHandler) getEditorInput().getAdapter(PatternHandler.class);
  }

  /**
   * Get pattern displayable name.
   * @param patternData_p
   * @return
   */
  protected String getPatternDisplayableName(PatternData patternData_p) {
    String displayableName = Messages.PatternEditor_DisplayableName;
    return MessageFormatHelper.formatMessage(
      displayableName, 
      new String[] { 
        patternData_p.getPatternLogicalName() 
      }
    );
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
   */
  @Override
  public void init(IEditorSite site_p, IEditorInput input_p) throws PartInitException {
    super.init(site_p, input_p);
    setPartName(getPatternDisplayableName(getPatternData(input_p)));
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormEditor#addPage(org.eclipse.ui.forms.editor.IFormPage)
   */
  @SuppressWarnings("boxing")
  @Override
  public int addPage(IFormPage page_p) throws PartInitException {
    int result = super.addPage(page_p);
    if (page_p instanceof AbstractPatternPage) {
      if (_pages == null) {
        _pages = new HashMap<Integer, AbstractPatternPage>(1);
      }
      // Auto-boxing.
      _pages.put(result, (AbstractPatternPage) page_p);
    }
    return result;
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
   */
  @Override
  protected void addPages() {
    // Create all pages.
    try {
      addPage(new PatternOverviewPage(this));
      addPage(new PatternProductionPage(this));      
      addPage(new PatternSpecificationPage(this));
      addPage(new PatternInheritancePage(this));
      addPage(new PatternImplementationPage(this));
      // Set first page as active one.
      // Avoids getting the bug that leaves the pattern FC view as the current selection.
      setActivePage(0);
    } catch (PartInitException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("PatternEditor.addPages(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    // Register as selection listener.
    getEditorSite().getPage().addSelectionListener(this);
  }

  /**
   * Get declared pages.<br>
   * The order of returned pages has nothing to do with the order of the pages in the editor.
   * @return A not null, but possibly empty, array of {@link AbstractPatternPage}.
   */
  protected AbstractPatternPage[] getPages() {
    Collection<AbstractPatternPage> result = _pages != null ? _pages.values() : new ArrayList<AbstractPatternPage>(0);
    // Return result as an array.
    return result.toArray(new AbstractPatternPage[result.size()]);
  }

  /**
   * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public void doSave(IProgressMonitor monitor_p) {
    PatternHandler patternHandler = getPatternHandler();
    if (patternHandler != null) {
      // Get pages.
      AbstractPatternPage[] patternPages = getPages();
      // Validate pattern first.
      boolean validationOk = handlePatternValidation(patternPages);
      // If validation is not successful, then do not allow the pattern to be saved.
      if (validationOk == false) {
        return;
      }
      try {
        // Notify pages that the content is about to be saved.
        for (AbstractPatternPage abstractPatternPage : patternPages) {
          abstractPatternPage.editorAboutToBeSaved();
        }
        // First of all, save data.
        patternHandler.save((PatternModel) getEditorInput().getAdapter(PatternModel.class));
        // Then change part name.
        setPartName(getPatternDisplayableName(getPatternData(null)));
        // Notify pages that the content has been saved.
        for (AbstractPatternPage abstractPatternPage : patternPages) {
          abstractPatternPage.editorSaved();
        }
        // Update header.
        updateHeaderContents();
        // Change dirty state.
        editorDirtyStateChanged();
        // Notify listeners.
        IPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
          IPatternModificationNotification.SAVED,
          getPatternData(null), 
          null, 
          null
        );
        sendNotification(notification);
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("PatternEditor.doSave(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }

  /**
   * Handle pattern validation.<br>
   * That includes looking for syntax errors on pages fields.
   * @param patternPages_p
   * @return true if validation was successful, false otherwise.
   */
  protected boolean handlePatternValidation(AbstractPatternPage[] patternPages_p) {
    // Make root diagnostic.
    Pattern pattern = getPatternData(null).getPattern();
    final Object[] data = new Object[] { pattern };
    final DiagnosticChain diagnosticChain = new BasicDiagnostic(
      EObjectValidator.DIAGNOSTIC_SOURCE, 
      0, 
      Messages.PatternEditor_SaveError_PatternModelMessage, 
      data
    );
    Diagnostic diagnostic = PatternValidationHelper.validatePattern(
      pattern, 
      new PatternValidationHelper.IValidationHandler() {
        public DiagnosticChain createErrorRootDiagnostic() {
          // Create sub-diagnostic dedicated to the model validation.
          DiagnosticChain validationDiagnostic = new BasicDiagnostic(
            Diagnostic.ERROR, 
            PatternValidator.DIAGNOSTIC_SOURCE, 
            0,
            Messages.PatternEditor_ValidationErrorMessage, 
            data
          );
          // Add it to root diagnostic.
          diagnosticChain.add((Diagnostic) validationDiagnostic);
          return validationDiagnostic;
        }
      }
    );
    // Is validation already on error ?
    boolean validationError = (Diagnostic.ERROR == diagnostic.getSeverity());
    // Check that no page has an syntax error.
    DiagnosticChain pagesDiagnostic = new BasicDiagnostic(
      Diagnostic.ERROR, 
      PatternValidator.DIAGNOSTIC_SOURCE, 
      0,
      Messages.PatternEditor_SaveError_PagesMessage, 
      data
    );
    boolean syntaxError = false;
    for (AbstractPatternPage pageOnError : patternPages_p) {
      if (pageOnError.hasErrors()) {
        // No page on error yet, add the pages diagnostic to root one.
        if (syntaxError == false) {
          validationError = true;
          syntaxError = true;
          diagnosticChain.add((Diagnostic) pagesDiagnostic);
        }
        pagesDiagnostic.add(
          new BasicDiagnostic(
            Diagnostic.ERROR, 
            PatternValidator.DIAGNOSTIC_SOURCE, 
            0, 
            pageOnError.getTitle(), 
            data
          )
        );
      }
    }
    if (validationError) {
      DiagnosticDialog.open(
        getSite().getShell(), 
        Messages.PatternEditor_SaveErrorTitle, 
        Messages.PatternEditor_SaveErrorMessage, 
        (Diagnostic) diagnosticChain
      );
    }
    return !validationError;
  }

  /**
   * @see org.eclipse.ui.part.EditorPart#doSaveAs()
   */
  @Override
  public void doSaveAs() {
    // Nothing to do here.
  }

  /**
   * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
   */
  @Override
  public boolean isSaveAsAllowed() {
    return false;
  }

  /**
   * Update header contents.
   * @return the containing scrolled form.
   */
  protected ScrolledForm updateHeaderContents() {
    // Get header form.
    ScrolledForm form = getHeaderForm().getForm();
    // Initialize its text.
    form.setText(getPatternDisplayableName(getPatternData(null)));
    form.setImage(ExtendedImageRegistry.INSTANCE.getImage(FactoryComponentEditPlugin.INSTANCE.getImage(IImageKeys.IMG_PATTERN_MODEL_ID)));
    // Decorate heading.
    getToolkit().decorateFormHeading(form.getForm());
    return form;
  }

  /**
   * @see org.eclipse.ui.forms.editor.SharedHeaderFormEditor#createHeaderContents(org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void createHeaderContents(IManagedForm headerForm_p) {
    // Get scrolled form.
    final ScrolledForm form = updateHeaderContents();
    // Create help action.
    Action helpAction = new Action() {
      /**
       * @see org.eclipse.jface.action.Action#run()
       */
      @Override
      public void run() {
        BusyIndicator.showWhile(
          form.getDisplay(), 
          new Runnable() {
            public void run() {
              // Set help context.
              AbstractPatternPage activePage = (AbstractPatternPage) getActivePageInstance();
              PlatformUI.getWorkbench().getHelpSystem().setHelp(form, activePage.getHelpContextId());
              PlatformUI.getWorkbench().getHelpSystem().displayHelp(activePage.getHelpContextId());
            }
          }
        );
      }
    };
    helpAction.setToolTipText(Messages.PatternEditor_HelpButtonToolTip);
    helpAction.setImageDescriptor(JavaPlugin.getDefault().getImageRegistry().getDescriptor(JavaPluginImages.IMG_OBJS_HELP));
    // Declare actions to the tool bar.
    form.getToolBarManager().add(helpAction);
    // Update tool bar.
    form.updateToolBar();
  }

  /**
   * @see org.eclipse.ui.part.MultiPageEditorPart#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Object getAdapter(Class adapter_p) {
    Object result = null;
    if (PatternEditorPageLinkListener.class.equals(adapter_p)) {
      // Adapt PatternEditorPageLinkListener.
      if (_pageLinksListener == null) {
        _pageLinksListener = new PatternEditorPageLinkListener(this);
      }
      result = _pageLinksListener;
    } else if (IContentOutlinePage.class.equals(adapter_p)) {
      // Adapt to outline.
      if (_contentOutlinePage == null) {
        PatternEditorContentOutlinePage patternEditorContentOutlinePage = new PatternEditorContentOutlinePage(
          getPatternData(null), 
          getPatternHandler().isEditable()
        );
        addPatternModificationListener(patternEditorContentOutlinePage);
        _contentOutlinePage = patternEditorContentOutlinePage;
      }
      result = _contentOutlinePage;
    } else if (IExternalSelectionProvider.class.equals(adapter_p) || ExternalSelectionManager.class.equals(adapter_p)) {
      // Adapt to external selection manager.
      if (_externalSelectionProvider == null) {
        _externalSelectionProvider = new ExternalSelectionManager();
      }
      result = _externalSelectionProvider;
    }
    // If no adaptation done, let default behavior act.
    if (result == null) {
      result = super.getAdapter(adapter_p);
    }
    return result;
  }

  /**
   * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
   */
  public void selectionChanged(IWorkbenchPart part_p, ISelection selection_p) {
    // Precondition.
    if (part_p instanceof ContentOutline == false || selection_p instanceof IStructuredSelection == false) {
      return;
    }
    // Fire selection.
    IStructuredSelection selection = (IStructuredSelection) selection_p;
    Object selectedElement = selection.getFirstElement();
    // Get external selection provider.
    IExternalSelectionProvider provider = (IExternalSelectionProvider) getAdapter(IExternalSelectionProvider.class);
    provider.fireExternalSelection(selectedElement, selection);
//    // Set focus back to content outline, if needed.
//    if (_contentOutlinePage.getControl().isFocusControl() == false) {
//      _contentOutlinePage.getControl().forceFocus();
//    }
  }
  
}