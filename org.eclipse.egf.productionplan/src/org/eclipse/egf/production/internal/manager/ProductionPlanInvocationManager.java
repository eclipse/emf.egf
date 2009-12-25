/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.production.internal.manager;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ProductionPlanInvocationManager<Q extends ProductionPlanManager, T extends ProductionPlanInvocation<?>> extends AbstractManager<Q, T> {

  public ProductionPlanInvocationManager(Q parent, T productionPlanInvocation) throws InvocationException {
    super(parent, productionPlanInvocation);
    reset();
  }

  public void reset() throws InvocationException {
    getProductionContext().init(getBundle());
  }

  public abstract void invoke(IProgressMonitor monitor) throws InvocationException;

}
