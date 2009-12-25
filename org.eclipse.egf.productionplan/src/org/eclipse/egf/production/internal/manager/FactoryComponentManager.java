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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManager extends ActivityManager<FactoryComponentInvocationManager, FactoryComponent> {

  private ProductionPlanManager _productionPlanManager;

  public FactoryComponentManager(FactoryComponent factoryComponent) throws InvocationException {
    super(factoryComponent);
  }

  public FactoryComponentManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
    super(bundle, factoryComponent);
  }

  public FactoryComponentManager(FactoryComponentInvocationManager parent, FactoryComponent factoryComponent) throws InvocationException {
    super(parent, factoryComponent);
  }

  public IProductionContext<FactoryComponent> getProductionContext() {
    if (_productionContext == null) {
      _productionContext = EGFProductionPlanPlugin.getProductionPlanContextFactory().createContext(getElement());
    }
    return _productionContext;
  }

  public ProductionPlanManager getProductionPlanManager() throws InvocationException {
    if (_productionPlanManager == null && getElement().getOrchestration() != null) {
      if (getElement().getOrchestration() instanceof ProductionPlan) {
        _productionPlanManager = new ProductionPlanManager(this, (ProductionPlan) getElement().getOrchestration());
      }
    }
    return _productionPlanManager;
  }

  public int getSteps() throws InvocationException {
    if (getProductionPlanManager() != null) {
      return getProductionPlanManager().getSteps();
    }
    return 0;
  }

  @Override
  public void invoke(IProgressMonitor monitor) throws InvocationException {
    ProductionPlanManager productionPlanManager = getProductionPlanManager();
    if (productionPlanManager != null) {
      try {
        productionPlanManager.invoke(monitor);
        if (monitor.isCanceled()) {
          throw new OperationCanceledException();
        }
      } finally {
        if (getParent() == null) {
          try {
            dispose();
          } catch (CoreException ce) {
            throw new InvocationException(ce);
          }
        }
      }
    }
  }

}
