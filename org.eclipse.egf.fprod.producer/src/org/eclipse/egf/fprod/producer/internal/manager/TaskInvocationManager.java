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
import org.eclipse.egf.fprod.producer.IProductionPlanProductionContext;
import org.eclipse.egf.fprod.producer.ITaskInvocationProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.fprod.producer.internal.context.TaskInvocationProductionContext;
import org.eclipse.egf.model.fprod.TaskInvocation;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskInvocationManager extends ProductionPlanInvocationManager {

  private TaskManager _taskManager;

  public TaskInvocationManager(IModelElementProducerManager parent, TaskInvocation taskInvocation) throws InvocationException {
    super(parent, taskInvocation);
  }

  @Override
  public TaskInvocation getElement() {
    return (TaskInvocation) super.getElement();
  }

  @Override
  public ITaskInvocationProductionContext getProductionContext() {
    return getInternalProductionContext();
  }

  @Override
  public TaskInvocationProductionContext getInternalProductionContext() {
    if (_productionContext == null) {
      _productionContext = FprodProducerContextFactory.createContext((IProductionPlanProductionContext) getParent().getProductionContext(), getElement(), getProjectBundleSession());
    }
    return (TaskInvocationProductionContext) _productionContext;
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
