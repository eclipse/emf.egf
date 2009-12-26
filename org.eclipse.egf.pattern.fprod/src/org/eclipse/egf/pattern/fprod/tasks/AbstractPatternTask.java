package org.eclipse.egf.pattern.fprod.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.osgi.framework.Bundle;

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

    protected PatternContext createPatternContext(final ITaskProductionContext prodCtx) {
        return new PatternContext(new BundleAccessor() {

            @Override
            public Bundle getBundle(String id) throws PatternException {

                try {
                    return prodCtx.getBundle(id);
                } catch (InvocationException e) {
                    // TODO on devrait pouvoir mieux gérer les exceptions,
                    // là on empile .. ce serait mieux de transmettre
                    // l'exception originale
                    throw new PatternException(e);
                }
            }
        });
    }

}
