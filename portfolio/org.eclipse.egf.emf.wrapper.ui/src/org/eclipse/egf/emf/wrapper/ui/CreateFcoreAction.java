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
package org.eclipse.egf.emf.wrapper.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

public class CreateFcoreAction implements IActionDelegate {

  private ISelection _selection;

  public void run(IAction action) {
    if (action.isEnabled()) {
      if (_selection instanceof IStructuredSelection) {
        IStructuredSelection structuredSelection = (IStructuredSelection) _selection;
        if (structuredSelection.size() == 1) {
          if (structuredSelection.getFirstElement() instanceof IFile) {
            IFile input = (IFile) structuredSelection.getFirstElement();
            CreateFcoreFileWizard wizard = new CreateFcoreFileWizard(input);
            wizard.init(getWorkbench(), structuredSelection);
            final WizardDialog dialog = new WizardDialog(getShell(), wizard);
            dialog.create();
            dialog.open();
          }
        }
      }
    }
  }

  public void selectionChanged(IAction action, ISelection selection) {
    _selection = selection;
  }

  private Shell getShell() {
    return getActiveWorkbenchWindow().getShell();
  }

  private IWorkbenchWindow getActiveWorkbenchWindow() {
    return getWorkbench().getActiveWorkbenchWindow();
  }

  private IWorkbench getWorkbench() {
    return Activator.getDefault().getWorkbench();
  }
}
