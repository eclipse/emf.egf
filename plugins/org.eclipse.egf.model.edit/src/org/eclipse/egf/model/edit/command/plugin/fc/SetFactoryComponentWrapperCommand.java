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
package org.eclipse.egf.model.edit.command.plugin.fc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a factory component modification in a factoryComponent extension.
 * @author fournier
 */
public class SetFactoryComponentWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Helper to deal with factoryComponent extension.
   */
  private IFactoryComponentExtensionFactory _helper;

  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public SetFactoryComponentWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
    _helper = getMDSoFaPde().getFactoryComponentExtensionHelper();
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  public List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Get factory component data.
    FactoryComponent fcElement = (FactoryComponent) getModelElement();
    // Get the contract id.
    Contract contract = ModelHelper.getContract(fcElement);
    String contractId = (null != contract) ? contract.getId() : null;
    // Get the domain value
    Domain fcDomain = fcElement.getDomain();
    String domainValue = (null != fcDomain) ? fcDomain.getPath() : null;
    // Get the production plan id.
    ProductionPlan productionPlan = ModelHelper.getProductionPlan(fcElement);
    String productionPlanId = (null != productionPlan) ? productionPlan.getId() : null;
    // Create a set command and add it to the list.
    commands.add(_helper.setFactoryComponentExtension(fcElement.getId(), fcElement.getName(), contractId, domainValue, productionPlanId, fcElement
        .getDescription()));
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    return getExecutablePluginChangeCommand();
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#doCanUndo()
   */
  @Override
  public boolean doCanUndo() {
    return true;
  }
}
