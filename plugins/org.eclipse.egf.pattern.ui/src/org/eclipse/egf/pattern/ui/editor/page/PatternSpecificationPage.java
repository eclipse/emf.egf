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

import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.DataBindingHelper;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.common.ui.viewers.IContentHandler;
import org.eclipse.egf.common.ui.viewers.IOrderedContentProvider;
import org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pattern.relations.RelationsFactory;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.internal.editor.DefaultPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.IParameterHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.specification.ConditionViewer;
import org.eclipse.egf.pattern.ui.internal.editor.page.specification.wizard.ParameterWizard;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;


/**
 * @author Guillaume Brocard
 */
public class PatternSpecificationPage extends AbstractPatternPage {
  
  /**
   * Page id.
   */
  public static final String ID = "egf_pattern_specification_page"; //$NON-NLS-1$
  
  /**
   * Help context id.
   */
  protected static final String HELP_CONTEXT_ID = PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + ID;
  
  /**
   * Parameters ordered viewer.
   */
  protected StructuredViewer _parametersViewer;
  
  /**
   * Condition viewer.
   */
  private ConditionViewer _conditionViewer;

  /**
   * Constructor.
   * @param editor_p
   */
  public PatternSpecificationPage(FormEditor editor_p) {
    super(editor_p, ID, Messages.PatternSpecificationPage_Title);
    // Initialize external selection triggers.
    getExternalSelectionManager().addExternalHandlerFor(IParameterHandler.class, this);
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormPage#dispose()
   */
  @Override
  public void dispose() {
    super.dispose();
    if (null != _conditionViewer) {
      _conditionViewer.dispose();
    }
    // Remove external selection triggers.
    getExternalSelectionManager().removeExternalHandler(this, IParameterHandler.class);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#handleSelection(java.lang.Object,
   *      org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  public void handleSelection(Object firstSelectedObject_p, IStructuredSelection selection_p) {
    IParameterHandler selectedHandler = (IParameterHandler) firstSelectedObject_p;
    if (!selectedHandler.isInherited()) {
      if (!isActive()) {
        // Set active page to current one.
        getEditor().setActivePage(ID);
      }
      // Set selection to internal methods viewer.
      if (null != _parametersViewer) {
        _parametersViewer.setSelection(new StructuredSelection(selectedHandler.getParameter()));
      }
    }
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#doCreateFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
   *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void doCreateFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p) {
    // First of all, call intended behavior.
    super.doCreateFormContent(toolkit_p, parent_p, patternData_p, managedForm_p);
    // Then ask for creation of the condition viewer.
    _conditionViewer = new ConditionViewer(parent_p, toolkit_p, patternData_p, getEditor().getPatternHandler(), isEditable());
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#createPatternBlock()
   */
  @Override
  protected AbstractPatternBlock createPatternBlock() {
    return new SpecificationBlock();
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#dataSaved()
   */
  @Override
  protected void dataSaved() {
    if (null != _parametersViewer) {
      _parametersViewer.setInput(ICommonConstants.EMPTY_STRING);
      _parametersViewer.setSelection(StructuredSelection.EMPTY);
    }
  }

  /**
   * Specification block.
   * @author Guillaume Brocard
   */
  protected class SpecificationBlock extends AbstractPatternBlock implements IDetailsPageProvider {
    
    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternBlock#doCreateMasterFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
     *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
     */
    @Override
    protected Couple<Viewer, IFormPart> doCreateMasterFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p,
        IManagedForm managedForm_p) {
      // Create parameters section.
      return createParametersSection(toolkit_p, parent_p, patternData_p);
    }

    /**
     * Create parameters section.
     * @param toolkit_p
     * @param parent_p
     * @param patternData_p
     */
    protected Couple<Viewer, IFormPart> createParametersSection(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p) {
      Couple<Viewer, IFormPart> result = null;
      // Create parameters section.
      Composite parametersParentComposite = FormHelper.createCompositeWithLayoutType(toolkit_p, parent_p, LayoutType.GRID_LAYOUT, 1, false);
      Couple<Section, Composite> parametersCouple = FormHelper.createSectionWithChildComposite(
        toolkit_p, 
        parametersParentComposite,
        ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
        LayoutType.GRID_LAYOUT, 
        1, 
        false
      );
      Section parametersSection = parametersCouple.getKey();
      parametersSection.setText(Messages.PatternSpecificationPage_Section_Parameters_Text);
      // Create composite content.
      Composite parametersComposite = parametersCouple.getValue();
      {
        // Create description label.
        Label parametersLabel = toolkit_p.createLabel(parametersComposite, Messages.PatternSpecificationPage_Parameters_Label_Text);
        GridData plData = new GridData(GridData.FILL_HORIZONTAL);
        plData.horizontalSpan = 2;
        parametersLabel.setLayoutData(plData);
        // Create parameters viewer.
        ParametersViewer parametersViewer = new ParametersViewer(parametersComposite);
        // Get selection viewer.
        result = new Couple<Viewer, IFormPart>(parametersViewer.getDecoratedViewer(), new SectionPart(parametersSection));
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
      // Do retain only 10 parameters max.
      detailsPart_p.setPageLimit(10);
    }

    /**
     * @see org.eclipse.ui.forms.IDetailsPageProvider#getPage(java.lang.Object)
     */
    public IDetailsPage getPage(final Object key_p) {
      IDetailsPage result = null;
      if (key_p instanceof ParameterRelation) {
        result = new ParameterDetails(getMasterPart()) {
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

  /**
   * Parameters tree viewer with regular expression as filter.
   * @author Guillaume Brocard
   */
  protected class ParametersViewer extends OrderedListViewerWithAddAndRemove { 
    
    /**
     * Content handler.
     */
    protected ParametersContentHandler _contentHandler;

    /**
     * Constructor.
     * @param parent_p
     */
    public ParametersViewer(Composite parent_p) {
      super(parent_p);
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.OrderedListViewer#createViewer(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected StructuredViewer createViewer(Composite composite_p) {
      FormToolkit toolkit = getEditor().getToolkit();
      Composite listComposite = FormHelper.createCompositeWithLayoutType(toolkit, composite_p, LayoutType.GRID_LAYOUT, 1, false);
      _parametersViewer = new ListViewer(listComposite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
      Control listControl = _parametersViewer.getControl();
      FormHelper.updateControlLayoutDataWithLayoutTypeData(listControl, LayoutType.GRID_LAYOUT);
      _contentHandler = new ParametersContentHandler();
      ParametersContentProvider parametersContentProvider = new ParametersContentProvider(_contentHandler);
      // Register content provider as listener for model changes.
      getEditor().addPatternModificationListener(parametersContentProvider);
      _parametersViewer.setContentProvider(parametersContentProvider);
      _parametersViewer.setLabelProvider(new ParametersLabelProvider());
      toolkit.adapt(listComposite);
      // Initial input is just needed to notify the content provider.
      // The content is retrieved directly from pattern data.
      _parametersViewer.setInput(ICommonConstants.EMPTY_STRING);
      return _parametersViewer;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove#getContentHandler()
     */
    @Override
    protected IContentHandler getContentHandler() {
      return _contentHandler;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#isEditable()
     */
    @Override
    protected boolean isEditable() {
      return PatternSpecificationPage.this.isEditable();
    }
    
  }

  /**
   * Content provider for parameters of handled pattern.<br>
   * @author Guillaume Brocard
   */
  protected class ParametersContentProvider extends AbstractPatternPageContentProvider implements IOrderedContentProvider, IPatternModificationListener {
    
    /**
     * Content handler.
     */
    private ParametersContentHandler _contentHandler;

    /**
     * Constructor.
     * @param handler_p
     */
    protected ParametersContentProvider(ParametersContentHandler handler_p) {
      _contentHandler = handler_p;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doDispose()
     */
    @Override
    protected void doDispose() {
      // Nothing to do here.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#getViewer()
     */
    @Override
    protected ListViewer getViewer() {
      return (ListViewer) super.getViewer();
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementsAdded(java.lang.Object)
     */
    @Override
    protected void doHandleElementsAdded(Object addedElements_p) {
      getViewer().add(addedElements_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementsRemoved(java.lang.Object)
     */
    @Override
    protected void doHandleElementsRemoved(Object removedElements_p) {
      getViewer().remove(removedElements_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementUpdated(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
      getViewer().update(oldInput_p, null);
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement_p) {
      return _contentHandler.getParameters().toArray();
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.IOrderedContentProvider#swap(int, int)
     */
    public void swap(int elementPosition1_p, int elementPosition2_p) {
      _contentHandler.swapParameters(elementPosition1_p, elementPosition2_p);
      getViewer().refresh();
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener#notifyChanged(org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification)
     */
    public void notifyChanged(IPatternModificationNotification notification_p) {
      int type = notification_p.getEventType();
      // Precondition.
      if (IPatternModificationNotification.SET != type) {
        return;
      }
      Object notifier = notification_p.getNotifier();
      // Update parameter, if needed.
      if (notifier instanceof ParameterRelation) {
        ParameterRelation parameter = (ParameterRelation) notifier;
        doHandleElementUpdated(parameter, parameter);
      }
    }
    
  }

  /**
   * Label provider for parameters of handled pattern.
   * @author Guillaume Brocard
   */
  protected class ParametersLabelProvider extends LabelProvider {
    
    /**
     * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
     */
    @Override
    public String getText(Object element_p) {
      ParameterRelation parameter = (ParameterRelation) element_p;
      String displayableParameter = MessageFormatHelper.formatMessage(
        Messages.PatternSpecificationPage_ParameterLabelPattern, 
        new Object[] {
          parameter.getName(),
          parameter.getType()
          .getName() 
        }
      );
      return displayableParameter;
    }
    
  }

  /**
   * Parameters content handler.
   * @author Guillaume Brocard
   */
  protected class ParametersContentHandler extends DefaultContentHandler {
    
    /**
     * Parameter name increment.
     */
    private int _parameterNameIncrement;

    /**
     * Constructor.
     */
    public ParametersContentHandler() {
      super(null, PatternSpecificationPage.this);
    }

    /**
     * Get known parameters.
     * @return
     */
    public List<ParameterRelation> getParameters() {
      return getPatternData().getPattern().getParameters();
    }

    /**
     * Get next new correct parameter name.
     * @return
     */
    @SuppressWarnings("boxing")
    protected String getNewParameterName() {
      String result = ICommonConstants.EMPTY_STRING;
      List<ParameterRelation> parameters = getPatternHandler().recomputeAllParameters();
      while (ICommonConstants.EMPTY_STRING.equals(result)) {
        // Create new name.
        result = MessageFormatHelper.formatMessage(Messages.PatternSpecificationPage_NewParameterNamePattern, new Object[] { _parameterNameIncrement++ });
        // Check that name does not already exist in the pool of all possible parameters (including parents ones).
        for (ParameterRelation parameterRelation : parameters) {
          if (result.equals(parameterRelation.getName())) {
            result = ICommonConstants.EMPTY_STRING;
            break;
          }
        }
        // A new name should have been found at this point.
      }
      return result;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler#createNewElement()
     */
    @Override
    public Object createNewElement() {
      // Create result.
      ParameterRelation newParameter = RelationsFactory.eINSTANCE.createParameterRelation();
      newParameter.setName(getNewParameterName());
      // Should be displaying a new wizard so as to choose the type of the parameter.
      newParameter.setType(EcorePackage.Literals.ECLASS);
      // Add new parameter to known list.
      getParameters().add(newParameter);
      // Notify editor.
      notifyModification();
      // Notify listeners.
      // Create notification.
      IPatternModificationNotification notification =DefaultPatternModificationNotification.createNotification(
        IPatternModificationNotification.ADDED,
        getPattern(), 
        null, 
        newParameter
      );
      // Send it.
      getEditor().sendNotification(notification);
      return newParameter;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler#removeElement(java.lang.Object)
     */
    @Override
    public void removeElement(Object element_p) {
      ParameterRelation parameter = (ParameterRelation) element_p;
      // Remove parameter from known ones.
      getParameters().remove(parameter);
      // Notify editor.
      notifyModification();
      // Notify listeners.
      // Create notification.
      IPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
        IPatternModificationNotification.REMOVED,
        getPattern(), 
        parameter, 
        null
      );
      // Send it.
      getEditor().sendNotification(notification);
    }

    /**
     * Swap parameters for given indexes.
     * @param firstIndex_p
     * @param secondIndex_p
     */
    protected void swapParameters(int firstIndex_p, int secondIndex_p) {
      // Move element from first index to second index.
      ((EList<ParameterRelation>) getParameters()).move(firstIndex_p, secondIndex_p);
      // Notify changes to editor.
      notifyModification();
    }
  }

  /**
   * Parameter details page.
   * @author Guillaume Brocard
   */
  protected abstract class ParameterDetails extends AbstractPatternDetails implements DisposeListener, IPatternModificationListener {
    
    /**
     * Handler reference.
     */
    private ParameterDetailsHandler _handler;
    
    /**
     * Parameter type text widget.
     */
    private Text _parameterTypeText;

    /**
     * Constructor.
     * @param masterPart_p
     */
    public ParameterDetails(IFormPart masterPart_p) {
      super(masterPart_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternDetails#doCreateContents(org.eclipse.ui.forms.widgets.FormToolkit,
     *      org.eclipse.swt.widgets.Composite, java.lang.Object)
     */
    @Override
    protected void doCreateContents(FormToolkit toolkit_p, Composite parent_p, final Object initialContent_p) {
      ParameterRelation parameter = (ParameterRelation) initialContent_p;
      // Create data handler.
      _handler = new ParameterDetailsHandler(parameter);
      // Update parent composite.
      FormHelper.updateCompositeLayoutWithLayoutType(parent_p, LayoutType.GRID_LAYOUT, 1, false);
      // Create parameter section.
      Couple<Section, Composite> parameterCouple = FormHelper.createSectionWithChildComposite(
        toolkit_p, 
        parent_p, 
        ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
        LayoutType.GRID_LAYOUT, 
        3, 
        false
      );
      parameterCouple.getKey().setText(Messages.PatternSpecificationPage_ParameterPropertiesSectionTitle);
      Composite parameterComposite = parameterCouple.getValue();
      // Create parameter name.
      Couple<Label, Text> parameterName = FormHelper.createLabelAndText(
        toolkit_p, 
        parameterComposite, 
        Messages.PatternSpecificationPage_ParameterNameLabel,
        null, 
        true
      );
      Text parameterNameText = parameterName.getValue();
      GridData actionNameTextData = (GridData) parameterNameText.getLayoutData();
      actionNameTextData.horizontalSpan = 2;
      // Bind parameter name text to handler.
      TextValidator parameterNameValidator = null;
      if (isEditable()) {
        parameterNameValidator = new ParameterNameValidator(parameterNameText, parameter);
      }
      DataBindingHelper.bindTextToProperty(parameterNameText, ParameterDetailsHandler.DATA_BINDING_PARAMETER_NAME, _handler, parameterNameValidator);
      // Create parameter type.
      Couple<Text, Button> parameterType = FormHelper.createLabelTextAndButton(
        toolkit_p, 
        parameterComposite,
        Messages.PatternSpecificationPage_ParameterTypeLabel,
        Messages.PatternSpecificationPage_ParameterTypeButtonLabel, 
        _handler
      );
      _parameterTypeText = parameterType.getKey();
      _parameterTypeText.setEditable(false);
      // Set dispose listener.
      _parameterTypeText.addDisposeListener(this);
      // Bind parameter type text to handler.
      DataBindingHelper.bindTextToProperty(_parameterTypeText, ParameterDetailsHandler.DATA_BINDING_PARAMETER_TYPE, _handler, null);
      // Register this as pattern modification listener.
      PatternSpecificationPage.this.getEditor().addPatternModificationListener(this);
      // Should parameter values be editable ?
      parameterComposite.setEnabled(isEditable());
    }

    /**
     * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
     */
    public void widgetDisposed(DisposeEvent e_p) {
      PatternSpecificationPage.this.getEditor().removePatternModificationListener(this);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener#notifyChanged(org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification)
     */
    public void notifyChanged(IPatternModificationNotification notification_p) {
      int type = notification_p.getEventType();
      // Precondition.
      if (IPatternModificationNotification.SET != type) {
        return;
      }
      Object notifier = notification_p.getNotifier();
      if (notifier instanceof ParameterRelation) {
        ParameterRelation parameter = (ParameterRelation) notifier;
        if (parameter == getInitialContent()) {
          _parameterTypeText.setText(_handler.getParameterType());
        }
      }
    }
    
  }

  /**
   * Parameter name validator.
   * @author Guillaume Brocard
   */
  protected class ParameterNameValidator extends TextValidator implements IPatternModificationListener {
    
    /**
     * ERROR KEY : name is already in use.
     */
    protected static final String ERROR_KEY_NOT_UNIQUE_NAME = "NotUniqueParameterName"; //$NON-NLS-1$
    
    /**
     * Initial content, that is the current parameter.
     */
    private ParameterRelation _currentParameter;

    /**
     * Constructor.
     * @param control_p
     * @param currentParameter_p
     */
    protected ParameterNameValidator(Control control_p, ParameterRelation currentParameter_p) {
      super(control_p);
      // Set regular expression.
      setRegularExpression(Messages.PatternSpecificationPage_ParameterNameRegularExpression);
      // Retain current parameter.
      _currentParameter = currentParameter_p;
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
        // Check that neither parents nor itself does already contain this parameter name.
        List<ParameterRelation> parameters = getPatternHandler().recomputeAllParameters();
        for (ParameterRelation parameterRelation : parameters) {
          result = (parameterRelation != _currentParameter) && parameterRelation.getName().equals(text_p);
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
        return MessageFormatHelper.formatMessage(Messages.PatternSpecificationPage_ParameterNameMalformedError, parameters);
      } else if (ERROR_KEY_NOT_UNIQUE_NAME == errorKey_p) {
        return MessageFormatHelper.formatMessage(Messages.PatternSpecificationPage_ParameterNameNotUniqueError, parameters);
      }
      return null;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener#notifyChanged(org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification)
     */
    public void notifyChanged(IPatternModificationNotification notification_p) {
      int type = notification_p.getEventType();
      // Precondition.
      if (IPatternModificationNotification.REMOVED != type) {
        return;
      }
      Object oldValue = notification_p.getOldValue();
      if (oldValue instanceof ParameterRelation) {
        ParameterRelation parameter = (ParameterRelation) oldValue;
        if (parameter == _currentParameter) {
          // Clear errors.
          clearErrors(getControl());
          // Remove itself as modification listener.
          getEditor().removePatternModificationListener(this);
        }
      }
    }
    
  }

  /**
   * Parameter details content handler.
   * @author Guillaume Brocard
   */
  protected class ParameterDetailsHandler extends DefaultContentHandler implements SelectionListener {
    
    /**
     * Parameter name property binding.
     */
    protected static final String DATA_BINDING_PARAMETER_NAME = "parameterName"; //$NON-NLS-1$
    
    /**
     * Parameter type property binding.
     */
    protected static final String DATA_BINDING_PARAMETER_TYPE = "parameterType"; //$NON-NLS-1$
    
    /**
     * Handled parameter.
     */
    private ParameterRelation _parameter;

    /**
     * Constructor.
     * @param parameter_p
     */
    protected ParameterDetailsHandler(ParameterRelation parameter_p) {
      super(null, PatternSpecificationPage.this);
      _parameter = parameter_p;
    }

    /**
     * Set parameter name.
     * @param newName_p
     */
    public void setParameterName(String newName_p) {
      if (!ICommonConstants.EMPTY_STRING.equals(newName_p.trim())) {
        // Old name.
        String oldName = _parameter.getName();
        // Set new name.
        _parameter.setName(newName_p);
        // Notify editor.
        notifyModification();
        // Notify listeners.
        // Create notification first.
        IPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
          IPatternModificationNotification.SET,
          _parameter, 
          oldName, 
          newName_p
        );
        // Then send it.
        notifyListeners(notification);
      }
    }

    /**
     * Get parameter name.
     * @return
     */
    public String getParameterName() {
      return _parameter.getName();
    }

    /**
     * Set parameter type.<br>
     * Fake implementation for binding purposes, should not be called explicitly.
     * @param newType_p
     */
    public void setParameterType(String newType_p) {
      // Do nothing.
    }

    /**
     * Get parameter type as a String.
     * @return
     */
    public String getParameterType() {
      String parameterTypeValue = _parameter.getType().getName();
      if (null == parameterTypeValue) {
        parameterTypeValue = ICommonConstants.EMPTY_STRING;
      }
      return parameterTypeValue;
    }

    /**
     * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
     */
    public void widgetDefaultSelected(SelectionEvent e_p) {
      // Nothing to do here.
    }

    /**
     * Notify registered listeners that handled parameter has changed.
     */
    protected void notifyListeners(IPatternModificationNotification notification_p) {
      // Send notification to listeners.
      getEditor().sendNotification(notification_p);
    }

    /**
     * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
     */
    public void widgetSelected(SelectionEvent e_p) {
      // Create temporary data.
      ParameterRelation temporaryParameter = RelationsFactory.eINSTANCE.createParameterRelation();
      temporaryParameter.setType(_parameter.getType());
      // Create selection wizard.
      WizardDialog wizardDialog = new WizardDialog(PatternSpecificationPage.this.getSite().getShell(), new ParameterWizard(temporaryParameter));
      int returnCode = wizardDialog.open();
      if (Window.OK == returnCode) {
        EClass type = temporaryParameter.getType();
        // Old type.
        EClass oldType = _parameter.getType();
        // Set new parameter type.
        _parameter.setType(type);
        // Notify editor.
        notifyModification();
        // Notify listeners.
        // Create notification first.
        IPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
          IPatternModificationNotification.SET,
          _parameter, 
          oldType, 
          type
        );
        // Then send it.
        notifyListeners(notification);
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
  
}
