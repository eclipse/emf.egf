package org.eclipse.egf.pattern.fprod.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.pattern.strategy.FilterStrategy;

public class FilterStrategyTask extends AbstractStrategyTask {

  public static final String FILTER_NAME_PARAMETER = "filter.name"; //$NON-NLS-1$

  public FilterStrategyTask() {
    super(new FilterStrategy());
  }

  @Override
  public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    super.preExecute(context, monitor);
    parameter = context.getInputValue(FILTER_NAME_PARAMETER, String.class);
  }
}
