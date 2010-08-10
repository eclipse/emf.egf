/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.dev.pattern.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EGFResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.dev.Activator;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.PatternConstants;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * @author Matthieu Helleboid
 * 
 */
public class DeleteUnusedTemplatesAction implements IWorkbenchWindowActionDelegate {

    private IWorkbenchWindow _window;

    public DeleteUnusedTemplatesAction() {
    }

    public void run(IAction action) {
        final List<Pattern> patterns = new ArrayList<Pattern>(200);
        Set<IFolder> folders = new HashSet<IFolder>();

        IPlatformFcore[] platformFcores = EGFCorePlugin.getWorkspacePlatformFcores();
        ResourceSet resourceSet = new EGFResourceSet();
        try {
            for (IPlatformFcore platformFcore : platformFcores) {
                URI uri = platformFcore.getURI();
                Resource res = resourceSet.getResource(uri, true);
                PatternCollector.INSTANCE.collect(res.getContents(), patterns, PatternCollector.EMPTY_ID_SET);

                IProject project = platformFcore.getPlatformBundle().getProject();
                IFolder folder = project.getFolder(PatternPreferences.getTemplatesFolderName());
                if (folder.exists())
                    folders.add(folder);
            }

            for (IFolder folder : folders) {
                folder.accept(new IResourceVisitor() {

                    public boolean visit(IResource resource) throws CoreException {
                        if (resource.getType() == IResource.FILE) {
                            if (PatternConstants.PATTERN_UNIT_FILE_EXTENSION.equals(resource.getFileExtension())) {
                                if (!found(patterns, resource)) {
                                    delete(resource);
                                    if (resource.getParent().getType() == IResource.FOLDER) {
                                        IFolder folder = (IFolder) resource;
                                        if (folder.members().length == 0)
                                            delete(resource);
                                    }
                                }
                            }

                            return false;
                        }

                        return true;
                    }

                    private void delete(IResource resource) throws CoreException {
                        System.out.println("Will delete " + resource); //$NON-NLS-1$
                        resource.delete(true, new NullProgressMonitor()); 
                    }

                    private boolean found(final List<Pattern> patterns, IResource resource) {
                        for (Pattern pattern : patterns) {
                            IPlatformFcore platformFcore = EGFCorePlugin.getPlatformFcore(pattern.eResource());
                            IProject project = platformFcore.getPlatformBundle().getProject();
                            if (project.equals(resource.getProject())) {
                                for (PatternMethod method : pattern.getMethods()) {
                                    IFile methodFile = project.getFile(method.getPatternFilePath().toFileString());
                                    if (methodFile.equals(resource)) {
                                        return true;
                                    }
                                }
                            }
                        }
                        return false;
                    }
                });
            }
        } catch (Exception e) {
            MessageDialog.openError(_window.getShell(), "Error", e.getMessage()); //$NON-NLS-1$
            Activator.getDefault().logError(e);
        }

        System.out.println("finished"); //$NON-NLS-1$
    }

    /**
     * Selection in the workbench has been changed. We
     * can change the state of the 'real' action here
     * if we want, but this can only happen after
     * the delegate has been created.
     * 
     * @see IWorkbenchWindowActionDelegate#selectionChanged
     */
    public void selectionChanged(IAction action, ISelection selection) {
        // Nothing to do
    }

    /**
     * We can use this method to dispose of any system
     * resources we previously allocated.
     * 
     * @see IWorkbenchWindowActionDelegate#dispose
     */
    public void dispose() {
        // Nothing to do
    }

    /**
     * We will cache window object in order to
     * be able to provide parent shell for the message dialog.
     * 
     * @see IWorkbenchWindowActionDelegate#init
     */
    public void init(IWorkbenchWindow window) {
        _window = window;
    }

}
