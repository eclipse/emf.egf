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

package org.eclipse.egf.pattern.ui.editors.wizards;

import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.dialogs.JavaTypeSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ChooseTypePage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
@SuppressWarnings("restriction")
public class OpenTypeWizard extends Wizard implements INewWizard {

    private ChooseTypePage chooseTypePage;

    private ISelection selection;

    private Object selectType;

    private TransactionalEditingDomain editingDomain;

    private String type;

    public OpenTypeWizard(TransactionalEditingDomain editingDomain, String type) {
        this.editingDomain = editingDomain;
        this.type = type;
    }

    @Override
    public boolean performFinish() {
        JavaTypeSelectionDialog page = chooseTypePage.getJavaTypePage();
        if (chooseTypePage.isInCoreTab()) {
            if (chooseTypePage.getType() != null) {
                selectType = chooseTypePage.getType();
            }
        } else {
            Object[] result = page.getResult();
            if (result == null) {
                page.computeResult();
            }
            result = page.getResult();
            if (result[0] instanceof BinaryType) {
                selectType = (BinaryType) result[0];
                System.out.println(selectType);
            }
        }
        return true;
    }

    /**
     * We will accept the selection in the workbench to see if
     * we can initialize from it.
     * 
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }

    /**
     * Adding the page to the wizard.
     */
    public void addPages() {
        // set the window's title label
        setWindowTitle(Messages.OpenTypeWizard_window_title);
        chooseTypePage = new ChooseTypePage(selection, editingDomain, type);
        addPage(chooseTypePage);
    }

    public Object getSelectType() {
        return selectType;
    }

}
