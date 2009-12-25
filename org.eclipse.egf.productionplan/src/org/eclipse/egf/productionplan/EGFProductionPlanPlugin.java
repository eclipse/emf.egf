package org.eclipse.egf.productionplan;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.productionplan.context.IProductionPlanContextFactory;
import org.eclipse.egf.productionplan.context.IProductionPlanManagerFactory;
import org.eclipse.egf.productionplan.internal.context.ProductionPlanContextFactory;
import org.eclipse.egf.productionplan.internal.manager.ProductionPlanManagerFactory;
import org.eclipse.egf.productionplan.internal.task.ProductionPlanTaskInvocationFactory;
import org.eclipse.egf.productionplan.task.IProductionPlanTaskInvocationFactory;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFProductionPlanPlugin extends EGFAbstractPlugin {

  /**
   * The shared instance
   */
  private static EGFProductionPlanPlugin __plugin;

  /**
   * IProductionPlanContextFactory singleton.
   */
  private static IProductionPlanContextFactory __productionPlanContextFactory;

  /**
   * IProductionPlanActivityFactory singleton.
   */
  private static IProductionPlanManagerFactory __productionPlanManagerFactory;

  /**
   * IProductionPlanTaskInvocationFactory singleton.
   */
  private static IProductionPlanTaskInvocationFactory __productionPlanTaskInvocationFactory;

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
  }

  /**
   * Returns the singleton instance of the IProductionPlanContextFactory.
   * 
   * @return the singleton production plan context factory.
   */
  public static IProductionPlanContextFactory getProductionPlanContextFactory() {
    if (__productionPlanContextFactory == null) {
      __productionPlanContextFactory = new ProductionPlanContextFactory();
    }
    return __productionPlanContextFactory;
  }

  /**
   * Returns the singleton instance of the IProductionPlanManagerFactory.
   * 
   * @return the singleton production plan manager factory.
   */
  public static IProductionPlanManagerFactory getProductionPlanManagerFactory() {
    if (__productionPlanManagerFactory == null) {
      __productionPlanManagerFactory = new ProductionPlanManagerFactory();
    }
    return __productionPlanManagerFactory;
  }

  /**
   * Returns the singleton instance of the IProductionPlanTaskInvocationFactory.
   * 
   * @return the singleton task runner factory.
   */
  public static IProductionPlanTaskInvocationFactory getProductionPlanTaskInvocationFactory() {
    if (__productionPlanTaskInvocationFactory == null) {
      __productionPlanTaskInvocationFactory = new ProductionPlanTaskInvocationFactory();
    }
    return __productionPlanTaskInvocationFactory;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    __plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static EGFProductionPlanPlugin getDefault() {
    return __plugin;
  }

}
