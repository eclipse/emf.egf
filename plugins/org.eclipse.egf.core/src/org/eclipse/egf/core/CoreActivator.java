/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;

import org.eclipse.egf.common.activator.AbstractActivator;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.progress.IProgressRunnable;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.data.FactoryComponentRegistry;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.core.internal.helper.FactoryComponentSortingPriorityHelper;
import org.eclipse.egf.core.internal.production.Messages;
import org.eclipse.egf.core.internal.production.ProductionManager;
import org.eclipse.egf.core.internal.reader.DefaultFactoryComponentReader;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentDescriptor;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ModelActivator;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;


/**
 * The activator class controls the plug-in life cycle.
 * @author brocard
 */
public class CoreActivator extends AbstractActivator {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(CoreActivator.class.getPackage().getName());
  /**
   * Plug-in unique instance.
   */
  private static CoreActivator __plugin;
  /**
   * Production manager.
   */
  private ProductionManager _productionManager;
  /**
   * FactoryComponent registry.
   */
  private FactoryComponentRegistry _fcRegistry;

  /**
   * Get activator shared instance.
   * @return
   */
  public static CoreActivator getDefault() {
    return __plugin;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
    // Configure log4j.
    Log4JConfigurator.configure(getBundle());
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {    
    __plugin = null;
    super.stop(context_p);
  }

  /**
   * Generate given factory component synchronously.
   * That is execute it in current thread.<br>
   * This method should be used in case of dynamically created factory components.<br>
   * If not, it is highly recommended to use {@link #generateFactoryComponent(String, IProgressMonitor, boolean)} instead.
   * @param factoryComponent_p
   * @return
   */
  public boolean generateFactoryComponentSynchronously(FactoryComponent factoryComponent_p) {
    boolean result = false;
    // Precondition.
    if (null == factoryComponent_p) {
      return result;
    }
    // Add new factory component to factory component registry.
    FactoryComponentRegistry fcRegistry = getFactoryComponentRegistry();
    String fcId = factoryComponent_p.getId();
    FactoryComponent alreadyKnownFc = fcRegistry.getFactoryComponent(fcId);
    boolean removeFromRegistry = false;
    // Precondition.
    if ((null != alreadyKnownFc) && (alreadyKnownFc != factoryComponent_p)) {
      StringBuilder loggerMessage = new StringBuilder("CoreActivator.generateFactoryComponentSynchronously(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Prevented corruption status to occur !"); //$NON-NLS-1$
      loggerMessage.append("Trying to execute factory component ").append(factoryComponent_p.getName()); //$NON-NLS-1$
      loggerMessage.append(" in replacement of ").append(alreadyKnownFc.getName()); //$NON-NLS-1$
      loggerMessage.append(" .Both are having the same ID, and yet there are not equal !"); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString());
      return result;
    } else if (null == alreadyKnownFc) {
      removeFromRegistry = true;
      fcRegistry.addFactoryComponent(fcId, factoryComponent_p);
    }
    // Generate it.
    result = generateFactoryComponent(fcId, null, false);
    // Finally remove it from factory component registry.
    if (removeFromRegistry) {
      fcRegistry.removeFactoryComponent(fcId);
    }
    return result;
  }

  /**
   * Generate identified factory component.
   * @param factoryComponentId_p
   * @param progressMonitor_p A progress monitor to use in case of a synchronous generation (can be null).
   * @param forkJob_p Should generation be executed in a job ? If true, given progress monitor remains unused.
   */
  public boolean generateFactoryComponent(final String factoryComponentId_p, IProgressMonitor progressMonitor_p, boolean forkJob_p) {
    boolean result = true;
    // Lazy allocation.
    if (_productionManager == null) {
      _productionManager = new ProductionManager();
    }
    // Create progress runnable.
    final ProductionManager productionManager = _productionManager;
    IProgressRunnable generateFc = new IProgressRunnable() {
      public String getReportingTitle() {
        return Messages.ProductionManager_ProgressReporting_Title + factoryComponentId_p;
      }

      public boolean run(IProgressMonitor runnableProgressMonitor_p) {
        return productionManager.generate(factoryComponentId_p, runnableProgressMonitor_p);
      }
    };
    // Execute it.
    if (forkJob_p) {
      ProgressReporter.asyncExec(generateFc);
    } else {
      result = ProgressReporter.syncExec(generateFc, progressMonitor_p);
    }
    return result;
  }

  /**
   * Get the collection of installed factory components in the running Eclipse instance.
   * @return a not null collection.
   */
  public Collection<FactoryComponent> getFactoryComponentsInPlatform() {
    ArrayList<FactoryComponent> resultingFcList = new ArrayList<FactoryComponent>(0);
    // Get all configuration elements for 'factoryComponent' extension-point.
    IConfigurationElement[] fcConfigurationElements = ExtensionPointHelper.getConfigurationElements(
      getPluginID(), 
      IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_POINT_ID
    );
    // Instantiate an eclipse platform factory component reader.
    DefaultFactoryComponentReader factoryComponentReader = new DefaultFactoryComponentReader();
    // Loop over retrieved factory components as configuration element.
    for (int i = 0; i < fcConfigurationElements.length; i++) {
      // Read the factory component descriptor from the configuration element.
      FactoryComponentDescriptor fcDescriptor = factoryComponentReader.readFactoryComponent(fcConfigurationElements[i]);
      resultingFcList.add(getFactoryComponent(fcDescriptor));
    }
    return resultingFcList;
  }

  /**
   * Read a factory component descriptor from specified configuration element got from plug-ins located in platform.
   * @param configurationElement_p a configuration element that conforms to 'factoryComponent' extension-point.
   * @return <code>null</code> if specified configuration element is <code>null</code>.
   */
  public IFactoryComponentDescriptor getFactoryComponentDescriptorFromPlatform(IConfigurationElement configurationElement_p) {
    // Instantiate an eclipse platform factory component reader.
    DefaultFactoryComponentReader factoryComponentReader = new DefaultFactoryComponentReader();
    return factoryComponentReader.readFactoryComponent(configurationElement_p);
  }

  /**
   * Get the plug-in id for the given factory component located in the running Eclipse platform only.
   * @param factoryComponentId_p
   * @return the plug-in id or null if not found.
   */
  public String getPluginIdForFactoryComponent(String factoryComponentId_p) {
    String result = null;
    // Get the configuration element for 'factoryComponent' extension-point matching specified factory component id.
    IConfigurationElement fcConfigurationElement = ExtensionPointHelper.getConfigurationElement(
      getPluginID(), 
      IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_POINT_ID,
      factoryComponentId_p
    );
    if (fcConfigurationElement != null) {
      // Found it, get the plug-in id from the current configuration element.
      result = fcConfigurationElement.getContributor().getName();
    }
    return result;
  }
  
  /**
   * Get the hosting bundle for given model element.<br>
   * It means the bundle where the factory component container of given model element is defined.
   * @param modelElement_p
   * @return an {@link Bundle} instance if given model element is contained by a factory component located in the runtime; null otherwise.
   */
  public Bundle getBundleForFactoryComponent(NamedModelElementWithId modelElement_p) {
    Bundle bundle = null;
    // Get the fc container for given model element
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(modelElement_p);
    if (fcContainer != null) {
      // Get the hosting bundle.
      String pluginID = getPluginIdForFactoryComponent(fcContainer.getId());
      if (pluginID != null) {
        bundle = Platform.getBundle(pluginID);
      }
    }
    return bundle;
  }    

  /**
   * Get a factory component for given factory component id.
   * @param factoryComponentId_p
   * @return an {@link FactoryComponent} instance or null if not found.
   */
  public FactoryComponent getFactoryComponent(String factoryComponentId_p) {
    return ModelActivator.getDefault().getFactoryComponentLoadingHelper().getFactoryComponent(factoryComponentId_p);
  }

  /**
   * Get a factory component for given factory component descriptor.
   * @param fcDescriptor_p
   * @return an {@link FactoryComponent} instance or null if not found.
   */
  public FactoryComponent getFactoryComponent(IFactoryComponentDescriptor fcDescriptor_p) {
    return ModelActivator.getDefault().getFactoryComponentLoadingHelper().getFactoryComponent(fcDescriptor_p);
  }

  /**
   * Get the factory component registry.
   * @return a not null instance of an {@link FactoryComponentRegistry}.
   */
  public FactoryComponentRegistry getFactoryComponentRegistry() {
    // Lazy loading creation pattern.
    if (null == _fcRegistry) {
      _fcRegistry = FactoryComponentRegistry.getInstance();
    }
    return _fcRegistry;
  }

  /**
   * Get the sorting priority for given model element.
   * @param modelElement_p
   * @return an integer or -1 if no priority is defined for given element.
   */
  public int getSortingPriority(NamedModelElementWithId modelElement_p) {
    return FactoryComponentSortingPriorityHelper.getInstance().getSortingPriority(modelElement_p);
  }
  
}