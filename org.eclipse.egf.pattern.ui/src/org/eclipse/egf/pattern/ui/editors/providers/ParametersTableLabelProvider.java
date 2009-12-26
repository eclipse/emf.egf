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

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.query.QueryManager;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author xrchen
 * 
 */
public class ParametersTableLabelProvider extends LabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {

        return null;
    }

    public String getColumnText(Object element, int columnIndex) {

        if (element instanceof PatternParameter) {
            PatternParameter patternParameter = (PatternParameter) element;
            switch (columnIndex) {
            case 0:
                return patternParameter.getName();
            case 1:
                return getType(patternParameter.getType());
            case 2:
                Query query = patternParameter.getQuery();
                if (query != null) {
                    String extensionId = query.getExtensionId();
                    QueryKind queryKind = QueryManager.INSTANCE.getQueryKind(extensionId);
                    String queryKindName = queryKind == null ? null : queryKind.getName();
                    if (queryKindName != null) {
                        return queryKindName;
                    }
                    return extensionId == null ? "" : extensionId;
                }
                return "";
            }
        } else if (element instanceof PatternVariable) {
            PatternVariable patternVariable = (PatternVariable) element;
            switch (columnIndex) {
            case 0:
                return patternVariable.getName();
            case 1:
                return getType(patternVariable.getType());
            }
        }
        return "";
    }

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {

        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

    /**
     * Drop any package or uri information of the type.
     */
    public static String getType(String type) {
        if (type == null || type.isEmpty() || "".equals(type))
            return "";
        int mark1Index = type.lastIndexOf("$");
        int mark2Index = type.lastIndexOf(".");
        int mark3 = type.lastIndexOf("//");
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
