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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.IExtensionDeltaEvent;
import org.eclipse.pde.internal.core.IExtensionDeltaListener;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;

/**
 * PlatformManager manage factory components extension point based on PDE
 * registry. It tracks Target Platform FCs and workspace FCs. PDE doesn't manage
 * n versions of the same plugin. As a result only the latest found is managed
 * in the registry. As such each bundle has its symbolic name as its ID.
 * 
 * @since 1.0
 */
public final class PlatformManager implements IPlatformManager, IPluginModelListener, IExtensionDeltaListener {

    // Use a lock object, this will prevent us against
    // a lock against the PlatformManager instance
    private Object __lockPlatformManager = new Object();

    // IPlatformBundle registry
    private Map<String, IPlatformBundle> _platformBundles;

    // IPlatformExtensionPoint Workspace registry
    private Map<Class<?>, List<Object>> _workspaceRegistry;

    // IPlatformExtensionPoint Target registry
    private Map<Class<?>, List<Object>> _targetRegistry;

    // A list of listeners interested in changes to extension points
    private List<IPlatformExtensionPointListener> _listeners;

    public PlatformManager() {
        initialize();
        PDECore.getDefault().getModelManager().addPluginModelListener(this);
        PDECore.getDefault().getModelManager().addExtensionDeltaListener(this);
    }

    public void dispose() {
        PDECore.getDefault().getModelManager().removePluginModelListener(this);
        PDECore.getDefault().getModelManager().removeExtensionDeltaListener(this);
        if (_platformBundles != null) {
            _platformBundles.clear();
        }
        if (_targetRegistry != null) {
            _targetRegistry.clear();
        }
        if (_workspaceRegistry != null) {
            _workspaceRegistry.clear();
        }
        if (_listeners != null) {
            _listeners.clear();
        }
    }

    public IPlatformBundle getPlatformBundle(String id) {
        // Lock PlatformManager
        if (id == null) {
            return null;
        }
        synchronized (__lockPlatformManager) {
            return _platformBundles.get(id);
        }
    }

    public IPlatformBundle getPlatformBundle(IPluginModelBase base) {
        if (base == null) {
            return null;
        }
        String id = BundleHelper.getBundleId(base);
        if (id == null) {
            return null;
        }
        return getPlatformBundle(id);
    }

    public IPlatformBundle getPlatformBundle(IProject project) {
        if (project == null) {
            return null;
        }
        IPluginModelBase base = BundleHelper.getPluginModelBase(project);
        if (base == null) {
            return null;
        }
        String id = BundleHelper.getBundleId(base);
        if (id == null) {
            return null;
        }
        return getPlatformBundle(id);
    }

    public IPlatformBundle[] getPlatformBundles() {
        synchronized (__lockPlatformManager) {
            // Create a copy of known values
            return _platformBundles.values().toArray(new IPlatformBundle[_platformBundles.size()]);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getWorkspacePlatformExtensionPoints(Class<T> clazz) {
        synchronized (__lockPlatformManager) {
            List<Object> extensionPoints = new ArrayList<Object>();
            if (clazz != null) {
                if (_workspaceRegistry.get(clazz) != null) {
                    extensionPoints.addAll(_workspaceRegistry.get(clazz));
                }
            }
            return CollectionHelper.toArray(extensionPoints, clazz);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getTargetPlatformExtensionPoints(Class<T> clazz) {
        synchronized (__lockPlatformManager) {
            List<Object> extensionPoints = new ArrayList<Object>();
            if (clazz != null) {
                if (_targetRegistry.get(clazz) != null) {
                    extensionPoints.addAll(_targetRegistry.get(clazz));
                }
            }
            return CollectionHelper.toArray(extensionPoints, clazz);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz) {
        synchronized (__lockPlatformManager) {
            if (clazz == null || EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz) == false) {
                return null;
            }
            // Create a copy of known values
            T[] targetExtensionPoints = getTargetPlatformExtensionPoints(clazz);
            T[] workspaceExtensionPoints = getWorkspacePlatformExtensionPoints(clazz);
            T[] extensionPoints = (T[]) Array.newInstance(clazz, targetExtensionPoints.length + workspaceExtensionPoints.length);
            System.arraycopy(targetExtensionPoints, 0, extensionPoints, 0, targetExtensionPoints.length);
            System.arraycopy(workspaceExtensionPoints, 0, extensionPoints, targetExtensionPoints.length, workspaceExtensionPoints.length);
            // Return
            return extensionPoints;

        }
    }

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(IProject project, Class<T> clazz) {
        synchronized (__lockPlatformManager) {
            if (project != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz)) {
                IPlatformBundle platformBundle = getPlatformBundle(project);
                if (platformBundle != null) {
                    return platformBundle.getPlatformExtensionPoints(clazz);
                }
            }
            return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(String id, Class<T> clazz) {
        synchronized (__lockPlatformManager) {
            if (id != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz)) {
                IPlatformBundle platformBundle = _platformBundles.get(id);
                if (platformBundle != null) {
                    return platformBundle.getPlatformExtensionPoints(clazz);
                }
            }
            return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
        }
    }

    private void initialize() {
        if (_platformBundles != null) {
            return;
        }
        long startTime = System.currentTimeMillis();
        // Retrieve models
        IPluginModelBase[] models = PluginRegistry.getActiveModels(true);
        // Initialize registries
        _platformBundles = new TreeMap<String, IPlatformBundle>();
        _workspaceRegistry = new HashMap<Class<?>, List<Object>>();
        _targetRegistry = new HashMap<Class<?>, List<Object>>();
        // Feed registries
        for (IPluginModelBase base : models) {
            addPlatformBundle(BundleHelper.getBundleId(base), createPlatformBundle(base), null);
        }
        // Debug
        if (EGFPlatformPlugin.getDefault().isDebugging()) {
            long endTime = System.currentTimeMillis();
            long time = (endTime - startTime);
            EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager _ found {0} Platform Bundle{1} in ''{2}'' ms", //$NON-NLS-1$ 
                    new Object[] {
                            _platformBundles.size(), _platformBundles.size() < 2 ? "" : "s", time}//$NON-NLS-1$  //$NON-NLS-2$
                    ));
            for (Class<?> clazz : EGFPlatformPlugin.getPlatformExtensionPointClasses()) {
                List<Object> targetObjects = _targetRegistry.get(clazz);
                List<Object> workspaceObjects = _workspaceRegistry.get(clazz);
                int target = targetObjects != null ? targetObjects.size() : 0;
                int workspace = workspaceObjects != null ? workspaceObjects.size() : 0;
                int extension = target + workspace;
                if (extension == 0) {
                    continue;
                }
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("{0} Extension{1} ''{2}''", //$NON-NLS-1$ 
                        new Object[] {
                                extension, extension < 2 ? "" : "s", clazz.getName()}), 1); //$NON-NLS-1$ //$NON-NLS-2$
                if (target != 0) {
                    EGFPlatformPlugin.getDefault().logInfo(NLS.bind("{0} target Extension{1}", //$NON-NLS-1$ 
                            new Object[] {
                                    target, target < 2 ? "" : "s", clazz.getName()}), 2); //$NON-NLS-1$ //$NON-NLS-2$
                }
                if (workspace != 0) {
                    EGFPlatformPlugin.getDefault().logInfo(NLS.bind("{0} workspace Extension{1}", //$NON-NLS-1$ 
                            new Object[] {
                                    workspace, workspace < 2 ? "" : "s", clazz.getName()}), 2); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
        }
    }

    /**
     * Notify all interested listeners in changes made to the models table
     * 
     * @param delta
     *            the delta of changes
     */
    private void firePlatformExtensionPoint(IPlatformExtensionPointDelta delta) {
        if (_listeners != null) {
            for (IPlatformExtensionPointListener listener : _listeners) {
                listener.platformExtensionPointChanged(delta);
            }
        }
    }

    /**
     * Add a listener to the platform manager
     * 
     * @param listener
     *            the listener to be added
     */
    public void addPlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
        // Lock PlatformManager
        synchronized (__lockPlatformManager) {
            if (_listeners == null) {
                _listeners = new ArrayList<IPlatformExtensionPointListener>();
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
     *            the listener to be removed
     */
    public void removePlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
        // Lock PlatformManager
        synchronized (__lockPlatformManager) {
            if (_listeners == null) {
                return;
            }
            _listeners.remove(listener);
        }
    }

    /**
     * Process extension delta event This method is called when listeners are
     * initialized.
     * 
     * @see org.eclipse.egf.core.platform.internal.pde.PlatformManager#getPlatformBundles() for initialization. If someone call dispose() this method is no longer
     *      called. No need to initialize the PlatformManager
     * 
     * @param event
     *            the event to be processed
     */
    public void extensionsChanged(IExtensionDeltaEvent event) {
        // Lock PlatformManager
        synchronized (__lockPlatformManager) {
            // Initialize a delta
            PlatformExtensionPointDelta delta = new PlatformExtensionPointDelta();
            // Process Removed Entries
            for (IPluginModelBase base : event.getRemovedModels()) {
                String id = BundleHelper.getBundleId(base);
                // Ignore Model with unknown id
                if (id == null) {
                    continue;
                }
                IPlatformBundle existingPlatformBundle = _platformBundles.get(id);
                if (existingPlatformBundle != null && base.equals(existingPlatformBundle.getPluginModelBase())) {
                    removePlatformBundle(id, existingPlatformBundle, delta);
                }
            }
            // Process Changed Entries
            for (IPluginModelBase base : event.getChangedModels()) {
                handleChange(base, delta);
            }
            // Process Added Entries
            for (IPluginModelBase base : event.getAddedModels()) {
                String id = BundleHelper.getBundleId(base);
                // Ignore Model with unknown id
                if (id == null) {
                    continue;
                }
                IPlatformBundle existingPlatformBundle = _platformBundles.get(id);
                if (existingPlatformBundle != null && base.equals(existingPlatformBundle.getPluginModelBase()) == false) {
                    removePlatformBundle(id, existingPlatformBundle, delta);
                }
                addPlatformBundle(id, createPlatformBundle(base), delta);
            }
            // Something to process
            if (delta.isEmpty() == false) {
                // Debug
                if (EGFPlatformPlugin.getDefault().isDebugging()) {
                    trace(delta);
                }
                // Notify all interested listeners in the changes made to models
                firePlatformExtensionPoint(delta);
            }
        }
    }

    /**
     * Process model delta event This method is called when listeners are
     * initialized.
     * 
     * @see org.eclipse.egf.core.platform.internal.pde.PlatformManager#getPlatformBundles() for initialization. If someone call dispose() this method is no longer
     *      called. No need to initialize the PlatformManager
     * 
     * @param event
     *            the event to be processed
     */
    public void modelsChanged(PluginModelDelta event) {
        // Lock PlatformManager
        synchronized (__lockPlatformManager) {
            // Initialize a delta
            PlatformExtensionPointDelta delta = new PlatformExtensionPointDelta();
            // Process Removed ModelEntry
            if ((event.getKind() & PluginModelDelta.REMOVED) != 0) {
                // Process Removed Entries
                for (ModelEntry entry : event.getRemovedEntries()) {
                    String id = entry.getId();
                    // Ignore Model with unknown id
                    if (id == null) {
                        continue;
                    }
                    IPlatformBundle existingPlatformBundle = _platformBundles.get(id);
                    if (existingPlatformBundle != null) {
                        removePlatformBundle(id, existingPlatformBundle, delta);
                    }
                }
            }
            // Process Added ModelEntry
            if ((event.getKind() & PluginModelDelta.ADDED) != 0) {
                // Process Added Entries
                for (ModelEntry entry : event.getAddedEntries()) {
                    for (IPluginModelBase base : getExtensionPointModels(entry)) {
                        String id = BundleHelper.getBundleId(base);
                        // Ignore Model with unknown id
                        if (id == null) {
                            continue;
                        }
                        IPlatformBundle existingPlatformBundle = _platformBundles.get(id);
                        if (existingPlatformBundle != null && base.equals(existingPlatformBundle.getPluginModelBase()) == false) {
                            removePlatformBundle(id, existingPlatformBundle, delta);
                        }
                        addPlatformBundle(id, createPlatformBundle(base), delta);
                    }
                }
            }
            // Process Changed ModelEntry
            if ((event.getKind() & PluginModelDelta.CHANGED) != 0) {
                // Process Changed Entries
                for (ModelEntry entry : event.getChangedEntries()) {
                    for (IPluginModelBase base : getExtensionPointModels(entry)) {
                        handleChange(base, delta);
                    }
                }
            }
            // Something to process
            if (delta.isEmpty() == false) {
                // Debug
                if (EGFPlatformPlugin.getDefault().isDebugging()) {
                    trace(delta);
                }
                // Notify all interested listeners in the changes made to models
                firePlatformExtensionPoint(delta);
            }
        }
    }

    private IPlatformBundle createPlatformBundle(IPluginModelBase base) {
        // Always create a model
        IPlatformBundle platformBundle = new PlatformBundle(base);
        // Process extension point
        for (IPluginExtension extension : base.getExtensions(false).getExtensions()) {
            Class<? extends IPlatformExtensionPoint> clazz = EGFPlatformPlugin.getPlatformExtensionPoints().get(extension.getPoint());
            if (clazz != null) {
                platformBundle.addPlatformExtensionPoint(clazz, extension);
            }
        }
        return platformBundle;
    }

    private void handleChange(IPluginModelBase base, PlatformExtensionPointDelta delta) {
        // Check an existing one
        String id = BundleHelper.getBundleId(base);
        IPlatformBundle existingPlatformBundle = _platformBundles.get(id);
        if (base.isEnabled()) {
            if (existingPlatformBundle != null && base == existingPlatformBundle.getPluginModelBase()) {
                mergePlatformBundle(existingPlatformBundle, createPlatformBundle(base), delta);
            } else {
                if (existingPlatformBundle != null && base != existingPlatformBundle.getPluginModelBase()) {
                    removePlatformBundle(id, existingPlatformBundle, delta);
                }
                addPlatformBundle(id, createPlatformBundle(base), delta);
            }
        } else {
            removePlatformBundle(id, existingPlatformBundle, delta);
        }
    }

    private void mergePlatformBundle(IPlatformBundle existingPlatformBundle, IPlatformBundle newPlatformBundle, PlatformExtensionPointDelta delta) {
        if (existingPlatformBundle == null || newPlatformBundle == null) {
            return;
        }
        // Analyse existing monitored ExtensionPoints
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPointClasses()) {
            // Remove non existing Extension Point if necessary
            LOOP: for (IPlatformExtensionPoint existingExtensionPoint : existingPlatformBundle.getPlatformExtensionPoints(clazz)) {
                // should we remove this extensionPoint ?
                for (IPlatformExtensionPoint newExtensionPoint : newPlatformBundle.getPlatformExtensionPoints(clazz)) {
                    if (existingExtensionPoint.equals(newExtensionPoint)) {
                        continue LOOP;
                    }
                }
                // Remove this ExtensionPoint from our existing model
                if (existingPlatformBundle.removePlatformExtensionPoint(clazz, existingExtensionPoint) == false) {
                    EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.mergePlatformBundle(..) _ ''{0}'' unable to remove Extension Point from PlatformBundle.", //$NON-NLS-1$
                            existingExtensionPoint));
                }
                // Remove this ExtensionPoint from our target or workspace registry
                if (existingPlatformBundle.isTarget()) {
                    if (_targetRegistry.get(clazz).remove(existingExtensionPoint)) {
                        // Clean Target Registry if necessary
                        if (_targetRegistry.get(clazz).isEmpty()) {
                            _targetRegistry.remove(clazz);
                        }
                        // Update delta
                        if (delta != null) {
                            delta.storeRemovedPlatformExtensionPoint(clazz, existingExtensionPoint);
                        }
                    }
                } else {
                    if (_workspaceRegistry.get(clazz).remove(existingExtensionPoint)) {
                        // Clean Workspace Registry if necessary
                        if (_workspaceRegistry.get(clazz).isEmpty()) {
                            _workspaceRegistry.remove(clazz);
                        }
                        // Update delta
                        if (delta != null) {
                            delta.storeRemovedPlatformExtensionPoint(clazz, existingExtensionPoint);
                        }
                    }
                }
            }
            // Add this new Extension Point
            LOOP: for (IPlatformExtensionPoint newExtensionPoint : newPlatformBundle.getPlatformExtensionPoints(clazz)) {
                // should we add newExtensionPoint ?
                for (IPlatformExtensionPoint existingExtensionPoint : existingPlatformBundle.getPlatformExtensionPoints(clazz)) {
                    if (existingExtensionPoint.equals(newExtensionPoint)) {
                        continue LOOP;
                    }
                }
                // Add this newExtensionPoint in our existing model
                existingPlatformBundle.addPlatformExtensionPoint(clazz, newExtensionPoint);
                // Add this newExtensionPoint in our target or workspace registry
                if (existingPlatformBundle.isTarget()) {
                    List<Object> extensionPoints = _targetRegistry.get(clazz);
                    // init slot if necessary
                    if (extensionPoints == null) {
                        extensionPoints = new ArrayList<Object>();
                        _targetRegistry.put(clazz, extensionPoints);
                    }
                    if (extensionPoints.add(newExtensionPoint) == false) {
                        EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.mergePlatformBundle(..) _ ''{0}'' unable to add Extension Point in target registry.", //$NON-NLS-1$
                                newExtensionPoint));
                    } else {
                        // Update delta
                        if (delta != null) {
                            delta.storeAddedPlatformExtensionPoint(clazz, newExtensionPoint);
                        }
                    }
                } else {
                    List<Object> extensionPoints = _workspaceRegistry.get(clazz);
                    // init slot if necessary
                    if (extensionPoints == null) {
                        extensionPoints = new ArrayList<Object>();
                        _workspaceRegistry.put(clazz, extensionPoints);
                    }
                    if (extensionPoints.add(newExtensionPoint) == false) {
                        EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.mergePlatformBundle(..) _ ''{0}'' unable to add Extension Point in workspace registry.", //$NON-NLS-1$
                                newExtensionPoint));
                    } else {
                        // Update delta
                        if (delta != null) {
                            delta.storeAddedPlatformExtensionPoint(clazz, newExtensionPoint);
                        }
                    }
                }
            }
        }
        // Finally remove existingModel if necessary
        if (existingPlatformBundle.isEmpty()) {
            if (existingPlatformBundle.equals(_platformBundles.remove(existingPlatformBundle.getBundleId())) == false) {
                EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.mergePlatformBundle(..) _ ''{0}'' unknown PlatformBundle.", //$NON-NLS-1$
                        existingPlatformBundle.getBundleId()));
            }
        }
    }

    private void removePlatformBundle(String id, IPlatformBundle platformBundle, PlatformExtensionPointDelta delta) {
        if (id == null || platformBundle == null) {
            return;
        }
        // Remove platform bundle from our main registry
        if (platformBundle.equals(_platformBundles.remove(id)) == false) {
            EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.removePlatformBundle(..) _ ''{0}'' unknown PlatformBundle.", //$NON-NLS-1$
                    id));
        }
        // Process extension point
        // Analyse Removed Extension Points
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPointClasses()) {
            for (IPlatformExtensionPoint extensionPoint : platformBundle.getPlatformExtensionPoints(clazz)) {
                // remove extension point from our target or workspace registry
                if (platformBundle.isTarget()) {
                    if (_targetRegistry.get(clazz).remove(extensionPoint)) {
                        // Clean Target Registry if necessary
                        if (_targetRegistry.get(clazz).isEmpty()) {
                            _targetRegistry.remove(clazz);
                        }
                        // Update delta
                        if (delta != null) {
                            delta.storeRemovedPlatformExtensionPoint(clazz, extensionPoint);
                        }
                    }
                } else {
                    if (_workspaceRegistry.get(clazz).remove(extensionPoint)) {
                        // Clean Workspace Registry if necessary
                        if (_workspaceRegistry.get(clazz).isEmpty()) {
                            _workspaceRegistry.remove(clazz);
                        }
                        // Update delta
                        if (delta != null) {
                            delta.storeRemovedPlatformExtensionPoint(clazz, extensionPoint);
                        }
                    }
                }
            }
        }
    }

    private void addPlatformBundle(String id, IPlatformBundle newPlatformBundle, PlatformExtensionPointDelta delta) {
        if (id == null || newPlatformBundle == null || newPlatformBundle.isEmpty()) {
            return;
        }
        // Check existing model
        // Retrieve an existing one
        IPlatformBundle existingPlatformBundle = _platformBundles.get(id);
        if (existingPlatformBundle != null) {
            // Nothing to add
            return;
        }
        // Add platform bundle to our main registry
        _platformBundles.put(id, newPlatformBundle);
        // Process extension point
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPointClasses()) {
            for (IPlatformExtensionPoint extensionPoint : newPlatformBundle.getPlatformExtensionPoints(clazz)) {
                // add extension point in our target or workspace registry
                if (newPlatformBundle.isTarget()) {
                    List<Object> extensionPoints = _targetRegistry.get(clazz);
                    if (extensionPoints == null) {
                        extensionPoints = new ArrayList<Object>();
                        _targetRegistry.put(clazz, extensionPoints);
                    }
                    if (extensionPoints.add(extensionPoint) == false) {
                        EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.addPlatformBundle(..) _ ''{0}'' unable to add Extension Point in target registry.", //$NON-NLS-1$
                                extensionPoint.getId()));
                    } else {
                        // Update delta
                        if (delta != null) {
                            delta.storeAddedPlatformExtensionPoint(clazz, extensionPoint);
                        }
                    }
                } else {
                    List<Object> extensionPoints = _workspaceRegistry.get(clazz);
                    if (extensionPoints == null) {
                        extensionPoints = new ArrayList<Object>();
                        _workspaceRegistry.put(clazz, extensionPoints);
                    }
                    if (extensionPoints.add(extensionPoint) == false) {
                        EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.addPlatformBundle(..) _ ''{0}'' unable to add Extension Point in workspace registry.", //$NON-NLS-1$
                                extensionPoint.getId()));
                    } else {
                        // Update delta
                        if (delta != null) {
                            delta.storeAddedPlatformExtensionPoint(clazz, extensionPoint);
                        }
                    }
                }
            }
        }
    }

    private List<IPluginModelBase> getExtensionPointModels(ModelEntry entry) {
        List<IPluginModelBase> plugins = new UniqueEList<IPluginModelBase>();
        // workspace models are always processed first, pde and jdt default behaviour
        LOOP: for (IPluginModelBase model : entry.hasWorkspaceModels() ? entry.getWorkspaceModels() : entry.getExternalModels()) {
            if (model.getExtensions(false) == null || model.getExtensions(false).getExtensions() == null) {
                continue;
            }
            for (IPluginExtension extension : model.getExtensions(false).getExtensions()) {
                Class<? extends IPlatformExtensionPoint> clazz = EGFPlatformPlugin.getPlatformExtensionPoints().get(extension.getPoint());
                if (clazz != null) {
                    plugins.add(model);
                    // Only one known extension points is enough to further analyse such model
                    continue LOOP;
                }
            }
        }
        return plugins;
    }

    private void trace(IPlatformExtensionPointDelta delta) {
        IPlatformExtensionPoint[] added = delta.getAddedPlatformExtensionPoints();
        IPlatformExtensionPoint[] removed = delta.getRemovedPlatformExtensionPoints();
        if (removed.length != 0) {
            IPlatformExtensionPoint[] target = delta.getTargetRemovedPlatformExtensionPoints();
            if (target.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager removed {0} target Extension{1}.", //$NON-NLS-1$ 
                        target.length, target.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
            }
            IPlatformExtensionPoint[] workspace = delta.getWorkspaceRemovedPlatformExtensionPoints();
            if (workspace.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager removed {0} workspace Extension{1}.", //$NON-NLS-1$ 
                        workspace.length, workspace.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
            }
        }
        if (added.length != 0) {
            IPlatformExtensionPoint[] target = delta.getTargetAddedPlatformExtensionPoints();
            if (target.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager added {0} target Extension{1}.", //$NON-NLS-1$ 
                        target.length, target.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
            }
            IPlatformExtensionPoint[] workspace = delta.getWorkspaceAddedPlatformExtensionPoints();
            if (workspace.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager added {0} workspace Extension{1}.", //$NON-NLS-1$ 
                        workspace.length, workspace.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
            }
        }
    }
}
