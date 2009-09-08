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

import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.field.JavaClassFieldEditor;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.ui.internal.databinding.JavaTypeHolder;
import org.eclipse.egf.core.ui.internal.databinding.UpdateWizardPage;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.ContextElementWizard;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.contract.type.ITypeHolder;
import org.eclipse.egf.model.data.helper.ModelHelper;


/**
 * Implements the context element key wizard page.
 * @author fournier
 */
public class ContextElementKeyWizardPage extends AbstractModelElementWizardPage {
  /**
   * Java class field editor.
   */
  private JavaClassFieldEditor _contextElementKeyTypeFieldEditor;
  
  /**
   * Field editor used to enter the context element key.
   */
  private ValidatingStringFieldEditor _contextElementKeyFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public ContextElementKeyWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public ContextElementKeyWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create a field editor to enter the key name.
    createKeyFieldEditor(parent_p);
    // Create a field editor to select the key type.
    createKeyTypeFieldEditor(parent_p);
    // Finally, layout the page.
    handlePageLayout(parent_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#handlePageLayout(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void handlePageLayout(Composite parent_p) {
    FieldEditorHelper.layoutFieldEditor(parent_p, _contextElementKeyFieldEditor, 3);
  }

  /**
   * Create the key type field editor.
   * @param parent_p
   */
  private void createKeyTypeFieldEditor(Composite parent_p) {
    // Create a field editor to select the key type.
    _contextElementKeyTypeFieldEditor = FieldEditorHelper.createJavaClassFieldEditor(
      parent_p, 
      this, 
      Messages.ContextElementKeyWizardPage_Type_Title,
      Messages.ContextElementKeyWizardPage_OpenTypeDialog_Title,
      getHostingProjectClassLoader(), 
      getHostingBundle(),
      ITypeHolder.class,
      isReadOnly()
    );
    // ITypeHolder class name text.
    Text className = _contextElementKeyTypeFieldEditor.getTextControl(parent_p);
    // Get handled model element.
    ContextElement contextElement = (ContextElement) getModelElement();
    // Get its type
    Type contextType = contextElement.getContextType();
    String typeHolderClassName = (null != contextType) ? contextType.getTypeHolderClassName() : ICommonConstants.EMPTY_STRING;
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(className, JavaTypeHolder.PROPERTY_TYPE, new JavaTypeHolder(typeHolderClassName), new JavaTypeHolderChangeListener(this));
    // Update valid state.
    _contextElementKeyTypeFieldEditor.isValid(true);
  }

  /**
   * Create the key field editor.
   * @param parent_p
   */
  private void createKeyFieldEditor(Composite parent_p) {
    // Create a field editor to enter the key name.
    _contextElementKeyFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.ContextElementWizardPage_Key_Title,
      Messages.ContextElementWizardPage_Key_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(Messages.ContextElementWizardPage_Key_ErrorMessage),
      isReadOnly()
    );
    // Contract element key text.
    Text key = _contextElementKeyFieldEditor.getTextControl();
    // Set default focus on this widget.
    key.setFocus();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(key, ModelPackage.Literals.CONTEXT_ELEMENT__KEY, getModelElement(), null);
    // update valid state.
    _contextElementKeyFieldEditor.isValid(true);
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
    IFieldEditor[] fieldEditors = { _contextElementKeyFieldEditor, _contextElementKeyTypeFieldEditor };
    // Compute validation state.
    boolean canFlipToNextPage = handleFieldEditorValidation(fieldEditors);
    // If we can flip to the next page, it means this page is complete and valid.
    if (canFlipToNextPage) {
      // Reset to null the contract element reference, because we are based on a local type.
      getContextElement().setContractElementReference(null);
    }
    return canFlipToNextPage;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ContextElementWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_CONTEXT_ELEMENT_TYPE_WIZARD_PAGE;
  }

  /**
   * Return the handled context element.
   * @return
   */
  protected ContextElement getContextElement() {
    return (ContextElement) getModelElement();
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    IWizard wizard = getWizard();
    ContextElementValueWizardPage nextPage = (ContextElementValueWizardPage) wizard.getPage(ContextElementWizard.CONTEXT_ELEMENT_VALUE_PAGE);
    nextPage.updateContextElementType(_contextElementKeyTypeFieldEditor.getStringValue());
    return nextPage;
  }

  /**
   * Handle changes performed on Java type holder.
   * @author fournier
   */
  class JavaTypeHolderChangeListener extends UpdateWizardPage {
    /**
     * Constructor.
     * @param wizardPage_p
     */
    public JavaTypeHolderChangeListener(AbstractModelElementWizardPage wizardPage_p) {
      super(wizardPage_p);
    }

    /**
     * @see org.eclipse.egf.core.ui.internal.databinding.UpdateWizardPage#handleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
     */
    @Override
    public void handleValueChange(ValueChangeEvent event_p) {
      // Get entered value.
      String typeClassName = (String) event_p.getObservableValue().getValue();
      // Get the context element.
      ContextElement contextElement = getContextElement();
      // Set entered type name.
      ModelHelper.setContextType(contextElement, typeClassName);
      // Finally, call super method to update the wizard page.
      super.handleValueChange(event_p);
    }
  }
}
