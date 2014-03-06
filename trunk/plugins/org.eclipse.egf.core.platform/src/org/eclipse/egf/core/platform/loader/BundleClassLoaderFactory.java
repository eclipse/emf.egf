/**
 *  Copyright (c) 2009-2010 Soyatec.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Soyatec - initial API and implementation
 */
package org.eclipse.egf.core.platform.loader;

import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.loader.JavaClassLoaderFactory;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.internal.loader.BundleClassLoader;
import org.eclipse.egf.core.platform.internal.pde.DirectoryBuildModel;
import org.eclipse.egf.core.platform.internal.pde.PlatformClasspathContainer;
import org.eclipse.egf.core.platform.internal.pde.PlatformClasspathContainer.Rule;
import org.eclipse.egf.core.platform.internal.pde.PlatformRequiredPluginsClasspathContainer;
import org.eclipse.egf.core.platform.l10n.CorePlatformMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.PDEClasspathContainer;

/**
 * @author Xavier Maysonnave
 * 
 * TODO fragment are not implemented
 * TODO JRE System Library are not implemented
 *
 */
public class BundleClassLoaderFactory {

    public static List<IPluginModelBase> getProjects(final IPluginModelBase model) throws CoreException {
        List<IPluginModelBase> models = new UniqueEList<IPluginModelBase>();
        // Ignore
        if (model == null) {
            return models;
        }
        IProject project = null;
        if (model.getUnderlyingResource() != null) {
            project = model.getUnderlyingResource().getProject();
        }
        // Classpath entries
        List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();
        // Check whether or not we face a directory or a file
        IPath location = new Path(model.getInstallLocation());
        if (project == null && location.toFile() != null && location.toFile().isDirectory()) {
            // Add a IClasspathEntry to this directory
            if (location.toFile() != null && location.toFile().exists()) {
                PlatformClasspathContainer.addLibraryEntry(location, null, new Rule[0], PlatformClasspathContainer.getClasspathAttributes(model), classpathEntries);
            }
        } else {
            // Create a classpathContainer
            IClasspathContainer classpathContainer = new PlatformRequiredPluginsClasspathContainer(model);
            // Process Required plugins entries
            IClasspathEntry[] entries = classpathContainer.getClasspathEntries();
            if (entries != null) {
                classpathEntries.addAll(Arrays.asList(entries));
            }
        }
        // Populate
        models.addAll(getProjects(model, classpathEntries));
        // Done
        return models;
    }

    public static List<URL> getBundlesURLs(final IPluginModelBase model, List<IProject> visitedProjects) throws CoreException {
        List<URL> urls = new UniqueEList<URL>();
        // Ignore
        if (model == null) {
            return urls;
        }
        IProject project = null;
        if (model.getUnderlyingResource() != null) {
            project = model.getUnderlyingResource().getProject();
            if (project != null) {
                // Already processed
                if (visitedProjects != null && visitedProjects.contains(project)) {
                    return urls;
                }
            }
        }
        // Classpath entries
        List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();
        // Check whether or not we face a directory or a file
        IPath location = new Path(model.getInstallLocation());
        if (project == null && location.toFile() != null && location.toFile().isDirectory()) {
            // Add a IClasspathEntry to this directory
            if (location.toFile() != null && location.toFile().exists()) {
                PlatformClasspathContainer.addLibraryEntry(location, null, new Rule[0], PlatformClasspathContainer.getClasspathAttributes(model), classpathEntries);
            }
            // Process External Entries
            IClasspathEntry[] entries = PDEClasspathContainer.getExternalEntries(model);
            if (entries != null) {
                classpathEntries.addAll(Arrays.asList(entries));
            }
            // build.properties analysis
            location = location.append(ICoreConstants.BUILD_FILENAME_DESCRIPTOR);
            if (location.toFile() != null && location.toFile().exists()) {
                IClasspathContainer classpathContainer = new PlatformRequiredPluginsClasspathContainer(model, new DirectoryBuildModel(location.toFile()).getBuild());
                // Process Required plugins entries
                entries = classpathContainer.getClasspathEntries();
                if (entries != null) {
                    classpathEntries.addAll(Arrays.asList(entries));
                }
            }
        } else {
            // Create a classpathContainer
            IClasspathContainer classpathContainer = new PlatformRequiredPluginsClasspathContainer(model);
            // Process Required plugins entries
            IClasspathEntry[] entries = classpathContainer.getClasspathEntries();
            if (entries != null) {
                classpathEntries.addAll(Arrays.asList(entries));
            }
        }
        // Populate
        urls.addAll(getBundlesURLs(model, classpathEntries, visitedProjects));
        // Return
        return urls;
    }

    protected static List<URL> getBundleURLs(IPluginModelBase model, final List<IClasspathEntry> classpathEntries) throws CoreException {
        List<URL> urls = new UniqueEList<URL>();
        // Ignore
        if (model == null) {
            return urls;
        }
        // Whether or not we are an IProject
        IProject project = null;
        if (model.getUnderlyingResource() != null) {
            project = model.getUnderlyingResource().getProject();
        }
        // Process stuff
        IJavaProject javaProject = null;
        try {
            // Process IProject and IJavaProject if any
            if (project != null) {
                // Always add the current project
                URL url = JavaClassLoaderFactory.getURL(project.getLocation());
                if (url != null) {
                    urls.add(url);
                }
                // Get the IJavaProject if any
                javaProject = JavaCore.create(project);
                // Default Output location analysis
                if (javaProject.exists()) {
                    IFolder folder = FileHelper.getFolder(javaProject.getOutputLocation());
                    if (folder != null) {
                        url = JavaClassLoaderFactory.getURL(folder.getLocation());
                        if (url != null) {
                            urls.add(url);
                        }
                    }
                }
            } else {
                // we always add root
                URL url = JavaClassLoaderFactory.getURL(new Path(model.getInstallLocation()));
                if (url != null) {
                    urls.add(url);
                }
            }
            // Classpath Source, Library, Variables analysis
            for (IClasspathEntry entry : classpathEntries) {
                // Source
                if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
                    IFolder folder = FileHelper.getFolder(entry.getOutputLocation());
                    if (folder != null) {
                        URL url = JavaClassLoaderFactory.getURL(folder.getLocation());
                        if (url != null) {
                            urls.add(url);
                        }
                    }
                }
                // Library
                else if (entry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
                    URL url = JavaClassLoaderFactory.getURL(entry.getPath());
                    if (url != null) {
                        urls.add(url);
                    }
                }
                // Variables
                else if (entry.getEntryKind() == IClasspathEntry.CPE_VARIABLE) {
                    URL url = JavaClassLoaderFactory.getURL(entry.getPath());
                    if (url != null) {
                        urls.add(url);
                    }
                }
            }
        } catch (Throwable t) {
            throw new CoreException(EGFPlatformPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CorePlatformMessages.Bundle_AnalysisFailure, BundleHelper.getBundleId(model)), t));
        } finally {
            if (javaProject != null) {
                try {
                    javaProject.close();
                } catch (Throwable t) {
                    // Just ignore
                }
            }
        }
        return urls;
    }

    protected static List<IPluginModelBase> getProjects(final IPluginModelBase model, final List<IClasspathEntry> classpathEntries) throws CoreException {
        List<IPluginModelBase> models = new UniqueEList<IPluginModelBase>();
        // Ignore
        if (model == null) {
            return models;
        }
        // Process
        try {
            // Local classpath Project analysis
            for (IClasspathEntry entry : classpathEntries) {
                if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
                    IProject innerProject = ResourcesPlugin.getWorkspace().getRoot().getProject(entry.getPath().toString());
                    if (innerProject != null && innerProject.exists() && innerProject.isOpen()) {
                        ModelEntry modelEntry = PluginRegistry.findEntry(innerProject.getName());
                        if (modelEntry != null && modelEntry.getModel() != null) {
                            models.add(modelEntry.getModel());
                            models.addAll(getProjects(modelEntry.getModel()));
                        }
                    }
                }
            }
        } catch (Throwable t) {
            throw new CoreException(EGFPlatformPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CorePlatformMessages.Bundle_AnalysisFailure, BundleHelper.getBundleId(model)), t));
        }
        return models;
    }

    protected static List<URL> getBundlesURLs(final IPluginModelBase model, final List<IClasspathEntry> classpathEntries, List<IProject> visitedProjects) throws CoreException {
        List<URL> urls = new UniqueEList<URL>();
        // Ignore
        if (model == null) {
            return urls;
        }
        IProject project = null;
        if (model.getUnderlyingResource() != null) {
            project = model.getUnderlyingResource().getProject();
            if (project != null) {
                // Already processed
                if (visitedProjects != null && visitedProjects.contains(project)) {
                    return urls;
                }
            }
        }
        // Process local project stuff and parent project stuff
        try {
            // Get project URLs
            urls.addAll(getBundleURLs(model, classpathEntries));
            // Get dependent bundle URLs
            for (IPluginModelBase dependentModel : getProjects(model, classpathEntries)) {
                urls.addAll(getBundlesURLs(dependentModel, visitedProjects));
            }
            // At this stage we visited this project
            if (visitedProjects != null && project != null) {
                visitedProjects.add(project);
            }
        } catch (Throwable t) {
            throw new CoreException(EGFPlatformPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CorePlatformMessages.Bundle_AnalysisFailure, BundleHelper.getBundleId(model)), t));
        }
        return urls;
    }

    public static IBundleClassLoader getBundleClassLoader(final IPluginModelBase model) throws CoreException {
        return getBundleClassLoader(model, null);
    }

    public static IBundleClassLoader getBundleClassLoader(final IPluginModelBase model, final ClassLoader parent) throws CoreException {

        // Ignore
        if (model == null) {
            return null;
        }

        // Debug        
        long startTime = System.currentTimeMillis();
        // Temp all visited parents project
        List<IProject> visitedProjects = new UniqueEList<IProject>();
        // Final with all parents project URLs
        final List<URL> urls = getBundlesURLs(model, visitedProjects);
        // Final all visited parents projects
        final List<IProject> visited = visitedProjects;

        // Debug
        long endTime = System.currentTimeMillis();
        try {

            return AccessController.doPrivileged(new PrivilegedAction<IBundleClassLoader>() {

                public IBundleClassLoader run() {

                    return new BundleClassLoader(model, visited, urls.toArray(new URL[urls.size()]), parent);

                }

            });

        } finally {

            if (EGFPlatformPlugin.getDefault().isDebugging()) {
                long time = (endTime - startTime);
                EGFPlatformPlugin.getDefault().logInfo(NLS.bind("BundleClassLoaderFactory _ build an {0} in ''{1}'' ms", //$NON-NLS-1$ 
                        new Object[] {
                                IBundleClassLoader.class.getSimpleName(), time
                        }));
            }

        }

    }

}
