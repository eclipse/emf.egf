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
package org.eclipse.egf.core.production.task;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;

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
  public void preExecute(final IProductionContext productionContext, final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InvocationException, OperationCanceledException;

  /**
   * Do execute this task.
   * 
   * @param monitor_p
   */
  public void doExecute(final IProductionContext productionContext, final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InvocationException, OperationCanceledException;

  /**
   * Post execute this task.
   * 
   * @param monitor_p
   */
  public void postExecute(final IProductionContext productionContext, final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InvocationException, OperationCanceledException;

}
