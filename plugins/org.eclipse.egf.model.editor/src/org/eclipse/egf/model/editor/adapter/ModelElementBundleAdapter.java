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
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelElementBundleAdapter extends EContentAdapter {

    private Resource _resource;

    private Shell _shell;

    public ModelElementBundleAdapter(Resource resource) {
        _shell = EGFModelEditorPlugin.getActiveWorkbenchShell();
        _resource = resource;
    }

    public ModelElementBundleAdapter(Resource resource, IWorkbenchPartSite site) {
        _shell = site != null ? site.getShell() : EGFModelEditorPlugin.getActiveWorkbenchShell();
        _resource = resource;
    }

    @Override
    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        if (notification.getNewValue() != null && notification.getNewValue() instanceof ModelElement) {
            handleNotification(notification);
        }
    }

    private void handleNotification(Notification notification) {

        if (notification.getEventType() == Notification.ADD || notification.getEventType() == Notification.SET || notification.getEventType() == Notification.ADD_MANY) {

            ModelElement modelElement = (ModelElement) notification.getNewValue();
            Resource resource = modelElement.eResource();
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
            // Check whether or not we have Pattern in this new element
            Collection<EObject> patterns = EMFHelper.getAllProperContents(PatternPackage.eINSTANCE.getPattern(), EcoreUtil.getRootContainer(modelElement, true));
            // Check whether or not we a new task in this new element
            Collection<EObject> tasks = EMFHelper.getAllProperContents(FtaskPackage.eINSTANCE.getTask(), EcoreUtil.getRootContainer(modelElement, true));
            // Check whether or not we have a new TypeClass in this new element
            Collection<EObject> typeClasses = EMFHelper.getAllProperContents(TypesPackage.eINSTANCE.getTypeClass(), EcoreUtil.getRootContainer(modelElement, true));
            // Project converter
            IRunnableWithProgress operation = null;
            if (patterns.isEmpty() && tasks.isEmpty()) {

                // Convert                
                if (typeClasses.isEmpty() == false) {

                    // Do not convert if we already belong to a bundle java project
                    IJavaProject javaProject = JavaCore.create(fcore.getPlatformBundle().getProject());
                    if (javaProject != null && javaProject.exists()) {
                        try {
                            javaProject.close();
                        } catch (JavaModelException jme) {
                            // Just Ignore
                        }
                        return;
                    }

                    operation = new ConvertProjectOperation(fcore.getPlatformBundle().getProject(), true, true) {

                        @Override
                        public List<String> addDependencies() {
                            List<String> dependencies = new ArrayList<String>(1);
                            dependencies.add("org.eclipse.egf.model.ftask"); //$NON-NLS-1$
                            return dependencies;
                        }

                        @Override
                        public List<String> addSourceFolders() {
                            List<String> sourceFolders = new ArrayList<String>(1);
                            sourceFolders.add("src"); //$NON-NLS-1$
                            return sourceFolders;
                        }
                    };

                }

            } else if (patterns.isEmpty() && tasks.isEmpty() == false) {

                operation = new ConvertProjectOperation(fcore.getPlatformBundle().getProject(), true, true) {

                    @Override
                    public List<String> addDependencies() {
                        List<String> dependencies = new ArrayList<String>(1);
                        dependencies.add("org.eclipse.egf.model.ftask"); //$NON-NLS-1$
                        return dependencies;
                    }

                    @Override
                    public List<String> addSourceFolders() {
                        List<String> sourceFolders = new ArrayList<String>(1);
                        sourceFolders.add("src"); //$NON-NLS-1$
                        return sourceFolders;
                    }
                };

            } else {

                operation = new ConvertProjectOperation(fcore.getPlatformBundle().getProject(), true, true) {

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

            }
            // asynchronous operation
            try {
                if (operation != null) {
                    new ProgressMonitorDialog(_shell).run(false, false, operation);
                }
            } catch (InterruptedException ie) {
                // Nothing to do
            } catch (Exception e) {
                ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), e);
            }

        }

    }

}
