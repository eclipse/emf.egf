/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.usecase.fc.uc1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Benoit Langlois
 * 
 */

public class PricerDisplay  implements ITaskProduction {

	private static final String PRICE_PARAMETER = "price"; 
	private static final String QUANTITY_PARAMETER = "quantity"; 
	private static final String AMOUNT_PARAMETER = "amount"; 

	private Integer quantity; 
	private Float price; 
	private Float amount; 

	public void preExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub
	}

	public void doExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
		quantity = taskProductionContext.getInputValue(QUANTITY_PARAMETER, Integer.class);
		price = taskProductionContext.getInputValue(PRICE_PARAMETER, Float.class);
		amount = taskProductionContext.getInputValue(AMOUNT_PARAMETER, Float.class);

		String message = new String ("Pricer: " + quantity + " * " + price + " = " + amount);

		// Message on the default console
		System.out.println(message);

		// Message on the EGF console
		EGFCorePlugin.getDefault().logInfo(message);
	}

	public void postExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub
	}

}
