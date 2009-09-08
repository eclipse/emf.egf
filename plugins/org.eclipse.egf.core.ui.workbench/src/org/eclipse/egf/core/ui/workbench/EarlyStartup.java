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
package org.eclipse.egf.core.ui.workbench;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;

/**
 * @author Guillaume Brocard
 */
public class EarlyStartup implements IStartup {

  /**
   * @see org.eclipse.ui.IStartup#earlyStartup()
   */
  public void earlyStartup() {
    // Make sure the job is done in the UI Thread.
    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
      /**
       * @see java.lang.Runnable#run()
       */
      public void run() {
        // The active page is displayed, let's register some listeners regarding the working sets management.
        EgfWorkbenchActivator egfWorkbenchActivator = EgfWorkbenchActivator.getDefault();
        egfWorkbenchActivator.registerPackageExplorerListeners(null);
        egfWorkbenchActivator.registerPackageExplorerPartListener();
      }
    });
  }
}
