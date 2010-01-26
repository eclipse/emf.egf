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
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.egf.core.pde.manifest.ManifestChangeCommandFactory;
import org.eclipse.egf.core.pde.plugin.IPluginChangesCommand;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.ui.util.PDEModelUtility;

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
   * @param pluginId
   * @param folderName
   * @param updateBuildProperties
   * @param monitor
   */
  public static void addFolderIn(String pluginId, String folderName, boolean updateBuildProperties, IProgressMonitor monitor) {
    IProject project = ProjectHelper.getProject(pluginId);
    IFolder folder = ProjectHelper.createFolder(folderName, project, monitor);
    if (folder != null && updateBuildProperties) {
      WorkspaceBuildModel buildModel = getBuildModel(project);
      addEntryInBinaryBuild(buildModel, folderName + EGFCommonConstants.SLASH_CHARACTER);
      buildModel.save();
    }
  }

  /**
   * Add an entry in the binary entry of the build.properties i.e bin.include.<br>
   * Caller is responsible to save the modified build model.
   * 
   * @param buildModel
   */
  public static void addEntryInBinaryBuild(IBuildModel buildModel, String entryName) {
    IBuild build = buildModel.getBuild();
    // Update the bin.includes property
    IBuildEntry binEntry = build.getEntry(IBuildEntry.BIN_INCLUDES);
    if (binEntry != null) {
      try {
        if (binEntry.contains(entryName) == false) {
          binEntry.addToken(entryName);
        }
      } catch (CoreException ce) {
        EGFPDEPlugin.getDefault().logError(new String("FcoreGeneratorHelper.addEntryInBinInclude(..) _ ").toString(), ce); //$NON-NLS-1$
      }
    }
  }

  /**
   * Get the build model for given project.
   * 
   * @param project
   * @return
   */
  public static WorkspaceBuildModel getBuildModel(IProject project) {
    // Precondition.
    if (project == null) {
      return null;
    }
    WorkspaceBuildModel buildModel = null;
    IFile buildFile = project.getFile(PDEModelUtility.F_BUILD);
    buildModel = new WorkspaceBuildModel(buildFile);
    if (buildFile.exists()) {
      buildModel.load();
    }
    return buildModel;
  }

  /**
   * Add Fcore dependency in given plug-in manifest. See {@link #getEGFCoreDependency()} .
   * 
   * @param pluginId
   * @param optional
   */
  public static void addStandardFcoreDependency(String pluginId, boolean optional) {
    // Add standard Fcore dependency.
    IPluginChangesCommand commandsOnManifest = ManifestChangeCommandFactory.setRequiredPlugins(getEGFCoreDependency(), optional);
    EGFPDEPlugin.getPluginChangesCommandRunner().performChangesOnManifest(pluginId, Collections.singletonList(commandsOnManifest));
  }

  /**
   * Return the EGF Core dependency for a Fcore.<br>
   * 
   * @return
   */
  public static String[] getEGFCoreDependency() {
    return new String[] { EGFCorePlugin.getDefault().getPluginID() };
  }
}
