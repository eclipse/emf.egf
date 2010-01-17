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
        Object object = null;
        try {
          object = ExtensionPointHelper.createInstance(configurationElement, IManagerConstants.MANAGER_ATT_CLASS);
        } catch (CoreException ce) {
          getDefault().logError(ce);
        }
        if (object == null) {
          continue;
        }
        if (object instanceof IPlatformExtensionPointFactory<?> == false) {
          getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Class should be an implementation of ''{0}''.", IPlatformExtensionPointFactory.class.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("extension ''{0}''", extension), 1); //$NON-NLS-1$
          continue;
        }
        // Fetch Returned Types from Class
        Class<?> key = fetchReturnedTypeFromFactory(object.getClass());
        if (key == null) {
          getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$          
          getDefault().logInfo("Unable to find ''createExtensionPoint(IPlatformBundle platformBundle, IPluginElement pluginElement)'' method."); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          continue;
        }
        if (__interfaces.get(key) != null) {
          getDefault().logError(NLS.bind("Duplicate Interface {0}", key.getClass().getName())); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          continue;
        }
        // Register
        __managers.put(extension, configurationElement);
        __interfaces.put(object.getClass().getName(), key);
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
