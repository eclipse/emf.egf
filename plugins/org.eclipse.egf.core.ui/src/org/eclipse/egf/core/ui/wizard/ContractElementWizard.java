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
package org.eclipse.egf.core.ui.wizard;

import org.eclipse.egf.core.ui.wizard.page.ContractElementReferenceWizardPage;
import org.eclipse.egf.core.ui.wizard.page.ContractElementTypeWizardPage;
import org.eclipse.egf.core.ui.wizard.page.ContractElementWizardPage;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.contract.SetContractElementWrapperCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.wizard.IWizardPage;


/**
 * This wizard allows the end-user to create or edit a contract element.
 * @author fournier
 */
public class ContractElementWizard extends AbstractModelElementWizard {
  
  /**
   * Constant used to identify the contract element type wizard page.
   */
  public static final String CONTRACT_ELEMENT_TYPE_PAGE = "contractElementTypePage"; //$NON-NLS-1$
  
  /**
   * Constant used to identify the contract element reference wizard page.
   */
  public static final String CONTRACT_ELEMENT_REFERENCE_PAGE = "contractElementReferencePage"; //$NON-NLS-1$
  
  /**
   * Constant used to identify the contract element wizard page.
   */
  protected static final String CONTRACT_ELEMENT_FIRST_PAGE = "contractElementPage"; //$NON-NLS-1$

  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   */
  public ContractElementWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p) {
    super(parent_p, modelElement_p, readOnlyMode_p);
    // Force to have the next and previous button
    setForcePreviousAndNextButtons(true);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#addPages()
   */
  @Override
  public void addPages() {
    super.addPages();
    // Add the first page.
    addPage(new ContractElementWizardPage(CONTRACT_ELEMENT_FIRST_PAGE));
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#getPage(java.lang.String)
   */
  @Override
  public IWizardPage getPage(String name_p) {
    IWizardPage page = super.getPage(name_p);
    // Precondition : it is useless to go far away, the requested page is found.
    if (null != page) {
      return page;
    }
    // The page is not created, let's do it.
    if (CONTRACT_ELEMENT_TYPE_PAGE.equals(name_p)) {
      // Create the page.
      page = new ContractElementTypeWizardPage(CONTRACT_ELEMENT_TYPE_PAGE);
    } else if (CONTRACT_ELEMENT_REFERENCE_PAGE.equals(name_p)) {
      // Create the page.
      page = new ContractElementReferenceWizardPage(CONTRACT_ELEMENT_REFERENCE_PAGE);
    }
    // Finally, add the page.
    addPage(page);
    return page;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#handleCanFinish()
   */
  @Override
  protected boolean handleCanFinish() {
    // Can only finish if the active second page is complete.
    return getContainer().getCurrentPage().isPageComplete();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    ContractElement contractElement = (ContractElement) getModelElement();
    // Check which page was used to complete the wizard.
    IWizardPage completingPage = getContainer().getCurrentPage();
    if (completingPage == getPage(CONTRACT_ELEMENT_TYPE_PAGE)) {
      // Remove all potential contract element references.
      // Do not remove contract element reference ids, because we have to destroy previously persisted ones.
      // This attribute will be reset later (cf AbstractContractWrapperCommand#handleContractElementReferences(..)).
      contractElement.getContractElementReferences().clear();
    }
    return super.performFinish();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#doCreateModelElement()
   */
  @Override
  protected NamedModelElementWithId doCreateModelElement() {
    ContractElement createdContractElement = ModelFactory.eINSTANCE.createContractElement();
    // Set contract element factory component id to its parent id.
    // No field editor can set the factory component id value.
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer((NamedModelElementWithId) getParent());
    createdContractElement.setFactoryComponentId(fcContainer.getId());
    return createdContractElement;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getAddCommandForCreatedElement(org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p) {
    // Add the contract element to its parent : ie a contract.
    return AddCommand.create(
      editingDomain_p, 
      parent_p, 
      ModelPackage.
      Literals.CONTRACT__CONTRACT_ELEMENTS, 
      createdElement_p
    );
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getTitle()
   */
  @Override
  protected String getTitle() {
    return Messages.ContractElementWizard_Title;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getCreationDescription()
   */
  @Override
  protected String getCreationDescription() {
    return Messages.ContractElementWizard_CreateDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getEditDescription()
   */
  @Override
  protected String getEditDescription() {
    return Messages.ContractElementWizard_EditDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getPluginChangeCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getPluginChangeCommand(
    EditingDomain editingDomain_p, 
    EObject modelElement_p, 
    EStructuralFeature feature_p,
    Object value_p
  ) {
    return new SetContractElementWrapperCommand(editingDomain_p, modelElement_p, feature_p, value_p);
  }
  
}
