/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.common.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;

public class JavaHelper {

  private JavaHelper() {
    // Prevent Instantiation
  }

  private static IFolder findFolder(IPath path) {
    if (path == null) {
      return null;
    }
    IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
    if (resource == null || resource instanceof IFolder == false) {
      return null;
    }
    return (IFolder) resource;
  }

  public static String getFileName(Class<?> clazz) {
    if (clazz == null) {
      return null;
    }
    return "/" + clazz.getName().replaceAll("[.]", "/") + ".class"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  }

  public static URL getResourceURL(Class<?> clazz) {
    try {
      String name = getFileName(clazz);
      if (name == null) {
        return null;
      }
      return clazz.getResource(name);
    } catch (Throwable t) {
      // Nothing to do
    }
    return null;
  }

  public static URL getFileURL(Class<?> clazz) {
    try {
      String name = getFileName(clazz);
      if (name == null) {
        return null;
      }
      URL url = clazz.getResource(name);
      if (url != null) {
        return FileLocator.resolve(url);
      }
    } catch (Throwable t) {
      // Nothing to do
    }
    return null;
  }

  public static ClassLoader getProjectClassLoader(IJavaProject project) throws CoreException {
    List<URL> urls = getProjectURLs(project, new HashSet<IJavaProject>());
    return new URLClassLoader(urls.toArray(new URL[urls.size()]), JavaHelper.class.getClassLoader());
  }

  public static List<URL> getProjectURLs(IJavaProject javaProject, Set<IJavaProject> visited) throws CoreException {
    List<URL> urls = new UniqueEList<URL>();
    // Do we need to process this IJavaProject
    if (visited.contains(javaProject)) {
      return urls;
    }
    // Process current IJavaProject
    visited.add(javaProject);
    try {
      // Default Output Location
      IFolder folder = findFolder(javaProject.getOutputLocation());
      if (folder != null) {
        urls.add(new URL("file://" + folder.getLocation().toOSString() + EGFCommonConstants.SLASH_CHARACTER)); //$NON-NLS-1$
      }
      // Classpath Lookup
      for (IClasspathEntry entry : javaProject.getResolvedClasspath(true)) {
        if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
          folder = findFolder(entry.getOutputLocation());
          if (folder != null) {
            urls.add(new URL("file://" + folder.getLocation().toOSString() + EGFCommonConstants.SLASH_CHARACTER)); //$NON-NLS-1$
          }
        } else if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
          IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(entry.getPath().toString());
          IJavaProject innerJavaProject = JavaCore.create(project);
          if (project.exists()) {
            urls.addAll(getProjectURLs(innerJavaProject, visited));
          }
        } else if (entry.getEntryKind() == IClasspathEntry.CPE_LIBRARY || entry.getEntryKind() == IClasspathEntry.CPE_VARIABLE) {
          urls.add(getURL(entry.getPath()));
        } else if (entry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
          IClasspathContainer classpathContainer = JavaCore.getClasspathContainer(entry.getPath(), javaProject);
          if (classpathContainer != null) {
            for (IClasspathEntry classpathEntry : classpathContainer.getClasspathEntries()) {
              urls.add(getURL(classpathEntry.getPath()));
            }
          }
        }
      }
    } catch (Throwable t) {
      throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCommonMessages.JavaHelper_AnalysingFailure, javaProject.getProject().getName()), t));
    }
    return urls;
  }

  private static URL getURL(IPath entry) throws MalformedURLException {
    String path = null;
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    // workspace relative path
    IPath location = root.getFile(entry).getLocation();
    if (location != null) {
      path = location.toOSString();
    }
    // absolute path
    if (path == null) {
      path = entry.toOSString();
    }
    // Check whether or not we face a folder or a file
    if (entry.toFile() != null && entry.toFile().isDirectory() == false) {
      return new URL("file://" + path); //$NON-NLS-1$
    }
    return new URL("file://" + path + EGFCommonConstants.SLASH_CHARACTER); //$NON-NLS-1$    
  }

  /**
   * Get output folders.<br>
   * 
   * @param project
   * @return a List of IFolders
   */
  public static List<IFolder> getOutputFolders(IJavaProject project) throws CoreException {
    List<IFolder> folders = new UniqueEList<IFolder>();
    if (project == null || project.exists() == false) {
      return folders;
    }
    // Default Output Location
    IFolder folder = findFolder(project.getOutputLocation());
    if (folder != null) {
      folders.add(folder);
    }
    // Lookup in source folders
    for (IClasspathEntry entry : project.getResolvedClasspath(true)) {
      if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
        IFolder innerFolder = findFolder(entry.getOutputLocation());
        if (innerFolder != null) {
          folders.add(innerFolder);
        }
      }
    }
    return folders;
  }

  /**
   * This will return the set of output folders name for the given
   * project.
   * <p>
   * For example, if a project has a source folder "src" with its output folder
   * set as "bin" and a source
   * folder "src-gen" with its output folder set as "bin-gen", this will return
   * a List containing
   * both "bin" and "bin-gen".
   * </p>
   * 
   * @param project
   *          The project we seek the output folders of.
   * @return The set of output folders name for the given (java) project.
   */
  public static List<String> getStringOutputFolders(IJavaProject project) throws CoreException {
    List<String> outputFoldersAsString = new UniqueEList<String>();
    if (project.exists() == false) {
      return outputFoldersAsString;
    }
    List<IFolder> outputFolders = getOutputFolders(project);
    for (IFolder outputFolder : outputFolders) {
      outputFoldersAsString.add(outputFolder.getFullPath().removeFirstSegments(1).toString());
    }
    return outputFoldersAsString;
  }

  /**
   * Locate in source folders and Delete a java class file.
   * Optionally delete its parent folder if they are empty.
   * Source folder is never deleted.
   * 
   * @param project
   * @param path
   * @param deleteParent
   */
  public static boolean deleteClass(IJavaProject project, IPath path, boolean deleteParent) throws CoreException {
    if (project == null || path == null) {
      return false;
    }
    // Retrieve the java source folder who contain the resource path
    IFolder sourceFolder = JavaHelper.getSourceFolder(project, path);
    if (sourceFolder == null) {
      return false;
    }
    // Locate the resource path member
    IResource resource = sourceFolder.findMember(path);
    if (resource == null || resource instanceof IFile == false) {
      return false;
    }
    // Delete found resource member
    if (FileHelper.deleteResource(resource) == false) {
      return false;
    }
    // Delete children container if they are empty
    if (deleteParent) {
      IContainer container = (IContainer) sourceFolder.findMember(path.removeLastSegments(1));
      while (container.equals(sourceFolder) == false) {
        try {
          IResource[] members = container.members();
          if (members == null || members.length == 0) {
            if (FileHelper.deleteResource(container)) {
              container = container.getParent();
            } else {
              break;
            }
          } else {
            break;
          }
        } catch (CoreException ce) {
          break;
        }
      }
    }
    return true;
  }

  /**
   * Get a java source IFile within a IJavaProject.<br>
   * 
   * @param project
   * @param path
   * @return null if it could not be found.
   */
  public static IFile getSourceFile(IJavaProject project, IPath path) throws CoreException {
    if (project == null || path == null) {
      return null;
    }
    List<IFolder> folders = getSourceFolders(project);
    // Lookup in source folders
    for (IFolder folder : folders) {
      // Check if a resource exist in this folder
      IResource resource = folder.findMember(path);
      if (resource != null && resource instanceof IFile) {
        // We got it, we return the current java source folder
        return (IFile) resource;
      }
    }
    return null;
  }

  /**
   * Get a java source folder who contain an IPath.<br>
   * 
   * @param project
   * @param path
   * @return null if it could not be found.
   */
  public static IFolder getSourceFolder(IJavaProject project, IPath path) throws CoreException {
    if (project == null || path == null) {
      return null;
    }
    List<IFolder> folders = getSourceFolders(project);
    // Lookup in source folders
    for (IFolder folder : folders) {
      // Check if a resource exist in this folder
      IResource resource = folder.findMember(path);
      if (resource != null) {
        // We got it, we return the current java source folder
        return folder;
      }
    }
    return null;
  }

  /**
   * Get source folders.<br>
   * 
   * @param project
   * @return a List of IFolders
   */
  public static List<IFolder> getSourceFolders(IJavaProject project) throws CoreException {
    List<IFolder> folders = new UniqueEList<IFolder>();
    if (project == null || project.exists() == false) {
      return folders;
    }
    // Lookup in source folders
    for (IClasspathEntry entry : project.getResolvedClasspath(true)) {
      if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
        IFolder innerFolder = findFolder(entry.getPath());
        if (innerFolder != null) {
          folders.add(innerFolder);
        }
      }
    }
    return folders;
  }

  /**
   * Get source and output folders.<br>
   * 
   * @param project
   * @return a List of IFolders
   */
  public static List<IFolder> getSourceAndOutputFolders(IJavaProject project) throws CoreException {
    List<IFolder> folders = new UniqueEList<IFolder>();
    folders.addAll(getSourceFolders(project));
    folders.addAll(getOutputFolders(project));
    return folders;
  }

}
