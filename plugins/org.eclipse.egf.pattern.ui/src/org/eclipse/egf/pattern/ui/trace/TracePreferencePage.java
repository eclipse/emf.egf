/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.ui.trace;

import org.eclipse.egf.core.trace.Category;
import org.eclipse.egf.core.trace.Configuration;
import org.eclipse.egf.core.trace.Filter;
import org.eclipse.egf.core.trace.TraceFactory;
import org.eclipse.egf.pattern.trace.TraceHelper;
import org.eclipse.egf.pattern.trace.TraceState;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author Thomas Guiu
 */
public class TracePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
    private TableViewer filterViewer;
    private CheckboxTableViewer categoryViewer;
    private Button addFilterButton;
    private Button delFilterButton;
    private Button addCategoryButton;
    private Button delCategoryButton;
    private boolean enableSubControl = false;
    private Configuration configuration;
    private Button noneBtn;
    private Button belowBtn;
    private Button alwaysBtn;

    public TracePreferencePage() {
        super();
        setTitle(Messages.TracePreferencePage_Title);
        setDescription(Messages.TracePreferencePage_Description);
    }

    @Override
    protected void performDefaults() {
        super.performDefaults();
    }

    @Override
    public boolean performOk() {
        final boolean performOk = super.performOk();
        if (performOk) {
            try {
                TraceState state = null;
                if (belowBtn.getSelection())
                    state = TraceState.FILTERS;
                else if (alwaysBtn.getSelection())
                    state = TraceState.ALWAYS;
                else
                    state = TraceState.NEVER;
                TraceHelper.PREFERENCES.save(state, configuration);
            } catch (Exception e) {
                Activator.getDefault().logError(e);
                MessageDialog.openError(getShell(), Messages.TracePreferencePage_Save_Error_Title, Messages.TracePreferencePage_Save_Error_Message);
                return false;
            }
        }
        return performOk;
    }

    public void init(IWorkbench workbench_p) {
    }

    protected void createFilterControl(Composite parent) {
        Label label = new Label(parent, SWT.None);
        label.setText(Messages.TracePreferencePage_Label_5);
        GridData layoutData = new GridData(GridData.FILL_BOTH);
        layoutData.horizontalSpan = 2;
        label.setLayoutData(layoutData);

        filterViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        final Table table = filterViewer.getTable();
        TableLayout layout = new TableLayout();
        table.setLayout(layout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        layoutData = new GridData(GridData.FILL_BOTH);
        layoutData.minimumHeight = 200;
        table.setLayoutData(layoutData);

        TableViewerColumn commentColumn = new TableViewerColumn(filterViewer, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, 100, true));
        commentColumn.getColumn().setText(Messages.TracePreferencePage_Label_1);
        commentColumn.getColumn().setResizable(true);
        commentColumn.getColumn().setData(0);
        commentColumn.setEditingSupport(new StringEditingSupport(filterViewer, Filter.class, "comment"));

        TableViewerColumn patternColumn = new TableViewerColumn(filterViewer, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, 100, true));
        patternColumn.getColumn().setText(Messages.TracePreferencePage_Label_2);
        patternColumn.getColumn().setResizable(true);
        patternColumn.getColumn().setData(0);
        patternColumn.setEditingSupport(new StringEditingSupport(filterViewer, Filter.class, "pattern"));

        filterViewer.setLabelProvider(new TraceFilterLabelProvider());
        filterViewer.setContentProvider(new TraceContentProvider());

        filterViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                final ISelection selection = event.getSelection();
                if (selection.isEmpty())
                    return;
                setButtonStates();
            }

        });

        Button[] buttons = createButtonBar(parent);
        addFilterButton = buttons[0];
        addFilterButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                final Category input = (Category) filterViewer.getInput();
                // if (input == null)
                final Filter filter = TraceFactory.eINSTANCE.createFilter();
                filter.setComment("");
                input.getFilters().add(filter);
                filterViewer.refresh();
                setButtonStates();
            }
        });
        delFilterButton = buttons[1];
        delFilterButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection ss = (IStructuredSelection) filterViewer.getSelection();
                for (Object obj : ss.toArray()) {
                    Filter filter = (Filter) obj;
                    EcoreUtil.delete(filter);
                }
                filterViewer.refresh();
                setButtonStates();
            }
        });

    }

    protected void createCategoryControl(Composite parent) {
        Label label = new Label(parent, SWT.None);
        label.setText(Messages.TracePreferencePage_Label_6);
        GridData layoutData = new GridData(GridData.FILL_BOTH);
        layoutData.horizontalSpan = 2;
        label.setLayoutData(layoutData);

        categoryViewer = CheckboxTableViewer.newCheckList(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.SINGLE);

        final Table table = categoryViewer.getTable();
        TableLayout layout = new TableLayout();
        table.setLayout(layout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        layoutData = new GridData(GridData.FILL_BOTH);
        layoutData.minimumHeight = 200;
        table.setLayoutData(layoutData);

        TableViewerColumn idColumn = new TableViewerColumn(categoryViewer, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, 100, true));
        idColumn.getColumn().setText(Messages.TracePreferencePage_Label_3);
        idColumn.getColumn().setResizable(true);
        idColumn.getColumn().setData(0);

        TableViewerColumn nameColumn = new TableViewerColumn(categoryViewer, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, 100, true));
        nameColumn.getColumn().setText(Messages.TracePreferencePage_Label_4);
        nameColumn.getColumn().setResizable(true);
        nameColumn.getColumn().setData(0);
        nameColumn.setEditingSupport(new StringEditingSupport(categoryViewer, Category.class, "name"));

        categoryViewer.setLabelProvider(new TraceCategoryLabelProvider());
        categoryViewer.setContentProvider(new TraceContentProvider());
        categoryViewer.setCheckStateProvider(new ICheckStateProvider() {

            public boolean isChecked(Object element) {
                if (element instanceof Category)
                    return ((Category) element).isActive();
                return false;
            }

            public boolean isGrayed(Object element) {

                return false;
            }

        });
        categoryViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                final ISelection selection = event.getSelection();
                if (selection.isEmpty())
                    return;
                filterViewer.setInput(((IStructuredSelection) selection).getFirstElement());
                setButtonStates();
            }

        });
        categoryViewer.addCheckStateListener(new ICheckStateListener() {

            public void checkStateChanged(CheckStateChangedEvent event) {
                final Category element = (Category) event.getElement();
                element.setActive(event.getChecked());
            }
        });

        final Button[] buttons = createButtonBar(parent);
        addCategoryButton = buttons[0];
        addCategoryButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                final Category cat = TraceFactory.eINSTANCE.createCategory();
                cat.setName("name");
                configuration.getCategories().add(cat);
                categoryViewer.refresh();
                categoryViewer.setSelection(new StructuredSelection(cat), true);
            }
        });
        delCategoryButton = buttons[1];
        delCategoryButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection ss = (IStructuredSelection) categoryViewer.getSelection();
                for (Object obj : ss.toArray()) {
                    Category cat = (Category) obj;
                    EcoreUtil.delete(cat);
                }
                categoryViewer.refresh();
                filterViewer.setInput(null);
                setButtonStates();
            }
        });

    }

    protected Button[] createButtonBar(Composite parent) {
        Composite buttonBar = new Composite(parent, SWT.None);
        buttonBar.setLayoutData(new GridData());
        buttonBar.setLayout(new FillLayout(SWT.VERTICAL));
        Button addBtn = new Button(buttonBar, SWT.PUSH);
        addBtn.setImage(Activator.getDefault().getImage(ImageShop.IMG_ADD_OBJ));
        Button delBtn = new Button(buttonBar, SWT.PUSH);
        delBtn.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
        return new Button[] { addBtn, delBtn };
    }

    protected Composite createComposite(Composite parent, int columns) {
        parent = new Composite(parent, SWT.None);
        parent.setLayoutData(new GridData(GridData.FILL_BOTH));
        GridLayout glayout = new GridLayout();
        glayout.numColumns = columns;
        parent.setLayout(glayout);
        return parent;
    }

    private void setButtonStates() {
        addCategoryButton.setEnabled(enableSubControl);
        delCategoryButton.setEnabled(enableSubControl && !categoryViewer.getSelection().isEmpty());

        addFilterButton.setEnabled(enableSubControl && !categoryViewer.getSelection().isEmpty());
        delFilterButton.setEnabled(enableSubControl && !filterViewer.getSelection().isEmpty());

        categoryViewer.getTable().setEnabled(enableSubControl);
        filterViewer.getTable().setEnabled(enableSubControl);
    }

    @Override
    protected Control createContents(Composite parent) {

        Group grp = new Group(parent, SWT.BORDER);
        grp.setText(Messages.TracePreferencePage_Label_7);
        grp.setLayout(new GridLayout());
        grp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        createRadioButtons(grp);

        createCategoryControl(createComposite(parent, 2));
        createFilterControl(createComposite(parent, 2));

        init();

        setButtonStates();
        return parent;
    }

    private void init() {
        try {
            switch (TraceHelper.PREFERENCES.loadState()) {
            case ALWAYS:
                alwaysBtn.setSelection(true);
                break;
            case FILTERS:
                belowBtn.setSelection(true);
                enableSubControl = belowBtn.getSelection();
                break;
            case NEVER:
                noneBtn.setSelection(true);
                break;
            }
            configuration = TraceHelper.PREFERENCES.loadConfiguration();
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            MessageDialog.openError(getShell(), Messages.TracePreferencePage_Load_Error_Title, Messages.TracePreferencePage_Load_Error_Message);
            configuration = TraceFactory.eINSTANCE.createConfiguration();
        }
        categoryViewer.setInput(configuration);

    }

    protected void createRadioButtons(Group grp) {
        final SelectionListener listener = new MySelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                enableSubControl = TraceState.FILTERS.equals(e.widget.getData());
                setButtonStates();
            }

        };

        alwaysBtn = new Button(grp, SWT.RADIO);
        alwaysBtn.setText(Messages.TracePreferencePage_Label_8);
        alwaysBtn.setData(TraceState.ALWAYS);
        alwaysBtn.addSelectionListener(listener);
        alwaysBtn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        belowBtn = new Button(grp, SWT.RADIO);
        belowBtn.setText(Messages.TracePreferencePage_Label_9);
        belowBtn.setData(TraceState.FILTERS);
        belowBtn.addSelectionListener(listener);
        belowBtn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        noneBtn = new Button(grp, SWT.RADIO);
        noneBtn.setText(Messages.TracePreferencePage_Label_10);
        noneBtn.setData(TraceState.NEVER);
        noneBtn.addSelectionListener(listener);
        noneBtn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    }

    private class MySelectionListener implements SelectionListener {
        public void widgetSelected(SelectionEvent e) {
        }

        public void widgetDefaultSelected(SelectionEvent e) {
        }
    }

}