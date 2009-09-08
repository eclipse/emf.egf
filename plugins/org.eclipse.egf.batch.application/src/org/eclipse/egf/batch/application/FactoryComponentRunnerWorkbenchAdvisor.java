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
package org.eclipse.egf.batch.application;

import java.net.URL;
import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.model.WorkbenchAdapterBuilder;

import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.ui.workbench.perspective.EgfPerspective;

/**
 * This class configures the workbench to be able to run a factory component.
 * @author Guillaume Brocard
 */
public class FactoryComponentRunnerWorkbenchAdvisor extends WorkbenchAdvisor {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(FactoryComponentRunnerWorkbenchAdvisor.class.getPackage().getName());
  private String _factoryComponentId;

  /**
   * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)
   */
  @Override
  public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
    return new FactoryComponentRunnerWorkbenchWindowAdvisor(configurer);
  }

  /**
   * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()
   */
  @Override
  public String getInitialWindowPerspectiveId() {
    return EgfPerspective.PERSPECTIVE_ID;
  }

  /**
   * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)
   */
  @Override
  public void initialize(IWorkbenchConfigurer configurer_p) {
    configurer_p.setSaveAndRestore(true);
    WorkbenchAdapterBuilder.registerAdapters();
    declareWorkbenchImages(configurer_p);
  }

  /**
   * Declares a workbench image.
   * @param configurer_p
   * @param symbolicName_p the symbolic name of the image
   * @param path_p the path of the image file; this path is relative to the base of the IDE plug-in
   * @param shared_p <code>true</code> if this is a shared image, and <code>false</code> if this is not a shared image
   * @see IWorkbenchConfigurer#declareImage
   */
  private void declareWorkbenchImage(IWorkbenchConfigurer configurer_p, Bundle bundle_p, String symbolicName_p, String path_p, boolean shared_p) {
    URL url = bundle_p.getEntry(path_p);
    ImageDescriptor desc = ImageDescriptor.createFromURL(url);
    configurer_p.declareImage(symbolicName_p, desc, shared_p);
  }

  /**
   * Declares specific workbench images.
   * @see IWorkbenchConfigurer#declareImage
   */
  private void declareWorkbenchImages(IWorkbenchConfigurer configurer_p) {
    final String ICONS_PATH = "icons/full/obj16/";//$NON-NLS-1$
    // Declare IDE specific images.
    Bundle ideBundle = Platform.getBundle("org.eclipse.ui.ide"); //$NON-NLS-1$
    declareWorkbenchImage(configurer_p, ideBundle, IDE.SharedImages.IMG_OBJ_PROJECT, ICONS_PATH + "prj_obj.gif", true); //$NON-NLS-1$
    declareWorkbenchImage(configurer_p, ideBundle, IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, ICONS_PATH + "cprj_obj.gif", true); //$NON-NLS-1$
    // Declare UI specific images.
    Bundle uiBundle = Platform.getBundle("org.eclipse.ui"); //$NON-NLS-1$
    declareWorkbenchImage(configurer_p, uiBundle, ISharedImages.IMG_OBJ_FILE, ICONS_PATH + "file_obj.gif", true); //$NON-NLS-1$
    declareWorkbenchImage(configurer_p, uiBundle, ISharedImages.IMG_OBJ_FOLDER, ICONS_PATH + "fldr_obj.gif", true); //$NON-NLS-1$
  }

  /**
   * @see org.eclipse.ui.application.WorkbenchAdvisor#postStartup()
   */
  @Override
  public void postStartup() {
    // First, refresh the workspace content.
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    try {
      root.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("FactoryComponentRunnerWorkbenchAdvisor.postStartup(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);

    }
    // Create a new job that runs given factory component from its id.
    String jobMessage = MessageFormat.format(Messages.FactoryComponentRunnerWorkbenchAdvisor_Job_Title, new Object[] { _factoryComponentId });
    Job executeFactoryComponentJob = new WorkspaceJob(jobMessage) {
      /**
       * @see org.eclipse.core.resources.WorkspaceJob#runInWorkspace(org.eclipse.core.runtime.IProgressMonitor)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      public IStatus runInWorkspace(IProgressMonitor monitor_p) throws CoreException {
        // Run the factory component from its id.
        CoreActivator.getDefault().generateFactoryComponent(_factoryComponentId, monitor_p, false);
        // Close the workbench, because factory component run is over.
        final IWorkbench workbench = PlatformUI.getWorkbench();
        workbench.getDisplay().asyncExec(new Runnable() {
          /**
           * @see java.lang.Runnable#run()
           */
          public void run() {
            workbench.close();
          }
        });
        return Status.OK_STATUS;
      }
    };
    // Execute the job.
    executeFactoryComponentJob.setRule(root);
    executeFactoryComponentJob.schedule();
  }

  /**
   * Set the value of the factory component to execute.
   * @param fcId_p
   */
  public void setExecutedFactoryComponentId(String fcId_p) {
    _factoryComponentId = fcId_p;
  }
}
