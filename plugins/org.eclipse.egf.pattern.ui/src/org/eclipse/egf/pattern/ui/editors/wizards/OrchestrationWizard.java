/**
 * <copyright>
 * 
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
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.wizards;

import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternFactory;
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

    private ChooseKindPage _chooseKindPage;

    private ChooseCallPage _chooseCallPage;

    private ChooseMethodCallPage _chooseMethodCallPage;

    private ParameterMatchingPage _parameterMatchingPage;

    private ISelection _selection;

    private Pattern _pattern;

    private Call _selectCall;

    private List<Call> _chooseMethodCallList;

    private CallTypeEnum _defaultKind;

    private Object _editItem;

    private TransactionalEditingDomain _editingDomain;

    /**
     * Constructor for MyWizard.
     */
    public OrchestrationWizard(Pattern pattern, CallTypeEnum defaultKind, Object eidtItem, TransactionalEditingDomain editingDomain) {
        super();
        setNeedsProgressMonitor(true);
        _pattern = pattern;
        _defaultKind = defaultKind;
        _editItem = eidtItem;
        _editingDomain = editingDomain;
    }

    @Override
    public boolean canFinish() {
        if (_chooseKindPage != null && (_chooseKindPage.getKind() == CallTypeEnum.BACK_CALL || _chooseKindPage.getKind() == CallTypeEnum.SUPERPATTERN_CALL)) {
            return true;
        }
        if (_chooseKindPage != null && _chooseKindPage.getKind() == CallTypeEnum.METHOD_CALL && _defaultKind == CallTypeEnum.ADD) {
            return _chooseMethodCallPage.canFinish();
        }
        return _chooseCallPage.canFinish();
    }

    /**
     * Adding the page to the wizard.
     */
    @Override
    public void addPages() {
        // Set the window's title label
        setWindowTitle(Messages.OrchestrationWizard_title);
        // Add chooseKindPage.
        if (_defaultKind.equals(CallTypeEnum.ADD)) {
            _chooseKindPage = new ChooseKindPage(_selection);
            addPage(_chooseKindPage);
        }
        // Add chooseCallPage.
        _chooseCallPage = new ChooseCallPage(_pattern, _selection, _editItem);
        addPage(_chooseCallPage);
        // Add chooseMethodCallPage.
        _chooseMethodCallPage = new ChooseMethodCallPage(_pattern, _selection, _editItem);
        addPage(_chooseMethodCallPage);
        // Add parameterMatchingPage.
        if (_defaultKind.equals(CallTypeEnum.PATTERN_CALL) || _defaultKind.equals(CallTypeEnum.ADD)) {
            _parameterMatchingPage = new ParameterMatchingPage(_selection, _pattern, _editingDomain);
            Pattern patternCallee = null;
            if (_editItem instanceof PatternCall) {
                patternCallee = ((PatternCall) _editItem).getCalled();
            }
            _parameterMatchingPage.setPatternCallee((patternCallee));
            addPage(_parameterMatchingPage);
        }
    }

    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        IWizardPage nextPage;
        if (page instanceof ChooseKindPage) {
            CallTypeEnum kind = ((ChooseKindPage) page).getKind();
            if (kind == CallTypeEnum.METHOD_CALL && _defaultKind.equals(CallTypeEnum.ADD)) {
                nextPage = _chooseMethodCallPage;
            } else if (_chooseKindPage.getKind() == CallTypeEnum.BACK_CALL || _chooseKindPage.getKind() == CallTypeEnum.SUPERPATTERN_CALL) {
                return null;
            } else {
                nextPage = _chooseCallPage;
            }
        } else {
            nextPage = _parameterMatchingPage;
        }
        return nextPage;
    }

    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     */
    @Override
    public boolean performFinish() {
        if (_chooseKindPage != null && _chooseKindPage.getKind() == CallTypeEnum.BACK_CALL)
            _selectCall = PatternFactory.eINSTANCE.createBackCall();
        else if (_chooseKindPage != null && _chooseKindPage.getKind() == CallTypeEnum.SUPERPATTERN_CALL)
            _selectCall = PatternFactory.eINSTANCE.createSuperCall();
        else {
            if (_chooseKindPage != null && _chooseKindPage.getKind() == CallTypeEnum.METHOD_CALL) {
                _chooseMethodCallList = _chooseMethodCallPage.getChooseMethodCallList();
                _selectCall = _chooseMethodCallPage.getChooseCall();
            } else {
                _selectCall = _chooseCallPage.getChooseCall();
            }
        }
        return true;
    }

    /**
     * The <code>Wizard</code> implementation of this <code>IWizard</code>
     * method does nothing and returns <code>true</code>. Subclasses should
     * reimplement this method if they need to perform any special cancel
     * processing for their wizard.
     */
    @Override
    public boolean performCancel() {
        if (_parameterMatchingPage != null && _editItem != null) {
            List<RecordingCommand> parameterMatchingCommands = _parameterMatchingPage.getParameterMatchingCommands();
            if (parameterMatchingCommands != null) {
                for (Iterator<RecordingCommand> it = parameterMatchingCommands.iterator(); it.hasNext();) {
                    if (_editingDomain.getCommandStack().canUndo()) {
                        _editingDomain.getCommandStack().undo();
                    }
                    it.next();
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
        this._selection = selection;
    }

    /**
     * Return the selection content.
     */
    public Call getSelectCall() {
        return _selectCall;
    }

    public List<Call> getSelectMethodCallList() {
        return _chooseMethodCallList;
    }

    public CallTypeEnum getDefaultKind() {
        return _defaultKind;
    }

}
