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

import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a Context modification (creation) in ProductionPlan & context extensions.
 * @author Guillaume Brocard
 */
public class AddContextInProductionPlanWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AddContextInProductionPlanWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    // Get the added context.
    Context context = (Context) getValue();
    String contextId = context.getId();
    // Get the modified abstract factory component factory.
    AbstractFactoryComponentFactory productionPlan = (AbstractFactoryComponentFactory) getModelElement();
    productionPlan.setContextId(contextId);
    // Create a command to update the production plan in plug-in file.
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(2);
    EgfPdeActivator pdeActivator = EgfPdeActivator.getDefault();
    IProductionPlanExtensionFactory ppHelper = pdeActivator.getProductionPlanExtensionHelper();
    commands.add(ppHelper.setProductionPlanExtension(productionPlan.getId(), contextId));
    // Create a command to create the context in plug-in file.
    IContextExtensionFactory contextHelper = pdeActivator.getContextExtensionHelper();
    commands.add(contextHelper.setContextExtension(contextId));
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    Object value = getValue();
    // The reverse add operation is a remove operation.
    RemoveContextInProductionPlanWrapperCommand removeCommand =
                                                                new RemoveContextInProductionPlanWrapperCommand(getDomain(), getModelElement(), getFeature(),
                                                                                                                value);
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