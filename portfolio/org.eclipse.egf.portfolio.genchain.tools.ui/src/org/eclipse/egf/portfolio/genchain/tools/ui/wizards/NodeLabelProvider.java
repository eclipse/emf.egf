/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * @author Thomas Guiu
 * 
 */
public class NodeLabelProvider extends LabelProvider {

    public String getText(Object element) {
        return element == null ? "" : ((Node) element).getName();//$NON-NLS-1$
    }

}
