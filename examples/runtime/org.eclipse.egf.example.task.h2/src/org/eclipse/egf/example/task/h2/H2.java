package org.eclipse.egf.example.task.h2;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.task.IProductionTask;

public class H2 implements IProductionTask {

  public void preExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws CoreException, InvocationException {
    EGFCorePlugin.getDefault().logInfo("preExecute H2"); //$NON-NLS-1$
  }

  public void doExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws CoreException, InvocationException {
    EGFCorePlugin.getDefault().logInfo("doExecute H2"); //$NON-NLS-1$	  		  
  }

  public void postExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws CoreException, InvocationException {
    EGFCorePlugin.getDefault().logInfo("postExecute H2"); //$NON-NLS-1$	  		  
  }

}
