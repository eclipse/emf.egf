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
package org.eclipse.egf.core.ui.data.explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.internal.data.ModelElement;
import org.eclipse.ui.IWorkingSet;

/**
 * A working set that contains factory components
 * @author Guillaume Brocard
 */
public class FactoryComponentWorkingSet implements IAdaptable {
  /**
   * Reference to the related platform working set.
   */
  private IWorkingSet _workingSet;

  /**
   * Constructor.
   * @param workingSet_p
   */
  public FactoryComponentWorkingSet(IWorkingSet workingSet_p) {
    _workingSet = workingSet_p;
  }

  /**
   * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter_p) {
    Object adapter = Platform.getAdapterManager().getAdapter(this, adapter_p);
    return adapter;
  }

  /**
   * Get all existing factory components in the workspace.
   * @return the internal collection or an empty list if this later one is null.
   */
  public List<FactoryComponent> getFactoryComponents() {
    List<FactoryComponent> result = new ArrayList<FactoryComponent>(0);
    // Get all factory components located in the workspace.
    FactoryComponentInWorkspace fcsInWorkspace = (FactoryComponentInWorkspace) EgfUiActivator.getDefault().getFactoryComponentInWorkspaceInput();
    // Check if the current working set is related to "Other FCs" working set.
    FactoryComponentWorkingSetManager fcWorkingSetManager = (FactoryComponentWorkingSetManager) EgfUiActivator.getDefault().getWorkingSetsInput();
    FactoryComponentWorkingSet otherFc = fcWorkingSetManager.getOtherFcsWorkingSet();
    if (otherFc.equals(this)) {
      List<IProject> allProjectContainedInPublicWorkingSets = new ArrayList<IProject>(0);
      // Get all public working set.
      Collection<FactoryComponentWorkingSet> publicWorkingSets = fcWorkingSetManager.getPublicWorkingSets();
      // Iterates over public working sets to get all projects contained in public working sets.
      Iterator<FactoryComponentWorkingSet> iter = publicWorkingSets.iterator();
      while (iter.hasNext()) {
        FactoryComponentWorkingSet currentWorkingSet = iter.next();
        allProjectContainedInPublicWorkingSets.addAll(FactoryComponentWorkingSetManager.getProjects(currentWorkingSet.getWorkingSet().getElements()));
      }
      Iterator<FactoryComponent> iterOverFcs = fcsInWorkspace.getFactoryComponents().iterator();
      // Iterate over factory components in workspace.
      while (iterOverFcs.hasNext()) {
        FactoryComponent currentFc = iterOverFcs.next();
        // Get its project.
        IProject currentFcProject = (IProject) ((ModelElement) currentFc).getAdapter(IProject.class);
        // Is this project is not contained in the collected project list, default location is the "Other FCs" working set.
        if (!allProjectContainedInPublicWorkingSets.contains(currentFcProject)) {
          result.add(currentFc);
        }
      }
    } else {
      // We must not compute only once the factory components contained in a working set, because the end-user can rearrange them through the Package Explorer view.
      // Let's retrieve factory components contained in this working set.
      IAdaptable[] elements = _workingSet.getElements();
      // Get Java projects contained in this working set.
      List<IProject> projects = FactoryComponentWorkingSetManager.getProjects(elements);
      Iterator<FactoryComponent> iter = fcsInWorkspace.getFactoryComponents().iterator();
      if (!projects.isEmpty()) {
        // Iterate over all factory components in the workspace to retrieve the ones owned by the current working set as Java Project.
        while (iter.hasNext()) {
          FactoryComponent currentFc = iter.next();
          // Get its project.
          IProject currentFcProject = (IProject) ((ModelElement) currentFc).getAdapter(IProject.class);
          // Is this project contained in the current platform working set ?
          if (projects.contains(currentFcProject)) {
            result.add(currentFc);
          }
        }
      }
    }
    return result;
  }

  /**
   * Get the related platform working set.
   * @return the workingSet
   */
  public IWorkingSet getWorkingSet() {
    return _workingSet;
  }
}
