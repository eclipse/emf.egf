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

package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.providers.ContainerLibraryContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ContainerLibraryLabelProvider;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ContainerLibrarySelectionDialog extends PatternElementSelectionDialog {
    private TableViewer tableViewer;

    private Text text;

    private PatternLibrary patternLibrary;

    private String librayName;

    private List<PatternLibrary> containerLibrarys;

    public ContainerLibrarySelectionDialog(Shell shell, PatternLibrary patternLibrary) {
        super(shell);
        this.patternLibrary = patternLibrary;
        if (patternLibrary != null) {
            librayName = patternLibrary.getName();
        }
    }

    protected Control createDialogArea(Composite parent) {
        containerLibrarys = getContainerLibraryList();
        checkContainerExist(librayName);

        Composite dialogArea = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(dialogArea, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginWidth = 5;
        container.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.minimumHeight = 380;
        container.setLayoutData(gd);

        Label patternLabel = new Label(container, SWT.NONE);
        patternLabel.setText(Messages.ContainerLibrarySelectionDialog_pattern_label);

        text = new Text(container, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 550;
        text.setLayoutData(gd);
        text.setText("");
        text.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                List<PatternLibrary> listAreaDisplay = getListAreaDisplay(text.getText());
                tableViewer.setInput(listAreaDisplay);
                checkContainerExist(text.getText());
                getSelectDefault(listAreaDisplay);
            }
        });

        Label label = new Label(container, SWT.NONE);
        label.setText(Messages.ContainerLibrarySelectionDialog_dialogArea_label);

        createListArea(container);
        return dialogArea;
    }

    private void createListArea(Composite container) {
        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_BOTH);
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        tableViewer = new TableViewer(listTable);

        tableViewer.setLabelProvider(new ContainerLibraryLabelProvider());
        tableViewer.setContentProvider(new ContainerLibraryContentProvider());
        List<PatternLibrary> listAreaDisplay = getListAreaDisplay(librayName);
        tableViewer.setInput(listAreaDisplay);
        getSelectDefault(listAreaDisplay);

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                if (selection.getFirstElement() instanceof PatternLibrary) {
                    patternLibrary = (PatternLibrary) selection.getFirstElement();
                }
            }
        });

        tableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                okPressed();
            }
        });

    }

    /**
     * Get all the library containers.
     */
    private List<PatternLibrary> getContainerLibraryList() {
        containerLibrarys = new ArrayList<PatternLibrary>();
        Set<PatternLibrary> allLibrarys = PatternHelper.TRANSACTIONNAL_COLLECTOR.getAllLibraries();
        for (PatternLibrary library : allLibrarys) {
            containerLibrarys.add(library);
        }
        return containerLibrarys;
    }

    private void checkContainerExist(String name) {
        IStatus fLastStatusErr = new Status(IStatus.ERROR, JavaCore.PLUGIN_ID, -1, "", null);
        IStatus fLastStatusOk = new Status(IStatus.OK, Policy.JFACE, IStatus.OK, Util.ZERO_LENGTH_STRING, null);
        if (getListAreaDisplay(name).size() > 0) {
            updateStatus(fLastStatusOk);
            return;
        }
        updateStatus(fLastStatusErr);
    }

    private List<PatternLibrary> getListAreaDisplay(String name) {
        List<PatternLibrary> containerLibrarysNew = new ArrayList<PatternLibrary>();
        for (PatternLibrary containerLibrary : containerLibrarys) {
            if (searchContainer(containerLibrary.getName(), name)) {
                containerLibrarysNew.add(containerLibrary);
            }
        }
        return containerLibrarysNew;
    }

    private void getSelectDefault(List<PatternLibrary> model) {
        Object selectEntry = selectDefault(model, tableViewer);
        if (selectEntry instanceof PatternLibrary) {
            patternLibrary = (PatternLibrary) selectEntry;
        }
    }

    public PatternLibrary getLibraryContainer() {
        return patternLibrary;
    }
}
