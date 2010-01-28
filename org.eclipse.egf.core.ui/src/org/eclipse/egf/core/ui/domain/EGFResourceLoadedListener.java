/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.core.ui.domain;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFResourceLoadedListener implements WorkspaceSynchronizer.Delegate {

  public static final ResourceEventManager RESOURCE_MANAGER = new ResourceEventManager();

  public static interface ResourceUser {

    Resource getResource();

    boolean isDirty();

    ResourceListener getListener();

  }

  public static interface ResourceListener {

    void resourceDeleted(Resource resource);

    void resourceMoved(Resource resource, URI newURI);

    void resourceChanged(Resource resource);
  }

  public static class ResourceEventManager {

    final List<ResourceListener> _listeners = new ArrayList<ResourceListener>();

    final Map<Resource, List<ResourceUser>> _observers = new HashMap<Resource, List<ResourceUser>>();

    public void addObserver(ResourceUser resourceUser) {
      Resource resource = resourceUser.getResource();
      List<ResourceUser> list = _observers.get(resource);
      if (list == null) {
        list = new ArrayList<ResourceUser>();
        _observers.put(resource, list);
      }
      list.add(resourceUser);
      _listeners.add(resourceUser.getListener());
    }

    public void removeObserver(ResourceUser resourceUser) {
      Resource resource = resourceUser.getResource();
      List<ResourceUser> list = _observers.get(resource);
      if (list == null) {
        return;
      }
      list.remove(resourceUser);
      _listeners.remove(resourceUser.getListener());
      if (noMoreObserver()) {
        clearResourceSet();
      }
    }

    private void clearResourceSet() {
      // no editor is actually open, so let's unload all the resources
      final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
      try {
        editingDomain.runExclusive(new Runnable() {
          public void run() {
            for (Resource res : editingDomain.getResourceSet().getResources()) {
              res.unload();
            }
          }
        });
      } catch (InterruptedException e) {
        EGFCoreUIPlugin.getDefault().logError(e);

      }
    }

    private boolean noMoreObserver() {
      for (List<ResourceUser> users : _observers.values()) {
        if (users.isEmpty() == false) {
          return false;
        }
      }
      return true;
    }

    public WorkspaceModifyOperation createSaveOperation(final ResourceUser resourceUser, final TransactionalEditingDomain editingDomain) {
      if (resourceUser == null) {
        throw new IllegalArgumentException();
      }
      if (resourceUser.getResource() == null) {
        throw new IllegalArgumentException();
      }
      final Resource resource = resourceUser.getResource();
      final ObjectHolder<Exception> holder = new ObjectHolder<Exception>();
      return new WorkspaceModifyOperation() {
        @Override
        public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
          editingDomain.runExclusive(new Runnable() {
            public void run() {
              try {
                if (resource instanceof XMLResource) {
                  resource.save(((XMLResource) resource).getDefaultSaveOptions());
                } else {
                  resource.save(Collections.EMPTY_MAP);
                }
              } catch (Exception exception) {
                holder.object = exception;
              }
            }
          });
          if (holder.object != null) {
            throw new InvocationTargetException(holder.object);
          }
        }
      };
    }
  }

  public boolean handleResourceMoved(Resource resource, URI newURI) {
    resource.unload();
    for (ResourceListener l : RESOURCE_MANAGER._listeners) {
      l.resourceMoved(resource, newURI);
    }
    return true;
  }

  public boolean handleResourceDeleted(Resource resource) {
    resource.unload();
    for (ResourceListener l : RESOURCE_MANAGER._listeners) {
      l.resourceDeleted(resource);
    }
    return true;
  }

  public boolean handleResourceChanged(final Resource resource) {
    if (need2reload(resource)) {
      TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
      editingDomain.getCommandStack().flush();
      try {
        resource.unload();
        if (resource instanceof XMLResource) {
          resource.load(((XMLResource) resource).getDefaultLoadOptions());
        } else {
          resource.load(Collections.EMPTY_MAP);
        }
      } catch (IOException e) {
        EGFCoreUIPlugin.getDefault().logError(e);
      }
    }
    for (ResourceListener l : RESOURCE_MANAGER._listeners) {
      l.resourceChanged(resource);
    }
    return true;
  }

  private boolean need2reload(Resource resource) {
    List<ResourceUser> users = RESOURCE_MANAGER._observers.get(resource);
    if (users == null) {
      return true; // no one edit it -> reload
    }
    final ObjectHolder<Boolean> reload = new ObjectHolder<Boolean>();
    boolean dirty = false;
    for (ResourceUser user : users) {
      dirty |= user.isDirty();
    }
    if (dirty == false) {
      return true; // no one has pending change -> reload
    }
    Display.getDefault().syncExec(new Runnable() {
      public void run() {
        IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (activeWorkbenchWindow != null) {
          reload.object = MessageDialog.openQuestion(activeWorkbenchWindow.getShell(), CoreUIMessages.ResourceListener_reloadDialog_title, CoreUIMessages.ResourceListener_reloadDialog_message);
        }
      }
    });

    return reload.object; // the choice of the user
  }

  public void dispose() {
    // Nothing to do
  }

}
