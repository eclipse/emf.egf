/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.generator.IEgfGeneratorConstants;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * Workspace projects helper.
 * 
 * @author brocard
 */
public class ProjectHelper {

    private ProjectHelper() {
        // Prevent Instantiation
    }

    /**
     * Obtains a scheduling rule to schedule myself on to give my delegate
     * access to the specified affected resources.
     * 
     * @param projects
     * @return the appropriate scheduling rule, or <code>null</code> if
     *         none is required
     */
    public static ISchedulingRule getRule(List<IProject> projects) {
        ISchedulingRule result = null;
        if (projects.isEmpty() == false) {
            IResourceRuleFactory factory = ResourcesPlugin.getWorkspace().getRuleFactory();
            for (IResource next : projects) {
                result = MultiRule.combine(result, factory.modifyRule(next));
            }
        }
        return result;
    }

    /**
     * Returns the workspace root default charset encoding.
     * 
     * @return the name of the default charset encoding for workspace root.
     * @see IContainer#getDefaultCharset()
     * @see ResourcesPlugin#getEncoding()
     * @since 3.0
     */
    public static String getEncoding(IProject project) {
        // project default encoding first
        if (project != null) {
            try {
                return project.getDefaultCharset();
            } catch (Throwable t) {
                // fails silently
            }
        }
        // default platform fallback
        try {
            return ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset();
        } catch (IllegalStateException ise) {
            // happen when there's no workspace (see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=216817)
            // or when it is shutting down (see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=60687)
            return System.getProperty("file.encoding"); //$NON-NLS-1$
        } catch (CoreException ce) {
            // fails silently and return plugin global encoding if core exception occurs
        }
        return ResourcesPlugin.getEncoding();
    }

    /**
     * Required plug-ins class path entry path identifier.
     */
    protected static final String CLASS_PATH_ENTRY_REQUIRED_PLUGINS_PATH_ID = "requiredPlugins"; //$NON-NLS-1$

    /**
     * Project existence status after check.<br>
     * The project already exists (including default structure), or it has just
     * been created, or creation process failed.<br>
     * Internal purpose only.
     */
    public enum ProjectExistenceStatus {
        ALREADY_EXISTS, CREATED, CREATION_FAILED
    }

    /**
     * Get project from its name.<br>
     * It is assumed that this project name refers to a plug-in.<br>
     * If not, the method
     * <code>ResourcesPlugin.getWorkspace().getRoot().getProject(projectName_p)</code>
     * is invoked as result.
     * 
     * @param bundleId
     *            A project name that points to a plug-in in the workspace.
     * @return IProject
     */
    public static IProject getProject(String bundleId) {
        // Precondition.
        if (bundleId == null) {
            return null;
        }
        return ResourcesPlugin.getWorkspace().getRoot().getProject(bundleId);
    }

    /**
     * Get the IProject from an IPath
     * 
     * @param path
     * @return null if not applicable
     */
    public static IProject getProject(IPath path) {
        // Precondition.
        if (path == null) {
            return null;
        }
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        if (file == null) {
            return null;
        }
        return file.getProject();
    }

    /**
     * Get the IProject for specified plug-in model.
     * 
     * @param model
     * @return null if the plug-in is not in the workspace.
     */
    public static IProject getProject(IPluginModelBase model) {
        // Precondition.
        if (model == null) {
            return null;
        }
        IResource underlyingResource = model.getUnderlyingResource();
        if (underlyingResource != null) {
            return underlyingResource.getProject();
        }
        return null;
    }

    /**
     * Refresh given project in the workspace.
     * 
     * @param project
     * @param monitor
     */
    public static void refreshProject(IProject project, IProgressMonitor monitor) throws CoreException {
        refreshProject(project, IResource.DEPTH_INFINITE, monitor);
    }

    /**
     * Refresh a project in the workspace.
     * 
     * @param project
     * @param depth
     * @param monitor
     */
    public static void refreshProject(IProject project, int depth, IProgressMonitor monitor) throws CoreException {
        project.refreshLocal(depth, monitor);
    }

    /**
     * Create a source folder in given project.
     * 
     * @param folder
     *            the name of the source folder.
     * @param project
     *            the hosting project.
     * @param monitor
     *            progress monitor.
     */
    public static void createSourceFolder(String folder, IProject project, IProgressMonitor monitor) throws CoreException {
        // Preconditions
        if (folder == null || project == null || monitor == null) {
            return;
        }
        try {
            // Get the related java project.
            IJavaProject javaProject = JavaCore.create(project);
            // Get all source entries.
            IClasspathEntry[] sourceEntries = javaProject.getRawClasspath();
            // Add a generated source folder.
            IPath generatedSourceFolderPath = project.getFullPath().append(folder);
            createFolder(folder, project, new SubProgressMonitor(monitor, 1));
            // Create a new source entry for the 'generated' source folder.
            IClasspathEntry generatedSourceEntry = JavaCore.newSourceEntry(generatedSourceFolderPath);
            IClasspathEntry[] newEntries = new IClasspathEntry[sourceEntries.length + 1];
            // Copy the 'src' source entry.
            newEntries[0] = sourceEntries[0];
            // Add the 'generated' entry.
            newEntries[1] = generatedSourceEntry;
            // Copy the remaining entries.
            System.arraycopy(sourceEntries, 1, newEntries, 2, sourceEntries.length - 1);
            // Set the new entries on the java project.
            javaProject.setRawClasspath(newEntries, new SubProgressMonitor(monitor, 1));
        } catch (Throwable t) {
            throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("ProjectHelper.createSourceFolder(..) _ project ''{0}'' folder ''{1}''.", project.getName(), folder), t)); //$NON-NLS-1$      
        }
        return;
    }

    /**
     * Create a folder with given name in given project.
     * 
     * @param folderName
     * @param project
     * @param monitor
     * @return <code>null</code> if creation failed.
     */
    public static IFolder createFolder(String folderName, IProject project, IProgressMonitor monitor) throws CoreException {
        IFolder folder = project.getFolder(folderName);
        // Create the physical resource.
        if (folder.exists() == false) {
            // Get parent path.
            IPath parentPath = new Path(folderName);
            if (parentPath.segmentCount() > 1) {
                parentPath = parentPath.removeLastSegments(1);
                // Make sure parent exists first.
                createFolder(parentPath.toString(), project, monitor);
            }
            // Then try and create given folder.
            try {
                folder.create(true, true, monitor);
            } catch (Throwable t) {
                throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("ProjectHelper.createFolder(..) _ project ''{0}'' folder ''{1}''.", project.getName(), folderName), t)); //$NON-NLS-1$
            }
        }
        return folder;
    }

    /**
     * Make sure named project exists.<br>
     * If not try and create a new one with given name.
     * 
     * @param projectName
     *            The expected project name.
     * @param cleanProject
     *            true to clean project structure after creation, false otherwise.
     * @param projectType
     *            {@link Generator#EMF_EMPTY_PROJECT_STYLE} see other values.
     * @return {@link ProjectExistenceStatus} value.
     */
    private static ProjectExistenceStatus ensureProjectExists(String projectName, boolean cleanProject, int projectType, IProgressMonitor monitor) throws CoreException {
        ProjectExistenceStatus result = ProjectExistenceStatus.CREATION_FAILED;
        // Precondition.
        if (projectName == null) {
            return result;
        }
        IFile file = FileHelper.getFile(projectName + IEgfGeneratorConstants.PROJECT_ROOT_FILE);
        // Project already exists, stop here.
        if (file != null && file.exists()) {
            return ProjectExistenceStatus.ALREADY_EXISTS;
        }
        // Else, try and create an EMF project.
        IPath projectLocationPath = new Path(EGFCommonConstants.SLASH_CHARACTER + projectName);
        IProject resultingProject = Generator.createEMFProject(projectLocationPath.append(EGFCommonConstants.SLASH_CHARACTER + IEgfGeneratorConstants.SRC_FOLDER), null, Collections.<IProject> emptyList(), monitor, projectType, Collections.EMPTY_LIST);
        if (resultingProject != null && resultingProject.exists()) {
            result = ProjectExistenceStatus.CREATED;
            // If project should be cleaned, do it.
            if (cleanProject) {
                cleanProjectStructure(resultingProject, monitor);
            }
        } else {
            result = ProjectExistenceStatus.CREATION_FAILED;
        }
        return result;
    }

    /**
     * Clean newly created project structure.<br/>
     * Remove plug-in dependencies class path container from given project (if
     * applicable).<br/>
     * Also set nature back to Java one.
     * 
     * @param project
     */
    private static void cleanProjectStructure(IProject project, IProgressMonitor monitor) throws CoreException {
        IJavaProject javaProject = JavaCore.create(project);
        // Precondition.
        if (javaProject == null) {
            return;
        }
        // Restore Java nature only.
        String natureIds[] = new String[] {
            JavaCore.NATURE_ID
        };
        IProjectDescription description = project.getDescription();
        description.setNatureIds(natureIds);
        project.setDescription(description, monitor);
        // Get raw class path.
        IClasspathEntry[] rawClasspath = null;
        try {
            rawClasspath = javaProject.getRawClasspath();
        } catch (JavaModelException jme) {
            throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("ProjectHelper.cleanProjectStructure(..) _ project ''{0}''.", project.getName()), jme)); //$NON-NLS-1$
        }
        // Iterate over class path elements.
        if (rawClasspath != null && rawClasspath.length != 0) {
            List<IClasspathEntry> newRawClasspath = new ArrayList<IClasspathEntry>(rawClasspath.length);
            for (IClasspathEntry classpathEntry : rawClasspath) {
                if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
                    // Do not retain required plug-ins container.
                    IPath path = classpathEntry.getPath();
                    if (CLASS_PATH_ENTRY_REQUIRED_PLUGINS_PATH_ID.equals(path.getFileExtension()) == false) {
                        newRawClasspath.add(classpathEntry);
                    }
                } else {
                    newRawClasspath.add(classpathEntry);
                }
            }
            // Set new raw class path.
            try {
                javaProject.setRawClasspath(newRawClasspath.toArray(new IClasspathEntry[newRawClasspath.size()]), new NullProgressMonitor());
            } catch (JavaModelException jme) {
                throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("ProjectHelper.cleanProjectStructure(..) _ project ''{0}''.", project.getName()), jme)); //$NON-NLS-1$
            }
        }
    }

    /**
     * Make sure named plug-in project exists.<br>
     * If not try and create a new one with given name.
     * 
     * @param projectName
     *            The expected project name.
     * @return ProjectExistenceStatus
     */
    public static ProjectExistenceStatus ensurePluginProjectExists(String projectName, IProgressMonitor monitor) throws CoreException {
        return ensureProjectExists(projectName, false, Generator.EMF_PLUGIN_PROJECT_STYLE, monitor);
    }

    /**
     * Make sure named project exists.<br>
     * If not try and create a new one with given name.
     * 
     * @param projectName
     *            The expected project name.
     * @return ProjectExistenceStatus
     */
    public static ProjectExistenceStatus ensureProjectExists(String projectName, IProgressMonitor monitor) throws CoreException {
        return ensureProjectExists(projectName, true, Generator.EMF_EMPTY_PROJECT_STYLE, monitor);
    }

}
