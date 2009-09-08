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

import org.eclipse.egf.core.ui.wizard.page.ContextElementKeyWizardPage;
import org.eclipse.egf.core.ui.wizard.page.ContextElementReferenceWizardPage;
import org.eclipse.egf.core.ui.wizard.page.ContextElementValueWizardPage;
import org.eclipse.egf.core.ui.wizard.page.ContextElementWizardPage;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.context.SetContextElementWrapperCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.wizard.IWizardPage;


/**
 * This wizard allows the end-user to edit a context element.
 * @author fournier
 */
public class ContextElementWizard extends AbstractModelElementWizard {
  /**
   * Constant used to identify the context element key wizard page.
   */
  public static final String CONTEXT_ELEMENT_KEY_PAGE = "contextElementKeyPage"; //$NON-NLS-1$
  /**
   * Constant used to identify the context element reference wizard page.
   */
  public static final String CONTEXT_ELEMENT_REFERENCE_PAGE = "contextElementReferencePage"; //$NON-NLS-1$
  /**
   * Constant used to identify the context element value wizard page.
   */
  public static final String CONTEXT_ELEMENT_VALUE_PAGE = "contextElementValuePage"; //$NON-NLS-1$
  /**
   * Constant used to identify the context element wizard page.
   */
  protected static final String CONTEXT_ELEMENT_FIRST_PAGE = "contextElementPage"; //$NON-NLS-1$

  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   */
  public ContextElementWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p) {
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
    // Add the first page. Next pages are lazy created.
    addPage(new ContextElementWizardPage(CONTEXT_ELEMENT_FIRST_PAGE));
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#getPage(java.lang.String)
   */
  @Override
  public IWizardPage getPage(String name_p) {
    IWizardPage page = super.getPage(name_p);
    // Precondition : it is useless to go further, the requested page is found.
    if (null != page) {
      return page;
    }
    // The page is not created, let's do it.
    if (CONTEXT_ELEMENT_KEY_PAGE.equals(name_p)) {
      // Create the page.
      page = new ContextElementKeyWizardPage(CONTEXT_ELEMENT_KEY_PAGE);
    } else if (CONTEXT_ELEMENT_REFERENCE_PAGE.equals(name_p)) {
      // Create the page.
      page = new ContextElementReferenceWizardPage(CONTEXT_ELEMENT_REFERENCE_PAGE);
    } else if (CONTEXT_ELEMENT_VALUE_PAGE.equals(name_p)) {
      // Create the page.
      page = new ContextElementValueWizardPage(CONTEXT_ELEMENT_VALUE_PAGE);
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
    // Can only finish if the active page is complete.
    return getContainer().getCurrentPage().isPageComplete();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#doCreateModelElement()
   */
  @Override
  protected NamedModelElementWithId doCreateModelElement() {
    return ModelFactory.eINSTANCE.createContextElement();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getAddCommandForCreatedElement(org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p) {
    // Add the context element to its parent : ie a context.
    return AddCommand.create(editingDomain_p, parent_p, ModelPackage.Literals.CONTEXT__CONTEXT_ELEMENTS, createdElement_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getCreationDescription()
   */
  @Override
  protected String getCreationDescription() {
    return Messages.ContextElementWizard_CreateDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getEditDescription()
   */
  @Override
  protected String getEditDescription() {
    return Messages.ContextElementWizard_EditDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getPluginChangeCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getPluginChangeCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p,
      Object value_p) {
    return new SetContextElementWrapperCommand(editingDomain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getTitle()
   */
  @Override
  protected String getTitle() {
    return Messages.ContextElementWizard_Title;
  }
}