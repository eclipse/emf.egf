/**
 *  Copyright (c) 2009-2010 Soyatec.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Soyatec - initial API and implementation
 */
package org.eclipse.egf.common.loader;

import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 *
 */
public class JavaClassLoaderFactory {

    private JavaClassLoaderFactory() {
        // Prevent Instantiation
    }

    public static URL getURL(IPath location) {
        // Analyse location
        IPath path = location;
        // Ignore
        if (path == null) {
            return null;
        }
        try {
            // file or directory
            if (path.toFile() != null) {
                if (path.toFile().isAbsolute()) {
                    return new URL(path.toFile().toURI().toURL().toExternalForm());
                }
            }
        } catch (Throwable t) {
            EGFCommonPlugin.getDefault().logWarning(t);
        }
        return null;
    }

    public static List<URL> getURLs(IJavaProject project) throws CoreException {
        return getURLs(project, new UniqueEList<IJavaProject>());
    }

    public static List<URL> getURLs(IJavaProject project, List<IJavaProject> visited) throws CoreException {
        List<URL> urls = new UniqueEList<URL>();
        // Ignore
        if (project == null) {
            return urls;
        }
        // Already processed
        if (visited != null && visited.contains(project)) {
            return urls;
        }
        // Process local project stuff and parent project stuff
        try {
            // Always add the current project
            URL url = getURL(project.getProject().getLocation());
            if (url != null) {
                urls.add(url);
            }
            // Default Output location analysis
            IFolder folder = FileHelper.getFolder(project.getOutputLocation());
            if (folder != null) {
                url = getURL(folder.getLocation());
                if (url != null) {
                    urls.add(url);
                }
            }
            // Classpath Source, Library, Variables and Containers analysis
            for (IClasspathEntry entry : project.getResolvedClasspath(true)) {
                // Source
                if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
                    folder = FileHelper.getFolder(entry.getOutputLocation());
                    if (folder != null) {
                        url = getURL(folder.getLocation());
                        if (url != null) {
                            urls.add(url);
                        }
                    }
                }
                // Library
                else if (entry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
                    url = getURL(entry.getPath());
                    if (url != null) {
                        urls.add(url);
                    }
                }
                // Variables
                else if (entry.getEntryKind() == IClasspathEntry.CPE_VARIABLE) {
                    url = getURL(entry.getPath());
                    if (url != null) {
                        urls.add(url);
                    }
                }
                // Container
                else if (entry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
                    IClasspathContainer classpathContainer = JavaCore.getClasspathContainer(entry.getPath(), project);
                    if (classpathContainer != null) {
                        for (IClasspathEntry innerEntry : classpathContainer.getClasspathEntries()) {
                            if (innerEntry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
                                url = getURL(innerEntry.getPath());
                                if (url != null) {
                                    urls.add(url);
                                }
                            } else if (innerEntry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
                                IJavaProject innerJavaProject = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(innerEntry.getPath().toString()));
                                if (innerJavaProject != null && innerJavaProject.exists() && innerJavaProject.isOpen()) {
                                    urls.addAll(getURLs(innerJavaProject, visited));
                                }
                            }
                        }
                    }
                }
                // Project
                else if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
                    IJavaProject innerJavaProject = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(entry.getPath().toString()));
                    if (innerJavaProject != null && innerJavaProject.exists() && innerJavaProject.isOpen()) {
                        urls.addAll(getURLs(innerJavaProject, visited));
                    }
                }
            }
            // At this stage we visited this Java project
            if (visited != null) {
                visited.add(project);
            }
        } catch (Throwable t) {
            throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCommonMessages.JavaProject_AnalysisFailure, project.getProject().getName()), t));
        }
        return urls;
    }

}
