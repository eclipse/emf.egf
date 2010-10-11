package org.eclipse.egf.usecase.activityworkflow.uc1.java;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;


//This Java task
//	1) Reads the "message" variable from the context
//	2) Changes the "message" value
//	3) Changes the "message" variable in the context with the new value  

public class HelloJava implements ITaskProduction {

	String message = new String();
	
	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

		// Get "message" value from context
		message  = productionContext.getInputValue("message", String.class);
	}

	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

		// Change "message" value
	    message = message + " from Java";

		
		// Display on console
		System.out.println(message);
		
		// Display in the EGF Console
	    EGFCorePlugin.getDefault().logInfo(message); 		  
	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

		// Change "message" value in the context
		productionContext.setOutputValue("message", message);
		
	}

}
