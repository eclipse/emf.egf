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
package org.eclipse.egf.production.internal.context;

import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.productionplan.context.IProductionPlanManager;
import org.eclipse.egf.productionplan.context.IProductionPlanManagerFactory;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanFactory implements IProductionPlanManagerFactory {

  public IProductionPlanManager<FactoryComponentInvocationManager, FactoryComponent> createProductionManager(FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(factoryComponent);
  }

  public IProductionPlanManager<TaskInvocationManager, Task> createProductionManager(Task task) throws InvocationException {
    return new TaskManager(task);
  }

  public IProductionPlanManager<FactoryComponentInvocationManager, FactoryComponent> createProductionManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(bundle, factoryComponent);
  }

  public IProductionPlanManager<TaskInvocationManager, Task> createProductionManager(Bundle bundle, Task task) throws InvocationException {
    return new TaskManager(bundle, task);
  }

}
