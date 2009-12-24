/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.log.IEGFLogger;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFEclipsePlugin extends EclipsePlugin {

  /**
   * Log Object
   */

  @Override
  public void log(Object object) {
    log(object, 0, true);
  }

  public void log(Object object, boolean appendLogger) {
    log(object, 0, appendLogger);
  }

  public void log(Object object, int nesting) {
    log(object, nesting, true);
  }

  public void log(Object logEntry, int nesting, boolean appendLogger) {
    IStatus status;
    if (logEntry instanceof IStatus) {
      status = (IStatus) logEntry;
      logStatus(status, nesting, appendLogger);
    } else {
      if (logEntry == null) {
        logEntry = new RuntimeException(getString("_UI_NullLogEntry_exception", true)).fillInStackTrace();
      }

      if (logEntry instanceof Throwable) {
        Throwable throwable = (Throwable) logEntry;

        // System.err.println("Logged throwable: --------------------");
        // throwable.printStackTrace();

        String message = throwable.getLocalizedMessage();
        if (message == null) {
          message = "";
        }

        status = new Status(IStatus.WARNING, getBundle().getSymbolicName(), 0, message, throwable);
        logStatus(status, nesting, appendLogger);
      } else {
        // System.err.println("Logged throwable: --------------------");
        // throwable.printStackTrace();
        status = new Status(IStatus.WARNING, getBundle().getSymbolicName(), 0, logEntry.toString(), null);
        logStatus(status, nesting, appendLogger);
      }
    }
  }

  private void logStatus(IStatus status, int nesting, boolean appendLogger) {
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
    return new Status(severity, getSymbolicName(), 0, message, exception);
  }

}
