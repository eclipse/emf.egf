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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class EcoreContentProvider implements ITreeContentProvider {

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    public boolean hasChildren(Object element) {
        return getChildren(element).length > 0;
    }

    public Object getParent(Object element) {
        if (element instanceof EObject) {
            return ((EObject) element).eContainer();
        }
        return null;
    }

    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof Resource) {
            Resource res = (Resource) parentElement;
            return res.getContents().toArray();
        } else if (parentElement instanceof List<?>) {
            return ((List<?>) parentElement).toArray();
        } else if (parentElement instanceof EPackage) {
            EPackage ePack = (EPackage) parentElement;
            return ePack.eContents().toArray();
        }
        return new Object[0];
    }
}
