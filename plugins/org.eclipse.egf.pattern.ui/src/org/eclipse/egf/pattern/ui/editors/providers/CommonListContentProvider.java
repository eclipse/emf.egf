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

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class CommonListContentProvider implements IStructuredContentProvider {

    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof List<?>)
            return ((List<?>) inputElement).toArray();
        return null;
    }

    public void dispose() {
        // Nothing to do
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        viewer.refresh();
    }

}
