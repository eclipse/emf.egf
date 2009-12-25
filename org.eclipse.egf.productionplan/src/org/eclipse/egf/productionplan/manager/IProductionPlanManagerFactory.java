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
package org.eclipse.egf.productionplan.manager;

import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.production.internal.manager.FactoryComponentInvocationManager;
import org.eclipse.egf.production.internal.manager.TaskInvocationManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionPlanManagerFactory {

  public IProductionPlanManager<FactoryComponentInvocationManager, FactoryComponent> createProductionManager(FactoryComponent factoryComponent) throws InvocationException;

  public IProductionPlanManager<TaskInvocationManager, Task> createProductionManager(Task task) throws InvocationException;

  public IProductionPlanManager<FactoryComponentInvocationManager, FactoryComponent> createProductionManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException;

  public IProductionPlanManager<TaskInvocationManager, Task> createProductionManager(Bundle bundle, Task task) throws InvocationException;

}
