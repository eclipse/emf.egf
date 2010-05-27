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
package org.eclipse.egf.core.platform;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.platform.internal.pde.IManagerConstants;
import org.eclipse.egf.core.platform.internal.pde.PlatformManager;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.egf.core.platform.pde.PlatformURIConverter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.osgi.framework.BundleContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFPlatformPlugin extends EGFAbstractPlugin {

  private static EGFPlatformPlugin __plugin;

  public static PlatformURIConverter getPlatformURIConverter() {
    return PlatformURIConverter.getInstance();
  }

  public static IPlatformManager getPlatformManager() {
    return PlatformManager.getInstance();
  }

  /**
   * EGF Registered Managers.
   * 
   */
  private static Map<String, IConfigurationElement> __managers;

  /**
   * Get Platforms.
   * 
   * @return an empty map if none could be found.
   */
  public Map<String, IConfigurationElement> getPlatform() {
    // Lazy loading.
    if (__managers == null) {
      // Build managers map
      Map<String, IConfigurationElement> managers = new HashMap<String, IConfigurationElement>();
      Map<String, Class<? extends IPlatformExtensionPoint>> interfaces = new HashMap<String, Class<? extends IPlatformExtensionPoint>>();
      // Get EGF Platform extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(getDefault().getBundle().getSymbolicName(), IManagerConstants.MANAGER_EXTENSION_POINT_ID)) {
        // Extension retrieval
        String extension = ExtensionPointHelper.getAttributeValue(configurationElement, IManagerConstants.MANAGER_ATT_EXTENSION);
        // Ignore
        if (extension == null || extension.trim().length() == 0) {
          continue;
        }
        extension = extension.trim();
        // Check
        if (managers.containsKey(extension)) {
          getDefault().logError(NLS.bind("Duplicate Extension {0}", extension)); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          continue;
        }
        // Check factory
        Object factory = null;
        try {
          factory = ExtensionPointHelper.createInstance(configurationElement, IManagerConstants.MANAGER_ATT_CLASS);
        } catch (CoreException ce) {
          getDefault().logError(ce);
        }
        if (factory == null) {
          continue;
        }
        if (factory instanceof IPlatformExtensionPointFactory<?> == false) {
          getDefault().logError(NLS.bind("Wrong Class {0}", factory.getClass().getName())); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Class should be an implementation of ''{0}''.", IPlatformExtensionPointFactory.class.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("extension ''{0}''", extension), 1); //$NON-NLS-1$
          continue;
        }
        // Fetch Returned Types from Class
        Class<? extends IPlatformExtensionPoint> clazz = fetchReturnedTypeFromFactory(factory.getClass());
        if (clazz == null) {
          getDefault().logError(NLS.bind("Wrong Class {0}", factory.getClass().getName())); //$NON-NLS-1$          
          getDefault().logInfo("Unable to find ''createExtensionPoint(IPlatformBundle platformBundle, IPluginElement pluginElement)'' method."); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          continue;
        }
        if (interfaces.get(factory.getClass().getName()) != null) {
          getDefault().logError(NLS.bind("Duplicate Factory {0}", factory.getClass().getName())); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          continue;
        }
        // Register
        managers.put(extension, configurationElement);
        interfaces.put(factory.getClass().getName(), clazz);
      }
      // Assign static map
      __managers = managers;
    }
    return __managers;
  }

  /**
   * The constructor
   */
  public EGFPlatformPlugin() {
    super();
  }

  @SuppressWarnings("unchecked")
  public static Class<? extends IPlatformExtensionPoint> fetchReturnedTypeFromFactory(Class<?> factory) {
    Class<? extends IPlatformExtensionPoint> clazz = null;
    Method method = null;
    try {
      method = factory.getDeclaredMethod("createExtensionPoint", IPlatformBundle.class, IPluginElement.class); //$NON-NLS-1$
    } catch (NoSuchMethodException nsme) {
      // Just Ignore
    }
    if (method != null) {
      Type type = null;
      try {
        type = method.getGenericReturnType();
      } catch (Throwable t) {
        // Just ignore
      }
      if (type != null) {
        try {
          clazz = (Class<? extends IPlatformExtensionPoint>) type;
        } catch (ClassCastException cce) {
          // Just Ignore
        }
      }
    }
    return clazz;
  }

  /**
   * 
   * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
   * BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
    // The platform URI Converter should be initialized after the platform manager
    PlatformManager.getInstance();
    PlatformURIConverter.getInstance();
  }

  /**
   * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
   * BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    PlatformManager.getInstance().dispose();
    PlatformURIConverter.getInstance().dispose();
    __plugin = null;
    __managers = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static EGFPlatformPlugin getDefault() {
    return __plugin;
  }

}
