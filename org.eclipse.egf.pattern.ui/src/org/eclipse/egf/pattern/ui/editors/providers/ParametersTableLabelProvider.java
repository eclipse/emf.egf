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
import org.eclipse.egf.model.pattern.Query;
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
                return query == null ? "" : getQuery(query.getExtensionId());
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
        String newType;

        if (type == null || type.isEmpty() || "".equals(type))
            return "";
        int index = type.lastIndexOf("/");
        if (index != -1) {
            newType = type.substring(index + 1);
            int lastIndex = newType.lastIndexOf(".");
            if (index != -1) {
                return newType.substring(lastIndex + 1);
            }
            return newType;
        } else {
            int lastIndex = type.lastIndexOf(".");
            if (index != -1) {
                return type.substring(lastIndex + 1);
            }
        }
        return type;
    }

    private static String getQuery(Object selectedValue) {
        String value = selectedValue.toString();
        if (value == null || value.isEmpty() || "".equals(value))
            return "";
        int index = value.lastIndexOf(".");
        if (index != -1)
            return value.substring(index + 1);
        return value;
    }
}
