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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManager extends ActivityManager<TaskInvocationManager, Task> {

  public TaskManager(Task task) throws InvocationException {
    super(task);
    Assert.isNotNull(task.getInvocationId());
  }

  public TaskManager(Bundle bundle, Task task) throws InvocationException {
    super(bundle, task);
    Assert.isNotNull(task.getInvocationId());
  }

  public TaskManager(TaskInvocationManager parent, Task task) throws InvocationException {
    super(parent, task);
    Assert.isNotNull(task.getInvocationId());
  }

  public ModelElementContext<Task> getProductionContext() {
    if (_modelElementContext == null) {
      _modelElementContext = EGFProductionPlanPlugin.getProductionPlanContextFactory().createContext(getElement());
    }
    return _modelElementContext;
  }

  public int getSteps() throws InvocationException {
    if (getElement().getInvocationId() != null) {
      return 1;
    }
    return 0;
  }

  @Override
  public void invoke(IProgressMonitor monitor) throws InvocationException {
    try {
      IProductionContext<Task> productionContext = getProductionContext();
      EGFProductionPlanPlugin.getProductionPlanTaskInvocationFactory().createInvocation(getProjectBundleSession(), productionContext, getElement().getInvocationId()).invoke(monitor);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    } finally {
      if (getParent() == null) {
        try {
          dispose();
        } catch (CoreException ce) {
          throw new InvocationException(ce);
        }
      }
    }
  }

}
