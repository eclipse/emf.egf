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

package org.eclipse.egf.pattern.strategy.modeldriven;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * TODO: improve pattern selection: At present time, the selection is done via
 * type matching. We can imagine a custom matching policy (for example a pattern
 * can apply if and only if the model element is named 'toto')
 * 
 * @author Thomas Guiu
 * 
 */
public class EmfModelVisitor extends DefaultDomainVisitor {
    private static final List<Object> EMPTY_LIST = new ArrayList<Object>();

    public List<?> getChildren(Object model) {
        // a implementer par les users en fct du model
    	if (model instanceof EObject)
    		return ((EObject) model).eContents();
        if (model instanceof List<?>)
            return (List<?>)model;
        return EMPTY_LIST;
    }

}