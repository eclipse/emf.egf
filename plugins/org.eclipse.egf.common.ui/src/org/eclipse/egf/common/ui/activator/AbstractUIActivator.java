/**
 *  Copyright (c) 2007, 2009 La Carotte Et Le Baton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      La Carotte Et Le Baton - initial API and implementation
 */
package org.eclipse.egf.common.ui.activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.StatusHelper;

/**
 * Base class for plug-ins that integrate with the Eclipse platform UI.<br>
 * 
 * @author fournier
 */
public abstract class AbstractUIActivator extends AbstractUIPlugin {
  
  private static final String ICONS_PATH = "$nl$/icons/"; //$NON-NLS-1$ 
  
  /**
   * Returns the workbench display to be used.
   */
  public static Display getWorkbenchDisplay() {
    return PlatformUI.getWorkbench().getDisplay();
  }  
  
  public void log(Throwable t) {
    log(newErrorStatus(t.getMessage(), t));
  }

  /**
   * Returns a new error status for this plug-in with the given message
   * @param message the message to be included in the status
   * @param exception the exception to be included in the status or <code>null</code> if none
   * @return a new error status
   */
  public IStatus newErrorStatus(String message, Throwable exception) {
    return new Status(IStatus.ERROR, getPluginID(), ICommonConstants.INTERNAL_ERROR, message, exception);
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
      // because with storing (id,image) the getDescriptor method will return null in later usage
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
    ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(getPluginID(), ICONS_PATH + key_p);
    return imageDescriptor;
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