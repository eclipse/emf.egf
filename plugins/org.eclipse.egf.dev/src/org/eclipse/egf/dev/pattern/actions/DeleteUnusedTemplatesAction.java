/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.pattern.PatternFolders;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.dev.Activator;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * @author Matthieu Helleboid
 * 
 */
public class DeleteUnusedTemplatesAction implements IWorkbenchWindowActionDelegate {

	public DeleteUnusedTemplatesAction() {
		// Nothing to do
	}

	public void run(IAction action) {
		final List<Pattern> patterns = new ArrayList<Pattern>(200);
		Set<IFolder> folders = new HashSet<IFolder>();

		IPlatformFcore[] platformFcores = EGFPlatformPlugin.getPlatformManager().getWorkspacePlatformExtensionPoints(IPlatformFcore.class);
		ResourceSet resourceSet = new EgfResourceSet();
		try {
			for (IPlatformFcore platformFcore : platformFcores) {
				URI uri = platformFcore.getURI();
				Resource res = resourceSet.getResource(uri, true);
				PatternCollector.INSTANCE.collect(res.getContents(), patterns, PatternCollector.EMPTY_ID_SET);

				IProject project = platformFcore.getPlatformBundle().getProject();
				IFolder folder = project.getFolder(PatternFolders.getTemplatesFolderName());
				if (folder.exists())
					folders.add(folder);
			}

			for (IFolder folder : folders) {

				folder.accept(new IResourceVisitor() {

					public boolean visit(IResource resource) throws CoreException {
						if (resource.getType() == IResource.FILE) {
							if (TemplateModelFileHelper.PATTERN_UNIT_FILE_EXTENSION.equals(resource.getFileExtension())) {
								if (!found(patterns, resource)) {
									delete(resource);
									if (resource.getParent().getType() == IResource.FOLDER) {
										IFolder innerFolder = (IFolder) resource.getParent();
										if (innerFolder.members().length == 0)
											delete(innerFolder);
									}
								}
							}
							return false;
						}
						return true;
					}

					private void delete(IResource resource) throws CoreException {
						Activator.getDefault().logInfo("Will delete " + resource); //$NON-NLS-1$
						resource.delete(true, new NullProgressMonitor());
					}

					private boolean found(final List<Pattern> innerPatterns, IResource resource) {
						for (Pattern pattern : innerPatterns) {
							IProject project = ((IPlatformFcoreProvider) pattern.eResource()).getIPlatformFcore().getPlatformBundle().getProject();
							if (project.equals(resource.getProject())) {
								for (PatternMethod method : pattern.getMethods()) {
									IFile methodFile = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(method.getPatternFilePath().toPlatformString(true));
									if (methodFile != null && methodFile.equals(resource)) {
										return true;
									}
								}
							}
						}
						return false;
					}

				});

			}
		} catch (Throwable t) {
			ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), t);
		}
		Activator.getDefault().logInfo("finished"); //$NON-NLS-1$
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
		// Nothing to do
	}

}
