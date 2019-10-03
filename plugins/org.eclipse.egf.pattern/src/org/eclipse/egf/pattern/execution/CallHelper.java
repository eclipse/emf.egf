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

package org.eclipse.egf.pattern.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.CallBackHandler;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternRuntimeException;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.utils.SubstitutionHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.osgi.util.NLS;

/**
 * This is an helper class to ease translation of patterns.
 * 
 * @author Thomas Guiu
 * 
 */
public class CallHelper {

    public static void executeWithContextInjection(String patternURI, PatternContext ctx) {

        try {
            List<Pattern> patterns = getPatterns(patternURI, ctx);
            TypePatternSubstitution substitutions = (TypePatternSubstitution) ctx.getValue(PatternContext.PATTERN_SUBSTITUTIONS);
            SubstitutionHelper.apply(patterns, substitutions);

            for (Pattern pattern : patterns) {
                PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
                String reason = extension.canExecute(pattern);
                if (reason != null)
                    throw new PatternException(reason);
                extension.createEngine(pattern).execute(ctx);
            }
        } catch (PatternException e) {
            throw new PatternRuntimeException(e);
        } catch (MissingExtensionException e) {
            throw new PatternRuntimeException(e);
        }
    }

    public static void executeWithParameterInjection(String patternURI, PatternContext ctx, Map<String, Object> name2parameterValue) {
        try {
            List<Pattern> patterns = getPatterns(patternURI, ctx);
            Pattern originalPattern = patterns.get(0);
            List<Object> values = new ArrayList<Object>(originalPattern.getAllParameters().size());
            for (PatternParameter param : originalPattern.getAllParameters()) {
                Object value = name2parameterValue.get(param.getName());
                values.add(value);
            }

            List<Pattern> substituedPatterns = SubstitutionHelper.apply(ctx, patterns, values);

            for (Pattern pattern : substituedPatterns) {
                PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
                String reason = extension.canExecute(pattern);
                if (reason != null)
                    throw new PatternException(reason);
                Map<PatternParameter, Object> parameters = new HashMap<PatternParameter, Object>();
                for (Map.Entry<String, Object> entry : name2parameterValue.entrySet()) {
                    PatternParameter parameter = pattern.getParameter(entry.getKey());
                    if (parameter == null)
                        throw new PatternException(NLS.bind(EGFPatternMessages.call_execution_error1, entry.getKey(), pattern.getName()));
                    parameters.put(parameter, entry.getValue());
                }
                PatternEngine engine = extension.createEngine(pattern);
                if (engine.checkCondition(ctx, parameters))
                    engine.executeWithInjection(ctx, parameters);
            }
        } catch (PatternException e) {
            throw new PatternRuntimeException(e);
        } catch (MissingExtensionException e) {
            throw new PatternRuntimeException(e);
        }
    }

    private static List<Pattern> getPatterns(String patternURI, PatternContext ctx) throws PatternException {
        List<Pattern> patterns = new ArrayList<Pattern>();

        if (patternURI == null)
            throw new PatternException(EGFPatternMessages.call_execution_error3);
        ResourceSet resourceSet = (ResourceSet) ctx.getValue(PatternContext.PATTERN_RESOURCESET);
        if (resourceSet == null)
            throw new PatternException(EGFPatternMessages.call_execution_error2);
        URI uri = URI.createURI(patternURI, false);

        Pattern targetPattern = (Pattern) resourceSet.getEObject(uri, true);

        if (targetPattern == null)
            throw new PatternException(NLS.bind(EGFPatternMessages.call_execution_error4, patternURI));
        patterns.add(targetPattern);
        return patterns;
    }

    public static void callBack(PatternContext ctx, Map<String, Object> parameters) {
        try {
            CallBackHandler handler = (CallBackHandler) ctx.getValue(PatternContext.CALL_BACK_HANDLER);
            if (handler == null)
                EGFPatternPlugin.getDefault().logWarning(EGFPatternMessages.missing_callback_handler);
            else
                handler.handleCall(ctx, parameters);
        } catch (PatternException e) {
            throw new PatternRuntimeException(e);
        }
    }

    private CallHelper() {
        super();

    }

}
