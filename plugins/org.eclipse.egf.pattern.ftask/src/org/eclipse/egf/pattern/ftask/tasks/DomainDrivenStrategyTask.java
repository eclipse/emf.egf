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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.pattern.strategy.domaindriven.DomainDrivenStrategy;

/**
 * @author Thomas Guiu
 */
public class DomainDrivenStrategyTask extends AbstractStrategyTask {

    private StrategyReporter reporter;

    public DomainDrivenStrategyTask() {
        super(new DomainDrivenStrategy());
    }

    @Override
    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.readContext(context, ctx);
        PatternExecutionReporter innerReporter = (PatternExecutionReporter) ctx.getValue(PatternContext.PATTERN_REPORTER);
        ctx.setValue(PatternContext.PATTERN_REPORTER, this.reporter = new StrategyReporter(innerReporter));
    }

    @Override
    protected void writeContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        reporter.executionFinished(ctx);
        super.writeContext(context, ctx);
    }

    @Override
    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        super.preExecute(context, monitor);
        parameter = this; // must be non null
    }

}
