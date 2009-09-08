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
package org.eclipse.egf.core.ui.viewers.explorer;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.listener.AbstractProjectListener;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentInWorkspace;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSetManager;
import org.eclipse.egf.core.ui.viewers.AbstractAdaptedModelElementContentProvider;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.progress.UIJob;


/**
 * Content provider implementation used to display factory components in an "Factory Component Project Explorer" view for instance.
 * @author fournier
 */
public class FactoryComponentExplorerContentProvider extends AbstractAdaptedModelElementContentProvider {
  /**
   * Reference to a project listener.
   */
  private AbstractProjectListener _projectListener;

  /**
   * Constructor.
   */
  public FactoryComponentExplorerContentProvider() {
    super();
    // Used to listen to factory component creation.
    _projectListener = new ProjectListener();
    // Register this content provider as resource change listener on workspace to be notified when projects are added, removed, ...
    ResourcesPlugin.getWorkspace().addResourceChangeListener(_projectListener);
  }

  /**
   * @see org.eclipse.egf.core.ui.viewers.AbstractAdaptedModelElementContentProvider#getAdapterFactory()
   */
  @Override
  protected AdapterFactory getAdapterFactory() {
    return EgfUiActivator.getDefault().getEditingDomain().getAdapterFactory();
  }

  /**
   * @see org.eclipse.egf.core.ui.viewers.AbstractAdaptedModelElementContentProvider#dispose()
   */
  @Override
  public void dispose() {
    super.dispose();
    // Unregister this content provider as resource change listener on workspace.
    ResourcesPlugin.getWorkspace().removeResourceChangeListener(_projectListener);
  }

  /**
   * Return the factory component in workspace.
   * @return
   */
  protected FactoryComponentInWorkspace getFactoryComponentInWorkspace() {
    return (FactoryComponentInWorkspace) EgfUiActivator.getDefault().getFactoryComponentInWorkspaceInput();
  }

  /**
   * Add given project (if it contains a factory component) as a factory component.
   * @param addedProject_p
   */
  protected void addProject(final IProject addedProject_p) {
    // Add given project through Job mechanism to ensure the workspace resource tree is not locked by another job.
    // Indeed, the EgfPdeActivator.getDefault().getFactoryComponent(addedProject_p) call reads data from IFile, and this one can be locked for modifications.
    // It was typically the case when converting an existing plug-in in a FC.
    // Ensure execution in the UI Thread.
    Job job = new UIJob(ICommonConstants.EMPTY_STRING) {
      /**
       * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      public IStatus runInUIThread(IProgressMonitor monitor_p) {
        if (null != addedProject_p) {
          final FactoryComponent factoryComponent = EgfPdeActivator.getDefault().getFactoryComponent(addedProject_p);
          if (null != factoryComponent) {
            // Add the newly created factory component to the factory component container.
            final FactoryComponentInWorkspace factoryComponentInWorkspace = getFactoryComponentInWorkspace();
            boolean fcIsAdded = factoryComponentInWorkspace.addFactoryComponent(factoryComponent);
            // If the factory component is newly added, add it to the viewer.
            if (fcIsAdded) {
              // Add it to the the viewer.
              final AbstractTreeViewer viewer = getViewer();
              Object parent = null;
              Object input = getInitialInput();
              if (input instanceof FactoryComponentInWorkspace) {
                // Project mode is selected.
                parent = input;
              } else {
                // Working set mode is selected, get the working set that hosts this project.
                parent = ((FactoryComponentWorkingSetManager) input).getParent(addedProject_p);
              }
              viewer.add(parent, factoryComponent);
              // Set the viewer selection on the newly created factory component.
              viewer.setSelection(new TreeSelection(new TreePath(new Object[] { parent, factoryComponent })), true);
            }
          }
        }
        return Status.OK_STATUS;
      }
    };
    job.setPriority(Job.SHORT);
    job.setSystem(true);
    // The job won't be run while other threads hold a conflicting rule.
    job.setRule(addedProject_p);
    job.schedule();
  }

  /**
   * Remove given project.
   * @param removeProject_p
   */
  protected void removeProject(IProject removeProject_p) {
    if (null != removeProject_p) {
      FactoryComponentInWorkspace factoryComponentInWorkspace = getFactoryComponentInWorkspace();
      Iterator<FactoryComponent> fcs = factoryComponentInWorkspace.getFactoryComponents().iterator();
      // Factory component to remove if any.
      FactoryComponent removedFactoryComponent = null;
      // Iterate over factory components contained in workspace.
      while (fcs.hasNext() && (null == removedFactoryComponent)) {
        FactoryComponent currentFactoryComponent = fcs.next();
        IProject currentFactoryComponentProject = ModelHelper.getProject(currentFactoryComponent);
        // Compare the removed project with the one related to the current factory component.
        if (currentFactoryComponentProject == removeProject_p) {
          removedFactoryComponent = currentFactoryComponent;
        }
      }
      // If a factory component to remove is found.
      if (null != removedFactoryComponent) {
        // Remove it from the initial input.
        factoryComponentInWorkspace.removeFactoryComponent(removedFactoryComponent);
        final FactoryComponent uiFactoryComponentToRemove = removedFactoryComponent;
        // UI removal operation must be performed into the SWT thread.
        final AbstractTreeViewer viewer = getViewer();
        // Ensure execution in the UI Thread.
        viewer.getControl().getDisplay().asyncExec(new Runnable() {
          public void run() {
            // Remove it from the viewer.
            viewer.remove(uiFactoryComponentToRemove);
          }
        });
      }
    }
  }

  /**
   * Implement a listener to add or remove factory component when the end-user add or remove factory component project.
   * @author Guillaume Brocard
   */
  class ProjectListener extends AbstractProjectListener {
    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectAdded(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectAdded(IProject project_p, IResourceDelta resourceDelta_p) {
      // Same behavior as project changed.
      handleProjectChanged(project_p, resourceDelta_p);
    }

    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectChanged(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectChanged(IProject project_p, IResourceDelta resourceDelta_p) {
      // Get the modified resources in the project.
      IResourceDelta[] projectFilesResourceDelta = resourceDelta_p.getAffectedChildren();
      // Looking for the plug-in file.
      for (IResourceDelta projectFileResourceDelta : projectFilesResourceDelta) {
        IResource projectFile = projectFileResourceDelta.getResource();
        // If plug-in file is detected, add the project.
        if (EgfPdeActivator.getDefault().isPluginFile(projectFile)) {
          addProject(project_p);
          break;
        }
      }
    }

    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectRemoved(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectRemoved(IProject project_p, IResourceDelta resourceDelta_p) {
      // Remove it ie the related factory component.
      removeProject(project_p);
    }

    /**
     * @see org.eclipse.egf.common.listener.AbstractProjectListener#handleProjectClosed(org.eclipse.core.resources.IProject,
     *      org.eclipse.core.resources.IResourceDelta)
     */
    @Override
    protected void handleProjectClosed(IProject project_p, IResourceDelta resourceDelta_p) {
      // Same behavior as project removed.
      handleProjectRemoved(project_p, resourceDelta_p);
    }
  }
}
