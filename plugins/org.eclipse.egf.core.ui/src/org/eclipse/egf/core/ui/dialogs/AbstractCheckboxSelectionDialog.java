/**
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.ui.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.egf.core.ui.internal.SWTFactory;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

/**
 * This class provides selection dialog using a check box table viewer.
 * 
 * @since 3.4
 */
public abstract class AbstractCheckboxSelectionDialog extends AbstractSelectionDialog {

    /**
     * Whether to add Select All / De-select All buttons to the custom footer controls.
     */
    private boolean fShowSelectButtons = false;

    /**
     * Constructor
     * 
     * @param parentShell
     */
    public AbstractCheckboxSelectionDialog(Shell parentShell) {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    /**
     * Returns the viewer cast to the correct instance. Possibly <code>null</code> if
     * the viewer has not been created yet.
     * 
     * @return the viewer cast to CheckboxTableViewer
     */
    protected CheckboxTableViewer getCheckBoxTableViewer() {
        return (CheckboxTableViewer) fViewer;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractSelectionDialog#initializeControls()
     */
    @Override
    protected void initializeControls() {
        List<?> selectedElements = getInitialElementSelections();
        if (selectedElements != null && selectedElements.isEmpty() == false) {
            fViewer.setInput(getViewerInput());
            getCheckBoxTableViewer().setCheckedElements(selectedElements.toArray());
            getCheckBoxTableViewer().setSelection(StructuredSelection.EMPTY);
        }
        if (getButtonBar() != null) {
            super.initializeControls();
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractSelectionDialog#createViewer (org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected StructuredViewer createViewer(Composite parent) {
        // by default return a checkbox table viewer
        Table table = new Table(parent, SWT.BORDER | SWT.SINGLE | SWT.CHECK);
        table.setLayoutData(new GridData(GridData.FILL_BOTH));
        return new CheckboxTableViewer(table);
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractSelectionDialog#addViewerListeners (org.eclipse.jface.viewers.StructuredViewer)
     */
    @Override
    protected void addViewerListeners(StructuredViewer viewer) {
        getCheckBoxTableViewer().addCheckStateListener(new DefaultCheckboxListener());
    }

    /**
     * A checkbox state listener that ensures that exactly one element is checked
     * and enables the OK button when this is the case.
     * 
     */
    private class DefaultCheckboxListener implements ICheckStateListener {

        public void checkStateChanged(CheckStateChangedEvent event) {
            if (getButtonBar() != null) {
                getButton(IDialogConstants.OK_ID).setEnabled(isValid());
            }
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractSelectionDialog#isValid()
     */
    @Override
    protected boolean isValid() {
        return getCheckBoxTableViewer().getCheckedElements().length > 0;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractSelectionDialog# addCustomFooterControls(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void addCustomFooterControls(Composite parent) {
        if (fShowSelectButtons) {
            Composite comp = SWTFactory.createComposite(parent, 2, 1, GridData.FILL_HORIZONTAL);
            GridData gd = (GridData) comp.getLayoutData();
            gd.horizontalAlignment = SWT.END;
            Button button = SWTFactory.createPushButton(comp, CoreUIMessages.AbstractCheckboxSelectionDialog_Select, null);
            button.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    getCheckBoxTableViewer().setAllChecked(true);
                    if (getButtonBar() != null) {
                        getButton(IDialogConstants.OK_ID).setEnabled(isValid());
                    }
                }

            });
            button = SWTFactory.createPushButton(comp, CoreUIMessages.AbstractCheckboxSelectionDialog_Deselect, null);
            button.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    getCheckBoxTableViewer().setAllChecked(false);
                    if (getButtonBar() != null) {
                        getButton(IDialogConstants.OK_ID).setEnabled(isValid());
                    }
                }

            });
        }
    }

    /**
     * If this setting is set to true before the dialog is opened, a Select All and
     * a De-select All button will be added to the custom footer controls. The default
     * setting is false.
     * 
     * @param setting
     *            whether to show the select all and de-select all buttons
     */
    protected void setShowSelectAllButtons(boolean setting) {
        fShowSelectButtons = setting;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed() {
        Object[] elements = getCheckBoxTableViewer().getCheckedElements();
        setResult(Arrays.asList(elements));
        super.okPressed();
    }

    /**
     * Returns the list of selections made by the user, or <code>null</code>
     * if the selection was canceled.
     * 
     * @return the array of selected elements, or <code>null</code> if Cancel
     *         was pressed
     */
    @Override
    public Object[] getResult() {
        if (getCheckBoxTableViewer().getControl().isDisposed()) {
            return super.getResult();
        }
        return getCheckBoxTableViewer().getCheckedElements();
    }

}
