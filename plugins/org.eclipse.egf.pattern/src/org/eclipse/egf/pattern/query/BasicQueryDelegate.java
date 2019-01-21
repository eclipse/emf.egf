/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Thomas Guiu
 * 
 */
public class BasicQueryDelegate implements IQuery {

    public List<Object> execute(ParameterDescription parameter, Map<String, String> queryCtx, PatternContext context) {
        String type = parameter.getType();

        Collection<EObject> domain = getDomain(context);
        if (domain == null)
            throw new IllegalStateException(EGFPatternMessages.query_error8);

        List<Object> result = new ArrayList<Object>();

        TreeIterator<EObject> allContentsIterator = EcoreUtil.getAllContents(domain);
        while (allContentsIterator.hasNext()) {
            EObject eObject = allContentsIterator.next();

            //same type
            URI eObjectClassURI = EcoreUtil.getURI(eObject.eClass());
            if (eObjectClassURI.toString().equals(type))
                result.add(eObject);

            //sub type
            for (EClass superClass : eObject.eClass().getEAllSuperTypes()) {
                URI eSuperClassURI = EcoreUtil.getURI(superClass);
                if (eSuperClassURI.toString().equals(type))
                    result.add(eObject);
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    protected Collection<EObject> getDomain(PatternContext context) {
        return (Collection<EObject>) context.getValue(PatternContext.DOMAIN_OBJECTS);
    }

}
