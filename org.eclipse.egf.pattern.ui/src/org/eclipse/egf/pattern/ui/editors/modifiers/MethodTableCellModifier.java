/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
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

package org.eclipse.egf.pattern.ui.editors.modifiers;

import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.pages.ImplementationPage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class MethodTableCellModifier extends EditingDomainCellModifier {

    public MethodTableCellModifier(TransactionalEditingDomain editingDomain, TableViewer tableViewer) {
        super(editingDomain, tableViewer);
    }

    public boolean canModify(Object element, String property) {
        if ((ImplementationPage.NAME_COLUMN_ID).equals(property)) {
            if (element instanceof PatternMethod)
                return !PatternUIHelper.isRenameDisable((PatternMethod) element);
        }
        return false;
    }

    public Object getValue(Object element, String property) {
        if ((ImplementationPage.NAME_COLUMN_ID).equals(property)) {
            if (element instanceof PatternMethod) {
                String name = ((PatternMethod) element).getName();
                return name;
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
        PatternMethod patternMethodel = (PatternMethod) element;
        if ((ImplementationPage.NAME_COLUMN_ID).equals(property)) {
            executeModify(text, patternMethodel);
        }
    }

    private void executeModify(final String text, final PatternMethod patternMethod) {
        Runnable runnable = new Runnable() {
            public void run() {
                patternMethod.setName(text);
            }
        };
        doModify(runnable);
    }

}
