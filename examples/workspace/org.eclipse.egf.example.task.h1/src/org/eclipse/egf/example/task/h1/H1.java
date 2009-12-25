package org.eclipse.egf.example.task.h1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.productionplan.invocation.IProductionTask;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;

public class H1 implements IProductionTask {

  private Integer quantity;

  private Float price;

  private Float amount;

  public void preExecute(final IProductionContext<Task> context, final IProgressMonitor monitor_p) throws InvocationException {
    quantity = context.getInputValue("quantity", Integer.class); //$NON-NLS-1$
    price = context.getInputValue("price", Float.class); //$NON-NLS-1$
    context.getOutputValue("generatorAdapterFactory", GenModelGeneratorAdapterFactory.class); //$NON-NLS-1$   
  }

  public void doExecute(final IProductionContext<Task> context, final IProgressMonitor monitor_p) throws InvocationException {
    amount = quantity * price;
  }

  public void postExecute(final IProductionContext<Task> context, final IProgressMonitor monitor_p) throws InvocationException {
    context.setOutputValue("amount", amount); //$NON-NLS-1$  		  
    context.setOutputValue("generatorAdapterFactory", new GenModelGeneratorAdapterFactory()); //$NON-NLS-1$
  }

}
