/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author Thomas Guiu
 * 
 */
public class NodeContentProvider implements ITreeContentProvider {

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public Object[] getElements(Object element) {
        if (element instanceof List)
            return ((List) element).toArray();
        Node node = (Node) element;
        return node.getChildren().toArray();
    }

    public Object[] getChildren(Object element) {
        Node node = (Node) element;
        return node.getChildren().toArray();
    }

    public Object getParent(Object element) {
        Node node = (Node) element;
        return node.getParent();
    }

    public boolean hasChildren(Object element) {
        Node node = (Node) element;
        return !node.getChildren().isEmpty();
    }

}
