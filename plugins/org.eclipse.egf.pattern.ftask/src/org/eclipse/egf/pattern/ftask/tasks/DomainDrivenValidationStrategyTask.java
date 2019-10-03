/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.egf.model.ftask.task.ValidationInvocationException;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * @author Matthieu Helleboid
 * 
 */
public class DomainDrivenValidationStrategyTask extends DomainDrivenStrategyTask {

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
        if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
        	ValidationInvocationException validationInvocationException = new ValidationInvocationException("Validation Error detected in " + context.getName());
        	validationInvocationException.setDiagnostic(diagnostic);
			throw validationInvocationException;
        }
    }

}
