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

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Base class to implement a clean action for an {@link AbstractPatternElement}.
 * @author Guillaume Brocard
 */
public abstract class AbstractCleanPatternElementAction extends AbstractModelElementAction {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractCleanPatternElementAction.class.getPackage().getName());

  /**
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public AbstractCleanPatternElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setId("org.eclipse.egf.core.ui.workbench.action.explorer.clean"); //$NON-NLS-1$
    setText(Messages.CleanPatternAction_Title);
    setToolTipText(Messages.CleanPatternAction_Tooltip);
  }

  /**
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    // If a user confirmation is requested, pop-up a dialog.
    boolean cleanConfirmed = MessageDialog.openQuestion(getShell(), Messages.CleanPatternActionConfirmDialog_Title, getConfirmationMessage());
    // Clean selected pattern if confirmation is ok or not requested.
    if (cleanConfirmed) {
      doCleanPatternElement();
    }
  }

  protected abstract String getConfirmationMessage();

  /**
   * Do the clean operation.
   */
  protected abstract void doCleanPatternElement();

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId selectedModelElement_p) {
    // Do nothing.
    return null;
  }

  /**
   * Clean generated structures for given pattern.
   * @param pattern_p
   * @param monitor_p if null the clean operation is run asynchronously.
   */
  protected void clean(final PatternModel pattern_p, IProgressMonitor monitor_p) {
    // Precondition.
    if (null == pattern_p) {
      return;
    }
    PatternHandler patternHandler = getPatternHandler(pattern_p);
    patternHandler.cleanGeneratedStructures();
    // Acknowledge one work unit is consumed.
    monitor_p.worked(1);
  }

  /**
   * Return the pattern handler for given pattern.
   * @return the patternHandler
   */
  protected PatternHandler getPatternHandler(PatternModel pattern_p) {
    PatternHandler patternHandler = new PatternHandler();
    try {
      patternHandler.load(pattern_p.getPath());
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("AbstractCleanPatternElementAction.getPatternHandler(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return patternHandler;
  }
}
