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
package org.eclipse.egf.core.pde.internal.plugin;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.egf.core.pde.internal.FcoreGeneratorHelper;
import org.eclipse.egf.core.pde.internal.ui.ModelModification;
import org.eclipse.egf.core.pde.internal.ui.PDEModelUtility;
import org.eclipse.egf.core.pde.plugin.IPluginChangesCommand;
import org.eclipse.egf.core.pde.plugin.IPluginChangesCommandRunner;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.TargetPlatformHelper;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModel;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.ibundle.IManifestHeader;
import org.eclipse.pde.internal.core.plugin.WorkspaceFragmentModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;
import org.eclipse.pde.internal.core.text.bundle.BundleSymbolicNameHeader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Constants;

/**
 * Implement a plug-in changes command runner.
 * 
 * @author Guillaume Brocard
 */
public class PluginChangesCommandRunner implements IPluginChangesCommandRunner {

  /**
   * 3.0 level compliance of plugin.xml
   */
  private static final String PLUGIN_VERSION_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * 3.2 level compliance of plugin.xml
   */
  private static final String PLUGIN_VERSION_3_2 = "3.2"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.core.pde.plugin.IPluginChangesCommandRunner#performChangesOnPlugin(java.lang.String, java.util.List)
   */
  public void performChangesOnPlugin(String bundleId, List<IPluginChangesCommand> commands) {
    // Check Precondition.
    if (bundleId == null) {
      StringBuffer msg = new StringBuffer("PluginChangesCommandRunner.performChangesOnPlugin(..) _ "); //$NON-NLS-1$
      msg.append("bundleId can't be null"); //$NON-NLS-1$
      EGFPDEPlugin.getDefault().logError(msg.toString());
      return;
    }
    // Get the plug-in model object for given id.
    IPluginModelBase model = PluginRegistry.findModel(bundleId);
    if (model != null && bundleFileExists(model, PDEModelUtility.F_PLUGIN, bundleId)) {
      modifyExistingPlugin(commands, model, PDEModelUtility.F_PLUGIN, bundleId);
    } else if (model != null) {
      createNewPlugin(commands, model, bundleId);
    }
    // Update singleton attribute in bundle file according to changes.
    updateSingleton(model, new NullProgressMonitor());
  }

  /**
   * @see org.eclipse.egf.core.pde.plugin.IPluginChangesCommandRunner#performChangesOnManifest(java.lang.String, java.util.List)
   */
  public void performChangesOnManifest(String bundleId, List<IPluginChangesCommand> commands) {
    // Check Precondition.
    if (bundleId == null) {
      StringBuffer msg = new StringBuffer("PluginChangesCommandRunner.performChangesOnManifest(..) _ "); //$NON-NLS-1$
      msg.append("bundleId can't be null"); //$NON-NLS-1$
      EGFPDEPlugin.getDefault().logError(msg.toString());
      return;
    }
    // Get the plug-in model object for given id.
    IPluginModelBase bundleModel = PluginRegistry.findModel(bundleId);
    if (bundleFileExists(bundleModel, PDEModelUtility.F_MANIFEST_FP, bundleId)) {
      modifyExistingPlugin(commands, bundleModel, PDEModelUtility.F_MANIFEST_FP, bundleId);
    }
  }

  /**
   * Create a plug-in file for given bundleModel.
   * 
   * @param commands
   * @param model
   * @param bundleId
   *          The bundle id.
   */
  private void createNewPlugin(final List<IPluginChangesCommand> commands, IPluginModelBase bundleModel, String bundleId) {
    // Plug-in file needs to be created.
    WorkspacePluginModelBase pluginModel = createPluginModel(bundleModel, bundleId);
    for (IPluginChangesCommand command : commands) {
      command.setPluginModelBase(pluginModel);
      command.execute();
    }
    save(pluginModel);
    updateBuildFile(pluginModel);
  }

  /**
   * Update the build.properties file to add the plugin.xml file in
   * bin.includes.
   * 
   * @param pluginModel
   */
  private void updateBuildFile(WorkspacePluginModelBase pluginModel) {
    // Add the newly created plug-in file in the build.properties.
    IFile file = pluginModel.getFile();
    IBuildModel buildModel = pluginModel.getBuildModel();
    IProject project = file.getProject();
    if (buildModel == null) {
      buildModel = FcoreGeneratorHelper.getBuildModel(project);
      pluginModel.setBuildModel(buildModel);
    }
    FcoreGeneratorHelper.addEntryInBinaryBuild(buildModel, PDEModelUtility.F_PLUGIN);
    // Save the build.properties.
    ((WorkspaceBuildModel) buildModel).save();
  }

  /**
   * Save given plug-in model object ie related plugin.xml file is written in
   * its workspace project location.
   * 
   * @param pluginModelBase
   * @return
   */
  private void save(IPluginModelBase pluginModelBase) {
    if (pluginModelBase instanceof WorkspacePluginModelBase) {
      WorkspacePluginModelBase plugin = (WorkspacePluginModelBase) pluginModelBase;
      plugin.save();
    }
  }

  /**
   * Modify an existing plugin in performing commands that contain the changes.
   * 
   * @param commands
   * @param bundleModel
   * @param bundleRelativeFileName
   *          the searched bundle file name.<br>
   * @param bundleId
   *          The bundle id.
   */
  private void modifyExistingPlugin(final List<IPluginChangesCommand> commands, IPluginModelBase bundleModel, String bundleRelativeFileName, String bundleId) {
    // Add a new extension and update existing plug-in file.
    final IFile file = getFile(bundleModel, bundleRelativeFileName, bundleId);
    // Execute the plug-in changes in the SWT thread to give a chance to the
    // end-user to check-out its plug-in file (if not already in RW mode).
    // Perform the plug-in changes in synchronous mode to prevent from executing
    // another dependent task if the end-user is requested for a check-out.
    final Display display = getDisplay();
    display.syncExec(new Runnable() {
      public void run() {
        // Create an update operation that deals with modifying extensions.
        ModelModification updateOperation = new ModelModification(file) {
          @Override
          protected void modifyModel(IBaseModel model, IProgressMonitor monitor) throws CoreException {
            if (model instanceof IPluginModelBase == false) {
              return;
            }
            IPluginModelBase pluginModel = (IPluginModelBase) model;
            // Execute all changes.
            for (IPluginChangesCommand command : commands) {
              command.setPluginModelBase(pluginModel);
              command.execute();
            }
          }
        };
        // Let's update the file.
        PDEModelUtility.modifyModel(updateOperation, new NullProgressMonitor());
      }
    });
  }

  /**
   * Return the display.
   * 
   * @return
   */
  protected Display getDisplay() {
    // Get the display.
    Display display = null;
    if (PlatformUI.isWorkbenchRunning()) {
      display = PlatformUI.getWorkbench().getDisplay();
    } else {
      // Case of the headless mode.
      display = Display.getDefault();
    }
    return display;
  }

  /**
   * Update singleton attribute in bundle manifest file.
   * 
   * @param bundleModel
   * @param monitor
   */
  private void updateSingleton(final IPluginModelBase bundleModel, final IProgressMonitor monitor) {
    if (bundleModel instanceof IBundlePluginModel) {
      IFile file = (IFile) bundleModel.getUnderlyingResource();
      // Create an update operation that deals with updating the singleton
      // attribute.
      ModelModification modification = new ModelModification(file) {
        @Override
        protected void modifyModel(IBaseModel model_p, IProgressMonitor progressMonitor_p) throws CoreException {
          // Precondition.
          if (model_p instanceof IBundlePluginModelBase == false) {
            return;
          }
          IBundlePluginModelBase modelBase = (IBundlePluginModelBase) model_p;
          IBundle bundle = modelBase.getBundleModel().getBundle();
          IManifestHeader header = bundle.getManifestHeader(Constants.BUNDLE_SYMBOLICNAME);
          if (header instanceof BundleSymbolicNameHeader) {
            BundleSymbolicNameHeader symbolic = (BundleSymbolicNameHeader) header;
            if (symbolic.isSingleton() == false)
              symbolic.setSingleton(true);
          }
        }
      };
      // Let's update the file.
      PDEModelUtility.modifyModel(modification, monitor);
    }
  }

  /**
   * Create plug-in model object
   * 
   * @param model
   * @param bundleRelativeFileName
   *          the searched bundle file name.<br>
   * @param bundleId
   *          The bundle id.
   * @return a {@link WorkspacePluginModelBase} instance or null if
   *         instantiation fails.
   */
  private WorkspacePluginModelBase createPluginModel(IPluginModelBase model, String bundleId) {
    IFile pluginFile = getFile(model, PDEModelUtility.F_PLUGIN, bundleId);
    // Create an internal PDE class that deals with plug-in manipulation.
    // It is not recommended but it is faster than re-implementing all PDE API.
    // TODO Stephane : ask a feature request on eclipse bugzilla to get a
    // factory.
    WorkspacePluginModelBase pluginModel = null;
    try {
      // Get real model file.
      pluginModel = (WorkspacePluginModelBase) getModel(pluginFile);
      // Set default attributes.
      IPluginBase plugin = pluginModel.getPluginBase();
      plugin.setSchemaVersion(TargetPlatformHelper.getTargetVersion() < 3.2 ? PLUGIN_VERSION_3_0 : PLUGIN_VERSION_3_2);
    } catch (CoreException ce) {
      EGFPDEPlugin.getDefault().logError(new String("AbstractExtensionHelper.createNewPlugin(..) _ "), ce); //$NON-NLS-1$
    }
    return pluginModel;
  }

  /**
   * Test whether or not given bundle model object exists.
   * 
   * @param model
   * @param bundleRelativeFileName
   *          the searched bundle file name.<br>
   * @return
   */
  private boolean bundleFileExists(IPluginModelBase model, String bundleRelativeFileName, String bundleId) {
    boolean result = false;
    IFile file = getFile(model, bundleRelativeFileName, bundleId);
    if (file != null) {
      result = file.exists();
    }
    return result;
  }

  /**
   * Get the Plug-in object for given {@link IFile} related to a plugin.xml
   * file.
   * 
   * @param file
   * @return
   */
  private IPluginModelBase getModel(IFile file) {
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
   * @param pluginModelBase
   * @param bundleRelativeFileName
   *          the searched bundle file name.<br>
   * @return.
   */
  private static IFile getFile(IPluginModelBase pluginModelBase, String bundleRelativeFileName) {
    IFile result = null;
    // Precondition.
    if (pluginModelBase == null) {
      return result;
    }
    IProject project = ProjectHelper.getProject(pluginModelBase);
    result = project.getFile(bundleRelativeFileName);
    return result;
  }

  /**
   * Get plug-in file for identified bundle and relative path.<br>
   * 
   * @see #getFile(IPluginModelBase, String) comments.
   * @param pluginModelBase
   * @param bundleRelativeFileName
   * @param bundleId
   * @return
   */
  private static IFile getFile(IPluginModelBase pluginModelBase, String bundleRelativeFileName, String bundleId) {
    IFile result = getFile(pluginModelBase, bundleRelativeFileName);
    if (null == result) {
      // Failed to get file from plug-in model, get it from bundle id.
      IProject project = ProjectHelper.getProject(bundleId);
      if (project != null) {
        result = project.getFile(bundleRelativeFileName);
      }
    }
    return result;
  }

}
