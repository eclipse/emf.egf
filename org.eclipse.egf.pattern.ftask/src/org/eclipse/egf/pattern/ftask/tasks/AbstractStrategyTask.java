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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.model.pattern.TypePatternList;
import org.eclipse.egf.pattern.execution.ConsoleReporter;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.ftask.Messages;
import org.eclipse.egf.pattern.strategy.Strategy;

/**
 * @author Thomas Guiu
 */
public abstract class AbstractStrategyTask extends AbstractPatternTask {
    private final Strategy strategy;
    protected Object parameter;
    protected final List<PatternElement> patterns = new ArrayList<PatternElement>();

    protected AbstractStrategyTask(Strategy strategy) {
        this.strategy = strategy;
    }

    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.readContext(context, ctx);
        PatternExecutionReporter reporter = (PatternExecutionReporter) ctx.getValue(PatternContext.PATTERN_REPORTER);
        if (reporter == null)
            reporter = new ConsoleReporter();
        ctx.setValue(PatternContext.PATTERN_REPORTER, reporter);
    }

    @Override
    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        TypePatternList patternList = context.getInputValue(PatternContext.PATTERN_IDS_PARAMETER, TypePatternList.class);
        if (patternList != null)
            patterns.addAll(patternList.getElements());
    }

    @Override
    public final void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        if (parameter == null)
            throw new InvocationException(Messages.taskInvocation_error1);
        if (patterns.isEmpty())
            // Activator.getDefault().logWarning(Messages.taskInvocation_error3);
            throw new InvocationException(Messages.taskInvocation_error3);

        try {
            PatternContext ctx = createPatternContext(context);
            readContext(context, ctx);
            strategy.setPatternElements(patterns);
            strategy.execute(ctx, parameter);
            writeContext(context, ctx);
        } catch (MissingExtensionException e) {
            throw new InvocationException(e);
        } catch (PatternException e) {
            throw new InvocationException(e);
        }
    }

    @Override
    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        super.postExecute(context, monitor);
        parameter = null;
    }
}
