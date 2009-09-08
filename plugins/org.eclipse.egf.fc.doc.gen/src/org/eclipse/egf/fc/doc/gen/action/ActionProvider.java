/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.fc.doc.gen.action;

import java.util.List;

import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Guillaume Brocard
 */
public class ActionProvider extends AbstractActionProvider {
  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider#initActions(org.eclipse.swt.widgets.Shell, org.eclipse.ui.IWorkbenchPage,
   *      org.eclipse.jface.viewers.ISelectionProvider)
   */
  @Override
  protected void initActions(Shell shell_p, IWorkbenchPage page_p, ISelectionProvider selectionProvider_p) {
    initAdditionActions(shell_p, selectionProvider_p);
  }

  /**
   * Initialize 'additions' actions.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initAdditionActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // Addition group marker actions
    List<IAction> additionActions = getAdditionActions();
    // Add the Generate documentation action.
    additionActions.add(new GenerateFcDocAction(shell_p, selectionProvider_p, false));
  }
}