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
package org.eclipse.egf.model.edit.command.plugin.contract;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IContractElementRefExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a contract element delete in a contract extension.
 * @author fournier
 */
public class RemoveContractElementWrapperCommand extends AbstractContractWrapperCommand {

  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public RemoveContractElementWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    // Get the removed contract element.
    ContractElement contractElement = (ContractElement) getValue();
    // Get contract element data.
    String contractElementId = contractElement.getId();
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Create an unset command and add it.
    commands.add(getMDSoFaPde().getContractExtensionHelper().unsetContractElement(getContractId(), contractElementId));
    // Unset its contract element references.
    IContractElementRefExtensionFactory contractElementRefExtHelper = getMDSoFaPde().getContractElementRefExtensionHelper();
    // Get the contract element references.
    List<ContractElementReference> contractElementReferences = contractElement.getContractElementReferences();
    // Loop over contract element reference to compute their id and add it into the related list.
    for (ContractElementReference contractElementReference : contractElementReferences) {
      String contractElementReferenceId = contractElementReference.getId();
      // Create a command to create the contract element reference in plug-in file.
      commands.add(contractElementRefExtHelper.unsetContractElementReferenceExtension(contractElementReferenceId));
    }
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    Object oldValue = getValue();
    // The reverse remove operation is an add operation.
    AddContractElementWrapperCommand addCommand = new AddContractElementWrapperCommand(getDomain(), getModelElement(), getFeature(), oldValue);
    // Set it the plug-in id.
    addCommand.setPluginId(getPluginId());
    return addCommand.getExecutablePluginChangeCommand();
  }
}
