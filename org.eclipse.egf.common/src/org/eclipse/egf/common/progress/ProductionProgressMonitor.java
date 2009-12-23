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
package org.eclipse.egf.common.progress;

import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.egf.common.constant.CharacterConstants;


/**
 * Production progress monitor eases the usage of {@link SubMonitor} in patterns production or execution.<br>
 * Have a look at {@link SubMonitor}, {@link IProgressMonitor} documentation.
 * @author Guillaume Brocard
 */
public class ProductionProgressMonitor {
  
  /**
   * Number of ticks to allocate to this progress monitor.
   */
  private int _totalWork;
  /**
   * Internal Sub monitor.
   */
  private SubMonitor _monitor;

  /**
   * Return the underlying monitor.
   * @return the monitor
   */
  public SubMonitor getMonitor() {
    return _monitor;
  }

  /**
   * Create a progress monitor for given parameters.
   * @param parentMonitor_p the parent monitor for this progress monitor.
   * @param taskName_p the end-user task name displayed in progress reporter.
   * @param totalWork_p number of ticks to allocate
   */
  public ProductionProgressMonitor(SubMonitor parentMonitor_p, String taskName_p, int totalWork_p) {
    _totalWork = totalWork_p;
    _monitor = parentMonitor_p.newChild(_totalWork);
    _monitor.beginTask(CharacterConstants.EMPTY_STRING, _totalWork);
    _monitor.setTaskName(taskName_p);
  }

  /**
   * End this progress monitor.
   */
  public void end() {
    _monitor.worked(_totalWork);
    _monitor.setWorkRemaining(0);
  }
  
}