/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde.internal.plugin.command;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.activator.CommonActivator;
import org.eclipse.egf.common.helper.IUserEnforcedHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.internal.FactoryComponentGeneratorHelper;
import org.eclipse.egf.pde.internal.ui.util.ModelModification;
import org.eclipse.egf.pde.internal.ui.util.PDEModelUtility;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
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
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;
import org.eclipse.pde.internal.core.text.bundle.BundleSymbolicNameHeader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Constants;


/**
 * Implement a plug-in changes command runner.
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
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(PluginChangesCommandRunner.class.getPackage().getName());
  
  /**
   * Get the user enforced helper.
   */
  static final IUserEnforcedHelper USER_ENFORCED_HELPER = CommonActivator.getDefault().getUserEnforcedHelper();

  /**
   * @see org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner#performChangesOnPlugin(java.lang.String, java.util.List)
   */
  public void performChangesOnPlugin(String bundleId_p, List<IPluginChangesCommand> commands_p) {
    // Check Precondition.
    if (null == bundleId_p) {
      StringBuffer loggerMessage = new StringBuffer("PluginChangesCommandRunner.performChangesOnPlugin(..) _ "); //$NON-NLS-1$
      loggerMessage.append("bundleId_p can't be null"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
      return;
    }
    // Get the plug-in model object for given id.
    IPluginModelBase bundleModel = PluginRegistry.findModel(bundleId_p);
    if ((null != bundleModel) && bundleFileExists(bundleModel, EgfPdeActivator.PLUGIN_FILE_NAME, bundleId_p)) {
      modifyExistingPlugin(commands_p, bundleModel, EgfPdeActivator.PLUGIN_FILE_NAME, bundleId_p);
    } else if (null != bundleModel) {
      createNewPlugin(commands_p, bundleModel, bundleId_p);
    }
    // Update singleton attribute in bundle file according to changes.
    updateSingleton(bundleModel, new NullProgressMonitor());
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner#performChangesOnManifest(java.lang.String, java.util.List)
   */
  public void performChangesOnManifest(String bundleId_p, List<IPluginChangesCommand> commands_p) {
    // Check Precondition.
    if (bundleId_p == null) {
      StringBuffer loggerMessage = new StringBuffer("PluginChangesCommandRunner.performChangesOnManifest(..) _ "); //$NON-NLS-1$
      loggerMessage.append("bundleId_p can't be null"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
      return;
    }
    // Get the plug-in model object for given id.
    IPluginModelBase bundleModel = PluginRegistry.findModel(bundleId_p);
    if (bundleFileExists(bundleModel, EgfPdeActivator.MANIFEST_FILE_NAME, bundleId_p)) {
      modifyExistingPlugin(commands_p, bundleModel, EgfPdeActivator.MANIFEST_FILE_NAME, bundleId_p);
    }
  }

  /**
   * Create a plug-in file for given bundleModel.
   * @param commands_p
   * @param bundleModel_p
   * @param bundleId_p The bundle id.
   */
  private void createNewPlugin(final List<IPluginChangesCommand> commands_p, IPluginModelBase bundleModel_p, String bundleId_p) {
    // Plug-in file needs to be created.
    WorkspacePluginModelBase pluginModel = createPluginModel(bundleModel_p, EgfPdeActivator.PLUGIN_FILE_NAME, bundleId_p);
    for (IPluginChangesCommand command : commands_p) {
      command.setPluginModelBase(pluginModel);
      command.execute();
    }
    updateBuildFile(pluginModel);
    // Save the plugin.xml.
    save(pluginModel);
  }

  /**
   * Update the build.properties file to add the plugin.xml file in bin.includes.
   * @param pluginModel_p
   */
  private void updateBuildFile(WorkspacePluginModelBase pluginModel_p) {
    // Add the newly created plug-in file in the build.properties.
    IBuildModel buildModel = pluginModel_p.getBuildModel();
    IProject project = pluginModel_p.getUnderlyingResource().getProject();
    if (null == buildModel) {
      buildModel = FactoryComponentGeneratorHelper.getBuildModel(project);
      pluginModel_p.setBuildModel(buildModel);
    }
    FactoryComponentGeneratorHelper.addEntryInBinaryBuild(buildModel, EgfPdeActivator.PLUGIN_FILE_NAME);
    // Save the build.properties.
    ((WorkspaceBuildModel) buildModel).save();
  }

  /**
   * Save given plug-in model object ie related plugin.xml file is written in its workspace project location.
   * @param pluginModelBase_p
   * @return
   */
  private void save(IPluginModelBase pluginModelBase_p) {
    if (pluginModelBase_p instanceof WorkspacePluginModelBase) {
      WorkspacePluginModelBase plugin = (WorkspacePluginModelBase) pluginModelBase_p;
      plugin.save();
    }
  }

  /**
   * Modify an existing plugin in performing commands that contain the changes.
   * @param commands_p
   * @param bundleModel_p
   * @param bundleRelativeFileName_p the searched bundle file name.<br>
   *          Most of the time it is either {@link EgfPdeActivator#PLUGIN_FILE_NAME} or {@link EgfPdeActivator#MANIFEST_FILE_NAME}
   * @param bundleId_p The bundle id.
   */
  private void modifyExistingPlugin(
    final List<IPluginChangesCommand> commands_p, 
    IPluginModelBase bundleModel_p, 
    String bundleRelativeFileName_p,
    String bundleId_p
  ) {
    // Add a new extension and update existing plug-in file.
    final IFile file = getFile(bundleModel_p, bundleRelativeFileName_p, bundleId_p);
    // Execute the plug-in changes in the SWT thread to give a chance to the end-user to check-out its plug-in file (if not already in RW mode).
    // Perform the plug-in changes in synchronous mode to prevent from executing another dependent task if the end-user is requested for a check-out.
    final Display display = getDisplay();
    display.syncExec(
      new Runnable() {
        public void run() {
          // Check if the file is not in read-only mode.
          IStatus status = USER_ENFORCED_HELPER.makeFileWritable(file, display);
          if (status.getSeverity() != IStatus.OK) {
            StringBuffer loggerMessage = new StringBuffer("PluginChangesCommandRunner.modifyExistingPlugin(..) _ "); //$NON-NLS-1$
            loggerMessage.append(file.getName() + " file is read only, changes are impossible."); //$NON-NLS-1$
            __logger.error(loggerMessage.toString());
            return;
          }
          // Create an update operation that deals with modifying extensions.
          ModelModification updateOperation = new ModelModification(file) {
            /**
             * @see org.eclipse.egf.pde.internal.ui.util.ModelModification#modifyModel(org.eclipse.pde.core.IBaseModel,
             *      org.eclipse.core.runtime.IProgressMonitor)
             */
            @Override
            protected void modifyModel(IBaseModel model_p, IProgressMonitor monitor_p) throws CoreException {
              // Precondition.
              if (!(model_p instanceof IPluginModelBase))
                return;
              IPluginModelBase pluginModel = (IPluginModelBase) model_p;
              // Execute all changes.
              for (IPluginChangesCommand command : commands_p) {
                command.setPluginModelBase(pluginModel);
                command.execute();
              }
            }
          };
          // Let's update the file.
          PDEModelUtility.modifyModel(updateOperation, new NullProgressMonitor());
        }
      }
    );
  }

  /**
   * Return the display.
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
   * @param bundleModel_p
   * @param monitor_p
   */
  private void updateSingleton(final IPluginModelBase bundleModel_p, final IProgressMonitor monitor_p) {
    if (bundleModel_p instanceof IBundlePluginModel) {
      IFile file = (IFile) bundleModel_p.getUnderlyingResource();
      // Create an update operation that deals with updating the singleton attribute.
      ModelModification modification = new ModelModification(file) {
        @Override
        protected void modifyModel(IBaseModel model_p, IProgressMonitor progressMonitor_p) throws CoreException {
          // Precondition.
          if (!(model_p instanceof IBundlePluginModelBase)) {
            return;
          }
          IBundlePluginModelBase modelBase = (IBundlePluginModelBase) model_p;
          IBundle bundle = modelBase.getBundleModel().getBundle();
          IManifestHeader header = bundle.getManifestHeader(Constants.BUNDLE_SYMBOLICNAME);
          if (header instanceof BundleSymbolicNameHeader) {
            BundleSymbolicNameHeader symbolic = (BundleSymbolicNameHeader) header;
            if (!symbolic.isSingleton())
              symbolic.setSingleton(true);
          }
        }
      };
      // Let's update the file.
      PDEModelUtility.modifyModel(modification, monitor_p);
    }
  }

  /**
   * Create plug-in model object
   * @param pluginModelBase_p
   * @param bundleRelativeFileName_p the searched bundle file name.<br>
   *          Most of the time it is either {@link EgfPdeActivator#PLUGIN_FILE_NAME} or {@link EgfPdeActivator#MANIFEST_FILE_NAME}
   * @param bundleId_p The bundle id.
   * @return a {@link WorkspacePluginModelBase} instance or null if instantiation fails.
   */
  private WorkspacePluginModelBase createPluginModel(
    IPluginModelBase pluginModelBase_p, 
    String bundleRelativeFileName_p, 
    String bundleId_p
  ) {
    IFile pluginFile = getFile(pluginModelBase_p, bundleRelativeFileName_p, bundleId_p);
    // Create an internal PDE class that deals with plug-in manipulation.
    // It is not recommended but it is faster than re-implementing all PDE API.
    // TODO Stephane : ask a feature request on eclipse bugzilla to get a factory.
    WorkspacePluginModelBase pluginModel = null;
    try {
      // Get real model file.
      pluginModel = (WorkspacePluginModelBase) getModel(pluginFile);
      // Set default attributes.
      IPluginBase plugin = pluginModel.getPluginBase();
      plugin.setSchemaVersion(TargetPlatformHelper.getTargetVersion() < 3.2 ? PLUGIN_VERSION_3_0 : PLUGIN_VERSION_3_2);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("AbstractExtensionHelper.createNewPlugin(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return pluginModel;
  }

  /**
   * Test whether or not given bundle model object exists.
   * @param pluginModelBase_p
   * @param bundleRelativeFileName_p the searched bundle file name.<br>
   *          Most of the time it is either {@link EgfPdeActivator#PLUGIN_FILE_NAME} or {@link EgfPdeActivator#MANIFEST_FILE_NAME}
   * @param bundleId_p The bundle id.
   * @return
   */
  private boolean bundleFileExists(IPluginModelBase pluginModelBase_p, String bundleRelativeFileName_p, String bundleId_p) {
    boolean result = false;
    IFile file = getFile(pluginModelBase_p, bundleRelativeFileName_p, bundleId_p);
    if (file != null) {
      result = file.exists();
    }
    return result;
  }

  /**
   * Get the Plug-in object for given {@link IFile} related to a plugin.xml file.
   * @param file
   * @return
   */
  private IPluginModelBase getModel(IFile file) {
    IPluginModelBase result = null;
    if (EgfPdeActivator.PLUGIN_FILE_NAME.equals(file.getName())) {
      result = new WorkspacePluginModel(file, false);
    }
    return result;
  }

  /**
   * Get the plug-in file for given plug-in model object (without checking existence) for specified bundle fileName.
   * @param pluginModelBase_p
   * @param bundleRelativeFileName_p the searched bundle file name.<br>
   *          Most of the time it is either {@link EgfPdeActivator#PLUGIN_FILE_NAME} or {@link EgfPdeActivator#MANIFEST_FILE_NAME}
   * @return.
   */
  private static IFile getFile(IPluginModelBase pluginModelBase_p, String bundleRelativeFileName_p) {
    IFile result = null;
    // Precondition.
    if (null == pluginModelBase_p) {
      return result;
    }
    IProject project = ProjectHelper.getProject(pluginModelBase_p);
    result = project.getFile(bundleRelativeFileName_p);
    return result;
  }

  /**
   * Get plug-in file for identified bundle and relative path.<br>
   * @see #getFile(IPluginModelBase, String) comments.
   * @param pluginModelBase_p
   * @param bundleRelativeFileName_p
   * @param bundleId_p
   * @return
   */
  private static IFile getFile(IPluginModelBase pluginModelBase_p, String bundleRelativeFileName_p, String bundleId_p) {
    IFile result = getFile(pluginModelBase_p, bundleRelativeFileName_p);
    if (null == result) {
      // Failed to get file from plug-in model, get it from bundle id.
      IProject project = ProjectHelper.getProject(bundleId_p);
      if (null != project) {
        result = project.getFile(bundleRelativeFileName_p);
      }
    }
    return result;
  }
  
}
