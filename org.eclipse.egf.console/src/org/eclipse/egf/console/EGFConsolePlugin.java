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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.console.helper.StatusHelper;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFConsolePlugin extends AbstractUIPlugin {

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
    
  public void log(Throwable t) {
    log(newErrorStatus(t.getMessage(), t));
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
    return AbstractUIPlugin.imageDescriptorFromPlugin(getPluginID(), ICONS_PATH + key_p);
  }  
  
  /**
   * Get the plug-in ID according to MANIFEST.MF definition.
   * 
   * @return a String containing the plug-in ID.
   */
  public String getPluginID() {
    return getBundle().getSymbolicName();
  }  

  /**
   * Returns a new error status for this plug-in with the given message
   * @param message the message to be included in the status
   * @param exception the exception to be included in the status or <code>null</code> if none
   * @return a new error status
   */
  public IStatus newErrorStatus(String message, Throwable exception) {
    return new Status(IStatus.ERROR, getPluginID(), 0, message, exception);
  }

  /**
   * Logs the given message to the platform log.
   * 
   * If you have an exception in hand, call log(String, Throwable) instead.
   * 
   * If you have a status object in hand call log(String, IStatus) instead.
   * 
   * @param message A high level UI message describing when the problem happened.
   */
  public void log(String message) {
    getLog().log(StatusHelper.newStatus(getPluginID(), IStatus.ERROR, message, null));
  }

  /**
   * Logs the given message and throwable to the platform log.
   * 
   * If you have a status object in hand call log(String, IStatus) instead.
   * 
   * 
   * @param message A high level UI message describing when the problem happened.
   * @param t The throwable from where the problem actually occurred.
   */
  public void log(String message, Throwable t) {
    log(message, StatusHelper.newStatus(getPluginID(), IStatus.ERROR, message, t));
  }

  /**
   * Logs the given throwable to the platform log, indicating the class and method from where it is being logged (this is not necessarily where it occurred).
   * 
   * @param clazz The calling class.
   * @param methodName The calling method name.
   * @param t The throwable from where the problem actually occurred.
   */
  public void log(Class<?> clazz, String methodName, Throwable t) {
    log(NLS.bind("Exception in {0}.{1}: {2}", new Object []{ clazz.getName(), methodName, t }), t); //$NON-NLS-1$
  }

  /**
   * Logs the given message and status to the platform log.
   * 
   * @param status The status describing the problem. Must not be null.
   */
  public void log(IStatus status) {
    log(null, status);
  }

  /**
   * Log the given exception along with the provided message and severity indicator
   */
  public void log(int severity, String message, Throwable e) {
    log(new Status(severity, getPluginID(), 0, message, e));
  }

  /**
   * Logs the given message and status to the platform log.
   * 
   * @param message A high level UI message describing when the problem happened. May be <code>null</code>.
   * @param status The status describing the problem. Must not be null.
   */
  public void log(String message, IStatus status) {
    // 1FTUHE0: ITPCORE:ALL - API - Status & logging - loss of semantic info
    if (message != null) {
      getLog().log(StatusHelper.newStatus(getPluginID(), IStatus.ERROR, message, null));
    }
    getLog().log(status);
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
