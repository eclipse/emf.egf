/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.ui.dialogs.FcoreSelectionDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
public class OpenFcoreAction extends Action implements IWorkbenchWindowActionDelegate {

  private Shell _shell;

  /**
   * Creates a new action for opening an EGF Fcore
   */
  public OpenFcoreAction() {
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
    FcoreSelectionDialog dialog = new FcoreSelectionDialog(_shell, true);
    int result = dialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }
    Object[] objects = dialog.getResult();
    if (objects == null) {
      return;
    }
    // Process selected Fcores
    EditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
    Map<Resource, List<EObject>> resources = new HashMap<Resource, List<EObject>>();
    for (Object object : objects) {
      if (object instanceof IPlatformFcore == false) {
        continue;
      }
      IPlatformFcore fcore = (IPlatformFcore) object;
      Resource resource = editingDomain.getResourceSet().getResource(fcore.getURI(), true);
      if (resource == null) {
        continue;
      }
      List<EObject> eObjects = resources.get(resource);
      if (eObjects == null) {
        eObjects = new ArrayList<EObject>();
        resources.put(resource, eObjects);
      }
      if (resource.getContents().isEmpty() == false) {
        eObjects.add(resource.getContents().get(0));
      }
    }
    // Open and select
    EditorHelper.openEditorsAndSelect(resources);
  }
}
