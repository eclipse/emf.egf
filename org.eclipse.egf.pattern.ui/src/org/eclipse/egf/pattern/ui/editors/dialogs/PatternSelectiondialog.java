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

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.models.PatternEntry;
import org.eclipse.egf.pattern.ui.editors.models.PatternsModel;
import org.eclipse.egf.pattern.ui.editors.providers.PatternSelectionContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.PatternSelectionLabelProvider;
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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

/**
 * @author xrchen
 * 
 */
public class PatternSelectiondialog extends PatternElementSelectionDialog {

    private Pattern parent;

    private String parentName;

    private PatternsModel patternsModel;

    private TableViewer tableViewer;

    private Text text;
    
    private Text statusLine;

    public PatternSelectiondialog(Shell shell, Pattern parent, String parentName) {
        super(shell);
        this.parent = parent;
        this.parentName = parentName;
    }

    protected Control createDialogArea(Composite parent) {
        patternsModel = getPatternsList();
        checkPatternExist(parentName);

        Composite dialogArea = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(dialogArea, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginWidth = 5;
        container.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.minimumHeight = 380;
        container.setLayoutData(gd);

        Label patternLabel = new Label(container, SWT.NONE);
        patternLabel.setText(Messages.PatternSelectiondialog_pattern_label);

        text = new Text(container, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 550;
        text.setLayoutData(gd);
        text.setText(parentName);
        text.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                PatternsModel listAreaDisplay = getListAreaDisplay(text.getText());
                tableViewer.setInput(listAreaDisplay);
                parentName = text.getText();
                checkPatternExist(text.getText());
                getSelectDefault(listAreaDisplay);
            }
        });

        Label label = new Label(container, SWT.NONE);
        label.setText(Messages.PatternSelectiondialog_dialogArea_label);

        createListArea(container);
        createStatusLine(container);
        return dialogArea;
    }

    private void createStatusLine(Composite container) {
        String statusContent = PatternHelper.getPlatformFcore(parent).getName();
        statusLine = new Text(container, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        statusLine.setText(statusContent);
        statusLine.setEditable(false);
        statusLine.setLayoutData(gd);
    }

    private void createListArea(Composite container) {
        Table listTable = new Table(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_BOTH);
        listTable.setLayoutData(gd);

        TableColumn tableColumn = new TableColumn(listTable, SWT.NONE);
        tableColumn.setWidth(500);
        tableViewer = new TableViewer(listTable);

        tableViewer.setLabelProvider(new PatternSelectionLabelProvider());
        tableViewer.setContentProvider(new PatternSelectionContentProvider());
        PatternsModel listAreaDisplay = getListAreaDisplay(parentName);
        tableViewer.setInput(listAreaDisplay);
        getSelectDefault(listAreaDisplay);

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                if (selection.getFirstElement() instanceof PatternEntry) {
                    parent = ((PatternEntry) selection.getFirstElement()).getPattern();
                    parentName = ((PatternEntry) selection.getFirstElement()).getName();
                    String statusContent = PatternHelper.getPlatformFcore(parent).getName();
                    statusLine.setText(statusContent);
                }
            }
        });
        
        tableViewer.addDoubleClickListener(new IDoubleClickListener() {
            
            public void doubleClick(DoubleClickEvent event) {
                okPressed();
            }
        });

    }

    private PatternsModel getPatternsList() {
        Set<Pattern> patterns = PatternHelper.getAllPatterns();
        patternsModel = new PatternsModel();
        for (Pattern pattern : patterns) {
            String patternDescrip = pattern.getName() + Messages.common_mark1 + PatternHelper.getFactoryConponentName(pattern) + Messages.common_mark2;
            PatternEntry entry = new PatternEntry(pattern, patternDescrip, pattern.getName());
            patternsModel.add(entry);
        }
        return patternsModel;
    }

    private PatternsModel getListAreaDisplay(String name) {
        PatternsModel patternsModelNew = new PatternsModel();
        Object[] patternEntrys = patternsModel.elements();
        for (Object patternEntry : patternEntrys) {
            if (patternEntry instanceof PatternEntry) {
                String content = ((PatternEntry) patternEntry).getDescription();
                if (searchContainer(content, name)) {
                    patternsModelNew.add(patternEntry);
                }
            }
        }
        return patternsModelNew;
    }

    private void checkPatternExist(String name) {
        IStatus fLastStatusErr = new Status(IStatus.ERROR, JavaCore.PLUGIN_ID, -1, "", null);
        IStatus fLastStatusOk = new Status(IStatus.OK, Policy.JFACE, IStatus.OK, Util.ZERO_LENGTH_STRING, null);
        if (getListAreaDisplay(name).elements().length > 0) {
            updateStatus(fLastStatusOk);
            return;
        }
        updateStatus(fLastStatusErr);
    }

    private void getSelectDefault(PatternsModel model) {
        Object selectEntry = selectDefault(model, tableViewer);
        if (selectEntry instanceof PatternEntry) {
            parent = ((PatternEntry) selectEntry).getPattern();
            parentName = ((PatternEntry) selectEntry).getName();
        }
    }

    public Pattern getParent() {
        return parent;
    }

    public String getParentName() {
        return parentName;
    }
}
