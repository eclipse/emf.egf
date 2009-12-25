package org.eclipse.egf.example.task.h1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.invocation.IProduction;
import org.eclipse.egf.model.productionplan.Task;

public class H1 implements IProduction<Task> {

  public void preExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    Activator.getDefault().logInfo("preExecute Modified H1"); //$NON-NLS-1$
  }

  public void doExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    throw new InvocationException("I'm a task who raised an exception"); //$NON-NLS-1$
  }

  public void postExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    Activator.getDefault().logInfo("postExecute Modified H1"); //$NON-NLS-1$	  		  
  }

}
