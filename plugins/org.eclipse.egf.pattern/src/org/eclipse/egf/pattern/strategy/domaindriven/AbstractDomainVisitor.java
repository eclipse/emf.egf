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

package org.eclipse.egf.pattern.strategy.domaindriven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.egf.model.pattern.DomainVisitor;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;
import org.eclipse.egf.pattern.utils.SubstitutionHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author Thomas Guiu
 */
public abstract class AbstractDomainVisitor implements DomainVisitor {

    protected static final Object[] EMPTY_ARRAY = new Object[0];

    protected final Map<String, List<Pattern>> type2patterns = new HashMap<String, List<Pattern>>(100);

    protected final Set<Object> visited = new HashSet<Object>();

    public void setPatterns(List<Pattern> patterns) throws PatternException {
        for (Pattern p : patterns) {
            EList<PatternParameter> parameters = p.getAllParameters();
            if (parameters.size() != 1)
                throw new PatternException(NLS.bind(EGFPatternMessages.strategy_error4, p.getName()));
            registerPattern(p, parameters.get(0));
        }
    }

    private void registerPattern(Pattern p, PatternParameter patternParameter) throws PatternException {
        String type = patternParameter.getType();
        List<Pattern> patterns = type2patterns.get(type);
        if (patterns == null) {
            try {
                // try to compute the associated classname, it will throw an
                // exception if the model is not available.
                String sourceTypeLiteral = ParameterTypeHelper.INSTANCE.getSourceTypeLiteral(type);
            } catch (Exception e) {

                throw new PatternException(NLS.bind(EGFPatternMessages.strategy_error5, p.getName()), e);
            }

            type2patterns.put(type, patterns = new ArrayList<Pattern>());
        }
        patterns.add(p);
    }

    protected List<Pattern> findPatterns(PatternContext context, Object model) throws PatternException {
        List<Pattern> result = findPatterns(model);

        if (result == null)
            return null;
        List<Object> parameterValues = Arrays.asList(model);
        return SubstitutionHelper.apply(context, result, parameterValues);
    }

    protected List<Pattern> findPatterns(Object model) {
        final Class<?> clazz = model.getClass();
        final List<Pattern> patterns = findPatternFromClass(clazz);
        if (patterns != null && !patterns.isEmpty())
            return patterns;
        final Class<?> superclass = clazz.getSuperclass();
        if (superclass == null)
            return null;
        return findPatternFromClass(superclass);
    }

    private List<Pattern> findPatternFromClass(Class<?> clazz) {
        List<Pattern> result = getPatterns(clazz);
        if (result == null || result.isEmpty()) {
            for (Class cls : clazz.getInterfaces()) {
                result = getPatterns(cls);
                if (result != null && !result.isEmpty())
                    return result;
            }
        }
        return result;
    }

    private List<Pattern> getPatterns(Class<?> clazz) {
        String fullName = clazz.getName();
        return type2patterns.get(fullName);
    }

    public void visit(PatternContext context, Object model) throws PatternException {
        for (Object obj : getChildren(model)) {
            if (!hasBeenVisited(obj))
                doProcess(context, obj);
            visit(context, obj);
        }
    }

    protected void doProcess(PatternContext context, Object model) throws PatternException {
        markVisited(model);
        List<Pattern> foundPattern = findPatterns(context, model);
        if (foundPattern == null || foundPattern.isEmpty())
            return;
        // TODO add filtering of patterns depending on pattern's preconditions
        executeWithInjection(foundPattern, context, model);
    }

    protected void executeWithInjection(Collection<Pattern> patterns, PatternContext context, Object model) throws PatternException {
        Node.Container currentNode = ((InternalPatternContext) context).getNode();
        for (Pattern pattern : patterns) {
            try {
                Map<PatternParameter, Object> parameters = createParameterMap(pattern, model);
                PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
                String canExecute = extension.canExecute(pattern);
                if (canExecute != null)
                    throw new PatternException(canExecute);
                PatternEngine engine = extension.createEngine(pattern);
                if (engine.checkCondition(context, parameters)) {
                    if (currentNode != null) {
                        Node.Container localNode = new Node.Container(currentNode, engine.getUnderlyingClassname());
                        ((InternalPatternContext) context).setNode(localNode);
                    }
                    engine.executeWithInjection(context, parameters);
                }
            } catch (MissingExtensionException e) {
                throw new PatternException(e);
            }
        }
        ((InternalPatternContext) context).setNode(currentNode);
    }

    private Map<PatternParameter, Object> createParameterMap(Pattern pattern, Object model) {
        Map<PatternParameter, Object> parameters = new HashMap<PatternParameter, Object>();
        parameters.put(pattern.getAllParameters().get(0), model);
        return parameters;
    }

    public void dispose() {
        visited.clear();
        for (String key : type2patterns.keySet()) {
            type2patterns.get(key).clear();
        }
        type2patterns.clear();

    }

    protected boolean hasBeenVisited(Object obj) {
        return visited.contains(obj);
    }

    protected void markVisited(Object model) {
        visited.add(model);
    }

}
