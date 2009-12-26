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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.internal.context.FactoryComponentInvocationProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.model.fprod.FactoryComponentInvocation;
import org.eclipse.egf.producer.internal.manager.FactoryComponentManager;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentInvocationManager extends ProductionPlanInvocationManager {

  private FactoryComponentManager _factoryComponentManager;

  public FactoryComponentInvocationManager(IModelElementProducerManager<?> parent, FactoryComponentInvocation factoryComponentInvocation) throws InvocationException {
    super(parent, factoryComponentInvocation);
  }

  @Override
  public FactoryComponentInvocation getElement() {
    return (FactoryComponentInvocation) super.getElement();
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

  public int getSteps() throws InvocationException {
    if (getFactoryComponentManager() != null) {
      return getFactoryComponentManager().getSteps();
    }
    return 0;
  }

  public void invoke(IProgressMonitor monitor) throws InvocationException {
    FactoryComponentManager factoryComponentManager = getFactoryComponentManager();
    if (factoryComponentManager != null) {
      factoryComponentManager.invoke(monitor);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    }
  }

}
