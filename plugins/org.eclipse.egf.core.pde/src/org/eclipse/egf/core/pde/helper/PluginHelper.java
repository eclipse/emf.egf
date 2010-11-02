/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde.helper;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.egf.core.pde.internal.FcoreGeneratorHelper;
import org.eclipse.egf.core.pde.internal.ui.PDEModelUtility;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.TargetPlatformHelper;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.core.plugin.WorkspaceFragmentModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;

/**
 * Implement a plug-in changes command runner.
 * 
 * @author Guillaume Brocard
 */
public class PluginHelper {

    private PluginHelper() {
        // Prevent Instantiation
    }

    /**
     * 3.0 level compliance of plugin.xml
     */
    private static final String PLUGIN_VERSION_3_0 = "3.0"; //$NON-NLS-1$

    /**
     * 3.2 level compliance of plugin.xml
     */
    private static final String PLUGIN_VERSION_3_2 = "3.2"; //$NON-NLS-1$

    /**
     * Update the build.properties file to add the plugin.xml file in
     * bin.includes.
     * 
     * @param model
     */
    public static void updateBuildFile(WorkspacePluginModelBase model) throws CoreException {
        // Add the newly created plug-in file in the build.properties.
        IFile file = model.getFile();
        WorkspaceBuildModel buildModel = (WorkspaceBuildModel) model.getBuildModel();
        IProject project = file.getProject();
        if (buildModel == null) {
            buildModel = FcoreGeneratorHelper.getBuildModel(project);
        }
        FcoreGeneratorHelper.addEntryInBinaryBuild(buildModel, PDEModelUtility.F_PLUGIN);
        // Save the build.properties.
        buildModel.save();
    }

    /**
     * Create plug-in model object
     * 
     * @param model
     * @return a {@link WorkspacePluginModelBase} instance or null if
     *         instantiation fails.
     */
    public static WorkspacePluginModelBase createWorkspacePluginModelBase(IPluginModelBase model) throws CoreException {
        IFile file = getFile(model, PDEModelUtility.F_PLUGIN);
        if (file == null) {
            return null;
        }
        WorkspacePluginModelBase pluginModel = null;
        // Get the real model file.
        pluginModel = (WorkspacePluginModelBase) getModel(file);
        if (pluginModel == null) {
            throw new CoreException(EGFPDEPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("PluginHelper.createWorkspacePluginModelBase(..) _ bundleId ''{0}''.", BundleHelper.getBundleId(model)), null)); //$NON-NLS-1$
        }
        // Set default attributes.
        IPluginBase base = pluginModel.getPluginBase();
        base.setSchemaVersion(TargetPlatformHelper.getTargetVersion() < 3.2 ? PLUGIN_VERSION_3_0 : PLUGIN_VERSION_3_2);
        return pluginModel;
    }

    /**
     * Test whether or not given bundle model object exists.
     * 
     * @param model
     * @param file
     *          the searched bundle file name.<br>
     * @return boolean
     */
    public static boolean bundleFileExists(IPluginModelBase model, String file) {
        IFile result = getFile(model, file);
        if (file != null) {
            return result.exists();
        }
        return false;
    }

    /**
     * Get the Plug-in object for given {@link IFile} related to a plugin.xml
     * file.
     * 
     * @param file
     * @return IPluginModelBase
     */
    public static IPluginModelBase getModel(IFile file) {
        if (file == null) {
            return null;
        }
        if (PDEModelUtility.F_PLUGIN.equals(file.getName())) {
            return new WorkspacePluginModel(file, false);
        } else if (PDEModelUtility.F_FRAGMENT.equals(file.getName())) {
            return new WorkspaceFragmentModel(file, false);
        }
        return null;
    }

    /**
     * Get the plug-in file for given plug-in model object (without checking
     * existence) for specified bundle fileName.
     * 
     * @param model
     * @param file
     *          the searched bundle file name.<br>
     * @return.
     */
    public static IFile getFile(IPluginModelBase model, String file) {
        // Precondition.
        if (model == null) {
            return null;
        }
        IProject project = ProjectHelper.getProject(model);
        if (project == null) {
            project = ProjectHelper.getProject(BundleHelper.getBundleId(model));
        }
        if (project == null) {
            return null;
        }
        return project.getFile(file);
    }

}
