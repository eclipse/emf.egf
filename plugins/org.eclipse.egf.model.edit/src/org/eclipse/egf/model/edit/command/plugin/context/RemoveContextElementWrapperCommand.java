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

import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a context element delete in a context extension.
 * @author fournier
 */
public class RemoveContextElementWrapperCommand extends AbstractContextElementWrapperCommand {

  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public RemoveContextElementWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Get the removed context element.
    ContextElement contextElement = (ContextElement) getValue();
    // Add commands to remove the context element.
    removeContextElement(commands, getContextId(), contextElement.getId(), contextElement);
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    Object value = getValue();
    // The reverse remove operation is an add operation.
    AddContextElementWrapperCommand addCommand = new AddContextElementWrapperCommand(getDomain(), getModelElement(), getFeature(), value);
    // Set it the plug-in id.
    addCommand.setPluginId(getPluginId());
    return addCommand.getExecutablePluginChangeCommand();
  }
}
