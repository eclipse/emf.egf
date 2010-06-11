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

package org.eclipse.egf.pattern.utils;

import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Thomas Guiu
 * 
 */
public class SubstitutionHelper {

    /**
     * This method applies the given substitutions to the given list of
     * patterns.
     * Improved implementation needed to enable the substitution of a pattern
     * added by a previous substitution.
     */
    public static void apply(List<Pattern> patterns, TypePatternSubstitution substitutions) {
        if (substitutions == null || substitutions.getSubstitutions().isEmpty() || patterns.isEmpty())
            return;
        // Add patterns
        EList<Pattern> additions = substitutions.getSubstitutions(null);
        if (additions != null)
            patterns.addAll(additions);

        for (Substitution substitution : substitutions.getSubstitutions()) {
            Pattern[] array = patterns.toArray(new Pattern[patterns.size()]);
            for (Pattern pattern : array) {
                Pattern target = substitution.getReplacedElement();
                if (target != null && pattern.getID().equals(target.getID())) {
                    int index = patterns.indexOf(pattern);
                    patterns.remove(index);
                    if (substitution.getReplacement() != null)
                        patterns.addAll(index, substitution.getReplacement());
                }
            }
        }

    }

    /**
     * This method applies the given substitutions to the given list of
     * patterns.
     * The current implementation only deals with simple cases.
     */
    public static void apply1(List<Pattern> patterns, TypePatternSubstitution substitutions) {
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

    public static TypePatternSubstitution merge(TypePatternSubstitution inputA, TypePatternSubstitution inputB) {
        TypePatternSubstitution result = PatternFactory.eINSTANCE.createTypePatternSubstitution();
        copySubstitutions(inputA, result);
        copySubstitutions(inputB, result);
        return result;
    }

    private static void copySubstitutions(TypePatternSubstitution input, TypePatternSubstitution result) {
        if (input == null) {
            return;
        }
        for (Substitution substitution : input.getSubstitutions()) {
            Substitution newSub = (Substitution) EcoreUtil.copy(substitution);
            result.getSubstitutions().add(newSub);
        }
    }
}
