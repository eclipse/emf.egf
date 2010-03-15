/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.dialogs;

import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
@SuppressWarnings("restriction")
public class JavaTypeSelectionDialog extends OpenTypeSelectionDialog {

    private Shell shell;
    private IWizard wizard;

    public JavaTypeSelectionDialog(Shell shell, IWizard wizard) {
        super(shell, false, PlatformUI.getWorkbench().getProgressService(), SearchEngine.createWorkspaceScope(), IJavaSearchConstants.TYPE);
        this.shell = shell;
        this.wizard = wizard;
    }

    public Shell getShell() {
        return shell;
    }

    public Control createPage(Composite parent) {
        return dialogArea = createDialogArea(parent);
    }

    public void computeResult() {
        super.computeResult();
    }

    @Override
    protected void handleDoubleClick() {
        okPressed();
        wizard.performFinish();
        IWizardContainer wizardContainer = wizard.getContainer();
        if (wizardContainer instanceof WizardDialog) {
            ((WizardDialog) wizardContainer).close();
        }
    }

}
