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

import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
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

    public ActivitySelectionPage() {
        super(ModelEditorMessages.InvokeActivityWizard_Activity_title);
        setTitle(ModelEditorMessages.InvokeActivityWizard_Activity_title);
        setDescription(ModelEditorMessages.InvokeActivityWizard_Activity_description);
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        _dialog = new ActivitySelectionDialog(parent.getShell(), false);
        _dialog.createPage(container);
        container.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                _dialog.close();
            }

        });
        setControl(container);
    }

    public ActivitySelectionDialog getActivitySelectionDialog() {
        return _dialog;
    }

}
