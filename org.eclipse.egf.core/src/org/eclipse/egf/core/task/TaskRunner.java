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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.CoreMessages;
import org.eclipse.osgi.util.NLS;

/**
 * This class is responsible to process user defined
 * {@link org.eclipse.egf.core.task.ITask}.
 * 
 * @author Xavier Maysonnave
 */
public class TaskRunner {

  /**
   * IPlatformTask
   */
  private IPlatformTask _platformTask;

  public TaskRunner(IPlatformTask platformTask_p) {
    Assert.isNotNull(platformTask_p);
    _platformTask = platformTask_p;
  }

  /**
   * instantiate a Task
   * 
   * @param monitor_p
   * @return the instantiated object or null
   */
  protected ITask createTaskInstance() {
    if (_platformTask.getPlatformBundle().isTarget() == false) {
      return null;
    }
    return null;
  }

  /**
   * Execute this task.
   * 
   * @param monitor_p
   * @return true if the execution was successful, false otherwise.
   */
  protected boolean execute(final IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException {
    SubMonitor monitor = SubMonitor.convert(monitor_p, NLS.bind(CoreMessages.AbstractTask_Execute, getPlatformTask().getId()), 40);
    try {
      // Instantiate an ITask object
      ITask task = createTaskInstance();
      monitor.worked(10);
      if (monitor.isCanceled()) {
        throw new InterruptedException();
      }
      // PreExecute
      if (preExecute(task, monitor.newChild(10)) == false) {
        return false;
      }
      monitor.worked(10);
      if (monitor.isCanceled()) {
        throw new InterruptedException();
      }
      // DoExecute
      if (doExecute(task, monitor.newChild(10)) == false) {
        return false;
      }
      monitor.worked(10);
      if (monitor.isCanceled()) {
        throw new InterruptedException();
      }
      // PostExecute
      if (postExecute(task, monitor.newChild(10)) == false) {
        return false;
      }
      monitor.worked(10);
      if (monitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      monitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * Pre execute this task.
   * 
   * @param monitor_p
   * @return true if the execution was successful, false otherwise.
   */
  public boolean preExecute(final ITask task, final IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException {
    SubMonitor monitor = SubMonitor.convert(monitor_p, NLS.bind(CoreMessages.AbstractTask_preExecute, getPlatformTask().getId()), 10);
    try {
      if (task != null && task.preExecute(monitor.newChild(10)) == false) {
        return false;
      }
      monitor.worked(10);
      if (monitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      monitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * Do execute this task.
   * 
   * @param monitor_p
   * @return true if the execution was successful, false otherwise.
   */
  public boolean doExecute(final ITask task_p, final IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException {
    SubMonitor monitor = SubMonitor.convert(monitor_p, NLS.bind(CoreMessages.AbstractTask_doExecute, getPlatformTask().getId()), 10);
    try {
      if (task_p != null && task_p.doExecute(monitor.newChild(10)) == false) {
        return false;
      }
      monitor.worked(10);
      if (monitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      monitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * Post execute this task.
   * 
   * @param monitor_p
   * @return true if the execution was successful, false otherwise.
   */
  public boolean postExecute(final ITask task_p, final IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException {
    SubMonitor monitor = SubMonitor.convert(monitor_p, NLS.bind(CoreMessages.AbstractTask_postExecute, getPlatformTask().getId()), 10);
    try {
      if (task_p != null && task_p.postExecute(monitor.newChild(10)) == false) {
        return false;
      }
      monitor.worked(10);
      if (monitor.isCanceled()) {
        throw new InterruptedException();
      }
    } finally {
      monitor.setWorkRemaining(0);
    }
    return true;
  }

  /**
   * @return the task
   */
  public IPlatformTask getPlatformTask() {
    return _platformTask;
  }

}
