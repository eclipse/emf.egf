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
package org.eclipse.egf.common.ui.helper;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.StatusHelper;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ThrowableHandler {

  private ThrowableHandler() {
    // Prevent Instantiation
  }

  public static void handleThrowable(String pluginID, Throwable t) {
    IStatus status = null;
    if (t instanceof CoreException) {
      CoreException ce = (CoreException) t;
      status = ce.getStatus();
    } else if (t instanceof InvocationTargetException) {
      InvocationTargetException ite = (InvocationTargetException) t;
      status = StatusHelper.newStatus(pluginID, IStatus.ERROR, ite.getClass().getSimpleName(), ite.getTargetException());
    } else {
      status = StatusHelper.newStatus(pluginID, IStatus.ERROR, t.getClass().getSimpleName(), t);
    }
    StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
  }

}
