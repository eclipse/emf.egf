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

import java.util.List;

import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.edit.command.plugin.fci.SetFactoryComponentInvocationWrapperCommand;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a Context modification (creation) in factoryComponentConfiguration & context extensions.
 * @author fournier
 */
public class AddContextInFcInvocationConfWrapperCommand extends SetFactoryComponentInvocationWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AddContextInFcInvocationConfWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.fci.SetFactoryComponentInvocationWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    // Get the added context.
    Context context = (Context) getValue();
    String contextId = context.getId();
    // Get the modified abstract factory component factory.
    AbstractFactoryComponentFactory parent = (AbstractFactoryComponentFactory) getModelElement();
    parent.setContextId(contextId);
    // Get the commands related to factory component configuration update.
    List<IPluginChangesCommand> commands = super.getExecutablePluginChangeCommand();
    // Create a command to set modifications in plug-in file.
    IContextExtensionFactory contextHelper = EgfPdeActivator.getDefault().getContextExtensionHelper();
    commands.add(contextHelper.setContextExtension(contextId));
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.fci.SetFactoryComponentInvocationWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    Object value = getValue();
    // The reverse add operation is a remove operation.
    RemoveContextInFcInvocationWrapperCommand removeCommand = new RemoveContextInFcInvocationWrapperCommand(getDomain(), getModelElement(), getFeature(), value);
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
