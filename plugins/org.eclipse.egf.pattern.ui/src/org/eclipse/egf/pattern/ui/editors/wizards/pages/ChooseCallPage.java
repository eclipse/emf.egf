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

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.InjectedContext;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.dialogs.PatternElementSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.MethodLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.PatternSelectionLabelProvider;
import org.eclipse.egf.pattern.ui.editors.wizards.OrchestrationWizard;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ChooseCallPage extends WizardPage {

    private CallTypeEnum _selectKind;

    private CallTypeEnum _oldKind = CallTypeEnum.Add;

    private Pattern _pattern;

    private TableViewer _parentTableViewer;

    private TableViewer _childTableViewer;

    private Call _selectCall;

    private List<Call> _selectMethodCallList;

    private Label _title;

    private Text _text;

    private Label _varParaLabel;

    private Object _editItem;

    protected Composite _container;

    private boolean _isFirst = true;

    private boolean _canFinish = false;

    public ChooseCallPage(Pattern pattern, ISelection selection, Object editItem) {
        super(Messages.ChooseCallPage_title);
        setTitle(Messages.ChooseCallPage_title);
        setDescription(Messages.ChooseCallPage_description);
        _pattern = pattern;
        _editItem = editItem;
    }

    public void createControl(Composite parent) {
        createCallControl(parent);
        setPageComplete(false);
    }

    private void createCallControl(Composite parent) {
        _container = new Composite(parent, SWT.NONE);
        _container.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
        GridLayout layout = new GridLayout();
        _container.setLayout(layout);

        _title = new Label(_container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        _title.setLayoutData(gd);

        createPatternsMethodsArea();
        createVariablesArea();
        setControl(_container);
    }

    private void createPatternsMethodsArea() {
        _text = new Text(_container, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 550;
        _text.setLayoutData(gd);
        _text.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {

                if (_selectKind != CallTypeEnum.SUPERPATTERN_CALL) {
                    checkListAreaExist(_text.getText());
                }
            }
        });
        Label label = new Label(_container, SWT.NONE);
        label.setText(Messages.ChooseCallPage_label_text);

        Table listTable = createParentTable();
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 60;
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        _parentTableViewer = new TableViewer(listTable);
        _parentTableViewer.setContentProvider(new CommonListContentProvider());
        _parentTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkParentTableSelect();
                setParameterMatchingCall(_selectCall);
                if (_selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
                    if (isPageComplete()) {
                        checkChildTableSelect();
                    }
                }
            }
        });

        _parentTableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (_selectKind == CallTypeEnum.METHOD_CALL || _selectKind == CallTypeEnum.PATTERN_CALL) {
                    getSelectionContent();
                    setParameterMatchingCall(_selectCall);
                    getWizard().performFinish();
                    WizardDialog wizardDialog = (WizardDialog) (getWizard().getContainer());
                    wizardDialog.close();
                } else {
                    checkChildTableSelect();
                    PatterninjectedCallDoubleClick();
                }
            }
        });
    }

    protected Table createParentTable() {
        Table listTable = new Table(_container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        return listTable;
    }

    private void createVariablesArea() {
        _varParaLabel = new Label(_container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        _varParaLabel.setLayoutData(gd);
        _varParaLabel.setText(Messages.ChooseCallPage_patternInjectCall_title);

        Table listTable = new Table(_container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 60;
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        _childTableViewer = new TableViewer(listTable);
        _childTableViewer.setLabelProvider(new PatternSelectionLabelProvider());
        _childTableViewer.setContentProvider(new CommonListContentProvider());
        _childTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkChildTableSelect();
                if (isPageComplete()) {
                    checkParentTableSelect();
                }
            }
        });

        _childTableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (_selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
                    checkParentTableSelect();
                    PatterninjectedCallDoubleClick();
                }
            }
        });
    }

    /**
     * Get the double click information while the call type is
     * PATTERNINJECTED_CALL.
     */
    private void PatterninjectedCallDoubleClick() {
        if (isPageComplete()) {
            getSelectionContent();
            getWizard().performFinish();
            WizardDialog wizardDialog = (WizardDialog) (getWizard().getContainer());
            wizardDialog.close();
        }
    }

    /**
     * If is a edit operation, set the default select value in table.
     */
    private void setDefaultSelectValue() {
        if (_editItem != null) {
            if (_selectKind == CallTypeEnum.METHOD_CALL && _editItem instanceof MethodCall) {
                MethodCall call = (MethodCall) _editItem;
                PatternMethod called = call.getCalled();
                setSelectValue(called, null);

            } else if (_selectKind == CallTypeEnum.PATTERN_CALL && _editItem instanceof PatternCall) {
                PatternCall call = (PatternCall) _editItem;
                Pattern called = call.getCalled();
                setSelectValue(called, null);

            } else if (_selectKind == CallTypeEnum.PATTERNINJECTED_CALL && _editItem instanceof PatternInjectedCall) {
                PatternInjectedCall call = (PatternInjectedCall) _editItem;
                Pattern called = call.getCalled();
                InjectedContext context = call.getContext();
                setSelectValue(called, context);
            }
            setParameterMatchingCall(_editItem);
        }
    }

    /**
     * Set the default select value if has been found in table.
     */
    private void setSelectValue(Object called, Object context) {
        if (called != null) {
            TableItem[] parentItems = _parentTableViewer.getTable().getItems();
            for (int i = 0; i < parentItems.length; i++) {
                Object currentData = parentItems[i].getData();
                if (currentData.equals(called)) {
                    _parentTableViewer.getTable().select(i);
                    setTextValue(called);
                    if (_selectKind == CallTypeEnum.METHOD_CALL || _selectKind == CallTypeEnum.PATTERN_CALL) {
                        checkParentTableSelect();
                        return;
                    } else if (_selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
                        setChildTableSelectValue(called, context);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Set the default text value.
     */
    private void setTextValue(Object called) {
        if (called instanceof PatternMethod) {
            PatternMethod patternMethod = (PatternMethod) called;
            _text.setText(patternMethod.getName());
        } else if (called instanceof Pattern) {
            Pattern pattern = (Pattern) called;
            _text.setText(pattern.getName());
        }
    }

    /**
     * Select the default context in child table if has been found.
     */
    private void setChildTableSelectValue(Object called, Object context) {
        if (context != null) {
            TableItem[] childItems = _childTableViewer.getTable().getItems();
            for (int i = 0; i < childItems.length; i++) {
                Object currentData = childItems[i].getData();
                if (currentData.equals(context)) {
                    _childTableViewer.getTable().select(i);
                    checkChildTableSelect();
                    return;
                }
            }
        }
    }

    /**
     * Get the kind of call.
     */
    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            if (getPreviousPage() != null) {
                _selectKind = ((ChooseKindPage) getPreviousPage()).getKind();
            } else {
                _selectKind = ((OrchestrationWizard) getWizard()).getDefaultKind();
            }
            updateTable(_selectKind);
        }
        super.setVisible(visible);
        if (_isFirst) {
            setDefaultSelectValue();
            _isFirst = false;
        }
    }

    /**
     * Refresh the page style by kind of call.
     */
    private void updateTable(CallTypeEnum kind) {
        if (kind == CallTypeEnum.METHOD_CALL) {
            if (kind != _oldKind) {
                _parentTableViewer.setLabelProvider(new MethodLabelProvider());
                _parentTableViewer.setSorter(new ViewerSorter(Collator.getInstance(Locale.ENGLISH)));
                updateTableInput(getMethods(), null, true, false);
            }
            _title.setText(Messages.ChooseCallPage_methodCall_title);
        } else {
            _parentTableViewer.setLabelProvider(new PatternSelectionLabelProvider());
        }

        if (kind == CallTypeEnum.PATTERN_CALL) {
            if (kind != _oldKind) {
                updateTableInput(getPatterns(), null, true, false);
            }
            _title.setText(Messages.ChooseCallPage_patternCall_title);
        }

        if (kind == CallTypeEnum.PATTERNINJECTED_CALL) {
            if (kind != _oldKind) {
                updateTableInput(getPatterns(), getContextForInjection(), true, true);
            }
            _title.setText(Messages.ChooseCallPage_patternCall_title);
        }

        if (kind == CallTypeEnum.SUPERPATTERN_CALL) {
            updateTableInput(null, null, false, false);
            if (kind != _oldKind) {
                _title.setText(Messages.ChooseCallPage_superPatternCall_title);
            }
        }
        _oldKind = kind;
    }

    private void redrawControl(boolean exclude) {
        GridData labelLayoutData = (GridData) _varParaLabel.getLayoutData();
        labelLayoutData.exclude = exclude;
        _varParaLabel.setVisible(!exclude);

        Table table = _childTableViewer.getTable();
        GridData tableLayoutData = (GridData) table.getLayoutData();
        tableLayoutData.exclude = exclude;
        table.setVisible(!exclude);

        layout(table);
    }

    private void layout(Control control) {
        if (control == null || control.isDisposed()) {
            return;
        }
        if (control instanceof Composite) {
            ((Composite) control).layout();
        }
        layout(control.getParent());
    }

    /**
     * While change the call type,update the table input.
     */
    private void updateTableInput(List<?> parentTableInput, List<?> childTableInput, boolean parentTableEnable, boolean childTableEnable) {
        _parentTableViewer.setInput(null);
        _parentTableViewer.setInput(parentTableInput);
        _childTableViewer.setInput(childTableInput);
        _parentTableViewer.getTable().setEnabled(parentTableEnable);
        _childTableViewer.getTable().setEnabled(childTableEnable);
        redrawControl(!childTableEnable);
        _text.setText(""); //$NON-NLS-1$
        if (_selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
            checkChildTableSelect();
        }
        checkParentTableSelect();
    }

    private void checkParentTableSelect() {
        int selectionIndex = _parentTableViewer.getTable().getSelectionIndex();
        if (selectionIndex == -1) {
            String errorMessage = Messages.ChooseCallPage_no_call_selected_error_message;
            updateMessage(errorMessage);
        } else {
            updateMessage(null);
            setPatternCalleeForMatch(selectionIndex);
        }
    }

    /**
     * If pattern call is chosen, update the parameterMatchingPage's
     * patternCallee with pattern item user select.
     */
    private void setPatternCalleeForMatch(int index) {
        if (_selectKind == CallTypeEnum.PATTERN_CALL) {
            Pattern pattern = (Pattern) _parentTableViewer.getElementAt(index);
            ((ParameterMatchingPage) getNextPage()).setPatternCallee(pattern);
        }
    }

    private void checkChildTableSelect() {
        int selectionIndex = _childTableViewer.getTable().getSelectionIndex();
        if (selectionIndex == -1) {
            String errorMessage = Messages.ChooseCallPage_no_variable_selected_error_message;
            updateMessage(errorMessage);
        } else {
            updateMessage(null);
        }
    }

    private void updateMessage(String message) {
        setMessage(message, ERROR);
        if ("".equals(message) || message == null) { //$NON-NLS-1$
            getSelectionContent();
            canFinish(true);
            setPageComplete(true);
        } else {
            canFinish(false);
            setPageComplete(false);
        }
    }

    private List<PatternMethod> getMethods() {
        return PatternUIHelper.getAllUseablePatternMethods(_pattern);
    }

    private List<Pattern> getPatterns() {
        return PatternHelper.TRANSACTIONNAL_COLLECTOR.getAllPatterns();
    }

    private List<InjectedContext> getContextForInjection() {
        List<InjectedContext> result = new ArrayList<InjectedContext>();
        result.addAll(_pattern.getAllVariables());
        result.addAll(_pattern.getAllParameters());
        return result;
    }

    private void checkListAreaExist(String name) {
        if ((getListAreaDisplay(name).size() <= 0)) {
            setPageComplete(false);
        }
    }

    /**
     * Get the parent table's content by the text value user input.
     */
    private List<?> getListAreaDisplay(String name) {
        List<?> input = new ArrayList<Object>();
        switch (_selectKind) {
            case METHOD_CALL:
                input = getMethods();
                break;
            case PATTERN_CALL:
                input = getPatterns();
                break;
            case PATTERNINJECTED_CALL:
                input = getPatterns();
                break;
            default:
                return null;
        }
        List<Object> callsNew = new ArrayList<Object>();
        if (!"".equals(name)) { //$NON-NLS-1$
            String currentName = ""; //$NON-NLS-1$
            for (Object currentItemData : input) {
                if (_selectKind == CallTypeEnum.METHOD_CALL) {
                    if (currentItemData instanceof PatternMethod) {
                        currentName = ((PatternMethod) currentItemData).getName().toLowerCase();
                    }
                } else if (_selectKind == CallTypeEnum.PATTERN_CALL || _selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
                    if (currentItemData instanceof Pattern) {
                        currentName = ((Pattern) currentItemData).getName().toLowerCase();
                    }
                }
                if (PatternElementSelectionDialog.searchContainer(currentName, name)) {
                    callsNew.add(currentItemData);
                }
            }
        } else {
            callsNew.addAll(input);
        }
        _parentTableViewer.setInput(callsNew);
        return callsNew;
    }

    /**
     * Get the selection content.
     */
    protected void getSelectionContent() {
        int selectParentTableIndex = _parentTableViewer.getTable().getSelectionIndex();
        if (selectParentTableIndex >= 0) {
            Object selectParentItem = _parentTableViewer.getElementAt(selectParentTableIndex);
            switch (_selectKind) {
                case METHOD_CALL:
                    getSelectMethodCallList();
                    PatternMethod patternMethod = (PatternMethod) selectParentItem;
                    MethodCall methodCall = PatternFactory.eINSTANCE.createMethodCall();
                    methodCall.setCalled(patternMethod);
                    _selectCall = methodCall;
                    return;
                case PATTERN_CALL:
                    Pattern patternKind_1 = (Pattern) selectParentItem;
                    PatternCall patternCall = PatternFactory.eINSTANCE.createPatternCall();
                    patternCall.setCalled(patternKind_1);
                    _selectCall = patternCall;
                    return;
                case PATTERNINJECTED_CALL:
                    Pattern patternKind_2 = (Pattern) selectParentItem;
                    PatternInjectedCall patternInjectedCall = PatternFactory.eINSTANCE.createPatternInjectedCall();
                    patternInjectedCall.setCalled(patternKind_2);
                    // Get the select PatternVariable.
                    int selectChildTableIndex = _childTableViewer.getTable().getSelectionIndex();
                    Object selectChildItem = _childTableViewer.getElementAt(selectChildTableIndex);
                    if (selectChildItem instanceof InjectedContext) {
                        InjectedContext ctx = (InjectedContext) selectChildItem;
                        patternInjectedCall.setContext(ctx);
                    }
                    _selectCall = patternInjectedCall;
                    return;
            }
        }
    }

    /**
     * Get select method calls.
     */
    private void getSelectMethodCallList() {
        _selectMethodCallList = new ArrayList<Call>();
        TableItem[] selection = _parentTableViewer.getTable().getSelection();
        for (TableItem item : selection) {
            Object data = item.getData();
            PatternMethod patternMethod = (PatternMethod) data;
            MethodCall methodCall = PatternFactory.eINSTANCE.createMethodCall();
            methodCall.setCalled(patternMethod);
            _selectMethodCallList.add(methodCall);
        }
    }

    /**
     * Update the new patternCall if the user set a new callee pattern.
     */
    private void setParameterMatchingCall(Object call) {
        if (_selectKind == CallTypeEnum.PATTERN_CALL && call != null && call instanceof PatternCall) {
            PatternCall patternCall = (PatternCall) call;
            ((ParameterMatchingPage) getNextPage()).setPatternCall(patternCall);
        }
    }

    /**
     * If pattern call is chosen, the second is for selecting the pattern to
     * call and the the third one is for matching manually the parameters.
     */
    @Override
    public IWizardPage getNextPage() {
        if (_selectKind == CallTypeEnum.PATTERN_CALL)
            return super.getNextPage();
        return null;
    }

    /**
     * Return the selection content.
     */
    public Call getChooseCall() {
        if (_selectKind == CallTypeEnum.PATTERN_CALL) {
            return ((ParameterMatchingPage) getNextPage()).getPatternCall();
        }
        return _selectCall;
    }

    public List<Call> getChooseMethodCallList() {
        return _selectMethodCallList;
    }

    private void canFinish(boolean isFinish) {
        _canFinish = isFinish;
    }

    public boolean canFinish() {
        return _canFinish;
    }
}
