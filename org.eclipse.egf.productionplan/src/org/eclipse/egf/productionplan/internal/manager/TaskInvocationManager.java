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

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskInvocationManager extends ProductionPlanInvocationManager {

  public TaskInvocationManager(TaskInvocation taskInvocation) {
    super(taskInvocation);
  }

  public TaskInvocationManager(IProductionContext productionContext, TaskInvocation taskInvocation) {
    super(productionContext, taskInvocation);
  }

  protected TaskInvocation getTaskInvocation() {
    return (TaskInvocation) getProductionPlanInvocation();
  }

  public TaskManager getTaskManager() {
    if (getTaskInvocation().getTask() != null) {
      return new TaskManager(getProductionContext(), getTaskInvocation().getTask());
    }
    return null;
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
