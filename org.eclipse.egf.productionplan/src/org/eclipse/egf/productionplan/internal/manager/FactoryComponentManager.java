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
package org.eclipse.egf.productionplan.internal.manager;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.ProductionPlan;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManager extends ActivityManager {

  public FactoryComponentManager(FactoryComponent factoryComponent) {
    super(factoryComponent);
  }

  public FactoryComponentManager(IProductionContext parentProductionContext, FactoryComponent factoryComponent) {
    super(parentProductionContext, factoryComponent);
  }

  protected FactoryComponent getFactoryComponent() {
    return (FactoryComponent) getActivity();
  }

  public ProductionPlanManager getProductionPlanManager() {
    if (getFactoryComponent().getOrchestration() != null) {
      if (getFactoryComponent().getOrchestration() instanceof ProductionPlan) {
        return new ProductionPlanManager(getProductionContext(), (ProductionPlan) getFactoryComponent().getOrchestration());
      }
    }
    return null;
  }

  @Override
  public void invoke(IProgressMonitor monitor) throws InvocationException {
    ProductionPlanManager productionPlanManager = getProductionPlanManager();
    if (productionPlanManager != null) {
      productionPlanManager.invoke(monitor);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    }
  }

}
