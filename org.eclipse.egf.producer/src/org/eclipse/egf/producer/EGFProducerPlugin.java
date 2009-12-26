package org.eclipse.egf.producer;

import java.util.Map;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.MissingExtensionException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.egf.producer.internal.registry.ProducerRegistry;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.emf.ecore.EClass;
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
   * Returns an ActivityManagerProducer based on an Fcore model Activity.
   * 
   * @return an ActivityManagerProducer
   */
  public static ActivityManagerProducer getActivityManagerProducer(Activity activity) throws MissingExtensionException {
    Map<EClass, ActivityManagerProducer> producers = ProducerRegistry.getActivityManagerProducers();
    ActivityManagerProducer producer = producers.get(EMFHelper.solveAgainstStaticPackage(activity.eClass()));
    if (producer == null) {
      throw new MissingExtensionException(NLS.bind(ProducerMessages.ActivityManagerProducer_extension_error, ProducerRegistry.getName(activity)));
    }
    return producer;

  }

  /**
   * Returns an ActivityProductionContextProducer based on a parent
   * IModelElementProductionContext<?>.
   * 
   * @return an ActivityProductionContextProducer
   */
  public static ActivityProductionContextProducer getActivityProductionContextProducer(IInvocationProductionContext parentProductionContext) throws MissingExtensionException {
    Map<Class<IInvocationProductionContext>, ActivityProductionContextProducer> producers = ProducerRegistry.getActivityProductionContextProducers();
    ActivityProductionContextProducer producer = producers.get(parentProductionContext.getClass());
    if (producer == null) {
      throw new MissingExtensionException(NLS.bind(ProducerMessages.ActivityProductionContextProducer_extension_error, ProducerRegistry.getName(parentProductionContext)));
    }
    return producer;

  }

  /**
   * Returns an OrchestrationProducer based on a Fcore model Orchestration.
   * 
   * @return an OrchestrationProducer
   */
  public static OrchestrationManagerProducer getOrchestrationProducer(Orchestration orchestration) throws MissingExtensionException {
    Map<EClass, OrchestrationManagerProducer> producers = ProducerRegistry.getOrchestrationManagerProducers();
    OrchestrationManagerProducer producer = producers.get(EMFHelper.solveAgainstStaticPackage(orchestration.eClass()));
    if (producer == null) {
      throw new MissingExtensionException(NLS.bind(ProducerMessages.OrchestrationManagerProducer_extension_error, ProducerRegistry.getName(orchestration)));
    }
    return producer;

  }

}
