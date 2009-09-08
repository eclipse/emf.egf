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
package org.eclipse.egf.model.edit.command.plugin.fci;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.edit.command.plugin.context.RemoveContextInFcInvocationWrapperCommand;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.ITaskFactoryExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a factory component invocation modification in ProductionPlan & factoryComponentConfiguration extensions.
 * @author fournier
 */
public class RemoveFactoryComponentInvocationWrapperCommand extends AbstractFactoryComponentInvocationWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public RemoveFactoryComponentInvocationWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Get production plan as parent.
    ProductionPlan productionPlan = (ProductionPlan) getModelElement();
    // Get the removed factory component invocation.
    FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) getValue();
    String fcInvocationId = fcInvocation.getId();
    // Remove the factory component invocation id from the production plan.
    productionPlan.getFactoryComponentInvocationIds().remove(fcInvocationId);
    // Create a command to remove the factory component invocation from the production plan.
    IProductionPlanExtensionFactory ppHelper = EgfPdeActivator.getDefault().getProductionPlanExtensionHelper();
    commands.add(ppHelper.unsetFactoryComponentInvocation(productionPlan.getId(), fcInvocationId));
    // Create a command to remove its factory if any.
    String taskFactoryHolderId = fcInvocation.getTaskFactoryId();
    if (null != taskFactoryHolderId) {
      ITaskFactoryExtensionFactory taskFactoryHelper = EgfPdeActivator.getDefault().getTaskFactoryExtensionHelper();
      commands.add(taskFactoryHelper.unsetTaskFactoryExtension(taskFactoryHolderId));
    }
    // Create a command to remove its context and all context children stuffs.
    if (null != fcInvocation.getContextId()) {
      RemoveContextInFcInvocationWrapperCommand removeContextCommand =
                                                                    new RemoveContextInFcInvocationWrapperCommand(
                                                                                                               getDomain(),
                                                                                                               fcInvocation,
                                                                                                               ModelPackage.Literals.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT,
                                                                                                               fcInvocation.getContext());
      // Set its plug-in id otherwise we can not perform the underlying commands provided by this wrapper command.
      removeContextCommand.setPluginId(getPluginId());
      // Get all sub commands to remove a context.
      commands.addAll(removeContextCommand.getExecutablePluginChangeCommand());
    }
    // Create a command to remove the factory component invocation from the plug-in file.
    IFactoryComponentInvocationExtensionFactory acHelper = EgfPdeActivator.getDefault().getFactoryComponentInvocationExtensionHelper();
    commands.add(acHelper.unsetFactoryComponentInvocationExtension(fcInvocationId));
    // Remove the referenced factory component dependency.
    removeFactoryComponentDependency(fcInvocation.getFactoryComponentId());
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    Object oldValue = getValue();
    // The reverse remove operation is an add operation.
    AddFactoryComponentInvocationWrapperCommand addCommand = new AddFactoryComponentInvocationWrapperCommand(getDomain(), getModelElement(), getFeature(), oldValue);
    // Set it the plug-in id.
    addCommand.setPluginId(getPluginId());
    return addCommand.getExecutablePluginChangeCommand();
  }
}
