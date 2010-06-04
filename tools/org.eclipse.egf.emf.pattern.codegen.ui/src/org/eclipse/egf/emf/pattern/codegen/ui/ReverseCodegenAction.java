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
package org.eclipse.egf.emf.pattern.codegen.ui;

import org.eclipse.egf.emf.pattern.codegen.ui.Activator;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

public class ReverseCodegenAction implements IActionDelegate {

    private ISelection _selection;

    public void run(IAction action) {
        if (action.isEnabled()) {
            if (_selection instanceof IStructuredSelection) {
                IStructuredSelection structuredSelection = (IStructuredSelection) _selection;
                ReverseCodegenWizard wizard = new ReverseCodegenWizard();
                wizard.init(getWorkbench(), structuredSelection);
                final WizardDialog dialog = new WizardDialog(getShell(), wizard);
                dialog.create();
                dialog.open();
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
