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

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.internal.context.ProductionPlanInvocationProductionContext;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.internal.manager.InvocationManager;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ProductionPlanInvocationManager extends InvocationManager {

  public ProductionPlanInvocationManager(IModelElementProducerManager<?> parent, ProductionPlanInvocation<?> productionPlanInvocation) throws InvocationException {
    super(parent, productionPlanInvocation);
  }

  @Override
  public ProductionPlanInvocation<?> getElement() {
    return (ProductionPlanInvocation<?>) super.getElement();
  }

  @Override
  public abstract ProductionPlanInvocationProductionContext getInternalProductionContext() throws InvocationException;

}
