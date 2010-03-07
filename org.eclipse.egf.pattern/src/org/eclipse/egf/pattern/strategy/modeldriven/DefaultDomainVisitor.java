package org.eclipse.egf.pattern.strategy.modeldriven;

import java.util.ArrayList;
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
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.utils.NsURIHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public abstract class DefaultDomainVisitor implements DomainVisitor {

    private final Map<String, List<Pattern>> type2patterns = new HashMap<String, List<Pattern>>(100);
    private final Set<Object> visited = new HashSet<Object>();

    public void setPatterns(Set<Pattern> patterns) throws PatternException {
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

    protected List<Pattern> findPatterns(Object model) {
        List<Pattern> result = null;
        if (model instanceof EObject) {
            String fullName = NsURIHelper.getFullName((EObject) model);
            result = type2patterns.get(fullName);
        } else
            throw new UnsupportedOperationException();
        return result;
    }

    public void visit(PatternContext context, Object model) throws PatternException {
        for (Object obj : getChildren(model)) {
            if (!visited.contains(obj))
                doProcess(context, obj);
            visit(context, obj);
        }
    }

    protected void doProcess(PatternContext context, Object model) throws PatternException {
        visited.add(model);
        List<Pattern> foundPattern = findPatterns(model);
        if (foundPattern == null || foundPattern.isEmpty())
            return;
        // TODO add filtering of patterns depending on pattern's preconditions
        executeWithInjection(foundPattern, context, model);
    }

    protected void executeWithInjection(Collection<Pattern> patterns, PatternContext context, Object... parameters) throws PatternException {
        for (Pattern pattern : patterns) {
            try {
                PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
                String canExecute = extension.canExecute(pattern);
                if (canExecute != null)
                    throw new PatternException(canExecute);
                extension.createEngine(pattern).executeWithInjection(context, parameters);
            } catch (MissingExtensionException e) {
                throw new PatternException(e);
            }
        }
    }

    public void dispose() {
        visited.clear();
        for (String key : type2patterns.keySet()) {
            type2patterns.get(key).clear();
        }
        type2patterns.clear();

    }

}
