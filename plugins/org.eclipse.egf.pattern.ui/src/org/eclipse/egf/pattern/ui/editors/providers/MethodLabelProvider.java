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

import java.util.List;

import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class MethodLabelProvider extends LabelProvider implements ITableLabelProvider {

    public MethodLabelProvider(List<String> parentMethods) {
        super();
        this.parentMethods = parentMethods;
    }

    private List<String> parentMethods;

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof PatternMethod)
            if (isOverride(element))
                return Activator.getDefault().getImage(ImageShop.IMG_METHOD_OVERRIDE);

        return Activator.getDefault().getImage(ImageShop.IMG_METHOD);
    }

    private boolean isOverride(Object element) {
        if (element instanceof PatternMethod) {
            PatternMethod patternMethod = (PatternMethod) element;
            return parentMethods.contains(patternMethod.getName());
        }
        return false;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof PatternMethod) {
            PatternMethod patternMethod = (PatternMethod) element;
            return patternMethod.getName();
        }
        return ""; //$NON-NLS-1$
    }

    @Override
    public String getText(Object element) {
        return getColumnText(element, 0);
    }

}
