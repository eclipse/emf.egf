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
package org.eclipse.egf.model.editor.adapter;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
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
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelElementBundleAdapter extends EContentAdapter {

    private Resource _resource;

    private IWorkbenchWindow _window;

    public ModelElementBundleAdapter(Resource resource) {
        _window = EGFModelEditorPlugin.getActiveWorkbenchWindow();
        _resource = resource;
    }

    public ModelElementBundleAdapter(Resource resource, IWorkbenchPartSite site) {
        _window = site != null ? site.getWorkbenchWindow() : EGFModelEditorPlugin.getActiveWorkbenchWindow();
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
            IProject project = EMFHelper.getProject(resource);
            if (project == null) {
                return;
            }
            // Check whether or not we have Pattern in this new element
            Collection<EObject> patterns = EMFHelper.getAllProperContents(PatternPackage.eINSTANCE.getPattern(), EcoreUtil.getRootContainer(modelElement, true));
            // Check whether or not we a new task in this new element
            Collection<EObject> tasks = EMFHelper.getAllProperContents(FtaskPackage.eINSTANCE.getTask(), EcoreUtil.getRootContainer(modelElement, true));
            // Check whether or not we have a new TypeClass in this new element
            Collection<EObject> typeClasses = EMFHelper.getAllProperContents(TypesPackage.eINSTANCE.getTypeClass(), EcoreUtil.getRootContainer(modelElement, true));
            // Project converter
            ConvertProjectOperation operation = null;
            if (patterns.isEmpty() && tasks.isEmpty()) {

                // Convert
                if (typeClasses.isEmpty() == false) {

                    // Do not convert if we already belong to a bundle java
                    // project
                    IJavaProject javaProject = JavaCore.create(project);
                    if (javaProject != null && javaProject.exists()) {
                        try {
                            javaProject.close();
                        } catch (JavaModelException jme) {
                            // Just Ignore
                        }
                        return;
                    }

                    operation = new ConvertProjectOperation(project, true, true);
                    operation.setInitialDependencies(new String[] { "org.eclipse.egf.model.ftask" });//$NON-NLS-1$
                    operation.setInitialSourceFolders(new String[] { "src" });//$NON-NLS-1$
                }

            } else if (patterns.isEmpty() && tasks.isEmpty() == false) {
                operation = new ConvertProjectOperation(project, true, true);
                operation.setInitialDependencies(new String[] { "org.eclipse.egf.model.ftask" });//$NON-NLS-1$
                operation.setInitialSourceFolders(new String[] { "src" });//$NON-NLS-1$
            } else {

                operation = new ConvertProjectOperation(project, true, true);
                operation.setInitialDependencies(new String[] { "org.eclipse.egf.pattern", "org.eclipse.egf.pattern.ftask" });//$NON-NLS-1$
                operation.setInitialSourceFolders(new String[] { "generated" });//$NON-NLS-1$

            }
            // synchronous operation, runned in thread UI
            try {
                if (operation != null) {
                    _window.run(false, false, operation);
                    _window.getWorkbench().getDisplay().readAndDispatch();
                }
            } catch (InterruptedException ie) {
                // Nothing to do
            } catch (Exception e) {
                ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), e);
            }

        }

    }

}
