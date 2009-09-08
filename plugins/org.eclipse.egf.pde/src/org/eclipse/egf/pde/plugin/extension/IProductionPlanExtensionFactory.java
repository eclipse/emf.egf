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
package org.eclipse.egf.pde.plugin.extension;

import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;

/**
 * This factory creates commands to deal with "ProductionPlan" extension-point.
 * @author fournier
 */
public interface IProductionPlanExtensionFactory {
  /**
   * Set an extension matching "ProductionPlan" extension-point for given parameters.
   * @param productionPlanId_p
   * @param contextId_p
   */
  public IPluginChangesCommand setProductionPlanExtension(String productionPlanId_p, String contextId_p);

  /**
   * Unset an existing extension matching "ProductionPlan" extension-point for given parameters.
   * @param productionPlanId_p
   */
  public IPluginChangesCommand unsetProductionPlanExtension(String productionPlanId_p);

  /**
   * Set a factory component invocation in a production plan.
   * @param productionPlanId_p
   * @param factoryComponentInvocationId_p
   * @return
   */
  public IPluginChangesCommand setFactoryComponentInvocation(String productionPlanId_p, String factoryComponentInvocationId_p);

  /**
   * Unset a factory component invocation in a production plan.
   * @param productionPlanId_p
   * @param factoryComponentInvocationId_p
   * @return
   */
  public IPluginChangesCommand unsetFactoryComponentInvocation(String productionPlanId_p, String factoryComponentInvocationId_p);
}
