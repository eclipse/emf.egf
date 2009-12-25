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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.productionplan.FactoryComponentInvocation;
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.eclipse.egf.model.productionplan.TaskInvocation;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.manager.IProductionPlanManager;
import org.eclipse.egf.productionplan.manager.TickManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanManager implements IProductionPlanManager {

  private ProductionPlan _productionPlan;

  private IProductionContext _parentProductionContext;

  public ProductionPlanManager(ProductionPlan productionPlan) {
    Assert.isNotNull(productionPlan);
    _productionPlan = productionPlan;
  }

  public ProductionPlanManager(IProductionContext parentProductionContext, ProductionPlan productionPlan) {
    Assert.isNotNull(productionPlan);
    _parentProductionContext = parentProductionContext;
    _productionPlan = productionPlan;
  }

  public IProductionContext getProductionContext() {
    return EGFProductionPlanPlugin.getProductionPlanContextFactory().createProductionPlanContext(_parentProductionContext, _productionPlan);
  }

  private Collection<ProductionPlanInvocationManager> getProductionPlanManagers() {
    if (_productionPlan.getProductionPlanInvocations() != null) {
      Collection<ProductionPlanInvocationManager> productionPlanManagers = new ArrayList<ProductionPlanInvocationManager>(_productionPlan.getProductionPlanInvocations().size());
      for (ProductionPlanInvocation invocation : _productionPlan.getProductionPlanInvocations()) {
        if (invocation instanceof FactoryComponentInvocation) {
          productionPlanManagers.add(new FactoryComponentInvocationManager(getProductionContext(), (FactoryComponentInvocation) invocation));
        } else if (invocation instanceof TaskInvocation) {
          productionPlanManagers.add(new TaskInvocationManager(getProductionContext(), (TaskInvocation) invocation));
        }
      }
      return productionPlanManagers;
    }
    return null;
  }

  public void invoke(IProgressMonitor monitor) throws InvocationException {
    Collection<ProductionPlanInvocationManager> productionPlanManagers = getProductionPlanManagers();
    if (productionPlanManagers != null) {
      int steps = TickManager.getTicks(_productionPlan);
      SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, _productionPlan.getExternalName()), steps * 900);
      try {
        for (ProductionPlanInvocationManager invocation : productionPlanManagers) {
          invocation.invoke(subMonitor.newChild(900 * TickManager.getTicks(invocation.getProductionPlanInvocation()), SubMonitor.SUPPRESS_NONE));
          if (monitor.isCanceled()) {
            throw new OperationCanceledException();
          }
        }
      } finally {
        subMonitor.done();
      }
    }
  }

}
