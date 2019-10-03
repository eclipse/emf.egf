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

package org.eclipse.egf.pattern.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Thomas Guiu
 * 
 */
public class SubstitutionHelper {

    /**
     * This method applies the given substitutions to the given list of
     * patterns. Substitution is performed only if one candidate for replacement
     * can be executed (i.e. the preCondition is true)
     */
    public static List<Pattern> apply(PatternContext context, List<Pattern> patterns1, List<Object> parameterValues) throws PatternException {
        TypePatternSubstitution substitutions = (TypePatternSubstitution) context.getValue(PatternContext.PATTERN_SUBSTITUTIONS);
        if (substitutions == null || substitutions.getSubstitutions().isEmpty() || patterns1.isEmpty())
            return patterns1;

        List<Pattern> patterns = new ArrayList<Pattern>(patterns1);
        for (Substitution substitution : substitutions.getSubstitutions()) {
            Pattern[] array = patterns.toArray(new Pattern[patterns.size()]);
            for (Pattern pattern : array) {
                Pattern target = substitution.getReplacedElement();
                if (target != null && pattern.getID().equals(target.getID())) {
                    // if (!checkCondition(context, target, parameterValues)) {
                    // // if the pattern won't be applied, no need to
                    // // substitute it.
                    // continue;
                    // }

                    int index = patterns.indexOf(pattern);
                    EList<Pattern> replacement = substitution.getReplacement();
                    if (replacement != null) {
                        if (replacement.isEmpty()) {
                            patterns.remove(index);
                        } else {

                            // substitute patterns if at least one pattern from
                            // replacement list can apply
                            List<Pattern> toAdd = new ArrayList<Pattern>(replacement.size());
                            for (Pattern replacementPattern : replacement) {
                                if (checkCondition(context, replacementPattern, parameterValues)) {
                                    toAdd.add(replacementPattern);
                                }
                            }
                            if (!toAdd.isEmpty()) {
                                patterns.remove(index);
                                patterns.addAll(index, replacement);
                            }
                        }
                    }
                    break;
                }
            }
        }

        return patterns;
    }

    private static boolean checkCondition(PatternContext context, Pattern replacementPattern, List<Object> parameterValues) throws PatternException {
        try {

            PatternExtension extension = ExtensionHelper.getExtension(replacementPattern.getNature());
            Map<PatternParameter, Object> parameters = new HashMap<PatternParameter, Object>();
            if (replacementPattern.getAllParameters().size() != parameterValues.size())
                return false;
            int nb = replacementPattern.getAllParameters().size();
            for (int i = 0; i < nb; i++) {
                parameters.put(replacementPattern.getAllParameters().get(i), parameterValues.get(i));
            }
            return extension.createEngine(replacementPattern).checkCondition(context, parameters);
        } catch (MissingExtensionException e) {
            throw new PatternException(e);
        }

    }

    public static void apply(List<Pattern> patterns, TypePatternSubstitution substitutions) {
        if (substitutions == null || substitutions.getSubstitutions().isEmpty() || patterns.isEmpty())
            return;

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

    public static TypePatternSubstitution merge(TypePatternSubstitution inputA, TypePatternSubstitution inputB) {
        TypePatternSubstitution result = PatternFactory.eINSTANCE.createTypePatternSubstitution();
        copySubstitutions(inputA, result);
        copySubstitutions(inputB, result);
        return result;
    }

    @SuppressWarnings("cast")
    private static void copySubstitutions(TypePatternSubstitution input, TypePatternSubstitution result) {
        if (input == null) {
            return;
        }
        for (Substitution substitution : input.getSubstitutions()) {
            // Preserve cast for backward compatibility
            Substitution newSub = (Substitution) EcoreUtil.copy(substitution);
            result.getSubstitutions().add(newSub);
        }
    }

}
