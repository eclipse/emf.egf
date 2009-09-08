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
package org.eclipse.egf.batch.application.headless;

import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.batch.application.Messages;
import org.eclipse.egf.core.CoreActivator;


/**
 * Run given factory component from a given id.
 * @author Guillaume Brocard
 */
public class FactoryComponentHeadlessApplication {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(FactoryComponentHeadlessApplication.class.getPackage().getName());

  public synchronized void run(final String factoryComponentId_p) {
    String jobMessage = MessageFormat.format(Messages.FactoryComponentRunnerWorkbenchAdvisor_Job_Title, new Object[] { factoryComponentId_p });
    Job executeFactoryComponentJob = new WorkspaceJob(jobMessage) {
      /**
       * @see org.eclipse.core.resources.WorkspaceJob#runInWorkspace(org.eclipse.core.runtime.IProgressMonitor)
       */
      @Override
      public IStatus runInWorkspace(IProgressMonitor monitor_p) throws CoreException {
        // Run the factory component from its id.
        CoreActivator.getDefault().generateFactoryComponent(factoryComponentId_p, new NullProgressMonitor(), false);
        return Status.OK_STATUS;
      }
    };
    // Execute the job.
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    executeFactoryComponentJob.setRule(root);
    executeFactoryComponentJob.schedule();
    try {
      executeFactoryComponentJob.join();
    } catch (InterruptedException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("FactoryComponentHeadlessApplication.run(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}
