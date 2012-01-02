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
import org.eclipse.emf.common.util.EList;
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
    private Button upFilterButton;
    private Button downFilterButton;
    private Button addCategoryButton;
    private Button duplicateCategoryButton;
    private Button delCategoryButton;
    private Button upCategoryButton;
    private Button downCategoryButton;
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
        configuration = TraceHelper.PREFERENCES.getDefaultConfiguration();
        categoryViewer.setInput(configuration);
        filterViewer.setInput(null);

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
        commentColumn.getColumn().setToolTipText(Messages.TracePreferencePage_Label_1_tooltip);
        commentColumn.getColumn().setResizable(true);
        commentColumn.getColumn().setData(0);
        commentColumn.setEditingSupport(new StringEditingSupport(filterViewer, Filter.class, "comment"));

        TableViewerColumn patternColumn = new TableViewerColumn(filterViewer, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, 100, true));
        patternColumn.getColumn().setText(Messages.TracePreferencePage_Label_2);
        patternColumn.getColumn().setToolTipText(Messages.TracePreferencePage_Label_2_tooltip);
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
        nameColumn.getColumn().setToolTipText(Messages.TracePreferencePage_Label_4_tooltip);
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
    }

    protected void createCategoryButtonBar(Composite parent) {
        Composite buttonBar = new Composite(parent, SWT.None);
        buttonBar.setLayoutData(new GridData());
        buttonBar.setLayout(new FillLayout(SWT.VERTICAL));
        addCategoryButton = new Button(buttonBar, SWT.PUSH);
        addCategoryButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_ADD_OBJ));
        addCategoryButton.setToolTipText(Messages.TracePreferencePage_Label_11_tooltip);
        addCategoryButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                final Category cat = TraceFactory.eINSTANCE.createCategory();
                cat.setName("name");
                configuration.getCategories().add(cat);
                categoryViewer.refresh();
                categoryViewer.setSelection(new StructuredSelection(cat), true);
            }
        });
        duplicateCategoryButton = new Button(buttonBar, SWT.PUSH);
        duplicateCategoryButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_COPY_OBJ));
        duplicateCategoryButton.setToolTipText(Messages.TracePreferencePage_Label_12_tooltip);
        duplicateCategoryButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                Category source = (Category) ((IStructuredSelection) categoryViewer.getSelection()).getFirstElement();
                final Category catCopy = TraceFactory.eINSTANCE.createCategory();
                catCopy.setName("Copy of " + source.getName());
                catCopy.setActive(source.isActive());
                for (Filter sourcefilter : source.getFilters()) {
                    final Filter filter = TraceFactory.eINSTANCE.createFilter();
                    filter.setComment(sourcefilter.getComment());
                    filter.setPattern(sourcefilter.getPattern());
                    catCopy.getFilters().add(filter);
                }
                configuration.getCategories().add(catCopy);
                categoryViewer.refresh();
                categoryViewer.setSelection(new StructuredSelection(catCopy), true);
            }
        });
        delCategoryButton = new Button(buttonBar, SWT.PUSH);
        delCategoryButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
        delCategoryButton.setToolTipText(Messages.TracePreferencePage_Label_13_tooltip);
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
        upCategoryButton = new Button(buttonBar, SWT.PUSH);
        upCategoryButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_UPWARD_OBJ));
        upCategoryButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection ss = (IStructuredSelection) categoryViewer.getSelection();
                Category cat = (Category) ss.getFirstElement();
                final EList<Category> categories = configuration.getCategories();
                final int index = categories.indexOf(cat);
                categories.move(index - 1, cat);
                categoryViewer.refresh();
                setButtonStates();
            }
        });
        downCategoryButton = new Button(buttonBar, SWT.PUSH);
        downCategoryButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_DOWNWARD_OBJ));
        downCategoryButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection ss = (IStructuredSelection) categoryViewer.getSelection();
                Category cat = (Category) ss.getFirstElement();
                final EList<Category> categories = configuration.getCategories();
                final int index = categories.indexOf(cat);
                categories.move(index + 1, cat);
                categoryViewer.refresh();
                setButtonStates();
            }
        });
    }

    protected void createFilterButtonBar(Composite parent) {
        Composite buttonBar = new Composite(parent, SWT.None);
        buttonBar.setLayoutData(new GridData());
        buttonBar.setLayout(new FillLayout(SWT.VERTICAL));
        addFilterButton = new Button(buttonBar, SWT.PUSH);
        addFilterButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_ADD_OBJ));
        addFilterButton.setToolTipText(Messages.TracePreferencePage_Label_14_tooltip);
        addFilterButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                final Category input = (Category) filterViewer.getInput();
                final Filter filter = TraceFactory.eINSTANCE.createFilter();
                filter.setComment("");
                input.getFilters().add(filter);
                filterViewer.refresh();
                setButtonStates();
            }
        });
        delFilterButton = new Button(buttonBar, SWT.PUSH);
        delFilterButton.setToolTipText(Messages.TracePreferencePage_Label_15_tooltip);
        delFilterButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
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
        upFilterButton = new Button(buttonBar, SWT.PUSH);
        upFilterButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_UPWARD_OBJ));
        upFilterButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                Category category = (Category) filterViewer.getInput();
                if (category != null) {
                    IStructuredSelection ss = (IStructuredSelection) filterViewer.getSelection();
                    Filter filter = (Filter) ss.getFirstElement();
                    final EList<Filter> filters = category.getFilters();
                    final int index = filters.indexOf(filter);
                    filters.move(index - 1, filter);
                    filterViewer.refresh();
                    setButtonStates();
                }
            }
        });
        downFilterButton = new Button(buttonBar, SWT.PUSH);
        downFilterButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_DOWNWARD_OBJ));
        downFilterButton.addSelectionListener(new MySelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                Category category = (Category) filterViewer.getInput();
                if (category != null) {
                    IStructuredSelection ss = (IStructuredSelection) filterViewer.getSelection();
                    Filter filter = (Filter) ss.getFirstElement();
                    final EList<Filter> filters = category.getFilters();
                    final int index = filters.indexOf(filter);
                    filters.move(index + 1, filter);
                    filterViewer.refresh();
                    setButtonStates();
                }
            }
        });

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
        IStructuredSelection selection = (IStructuredSelection) categoryViewer.getSelection();
        int size = selection.size();
        addCategoryButton.setEnabled(enableSubControl);
        delCategoryButton.setEnabled(enableSubControl && !selection.isEmpty());
        duplicateCategoryButton.setEnabled(enableSubControl && size == 1);
        upCategoryButton.setEnabled(false);
        downCategoryButton.setEnabled(false);
        if (size == 1) {
            final EList<Category> categories = configuration.getCategories();
            final int nbCategories = categories.size() - 1;
            final int index = categories.indexOf(selection.getFirstElement());
            upCategoryButton.setEnabled(enableSubControl && index > 0);
            downCategoryButton.setEnabled(enableSubControl && index < nbCategories);
        }

        addFilterButton.setEnabled(enableSubControl && !selection.isEmpty());
        delFilterButton.setEnabled(enableSubControl && !filterViewer.getSelection().isEmpty());
        upFilterButton.setEnabled(false);
        downFilterButton.setEnabled(false);
        if (size == 1) {
            Category category = (Category) filterViewer.getInput();
            if (category != null && !filterViewer.getSelection().isEmpty()) {
                final int nbFilters = category.getFilters().size() - 1;
                final int index = category.getFilters().indexOf(((IStructuredSelection) filterViewer.getSelection()).getFirstElement());
                upFilterButton.setEnabled(enableSubControl && index > 0);
                downFilterButton.setEnabled(enableSubControl && index < nbFilters);
            }
        }

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

        Composite categoryComposite = createComposite(parent, 2);
        createCategoryControl(categoryComposite);
        createCategoryButtonBar(categoryComposite);
        Composite filterComposite = createComposite(parent, 2);
        createFilterControl(filterComposite);
        createFilterButtonBar(filterComposite);

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
        alwaysBtn.setToolTipText(Messages.TracePreferencePage_Label_8_tooltip);
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