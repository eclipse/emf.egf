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
package org.eclipse.egf.fprod.producer.internal.manager;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.internal.manager.AbstractManager;
import org.eclipse.egf.producer.manager.IModelProducerManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ProductionPlanInvocationManager<T extends ProductionPlanInvocation<?>> extends AbstractManager<T> {

  public ProductionPlanInvocationManager(IModelProducerManager<?> parent, T productionPlanInvocation) throws InvocationException {
    super(parent, productionPlanInvocation);
    init();
  }

  public void init() throws InvocationException {
    getProductionContext().reset();
  }

  public abstract void invoke(IProgressMonitor monitor) throws InvocationException;

}
