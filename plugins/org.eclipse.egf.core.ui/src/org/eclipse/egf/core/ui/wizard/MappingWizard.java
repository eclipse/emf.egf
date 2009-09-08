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
import org.eclipse.egf.core.ui.wizard.page.MappingWizardPage;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.mapping.SetMappingWrapperCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;


/**
 * This wizard allows the end-user to create a mapping.
 * @author Guillaume Brocard
 */
public class MappingWizard extends AbstractModelElementWizard {
  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   */
  public MappingWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p) {
    super(parent_p, modelElement_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#addPages()
   */
  @Override
  public void addPages() {
    super.addPages();
    // Add the mapping page.
    addPage(new MappingWizardPage("mappingWizardPage"));//$NON-NLS-1$
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#doCreateModelElement()
   */
  @Override
  protected NamedModelElementWithId doCreateModelElement() {
    return ModelFactory.eINSTANCE.createMappingModel();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getAddCommandForCreatedElement(org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p) {
    // Add the mapping model to its parent : ie a mapping viewpoint.
    return AddCommand.create(editingDomain_p, parent_p, ModelPackage.Literals.MAPPING_VIEWPOINT__MAPPINGS, createdElement_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getCreationDescription()
   */
  @Override
  protected String getCreationDescription() {
    return Messages.MappingWizard_CreateDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getEditDescription()
   */
  @Override
  protected String getEditDescription() {
    return Messages.MappingWizard_EditDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getPluginChangeCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getPluginChangeCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p,
      Object value_p) {
    return new SetMappingWrapperCommand(editingDomain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getTitle()
   */
  @Override
  protected String getTitle() {
    return Messages.MappingWizard_Title;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getWizardDefaultPageImageDescriptor()
   */
  @Override
  protected ImageDescriptor getWizardDefaultPageImageDescriptor() {
    return EgfUiActivator.getDefault().getImageDescriptor(IImageKeys.IMG_WIZARD_MAPPING);
  }
}