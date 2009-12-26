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
package org.eclipse.egf.pattern.ui.editors.modifiers;

import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.ui.editors.pages.ImplementationPage;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author xrchen
 * 
 */
public class VariablesTableCellModifier implements ICellModifier {

    private TransactionalEditingDomain editingDomain;

    private TableViewer tableViewer;

    public VariablesTableCellModifier(TransactionalEditingDomain editingDomain, TableViewer tableViewer) {
        this.editingDomain = editingDomain;
        this.tableViewer = tableViewer;
    }

    public boolean canModify(Object element, String property) {
        if ((ImplementationPage.NAME_COLUMN_ID).equals(property)) {
            return true;
        } else if ((ImplementationPage.TYPE_COLUMN_ID).equals(property)) {
            return true;
        }
        return false;
    }

    public Object getValue(Object element, String property) {
        if (element instanceof PatternVariable) {
            PatternVariable patternVariable = (PatternVariable) element;
            if ((ImplementationPage.NAME_COLUMN_ID).equals(property)) {
                return patternVariable.getName();
            } else if ((ImplementationPage.TYPE_COLUMN_ID).equals(property)) {
                String type = patternVariable.getType();
                return ParametersTableLabelProvider.getType(type);
            }
        }
        return null;
    }

    public void modify(Object element, String property, Object value) {
        if (value == null)
            return;

        if (element instanceof TableItem) {
            element = ((TableItem) element).getData();
        }
        String text = (value.toString()).trim();

        if (element instanceof PatternVariable) {
            PatternVariable patternVariable = (PatternVariable) element;
            if ((ImplementationPage.NAME_COLUMN_ID).equals(property)) {
                executeModifyName(patternVariable, text);
            }
        }
    }

    private void executeModifyName(final PatternVariable patternVariable, final String text) {
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                patternVariable.setName(text);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }
}
