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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * @author Thomas Guiu
 * 
 */
public class ListBuilderDialog<E, S> extends Dialog {
    protected final IBaseLabelProvider labelProvider;
    protected final IStructuredContentProvider contentProvider;
    protected String displayName;
    protected EList<E> result;
    protected boolean multiLine;

    private List<S> possibleValues;
    private final List<E> currentValues = new ArrayList<E>();

    public ListBuilderDialog(Shell parent, IStructuredContentProvider contentProvider, IBaseLabelProvider labelProvider, List<S> possibleValues, List<E> initialValues) {
        super(parent);
        this.contentProvider = contentProvider;
        this.labelProvider = labelProvider;
        if (possibleValues == null)
            throw new IllegalArgumentException();
        if (labelProvider == null)
            throw new IllegalArgumentException();
        if (contentProvider == null)
            throw new IllegalArgumentException();
        if (initialValues == null)
            throw new IllegalArgumentException();
        this.currentValues.addAll(initialValues);
        this.possibleValues = possibleValues;

    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite contents = (Composite) super.createDialogArea(parent);

        GridLayout contentsGridLayout = (GridLayout) contents.getLayout();
        contentsGridLayout.numColumns = 3;

        GridData contentsGridData = (GridData) contents.getLayoutData();
        contentsGridData.horizontalAlignment = SWT.FILL;
        contentsGridData.verticalAlignment = SWT.FILL;

        Text patternText = null;

        {
            Group filterGroupComposite = new Group(contents, SWT.NONE);
            filterGroupComposite.setLayout(new GridLayout(2, false));
            filterGroupComposite.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1));

            Label label = new Label(filterGroupComposite, SWT.NONE);
            label.setText(Messages.ListBuilderDialog_searchPatternValue_label);

            patternText = new Text(filterGroupComposite, SWT.BORDER);
            patternText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        }

        Composite initialComposite = new Composite(contents, SWT.NONE);
        {
            GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
            data.horizontalAlignment = SWT.END;
            initialComposite.setLayoutData(data);

            GridLayout layout = new GridLayout();
            data.horizontalAlignment = SWT.FILL;
            layout.marginHeight = 0;
            layout.marginWidth = 0;
            layout.numColumns = 1;
            initialComposite.setLayout(layout);
        }

        Label initialLabel = new Label(initialComposite, SWT.NONE);
        initialLabel.setText(Messages.ListBuilderDialog_initialvalue_label);
        GridData initialLabelGridData = new GridData();
        initialLabelGridData.verticalAlignment = SWT.FILL;
        initialLabelGridData.horizontalAlignment = SWT.FILL;
        initialLabel.setLayoutData(initialLabelGridData);

        final Tree initialTree = new Tree(initialComposite, SWT.MULTI | SWT.BORDER);
        GridData initialTreeGridData = new GridData();
        initialTreeGridData.widthHint = Display.getCurrent().getBounds().width / 5;
        initialTreeGridData.heightHint = Display.getCurrent().getBounds().height / 3;
        initialTreeGridData.verticalAlignment = SWT.FILL;
        initialTreeGridData.horizontalAlignment = SWT.FILL;
        initialTreeGridData.grabExcessHorizontalSpace = true;
        initialTreeGridData.grabExcessVerticalSpace = true;
        initialTree.setLayoutData(initialTreeGridData);

        final TreeViewer initialTreeViewer = new TreeViewer(initialTree);
        initialTreeViewer.setContentProvider(contentProvider);
        initialTreeViewer.setLabelProvider(labelProvider);
        final PatternFilter filter = new PatternFilter() {
            @Override
            protected boolean isParentMatch(Viewer viewer, Object element) {
                return viewer instanceof AbstractTreeViewer && super.isParentMatch(viewer, element);
            }
        };
        initialTreeViewer.addFilter(filter);
        initialTreeViewer.setSorter(new ViewerSorter());
        assert patternText != null;
        patternText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                filter.setPattern(((Text) e.widget).getText());
                initialTreeViewer.refresh();
            }
        });
        initialTreeViewer.setInput(possibleValues);

        Composite controlButtons = new Composite(contents, SWT.NONE);
        GridData controlButtonsGridData = new GridData();
        controlButtonsGridData.verticalAlignment = SWT.FILL;
        controlButtonsGridData.horizontalAlignment = SWT.FILL;
        controlButtons.setLayoutData(controlButtonsGridData);

        GridLayout controlsButtonGridLayout = new GridLayout();
        controlButtons.setLayout(controlsButtonGridLayout);

        new Label(controlButtons, SWT.NONE);

        final Button addButton = new Button(controlButtons, SWT.PUSH);
        addButton.setText(Messages.SpecificationPage_button_add);
        addButton.setImage(ImageShop.get(ImageShop.IMG_ADD_OBJ));
        GridData addButtonGridData = new GridData();
        addButtonGridData.verticalAlignment = SWT.FILL;
        addButtonGridData.horizontalAlignment = SWT.FILL;
        addButton.setLayoutData(addButtonGridData);

        final Button removeButton = new Button(controlButtons, SWT.PUSH);
        removeButton.setText(Messages.SpecificationPage_button_remove);
        removeButton.setImage(ImageShop.get(ImageShop.IMG_DELETE_OBJ));
        GridData removeButtonGridData = new GridData();
        removeButtonGridData.verticalAlignment = SWT.FILL;
        removeButtonGridData.horizontalAlignment = SWT.FILL;
        removeButton.setLayoutData(removeButtonGridData);

        Label spaceLabel = new Label(controlButtons, SWT.NONE);
        GridData spaceLabelGridData = new GridData();
        spaceLabelGridData.verticalSpan = 2;
        spaceLabel.setLayoutData(spaceLabelGridData);

        final Button upButton = new Button(controlButtons, SWT.PUSH);
        upButton.setText(Messages.SpecificationPage_button_up);
        upButton.setImage(ImageShop.get(ImageShop.IMG_UPWARD_OBJ));
        GridData upButtonGridData = new GridData();
        upButtonGridData.verticalAlignment = SWT.FILL;
        upButtonGridData.horizontalAlignment = SWT.FILL;
        upButton.setLayoutData(upButtonGridData);

        final Button downButton = new Button(controlButtons, SWT.PUSH);
        downButton.setText(Messages.SpecificationPage_button_down);
        downButton.setImage(ImageShop.get(ImageShop.IMG_DOWNWARD_OBJ));
        GridData downButtonGridData = new GridData();
        downButtonGridData.verticalAlignment = SWT.FILL;
        downButtonGridData.horizontalAlignment = SWT.FILL;
        downButton.setLayoutData(downButtonGridData);

        Composite currentComposite = new Composite(contents, SWT.NONE);
        {
            GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
            data.horizontalAlignment = SWT.END;
            currentComposite.setLayoutData(data);

            GridLayout layout = new GridLayout();
            data.horizontalAlignment = SWT.FILL;
            layout.marginHeight = 0;
            layout.marginWidth = 0;
            layout.numColumns = 1;
            currentComposite.setLayout(layout);
        }

        Label currentLabel = new Label(currentComposite, SWT.NONE);
        currentLabel.setText(Messages.ListBuilderDialog_currentValue_label);
        GridData currentLabelGridData = new GridData();
        currentLabelGridData.horizontalSpan = 2;
        currentLabelGridData.horizontalAlignment = SWT.FILL;
        currentLabelGridData.verticalAlignment = SWT.FILL;
        currentLabel.setLayoutData(currentLabelGridData);

        final Tree currentTree = new Tree(currentComposite, SWT.MULTI | SWT.BORDER);
        GridData currentTableGridData = new GridData();
        currentTableGridData.widthHint = Display.getCurrent().getBounds().width / 5;
        currentTableGridData.heightHint = Display.getCurrent().getBounds().height / 3;
        currentTableGridData.verticalAlignment = SWT.FILL;
        currentTableGridData.horizontalAlignment = SWT.FILL;
        currentTableGridData.grabExcessHorizontalSpace = true;
        currentTableGridData.grabExcessVerticalSpace = true;
        currentTree.setLayoutData(currentTableGridData);

        final TreeViewer currentTreeViewer = new TreeViewer(currentTree);
        currentTreeViewer.setContentProvider(contentProvider);
        currentTreeViewer.setLabelProvider(labelProvider);
        currentTreeViewer.setInput(currentValues);
        if (!currentValues.isEmpty()) {
            currentTreeViewer.setSelection(new StructuredSelection(currentValues.get(0)));
        }

        if (initialTreeViewer != null) {
            initialTreeViewer.addDoubleClickListener(new IDoubleClickListener() {
                public void doubleClick(DoubleClickEvent event) {
                    if (addButton.isEnabled()) {
                        addButton.notifyListeners(SWT.Selection, null);
                    }
                }
            });

            currentTreeViewer.addDoubleClickListener(new IDoubleClickListener() {
                public void doubleClick(DoubleClickEvent event) {
                    if (removeButton.isEnabled()) {
                        removeButton.notifyListeners(SWT.Selection, null);
                    }
                }
            });
        }

        upButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                // IStructuredSelection selection = (IStructuredSelection)
                // featureTableViewer.getSelection();
                // int minIndex = 0;
                // for (Iterator<?> i = selection.iterator(); i.hasNext();) {
                // Object value = i.next();
                // int index = initialValues.indexOf(value);
                // initialValues.move(Math.max(index - 1, minIndex++), value);
                // }
            }
        });

        downButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                // IStructuredSelection selection = (IStructuredSelection)
                // featureTableViewer.getSelection();
                // int maxIndex = values.getChildren().size() -
                // selection.size();
                // for (Iterator<?> i = selection.iterator(); i.hasNext();) {
                // Object value = i.next();
                // int index = values.getChildren().indexOf(value);
                // values.getChildren().move(Math.min(index + 1, maxIndex++),
                // value);
                // }
            }
        });

        addButton.addSelectionListener(new SelectionAdapter() {
            // event is null when choiceTableViewer is double clicked
            @Override
            public void widgetSelected(SelectionEvent event) {
                IStructuredSelection selection = (IStructuredSelection) initialTreeViewer.getSelection();
                for (Iterator<?> i = selection.iterator(); i.hasNext();) {
                    currentValues.add((E) i.next());
                }
                currentTreeViewer.setSelection(selection);
                currentTreeViewer.refresh();
                // if (choiceText != null) {
                // try {
                // Object value = EcoreUtil.createFromString((EDataType)
                // eClassifier, choiceText.getText());
                // values.getChildren().add(value);
                // choiceText.setText("");
                // featureTableViewer.setSelection(new
                // StructuredSelection(value));
                // } catch (RuntimeException exception) {
                // // Ignore
                // }
                // }
            }
        });

        removeButton.addSelectionListener(new SelectionAdapter() {
            // event is null when featureTableViewer is double clicked
            @Override
            public void widgetSelected(SelectionEvent event) {
                IStructuredSelection selection = (IStructuredSelection) currentTreeViewer.getSelection();
                Object firstValue = null;
                for (Iterator<?> i = selection.iterator(); i.hasNext();) {
                    Object value = i.next();
                    if (firstValue == null) {
                        firstValue = value;
                    }
                    currentValues.remove(value);
                }

                if (!currentValues.isEmpty()) {
                    currentTreeViewer.setSelection(new StructuredSelection(currentValues.get(0)));
                }

                initialTreeViewer.setSelection(selection);
                currentTreeViewer.refresh();
                // } else if (choiceText != null) {
                // if (firstValue != null) {
                // String value = EcoreUtil.convertToString((EDataType)
                // eClassifier, firstValue);
                // choiceText.setText(value);
                // }
            }
        });

        return contents;
    }

    @Override
    protected void okPressed() {
        super.okPressed();
    }

    @Override
    public boolean close() {
        contentProvider.dispose();
        return super.close();
    }

    public List<E> getResult() {
        return currentValues;
    }
}