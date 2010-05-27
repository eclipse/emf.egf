/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.editor.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Standard action for opening an editor on EGF Fcores.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 */
public class OpenActivityAction extends Action implements IWorkbenchWindowActionDelegate {

  private Shell _shell;

  /**
   * Creates a new action for opening an EGF Fcore
   */
  public OpenActivityAction() {
    setEnabled(true);
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
   */
  public void dispose() {
    _shell = null;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
   */
  public void init(IWorkbenchWindow window) {
    _shell = window.getShell();
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
   */
  public void run(IAction action) {
    run();
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
   */
  public void selectionChanged(IAction action, ISelection selection) {
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    ActivitySelectionDialog activityDialog = new ActivitySelectionDialog(_shell, true);
    int result = activityDialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }
    final Object[] objects = activityDialog.getResult();
    if (objects == null) {
      return;
    }
    // Build a map of selected activities per resources
    Map<Resource, List<EObject>> resources = new HashMap<Resource, List<EObject>>();
    for (Object object : objects) {
      if (object instanceof Activity == false) {
        continue;
      }
      Activity activity = (Activity) object;
      if (activity.eResource() == null) {
        continue;
      }
      List<EObject> activities = resources.get(activity.eResource());
      if (activities == null) {
        activities = new ArrayList<EObject>();
        resources.put(activity.eResource(), activities);
      }
      activities.add(activity);
    }
    // Open and select
    EditorHelper.openEditorsAndSelect(resources);
  }
}
