package org.eclipse.egf.example.task.h1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.task.IProductionTask;

public class H1 implements IProductionTask {
	
  private Integer quantity;
  
  private Float price;  
  
  private Float amount;

  public void preExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
	  quantity = productionContext.getValue("quantity", Integer.class); //$NON-NLS-1$
	  price = productionContext.getValue("price", Float.class); //$NON-NLS-1$
  }

  public void doExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
	  amount = quantity * price;
  }

  public void postExecute(final IProductionContext productionContext, final IProgressMonitor monitor_p) throws InvocationException {
	  productionContext.setValue("amount", amount); //$NON-NLS-1$	  		  
  }

}
