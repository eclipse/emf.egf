/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Thales Corporate Services S.A.S
 */

package org.eclipse.egf.console.internal;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ConsolePreferenceInitializer extends AbstractPreferenceInitializer {

  public ConsolePreferenceInitializer() {
    super();
  }

  /*
   * (non-Javadoc)
   * 
   * @seeorg.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
   * initializeDefaultPreferences()
   */
  @Override
  public void initializeDefaultPreferences() {
    final IPreferenceStore prefs = EGFConsolePlugin.getDefault().getPreferenceStore();
    PreferenceConverter.setDefault(prefs, IEGFConsoleConstants.CONSOLE_ERROR_COLOR, new RGB(255, 0, 0));
    PreferenceConverter.setDefault(prefs, IEGFConsoleConstants.CONSOLE_WARNING_COLOR, new RGB(64, 128, 128));
    PreferenceConverter.setDefault(prefs, IEGFConsoleConstants.CONSOLE_INFO_COLOR, new RGB(0, 0, 255));
    PreferenceConverter.setDefault(prefs, IEGFConsoleConstants.CONSOLE_DEBUG_COLOR, new RGB(0, 0, 0));
    prefs.setDefault(IEGFConsoleConstants.CONSOLE_SHOW_ON_MESSAGE, true);
    prefs.setDefault(IEGFConsoleConstants.CONSOLE_WRAP, false);
    prefs.setDefault(IEGFConsoleConstants.CONSOLE_WIDTH, 220);
    prefs.setDefault(IEGFConsoleConstants.CONSOLE_LIMIT_OUTPUT, true);
    prefs.setDefault(IEGFConsoleConstants.CONSOLE_LOW_WATER_MARK, 8 * 1024);
    prefs.setDefault(IEGFConsoleConstants.CONSOLE_HIGH_WATER_MARK, 64 * 1024);
    // can be called in non-UI thread, so we must play safe
    final Display display = EGFConsolePlugin.getWorkbenchDisplay();
    if (display != null) {
      if (Thread.currentThread().equals(display.getThread())) {
        PreferenceConverter.setDefault(prefs, IEGFConsoleConstants.CONSOLE_BACKGROUND_COLOR, display.getSystemColor(SWT.COLOR_LIST_BACKGROUND).getRGB());
      } else {
        display.asyncExec(new Runnable() {
          public void run() {
            PreferenceConverter.setDefault(prefs, IEGFConsoleConstants.CONSOLE_BACKGROUND_COLOR, display.getSystemColor(SWT.COLOR_LIST_BACKGROUND).getRGB());
          }
        });
      }
    }
  }

}
