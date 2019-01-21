/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.file.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * @author Benoit Langlois
 * 
 */
public class FileUtil {

  /*
   * Get existing file
   */
  public static IFile getExistingFile(String projectName, String folder, String fileName) {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IProject project = root.getProject(projectName);

    IPath path = new Path(""); //$NON-NLS-1$

    if (folder != null && folder.trim().length() > 0)
      for (String member : folder.split("\\.|/|\\\\")) { //$NON-NLS-1$
        path = path.append(member);
        IFolder aFolder = project.getFolder(path);
        if (!aFolder.exists())
          return null;
      }

    path = path.append(fileName);

    return project.getFile(path);
  }

  /*
   * Get file where contents is to be written
   * Not existing folders are created
   */
  public static IFile getNewFile(String projectName, String folder, String fileName) throws CoreException {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IProject project = root.getProject(projectName);

    // build the class resource path
    IPath path = new Path(""); //$NON-NLS-1$

    if (folder != null && folder.trim().length() > 0)
      for (String member : folder.split("\\.|/|\\\\")) { //$NON-NLS-1$
        path = path.append(member);
        IFolder aFolder = project.getFolder(path);
        if (!aFolder.exists())
          aFolder.create(true, true, null);
      }

    path = path.append(fileName);

    return project.getFile(path);
  }

}
