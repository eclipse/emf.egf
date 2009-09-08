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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.progress.IProgressRunnable;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Clean the generated structures for contained patterns in selected pattern library.
 * @author Guillaume Brocard
 */
public class CleanPatternLibraryAction extends AbstractCleanPatternElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CleanPatternLibraryAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.AbstractCleanPatternElementAction#getConfirmationMessage()
   */
  @Override
  protected String getConfirmationMessage() {
    return Messages.CleanPatternLibraryActionConfirmDialog_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return PatternLibrary.class;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.AbstractCleanPatternElementAction#doCleanPatternElement()
   */
  @Override
  protected void doCleanPatternElement() {
    // Get library.
    final PatternLibrary library = (PatternLibrary) getModelElement();
    // Execute clean asynchronously.
    ProgressReporter.asyncExec(new IProgressRunnable() {
      public String getReportingTitle() {
        return Messages.CleanPatternAction_Title + ICommonConstants.WHITE_SPACE_CHARACTER + library.getName();
      }

      @SuppressWarnings("synthetic-access")
      public boolean run(IProgressMonitor progressMonitor_p) {
        // Get the pattern element count to deal with.
        int work = library.getPatternElements().size();
        // Convert given progress monitor.
        SubMonitor monitor = SubMonitor.convert(progressMonitor_p, work);
        // Set the remaining work.
        monitor.setWorkRemaining(work);
        try {
          clean(library, monitor);
        } finally {
          // Ensure progress bar displays feedback till 100%.
          monitor.setWorkRemaining(0);
        }
        return true;
      }
    });
  }

  /**
   * Clean all patterns generated structures for given library.
   * @param library_p
   * @param monitor_p a progress monitor. If null, clean is done asynchronously. If not, clean uses given monitor to report execution in calling thread.
   */
  private void clean(PatternLibrary library_p, SubMonitor monitor_p) {
    // Set the current library name as current task.
    String taskName = Messages.CleanPatternAction_Title + ICommonConstants.WHITE_SPACE_CHARACTER + library_p.getName();
    monitor_p.setTaskName(taskName);
    // Clone the list to prevent from concurrent modifications.
    List<AbstractPatternElement> patternElementList = library_p.getPatternElements();
    // Iterate over contained patterns and sub libraries to clean up.
    Iterator<AbstractPatternElement> patternElements = patternElementList.iterator();
    while (patternElements.hasNext()) {
      AbstractPatternElement currentPatternElement = patternElements.next();
      // If current pattern element is a pattern library recurse on it.
      if (currentPatternElement instanceof PatternLibrary) {
        PatternLibrary library = (PatternLibrary) currentPatternElement;
        // Create a new sub monitor for library content that represents one work unit of the parent.
        SubMonitor subMonitor = monitor_p.newChild(1);
        // Set the work remaining to deal with the library content.
        int work = library.getPatternElements().size();
        subMonitor.setWorkRemaining(work);
        // Recurse on current library.
        try {
          clean(library, subMonitor);
        } finally {
          // Ensure cleaning the current sub library reports progress successfully.
          subMonitor.setWorkRemaining(0);
          // Reset task name to parent one's name.
          monitor_p.setTaskName(taskName);
        }
      }
      // If current pattern element is a pattern, clean it.
      else if (currentPatternElement instanceof PatternModel) {
        // Set the current pattern name as sub task.
        monitor_p.subTask(Messages.CleanPatternAction_Title + ICommonConstants.WHITE_SPACE_CHARACTER + currentPatternElement.getName());
        clean((PatternModel) currentPatternElement, monitor_p);
      }
    }
  }
}
