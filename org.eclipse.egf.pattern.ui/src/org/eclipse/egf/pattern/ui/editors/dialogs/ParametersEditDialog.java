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

import java.util.List;

import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.query.QueryManager;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ParametersEditDialog extends VariablesEditDialog {

    private Combo queryCombo;

    private String query;

    public ParametersEditDialog(Shell shell, PatternParameter selectItem, TransactionalEditingDomain editingDomain) {
        super(shell, selectItem, editingDomain);
        setDefaultQuery(selectItem);
    }

    private void setDefaultQuery(PatternParameter selectItem) {
        Query itemQuery = selectItem.getQuery();
        query = itemQuery == null ? "" : itemQuery.getExtensionId(); //$NON-NLS-1$
        QueryKind queryKind = QueryManager.INSTANCE.getQueryKind(query);
        if (queryKind != null) {
            query = queryKind.getName();
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
        queryCombo.select(0);
        return dialogArea;
    }

    private void setQueryComboList(Combo combo, String query) {
        List<QueryKind> availableQueries = QueryManager.INSTANCE.getAvailableQueries();
        for (QueryKind kind : availableQueries) {
            String name = kind.getName();
            if (!name.equals(query)) {
                combo.add(name);
            }
        }
    }

    public String getQuery() {
        return query;
    }
}
