/**
 *  Copyright (c) 2007, 2009 La Carotte Et Le Baton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      La Carotte Et Le Baton - initial API and implementation
 */
package org.eclipse.egf.core.ui.workbench.action.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;


/**
 * Base class to implement action provider for MDSoFa views based on the common navigator framework.
 * @author Guillaume Brocard
 */
public abstract class AbstractActionProvider extends CommonActionProvider {
  
  /**
   * Group that hosts the delete actions.
   */
  private static final String GROUP_DELETE = "group.delete"; //$NON-NLS-1$
  
  /**
   * Id of the sub menu manager for 'new' sub menu.
   */
  private static final String GROUP_NEW_SUB_MENU_ID = "group.new.subMenu"; //$NON-NLS-1$
  
  /**
   * List of action located in the group marker 'group.new'
   */
  private List<IAction> _newActions;

  /**
   * List of action located in the group marker 'group.open'
   */
  private List<IAction> _openActions;

  /**
   * List of action located in the group marker 'group.edit'
   */
  private List<IAction> _editActions;
  
  /**
   * List of action located in the group marker 'group.delete'
   */
  private List<IAction> _deleteActions;
  
  /**
   * List of action located in the group marker 'additions'
   */
  private List<IAction> _additionActions;

  /**
   * Constructor.
   */
  public AbstractActionProvider() {
    _newActions = new ArrayList<IAction>(0);
    _openActions = new ArrayList<IAction>(0);
    _editActions = new ArrayList<IAction>(0);
    _deleteActions = new ArrayList<IAction>(0);
    _additionActions = new ArrayList<IAction>(0);
  }

  /**
   * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
   */
  @Override
  public void init(ICommonActionExtensionSite site_p) {
    super.init(site_p);
    ICommonViewerSite commonViewerSite = site_p.getViewSite();
    if (commonViewerSite instanceof ICommonViewerWorkbenchSite) {
      ICommonViewerWorkbenchSite workbenchSite = (ICommonViewerWorkbenchSite) commonViewerSite;
      IWorkbenchPage page = workbenchSite.getPage();
      ISelectionProvider selectionProvider = workbenchSite.getSelectionProvider();
      Shell shell = workbenchSite.getShell();
      initActions(shell, page, selectionProvider);
    }
  }

  /**
   * Initialization actions
   * @param shell_p
   * @param page_p
   * @param selectionProvider_p
   */
  protected abstract void initActions(Shell shell_p, IWorkbenchPage page_p, ISelectionProvider selectionProvider_p);

  /**
   * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars(IActionBars actionBars_p) {
    fillActionsBars(actionBars_p, _newActions);
    fillActionsBars(actionBars_p, _openActions);
    fillActionsBars(actionBars_p, _editActions);
    fillActionsBars(actionBars_p, _deleteActions);
    fillActionsBars(actionBars_p, _additionActions);
  }

  /**
   * Fill action bars.
   * @param actionBars_p
   * @param actions_p
   */
  protected void fillActionsBars(IActionBars actionBars_p, List<IAction> actions_p) {
    for (IAction action : actions_p) {
      // Default value for selection compatible boolean is true
      boolean isSelectionCompatible = true;
      if (action instanceof AbstractNavigatorAction) {
        // In this case, check really if the action is compatible with current selection.
        isSelectionCompatible = ((AbstractNavigatorAction) action).isSelectionCompatible();
      }
      // Enable global action handler if the action fulfills both conditions.
      if (isSelectionCompatible && action.isEnabled()) {
        actionBars_p.setGlobalActionHandler(action.getId(), action);
      }
    }
  }

  /**
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu(IMenuManager menu_p) {
    // Fill actions located in GROUP_NEW
    IMenuManager subMenu = createNewSubMenuManager();
    menu_p.insertAfter(ICommonMenuConstants.GROUP_NEW, subMenu);
    // Fill actions located in GROUP_EDIT
    fillContextMenu(menu_p, _editActions, ICommonMenuConstants.GROUP_EDIT);
    // Fill actions located in GROUP_OPEN
    fillContextMenu(menu_p, _openActions, ICommonMenuConstants.GROUP_OPEN);
    // Fill actions located in GROUP_DELETE
    fillContextMenu(menu_p, _deleteActions, GROUP_DELETE);
    // Fill actions located in ADDITIONS
    fillContextMenu(menu_p, _additionActions, ICommonMenuConstants.GROUP_ADDITIONS);
  }

  /**
   * Create new sub Menu manager.
   * @return
   */
  protected IMenuManager createNewSubMenuManager() {
    IMenuManager subMenuManager = new MenuManager(Messages.ExplorerActionProvider_NewMenuItem_Title, GROUP_NEW_SUB_MENU_ID);
    fillContextMenu(subMenuManager, _newActions, null);
    return subMenuManager;
  }

  /**
   * Fill context menu group
   * @param menu_p
   * @param actions_p
   * @param groupId_p
   */
  protected void fillContextMenu(IMenuManager menu_p, List<IAction> actions_p, String groupId_p) {
    for (IAction action : actions_p) {
      // Default value for selection compatible boolean is true
      boolean isSelectionCompatible = true;
      if (action instanceof AbstractNavigatorAction) {
        // In this case, check really if the action is compatible with current selection.
        isSelectionCompatible = ((AbstractNavigatorAction) action).isSelectionCompatible();
      }
      // Append it to group if this action is compatible with current selection.
      if (isSelectionCompatible) {
        // Override the action contribution item to force the context menu to be refreshed even if the selected object has not changed.
        ActionContributionItem item = new ActionContributionItem(action) {
          @Override
          public boolean isDirty() {
            return true;
          }
          @Override
          public boolean isDynamic() {
            return true;
          }
        };
        // Append the action to a group if provided...
        if (groupId_p != null) {
          menu_p.appendToGroup(groupId_p, item);
        } else {
          menu_p.add(item);
        }
      }
    }
  }

  /**
   * Return the 'New' action list.
   * @return a not null list.
   */
  protected List<IAction> getNewActions() {
    return _newActions;
  }

  /**
   * Return the 'Open' action list.
   * @return a not null list.
   */
  protected List<IAction> getOpenActions() {
    return _openActions;
  }

  /**
   * Return the 'Edit' action list.
   * @return a not null list.
   */
  protected List<IAction> getEditActions() {
    return _editActions;
  }

  /**
   * Return the 'Delete' action list.
   * @return a not null list.
   */
  protected List<IAction> getDeleteActions() {
    return _deleteActions;
  }

  /**
   * Return the 'additions' action list.
   * @return a not null list.
   */
  protected List<IAction> getAdditionActions() {
    return _additionActions;
  }
  
}
