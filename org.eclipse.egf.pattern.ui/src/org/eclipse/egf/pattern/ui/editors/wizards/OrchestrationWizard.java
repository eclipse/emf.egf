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

import java.util.List;

import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.CallTypeEnum;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ChooseCallPage;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ChooseKindPage;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ChooseMethodCallPage;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.ParameterMatchingPage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class OrchestrationWizard extends Wizard implements INewWizard {

    private ChooseKindPage chooseKindPage;

    private ChooseCallPage chooseCallPage;

    private ChooseMethodCallPage chooseMethodCallPage;

    private ParameterMatchingPage parameterMatchingPage;

    private ISelection selection;

    private Pattern pattern;

    private Call selectCall;

    private List<MethodCall> chooseMethodCallList;

    private CallTypeEnum defaultKind;

    private Object eidtItem;

    private TransactionalEditingDomain transactionalEditingDomain;

    /**
     * Constructor for MyWizard.
     */
    public OrchestrationWizard(Pattern pattern, CallTypeEnum defaultKind, Object eidtItem, TransactionalEditingDomain transactionalEditingDomain) {
        super();
        setNeedsProgressMonitor(true);
        this.pattern = pattern;
        this.defaultKind = defaultKind;
        this.eidtItem = eidtItem;
        this.transactionalEditingDomain = transactionalEditingDomain;
    }

    @Override
    public boolean canFinish() {

        if (chooseKindPage != null && chooseKindPage.getKind() == CallTypeEnum.BACK_CALL || chooseKindPage.getKind() == CallTypeEnum.SUPERPATTERN_CALL)
            return true;
        if (chooseKindPage != null && chooseKindPage.getKind() == CallTypeEnum.METHOD_CALL && defaultKind == CallTypeEnum.Add) {
            return chooseMethodCallPage.canFinish();
        } else {
            return chooseCallPage.canFinish();
        }
    }

    /**
     * Adding the page to the wizard.
     */
    public void addPages() {
        // Set the window's title label
        setWindowTitle(Messages.OrchestrationWizard_title);
        // Add chooseKindPage.
        if (defaultKind.equals(CallTypeEnum.Add)) {
            chooseKindPage = new ChooseKindPage(selection);
            addPage(chooseKindPage);
        }
        // Add chooseCallPage.
        chooseCallPage = new ChooseCallPage(pattern, selection, eidtItem);
        addPage(chooseCallPage);
        // Add chooseMethodCallPage.
        chooseMethodCallPage = new ChooseMethodCallPage(pattern, selection, eidtItem);
        addPage(chooseMethodCallPage);
        // Add parameterMatchingPage.
        if (defaultKind.equals(CallTypeEnum.PATTERN_CALL) || defaultKind.equals(CallTypeEnum.Add)) {
            parameterMatchingPage = new ParameterMatchingPage(selection, pattern, transactionalEditingDomain);
            Pattern patternCallee = null;
            if (eidtItem instanceof PatternCall) {
                patternCallee = ((PatternCall) eidtItem).getCalled();
            }
            parameterMatchingPage.setPatternCallee((patternCallee));
            addPage(parameterMatchingPage);
        }
    }

    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        IWizardPage nextPage;
        if (page instanceof ChooseKindPage) {
            CallTypeEnum kind = ((ChooseKindPage) page).getKind();
            if (kind == CallTypeEnum.METHOD_CALL && defaultKind.equals(CallTypeEnum.Add)) {
                nextPage = chooseMethodCallPage;
            } else if (chooseKindPage.getKind() == CallTypeEnum.BACK_CALL || chooseKindPage.getKind() == CallTypeEnum.SUPERPATTERN_CALL){
            	return null;
            }
            else {
                nextPage = chooseCallPage;
            }
        } else {
            nextPage = parameterMatchingPage;
        }
        return nextPage;
    }

    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     */
    public boolean performFinish() {
        selectCall = chooseCallPage.getChooseCall();
        return true;
    }

    /**
     * The <code>Wizard</code> implementation of this <code>IWizard</code>
     * method does nothing and returns <code>true</code>. Subclasses should
     * reimplement this method if they need to perform any special cancel
     * processing for their wizard.
     */
    public boolean performCancel() {
        if (parameterMatchingPage != null && eidtItem != null) {
            List<RecordingCommand> parameterMatchingCommands = parameterMatchingPage.getParameterMatchingCommands();
            if (parameterMatchingCommands != null) {
                for (final RecordingCommand parameterMatchingCommand : parameterMatchingCommands) {
                    if (transactionalEditingDomain.getCommandStack().canUndo())
                        transactionalEditingDomain.getCommandStack().undo();
                }
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
     * Return the selection content.
     */
    public Call getSelectCall() {
        return selectCall;
    }

    public List<MethodCall> getSelectMethodCallList() {
        return chooseMethodCallList;
    }

    public CallTypeEnum getDefaultKind() {
        return defaultKind;
    }
}
