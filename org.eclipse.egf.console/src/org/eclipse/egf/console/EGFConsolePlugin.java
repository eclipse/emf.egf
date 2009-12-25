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
package org.eclipse.egf.console;

import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.egf.console.internal.ColorManager;
import org.eclipse.egf.console.internal.Console;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFConsolePlugin extends EGFAbstractUIPlugin {

  private static EGFConsolePlugin __plugin;

  /**
   * @return the EGF console
   */
  public static Console getConsole() {
    return getDefault().getInnerConsole();
  }

  /**
   * Returns the standard display to be used. The method first checks, if
   * the thread calling this method has an associated display. If so, this
   * display is returned. Otherwise the method returns the default display.
   */
  public static Display getStandardDisplay() {
    Display display = Display.getCurrent();
    if (display == null) {
      display = Display.getDefault();
    }
    return display;
  }

  private Console _console;

  /**
   * The constructor
   */
  public EGFConsolePlugin() {
    super();
  }

  public Color getPreferenceColor(String type) {
    return ColorManager.getDefault().getColor(PreferenceConverter.getColor(getDefault().getPreferenceStore(), type));
  }

  protected Console getInnerConsole() {
    return _console;
  }

  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
    try {
      _console = new Console();
    } catch (RuntimeException re) {
      // Don't let the console bring down UI
      logError("Errors occurred starting the EGF console", re); //$NON-NLS-1$
    }
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    try {
      ColorManager.getDefault().dispose();
      if (_console != null) {
        _console.shutdown();
      }
      __plugin = null;
    } finally {
      super.stop(context);
    }
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static EGFConsolePlugin getDefault() {
    return __plugin;
  }

}
