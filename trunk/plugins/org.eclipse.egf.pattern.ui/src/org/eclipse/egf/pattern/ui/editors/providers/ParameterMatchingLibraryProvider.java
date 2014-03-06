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

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.InjectedContext;
import org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ParameterMatchingLibraryProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {

        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof Paramerter2ParameterMapImpl) {
            Paramerter2ParameterMapImpl entry = (Paramerter2ParameterMapImpl) element;
            InjectedContext key = entry.getKey();
            InjectedContext value = entry.getValue();
            return (value.getName() == null ? "" : value.getName()) + " -> " + (key.getName() == null ? "" : key.getName()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        return null;
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

}
