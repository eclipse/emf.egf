/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.usecase.fc.uc1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Benoit Langlois
 * 
 */

public class PricerComputation implements ITaskProduction {

  private static final String PRICE_PARAMETER = "price"; //$NON-NLS-1$

  private static final String QUANTITY_PARAMETER = "quantity"; //$NON-NLS-1$

  private static final String AMOUNT_PARAMETER = "amount"; //$NON-NLS-1$

  private Integer quantity;
  private Float price;
  private Float amount;

  public void preExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
    quantity = taskProductionContext.getInputValue(QUANTITY_PARAMETER, Integer.class);
    price = taskProductionContext.getInputValue(PRICE_PARAMETER, Float.class);
  }

  public void doExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
    amount = quantity * price;
  }

  public void postExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
    taskProductionContext.setOutputValue(AMOUNT_PARAMETER, amount);
  }

}
