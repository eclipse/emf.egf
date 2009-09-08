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

package org.eclipse.egf.console;

import org.osgi.framework.BundleContext;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;

import org.eclipse.egf.common.ui.activator.AbstractUIActivator;


/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFConsolePlugin extends AbstractUIActivator {

  private static EGFConsolePlugin __plugin;

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

  /**
   * @return the EGF console
   */
  public static Console getConsole() {
    return getDefault().getInnerConsole();
  }

  protected Console getInnerConsole() {
    return _console;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;    
    try {
      _console = new Console();
    } catch (RuntimeException e) {
      // Don't let the console bring down UI
      log(IStatus.ERROR, "Errors occurred starting the console", e); //$NON-NLS-1$
    }
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    ColorManager.getDefault().dispose();
    __plugin = null;
    super.stop(context);
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
