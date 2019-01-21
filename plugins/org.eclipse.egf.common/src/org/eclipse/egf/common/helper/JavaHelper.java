/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S and others
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
package org.eclipse.egf.common.helper;

import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class JavaHelper {

    private JavaHelper() {
        // Prevent Instantiation
    }

    public static String dropNonWordCharacterWith(String value, String replacement) {
        if (value == null) {
            return null;
        }
        if (replacement != null) {
            return value.replaceAll("\\W", replacement); //$NON-NLS-1$
        }
        return dropNonWordCharacter(value);
    }

    public static String dropNonWordCharacter(String value) {
        if (value == null) {
            return null;
        }
        return value.replaceAll("\\W", ""); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public static String dropNonWordCharacterExcept(String value, String except) {
        if (value == null) {
            return null;
        }
        if (except != null) {
            return value.replaceAll("\\W^" + except, ""); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return dropNonWordCharacter(value);
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
        IFolder folder = FileHelper.getFolder(project.getOutputLocation());
        if (folder != null) {
            folders.add(folder);
        }
        // Lookup in source folders
        for (IClasspathEntry entry : project.getResolvedClasspath(true)) {
            if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
                IFolder innerFolder = FileHelper.getFolder(entry.getOutputLocation());
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
     *            The project we seek the output folders of.
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
     * Locate in source folders and Delete a java file.
     * Optionally delete its parent folder if they are empty.
     * Source folder is never deleted.
     * 
     * @param monitor 
     * @param project
     * @param folderName
     * @param packageName
     * @param className
     * @param deleteParent
     */
    public static boolean deleteJavaResource(IProgressMonitor monitor, IProject project, String folderName, String packageName, String className, boolean deleteParent) throws CoreException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, 300);
        subMonitor.beginTask(null, 300);
        if (project == null || packageName == null) {
            subMonitor.worked(300);
            return false;
        }
        // IJavaProject lookup
        IJavaProject javaProject = null;
        try {
            // Exist
            if (project.exists() == false) {
                subMonitor.worked(300);
                return false;
            }
            // Open if necessary
            if (project.isAccessible() == false) {
                project.open(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
            }
            subMonitor.worked(100);
            // JavaProject
            if (project.hasNature(JavaCore.NATURE_ID)) {
                javaProject = JavaCore.create(project);
            }
            if (javaProject == null) {
                subMonitor.worked(200);
                return false;
            }
            // Source folder
            IFolder root = JavaHelper.getSourceFolder(javaProject, folderName);
            if (root == null) {
                subMonitor.worked(200);
                return false;
            }
            IResource resource = null;
            IContainer container = null;
            // Locate the resource
            if (className != null) {
                IPath targetPath = new Path(FileHelper.convertPackageNameToFolderPath(packageName)).append(className + ".java"); //$NON-NLS-1$
                resource = root.findMember(targetPath);
            } else {
                IPath targetPath = new Path(FileHelper.convertPackageNameToFolderPath(packageName));
                container = (IContainer) root.findMember(targetPath);
            }
            if (resource != null && resource.exists()) {
                return FileHelper.deleteIResource(subMonitor.newChild(200, SubMonitor.SUPPRESS_NONE), root, resource, deleteParent);
            }
            if (container != null && container.exists() && (container.members() == null || container.members().length == 0)) {
                return FileHelper.deleteIResource(subMonitor.newChild(200, SubMonitor.SUPPRESS_NONE), root, container, deleteParent);
            }
            subMonitor.worked(200);
        } finally {
            try {
                if (javaProject != null) {
                    javaProject.close();
                }
            } catch (JavaModelException t) {
                // Ignore
            }
        }
        return true;
    }

    /**
     * Locate in source folders and Delete a java file.
     * Optionally delete its parent folder if they are empty.
     * Source folder is never deleted.
     * 
     * @param monitor 
     * @param project
     * @param folderName
     * @param oldPackageName
     * @param oldClassName
     * @param newPackageName
     * @param newClassName 
     * @param deleteParent 
     */
    public static boolean moveJavaResource(IProgressMonitor monitor, IProject project, String folderName, String oldPackageName, String oldClassName, String newPackageName, String newClassName, boolean deleteParent) throws CoreException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, 300);
        subMonitor.beginTask(null, 300);
        if (project == null || oldPackageName == null || newPackageName == null) {
            subMonitor.worked(300);
            return false;
        }
        // IJavaProject lookup
        IJavaProject javaProject = null;
        try {
            // Exist
            if (project.exists() == false) {
                subMonitor.worked(300);
                return false;
            }
            // Open if necessary
            if (project.isAccessible() == false) {
                project.open(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
            }
            subMonitor.worked(100);
            // JavaProject
            if (project.hasNature(JavaCore.NATURE_ID)) {
                javaProject = JavaCore.create(project);
            }
            if (javaProject == null) {
                subMonitor.worked(200);
                return false;
            }
            // Source folder
            IFolder root = JavaHelper.getSourceFolder(javaProject, folderName);
            if (root == null) {
                subMonitor.worked(200);
                return false;
            }
            IResource resourceToMove = null;
            IContainer container = null;
            // Locate the resource
            if (oldClassName != null) {
                resourceToMove = root.findMember(new Path(FileHelper.convertPackageNameToFolderPath(oldPackageName)).append(oldClassName + ".java")); //$NON-NLS-1$
                container = (IContainer) root.findMember(new Path(FileHelper.convertPackageNameToFolderPath(oldPackageName)));
            } else {
                resourceToMove = root.findMember(new Path(FileHelper.convertPackageNameToFolderPath(oldPackageName)));
                if (resourceToMove != null && resourceToMove.exists()) {
                    container = resourceToMove.getParent();
                }
            }
            if (resourceToMove == null || resourceToMove.exists() == false) {
                subMonitor.worked(200);
                return false;
            }
            // Move the resource
            if (newClassName != null) {
                IPath targetPath = new Path(FileHelper.convertPackageNameToFolderPath(newPackageName)).append(newClassName + ".java"); //$NON-NLS-1$ 
                IResource targetResource = root.getFile(targetPath);
                if (targetResource.exists() == false) {
                    FileHelper.createContainers(new NullProgressMonitor(), targetResource);
                    resourceToMove.move(targetResource.getFullPath(), false, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
                } else {
                    return FileHelper.deleteIResource(subMonitor.newChild(200, SubMonitor.SUPPRESS_NONE), root, resourceToMove, deleteParent);
                }
            } else {
                IPath targetPath = root.getFullPath().append(new Path(FileHelper.convertPackageNameToFolderPath(newPackageName)));
                resourceToMove.move(targetPath, false, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
            }
            if (container != null && container.exists() && (container.members() == null || container.members().length == 0)) {
                return FileHelper.deleteIResource(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), root, container, deleteParent);
            }
            subMonitor.worked(100);
        } finally {
            try {
                if (javaProject != null) {
                    javaProject.close();
                }
            } catch (JavaModelException t) {
                // Ignore
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
     * Get a java source folder from its name.<br>
     * 
     * @param project
     * @param name
     * @return null if it could not be found.
     */
    public static IFolder getSourceFolder(IJavaProject project, String name) throws CoreException {
        if (project == null || name == null) {
            return null;
        }
        List<IFolder> folders = getSourceFolders(project);
        // Lookup in source folders
        for (IFolder folder : folders) {
            if (folder.getName().equals(name)) {
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
                IFolder innerFolder = FileHelper.getFolder(entry.getPath());
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
