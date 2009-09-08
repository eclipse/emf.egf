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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * This class configures the action bars content of a workbench window.
 * @author Guillaume Brocard
 */
public class FactoryComponentRunnerActionBarAdvisor extends ActionBarAdvisor {
  /**
   * Constructor.
   * @param configurer
   */
  public FactoryComponentRunnerActionBarAdvisor(IActionBarConfigurer configurer) {
    super(configurer);
  }

  /**
   * @see org.eclipse.ui.application.ActionBarAdvisor#makeActions(org.eclipse.ui.IWorkbenchWindow)
   */
  @Override
  protected void makeActions(IWorkbenchWindow window) {
    // Do nothing.
  }

  @Override
  protected void fillMenuBar(IMenuManager menuBar) {
    // Do nothing.
  }
}
