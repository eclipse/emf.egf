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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.production.EGFCoreProductionPlugin;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManager extends ActivityManager {

  public TaskManager(Task task) {
    super(task);
    Assert.isNotNull(task.getTaskId());
  }

  public TaskManager(IProductionContext parentProductionContext, Task task) {
    super(parentProductionContext, task);
    Assert.isNotNull(task.getTaskId());
  }

  protected Task getTask() {
    return (Task) getActivity();
  }

  @Override
  public void invoke(IProgressMonitor monitor) throws InvocationException {
    EGFCoreProductionPlugin.getProductionTaskInvocationFactory().createProductionTaskInvocation(EGFProductionPlanPlugin.getProductionPlanContextFactory().createProductionPlanContext(getProductionContext(), getActivity()), getTask().getTaskId()).invoke(monitor);
    if (monitor.isCanceled()) {
      throw new OperationCanceledException();
    }
  }

}
