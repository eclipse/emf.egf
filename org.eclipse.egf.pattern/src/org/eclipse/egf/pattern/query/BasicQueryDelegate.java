/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.pattern.BasicQuery;
import org.eclipse.egf.pattern.Messages;
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
public class BasicQueryDelegate implements QueryManager {

  public List<Object> executeQuery(Map<String, String> queryContext, PatternContext context) {
    String type = queryContext.get(BasicQuery.TYPE);
    Object loadClass = ParameterTypeHelper.INSTANCE.loadClass(type);
    if (!(loadClass instanceof EClass))
      throw new IllegalStateException(Messages.query_error1);
    SELECT query = new SELECT(new FROM((Collection<EObject>) context.getValue(PatternContext.DOMAIN_OBJECTS)), new WHERE(new EObjectTypeRelationCondition((EClass) loadClass, TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL)));
    IQueryResult result = query.execute();
    if (result.getException() != null)
      throw new IllegalStateException(result.getException());
    return new ArrayList<Object>(result.getEObjects());
  }
}
