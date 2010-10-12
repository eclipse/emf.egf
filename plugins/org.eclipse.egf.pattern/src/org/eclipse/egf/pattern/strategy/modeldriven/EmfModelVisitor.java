/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.strategy.modeldriven;

import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * TODO: improve pattern selection: At present time, the selection is done via
 * type matching. We can imagine a custom matching policy (for example a pattern
 * can apply if and only if the model element is named 'toto')
 * 
 * @author Thomas Guiu
 * 
 */
public class EmfModelVisitor extends DefaultDomainVisitor {

    public List<?> getChildren(Object model) {
        // a implementer par les users en fct du model
        if (model instanceof EObject)
            return ((EObject) model).eContents();
        if (model instanceof List<?>)
            return (List<?>) model;
        return EMPTY_LIST;
    }

    @Override
    protected List<Pattern> findPatterns(Object model) {
        if (model instanceof EObject) {
            String fullName = EcoreUtil.getURI(((EObject) model).eClass()).toString();
            return type2patterns.get(fullName);
        }

        return super.findPatterns(model);
    }
}
