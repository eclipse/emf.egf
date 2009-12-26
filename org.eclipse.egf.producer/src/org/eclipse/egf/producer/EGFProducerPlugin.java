package org.eclipse.egf.producer;

import java.util.Map;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.core.producer.MissingExtensionException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.producer.activity.ActivityProducer;
import org.eclipse.egf.producer.activity.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IModelElementProductionContext;
import org.eclipse.egf.producer.internal.registry.ProducerRegistry;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.orchestration.OrchestrationProducer;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFProducerPlugin extends EGFAbstractPlugin {

  // The shared instance
  private static EGFProducerPlugin __plugin;

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
  public static EGFProducerPlugin getDefault() {
    return __plugin;
  }

  /**
   * Returns an ActivityProducer based on a Fcore model Activity.
   * 
   * @return an ActivityProducer
   */
  public static ActivityProducer getActivityProducer(Activity activity) throws MissingExtensionException {
    Map<String, ActivityProducer> producers = ProducerRegistry.getActivityProducers();
    ActivityProducer producer = producers.get(ProducerRegistry.getName(activity));
    if (producer == null) {
      throw new MissingExtensionException(NLS.bind(ProducerMessages.Activity_extension_error, ProducerRegistry.getName(activity)));
    }
    return producer;

  }

  /**
   * Returns an ActivityProductionContextProducer based on a parent
   * IModelElementProductionContext<?>.
   * 
   * @return an ActivityProductionContextProducer
   */
  public static ActivityProductionContextProducer<?> getActivityProductionContextProducer(IModelElementProductionContext<?> parentProductionContext) throws MissingExtensionException {
    Map<Class<IModelElementProductionContext<?>>, ActivityProductionContextProducer<?>> producers = ProducerRegistry.getActivityProductionContextProducers();
    ActivityProductionContextProducer<?> producer = producers.get(parentProductionContext.getClass());
    if (producer == null) {
      throw new MissingExtensionException(NLS.bind(ProducerMessages.ActivityProductionContext_extension_error, ProducerRegistry.getName(parentProductionContext)));
    }
    return producer;

  }

  /**
   * Returns an OrchestrationProducer based on a Fcore model Orchestration.
   * 
   * @return an OrchestrationProducer
   */
  public static OrchestrationProducer getOrchestrationProducer(Orchestration orchestration) throws MissingExtensionException {
    Map<String, OrchestrationProducer> producers = ProducerRegistry.getOrchestrationProducers();
    OrchestrationProducer producer = producers.get(ProducerRegistry.getName(orchestration));
    if (producer == null) {
      throw new MissingExtensionException(NLS.bind(ProducerMessages.Orchestration_extension_error, ProducerRegistry.getName(orchestration)));
    }
    return producer;

  }

}
