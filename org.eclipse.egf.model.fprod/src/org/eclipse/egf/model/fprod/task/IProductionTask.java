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
package org.eclipse.egf.model.fprod.task;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.model.fprod.Task;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionTask {

  /**
   * Pre execute this task.
   * 
   * @param monitor_p
   */
  public void preExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor) throws InvocationException;

  /**
   * Do execute this task.
   * 
   * @param monitor_p
   */
  public void doExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor) throws InvocationException;

  /**
   * Post execute this task.
   * 
   * @param monitor_p
   */
  public void postExecute(final IProductionContext<Task> productionContext, final IProgressMonitor monitor) throws InvocationException;

}
