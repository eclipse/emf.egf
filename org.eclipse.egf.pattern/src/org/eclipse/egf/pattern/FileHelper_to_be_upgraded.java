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

package org.eclipse.egf.pattern;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

/**
 * At this time, this helper is only able to access workspace files...
 * 
 * @author Guiu
 *
 */
public class FileHelper_to_be_upgraded {

	public static void setContent(String pluginId, IPath path, InputStream source) throws CoreException {
		if (path.isEmpty())
			throw new IllegalArgumentException("Path is empty");
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
		if (project == null)
			throw new IllegalStateException("Cannot get project");
		IFile file = project.getFile(path);
		if (file == null)
			throw new IllegalStateException("Target file is null");
		if (file.exists())
			file.setContents(source, true, true, null);
		else {
			createParentfolders(project, path.removeLastSegments(1));
			file.create(source, true, null);
		}
		
	}
	
	private static void createParentfolders(IProject project, IPath folderPath) throws CoreException {
		if (folderPath.isEmpty())
			return ;
		IFolder folder = project.getFolder(folderPath);
		if (folder == null)
			throw new IllegalStateException();
		if (!folder.exists())
		{
			createParentfolders(project, folderPath.removeLastSegments(1));
			folder.create(true, true, null);
		}
	}

	public static String getContent(String pluginId, URI uri) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
		if (project == null)
			throw new IllegalStateException();
		IFile file = project.getFile(uri.path());
		if (file == null)
			throw new IllegalStateException();
		if (!file.exists())
			return "";
		byte[] buf = null;
		InputStream contents = null;
		try {
			contents = file.getContents();
			buf = new byte[contents.available()];
			contents.read(buf);
		} catch (Exception e) {
			Activator.getDefault().logError(e);
			return "";
		}
		finally
		{
			if (contents != null)
				try {
					contents.close();
				} catch (IOException e) {
					Activator.getDefault().logError(e);
				}
		}
		return new String(buf);
	}

}
