/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.editor;

import java.text.MessageFormat;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.pages.ImplementationPage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class MethodsComboBoxViewerCellEditor extends ComboBoxViewerCellEditor {

    /**
     * The custom combo box control.
     */
    ComboViewer viewer;

    static Object selectedValue;

    TransactionalEditingDomain editingDomain;

    TableViewer tableViewer;

    ImplementationPage implementationPage;

    CCombo comboBox;

    boolean isModify = false;

    boolean changeSelection = false;

    public MethodsComboBoxViewerCellEditor(Composite parent, TransactionalEditingDomain editingDomain, TableViewer tableViewer, ImplementationPage implementationPage) {
        super(parent);
        this.editingDomain = editingDomain;
        this.tableViewer = tableViewer;
        this.implementationPage = implementationPage;
    }

    /*
     * (non-Javadoc) Method declared on CellEditor.
     */
    protected Control createControl(Composite parent) {
        super.createControl(parent);
        comboBox = new CCombo(parent, getStyle());
        comboBox.setFont(parent.getFont());
        viewer = new ComboViewer(comboBox);

        comboBox.addKeyListener(new KeyAdapter() {
            // hook key pressed - see PR 14201
            public void keyPressed(KeyEvent e) {
                keyReleaseOccured(e);
            }
        });

        comboBox.addSelectionListener(new SelectionAdapter() {
            public void widgetDefaultSelected(SelectionEvent event) {
                applyEditorValueAndDeactivate();
            }

            public void widgetSelected(SelectionEvent event) {
                ISelection selection = viewer.getSelection();
                if (selection.isEmpty()) {
                    selectedValue = null;
                } else {
                    selectedValue = ((IStructuredSelection) selection).getFirstElement();
                }
            }
        });

        comboBox.addTraverseListener(new TraverseListener() {
            public void keyTraversed(TraverseEvent e) {
                if (e.detail == SWT.TRAVERSE_ESCAPE || e.detail == SWT.TRAVERSE_RETURN) {
                    e.doit = false;
                }
            }
        });

        comboBox.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                MethodsComboBoxViewerCellEditor.this.focusLost();
                String text = comboBox.getText();
                executeModifyMethod(text);
                isModify = false;
            }
        });

        comboBox.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                String text = comboBox.getText();
                isModify = true;
                Button editButton = implementationPage.getEditButton();
                if (editButton != null && !editButton.isDisposed()) {
                    if (Messages.ImplementationPage_header.equals(text) || Messages.ImplementationPage_init.equals(text) || Messages.ImplementationPage_footer.equals(text)) {
                        editButton.setEnabled(false);
                    } else if (!("").equals(text)) {
                        editButton.setEnabled(true);
                    }
                }
            }
        });

        return comboBox;
    }

    /**
     * Update the method name while modify the comBox.
     */
    private void executeModifyMethod(final String newName) {
        if (newName != null && !"".equals(newName) && isModify) {
            int selectionIndex = tableViewer.getTable().getSelectionIndex();
            if (selectionIndex < 0)
                return;
            final PatternMethod method = (PatternMethod) tableViewer.getElementAt(selectionIndex);
            RecordingCommand cmd = new RecordingCommand(editingDomain) {
                protected void doExecute() {
                    method.setName(newName);
                    tableViewer.refresh();
                }
            };
            editingDomain.getCommandStack().execute(cmd);
        }
    }

    /**
     * The <code>ComboBoxCellEditor</code> implementation of this
     * <code>CellEditor</code> framework method returns the zero-based index
     * of the current selection.
     * 
     * @return the zero-based index of the current selection wrapped as an
     *         <code>Integer</code>
     */
    protected Object doGetValue() {
        return selectedValue;
    }

    /*
     * (non-Javadoc) Method declared on CellEditor.
     */
    protected void doSetFocus() {
        viewer.getControl().setFocus();
    }

    /**
     * The <code>ComboBoxCellEditor</code> implementation of this
     * <code>CellEditor</code> framework method sets the minimum width of the
     * cell. The minimum width is 10 characters if <code>comboBox</code> is
     * not <code>null</code> or <code>disposed</code> eles it is 60 pixels
     * to make sure the arrow button and some text is visible. The list of
     * CCombo will be wide enough to show its longest item.
     */
    public LayoutData getLayoutData() {
        LayoutData layoutData = super.getLayoutData();
        if ((viewer.getControl() == null) || viewer.getControl().isDisposed()) {
            layoutData.minimumWidth = 60;
        } else {
            // make the comboBox 10 characters wide
            GC gc = new GC(viewer.getControl());
            layoutData.minimumWidth = (gc.getFontMetrics().getAverageCharWidth() * 10) + 10;
            gc.dispose();
        }
        return layoutData;
    }

    /**
     * Set a new value
     * 
     * @param value
     *            the new value
     */
    protected void doSetValue(Object value) {
        Assert.isTrue(viewer != null);
        selectedValue = value;
        if (value == null) {
            viewer.setSelection(StructuredSelection.EMPTY);
            changeSelection = true;
        } else {
            if (isIncomboBoxlist(value)) {
                viewer.setSelection(new StructuredSelection(value));
                changeSelection = true;
            } else {
                changeSelection = false;
            }
        }
    }

    /**
     * Return whether the value is in the list of comboBox.
     */
    private boolean isIncomboBoxlist(Object value) {
        String[] items = comboBox.getItems();
        for (String item : items) {
            if (item.equals(value))
                return true;
        }
        return false;
    }

    /**
     * @param labelProvider
     *            the label provider used
     * @see StructuredViewer#setLabelProvider(IBaseLabelProvider)
     */
    public void setLabelProvider(IBaseLabelProvider labelProvider) {
        viewer.setLabelProvider(labelProvider);
    }

    /**
     * @param provider
     *            the content provider used
     * @see StructuredViewer#setContentProvider(IContentProvider)
     */
    public void setContenProvider(IStructuredContentProvider provider) {
        viewer.setContentProvider(provider);
    }

    /**
     * @param input
     *            the input used
     * @see StructuredViewer#setInput(Object)
     */
    public void setInput(Object input) {
        viewer.setInput(input);
    }

    /**
     * @return get the viewer
     */
    public ComboViewer getViewer() {
        return viewer;
    }

    /**
     * Applies the currently selected value and deactiavates the cell editor
     */
    void applyEditorValueAndDeactivate() {
        // must set the selection before getting value
        ISelection selection = viewer.getSelection();
        if (selection.isEmpty()) {
            selectedValue = null;
        } else if (changeSelection) {
            selectedValue = ((IStructuredSelection) selection).getFirstElement();
        }

        Object newValue = doGetValue();
        markDirty();
        boolean isValid = isCorrect(newValue);
        setValueValid(isValid);

        if (!isValid) {
            MessageFormat.format(getErrorMessage(), new Object[] { selectedValue });
        }

        fireApplyEditorValue();

        deactivate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.CellEditor#focusLost()
     */
    protected void focusLost() {
        if (isActivated()) {
            applyEditorValueAndDeactivate();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.CellEditor#keyReleaseOccured(org.eclipse.swt
     * .events.KeyEvent)
     */
    protected void keyReleaseOccured(KeyEvent keyEvent) {
        if (keyEvent.character == '\u001b') { // Escape character
            fireCancelEditor();
        } else if (keyEvent.character == '\t') { // tab key
            applyEditorValueAndDeactivate();
        }
    }

}
