/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.common.progress.ProgressReporter;


/**
 * A compound task contains other {@link AbstractTask} objects.
 * @author fournier
 */
public class CompoundTask extends AbstractTask {

  /**
   * Contained tasks.
   */
  private List<AbstractTask> _tasks;

  /**
   * Should the task execution stop on error ?
   */
  private boolean _failOnError;

  /**
   * Create a compound task. Default behavior is to stop execution on failure.
   */
  public CompoundTask() {
    super();
    _failOnError = true;
  }

  /**
   * Add a new task.
   * @param task_p
   */
  public void addTask(AbstractTask task_p) {
    if (null == _tasks) {
      _tasks = new ArrayList<AbstractTask>(0);
    }
    _tasks.add(task_p);
  }

  /**
   * Remove a task.
   * @param task_p
   */
  public void removeTask(AbstractTask task_p) {
    if (null != _tasks) {
      _tasks.remove(task_p);
    }
  }

  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    boolean result = true;
    boolean stop = false;
    if ((null != _tasks) && !_tasks.isEmpty()) {
      Iterator<AbstractTask> iterator = _tasks.iterator();
      int ticksCount = ProgressReporter.TASK_DEFAULT_TICKS_COUNT / _tasks.size();
      while (iterator.hasNext() && !stop) {
        AbstractTask task = iterator.next();
        result &= task.execute(new SubProgressMonitor(progressMonitor_p, ticksCount), ticksCount);
        if (!result && _failOnError) {
          stop = true;
        }
      }
    }
    return result;
  }

  /**
   * Set or unset the fail on error flag.
   * @param failOnError_p
   *          the failOnError to set
   */
  public void setFailOnError(boolean failOnError_p) {
    _failOnError = failOnError_p;
  }
}
