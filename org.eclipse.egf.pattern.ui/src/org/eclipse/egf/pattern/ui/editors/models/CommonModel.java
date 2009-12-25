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
package org.eclipse.egf.pattern.ui.editors.models;

import java.util.Vector;

/**
 * @author xrchen
 * 
 */
public class CommonModel extends CommonElement {
    @SuppressWarnings("unchecked")
    private Vector content;

    @SuppressWarnings("unchecked")
    public CommonModel() {
        content = new Vector();
    }

    @SuppressWarnings("unchecked")
    public void add(Object element) {
        content.add(element);
        if (element instanceof CommonElement) {
            ((CommonElement) element).setParent(this);
        }
    }

    public void remove(Object element) {
        content.remove(element);
    }

    public Object[] elements() {
        return content.toArray();
    }

}
