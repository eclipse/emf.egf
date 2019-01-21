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

package org.eclipse.egf.pattern.ui.trace;

import org.eclipse.egf.core.trace.Category;
import org.eclipse.egf.core.trace.Configuration;
import org.eclipse.egf.core.trace.util.TraceSwitch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author Thomas Guiu
 * 
 */
public class TraceContentProvider implements IStructuredContentProvider {

    private static final Object[] EMPTY = new Object[0];
    private final TraceSwitch<Object[]> _switch = new TraceSwitch<Object[]>() {

        @Override
        public Object[] defaultCase(EObject object) {

            return EMPTY;
        }

        @Override
        public Object[] caseConfiguration(Configuration object) {

            return object.getCategories().toArray();
        }

        @Override
        public Object[] caseCategory(Category object) {

            return object.getFilters().toArray();
        }

    };

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public Object[] getElements(Object inputElement) {

        return _switch.doSwitch((EObject) inputElement);
    }

}
