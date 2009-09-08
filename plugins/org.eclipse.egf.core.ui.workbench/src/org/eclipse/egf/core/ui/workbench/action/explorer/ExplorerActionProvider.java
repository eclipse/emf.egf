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

import java.util.List;

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.workbench.action.edit.EditContextElementAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditContractElementAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditDomainAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditFactoryComponentAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditFactoryComponentInvocationAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditMappingAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditPatternLibraryAction;
import org.eclipse.egf.core.ui.workbench.action.edit.EditTaskFactoryHolderAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateContextAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateContextElementAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateContractElementAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateDomainAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateFactoryComponentInvocationAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateMappingAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreatePatternAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreatePatternLibraryAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateRootPatternLibraryAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateTaskFactoryHolderAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteContextAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteContextElementAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteContractElementAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteDomainAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteFactoryComponentInvocationAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteMappingAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeletePatternAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeletePatternLibraryAction;
import org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteTaskFactoryHolderAction;
import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider;
import org.eclipse.egf.core.ui.workbench.action.navigator.ValidateElementAction;
import org.eclipse.egf.core.ui.workbench.action.open.OpenDomainAction;
import org.eclipse.egf.core.ui.workbench.action.open.OpenMappingAction;
import org.eclipse.egf.core.ui.workbench.action.open.OpenPatternAction;
import org.eclipse.egf.core.ui.workbench.views.fc.AbstractFactoryComponentView;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;


/**
 * Provides action for context menu for FactoryComponent Project Explorer view.
 * @see AbstractFactoryComponentView
 * @author fournier
 */
public class ExplorerActionProvider extends AbstractActionProvider {
  /**
   * Group that hosts the undo & redo actions.
   */
  private static final String GROUP_UNDO_REDO = "group.undoredo"; //$NON-NLS-1$
  /**
   * Undo global action handler.
   */
  private UndoAction _undoAction;
  /**
   * Redo global action handler.
   */
  private RedoAction _redoAction;

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider#initActions(org.eclipse.swt.widgets.Shell,
   *      org.eclipse.ui.IWorkbenchPage, org.eclipse.jface.viewers.ISelectionProvider)
   */
  @Override
  protected void initActions(Shell shell_p, IWorkbenchPage page_p, ISelectionProvider selectionProvider_p) {
    // Actions provided by this class are used to create or edit model element objects.
    // Hence, wizards opened by these actions are not in read only.
    initUndoRedoActions();
    initCreationActions(shell_p, selectionProvider_p);
    initEditActions(shell_p, selectionProvider_p);
    initOpenActions(shell_p, selectionProvider_p);
    initDeleteActions(shell_p, selectionProvider_p);
    initAdditionActions(shell_p, selectionProvider_p);
  }

  private void initUndoRedoActions() {
    // Undo action.
    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
    AdapterFactoryEditingDomain editingDomain = EgfUiActivator.getDefault().getEditingDomain();
    _undoAction = new UndoAction(editingDomain);
    _undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
    _undoAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO_DISABLED));
    // Redo action.
    _redoAction = new RedoAction(editingDomain);
    _redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
    _redoAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO_DISABLED));
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
    openActions.add(new OpenDomainAction(shell_p, selectionProvider_p, false));
    // Action to open a pattern editor.
    openActions.add(new OpenPatternAction(shell_p, selectionProvider_p, false));
    // Action to open a mapping editor.
    openActions.add(new OpenMappingAction(shell_p, selectionProvider_p, false));
    // Action to produce a pattern element.
    openActions.add(new ProducePatternElementAction(shell_p, selectionProvider_p, false));
  }

  /**
   * Initialize the actions related to execute an 'delete' operation.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initDeleteActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // Delete group marker actions
    List<IAction> deleteActions = getDeleteActions();
    // Delete actions related to a domain.
    deleteActions.add(new DeleteDomainAction(shell_p, selectionProvider_p, false));
    // Delete actions related to a factory component invocation.
    deleteActions.add(new DeleteFactoryComponentInvocationAction(shell_p, selectionProvider_p, false));
    // Delete actions related to a task factory.
    deleteActions.add(new DeleteTaskFactoryHolderAction(shell_p, selectionProvider_p, false));
    // Delete actions related to a contract element.
    deleteActions.add(new DeleteContractElementAction(shell_p, selectionProvider_p, false));
    // Delete actions related to a context.
    deleteActions.add(new DeleteContextAction(shell_p, selectionProvider_p, false));
    deleteActions.add(new DeleteContextElementAction(shell_p, selectionProvider_p, false));
    // Delete actions related to a pattern library.
    deleteActions.add(new DeletePatternLibraryAction(shell_p, selectionProvider_p, false));
    deleteActions.add(new DeletePatternAction(shell_p, selectionProvider_p, false));
    // Delete actions related to a mapping model.
    deleteActions.add(new DeleteMappingAction(shell_p, selectionProvider_p, false));
  }

  /**
   * Initialize the actions related to execute an 'edit' operation.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initEditActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // Edit group marker actions
    List<IAction> editActions = getEditActions();
    // Edit actions related to a factory component.
    editActions.add(new EditFactoryComponentAction(shell_p, selectionProvider_p, false));
    // Edit actions related to a domain.
    editActions.add(new EditDomainAction(shell_p, selectionProvider_p, false));
    // Edit actions related to a factory component invocation.
    editActions.add(new EditFactoryComponentInvocationAction(shell_p, selectionProvider_p, false));
    editActions.add(new EditTaskFactoryHolderAction(shell_p, selectionProvider_p, false));
    // Edit actions related to a contract element.
    editActions.add(new EditContractElementAction(shell_p, selectionProvider_p, false));
    // Edit actions related to a context.
    editActions.add(new EditContextElementAction(shell_p, selectionProvider_p, false));
    // Edit actions related to a pattern library.
    editActions.add(new EditPatternLibraryAction(shell_p, selectionProvider_p, false));
    // Edit actions related to a mapping model.
    editActions.add(new EditMappingAction(shell_p, selectionProvider_p, false));
  }

  /**
   * Initialize the actions related to execute a 'creation' operation.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initAdditionActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // Addition group marker actions
    List<IAction> additionActions = getAdditionActions();
    // Clean actions related to a pattern library.
    additionActions.add(new CleanPatternLibraryAction(shell_p, selectionProvider_p, false));
    additionActions.add(new CleanPatternAction(shell_p, selectionProvider_p, false));
    // Validate action.
    additionActions.add(new ValidateElementAction(shell_p, selectionProvider_p, false));
  }

  /**
   * Initialize the actions related to execute a 'creation' operation.
   * @param shell_p
   * @param selectionProvider_p
   */
  private void initCreationActions(Shell shell_p, ISelectionProvider selectionProvider_p) {
    // New group marker actions
    List<IAction> newActions = getNewActions();
    // Creation actions related to a domain.
    newActions.add(new CreateDomainAction(shell_p, selectionProvider_p, false));
    // Creation actions related to an factory component invocation.
    newActions.add(new CreateFactoryComponentInvocationAction(shell_p, selectionProvider_p, false));
    newActions.add(new CreateTaskFactoryHolderAction(shell_p, selectionProvider_p, false));
    // Creation actions related to a contract element.
    newActions.add(new CreateContractElementAction(shell_p, selectionProvider_p, false));
    // Creation actions related to a context.
    newActions.add(new CreateContextAction(shell_p, selectionProvider_p, false));
    newActions.add(new CreateContextElementAction(shell_p, selectionProvider_p, false));
    // Creation actions related to a pattern library.
    newActions.add(new CreateRootPatternLibraryAction(shell_p, selectionProvider_p, false));
    newActions.add(new CreatePatternLibraryAction(shell_p, selectionProvider_p, false));
    // Creation actions related to a pattern.
    newActions.add(new CreatePatternAction(shell_p, selectionProvider_p, false));
    // Creation actions related to a mapping.
    newActions.add(new CreateMappingAction(shell_p, selectionProvider_p, false));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu(IMenuManager menu_p) {
    super.fillContextMenu(menu_p);
    // Add Undo & Redo actions.
    menu_p.appendToGroup(GROUP_UNDO_REDO, _undoAction);
    menu_p.appendToGroup(GROUP_UNDO_REDO, _redoAction);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars(IActionBars actionBars_p) {
    super.fillActionBars(actionBars_p);
    // Register undo as action handler.
    actionBars_p.setGlobalActionHandler(ActionFactory.UNDO.getId(), _undoAction);
    // Register redo as action handler.
    actionBars_p.setGlobalActionHandler(ActionFactory.REDO.getId(), _redoAction);
  }

  /**
   * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
   */
  @Override
  public void updateActionBars() {
    _undoAction.update();
    _redoAction.update();
  }
}