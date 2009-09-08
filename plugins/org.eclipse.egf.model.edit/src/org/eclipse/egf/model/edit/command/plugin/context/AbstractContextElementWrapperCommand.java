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
package org.eclipse.egf.model.edit.command.plugin.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Base class to implement a command that wraps a context extension processing.
 * @author fournier
 */
public abstract class AbstractContextElementWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AbstractContextElementWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * Returns the context id of model element object.
   * @return
   */
  protected String getContextId() {
    String contextId = null;
    NamedModelElementWithId modelElement = getModelElement();
    // ModelElement is the context object.
    if (modelElement instanceof Context) {
      contextId = modelElement.getId();
    } else if (modelElement instanceof ContextElement) {
      // Contract is the parent of ContextElement.
      contextId = ((NamedModelElementWithId) modelElement.eContainer()).getId();
    }
    return contextId;
  }

  /**
   * Handle a context to be set or created.
   * @param contextElement_p
   * @return
   */
  protected List<IPluginChangesCommand> handleContextElement(ContextElement contextElement_p) {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // // Get the context id.
    String contextId = getContextId();
    // Get context element data.
    String contextElementId = contextElement_p.getId();
    String contextElementValue = contextElement_p.getReadableValue();
    // Add commands to remove the previous context element with the same id.
    // When the end-user edits a context element again, it can change it from a context element based on a key/value to a context element based on a
    // reference (or vice versa).
    // The easiest way to handle that is to remove it systematically.
    removeContextElement(commands, contextId, contextElementId, contextElement_p);
    // Try creating the right context element : either a contextElement based on type or one based on a contract reference.
    // Is this context element a simple (key/type and value) or value for a contract element reference ?
    ContractElementReference contractElementReference = contextElement_p.getContractElementReference();
    if (null != contractElementReference) {
      // Case of a context element based on a contract element.
      handleContextElementBasedOnContractElementReference(commands, contextElement_p, contractElementReference, contextId, contextElementId,
                                                          contextElementValue);
    } else {
      // Case of context element based on a local type.
      handleContextElementBasedOnKey(commands, contextElement_p, contextId, contextElementId, contextElementValue);
    }
    return commands;
  }

  /**
   * Handle a context element based on a key.
   * @param commands_p
   * @param contextElement_p
   * @param contextId_p
   * @param contextElementId_p
   * @param contextElementValue_p
   */
  protected void handleContextElementBasedOnKey(List<IPluginChangesCommand> commands_p, ContextElement contextElement_p, String contextId_p,
      String contextElementId_p, String contextElementValue_p) {
    // Create a command to create the context element in plug-in file.
    commands_p.add(getMDSoFaPde().getContextExtensionHelper().setContextElementBasedOnKey(contextId_p, contextElementId_p, contextElement_p.getKey(),
                                                                                          contextElement_p.getContextType().getTypeHolderClassName(),
                                                                                          contextElementValue_p));
  }

  /**
   * Handle a context element based on a contract element reference.
   * @param commands_p
   * @param contextElement_p
   * @param contextId_p
   * @param contextElementId_p
   * @param contextElementValue_p
   */
  protected void handleContextElementBasedOnContractElementReference(List<IPluginChangesCommand> commands_p, ContextElement contextElement_p,
      ContractElementReference contractElementReference_p, String contextId_p, String contextElementId_p, String contextElementValue_p) {
    // Get the new contract element reference id.
    String newContractElementReferenceId = contractElementReference_p.getId();
    // Create a command to set the contract element reference.
    commands_p.add(getMDSoFaPde().getContractElementRefExtensionHelper()
        .setContractElementReferenceExtension(newContractElementReferenceId, contractElementReference_p.getReferencedContractElementId(),
                                              contractElementReference_p.getReferencedFactoryComponentId()));
    // Create a command to create the context element in plug-in file.
    commands_p.add(getMDSoFaPde().getContextExtensionHelper().setContextElementBasedOnContractElementRef(contextId_p, contextElementId_p,
                                                                                                         newContractElementReferenceId, contextElementValue_p));
    // Set the new contract element reference id.
    contextElement_p.setContractReferenceId(newContractElementReferenceId);
  }

  /**
   * Remove (in plug-in file) given context element from given context.
   * @param commands_p
   * @param contextId
   * @param contextElementId
   * @param contextElement_p
   */
  protected void removeContextElement(List<IPluginChangesCommand> commands_p, String contextId, String contextElementId, ContextElement contextElement_p) {
    commands_p.add(getMDSoFaPde().getContextExtensionHelper().unsetContextElement(contextId, contextElementId));
    // Handle the previous contract element reference if any.
    removePreviousContractElementReference(commands_p, contextElement_p);
  }

  /**
   * Remove the previous contract element reference if any.
   * @param commands_p
   * @param contextElement_p
   */
  protected void removePreviousContractElementReference(List<IPluginChangesCommand> commands_p, ContextElement contextElement_p) {
    // Get the previous contract element reference id if defined.
    String previousContractElementReferenceId = contextElement_p.getContractReferenceId();
    if (null != previousContractElementReferenceId) {
      // Create a command to remove the previous contract element reference.
      commands_p.add(getMDSoFaPde().getContractElementRefExtensionHelper().unsetContractElementReferenceExtension(previousContractElementReferenceId));
    }
    // Reset to null.
    contextElement_p.setContractReferenceId(null);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#doCanUndo()
   */
  @Override
  public boolean doCanUndo() {
    return true;
  }
}
