package org.eclipse.egf.ftask.producer;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.ftask.producer.internal.task.TaskJavaProductionInvocationFactory;
import org.eclipse.egf.ftask.producer.task.ITaskJavaProductionInvocationFactory;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFFtaskProducerPlugin extends EGFAbstractPlugin {

  /**
   * The shared instance
   */
  private static EGFFtaskProducerPlugin __plugin;

  /**
   * ITaskProductionInvocationFactory singleton.
   */
  private static ITaskJavaProductionInvocationFactory __taskProductionInvocationFactory;

  /**
   * Returns the singleton instance of the ITaskProductionInvocationFactory.
   * 
   * @return the singleton task runner factory.
   */
  public static ITaskJavaProductionInvocationFactory getTaskProductionInvocationFactory() {
    if (__taskProductionInvocationFactory == null) {
      __taskProductionInvocationFactory = new TaskJavaProductionInvocationFactory();
    }
    return __taskProductionInvocationFactory;
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
  public static EGFFtaskProducerPlugin getDefault() {
    return __plugin;
  }

}
