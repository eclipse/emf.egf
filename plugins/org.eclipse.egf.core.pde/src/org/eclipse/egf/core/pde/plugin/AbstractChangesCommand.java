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
package org.eclipse.egf.core.pde.plugin;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.egf.core.pde.helper.PluginHelper;
import org.eclipse.egf.core.pde.internal.ui.ModelModification;
import org.eclipse.egf.core.pde.internal.ui.PDEModelUtility;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;

/**
 * Base class to implement a command that performs bundle changes in the plugin.xml file.
 * 
 * @author Guillaume Brocard
 */
public abstract class AbstractChangesCommand implements IPluginChangesCommand {

  private String _bundleId;

  private IPluginModelBase _pluginModelBase;

  private IProject _project;

  public AbstractChangesCommand(IProject project) throws CoreException {
    Assert.isNotNull(project);
    _project = project;
    IPluginModelBase fakeModel = BundleHelper.getPluginModelBase(_project);
    if (fakeModel == null) {
      throw new CoreException(EGFPDEPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("AbstractChangesCommand(..) _ project ''{0}'' is not a bundle project.", _project.getModificationStamp()), null)); //$NON-NLS-1$
    }
  }

  /**
   * Get the plug-in model id
   * 
   * @return the bundleId
   */
  public String getBundleId() {
    if (_bundleId == null) {
      if (_pluginModelBase != null) {
        _bundleId = BundleHelper.getBundleId(_pluginModelBase);
      }
    }
    return _bundleId;
  }

  /**
   * Get the plug-in model that this command is performed against.
   * 
   * @return the pluginModelBase
   */
  public IPluginModelBase getPluginModelBase() {
    return _pluginModelBase;
  }

  /**
   * @see org.eclipse.egf.core.pde.plugin.IPluginChangesCommand#execute(org.eclipse.core.runtime.IProgressMonitor)
   */
  public void execute(IProgressMonitor monitor) throws CoreException {
    if (_project.getFile(PDEModelUtility.F_PLUGIN).exists()) {
      modifyExistingPlugin(monitor);
    } else {
      createNewPlugin(monitor);
    }
  }

  private void createNewPlugin(IProgressMonitor monitor) throws CoreException {
    IPluginModelBase fakeModel = BundleHelper.getPluginModelBase(_project);
    if (fakeModel == null) {
      throw new CoreException(EGFPDEPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("AbstractChangesCommand.createNewPlugin(..) _ project ''{0}'' is not a bundle project.", _project.getModificationStamp()), null)); //$NON-NLS-1$
    }
    WorkspacePluginModelBase pluginModel = PluginHelper.createWorkspacePluginModelBase(fakeModel);
    if (pluginModel == null) {
      return;
    }
    _pluginModelBase = pluginModel;
    doExecute(monitor);
    pluginModel.save();
    PluginHelper.updateBuildFile(pluginModel);
  }

  private void modifyExistingPlugin(final IProgressMonitor monitor) {
    EGFPDEPlugin.getDisplay().syncExec(new Runnable() {

      public void run() {
        // Create an update operation that deals with modifying extensions.
        ModelModification updateOperation = new ModelModification(_project.getFile(PDEModelUtility.F_PLUGIN)) {

          @Override
          protected void modifyModel(IBaseModel model, IProgressMonitor innerMonitor) throws CoreException {
            if (model == null) {
              return;
            }
            if (model instanceof IPluginModelBase == false) {
              return;
            }
            _pluginModelBase = (IPluginModelBase) model;
            doExecute(innerMonitor);
          }
        };
        // Let's update the file.
        PDEModelUtility.modifyModel(updateOperation, monitor);
      }
    });
  }

  protected abstract void doExecute(IProgressMonitor monitor) throws CoreException;

}
