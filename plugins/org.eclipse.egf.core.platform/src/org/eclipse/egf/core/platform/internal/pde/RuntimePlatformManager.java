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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointURI;
import org.eclipse.egf.core.platform.pde.IRuntimePlatformManager;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * PlatformManager manage factory components extension point based on PDE
 * registry. It tracks Target Platform FCs and workspace FCs. PDE doesn't manage
 * n versions of the same plugin. As a result only the latest found is managed
 * in the registry. As such each bundle has its symbolic name as its ID.
 * 
 * @since 1.0
 */
public final class RuntimePlatformManager extends AbstractPlatformManager implements IRuntimePlatformManager {

    private class RuntimeRegistryListener implements IRegistryEventListener {

        private Class<? extends IPlatformExtensionPoint> _clazz;

        public RuntimeRegistryListener(String point, Class<? extends IPlatformExtensionPoint> clazz) {
            Assert.isNotNull(point);
            Assert.isLegal(point.trim().length() != 0);
            Assert.isNotNull(clazz);
            _clazz = clazz;
            RegistryFactory.getRegistry().addListener(this, point.trim());
        }

        public void removed(IExtension[] extensions) {
            // Initialize a delta
            PlatformExtensionPointDelta delta = new PlatformExtensionPointDelta();
            // Lock PlatformManager
            synchronized (_lockPlatformManager) {
                if (extensions == null) {
                    return;
                }
                // Process
                for (IExtension extension : extensions) {
                    for (Iterator<IPlatformBundle> it = _bundleRegistry.values().iterator(); it.hasNext();) {
                        PlatformBundle bundle = (PlatformBundle) it.next();
                        // Analyse Removed Extension Points
                        for (IPlatformExtensionPoint extensionPoint : bundle.getPlatformExtensionPoints(_clazz)) {
                            if (originatesFrom(extension, extensionPoint.getUniqueIdentifier(), extensionPoint.getHandleId())) {
                                // Remove this ExtensionPoint from our existing model
                                if (bundle.removePlatformExtensionPoint(_clazz, extensionPoint) == false) {
                                    EGFPlatformPlugin.getDefault().logError(NLS.bind("RuntimePlatformManager$RuntimeRegistryListener.removed(..) _ ''{0}'' unable to remove Extension Point from IPlatformBundle.", //$NON-NLS-1$
                                            extensionPoint));
                                }
                                removeExtensionPoint(extensionPoint, _clazz, _runtimeRegistry, delta);
                            }
                        }
                        if (bundle.isEmpty()) {
                            it.remove();
                        }
                    }
                }
            }
            // Broadcast
            if (delta.isEmpty() == false) {
                // Debug
                if (EGFPlatformPlugin.getDefault().isDebugging()) {
                    trace(delta);
                }
                // Notify all interested listeners
                firePlatformExtensionPoint(delta);
            }
        }

        public void added(IExtension[] extensions) {
            // Initialize a delta
            PlatformExtensionPointDelta delta = new PlatformExtensionPointDelta();
            // Lock PlatformManager
            synchronized (_lockPlatformManager) {
                // Process                
                for (IExtension extension : extensions) {
                    for (IConfigurationElement element : extension.getConfigurationElements()) {
                        addElement(element, _clazz, delta, false);
                    }
                }
            }
            // Broadcast
            if (delta.isEmpty() == false) {
                // Debug
                if (EGFPlatformPlugin.getDefault().isDebugging()) {
                    trace(delta);
                }
                // Notify all interested listeners
                firePlatformExtensionPoint(delta);
            }
        }

        public void added(IExtensionPoint[] extensionPoints) {
            // Nothing to do
        }

        public void removed(IExtensionPoint[] extensionPoints) {
            // Nothing to do
        }

        public void dispose() {
            RegistryFactory.getRegistry().removeListener(this);
        }

        public boolean originatesFrom(IExtension extension, String uniqueIdentifier, int handleId) {
            String id = extension.getUniqueIdentifier();
            if (id != null) {
                return id.equals(uniqueIdentifier);
            }
            if (extension instanceof Handle == false) {
                return false;
            }
            return (handleId == ((Handle) extension).getId());
        }

    }

    // Runtime bundle registry
    private Map<String, IPlatformBundle> _bundleRegistry;

    // IPlatformExtensionPoint Runtime Registry
    private Map<Class<?>, Set<Object>> _runtimeRegistry;

    // A list of listeners interested in registry changes
    private Set<RuntimeRegistryListener> _registryListeners;

    public RuntimePlatformManager() {
        super();
        // Registry listeners for runtime management
        _registryListeners = new HashSet<RuntimeRegistryListener>();
        for (Map.Entry<String, Class<? extends IPlatformExtensionPoint>> entry : EGFPlatformPlugin.getPlatformExtensionPoints().entrySet()) {
            _registryListeners.add(new RuntimeRegistryListener(entry.getKey(), entry.getValue()));
        }
    }

    public int getPlatformBundleSize() {
        return _bundleRegistry.size();
    }

    public int getPlatformExtensionPointSize() {
        int size = 0;
        for (Map.Entry<Class<?>, Set<Object>> entry : _runtimeRegistry.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }

    @Override
    public void dispose() {
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            super.dispose();
            if (_registryListeners != null) {
                for (RuntimeRegistryListener listener : _registryListeners) {
                    listener.dispose();
                }
                _registryListeners.clear();
            }
            if (_bundleRegistry != null) {
                _bundleRegistry.clear();
            }
            if (_runtimeRegistry != null) {
                _runtimeRegistry.clear();
            }
        }
    }

    public IPlatformBundle getPlatformBundle(String id) {
        // Lock PlatformManager
        if (id == null) {
            return null;
        }
        synchronized (_lockPlatformManager) {
            return _bundleRegistry.get(id);
        }
    }

    public IPlatformBundle[] getPlatformBundles() {
        synchronized (_lockPlatformManager) {
            // Create a copy of known values
            return _bundleRegistry.values().toArray(new IPlatformBundle[_bundleRegistry.size()]);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            return getPlatformExtensionPoints(_runtimeRegistry, clazz);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(String id, Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            if (id != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz)) {
                IPlatformBundle platformBundle = _bundleRegistry.get(id);
                if (platformBundle != null) {
                    return platformBundle.getPlatformExtensionPoints(clazz);
                }
            }
            return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
        }
    }

    @Override
    protected void initialize() {
        // Initialize Runtime registries
        long startRuntimeTime = System.currentTimeMillis();
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            initializeRegistry();
        }
        // Debug
        long endRuntimeTime = System.currentTimeMillis();
        if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFPlatformPlugin.getDefault().logInfo(NLS.bind("RuntimePlatformManager _ found {0} Platform Bundle{1}, " //$NON-NLS-1$ 
                    + "''{2}'' Runtime Extension Point{3}," //$NON-NLS-1$ 
                    + "in " //$NON-NLS-1$
                    + "''{4}'' ms", //$NON-NLS-1$ 
                    new Object[] {
                            getPlatformBundleSize(), getPlatformBundleSize() < 2 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
                            getPlatformExtensionPointSize(), getPlatformExtensionPointSize() < 2 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$                                                                        
                            (endRuntimeTime - startRuntimeTime)
                    }));
            for (Class<?> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
                Set<Object> runtimeObjects = _runtimeRegistry.get(clazz);
                int extension = runtimeObjects != null ? runtimeObjects.size() : 0;
                if (extension == 0) {
                    continue;
                }
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("{0} Extension{1} ''{2}''", //$NON-NLS-1$ 
                        new Object[] {
                                extension, extension < 2 ? "" : "s", clazz.getName()}), 1); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }

    @Override
    protected void initializeRegistry() {
        if (_bundleRegistry != null) {
            return;
        }
        _bundleRegistry = new HashMap<String, IPlatformBundle>();
        _runtimeRegistry = new HashMap<Class<?>, Set<Object>>();
        for (Map.Entry<String, Class<? extends IPlatformExtensionPoint>> entry : EGFPlatformPlugin.getPlatformExtensionPoints().entrySet()) {
            IConfigurationElement[] elements = RegistryFactory.getRegistry().getConfigurationElementsFor(entry.getKey());
            if (elements == null) {
                continue;
            }
            for (IConfigurationElement element : elements) {
                addElement(element, entry.getValue(), null, true);
            }
        }
    }

    protected void addElement(IConfigurationElement element, Class<? extends IPlatformExtensionPoint> clazz, PlatformExtensionPointDelta delta, boolean init) {
        Bundle bundle = BundleHelper.getBundle(element.getDeclaringExtension().getContributor());
        // No bundle but valid
        if (bundle == null && element.isValid()) {
            IContributor contributor = element.getDeclaringExtension().getContributor();
            if (contributor instanceof RegistryContributor) {
                try {
                    long id = Long.parseLong(((RegistryContributor) contributor).getActualId());
                    BundleContext context = EGFCommonPlugin.getDefault().getBundle().getBundleContext();
                    if (context != null) {
                        bundle = context.getBundle(id);
                        if (bundle == null) {
                            bundle = Platform.getBundle(contributor.getName());
                            if (bundle != null) {
                                try {
                                    bundle.start(Bundle.START_TRANSIENT);
                                } catch (BundleException e) {
                                    EGFPlatformPlugin.getDefault().logError(e);
                                }
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    // try using the name of the contributor below
                }
            }
        }
        // Nothing to do        
        if (bundle == null || element.isValid() == false) {
            return;
        }
        // Create a PlatformBundle if necessary
        PlatformBundle platformBundle = (PlatformBundle) _bundleRegistry.get(bundle.getSymbolicName());
        if (platformBundle == null) {
            platformBundle = new PlatformBundle(bundle);
        }
        // Is there something to do ?
        IPlatformExtensionPoint extensionPoint = platformBundle.createPlatformExtensionPoint(clazz, element);
        if (extensionPoint == null) {
            return;
        }
        if (init == false && extensionPoint instanceof AbstractPlatformExtensionPoint) {
            ((AbstractPlatformExtensionPoint) extensionPoint).setPlatformBundle(platformBundle);
        }
        // Fill registries
        _bundleRegistry.put(bundle.getSymbolicName(), platformBundle);
        Set<Object> objects = _runtimeRegistry.get(clazz);
        if (objects == null) {
            objects = new HashSet<Object>();
            _runtimeRegistry.put(clazz, objects);
        }
        objects.add(extensionPoint);
        // Update delta
        if (delta != null) {
            delta.storeAddedPlatformExtensionPoint(clazz, extensionPoint);
        }
    }

    private void trace(IPlatformExtensionPointDelta delta) {
        IPlatformExtensionPoint[] added = delta.getAddedPlatformExtensionPoints();
        IPlatformExtensionPoint[] removed = delta.getRemovedPlatformExtensionPoints();
        if (removed.length != 0) {
            IPlatformExtensionPoint[] runtime = delta.getRemovedPlatformExtensionPoints();
            if (runtime.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("RuntimePlatformManager removed {0} Extension{1}.", //$NON-NLS-1$ 
                        runtime.length, runtime.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
                for (IPlatformExtensionPoint extensionPoint : removed) {
                    if (extensionPoint instanceof IPlatformExtensionPointURI) {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Removed {0}", URI.encode(((IPlatformExtensionPointURI) extensionPoint).getURI().toString())), 1); //$NON-NLS-1$
                    } else {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Removed {0}", extensionPoint.getId()), 1); //$NON-NLS-1$
                    }
                }
            }
        }
        if (added.length != 0) {
            IPlatformExtensionPoint[] runtime = delta.getAddedPlatformExtensionPoints();
            if (runtime.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("RuntimePlatformManager added {0} Extension{1}.", //$NON-NLS-1$ 
                        runtime.length, runtime.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
                for (IPlatformExtensionPoint extensionPoint : added) {
                    if (extensionPoint instanceof IPlatformExtensionPointURI) {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Added {0}", URI.encode(((IPlatformExtensionPointURI) extensionPoint).getURI().toString())), 1); //$NON-NLS-1$
                    } else {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Added {0}", extensionPoint.getId()), 1); //$NON-NLS-1$
                    }
                }
            }
        }
    }

}
