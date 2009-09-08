/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.views.fc;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.EventObject;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.ui.helper.ViewerHelper;
import org.eclipse.egf.core.ui.viewers.AbstractAdaptedModelElementContentProvider;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.INavigatorContentExtension;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;


/**
 * Base class to implement {@link IViewPart} that display model element objects.
 * @author fournier
 */
public abstract class AbstractFactoryComponentView extends CommonNavigator {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractFactoryComponentView.class.getPackage().getName());
  /**
   * Memento persistence tag.
   */
  private static final String TAG_MEMENTO = "memento"; //$NON-NLS-1$
  /**
   * Pattern filter persistence tag.
   */
  private static final String TAG_PATTERN_FILTER = "patternFilter"; //$NON-NLS-1$
  /**
   * View memento.
   */
  private IMemento _memento;
  /**
   * Dialog settings for this view.
   */
  private IDialogSettings _viewSettings;
  /**
   * This is the property sheet page.
   */
  private PropertySheetPage _propertySheetPage;
  /**
   * This command stack listener is used to refresh the property sheet page and the tree viewer when a command is performed.
   */
  private CommandStackListener _commandStackListener;
  /**
   * Text field where the end-user enters a pattern to filter displayed FCs.
   */
  private Text _filterText;
  /**
   * Pattern filter used to apply pattern entered by the end-user on the common viewer.
   */
  private PatternFilter _patternFilter;
  /**
   * Holds the entered pattern filter. Necessary to be able to persist it when text widget is disposed.
   */
  private String _enteredPatternFilter;

  /**
   * Constructor.
   */
  protected AbstractFactoryComponentView() {
    // Get the dialog settings section for this view.
    _viewSettings = getDialogSettingsSection();
    // Create a pattern filter.
    _patternFilter = new PatternFilter() {
      /**
       * @see org.eclipse.ui.dialogs.PatternFilter#isParentMatch(org.eclipse.jface.viewers.Viewer, java.lang.Object)
       */
      @Override
      protected boolean isParentMatch(Viewer viewer_p, Object element_p) {
        return false;
      }

      /**
       * @see org.eclipse.ui.dialogs.PatternFilter#isLeafMatch(org.eclipse.jface.viewers.Viewer, java.lang.Object)
       */
      @Override
      protected boolean isLeafMatch(Viewer viewer_p, Object element_p) {
        boolean result = true;
        // Apply pattern matching for factory components only.
        if (element_p instanceof FactoryComponent) {
          result = super.isLeafMatch(viewer_p, element_p);
        }
        return result;
      }
    };
    // Create a listener to update the selection and the property sheet page.
    _commandStackListener = new CommandStackListener() {
      public void commandStackChanged(final EventObject event_P) {
        final Command mostRecentCommand = ((CommandStack) event_P.getSource()).getMostRecentCommand();
        getViewSite().getShell().getDisplay().asyncExec(new Runnable() {
          @SuppressWarnings("synthetic-access")
          public void run() {
            // Try to select the affected objects.
            if (null != mostRecentCommand) {
              Collection<?> affectedObjects = mostRecentCommand.getAffectedObjects();
              // Handle affected Objects.
              handleAffectedObjects(affectedObjects);
            }
            // Refresh the property sheet page
            if (null != _propertySheetPage) {
              _propertySheetPage.refresh();
            }
          }
        });
      }
    };
    // Register this command stack listener.
    getCommandStack().addCommandStackListener(_commandStackListener);
  }

  /**
   * Get dialog settings for this view.
   * @return
   */
  private IDialogSettings getDialogSettingsSection() {
    IDialogSettings dialogSettings = EgfWorkbenchActivator.getDefault().getDialogSettings();
    String sectionName = getClass().getName();
    // Get the dialog setting for this view.
    IDialogSettings section = dialogSettings.getSection(sectionName);
    if (null == section) {
      section = dialogSettings.addNewSection(sectionName);
    }
    return section;
  }

  /**
   * Handle affected objects.<br>
   * Default behavior is to set selection to viewer for given affected objects.
   * @param affectedObjects_p
   */
  protected void handleAffectedObjects(Collection<?> affectedObjects_p) {
    // Set the selection on affected objects.
    setSelectionToViewer(affectedObjects_p);
  }

  /**
   * Return the adapter factory editing domain for this view.
   * @return a not null instance.
   */
  protected abstract AdapterFactoryEditingDomain getEditingDomain();

  /**
   * Return the command stack for this view.
   * @return a not null instance.
   */
  protected CommandStack getCommandStack() {
    return getEditingDomain().getCommandStack();
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Object getAdapter(Class adapter_p) {
    Object result = null;
    // Handles the property sheet view.
    if (adapter_p == IPropertySheetPage.class) {
      result = getPropertySheetPage();
    } else {
      result = super.getAdapter(adapter_p);
    }
    return result;
  }

  /**
   * Return the content provider identifier.
   * @return
   */
  protected abstract String getContentProviderId();

  /**
   * This accesses a cached version of the property sheet.
   */
  public IPropertySheetPage getPropertySheetPage() {
    if (_propertySheetPage == null) {
      AdapterFactoryEditingDomain editingDomain = getEditingDomain();
      _propertySheetPage = new ExtendedPropertySheetPage(editingDomain) {
        /**
         * @see org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage#setSelectionToViewer(java.util.List)
         */
        @Override
        public void setSelectionToViewer(List<?> selection_p) {
          AbstractFactoryComponentView.this.setSelectionToViewer(selection_p);
          AbstractFactoryComponentView.this.setFocus();
        }

        /**
         * @see org.eclipse.ui.views.properties.PropertySheetPage#setActionBars(org.eclipse.ui.IActionBars)
         */
        @Override
        public void setActionBars(IActionBars actionBars_p) {
          super.setActionBars(actionBars_p);
          // TODO hookGlobalActions(actionBars_p);
        }
      };
      // Get the EMF adapter content provider from the view content provider.
      ITreeContentProvider contentProvider = getContentProvider();
      IPropertySourceProvider propertySourceProvider = null;
      if (contentProvider instanceof AbstractAdaptedModelElementContentProvider) {
        propertySourceProvider = ((AbstractAdaptedModelElementContentProvider) contentProvider).getAdapterFactoryContentProvider();
      } else {
        StringBuilder loggerMessage = new StringBuilder("AbstractFactoryComponentView.getPropertySheetPage(..) _ "); //$NON-NLS-1$
        loggerMessage.append("no content provider found for current view!!!"); //$NON-NLS-1$
        __logger.error(loggerMessage.toString());
      }
      // Set it.
      _propertySheetPage.setPropertySourceProvider(propertySourceProvider);
    }
    return _propertySheetPage;
  }

  /**
   * Return the content provider used by this view.
   * @return
   */
  protected ITreeContentProvider getContentProvider() {
    // Get the navigator content service.
    INavigatorContentService navigatorContentService = getCommonViewer().getNavigatorContentService();
    // Get the content extension by id
    INavigatorContentExtension contentExt = navigatorContentService.getContentExtensionById(getContentProviderId());
    ITreeContentProvider contentProvider = contentExt.getContentProvider();
    return contentProvider;
  }

  /**
   * This sets the selection into whichever viewer is active.
   */
  public void setSelectionToViewer(Collection<?> collection) {
    final Collection<?> theSelection = collection;
    // Make sure it's okay.
    //
    if (theSelection != null && !theSelection.isEmpty()) {
      // I don't know if this should be run this deferred
      // because we might have to give the editor a chance to process the viewer update events
      // and hence to update the views first.
      //
      //
      Runnable runnable = new Runnable() {
        public void run() {
          // Try to select the items in the current content viewer of the editor.
          //
          CommonViewer viewer = getCommonViewer();
          if (viewer != null) {
            viewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
          }
        }
      };
      runnable.run();
    }
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#createPartControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createPartControl(Composite parent_p) {
    // Create a composite that hosts the view content.
    Composite composite = new Composite(parent_p, SWT.NONE);
    GridLayout layout = new GridLayout();
    composite.setLayout(layout);
    composite.setLayoutData(new GridData(GridData.FILL_BOTH));
    // Add a widget to enter patterns to filter the viewer.
    createFilterWidget(composite);
    // Create the content provided by the common navigator.
    super.createPartControl(composite);
    // Set a layout data for the common tree viewer.
    CommonViewer commonViewer = getCommonViewer();
    commonViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
    // Add a viewer filter driven by the filter text.
    commonViewer.addFilter(_patternFilter);
  }

  /**
   * Return the memento for this view.
   * @return <code>null</code> can be returned, if it is the first time the view is open.
   */
  protected IMemento getMemento() {
    return _memento;
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#init(org.eclipse.ui.IViewSite, org.eclipse.ui.IMemento)
   */
  @Override
  public void init(IViewSite site_p, IMemento memento_p) throws PartInitException {
    // Specified memento could be null :
    // 1) if the view was not shown when the previous workbench session exited.
    // 2) the view is open by the end-user whereas the workbench is already loaded.
    // Parent class does not a provide an accessor on memento field.
    _memento = restoreViewSettings(memento_p);
    super.init(site_p, _memento);
  }

  /**
   * Restore view settings.
   */
  private IMemento restoreViewSettings(IMemento memento_p) {
    IMemento memento = memento_p;
    // Specified memento is null, let's get it from view settings persistence.
    if (null == memento) {
      // Indeed, if the view was not shown when the previous workbench session exited, no memento is provided.
      // The only chance to restore current state is to get the memento from its persisted representation in view settings (if any).
      String persistedMemento = _viewSettings.get(TAG_MEMENTO);
      if (null != persistedMemento) {
        try {
          memento = XMLMemento.createReadRoot(new StringReader(persistedMemento));
        } catch (WorkbenchException exception_p) {
          // Don't do anything. Simply don't restore the settings
        }
      }
    }
    return memento;
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#dispose()
   */
  @Override
  public void dispose() {
    // Save view settings.
    saveViewSettings();
    // Remove filters.
    getCommonViewer().removeFilter(_patternFilter);
    // Unregister the command stack listener.
    CommandStack commandStack = getCommandStack();
    commandStack.removeCommandStackListener(_commandStackListener);
    // Flush the command stack.
    commandStack.flush();
    super.dispose();
  }

  /**
   * Save the dialog settings for this view.
   */
  private void saveViewSettings() {
    String rootName = getClass().getSimpleName();
    // Create a new memento.
    XMLMemento memento = XMLMemento.createWriteRoot(rootName);
    // Save current state in it.
    // Notice, that the saveState() method is also called by the workbench when exiting before the dispose() method.
    // Nevertheless, we keep this call here, to make sure current state is stored within a running workbench session where the saveState() method is not called.
    saveState(memento);
    StringWriter writer = new StringWriter();
    try {
      memento.save(writer);
      _viewSettings.put(TAG_MEMENTO, writer.getBuffer().toString());
    } catch (IOException exception_p) {
      // Don't do anything. Simply don't store the settings
    }
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#saveState(org.eclipse.ui.IMemento)
   */
  @Override
  public void saveState(IMemento memento_p) {
    // Save the entered pattern filter (if any).
    if (null != _enteredPatternFilter) {
      memento_p.putString(TAG_PATTERN_FILTER, _enteredPatternFilter);
    }
    super.saveState(memento_p);
  }

  /**
   * Restore the pattern filter
   * @param text_p
   * @param memento_p
   */
  private void restorePatternFilter(Text text_p, IMemento memento_p) {
    // Preconditions
    if ((null == memento_p) || (null == text_p)) {
      return;
    }
    String patternFilter = memento_p.getString(TAG_PATTERN_FILTER);
    if (null != patternFilter) {
      text_p.setText(patternFilter);
      // Restore the pattern previously entered by the end-user.
      getPatternFilter().setPattern(patternFilter);
      _enteredPatternFilter = patternFilter;
    }
  }

  /**
   * Creates the message text widget and sets layout data.
   * @param parent_p the parent composite of the message area.
   */
  protected Label createMessageArea(Composite parent_p) {
    Label label = new Label(parent_p, SWT.NONE);
    label.setText(Messages.FactoryComponentView_PatternFilterText_Title);
    label.setFont(parent_p.getFont());
    GridData data = new GridData();
    data.grabExcessVerticalSpace = false;
    data.grabExcessHorizontalSpace = true;
    data.horizontalAlignment = GridData.FILL;
    data.verticalAlignment = GridData.BEGINNING;
    label.setLayoutData(data);
    return label;
  }

  /**
   * Creates the text widget where filter is entered and sets layout data.
   * @param composite the parent composite of the message area.
   */
  protected Text createFilterText(Composite parent_p) {
    Text text = new Text(parent_p, SWT.BORDER);
    GridData data = new GridData();
    data.grabExcessVerticalSpace = false;
    data.grabExcessHorizontalSpace = true;
    data.horizontalAlignment = GridData.FILL;
    data.verticalAlignment = GridData.BEGINNING;
    text.setLayoutData(data);
    text.setFont(parent_p.getFont());
    // Restore previously entered pattern filter.
    restorePatternFilter(text, getMemento());
    // Add a listener to allow the end-user to select something in the tree viewer from the filter text with the down arrow.
    text.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.keyCode == SWT.ARROW_DOWN) {
          setFocus();
        }
      }
    });
    // Add a listener to notify the viewer filter.
    text.addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      @SuppressWarnings("synthetic-access")
      public void modifyText(ModifyEvent event_p) {
        _enteredPatternFilter = getFilterTextValue();
        // Set the new pattern entered by the end-user.
        getPatternFilter().setPattern(_enteredPatternFilter);
        // Refresh the common viewer to take into account the new pattern filter.
        ViewerHelper.refresh(getCommonViewer(), false);
      }
    });
    return text;
  }

  /**
   * Create the filter widget.
   * @param composite_p
   */
  protected void createFilterWidget(Composite composite_p) {
    // Create a field to enter filter value.
    createMessageArea(composite_p);
    _filterText = createFilterText(composite_p);
  }

  /**
   * Return the filter text value.
   * @return the filterText
   */
  protected String getFilterTextValue() {
    return _filterText.getText();
  }

  /**
   * Return the pattern filter.
   * @return the patternFilter
   */
  protected PatternFilter getPatternFilter() {
    return _patternFilter;
  }
}
