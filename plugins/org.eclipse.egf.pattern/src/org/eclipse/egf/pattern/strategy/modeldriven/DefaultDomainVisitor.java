package org.eclipse.egf.pattern.strategy.modeldriven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.egf.model.pattern.DomainVisitor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.utils.SubstitutionHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public abstract class DefaultDomainVisitor implements DomainVisitor {

    private final Map<String, List<Pattern>> type2patterns = new HashMap<String, List<Pattern>>(100);

    protected final Set<Object> visited = new HashSet<Object>();

    public void setPatterns(List<Pattern> patterns) throws PatternException {
        for (Pattern p : patterns) {
            EList<PatternParameter> parameters = p.getAllParameters();
            if (parameters.size() != 1)
                throw new PatternException(Messages.bind(Messages.strategy_error4, p.getName()));
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

    protected List<Pattern> findPatterns(PatternContext context, Object model) throws PatternException {
        List<Pattern> result = null;
        if (model instanceof EObject) {
            String fullName = Activator.getEPackageHelper().getFullName((EObject) model);
            result = type2patterns.get(fullName);
        } else
            throw new UnsupportedOperationException();

        if (result == null)
            return null;
        List<Object> parameterValues = Arrays.asList(model);
        return SubstitutionHelper.apply(context, result, parameterValues);
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
        for (Pattern pattern : patterns) {
            try {
                Map<PatternParameter, Object> parameters = createParameterMap(pattern, model);
                PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
                String canExecute = extension.canExecute(pattern);
                if (canExecute != null)
                    throw new PatternException(canExecute);
                PatternEngine engine = extension.createEngine(pattern);
                if (engine.checkCondition(context, parameters))
                    engine.executeWithInjection(context, parameters);
            } catch (MissingExtensionException e) {
                throw new PatternException(e);
            }
        }
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
