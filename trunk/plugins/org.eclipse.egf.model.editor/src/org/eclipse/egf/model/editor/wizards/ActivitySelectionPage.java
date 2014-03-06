/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * </copyright>
 */

package org.eclipse.egf.model.editor.wizards;

import java.util.List;

import org.eclipse.egf.core.ui.dialogs.ISelectionDialogListener;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ActivitySelectionPage extends WizardPage {

    private ActivitySelectionDialog _dialog;

    private Object[] _selected;

    public ActivitySelectionPage() {
        super(ModelEditorMessages.InvokeActivityWizard_Activity_title);
        setTitle(ModelEditorMessages.InvokeActivityWizard_Activity_title);
        setDescription(ModelEditorMessages.InvokeActivityWizard_Activity_description);
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        _dialog = new ActivitySelectionDialog(parent.getShell(), false) {

            @Override
            protected void handleDoubleClick() {
                IWizard wizard = getWizard();
                wizard.performFinish();
                super.handleDoubleClick();
                IWizardContainer wizardContainer = wizard.getContainer();
                if (wizardContainer instanceof WizardDialog) {
                    ((WizardDialog) wizardContainer).close();
                }
            }

        };
        _dialog.createPage(container);
        container.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                _dialog.close();
            }

        });
        _dialog.addSelectionListeners(new ISelectionDialogListener() {

            public void handleSelected(Object[] selected) {
                _selected = selected;
                setPageComplete(isPageComplete());
                IWizardPage page = getNextPage();
                if (page instanceof ContractSelectionPage) {
                    ((ContractSelectionPage) page).setContracts(getContracts());
                }
            }

        });
        setControl(container);
    }

    private List<Contract> getContracts() {
        if (getFirstSelection() != null) {
            Object selection = getFirstSelection();
            if (selection != null && selection instanceof Activity) {
                return ((Activity) selection).getContracts();
            }
        }
        return null;
    }

    @Override
    public boolean canFlipToNextPage() {
        List<Contract> contracts = getContracts();
        return contracts != null && contracts.size() > 0;
    }

    @Override
    public boolean isPageComplete() {
        return _selected != null && _selected.length > 0;
    }

    public Object getFirstSelection() {
        return isPageComplete() ? _selected[0] : null;
    }

}
