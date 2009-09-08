/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pde.internal;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.manifest.command.ManifestChangeCommandFactory;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;


/**
 * Provides services when creating factory components or converting existing plug-ins in factory components.
 * @author Guillaume Brocard
 */
public class FactoryComponentGeneratorHelper {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(FactoryComponentGeneratorHelper.class.getPackage().getName());

  /**
   * Create and add a new source folder named 'generated' in given plug-in.<br>
   * The 'build.properties' file is updated accordingly if requested.
   * @param pluginId_p
   * @param updateBuildProperties_p
   */
  public static void addGeneratedSourceFolderIn(String pluginId_p, boolean updateBuildProperties_p) {
    IProject project = ProjectHelper.getProject(pluginId_p);
    boolean isCreated = createGeneratedSourceFolder(project);
    // Update the source. property to add generated source folder if it exists.
    if (isCreated && updateBuildProperties_p) {
      WorkspaceBuildModel buildModel = getBuildModel(project);
      addGeneratedSourceFolderInLibrarySources(buildModel, null);
      buildModel.save();
    }
  }

  /**
   * Create a 'generated' source folder in given project.
   * @param project_p
   * @return <code>true</code> means successfully created.
   */
  public static boolean createGeneratedSourceFolder(IProject project_p) {
    return ProjectHelper.createSourceFolder(ICommonConstants.GENERATED_FOLDER_PATH, project_p, new NullProgressMonitor());
  }

  /**
   * Create and add a new folder in given plug-in. <br>
   * The 'build.properties' file is updated accordingly if requested.
   * @param pluginId_p
   * @param folderName_p
   * @param updateBuildProperties_p
   * @param monitor_p
   */
  public static void addFolderIn(String pluginId_p, String folderName_p, boolean updateBuildProperties_p, IProgressMonitor monitor_p) {
    IProject project = ProjectHelper.getProject(pluginId_p);
    IFolder folder = ProjectHelper.createFolder(folderName_p, project, monitor_p);
    if (null != folder && updateBuildProperties_p) {
      WorkspaceBuildModel buildModel = getBuildModel(project);
      addEntryInBinaryBuild(buildModel, folderName_p + ICommonConstants.SLASH_CHARACTER);
      buildModel.save();
    }
  }

  /**
   * Add the 'generated' source folder in the source entry of the build.properties i.e 'SOURCE.<LIBRARY_NAME>'
   * @param buildModel
   * @param entryName_p if <code>null</code> default entry is used i.e '.'
   */
  public static void addGeneratedSourceFolderInLibrarySources(IBuildModel buildModel, String entryName_p) {
    // Precondition
    if (null == buildModel) {
      return;
    }
    String entryName = (null == entryName_p) ? String.valueOf(ICommonConstants.DOT_CHARACTER) : entryName_p;
    IBuild build = buildModel.getBuild();
    IBuildEntry sourceEntry = build.getEntry(IBuildEntry.JAR_PREFIX + entryName);
    if (null != sourceEntry) {
      try {
        sourceEntry.addToken(new Path(ICommonConstants.GENERATED_FOLDER_PATH).addTrailingSeparator().toString());
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("FactoryComponentGeneratorHelper.createGeneratedSourceFolderIn(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }

  /**
   * Add an entry in the binary entry of the build.properties i.e bin.include.<br>
   * Caller is responsible to save the modified build model.
   * @param buildModel_p
   */
  public static void addEntryInBinaryBuild(IBuildModel buildModel_p, String entryName_p) {
    IBuild build = buildModel_p.getBuild();
    // Update the bin.includes property
    IBuildEntry binEntry = build.getEntry(IBuildEntry.BIN_INCLUDES);
    if (null != binEntry) {
      try {
        if (!binEntry.contains(entryName_p)) {
          binEntry.addToken(entryName_p);
        }
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("FactoryComponentGeneratorHelper.addEntryInBinInclude(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }

  /**
   * Get the build model for given project.
   * @param project_p
   * @return
   */
  public static WorkspaceBuildModel getBuildModel(IProject project_p) {
    WorkspaceBuildModel buildModel = null;
    // Precondition.
    if (null == project_p) {
      return buildModel;
    }
    IFile buildFile = project_p.getFile("build.properties"); //$NON-NLS-1$
    if (buildFile.exists()) {
      buildModel = new WorkspaceBuildModel(buildFile);
      buildModel.load();
    }
    return buildModel;
  }

  /**
   * Add the standard dependencies in given plug-in manifest. See {@link #getStandardDependencies()}.
   * @param pluginId_p
   * @param optional_p
   */
  public static void addStandardFactoryComponentDependencies(String pluginId_p, boolean optional_p) {
    // Add dependencies on bootstrap factory component plug-in and pattern plug-in for given plug-in.
    String[] dependencies = getStandardDependencies();
    IPluginChangesCommand commandsOnManifest = ManifestChangeCommandFactory.setRequiredPlugins(dependencies, optional_p);
    EgfPdeActivator.getDefault().getPluginChangesCommandRunner().performChangesOnManifest(pluginId_p, Collections.singletonList(commandsOnManifest));
  }

  /**
   * Return the standard dependencies for a factory component.<br>
   * Default dependencies are <code>org.eclipse.egf.core</code> plug-in and <code>org.eclipse.egf.pattern</code> plug-in
   * @return
   */
  public static String[] getStandardDependencies() {
    String[] dependencies =
                            { CoreActivator.getDefault().getPluginID(), IPatternConstants.PATTERN_PLUGIN_ID};
    return dependencies;
  }
}
