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
import org.eclipse.egf.task.ui.preferences.InterpreterSetPreferencePage;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.PathEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

/**
 * @author xiaoru chen
 * 
 */
public class RubyVMLibraryPathsEditor extends PathEditor {

    private List list;

    private Label label;

    public RubyVMLibraryPathsEditor(String name, String labelText, String dirChooserLabelText, Composite parent) {
        super(name, labelText, dirChooserLabelText, parent);
    }

    @Override
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        super.doFillIntoGrid(parent, numColumns);
        list = getListControl(parent);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalAlignment = GridData.FILL;
        gd.horizontalSpan = numColumns - 1;
        gd.grabExcessHorizontalSpace = true;
        gd.horizontalIndent = 9;
        list.setLayoutData(gd);

        label = new Label(parent, SWT.NONE);
        label.setText(EGFTaskUIMessages.RubyVMLibraryPathsEditor_label_text);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalAlignment = GridData.FILL;
        gd.horizontalSpan = numColumns + 1;
        gd.grabExcessHorizontalSpace = true;
        gd.horizontalIndent = 9;
        label.setLayoutData(gd);
        addButtonsListener();
    }

    @Override
    public void setEnabled(boolean enabled, Composite parent) {
        super.setEnabled(enabled, parent);
        label.setEnabled(enabled);
    }

    private void addButtonsListener() {

        getRemoveButton().addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                DialogPage page = getPage();
                if (page instanceof InterpreterSetPreferencePage) {
                    ((InterpreterSetPreferencePage) page).checkLibraryList(list);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        getAddButton().addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                DialogPage page = getPage();
                if (page instanceof InterpreterSetPreferencePage) {
                    ((InterpreterSetPreferencePage) page).checkLibraryList(list);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });
    }

}
