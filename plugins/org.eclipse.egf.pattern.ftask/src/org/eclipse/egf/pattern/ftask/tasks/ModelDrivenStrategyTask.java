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
package org.eclipse.egf.pattern.ftask.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.pattern.strategy.modeldriven.ModelDrivenStrategy;

/**
 * @author Thomas Guiu
 */
public class ModelDrivenStrategyTask extends AbstractStrategyTask {

    private StrategyReporter reporter;

    public ModelDrivenStrategyTask() {
        super(new ModelDrivenStrategy());
    }

    @Override
    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.readContext(context, ctx);
        PatternExecutionReporter innerReporter = (PatternExecutionReporter) ctx.getValue(PatternContext.PATTERN_REPORTER);
        ctx.setValue(PatternContext.PATTERN_REPORTER, reporter = new StrategyReporter(innerReporter));
    }

    @Override
    protected void writeContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.writeContext(context, ctx);
        reporter.executionFinished(ctx);
    }

    @Override
    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        super.preExecute(context, monitor);
        parameter = this; // must be non null
    }

}
