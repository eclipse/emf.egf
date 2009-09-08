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
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.CompoundValidator;
import org.eclipse.egf.common.ui.toolkit.validators.RegExpValidator;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.internal.validators.PatternElementValidator;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implement the pattern wizard page.
 * @author Guillaume Brocard
 */
public class PatternWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Field editor used to enter the pattern name.
   */
  private ValidatingStringFieldEditor _patternNameFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public PatternWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public PatternWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create the field editor for the name.
    createLibraryNameFieldEditor(parent_p);
  }

  /**
   * @param parent_p
   */
  private void createLibraryNameFieldEditor(Composite parent_p) {
    // Entered value can not be null.
    CompoundValidator compoundValidator = new CompoundValidator(
      new RegExpValidator(
        org.eclipse.egf.core.ui.Messages.PatternOverviewPage_PatternNameErrorMessage,
        org.eclipse.egf.core.ui.Messages.PatternOverviewPage_PatternNameRegularExpression
      )
    );
    compoundValidator.addValidator(
      new PatternElementValidator(
        getParent(), 
        (AbstractPatternElement) getModelElement(),
        Messages.PatternWizardPage_Name_ErrorMessage
      )
    );
    _patternNameFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.PatternWizardPage_Name_Title,
      Messages.PatternWizardPage_Name_Tooltip, 
      null, 
      SWT.DEFAULT, 
      compoundValidator,
      isReadOnly()
    );
    // Library name text.
    Text libraryName = _patternNameFieldEditor.getTextControl();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      libraryName, 
      ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME, 
      getModelElement(), 
      null
    );
    // Update valid state.
    _patternNameFieldEditor.isValid(true);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _patternNameFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.PatternWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_PATTERN_WIZARD_PAGE;
  }
  
}