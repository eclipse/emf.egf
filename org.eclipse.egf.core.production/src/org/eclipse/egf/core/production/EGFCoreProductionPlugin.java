/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.production;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.core.production.context.IProductionContextFactory;
import org.eclipse.egf.core.production.internal.context.ProductionContextFactory;
import org.eclipse.egf.core.production.internal.task.ProductionTaskInvocationFactory;
import org.eclipse.egf.core.production.task.IProductionTaskInvocationFactory;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCoreProductionPlugin extends EGFAbstractPlugin {

  /**
   * Plug-in unique instance.
   */
  private static EGFCoreProductionPlugin __plugin;

  /**
   * IProductionContextFactory singleton.
   */
  private static IProductionContextFactory __productionContextFactory;

  /**
   * IProductionTaskInvocationFactory singleton.
   */
  private static IProductionTaskInvocationFactory __productionTaskInvocationFactory;

  /**
   * Get activator shared instance.
   * 
   * @return
   */
  public static EGFCoreProductionPlugin getDefault() {
    return __plugin;
  }

  /**
   * Returns the singleton instance of the IProductionContextFactory.
   * 
   * @return the singleton production context factory.
   */
  public static IProductionContextFactory getProductionContextFactory() {
    if (__productionContextFactory == null) {
      __productionContextFactory = new ProductionContextFactory();
    }
    return __productionContextFactory;
  }

  /**
   * Returns the singleton instance of the IProductionTaskInvocationFactory.
   * 
   * @return the singleton task runner factory.
   */
  public static IProductionTaskInvocationFactory getProductionTaskInvocationFactory() {
    if (__productionTaskInvocationFactory == null) {
      __productionTaskInvocationFactory = new ProductionTaskInvocationFactory();
    }
    return __productionTaskInvocationFactory;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    __plugin = null;
    super.stop(context);
  }

}