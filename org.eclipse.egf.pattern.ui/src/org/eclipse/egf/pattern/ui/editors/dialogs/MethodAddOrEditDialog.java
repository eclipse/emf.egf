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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class MethodAddOrEditDialog extends SelectionStatusDialog {

    private List<String> parentMethodNames;

    private Combo combo;

    private String name;

    private String oldName;

    public MethodAddOrEditDialog(Shell shell, List<String> parentMethods, String oldName) {
        super(shell);
        this.parentMethodNames = parentMethods;
        this.oldName = oldName;
    }

    protected Control createDialogArea(Composite parent) {
        final IStatus fLastStatusOk = new Status(IStatus.OK, Policy.JFACE, IStatus.OK, Util.ZERO_LENGTH_STRING, null);
        final IStatus fLastStatusErr = new Status(IStatus.ERROR, JavaCore.PLUGIN_ID, -1, "", null);
        updateStatus(fLastStatusErr);

        Composite dialogArea = (Composite) super.createDialogArea(parent);

        combo = new Combo(dialogArea, SWT.DROP_DOWN);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        combo.setLayoutData(gd);
        combo.setText(oldName);
        if (parentMethodNames != null) {
            for (String parentMethodName : parentMethodNames) {
                combo.add(parentMethodName);
            }
        }
        combo.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                updateStatus(fLastStatusOk);
                name = combo.getItem(combo.getSelectionIndex());
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });
        combo.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                name = combo.getText();
                if ("".equals(name)) {
                    updateStatus(fLastStatusErr);
                    return;
                }
                updateStatus(fLastStatusOk);
            }
        });

        checkRenameEnable();

        return dialogArea;
    }

    private void checkRenameEnable() {
        if (Messages.ImplementationPage_header.equals(oldName) || Messages.ImplementationPage_init.equals(oldName) || Messages.ImplementationPage_footer.equals(oldName)) {
            combo.setEnabled(false);
        }
    }

    @Override
    protected void computeResult() {
        // TODO Auto-generated method stub
    }

    public String getName() {
        return name;
    }
}
