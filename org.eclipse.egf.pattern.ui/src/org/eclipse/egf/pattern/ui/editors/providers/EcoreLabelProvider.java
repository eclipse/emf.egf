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

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class EcoreLabelProvider implements ITableLabelProvider, ILabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof EPackage)
            return ImageShop.get(ImageShop.IMG_TREE_MODE);
        if (element instanceof EObject)
            return ImageShop.get(ImageShop.IMG_CATEGORY_OBJ);

        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof ENamedElement) {
            ENamedElement eNamedElement = (ENamedElement) element;
            return eNamedElement.getName();
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

    public Image getImage(Object element) {

        return getColumnImage(element, 0);
    }

    public String getText(Object element) {

        return getColumnText(element, 0);
    }

}
