/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.common.generator.IEgfGeneratorConstants;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

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
   * @param pluginId
   *          A project name that points to a plug-in in the workspace.
   * @return
   */
  public static IProject getProject(String pluginId) {
    // Precondition.
    if (pluginId == null) {
      return null;
    }
    // Get model base from project name.
    IPluginModelBase modelBase = PluginRegistry.findModel(pluginId);
    // Precondition.
    // Warning : fix for the Eclipse platform bug that consists in having PDE in
    // a weird state
    // regarding in-development plug-ins from launching platform as deployed
    // ones in current one.
    if (modelBase == null) {
      return ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
    }
    return getProject(modelBase);
  }

  /**
   * Get the IProject for specified plug-in model.
   * 
   * @param base
   * @return null if the plug-in is not in the workspace.
   */
  public static IProject getProject(IPluginModelBase base) {
    // Precondition.
    if (base == null) {
      return null;
    }
    IResource underlyingResource = base.getUnderlyingResource();
    if (underlyingResource != null) {
      return underlyingResource.getProject();
    }
    return null;
  }

  public static ClassLoader getProjectClassLoader(IProject project) throws CoreException {
    return new URLClassLoader(asURL(project), ProjectHelper.class.getClassLoader());
  }

  /**
   * This will return the set of output folders name for the given
   * project.
   * <p>
   * For example, if a project has a source folder "src" with its output folder
   * set as "bin" and a source
   * folder "src-gen" with its output folder set as "bin-gen", this will return
   * a LinkedHashSet containing
   * both "bin" and "bin-gen".
   * </p>
   * 
   * @param project
   *          The project we seek the output folders of.
   * @return The set of output folders name for the given (java) project.
   */
  public static Set<String> getOutputFolders(IProject project) throws CoreException {
    Set<String> classpathEntries = new LinkedHashSet<String>();
    IJavaProject javaProject = JavaCore.create(project);
    if (javaProject.exists() == false) {
      return classpathEntries;
    }
    try {
      for (IClasspathEntry entry : javaProject.getResolvedClasspath(true)) {
        if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
          IPath output = entry.getOutputLocation();
          if (output != null) {
            classpathEntries.add(output.removeFirstSegments(1).toString());
          }
        }
      }
      classpathEntries.add(javaProject.getOutputLocation().removeFirstSegments(1).toString());
    } catch (Throwable t) {
      throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCommonMessages.ProjectHelper_AnalysingFailure, project.getName()), t));
    }
    return classpathEntries;
  }

  private static URL[] asURL(IProject project) throws CoreException {
    Set<String> outputFolders = getOutputFolders(project);
    List<URL> urls = new ArrayList<URL>(outputFolders.size());
    for (String outputFolder : outputFolders) {
      try {
        urls.add(new URL("file", null, outputFolder)); //$NON-NLS-1$
      } catch (MalformedURLException mue) {
        throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCommonMessages.ProjectHelper_AnalysingFailure, project.getName()), mue));
      }
    }
    return urls.toArray(new URL[urls.size()]);
  }

  /**
   * Refresh given project in the workspace.
   * 
   * @param project_p
   * @param monitor_p
   */
  public static void refreshProject(IProject project_p, IProgressMonitor monitor_p) {
    refreshProject(project_p, IResource.DEPTH_INFINITE, monitor_p);
  }

  /**
   * Refresh a project in the workspace.
   * 
   * @param projectToRefresh_p
   * @param depth_p
   * @param monitor_p
   * @see {@link IResource#refreshLocal(int, IProgressMonitor)}
   */
  public static void refreshProject(IProject projectToRefresh_p, int depth_p, IProgressMonitor monitor_p) {
    try {
      projectToRefresh_p.refreshLocal(depth_p, monitor_p);
    } catch (CoreException ce) {
      StringBuilder msg = new StringBuilder("ProjectHelper.refreshProject(..) _ "); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), ce);
    }
  }

  /**
   * Create a source folder in given project.
   * 
   * @param sourceFolderName_p
   *          the name of the source folder.
   * @param project_p
   *          the hosting project.
   * @param monitor_p
   *          progress monitor.
   * @return <code>true</code> means the creation is successful.
   */
  public static boolean createSourceFolder(String sourceFolderName_p, IProject project_p, IProgressMonitor monitor_p) {
    boolean successful = false;
    // Preconditions
    if (sourceFolderName_p == null || project_p == null || monitor_p == null) {
      return successful;
    }
    try {
      // Get the related java project.
      IJavaProject javaProject = JavaCore.create(project_p);
      // Get all source entries.
      IClasspathEntry[] sourceEntries = javaProject.getRawClasspath();
      // Add a generated source folder.
      IPath generatedSourceFolderPath = project_p.getFullPath().append(sourceFolderName_p);
      createFolder(sourceFolderName_p, project_p, new SubProgressMonitor(monitor_p, 1));
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
      javaProject.setRawClasspath(newEntries, new SubProgressMonitor(monitor_p, 1));
      successful = true;
    } catch (Exception e) {
      successful = false;
      StringBuilder msg = new StringBuilder("ProjectHelper.createSourceFolder(..) _ "); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), e);
    }
    return successful;
  }

  /**
   * Create a folder with given name in given project.
   * 
   * @param folderName_p
   * @param project_p
   * @param monitor_p
   * @return <code>null</code> if creation failed.
   */
  public static IFolder createFolder(String folderName_p, IProject project_p, IProgressMonitor monitor_p) {
    IFolder folder = project_p.getFolder(folderName_p);
    // Create the physical resource.
    if (folder.exists() == false) {
      // Get parent path.
      IPath parentPath = new Path(folderName_p);
      if (parentPath.segmentCount() > 1) {
        parentPath = parentPath.removeLastSegments(1);
        // Make sure parent exists first.
        createFolder(parentPath.toString(), project_p, monitor_p);
      }
      // Then try and create given folder.
      try {
        folder.create(true, true, monitor_p);
      } catch (CoreException ce) {
        folder = null;
        StringBuilder msg = new StringBuilder("ProjectHelper.createFolder(..) _ "); //$NON-NLS-1$
        EGFCommonPlugin.getDefault().logError(msg.toString(), ce);
      }
    }
    return folder;
  }

  /**
   * Make sure named project exists.<br>
   * If not try and create a new one with given name.
   * 
   * @param projectName_p
   *          The expected project name.
   * @param cleanProject_p
   *          true to clean project structure after creation, false otherwise.
   * @param projectType_p
   *          {@link Generator#EMF_EMPTY_PROJECT_STYLE} see other values.
   * @return {@link ProjectExistenceStatus} value.
   */
  private static ProjectExistenceStatus ensureProjectExists(String projectName_p, boolean cleanProject_p, int projectType_p) {
    ProjectExistenceStatus result = ProjectExistenceStatus.CREATION_FAILED;
    // Precondition.
    if (projectName_p == null) {
      return result;
    }
    IFile file = FileHelper.getPlatformFile(projectName_p + IEgfGeneratorConstants.PROJECT_ROOT_FILE);
    // Project already exists, stop here.
    if (file.exists()) {
      return ProjectExistenceStatus.ALREADY_EXISTS;
    }
    // Else, try and create an EMF project.
    IPath projectLocationPath = new Path(CharacterConstants.SLASH_CHARACTER + projectName_p);
    IProject resultingProject = Generator.createEMFProject(projectLocationPath.append(CharacterConstants.SLASH_CHARACTER + IEgfGeneratorConstants.SRC_FOLDER), null, Collections.<IProject> emptyList(), new NullProgressMonitor(), projectType_p, Collections.EMPTY_LIST);
    if (resultingProject != null && resultingProject.exists()) {
      result = ProjectExistenceStatus.CREATED;
      // If project should be cleaned, do it.
      if (cleanProject_p) {
        cleanProjectStructure(resultingProject);
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
   * @param project_p
   */
  private static void cleanProjectStructure(IProject project_p) {
    IJavaProject javaProject = JavaCore.create(project_p);
    // Precondition.
    if (javaProject == null) {
      return;
    }
    // Restore Java nature only.
    String natureIds[] = new String[] { JavaCore.NATURE_ID };
    try {
      IProjectDescription description = project_p.getDescription();
      description.setNatureIds(natureIds);
      project_p.setDescription(description, new NullProgressMonitor());
    } catch (CoreException ce) {
      StringBuilder msg = new StringBuilder("ProjectHelper.cleanProjectStructure(..) _ "); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), ce);
    }
    // Get raw class path.
    IClasspathEntry[] rawClasspath = null;
    try {
      rawClasspath = javaProject.getRawClasspath();
    } catch (JavaModelException jme) {
      StringBuilder msg = new StringBuilder("ProjectHelper.cleanProjectStructure(..) _ "); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), jme);
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
        StringBuilder msg = new StringBuilder("ProjectHelper.cleanProjectStructure(..) _ "); //$NON-NLS-1$
        EGFCommonPlugin.getDefault().logError(msg.toString(), jme);
      }
    }
  }

  /**
   * Make sure named plug-in project exists.<br>
   * If not try and create a new one with given name.
   * 
   * @param projectName_p
   *          The expected project name.
   * @return
   */
  public static ProjectExistenceStatus ensurePluginProjectExists(String projectName_p) {
    return ensureProjectExists(projectName_p, false, Generator.EMF_PLUGIN_PROJECT_STYLE);
  }

  /**
   * Make sure named project exists.<br>
   * If not try and create a new one with given name.
   * 
   * @param projectName_p
   *          The expected project name.
   * @return
   */
  public static ProjectExistenceStatus ensureProjectExists(String projectName_p) {
    return ensureProjectExists(projectName_p, true, Generator.EMF_EMPTY_PROJECT_STYLE);
  }

}
