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
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a factory component invocation modification in factoryComponentConfiguration extension.
 * @author fournier
 */
public class SetFactoryComponentInvocationWrapperCommand extends AbstractFactoryComponentInvocationWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public SetFactoryComponentInvocationWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Get the modified factory component invocation.
    FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) getModelElement();
    // Create a command to set modifications in plug-in file.
    IFactoryComponentInvocationExtensionFactory acHelper = EgfPdeActivator.getDefault().getFactoryComponentInvocationExtensionHelper();
    String referencedFcId = fcInvocation.getFactoryComponentId();
    commands.add(acHelper.setFactoryComponentInvocationExtension(fcInvocation.getId(), fcInvocation.getName(), referencedFcId, fcInvocation
        .getContextId(), fcInvocation.getTaskFactoryId()));
    // Add factory component dependency to the referenced factory component.
    addFactoryComponentDependency(referencedFcId);
    // Remove the previous referenced factory component dependency if the referenced factory component has changed.
    if (ModelPackage.Literals.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID == getFeature()) {
      removeFactoryComponentDependency((String) getValue());
    }
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    return getExecutablePluginChangeCommand();
  }
}