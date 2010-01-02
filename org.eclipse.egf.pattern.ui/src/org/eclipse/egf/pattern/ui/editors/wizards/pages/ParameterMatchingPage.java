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

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ParameterMatchingLibraryProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ParameterMatchingPage extends WizardPage {

    private Pattern patternCaller;

    private Pattern patternCallee;

    private Label patternCalleeNameLabel;

    private TableViewer calleeTableViewer;

    private TableViewer matchingTableViewer;

    private TableViewer callerTableViewer;

    private Button createMatch;

    private Button deleteMatch;

    private Button editMatch;

    private PatternCall call;

    private TransactionalEditingDomain transactionalEditingDomain;

    private List<RecordingCommand> matchingCommands = new ArrayList<RecordingCommand>();;

    public ParameterMatchingPage(ISelection selection, Pattern patternCaller, TransactionalEditingDomain transactionalEditingDomain) {
        super(Messages.ParameterMatchingPage_title);
        setTitle(Messages.ParameterMatchingPage_title);
        setDescription(Messages.ParameterMatchingPage_label_text);

        this.patternCaller = patternCaller;
        this.transactionalEditingDomain = transactionalEditingDomain;
    }

    public void createControl(Composite parent) {
        Composite dialogArea = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        dialogArea.setLayout(layout);

        createParameterArea(dialogArea);
        createMatchingArea(dialogArea);

        setControl(dialogArea);
    }

    private void createParameterArea(Composite dialogArea) {
        Composite parameterArea = createArea(dialogArea, true);

        createCallerArea(parameterArea);
        createCalleeArea(parameterArea);
        createMatingButton(parameterArea);
    }

    private void createMatingButton(Composite parameterArea) {
        createMatch = new Button(parameterArea, SWT.PUSH);
        createMatch.setText(Messages.ParameterMatchingPage_button_create);

        GridData gd = new GridData();
        gd.widthHint = 200;
        gd.horizontalSpan = 2;
        gd.horizontalAlignment = SWT.CENTER;
        gd.verticalIndent = 0;
        createMatch.setLayoutData(gd);
        createMatch.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                createMatching();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    private void createMatchingArea(Composite dialogArea) {
        Composite parameterArea = createArea(dialogArea, false);

        Label currenMatchingLabel = new Label(parameterArea, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        gd.horizontalIndent = 9;
        currenMatchingLabel.setLayoutData(gd);
        currenMatchingLabel.setText(Messages.ParameterMatchingPage_current_mathings_title);

        Table table = new Table(parameterArea, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 160;
        gd.horizontalIndent = 7;
        gd.verticalIndent = 0;
        table.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setWidth(420);
        matchingTableViewer = new TableViewer(table);
        matchingTableViewer.setLabelProvider(new ParameterMatchingLibraryProvider());
        matchingTableViewer.setContentProvider(new CommonListContentProvider());
        matchingTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkEidtAndDeleteButtonEnable();
            }

        });
        createMatchingAreaButtons(parameterArea);
    }

    private void createMatchingAreaButtons(Composite parameterArea) {
        Composite buttonsArea = new Composite(parameterArea, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttonsArea.setLayout(layout);

        deleteMatch = createButton(buttonsArea);
        deleteMatch.setToolTipText(Messages.ParameterMatchingPage_button_delete);
        deleteMatch.setText(""); //$NON-NLS-1$
        deleteMatch.setImage(ImageShop.get(ImageShop.IMG_DELETE_OBJ));
        deleteMatch.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                deleteMatching();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        editMatch = createButton(buttonsArea);
        editMatch.setToolTipText(Messages.ParameterMatchingPage_button_edit);
        editMatch.setText(""); //$NON-NLS-1$
        editMatch.setImage(ImageShop.get(ImageShop.IMG_EDIT_OBJ));
    }

    private Composite createArea(Composite composite, boolean makeColumnsEqualWidth) {
        Composite container = new Composite(composite, SWT.NONE);
        GridLayout layout = new GridLayout(2, makeColumnsEqualWidth);

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 0;
        container.setLayout(layout);
        container.setLayoutData(gd);
        return container;
    }

    private void createCallerArea(Composite dialogArea) {
        Composite callerArea = createCallArea(dialogArea);
        createPatternNameLabel(callerArea, patternCaller);
        callerTableViewer = createParameterTableViewer(callerArea, patternCaller);
        callerTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkCreateButtonEnable();
            }

        });
    }

    private void createCalleeArea(Composite dialogArea) {
        Composite calleeArea = createCallArea(dialogArea);
        patternCalleeNameLabel = createPatternNameLabel(calleeArea, patternCallee);
        calleeTableViewer = createParameterTableViewer(calleeArea, patternCallee);
        calleeTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkCreateButtonEnable();
            }

        });
    }

    private Label createPatternNameLabel(Composite container, Pattern pattern) {
        Label patternNameLabel = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        patternNameLabel.setLayoutData(gd);
        setPatternName(pattern, patternNameLabel); //$NON-NLS-1$ //$NON-NLS-2$
        return patternNameLabel;
    }

    private TableViewer createParameterTableViewer(Composite container, Pattern pattern) {
        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = listTable.getItemHeight();
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(260);
        TableViewer tableViewer = new TableViewer(listTable);
        tableViewer.setLabelProvider(new ParametersTableLabelProvider());
        tableViewer.setContentProvider(new CommonListContentProvider());

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

    private Button createButton(Composite container) {
        Button button = new Button(container, SWT.PUSH);
        GridData gd = new GridData();
        gd.widthHint = 60;
        button.setLayoutData(gd);
        return button;
    }

    private List<PatternParameter> getCallerTableInput(Pattern pattern) {
        return pattern == null ? null : pattern.getParameters();
    }

    private List<PatternParameter> getCalleeTableInput(Pattern pattern) {
        if (pattern == null) {
            return null;
        }
        EList<PatternParameter> parameters = pattern.getParameters();
        List<PatternParameter> availableParameters = new ArrayList<PatternParameter>();
        EMap<PatternParameter, PatternParameter> parameterMatching = call.getParameterMatching();
        for (PatternParameter parameter : parameters) {
            if (isAvailableParameter(parameter, parameterMatching)) {
                availableParameters.add(parameter);
            }
        }

        return availableParameters;
    }

    /**
     * Check whether the parameter is available.
     */
    private boolean isAvailableParameter(PatternParameter parameter, EMap<PatternParameter, PatternParameter> parameterMatching) {
        for (int i = 0; i < parameterMatching.size(); i++) {
            Entry<PatternParameter, PatternParameter> currentEntry = parameterMatching.get(i);
            PatternParameter currentKey = currentEntry.getKey();
            if (currentKey.equals(parameter)) {
                return false;
            }
        }
        return true;
    }

    private void checkCreateButtonEnable() {
        if ((getSelection(callerTableViewer) != null) && (getSelection(calleeTableViewer) != null)) {
            createMatch.setEnabled(true);
        } else {
            createMatch.setEnabled(false);
        }
    }

    private void checkEidtAndDeleteButtonEnable() {
        if ((getSelection(matchingTableViewer) != null)) {
            deleteMatch.setEnabled(true);
            editMatch.setEnabled(true);
        } else {
            deleteMatch.setEnabled(false);
            editMatch.setEnabled(false);
        }
    }

    private Object getSelection(TableViewer tableViewer) {
        int selectionIndex = tableViewer.getTable().getSelectionIndex();
        if (selectionIndex != -1) {
            return tableViewer.getElementAt(selectionIndex);
        }
        return null;
    }

    /**
     * Create a new parameter matching.
     */
    private void createMatching() {
        final PatternParameter callerParameter = (PatternParameter) getSelection(callerTableViewer);
        final PatternParameter calleeParameter = (PatternParameter) getSelection(calleeTableViewer);
        int selectIndex = calleeTableViewer.getTable().getSelectionIndex();
        RecordingCommand cmd = new RecordingCommand(transactionalEditingDomain) {
            protected void doExecute() {
                call.getParameterMatching().put(calleeParameter, callerParameter);
            }
        };
        transactionalEditingDomain.getCommandStack().execute(cmd);
        matchingCommands.add(cmd);
        refreshTables();
        setSelection(calleeTableViewer, selectIndex);
    }

    /**
     * Delete a new parameter matching.
     */
    private void deleteMatching() {
        final Paramerter2ParameterMapImpl deleteItem = (Paramerter2ParameterMapImpl) getSelection(matchingTableViewer);
        int selectIndex = matchingTableViewer.getTable().getSelectionIndex();
        RecordingCommand cmd = new RecordingCommand(transactionalEditingDomain) {
            protected void doExecute() {
                call.getParameterMatching().remove(deleteItem);
            }
        };
        transactionalEditingDomain.getCommandStack().execute(cmd);
        matchingCommands.add(cmd);
        refreshTables();
        setSelection(matchingTableViewer, selectIndex);
    }

    private void refreshTables() {
        matchingTableViewer.setInput(getMatchingList());
        calleeTableViewer.setInput(getCalleeTableInput(patternCallee));
        setMissingInformation();
    }

    /**
     * Get the matchingTableViewer's input.
     */
    private EMap<PatternParameter, PatternParameter> getMatchingList() {
        EMap<PatternParameter, PatternParameter> parameterMatching = null;
        parameterMatching = call.getParameterMatching();
        return parameterMatching;
    }

    /**
     * Update the patterCallee table.
     */
    public void setVisible(boolean visible) {
        if (visible) {
            updatePatternCallee();
            callerTableViewer.setInput(getCallerTableInput(patternCaller));
            refreshTables();
            checkCreateButtonEnable();
            checkEidtAndDeleteButtonEnable();
        }
        super.setVisible(visible);
    }

    private String getPatternName(String name) {
        return name + ((name == null || name.equals("")) ? "" : ":"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    }

    /**
     * Set the display pattern name label.
     */
    private void setPatternName(Pattern pattern, Label label) {
        String patternName = pattern == null ? "" : pattern.getName(); //$NON-NLS-1$
        label.setText(getPatternName(patternName));
    }

    /**
     * Refresh the patternCallee area.
     */
    private void updatePatternCallee() {
        setPatternName(patternCallee, patternCalleeNameLabel);
        calleeTableViewer.setInput(getCallerTableInput(patternCallee));
    }

    /**
     * Set new selection after refresh the tableViewr.
     */
    private void setSelection(TableViewer tableViewer, int oldIndex) {
        int len = tableViewer.getTable().getItemCount();
        if (len > 0) {
            if (oldIndex == len) {
                tableViewer.getTable().setSelection(oldIndex - 1);
            } else if (oldIndex < len) {
                tableViewer.getTable().setSelection(oldIndex);
            }
        }
        checkCreateButtonEnable();
        checkEidtAndDeleteButtonEnable();
    }

    private void setMissingInformation() {
        String message = null;
        if (callerTableViewer.getTable().getItemCount() == 0 || calleeTableViewer.getTable().getItemCount() == 0) {
            message = Messages.ParameterMatchingPage_missing_information;
        }
        setMessage(message, INFORMATION);
    }

    public void setPatternCall(PatternCall call) {
        this.call = call;
    }

    public PatternCall getPatternCall() {
        return call;
    }

    public void setPatternCallee(Pattern patternCallee) {
        this.patternCallee = patternCallee;
    }

    public List<RecordingCommand> getParameterMatchingCommands() {
        return matchingCommands;
    }
}
