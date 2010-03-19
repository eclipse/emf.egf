package org.eclipse.egf.example.task.h2;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

public class H2 implements ITaskProduction {

  public void preExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    EGFCorePlugin.getDefault().logInfo("preExecute H2"); //$NON-NLS-1$
  }

  public void doExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    throw new InvocationException("I'm a task who raised an exception"); //$NON-NLS-1$
  }

  public void postExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
    EGFCorePlugin.getDefault().logInfo("postExecute H2"); //$NON-NLS-1$	  		  
  }

}
