/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreConstants;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.core.workspace.EGFWorkspaceSynchronizer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;

/**
 * @author Thomas Guiu
 * 
 */
public final class PlatformResourceLoadedListener implements EGFWorkspaceSynchronizer.Delegate {

	private static volatile PlatformResourceLoadedListener resourceLoadedListener = new PlatformResourceLoadedListener();

	private static volatile ResourceManager resourceManager = new ResourceManager();

	private final WorkspaceListener workspaceListener = new WorkspaceListener();

	public static ResourceManager getResourceManager() {
		return resourceManager;
	}

	public static PlatformResourceLoadedListener getResourceLoadedListener() {
		return resourceLoadedListener;
	}

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

		public void resourceDeleted(final Resource resource);

		public void resourceMoved(final Resource resource, URI oldURI);

		public void resourceReloaded(final Resource resource);

		public void externalUpdate(final Resource resource);

		public void internalUpdate(final Resource resource);

	}

	public static class ResourceManager {

		final private List<ResourceListener> listeners = new ArrayList<ResourceListener>();

		final private Map<Resource, List<ResourceUser>> observers = new HashMap<Resource, List<ResourceUser>>();

		protected void dispose() {
			listeners.clear();
			observers.clear();
		}

		public void addObserver(ResourceUser resourceUser) {
			synchronized (PlatformResourceLoadedListener.class) {
				Resource resource = resourceUser.getResource();
				List<ResourceUser> list = observers.get(resource);
				if (list == null) {
					list = new ArrayList<ResourceUser>();
					observers.put(resource, list);
				}
				list.add(resourceUser);
				listeners.add(resourceUser.getListener());
			}
		}

		public void removeObserver(ResourceUser resourceUser) {
			synchronized (resourceLoadedListener) {
				Resource resource = resourceUser.getResource();
				List<ResourceUser> list = observers.get(resource);
				if (list == null) {
					return;
				}
				list.remove(resourceUser);
				if (list.isEmpty()) {
					try {
						resource.unload();
						observers.remove(resource);
						if (noMoreObserver() == false) {
							resource.load(Collections.EMPTY_MAP);
						}
					} catch (IOException ioe) {
						resource.getErrors().add(new DiagnosticResourceException(resource, ioe));
					}
				}
				listeners.remove(resourceUser.getListener());
				if (noMoreObserver()) {
					clear();
				}
			}
		}

		private void clear() {
			// no editor is actually open, so let's unload all the resources
			final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
			try {
				editingDomain.runExclusive(new Runnable() {

					public void run() {
						ResourceSet resourceSet = editingDomain.getResourceSet();
						for (Iterator<Resource> it = resourceSet.getResources().iterator(); it.hasNext();) {
							Resource resource = it.next();
							resource.unload();
							it.remove();
						}
					}
				});
				if (EGFCorePlugin.getDefault().isDebugging()) {
					EGFPlatformPlugin.getDefault().logInfo(NLS.bind("''{0}'' _ clear", EGFCorePlugin.EDITING_DOMAIN_ID)); //$NON-NLS-1$
				}
			} catch (InterruptedException e) {
				EGFCorePlugin.getDefault().logError(e);
			}
		}

		private boolean noMoreObserver() {
			for (List<ResourceUser> users : observers.values()) {
				if (users.isEmpty() == false) {
					return false;
				}
			}
			return true;
		}

		public void removeResource(Resource resource) {
			if (resource == null) {
				throw new IllegalArgumentException();
			}
			synchronized (resourceLoadedListener) {
				boolean isDirty = false;
				// Check whether or not we are editing the current resource
				List<ResourceUser> users = observers.get(resource);
				if (users != null) {
					for (ResourceUser user : users) {
						// This state is propagated, the first user is enough to
						// check this state
						isDirty = user.isDirty();
						break;
					}
				}
				// Notify, use an iterator as a closing editor always remove its
				// listener
				// This we avoid any concurrent modification exception
				for (Iterator<ResourceListener> iterator = listeners.iterator(); iterator.hasNext();) {
					ResourceListener resourceListener = iterator.next();
					resourceListener.resourceDeleted(resource);
				}
				// Non dirty editors should close themselves while editing a
				// deleted resource if any
				if (isDirty == false) {
					resource.unload();
				}
			}
		}

		public void reloadResource(Resource resource) {
			if (resource == null) {
				throw new IllegalArgumentException();
			}
			synchronized (resourceLoadedListener) {
				try {
					resource.unload();
					resource.load(Collections.EMPTY_MAP);
				} catch (IOException ioe) {
					resource.getErrors().add(new DiagnosticResourceException(resource, ioe));
				}
				for (Iterator<ResourceListener> iterator = listeners.iterator(); iterator.hasNext();) {
					ResourceListener resourceListener = iterator.next();
					resourceListener.resourceReloaded(resource);
				}
			}
		}

		public void movedResource(Resource movedResource, URI newURI) {
			if (newURI == null) {
				throw new IllegalArgumentException();
			}
			final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
			synchronized (resourceLoadedListener) {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				Resource resource = resourceSet.getResource(newURI, false);
				// Resource who can't open a physical resource raise exception
				// but are loaded
				// in the resource set, its flag is also set to isLoaded
				// we need to unload it otherwise our resource set will be messy
				// (two resources with the same URI)
				if (resource != null && resource.getContents().size() == 0 && resource.getErrors().isEmpty() == false) {
					resource.unload();
					resourceSet.getResources().remove(resource);
					if (EGFCorePlugin.getDefault().isDebugging()) {
						EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformResourceLoadedListener$ResourceManager.movedResource(...) - discard loaded empty resource with errors ''{0}''", //$NON-NLS-1$
								URIHelper.toString(newURI)));
					}
					// Load it in our resource set
					movedResource = editingDomain.getResourceSet().getResource(newURI, true);
				} else {
					if (movedResource != null) {
						movedResource.setURI(newURI);
					}
				}
				if (movedResource != null) {
					URI oldURI = movedResource.getURI();
					for (Iterator<ResourceListener> iterator = listeners.iterator(); iterator.hasNext();) {
						ResourceListener resourceListener = iterator.next();
						resourceListener.resourceMoved(movedResource, oldURI);
					}
				}
			}
		}

		public boolean resourceHasBeenExternallyChanged(Resource resource) {
			if (resource == null) {
				throw new IllegalArgumentException();
			}
			synchronized (resourceLoadedListener) {
				List<ResourceUser> users = observers.get(resource);
				if (users == null) {
					return false;
				}
				boolean resourceHasBeenExternallyChanged = false;
				// This state is propagated, the first user is enough to check
				// this state
				for (ResourceUser user : users) {
					resourceHasBeenExternallyChanged = user.resourceHasBeenExternallyChanged();
					break;
				}
				return resourceHasBeenExternallyChanged;
			}
		}

		public void populateUndoContext(IOperationHistory operationHistory, ObjectUndoContext undoContext, Resource resource) {
			if (resource == null || undoContext == null) {
				throw new IllegalArgumentException();
			}
			synchronized (resourceLoadedListener) {
				List<ResourceUser> users = observers.get(resource);
				if (users == null) {
					return;
				}
				// Operation History is propagated, the first user is enough to
				// retrieve it
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

	}

	/**
	 * This listens for platform changes.
	 */
	protected IPlatformExtensionPointListener platformListener = new IPlatformExtensionPointListener() {

		public void platformExtensionPointChanged(IPlatformExtensionPointDelta delta) {

			synchronized (PlatformResourceLoadedListener.this) {

				TransactionalEditingDomain editingDomain = getEditingDomain();

				List<Resource> deltaChangedFcores = new UniqueEList<Resource>();

				Map<Resource, IPlatformFcore> deltaRemovedFcores = new HashMap<Resource, IPlatformFcore>();

				// Check if removed platform fcores are applicable
				for (IPlatformFcore fcore : delta.getRemovedPlatformExtensionPoints(IPlatformFcore.class)) {
					Resource resource = editingDomain.getResourceSet().getResource(fcore.getURI(), false);
					if (resource == null) {
						continue;
					}
					deltaRemovedFcores.put(resource, fcore);
				}

				// Check if added platform fcores are applicable
				// if a removed platform fcore is also detected it means a
				// changed resource
				// eg: changed means target versus workspace fcore
				for (IPlatformFcore fcore : delta.getAddedPlatformExtensionPoints(IPlatformFcore.class)) {
					Resource resource = editingDomain.getResourceSet().getResource(fcore.getURI(), false);
					if (resource == null) {
						continue;
					}
					// Resource who can't open a physical resource raise
					// exception but are loaded in the resource set
					// we need to unload it to get a chance to load it again
					if (resource.getContents().size() == 0 && resource.getErrors().isEmpty() == false) {
						// start substitution removed resource if applicable
						IPlatformFcore deletedFcore = deltaRemovedFcores.get(resource);
						if (deletedFcore != null) {
							deltaRemovedFcores.remove(resource);
						}
						// Remove previous on error resource
						resource.unload();
						resource.getResourceSet().getResources().remove(resource);
						if (EGFCorePlugin.getDefault().isDebugging()) {
							EGFPlatformPlugin.getDefault().logInfo(NLS.bind("PlatformResourceLoadedListener.platformExtensionPointChanged(...) - discard loaded empty resource with errors ''{0}''", //$NON-NLS-1$
									fcore.toString()));
						}
						// Load it in our resource set, beware the URIConverter
						// should be updated accordingly
						resource = editingDomain.getResourceSet().getResource(fcore.getURI(), true);
						if (resource == null) {
							continue;
						}
						// end substitution removed resource if applicable
						if (deletedFcore != null) {
							deltaRemovedFcores.put(resource, deletedFcore);
						}
					}
					if (deltaRemovedFcores.remove(resource) != null) {
						deltaChangedFcores.add(resource);
					}
				}

				// Process Removed Fcores
				if (deltaRemovedFcores.isEmpty() == false) {
					for (Resource resource : deltaRemovedFcores.keySet()) {
						getResourceManager().removeResource(resource);
					}
				}

				// Target and workspace update, this is not detected by other
				// listeners
				// This is safe to do it here
				if (deltaChangedFcores.isEmpty() == false) {
					for (Resource resource : deltaChangedFcores) {
						getResourceManager().reloadResource(resource);
					}
				}

			}

		}

	};

	private PlatformResourceLoadedListener() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
	}

	private TransactionalEditingDomain getEditingDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
	}

	public synchronized boolean handleResourcePersisted(Resource resource) {
		for (Iterator<ResourceListener> iterator = getResourceManager().listeners.iterator(); iterator.hasNext();) {
			ResourceListener resourceListener = iterator.next();
			resourceListener.internalUpdate(resource);
		}
		return true;
	}

	public synchronized boolean handleResourceMoved(Resource movedResource, URI newURI) {
		// check whether or not we face a moved fcore to non fcore
		boolean isFcore = IPlatformFcoreConstants.FCORE_FILE_EXTENSION.equals(movedResource.getURI().fileExtension());
		boolean isMovedToFcore = IPlatformFcoreConstants.FCORE_FILE_EXTENSION.equals(newURI.fileExtension());
		// Not sure here is we need to let process non fcore file
		if ((isFcore && isMovedToFcore) || isFcore == false) {
			// Moved resource are always in non dirty editors
			// when moving a dirty resource the platform request to save the
			// resource
			// if not saved the resource is not moved
			Resource resource = getEditingDomain().getResourceSet().getResource(movedResource.getURI(), false);
			if (resource != null || getEditingDomain().getResourceSet().getResource(newURI, false) != null) {
				// Notify moved resource
				getResourceManager().movedResource(resource, newURI);
			}
		} else {
			// an fcore has moved to a non fcore resource, process a remove
			return handleResourceDeleted(movedResource);
		}
		return true;
	}

	public synchronized boolean handleResourceDeleted(Resource deletedResource) {
		IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(deletedResource);
		// Either a non Fcore resource or an already processed deleted fcore
		// from _platformListener
		if (fcore == null) {
			// _platformListener has been called first, Process workspace
			// removed fcores detected in _platformListener
			getResourceManager().removeResource(deletedResource);
		}
		return true;
	}

	public synchronized boolean handleResourceChanged(final Resource changedResource) {
		List<ResourceUser> users = getResourceManager().observers.get(changedResource);
		// No one edit this resource, process a standard reload
		if (users == null) {
			getResourceManager().reloadResource(changedResource);
			return true;
		}
		// Check the state of this edited resource
		boolean hasSavedResource = false;
		boolean isDirty = false;
		for (ResourceUser user : users) {
			// We need to deeply analyze users as anyone could have saved this
			// resource if any
			hasSavedResource |= user.userHasSavedResource();
			// This state is propagated, the first user is enough to check this
			// state
			isDirty |= user.isDirty();
		}
		// Nothing to do, we just reload the resource
		if (hasSavedResource == false && isDirty == false) {
			getResourceManager().reloadResource(changedResource);
			return true;
		}
		// Dirty resource
		if (hasSavedResource == false && isDirty) { // Give a chance to cancel
													// dirty editors while
													// reloading external
													// changed resource
			for (Iterator<ResourceListener> iterator = getResourceManager().listeners.iterator(); iterator.hasNext();) {
				ResourceListener resourceListener = iterator.next();
				resourceListener.externalUpdate(changedResource);
			}
			return true;
		}
		// Non dirty resource
		for (Iterator<ResourceListener> iterator = getResourceManager().listeners.iterator(); iterator.hasNext();) {
			ResourceListener resourceListener = iterator.next();
			resourceListener.internalUpdate(changedResource);
		}
		return true;
	}

	public synchronized void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);
		EGFPlatformPlugin.getPlatformManager().removePlatformExtensionPointListener(platformListener);
		getResourceManager().dispose();
		resourceManager = null;
	}

	public class WorkspaceListener  implements IResourceChangeListener, IResourceDeltaVisitor {

		public void resourceChanged(IResourceChangeEvent event) {
			switch (event.getType()) {
			case IResourceChangeEvent.POST_CHANGE :
				IResourceDelta delta = event.getDelta();
				if (delta != null)
					try {
						delta.accept(this);
					} catch (CoreException e) {
						EGFPlatformPlugin.getDefault().logError(e);
					}
				break;
			case IResourceChangeEvent.PRE_CLOSE :
				IProject proj = (IProject) event.getResource();
				reload(proj);
				break;
		}
		}

		private void reload(IProject proj) {
			TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
			for (Resource r : editingDomain.getResourceSet().getResources()) {
				if (proj.getName().equals(r.getURI().segment(1)))
				{
					getResourceManager().reloadResource(r);
				}
			}

		}

		public boolean visit(IResourceDelta delta) throws CoreException {
			final IResource resource = delta.getResource();
			switch (resource.getType()) {

				case IResource.ROOT :
					return true;
				case IResource.PROJECT : {
					IProject project = (IProject) resource;
					if ( (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.REMOVED || (delta.getFlags() & IResourceDelta.OPEN) != 0)) {
						reload(project);
						return false;
					}
					return true;
				}
			}
			return false;
		}
		
	}
}
