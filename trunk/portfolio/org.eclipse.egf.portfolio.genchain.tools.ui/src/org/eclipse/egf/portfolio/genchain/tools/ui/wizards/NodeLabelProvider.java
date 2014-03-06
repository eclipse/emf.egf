/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import org.eclipse.egf.portfolio.genchain.extension.ExtensionProperties;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Thomas Guiu
 * 
 */
public class NodeLabelProvider implements ITableLabelProvider, ILabelProvider {

    private String validate(String label) {
        return label == null ? "" : label;//$NON-NLS-1$
    }

    public Image getColumnImage(Object element, int columnIndex) {
        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        final Node element2 = (Node) element;
        switch (columnIndex) {
        case 0:
            return validate(element2.getName());
        case 1:
            return validate(element2.getProperties().get(ExtensionProperties.PROPERTY_VALUE));
        }
        return "";//$NON-NLS-1$
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

    public Image getImage(Object element) {

        return null;
    }

    public String getText(Object element) {
        final Node element2 = (Node) element;
        return validate(element2.getName());
    }

}
