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

import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFConsolePlugin extends EGFAbstractUIPlugin {

  private static EGFConsolePlugin __plugin;

  private static final String ICONS_PATH = "$nl$/icons/"; //$NON-NLS-1$  

  /**
   * @return the EGF console
   */
  public static Console getConsole() {
    return getDefault().getInnerConsole();
  }

  /**
   * Returns the workbench display to be used.
   */
  public static Display getWorkbenchDisplay() {
    return PlatformUI.getWorkbench().getDisplay();
  }

  private Console _console;

  /**
   * The constructor
   */
  public EGFConsolePlugin() {
    super();
  }

  /**
   * Get an image descriptor for given key.<br>
   * Images must be located in 'plug-in folder'/icons
   * 
   * @param key_p
   *          the key must be the file name of the related image.
   * @return an {@link ImageDescriptor} or null if not found
   */
  public ImageDescriptor getImageDescriptor(String key_p) {
    ImageRegistry imageRegistry = getImageRegistry();
    ImageDescriptor imageDescriptor = imageRegistry.getDescriptor(key_p);
    if (imageDescriptor == null) {
      imageDescriptor = createImageDescriptor(key_p);
      imageRegistry.put(key_p, imageDescriptor);
    }
    return imageDescriptor;
  }

  public Color getPreferenceColor(String type) {
    return ColorManager.getDefault().getColor(PreferenceConverter.getColor(getDefault().getPreferenceStore(), type));
  }

  /**
   * Create an image descriptor for given key.<br>
   * Images must be located in 'plug-in folder'/icons
   * 
   * @param key_p
   *          the key must be the file name of the related image.
   * @return an {@link ImageDescriptor} or null if error occurred
   */
  protected ImageDescriptor createImageDescriptor(String key_p) {
    return EGFAbstractUIPlugin.imageDescriptorFromPlugin(getPluginID(), ICONS_PATH + key_p);
  }

  /**
   * Get the plug-in ID according to MANIFEST.MF definition.
   * 
   * @return a String containing the plug-in ID.
   */
  public String getPluginID() {
    return getBundle().getSymbolicName();
  }

  protected Console getInnerConsole() {
    return _console;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
   * )
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
    try {
      _console = new Console();
    } catch (RuntimeException re) {
      // Don't let the console bring down UI
      logError("Errors occurred starting the console", re); //$NON-NLS-1$
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
   * )
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
