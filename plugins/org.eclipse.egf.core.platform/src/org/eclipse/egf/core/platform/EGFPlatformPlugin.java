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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.core.platform.internal.pde.IManagerConstants;
import org.eclipse.egf.core.platform.internal.pde.PlatformManager;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.egf.core.platform.uri.PlatformURIConverter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.osgi.framework.BundleContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFPlatformPlugin extends EGFAbstractPlugin {

    private static EGFPlatformPlugin __plugin;

    private static PlatformManager __platformManager;

    private static PlatformURIConverter __platformURIConverter;

    private static Map<String, IConfigurationElement> __managerExtensionPoints;

    private static Map<String, Class<? extends IPlatformExtensionPoint>> __platformExtensionPoints;

    private static Collection<Class<? extends IPlatformExtensionPoint>> __platformExtensionPointClasses;

    private static Map<Class<? extends IPlatformExtensionPoint>, IPlatformExtensionPointFactory<? extends IPlatformExtensionPoint>> __platformExtensionPointFactories;

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EGFPlatformPlugin getDefault() {
        return __plugin;
    }

    public static IPlatformManager getPlatformManager() {
        return __platformManager;
    }

    /**
     * Returns a snapshot of known IPlatformFcore
     * 
     * @return an array of IPlatformFcore
     */
    public static PlatformURIConverter getPlatformURIConverter() {
        return __platformURIConverter;
    }

    /**
     * Get __managerExtensionPoints.
     * 
     * @return an empty map if none could be found.
     */
    public Map<String, IConfigurationElement> getManagerExtensionPoints() {
        // Lazy loading.
        if (__managerExtensionPoints == null) {
            // Build managers map
            Map<String, IConfigurationElement> platformManagers = new HashMap<String, IConfigurationElement>();
            Map<String, Class<? extends IPlatformExtensionPoint>> interfaces = new HashMap<String, Class<? extends IPlatformExtensionPoint>>();
            IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(getDefault().getBundle().getSymbolicName(), IManagerConstants.MANAGER_EXTENSION_POINT_ID);
            // Get EGF Platform extension points.
            for (IConfigurationElement element : elements) {
                // Extension retrieval
                String extension = element.getAttribute(IManagerConstants.MANAGER_ATT_EXTENSION);
                // Ignore
                if (extension == null || extension.trim().length() == 0) {
                    continue;
                }
                extension = extension.trim();
                // Check
                if (platformManagers.containsKey(extension)) {
                    getDefault().logError(NLS.bind("Duplicate Extension {0}", extension)); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Bundle ''{0}''", element.getContributor().getName()), 1); //$NON-NLS-1$
                    continue;
                }
                // Time to init Factory
                long startTimeFactory = System.currentTimeMillis();
                // Check factory
                Object factory = null;
                try {
                    factory = element.createExecutableExtension(IManagerConstants.MANAGER_ATT_CLASS);
                } catch (Throwable t) {
                    getDefault().logError(t);
                }
                if (EGFPlatformPlugin.getDefault().isDebugging()) {
                    long endTime = System.currentTimeMillis();
                    long time = (endTime - startTimeFactory);
                    EGFPlatformPlugin.getDefault().logInfo(NLS.bind("EGFPlatformPlugin _ create factory ''{0}'' in ''{1}'' ms", //$NON-NLS-1$ 
                            element.getAttribute(IManagerConstants.MANAGER_ATT_EXTENSION), time));
                }
                if (factory == null) {
                    continue;
                }
                if (factory instanceof IPlatformExtensionPointFactory<?> == false) {
                    getDefault().logError(NLS.bind("Wrong Class {0}", factory.getClass().getName())); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Class should be an implementation of ''{0}''.", IPlatformExtensionPointFactory.class.getName()), 1); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Bundle ''{0}''", element.getContributor().getName()), 1); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("extension ''{0}''", extension), 1); //$NON-NLS-1$
                    continue;
                }
                // Fetch Returned Types from Class
                Class<? extends IPlatformExtensionPoint> clazz = fetchReturnedTypeFromFactory(factory.getClass());
                if (clazz == null) {
                    getDefault().logError(NLS.bind("Wrong Class {0}", factory.getClass().getName())); //$NON-NLS-1$          
                    getDefault().logInfo("Unable to find ''createExtensionPoint(IPlatformBundle platformBundle, IPluginElement pluginElement)'' method."); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Bundle ''{0}''", element.getContributor().getName()), 1); //$NON-NLS-1$
                    continue;
                }
                if (interfaces.get(factory.getClass().getName()) != null) {
                    getDefault().logError(NLS.bind("Duplicate Factory {0}", factory.getClass().getName())); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                    getDefault().logInfo(NLS.bind("Bundle ''{0}''", element.getContributor().getName()), 1); //$NON-NLS-1$
                    continue;
                }
                // Register
                platformManagers.put(extension, element);
                interfaces.put(factory.getClass().getName(), clazz);
            }
            // Assign static map
            __managerExtensionPoints = platformManagers;
        }
        return __managerExtensionPoints;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Class<? extends IPlatformExtensionPoint>> getPlatformExtensionPoints() {
        if (__platformExtensionPoints == null) {
            Map<String, IConfigurationElement> platformManagers = getDefault().getManagerExtensionPoints();
            Map<String, Class<? extends IPlatformExtensionPoint>> extensionPoints = new HashMap<String, Class<? extends IPlatformExtensionPoint>>();
            for (Map.Entry<String, IConfigurationElement> entry : platformManagers.entrySet()) {
                // Factory
                IPlatformExtensionPointFactory<?> clazz = null;
                try {
                    clazz = (IPlatformExtensionPointFactory<?>) entry.getValue().createExecutableExtension(IManagerConstants.MANAGER_ATT_CLASS);
                } catch (CoreException ce) {
                    EGFPlatformPlugin.getDefault().logError(ce);
                }
                if (clazz == null) {
                    continue;
                }
                // Fetch Returned Types from Factory
                Class<?> key = EGFPlatformPlugin.fetchReturnedTypeFromFactory(((IPlatformExtensionPointFactory<?>) clazz).getClass());
                // Store it
                extensionPoints.put(entry.getKey(), (Class<? extends IPlatformExtensionPoint>) key);
            }
            __platformExtensionPoints = extensionPoints;
        }
        return __platformExtensionPoints;
    }

    public static Collection<Class<? extends IPlatformExtensionPoint>> getPlatformExtensionPointClasses() {
        if (__platformExtensionPointClasses == null) {
            __platformExtensionPointClasses = getPlatformExtensionPoints().values();
        }
        return __platformExtensionPointClasses;
    }

    @SuppressWarnings("unchecked")
    public static Map<Class<? extends IPlatformExtensionPoint>, IPlatformExtensionPointFactory<? extends IPlatformExtensionPoint>> getPlatformExtensionPointFactories() {
        if (__platformExtensionPointFactories == null) {
            Map<String, IConfigurationElement> platformManagers = EGFPlatformPlugin.getDefault().getManagerExtensionPoints();
            Map<Class<? extends IPlatformExtensionPoint>, IPlatformExtensionPointFactory<? extends IPlatformExtensionPoint>> extensionPointFactories = new HashMap<Class<? extends IPlatformExtensionPoint>, IPlatformExtensionPointFactory<? extends IPlatformExtensionPoint>>();
            for (Map.Entry<String, IConfigurationElement> entry : platformManagers.entrySet()) {
                // Factory
                IPlatformExtensionPointFactory<?> clazz = null;
                try {
                    clazz = (IPlatformExtensionPointFactory<?>) entry.getValue().createExecutableExtension(IManagerConstants.MANAGER_ATT_CLASS);
                } catch (CoreException ce) {
                    EGFPlatformPlugin.getDefault().logError(ce);
                }
                if (clazz == null) {
                    continue;
                }
                // Fetch Returned Types from Factory
                Class<?> key = EGFPlatformPlugin.fetchReturnedTypeFromFactory(((IPlatformExtensionPointFactory<?>) clazz).getClass());
                // Store it
                extensionPointFactories.put((Class<? extends IPlatformExtensionPoint>) key, (IPlatformExtensionPointFactory<?>) clazz);
            }
            __platformExtensionPointFactories = extensionPointFactories;
        }
        return __platformExtensionPointFactories;
    }

    /**
     * The constructor
     */
    public EGFPlatformPlugin() {
        super();
    }

    @SuppressWarnings("unchecked")
    public static Class<? extends IPlatformExtensionPoint> fetchReturnedTypeFromFactory(Class<?> factory) {
        Method method = null;
        try {
            method = factory.getDeclaredMethod("createExtensionPoint", IPlatformBundle.class, IPluginElement.class); //$NON-NLS-1$
        } catch (NoSuchMethodException nsme) {
            // Just Ignore
        }
        if (method == null) {
            return null;
        }
        Type type = null;
        try {
            type = method.getGenericReturnType();
        } catch (Throwable t) {
            // Just ignore
        }
        if (type == null) {
            return null;
        }
        try {
            return (Class<? extends IPlatformExtensionPoint>) type;
        } catch (ClassCastException cce) {
            // Just Ignore
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
        __plugin = this;
        __platformURIConverter = new PlatformURIConverter();
        __platformManager = new PlatformManager();
    }

    /**
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
     * BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        __platformManager.dispose();
        __platformURIConverter.dispose();
        __platformManager = null;
        __platformURIConverter = null;
        __managerExtensionPoints = null;
        __platformExtensionPoints = null;
        __platformExtensionPointClasses = null;
        __platformExtensionPointFactories = null;
        __plugin = null;
        super.stop(context);
    }

}
