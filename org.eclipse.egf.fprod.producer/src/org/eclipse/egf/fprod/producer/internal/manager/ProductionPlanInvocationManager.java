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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.internal.manager.InvocationManager;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanInvocationManager extends InvocationManager<ProductionPlan, ProductionPlanInvocation> {

  private IActivityManager<Activity> _activityManager;

  public ProductionPlanInvocationManager(IModelElementManager<ProductionPlan, OrchestrationParameter> parent, ProductionPlanInvocation element) throws InvocationException {
    super(parent, element);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ProductionContext<ProductionPlanInvocation, InvocationContract> getInternalProductionContext() throws InvocationException {
    if (_productionContext == null) {
      _productionContext = FprodProducerContextFactory.createContext((IProductionContext<ProductionPlan, OrchestrationParameter>) getParent().getProductionContext(), getProjectBundleSession(), getElement());
    }
    return (ProductionContext<ProductionPlanInvocation, InvocationContract>) _productionContext;
  }

  public IActivityManager<Activity> getActivityManager() throws InvocationException {
    if (_activityManager == null && getElement().getInvokedActivity() != null) {
      ActivityManagerProducer<Activity> producer = null;
      try {
        producer = EGFProducerPlugin.getActivityManagerProducer(getElement().getInvokedActivity());
      } catch (Throwable t) {
        throw new InvocationException(t);
      }
      _activityManager = producer.createActivityManager(this, getElement().getInvokedActivity());
    }
    return _activityManager;
  }

  @Override
  public void dispose() throws InvocationException {
    super.dispose();
    if (getActivityManager() != null) {
      getActivityManager().dispose();
    }
  }

  @Override
  public Diagnostic canInvoke() throws InvocationException {
    BasicDiagnostic diagnostic = checkInputElement(false);
    if (getActivityManager() != null) {
      diagnostic.add(getActivityManager().canInvoke());
    }
    return diagnostic;
  }

  @Override
  public void initializeContext() throws InvocationException {
    super.initializeContext();
    if (getActivityManager() != null) {
      getActivityManager().initializeContext();
    }
  }

  public int getSteps() throws InvocationException {
    if (getActivityManager() != null) {
      return getActivityManager().getSteps();
    }
    return 0;
  }

  public List<Activity> getActivities() throws InvocationException {
    List<Activity> activities = new UniqueEList<Activity>();
    if (getActivityManager() != null) {
      activities.addAll(getActivityManager().getActivities());
    }
    return activities;
  }

  public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException {
    BasicDiagnostic diagnostic = checkInputElement(true);
    if (diagnostic.getSeverity() != Diagnostic.ERROR) {
      IActivityManager<Activity> activityManager = getActivityManager();
      if (activityManager != null) {
        diagnostic.add(activityManager.invoke(monitor));
        if (monitor.isCanceled()) {
          throw new OperationCanceledException();
        }
      }
    }
    return diagnostic;
  }

}
