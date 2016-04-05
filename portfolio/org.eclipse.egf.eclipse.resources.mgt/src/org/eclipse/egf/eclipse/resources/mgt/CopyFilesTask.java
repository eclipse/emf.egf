/**
 * <copyright>
 * 
 * Copyright (c) 2016 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.eclipse.resources.mgt;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * Copy files to a plug-in folder.
 * 
 * @author Guillaume Gebhart
 */
public class CopyFilesTask implements ITaskProduction {

	private static final String CONTRACT_PLUGIN_ID_TAG = "plugin_id";  //$NON-NLS-1$
	private static final String DESTINATION_PATH = "destination_path"; //$NON-NLS-1$
	private static final String SOURCE_PATH = "source_path"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.egf.ftask.producer.invocation.ITaskProduction#doExecute(org
	 * .eclipse.egf.ftask.producer.context.ITaskProductionContext,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		IFolder source = getSourceFolder(productionContext);
		IFolder destination = getDestinationFolder(productionContext);
		try {
			copy(source, destination);
		} catch (CoreException e) {
			throw new InvocationException(e);
		}
	}

	private void copy(IFolder source, IFolder destination) throws CoreException {
		for (IResource resource : source.members()) 
		{
			if (resource.getType() == IResource.FILE) 
			{
				copy((IFile) resource, destination);
			}
		}
	}

	private void copy(IFile file, IFolder destination) throws CoreException {
		IFile destinationFile = destination.getFile(file.getName());
		if (destinationFile.exists()) 
		{
			// The file exists. We have to delete it.
			destinationFile.delete(true, new NullProgressMonitor());
		}
		file.copy(destinationFile.getFullPath(), true, new NullProgressMonitor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.egf.ftask.producer.invocation.ITaskProduction#postExecute
	 * (org.eclipse.egf.ftask.producer.context.ITaskProductionContext,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		// refresh destination path
		IFolder folder = getDestinationFolder(productionContext);
		try {
			folder.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			throw new InvocationException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.egf.ftask.producer.invocation.ITaskProduction#preExecute(
	 * org.eclipse.egf.ftask.producer.context.ITaskProductionContext,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		// refresh source and destination path.
		IFolder source = getSourceFolder(productionContext);
		IFolder destination = getDestinationFolder(productionContext);
		try {
			source.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
			destination.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			throw new InvocationException(e);
		}
	}

	private String getPluginId(ITaskProductionContext context)
			throws InvocationException {
		return context.getInputValue(CONTRACT_PLUGIN_ID_TAG, String.class);
	}

	private String getDestinationPath(ITaskProductionContext context)
			throws InvocationException {
		return context.getInputValue(DESTINATION_PATH, String.class);
	}

	private String getSourcePath(ITaskProductionContext context)
			throws InvocationException {
		return context.getInputValue(SOURCE_PATH, String.class);
	}

	private IFolder getDestinationFolder(ITaskProductionContext context)
			throws InvocationException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getPluginId(context));
		return project.getFolder(new Path(getDestinationPath(context)));
	}

	private IFolder getSourceFolder(ITaskProductionContext context)
			throws InvocationException {
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(getSourcePath(context)));
	}

}
