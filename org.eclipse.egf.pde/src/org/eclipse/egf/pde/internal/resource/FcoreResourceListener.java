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
package org.eclipse.egf.pde.internal.resource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.StatusHelper;
import org.eclipse.egf.common.uri.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IFcoreConstants;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IResourceFcoreDelta;
import org.eclipse.egf.core.fcore.IResourceFcoreListener;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.pde.EGFPDEPlugin;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreResourceListener implements IResourceChangeListener {

  /*
   * Type of event that should be processed no matter what the real event type
   * is.
   */
  public int _overridenEventType = -1;

  // A list of listeners interested in changes to factory components resources
  private List<IResourceFcoreListener> _listeners;

  public FcoreResourceListener() {
    ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
  }

  /**
   * Notify all interested listeners in changes made to the factory components
   * resource
   * 
   * @param delta
   *          the delta of changes
   */
  private void fireResourceFcore(IResourceFcoreDelta delta) {
    if (_listeners != null) {
      for (IResourceFcoreListener listener : _listeners) {
        listener.fcoreChanged(delta);
      }
    }
  }

  /**
   * Add a listener
   * 
   * @param listener
   *          the listener to be added
   */
  public void addResourceFcoreListener(IResourceFcoreListener listener) {
    if (_listeners == null) {
      _listeners = new ArrayList<IResourceFcoreListener>();
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
  public void removeResourceFcoreListener(IResourceFcoreListener listener) {
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

        protected ResourceFcoreDelta deltaFcores = new ResourceFcoreDelta();

        protected Collection<IResource> addedFcores = new ArrayList<IResource>();

        protected Collection<IPlatformFcore> removedFcores = new ArrayList<IPlatformFcore>();

        public boolean visit(IResourceDelta delta) throws CoreException {

          if (delta.getFlags() == IResourceDelta.MARKERS) {
            return true;
          }

          IResource resource = delta.getResource();

          // Analyse projects
          if (resource.getType() == IResource.PROJECT) {
            // Ignore Added or Remove projects
            if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.REMOVED) {
              return false;
            } else if (delta.getKind() == IResourceDelta.CHANGED) {
              // Ignore opened or closed project
              if ((delta.getFlags() & IResourceDelta.OPEN) != 0) {
                return false;
              }
            }
            // Deeper projects analysis
            return true;
          }

          // Analyse further all other artifacts
          if (resource.getType() != IResource.FILE) {
            return true;
          }

          // Process files
          if (delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED || delta.getKind() == IResourceDelta.ADDED) {
            if (IFcoreConstants.FCORE_FILE_EXTENSION.equals(resource.getFileExtension())) {
              try {
                // Build a Resource URI
                URI uri = URIHelper.getPlatformURI(resource);
                if (uri != null) {
                  // Removed resource
                  if (delta.getKind() == IResourceDelta.REMOVED) {
                    for (IPlatformFcore fc : EGFCorePlugin.getWorkspacePlatformFcores()) {
                      if (fc.getURI().equals(uri)) {
                        removedFcores.add(fc);
                        break;
                      }
                    }
                    // Added resource
                  } else if (delta.getKind() == IResourceDelta.ADDED) {
                    boolean found = false;
                    for (IPlatformFcore fc : EGFCorePlugin.getWorkspacePlatformFcores()) {
                      if (fc.getURI().equals(uri)) {
                        found = true;
                        break;
                      }
                    }
                    if (found == false) {
                      addedFcores.add(resource);
                      if ((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
                        // Build a Resource URI
                        URI fromURI = URIHelper.getPlatformURI(delta.getMovedFromPath());
                        if (fromURI != null) {
                          deltaFcores.storeMovedResourceFcore(uri, fromURI);
                        }
                      }
                    }
                    // Changed resource
                  } else if (delta.getKind() == IResourceDelta.CHANGED) {
                    if ((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
                      deltaFcores.storeChangedResourceFcore(uri);
                    }
                  }
                }
              } catch (IllegalArgumentException iae) {
                EGFPlatformPlugin.getDefault().logError(new String("FcoreResourceListener.resourceChanged(..) _ "), iae); //$NON-NLS-1$
              }
            }
          }

          return true;

        }

        public Collection<IPlatformFcore> getRemovedFcores() {
          return removedFcores;
        }

        public Collection<IResource> getAddedFcores() {
          return addedFcores;
        }

        public ResourceFcoreDelta getFcoresDelta() {
          return deltaFcores;
        }

      }

      switch (eventType) {
      case IResourceChangeEvent.POST_CHANGE:
        final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
        event.getDelta().accept(visitor);
        // Process added and removed resources
        if (visitor.getRemovedFcores().isEmpty() == false || visitor.getAddedFcores().isEmpty() == false) {
          final IStatus[] errorStatus = new IStatus[1];
          errorStatus[0] = Status.OK_STATUS;
          final IRunnableWithProgress op = createFcoreOperation(errorStatus, visitor.getRemovedFcores(), visitor.getAddedFcores());
          WorkspaceJob job = new WorkspaceJob("update") { //$NON-NLS-1$
            @Override
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
        if (visitor.getFcoresDelta().isEmpty() == false) {
          // Debug
          if (EGFPDEPlugin.getDefault().isDebugging()) {
            trace(visitor.getFcoresDelta());
          }
          // Notify all interested listeners in the changes made to models
          fireResourceFcore(visitor.getFcoresDelta());
        }
      }

    } catch (CoreException ce) {
      EGFPDEPlugin.getDefault().logError(new String("FcoreResourceListener.resourceChanged(..) _"), ce); //$NON-NLS-1$
    }

  }

  public void dispose() {
    ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
    _listeners = null;
  }

  final protected IRunnableWithProgress createFcoreOperation(final IStatus[] errorStatus, final Collection<IPlatformFcore> removedFcores, final Collection<IResource> addedFcores) {
    return new IRunnableWithProgress() {
      public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        monitor.beginTask("", (removedFcores.size() + addedFcores.size()) * 1000); //$NON-NLS-1$
        monitor.setTaskName(InternalResourcesMessages.PluginModelUpdate_progressMessage);
        try {
          // Removed Fcores
          for (IPlatformFcore fcore : removedFcores) {
            // Delete an extension point
            IPluginChangesCommand unsetCommand = EGFPDEPlugin.getFcoreExtensionHelper().unsetFcoreExtension(fcore.getURI());
            IPluginChangesCommandRunner runner = EGFPDEPlugin.getPluginChangesCommandRunner();
            runner.performChangesOnPlugin(fcore.getPlatformBundle().getBundleId(), Collections.singletonList(unsetCommand));
            monitor.worked(1000);
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          }
          // Added Fcores
          for (IResource resource : addedFcores) {
            // Create an extension point
            IPluginChangesCommand createCommand = EGFPDEPlugin.getFcoreExtensionHelper().setFcoreExtension(URI.createURI(resource.getFullPath().removeFirstSegments(1).makeRelative().toString()));
            IPluginChangesCommandRunner runner = EGFPDEPlugin.getPluginChangesCommandRunner();
            // Locate the bundleId, resource should be located in a bundle
            // project
            String bundleId = BundleHelper.getBundleId(resource);
            if (bundleId != null) {
              runner.performChangesOnPlugin(bundleId, Collections.singletonList(createCommand));
            }
            monitor.worked(1000);
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          }
          errorStatus[0] = Status.OK_STATUS;
        } finally {
          monitor.done();
        }
      }
    };
  }

  private void trace(IResourceFcoreDelta delta) {
    if (delta.getChangedResourceFcores().length > 0) {
      EGFPDEPlugin.getDefault().logInfo(NLS.bind("FcoreResourceListener Changed {0} Fcore{1}.", //$NON-NLS-1$ 
          delta.getChangedResourceFcores().length, delta.getChangedResourceFcores().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getChangedResourceFcores(), null);
    }
    if (delta.getMovedResourceFcores().length > 0) {
      EGFPDEPlugin.getDefault().logInfo(NLS.bind("FcoreResourceListener Moved {0} Fcore{1}.", //$NON-NLS-1$ 
          delta.getMovedResourceFcores().length, delta.getMovedResourceFcores().length < 2 ? "" : "s" //$NON-NLS-1$  //$NON-NLS-2$
      ));
      trace(delta.getMovedResourceFcores(), delta);
    }
  }

  private void trace(URI[] uris, IResourceFcoreDelta delta) {
    for (URI uri : uris) {
      EGFPDEPlugin.getDefault().logWarning(uri.toString(), 1);
      if (delta != null) {
        EGFPDEPlugin.getDefault().logInfo("From: " + delta.getMovedFromResourceFcore(uri), 2); //$NON-NLS-1$
      }
    }
  }

}
