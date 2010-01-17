package org.eclipse.egf.fprod.producer;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.fprod.producer.internal.task.ProductionPlanTaskInvocationFactory;
import org.eclipse.egf.fprod.producer.task.IProductionPlanTaskInvocationFactory;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFFprodProducerPlugin extends EGFAbstractPlugin {

  /**
   * The shared instance
   */
  private static EGFFprodProducerPlugin __plugin;

  /**
   * IProductionPlanTaskInvocationFactory singleton.
   */
  private static IProductionPlanTaskInvocationFactory __productionPlanTaskInvocationFactory;

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
   * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
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
  public static EGFFprodProducerPlugin getDefault() {
    return __plugin;
  }

}
