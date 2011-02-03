/**
 * <copyright>
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
import org.eclipse.egf.pattern.ui.Activator;
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

    private Pattern _patternCaller;

    private Pattern _patternCallee;

    private Label _patternCalleeNameLabel;

    private TableViewer _calleeTableViewer;

    private TableViewer _matchingTableViewer;

    private TableViewer _callerTableViewer;

    private Button _createMatch;

    private Button _deleteMatch;

    private Button _editMatch;

    private PatternCall patternCall;

    private TransactionalEditingDomain _editingDomain;

    private List<RecordingCommand> _matchingCommands;

    public ParameterMatchingPage(ISelection selection, Pattern patternCaller, TransactionalEditingDomain editingDomain) {
        super(Messages.ParameterMatchingPage_title);
        setTitle(Messages.ParameterMatchingPage_title);
        setDescription(Messages.ParameterMatchingPage_label_text);

        this._patternCaller = patternCaller;
        this._editingDomain = editingDomain;
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
        _createMatch = new Button(parameterArea, SWT.PUSH);
        _createMatch.setText(Messages.ParameterMatchingPage_button_create);

        GridData gd = new GridData();
        gd.widthHint = 200;
        gd.horizontalSpan = 2;
        gd.horizontalAlignment = SWT.CENTER;
        gd.verticalIndent = 0;
        _createMatch.setLayoutData(gd);
        _createMatch.addSelectionListener(new SelectionListener() {

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
        _matchingTableViewer = new TableViewer(table);
        _matchingTableViewer.setLabelProvider(new ParameterMatchingLibraryProvider());
        _matchingTableViewer.setContentProvider(new CommonListContentProvider());
        _matchingTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

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

        _deleteMatch = createButton(buttonsArea);
        _deleteMatch.setToolTipText(Messages.ParameterMatchingPage_button_delete);
        _deleteMatch.setText(""); //$NON-NLS-1$
        _deleteMatch.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
        _deleteMatch.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                deleteMatching();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        _editMatch = createButton(buttonsArea);
        _editMatch.setToolTipText(Messages.ParameterMatchingPage_button_edit);
        _editMatch.setText(""); //$NON-NLS-1$
        _editMatch.setImage(Activator.getDefault().getImage(ImageShop.IMG_EDIT_OBJ));
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
        createPatternNameLabel(callerArea, _patternCaller);
        _callerTableViewer = createParameterTableViewer(callerArea, _patternCaller);
        _callerTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkCreateButtonEnable();
            }

        });
    }

    private void createCalleeArea(Composite dialogArea) {
        Composite calleeArea = createCallArea(dialogArea);
        _patternCalleeNameLabel = createPatternNameLabel(calleeArea, _patternCallee);
        _calleeTableViewer = createParameterTableViewer(calleeArea, _patternCallee);
        _calleeTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkCreateButtonEnable();
            }

        });
    }

    private Label createPatternNameLabel(Composite container, Pattern pattern) {
        Label patternNameLabel = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        patternNameLabel.setLayoutData(gd);
        setPatternName(pattern, patternNameLabel);
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
        if (pattern == null)
            return null;
        return pattern.getAllParameters();
    }

    private List<PatternParameter> getCalleeTableInput(Pattern pattern) {
        if (pattern == null) {
            return null;
        }
        EList<PatternParameter> parameters = pattern.getAllParameters();
        List<PatternParameter> availableParameters = new ArrayList<PatternParameter>();
        EMap<PatternParameter, PatternParameter> parameterMatching = patternCall.getParameterMatching();
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
        if ((getSelection(_callerTableViewer) != null) && (getSelection(_calleeTableViewer) != null)) {
            _createMatch.setEnabled(true);
        } else {
            _createMatch.setEnabled(false);
        }
    }

    private void checkEidtAndDeleteButtonEnable() {
        if ((getSelection(_matchingTableViewer) != null)) {
            _deleteMatch.setEnabled(true);
            _editMatch.setEnabled(true);
        } else {
            _deleteMatch.setEnabled(false);
            _editMatch.setEnabled(false);
        }
    }

    /**
     * Return the selection of the tableViewer.
     */
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
        final PatternParameter callerParameter = (PatternParameter) getSelection(_callerTableViewer);
        final PatternParameter calleeParameter = (PatternParameter) getSelection(_calleeTableViewer);
        int selectIndex = _calleeTableViewer.getTable().getSelectionIndex();
        RecordingCommand cmd = new RecordingCommand(_editingDomain) {

            @Override
            protected void doExecute() {
                patternCall.getParameterMatching().put(calleeParameter, callerParameter);
            }

        };
        _editingDomain.getCommandStack().execute(cmd);
        _matchingCommands.add(cmd);
        refreshTables();
        setSelection(_calleeTableViewer, selectIndex);
    }

    /**
     * Delete a new parameter matching.
     */
    private void deleteMatching() {
        final Paramerter2ParameterMapImpl deleteItem = (Paramerter2ParameterMapImpl) getSelection(_matchingTableViewer);
        int selectIndex = _matchingTableViewer.getTable().getSelectionIndex();
        RecordingCommand cmd = new RecordingCommand(_editingDomain) {

            @Override
            protected void doExecute() {
                patternCall.getParameterMatching().remove(deleteItem);
            }

        };
        _editingDomain.getCommandStack().execute(cmd);
        _matchingCommands.add(cmd);
        refreshTables();
        setSelection(_matchingTableViewer, selectIndex);
    }

    private void refreshTables() {
        _matchingTableViewer.setInput(getMatchingList());
        _calleeTableViewer.setInput(getCalleeTableInput(_patternCallee));
        setMissingInformation();
    }

    /**
     * Get the matchingTableViewer's input.
     */
    private EMap<PatternParameter, PatternParameter> getMatchingList() {
        EMap<PatternParameter, PatternParameter> parameterMatching = null;
        parameterMatching = patternCall.getParameterMatching();
        return parameterMatching;
    }

    /**
     * Update the patterCallee table.
     */
    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            _matchingCommands = new ArrayList<RecordingCommand>();
            updatePatternCallee();
            _callerTableViewer.setInput(getCallerTableInput(_patternCaller));
            refreshTables();
            checkCreateButtonEnable();
            checkEidtAndDeleteButtonEnable();
        }
        super.setVisible(visible);
    }

    private String getPatternName(String name) {
        return name + ((name == null || name.equals("")) ? "" : ":"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
        setPatternName(_patternCallee, _patternCalleeNameLabel);
        _calleeTableViewer.setInput(getCallerTableInput(_patternCallee));
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

    /**
     * If there is no available caller parameters or callee parameters to
     * setup,show the information in the page.
     */
    private void setMissingInformation() {
        String message = null;
        if (_callerTableViewer.getTable().getItemCount() == 0 || _calleeTableViewer.getTable().getItemCount() == 0) {
            message = Messages.ParameterMatchingPage_missing_information;
        }
        setMessage(message, INFORMATION);
    }

    public void setPatternCall(PatternCall call) {
        this.patternCall = call;
    }

    public PatternCall getPatternCall() {
        return patternCall;
    }

    public void setPatternCallee(Pattern patternCallee) {
        this._patternCallee = patternCallee;
    }

    public List<RecordingCommand> getParameterMatchingCommands() {
        return _matchingCommands;
    }
}
