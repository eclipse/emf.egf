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
import org.eclipse.egf.fprod.producer.context.IFactoryComponentInvocationProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FactoryComponentInvocationProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.fprod.producer.manager.IFactoryComponentInvocationManager;
import org.eclipse.egf.fprod.producer.manager.IProductionPlanManager;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fprod.FactoryComponentInvocation;
import org.eclipse.egf.producer.internal.manager.FactoryComponentManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentInvocationManager extends ProductionPlanInvocationManager implements IFactoryComponentInvocationManager {

  private FactoryComponentManager _factoryComponentManager;

  public FactoryComponentInvocationManager(IProductionPlanManager parent, FactoryComponentInvocation factoryComponentInvocation) throws InvocationException {
    super(parent, factoryComponentInvocation);
  }

  @Override
  public FactoryComponentInvocation getElement() {
    return (FactoryComponentInvocation) super.getElement();
  }

  @Override
  public IFactoryComponentInvocationProductionContext getProductionContext() throws InvocationException {
    return getInternalProductionContext();
  }

  @Override
  public FactoryComponentInvocationProductionContext getInternalProductionContext() throws InvocationException {
    if (_productionContext == null) {
      _productionContext = FprodProducerContextFactory.createContext(getParent().getProductionContext(), getElement(), getProjectBundleSession());
    }
    return (FactoryComponentInvocationProductionContext) _productionContext;
  }

  public FactoryComponentManager getFactoryComponentManager() throws InvocationException {
    if (_factoryComponentManager == null && getElement().getActivity() != null) {
      _factoryComponentManager = new FactoryComponentManager(this, getElement().getActivity());
    }
    return _factoryComponentManager;
  }

  @Override
  public Diagnostic canInvoke() throws InvocationException {
    BasicDiagnostic diagnostic = (BasicDiagnostic) super.canInvokeElement();
    if (getFactoryComponentManager() != null) {
      diagnostic.add(getFactoryComponentManager().canInvoke());
    }
    return diagnostic;
  }

  @Override
  public void dispose() throws InvocationException {
    super.dispose();
    if (getFactoryComponentManager() != null) {
      getFactoryComponentManager().dispose();
    }
  }

  @Override
  public void initializeContext() throws InvocationException {
    super.initializeContext();
    if (getFactoryComponentManager() != null) {
      getFactoryComponentManager().initializeContext();
    }
  }

  public int getSteps() throws InvocationException {
    if (getFactoryComponentManager() != null) {
      return getFactoryComponentManager().getSteps();
    }
    return 0;
  }

  public List<Activity> getActivities() throws InvocationException {
    List<Activity> activities = new UniqueEList<Activity>();
    if (getFactoryComponentManager() != null) {
      activities.addAll(getFactoryComponentManager().getActivities());
    }
    return activities;
  }

  public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException {
    BasicDiagnostic diagnostic = (BasicDiagnostic) canInvokeElement();
    if (diagnostic.getSeverity() != Diagnostic.ERROR) {
      FactoryComponentManager factoryComponentManager = getFactoryComponentManager();
      if (factoryComponentManager != null) {
        diagnostic.add(factoryComponentManager.invoke(monitor));
        if (monitor.isCanceled()) {
          throw new OperationCanceledException();
        }
      }
    }
    return diagnostic;
  }

}
