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
import java.util.Set;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.strategy.AbstractStrategy;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Thomas Guiu
 * 
 */
public class ModelDrivenStrategy extends AbstractStrategy {

    public void execute(PatternContext context, Object parameter) throws PatternException, MissingExtensionException {
        Set<Pattern> result = new HashSet<Pattern>(100);
        PatternCollector.INSTANCE.collect(patternElements, result);

        EList<EObject> model = (EList<EObject>) context.getValue(PatternContext.DOMAIN_OBJECTS);

        final EmfModelVisitor visitor = new EmfModelVisitor();
        visitor.setPatterns(result);
        // CallBackHandler handler = new ModelDrivenCallBackHandler(visitor);
        // context.setValue(PatternContext.CALL_BACK_HANDLER, handler);
        for (EObject obj : model)
            visitor.visit(context, obj);
    }

}
