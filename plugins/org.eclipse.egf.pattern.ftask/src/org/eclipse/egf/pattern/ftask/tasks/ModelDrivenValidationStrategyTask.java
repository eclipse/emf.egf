/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ftask.tasks;

import java.util.List;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ModelDrivenValidationStrategyTask extends ModelDrivenStrategyTask {

    private static final String DIAGNOSTIC = "diagnostic"; //$NON-NLS-1$

    @Override
    @SuppressWarnings("unchecked")
    protected void readContext(ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.readContext(context, ctx);
        List<EObject> objects = (List<EObject>) ctx.getValue(PatternContext.DOMAIN_OBJECTS);

        Diagnostic diagnostic = null;
        Diagnostician diagnostician = new Diagnostician();
        for (EObject eObject : objects) {
            if (diagnostic == null)
                diagnostic = diagnostician.validate(eObject);
            else
                diagnostician.validate(eObject, (DiagnosticChain) diagnostic);
        }

        ctx.setValue(DIAGNOSTIC, diagnostic);
    }

    @Override
    protected void writeContext(ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.writeContext(context, ctx);

        Diagnostic diagnostic = (Diagnostic) context.getOutputValue(DIAGNOSTIC, Object.class);
        if (diagnostic.getSeverity() >= Diagnostic.WARNING)
            System.out.println(diagnostic);

        if (diagnostic.getSeverity() == Diagnostic.ERROR)
            throw new RuntimeException(diagnostic.getMessage());
    }
}
