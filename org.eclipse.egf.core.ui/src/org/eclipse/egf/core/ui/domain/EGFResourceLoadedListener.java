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
package org.eclipse.egf.core.ui.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.core.workspace.EGFWorkspaceSynchronizer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author Thomas Guiu
 * 
 */
public final class EGFResourceLoadedListener implements EGFWorkspaceSynchronizer.Delegate {

  public static final ResourceEventManager RESOURCE_MANAGER = new ResourceEventManager();

  public static interface ResourceUser {

    public Resource getResource();

    public ResourceListener getListener();

    public boolean isDirty();

    public boolean userHasSavedResource();

    public boolean resourceHasBeenExternallyChanged();

    public IOperationHistory getOperationHistory();

    public ObjectUndoContext getUndoContext();

  }

  public static interface ResourceListener {

    public void resourceDeleted(Resource resource);

    public void resourceMoved(Resource resource, URI oldURI);

    public void resourceReloaded(Resource resource);

    public void externalUpdate(Resource resource);

    public void internalUpdate(Resource resource);

  }

  public static class ResourceEventManager {

    final List<ResourceListener> _listeners = new ArrayList<ResourceListener>();

    final Map<Resource, List<ResourceUser>> _observers = new HashMap<Resource, List<ResourceUser>>();

    // Due to PDE bug notification we need to handle
    // notification in a weird way
    // https://bugs.eclipse.org/bugs/show_bug.cgi?id=267954
    // See PlatformManager for more informations
    final Map<Resource, IPlatformFcore> _fcores = new HashMap<Resource, IPlatformFcore>();

    public void addObserver(ResourceUser resourceUser) {
      Resource resource = resourceUser.getResource();
      List<ResourceUser> list = _observers.get(resource);
      if (list == null) {
        list = new ArrayList<ResourceUser>();
        _observers.put(resource, list);
        // Start Workaround PDE Bug 267954
        IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(resource);
        if (fcore != null) {
          _fcores.put(resource, fcore);
        }
        // End Workaround PDE Bug 267954
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
      if (list.isEmpty()) {
        try {
          resource.unload();
          _observers.remove(resource);
          // Start Workaround PDE Bug 267954
          _fcores.remove(resource);
          // End Workaround PDE Bug 267954
          if (noMoreObserver() == false) {
            resource.load(Collections.EMPTY_MAP);
          }
        } catch (IOException ioe) {
          resource.getErrors().add(new XMIException(EGFCorePlugin.EDITING_DOMAIN_ID, ioe));
        }
      }
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
            for (Iterator<Resource> it = editingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
              Resource resource = it.next();
              resource.unload();
              it.remove();
            }
          }
        });
        if (EGFCoreUIPlugin.getDefault().isDebugging()) {
          EGFPlatformPlugin.getDefault().logInfo("EGFResourceLoadedListener.clearResourceSet()"); //$NON-NLS-1$           
        }
      } catch (InterruptedException e) {
        EGFCoreUIPlugin.getDefault().logError(e);
      }
      _fcores.clear();
    }

    private boolean noMoreObserver() {
      for (List<ResourceUser> users : _observers.values()) {
        if (users.isEmpty() == false) {
          return false;
        }
      }
      return true;
    }

    public void removeResource(EditingDomain editingDomain, Resource resource) {
      if (resource == null) {
        throw new IllegalArgumentException();
      }
      boolean isDirty = false;
      // Check whether or not we are editing the current resource
      List<ResourceUser> users = _observers.get(resource);
      if (users != null) {
        for (ResourceUser user : users) {
          // This state is propagated, the first user is enough to check this state
          isDirty = user.isDirty();
          break;
        }
      }
      // Notify, use an iterator as a closing editor always remove its listener
      // This we avoid any concurrent modification exception
      for (Iterator<ResourceListener> iterator = _listeners.iterator(); iterator.hasNext();) {
        ResourceListener resourceListener = iterator.next();
        resourceListener.resourceDeleted(resource);
      }
      // Non dirty editors should close themselves while editing a deleted resource if any
      if (isDirty == false) {
        resource.unload();
        // Start Workaround PDE Bug 267954
        _fcores.remove(resource);
        // End Workaround PDE Bug 267954
      }
    }

    public void reloadResource(Resource resource) {
      if (resource == null) {
        throw new IllegalArgumentException();
      }
      try {
        resource.unload();
        resource.load(Collections.EMPTY_MAP);
      } catch (IOException ioe) {
        resource.getErrors().add(new XMIException(EGFCorePlugin.EDITING_DOMAIN_ID, ioe));
      }
      for (Iterator<ResourceListener> iterator = _listeners.iterator(); iterator.hasNext();) {
        ResourceListener resourceListener = iterator.next();
        resourceListener.resourceReloaded(resource);
      }
    }

    public void movedResource(TransactionalEditingDomain editingDomain, Resource movedResource, URI newURI) {
      if (movedResource == null) {
        throw new IllegalArgumentException();
      }
      URI oldURI = movedResource.getURI();
      Resource resource = movedResource.getResourceSet().getResource(newURI, false);
      // Resource who can't open a physical resource raise exception but are loaded
      // in the resource set, its flag is also set to isLoaded
      // we need to unload otherwise our resource set will be messy (two resources with the same URI)
      if (resource != null && resource.getContents().size() == 0 && resource.getErrors().isEmpty() == false) {
        resource.unload();
        resource.getResourceSet().getResources().remove(resource);
        if (EGFCoreUIPlugin.getDefault().isDebugging()) {
          EGFPlatformPlugin.getDefault().logInfo(NLS.bind("EGFResourceLoadedListener.movedResource(...) - discard loaded empty resource with errors ''{0}''", resource.getURI())); //$NON-NLS-1$           
        }
        _fcores.remove(resource);
        // Load it in our resource set
        movedResource = editingDomain.getResourceSet().getResource(newURI, true);
      }
      _fcores.remove(movedResource);
      movedResource.setURI(newURI);
      for (Iterator<ResourceListener> iterator = _listeners.iterator(); iterator.hasNext();) {
        ResourceListener resourceListener = iterator.next();
        resourceListener.resourceMoved(movedResource, oldURI);
      }
    }

    public boolean resourceHasBeenExternallyChanged(Resource resource) {
      if (resource == null) {
        throw new IllegalArgumentException();
      }
      List<ResourceUser> users = _observers.get(resource);
      if (users == null) {
        return false;
      }
      boolean resourceHasBeenExternallyChanged = false;
      // This state is propagated, the first user is enough to check this state
      for (ResourceUser user : users) {
        resourceHasBeenExternallyChanged = user.resourceHasBeenExternallyChanged();
        break;
      }
      return resourceHasBeenExternallyChanged;
    }

    public void populateUndoContext(IOperationHistory operationHistory, ObjectUndoContext undoContext, Resource resource) {
      if (resource == null || undoContext == null) {
        throw new IllegalArgumentException();
      }
      List<ResourceUser> users = _observers.get(resource);
      if (users == null) {
        return;
      }
      // Operation History is propagated, the first user is enough to retrieve it
      ObjectUndoContext innerUndoContext = null;
      for (ResourceUser user : users) {
        if (user.getUndoContext() != undoContext) {
          innerUndoContext = user.getUndoContext();
          break;
        }
      }
      // Populate
      if (innerUndoContext != null) {
        for (IUndoableOperation operation : operationHistory.getUndoHistory(innerUndoContext)) {
          operation.addContext(undoContext);
        }
        for (IUndoableOperation operation : operationHistory.getRedoHistory(innerUndoContext)) {
          operation.addContext(undoContext);
        }
      }
    }

  }

  /**
   * This listens for platform changes.
   */
  protected IPlatformExtensionPointListener _platformListener = new IPlatformExtensionPointListener() {

    public void platformExtensionPointChanged(IPlatformExtensionPointDelta delta) {

      TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);

      List<Resource> deltaChangedFcores = new UniqueEList<Resource>();

      Map<Resource, IPlatformFcore> deltaRemovedFcores = new HashMap<Resource, IPlatformFcore>();

      // Check if a removed platform fcore is applicable
      for (IPlatformFcore fcore : delta.getRemovedPlatformExtensionPoints(IPlatformFcore.class)) {
        Resource resource = editingDomain.getResourceSet().getResource(fcore.getURI(), false);
        if (resource == null) {
          continue;
        }
        deltaRemovedFcores.put(resource, fcore);
      }

      // Check if an added platform fcore is applicable
      // if a removed platform fcore is also detected it means a changed resource
      // eg: changed means target versus workspace fcore
      for (IPlatformFcore fcore : delta.getAddedPlatformExtensionPoints(IPlatformFcore.class)) {
        Resource resource = editingDomain.getResourceSet().getResource(fcore.getURI(), false);
        if (resource == null) {
          continue;
        }
        // Resource who can't open a physical resource raise exception but are loaded
        // in the resource set, its flag is also set to isLoaded
        // we need to unload it to get a chance to load it again
        if (resource.getContents().size() == 0 && resource.getErrors().isEmpty() == false) {
          // start substitution removed resource if applicable
          IPlatformFcore deletedFcore = deltaRemovedFcores.get(resource);
          if (deletedFcore != null) {
            deltaRemovedFcores.remove(resource);
          }
          resource.unload();
          resource.getResourceSet().getResources().remove(resource);
          if (EGFCoreUIPlugin.getDefault().isDebugging()) {
            EGFPlatformPlugin.getDefault().logInfo(NLS.bind("EGFResourceLoadedListener.platformExtensionPointChanged(...) - discard loaded empty resource with errors ''{0}''", resource.getURI())); //$NON-NLS-1$           
          }
          RESOURCE_MANAGER._fcores.remove(resource);
          // Load it in our resource set
          resource = editingDomain.getResourceSet().getResource(fcore.getURI(), true);
          if (resource == null) {
            continue;
          }
          // end substitution removed resource if applicable
          if (deletedFcore != null) {
            deltaRemovedFcores.put(resource, deletedFcore);
          }
        }
        // Start Workaround PDE Bug 267954
        IPlatformFcore deletedFcore = deltaRemovedFcores.get(resource);
        if (deltaRemovedFcores.remove(resource) != null) {
          if (deletedFcore.equals(fcore) == false) {
            deltaChangedFcores.add(resource); // <- this statement is not a workaround
          }
        }
        RESOURCE_MANAGER._fcores.put(resource, fcore);
        // End Workaround PDE Bug 267954
      }

      // Process Removed Fcores
      if (deltaRemovedFcores.isEmpty() == false) {
        for (Resource resource : deltaRemovedFcores.keySet()) {
          RESOURCE_MANAGER.removeResource(editingDomain, resource);
        }
      }

      // Target and workspace update, this is not detected by other listeners
      // This is safe to do it here
      if (deltaChangedFcores.isEmpty() == false) {
        for (Resource resource : deltaChangedFcores) {
          RESOURCE_MANAGER.reloadResource(resource);
        }
      }

    }

  };

  private TransactionalEditingDomain _editingDomain;

  public EGFResourceLoadedListener() {
    EGFPlatformPlugin.getPlatformManager().addPlatformExtensionPointListener(_platformListener);
  }

  public TransactionalEditingDomain getEditingDomain() {
    if (_editingDomain == null) {
      _editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
    }
    return _editingDomain;
  }

  public boolean handleResourcePersisted(Resource resource) {
    for (Iterator<ResourceListener> iterator = RESOURCE_MANAGER._listeners.iterator(); iterator.hasNext();) {
      ResourceListener resourceListener = iterator.next();
      resourceListener.internalUpdate(resource);
    }
    return true;
  }

  public boolean handleResourceMoved(Resource movedResource, URI newURI) {
    // Moved resource are always in non dirty editors
    // when moving a dirty resource the platform request to save the resource
    // if not saved the resource is not moved
    Resource resource = getEditingDomain().getResourceSet().getResource(movedResource.getURI(), false);
    if (resource == null) {
      resource = getEditingDomain().getResourceSet().getResource(newURI, false);
    }
    if (resource != null) {
      // Notify moved resource
      RESOURCE_MANAGER.movedResource(getEditingDomain(), resource, newURI);
    }
    return true;
  }

  public boolean handleResourceDeleted(Resource deletedResource) {
    IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(deletedResource);
    // Either a non Fcore resource or an already processed deleted fcore from _platformListener
    if (fcore == null) {
      // _platformListener has been called first, Process workspace removed fcores detected in _platformListener
      RESOURCE_MANAGER.removeResource(getEditingDomain(), deletedResource);
    }
    return true;
  }

  public boolean handleResourceChanged(final Resource changedResource) {
    List<ResourceUser> users = RESOURCE_MANAGER._observers.get(changedResource);
    // No one edit this resource, process a standard reload
    if (users == null) {
      RESOURCE_MANAGER.reloadResource(changedResource);
      return true;
    }
    // Check the state of this edited resource
    boolean hasSavedResource = false;
    boolean isDirty = false;
    for (ResourceUser user : users) {
      // We need to deeply analyze users as anyone could have saved this resource if any
      hasSavedResource |= user.userHasSavedResource();
      // This state is propagated, the first user is enough to check this state
      isDirty |= user.isDirty();
    }
    // Nothing to do, we just reload the resource
    if (hasSavedResource == false && isDirty == false) {
      RESOURCE_MANAGER.reloadResource(changedResource);
      return true;
    }
    // Dirty resource
    if (hasSavedResource == false && isDirty) { // Give a chance to cancel dirty editors while reloading external changed resource
      final Boolean[] reload = new Boolean[] { Boolean.FALSE };
      Display.getDefault().syncExec(new Runnable() {
        public void run() {
          IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
          if (activeWorkbenchWindow != null) {
            reload[0] = MessageDialog.openQuestion(activeWorkbenchWindow.getShell(), CoreUIMessages.ResourceListener_reloadDialog_title, NLS.bind(CoreUIMessages.ResourceListener_reloadDialog_message, URI.decode(changedResource.getURI().toString())));
          }
        }
      });
      if (reload[0]) {
        RESOURCE_MANAGER.reloadResource(changedResource);
        return true;
      }
      for (Iterator<ResourceListener> iterator = RESOURCE_MANAGER._listeners.iterator(); iterator.hasNext();) {
        ResourceListener resourceListener = iterator.next();
        resourceListener.externalUpdate(changedResource);
      }
      return true;
    }
    // Non dirty resource
    for (Iterator<ResourceListener> iterator = RESOURCE_MANAGER._listeners.iterator(); iterator.hasNext();) {
      ResourceListener resourceListener = iterator.next();
      resourceListener.internalUpdate(changedResource);
    }
    return true;
  }

  public void dispose() {
    EGFPlatformPlugin.getPlatformManager().removePlatformExtensionPointListener(_platformListener);
  }

}
