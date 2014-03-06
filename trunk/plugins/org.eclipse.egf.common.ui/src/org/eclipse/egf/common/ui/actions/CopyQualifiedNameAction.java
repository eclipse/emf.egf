/**
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.common.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.egf.common.ui.l10n.EGFCommonUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ResourceTransfer;

public abstract class CopyQualifiedNameAction extends Action implements IObjectActionDelegate {

    protected IWorkbenchPart _part;

    public CopyQualifiedNameAction(String text, ImageDescriptor image) {
        super(text, image);
    }

    public abstract void selectionChanged(IAction action, ISelection selection);

    protected EObject getSelection(IStructuredSelection selection) {
        Object selectedObject = selection.getFirstElement();
        if (selectedObject != null) {
            if (selectedObject instanceof EObject) {
                return (EObject) selectedObject;
            }
            if (selectedObject instanceof IAdaptable) {
                Object adaptedObj = ((IAdaptable) selectedObject).getAdapter(EObject.class);
                if (adaptedObj != null && adaptedObj instanceof EObject) {
                    return (EObject) adaptedObj;
                }
            }
            IAdapterManager adapterManager = Platform.getAdapterManager();
            if (adapterManager.hasAdapter(selectedObject, EObject.class.getName())) {
                Object adaptedObj = adapterManager.loadAdapter(selectedObject, EObject.class.getName());
                if (adaptedObj instanceof EObject) {
                    return (EObject) adaptedObj;
                }
            }
        }
        return null;
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        _part = targetPart;
    }

    protected abstract URI getURI();

    public void run(IAction action) {

        URI uri = getURI();

        if (uri == null || _part == null) {
            return;
        }

        try {

            Object[] data = null;
            Transfer[] dataTypes = null;

            // Build IResource if any
            //
            IResource resource = null;
            if (uri.isPlatformResource()) {
                String path = uri.toPlatformString(true);
                resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
            }

            if (resource != null) {
                IPath location = resource.getLocation();
                if (location != null) {
                    data = new Object[] {
                            uri.toString(), resource, new String[] {
                                location.toOSString()
                            }
                    };
                    dataTypes = new Transfer[] {
                            TextTransfer.getInstance(), ResourceTransfer.getInstance(), FileTransfer.getInstance()
                    };
                } else {
                    data = new Object[] {
                            uri.toString(), resource
                    };
                    dataTypes = new Transfer[] {
                            TextTransfer.getInstance(), ResourceTransfer.getInstance()
                    };
                }
            } else {
                data = new Object[] {
                    uri.toString()
                };
                dataTypes = new Transfer[] {
                    TextTransfer.getInstance()
                };
            }

            Clipboard clipboard = new Clipboard(_part.getSite().getShell().getDisplay());
            try {
                clipboard.setContents(data, dataTypes);
            } catch (SWTError e) {
                if (e.code != DND.ERROR_CANNOT_SET_CLIPBOARD) {
                    throw e;
                }
                if (MessageDialog.openQuestion(_part.getSite().getShell(), EGFCommonUIMessages.CopyQualifiedNameAction_ErrorTitle, EGFCommonUIMessages.CopyQualifiedNameAction_ErrorDescription)) {
                    clipboard.setContents(data, dataTypes);
                }
            } finally {
                clipboard.dispose();
            }

        } catch (Throwable t) {
            EGFCommonUIPlugin.getDefault().logError("CopyQualifiedNameAction.run(..) _", t); //$NON-NLS-1$
        }

    }

}
