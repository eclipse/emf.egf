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
package org.eclipse.egf.producer.ftask.internal.invocation;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.task.TaskHook;
import org.eclipse.egf.producer.ftask.invocation.ITaskProductionInvocation;
import org.osgi.framework.Bundle;

/**
 * This class is responsible to process user defined {@link org.eclipse.egf.producer.ftask.invocation.ITaskProductionInvocation}.
 * 
 * @author Xavier Maysonnave
 */
public class TaskProductionInvocation implements ITaskProductionInvocation {

  /**
   * Bundle
   */
  private Bundle bundle;

  /**
   * ITaskProductionContext
   */
  private ITaskProductionContext productionContext;

  /**
   * Task
   */
  private Task task;

  public TaskProductionInvocation(Bundle bundle, ITaskProductionContext productionContext, Task task) {
    Assert.isNotNull(bundle);
    Assert.isNotNull(productionContext);
    this.bundle = bundle;
    this.productionContext = productionContext;
    this.task = task;
  }

  public void invoke(final IProgressMonitor monitor) throws InvocationException {
    TaskHook.HELPER.getHook(task).invoke(bundle, productionContext, task, monitor);
  }

}
