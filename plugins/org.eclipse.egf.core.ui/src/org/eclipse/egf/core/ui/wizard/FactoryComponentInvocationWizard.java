/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.wizard;

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.core.ui.wizard.page.FactoryComponentInvocationWizardPage;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.fci.SetFactoryComponentInvocationWrapperCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;


/**
 * This wizard allows the end-user to create or edit a factory component invocation.
 * @author fournier
 */
public class FactoryComponentInvocationWizard extends AbstractModelElementWizard {
  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   */
  public FactoryComponentInvocationWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p) {
    super(parent_p, modelElement_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#addPages()
   */
  @Override
  public void addPages() {
    super.addPages();
    addPage(new FactoryComponentInvocationWizardPage("factoryComponentInvocationWizardPage")); //$NON-NLS-1$
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#doCreateModelElement()
   */
  @Override
  protected NamedModelElementWithId doCreateModelElement() {
    return ModelFactory.eINSTANCE.createFactoryComponentInvocation();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getCreationDescription()
   */
  @Override
  protected String getCreationDescription() {
    return Messages.FactoryComponentInvocationWizard_CreateDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getEditDescription()
   */
  @Override
  protected String getEditDescription() {
    return Messages.FactoryComponentInvocationWizard_EditDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getAddCommandForCreatedElement(org.eclipse.emf.ecore.EObject,
   *  org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p) {
    // Add the factory component invocation to its parent : a production plan.
    return AddCommand.create(editingDomain_p, parent_p, ModelPackage.Literals.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS, createdElement_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getPluginChangeCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *  org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getPluginChangeCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p,
      Object value_p) {
    return new SetFactoryComponentInvocationWrapperCommand(editingDomain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getTitle()
   */
  @Override
  protected String getTitle() {
    return Messages.FactoryComponentInvocationWizard_Title;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#handleChangeDescription()
   */
  @Override
  protected boolean handleChangeDescription() {
    boolean cr = super.handleChangeDescription();
    ChangeDescription changeDescription = getChangeDescription();
    if (containsChanges(changeDescription)) {
      // If the referenced FC was changed with existing context elements, let's warn the end-user that existing context elements are not valid.
      // Get current factory component invocation.
      FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) getModelElement();
      // Get current factory component invocation context.
      Context context = fcInvocation.getContext();
      if (null != context) {
        // Context is declared, check if context elements exist ?
        if (!context.getContextElements().isEmpty()) {
          Couple<EStructuralFeature, Object> modifiedFeature = getModifiedFeature(changeDescription, fcInvocation);
          if (ModelPackage.Literals.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID.equals(modifiedFeature.getKey())) {
            MessageDialog.openWarning(getShell(), Messages.FactoryComponentInvocationWizard_WarnDialog_Title, Messages.FactoryComponentInvocationWizard_WarnDialog_Message);
          }
        }
      }
    }
    return cr;
  }

}
