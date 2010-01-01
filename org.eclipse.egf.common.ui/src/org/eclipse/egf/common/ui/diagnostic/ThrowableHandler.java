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
package org.eclipse.egf.common.ui.diagnostic;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.egf.common.ui.l10n.EGFCommonUIMessages;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ThrowableHandler {

  private ThrowableHandler() {
    // Prevent Instantiation
  }

  public static void displayAsyncDiagnostic(final Shell shell, final Throwable throwable, final String pluginID) {
    if (throwable == null) {
      return;
    }
    final String id = pluginID != null ? pluginID : EGFCommonUIPlugin.getDefault().getPluginID();
    if (EGFCommonUIPlugin.getWorkbenchDisplay() != null) {
      EGFCommonUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {
        public void run() {
          IStatus status;
          String message = throwable.getMessage() != null ? throwable.getMessage() : throwable.toString();
          if (throwable instanceof CoreException) {
            status = ((CoreException) throwable).getStatus();
            // if the 'message' resource string and the IStatus' message are the same,
            // don't show both in the dialog
            if (status != null && message.equals(status.getMessage())) {
              message = null;
            }
          } else {
            status = new Status(IStatus.ERROR, id, 0, EGFCommonUIMessages.Unexpected_Error, throwable);
          }
          ErrorDialog.openError(shell, EGFCommonUIMessages.ThrowableHandler_Title, message, status);
        }
      });
    }
  }
}
