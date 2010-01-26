package org.eclipse.egf.pattern.ftask.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.pattern.strategy.ModelDrivenStrategy;

public class ModelDrivenStrategyTask extends AbstractStrategyTask {

    public ModelDrivenStrategyTask() {
        super(new ModelDrivenStrategy());
    }

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        super.preExecute(context, monitor);
        parameter = this; // must be non null
    }
}
