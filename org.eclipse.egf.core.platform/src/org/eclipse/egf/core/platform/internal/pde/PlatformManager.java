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
package org.eclipse.egf.core.platform.internal.pde;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.egf.core.platform.util.CollectionHelper;
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

  private static Map<String, Class<? extends IPlatformExtensionPoint>> _extensionPoints;

  @SuppressWarnings("unchecked")
  private static Map<String, Class<? extends IPlatformExtensionPoint>> getExtensionPoints() {
    if (_extensionPoints == null) {
      _extensionPoints = new HashMap<String, Class<? extends IPlatformExtensionPoint>>();
      for (String extensionPoint : EGFPlatformPlugin.getDefault().getPlatform().keySet()) {
        // Factory
        IPlatformExtensionPointFactory<?> clazz = (IPlatformExtensionPointFactory<?>) ExtensionPointHelper.createInstance(EGFPlatformPlugin.getDefault().getPlatform().get(extensionPoint), IManagerConstants.MANAGER_ATT_CLASS);
        if (clazz == null) {
          continue;
        }
        // Fetch Returned Types from Factory
        Class<?> key = EGFPlatformPlugin.fetchReturnedTypeFromFactory(((IPlatformExtensionPointFactory<?>) clazz).getClass());
        // Store it
        _extensionPoints.put(extensionPoint, (Class<? extends IPlatformExtensionPoint>) key);
      }
    }
    return _extensionPoints;
  }

  public static Collection<Class<? extends IPlatformExtensionPoint>> getExtensionPointsValues() {
    return getExtensionPoints().values();
  }

  private static volatile PlatformManager __platformManager;

  // Use a lock object, this will prevent us against
  // a lock against the PlatformManager instance
  private static Object _lock = new Object();

  public static PlatformManager getInstance() {
    if (__platformManager == null) {
      synchronized (_lock) {
        if (__platformManager == null) {
          __platformManager = new PlatformManager();
        }
      }
    }
    return __platformManager;
  }

  // IPlatformBundle registry
  private Map<String, IPlatformBundle> _platformBundles;

  // IPlatformExtensionPoint Workspace registry
  private Map<Class<?>, List<Object>> _workspaceRegistry;

  // IPlatformExtensionPoint Target registry
  private Map<Class<?>, List<Object>> _targetRegistry;

  // A list of listeners interested in changes to extension points
  private List<IPlatformExtensionPointListener> _listeners;

  private PlatformManager() {
    // Nothing to do
  }

  public void dispose() {
    PDECore.getDefault().getModelManager().removePluginModelListener(this);
    PDECore.getDefault().getModelManager().removeExtensionDeltaListener(this);
    _platformBundles = null;
    _targetRegistry = null;
    _workspaceRegistry = null;
    _listeners = null;
  }

  public IPlatformBundle getPlatformBundle(String id) {
    // Lock PlatformManager
    synchronized (_lock) {
      if (id == null) {
        return null;
      }
      if (_platformBundles == null) {
        initializePlatformManager();
      }
      return _platformBundles.get(id);
    }
  }

  public IPlatformBundle getPlatformBundle(IPluginModelBase base) {
    // Lock PlatformManager
    synchronized (_lock) {
      if (base == null) {
        return null;
      }
      String id = BundleHelper.getBundleId(base);
      if (id == null) {
        return null;
      }
      return getPlatformBundle(id);
    }
  }

  public IPlatformBundle getPlatformBundle(IProject project) {
    // Lock PlatformManager
    synchronized (_lock) {
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
  }

  public IPlatformBundle[] getPlatformBundles() {
    // Lock PlatformManager
    synchronized (_lock) {
      if (_platformBundles == null) {
        initializePlatformManager();
      }
      // Create a copy of known values
      return _platformBundles.values().toArray(new IPlatformBundle[_platformBundles.size()]);
    }
  }

  public <T extends IPlatformExtensionPoint> T[] getWorkspacePlatformExtensionPoints(Class<T> clazz) {
    // Lock PlatformManager
    synchronized (_lock) {
      List<Object> extensionPoints = new ArrayList<Object>();
      if (clazz != null && getExtensionPointsValues().contains(clazz)) {
        if (_platformBundles == null) {
          initializePlatformManager();
        }
        if (_workspaceRegistry.get(clazz) != null) {
          extensionPoints.addAll(_workspaceRegistry.get(clazz));
        }
      }
      return CollectionHelper.toArray(extensionPoints, clazz);
    }
  }

  public <T extends IPlatformExtensionPoint> T[] getTargetPlatformExtensionPoints(Class<T> clazz) {
    // Lock PlatformManager
    synchronized (_lock) {
      List<Object> extensionPoints = new ArrayList<Object>();
      if (clazz != null && getExtensionPointsValues().contains(clazz)) {
        if (_platformBundles == null) {
          initializePlatformManager();
        }
        if (_targetRegistry.get(clazz) != null) {
          extensionPoints.addAll(_targetRegistry.get(clazz));
        }
      }
      return CollectionHelper.toArray(extensionPoints, clazz);
    }
  }

  @SuppressWarnings("unchecked")
  public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz) {
    // Lock PlatformManager
    synchronized (_lock) {
      if (clazz == null || getExtensionPointsValues().contains(clazz) == false) {
        return null;
      }
      if (_platformBundles == null) {
        initializePlatformManager();
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
    // Lock PlatformManager
    synchronized (_lock) {
      if (project != null && clazz != null && getExtensionPointsValues().contains(clazz)) {
        if (_platformBundles == null) {
          initializePlatformManager();
        }
        IPlatformBundle platformBundle = getPlatformBundle(project);
        if (platformBundle != null) {
          return platformBundle.getPlatformExtensionPoints(clazz);
        }
      }
      return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
    }
  }

  public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(String id, Class<T> clazz) {
    // Lock PlatformManager
    synchronized (_lock) {
      if (id != null && clazz != null && getExtensionPointsValues().contains(clazz)) {
        if (_platformBundles == null) {
          initializePlatformManager();
        }
        IPlatformBundle platformBundle = _platformBundles.get(id);
        if (platformBundle != null) {
          return platformBundle.getPlatformExtensionPoints(clazz);
        }
      }
      return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
    }
  }

  private void initializePlatformManager() {
    if (_platformBundles != null) {
      return;
    }
    // listeners
    PDECore.getDefault().getModelManager().addPluginModelListener(this);
    PDECore.getDefault().getModelManager().addExtensionDeltaListener(this);
    // registries
    _platformBundles = new TreeMap<String, IPlatformBundle>();
    _workspaceRegistry = new HashMap<Class<?>, List<Object>>();
    _targetRegistry = new HashMap<Class<?>, List<Object>>();
    for (IPluginModelBase base : PluginRegistry.getActiveModels(true)) {
      addPlatformBundle(BundleHelper.getBundleId(base), createPlatformBundle(base), null);
    }
    // Debug
    if (EGFPlatformPlugin.getDefault().isDebugging()) {
      IPlatformBundle[] platformBundles = getPlatformBundles();
      if (platformBundles.length > 0) {
        EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager.initializePlatformManager(..) _ found {0} Platform Bundle{1}", //$NON-NLS-1$ 
            platformBundles.length, platformBundles.length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
        ));
      }
      trace(platformBundles);
    }
  }

  /**
   * Notify all interested listeners in changes made to the models table
   * 
   * @param delta
   *          the delta of changes
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
   *          the listener to be added
   */
  public void addPlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
    // Lock PlatformManager
    synchronized (_lock) {
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
   *          the listener to be removed
   */
  public void removePlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
    // Lock PlatformManager
    synchronized (_lock) {
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
   * @see {@link org.eclipse.egf.core.platform.internal.pde.PlatformManager#getPlatformBundles()}
   *      for initialization. If someone call dispose() this method is no longer
   *      called. No need to initialize the PlatformManager
   * 
   * @param event
   *          the event to be processed
   */
  public void extensionsChanged(IExtensionDeltaEvent event) {
    // Lock PlatformManager
    synchronized (_lock) {
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
   * @see {@link org.eclipse.egf.core.platform.internal.pde.PlatformManager#getPlatformBundles()}
   *      for initialization. If someone call dispose() this method is no longer
   *      called. No need to initialize the PlatformManager
   * 
   * @param event
   *          the event to be processed
   */
  public void modelsChanged(PluginModelDelta event) {
    // Lock PlatformManager
    synchronized (_lock) {
      // Initialize a delta
      PlatformExtensionPointDelta delta = new PlatformExtensionPointDelta();
      // Process Removed Entries
      if ((event.getKind() & PluginModelDelta.REMOVED) != 0) {
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
      // Process Changed Entries
      if ((event.getKind() & PluginModelDelta.CHANGED) != 0) {
        for (ModelEntry entry : event.getChangedEntries()) {
          for (IPluginModelBase base : getExtensionPointModels(entry)) {
            handleChange(base, delta);
          }
        }
      }
      // Process Added Entries
      if ((event.getKind() & PluginModelDelta.ADDED) != 0) {
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
      Class<? extends IPlatformExtensionPoint> clazz = getExtensionPoints().get(extension.getPoint());
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
      if (existingPlatformBundle != null && base.equals(existingPlatformBundle.getPluginModelBase())) {
        mergePlatformBundle(id, createPlatformBundle(base), delta);
      } else {
        if (existingPlatformBundle != null && base.equals(existingPlatformBundle.getPluginModelBase()) == false) {
          removePlatformBundle(id, existingPlatformBundle, delta);
        }
        addPlatformBundle(id, createPlatformBundle(base), delta);
      }
    } else {
      removePlatformBundle(id, existingPlatformBundle, delta);
    }
  }

  private void mergePlatformBundle(String id, IPlatformBundle newPlatformBundle, PlatformExtensionPointDelta delta) {
    if (id == null || newPlatformBundle == null) {
      return;
    }
    // Retrieve an existing one
    IPlatformBundle existingPlatformBundle = _platformBundles.get(id);
    // Nothing to compare with
    if (existingPlatformBundle == null) {
      return;
    }
    // Analyse existing monitored ExtensionPoints
    for (Class<? extends IPlatformExtensionPoint> clazz : getExtensionPoints().values()) {
      // Remove existing Extension Point if necessary
      LOOP: for (IPlatformExtensionPoint extensionPoint : existingPlatformBundle.getPlatformExtensionPoints(clazz)) {
        // should we remove extensionPoint ?
        for (IPlatformExtensionPoint newExtensionPoint : newPlatformBundle.getPlatformExtensionPoints(clazz)) {
          // TODO: PluginElement equals bug
          // https://bugs.eclipse.org/bugs/show_bug.cgi?id=267954
          try {
            if (extensionPoint.getPluginElement().equals(newExtensionPoint.getPluginElement())) {
              continue LOOP;
            }
          } catch (InvalidRegistryObjectException iroe) {
            // org.eclipse.core.internal.registry.RegistryObjectManager raised such exception when
            // an object is no longer valid. In such case we always discard it.
            break;
          }
        }
        // Remove ExtensionPoint from our existing model
        if (existingPlatformBundle.removePlatformExtensionPoint(clazz, extensionPoint) == false) {
          EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.mergePlatformBundle(..) _ ''{0}'' unable to remove Extension Point from PlatformBundle.", //$NON-NLS-1$
              extensionPoint));
        }
        // Remove ExtensionPoint from our target or workspace registry
        if (existingPlatformBundle.isTarget()) {
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
      // Add unknown Extension Point if necessary
      LOOP: for (IPlatformExtensionPoint newExtensionPoint : newPlatformBundle.getPlatformExtensionPoints(clazz)) {
        // should we add newExtensionPoint ?
        for (IPlatformExtensionPoint extensionPoint : existingPlatformBundle.getPlatformExtensionPoints(clazz)) {
          // TODO: PluginElement equals bug
          // https://bugs.eclipse.org/bugs/show_bug.cgi?id=267954
          if (extensionPoint.getPluginElement().equals(newExtensionPoint.getPluginElement())) {
            continue LOOP;
          }
        }
        // Add newExtensionPoint in our existing model
        newExtensionPoint = existingPlatformBundle.addPlatformExtensionPoint(clazz, newExtensionPoint.getPluginElement());
        if (newExtensionPoint == null) {
          continue;
        }
        // Add newExtensionPoint in our target or workspace registry
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
      if (existingPlatformBundle.equals(_platformBundles.remove(id)) == false) {
        EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformManager.mergePlatformBundle(..) _ ''{0}'' unknown PlatformBundle.", //$NON-NLS-1$
            id));
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
    for (Class<? extends IPlatformExtensionPoint> clazz : getExtensionPoints().values()) {
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
    for (Class<? extends IPlatformExtensionPoint> clazz : getExtensionPoints().values()) {
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
    // workspace models are always processed first, pde and jdt default
    // behaviour
    LOOP: for (IPluginModelBase model : entry.hasWorkspaceModels() ? entry.getWorkspaceModels() : entry.getExternalModels()) {
      if (model.getExtensions(false) == null || model.getExtensions(false).getExtensions() == null) {
        continue;
      }
      for (IPluginExtension extension : model.getExtensions(false).getExtensions()) {
        Class<? extends IPlatformExtensionPoint> clazz = getExtensionPoints().get(extension.getPoint());
        if (clazz != null) {
          plugins.add(model);
          // Only one known extension points is enough to further analyse such
          // model
          continue LOOP;
        }
      }
    }
    return plugins;
  }

  private void trace(IPlatformBundle[] platformBundles) {
    for (IPlatformBundle platformBundle : platformBundles) {
      EGFPlatformPlugin.getDefault().logInfo(platformBundle.toString(), 1);
      for (IPlatformExtensionPoint extensionPoint : platformBundle.getPlatformExtensionPoints()) {
        EGFPlatformPlugin.getDefault().logInfo("Contains: " + extensionPoint.toString(), 2); //$NON-NLS-1$
      }
    }
  }

  private void trace(IPlatformExtensionPointDelta delta) {
    if (delta.getRemovedPlatformExtensionPoints().length > 0) {
      EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager Removed {0} Extension Point{1}.", //$NON-NLS-1$ 
          delta.getRemovedPlatformExtensionPoints().length, delta.getRemovedPlatformExtensionPoints().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getRemovedPlatformExtensionPoints());
    }
    if (delta.getAddedPlatformExtensionPoints().length > 0) {
      EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformManager Added {0} Extension Point{1}.", //$NON-NLS-1$ 
          delta.getAddedPlatformExtensionPoints().length, delta.getAddedPlatformExtensionPoints().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getAddedPlatformExtensionPoints());
    }
  }

  private void trace(IPlatformExtensionPoint[] extensionPoints) {
    for (IPlatformExtensionPoint extensionPoint : extensionPoints) {
      EGFPlatformPlugin.getDefault().logInfo(extensionPoint.toString(), 1);
      EGFPlatformPlugin.getDefault().logInfo("From: " + extensionPoint.getPlatformBundle().toString(), 2); //$NON-NLS-1$
    }
  }

}
