package org.eclipse.egf.examples.uc1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;

public class HelloWorld implements ITaskProduction {

	@Override
	public void doExecute(ITaskProductionContext taskProductionContext,
			IProgressMonitor monitor) throws InvocationException {
		String value  = taskProductionContext.getInputValue("value", String.class);
		String outputMessage = new String ("Hello " + value + "!");
		// Message on the default console
		System.out.println(outputMessage);
		// Message on the EGF console
	    EGFCorePlugin.getDefault().logInfo(outputMessage); 		  

	}

	@Override
	public void postExecute(ITaskProductionContext taskProductionContext,
			IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void preExecute(ITaskProductionContext taskProductionContext,
			IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub

	}

}
