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

package org.eclipse.egf.pattern.strategy.modeldriven;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.pattern.DomainVisitor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.strategy.AbstractStrategy;

/**
 * @author Thomas Guiu
 * 
 */
public class ModelDrivenStrategy extends AbstractStrategy {

    public void execute(PatternContext context, Object parameter) throws PatternException, MissingExtensionException {
        Set<Pattern> result = new HashSet<Pattern>(100);
        PatternCollector.INSTANCE.collect(patternElements, result);

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
