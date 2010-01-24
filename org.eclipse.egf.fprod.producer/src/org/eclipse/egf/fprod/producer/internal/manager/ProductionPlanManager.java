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
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.internal.manager.OrchestrationManager;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanManager extends OrchestrationManager<ProductionPlan> {

  private Map<ProductionPlanInvocation, ProductionPlanInvocationManager> _managers;

  public ProductionPlanManager(IActivityManager<FactoryComponent> parent, ProductionPlan productionPlan) throws InvocationException {
    super(parent, productionPlan);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ProductionContext<ProductionPlan, OrchestrationParameter> getInternalProductionContext() throws InvocationException {
    if (_productionContext == null) {
      _productionContext = FprodProducerContextFactory.createContext((IProductionContext<FactoryComponent, Contract>) getParent().getProductionContext(), getProjectBundleSession(), getElement());
    }
    return (ProductionContext<ProductionPlan, OrchestrationParameter>) _productionContext;
  }

  private Map<ProductionPlanInvocation, ProductionPlanInvocationManager> getProductionPlanManagers() throws InvocationException {
    if (_managers == null && getElement().getInvocations() != null) {
      _managers = new HashMap<ProductionPlanInvocation, ProductionPlanInvocationManager>(getElement().getInvocations().size());
      for (ProductionPlanInvocation invocation : getElement().getInvocations()) {
        _managers.put(invocation, new ProductionPlanInvocationManager(this, invocation));
      }
    }
    return _managers;
  }

  @Override
  public void dispose() throws InvocationException {
    super.dispose();
    Map<ProductionPlanInvocation, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
    if (managers != null) {
      for (Invocation invocation : getElement().getInvocations()) {
        managers.get(invocation).dispose();
      }
    }
  }

  @Override
  public Diagnostic canInvoke() throws InvocationException {
    BasicDiagnostic diagnostic = canInvokeElement();
    Map<ProductionPlanInvocation, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
    if (managers != null) {
      for (Invocation invocation : getElement().getInvocations()) {
        diagnostic.add(managers.get(invocation).canInvoke());
      }
    }
    return diagnostic;
  }

  @Override
  public void initializeContext() throws InvocationException {
    super.initializeContext();
    Map<ProductionPlanInvocation, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
    if (managers != null) {
      for (Invocation invocation : getElement().getInvocations()) {
        managers.get(invocation).initializeContext();
      }
    }
  }

  public int getSteps() throws InvocationException {
    int steps = 0;
    Map<ProductionPlanInvocation, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
    if (managers != null) {
      for (Invocation invocation : getElement().getInvocations()) {
        steps += managers.get(invocation).getSteps();
      }
    }
    return steps;
  }

  public List<Activity> getActivities() throws InvocationException {
    List<Activity> activities = new UniqueEList<Activity>();
    Map<ProductionPlanInvocation, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
    if (managers != null) {
      for (Invocation invocation : getElement().getInvocations()) {
        activities.addAll(managers.get(invocation).getActivities());
      }
    }
    return activities;
  }

  public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException {
    BasicDiagnostic diagnostic = canInvokeElement();
    if (diagnostic.getSeverity() != Diagnostic.ERROR) {
      Map<ProductionPlanInvocation, ProductionPlanInvocationManager> managers = getProductionPlanManagers();
      if (managers != null) {
        int steps = getSteps();
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, getName()), steps * 900);
        try {
          for (Invocation invocation : getElement().getInvocations()) {
            ProductionPlanInvocationManager manager = managers.get(invocation);
            Diagnostic innerDiagnostic = manager.invoke(subMonitor.newChild(900 * manager.getSteps(), SubMonitor.SUPPRESS_NONE));
            diagnostic.add(innerDiagnostic);
            // Stop if any invocation diagnosis error are raised
            if (innerDiagnostic.getSeverity() == Diagnostic.ERROR) {
              break;
            }
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          }
        } finally {
          subMonitor.done();
        }
      }
    }
    return diagnostic;
  }

}
