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

package org.eclipse.egf.pattern.utils;

import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.emf.common.util.EList;

/**
 * @author Thomas Guiu
 * 
 */
public class SubstitutionHelper {
    /**
     * This method applies the given substitutions to the given list of
     * patterns.
     * The current implementation only deals with simple cases.
     */
    public static void apply(List<Pattern> patterns, TypePatternSubstitution substitutions) {
        if (substitutions == null)
            return;
        Pattern[] array = patterns.toArray(new Pattern[patterns.size()]);
        for (Pattern pattern : array) {
            EList<Pattern> substitutions2 = substitutions.getSubstitutions(pattern);
            if (substitutions2 != null) {
                int index = patterns.indexOf(pattern);
                patterns.remove(index);
                patterns.addAll(index, substitutions2);
            }
        }
        // Add patterns
        EList<Pattern> additions = substitutions.getSubstitutions(null);
        if (additions != null)
            patterns.addAll(additions);
    }

    public static void merge(TypePatternSubstitution result, TypePatternSubstitution addition) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
