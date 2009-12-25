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

import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Xavier Maysonnave
 * 
 */
public class DiagnosticHandler {

  private DiagnosticHandler() {
    // Prevent Instantiation
  }

  public static void displayAsyncDiagnostic(final Shell shell, final Throwable throwable) {
    if (EGFCommonUIPlugin.getWorkbenchDisplay() != null) {
      EGFCommonUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {
        public void run() {
          MessageDialog dialog = new MessageDialog(shell, throwable.getClass().getSimpleName(), null, throwable.getMessage(), MessageDialog.ERROR, new String[] { IDialogConstants.OK_LABEL }, 0);
          dialog.open();
        }
      });
    }
  }

}
