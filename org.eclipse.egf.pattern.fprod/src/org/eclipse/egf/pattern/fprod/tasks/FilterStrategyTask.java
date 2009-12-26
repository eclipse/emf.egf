package org.eclipse.egf.pattern.fprod.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.pattern.strategy.FilterStrategy;

public class FilterStrategyTask extends AbstractStrategyTask {

    public static final String FILTER_NAME_PARAMETER = "filterName";

    public FilterStrategyTask() {
        super(new FilterStrategy());
    }

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        parameter = context.getInputValue(FILTER_NAME_PARAMETER, String.class);
    }
}
