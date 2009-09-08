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

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * This class configures the workbench to be able to run a factory component.
 * @author Guillaume Brocard
 */
public class FactoryComponentRunnerWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {
  /**
   * Constructor.
   * @param configurer
   */
  public FactoryComponentRunnerWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
    super(configurer);
  }

  /**
   * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#createActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)
   */
  @Override
  public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
    return new FactoryComponentRunnerActionBarAdvisor(configurer);
  }

  /**
   * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#preWindowOpen()
   */
  @Override
  public void preWindowOpen() {
    IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
    configurer.setInitialSize(new Point(400, 300));
    configurer.setShowCoolBar(true);
    configurer.setShowStatusLine(true);
    configurer.setShowProgressIndicator(true);
    configurer.setTitle(Messages.FactoryComponentRunnerWorkbenchWindowAdvisor_Application_Title);
  }
}
