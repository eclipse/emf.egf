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

package org.eclipse.egf.pattern.engine;

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
            for (PatternParameter sParam : called.getAllParameters()) {
                String type = sParam.getType();

                for (PatternParameter tParam : caller.getAllParameters()) {
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
        if (called.getAllParameters().isEmpty() && caller.getAllParameters().isEmpty())
            return true;
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
