/*******************************************************************************
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.pde.internal;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.egf.core.pde.manifest.ManifestChangeCommandFactory;
import org.eclipse.egf.core.pde.plugin.IPluginChangesCommand;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;

/**
 * Provides services when creating fcore or converting existing
 * plug-ins in fcore projects.
 * 
 * @author Guillaume Brocard
 */
public class FcoreGeneratorHelper {

  /**
   * Create and add a new folder in given plug-in. <br>
   * The 'build.properties' file is updated accordingly if requested.
   * 
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
      addEntryInBinaryBuild(buildModel, folderName_p + CharacterConstants.SLASH_CHARACTER);
      buildModel.save();
    }
  }

  /**
   * Add an entry in the binary entry of the build.properties i.e bin.include.<br>
   * Caller is responsible to save the modified build model.
   * 
   * @param buildModel_p
   */
  public static void addEntryInBinaryBuild(IBuildModel buildModel_p, String entryName_p) {
    IBuild build = buildModel_p.getBuild();
    // Update the bin.includes property
    IBuildEntry binEntry = build.getEntry(IBuildEntry.BIN_INCLUDES);
    if (binEntry != null) {
      try {
        if (binEntry.contains(entryName_p) == false) {
          binEntry.addToken(entryName_p);
        }
      } catch (CoreException ce) {
        EGFPDEPlugin.getDefault().logError(new String("FcoreGeneratorHelper.addEntryInBinInclude(..) _ ").toString(), ce); //$NON-NLS-1$
      }
    }
  }

  /**
   * Get the build model for given project.
   * 
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
   * Add the standard dependencies in given plug-in manifest. See {@link #getStandardDependencies()}
   * .
   * 
   * @param pluginId_p
   * @param optional_p
   */
  public static void addStandardFcoreDependencies(String pluginId_p, boolean optional_p) {
    // Add dependencies on bootstrap factory component plug-in and pattern
    // plug-in for given plug-in.
    String[] dependencies = getStandardDependencies();
    IPluginChangesCommand commandsOnManifest = ManifestChangeCommandFactory.setRequiredPlugins(dependencies, optional_p);
    EGFPDEPlugin.getPluginChangesCommandRunner().performChangesOnManifest(pluginId_p, Collections.singletonList(commandsOnManifest));
  }

  /**
   * Return the standard dependencies for a factory component.<br>
   * Default dependencies are <code>org.eclipse.egf.core</code> plug-in and
   * <code>org.eclipse.egf.pattern</code> plug-in
   * 
   * @return
   */
  public static String[] getStandardDependencies() {
    String[] dependencies = { EGFCorePlugin.getDefault().getPluginID() };
    return dependencies;
  }
}
