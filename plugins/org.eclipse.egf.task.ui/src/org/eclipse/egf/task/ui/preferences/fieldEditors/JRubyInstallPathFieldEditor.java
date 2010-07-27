/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */

package org.eclipse.egf.task.ui.preferences.fieldEditors;

import org.eclipse.egf.task.ui.l10n.EGFTaskUIMessages;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author xiaoru chen
 * 
 */
public class JRubyInstallPathFieldEditor extends DirectoryFieldEditor {
    private Label label;

    public JRubyInstallPathFieldEditor(String name, String labelText, Composite parent) {
        super(name, labelText, parent);
    }

    @Override
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        label = new Label(parent, SWT.LEFT);
        label.setFont(parent.getFont());
        label.setText(EGFTaskUIMessages.JRubyInstallPathFieldEditor_label_text);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalAlignment = GridData.FILL;
        gd.horizontalSpan = numColumns;
        gd.grabExcessHorizontalSpace = true;
        gd.horizontalIndent = 9;
        label.setLayoutData(gd);
        super.doFillIntoGrid(parent, numColumns);
        Text text = getTextControl(parent);
        text.setEditable(false);
    }

    @Override
    public void setEnabled(boolean enabled, Composite parent) {
        super.setEnabled(enabled, parent);
        label.setEnabled(enabled);
    }

    @Override
    protected boolean checkState() {
        return true;
    }

    @Override
    protected void clearErrorMessage() {

    }
}
