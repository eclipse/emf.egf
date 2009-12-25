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
import org.eclipse.egf.model.productionplan.TaskInvocation;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskInvocationManager extends ProductionPlanInvocationManager<ProductionPlanManager, TaskInvocation> {

  private TaskManager _taskManager;

  public TaskInvocationManager(ProductionPlanManager parent, TaskInvocation taskInvocation) throws InvocationException {
    super(parent, taskInvocation);
  }

  public IProductionContext<TaskInvocation> getProductionContext() throws InvocationException {
    if (_productionContext == null) {
      _productionContext = EGFProductionPlanPlugin.getProductionPlanContextFactory().createContext(getElement(), getProjectBundleSession());
    }
    return _productionContext;
  }

  public TaskManager getTaskManager() throws InvocationException {
    if (_taskManager == null && getElement().getActivity() != null) {
      _taskManager = new TaskManager(this, getElement().getActivity());
    }
    return _taskManager;
  }

  public int getSteps() throws InvocationException {
    if (getTaskManager() != null) {
      return getTaskManager().getSteps();
    }
    return 0;
  }

  @Override
  public void invoke(IProgressMonitor monitor) throws InvocationException {
    TaskManager taskManager = getTaskManager();
    if (taskManager != null) {
      taskManager.invoke(monitor);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    }
  }

}
