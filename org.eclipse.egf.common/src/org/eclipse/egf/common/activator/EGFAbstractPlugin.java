/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.common.activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.StatusHelper;

/**
 * @author fournier
 */
public abstract class EGFAbstractPlugin extends Plugin {
  
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
   * Get the plug-in ID according to MANIFEST.MF definition.
   * 
   * @return a String containing the plug-in ID.
   */
  public String getPluginID() {
    return getBundle().getSymbolicName();
  }
    
}
