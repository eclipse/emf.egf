/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.usecase.pattern.uc1.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.pattern.utils.RuntimeParameterTypeHelper;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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

public class ContentQuery implements IQuery {

    public List<Object> execute(ParameterDescription parameter, Map<String, String> queryCtx, PatternContext context) {
        String type = parameter.getType();
        Object loadClass = RuntimeParameterTypeHelper.INSTANCE.loadClass(type);
        if (!(loadClass instanceof EClass))
            throw new IllegalStateException(EGFPatternMessages.query_error1);

        Collection<EObject> domain = ((EObject) context.getValue(PatternContext.INJECTED_CONTEXT)).eContents();
        if (domain == null)
            throw new IllegalStateException(EGFPatternMessages.query_error8);

        SELECT query = new SELECT(new FROM(domain), new WHERE(new EObjectTypeRelationCondition((EClass) loadClass, TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL)));
        IQueryResult result = query.execute();
        if (result.getException() != null)
            throw new IllegalStateException(result.getException());
        return new ArrayList<Object>(result.getEObjects());
    }

}
