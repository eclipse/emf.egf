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

package org.eclipse.egf.pattern.ui.editors.editor;

import java.text.MessageFormat;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author xrchen
 * 
 */
public class QueryComboBoxViewerCellEditor extends ComboBoxViewerCellEditor {

    /**
     * The custom combo box control.
     */
    ComboViewer viewer;

    static Object selectedValue;

    public static Object getSelectedValue() {
        return selectedValue;
    }

    public QueryComboBoxViewerCellEditor(Composite parent, int style) {
        super(parent, style);
    }

    /*
     * (non-Javadoc) Method declared on CellEditor.
     */
    protected Control createControl(Composite parent) {
        super.createControl(parent);
        CCombo comboBox = new CCombo(parent, getStyle());
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
                QueryComboBoxViewerCellEditor.this.focusLost();
            }
        });
        return comboBox;
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
        return getQuery(selectedValue);
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
        } else {
            viewer.setSelection(new StructuredSelection(value));
        }
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
        } else {
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

    private Object getQuery(Object selectedValue) {
        String value = selectedValue.toString();
        if (value == null || value.isEmpty() || "".equals(value))
            return "";
        int index = value.lastIndexOf(".");
        if (index != -1)
            return value.substring(index + 1);
        return value;
    }
}
