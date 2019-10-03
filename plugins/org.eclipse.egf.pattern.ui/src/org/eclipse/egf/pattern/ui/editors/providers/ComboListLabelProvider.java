/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ComboListLabelProvider implements ILabelProvider {

    public Image getImage(Object element) {
        return null;
    }

    public String getText(Object element) {
        if (element instanceof QueryKind) {
            return ((QueryKind) element).getName();
        }
        return ""; //$NON-NLS-1$
    }

    public void addListener(ILabelProviderListener listener) {

    }

    public void dispose() {

    }

    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

}
