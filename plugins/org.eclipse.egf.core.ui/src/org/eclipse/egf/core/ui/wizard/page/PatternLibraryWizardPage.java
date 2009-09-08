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

import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.internal.validators.PatternElementValidator;
import org.eclipse.egf.core.ui.wizard.AbstractPatternLibraryWizard;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implement the pattern library wizard page.
 * @author Guillaume Brocard
 */
public class PatternLibraryWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Field editor used to enter the library name.
   */
  private ValidatingStringFieldEditor _libraryNameFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public PatternLibraryWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public PatternLibraryWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create the library id.
    createLibraryFullId();
    // Create the field editor for the library name.
    createLibraryNameFieldEditor(parent_p);
  }

  /**
   * Create the field editor to enter the pattern library name.
   * @param parent_p
   */
  private void createLibraryNameFieldEditor(Composite parent_p) {
    // Entered value can not be null.
    _libraryNameFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.PatternLibraryWizardPage_Name_Title,
      Messages.PatternLibraryWizardPage_Name_Tooltip, 
      null, 
      SWT.DEFAULT,
      new PatternElementValidator(
        getParent(), 
        (AbstractPatternElement) getModelElement(),
        Messages.PatternLibraryWizardPage_Name_ErrorMessage
      ),
      isReadOnly()
    );
    // Library name text.
    Text libraryName = _libraryNameFieldEditor.getTextControl();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      libraryName, 
      ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME, 
      getModelElement(), 
      null
    );
    // Update valid state.
    _libraryNameFieldEditor.isValid(true);
  }

  /**
   * Create the pattern library id.<br>
   * @param parent_p
   */
  private void createLibraryFullId() {
    AbstractPatternElement patternLibrary = getPatternLibrary();
    // In creation mode, perform extra-stuffs.
    boolean isInCreationMode = ((AbstractPatternLibraryWizard) getModelElementWizard()).isInCreationMode();
    if (isInCreationMode) {
      // Get the short id of the created library.
      String createdLibraryShortId = patternLibrary.getId();
      NamedModelElementWithId parent = getParent();
      // Check the parent is not the pattern viewpoint ?
      // If the parent is another library, the parent id is the library id.
      // Else we are creating a 'root' library, thus do nothing.
      if (parent instanceof PatternLibrary) {
        String parentId = parent.getId();
        // At creation time, the library id is a short id.
        // Create the pattern element full id.
        String createLibraryFullId = PatternHelper.getFullId(parentId, createdLibraryShortId);
        // Set it.
        patternLibrary.setId(createLibraryFullId);
      }
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _libraryNameFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.PatternLibraryWizardPage_Title;
  }

  /**
   * Get the handled pattern library.
   * @return
   */
  protected PatternLibrary getPatternLibrary() {
    return (PatternLibrary) getModelElement();
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    return getWizard().getPage(AbstractPatternLibraryWizard.PATTERN_LIBRARY_PRODUCTION_SEQUENCE_PAGE);
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_PATTERN_LIBRARY_WIZARD_PAGE;
  }
  
}