package org.eclipse.egf.pattern.ftask.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.pattern.strategy.DefaultStrategy;

public class DefaultStrategyTask extends AbstractStrategyTask {

  public DefaultStrategyTask() {
    super(new DefaultStrategy());
  }

  @Override
  public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    super.preExecute(context, monitor);
    parameter = this; // must be non null
  }
}
