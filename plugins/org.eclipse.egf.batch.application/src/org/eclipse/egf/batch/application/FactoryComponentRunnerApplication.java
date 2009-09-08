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
package org.eclipse.egf.batch.application;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * This class controls all aspects of the application's execution.<br>
 * This application is a workbench window that runs given factory component and exit immediately when execution is done.
 */
public class FactoryComponentRunnerApplication implements IApplication {
  /**
   * Constant to be used to set the factory component to run.
   */
  public static final String FACTORY_COMPONENT_ID = "-factoryComponentId"; //$NON-NLS-1$

  /**
   * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
   */
  public Object start(IApplicationContext context_p) throws Exception {
    String[] args = (String[]) context_p.getArguments().get(IApplicationContext.APPLICATION_ARGS);
    return run(args);
  }

  /**
   * Starts this application with the given context and returns a result.
   * @param args_p
   * @return
   */
  public Object run(String[] args_p) {
    String factoryComponentId = getFactoryComponentId(args_p);
    // Precondition.
    if ((null == factoryComponentId) || (factoryComponentId.length() == 0)) {
      // Exist with failed status.
      return new Integer(-1);
    }
    Display display = PlatformUI.createDisplay();
    try {
      FactoryComponentRunnerWorkbenchAdvisor workbenchAdvisor = new FactoryComponentRunnerWorkbenchAdvisor();
      // Set it the factory component to run.
      workbenchAdvisor.setExecutedFactoryComponentId(factoryComponentId);
      int returnCode = PlatformUI.createAndRunWorkbench(display, workbenchAdvisor);
      if (returnCode == PlatformUI.RETURN_RESTART) {
        return IApplication.EXIT_RESTART;
      }
      return IApplication.EXIT_OK;
    } finally {
      display.dispose();
    }
  }

  /**
   * @see org.eclipse.equinox.app.IApplication#stop()
   */
  public void stop() {
    final IWorkbench workbench = PlatformUI.getWorkbench();
    if (workbench == null)
      return;
    final Display display = workbench.getDisplay();
    display.syncExec(new Runnable() {
      public void run() {
        if (!display.isDisposed())
          workbench.close();
      }
    });
  }

  /**
   * Get the fc id from the arguments command line.
   * @return
   */
  private String getFactoryComponentId(String[] args_p) {
    String result = null;
    for (int i = 0; i < args_p.length && (null == result); i++) {
      String argument = args_p[i];
      if (argument.equals(FACTORY_COMPONENT_ID)) {
        result = args_p[++i];
      }
    }
    return result;
  }
}
