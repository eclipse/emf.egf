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
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps an factory component invocation modification in ProductionPlan & factoryComponentConfiguration extensions.
 * @author fournier
 */
public class AddFactoryComponentInvocationWrapperCommand extends AbstractFactoryComponentInvocationWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AddFactoryComponentInvocationWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
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
    // Get the added factory component invocation.
    FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) getValue();
    // Create a command to register the factory component invocation id in production plan.
    IProductionPlanExtensionFactory ppHelper = EgfPdeActivator.getDefault().getProductionPlanExtensionHelper();
    String fcInvocationId = fcInvocation.getId();
    // Add the factory component invocation id in production plan.
    productionPlan.getFactoryComponentInvocationIds().add(fcInvocationId);
    commands.add(ppHelper.setFactoryComponentInvocation(productionPlan.getId(), fcInvocationId));
    // Create a command to register in plug-in file the new factory component invocation.
    IFactoryComponentInvocationExtensionFactory acHelper = EgfPdeActivator.getDefault().getFactoryComponentInvocationExtensionHelper();
    String fcInvocationName = fcInvocation.getName();
    String referencedFcId = fcInvocation.getFactoryComponentId();
    String contextId = fcInvocation.getContextId();
    String taskFactoryId = fcInvocation.getTaskFactoryId();
    commands.add(acHelper.setFactoryComponentInvocationExtension(fcInvocationId, fcInvocationName, referencedFcId, contextId, taskFactoryId));
    // Add factory component dependency to the pointed factory component.
    addFactoryComponentDependency(referencedFcId);
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    Object oldValue = getValue();
    // The reverse add operation is a remove operation.
    RemoveFactoryComponentInvocationWrapperCommand removeCommand = new RemoveFactoryComponentInvocationWrapperCommand(getDomain(), getModelElement(), getFeature(), oldValue);
    // Set it the plug-in id.
    removeCommand.setPluginId(getPluginId());
    return removeCommand.getExecutablePluginChangeCommand();
  }
}
