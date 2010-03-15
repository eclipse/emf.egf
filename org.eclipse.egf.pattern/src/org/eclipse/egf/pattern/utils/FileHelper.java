/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class FileHelper {

  public static void setContent(IFile file, String source) throws CoreException {
    setContent(file, new ByteArrayInputStream(source.getBytes()));
  }

  private static void setContent(IFile file, InputStream source) throws CoreException {
    if (file.exists())
      file.setContents(source, true, true, null);
    else {
      createParentfolders(file.getProject(), file.getProjectRelativePath().removeLastSegments(1));
      file.create(source, true, null);
    }
  }

  private static void createParentfolders(IProject project, IPath folderPath) throws CoreException {
    if (folderPath.isEmpty())
      return;
    IFolder folder = project.getFolder(folderPath);
    if (folder == null)
      throw new IllegalStateException();
    if (!folder.exists()) {
      createParentfolders(project, folderPath.removeLastSegments(1));
      folder.create(true, true, null);
    }
  }

  /**
   * This method tries to read a file from the project and then from the
   * plugins.
   * 
   */
  public static String getContent(String pluginId, IProject project, IPath templatePath) throws CoreException, IOException {
    IFile file = project.getFile(templatePath);
    if (file == null)
      throw new IllegalStateException();
    if (file.exists())
      return getFileContent(file);

    Bundle bundle = Platform.getBundle(pluginId);
    if (bundle == null)
      throw new IllegalArgumentException(Messages.bind(Messages.fileHelper_error1, pluginId));

    URL entry = bundle.getEntry(templatePath.toPortableString());
    if (entry == null)
      throw new IllegalStateException(Messages.bind(Messages.fileHelper_error2, templatePath.toPortableString(), pluginId));

    return getContent(entry.openStream());
  }

  /**
   * Reads a file from a plugin who lives in the workspace or RT. If the file
   * doesn't exist an empty string is returned.
   * 
   */
  public static String getContent(IPlatformFcore component, URI uri) throws CoreException, IOException {
    if (component == null)
      throw new IllegalArgumentException(Messages.fileHelper_error3);
    IProject project = component.getPlatformBundle().getProject();
    if (project != null) {
      IFile file = project.getFile(uri.path());
      if (file == null)
        throw new IllegalStateException();
      if (!file.exists())
        return EGFCommonConstants.EMPTY_STRING;
      return getFileContent(file);
    }

    Bundle bundle = component.getPlatformBundle().getBundle();
    if (bundle == null)
      throw new IllegalArgumentException(Messages.bind(Messages.fileHelper_error1, component.getPlatformBundle().getBundleId()));
    URL entry = bundle.getEntry(uri.path());
    if (entry == null)
      throw new IllegalStateException(Messages.bind(Messages.fileHelper_error2, uri.toString(), component.getPlatformBundle().getBundleId()));

    return getContent(entry.openStream());

  }

  public static String getFileContent(IFile file) throws CoreException, IOException {
    return getContent(file.getContents());
  }

  private static String getContent(InputStream contents) throws CoreException, IOException {
    byte[] buf = null;
    try {
      buf = new byte[contents.available()];
      contents.read(buf);
    } finally {
      if (contents != null)
        contents.close();
    }
    return new String(buf);
  }

}
