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
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;

public class ConsoleFactory implements IConsoleFactory {

  public ConsoleFactory() {
    // Nothing to do
  }

  public void openConsole() {
    showConsole();
  }

  public static void showConsole() {
    Console console = EGFConsolePlugin.getConsole();
    if (console != null) {
      IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
      IConsole[] existing = manager.getConsoles();
      boolean exists = false;
      for (int i = 0; i < existing.length; i++) {
        if (console == existing[i]) {
          exists = true;
        }
      }
      if (exists == false) {
        manager.addConsoles(new IConsole[] { console });
      }
      manager.showConsoleView(console);
    }
  }

  public static void closeConsole() {
    IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
    Console console = EGFConsolePlugin.getConsole();
    if (console != null) {
      manager.removeConsoles(new IConsole[] { console });
      ConsolePlugin.getDefault().getConsoleManager().addConsoleListener(console.new MyLifecycle());
    }
  }

}
