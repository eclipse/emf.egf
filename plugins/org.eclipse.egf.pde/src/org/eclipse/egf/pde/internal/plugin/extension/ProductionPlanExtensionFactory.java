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
package org.eclipse.egf.pde.internal.plugin.extension;

import org.eclipse.egf.pde.internal.plugin.command.pp.SetFactoryComponentInvocationReferenceCommand;
import org.eclipse.egf.pde.internal.plugin.command.pp.SetProductionPlanExtensionCommand;
import org.eclipse.egf.pde.internal.plugin.command.pp.UnsetFactoryComponentInvocationReferenceCommand;
import org.eclipse.egf.pde.internal.plugin.command.pp.UnsetProductionPlanExtensionCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory;

/**
 * This factory creates commands to deal with "ProductionPlan" extension-point.
 * @author fournier
 */
public class ProductionPlanExtensionFactory implements IProductionPlanExtensionFactory {
  /**
   * Unique reference.
   */
  private static ProductionPlanExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private ProductionPlanExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static ProductionPlanExtensionFactory getInstance() {
    if (null == __instance) {
      __instance = new ProductionPlanExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory#setProductionPlanExtension(java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setProductionPlanExtension(String productionPlanId_p, String contextId_p) {
    return new SetProductionPlanExtensionCommand(productionPlanId_p, contextId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory#unsetProductionPlanExtension(java.lang.String)
   */
  public IPluginChangesCommand unsetProductionPlanExtension(String productionPlanId_p) {
    return new UnsetProductionPlanExtensionCommand(productionPlanId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory#setFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setFactoryComponentInvocation(String productionPlanId_p, String factoryComponentInvocationId_p) {
    return new SetFactoryComponentInvocationReferenceCommand(productionPlanId_p, factoryComponentInvocationId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory#unsetFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand unsetFactoryComponentInvocation(String productionPlanId_p, String factoryComponentInvocationId_p) {
    return new UnsetFactoryComponentInvocationReferenceCommand(productionPlanId_p, factoryComponentInvocationId_p);
  }
}
