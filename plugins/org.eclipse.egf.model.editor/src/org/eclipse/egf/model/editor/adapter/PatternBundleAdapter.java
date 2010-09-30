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
package org.eclipse.egf.model.editor.adapter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * @author Xavier Maysonnave
 * 
 */
public class PatternBundleAdapter extends EContentAdapter {

    private Resource _resource;

    private Shell _shell;

    public PatternBundleAdapter(Resource resource) {
        _shell = EGFModelEditorPlugin.getActiveWorkbenchShell();
        _resource = resource;
    }

    public PatternBundleAdapter(Resource resource, IWorkbenchPartSite site) {
        _shell = site != null ? site.getShell() : EGFModelEditorPlugin.getActiveWorkbenchShell();
        _resource = resource;
    }

    @Override
    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        if (notification.getNewValue() != null && notification.getNewValue() instanceof Pattern) {
            handleNotification(notification);
        }
    }

    private void handleNotification(Notification notification) {
        if (notification.getEventType() == Notification.ADD) {
            Pattern pattern = (Pattern) notification.getNewValue();
            Resource resource = pattern.eResource();
            if (resource != _resource || ((ResourceImpl) resource).isLoading()) {
                return;
            }
            if (resource instanceof IPlatformFcoreProvider == false) {
                return;
            }
            final IPlatformFcore fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
            if (fcore == null || fcore.getPlatformBundle().getProject() == null) {
                return;
            }
            IRunnableWithProgress operation = new ConvertProjectOperation(fcore.getPlatformBundle().getProject(), true, true) {

                @Override
                public List<String> addDependencies() {
                    List<String> dependencies = new ArrayList<String>(2);
                    dependencies.add("org.eclipse.egf.pattern"); //$NON-NLS-1$
                    dependencies.add("org.eclipse.egf.pattern.ftask"); //$NON-NLS-1$
                    return dependencies;
                }

                @Override
                public List<String> addSourceFolders() {
                    List<String> sourceFolders = new ArrayList<String>(1);
                    sourceFolders.add("generated"); //$NON-NLS-1$
                    return sourceFolders;
                }

            };
            // asynchronous operation
            try {
                new ProgressMonitorDialog(_shell).run(false, false, operation);
            } catch (InterruptedException ie) {
                // Nothing to do
            } catch (Exception e) {
                ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), e);
            }
        }
    }

}
