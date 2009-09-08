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

import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.IImageKeys;
import org.eclipse.egf.core.ui.wizard.page.NewDomainWizardPage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.domain.SetDomainWrapperCommand;
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
public class NewDomainWizard extends AbstractModelElementWizard {
  /**
   * Page that allows the end-user to enter data needed to create the domain.
   */
  private NewDomainWizardPage _newDomainWizardPage;

  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   */
  public NewDomainWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p) {
    super(parent_p, modelElement_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#addPages()
   */
  @Override
  public void addPages() {
    // Override behavior from the super class.
    // Domain creation is slightly different from other model elements.
    // Create the composed title.
    String titleMessage = MessageFormatHelper.formatMessage(Messages.Wizard_Title, new String[] { Messages.CreationWizard_Prefix, getTitle() });
    // Set the wizard title.
    setWindowTitle(titleMessage);
    // Add pages.
    _newDomainWizardPage = new NewDomainWizardPage("newDomainWizardPage"); //$NON-NLS-1$
    addPage(_newDomainWizardPage);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#doCreateModelElement()
   */
  @Override
  protected NamedModelElementWithId doCreateModelElement() {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getAddCommandForCreatedElement(org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getCreationDescription()
   */
  @Override
  protected String getCreationDescription() {
    return Messages.DomainWizard_CreateDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getEditDescription()
   */
  @Override
  protected String getEditDescription() {
    return Messages.DomainWizard_CreateDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getPluginChangeCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getPluginChangeCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p,
      Object value_p) {
    SetDomainWrapperCommand command = null;
    String rootPackage = _newDomainWizardPage.getRootPackage();
    command = new SetDomainWrapperCommand(editingDomain_p, modelElement_p, feature_p, value_p);
    // Set the root package name.
    command.setRootPackageForDomain(rootPackage);
    return command;
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
