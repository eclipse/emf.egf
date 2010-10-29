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
package org.eclipse.egf.core.platform.internal.pde;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class AbstractPlatformManager implements IPlatformManager {

    // Use a lock object, this will prevent us against
    // a lock against the AbstractPlatformManager instance
    protected Object _lockPlatformManager = new Object();

    // A list of listeners interested in changes to extension points
    private Set<IPlatformExtensionPointListener> _listeners;

    public static <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Map<Class<?>, Set<Object>> registry, Class<T> clazz) {
        List<Object> extensionPoints = new ArrayList<Object>();
        if (clazz != null) {
            if (registry.get(clazz) != null) {
                extensionPoints.addAll(registry.get(clazz));
            }
        }
        return CollectionHelper.toArray(extensionPoints, clazz);
    }

    protected static void addPlatformBundle(IPlatformBundle bundle, Map<String, IPlatformBundle> registry, Map<Class<?>, Set<Object>> extensions, PlatformExtensionPointDelta delta) {
        // Add platform bundle to the registry
        registry.put(bundle.getBundleId(), bundle);
        // Process extension point
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
            for (IPlatformExtensionPoint extensionPoint : bundle.getPlatformExtensionPoints(clazz)) {
                addExtensionPoint(extensionPoint, clazz, extensions, delta);
            }
        }
    }

    protected static void addExtensionPoint(IPlatformExtensionPoint extensionPoint, Class<? extends IPlatformExtensionPoint> clazz, Map<Class<?>, Set<Object>> extensions, PlatformExtensionPointDelta delta) {
        // add extension point in Extension registry
        Set<Object> extensionPoints = extensions.get(clazz);
        if (extensionPoints == null) {
            extensionPoints = new HashSet<Object>();
            extensions.put(clazz, extensionPoints);
        }
        if (extensionPoints.add(extensionPoint) == false) {
            EGFPlatformPlugin.getDefault().logError(NLS.bind("AbstractPlatformManager.addExtensionPoint(..) _ ''{0}'' unable to add Extension Point.", //$NON-NLS-1$
                    extensionPoint.getId()));
        } else {
            // Update delta
            if (delta != null) {
                delta.storeAddedPlatformExtensionPoint(clazz, extensionPoint);
            }
        }
    }

    protected static void removePlatformBundle(IPlatformBundle bundle, Map<String, IPlatformBundle> registry, Map<Class<?>, Set<Object>> extensions, PlatformExtensionPointDelta delta) {
        // Remove platform bundle from our main registry
        if (bundle.equals(registry.remove(bundle.getBundleId())) == false) {
            EGFPlatformPlugin.getDefault().logError(NLS.bind("AbstractPlatformManager.removePlatformBundle(..) _ ''{0}'' unknown IPlatformBundle.", //$NON-NLS-1$
                    bundle.getBundleId()));
        }
        // Analyse Removed Extension Points
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
            for (IPlatformExtensionPoint extensionPoint : bundle.getPlatformExtensionPoints(clazz)) {
                removeExtensionPoint(extensionPoint, clazz, extensions, delta);
            }
        }
    }

    protected static void removeExtensionPoint(IPlatformExtensionPoint extensionPoint, Class<? extends IPlatformExtensionPoint> clazz, Map<Class<?>, Set<Object>> extensions, PlatformExtensionPointDelta delta) {
        // remove extension point from Extension registry
        if (extensions.get(clazz).remove(extensionPoint)) {
            // Clean Extension registry if necessary
            if (extensions.get(clazz).isEmpty()) {
                extensions.remove(clazz);
            }
            // Update delta
            if (delta != null) {
                delta.storeRemovedPlatformExtensionPoint(clazz, extensionPoint);
            }
        }
    }

    public AbstractPlatformManager() {
        initialize();
    }

    /**
     * Add a listener to the platform manager
     * 
     * @param listener
     * the listener to be added
     */
    public void addPlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            if (_listeners == null) {
                _listeners = new HashSet<IPlatformExtensionPointListener>();
            }
            if (_listeners.contains(listener) == false) {
                _listeners.add(listener);
            }
        }
    }

    /**
     * Remove a listener from the platform manager
     * 
     * @param listener
     * the listener to be removed
     */
    public void removePlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            if (_listeners == null) {
                return;
            }
            _listeners.remove(listener);
        }
    }

    /**
     * Notify all interested listeners in changes made to the models table
     * 
     * @param delta
     *            the delta of changes
     */
    protected void firePlatformExtensionPoint(IPlatformExtensionPointDelta delta) {
        if (_listeners != null) {
            for (IPlatformExtensionPointListener listener : _listeners) {
                listener.platformExtensionPointChanged(delta);
            }
        }
    }

    public void dispose() {
        if (_listeners != null) {
            _listeners.clear();
        }
    }

    protected abstract void initialize();

    protected abstract void initializeRegistry();

}
