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
package org.eclipse.egf.pattern.ui.editor.page;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.DataBindingHelper;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.egf.common.ui.viewers.IButtonClickedListener;
import org.eclipse.egf.common.ui.viewers.ViewerWithAddAndRemove;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.AbstractPatternGenerator;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.internal.editor.DefaultPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.InternalMethodHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.InternalMethodHelper;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.InternalMethodsLabelProvider;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.MethodActionHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.MethodPatternCodeDetailsViewer;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.MethodPatternCodeViewer;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.InternalMethodHelper.IInternalMethodHandlerFactory;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author Guillaume Brocard
 */
public class PatternImplementationPage extends AbstractPatternPage {
  
  /**
   * Page id.
   */
  public static final String ID = "egf_pattern_implementation_page"; //$NON-NLS-1$
  
  /**
   * Help context id.
   */
  protected static final String HELP_CONTEXT_ID = PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + ID;
  
  /**
   * List of effectively handled internal methods.
   */
  protected List<InternalMethodHandler> _handledMethods;
  
  /**
   * Internal methods viewer.
   */
  protected StructuredViewer _internalMethodsviewer;
  
  /**
   * Public method viewer.
   */
  protected MethodPatternCodeViewer _publicMethodViewer;
  
  /**
   * Temporary block factory.
   */
  private IBlockFactory _temporaryFactory;

  /**
   * Constructor.
   * @param editor_p
   */
  public PatternImplementationPage(FormEditor editor_p) {
    super(editor_p, ID, Messages.PatternImplementationPage_Title);
    // Initialize external selection triggers.
    getExternalSelectionManager().addExternalHandlerFor(InternalMethodHandler.class, this);
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormPage#dispose()
   */
  @Override
  public void dispose() {
    // Remove external selection triggers.
    getExternalSelectionManager().removeExternalHandler(this, InternalMethodHandler.class);
    super.dispose();
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#handleSelection(java.lang.Object, org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  public void handleSelection(Object firstSelectedObject_p, IStructuredSelection selection_p) {
    // Set active page to current one.
    if (!isActive()) {
      getEditor().setActivePage(ID);
    }
    // Set selection to internal methods viewer.
    if (null != _internalMethodsviewer) {
      _internalMethodsviewer.setSelection(new StructuredSelection(firstSelectedObject_p));
    }
  }

  /**
   * A block factory (for master/details schema).
   * @author Guillaume Brocard
   */
  private interface IBlockFactory {
    
    /**
     * Create a new block.
     * @return
     */
    AbstractPatternBlock createBlock();
    
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#doCreateFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
   *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void doCreateFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p) {
    // Create first block.
    _temporaryFactory = new IBlockFactory() {
      public AbstractPatternBlock createBlock() {
        // Create internal methods block.
        return new InternalMethodsBlock();
      }
    };
    super.doCreateFormContent(toolkit_p, parent_p, patternData_p, managedForm_p);
    // Then create second one.
    _temporaryFactory = new IBlockFactory() {
      public AbstractPatternBlock createBlock() {
        // Create generate method block.
        return new GenerateMethodBlock();
      }
    };
    super.doCreateFormContent(toolkit_p, parent_p, patternData_p, managedForm_p);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#createPatternBlock()
   */
  @Override
  protected AbstractPatternBlock createPatternBlock() {
    // Create block.
    AbstractPatternBlock result = _temporaryFactory.createBlock();
    // Reset temporary factory.
    _temporaryFactory = null;
    return result;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#editorAboutToBeSaved()
   */
  @Override
  public void editorAboutToBeSaved() {
    if (null != _publicMethodViewer) {
      _publicMethodViewer.savePatternCode();
    }
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#dataSaved()
   */
  @Override
  protected void dataSaved() {
    // Clear known data.
    if (null != _handledMethods) {
      // Clear internal list.
      _handledMethods.clear();
      // Reset inputs for both viewers.
      if (null != _internalMethodsviewer) {
        _internalMethodsviewer.setInput(getPatternData());
        _internalMethodsviewer.setSelection(StructuredSelection.EMPTY);
      }
      if (null != _publicMethodViewer) {
        _publicMethodViewer.setInput(getPatternData().getGenerateOperation());
        _publicMethodViewer.setSelection(StructuredSelection.EMPTY);
      }
    }
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#getHelpContextId()
   */
  @Override
  public String getHelpContextId() {
    return HELP_CONTEXT_ID;
  }

  /**
   * Internal methods block.
   * @author Guillaume Brocard
   */
  protected class InternalMethodsBlock extends AbstractPatternBlock implements IDetailsPageProvider {
    
    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternBlock#doCreateMasterFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
     *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
     */
    @Override
    protected Couple<Viewer, IFormPart> doCreateMasterFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p,
        IManagedForm managedForm_p) {
      // Create internal methods section.
      return createInternalMethodsSection(toolkit_p, parent_p, patternData_p);
    }

    /**
     * Create internal methods section.
     * @param toolkit_p
     * @param parent_p
     * @param patternData_p
     */
    protected Couple<Viewer, IFormPart> createInternalMethodsSection(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p) {
      Couple<Viewer, IFormPart> result = null;
      Composite methodsParentComposite = FormHelper.createCompositeWithLayoutType(
        toolkit_p, 
        parent_p, 
        LayoutType.GRID_LAYOUT, 
        1, 
        false
      );
      // Create internal methods section.
      Couple<Section, Composite> methodsCouple = FormHelper.createSectionWithChildComposite(
        toolkit_p, 
        methodsParentComposite, 
        ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
        LayoutType.GRID_LAYOUT, 
        1, 
        false
      );
      Section methodsSection = methodsCouple.getKey();
      methodsSection.setText(Messages.PatternImplementationPage_InternalMethodsSectionText);
      // Get methods composite.
      Composite methodsComposite = methodsCouple.getValue();
      {
        // Create description label.
        toolkit_p.createLabel(methodsComposite, Messages.PatternImplementationPage_InternalMethodsSectionDescriptionLabel);
        // Create methods viewer.
        InternalMethodsViewer viewer = new InternalMethodsViewer(methodsComposite);
        result = new Couple<Viewer, IFormPart>(viewer.getDecoratedViewer(), new SectionPart(methodsSection));
      }
      return result;
    }

    /**
     * @see org.eclipse.ui.forms.MasterDetailsBlock#registerPages(org.eclipse.ui.forms.DetailsPart)
     */
    @Override
    protected void registerPages(DetailsPart detailsPart_p) {
      // Get details page dynamically.
      // Register page provider.
      detailsPart_p.setPageProvider(this);
      // Set limit to 10.
      detailsPart_p.setPageLimit(10);
    }

    /**
     * @see org.eclipse.ui.forms.IDetailsPageProvider#getPage(java.lang.Object)
     */
    public IDetailsPage getPage(final Object key_p) {
      IDetailsPage result = null;
      if (key_p instanceof InternalMethodHandler) {
        result = new InternalMethodsDetails(getMasterPart()) {
          /**
           * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternDetails#getInitialContent()
           */
          @Override
          protected Object getInitialContent() {
            return key_p;
          }
        };
      }
      return result;
    }

    /**
     * @see org.eclipse.ui.forms.IDetailsPageProvider#getPageKey(java.lang.Object)
     */
    public Object getPageKey(Object object_p) {
      // Returns the object as key.
      return object_p;
    }
    
  }

  /**
   * Internal methods handler.<br>
   * Is responsible for the addition and the removal of methods to/from current pattern.
   * @author Guillaume Brocard
   */
  protected class InternalMethodsHandler extends DefaultContentHandler implements IButtonClickedListener {
    
    /**
     * Method name increment.
     */
    private int _methodNameIncrement;
    
    /**
     * Viewer reference.
     */
    private StructuredViewer _viewer;
    

    /**
     * Constructor.
     * @param patternData_p
     */
    protected InternalMethodsHandler(PatternData patternData_p, StructuredViewer viewer_p) {
      super(patternData_p, PatternImplementationPage.this);
      _viewer = viewer_p;
      _methodNameIncrement = 0;
    }

    /**
     * Get next available correct method name.
     * @param pattern_p
     * @return
     */
    @SuppressWarnings("boxing")
    protected String getNewMethodName(Pattern pattern_p) {
      String result = ICommonConstants.EMPTY_STRING;
      // Get existing operations.
      List<EOperation> existingOperations = pattern_p.getEOperations();
      // As long as a name has not been chosen, try to find one.
      while (ICommonConstants.EMPTY_STRING.equals(result)) {
        // Create new name.
        result = MessageFormatHelper.formatMessage(Messages.PatternImplementationPage_NewMethodNamePattern, new Object[] { _methodNameIncrement++ });
        // Check that this name does not already exists in the pool of existing operations.
        for (EOperation operation : existingOperations) {
          // If so, stop search for this name.
          if (result.equals(operation.getName())) {
            result = ICommonConstants.EMPTY_STRING;
            break;
          }
        }
        // Else, new name is acceptable.
      }
      return result;
    }

    /**
     * Create a new method.
     * @return
     */
    protected InternalMethodHandler createNewMethod() {
      AnnotationHandler annotationHandler = new AnnotationHandler();
      Pattern pattern = getPattern();
      EOperation newOperation = AbstractPatternGenerator.addOperation(pattern, getNewMethodName(pattern));
      // Add UID.
      String UID = annotationHandler.addUidAnnotation(newOperation);
      // Get template file path.
      String fileRelativePath = TemplateHelper.getTemplateRelativePath(
        getPatternData().getPattern().getShortId(), 
        getPatternData().getFactoryComponentId(), 
        newOperation.getName(), 
        UID
      );
      // Add read file pattern code.
      annotationHandler.addReadFilePatternCode(newOperation, fileRelativePath);
      // Translate it to java code.
      annotationHandler.translateAnnotations(Collections.singletonList(newOperation));
      // Return resulting method.
      return new InternalMethodHandler(
        PatternImplementationPage.this, 
        newOperation, 
        getPatternData(), 
        _viewer.getContentProvider()
      );
    }

    /**
     * Remove method.
     * @param handler_p
     */
    protected void removeMethod(InternalMethodHandler handler_p) {
      EOperation removedMethod = handler_p.getMethod();
      // Remove method from pattern.
      AbstractPatternGenerator.removeOperation(getPatternData().getPattern(), removedMethod);
    }

    /**
     * Get selected handler.
     * @return null if no method handler is currently selected.
     */
    protected InternalMethodHandler getSelectedHandler() {
      InternalMethodHandler selectedHandler = null;
      ISelection selection = _viewer.getSelection();
      if (selection instanceof IStructuredSelection) {
        selectedHandler = (InternalMethodHandler) ((IStructuredSelection) selection).getFirstElement();
      }
      return selectedHandler;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.IButtonClickedListener#buttonClicked(org.eclipse.swt.widgets.Button, java.lang.Object)
     */
    public void buttonClicked(Button clickedButton_p, Object data_p) {
      IContentProvider contentProvider = _viewer.getContentProvider();
      boolean notifyChange = false;
      if (ViewerWithAddAndRemove.ADD_BUTTON_DATA.equals(data_p)) {
        // Create new method.
        InternalMethodHandler newHandler = createNewMethod();
        // Notify listeners.
        // Create notification.
        IPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
          IPatternModificationNotification.ADDED, 
          getPattern(), 
          null, 
          newHandler.getMethod()
        );
        // Send it to listeners.
        getEditor().sendNotification(notification);
        // Notify the viewer.
        contentProvider.inputChanged(_viewer, null, newHandler);
        notifyChange = true;
      } else if (ViewerWithAddAndRemove.REMOVE_BUTTON_DATA.equals(data_p)) {
        // Remove method.
        InternalMethodHandler oldHandler = getSelectedHandler();
        removeMethod(oldHandler);
        // Notify listeners.
        // Create notification.
        IPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
          IPatternModificationNotification.REMOVED, 
          getPattern(), 
          oldHandler.getMethod(), 
          null
        );
        // Send it to listeners.
        getEditor().sendNotification(notification);
        // Notify the viewer.
        contentProvider.inputChanged(_viewer, oldHandler, null);
        notifyChange = true;
      }
      // Did a change occurred ?
      if (notifyChange) {
        // Then notify editor.
        notifyModification();
      }
    }
    
  }

  /**
   * Pattern internal methods master viewer.<br>
   * Show all methods within a list.
   * @author Guillaume Brocard
   */
  protected class InternalMethodsViewer extends ViewerWithAddAndRemove {
    
    /**
     * Constructor.
     * @param parent_p
     */
    protected InternalMethodsViewer(Composite parent_p) {
      super(parent_p);
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#isEditable()
     */
    @Override
    protected boolean isEditable() {
      return PatternImplementationPage.this.isEditable();
    }

    /**
     * Get selected handler.
     * @return null if no method handler is currently selected.
     */
    protected InternalMethodHandler getSelectedHandler() {
      InternalMethodHandler selectedHandler = null;
      ISelection selection = getDecoratedViewer().getSelection();
      if (selection instanceof IStructuredSelection) {
        selectedHandler = (InternalMethodHandler) ((IStructuredSelection) selection).getFirstElement();
      }
      return selectedHandler;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ViewerWithAddAndRemove#createRemoveHandler()
     */
    @Override
    protected SelectionChangedHandler createRemoveHandler() {
      // Do not allow to delete internal methods which are not modifiable.
      SelectionChangedHandler removeHandler = new SelectionChangedHandler() {
        @Override
        protected boolean doHandleSelection(ISelection selection_p) {
          boolean result = false;
          InternalMethodHandler selectedHandler = getSelectedHandler();
          if (null != selectedHandler) {
            result = selectedHandler.isModifiable();
          }
          return result;
        }
      };
      // Return handler.
      return removeHandler;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#createViewer(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected StructuredViewer createViewer(Composite composite_p) {
      FormToolkit toolkit = getManagedForm().getToolkit();
      Composite listComposite = FormHelper.createCompositeWithLayoutType(toolkit, composite_p, LayoutType.GRID_LAYOUT, 1, false);
      _internalMethodsviewer = new ListViewer(listComposite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
      FormHelper.updateControlLayoutDataWithLayoutTypeData(_internalMethodsviewer.getControl(), LayoutType.GRID_LAYOUT);
      _internalMethodsviewer.setContentProvider(new InternalMethodsContentProvider());
      _internalMethodsviewer.setLabelProvider(new InternalMethodsLabelProvider());
      _internalMethodsviewer.setSorter(new ViewerSorter());
      _internalMethodsviewer.setInput(getPatternData());
      toolkit.adapt(listComposite);
      setButtonClickedListener(new InternalMethodsHandler(getPatternData(), _internalMethodsviewer));
      return _internalMethodsviewer;
    }
    
  }

  /**
   * Internal methods content provider.
   * @author Guillaume Brocard
   */
  protected class InternalMethodsContentProvider extends AbstractPatternPageContentProvider {
    
    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#getViewer()
     */
    @Override
    protected ListViewer getViewer() {
      return (ListViewer) super.getViewer();
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doDispose()
     */
    @Override
    protected void doDispose() {
      // Nothing to do yet.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementUpdated(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
      // Update viewer.
      getViewer().update(newInput_p, null);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementsAdded(java.lang.Object)
     */
    @Override
    protected void doHandleElementsAdded(Object addedElements_p) {
      // Add new handler to internal list.
      _handledMethods.add((InternalMethodHandler) addedElements_p);
      // Update viewer.
      getViewer().add(addedElements_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementsRemoved(java.lang.Object)
     */
    @Override
    protected void doHandleElementsRemoved(Object removedElements_p) {
      // Remove handler from internal list.
      _handledMethods.remove(removedElements_p);
      // Update viewer.
      getViewer().remove(removedElements_p);
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement_p) {
      InternalMethodHandler[] handlers = null;
      if (inputElement_p instanceof PatternData) {
        // Get operations.
        final PatternData patternData = (PatternData) inputElement_p;
        // Make sure list of handled methods is created/cleared.
        if (null == _handledMethods) {
          _handledMethods = new ArrayList<InternalMethodHandler>(0);
        } else {
          _handledMethods.clear();
        }
        // Create internal method handler factory.
        IInternalMethodHandlerFactory factory = new IInternalMethodHandlerFactory() {
          public InternalMethodHandler createNewHandler(EOperation method_p) {
            return new InternalMethodHandler(PatternImplementationPage.this, method_p, patternData, getViewer().getContentProvider());
          }
        };
        handlers = InternalMethodHelper.getInternalMethodsFromInput(patternData, factory);
        Collections.addAll(_handledMethods, handlers);
      }
      return handlers;
    }
    
  }

  /**
   * Internal methods details.
   * @author Guillaume Brocard
   */
  protected abstract class InternalMethodsDetails extends AbstractPatternDetails {
    
    /**
     * Constructor.
     * @param masterPart_p
     */
    public InternalMethodsDetails(IFormPart masterPart_p) {
      super(masterPart_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternDetails#doCreateContents(org.eclipse.ui.forms.widgets.FormToolkit,
     *      org.eclipse.swt.widgets.Composite, java.lang.Object)
     */
    @Override
    protected void doCreateContents(FormToolkit toolkit_p, Composite parent_p, Object initialContent_p) {
      InternalMethodHandler methodHandler = (InternalMethodHandler) initialContent_p;
      // Link listener.
      InternalMethodLinkListener listener = new InternalMethodLinkListener();
      listener.setSelectedHandler(methodHandler);
      // Update parent composite.
      FormHelper.updateCompositeLayoutWithLayoutType(parent_p, LayoutType.GRID_LAYOUT, 1, false);
      // Create method section.
      Couple<Section, Composite> methodCouple = FormHelper.createSectionWithChildComposite(
        toolkit_p, 
        parent_p, 
        ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED, 
        LayoutType.GRID_LAYOUT,
        2, 
        false
      );
      Section methodSection = methodCouple.getKey();
      // Create method name edition text.
      methodSection.setText(Messages.PatternImplementationPage_InternalMethodPropertiesSectionText);
      Composite methodComposite = methodCouple.getValue();
      Couple<Label, Text> methodName = FormHelper.createLabelAndText(
        toolkit_p, 
        methodComposite, 
        Messages.PatternImplementationPage_InternalMethodPropertiesSectionNameLabel, 
        null, 
        listener.isModifiable()
      );
      // Bind text to data.
      Text methodNameText = methodName.getValue();
      TextValidator methodNameValidator = null;
      if (isEditable()) {
        methodNameValidator = new MethodNameValidator(methodNameText, methodHandler);
      }
      DataBindingHelper.bindTextToProperty(methodNameText, InternalMethodLinkListener.DATA_BINDING_METHOD_NAME, listener, methodNameValidator);
      methodNameText.setEditable(isEditable());
      // Create link for template edition.
      Image image = JavaPlugin.getDefault().getImageRegistry().get(JavaPluginImages.IMG_OBJS_TEMPLATE);
      FormHelper.createLinkWithDescription(
        toolkit_p, 
        methodComposite, 
        image, 
        Messages.PatternImplementationPage_InternalMethodPropertiesSectionContentLabel,
        null, 
        Messages.PatternImplementationPage_InternalMethodPropertiesSectionContentDescription, 
        listener
      );
      // Create method content viewer.
      Composite methodContentComposite = FormHelper.createCompositeWithLayoutType(
        toolkit_p, 
        methodComposite, 
        LayoutType.GRID_LAYOUT, 
        1, 
        false
      );
      GridData layoutData = (GridData) methodContentComposite.getLayoutData();
      layoutData.horizontalSpan = 2;
      MethodPatternCodeViewer patternCodeViewer = new MethodPatternCodeViewer(PatternImplementationPage.this, methodContentComposite) {
        /**
         * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#isEditable()
         */
        @Override
        protected boolean isEditable() {
          return PatternImplementationPage.this.isEditable();
        }
      };
      List<String> availableActions = Arrays.asList(PatternConstants.PC_TAG_SUPER);
      // Do not allow to choose super method name.
      patternCodeViewer.initialize(availableActions, false, true);
      patternCodeViewer.setInput(listener.getMethod());
    }
  }

  /**
   * Method name validator.
   * @author Guillaume Brocard
   */
  protected class MethodNameValidator extends TextValidator implements IPatternModificationListener {
    
    /**
     * ERROR KEY : name is already in use.
     */
    protected static final String ERROR_KEY_NOT_UNIQUE_NAME = "NotUniqueMethodName"; //$NON-NLS-1$
    
    /**
     * Initial content, that is the current method handler.
     */
    private InternalMethodHandler _methodHandler;

    /**
     * Constructor.
     * @param control_p
     * @param currentMethodHandler_p
     */
    protected MethodNameValidator(Control control_p, InternalMethodHandler currentMethodHandler_p) {
      super(control_p);
      // Set regular expression.
      setRegularExpression(Messages.PatternImplementationPage_MethodNameRegularExpression);
      // Retain method handler.
      _methodHandler = currentMethodHandler_p;
      // Register as modification listener.
      getEditor().addPatternModificationListener(this);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.TextValidator#onError(java.lang.String)
     */
    @Override
    protected boolean onError(String text_p) {
      boolean result = super.onError(text_p);
      if (!result) {
        // Check that this pattern does not already contain this method name.
        List<EOperation> operations = getPatternData().getPattern().getEOperations();
        for (EOperation operation : operations) {
          result = (operation != _methodHandler.getMethod()) && operation.getName().equals(text_p);
          // Found same name, stop here.
          if (result) {
            addErrorKey(ERROR_KEY_NOT_UNIQUE_NAME);
            break;
          }
        }
      }
      return result;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.TextValidator#getErrorMessageFor(java.lang.String, java.lang.String)
     */
    @Override
    protected String getErrorMessageFor(String errorKey_p, String value_p) {
      Object[] parameters = new Object[] { value_p };
      if (ERROR_KEY_REG_EXP == errorKey_p) {
        return MessageFormatHelper.formatMessage(Messages.PatternImplementationPage_MethodNameMalformedError, parameters);
      } else if (ERROR_KEY_NOT_UNIQUE_NAME == errorKey_p) {
        return MessageFormatHelper.formatMessage(Messages.PatternImplementationPage_MethodNameNotUniqueError, parameters);
      }
      return null;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener#notifyChanged(org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification)
     */
    public void notifyChanged(IPatternModificationNotification notification_p) {
      // Precondition.
      if (IPatternModificationNotification.REMOVED != notification_p.getEventType()) {
        return;
      }
      Object removedObject = notification_p.getOldValue();
      // Testing removed object against handled method.
      if (_methodHandler.getMethod() == removedObject) {
        // Clear corresponding errors.
        clearErrors(getControl());
        // Remove from registered listeners.
        getEditor().removePatternModificationListener(this);
      }
    }
    
  }

  /**
   * Internal methods edition link listener.
   * @author Guillaume Brocard
   */
  protected class InternalMethodLinkListener extends HyperlinkAdapter {
    
    /**
     * Internal method name property binding.
     */
    protected static final String DATA_BINDING_METHOD_NAME = "methodName"; //$NON-NLS-1$
    
    /**
     * Currently selected handler.
     */
    private InternalMethodHandler _selectedHandler;

    /**
     * Set selected handler.
     * @param handler_p
     */
    protected void setSelectedHandler(InternalMethodHandler handler_p) {
      _selectedHandler = handler_p;
    }

    /**
     * Is selected handler modifiable ?
     * @return false if not or no handler is selected.
     */
    protected boolean isModifiable() {
      boolean result = false;
      if (null != _selectedHandler) {
        result = _selectedHandler.isModifiable();
      }
      return result;
    }

    /**
     * Get handled method.
     * @return
     */
    protected EOperation getMethod() {
      EOperation result = null;
      if (null != _selectedHandler) {
        result = _selectedHandler.getMethod();
      }
      return result;
    }

    /**
     * Set new method name.
     * @param newName_p
     */
    public void setMethodName(String newName_p) {
      _selectedHandler.setMethodName(newName_p);
    }

    /**
     * Get method name.
     * @return
     */
    public String getMethodName() {
      if (null != _selectedHandler) {
        return _selectedHandler.getMethodName();
      }
      return ICommonConstants.EMPTY_STRING;
    }

    /**
     * @see org.eclipse.ui.forms.events.HyperlinkAdapter#linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent)
     */
    @Override
    public void linkActivated(HyperlinkEvent he_p) {
      InternalMethodHelper.openMethodContent(getPatternData(), _selectedHandler, isEditable());
    }

    /**
     * Silly JFace data binding counter measure.
     * @param propertyName_p
     * @param listener_p
     */
    public void addPropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
      // Avoid the JFace data-binding not very nice error message.
    }

    /**
     * Silly JFace data binding counter measure.
     * @param propertyName_p
     * @param listener_p
     */
    public void removePropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
      // Avoid the JFace data-binding not very nice error message.
    }
    
  }

  /**
   * Unique public method block.
   * @author Guillaume Brocard
   */
  protected class GenerateMethodBlock extends AbstractPatternBlock implements IDetailsPageProvider {
    
    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternBlock#doCreateMasterFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
     *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
     */
    @Override
    protected Couple<Viewer, IFormPart> doCreateMasterFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p,
        IManagedForm managedForm_p) {
      // Create public method section.
      return createPublicMethodSection(toolkit_p, parent_p, patternData_p);
    }

    /**
     * Create public method section.
     * @param toolkit_p
     * @param parent_p
     * @param patternData_p
     */
    protected Couple<Viewer, IFormPart> createPublicMethodSection(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p) {
      Couple<Viewer, IFormPart> result = null;
      Composite methodParentComposite = FormHelper.createCompositeWithLayoutType(
        toolkit_p, 
        parent_p, 
        LayoutType.GRID_LAYOUT, 
        1, 
        false
      );
      // Create generate method section.
      Couple<Section, Composite> methodCouple = FormHelper.createSectionWithChildComposite(
        toolkit_p, 
        methodParentComposite, 
        ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
        LayoutType.GRID_LAYOUT, 
        1, 
        false
      );
      Section methodSection = methodCouple.getKey();
      methodSection.setText(Messages.PatternImplementationPage_GenerateMethodSectionText);
      // Get method composite.
      Composite methodComposite = methodCouple.getValue();
      {
        // Create description label.
        toolkit_p.createLabel(methodComposite, Messages.PatternImplementationPage_GenerateMethodSectionDescription);
        // Create method viewer.
        _publicMethodViewer = new MethodPatternCodeViewer(PatternImplementationPage.this, methodComposite) {
          /**
           * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#isEditable()
           */
          @Override
          protected boolean isEditable() {
            return PatternImplementationPage.this.isEditable();
          }
        };
        List<String> availableActions = Arrays.asList(PatternConstants.PC_TAG_CALL, PatternConstants.PC_TAG_PATTERN, PatternConstants.PC_TAG_SUPER);
        _publicMethodViewer.initialize(availableActions, true, false);
        // Set initial input.
        _publicMethodViewer.setInput(getPatternData().getGenerateOperation());
        result = new Couple<Viewer, IFormPart>(_publicMethodViewer.getDecoratedViewer(), new SectionPart(methodSection));
      }
      return result;
    }

    /**
     * @see org.eclipse.ui.forms.MasterDetailsBlock#registerPages(org.eclipse.ui.forms.DetailsPart)
     */
    @Override
    protected void registerPages(DetailsPart detailsPart_p) {
      detailsPart_p.setPageLimit(0);
      detailsPart_p.setPageProvider(this);
    }

    /**
     * @see org.eclipse.ui.forms.IDetailsPageProvider#getPage(java.lang.Object)
     */
    public IDetailsPage getPage(final Object key_p) {
      IDetailsPage result = null;
      if (key_p instanceof MethodActionHandler) {
        result = new MethodPatternCodeDetailsViewer(getMasterPart(), PatternImplementationPage.this) {
          /**
           * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternDetails#getInitialContent()
           */
          @Override
          protected Object getInitialContent() {
            return key_p;
          }
        };
      }
      return result;
    }

    /**
     * @see org.eclipse.ui.forms.IDetailsPageProvider#getPageKey(java.lang.Object)
     */
    public Object getPageKey(Object object_p) {
      return object_p;
    }
    
  }
  
}
