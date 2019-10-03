package org.eclipse.egf.producer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.internal.registry.ActivityManagerProducerRegistry;
import org.eclipse.egf.producer.internal.registry.ActivityProductionContextProducerRegistry;
import org.eclipse.egf.producer.internal.registry.OrchestrationManagerProducerRegistry;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFProducerPlugin extends EGFAbstractPlugin {

    /**
     * Keep track of the ActivityManagerProducerRegistry
     */
    private static ActivityManagerProducerRegistry __activityManagerProducerRegistry;

    /**
     * Keep track of the ActivityProductionContextProducerRegistry
     */
    private static ActivityProductionContextProducerRegistry __activityProductionContextProducerRegistry;

    /**
     * Keep track of the OrchestrationManagerProducerRegistry
     */
    private static OrchestrationManagerProducerRegistry __orchestrationManagerProducerRegistry;

    // The shared instance
    private static EGFProducerPlugin __plugin;

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
        if (__activityManagerProducerRegistry != null) {
            __activityManagerProducerRegistry.dispose();
            __activityManagerProducerRegistry = null;
        }
        if (__activityProductionContextProducerRegistry != null) {
            __activityProductionContextProducerRegistry.dispose();
            __activityProductionContextProducerRegistry = null;
        }
        if (__orchestrationManagerProducerRegistry != null) {
            __orchestrationManagerProducerRegistry.dispose();
            __orchestrationManagerProducerRegistry = null;
        }
        super.stop(context);
        __plugin = null;
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EGFProducerPlugin getDefault() {
        return __plugin;
    }

    /**
     * Returns an ActivityManagerProducer based on an Fcore model Activity.
     * 
     * @return an ActivityManagerProducer
     */
    public static <P extends Activity> ActivityManagerProducer<P> getActivityManagerProducer(P activity) throws CoreException {
        if (activity == null) {
            return null;
        }
        if (__activityManagerProducerRegistry == null) {
            __activityManagerProducerRegistry = new ActivityManagerProducerRegistry();
        }
        return __activityManagerProducerRegistry.getActivityManagerProducer(activity);
    }

    /**
     * Returns an ActivityProductionContextProducer based on a parent
     * IModelElementProductionContext<?>.
     * 
     * @return an ActivityProductionContextProducer
     */
    public static <P extends Activity> ActivityProductionContextProducer<P> getActivityProductionContextProducer(P activity) throws CoreException {
        if (activity == null) {
            return null;
        }
        if (__activityProductionContextProducerRegistry == null) {
            __activityProductionContextProducerRegistry = new ActivityProductionContextProducerRegistry();
        }
        return __activityProductionContextProducerRegistry.getActivityProductionContextProducer(activity);
    }

    /**
     * Returns an OrchestrationProducer based on a Fcore model Orchestration.
     * 
     * @return an OrchestrationProducer
     */
    public static <P extends Orchestration> OrchestrationManagerProducer<P> getOrchestrationProducer(P orchestration) throws CoreException {
        if (orchestration == null) {
            return null;
        }
        if (__orchestrationManagerProducerRegistry == null) {
            __orchestrationManagerProducerRegistry = new OrchestrationManagerProducerRegistry();
        }
        return __orchestrationManagerProducerRegistry.getOrchestrationManagerProducer(orchestration);
    }

}
