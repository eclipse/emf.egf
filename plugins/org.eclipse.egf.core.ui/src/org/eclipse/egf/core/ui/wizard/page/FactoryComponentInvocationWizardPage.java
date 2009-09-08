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

import java.util.Collections;

import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.ui.internal.databinding.ReferencedFactoryComponent;
import org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler;
import org.eclipse.egf.core.ui.internal.dialogs.FactoryComponentSelectionDialog;
import org.eclipse.egf.core.ui.internal.field.ModelElementButtonFieldEditor;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.internal.validators.ReferencedFactoryComponentValidator;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implements the factory component configuration wizard page.
 * @author fournier
 */
public class FactoryComponentInvocationWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Field editor used to enter the factory component invocation name.
   */
  private ValidatingStringFieldEditor _factoryComponentInvocationNameFieldEditor;
  
  /**
   * Field editor used to enter the referenced factory component.
   */
  private ValidatingStringButtonFieldEditor _referencedFactoryComponentFieldEditor;
  
  /**
   * Field that holds the referenced factory component id.
   */
  protected String _referencedFactoryComponentId;

  /**
   * Constructor.
   * @param pageName_p
   */
  public FactoryComponentInvocationWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public FactoryComponentInvocationWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * Get the factory component invocation managed by this page.
   * @return
   */
  protected FactoryComponentInvocation getFactoryComponentInvocation() {
    return (FactoryComponentInvocation) getModelElement();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create a field editor to enter the factory component configuration name.
    createFactoryComponentInvocationNameFieldEditor(parent_p);
    // Create the referenced factory component field editor.
    createReferencedFactoryComponentFieldEditor(parent_p);
    // Finally, layout the page.
    handlePageLayout(parent_p);
  }

  /**
   * Create the field editor to enter the factory component invocation name.
   * @param parent_p
   */
  private void createFactoryComponentInvocationNameFieldEditor(Composite parent_p) {
    // Entered name can not be null.
    _factoryComponentInvocationNameFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.FactoryComponentInvocationWizardPage_Name_Title,
      Messages.FactoryComponentInvocationWizardPage_Name_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(Messages.FactoryComponentInvocationWizardPage_Name_ErrorMessage),
      isReadOnly()
    );
    // FactoryComponent configuration name text.
    Text fcInvocationName = _factoryComponentInvocationNameFieldEditor.getTextControl();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(fcInvocationName, ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME, getModelElement(), null);
    // Update valid state.
    _factoryComponentInvocationNameFieldEditor.isValid(true);
  }

  /**
   * Create the referenced factory component field editor.
   * @param parent_p
   */
  private void createReferencedFactoryComponentFieldEditor(Composite parent_p) {
    // Referenced factory component name text.
    FactoryComponentSelectionDialog fcSelectionDialog = new FactoryComponentSelectionDialog(getShell());
    // Filter the factory component container of this factory component invocation.
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(getParent());
    fcSelectionDialog.setFilteredFactoryComponents(Collections.singletonList(fcContainer));
    ReferencedFactoryComponentValidator validator = new ReferencedFactoryComponentValidator(Messages.FactoryComponentInvocationWizardPage_ReferencedFactoryComponent_ErrorMessage) {
      /**
       * @see org.eclipse.egf.core.ui.internal.validators.ReferencedFactoryComponentValidator#handleReferencedFactoryComponentChange(java.lang.String)
       */
      @Override
      protected void handleReferencedFactoryComponentChange(String newReferencedFcIdValue_p) {
        _referencedFactoryComponentId = newReferencedFcIdValue_p;
      }
    };
    _referencedFactoryComponentFieldEditor = ModelElementButtonFieldEditor.createModelElementButtonFieldEditor(
      parent_p, 
      this, 
      Messages.FactoryComponentInvocationWizardPage_ReferencedFactoryComponent_Title,
      Messages.FactoryComponentInvocationWizardPage_ReferencedFactoryComponent_Tooltip, 
      fcSelectionDialog,
      validator,
      isReadOnly()
    );
    // Get the referenced factory component name from the referenced factory component id if existing.
    FactoryComponentInvocation fcInvocation = getFactoryComponentInvocation();
    NamedModelElementWithId referenceFc = CoreActivator.getDefault().getFactoryComponent(fcInvocation.getFactoryComponentId());
    String referencedFcName = (null != referenceFc) ? referenceFc.getName() : ICommonConstants.EMPTY_STRING;
    ReferencedFactoryComponent referencedFc = new ReferencedFactoryComponent(referencedFcName);
    // Referenced factory component name text
    Text referencedFcNameText = _referencedFactoryComponentFieldEditor.getTextControl(parent_p);
    // Create a value change listener to compute the referenced factory component id according to referenced factory component name.
    ValueChangeHandler valueChangeHandler = new ValueChangeHandler(this) {
      /**
       * @see org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler#doHandleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
       */
      @Override
      protected void doHandleValueChange(ValueChangeEvent event_p) {
        // Either set a null value (means no referenced factory component is retrieved) or a right one.
        getFactoryComponentInvocation().setFactoryComponentId(_referencedFactoryComponentId);
      }
    };
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(referencedFcNameText, ReferencedFactoryComponent.PROPERTY_NAME, referencedFc, valueChangeHandler);
    // Update valid state.
    _referencedFactoryComponentFieldEditor.isValid(true);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#handlePageLayout(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void handlePageLayout(Composite parent_p) {
    // Force to layout the text field editor on the right size.
    FieldEditorHelper.layoutFieldEditor(parent_p, _factoryComponentInvocationNameFieldEditor, 3);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _factoryComponentInvocationNameFieldEditor, _referencedFactoryComponentFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.FactoryComponentInvocationWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_FC_CONFIGURATION_WIZARD_PAGE;
  }
  
}