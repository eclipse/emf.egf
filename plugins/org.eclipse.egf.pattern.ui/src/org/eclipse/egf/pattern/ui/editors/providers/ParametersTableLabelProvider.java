/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Point;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ParametersTableLabelProvider extends CellLabelProvider {

    @Override
    public String getToolTipText(Object element) {
        if (element instanceof PatternParameter) {
            return ((PatternParameter) element).getType();
        } else if (element instanceof PatternVariable) {
            return ((PatternVariable) element).getType();
        }
        return null;
    }

    @Override
    public Point getToolTipShift(Object object) {
        return new Point(5, 5);
    }

    @Override
    public int getToolTipDisplayDelayTime(Object object) {
        return 100;
    }

    @Override
    public int getToolTipTimeDisplayed(Object object) {
        return 5000;
    }

    @Override
    public void update(ViewerCell cell) {
        Object element = cell.getElement();
        int columnIndex = cell.getColumnIndex();
        // Image Processing
        if (element instanceof PatternParameter && columnIndex == 2) {
            Query query = ((PatternParameter) element).getQuery();
            if (query != null) {
                EMap<String, String> queryContext = query.getQueryContext();
                if (queryContext != null && !queryContext.isEmpty()) {
                    cell.setImage(Activator.getDefault().getImage(ImageShop.IMG_QUERY_SET));
                }
            }
        }
        // Text Processing
        if (element instanceof PatternParameter) {
            PatternParameter patternParameter = (PatternParameter) element;
            switch (columnIndex) {
                case 0:
                    cell.setText(patternParameter.getName());
                    return;
                case 1:
                    cell.setText(getType(patternParameter.getType()));
                    return;
                case 2:
                    Query query = patternParameter.getQuery();
                    if (query != null) {
                        String extensionId = query.getExtensionId();
                        QueryKind queryKind = IQuery.INSTANCE.getQueryKind(extensionId);
                        String queryKindName = queryKind == null ? null : queryKind.getName();
                        if (queryKindName != null) {
                            cell.setText(queryKindName);
                            return;
                        }
                        cell.setText(extensionId == null ? "" : extensionId); //$NON-NLS-1$
                        return;
                    }
                    cell.setText(""); //$NON-NLS-1$
                    return;
            }
        } else if (element instanceof PatternVariable) {
            PatternVariable patternVariable = (PatternVariable) element;
            switch (columnIndex) {
                case 0:
                    cell.setText(patternVariable.getName());
                    return;
                case 1:
                    cell.setText(getType(patternVariable.getType()));
                    return;
            }
        }
        cell.setText(""); //$NON-NLS-1$
    }

    /**
     * Drop any package or uri information of the type.
     */
    public static String getType(String type) {
        if (type == null || type.length() == 0)
            return ""; //$NON-NLS-1$
        int mark1Index = type.lastIndexOf("$"); //$NON-NLS-1$
        int mark2Index = type.lastIndexOf("."); //$NON-NLS-1$
        int mark3 = type.lastIndexOf("//"); //$NON-NLS-1$
        int mark3Index = mark3 == -1 ? -1 : mark3 + 1;
        int index = getIndex(mark1Index, mark2Index, mark3Index);
        if (index != -1) {
            return type.substring(index + 1);
        }
        return type;
    }

    private static int getIndex(int mark1Index, int mark2Index, int mark3Index) {
        if (mark1Index > 0) {
            return mark1Index;
        } else if (mark3Index > 0) {
            return mark3Index;
        }
        return mark2Index;
    }

}
