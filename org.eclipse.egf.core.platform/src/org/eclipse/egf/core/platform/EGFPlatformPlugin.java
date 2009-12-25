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
package org.eclipse.egf.core.platform;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.platform.internal.pde.IManagerConstants;
import org.eclipse.egf.core.platform.internal.pde.PlatformManager;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.osgi.framework.BundleContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFPlatformPlugin extends EGFAbstractPlugin {

  private static EGFPlatformPlugin _plugin;

  public static IPlatformManager getPlatformManager() {
    return PlatformManager.getInstance();
  }

  /**
   * EGF Registered Managers.
   * 
   */
  private static Map<String, IConfigurationElement> __managers;

  /**
   * EGF Registered Interface.
   * 
   */
  private static Map<String, Object> __interfaces;

  /**
   * Get Platforms.
   * 
   * @return an empty map if none could be found.
   */
  public Map<String, IConfigurationElement> getPlatform() {
    // Lazy loading.
    if (__managers == null) {
      __managers = new HashMap<String, IConfigurationElement>();
      __interfaces = new HashMap<String, Object>();
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
        if (__managers.containsKey(extension)) {
          getDefault().logError(NLS.bind("Duplicate Extension {0}", extension)); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          continue;
        }
        // Check factory
        Object factory = ExtensionPointHelper.createInstance(configurationElement, IManagerConstants.MANAGER_ATT_FACTORY);
        if (factory == null || factory instanceof IPlatformExtensionPointFactory<?> == false) {
          getDefault().logError(NLS.bind("Wrong Class {0}", factory.getClass().getName())); //$NON-NLS-1$
          getDefault().logInfo("Class should be an implementation of ''org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory''.", 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("extension ''{0}''", extension), 1); //$NON-NLS-1$
          continue;
        }
        // Fetch Returned Types from Factory
        Class<?> key = fetchReturnedTypeFromFactory(((IPlatformExtensionPointFactory<?>) factory).getClass());
        if (__interfaces.get(key) != null) {
          getDefault().logError(NLS.bind("Duplicate Interface {0}", key.getClass().getName())); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          continue;
        }
        // Register
        __managers.put(extension, configurationElement);
        __interfaces.put(factory.getClass().getName(), key);
      }
    }
    return __managers;
  }

  /**
   * The constructor
   */
  public EGFPlatformPlugin() {
    super();
  }

  public static Class<?> fetchReturnedTypeFromFactory(Class<?> factory) {
    Method method = null;
    try {
      method = factory.getDeclaredMethod("createExtensionPoint", IPlatformBundle.class, IPluginElement.class); //$NON-NLS-1$
    } catch (NoSuchMethodException nsme) {
      // Just Ignore
    }
    if (method != null) {
      Type type = method.getGenericReturnType();
      if (type instanceof Class<?>) {
        return (Class<?>) type;
      }
    }
    return null;
  }

  /**
   * 
   * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
   * BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    _plugin = this;
  }

  /**
   * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
   * BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    // Dispose PlatformManager
    PlatformManager.getInstance().dispose();
    // Final steps
    _plugin = null;
    __managers = null;
    __interfaces = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static EGFPlatformPlugin getDefault() {
    return _plugin;
  }

}
