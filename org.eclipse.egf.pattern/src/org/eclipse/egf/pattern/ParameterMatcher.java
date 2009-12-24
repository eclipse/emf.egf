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
    private final Pattern called;
    private final Pattern caller;
    private Map<PatternParameter, PatternParameter> matching;

    public boolean matches() {
        if (matching == null) {
            matching = new HashMap<PatternParameter, PatternParameter>();

            PatternParameter match = null;
            for (PatternParameter sParam : called.getParameters()) {
                String type = sParam.getType();

                for (PatternParameter tParam : caller.getParameters()) {
                    if (type.equals(tParam.getType())) {
                        if (match == null)
                            match = tParam;
                        else {
                            matching.clear();
                            return false;
                        }
                    }
                }
                if (match == null) {
                    matching.clear();
                    return false;
                }
                matching.put(sParam, match);
                match = null;
            }
        }
        return !matching.isEmpty();
    }

    public Map<PatternParameter, PatternParameter> getMatching() {
        if (matching == null)
            throw new IllegalStateException();
        return matching;
    }

    private ParameterMatcher(Pattern caller, Pattern called) {
        this.called = called;
        this.caller = caller;
    }

    public static boolean matches(Pattern caller, Pattern called) {
        return create(called, caller).matches();
    }

    public static ParameterMatcher create(Pattern caller, Pattern called) {
        return new ParameterMatcher(caller, called);
    }
}
