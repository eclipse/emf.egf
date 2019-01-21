/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.modifiers;

import org.eclipse.egf.pattern.ui.editors.dialogs.ParametersEditDialog;
import org.eclipse.egf.pattern.ui.editors.models.QueryContent;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class QueryContentTableCellModifier implements ICellModifier {
    private TableViewer tableViewer;

    public QueryContentTableCellModifier(TableViewer tableViewer) {
        this.tableViewer = tableViewer;
    }

    public boolean canModify(Object element, String property) {
        if ((ParametersEditDialog.KEY_ID).equals(property)) {
            return true;
        } else if ((ParametersEditDialog.VALUE_ID).equals(property)) {
            return true;
        }
        return false;
    }

    public Object getValue(Object element, String property) {
        if (element instanceof QueryContent) {
            QueryContent content = (QueryContent) element;
            if ((ParametersEditDialog.KEY_ID).equals(property)) {
                return content.getKey();
            } else if ((ParametersEditDialog.VALUE_ID).equals(property)) {
                return content.getValue();
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
        if (element instanceof QueryContent) {
            QueryContent content = (QueryContent) element;
            if ((ParametersEditDialog.KEY_ID).equals(property)) {
                content.setKey(text);
            } else if ((ParametersEditDialog.VALUE_ID).equals(property)) {
                content.setValue(text);
            }
        }
        tableViewer.refresh();

    }

}
