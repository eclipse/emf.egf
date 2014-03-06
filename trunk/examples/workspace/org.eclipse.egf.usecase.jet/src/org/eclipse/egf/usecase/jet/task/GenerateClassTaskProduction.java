/**
 * <copyright>
 * 
 * Copyright (c) 2011 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.usecase.jet.task;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * 
 * @author Florian Barbin
 * 
 */
public class GenerateClassTaskProduction implements ITaskProduction {

	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		String outputContentString = productionContext.getInputValue("value",
				String.class);
		String outputFolder = productionContext.getInputValue("outputFolder", String.class);
		String fileName = productionContext.getInputValue("fileName",
				String.class);
		String projectName = productionContext.getInputValue("projectName",
				String.class);
		ByteArrayInputStream outputContent = new ByteArrayInputStream(
				outputContentString.getBytes());
		try {
			IFile file = getFile(fileName, projectName, outputFolder);
			if (file.exists())
				file.setContents(outputContent, true, false, null);
			else
				file.create(outputContent, true, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		// do nothing
	}

	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		// do nothing
	}

	private IFile getFile(String fileName, String projectName,
			String outputFolder) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);

		// build the class resource path
		IPath path = new Path(""); //$NON-NLS-1$

		for (String member : outputFolder.split("\\.|/|\\\\")) { //$NON-NLS-1$
			path = path.append(member);
			IFolder folder = project.getFolder(path);
			if (!folder.exists())
				folder.create(true, true, null);
		}

		path = path.append(fileName);

		return project.getFile(path);
	}

}
