package org.eclipse.egf.example.task.h1;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;

public class H1 implements ITaskProduction {

  private Integer _quantity;

  private Float _price;

  private Float _amount;

  private Collection<String> _parameters;

  @SuppressWarnings("unchecked")
  public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    _quantity = context.getInputValue("quantity", Integer.class); //$NON-NLS-1$
    _price = context.getInputValue("price", Float.class); //$NON-NLS-1$
    _parameters = context.getInputValue("parameters", Collection.class); //$NON-NLS-1$
    context.getOutputValue("generatorAdapterFactory", GeneratorAdapterFactory.class); //$NON-NLS-1$
  }

  public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    _amount = _quantity * _price;
  }

  public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    context.setOutputValue("amount", _amount); //$NON-NLS-1$  		  
    context.setOutputValue("generatorAdapterFactory", new GenModelGeneratorAdapterFactory()); //$NON-NLS-1$
    _parameters = new ArrayList<String>();
    _parameters.add("param1"); //$NON-NLS-1$
    _parameters.add("param2"); //$NON-NLS-1$
    context.setOutputValue("parameters", _parameters); //$NON-NLS-1$
  }

}
