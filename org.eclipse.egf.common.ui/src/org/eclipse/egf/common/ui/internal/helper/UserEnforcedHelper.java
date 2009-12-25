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
package org.eclipse.egf.common.ui.internal.helper;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.IUserEnforcedHelper;
import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Helper methods enforced by user interaction.<br>
 * It should not be overridden nor instantiated.<br>
 * It is located here for dependencies issues.
 * 
 * @author Guillaume Brocard
 */
public class UserEnforcedHelper implements IUserEnforcedHelper {

  /**
   * @see org.eclipse.egf.common.helper.IUserEnforcedHelper#makeFileWritable(org.eclipse.core.resources.IFile)
   */
  public IStatus makeFileWritable(final IFile file_p) {
    // Resulting status.
    final IStatus[] result = new IStatus[] { Status.CANCEL_STATUS };
    // Get display, if any.
    // Do not create a new one if none, simply ignore it.
    final Display display = PlatformUI.isWorkbenchRunning() ? PlatformUI.getWorkbench().getDisplay() : null;
    // Execute through a runnable.
    Runnable makeFileWritableRunnable = new Runnable() {
      public void run() {
        result[0] = makeFileWritable(file_p, display);
      }
    };
    // Whether it is displaying a user interface dialog or not, the execution is
    // always synchronous.
    if (display != null) {
      // Ask user, if needed.
      display.syncExec(makeFileWritableRunnable);
    } else {
      // No way to ask user, execute it.
      makeFileWritableRunnable.run();
    }
    return result[0];
  }

  /**
   * @see org.eclipse.egf.common.helper.IUserEnforcedHelper#makeFileWritable(org.eclipse.core.resources.IFile,
   *      java.lang.Object)
   */
  public IStatus makeFileWritable(IFile file_p, Object display_p) {
    // Given file must not be null.
    if (file_p == null) {
      return Status.CANCEL_STATUS;
    }
    // If file does not exist, then it is writable.
    if (file_p.exists() == false) {
      return Status.OK_STATUS;
    }
    // Resulting shell.
    Shell shell = null;
    // Given display object must indeed be a display.
    if (display_p instanceof Display) {
      // Get shell from display.
      shell = ((Display) display_p).getActiveShell();
    }
    // If a shell is active, use it to make sure an end-user confirmation is
    // performed (as needed).
    // Try validate prompt behavior otherwise.
    Object context = shell == null ? IWorkspace.VALIDATE_PROMPT : shell;
    // Check given file.
    IStatus result = ResourcesPlugin.getWorkspace().validateEdit(new IFile[] { file_p }, context);
    if (result.isOK() == false) {
      EGFCommonUIPlugin.getDefault().log(result);
    }
    return result;
  }

}
