package org.eclipse.egf.producer.ftask;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.producer.ftask.internal.task.TaskProductionInvocationFactory;
import org.eclipse.egf.producer.ftask.task.ITaskProductionInvocationFactory;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFProducerFtaskPlugin extends EGFAbstractPlugin {

    /**
     * The shared instance
     */
    private static EGFProducerFtaskPlugin __plugin;

    /**
     * ITaskProductionInvocationFactory singleton.
     */
    private static ITaskProductionInvocationFactory __taskProductionInvocationFactory;

    /**
     * Returns the singleton instance of the ITaskProductionInvocationFactory.
     * 
     * @return the singleton task runner factory.
     */
    public static ITaskProductionInvocationFactory getTaskProductionInvocationFactory() {
        if (__taskProductionInvocationFactory == null) {
            __taskProductionInvocationFactory = new TaskProductionInvocationFactory();
        }
        return __taskProductionInvocationFactory;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
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
        super.stop(context);
        __plugin = null;
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EGFProducerFtaskPlugin getDefault() {
        return __plugin;
    }

}
