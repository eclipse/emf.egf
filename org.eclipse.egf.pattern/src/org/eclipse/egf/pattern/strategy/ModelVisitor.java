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

package org.eclipse.egf.pattern.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.utils.NsURIHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * TODO: improve pattern selection: At present time, the selection is done via
 * type matching. We can imagine a custom matching policy (for example a pattern
 * can apply if and only if the model element is named 'toto')
 * 
 * @author Thomas Guiu
 * 
 */
public class ModelVisitor {
    private static final List<Object> EMPTY_LIST = new ArrayList<Object>();

    private final Map<String, List<Pattern>> type2patterns = new HashMap<String, List<Pattern>>(100);

    public ModelVisitor(Set<Pattern> result) throws PatternException {
        super();
        for (Pattern p : result) {
            EList<PatternParameter> parameters = p.getAllParameters();
            if (parameters.size() != 1)
                throw new PatternException("The pattern needs exactly one parameter.");
            registerPattern(p, parameters.get(0));
        }
    }

    private void registerPattern(Pattern p, PatternParameter patternParameter) {
        String type = patternParameter.getType();
        List<Pattern> patterns = type2patterns.get(type);
        if (patterns == null)
            type2patterns.put(type, patterns = new ArrayList<Pattern>());
        patterns.add(p);
    }

    public void visit(PatternContext context, List<?> model) throws MissingExtensionException, PatternException {
        for (Object obj : model) {
            if (!process(context, obj))
                visit(context, obj);
        }
    }

    public void visit(PatternContext context, Object model) throws MissingExtensionException, PatternException {
        visit(context, getChildren(model));
    }

    protected boolean process(PatternContext context, Object model) throws MissingExtensionException, PatternException {
        List<Pattern> foundPattern = findPatterns(model);
        if (foundPattern == null || foundPattern.isEmpty())
            return false;
        return executeWithInjection(foundPattern, context, model);
    }

    protected List<Pattern> findPatterns(Object model) {
        List<Pattern> result = null;
        if (model instanceof EObject) {
            String fullName = NsURIHelper.getFullName((EObject) model);
            result = type2patterns.get(fullName);
        } else
            throw new UnsupportedOperationException();
        return result;
    }

    protected boolean executeWithInjection(Collection<Pattern> patterns, PatternContext context, Object... parameters) throws MissingExtensionException, PatternException {
        for (Pattern pattern : patterns) {
            PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
            String canExecute = extension.canExecute(pattern);
            if (canExecute != null)
                throw new PatternException(canExecute);
            extension.createEngine(pattern).executeWithInjection(context, parameters);
        }
        return true;
    }

    public List<?> getChildren(Object model) {
        // a implementer par les users en fct du model
        if (model instanceof EObject)
            return ((EObject) model).eContents();
        return EMPTY_LIST;
    }

}