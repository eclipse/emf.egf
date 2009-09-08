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
package org.eclipse.egf.core.ui.workbench;

import org.eclipse.egf.common.ui.activator.AbstractUIActivator;
import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSetManager;
import org.eclipse.egf.core.ui.workbench.views.explorer.FactoryComponentProjectExplorer;
import org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart;
import org.eclipse.jdt.internal.ui.workingsets.WorkingSetMessages;
import org.eclipse.jdt.internal.ui.workingsets.WorkingSetModel;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 */
public class EgfWorkbenchActivator extends AbstractUIActivator {
  /**
   * Property used by actions when, checked state changes.
   */
  private static final String PROPERTY_CHECKED = "checked"; //$NON-NLS-1$
  /**
   * The shared instance.
   */
  private static EgfWorkbenchActivator __plugin;
  /**
   * Maintain registration state regarding the Package Explorer WorkingSetModel.
   */
  private volatile boolean _isAlreadyResgisteredAsPackageExplorerWorkingSetModelListener;
  /**
   * Maintain registration state regarding the Package Explorer menu manager.
   */
  private volatile boolean _isAlreadyResgisteredAsMenuManagerListener;

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
    // Force to load EGF Core UI plug-in
    EgfUiActivator.getDefault();
  }

  /**
   * Register a part listener to monitor Package Explorer life cycle.
   */
  public void registerPackageExplorerPartListener() {
    // Register a part listener to monitor PackageExplorer view events.
    IWorkbenchPage activeWorkbenchPage = WorkbenchHelper.getActiveWorkbenchPage();
    activeWorkbenchPage.addPartListener(new IPartListener2() {
      /**
       * @see org.eclipse.ui.IPartListener2#partClosed(org.eclipse.ui.IWorkbenchPartReference)
       */
      @SuppressWarnings("synthetic-access")
      public void partClosed(IWorkbenchPartReference partRef_p) {
        if (JavaUI.ID_PACKAGES.equals(partRef_p.getId())) {
          // Unregister the FactoryComponentWorkingSetManager as listener of the Package Explorer working set model.
          unregisterPackageExplorerListeners((PackageExplorerPart) partRef_p.getPart(false));
        }
      }

      /**
       * @see org.eclipse.ui.IPartListener2#partActivated(org.eclipse.ui.IWorkbenchPartReference)
       */
      public void partActivated(IWorkbenchPartReference partRef_p) {
        if (JavaUI.ID_PACKAGES.equals(partRef_p.getId())) {
          // Register the FactoryComponentWorkingSetManager as listener of the Package Explorer working set model.
          registerPackageExplorerListeners((PackageExplorerPart) partRef_p.getPart(false));
        }
      }

      /**
       * @see org.eclipse.ui.IPartListener2#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)
       */
      public void partInputChanged(IWorkbenchPartReference partRef_p) {
        // Do nothing.
      }

      /**
       * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
       */
      public void partBroughtToTop(IWorkbenchPartReference partRef_p) {
        // Do nothing.
      }

      /**
       * @see org.eclipse.ui.IPartListener2#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)
       */
      public void partDeactivated(IWorkbenchPartReference partRef_p) {
        // Do nothing.
      }

      /**
       * @see org.eclipse.ui.IPartListener2#partOpened(org.eclipse.ui.IWorkbenchPartReference)
       */
      public void partOpened(IWorkbenchPartReference partRef_p) {
        // Do nothing.
      }

      /**
       * @see org.eclipse.ui.IPartListener2#partHidden(org.eclipse.ui.IWorkbenchPartReference)
       */
      public void partHidden(IWorkbenchPartReference partRef_p) {
        // Do nothing.
      }

      /**
       * @see org.eclipse.ui.IPartListener2#partVisible(org.eclipse.ui.IWorkbenchPartReference)
       */
      public void partVisible(IWorkbenchPartReference partRef_p) {
        // Do nothing.
      }
    });
  }

  /**
   * Register listener on Package Explorer.
   */
  public void registerPackageExplorerListeners(PackageExplorerPart packageExplorerView_p) {
    PackageExplorerPart packageExplorerView = (null == packageExplorerView_p) ? WorkbenchHelper.getPackageExplorerView() : packageExplorerView_p;
    // Precondition.
    if (null == packageExplorerView) {
      return;
    }
    // Register a listener on "Top Level Elements" Package Explorer menu.
    registerPackageExplorerMenuManagerListener(packageExplorerView);
    // Register a listener on Package Explorer WorkingSetModel
    registerPackageExplorerWorkingSetModelListener(packageExplorerView.getWorkingSetModel());
  }

  /**
   * Register a listener on Package Explorer WorkingSetModel to be notified when the end-user modifies the working sets.
   * @param workingSetModel_p
   */
  private void registerPackageExplorerWorkingSetModelListener(WorkingSetModel workingSetModel_p) {
    // Precondition
    if (_isAlreadyResgisteredAsPackageExplorerWorkingSetModelListener) {
      return;
    }
    WorkingSetModel workingSetModel = workingSetModel_p;
    // Get it from the view because it is not provided by the caller.
    if (null == workingSetModel) {
      workingSetModel = WorkbenchHelper.getPackageExplorerView().getWorkingSetModel();
    }
    // Register listener on working set model if not already done.
    if (null != workingSetModel) {
      _isAlreadyResgisteredAsPackageExplorerWorkingSetModelListener = true;
      FactoryComponentWorkingSetManager workingSetsManager = (FactoryComponentWorkingSetManager) EgfUiActivator.getDefault().getWorkingSetsInput();
      workingSetModel_p.addPropertyChangeListener(workingSetsManager);
      // Force an event to refresh the FactoryComponentWorkingSetManager.
      workingSetsManager.propertyChange(new PropertyChangeEvent(this, WorkingSetModel.CHANGE_WORKING_SET_MODEL_CONTENT, null, null));
    }
  }

  /**
   * Register a listener on Package Explorer menu manager to be notified when the end-user switches between project mode or working set mode.
   * @param packageExplorerView_p
   */
  private void registerPackageExplorerMenuManagerListener(final PackageExplorerPart packageExplorerView_p) {
    // Preconditions.
    if (null == packageExplorerView_p || _isAlreadyResgisteredAsMenuManagerListener) {
      return;
    }
    IMenuManager menuManager = packageExplorerView_p.getViewSite().getActionBars().getMenuManager();
    IContributionItem[] items = menuManager.getItems();
    for (IContributionItem contributionItem : items) {
      if (contributionItem instanceof MenuManager) {
        MenuManager currentMenuManager = (MenuManager) contributionItem;
        // MenuManager does not have an id, what a pity !
        if (WorkingSetMessages.ViewActionGroup_show_label.equals(currentMenuManager.getMenuText())) {
          // The menu where both actions to switch between working sets & projects is found.
          IContributionItem[] actions = currentMenuManager.getItems();
          for (int i = 0; i < actions.length; i++) {
            if (actions[i] instanceof ActionContributionItem) {
              IAction uiAction = ((ActionContributionItem) actions[i]).getAction();
              String uiActionLabel = uiAction.getText();
              // Action does not have an id, what a pity !
              if ((WorkingSetMessages.ViewActionGroup_projects_label.equals(uiActionLabel))
                  || (WorkingSetMessages.ViewActionGroup_workingSets_label.equals(uiAction.getText()))) {
                uiAction.addPropertyChangeListener(new IPropertyChangeListener() {
                  /**
                   * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
                   */
                  @SuppressWarnings("synthetic-access")
                  public void propertyChange(PropertyChangeEvent event_p) {
                    String property = event_p.getProperty();
                    Object newValue = event_p.getNewValue();
                    if (PROPERTY_CHECKED.equals(property)) {
                      // Handle the action that is now checked.
                      if (((Boolean) newValue).booleanValue()) {
                        // Get the FactoryComponent Explorer if open, and ask it to update its input.
                        IViewPart fcExplorerView = WorkbenchHelper.getActiveWorkbenchPage().findView(FactoryComponentProjectExplorer.VIEW_ID);
                        if (null != fcExplorerView) {
                          IAction currentAction = (IAction) event_p.getSource();
                          String currentActionLabel = currentAction.getText();
                          // The property dialog that tells the new mode is not already set, hence use the action name to compute the flag mode : projects or
                          // working sets.
                          boolean isProjectSelected = (WorkingSetMessages.ViewActionGroup_projects_label.equals(currentActionLabel)) ? true : false;
                          // Update the factory component explorer.
                          ((FactoryComponentProjectExplorer) fcExplorerView).updateInput(isProjectSelected);
                          if (!isProjectSelected) {
                            // Run this code in the UI Thread, to let a chance to the Package Explorer to be updated with working sets before accessing its
                            // working set model.
                            fcExplorerView.getSite().getShell().getDisplay().asyncExec(new Runnable() {
                              /**
                               * @see java.lang.Runnable#run()
                               */
                              public void run() {
                                registerPackageExplorerWorkingSetModelListener(packageExplorerView_p.getWorkingSetModel());
                              }
                            });
                          }
                        }
                      }
                    }
                  }
                });
                // Set the flag to avoid multiple registration.
                _isAlreadyResgisteredAsMenuManagerListener = true;
              }
            }
          }
          break;
        }
      }
    }
  }

  /**
   * Unregister some listeners from the Package Explorers.<br>
   * @param packageExplorerView_p
   */
  private void unregisterPackageExplorerListeners(PackageExplorerPart packageExplorerView_p) {
    WorkingSetModel workingSetModel = packageExplorerView_p.getWorkingSetModel();
    if (null != workingSetModel) {
      workingSetModel.removePropertyChangeListener((IPropertyChangeListener) EgfUiActivator.getDefault().getWorkingSetsInput());
    }
    // Set the flags to false.
    _isAlreadyResgisteredAsPackageExplorerWorkingSetModelListener = false;
    _isAlreadyResgisteredAsMenuManagerListener = false;
  }

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    __plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   * @return the shared instance
   */
  public static EgfWorkbenchActivator getDefault() {
    return __plugin;
  }
}
