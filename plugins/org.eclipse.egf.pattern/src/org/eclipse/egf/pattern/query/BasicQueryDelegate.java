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

package org.eclipse.egf.pattern.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

/**
 * @author Thomas Guiu
 * 
 */
public class BasicQueryDelegate implements IQuery {

    public List<Object> execute(ParameterDescription parameter, Map<String, String> queryCtx, PatternContext context) {
        String type = parameter.getType();
        Object loadClass = ParameterTypeHelper.INSTANCE.loadClass(type);
        if (!(loadClass instanceof EClass))
            throw new IllegalStateException(Messages.query_error1);

        Collection<EObject> domain = getDomain(context);
        if (domain == null)
            throw new IllegalStateException(Messages.query_error8);

        List<Object> result = new ArrayList<Object>();
        
        TreeIterator<EObject> allContentsIterator = EcoreUtil.getAllContents(domain);
        while (allContentsIterator.hasNext()) {
            EObject eObject = allContentsIterator.next();
            URI parameterTypeURI = EcoreUtil.getURI((EObject) loadClass);
            
            //same type
            URI eObjectClassURI = EcoreUtil.getURI(eObject.eClass());
            if (eObjectClassURI.equals(parameterTypeURI))
                result.add(eObject);
            
            //sub type
            for (EClass superClass : eObject.eClass().getEAllSuperTypes()) {
                URI eSuperClassURI = EcoreUtil.getURI(superClass);
                if (eSuperClassURI.equals(parameterTypeURI))
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
