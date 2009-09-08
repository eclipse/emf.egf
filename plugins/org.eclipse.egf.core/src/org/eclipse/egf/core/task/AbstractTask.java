/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.task;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.context.ProductionContext;


/**
 * Base class to implement a task.
 * @author fournier
 */
public abstract class AbstractTask {
  
  /**
   * Provides data in task execution.
   */
  private ProductionContext _productionContext;
  
  /**
   * Id of the factory component that declares the task (through a task factory).
   */
  private String _fcId;
  
  /**
   * Total amount of available ticks.
   */
  private int _ticksCount;

  /**
   * Execute this task.
   * @param progressMonitor_p
   *          a new progress monitor usable for the execution of the task. By default, it is allocated {@link ProgressReporter#TASK_DEFAULT_TICKS_COUNT} ticks
   *          (which in the end should be more than sufficient).
   * @return true if the execution was successful, false otherwise.
   */
  public final boolean execute(IProgressMonitor progressMonitor_p, int ticksCount_p) {
    boolean result = false;
    // Usual progress monitor use pattern.
    try {
      // Begin unique task.
      progressMonitor_p.beginTask(getReportingMessage(), ticksCount_p);
      _ticksCount = ticksCount_p;
      result = doExecute(progressMonitor_p);
    } finally {
      // Complete monitor.
      progressMonitor_p.done();
    }
    return result;
  }

  /**
   * Do execute this task.
   * @param progressMonitor_p
   *          A progress monitor with {@link ProgressReporter#TASK_DEFAULT_TICKS_COUNT} ticks available.<br>
   *          <b>Important note : </b> {@link IProgressMonitor#beginTask(String, int)} must <b>never</b> be called on given progress monitor.<br>
   *          Instead call {@link IProgressMonitor#worked(int)} or (exclusive) create a new {@link SubProgressMonitor}.<br>
   *          Likewise, a call to {@link IProgressMonitor#done()} is <b>forbidden</b> too.
   * @return true if the execution was successful, false otherwise.
   */
  protected abstract boolean doExecute(final IProgressMonitor progressMonitor_p);

  /**
   * Get reporting message for this task.<br>
   * By default, return the factory component id containing this task.
   * @return
   */
  protected String getReportingMessage() {
    return _fcId;
  }

  /**
   * Set a new context to this task.
   * @param productionContext_p
   */
  public void setProductionContext(ProductionContext productionContext_p) {
    _productionContext = productionContext_p;
  }

  /**
   * Get the context bound to this task.
   * @return the context
   */
  protected ProductionContext getProductionContext() {
    return _productionContext;
  }

  /**
   * Get the value of contract element for given name.
   * @param contractElementName_p
   * @return an Object or null if not found.
   */
  protected Object getContextElementValue(String contractElementName_p) {
    ProductionContext context = getProductionContext();
    return context.getContextElementValue(contractElementName_p, _fcId);
  }

  /**
   * Set containing factory component id.
   * @param fcId_p
   */
  public void setFactoryComponentId(String fcId_p) {
    _fcId = fcId_p;
  }

  /**
   * Get available ticks count.
   * @return
   */
  protected int getTicksCount() {
    return _ticksCount;
  }
  
}
