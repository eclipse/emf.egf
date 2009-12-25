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

import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.editors.models.PatternEntry;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author xrchen
 * 
 */
public class PatternSelectionLabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {

        return ImageShop.get(ImageShop.IMG_INNERCLASS_PUBLIC_OBJ);
    }

    public String getColumnText(Object element, int columnIndex) {
        PatternEntry patternEntry = (PatternEntry) element;
        switch (columnIndex) {
        case 0:
            return patternEntry.getDescription();
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

}
