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
 */

package org.eclipse.egf.pattern.ui.editors.domain;

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
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
public class ResourceLoadedListener implements WorkspaceSynchronizer.Delegate {
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
        final List<ResourceListener> listeners = new ArrayList<ResourceListener>();
        final Map<Resource, List<ResourceUser>> observers = new HashMap<Resource, List<ResourceUser>>();

        public void addObserver(ResourceUser u) {
            Resource resource = u.getResource();
            List<ResourceUser> list = observers.get(resource);
            if (list == null) {
                list = new ArrayList<ResourceUser>();
                observers.put(resource, list);
            }
            list.add(u);
            listeners.add(u.getListener());
        }

        public void removeObserver(ResourceUser u) {
            Resource resource = u.getResource();
            List<ResourceUser> list = observers.get(resource);
            if (list == null)
                return;
            list.remove(u);
            listeners.remove(u.getListener());
        }

        public WorkspaceModifyOperation createSaveOperation(final ResourceUser u, final TransactionalEditingDomain editingDomain) {
            if (u == null)
                throw new IllegalArgumentException();
            if (u.getResource() == null)
                throw new IllegalArgumentException();

            final Resource resource = u.getResource();
            final ObjectHolder<Exception> holder = new ObjectHolder<Exception>();
            return new WorkspaceModifyOperation() {
                @Override
                public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
                    editingDomain.runExclusive(new Runnable() {
                        public void run() {
                            try {
                                resource.save(Collections.EMPTY_MAP);
                            } catch (Exception exception) {
                                holder.object = exception;
                            }
                        }
                    });
                    if (holder.object != null)
                        throw new InvocationTargetException(holder.object);
                }
            };
        }
    }

    public boolean handleResourceMoved(Resource resource, URI newURI) {
        resource.unload();
        for (ResourceListener l : RESOURCE_MANAGER.listeners)
            l.resourceMoved(resource, newURI);

        return true;
    }

    public boolean handleResourceDeleted(Resource resource) {
        resource.unload();
        for (ResourceListener l : RESOURCE_MANAGER.listeners)
            l.resourceDeleted(resource);
        return true;
    }

    public boolean handleResourceChanged(Resource resource) {
        if (need2reload(resource)) {
            resource.unload();
            try {
                resource.load(resource.getResourceSet().getLoadOptions());
            } catch (IOException e) {
                Activator.getDefault().logError(e);
            }
        }
        for (ResourceListener l : RESOURCE_MANAGER.listeners)
            l.resourceChanged(resource);

        return true;
    }

    private boolean need2reload(Resource resource) {
        List<ResourceUser> users = RESOURCE_MANAGER.observers.get(resource);
        if (users == null)
            return true; // no one edit it -> reload
        final ObjectHolder<Boolean> reload = new ObjectHolder<Boolean>();
        boolean dirty = false;
        for (ResourceUser user : users)
            dirty |= user.isDirty();

        if (!dirty)
            return true; // no one has pending change -> reload
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if (activeWorkbenchWindow != null)

                    reload.object = MessageDialog.openQuestion(activeWorkbenchWindow.getShell(), "File Conflict", //$NON-NLS-1$
                            "External changes, reload the resource ?"); //$NON-NLS-1$
            }
        });

        return reload.object; // the choice of the user
    }

    public void dispose() {
    }

}
