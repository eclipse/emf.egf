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

import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.ui.editors.pages.SpecificationPage;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ParametersTableCellModifier extends EditingDomainCellModifier {

    public ParametersTableCellModifier(TransactionalEditingDomain editingDomain, TableViewer tableViewer) {
        super(editingDomain, tableViewer);
    }

    public boolean canModify(Object element, String property) {
        if ((SpecificationPage.NAME_COLUMN_ID).equals(property)) {
            return true;
        } else if ((SpecificationPage.TYPE_COLUMN_ID).equals(property)) {
            return true;
        } else if ((SpecificationPage.QUERY_COLUMN_ID).equals(property)) {
            return true;
        }
        return false;
    }

    public Object getValue(Object element, String property) {
        if ((SpecificationPage.NAME_COLUMN_ID).equals(property)) {
            if (element instanceof PatternParameter) {
                return ((PatternParameter) element).getName();
            }
        } else if ((SpecificationPage.TYPE_COLUMN_ID).equals(property)) {
            if (element instanceof PatternParameter) {
                String type = ((PatternParameter) element).getType();
                return ParametersTableLabelProvider.getType(type);
            }
        } else if ((SpecificationPage.QUERY_COLUMN_ID).equals(property)) {
            if (element instanceof PatternParameter) {
                Query patternQuery = ((PatternParameter) element).getQuery();
                String query = patternQuery == null ? "" : patternQuery.getExtensionId();
                return query;
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
        String text = "";
        if (value instanceof QueryKind) {
            text = ((QueryKind) value).getId();
        } else {
            text = (value.toString()).trim();
        }
        PatternParameter patternParameter = (PatternParameter) element;
        if ((SpecificationPage.NAME_COLUMN_ID).equals(property)) {
            executeModify(0, patternParameter, text);
        } else if ((SpecificationPage.TYPE_COLUMN_ID).equals(property)) {
            executeModify(1, patternParameter, text);
        } else if ((SpecificationPage.QUERY_COLUMN_ID).equals(property)) {
            executeModify(2, patternParameter, text);
        }
    }

    private void executeModify(final int setFlag, final PatternParameter patternParameter, final String text) {
        Runnable cmd = new Runnable() {
            public void run() {
                switch (setFlag) {
                case 0:
                    patternParameter.setName(text);
                case 1:
                    break;
                case 2:
                    modifyQuery(patternParameter, text);
                    break;
                default:
                    return;
                }
            }
        };
        doModify(cmd);
    }

    protected void modifyQuery(PatternParameter patternParameter, String text) {
        Query query = patternParameter.getQuery();
        if (text != null) {
            if (query == null && (text != null && !"".equals(text))) {
                Query createBasicQuery = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createBasicQuery();
                createBasicQuery.setExtensionId(text);
                patternParameter.setQuery(createBasicQuery);
            } else if (text != null && !"".equals(text)) {
                query.setExtensionId(text);
            } else if ("".equals(text)) {
                patternParameter.setQuery(null);
            }
        }
    }
}
