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

package org.eclipse.egf.pattern.strategy.modeldriven;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.DomainVisitor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.strategy.AbstractStrategy;
import org.eclipse.emf.common.util.EList;

/**
 * @author Thomas Guiu
 * 
 */
public class ModelDrivenStrategy extends AbstractStrategy {

    @SuppressWarnings("unchecked")
    public void execute(PatternContext context, Object parameter) throws PatternException, MissingExtensionException {
        List<Pattern> result = new ArrayList<Pattern>(100);
        PatternCollector.INSTANCE.collect(patternElements, result);

        TypePatternSubstitution substitutions = (TypePatternSubstitution) context.getValue(PatternContext.PATTERN_SUBSTITUTIONS);
        if (substitutions != null) {
            EList<Pattern> additions = substitutions.getSubstitutions(null);
            if (additions != null)
                result.addAll(additions);
        }
        List<Object> model = (List<Object>) context.getValue(PatternContext.DOMAIN_OBJECTS);

        final DomainVisitor visitor = (DomainVisitor) context.getValue(PatternContext.MODEL_DRIVEN_DOMAIN_VISITOR);
        visitor.setPatterns(result);
        try {
            visitor.visit(context, model);
        } finally {
            visitor.dispose();
        }
    }

}
