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
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.editors.providers.MethodCallContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.MethodCallLabelProviders;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
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

    private int kind;

    private int oldKind = -1;

    private Pattern pattern;

    private TableViewer parentTableViewer;

    private TableViewer childTableViewer;

    private List<?> childTableInput;

    private Call selectCall;

    private Label title;

    private Text text;

    private Label varParaLabel;
    
    // Record the table item's index which should set up a decoration.
    private List<Integer> docoIndex;

    public ChooseCallPage(Pattern pattern, ISelection selection) {
        super("ChooseToCall");
        setTitle("ChooseToCall");
        setDescription("Choose a method or pattern to call.");
        this.pattern = pattern;
    }

    public void createControl(Composite parent) {
        createMetodCall(parent);
        setPageComplete(false);
    }

    private void createMetodCall(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);

        title = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        title.setLayoutData(gd);

        createListArea(container);
        createVarParaArea(container);
        setControl(container);
    }

    private void createListArea(Composite container) {
        text = new Text(container, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 550;
        text.setLayoutData(gd);
        text.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                if (kind != 3) {
                    checkListAreaExist(text.getText());
                }
                childTableViewer.setInput(null);
            }
        });
        Label label = new Label(container, SWT.NONE);
        label.setText("Matching items:");

        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        parentTableViewer = new TableViewer(listTable);
        parentTableViewer.setLabelProvider(new MethodCallLabelProviders());
        parentTableViewer.setContentProvider(new MethodCallContentProvider());
        parentTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                if (kind == 2) {
                    getChildTableInput();
                } else {
                    setPageComplete(true);
                }
                getSelectionContent();
            }
        });
    }

    protected void getChildTableInput() {
        int index = parentTableViewer.getTable().getSelectionIndex();
        if (index >= 0) {
            Object selectItem = parentTableViewer.getElementAt(index);
            if (selectItem instanceof Pattern) {
                childTableInput = getVariables((Pattern) selectItem);
                childTableViewer.setInput(childTableInput);
            }
        }
    }

    private void createVarParaArea(Composite container) {
        varParaLabel = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        varParaLabel.setLayoutData(gd);

        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        childTableViewer = new TableViewer(listTable);

        childTableViewer.setLabelProvider(new MethodCallLabelProviders());
        childTableViewer.setContentProvider(new MethodCallContentProvider());
        childTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                setPageComplete(true);
                getSelectionContent();
            }
        });
    }

    public void setVisible(boolean visible) {
        if (visible) {
            kind = ((ChooseKindPage) getPreviousPage()).getKind();
            updateTable(kind);
        }
        super.setVisible(visible);
    }

    private void updateTable(int kind) {
        if (kind == 0) {
            if (kind != oldKind) {
                updateTableInput(getMethods(), null, true, false);
                setDecoration();
            }
            title.setText("Choose a method to call:");
            varParaLabel.setText("");
        } else if (kind == 1) {
            if (kind != oldKind) {
                updateTableInput(getPatterns(), null, true, false);
            }
            title.setText("Choose a pattern to call:");
            varParaLabel.setText("");
        } else if (kind == 2) {
            if (kind != oldKind) {
                updateTableInput(getPatterns(), null, true, true);
            }
            title.setText("Choose a pattern to call:");
            varParaLabel.setText("Choose the context object to inject:");
        } else if (kind == 3) {
            updateTableInput(null, null, false, false);
            if (kind != oldKind) {
                title.setText("Choose a superPattern to call:");
                varParaLabel.setText("");
            }
        }
        oldKind = kind;
    }

    private void updateTableInput(List<?> parentTableInput, List<?> childTableInput, boolean parentTableEnable, boolean childTableEnable) {
        parentTableViewer.setInput(null);
        parentTableViewer.setInput(parentTableInput);
        if (kind != 2) {
            childTableViewer.setInput(childTableInput);
        }
        parentTableViewer.getTable().setEnabled(parentTableEnable);
        childTableViewer.getTable().setEnabled(childTableEnable);
        text.setText("");
        setPageComplete(false);
    }

    private void setDecoration() {
        if (docoIndex != null) {
            for (int i = 0; i < docoIndex.size(); i++) {
                parentTableViewer.getTable().getItem(docoIndex.get(i)).setImage(ImageShop.get(ImageShop.IMG_OVER_OBJ));
            }
        }
    }

    private List<PatternMethod> getMethods() {
        List<PatternMethod> parentMethods = new ArrayList<PatternMethod>();
        docoIndex = new ArrayList<Integer>();
        int index = 0;
        for (PatternMethod method : pattern.getMethods()) {
            parentMethods.add(method);
            index++;
        }
        Pattern parent = pattern.getSuperPattern();
        if (parent != null) {
            for (PatternMethod parentMethod : parent.getMethods()) {
                parentMethods.add(parentMethod);
                docoIndex.add(index);
                index++;
            }
        }
        return parentMethods;
    }

    private List<Pattern> getPatterns() {
        Set<Pattern> patterns = PatternHelper.getAllPatterns();
        List<Pattern> parentMethods = new ArrayList<Pattern>();
        for (Pattern pattern : patterns) {
            parentMethods.add(pattern);
        }
        return parentMethods;
    }

    private List getVariables(Pattern parent) {
        List variables = new ArrayList<String>();
        if (parent.getAllVariables() != null) {
            for (PatternVariable patternVariable : parent.getAllVariables()) {
                variables.add(patternVariable);
            }
        }
        return variables;
    }

    private void checkListAreaExist(String name) {
        if ("".equals(name)) {
            int len = parentTableViewer.getTable().getItems().length;
            if (len <= 0) {
                setPageComplete(false);
            }
        } else if (getListAreaDisplay(name).size() <= 0) {
            setPageComplete(false);
        }
    }

    private List getListAreaDisplay(String name) {
        List methodCallsNew = new ArrayList();
        TableItem[] items = parentTableViewer.getTable().getItems();
        String currentName = "";
        for (TableItem item : items) {
            Object currentItemData = item.getData();
            if (kind == 0) {
                if (currentItemData instanceof PatternMethod) {
                    currentName = ((PatternMethod) currentItemData).getName().toLowerCase();
                }
            } else if (kind == 1) {
                if (currentItemData instanceof Pattern) {
                    currentName = ((Pattern) currentItemData).getName().toLowerCase();
                }
            }
            if (currentName.equals(name)) {
                methodCallsNew.add(currentItemData);
            }
        }
        parentTableViewer.setInput(methodCallsNew);
        return methodCallsNew;
    }

    /**
     * Get the selection content.
     */
    protected void getSelectionContent() {
        int selectParentTableIndex = parentTableViewer.getTable().getSelectionIndex();
        if (selectParentTableIndex >= 0) {
            Object selectParentItem = parentTableViewer.getElementAt(selectParentTableIndex);
            switch (kind) {
            case 0:
                PatternMethod patternMethod = (PatternMethod) selectParentItem;
                MethodCall methodCall = PatternFactory.eINSTANCE.createMethodCall();
                methodCall.setCalled(patternMethod);
                selectCall = methodCall;
                return;
            case 1:
                Pattern patternKind_1 = (Pattern) selectParentItem;
                PatternCall patternCall = PatternFactory.eINSTANCE.createPatternCall();
                patternCall.setCalled(patternKind_1);
                selectCall = patternCall;
                return;
            case 2:
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
            case 3:
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
