/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.log.IEGFLogger;
import org.eclipse.egf.common.log.IEGFLoggerFactory;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleContext;

/**
 * Common plug-in activator.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCommonPlugin extends EGFAbstractPlugin {

  /**
   * EGF Registered loggers.
   */
  private static List<IEGFLogger> __egfLoggers;

  /**
   * Shared instance.
   */
  protected static EGFCommonPlugin __plugin;

  /**
   * Get shared instance.
   * 
   * @return
   */
  public static EGFCommonPlugin getDefault() {
    return __plugin;
  }

  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    __plugin = null;
    __egfLoggers = null;
    super.stop(context);
  }

  /**
   * Get egf loggers implementations.
   * 
   * @return an empty list if none could be found.
   */
  public static List<IEGFLogger> getEGFLoggers() {
    // Lazy loading. Search for the implementation.
    if (__egfLoggers == null) {
      // Build loggers list
      List<IEGFLogger> egfLoggers = new ArrayList<IEGFLogger>();
      // Get EGF logger extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(EGFCommonPlugin.getDefault().getPluginID(), EXTENSION_POINT_SHORT_ID_LOGGER)) {
        Object object = null;
        try {
          object = ExtensionPointHelper.createInstance(configurationElement);
        } catch (CoreException ce) {
          getDefault().logError(ce);
        }
        if (object == null) {
          continue;
        }
        // Make sure this is the correct resulting type.
        if (object instanceof IEGFLoggerFactory == false) {
          getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("This Class should be a sub-type of ''{0}''.", IEGFLoggerFactory.class.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          continue;
        }
        IEGFLogger logger = ((IEGFLoggerFactory) object).getLogger();
        if (logger != null) {
          egfLoggers.add(logger);
        }
      }
      // Set builded loggers list
      __egfLoggers = egfLoggers;
    }
    return __egfLoggers;
  }

}