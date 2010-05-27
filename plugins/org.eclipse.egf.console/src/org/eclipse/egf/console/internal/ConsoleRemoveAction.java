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

import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.console.l10n.ConsoleMessages;
import org.eclipse.jface.action.Action;

public class ConsoleRemoveAction extends Action {

  public static final String _id = "org.eclipse.egf.console.internal.ConsoleRemoveAction"; //$NON-NLS-1$  

  ConsoleRemoveAction() {
    super(ConsoleMessages.Console_close);
    setDisabledImageDescriptor(EGFConsolePlugin.getDefault().getImageDescriptor(IEGFConsoleConstants.IMG_DISABLED_CLOSE_CONSOLE));
    setImageDescriptor(EGFConsolePlugin.getDefault().getImageDescriptor(IEGFConsoleConstants.IMG_ENABLED_CLOSE_CONSOLE));
    setId(_id);
  }

  @Override
  public void run() {
    ConsoleFactory.closeConsole();
  }

}
