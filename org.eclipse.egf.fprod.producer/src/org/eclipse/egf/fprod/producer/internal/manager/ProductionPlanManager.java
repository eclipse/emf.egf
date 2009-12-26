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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.IProductionPlanProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.fprod.producer.internal.context.ProductionPlanProductionContext;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fprod.FactoryComponentInvocation;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.TaskInvocation;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.manager.OrchestrationManager;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanManager extends OrchestrationManager {

  private Map<Invocation<?>, ProductionPlanInvocationManager> _managers;

  public ProductionPlanManager(IModelElementProducerManager parent, ProductionPlan productionPlan) throws InvocationException {
    super(parent, productionPlan);
  }

  @Override
  public IProductionPlanProductionContext getProductionContext() {
    return getInternalProductionContext();
  }

  @Override
  public ProductionPlan getElement() {
    return (ProductionPlan) super.getElement();
  }

  @Override
  public ProductionPlanProductionContext getInternalProductionContext() {
    if (_productionContext == null) {
      _productionContext = FprodProducerContextFactory.createContext((IFactoryComponentProductionContext) getParent().getProductionContext(), getElement(), getProjectBundleSession());
    }
    return (ProductionPlanProductionContext) _productionContext;
  }

  private Map<Invocation<?>, ProductionPlanInvocationManager> getProductionPlanManagers() throws InvocationException {
    if (_managers == null && getElement().getInvocations() != null) {
      _managers = new HashMap<Invocation<?>, ProductionPlanInvocationManager>(getElement().getInvocations().size());
      for (Invocation<?> invocation : getElement().getInvocations()) {
        if (invocation instanceof FactoryComponentInvocation) {
          _managers.put(invocation, new FactoryComponentInvocationManager(this, (FactoryComponentInvocation) invocation));
        } else if (invocation instanceof TaskInvocation) {
          _managers.put(invocation, new TaskInvocationManager(this, (TaskInvocation) invocation));
        }
      }
    }
    return _managers;
  }

  public int getSteps() throws InvocationException {
    int steps = 0;
    Map<Invocation<?>, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
    if (managers != null) {
      for (ProductionPlanInvocationManager invocation : managers.values()) {
        steps += invocation.getSteps();
      }
    }
    return steps;
  }

  public void invoke(IProgressMonitor monitor) throws InvocationException {
    Map<Invocation<?>, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
    if (managers != null) {
      int steps = getSteps();
      SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, getName()), steps * 900);
      try {
        for (ProductionPlanInvocationManager invocation : managers.values()) {
          invocation.invoke(subMonitor.newChild(900 * invocation.getSteps(), SubMonitor.SUPPRESS_NONE));
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
