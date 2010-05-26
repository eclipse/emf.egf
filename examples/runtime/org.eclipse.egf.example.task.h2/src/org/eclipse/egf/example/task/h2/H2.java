package org.eclipse.egf.example.task.h2;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

public class H2 implements ITaskProduction {

  public void preExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    // Nothing to do
  }

  public void doExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    // Nothing to do
  }

  public void postExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    // Nothing to do
  }

}
