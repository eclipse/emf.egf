/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.common.ui.activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.activator.EGFCommonPlugin;
import org.eclipse.egf.common.log.IEGFLogger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Base class for plug-ins that integrate with the Eclipse platform UI.<br>
 * 
 * @author Xavier Maysonnave
 */
public abstract class EGFAbstractUIPlugin extends AbstractUIPlugin {

  private static final String ICONS_PATH = "$nl$/icons/"; //$NON-NLS-1$  

  /**
   * Returns the workbench display to be used.
   */
  public static Display getWorkbenchDisplay() {
    return PlatformUI.getWorkbench().getDisplay();
  }

  /**
   * Log Status
   */

  public void log(IStatus status) {
    log(status, 0, true);
  }

  public void log(IStatus status, boolean appendLogger) {
    log(status, 0, appendLogger);
  }

  public void log(IStatus status, int nesting) {
    log(status, nesting, true);
  }

  public void log(IStatus status, int nesting, boolean appendLogger) {
    getLog().log(status);
    if (appendLogger) {
      for (IEGFLogger logger : EGFCommonPlugin.getEGFLoggers()) {
        logger.logStatus(status, nesting);
      }
    }
  }

  /**
   * Log Message Info
   */

  public void logInfo(String message) {
    logInfo(message, 0, true);
  }

  public void logInfo(String message, boolean appendLogger) {
    logInfo(message, 0, appendLogger);
  }

  public void logInfo(String message, int nesting) {
    logInfo(message, nesting, true);
  }

  public void logInfo(String message, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.INFO, message, null), nesting, appendLogger);
  }

  /**
   * Log Message and Throwable Info
   */

  public void logInfo(String message, Throwable t) {
    logInfo(message, t, 0, true);
  }

  public void logInfo(String message, Throwable t, boolean appendLogger) {
    logInfo(message, t, 0, appendLogger);
  }

  public void logInfo(String message, Throwable t, int nesting) {
    logInfo(message, t, nesting, true);
  }

  public void logInfo(String message, Throwable t, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.INFO, message, t), nesting, appendLogger);
  }

  /**
   * Log Throwable Info
   */

  public void logInfo(Throwable t) {
    logInfo(t, 0, true);
  }

  public void logInfo(Throwable t, boolean appendLogger) {
    logInfo(t, 0, appendLogger);
  }

  public void logInfo(Throwable t, int nesting) {
    logInfo(t, nesting, true);
  }

  public void logInfo(Throwable t, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.INFO, t.getMessage(), t), nesting, appendLogger);
  }

  /**
   * Log Message Error
   */

  public void logError(String message) {
    logError(message, 0, true);
  }

  public void logError(String message, boolean appendLogger) {
    logError(message, 0, appendLogger);
  }

  public void logError(String message, int nesting) {
    logError(message, nesting, true);
  }

  public void logError(String message, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.ERROR, message, null), nesting, appendLogger);
  }

  /**
   * Log Message and Throwable Error
   */

  public void logError(String message, Throwable t) {
    logError(message, t, 0, true);
  }

  public void logError(String message, Throwable t, boolean appendLogger) {
    logError(message, t, 0, appendLogger);
  }

  public void logError(String message, Throwable t, int nesting) {
    logError(message, t, nesting, true);
  }

  public void logError(String message, Throwable t, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.ERROR, message, t), nesting, appendLogger);
  }

  /**
   * Log Throwable Error
   */

  public void logError(Throwable t) {
    logError(t, 0, true);
  }

  public void logError(Throwable t, boolean appendLogger) {
    logError(t, 0, appendLogger);
  }

  public void logError(Throwable t, int nesting) {
    logError(t, nesting, true);
  }

  public void logError(Throwable t, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.ERROR, t.getMessage(), t), nesting, appendLogger);
  }

  /**
   * Log Message Warning
   */

  public void logWarning(String message) {
    logWarning(message, 0, true);
  }

  public void logWarning(String message, boolean appendLogger) {
    logWarning(message, 0, appendLogger);
  }

  public void logWarning(String message, int nesting) {
    logWarning(message, nesting, true);
  }

  public void logWarning(String message, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.WARNING, message, null), nesting, appendLogger);
  }

  /**
   * Log Message and Throwable Warning
   */

  public void logWarning(String message, Throwable t) {
    logWarning(message, t, 0, true);
  }

  public void logWarning(String message, Throwable t, boolean appendLogger) {
    logWarning(message, t, 0, appendLogger);
  }

  public void logWarning(String message, Throwable t, int nesting) {
    logWarning(message, t, nesting, true);
  }

  public void logWarning(String message, Throwable t, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.WARNING, message, t), nesting, appendLogger);
  }

  /**
   * Log Throwable Warning
   */

  public void logWarning(Throwable t) {
    logWarning(t, 0, true);
  }

  public void logWarning(Throwable t, boolean appendLogger) {
    logWarning(t, 0, appendLogger);
  }

  public void logWarning(Throwable t, int nesting) {
    logWarning(t, nesting, true);
  }

  public void logWarning(Throwable t, int nesting, boolean appendLogger) {
    log(newStatus(IStatus.WARNING, t.getMessage(), t), nesting, appendLogger);
  }

  /**
   * Create an IStatus
   * 
   * @return a new IStatus
   */
  private IStatus newStatus(int severity, String message, Throwable exception) {
    return new Status(severity, getPluginID(), 0, message, exception);
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

  /**
   * Get an image for given key.<br>
   * Images must be located in 'plug-in folder'/icons
   * 
   * @param key_p
   *          the key must be the file name of the related image.
   * @return an {@link Image} or null if not found
   */
  public Image getImage(String key_p) {
    ImageRegistry imageRegistry = getImageRegistry();
    Image image = imageRegistry.get(key_p);
    if (image == null) {
      // Create an image descriptor for given id.
      ImageDescriptor imageDescriptor = createImageDescriptor(key_p);
      // Store the (id, imageDescriptor) rather than (id,image)
      // because with storing (id,image) the getDescriptor method will
      // return null in later usage
      // this way, everything is correctly initialized.
      imageRegistry.put(key_p, imageDescriptor);
      // Everything is all right at this step, let's get the real image
      image = imageRegistry.get(key_p);
    }
    return image;
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

}