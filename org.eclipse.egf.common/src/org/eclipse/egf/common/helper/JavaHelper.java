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
 * 
 */
package org.eclipse.egf.common.helper;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;


public class JavaHelper {
  
  /**
   * Locate in source folders and Delete a java class file.
   * Optionally delete its parent folder if they are empty.
   * Source folder is never deleted.
   * @param javaProject_p
   * @param resourcePath_p 
   */  
  public static boolean deleteJavaClass(IJavaProject javaProject_p, IPath resourcePath_p, boolean deleteParent_p) {
    if (javaProject_p == null || resourcePath_p == null) {
      return false;
    }
    // Retrieve the java source folder who contain the resource path
    IFolder sourceFolder = JavaHelper.getJavaSourceFolder(
      javaProject_p, 
      resourcePath_p
    );
    if (sourceFolder == null) {
      return false;
    }
    // Locate the resource path member
    IResource resource = sourceFolder.findMember(resourcePath_p);
    if (resource == null || resource instanceof IFile == false) {
      return false;
    }
    // Delete found resource member
    if (FileHelper.deleteResource(resource) == false) {
      return false;
    }
    // Delete children container if they are empty
    if (deleteParent_p) {
      IContainer container = (IContainer) sourceFolder.findMember(resourcePath_p.removeLastSegments(1));
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
        } catch(CoreException ce) {
          break;
        }
      }
    }    
    return true;
  }
  
  /**
   * Get a java source IFile within a IJavaProject.<br>
   * @param javaProject_p
   * @param name_p 
   * @return null if it could not be found.
   */
  public static IFile getJavaSourceFile(IJavaProject javaProject_p, IPath path_p) {
    if (javaProject_p == null || path_p == null) {
      return null;
    }
    // Lookup in source folders
    try {
      for (IClasspathEntry classpathEntry : javaProject_p.getRawClasspath()) {
        if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
          IResource sourceFolder = ResourcesPlugin.getWorkspace().getRoot().findMember(classpathEntry.getPath());
          if (sourceFolder == null || sourceFolder instanceof IFolder == false) {
            continue;
          }
          // Check if a resource exist in this folder
          IResource resource = ((IFolder) sourceFolder).findMember(path_p);
          if (resource != null && resource instanceof IFile) {
            // We got it, we return the current java source folder
            return (IFile) resource;
          }
        }
      }
    } catch (JavaModelException jme) {
      // Just ignore
    }
    return null;
  }
  
  /**
   * Get a java source folder who contain an IPath.<br>
   * @param javaProject_p
   * @param name_p 
   * @return null if it could not be found.
   */
  public static IFolder getJavaSourceFolder(IJavaProject javaProject_p, IPath path_p) {
    if (javaProject_p == null || path_p == null) {
      return null;
    }
    // Lookup in source folders
    try {
      for (IClasspathEntry classpathEntry : javaProject_p.getRawClasspath()) {
        if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
          IResource sourceFolder = ResourcesPlugin.getWorkspace().getRoot().findMember(classpathEntry.getPath());
          if (sourceFolder == null || sourceFolder instanceof IFolder == false) {
            continue;
          }
          // Check if a resource exist in this folder
          IResource resource = ((IFolder) sourceFolder).findMember(path_p);
          if (resource != null) {
            // We got it, we return the current java source folder
            return (IFolder) sourceFolder;
          }
        }
      }
    } catch (JavaModelException jme) {
      // Just ignore
    }
    return null;
  }    

}
