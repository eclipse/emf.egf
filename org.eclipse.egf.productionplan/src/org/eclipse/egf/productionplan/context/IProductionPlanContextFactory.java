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
package org.eclipse.egf.productionplan.context;

import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.FactoryComponentInvocation;
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.model.productionplan.TaskInvocation;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionPlanContextFactory {

  public IProductionContext<FactoryComponent> createContext(FactoryComponent factoryComponent);

  public IProductionContext<Task> createContext(Task task);

  public IProductionContext<ProductionPlan> createContext(ProductionPlan productionPlan);

  public IProductionContext<FactoryComponentInvocation> createContext(FactoryComponentInvocation factoryComponentInvocation);

  public IProductionContext<TaskInvocation> createContext(TaskInvocation taskInvocation);

}
