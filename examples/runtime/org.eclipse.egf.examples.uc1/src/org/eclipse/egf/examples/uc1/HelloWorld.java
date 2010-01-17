package org.eclipse.egf.examples.uc1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;

public class HelloWorld implements ITaskProduction {

  public void doExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
    String value = taskProductionContext.getInputValue("value", String.class); //$NON-NLS-1$
    String outputMessage = new String("Hello " + value + "!"); //$NON-NLS-1$ //$NON-NLS-2$
    // Message on the default console
    System.out.println(outputMessage);
    // Message on the EGF console
    EGFCorePlugin.getDefault().logInfo(outputMessage);

  }

  public void postExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
    // TODO Auto-generated method stub

  }

  public void preExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
    // TODO Auto-generated method stub

  }

}
