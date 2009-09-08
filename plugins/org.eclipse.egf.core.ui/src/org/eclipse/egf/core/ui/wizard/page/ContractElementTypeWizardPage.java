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
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.core.ui.internal.databinding.JavaTypeHolder;
import org.eclipse.egf.core.ui.internal.databinding.UpdateWizardPage;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.contract.type.ITypeHolder;
import org.eclipse.egf.model.data.helper.ModelHelper;


/**
 * Implements the contract element type page.
 * @author fournier
 */
public class ContractElementTypeWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Java class field editor.
   */
  private ValidatingStringButtonFieldEditor _classFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public ContractElementTypeWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public ContractElementTypeWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    // No next page.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    createClassFieldEditor(parent_p);
  }

  /**
   * Create the field editor to select a class.
   * @param parent_p
   */
  private void createClassFieldEditor(Composite parent_p) {
    _classFieldEditor = FieldEditorHelper.createJavaClassFieldEditor(
      parent_p, 
      this, 
      Messages.ContractElementTypeWizardPage_Class_Title,
      Messages.ContractElementTypeWizardPage_OpenTypeDialog_Title, 
      getHostingProjectClassLoader(),
      getHostingBundle(),      
      ITypeHolder.class,
      isReadOnly()
    );    
    // Get the text widget for the class name.
    Text className = (Text) _classFieldEditor.getValueControl();
    // Get handled model element.
    ContractElement contractElement = getContractElement();
    // Get its type
    Type contractType = contractElement.getContractType();
    String typeHolderClassName = contractType != null ? contractType.getTypeHolderClassName() : ICommonConstants.EMPTY_STRING;
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      className, 
      JavaTypeHolder.PROPERTY_TYPE, 
      new JavaTypeHolder(typeHolderClassName), 
      new JavaTypeHolderChangeListener(this)
    );
    _classFieldEditor.isValid(true);
  }

  /**
   * @return
   */
  protected ContractElement getContractElement() {
    return (ContractElement) getModelElement();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _classFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ContractElementWizardPage_Title;
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
      // Get the contract element.
      ContractElement contractElement = getContractElement();
      // Set entered type name.
      ModelHelper.setContractType(contractElement, typeClassName);
      // Finally, call super method to update the wizard page.
      super.handleValueChange(event_p);
    }
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_CONTRACT_ELEMENT_TYPE_WIZARD_PAGE;
  }
  
}
