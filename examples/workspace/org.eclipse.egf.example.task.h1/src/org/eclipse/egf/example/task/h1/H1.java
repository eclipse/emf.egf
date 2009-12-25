package org.eclipse.egf.example.task.h1;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.task.IProductionTask;

public class H1 implements IProductionTask {

  public void preExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws CoreException, InvocationException {
    Activator.getDefault().logInfo("preExecute H1"); //$NON-NLS-1$
  }

  public void doExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws CoreException, InvocationException {
    Activator.getDefault().logInfo("doExecute H1"); //$NON-NLS-1$	  		  
  }

  public void postExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws CoreException, InvocationException {
    Activator.getDefault().logInfo("postExecute H1"); //$NON-NLS-1$	  		  
  }

}
