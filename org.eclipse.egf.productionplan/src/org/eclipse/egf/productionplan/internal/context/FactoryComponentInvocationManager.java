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
package org.eclipse.egf.productionplan.internal.context;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.productionplan.FactoryComponentInvocation;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentInvocationManager extends ProductionPlanInvocationManager<ProductionPlanManager, FactoryComponentInvocation> {

  private FactoryComponentManager _factoryComponentManager;

  public FactoryComponentInvocationManager(ProductionPlanManager parent, FactoryComponentInvocation factoryComponentInvocation) throws InvocationException {
    super(parent, factoryComponentInvocation);
  }

  public ModelElementContext<FactoryComponentInvocation> getProductionContext() {
    if (_modelElementContext == null) {
      _modelElementContext = EGFProductionPlanPlugin.getProductionPlanContextFactory().createContext(getElement());
    }
    return _modelElementContext;
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

  @Override
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
