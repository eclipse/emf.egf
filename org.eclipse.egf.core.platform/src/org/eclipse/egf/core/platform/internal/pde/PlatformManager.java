/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */

package org.eclipse.egf.core.platform.internal.pde;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IFactoryComponentConstants;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponentDelta;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponentListener;
import org.eclipse.egf.core.platform.pde.IPlatformPlugin;
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
public final class PlatformManager implements IPluginModelListener, IExtensionDeltaListener {

  private static volatile PlatformManager __platformManager;

  // Use a lock object, this will prevent us against
  // a lock against the PlatformManager instance
  private static Object _lock = new Object();

  public static PlatformManager getInstance() {
    if (__platformManager == null) {
      synchronized (_lock) {
        __platformManager = new PlatformManager();
      }
    }
    return __platformManager;
  }

  // IPlatformPlugin registry
  private volatile Map<String, IPlatformPlugin> _models;

  // IPlatformFactoryComponent Target platform registry
  private List<IPlatformFactoryComponent> _workspace;

  // IPlatformFactoryComponent Workspace registry
  private List<IPlatformFactoryComponent> _target;

  // A list of listeners interested in changes to the plug-in factory components
  // models
  private List<IPlatformFactoryComponentListener> _listeners;

  private PlatformManager() {
    // Nothing to do
  }

  public void dispose() {
    PDECore.getDefault().getModelManager().removePluginModelListener(this);
    PDECore.getDefault().getModelManager().removeExtensionDeltaListener(this);
    _models = null;
    _target = null;
    _workspace = null;
    _listeners = null;
  }

  public IPlatformPlugin[] getPlatformPlugins() {
    // Lock PlatformManager
    synchronized (_lock) {
      if (_models == null) {
        initializePlatformPlugin();
      }
      // Create a copy of known values
      IPlatformPlugin[] platformModels = _models.values().toArray(new IPlatformPlugin[_models.size()]);
      // Return
      return platformModels;
    }
  }

  public IPlatformFactoryComponent[] getWorkspaceFactoryComponents() {
    // Lock PlatformManager
    synchronized (_lock) {
      if (_models == null) {
        initializePlatformPlugin();
      }
      // Return
      return _workspace.toArray(new IPlatformFactoryComponent[_workspace.size()]);
    }
  }

  public IPlatformFactoryComponent[] getTargetFactoryComponents() {
    // Lock PlatformManager
    synchronized (_lock) {
      if (_models == null) {
        initializePlatformPlugin();
      }
      // Return
      return _target.toArray(new IPlatformFactoryComponent[_target.size()]);
    }
  }

  public IPlatformFactoryComponent[] getFactoryComponents() {
    // Lock PlatformManager
    synchronized (_lock) {
      if (_models == null) {
        initializePlatformPlugin();
      }
      // Create a copy of known values
      IPlatformFactoryComponent[] targetFCs = getTargetFactoryComponents();
      IPlatformFactoryComponent[] workspaceFCs = getWorkspaceFactoryComponents();
      IPlatformFactoryComponent[] fcs = new IPlatformFactoryComponent[targetFCs.length + workspaceFCs.length];
      System.arraycopy(targetFCs, 0, fcs, 0, targetFCs.length);
      System.arraycopy(workspaceFCs, 0, fcs, targetFCs.length, workspaceFCs.length);
      // Return
      return fcs;
    }
  }

  private void initializePlatformPlugin() {
    if (_models != null) {
      return;
    }
    // Initialize listeners
    PDECore.getDefault().getModelManager().addPluginModelListener(this);
    PDECore.getDefault().getModelManager().addExtensionDeltaListener(this);
    // Create our registry
    _models = new TreeMap<String, IPlatformPlugin>();
    _workspace = new ArrayList<IPlatformFactoryComponent>();
    _target = new ArrayList<IPlatformFactoryComponent>();
    for (IPluginModelBase base : PluginRegistry.getActiveModels(true)) {
      addModel(EGFPlatformPlugin.getId(base), createPlatformPlugin(base), null);
    }
    // Debug
    if (EGFPlatformPlugin.getDefault().isDebugging()) {
      if (_models.size() > 0) {
        EGFConsolePlugin.getConsole().logInfo(NLS.bind("PlatformManager.initializePlatformPlugin(..) _ found {0} Platform Plugin Model{1}", //$NON-NLS-1$ 
            _models.size(), _models.size() < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
        ));
      }
      trace(getPlatformPlugins());
    }
  }

  /**
   * Notify all interested listeners in changes made to the models table
   * 
   * @param delta
   *          the delta of changes
   */
  private void firePlatformFactoryComponent(IPlatformFactoryComponentDelta delta) {
    if (_listeners != null) {
      for (IPlatformFactoryComponentListener listener : _listeners) {
        listener.factoryComponentChanged(delta);
      }
    }
  }

  /**
   * Add a listener to the platform manager
   * 
   * @param listener
   *          the listener to be added
   */
  public void addPlatformFactoryComponentListener(IPlatformFactoryComponentListener listener) {
    if (_listeners == null) {
      _listeners = new ArrayList<IPlatformFactoryComponentListener>();
    }
    if (_listeners.contains(listener) == false) {
      _listeners.add(listener);
    }
  }

  /**
   * Remove a listener from the platform manager
   * 
   * @param listener
   *          the listener to be removed
   */
  public void removePlatformFactoryComponentListener(IPlatformFactoryComponentListener listener) {
    if (_listeners == null) {
      return;
    }
    _listeners.remove(listener);
  }

  /**
   * Process extension delta event This method is called when listeners are
   * initialized.
   * 
   * @see {@link org.eclipse.egf.core.platform.internal.pde.PlatformManager#getPlatformPlugins()}
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
      PlatformFactoryComponentDelta delta = new PlatformFactoryComponentDelta();
      // Process Removed Entries
      for (IPluginModelBase base : event.getRemovedModels()) {
        String id = EGFPlatformPlugin.getId(base);
        IPlatformPlugin existing = _models.get(id);
        if (existing != null && base.equals(existing.getPluginModelBase())) {
          removeModel(id, _models.get(id), delta);
        }
      }
      // Process Changed Entries
      for (IPluginModelBase base : event.getChangedModels()) {
        handleChange(base, delta);
      }
      // Process Added Entries
      for (IPluginModelBase base : event.getAddedModels()) {
        addModel(EGFPlatformPlugin.getId(base), createPlatformPlugin(base), delta);
      }
      // Something to process
      if (delta.isEmpty() == false) {
        // Debug
        if (EGFPlatformPlugin.getDefault().isDebugging()) {
          trace(delta);
        }
        // Notify all interested listeners in the changes made to models
        firePlatformFactoryComponent(delta);
      }
    }
  }

  /**
   * Process model delta event This method is called when listeners are
   * initialized.
   * 
   * @see {@link org.eclipse.egf.core.platform.internal.pde.PlatformManager#getPlatformPlugins()}
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
      PlatformFactoryComponentDelta delta = new PlatformFactoryComponentDelta();
      // Process Removed Entries
      if ((event.getKind() & PluginModelDelta.REMOVED) != 0) {
        for (ModelEntry entry : event.getRemovedEntries()) {
          String id = EGFPlatformPlugin.getId(entry);
          removeModel(id, _models.get(id), delta);
        }
      }
      // Process Changed Entries
      if ((event.getKind() & PluginModelDelta.CHANGED) != 0) {
        for (ModelEntry entry : event.getChangedEntries()) {
          for (IPluginModelBase base : getFactoryComponentsModels(entry)) {
            handleChange(base, delta);
          }
        }
      }
      // Process Added Entries
      if ((event.getKind() & PluginModelDelta.ADDED) != 0) {
        for (ModelEntry entry : event.getAddedEntries()) {
          for (IPluginModelBase base : getFactoryComponentsModels(entry)) {
            addModel(EGFPlatformPlugin.getId(base), createPlatformPlugin(base), delta);
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
        firePlatformFactoryComponent(delta);
      }
    }
  }

  private PlatformPlugin createPlatformPlugin(IPluginModelBase base) {
    // Always create a model
    PlatformPlugin model = new PlatformPlugin(base);
    // Process extension point
    for (IPluginExtension extension : base.getExtensions(false).getExtensions()) {
      if (IFactoryComponentConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID.equals(extension.getPoint())) {
        model.addPlatformFactoryComponent(extension);
      }
    }
    return model;
  }

  private void handleChange(IPluginModelBase base, PlatformFactoryComponentDelta delta) {
    String id = EGFPlatformPlugin.getId(base);
    // Check an existing one
    IPlatformPlugin existingModel = _models.get(id);
    if (base.isEnabled()) {
      if (existingModel != null && base.equals(existingModel.getPluginModelBase())) {
        mergeModel(id, createPlatformPlugin(base), delta);
      } else {
        if (base.equals(existingModel.getPluginModelBase()) == false) {
          removeModel(id, existingModel, delta);
        }
        addModel(id, createPlatformPlugin(base), delta);
      }
    } else {
      removeModel(id, existingModel, delta);
    }
  }

  private void mergeModel(String id, IPlatformPlugin newModel, PlatformFactoryComponentDelta delta) {
    if (id == null || newModel == null) {
      return;
    }
    // Retrieve an existing one
    IPlatformPlugin existingModel = _models.get(id);
    if (existingModel == null) {
      return;
    }
    // Analyse Removed Factory Components
    LOOP: for (IPlatformFactoryComponent fc : existingModel.getPlatformFactoryComponents()) {
      // Analyse model
      for (IPlatformFactoryComponent newFc : newModel.getPlatformFactoryComponents()) {
        if (newFc.getURI().equals(fc.getURI())) {
          continue LOOP;
        }
      }
      // Remove factory component from our existing model
      if (existingModel.removePlatformFactoryComponent(fc) == false) {
        String msg = NLS.bind("PlatformManager.mergeModel(..) _ ''{0}'' unable to remove Factory Component from existingModel.", //$NON-NLS-1$
            fc.getURI());
        EGFPlatformPlugin.getDefault().log(msg);
        if (EGFPlatformPlugin.getDefault().isDebugging()) {
          EGFConsolePlugin.getConsole().logError(msg);
        }
      }
      // Remove factory component in our target or workspace registry
      if (existingModel.isTarget()) {
        if (_target.remove(fc) == false) {
          String msg = NLS.bind("PlatformManager.mergeModel(..) _ ''{0}'' unable to remove Factory Component from target registry.", //$NON-NLS-1$
              fc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logError(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeRemovedPlatformFactoryComponent(fc);
          }
        }
      } else {
        if (_workspace.remove(fc) == false) {
          String msg = NLS.bind("PlatformManager.mergeModel(..) _ ''{0}'' unable to remove Factory Component from workspace registry.", //$NON-NLS-1$
              fc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logError(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeRemovedPlatformFactoryComponent(fc);
          }
        }
      }
    }
    // Analyse Added Factory Components
    LOOP: for (IPlatformFactoryComponent newFc : newModel.getPlatformFactoryComponents()) {
      // analyse model
      for (IPlatformFactoryComponent fc : existingModel.getPlatformFactoryComponents()) {
        if (fc.getURI().equals(newFc.getURI())) {
          continue LOOP;
        }
      }
      // add a new factory component in our existing model
      newFc = existingModel.addPlatformFactoryComponent(newFc.getPluginElement());
      if (newFc == null) {
        continue;
      }
      // add factory component in our target or workspace registry
      if (existingModel.isTarget()) {
        if (_target.add(newFc) == false) {
          String msg = NLS.bind("PlatformManager.mergeModel(..) _ ''{0}'' unable to add Factory Component in target registry.", //$NON-NLS-1$
              newFc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logError(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeAddedPlatformFactoryComponent(newFc);
          }
        }
      } else {
        if (_workspace.add(newFc) == false) {
          String msg = NLS.bind("PlatformManager.mergeModel(..) _ ''{0}'' unable to add Factory Component in workspace registry.", //$NON-NLS-1$
              newFc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logError(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeAddedPlatformFactoryComponent(newFc);
          }
        }
      }
    }
    // Finally remove existingModel if necessary
    if (existingModel.getPlatformFactoryComponents().length == 0) {
      // remove model from our main registry
      if (existingModel.equals(_models.remove(id)) == false) {
        String msg = NLS.bind("PlatformManager.mergeModel(..) _ ''{0}'' unknown model to remove.", //$NON-NLS-1$
            id);
        EGFPlatformPlugin.getDefault().log(msg);
        if (EGFPlatformPlugin.getDefault().isDebugging()) {
          EGFConsolePlugin.getConsole().logError(msg);
        }
      }
    }
  }

  private void removeModel(String id, IPlatformPlugin model, PlatformFactoryComponentDelta delta) {
    if (id == null || model == null) {
      return;
    }
    // Remove model from our main registry
    if (model.equals(_models.remove(id)) == false) {
      String msg = NLS.bind("PlatformManager.removeModel(..) _ ''{0}'' unknown model to remove.", //$NON-NLS-1$
          id);
      EGFPlatformPlugin.getDefault().log(msg);
      if (EGFPlatformPlugin.getDefault().isDebugging()) {
        EGFConsolePlugin.getConsole().logError(msg);
      }
    }
    // Process Factory Component
    for (IPlatformFactoryComponent fc : model.getPlatformFactoryComponents()) {
      // remove factory component in our target or workspace registry
      if (model.isTarget()) {
        if (_target.remove(fc) == false) {
          String msg = NLS.bind("PlatformManager.removeModel(..) _ ''{0}'' unable to remove Factory Component from target registry.", //$NON-NLS-1$
              fc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logError(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeRemovedPlatformFactoryComponent(fc);
          }
        }
      } else {
        if (_workspace.remove(fc) == false) {
          String msg = NLS.bind("PlatformManager.removeModel(..) _ ''{0}'' unable to remove Factory Component from workspace registry.", //$NON-NLS-1$
              fc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logError(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeRemovedPlatformFactoryComponent(fc);
          }
        }
      }
    }
  }

  private void addModel(String id, IPlatformPlugin model, PlatformFactoryComponentDelta delta) {
    if (id == null || model == null || model.getPlatformFactoryComponents().length == 0) {
      return;
    }
    // Add model from our main registry
    if (_models.put(id, model) != null) {
      String msg = NLS.bind("PlatformManager.addModel(..) _ Bundle ''{0}'' contains a duplicate Model.", //$NON-NLS-1$
          id);
      EGFPlatformPlugin.getDefault().log(msg);
      if (EGFPlatformPlugin.getDefault().isDebugging()) {
        EGFConsolePlugin.getConsole().logWarning(msg);
        EGFConsolePlugin.getConsole().logWarning(new String("The previous Model has been discarded."), 1);
      }
    }
    // Process Factory Component
    for (IPlatformFactoryComponent fc : model.getPlatformFactoryComponents()) {
      // add factory component in our target or workspace registry
      if (model.isTarget()) {
        if (_target.add(fc) == false) {
          String msg = NLS.bind("PlatformManager.addModel(..) _ ''{0}'' unable to add Factory Component in target registry.", //$NON-NLS-1$
              fc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logWarning(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeAddedPlatformFactoryComponent(fc);
          }
        }
      } else {
        if (_workspace.add(fc) == false) {
          String msg = NLS.bind("PlatformManager.addModel(..) _ ''{0}'' unable to add Factory Component in workspace registry.", //$NON-NLS-1$
              fc.getURI());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logError(msg);
          }
        } else {
          // Update delta
          if (delta != null) {
            delta.storeAddedPlatformFactoryComponent(fc);
          }
        }
      }
    }
  }

  private List<IPluginModelBase> getFactoryComponentsModels(ModelEntry entry) {
    List<IPluginModelBase> plugins = new UniqueEList<IPluginModelBase>();
    // workspace models are always processed first, pde and jdt default
    // behaviour
    LOOP: for (IPluginModelBase model : entry.hasWorkspaceModels() ? entry.getWorkspaceModels() : entry.getExternalModels()) {
      if (model.getExtensions(false) == null || model.getExtensions(false).getExtensions() == null) {
        continue;
      }
      for (IPluginExtension extension : model.getExtensions(false).getExtensions()) {
        if (IFactoryComponentConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID.equals(extension.getPoint())) {
          plugins.add(model);
          continue LOOP;
        }
      }
    }
    return plugins;
  }

  private void trace(IPlatformPlugin[] models) {
    for (IPlatformPlugin model : models) {
      EGFConsolePlugin.getConsole().logWarning(model.toString(), 1);
      for (IPlatformFactoryComponent factoryComponent : model.getPlatformFactoryComponents()) {
        EGFConsolePlugin.getConsole().logWarning("Contains: " + factoryComponent.toString(), 2); //$NON-NLS-1$
      }
    }
  }

  private void trace(IPlatformFactoryComponentDelta delta) {
    if (delta.getRemovedPlatformFactoryComponents().length > 0) {
      EGFConsolePlugin.getConsole().logInfo(NLS.bind("PlatformManager Removed {0} Factory Component{1}.", //$NON-NLS-1$ 
          delta.getRemovedPlatformFactoryComponents().length, delta.getRemovedPlatformFactoryComponents().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getRemovedPlatformFactoryComponents());
    }
    if (delta.getAddedPlatformFactoryComponents().length > 0) {
      EGFConsolePlugin.getConsole().logInfo(NLS.bind("PlatformManager Added {0} Factory Component{1}.", //$NON-NLS-1$ 
          delta.getAddedPlatformFactoryComponents().length, delta.getAddedPlatformFactoryComponents().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getAddedPlatformFactoryComponents());
    }
  }

  private void trace(IPlatformFactoryComponent[] factoryComponents) {
    for (IPlatformFactoryComponent factoryComponent : factoryComponents) {
      EGFConsolePlugin.getConsole().logWarning(factoryComponent.toString(), 1);
      EGFConsolePlugin.getConsole().logWarning("From: " + factoryComponent.getPlatformPlugin().toString(), 2); //$NON-NLS-1$
    }
  }

}
