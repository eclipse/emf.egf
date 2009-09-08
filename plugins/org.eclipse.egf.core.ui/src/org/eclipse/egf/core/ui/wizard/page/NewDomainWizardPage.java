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

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.field.DomainFieldEditor;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.adapters.BooleanFieldEditorAdapter;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implements the new domain wizard page.
 * @author fournier
 */
public class NewDomainWizardPage extends AbstractDomainWizardPage {
  
  /**
   * Field editor used to enter the package name.
   */
  private ValidatingStringFieldEditor _packageNameFieldEditor;
  
  /**
   * Constant used to properly layout the wizard page.
   */
  private static final int GROUP_NUM_COLUMNS = 3;
  private Composite _group;
  private BooleanFieldEditorAdapter _creationFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public NewDomainWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public NewDomainWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    _group = FieldEditorHelper.createGroup(parent_p, null, SWT.NONE, GROUP_NUM_COLUMNS);
    createDomainCreationCheckBox(_group);
    // Create a field editor to enter the root package of created domain file.
    createPackageNameFieldEditor(_group);
    // Create a field editor to display domain file name.
    createDomainFileFieldEditor(_group);
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
      _packageNameFieldEditor.getTextControl().getParent(), 
      _packageNameFieldEditor, 
      GROUP_NUM_COLUMNS
    );
    // Shift the Package Name Field Editor to the right.
    GridData gd = (GridData) _packageNameFieldEditor.getLabel().getLayoutData();
    gd.horizontalIndent = 10;
    // Force to layout the field editor on the right size.
    IFieldEditor domainFileNameFieldEditor = getDomainFileNameFieldEditor();
    FieldEditorHelper.layoutFieldEditor(
      domainFileNameFieldEditor.getValueControl().getParent(), 
      (FieldEditor) domainFileNameFieldEditor, 
      GROUP_NUM_COLUMNS
    );
    // Shift the Domain File Name Field Editor to the right.
    gd = new GridData();
    domainFileNameFieldEditor.getLabel().setLayoutData(gd);
    gd.horizontalIndent = 10;
    // Force to layout the field editor on the right size.
    FieldEditorHelper.layoutFieldEditor(
      _creationFieldEditor.getValueControl().getParent(), 
      _creationFieldEditor, 
      GROUP_NUM_COLUMNS
    );
  }

  /**
   * @param group_p
   */
  private BooleanFieldEditorAdapter createDomainCreationCheckBox(Composite group_p) {
    _creationFieldEditor = FieldEditorHelper.createCheckBoxFieldEditor(
      group_p, 
      this, 
      Messages.NewDomainWizardPage_CreateDomain_Title, 
      Messages.NewDomainWizardPage_CreateDomain_Tooltip, 
      true,
      0, 
      0,
      isReadOnly()
    );
    ((Button) _creationFieldEditor.getValueControl()).addSelectionListener(
      new SelectionAdapter() {
        /**
         * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        @SuppressWarnings("synthetic-access")
        @Override
        public void widgetSelected(SelectionEvent event_p) {
          boolean isCreatingDomain = ((Button) event_p.widget).getSelection();
          // Handle package name selection
          Text packageNameText = (Text) _packageNameFieldEditor.getValueControl();
          packageNameText.setEditable(isCreatingDomain);
          // Handle the domain file selector.
          IFieldEditor domainFileNameFieldEditor = getDomainFileNameFieldEditor();
          domainFileNameFieldEditor.getHelperControl().setEnabled(!isCreatingDomain);
          if (isCreatingDomain) {
            // Handle specific action when creating the domain file.
            ((Text) domainFileNameFieldEditor.getValueControl()).setText(getDefaultDomainFilePath());
          } else {
            // Handle specific action when browsing the domain file.
            packageNameText.setText(ICommonConstants.EMPTY_STRING);
          }
          // Check page validity.
          getCompleteStatus();
        }
      }
    );
    return _creationFieldEditor;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractDomainWizardPage#createDomainFileFieldEditor(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createDomainFileFieldEditor(Composite parent_p) {
    super.createDomainFileFieldEditor(parent_p);
    DomainFieldEditor fieldEditor = (DomainFieldEditor) getDomainFileNameFieldEditor();
    fieldEditor.getHelperControl().setEnabled(false);
    // Domain path text
    Text domainPath = fieldEditor.getTextControl(parent_p);
    // Set default value.
    domainPath.setText(getDefaultDomainFilePath());
    // Update valid state.
    fieldEditor.isValid(true);
  }

  /**
   * Create the field editor to enter the package name.
   * @param parent_p
   */
  private void createPackageNameFieldEditor(Composite parent_p) {
    // Entered string can not be null.
    _packageNameFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.NewDomainWizardPage_Package_Title,
      Messages.NewDomainWizardPage_Package_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(Messages.NewDomainWizardPage_Package_ErrorMessage),
      isReadOnly()
    );
    // Update valid state.
    _packageNameFieldEditor.isValid(true);
    // Package name is not bound to a model feature.
    // Add listener to refresh page status.
    Text packageNameText = _packageNameFieldEditor.getTextControl();
    packageNameText.addModifyListener(
      new ModifyListener() {
        /**
         * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
         */
        public void modifyText(ModifyEvent e_p) {
          updateButtons();
        }
      }
    );
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    boolean result = false;
    // If the domain is created, check the appropriate field editor.
    if (_creationFieldEditor.getBooleanValue()) {
      // Field editors to validate.
      IFieldEditor[] fieldEditors = { _packageNameFieldEditor };
      // Compute validation state.
      result = handleFieldEditorValidation(fieldEditors);
    } else {
      // An existing domain file is selected, check it.
      result = isDomainSelectedExist();
      String errorMessage = null;
      if (!result) {
        errorMessage = Messages.NewDomainWizardPage_Domain_ErrorMessage;
      }
      setErrorMessage(errorMessage);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.DomainWizardPage_Title;
  }

  /**
   * Return the root package entered by the end-user.
   * @return
   */
  public String getRootPackage() {
    return _packageNameFieldEditor.getStringValue();
  }
  
}
