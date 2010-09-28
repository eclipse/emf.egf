/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class PatternSelectionLabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof Pattern)
            return Activator.getDefault().getImage(ImageShop.IMG_INNERCLASS_PUBLIC_OBJ);
        if (element instanceof PatternVariable)
            return Activator.getDefault().getImage(ImageShop.IMG_VARIABLE);
        if (element instanceof PatternParameter)
            return Activator.getDefault().getImage(ImageShop.IMG_PARAMETER_OBJ);
        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof Pattern) {
            Pattern pattern = (Pattern) element;
            switch (columnIndex) {
                case 0:
                    return pattern.getName() + Messages.common_mark1 + PatternHelper.getFactoryComponentName(pattern) + Messages.common_mark2 + " - " + pattern.eResource().getURI(); //$NON-NLS-1$
            }
        }
        if (element instanceof NamedModelElement)
            return ((NamedModelElement) element).getName();
        return ""; //$NON-NLS-1$
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
