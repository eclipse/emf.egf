/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.listener.AbstractProjectListener;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.data.helper.ModelHelper;


/**
 * A factory component registry contains factory components. <br>
 * It provides services to deal with contained elements.<br>
 * This registry is a singleton.
 * @see FactoryComponent
 * @author fournier
 */
public class FactoryComponentRegistry {
  /**
   * Singleton instance.
   */
  private static FactoryComponentRegistry __instance;
  /**
   * Loaded factory components.
   */
  Map<String, FactoryComponent> _factoryComponents;

  /**
   * Constructor.
   */
  private FactoryComponentRegistry() {
    _factoryComponents = new HashMap<String, FactoryComponent>(0);
    // Listener initialization.
    initializeListeners();
  }

  /**
   * Initialization of listeners.
   */
  private void initializeListeners() {
    // Register the factory component registry as a resource changed listener.
    // The goal is to be notified when the a project is deleted or closed by the end-user.
    ResourcesPlugin.getWorkspace().addResourceChangeListener(new ProjectListener());
  }

  /**
   * Get the unique instance.
   * @return a not null instance.
   */
  public synchronized static FactoryComponentRegistry getInstance() {
    if (null == __instance) {
      __instance = new FactoryComponentRegistry();
    }
    return __instance;
  }

  /**
   * Get a factory component for given factory component id.
   * @param factoryComponentId_p
   * @return an {@link FactoryComponent} instance or null if not found.
   */
  public synchronized FactoryComponent getFactoryComponent(String factoryComponentId_p) {
    return _factoryComponents.get(factoryComponentId_p);
  }

  /**
   * Remove a factory component with its given id.
   * @param factoryComponentId_p
   * @return the removed factory component or null if not found.
   */
  public synchronized FactoryComponent removeFactoryComponent(String factoryComponentId_p) {
    return _factoryComponents.remove(factoryComponentId_p);
  }

  /**
   * Remove given collection of factory components from contained factory components.
   * @param factoryComponents_p components_p
   */
  public synchronized boolean removeFactoryComponents(Collection<FactoryComponent> factoryComponents_p) {
    return _factoryComponents.values().removeAll(factoryComponents_p);
  }

  /**
   * Add a factory component for given parameters.
   * @param factoryComponentId_p
   * @param factoryComponent_p
   */
  public synchronized void addFactoryComponent(String factoryComponentId_p, FactoryComponent factoryComponent_p) {
    _factoryComponents.put(factoryComponentId_p, factoryComponent_p);
  }

  /**
   * Return a shallow copy of contained factory components.
   * @return a not null {@link List}.
   */
  public synchronized List<FactoryComponent> getFactoryComponents() {
    return new ArrayList<FactoryComponent>(_factoryComponents.values());
  }

  /**
   * Implement a project listener to be able to remove the factory components for removed projects from the workspace.
   * @author Guillaume Brocard
   */
  class ProjectListener extends AbstractProjectListener {

    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectAdded(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectAdded(IProject project_p, IResourceDelta resourceDelta_p) {
      // Do nothing.
    }

    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectChanged(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectChanged(IProject project_p, IResourceDelta resourceDelta_p) {
      // Do nothing.
    }

    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectRemoved(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectRemoved(IProject project_p, IResourceDelta resourceDelta_p) {
      // Remove the related factory component from the factory component registry if any.
      Iterator<FactoryComponent> iteratorOverFcs = _factoryComponents.values().iterator();
      boolean removed = false;
      // Iterate to remove the related factory component if existing.
      while (iteratorOverFcs.hasNext() && !removed) {
        // Get the current model element.
        FactoryComponent currentFc = iteratorOverFcs.next();
        // Get the plug-in model associated to this factory component if any.
        IProject currentFcProject = ModelHelper.getProject(currentFc);
        // Check if given project is the one that hosts the current factory component (can have no project if the factory component is coming from the target platform).
        if (project_p == currentFcProject) {
          removed = true;
          // Remove it from the registry.
          iteratorOverFcs.remove();
        }
      }
    }

    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectClosed(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectClosed(IProject project_p, IResourceDelta resourceDelta_p) {
      handleProjectRemoved(project_p, resourceDelta_p);
    }
  }
}