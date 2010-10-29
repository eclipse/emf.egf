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
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.platform.loader.BundleClassLoaderFactory;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

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

    public static boolean isUniqueNameWithinBundle(IPlatformFcore fcore, PatternLibrary library, Pattern pattern) {
        if (fcore == null || pattern == null || library == null || pattern.getName() == null || pattern.getName().trim().length() == 0) {
            return true;
        }
        ResourceSet resourceSet = null;
        if (library.eResource() != null) {
            resourceSet = library.eResource().getResourceSet();
        }
        if (resourceSet == null) {
            if (fcore.isRuntime()) {
                resourceSet = new RuntimePlatformResourceSet();
            } else {
                resourceSet = new TargetPlatformResourceSet();
            }
        }
        IPlatformFcore[] fcores = null;
        if (fcore.isRuntime()) {
            fcores = EGFCorePlugin.getRuntimePlatformFcores(fcore.getBundle());
        } else {
            fcores = EGFCorePlugin.getTargetPlatformFcores(fcore.getPluginModelBase());
        }
        for (IPlatformFcore innerFcore : fcores) {
            Resource resource = resourceSet.getResource(innerFcore.getURI(), true);
            for (EObject eObject : resource.getContents()) {
                if (isUniqueNameWithinLibrary(eObject, library, pattern) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isUniqueNameWithinLibrary(EObject root, PatternLibrary library, Pattern pattern) {
        for (EObject innerEObject : EMFHelper.getAllProperContents(PatternPackage.eINSTANCE.getPattern(), root)) {
            Pattern innerPattern = (Pattern) innerEObject;
            // Library name should be identical
            if (innerPattern.getContainer().getName() != null && innerPattern.getContainer().getName().equals(library.getName())) {
                if (innerPattern != pattern && pattern.getName().equals(innerPattern.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    protected static IBundleClassLoader getLoader(EObject eObject, Map<Object, Object> context) {
        if (eObject == null) {
            return null;
        }
        Resource resource = eObject.eResource();
        IPlatformFcore fcore = null;
        IBundleClassLoader loader = null;
        // Locate an fcore
        if (resource != null && resource instanceof IPlatformFcoreProvider) {
            fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
        }
        // Retrieve Bundle Class Loader Map if any
        Map<Resource, IBundleClassLoader> loaders = (Map<Resource, IBundleClassLoader>) context.get(IBundleClassLoader.BUNDLE_CLASS_LOADER_MAP);
        // Use loaders
        if (loaders != null && fcore != null) {
            loader = loaders.get(resource);
            if (loader == null) {
                try {
                    loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase(), eObject.getClass().getClassLoader());
                } catch (CoreException ce) {
                    EGFModelPlugin.getPlugin().logError(ce);
                    return null;
                }
                loaders.put(resource, loader);
            }
        } else {
            // Locate the default class loader
            loader = (IBundleClassLoader) context.get(IBundleClassLoader.DEFAULT_BUNDLE_CLASS_LOADER);
            if (loader == null && fcore != null) {
                // Build a default class loader
                try {
                    loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase(), eObject.getClass().getClassLoader());
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
        // Load Class
        Class<?> clazz = null;
        // Runtime or memory
        if (fcore == null || fcore.isRuntime()) {
            try {
                // Runtime
                if (fcore == null) {
                    clazz = Class.forName(value.trim());
                } else {
                    clazz = fcore.getBundle().loadClass(value.trim());
                }
            } catch (Throwable t) {
                // Nothing to do
            }
        }
        // Target or Workspace
        else {
            try {
                if (fcore.getBundle() != null) {
                    clazz = fcore.getBundle().loadClass(value.trim());
                } else {
                    IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase());
                    clazz = loader.loadClass(value.trim());
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
        // Load Class
        Class<?> clazz = null;
        // Runtime or memory        
        if (fcore == null || fcore.isRuntime()) {
            try {
                // Runtime
                if (fcore == null) {
                    clazz = Class.forName(value.trim());
                } else {
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
        }
        // Target or Workspace
        else {
            try {
                if (fcore.getBundle() != null) {
                    clazz = fcore.getBundle().loadClass(value.trim());
                } else {
                    IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase());
                    clazz = loader.loadClass(value.trim());
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
