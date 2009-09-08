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

import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implements the factory component wizard page.
 * @author fournier
 */
public class EditFactoryComponentWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Field editor used to enter the factory component name.
   */
  private ValidatingStringFieldEditor _factoryComponentNameFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public EditFactoryComponentWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public EditFactoryComponentWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create a field editor to enter the factory component name.
    createFactoryComponentNameFieldEditor(parent_p);
    createDescriptionFieldEditor(parent_p);
  }

  /**
   * Create the field editor to enter the factory component name.
   * @param parent_p
   */
  private void createFactoryComponentNameFieldEditor(Composite parent_p) {
    // Entered name can not be null.
    _factoryComponentNameFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.EditFactoryComponentWizardPage_Name_Title,
      Messages.EditFactoryComponentWizardPage_Name_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(Messages.EditFactoryComponentWizardPage_Name_ErrorMessage),
      isReadOnly()
    );
    // FactoryComponent name text.
    Text fcName = _factoryComponentNameFieldEditor.getTextControl();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(fcName, ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME, getModelElement(), null);
    // Update valid state.
    _factoryComponentNameFieldEditor.isValid(true);
  }

  /**
   * Create the description field editor.
   * @param definitionGroup_p
   */
  private void createDescriptionFieldEditor(Composite parent_p) {
    String formattedTooltip = MessageFormatHelper.formatMessage(Messages.WizardPage_Description_Tooltip, new String[] { Messages.ContractElementWizard_Title });
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
      2 /* force to have the description label at the bottom of the text */, 
      modificationHandler,
      isReadOnly()
    );
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _factoryComponentNameFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.EditFactoryComponentWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.EDIT_FC_WIZARD_PAGE;
  }
  
}
