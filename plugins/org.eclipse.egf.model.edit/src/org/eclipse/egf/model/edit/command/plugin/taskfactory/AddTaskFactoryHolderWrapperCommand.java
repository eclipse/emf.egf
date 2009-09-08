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
package org.eclipse.egf.model.edit.command.plugin.taskfactory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.ITaskFactoryExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a Task Factory Holder modification in taskFactory extensions.
 * @author fournier
 */
public class AddTaskFactoryHolderWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AddTaskFactoryHolderWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Get factory component invocation as parent.
    FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) getModelElement();
    // Get the added task factory.
    TaskFactoryHolder taskFactory = (TaskFactoryHolder) getValue();
    // Get data related to the task factory to report in plug-in file.
    String taskFactoryId = taskFactory.getId();
    String taskFactoryClass = taskFactory.getFactoryClass();
    // Set the task factory id in factory component invocation.
    fcInvocation.setTaskFactoryId(taskFactoryId);
    // Get FactoryComponent configuration data
    String fcInvocationId = fcInvocation.getId();
    String fcInvocationName = fcInvocation.getName();
    String referencedFcId = fcInvocation.getFactoryComponentId();
    String contextId = fcInvocation.getContextId();
    IFactoryComponentInvocationExtensionFactory acHelper = EgfPdeActivator.getDefault().getFactoryComponentInvocationExtensionHelper();
    // Create a command to update the factory component invocation which references this task factory.
    commands.add(acHelper.setFactoryComponentInvocationExtension(fcInvocationId, fcInvocationName, referencedFcId, contextId, taskFactoryId));
    // Create a command to register in plug-in file the new task factory holder.
    ITaskFactoryExtensionFactory ppHelper = EgfPdeActivator.getDefault().getTaskFactoryExtensionHelper();
    commands.add(ppHelper.setTaskFactoryExtension(taskFactoryId, taskFactoryClass));
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    Object oldValue = getValue();
    // The reverse add operation is a remove operation.
    RemoveTaskFactoryHolderWrapperCommand removeCommand = new RemoveTaskFactoryHolderWrapperCommand(getDomain(), getModelElement(), getFeature(), oldValue);
    // Set it the plug-in id.
    removeCommand.setPluginId(getPluginId());
    return removeCommand.getExecutablePluginChangeCommand();
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#doCanUndo()
   */
  @Override
  public boolean doCanUndo() {
    return true;
  }
}
