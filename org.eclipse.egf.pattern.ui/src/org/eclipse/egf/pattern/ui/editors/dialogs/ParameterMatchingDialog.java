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
package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.PatternSelectionLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TableObservableListContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

public class ParameterMatchingDialog extends SelectionStatusDialog {

    private Pattern patternCaller;

    private Pattern patternCallee;

    public ParameterMatchingDialog(Shell parent, Pattern patternCaller, Pattern patternCallee) {
        super(parent);
        this.patternCaller = patternCaller;
        this.patternCallee = patternCallee;
    }

    protected Control createDialogArea(Composite parent) {
        Composite dialogArea = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout(2, true);
        dialogArea.setLayout(layout);

        Label label = new Label(dialogArea, SWT.NONE);
        label.setText(Messages.ParameterMatchingDialog_label_text);
        GridData gd = new GridData();
        gd.horizontalSpan = 2;
        gd.horizontalIndent = 5;
        label.setLayoutData(gd);

        // TODO:0001091 Issue.
        createCallerArea(dialogArea);
        createCalleeArea(dialogArea);

        return dialogArea;
    }

    private void createCallerArea(Composite dialogArea) {
        Composite callerArea = createCallArea(dialogArea);
        createPatternNameLabel(callerArea, patternCaller);
        TableViewer callerTableViewer = createParameterTableViewer(callerArea, patternCaller);
    }

    private void createCalleeArea(Composite dialogArea) {
        Composite calleeArea = createCallArea(dialogArea);
        createPatternNameLabel(calleeArea, patternCallee);
        TableViewer calleeTableViewer = createParameterTableViewer(calleeArea, patternCallee);
    }

    private Label createPatternNameLabel(Composite container, Pattern pattern) {
        Label patternNameLabel = new Label(container, SWT.NONE);
        GridData gd = new GridData();
        patternNameLabel.setLayoutData(gd);
        String name = pattern.getName();
        patternNameLabel.setText(name + (name != null ? ":" : "")); //$NON-NLS-1$ //$NON-NLS-2$
        return null;
    }

    private TableViewer createParameterTableViewer(Composite container, Pattern pattern) {
        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 60;
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(200);
        TableViewer tableViewer = new TableViewer(listTable);
        tableViewer.setLabelProvider(new ParametersTableLabelProvider());
        tableViewer.setContentProvider(new CommonListContentProvider());
        List<PatternParameter> tableInput = getTableInput(pattern);
        tableViewer.setInput(tableInput);

        return tableViewer;
    }

    private Composite createCallArea(Composite container) {
        Composite callArea = new Composite(container, SWT.NONE);
        GridLayout layout = new GridLayout();
        callArea.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        callArea.setLayoutData(gd);
        return callArea;
    }

    private List<PatternParameter> getTableInput(Pattern pattern) {
        return pattern.getParameters();
    }

    @Override
    protected void computeResult() {
    }

}
