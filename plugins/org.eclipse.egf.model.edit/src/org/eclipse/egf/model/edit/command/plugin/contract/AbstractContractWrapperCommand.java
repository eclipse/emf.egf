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
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IContractElementRefExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IContractExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Base class to implement a command that wraps a contract extension processing.
 * @author fournier
 */
public abstract class AbstractContractWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  protected AbstractContractWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * Returns the contract id of model element object.
   * @return
   */
  protected String getContractId() {
    String contractId = null;
    NamedModelElementWithId modelElement = getModelElement();
    // ModelElement is the contract object.
    if (modelElement instanceof Contract) {
      contractId = modelElement.getId();
    } else if (modelElement instanceof ContractElement) {
      // Contract is the parent of ContractElement.
      contractId = ((NamedModelElementWithId) modelElement.eContainer()).getId();
    }
    return contractId;
  }

  protected List<IPluginChangesCommand> getExecutableCommandList(ContractElement contractElement_p) {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Handle contract element references.
    commands.addAll(handleContractElementReferences(contractElement_p));
    // Handle contract element itself.
    commands.addAll(handleContractElement(contractElement_p));
    return commands;
  }

  protected List<IPluginChangesCommand> handleContractElement(ContractElement contractElement_p) {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>();
    // Get contract element data.
    String contractElementId = contractElement_p.getId();
    String contractElementName = contractElement_p.getName();
    String contractElementType = contractElement_p.getContractType().getTypeHolderClassName();
    String isMandatory = Boolean.toString(contractElement_p.isMandatory());
    List<String> contractElementReferenceIds = contractElement_p.getContractReferenceIds();
    String contractId = getContractId();
    // Create a command to remove the previous identical contract element in plug-in file.
    IContractExtensionFactory contractExtensionHelper = getMDSoFaPde().getContractExtensionHelper();
    commands.add(contractExtensionHelper.unsetContractElement(contractId, contractElementId));
    // Create a command to create the contract element in plug-in file.
    commands.add(contractExtensionHelper.setContractElement(contractId, contractElementId, contractElementName, contractElementType,
                                                            contractElementReferenceIds, isMandatory, contractElement_p.getDescription()));
    return commands;
  }

  /**
   * Handle contract element references including delta between to 2 set operations.
   * @param contractElement_p
   */
  protected List<IPluginChangesCommand> handleContractElementReferences(ContractElement contractElement_p) {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>();
    // Get the contract element reference ids.
    List<String> contractElementReferenceIds = contractElement_p.getContractReferenceIds();
    // Get the contract element reference objects.
    List<ContractElementReference> contractElementReferences = contractElement_p.getContractElementReferences();
    // Get the contract element ref helper to handle contract element references in plug-in file.
    IContractElementRefExtensionFactory contractElementRefExtHelper = getMDSoFaPde().getContractElementRefExtensionHelper();
    // Create a list of up-to-date contract element reference ids used afterward to remove old references.
    List<String> upToDateContractElementReferenceIds = new ArrayList<String>(0);
    // Loop over contract element reference to compute their id and add it into the related list.
    for (ContractElementReference contractElementReference : contractElementReferences) {
      String contractElementReferenceId = contractElementReference.getId();
      // Add the contract element reference to the contract element reference id list.
      contractElementReferenceIds.add(contractElementReferenceId);
      // Add it in the up-to-date contract reference id list.
      upToDateContractElementReferenceIds.add(contractElementReferenceId);
      // Create a command to create the contract element reference in plug-in file.
      commands.add(contractElementRefExtHelper.setContractElementReferenceExtension(contractElementReferenceId, contractElementReference
          .getReferencedContractElementId(), contractElementReference.getReferencedFactoryComponentId()));
    }
    // Loop to remove unreferenced contract elements.
    Iterator<String> iteratorOvercontractElementReferenceId = contractElementReferenceIds.iterator();
    while (iteratorOvercontractElementReferenceId.hasNext()) {
      String currentContractElementReferenceId = iteratorOvercontractElementReferenceId.next();
      // Check if current id is contained in up-to-date list ?
      if (!upToDateContractElementReferenceIds.contains(currentContractElementReferenceId)) {
        commands.add(contractElementRefExtHelper.unsetContractElementReferenceExtension(currentContractElementReferenceId));
        // Remove it from the contract element reference id list.
        iteratorOvercontractElementReferenceId.remove();
      }
    }
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#doCanUndo()
   */
  @Override
  public boolean doCanUndo() {
    // It is possible to undo / redo contract element add operation.
    return true;
  }
}
