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
import org.eclipse.egf.fprod.producer.context.ITaskInvocationProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.fprod.producer.internal.context.TaskInvocationProductionContext;
import org.eclipse.egf.fprod.producer.manager.IProductionPlanManager;
import org.eclipse.egf.fprod.producer.manager.ITaskInvocationManager;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fprod.TaskInvocation;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskInvocationManager extends ProductionPlanInvocationManager implements ITaskInvocationManager {

  private TaskManager _taskManager;

  public TaskInvocationManager(IProductionPlanManager parent, TaskInvocation taskInvocation) throws InvocationException {
    super(parent, taskInvocation);
  }

  @Override
  public TaskInvocation getElement() {
    return (TaskInvocation) super.getElement();
  }

  @Override
  public ITaskInvocationProductionContext getProductionContext() {
    return (ITaskInvocationProductionContext) super.getProductionContext();
  }

  @Override
  public TaskInvocationProductionContext getInternalProductionContext() throws InvocationException {
    if (_productionContext == null) {
      _productionContext = FprodProducerContextFactory.createContext(getParent().getProductionContext(), getElement(), getProjectBundleSession());
    }
    return (TaskInvocationProductionContext) _productionContext;
  }

  public TaskManager getTaskManager() throws InvocationException {
    if (_taskManager == null && getElement().getActivity() != null) {
      _taskManager = new TaskManager(this, getElement().getActivity());
    }
    return _taskManager;
  }

  @Override
  public void dispose() throws InvocationException {
    super.dispose();
    if (getTaskManager() != null) {
      getTaskManager().dispose();
    }
  }

  @Override
  public Diagnostic canInvoke() throws InvocationException {
    BasicDiagnostic diagnostic = (BasicDiagnostic) super.canInvoke();
    if (getTaskManager() != null) {
      diagnostic.add(getTaskManager().canInvoke());
    }
    return diagnostic;
  }

  @Override
  public void initializeContext() throws InvocationException {
    super.initializeContext();
    if (getTaskManager() != null) {
      getTaskManager().initializeContext();
    }
  }

  public int getSteps() throws InvocationException {
    if (getTaskManager() != null) {
      return getTaskManager().getSteps();
    }
    return 0;
  }

  public List<Activity> getActivities() throws InvocationException {
    List<Activity> activities = new UniqueEList<Activity>();
    if (getTaskManager() != null) {
      activities.addAll(getTaskManager().getActivities());
    }
    return activities;
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
