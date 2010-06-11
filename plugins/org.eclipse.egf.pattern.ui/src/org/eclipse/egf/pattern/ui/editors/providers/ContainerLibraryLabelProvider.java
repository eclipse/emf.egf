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

import org.eclipse.egf.model.pattern.PatternLibrary;
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
public class ContainerLibraryLabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {
        return Activator.getDefault().getImage(ImageShop.IMG_INNERCLASS_PUBLIC_OBJ);
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof PatternLibrary) {
            PatternLibrary libraryEntry = (PatternLibrary) element;
            return (libraryEntry.getName() + Messages.common_mark1 + PatternHelper.getFactoryConponentName(libraryEntry) + Messages.common_mark2);
        }
        return ""; //$NON-NLS-1$
    }

    public void addListener(ILabelProviderListener listener) {
        // Nothing to do
    }

    public void dispose() {
        // Nothing to do
    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
        // Nothing to do
    }

}
