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
import java.util.Set;

import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.SuperPatternCall;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.dialogs.PatternElementSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.MethodLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.PatternSelectionLabelProvider;
import org.eclipse.egf.pattern.ui.editors.wizards.OrchestrationWizard;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * @author xrchen
 * 
 */
public class ChooseCallPage extends WizardPage {

    private CallTypeEnum selectKind;

    private CallTypeEnum oldKind = CallTypeEnum.Add;

    private Pattern pattern;

    private TableViewer parentTableViewer;

    private TableViewer childTableViewer;

    private Call selectCall;

    private Label title;

    private Text text;

    private Label varParaLabel;

    private Object eidtItem;

    public ChooseCallPage(Pattern pattern, ISelection selection, Object eidtItem) {
        super(Messages.ChooseCallPage_title);
        setTitle(Messages.ChooseCallPage_title);
        setDescription(Messages.ChooseCallPage_description);
        this.pattern = pattern;
        this.eidtItem = eidtItem;
    }

    public void createControl(Composite parent) {
        createCallControl(parent);
        setPageComplete(false);
    }

    private void createCallControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);

        title = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        title.setLayoutData(gd);

        createPatternsMethodsArea(container);
        createVariablesArea(container);
        setControl(container);
    }

    private void createPatternsMethodsArea(Composite container) {
        text = new Text(container, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 550;
        text.setLayoutData(gd);
        text.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {

                if (selectKind != CallTypeEnum.SUPERPATTERN_CALL) {
                    checkListAreaExist(text.getText());
                }
            }
        });
        Label label = new Label(container, SWT.NONE);
        label.setText(Messages.ChooseCallPage_label_text);

        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 60;
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        parentTableViewer = new TableViewer(listTable);
        parentTableViewer.setContentProvider(new CommonListContentProvider());
        parentTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkParentTableSelect();
                if (selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
                    if (isPageComplete()) {
                        checkChildTableSelect();
                    }
                }
            }
        });

        parentTableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (selectKind == CallTypeEnum.METHOD_CALL || selectKind == CallTypeEnum.PATTERN_CALL) {
                    getSelectionContent();
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

    private void createVariablesArea(Composite container) {
        varParaLabel = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        varParaLabel.setLayoutData(gd);
        varParaLabel.setText(Messages.ChooseCallPage_patternInjectCall_title);

        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 60;
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        childTableViewer = new TableViewer(listTable);
        childTableViewer.setLabelProvider(new PatternSelectionLabelProvider());
        childTableViewer.setContentProvider(new CommonListContentProvider());
        childTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkChildTableSelect();
                if (isPageComplete()) {
                    checkParentTableSelect();
                }
            }
        });

        childTableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
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
        if (eidtItem != null) {
            if (selectKind == CallTypeEnum.METHOD_CALL && eidtItem instanceof MethodCall) {
                MethodCall call = (MethodCall) eidtItem;
                PatternMethod called = call.getCalled();
                setSelectValue(called, null);

            } else if (selectKind == CallTypeEnum.PATTERN_CALL && eidtItem instanceof PatternCall) {
                PatternCall call = (PatternCall) eidtItem;
                Pattern called = call.getCalled();
                setSelectValue(called, null);

            } else if (selectKind == CallTypeEnum.PATTERNINJECTED_CALL && eidtItem instanceof PatternInjectedCall) {
                PatternInjectedCall call = (PatternInjectedCall) eidtItem;
                Pattern called = call.getCalled();
                PatternVariable context = call.getContext();
                setSelectValue(called, context);

            } else if (selectKind == CallTypeEnum.SUPERPATTERN_CALL && eidtItem instanceof SuperPatternCall) {

            }
        }
    }

    /**
     * Set the default select value if has been found in table.
     */
    private void setSelectValue(Object called, Object context) {
        if (called != null) {
            TableItem[] parentItems = parentTableViewer.getTable().getItems();
            for (int i = 0; i < parentItems.length; i++) {
                Object currentData = parentItems[i].getData();
                if (currentData.equals(called)) {
                    parentTableViewer.getTable().select(i);
                    setTextValue(called);
                    if (selectKind == CallTypeEnum.METHOD_CALL || selectKind == CallTypeEnum.PATTERN_CALL) {
                        checkParentTableSelect();
                        return;
                    } else if (selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
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
            text.setText(patternMethod.getName());
        } else if (called instanceof Pattern) {
            Pattern pattern = (Pattern) called;
            text.setText(pattern.getName());
        }
    }

    /**
     * Select the default context in child table if has been found.
     */
    private void setChildTableSelectValue(Object called, Object context) {
        if (context != null) {
            TableItem[] childItems = childTableViewer.getTable().getItems();
            for (int i = 0; i < childItems.length; i++) {
                Object currentData = childItems[i].getData();
                if (currentData.equals(context)) {
                    childTableViewer.getTable().select(i);
                    checkChildTableSelect();
                    return;
                }
            }
        }
    }

    /**
     * Get the kind of call.
     */
    public void setVisible(boolean visible) {
        if (visible) {
            if (getPreviousPage() != null) {
                selectKind = ((ChooseKindPage) getPreviousPage()).getKind();
            } else {
                selectKind = ((OrchestrationWizard) getWizard()).getDefaultKind();
            }
            updateTable(selectKind);
        }
        super.setVisible(visible);
        setDefaultSelectValue();
    }

    /**
     * Refresh the page style by kind of call.
     */
    private void updateTable(CallTypeEnum kind) {
        if (kind == CallTypeEnum.METHOD_CALL) {
            if (kind != oldKind) {
                parentTableViewer.setLabelProvider(new MethodLabelProvider(getParentMethods()));
                updateTableInput(getMethods(), null, true, false);
            }
            title.setText(Messages.ChooseCallPage_methodCall_title);
        } else {
            parentTableViewer.setLabelProvider(new PatternSelectionLabelProvider());
        }

        if (kind == CallTypeEnum.PATTERN_CALL) {
            if (kind != oldKind) {
                updateTableInput(getPatterns(), null, true, false);
            }
            title.setText(Messages.ChooseCallPage_patternCall_title);
        }

        if (kind == CallTypeEnum.PATTERNINJECTED_CALL) {
            if (kind != oldKind) {
                updateTableInput(getPatterns(), getVariables(pattern), true, true);
            }
            title.setText(Messages.ChooseCallPage_patternCall_title);
        }

        if (kind == CallTypeEnum.SUPERPATTERN_CALL) {
            updateTableInput(null, null, false, false);
            if (kind != oldKind) {
                title.setText(Messages.ChooseCallPage_superPatternCall_title);
            }
        }
        oldKind = kind;
    }

    private void redrawControl(boolean exclude) {
        Table table = childTableViewer.getTable();
        GridData tableLayoutData = (GridData) table.getLayoutData();
        tableLayoutData.exclude = exclude;
        table.getParent().layout();

        GridData labelLayoutData = (GridData) varParaLabel.getLayoutData();
        labelLayoutData.exclude = exclude;
        varParaLabel.getParent().layout();
    }

    /**
     * Get the pattern's parent methods.
     */
    private List<String> getParentMethods() {
        List<String> parentMethods = new ArrayList<String>();
        Pattern parent = pattern == null ? null : pattern.getSuperPattern();
        if (parent != null) {
            for (PatternMethod patternMethod : parent.getMethods()) {
                String name = patternMethod.getName();
                parentMethods.add(name);
            }
        }
        return parentMethods;
    }

    /**
     * While change the call type,update the table input.
     */
    private void updateTableInput(List<?> parentTableInput, List<?> childTableInput, boolean parentTableEnable, boolean childTableEnable) {
        parentTableViewer.setInput(null);
        parentTableViewer.setInput(parentTableInput);
        childTableViewer.setInput(childTableInput);
        parentTableViewer.getTable().setEnabled(parentTableEnable);
        childTableViewer.getTable().setEnabled(childTableEnable);
        redrawControl(!childTableEnable);
        text.setText(""); //$NON-NLS-1$
        if (selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
            checkChildTableSelect();
        }
        checkParentTableSelect();
    }

    private void checkParentTableSelect() {
        int selectionIndex = parentTableViewer.getTable().getSelectionIndex();
        if (selectionIndex == -1) {
            String errorMessage = Messages.ChooseCallPage_no_call_selected_error_message;
            updateMessage(errorMessage);
        } else {
            updateMessage(null);
        }
    }

    private void checkChildTableSelect() {
        int selectionIndex = childTableViewer.getTable().getSelectionIndex();
        if (selectionIndex == -1) {
            String errorMessage = Messages.ChooseCallPage_no_variable_selected_error_message;
            updateMessage(errorMessage);
        } else {
            updateMessage(null);
        }
    }

    private void updateMessage(String message) {
        setMessage(message, 3);
        if ("".equals(message) || message == null) { //$NON-NLS-1$
            getSelectionContent();
            setPageComplete(true);
        } else {
            setPageComplete(false);
        }
    }

    private List<PatternMethod> getMethods() {
        List<PatternMethod> parentMethods = new ArrayList<PatternMethod>();
        EList<PatternMethod> allMethods = pattern.getAllMethods();
        if (allMethods != null) {
            for (PatternMethod method : allMethods) {
                String name = method.getName();
                if (!(Messages.ImplementationPage_header.equals(name) || Messages.ImplementationPage_init.equals(name) || Messages.ImplementationPage_footer.equals(name))) {
                    parentMethods.add(method);
                }
            }
        }
        return parentMethods;
    }

    private List<Pattern> getPatterns() {
        Set<Pattern> patterns = PatternHelper.TRANSACTIONNAL_COLLECTOR.getAllPatterns();
        List<Pattern> parentMethods = new ArrayList<Pattern>();
        parentMethods.addAll(patterns);
        return parentMethods;
    }

    private List<PatternVariable> getVariables(Pattern pattern) {
        EList<PatternVariable> allVariables = pattern.getAllVariables();
        return allVariables;
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
        switch (selectKind) {
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
        List callsNew = new ArrayList();
        if (!"".equals(name)) { //$NON-NLS-1$
            String currentName = ""; //$NON-NLS-1$
            for (Object currentItemData : input) {
                if (selectKind == CallTypeEnum.METHOD_CALL) {
                    if (currentItemData instanceof PatternMethod) {
                        currentName = ((PatternMethod) currentItemData).getName().toLowerCase();
                    }
                } else if (selectKind == CallTypeEnum.PATTERN_CALL || selectKind == CallTypeEnum.PATTERNINJECTED_CALL) {
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
        parentTableViewer.setInput(callsNew);
        return callsNew;
    }

    /**
     * Get the selection content.
     */
    protected void getSelectionContent() {
        int selectParentTableIndex = parentTableViewer.getTable().getSelectionIndex();
        if (selectParentTableIndex >= 0) {
            Object selectParentItem = parentTableViewer.getElementAt(selectParentTableIndex);
            switch (selectKind) {
            case METHOD_CALL:
                PatternMethod patternMethod = (PatternMethod) selectParentItem;
                MethodCall methodCall = PatternFactory.eINSTANCE.createMethodCall();
                methodCall.setCalled(patternMethod);
                selectCall = methodCall;
                return;
            case PATTERN_CALL:
                Pattern patternKind_1 = (Pattern) selectParentItem;
                PatternCall patternCall = PatternFactory.eINSTANCE.createPatternCall();
                patternCall.setCalled(patternKind_1);
                selectCall = patternCall;
                return;
            case PATTERNINJECTED_CALL:
                Pattern patternKind_2 = (Pattern) selectParentItem;
                PatternInjectedCall patternInjectedCall = PatternFactory.eINSTANCE.createPatternInjectedCall();
                patternInjectedCall.setCalled(patternKind_2);
                // Get the select PatternVariable.
                int selectChildTableIndex = childTableViewer.getTable().getSelectionIndex();
                Object selectChildItem = childTableViewer.getElementAt(selectChildTableIndex);
                if (selectChildItem instanceof PatternVariable) {
                    PatternVariable patternVariable = (PatternVariable) selectChildItem;
                    patternInjectedCall.setContext(patternVariable);
                }
                selectCall = patternInjectedCall;
                return;
            case SUPERPATTERN_CALL:
                // TODO:superPatternCall there is nothing to do.
                return;
            }
        }
    }

    /**
     * Return the selection content.
     */
    public Call getChooseCallPage() {
        return selectCall;
    }
}
