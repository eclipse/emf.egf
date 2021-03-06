/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.wizards;

import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ChooseTypePage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class OpenTypeWizard extends Wizard implements INewWizard {

    private ChooseTypePage _chooseTypePage;

    private Object _selectType;

    private String _type;

    private EObject _current;

    public OpenTypeWizard(String type) {
        _type = type;
    }

    public OpenTypeWizard(String type, EObject current) {
        _type = type;
        _current = current;
    }

    @Override
    public boolean performFinish() {
        if (_chooseTypePage.isInCoreTab()) {
            if (_chooseTypePage.getSelectedEcoreType() != null) {
                _selectType = _chooseTypePage.getSelectedEcoreType();
            }
        } else {
            Object result = _chooseTypePage.getSelectedJavaType();
            if (result instanceof IType) {
                _selectType = result;
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
        // Nothing to do
    }

    /**
     * Adding the page to the wizard.
     */
    @Override
    public void addPages() {
        setWindowTitle(Messages.OpenTypeWizard_window_title);
        _chooseTypePage = new ChooseTypePage(_type, _current);
        addPage(_chooseTypePage);
    }

    public Object getSelectType() {
        return _selectType;
    }

}
