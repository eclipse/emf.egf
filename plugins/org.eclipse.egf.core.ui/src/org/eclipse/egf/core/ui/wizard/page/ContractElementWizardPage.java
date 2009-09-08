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
package org.eclipse.egf.core.ui.wizard.page;

import org.eclipse.egf.common.ui.field.SpacerFieldEditor;
import org.eclipse.egf.common.ui.helper.DataBindingHelper;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.common.ui.toolkit.adapters.BooleanFieldEditorAdapter;
import org.eclipse.egf.common.ui.toolkit.fields.CRadioGroupFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.ContractElementWizard;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implements the contract element first page.
 * @author fournier
 */
public class ContractElementWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Constant used when this contract element defines a type.
   */
  private static final String CONTRACT_ELEMENT_TYPE = String.valueOf(0);
  
  /**
   * Constant used when this contract element references other contract elements.
   */
  private static final String CONTRACT_ELEMENT_REFERENCE = String.valueOf(1);
  
  /**
   * Constant used to properly layout the wizard page.
   */
  private static final int GROUP_NUM_COLUMNS = 2;
  
  /**
   * Field editor used to enter the contract element key.
   */
  private ValidatingStringFieldEditor _contractElementKeyFieldEditor;
  
  /**
   * Field editor used to select a simple type or to reference another contract element.
   */
  private CRadioGroupFieldEditor _typeGroup;
  
  /**
   * Field editor used to define if the contract element is mandatory or not.
   */
  private BooleanFieldEditorAdapter _checkBoxFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   * @param wizardContainer_p the wizard that contains this page.
   */
  public ContractElementWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public ContractElementWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    Composite definitionGroup = FieldEditorHelper.createGroup(
      parent_p, 
      null, 
      SWT.NONE, 
      GROUP_NUM_COLUMNS
    );
    // Create the contract element key widget.
    createKeyFieldEditor(definitionGroup);
    // Create the contract element description widget.
    createDescriptionFieldEditor(definitionGroup);
    // Create a space field editor.
    new SpacerFieldEditor(parent_p);
    // Create the contract element type group.
    createTypeGroup(parent_p);
    // Create the contract element mandatory check box.
    createMandatoryCheckBox(parent_p);
    // Finally, layout the page.
    handlePageLayout(parent_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#handlePageLayout(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void handlePageLayout(Composite parent_p) {
    // Force to layout the text field editor on the right size.
    FieldEditorHelper.layoutFieldEditor(
      _contractElementKeyFieldEditor.getValueControl().getParent(), 
      _contractElementKeyFieldEditor, 
      GROUP_NUM_COLUMNS
    );
    // Force to layout the text field editor on the right size.
    FieldEditorHelper.layoutFieldEditor(
      _checkBoxFieldEditor.getValueControl().getParent(), 
      _checkBoxFieldEditor, 
      GROUP_NUM_COLUMNS
    );
    // Force to layout the text field editor on the right size.
    FieldEditorHelper.layoutFieldEditor(
      parent_p, 
      _typeGroup, 
      GROUP_NUM_COLUMNS
    );
  }

  /**
   * Create the contract element mandatory chack box.
   * @param parent_p
   */
  private void createMandatoryCheckBox(Composite parent_p) {
    // Get the contract element.
    ContractElement contractElement = (ContractElement) getModelElement();
    Composite options = FieldEditorHelper.createGroup(
      parent_p, 
      Messages.ContractElementWizardPage_OptionsGroup_Title, 
      SWT.NONE, 
      GROUP_NUM_COLUMNS
    );
    _checkBoxFieldEditor = FieldEditorHelper.createCheckBoxFieldEditor(
      options, 
      this, 
      Messages.ContractElementWizardPage_OptionsGroup_Mandatory_Title,
      Messages.ContractElementWizardPage_OptionsGroup_Mandatory_Tooltip, 
      contractElement.isMandatory(), 
      5, 
      5,
      isReadOnly()
    );
    DataBindingHelper.bindControlSelectionToProperty(
      _checkBoxFieldEditor.getValueControl(), 
      ModelPackage.Literals.CONTRACT_ELEMENT__MANDATORY.getName(),
      contractElement, 
      null
    );
  }

  /**
   * Create the contract element type group : Simple type or a reference to another contract element.
   * @param parent_p
   */
  private void createTypeGroup(Composite parent_p) {
    // Get the contract element.
    ContractElement contractElement = (ContractElement) getModelElement();
    // Create a radio group field editor to allow the end-user to select between defining a type or references other contract elements.
    String[][] labelAndValues = { 
      { Messages.ContractElementWizardPage_TypeGroup_Type, CONTRACT_ELEMENT_TYPE },
      { Messages.ContractElementWizardPage_TypeGroup_Reference, CONTRACT_ELEMENT_REFERENCE } 
    };
    _typeGroup = FieldEditorHelper.createRadioGroupFieldEditor(
      parent_p, 
      Messages.ContractElementWizardPage_TypeGroup_Title, 
      GROUP_NUM_COLUMNS, 
      labelAndValues,
      isReadOnly()
    );
    // Check if contract element has referenced contract elements ?
    EList<ContractElementReference> contractElementReferences = contractElement.getContractElementReferences();
    boolean hasReferencedContractElements = ((null != contractElementReferences) && !contractElementReferences.isEmpty());
    Object typeGroupSelection = hasReferencedContractElements ? CONTRACT_ELEMENT_REFERENCE : CONTRACT_ELEMENT_TYPE;
    _typeGroup.selectRadioButtonFor(typeGroupSelection);
  }

  /**
   * Create the field editor where the end-user enter the contract element key name.
   * @param parent_p
   */
  private void createKeyFieldEditor(Composite parent_p) {
    // Create a field editor to enter the contract element key.
    _contractElementKeyFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.ContractElementWizardPage_Key_Title,
      Messages.ContractElementWizardPage_Key_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(Messages.ContractElementWizardPage_Key_ErrorMessage),
      isReadOnly()
    );
    // Contract element key text.
    Text key = _contractElementKeyFieldEditor.getTextControl();
    // Set default focus on this widget.
    key.setFocus();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      key, 
      ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME, 
      getModelElement(), 
      null
    );
    // Update valid state.
    _contractElementKeyFieldEditor.isValid(true);
  }

  /**
   * Create the description field editor.
   * @param definitionGroup_p
   */
  private void createDescriptionFieldEditor(Composite parent_p) {
    String formattedTooltip = MessageFormatHelper.formatMessage(
      Messages.WizardPage_Description_Tooltip, 
      new String[] { 
        Messages.ContractElementWizard_Title 
      }
    );
    // Create a document listener to get document modification to persist in the description
    IDocumentListener modificationHandler = new IDocumentListener() {
      /**
       * @see org.eclipse.jface.text.IDocumentListener#documentAboutToBeChanged(org.eclipse.jface.text.DocumentEvent)
       */
      public void documentAboutToBeChanged(DocumentEvent event_p) {
        // Do nothing.
      }
      public void documentChanged(DocumentEvent event_p) {
        // Get the entered text.
        IDocument document = event_p.getDocument();
        String enteredText = document.get();
        getModelElement().setDescription(enteredText);
      }
    };
    // Create a field editor to enter the contract element description.
    FieldEditorHelper.createDescriptionFieldEditor(
      parent_p, 
      Messages.WizardPage_Description_Title, 
      formattedTooltip, 
      getModelElement().getDescription(),
      GROUP_NUM_COLUMNS, 
      modificationHandler,
      isReadOnly()
    );
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // We can't finish in this page.
    return false;
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
   */
  @Override
  public boolean canFlipToNextPage() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _contractElementKeyFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    IWizardPage result = null;
    // Get the checked radio button to open the right second page.
    Object radioButtonValue = _typeGroup.getSelectedRadioButton();
    IWizard wizard = getWizard();
    if (CONTRACT_ELEMENT_TYPE.equals(radioButtonValue)) {
      result = wizard.getPage(ContractElementWizard.CONTRACT_ELEMENT_TYPE_PAGE);
    } else if (CONTRACT_ELEMENT_REFERENCE.equals(radioButtonValue)) {
      result = wizard.getPage(ContractElementWizard.CONTRACT_ELEMENT_REFERENCE_PAGE);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ContractElementWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_CONTRACT_ELEMENT_WIZARD_PAGE;
  }
  
}
