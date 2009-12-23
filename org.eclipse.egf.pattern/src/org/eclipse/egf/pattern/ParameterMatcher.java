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

package org.eclipse.egf.pattern;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;

/**
 * This class aims at matching parameters between 2 patterns. This matching
 * could be used as implicit matching when a pattern calls another one.<br>
 * 
 * For each parameter of the target pattern, we will look for exactly one
 * parameter from the source pattern who is assignable.
 * 
 * 
 * @author Thomas Guiu
 * 
 */
public class ParameterMatcher {
    private final Pattern source;
    private final Pattern target;
    private Map<PatternParameter, PatternParameter> matching;

    public boolean matches() {
        if (matching == null) {
            matching = new HashMap<PatternParameter, PatternParameter>();

            PatternParameter match = null;
            for (PatternParameter tParam : target.getParameters()) {
                EModelElement type = tParam.getType();

                for (PatternParameter sParam : source.getParameters()) {
                    if (isAssignable(type, sParam.getType())) {
                        if (match == null)
                            match = sParam;
                        else {
                            matching.clear();
                            return false;
                        }
                    }
                }
                matching.put(match, tParam);
                match = null;
            }
        }
        return !matching.isEmpty();
    }

    private boolean isAssignable(EModelElement type1, EModelElement type2) {
        // TODO handle all other cases
        if (type1 instanceof EClass && type2 instanceof EClass) {
            EClass c1 = (EClass) type1;
            EClass c2 = (EClass) type2;
            return c1.isSuperTypeOf(c2);
        }
        return type1.equals(type2);
    }

    public Map<PatternParameter, PatternParameter> getMatching() {
        if (matching == null)
            throw new IllegalStateException();
        return matching;
    }

    private ParameterMatcher(Pattern source, Pattern target) {
        this.source = source;
        this.target = target;
    }

    public static boolean matches(Pattern source, Pattern target) {
        return create(source, target).matches();
    }

    public static ParameterMatcher create(Pattern source, Pattern target) {
        return new ParameterMatcher(source, target);
    }
}
