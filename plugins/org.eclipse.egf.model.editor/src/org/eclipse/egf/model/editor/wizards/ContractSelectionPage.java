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

import org.eclipse.egf.model.editor.dialogs.ContractSelectionDialog;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Contract;
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
public class ContractSelectionPage extends WizardPage {

    private ContractSelectionDialog _dialog;

    public ContractSelectionPage() {
        super(ModelEditorMessages.InvokeActivityWizard_Contract_title);
        setTitle(ModelEditorMessages.InvokeActivityWizard_Contract_title);
        setDescription(ModelEditorMessages.InvokeActivityWizard_Contract_description);
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        _dialog = new ContractSelectionDialog(parent.getShell());
        _dialog.createPage(container);
        container.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                _dialog.close();
            }

        });
        setControl(container);
    }

    public void setContracts(List<Contract> contracts) {
        _dialog.setContracts(contracts);
    }

    public Object[] getResult() {
        return _dialog.getResult();
    }

}
