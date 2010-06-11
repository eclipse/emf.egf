/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.models.QueryContent;
import org.eclipse.egf.pattern.ui.editors.modifiers.QueryContentTableCellModifier;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.QueryContentTableLabelProvider;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ParametersEditDialog extends VariablesEditDialog {

    private Combo queryCombo;

    private String query;

    private Query itemQuery;

    private TableViewer tableViewer;

    private Button add;

    private Button remove;

    public static final String KEY_ID = "key"; //$NON-NLS-1$

    public static final String VALUE_ID = "value"; //$NON-NLS-1$

    private List<QueryContent> queryContents;

    public ParametersEditDialog(Shell shell, PatternParameter selectItem, TransactionalEditingDomain editingDomain) {
        super(shell, selectItem, editingDomain);
        setDefaultQuery(selectItem);
    }

    private void setDefaultQuery(PatternParameter selectItem) {
        if (selectItem != null) {
            itemQuery = selectItem.getQuery();
            query = itemQuery == null ? "" : itemQuery.getExtensionId(); //$NON-NLS-1$
            QueryKind queryKind = IQuery.INSTANCE.getQueryKind(query);
            if (queryKind != null) {
                query = queryKind.getName();
            }
        }
    }

    protected Control createDialogArea(Composite parent) {
        Composite dialogArea = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        dialogArea.setLayout(layout);

        createLabel(dialogArea, Messages.ParametersEditDialog_Query);
        queryCombo = new Combo(dialogArea, SWT.NONE | SWT.READ_ONLY);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        queryCombo.setLayoutData(gd);
        queryCombo.add(query);
        setQueryComboList(queryCombo, query);
        queryCombo.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                query = queryCombo.getText();
            }
        });
        queryCombo.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                setQueryContentAreaStatus();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        queryCombo.select(0);
        setQueryContentArea(dialogArea);
        setQueryContentAreaStatus();
        setButtonsStatus();
        return dialogArea;
    }

    private void createQueryContentTable(Composite parent) {
        Composite tableComp = new Composite(parent, SWT.NONE);
        TableColumnLayout layout = new TableColumnLayout();
        tableComp.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 2;
        gd.heightHint = 100;
        gd.widthHint = 400;
        tableComp.setLayoutData(gd);

        Table table = new Table(tableComp, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 130;
        table.setLayoutData(gd);

        tableViewer = new TableViewer(table);
        int[] colWidths = {
                110, 200
        };
        String[] colNames = {
                Messages.ParametersEditDialog_Key_title, Messages.ParametersEditDialog_Value_title
        };
        for (int i = 0; i < colWidths.length; i++) {
            TableColumn tableColumn = new TableColumn(table, SWT.NONE);
            tableColumn.setWidth(colWidths[i]);
            tableColumn.setText(colNames[i]);
            layout.setColumnData(tableColumn, new ColumnWeightData(colWidths[i], true));
        }

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                checkKeyDuplicate();
                setButtonsStatus();
            }
        });
        initTableEditor();
        tableViewer.setContentProvider(new CommonListContentProvider());
        tableViewer.setLabelProvider(new QueryContentTableLabelProvider());
        getInitTableInput();
        tableViewer.setInput(queryContents);
    }

    private void initTableEditor() {
        tableViewer.setColumnProperties(new String[] {
                KEY_ID, VALUE_ID
        });
        final TextCellEditor stringEditor = new TextCellEditor(tableViewer.getTable());
        tableViewer.setCellEditors(new CellEditor[] {
                stringEditor, stringEditor
        });

        QueryContentTableCellModifier modifier = new QueryContentTableCellModifier(tableViewer);
        tableViewer.setCellModifier(modifier);
    }

    private void setQueryContentArea(Composite parent) {
        Label queryContextLabel = createLabel(parent, Messages.ParametersEditDialog_query_context_label);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 3;
        queryContextLabel.setLayoutData(gd);

        createQueryContentTable(parent);
        createQueryContentButtons(parent);
    }

    private void createQueryContentButtons(Composite parent) {
        Composite buttons = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 40;

        add = new Button(buttons, SWT.PUSH);
        add.setImage(Activator.getDefault().getImage(ImageShop.IMG_ADD_OBJ));
        add.setToolTipText(Messages.SpecificationPage_button_add);
        add.setLayoutData(gd);
        add.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeAdd();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        remove = new Button(buttons, SWT.PUSH);
        remove.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
        remove.setToolTipText(Messages.SpecificationPage_button_remove);
        remove.setLayoutData(gd);
        remove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeRemove();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    /**
     * Add a new entry for the content of a Map<String,String>.
     */
    private void executeAdd() {
        String key = KEY_ID;
        String value = VALUE_ID;
        QueryContent newContent = new QueryContent(key, value);
        if (queryContents == null) {
            queryContents = new ArrayList<QueryContent>();
        }
        queryContents.add(newContent);
        tableViewer.setInput(queryContents);
        tableViewer.getTable().setSelection(tableViewer.getTable().getItemCount() - 1);
        checkKeyDuplicate();
        setButtonsStatus();
    }

    /**
     * Remove a entry from the content of a Map<String,String>.
     */
    private void executeRemove() {
        int selectionIndex = tableViewer.getTable().getSelectionIndex();
        QueryContent selectItem = getSelectItem();
        if (queryContents != null) {
            queryContents.remove(selectItem);
        }
        tableViewer.setInput(queryContents);

        int itemCount = tableViewer.getTable().getItemCount();
        if (selectionIndex < itemCount) {
            tableViewer.getTable().setSelection(selectionIndex);
        } else {
            tableViewer.getTable().setSelection(selectionIndex - 1);
        }
        setButtonsStatus();
    }

    /**
     * Get the select item of table.
     */
    private QueryContent getSelectItem() {
        int selectionIndex = tableViewer.getTable().getSelectionIndex();
        Object element = tableViewer.getElementAt(selectionIndex);
        if (element instanceof QueryContent) {
            return (QueryContent) element;
        }
        return null;
    }

    private void setButtonsStatus() {
        if (getSelectItem() == null) {
            remove.setEnabled(false);
        } else {
            remove.setEnabled(true);
        }
    }

    private void getInitTableInput() {
        queryContents = new ArrayList<QueryContent>();
        if (itemQuery != null) {
            EMap<String, String> queryContext = itemQuery.getQueryContext();
            Set<String> keySet = queryContext.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = queryContext.get(key);
                QueryContent content = new QueryContent(key, value);
                queryContents.add(content);
            }
        }
    }

    private void setQueryComboList(Combo combo, String query) {
        List<QueryKind> availableQueries = IQuery.INSTANCE.getAvailableQueries();
        for (QueryKind kind : availableQueries) {
            String name = kind.getName();
            if (!name.equals(query)) {
                combo.add(name);
            }
        }
        if (query != null && !"".equals(query)) {
            combo.add("");
        }
    }

    private void checkKeyDuplicate() {
        IStatus fLastStatusErr = new Status(IStatus.ERROR, JavaCore.PLUGIN_ID, -1, Messages.ParametersEditDialog_duplicate_key_error_message, null);
        IStatus fLastStatusOk = new Status(IStatus.OK, Policy.JFACE, IStatus.OK, Util.ZERO_LENGTH_STRING, null);
        if (PatternUIHelper.hasDuplicateKey(queryContents)) {
            updateStatus(fLastStatusErr);
        } else {
            updateStatus(fLastStatusOk);
        }

    }

    private void setQueryContentAreaStatus() {
        String query = getQuery();
        if (query != null && !"".equals(query)) { //$NON-NLS-1$
            setQueryContentAreaEnable(true);
        } else {
            setQueryContentAreaEnable(false);
            queryContents = new ArrayList<QueryContent>();
            tableViewer.setInput(queryContents);
        }
    }

    private void setQueryContentAreaEnable(boolean isEnable) {
        add.setEnabled(isEnable);
        remove.setEnabled(isEnable);
        tableViewer.getTable().setEnabled(isEnable);
    }

    public List<QueryContent> getQueryContents() {
        return queryContents;
    }

    public String getQuery() {
        return query;
    }
}
