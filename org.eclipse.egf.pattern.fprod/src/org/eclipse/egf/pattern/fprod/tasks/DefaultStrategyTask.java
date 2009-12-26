package org.eclipse.egf.pattern.fprod.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.pattern.strategy.DefaultStrategy;

public class DefaultStrategyTask extends AbstractStrategyTask {

    public DefaultStrategyTask() {
        super(new DefaultStrategy());
    }

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        super.preExecute(context, monitor_p);
        parameter = this; // must be non null
    }
}
