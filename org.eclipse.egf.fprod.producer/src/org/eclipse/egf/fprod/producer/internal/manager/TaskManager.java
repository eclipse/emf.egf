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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.EGFFprodProducerPlugin;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.fprod.producer.internal.context.TaskProductionContext;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.producer.internal.manager.ActivityManager;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManager extends ActivityManager {

  public TaskManager(Task task) throws InvocationException {
    super(task);
    Assert.isNotNull(task.getValue());
  }

  public TaskManager(Bundle bundle, Task task) throws InvocationException {
    super(bundle, task);
    Assert.isNotNull(task.getValue());
  }

  public TaskManager(IModelElementProducerManager parent, Task task) throws InvocationException {
    super(parent, task);
    Assert.isNotNull(task.getValue());
  }

  @Override
  public Task getElement() {
    return (Task) super.getElement();
  }

  @Override
  public ITaskProductionContext getProductionContext() {
    return getInternalProductionContext();
  }

  @Override
  public TaskProductionContext getInternalProductionContext() {
    if (_productionContext == null) {
      _productionContext = FprodProducerContextFactory.createContext(getElement(), getProjectBundleSession());
    }
    return (TaskProductionContext) _productionContext;
  }

  public int getSteps() throws InvocationException {
    if (getElement().getValue() != null) {
      return 1;
    }
    return 0;
  }

  public void invoke(IProgressMonitor monitor) throws InvocationException {
    try {
      TaskProductionContext taskProductionContext = getInternalProductionContext();
      EGFFprodProducerPlugin.getProductionPlanTaskInvocationFactory().createInvocation(getBundle(), taskProductionContext, getElement().getValue()).invoke(monitor);
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
