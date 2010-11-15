package org.eclipse.egf.example.task.h1;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.emf.codegen.merge.java.JMerger;

public class H1 implements ITaskProduction {

  private Integer quantity;

  private Float price;

  private Float amount;

  public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    quantity = context.getInputValue("quantity", Integer.class); //$NON-NLS-1$
    price = context.getInputValue("price", Float.class); //$NON-NLS-1$
    context.getInputValue("parameters", Collection.class); //$NON-NLS-1$
    context.getOutputValue("jmerger", JMerger.class); //$NON-NLS-1$       
  }

  public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    amount = quantity * price;
  }

  public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    context.setOutputValue("amount", amount); //$NON-NLS-1$       
    context.setOutputValue("jmerger", new JMerger()); //$NON-NLS-1$
    Activator.getDefault().logInfo("Quantity : " + quantity); //$NON-NLS-1$
    Activator.getDefault().logInfo("Price : " + price); //$NON-NLS-1$
    Activator.getDefault().logInfo("Amount : " + amount); //$NON-NLS-1$
  }

}
