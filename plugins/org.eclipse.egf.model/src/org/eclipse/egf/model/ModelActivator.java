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
package org.eclipse.egf.model;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.activator.AbstractActivator;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper;
import org.osgi.framework.BundleContext;


/**
 * @author brocard
 */
public class ModelActivator extends AbstractActivator {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(ModelActivator.class.getPackage().getName());
  /**
   * Definition of the factory component loading helper extension-point id.
   */
  private static final String FACTORY_COMPONENT_LOADING_HELPER_EXTENSION_POINT_ID = "factoryComponentLoadingHelper"; //$NON-NLS-1$
  /**
   * Shared instance.
   */
  private static ModelActivator __plugin;
  /**
   * FactoryComponent loading helper.
   */
  private IFactoryComponentLoadingHelper _factoryComponentLoadingHelper;

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {
    super.stop(context_p);
    __plugin = null;
  }

  /**
   * @return the instance
   */
  public static ModelActivator getDefault() {
    return __plugin;
  }

  /**
   * Get factory component loading helper.
   * @return
   */
  public IFactoryComponentLoadingHelper getFactoryComponentLoadingHelper() {
    // Lazy creation strategy.
    if (null == _factoryComponentLoadingHelper) {
      _factoryComponentLoadingHelper = loadFactoryComponentLoadingHelper();
      if (null == _factoryComponentLoadingHelper) {
        StringBuilder loggerMessage = new StringBuilder("ModelActivator.getFactoryComponentLoadingHelper(..) _ "); //$NON-NLS-1$
        loggerMessage.append("Factory Component loading helper implementation not found!!!"); //$NON-NLS-1$
        __logger.fatal(loggerMessage.toString());
      }
    }
    return _factoryComponentLoadingHelper;
  }

  /**
   * Load from the extension registry an implementation.
   * @return an {@link IFactoryComponentLoadingHelper} instance or null if not found.
   */
  private IFactoryComponentLoadingHelper loadFactoryComponentLoadingHelper() {
    IFactoryComponentLoadingHelper result = null;
    // Load other readers provided by contribution.
    IConfigurationElement[] configurationElement = ExtensionPointHelper.getConfigurationElements(getPluginID(), FACTORY_COMPONENT_LOADING_HELPER_EXTENSION_POINT_ID);
    if (null != configurationElement && (configurationElement.length > 0)) {
      result = (IFactoryComponentLoadingHelper) ExtensionPointHelper.createInstance(configurationElement[0], ExtensionPointHelper.ATT_CLASS);
    }
    return result;
  }
}
