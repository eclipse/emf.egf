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

import java.util.List;

import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternElementcontentProvider implements ITreeContentProvider {

    private static final Object[] EMPTY_ARRAY = new Object[0];

    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof List<?>)
            return ((List<?>) inputElement).toArray();
        else if (inputElement instanceof PatternLibrary)
            return ((PatternLibrary) inputElement).getElements().toArray();
        return EMPTY_ARRAY;
    }

    public void dispose() {

    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public Object[] getChildren(Object parentElement) {

        return getElements(parentElement);
    }

    public Object getParent(Object element) {

        return ((EObject) element).eContainer();
    }

    public boolean hasChildren(Object element) {

        return getElements(element).length != 0;
    }

}
