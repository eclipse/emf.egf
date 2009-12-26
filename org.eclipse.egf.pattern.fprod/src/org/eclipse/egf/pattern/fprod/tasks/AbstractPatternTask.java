package org.eclipse.egf.pattern.fprod.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.fcore.ActivityContract;

public abstract class AbstractPatternTask implements ITaskProduction {

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    protected void writeContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        for (ActivityContract ac : context.getOutputValueKeys()) {
            context.setOutputValue(ac.getName(), ctx.getValue(ac.getName()));
        }
    }

    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        for (ActivityContract ac : context.getInputValueKeys()) {
            ctx.setValue(ac.getName(), context.getInputValue(ac.getName(), ac.getType().getType()));
        }
    }

}
