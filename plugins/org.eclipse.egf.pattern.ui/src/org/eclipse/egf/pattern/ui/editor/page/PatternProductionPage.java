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

import org.apache.log4j.Logger;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.DataBindingHelper;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.common.ui.toolkit.fields.CRadioGroupFieldEditor;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ecore.PatternHandler.ProductionOptionsHandler;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;


/**
 * Pattern overview page.
 * @author Guillaume Brocard
 */
public class PatternProductionPage extends AbstractPatternPage {
  
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(PatternProductionPage.class.getPackage().getName());
    
  /**
   * Page id.
   */
  protected static final String ID = "egf_pattern_production_page"; //$NON-NLS-1$
  
  /**
   * Help context id.
   */
  protected static final String HELP_CONTEXT_ID = PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + ID;
  
  /**
   * Production handler reminder.
   */
  private ProductionHandler _productionHandler;
  
  /**
   * Constructor.
   * @param editor_p
   */
  public PatternProductionPage(FormEditor editor_p) {
    super(editor_p, ID, Messages.PatternProductionPage_Title);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#handleSelection(java.lang.Object, org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  public void handleSelection(Object firstSelectedObject_p, IStructuredSelection selection_p) {
    // Set active page to current one.
    getEditor().setActivePage(ID);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#createPatternBlock()
   */
  @Override
  protected AbstractPatternBlock createPatternBlock() {
    return null;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#doCreateFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
   *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void doCreateFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p) {
    // Main composite is made of 1 columns of the same size.
    FormHelper.updateCompositeLayoutWithLayoutType(parent_p, LayoutType.GRID_LAYOUT, 1, false);
    // Create production options section.
    createProductionOptionsSection(toolkit_p, parent_p, patternData_p);
  }

  /**
   * Create production options section.
   * @param toolkit_p
   * @param parent_p
   * @param patternData_p
   */
  private void createProductionOptionsSection(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p) {
    // Handler.
    _productionHandler = new ProductionHandler(patternData_p);
    // Create options section.
    Couple<Section, Composite> optionsCouple = FormHelper.createSectionWithChildComposite(
      toolkit_p, 
      parent_p, 
      ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
      LayoutType.GRID_LAYOUT, 
      1, 
      false
    );
    Section optionsSection = optionsCouple.getKey();
    optionsSection.setText(Messages.PatternOverviewPage_Section_ProductionOptions_Text);
    // Get section composite.
    Composite parentOptionsComposite = optionsCouple.getValue();
    // Add the override button, that enables or disables the whole options panel.
    Button overrideButton = toolkit_p.createButton(
      parentOptionsComposite, 
      Messages.PatternOverviewPage_ProductionOptions_Override_Button_Text, SWT.CHECK
    );
    overrideButton.setEnabled(isEditable());
    // Listen to the button changes.
    overrideButton.addSelectionListener(_productionHandler);
    // Get and set current value.
    boolean optionsEnabled = _productionHandler.isEnabled();
    overrideButton.setSelection(optionsEnabled);
    // Get options composite.
    Composite optionsComposite = FieldEditorHelper.createGroup(
      parentOptionsComposite, 
      Messages.PatternOverviewPage_Section_ProductionOptions_Text, 
      SWT.NONE, 
      1
    );
    {
      // Create compilation option description label.
      toolkit_p.createLabel(optionsComposite, Messages.PatternOverviewPage_ProductionOptions_CompileTemplate_Description);
      // Create compilation choice.
      String trueString = Boolean.TRUE.toString();
      String falseString = Boolean.FALSE.toString();
      String[][] compilationOptions = new String[][] { 
        { Messages.PatternOverviewPage_ProductionOptions_CompileTemplate_Compile_Choice_Label, trueString },
        { Messages.PatternOverviewPage_ProductionOptions_CompileTemplate_Skip_Choice_Label, falseString } 
      };
      CRadioGroupFieldEditor compilationRadioGroup = FieldEditorHelper.createRadioGroupFieldEditor(
        optionsComposite,
        Messages.PatternOverviewPage_ProductionOptions_CompileTemplate_Title, 
        2,
        compilationOptions,
        isEditable() == false
      );
      // Listen to compilation option changes.
      _productionHandler._compilationSource = compilationRadioGroup;
      compilationRadioGroup.setPropertyChangeListener(_productionHandler);
      // Create buffer modification option description label.
      toolkit_p.createLabel(optionsComposite, Messages.PatternOverviewPage_ProductionOptions_ModifyBuffer_Description);
      String[][] bufferModificationOptions = new String[][] { 
        { Messages.PatternOverviewPage_ProductionOptions_ModifyBuffer_Enabled_Choice_Label, trueString },
        { Messages.PatternOverviewPage_ProductionOptions_ModifyBuffer_Disabled_Choice_Label, falseString } 
      };
      CRadioGroupFieldEditor bufferModificationRadioGroup = FieldEditorHelper.createRadioGroupFieldEditor(
        optionsComposite,
        Messages.PatternOverviewPage_ProductionOptions_ModifyBuffer_Title,
        2, 
        bufferModificationOptions,
        isEditable() == false
      );
      // Listen to buffer modification option changes.
      _productionHandler._bufferModificationSource = bufferModificationRadioGroup;
      bufferModificationRadioGroup.setPropertyChangeListener(_productionHandler);
      // Create destination path section.
      Couple<Section, Composite> destinationPathCouple = FormHelper.createSectionWithChildComposite(
        toolkit_p, 
        optionsComposite, 
        ExpandableComposite.EXPANDED,
        LayoutType.GRID_LAYOUT, 
        2, 
        false
      );
      Section destinationPathSection = destinationPathCouple.getKey();
      destinationPathSection.setText(Messages.PatternOverviewPage_ProductionOptions_TemplatePath_Section_Text);
      destinationPathSection.setFont(bufferModificationRadioGroup.getRadioBoxControl(optionsComposite).getFont());
      destinationPathSection.setForeground(toolkit_p.getColors().getColor(IFormColors.TITLE));
      Composite destinationPathComposite = destinationPathCouple.getValue();
      {
        // Create description label.
        Label destinationPathDescriptionLabel = toolkit_p.createLabel(
          destinationPathComposite,
          Messages.PatternOverviewPage_ProductionOptions_TemplatePath_Description
        );
        GridData gilData = new GridData(GridData.FILL_HORIZONTAL);
        gilData.horizontalSpan = 2;
        destinationPathDescriptionLabel.setLayoutData(gilData);
        // Create destination text.
        Text destinationPathText = FormHelper.createLabelAndText(
          toolkit_p, 
          destinationPathComposite,
          Messages.PatternOverviewPage_ProductionOptions_TemplatePath_Label, 
          null, 
          isEditable()
        ).getValue();
        _productionHandler._templateRelativePath = destinationPathText;
        TextValidator textValidator = new TextValidator(destinationPathText) {
          @Override
          protected String getErrorMessageFor(String errorKey_p, String value_p) {
            if (ERROR_KEY_REG_EXP == errorKey_p) {
              return Messages.PatternOverviewPage_ProductionOptions_TemplatePath_Validation_Error_Message;
            }
            return null;
          }
        };
        textValidator.setRegularExpression(Messages.PatternOverviewPage_ProductionOptions_TemplatePath_Validation_RegularExpression);
        // Data binding takes care of initializing the field with currently known value.
        // This is taken into account by the refreshUiValues() method behavior.
        DataBindingHelper.bindTextToProperty(destinationPathText, ProductionHandler.DATA_BINDING_TEMPLATE_DESTINATION_PATH, _productionHandler, textValidator);
      }
    }
    // Force widgets to refresh their enabled status.
    _productionHandler.updateUiEnablement(optionsEnabled);
    // Force widgets to display initial values.
    _productionHandler.refreshUiValues();
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#dataSaved()
   */
  @Override
  public void dataSaved() {
    // Force production options values to synchronize with model.
    if (null != _productionHandler) {
      _productionHandler.refreshUiValues();
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
   * Production options handler.
   * @author Guillaume Brocard
   */
  private class ProductionHandler extends DefaultContentHandler implements IPropertyChangeListener, SelectionListener {
    
    /**
     * Pattern template destination path.
     */
    protected static final String DATA_BINDING_TEMPLATE_DESTINATION_PATH = "destinationPath"; //$NON-NLS-1$
    
    /**
     * Handler to delegate to.
     */
    private ProductionOptionsHandler _optionsHandler;
    
    /**
     * Compilation option source field editor.
     */
    protected CRadioGroupFieldEditor _compilationSource;
    
    /**
     * Buffer modification option source field editor.
     */
    protected CRadioGroupFieldEditor _bufferModificationSource;
    
    /**
     * Template relative path control.
     */
    protected Text _templateRelativePath;
    
    /**
     * Ignore next value for template path ?
     */
    private boolean _ignoreNextTemplatePathValue;

    /**
     * Constructor.
     * @param patternData_p
     */
    protected ProductionHandler(PatternData patternData_p) {
      super(patternData_p, PatternProductionPage.this);
      _optionsHandler = patternData_p.getProductionOptionsHandler();
      _ignoreNextTemplatePathValue = false;
    }

    /**
     * Get destination path, data binding method.
     * @return
     */
    public String getDestinationPath() {
      return _optionsHandler.getPatternTemplatePath();
    }

    /**
     * Set destination path, data binding method.
     * @param newTemplateDestinationPath_p
     */
    public void setDestinationPath(String newTemplateDestinationPath_p) {
      if (!_ignoreNextTemplatePathValue) {
        _optionsHandler.setPatternTemplatePath(newTemplateDestinationPath_p);
        notifyModification();
      } else {
        _ignoreNextTemplatePathValue = false;
      }
    }

    /**
     * Get compilation option flag current value.
     * @return
     */
    protected boolean shouldCompile() {
      return _optionsHandler.shouldCompileTemplate();
    }

    /**
     * Get buffer modification option flag current value.
     * @return
     */
    protected boolean shouldModifyBuffer() {
      return _optionsHandler.shouldModifyBuffer();
    }

    /**
     * Are options enabled.
     * @return
     */
    protected boolean isEnabled() {
      return _optionsHandler.isEnabled();
    }

    /**
     * Should options be enabled (true) or disabled (false) ?
     * @param enabled_p
     */
    protected void setEnabled(boolean enabled_p) {
      // Delegate to internal handler.
      _optionsHandler.setEnabled(enabled_p);
      // Then enable/disable the UI controls.
      updateUiEnablement(enabled_p);
      // Finally, notify the editor.
      notifyModification();
    }

    /**
     * Update UI enabled status.
     * @param enabled_p
     */
    protected void updateUiEnablement(boolean enabled_p) {
      // Enable/disable the UI controls.
      _compilationSource.setEnabled(enabled_p, null);
      _bufferModificationSource.setEnabled(enabled_p, null);
      _templateRelativePath.setEnabled(enabled_p);
    }

    /**
     * Refresh UI values with no impact on reflected models.
     */
    protected void refreshUiValues() {
      // Disable listening first.
      _compilationSource.setPropertyChangeListener(null);
      _bufferModificationSource.setPropertyChangeListener(null);
      _ignoreNextTemplatePathValue = true;
      // Change widgets values.
      // Compilation option.
      String selectedValue = Boolean.toString(_optionsHandler.shouldCompileTemplate());
      _compilationSource.selectRadioButtonFor(selectedValue);
      // Buffer modification option.
      selectedValue = Boolean.toString(_optionsHandler.shouldModifyBuffer());
      _bufferModificationSource.selectRadioButtonFor(selectedValue);
      // Template relative path option.
      _templateRelativePath.setText(_optionsHandler.getPatternTemplatePath());
      // Enable listening again.
      _compilationSource.setPropertyChangeListener(this);
      _bufferModificationSource.setPropertyChangeListener(this);
    }

    /**
     * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent event_p) {
      // Get property change source.
      Object source = event_p.getSource();
      boolean notify = false;
      if (source.equals(_compilationSource)) {
        // Compilation option case.
        _optionsHandler.setCompileTemplateTo(Boolean.valueOf((String) event_p.getNewValue()).booleanValue());
        notify = true;
      } else if (source.equals(_bufferModificationSource)) {
        // Buffer modification option case.
        _optionsHandler.setModifyBufferTo(Boolean.valueOf((String) event_p.getNewValue()).booleanValue());
        notify = true;
      }
      // Notify editor of changes, if required.
      if (notify) {
        notifyModification();
      }
    }

    /**
     * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
     */
    public void widgetDefaultSelected(SelectionEvent e_p) {
      // Nothing to do here.
    }

    /**
     * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
     */
    public void widgetSelected(SelectionEvent e_p) {
      Object source = e_p.getSource();
      // Check if source is a button.
      if (source instanceof Button) {
        // It is assumed that the only listened to button is the override one.
        // Thus its selection leads to the enabled status of the production options.
        setEnabled(((Button) source).getSelection());
      }
    }
    
  }

}
