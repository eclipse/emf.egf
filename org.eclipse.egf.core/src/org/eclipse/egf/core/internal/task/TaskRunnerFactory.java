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
package org.eclipse.egf.core.internal.task;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.context.IProductionContext;
import org.eclipse.egf.core.task.IPlatformTask;
import org.eclipse.egf.core.task.ITaskRunner;
import org.eclipse.egf.core.task.ITaskRunnerFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskRunnerFactory implements ITaskRunnerFactory {

  public ITaskRunner createTaskRunner(IProductionContext context, IPlatformTask platformTask) {
    return new TaskRunner(context, platformTask);
  }

  public ITaskRunner createTaskRunner(IPlatformTask platformTask) {
    return createTaskRunner(EGFCorePlugin.getProductionContextFactory().createProductionContext(), platformTask);
  }

  public ITaskRunner createTaskRunner(String id) {
    return createTaskRunner(EGFCorePlugin.getPlatformTask(id));
  }

}
