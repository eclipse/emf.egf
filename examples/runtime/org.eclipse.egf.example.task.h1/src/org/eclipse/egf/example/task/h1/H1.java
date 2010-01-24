package org.eclipse.egf.example.task.h1;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;

public class H1 implements ITaskProduction {

  private Integer quantity;

  private Float price;

  private Float amount;

  private Collection<String> parameters;

  @SuppressWarnings("unchecked")
  public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    quantity = context.getInputValue("quantity", Integer.class); //$NON-NLS-1$
    price = context.getInputValue("price", Float.class); //$NON-NLS-1$
    parameters = context.getInputValue("parameters", Collection.class); //$NON-NLS-1$
    context.getOutputValue("generatorAdapterFactory", GeneratorAdapterFactory.class); //$NON-NLS-1$       
  }

  public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    amount = quantity * price;
  }

  public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    context.setOutputValue("amount", amount); //$NON-NLS-1$       
    context.setOutputValue("generatorAdapterFactory", new GenModelGeneratorAdapterFactory()); //$NON-NLS-1$
  }

}
