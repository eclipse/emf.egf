package org.eclipse.egf.productionplan;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.productionplan.context.IProductionPlanContextFactory;
import org.eclipse.egf.productionplan.internal.context.ProductionPlanContextFactory;
import org.eclipse.egf.productionplan.internal.manager.ProductionPlanActivityFactory;
import org.eclipse.egf.productionplan.manager.IProductionPlanActivityFactory;
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
  private static IProductionPlanActivityFactory __productionPlanActivityFactory;

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
   * Returns the singleton instance of the IProductionPlanActivityFactory.
   * 
   * @return the singleton production plan context factory.
   */
  public static IProductionPlanActivityFactory getProductionPlanActivityFactory() {
    if (__productionPlanActivityFactory == null) {
      __productionPlanActivityFactory = new ProductionPlanActivityFactory();
    }
    return __productionPlanActivityFactory;
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
