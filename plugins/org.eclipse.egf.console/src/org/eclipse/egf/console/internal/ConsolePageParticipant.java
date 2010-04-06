/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.console.internal;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;

public class ConsolePageParticipant implements IConsolePageParticipant {

  private ConsoleRemoveAction consoleRemoveAction;

  public void init(IPageBookViewPage page, IConsole console) {
    this.consoleRemoveAction = new ConsoleRemoveAction();
    IActionBars bars = page.getSite().getActionBars();
    bars.getToolBarManager().appendToGroup(IConsoleConstants.LAUNCH_GROUP, consoleRemoveAction);
  }

  public void dispose() {
    this.consoleRemoveAction = null;
  }

  public void activated() {
    // Nothing to do
  }

  public void deactivated() {
    // Nothing to do
  }

  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter) {
    return null;
  }

}
