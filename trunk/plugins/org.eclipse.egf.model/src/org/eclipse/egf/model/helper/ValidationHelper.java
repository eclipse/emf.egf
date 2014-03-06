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
package org.eclipse.egf.model.helper;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.platform.loader.BundleClassLoaderFactory;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 * 
 * TODO: runtime support should be added in that case use the bundle rather than a bundleclassloader
 * 
 */
public class ValidationHelper {

    private ValidationHelper() {
        // Prevent Instantiation
    }

    @SuppressWarnings("unchecked")
    protected static IClassLoader getLoader(IPluginModelBase model, EObject eObject, Map<Object, Object> context) {
        if (eObject == null) {
            return null;
        }
        Resource resource = eObject.eResource();
        IPlatformFcore fcore = null;
        IClassLoader loader = null;
        // Locate an fcore
        if (resource != null && resource instanceof IPlatformFcoreProvider) {
            fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
        }
        // Retrieve Class Loader Map if any
        Map<IPluginModelBase, IClassLoader> loaders = (Map<IPluginModelBase, IClassLoader>) context.get(IBundleClassLoader.BUNDLE_CLASS_LOADER_MAP);
        // Use loaders
        if (loaders != null && fcore != null) {
            loader = loaders.get(fcore.getPluginModelBase());
            if (loader == null) {
                try {
                    loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase(), eObject.getClass().getClassLoader());
                    if (loader != null) {
                        loaders.put(fcore.getPluginModelBase(), loader);
                    }
                } catch (CoreException ce) {
                    EGFModelPlugin.getPlugin().logError(ce);
                    return null;
                }
            }
        } else {
            // Locate the default class loader
            loader = (IBundleClassLoader) context.get(IBundleClassLoader.DEFAULT_BUNDLE_CLASS_LOADER);
            if (loader == null && fcore != null) {
                // Build a default class loader
                try {
                    loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase(), eObject.getClass().getClassLoader());
                    if (loaders != null && loader != null) {
                        loaders.put(fcore.getPluginModelBase(), loader);
                    }
                } catch (CoreException ce) {
                    EGFModelPlugin.getPlugin().logError(ce);
                    return null;
                }
            } else {
                // TODO this should be enhanced with memory support, eg: IBundleClassLoader.BUNDLE_CLASS_LOADER_MAP
                if (fcore == null) {
                    throw new UnsupportedOperationException();
                }
            }
        }
        if (loader == null) {
            try {
                loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase(), eObject.getClass().getClassLoader());
                if (loaders != null && loader != null) {
                    loaders.put(fcore.getPluginModelBase(), loader);
                }
            } catch (CoreException ce) {
                EGFModelPlugin.getPlugin().logError(ce);
                return null;
            }
        }
        return loader;
    }

    public static boolean isLoadableClass(EObject eObject, String value, Map<Object, Object> context) {

        if (context != null && context.get(IEGFModelConstants.VALIDATE_TYPES) == Boolean.FALSE) {
            return true;
        }
        if (eObject == null || eObject.eResource() == null || eObject.eResource() instanceof IPlatformFcoreProvider == false || value == null || value.trim().length() == 0) {
            return true;
        }

        // Retrieve fcore
        IPlatformFcore fcore = ((IPlatformFcoreProvider) eObject.eResource()).getIPlatformFcore();
        // IClassLoader if any
        IClassLoader loader = null;
        if (fcore != null) {
            loader = getLoader(fcore.getPluginModelBase(), eObject, context);
        }
        // Load Class
        Class<?> clazz = null;
        // Runtime or memory
        if (fcore == null || fcore.isRuntime()) {
            try {
                // Runtime
                if (fcore == null) {
                    clazz = Class.forName(value.trim());
                } else {
                    if (loader != null) {
                        clazz = loader.loadClass(value.trim());
                    }
                    if (clazz == null && fcore.getBundle() != null) {
                        clazz = fcore.getBundle().loadClass(value.trim());
                    }
                }
            } catch (Throwable t) {
                // Nothing to do
            }
        }
        // Target or Workspace
        else {
            try {
                if (loader != null) {
                    clazz = loader.loadClass(value.trim());
                }
                if (clazz == null && fcore.getBundle() != null) {
                    clazz = fcore.getBundle().loadClass(value.trim());
                }
            } catch (Throwable t) {
                // Nothing to do
            }
        }
        if (clazz == null) {
            return false;
        }
        return true;
    }

    public static boolean isValidClass(EObject eObject, Class<?> type, String value, Map<Object, Object> context) {
        if (context != null && context.get(IEGFModelConstants.VALIDATE_TYPES) == Boolean.FALSE) {
            return true;
        }
        if (eObject == null || eObject.eResource() == null || eObject.eResource() instanceof IPlatformFcoreProvider == false || value == null || value.trim().length() == 0) {
            return true;
        }
        // Retrieve fcore
        IPlatformFcore fcore = ((IPlatformFcoreProvider) eObject.eResource()).getIPlatformFcore();
        // IClassLoader if any
        IClassLoader loader = null;
        if (fcore != null) {
            loader = getLoader(fcore.getPluginModelBase(), eObject, context);
        }
        // Load Class
        Class<?> clazz = null;
        // Runtime or memory        
        if (fcore == null || fcore.isRuntime()) {
            try {
                // Runtime
                if (fcore == null) {
                    clazz = Class.forName(value.trim());
                } else {
                    if (loader != null) {
                        clazz = loader.loadClass(value.trim());
                    }
                    if (clazz == null && fcore.getBundle() != null) {
                        clazz = fcore.getBundle().loadClass(value.trim());
                    }
                }
                if (clazz == null) {
                    return false;
                }
                // Valid Value
                if (ClassHelper.isSubClass(clazz, type) == false) {
                    return false;
                }
            } catch (Throwable t) {
                // Nothing to do
            }
        }
        // Target or Workspace
        else {
            try {
                if (loader != null) {
                    clazz = loader.loadClass(value.trim());
                }
                if (clazz == null && fcore.getBundle() != null) {
                    clazz = fcore.getBundle().loadClass(value.trim());
                }
                if (clazz == null) {
                    return false;
                }
                // Valid Value
                if (ClassHelper.isSubClass(clazz, type) == false) {
                    return false;
                }
            } catch (Throwable t) {
                // Nothing to do
            }
            if (clazz == null) {
                return false;
            }
        }
        if (clazz == null) {
            return false;
        }
        return true;
    }

}
