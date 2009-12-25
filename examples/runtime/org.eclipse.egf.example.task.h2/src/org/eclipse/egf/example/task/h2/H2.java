package org.eclipse.egf.example.task.h2;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.task.IProductionTask;

public class H2 implements IProductionTask {

  public void preExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    EGFCorePlugin.getDefault().logInfo("preExecute H2"); //$NON-NLS-1$
  }

  public void doExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    throw new InvocationException("I'm a task who raised an exception"); //$NON-NLS-1$
  }

  public void postExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    EGFCorePlugin.getDefault().logInfo("postExecute H2"); //$NON-NLS-1$	  		  
  }

}
