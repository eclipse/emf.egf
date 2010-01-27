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

import org.eclipse.egf.model.pattern.CallBackHandler;
import org.eclipse.egf.model.pattern.DomainVisitor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.Activator;

/**
 * @author Thomas Guiu
 * 
 */
public class ModelDrivenCallBackHandler implements CallBackHandler {
    public void handleCall(PatternContext ctx, Object model) {
        try {
            DomainVisitor visitor = (DomainVisitor) ctx.getValue(PatternContext.MODEL_DRIVEN_DOMAIN_VISITOR);
            if (visitor != null)
                visitor.visit(ctx, model);
        } catch (PatternException e) {
            Activator.getDefault().logError(e);
        }
    }
}
