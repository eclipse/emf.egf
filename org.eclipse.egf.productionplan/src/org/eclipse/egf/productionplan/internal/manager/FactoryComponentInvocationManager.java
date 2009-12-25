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
import org.eclipse.egf.model.productionplan.FactoryComponentInvocation;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentInvocationManager extends ProductionPlanInvocationManager {

  public FactoryComponentInvocationManager(FactoryComponentInvocation factoryComponentInvocation) {
    super(factoryComponentInvocation);
  }

  public FactoryComponentInvocationManager(IProductionContext parentProductionContext, FactoryComponentInvocation factoryComponentInvocation) {
    super(parentProductionContext, factoryComponentInvocation);
  }

  protected FactoryComponentInvocation getFactoryComponentInvocation() {
    return (FactoryComponentInvocation) getProductionPlanInvocation();
  }

  public FactoryComponentManager getFactoryComponentManager() {
    if (getFactoryComponentInvocation().getFactoryComponent() != null) {
      return new FactoryComponentManager(getProductionContext(), getFactoryComponentInvocation().getFactoryComponent());
    }
    return null;
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
