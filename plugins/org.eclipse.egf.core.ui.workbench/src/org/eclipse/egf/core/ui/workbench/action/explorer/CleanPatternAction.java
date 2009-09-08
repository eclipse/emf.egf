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
package org.eclipse.egf.core.ui.workbench.action.explorer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.progress.IProgressRunnable;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Clean the generated structures for selected pattern.
 * @author Guillaume Brocard
 */
public class CleanPatternAction extends AbstractCleanPatternElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CleanPatternAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.AbstractCleanPatternElementAction#doCleanPatternElement()
   */
  @Override
  protected void doCleanPatternElement() {
    // Get library.
    final PatternModel pattern = (PatternModel) getModelElement();
    // Execute clean asynchronously.
    ProgressReporter.asyncExec(new IProgressRunnable() {
      public String getReportingTitle() {
        return Messages.CleanPatternAction_Title + ICommonConstants.WHITE_SPACE_CHARACTER + pattern.getName();
      }

      /**
       * @see org.eclipse.egf.common.progress.IProgressRunnable#run(org.eclipse.core.runtime.IProgressMonitor)
       */
      public boolean run(IProgressMonitor progressMonitor_p) {
        // Convert given progress monitor.
        SubMonitor monitor = SubMonitor.convert(progressMonitor_p, 1);
        try {
          // Set the remaining work.
          monitor.setWorkRemaining(1);
          clean(pattern, monitor);
        } finally {
          // Ensure progress bar displays feedback till 100%.
          monitor.setWorkRemaining(0);
        }
        return true;
      }
    });

  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.AbstractCleanPatternElementAction#getConfirmationMessage()
   */
  @Override
  protected String getConfirmationMessage() {
    return Messages.CleanPatternActionConfirmDialog_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return PatternModel.class;
  }
}
