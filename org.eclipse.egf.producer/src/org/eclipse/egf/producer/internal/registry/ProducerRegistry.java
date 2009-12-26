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
package org.eclipse.egf.producer.internal.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProducerRegistry {

  private ProducerRegistry() {
    // Prevent Instantiation
  }

  /**
   * Extension point "activityManagerProducer" short id.
   */
  protected static final String EXTENSION_POINT_SHORT_ID_ACTIVITY_MANAGER_PRODUCER = "activityManagerProducer"; //$NON-NLS-1$

  /**
   * Extension point "activityProductionContextProducer" short id.
   */
  protected static final String EXTENSION_POINT_SHORT_ID_ACTIVITY_PRODUCTION_CONTEXT_PRODUCER = "activityProductionContextProducer"; //$NON-NLS-1$  

  /**
   * Extension point "orchestrationManagerProducer" short id.
   */
  protected static final String EXTENSION_POINT_SHORT_ID_ORCHESTRATION_MANAGER_PRODUCER = "orchestrationManagerProducer"; //$NON-NLS-1$ 

  /**
   * EGF Registered Activity Manager Producers.
   */
  private static Map<EClass, ActivityManagerProducer> __activityManagerProducers;

  /**
   * EGF Registered Activity Production Context Producers.
   */
  private static Map<Class<IInvocationProductionContext>, ActivityProductionContextProducer> __activityProductionContextProducers;

  /**
   * EGF Registered Orchestration Manager Producers.
   */
  private static Map<EClass, OrchestrationManagerProducer> __orchestrationManagerProducers;

  public static String getName(Object object) {
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getName();
    } else if (object instanceof Class<?>) {
      return ((Class<?>) object).getName();
    }
    return object.getClass().getName();
  }

  /**
   * Get Activity Manager Producers implementations.
   * 
   * @return an empty map if none could be found.
   */
  public static Map<EClass, ActivityManagerProducer> getActivityManagerProducers() {
    // Lazy loading. Search for the implementation.
    if (__activityManagerProducers == null) {
      __activityManagerProducers = new HashMap<EClass, ActivityManagerProducer>();
      // Get ActivityProducer extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(EGFProducerPlugin.getDefault().getPluginID(), EXTENSION_POINT_SHORT_ID_ACTIVITY_MANAGER_PRODUCER)) {
        Object object = null;
        try {
          object = ExtensionPointHelper.createInstance(configurationElement);
        } catch (CoreException ce) {
          EGFProducerPlugin.getDefault().logError(ce);
        }
        if (object == null) {
          continue;
        }
        // Make sure this is the correct resulting type.
        if (object instanceof ActivityManagerProducer == false) {
          EGFProducerPlugin.getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("This Class should be a sub-type of ''{0}''.", ActivityManagerProducer.class.getName()), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          continue;
        }
        __activityManagerProducers.put(((ActivityManagerProducer) object).getActivity(), (ActivityManagerProducer) object);
      }
    }
    return __activityManagerProducers;
  }

  /**
   * Get Activity Production Context Producers implementations.
   * 
   * @return an empty map if none could be found.
   */
  public static Map<Class<IInvocationProductionContext>, ActivityProductionContextProducer> getActivityProductionContextProducers() {
    // Lazy loading. Search for the implementation.
    if (__activityProductionContextProducers == null) {
      __activityProductionContextProducers = new HashMap<Class<IInvocationProductionContext>, ActivityProductionContextProducer>();
      // Get ActivityProductionContextProducer extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(EGFProducerPlugin.getDefault().getPluginID(), EXTENSION_POINT_SHORT_ID_ACTIVITY_PRODUCTION_CONTEXT_PRODUCER)) {
        Object object = null;
        try {
          object = ExtensionPointHelper.createInstance(configurationElement);
        } catch (CoreException ce) {
          EGFProducerPlugin.getDefault().logError(ce);
        }
        if (object == null) {
          continue;
        }
        // Make sure this is the correct resulting type.
        if (object instanceof ActivityProductionContextProducer == false) {
          EGFProducerPlugin.getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("This Class should be a sub-type of ''{0}''.", ActivityProductionContextProducer.class.getName()), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          continue;
        }
        __activityProductionContextProducers.put(((ActivityProductionContextProducer) object).getParentProductionContext(), (ActivityProductionContextProducer) object);
      }
    }
    return __activityProductionContextProducers;
  }

  /**
   * Get Orchestration Manager Producers implementations.
   * 
   * @return an empty map if none could be found.
   */
  public static Map<EClass, OrchestrationManagerProducer> getOrchestrationManagerProducers() {
    // Lazy loading. Search for the implementation.
    if (__orchestrationManagerProducers == null) {
      __orchestrationManagerProducers = new HashMap<EClass, OrchestrationManagerProducer>();
      // Get ActivityProducer extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(EGFProducerPlugin.getDefault().getPluginID(), EXTENSION_POINT_SHORT_ID_ORCHESTRATION_MANAGER_PRODUCER)) {
        Object object = null;
        try {
          object = ExtensionPointHelper.createInstance(configurationElement);
        } catch (CoreException ce) {
          EGFProducerPlugin.getDefault().logError(ce);
        }
        if (object == null) {
          continue;
        }
        // Make sure this is the correct resulting type.
        if (object instanceof OrchestrationManagerProducer == false) {
          EGFProducerPlugin.getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("This Class should be a sub-type of ''{0}''.", OrchestrationManagerProducer.class.getName()), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          continue;
        }
        __orchestrationManagerProducers.put(((OrchestrationManagerProducer) object).getOrchestration(), (OrchestrationManagerProducer) object);
      }
    }
    return __orchestrationManagerProducers;
  }

}
