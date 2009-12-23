/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde.internal.resource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.helper.StatusHelper;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IFactoryComponentConstants;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.core.platform.resource.IResourceFactoryComponentDelta;
import org.eclipse.egf.core.platform.resource.IResourceFactoryComponentListener;
import org.eclipse.egf.pde.EGFPDEPlugin;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentResourceListener implements IResourceChangeListener {

  /*
   * Type of event that should be processed no matter what the real event type
   * is.
   */
  public int _overridenEventType = -1;

  // A list of listeners interested in changes to factory components resources
  private List<IResourceFactoryComponentListener> _listeners;

  public FactoryComponentResourceListener() {
    ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
  }

  /**
   * Notify all interested listeners in changes made to the factory components
   * resource
   * 
   * @param delta
   *          the delta of changes
   */
  private void fireResourceFactoryComponent(IResourceFactoryComponentDelta delta) {
    if (_listeners != null) {
      for (IResourceFactoryComponentListener listener : _listeners) {
        listener.factoryComponentChanged(delta);
      }
    }
  }

  /**
   * Add a listener
   * 
   * @param listener
   *          the listener to be added
   */
  public void addResourceFactoryComponentListener(IResourceFactoryComponentListener listener) {
    if (_listeners == null) {
      _listeners = new ArrayList<IResourceFactoryComponentListener>();
    }
    if (_listeners.contains(listener) == false) {
      _listeners.add(listener);
    }
  }

  /**
   * Remove a listener
   * 
   * @param listener
   *          the listener to be removed
   */
  public void removeResourceFactoryComponentListener(IResourceFactoryComponentListener listener) {
    if (_listeners == null) {
      return;
    }
    _listeners.remove(listener);
  }

  /**
   * This listens for workspace changes.
   */

  public void resourceChanged(IResourceChangeEvent event) {

    int eventType = _overridenEventType == -1 ? event.getType() : _overridenEventType;

    try {

      final class ResourceDeltaVisitor implements IResourceDeltaVisitor {

        protected ResourceFactoryComponentDelta deltaFcs = new ResourceFactoryComponentDelta();

        protected Collection<IResource> addedFcs = new ArrayList<IResource>();

        protected Collection<IPlatformFactoryComponent> removedFcs = new ArrayList<IPlatformFactoryComponent>();

        public boolean visit(IResourceDelta delta) throws CoreException {

          IResource resource = delta.getResource();

          // Analyse projects
          if (resource.getType() == IResource.PROJECT || delta.getFlags() == IResourceDelta.MARKERS) {
            // Added resource
            if (delta.getKind() == IResourceDelta.ADDED) {
              // Project is renamed, do not look further
              if ((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
                return false;
              }
            } else if (delta.getKind() == IResourceDelta.CHANGED) {
              // Project is opened or closed
              if ((delta.getFlags() & IResourceDelta.OPEN) != 0) {
                return false;
              }
            }
            return true;
          }

          // Analyse further all other artifacts
          if (resource.getType() != IResource.FILE || delta.getFlags() == IResourceDelta.MARKERS) {
            return true;
          }

          if (delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED || delta.getKind() == IResourceDelta.ADDED) {
            if (resource.getFileExtension().equals(IFactoryComponentConstants.FACTORY_COMPONENT_FILE_EXTENSION)) {
              try {
                IPluginModelBase base = EGFPlatformPlugin.getPluginModelBase(resource.getProject());
                if (base != null) {
                  // Build a Resource URI
                  URI resourceURI = URI.createPlatformPluginURI(EGFPlatformPlugin.getId(base) + "/" + resource.getFullPath().removeFirstSegments(1).toString(), //$NON-NLS-1$ 
                      true);
                  // Removed resource
                  if (delta.getKind() == IResourceDelta.REMOVED) {
                    for (IPlatformFactoryComponent fc : EGFPlatformPlugin.getDefault().getWorkspacePluginFactoryComponents()) {
                      if (fc.getURI().equals(resourceURI)) {
                        removedFcs.add(fc);
                        if ((delta.getFlags() & IResourceDelta.MOVED_TO) == 0) {
                          deltaFcs.storeRemovedResourceFactoryComponent(resourceURI);
                        }
                        break;
                      }
                    }
                    // Added resource
                  } else if (delta.getKind() == IResourceDelta.ADDED) {
                    addedFcs.add(resource);
                    if ((delta.getFlags() & IResourceDelta.MOVED_FROM) == 0) {
                      deltaFcs.storeAddedResourceFactoryComponent(resourceURI);
                    } else {
                      IProject fromProject = ProjectHelper.getProject(delta.getMovedFromPath().segment(0));
                      IPluginModelBase fromBase = EGFPlatformPlugin.getPluginModelBase(fromProject);
                      if (fromBase != null) {
                        // Build a Resource URI
                        URI fromURI = URI.createPlatformPluginURI(EGFPlatformPlugin.getId(fromBase) + "/" + delta.getMovedFromPath().removeFirstSegments(1).toString(), //$NON-NLS-1$ 
                            true);
                        deltaFcs.storeMovedResourceFactoryComponent(resourceURI, fromURI);
                      }
                    }
                    // Changed resource
                  } else if (delta.getKind() == IResourceDelta.CHANGED) {
                    if ((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
                      deltaFcs.storeChangedResourceFactoryComponent(resourceURI);
                    }
                  }
                }
              } catch (IllegalArgumentException iae) {
                String msg = new String("PlatformManager.ResourceDeltaVisitor.visit(..) _ "); //$NON-NLS-1$
                EGFPlatformPlugin.getDefault().log(msg, iae);
                if (EGFPlatformPlugin.getDefault().isDebugging()) {
                  EGFConsolePlugin.getConsole().logThrowable(msg, iae);
                }
              }
            }
          }

          return true;

        }

        public Collection<IPlatformFactoryComponent> getRemovedFactoryComponents() {
          return removedFcs;
        }

        public Collection<IResource> getAddedFactoryComponents() {
          return addedFcs;
        }

        public ResourceFactoryComponentDelta getFactoryComponentsDelta() {
          return deltaFcs;
        }

      }

      switch (eventType) {
      case IResourceChangeEvent.POST_CHANGE:
        final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
        event.getDelta().accept(visitor);
        // Process added and removed resources
        if (visitor.getRemovedFactoryComponents().isEmpty() == false || visitor.getAddedFactoryComponents().isEmpty() == false) {
          final IStatus[] errorStatus = new IStatus[1];
          errorStatus[0] = Status.OK_STATUS;
          final IRunnableWithProgress op = createFactoryComponentOperation(errorStatus, visitor.getRemovedFactoryComponents(), visitor.getAddedFactoryComponents());
          WorkspaceJob job = new WorkspaceJob("update") { //$NON-NLS-1$
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
              try {
                op.run(monitor);
              } catch (InvocationTargetException e) {
                String msg = NLS.bind(InternalResourcesMessages.PluginModelUpdate_logTitle, getClass().getName(), e.getTargetException());
                throw new CoreException(StatusHelper.newStatus(IStatus.ERROR, msg, e.getTargetException()));
              } catch (InterruptedException e) {
                return Status.CANCEL_STATUS;
              }
              return errorStatus[0];
            }

          };
          job.setUser(true);
          job.schedule();
        }
        // Broadcast events
        // Something to process
        if (visitor.getFactoryComponentsDelta().isEmpty() == false) {
          // Debug
          if (EGFPDEPlugin.getDefault().isDebugging()) {
            trace(visitor.getFactoryComponentsDelta());
          }
          // Notify all interested listeners in the changes made to models
          fireResourceFactoryComponent(visitor.getFactoryComponentsDelta());
        }
      }

    } catch (CoreException ce) {
      String msg = new String("PlatformManager.ResourceDeltaVisitor.resourceChanged(..) _"); //$NON-NLS-1$
      EGFPDEPlugin.getDefault().log(msg, ce);
      if (EGFPDEPlugin.getDefault().isDebugging()) {
        EGFConsolePlugin.getConsole().logThrowable(msg, ce);
      }
    }

  }

  public void dispose() {
    ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
    _listeners = null;
  }

  final protected IRunnableWithProgress createFactoryComponentOperation(final IStatus[] errorStatus, final Collection<IPlatformFactoryComponent> removedFCs, final Collection<IResource> addedFCs) {
    return new IRunnableWithProgress() {
      public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        MultiStatus errors = null;
        monitor.beginTask("", (removedFCs.size() + addedFCs.size()) * 1000); //$NON-NLS-1$
        monitor.setTaskName(InternalResourcesMessages.PluginModelUpdate_progressMessage);
        try {
          // Removed FCs
          for (IPlatformFactoryComponent fc : removedFCs) {
            // Delete an extension point
            IPluginChangesCommand unsetCommand = EGFPDEPlugin.getFactoryComponentExtensionHelper().unsetFactoryComponentExtension(fc.getURI());
            IPluginChangesCommandRunner runner = EGFPDEPlugin.getPluginChangesCommandRunner();
            runner.performChangesOnPlugin(fc.getPlatformPlugin().getId(), Collections.singletonList(unsetCommand));
            monitor.worked(1000);
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          }
          // Added FCs
          for (IResource resource : addedFCs) {
            // Create an extension point
            IPluginChangesCommand createCommand = EGFPDEPlugin.getFactoryComponentExtensionHelper().setFactoryComponentExtension(URI.createURI(resource.getFullPath().removeFirstSegments(1).makeRelative().toString()));
            IPluginChangesCommandRunner runner = EGFPDEPlugin.getPluginChangesCommandRunner();
            // Locate the bundleId
            String bundleId = null;
            IPluginModelBase base = EGFPlatformPlugin.getPluginModelBase(resource.getProject());
            if (base != null) {
              bundleId = EGFPlatformPlugin.getId(base);
            }
            if (bundleId == null) {
              bundleId = resource.getProject().getName();
            }
            runner.performChangesOnPlugin(bundleId, Collections.singletonList(createCommand));
            monitor.worked(1000);
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          }
          if (errors != null) {
            errorStatus[0] = errors;
          }
        } finally {
          monitor.done();
        }
      }
    };
  }

  private void trace(IResourceFactoryComponentDelta delta) {
    if (delta.getRemovedResourceFactoryComponents().length > 0) {
      EGFConsolePlugin.getConsole().logInfo(NLS.bind("FactoryComponentResourceListener Removed {0} Factory Component{1}.", //$NON-NLS-1$ 
          delta.getRemovedResourceFactoryComponents().length, delta.getRemovedResourceFactoryComponents().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getRemovedResourceFactoryComponents(), null);
    }
    if (delta.getAddedResourceFactoryComponents().length > 0) {
      EGFConsolePlugin.getConsole().logInfo(NLS.bind("FactoryComponentResourceListener Added {0} Factory Component{1}.", //$NON-NLS-1$ 
          delta.getAddedResourceFactoryComponents().length, delta.getAddedResourceFactoryComponents().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getAddedResourceFactoryComponents(), null);
    }
    if (delta.getChangedResourceFactoryComponents().length > 0) {
      EGFConsolePlugin.getConsole().logInfo(NLS.bind("FactoryComponentResourceListener Changed {0} Factory Component{1}.", //$NON-NLS-1$ 
          delta.getChangedResourceFactoryComponents().length, delta.getChangedResourceFactoryComponents().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getChangedResourceFactoryComponents(), null);
    }
    if (delta.getMovedResourceFactoryComponents().length > 0) {
      EGFConsolePlugin.getConsole().logInfo(NLS.bind("FactoryComponentResourceListener Moved {0} Factory Component{1}.", //$NON-NLS-1$ 
          delta.getMovedResourceFactoryComponents().length, delta.getMovedResourceFactoryComponents().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getMovedResourceFactoryComponents(), delta);
    }
  }

  private void trace(URI[] uris, IResourceFactoryComponentDelta delta) {
    for (URI uri : uris) {
      EGFConsolePlugin.getConsole().logWarning(uri.toString(), 1);
      if (delta != null) {
        EGFConsolePlugin.getConsole().logWarning("From: " + delta.getMovedFromResourceFactoryComponent(uri), 2); //$NON-NLS-1$
      }
    }
  }

}
