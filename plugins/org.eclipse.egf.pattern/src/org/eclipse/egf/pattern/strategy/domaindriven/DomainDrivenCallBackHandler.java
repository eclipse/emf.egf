/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.strategy.domaindriven;

import java.util.Map;

import org.eclipse.egf.model.pattern.CallBackHandler;
import org.eclipse.egf.model.pattern.DomainVisitor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;

/**
 * @author Thomas Guiu
 * 
 */
public class DomainDrivenCallBackHandler implements CallBackHandler {
    public void handleCall(PatternContext ctx, Map<String, Object> parameters) throws PatternException {
        if (parameters.size() != 1)
            throw new IllegalStateException(EGFPatternMessages.model_driven_strategy_error1);

        DomainVisitor visitor = (DomainVisitor) ctx.getValue(PatternContext.DOMAIN_DRIVEN_STRATEGY_VISITOR);
        if (visitor != null)
            visitor.visit(ctx, parameters.values().iterator().next());
    }
}
