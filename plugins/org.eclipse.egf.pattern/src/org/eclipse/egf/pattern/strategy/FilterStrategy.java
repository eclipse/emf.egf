package org.eclipse.egf.pattern.strategy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * This base class gathers code to compute the Pattern list from the given
 * PatternElement objects prior to execution.
 * 
 * 
 * @author Thomas Guiu
 * 
 */

public class FilterStrategy extends AbstractPatternStrategy {

    private static final String OK = "ok"; //$NON-NLS-1$

    private static final class FilterSwitch extends PatternSwitch<String> {

        private final String filter;

        private final Set<Pattern> result;

        private final TypePatternSubstitution substitutions;

        private FilterSwitch(String filter, Set<Pattern> result, TypePatternSubstitution substitutions) {
            this.filter = filter;
            this.result = result;
            this.substitutions = substitutions;
        }

        @Override
        public String casePattern(Pattern object) {
            result.add(object);
            return OK;
        }

        @Override
        public String casePatternLibrary(PatternLibrary object) {
            EList<PatternElement> list = object.getFilters().get(filter);
            if (list != null) {
                for (PatternElement elem : list) {
                    String error = doSwitch(elem);
                    if (error != null && !OK.equals(error))
                        return error;
                }
            }
            return OK;
        }

        @Override
        public String defaultCase(EObject object) {
            return Messages.bind(Messages.strategy_error1, object);
        }

    }

    public void execute(PatternContext context, Object parameter) throws PatternException, MissingExtensionException {
        if (parameter == null)
            throw new PatternException(Messages.strategy_error3);
        if (!(parameter instanceof String))
            throw new PatternException(Messages.bind(Messages.strategy_error2, "String", parameter.getClass().getName())); //$NON-NLS-1$

        String filter = (String) parameter;
        TypePatternSubstitution substitutions = (TypePatternSubstitution) context.getValue(PatternContext.PATTERN_SUBSTITUTIONS);

        List<Pattern> patterns = getPatterns(filter, substitutions);

        doExecute(patterns, context);
    }

    /**
     * This methods returns a list of the elements from patternElements field.
     * The order is computed by using registered scheduling rules. If the rule
     * can't be found the natural ordering is used.
     * 
     * @param substitutions
     */
    protected List<Pattern> getPatterns(final String filter, TypePatternSubstitution substitutions) throws PatternException {
        PatternElement[] elements = patternElements;
        final Set<Pattern> result = new LinkedHashSet<Pattern>(elements.length * 2);
        PatternSwitch<String> switch_ = new FilterSwitch(filter, result, substitutions);
        for (PatternElement elem : elements) {
            String error = switch_.doSwitch(elem);
            if (error != null && !OK.equals(error))
                throw new PatternException(error);
        }

        return new ArrayList<Pattern>(result);
    }

}
