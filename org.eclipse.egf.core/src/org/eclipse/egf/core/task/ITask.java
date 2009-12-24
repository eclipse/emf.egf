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
package org.eclipse.egf.core.task;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface ITask {

  /**
   * @return the task id
   */
  public String getTaskId();

  /**
   * Pre execute this task.
   * 
   * @param monitor_p
   * @return true if the execution was successful, false otherwise.
   */
  public boolean preExecute(final IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException;

  /**
   * Do execute this task.
   * 
   * @param monitor_p
   * @return true if the execution was successful, false otherwise.
   */
  public boolean doExecute(final IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException;

  /**
   * Post execute this task.
   * 
   * @param monitor_p
   * @return true if the execution was successful, false otherwise.
   */
  public boolean postExecute(final IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException;

}
