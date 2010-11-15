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
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointURI;
import org.eclipse.egf.core.platform.pde.ITargetPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.ITargetPlatformManager;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
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
public final class TargetPlatformManager extends AbstractPlatformManager implements ITargetPlatformManager, IPluginModelListener, IExtensionDeltaListener {

    // IPlatformBundle Runtime and Workspace Registry
    protected Map<String, IPlatformBundle> _platformRegistry;

    // IPlatformExtensionPoint Workspace Registry
    private Map<Class<?>, Set<Object>> _workspaceRegistry;

    // IPlatformExtensionPoint Target Registry
    private Map<Class<?>, Set<Object>> _targetRegistry;

    protected static IPlatformBundle createPlatformBundle(IPluginModelBase base) {
        // Always create a new PlatformBundle
        PlatformBundle platformBundle = new PlatformBundle(base);
        // Process extension point
        for (IPluginExtension extension : base.getExtensions(false).getExtensions()) {
            Class<? extends IPlatformExtensionPoint> clazz = EGFPlatformPlugin.getPlatformExtensionPoints().get(extension.getPoint());
            if (clazz != null) {
                for (IPluginObject pluginObject : extension.getChildren()) {
                    if (pluginObject instanceof IPluginElement) {
                        platformBundle.createPlatformExtensionPoint(clazz, pluginObject);
                    }
                }
            }
        }
        return platformBundle;
    }

    protected static List<IPluginModelBase> getExtensionPointModels(ModelEntry entry) {
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
                    continue LOOP;
                }
            }
        }
        return plugins;
    }

    public TargetPlatformManager() {
        super();
        // PDE Listeners
        PDECore.getDefault().getModelManager().addPluginModelListener(this);
        PDECore.getDefault().getModelManager().addExtensionDeltaListener(this);
    }

    public int getPlatformBundleSize() {
        return _platformRegistry.size();
    }

    public int getPlatformExtensionPointSize() {
        int size = 0;
        for (Map.Entry<Class<?>, Set<Object>> entry : _workspaceRegistry.entrySet()) {
            size += entry.getValue().size();
        }
        for (Map.Entry<Class<?>, Set<Object>> entry : _targetRegistry.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }

    public int getWorkspacePlatformExtensionPointSize() {
        int size = 0;
        for (Map.Entry<Class<?>, Set<Object>> entry : _workspaceRegistry.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }

    public int getTargetPlatformExtensionPointSize() {
        int size = 0;
        for (Map.Entry<Class<?>, Set<Object>> entry : _targetRegistry.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }

    @Override
    public void dispose() {
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            super.dispose();
            PDECore.getDefault().getModelManager().removePluginModelListener(this);
            PDECore.getDefault().getModelManager().removeExtensionDeltaListener(this);
            if (_platformRegistry != null) {
                _platformRegistry.clear();
            }
            if (_targetRegistry != null) {
                _targetRegistry.clear();
            }
            if (_workspaceRegistry != null) {
                _workspaceRegistry.clear();
            }
        }
    }

    public IPlatformBundle getPlatformBundle(String id) {
        // Lock PlatformManager
        if (id == null) {
            return null;
        }
        synchronized (_lockPlatformManager) {
            return _platformRegistry.get(id);
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
        synchronized (_lockPlatformManager) {
            // Create a copy of known values
            return _platformRegistry.values().toArray(new IPlatformBundle[_platformRegistry.size()]);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getWorkspacePlatformExtensionPoints(Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            return getPlatformExtensionPoints(_workspaceRegistry, clazz);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getTargetPlatformExtensionPoints(Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            return getPlatformExtensionPoints(_targetRegistry, clazz);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            if (clazz == null || EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz) == false) {
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

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(IPluginModelBase model, Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            if (model != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz)) {
                IPlatformBundle platformBundle = getPlatformBundle(model);
                if (platformBundle != null) {
                    return platformBundle.getPlatformExtensionPoints(clazz);
                }
            }
            return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(IProject project, Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            if (project != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz)) {
                IPlatformBundle platformBundle = getPlatformBundle(project);
                if (platformBundle != null) {
                    return platformBundle.getPlatformExtensionPoints(clazz);
                }
            }
            return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
        }
    }

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(String id, Class<T> clazz) {
        synchronized (_lockPlatformManager) {
            if (id != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz)) {
                IPlatformBundle platformBundle = _platformRegistry.get(id);
                if (platformBundle != null) {
                    return platformBundle.getPlatformExtensionPoints(clazz);
                }
            }
            return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
        }
    }

    @Override
    protected void initialize() {
        // Initialize Target Platform Registries
        long startTargetTime = System.currentTimeMillis();
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            initializeRegistry();
        }
        // Debug
        long endTargetTime = System.currentTimeMillis();
        if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFPlatformPlugin.getDefault().logInfo(NLS.bind("TargetPlatformManager _ found {0} Platform Bundle{1}, " //$NON-NLS-1$ 
                    + "''{2}'' Workspace Extension Point{3}," //$NON-NLS-1$ 
                    + "''{4}'' Target Extension Point{5}," //$NON-NLS-1$
                    + "in " //$NON-NLS-1$
                    + "''{6}'' ms", //$NON-NLS-1$ 
                    new Object[] {
                            getPlatformBundleSize(), getPlatformBundleSize() < 2 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
                            getWorkspacePlatformExtensionPointSize(), getWorkspacePlatformExtensionPointSize() < 2 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$                                    
                            getTargetPlatformExtensionPointSize(), getTargetPlatformExtensionPointSize() < 2 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$                                    
                            (endTargetTime - startTargetTime)
                    }));
            for (Class<?> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
                Set<Object> targetObjects = _targetRegistry.get(clazz);
                Set<Object> workspaceObjects = _workspaceRegistry.get(clazz);
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

    @Override
    protected void initializeRegistry() {
        if (_platformRegistry != null) {
            return;
        }
        _platformRegistry = new HashMap<String, IPlatformBundle>();
        _workspaceRegistry = new HashMap<Class<?>, Set<Object>>();
        _targetRegistry = new HashMap<Class<?>, Set<Object>>();
        // Feed Platform Registries
        for (IPluginModelBase base : PluginRegistry.getActiveModels(true)) {
            addPlatformBundle(createPlatformBundle(base), null);
        }
    }

    protected void handleChange(IPluginModelBase base, PlatformExtensionPointDelta delta) {
        if (base == null) {
            return;
        }
        // Check an existing one
        PlatformBundle platformBundle = (PlatformBundle) _platformRegistry.get(BundleHelper.getBundleId(base));
        if (platformBundle == null) {
            if (base.isEnabled()) {
                addPlatformBundle(createPlatformBundle(base), delta);
            }
        } else if (base.isEnabled()) {
            if (base == platformBundle.getPluginModelBase()) {
                mergePlatformBundle(platformBundle, createPlatformBundle(base), delta);
            } else {
                removePlatformBundle(platformBundle, delta);
                addPlatformBundle(createPlatformBundle(base), delta);
            }
        } else {
            removePlatformBundle(platformBundle, delta);
        }
    }

    /**
     * Process extension delta event This method is called when listeners are
     * initialized.
     * 
     * @see org.eclipse.egf.core.platform.internal.pde.TargetPlatformManager#getPlatformBundles() for initialization. If someone call dispose() this method is no longer
     *      called. No need to initialize the PlatformManager
     * 
     * @param event
     * the event to be processed
     */
    public void extensionsChanged(IExtensionDeltaEvent event) {
        // Initialize a delta
        TargetPlatformExtensionPointDelta delta = new TargetPlatformExtensionPointDelta();
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            // Process Removed Entries
            for (IPluginModelBase base : event.getRemovedModels()) {
                IPlatformBundle platformBundle = _platformRegistry.get(BundleHelper.getBundleId(base));
                if (platformBundle != null && base.equals(platformBundle.getPluginModelBase())) {
                    removePlatformBundle(platformBundle, delta);
                }
            }
            // Process Added Entries
            for (IPluginModelBase base : event.getAddedModels()) {
                IPlatformBundle platformBundle = _platformRegistry.get(BundleHelper.getBundleId(base));
                if (platformBundle != null && base.equals(platformBundle.getPluginModelBase()) == false) {
                    removePlatformBundle(platformBundle, delta);
                }
                addPlatformBundle(createPlatformBundle(base), delta);
            }
            // Process Changed Entries
            for (IPluginModelBase base : event.getChangedModels()) {
                handleChange(base, delta);
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

    /**
     * Process model delta event This method is called when listeners are
     * initialized.
     * 
     * @see org.eclipse.egf.core.platform.internal.pde.TargetPlatformManager#getPlatformBundles() for initialization. If someone call dispose() this method is no longer
     *      called. No need to initialize the PlatformManager
     * 
     * @param event
     *            the event to be processed
     */
    public void modelsChanged(PluginModelDelta event) {
        // Initialize a delta
        TargetPlatformExtensionPointDelta delta = new TargetPlatformExtensionPointDelta();
        // Lock PlatformManager
        synchronized (_lockPlatformManager) {
            // Process Removed ModelEntry
            if ((event.getKind() & PluginModelDelta.REMOVED) != 0) {
                // Process Removed Entries
                for (ModelEntry entry : event.getRemovedEntries()) {
                    for (IPluginModelBase base : getExtensionPointModels(entry)) {
                        IPlatformBundle platformBundle = _platformRegistry.get(BundleHelper.getBundleId(base));
                        if (platformBundle != null && base.equals(platformBundle.getPluginModelBase())) {
                            removePlatformBundle(platformBundle, delta);
                        }
                    }
                }
            }
            // Process Added ModelEntry
            if ((event.getKind() & PluginModelDelta.ADDED) != 0) {
                // Process Added Entries
                for (ModelEntry entry : event.getAddedEntries()) {
                    for (IPluginModelBase base : getExtensionPointModels(entry)) {
                        IPlatformBundle platformBundle = _platformRegistry.get(BundleHelper.getBundleId(base));
                        if (platformBundle != null && base.equals(platformBundle.getPluginModelBase()) == false) {
                            removePlatformBundle(platformBundle, delta);
                        }
                        addPlatformBundle(createPlatformBundle(base), delta);
                    }
                }
            }
            // Process Changed ModelEntry
            if ((event.getKind() & PluginModelDelta.CHANGED) != 0) {
                // Process Changed Entries
                for (ModelEntry entry : event.getChangedEntries()) {
                    for (IPluginModelBase base : entry.hasWorkspaceModels() ? entry.getWorkspaceModels() : entry.getExternalModels()) {
                        handleChange(base, delta);
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

    protected void mergePlatformBundle(PlatformBundle platformBundle, IPlatformBundle newPlatformBundle, PlatformExtensionPointDelta delta) {
        if (platformBundle == null || newPlatformBundle == null) {
            return;
        }
        // Analyse existing monitored ExtensionPoints
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
            // Remove non existing Extension Point if necessary
            LOOP: for (IPlatformExtensionPoint existingExtensionPoint : platformBundle.getPlatformExtensionPoints(clazz)) {
                // should we remove this extensionPoint ?
                for (IPlatformExtensionPoint newExtensionPoint : newPlatformBundle.getPlatformExtensionPoints(clazz)) {
                    if (existingExtensionPoint.equals(newExtensionPoint)) {
                        continue LOOP;
                    }
                }
                // Remove this ExtensionPoint from our existing model
                if (platformBundle.removePlatformExtensionPoint(clazz, existingExtensionPoint) == false) {
                    EGFPlatformPlugin.getDefault().logError(NLS.bind("TargetPlatformManager.mergePlatformBundle(..) _ ''{0}'' unable to remove Extension Point from IPlatformBundle.", //$NON-NLS-1$
                            existingExtensionPoint));
                }
                // Remove this ExtensionPoint from our target or workspace registry
                if (platformBundle.isTarget()) {
                    removeExtensionPoint(existingExtensionPoint, clazz, _targetRegistry, delta);
                } else if (platformBundle.isWorkspace()) {
                    removeExtensionPoint(existingExtensionPoint, clazz, _workspaceRegistry, delta);
                }
            }
            // Add new Platform Extension Points
            LOOP: for (IPlatformExtensionPoint newExtensionPoint : newPlatformBundle.getPlatformExtensionPoints(clazz)) {
                // should we add it ?
                for (IPlatformExtensionPoint existingExtensionPoint : platformBundle.getPlatformExtensionPoints(clazz)) {
                    if (existingExtensionPoint.equals(newExtensionPoint)) {
                        continue LOOP;
                    }
                }
                // Add it in our existing model
                platformBundle.addPlatformExtensionPoint(clazz, newExtensionPoint);
                // Add it in our target or workspace registry
                if (platformBundle.isTarget()) {
                    addExtensionPoint(newExtensionPoint, clazz, _targetRegistry, delta);
                } else if (platformBundle.isWorkspace()) {
                    addExtensionPoint(newExtensionPoint, clazz, _workspaceRegistry, delta);
                }
            }
        }
        // Finally remove existingModel if necessary
        if (platformBundle.isEmpty()) {
            if (platformBundle.equals(_platformRegistry.remove(platformBundle.getBundleId())) == false) {
                EGFPlatformPlugin.getDefault().logError(NLS.bind("TargetPlatformManager.mergePlatformBundle(..) _ ''{0}'' unknown IPlatformBundle.", //$NON-NLS-1$
                        platformBundle.getBundleId()));
            }
        }
    }

    protected void removePlatformBundle(IPlatformBundle platformBundle, PlatformExtensionPointDelta delta) {
        if (platformBundle == null) {
            return;
        }
        if (platformBundle.isTarget()) {
            // Remove platform bundle registries
            removePlatformBundle(platformBundle, _platformRegistry, _targetRegistry, delta);
        } else {
            // Remove platform bundle from registries
            removePlatformBundle(platformBundle, _platformRegistry, _workspaceRegistry, delta);
        }
    }

    protected void addPlatformBundle(IPlatformBundle platformBundle, PlatformExtensionPointDelta delta) {
        if (platformBundle == null || platformBundle.isEmpty()) {
            return;
        }
        // Check existing model
        IPlatformBundle innerPlatformBundle = _platformRegistry.get(platformBundle.getBundleId());
        // Already processed
        if (platformBundle.equals(innerPlatformBundle)) {
            return;
        }
        if (platformBundle.isTarget()) {
            // Add platform bundle to our registries
            addPlatformBundle(platformBundle, _platformRegistry, _targetRegistry, delta);
        } else {
            // Add platform bundle to our registries
            addPlatformBundle(platformBundle, _platformRegistry, _workspaceRegistry, delta);
        }
    }

    private void trace(ITargetPlatformExtensionPointDelta delta) {
        IPlatformExtensionPoint[] added = delta.getAddedPlatformExtensionPoints();
        IPlatformExtensionPoint[] removed = delta.getRemovedPlatformExtensionPoints();
        if (removed.length != 0) {
            IPlatformExtensionPoint[] target = delta.getTargetRemovedPlatformExtensionPoints();
            if (target.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("TargetPlatformManager removed {0} target Extension{1}.", //$NON-NLS-1$ 
                        target.length, target.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
                for (IPlatformExtensionPoint extensionPoint : target) {
                    if (extensionPoint instanceof IPlatformExtensionPointURI) {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Target Removed {0}", URI.encode(((IPlatformExtensionPointURI) extensionPoint).getURI().toString())), 1); //$NON-NLS-1$
                    } else {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Target Removed {0}", extensionPoint.getId()), 1); //$NON-NLS-1$
                    }
                }
            }
            IPlatformExtensionPoint[] workspace = delta.getWorkspaceRemovedPlatformExtensionPoints();
            if (workspace.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("TargetPlatformManager removed {0} workspace Extension{1}.", //$NON-NLS-1$ 
                        workspace.length, workspace.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
                for (IPlatformExtensionPoint extensionPoint : workspace) {
                    if (extensionPoint instanceof IPlatformExtensionPointURI) {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Workspace Removed {0}", URI.encode(((IPlatformExtensionPointURI) extensionPoint).getURI().toString())), 1); //$NON-NLS-1$
                    } else {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Workspace Removed {0}", extensionPoint.getId()), 1); //$NON-NLS-1$
                    }
                }
            }
        }
        if (added.length != 0) {
            IPlatformExtensionPoint[] target = delta.getTargetAddedPlatformExtensionPoints();
            if (target.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("TargetPlatformManager added {0} target Extension{1}.", //$NON-NLS-1$ 
                        target.length, target.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
                for (IPlatformExtensionPoint extensionPoint : target) {
                    if (extensionPoint instanceof IPlatformExtensionPointURI) {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Target Added {0}", URI.encode(((IPlatformExtensionPointURI) extensionPoint).getURI().toString())), 1); //$NON-NLS-1$
                    } else {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Target Added {0}", extensionPoint.getId()), 1); //$NON-NLS-1$
                    }
                }
            }
            IPlatformExtensionPoint[] workspace = delta.getWorkspaceAddedPlatformExtensionPoints();
            if (workspace.length != 0) {
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("TargetPlatformManager added {0} workspace Extension{1}.", //$NON-NLS-1$ 
                        workspace.length, workspace.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
                ));
                for (IPlatformExtensionPoint extensionPoint : workspace) {
                    if (extensionPoint instanceof IPlatformExtensionPointURI) {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Workspace Added {0}", URI.encode(((IPlatformExtensionPointURI) extensionPoint).getURI().toString())), 1); //$NON-NLS-1$
                    } else {
                        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("Workspace Added {0}", extensionPoint.getId()), 1); //$NON-NLS-1$
                    }
                }
            }
        }
    }

}
