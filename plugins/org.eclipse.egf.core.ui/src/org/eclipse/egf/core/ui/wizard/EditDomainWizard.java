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

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.IImageKeys;
import org.eclipse.egf.core.ui.wizard.page.EditDomainWizardPage;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.fc.SetFactoryComponentWrapperCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;


/**
 * This wizard allows the end-user to edit a domain.
 * @author fournier
 */
public class EditDomainWizard extends AbstractModelElementWizard {
  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   */
  public EditDomainWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p) {
    super(parent_p, modelElement_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#addPages()
   */
  @Override
  public void addPages() {
    super.addPages();
    addPage(new EditDomainWizardPage("editDomainWizardPage")); //$NON-NLS-1$
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#doCreateModelElement()
   */
  @Override
  protected NamedModelElementWithId doCreateModelElement() {
    // Do nothing because a domain is always created but its path can be null if not defined.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getAddCommandForCreatedElement(org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p) {
    // Do nothing. Domain is is always created.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getCreationDescription()
   */
  @Override
  protected String getCreationDescription() {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getEditDescription()
   */
  @Override
  protected String getEditDescription() {
    return Messages.DomainWizard_EditDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getPluginChangeCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getPluginChangeCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p,
      Object value_p) {
    // Set a command to modify plug-in xml : the domain path is contained by the factoryComponent extension.
    // Let's modify it.
    FactoryComponent fcContainer = (FactoryComponent) getParent();
    return new SetFactoryComponentWrapperCommand(editingDomain_p, fcContainer, ModelPackage.Literals.FACTORY_COMPONENT__DOMAIN, getModelElement());
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getTitle()
   */
  @Override
  protected String getTitle() {
    return Messages.DomainWizard_Title;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getWizardDefaultPageImageDescriptor()
   */
  @Override
  protected ImageDescriptor getWizardDefaultPageImageDescriptor() {
    return EgfUiActivator.getDefault().getImageDescriptor(IImageKeys.IMG_WIZARD_DOMAIN);
  }
}