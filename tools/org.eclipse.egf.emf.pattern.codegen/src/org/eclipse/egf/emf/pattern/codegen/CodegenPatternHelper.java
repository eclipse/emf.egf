/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen;

import java.util.Set;

import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenPatternHelper {
    
    public String getSuperPatternName(PatternInfo patternInfo) {
        return patternInfo.getParameterType() + patternInfo.getContentType();
    }
    
    public Pattern findPattern(Resource resource, String patternName) {
        FROM from = new FROM(resource.getContents());
        EObjectCondition typeCondition = new EObjectTypeRelationCondition(PatternPackage.eINSTANCE.getPattern(), TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL);
        EObjectCondition nameCondition = new EObjectAttributeValueCondition(FcorePackage.eINSTANCE.getNamedModelElement_Name(), new StringValue(patternName));
        WHERE where = new WHERE(typeCondition.AND(nameCondition));
        SELECT select = new SELECT(from, where);

        IQueryResult result = select.execute();
        Set<? extends EObject> eObjects = result.getEObjects();

        if (eObjects.size() != 1)
            throw new IllegalStateException("Should found only one pattern with name " + patternName); //$NON-NLS-1$

        return (Pattern) eObjects.toArray()[0];
    }
}
