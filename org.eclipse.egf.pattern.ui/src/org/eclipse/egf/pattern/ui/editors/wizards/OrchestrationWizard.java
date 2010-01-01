/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.pattern.ui.editors.wizards;

import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.CallTypeEnum;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ChooseCallPage;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ChooseKindPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author xrchen
 * 
 */
public class OrchestrationWizard extends Wizard implements INewWizard {

    private ChooseKindPage chooseKindPage;

    private ChooseCallPage chooseCallPage;

    private ISelection selection;

    private Pattern pattern;

    private Call selectCall;

    private CallTypeEnum defaultKind;

    private Object eidtItem;

    /**
     * Constructor for MyWizard.
     */
    public OrchestrationWizard(Pattern pattern, CallTypeEnum defaultKind, Object eidtItem) {
        super();
        setNeedsProgressMonitor(true);
        this.pattern = pattern;
        this.defaultKind = defaultKind;
        this.eidtItem = eidtItem;
    }

    /**
     * Adding the page to the wizard.
     */
    public void addPages() {
        // Set the window's title label
        setWindowTitle(Messages.OrchestrationWizard_title);
        if (defaultKind.equals(CallTypeEnum.Add)) {
            chooseKindPage = new ChooseKindPage(selection);
            addPage(chooseKindPage);
        }
        chooseCallPage = new ChooseCallPage(pattern, selection, eidtItem);
        addPage(chooseCallPage);
    }

    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     */
    public boolean performFinish() {
        selectCall = chooseCallPage.getChooseCallPage();
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
     * Return the selection content.
     */
    public Call getSelectCall() {
        return selectCall;
    }
    
    public CallTypeEnum getDefaultKind(){
        return defaultKind;
    }
}
