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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author xrchen
 * 
 */
public class MethodLabelProvider implements ITableLabelProvider {

    private List<String> parentMethods;

    public MethodLabelProvider(List<String> parentMethods) {
        this.parentMethods = parentMethods;
    }

    public Image getColumnImage(Object element, int columnIndex) {

        if (element instanceof PatternMethod)
            if (isOverride(element))
                return ImageShop.get(ImageShop.IMG_INNERCLASS_DEFAULT_OBJ);
        return null;
    }

    private boolean isOverride(Object element) {
        for(String parentMethod : parentMethods){
            String elementName = ((PatternMethod)element).getName();
            if(elementName.equals(parentMethod)){
                return true;
            }
        }
        return false;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof PatternMethod)
            return ((PatternMethod) element).getName();
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
}
