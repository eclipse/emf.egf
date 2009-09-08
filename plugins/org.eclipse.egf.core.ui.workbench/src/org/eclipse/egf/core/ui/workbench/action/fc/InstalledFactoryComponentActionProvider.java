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
package org.eclipse.egf.core.ui.workbench.action.fc;

import java.util.List;

import org.eclipse.egf.core.ui.workbench.action.edit.EditFactoryComponentAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditFactoryComponentInvocationAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditContextElementAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditContractElementAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditDomainAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditMappingAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditPatternLibraryAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditTaskFactoryHolderAction;
import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider;
import org.eclipse.egf.core.ui.workbench.action.navigator.ValidateElementAction;
import org.eclipse.egf.core.ui.workbench.action.open.OpenDomainAction;
import org.eclipse.egf.core.ui.workbench.action.open.OpenPatternAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;


/**
 * Provides action for context menu for Installed Factory Components view.
 * @author Guillaume Brocard
 */
public class InstalledFactoryComponentActionProvider extends AbstractActionProvider {

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider#initActions(org.eclipse.swt.widgets.Shell,
   *      org.eclipse.ui.IWorkbenchPage, org.eclipse.jface.viewers.ISelectionProvider)
   */
  @Override
  protected void initActions(Shell shell_p, IWorkbenchPage page_p, ISelectionProvider selectionProvider_p) {
    // Actions provided by this class are used to edit (without changes) model element objects.
    // Hence, wizards opened by these actions are not in read only.
    initOpenActions(shell_p, selectionProvider_p);
    initEditActions(shell_p, selectionProvider_p);
    initAdditionActions(shell_p, selectionProvider_p);
  }

  /**
   * Initialize the actions related to execute an 'edit' operation.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initEditActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // Edit group marker actions
    // Edit actions related to a factory component.
    List<IAction> editActions = getEditActions();
    editActions.add(new EditFactoryComponentAction(shell_p, selectionProvider_p, true));
    // Edit actions related to a domain.
    editActions.add(new EditDomainAction(shell_p, selectionProvider_p, true));
    // Edit actions related to a factory component invocation.
    editActions.add(new EditFactoryComponentInvocationAction(shell_p, selectionProvider_p, true));
    editActions.add(new EditTaskFactoryHolderAction(shell_p, selectionProvider_p, true));
    // Edit actions related to a contract element.
    editActions.add(new EditContractElementAction(shell_p, selectionProvider_p, true));
    // Edit actions related to a context.
    editActions.add(new EditContextElementAction(shell_p, selectionProvider_p, true));
    // Edit actions related to a pattern library.
    editActions.add(new EditPatternLibraryAction(shell_p, selectionProvider_p, true));
    // Edit actions related to a mapping model.
    editActions.add(new EditMappingAction(shell_p, selectionProvider_p, true));
  }

  /**
   * Initialize the actions related to execute an 'open' operation.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initOpenActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // Open group marker actions
    List<IAction> openActions = getOpenActions();
    // Action to open a domain editor.
    openActions.add(new OpenDomainAction(shell_p, selectionProvider_p, true));
    // Action to open a pattern editor.
    openActions.add(new OpenPatternAction(shell_p, selectionProvider_p, true));
  }

  /**
   * Initialize the actions related to execute a 'creation' operation.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initAdditionActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // Addition group marker actions
    List<IAction> additionActions = getAdditionActions();
    // Action to execute (ie build) an FactoryComponent from a factory component factory.
    additionActions.add(new ExecuteFactoryAction(shell_p, selectionProvider_p, true));
    // Action to execute (ie build) an FactoryComponent from a factory component itself.
    additionActions.add(new ExecuteFactoryComponentAction(shell_p, selectionProvider_p, true));
    // Validate action.
    additionActions.add(new ValidateElementAction(shell_p, selectionProvider_p, true));
  }
}
