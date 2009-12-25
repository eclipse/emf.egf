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
package org.eclipse.egf.core.production.internal.task;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.task.IProductionTask;
import org.eclipse.egf.core.production.task.IProductionTaskInvocation;
import org.eclipse.egf.core.task.IPlatformTask;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * This class is responsible to process user defined
 * {@link org.eclipse.egf.core.production.task.IProductionTask}.
 * 
 * @author Xavier Maysonnave
 */
public class ProductionTaskInvocation implements IProductionTaskInvocation {

  /**
   * IProductionContext
   */
  private IProductionContext _productionContext;

  /**
   * IPlatformTask
   */
  private IPlatformTask _platformTask;

  public ProductionTaskInvocation(IProductionContext productionContext, IPlatformTask platformTask) {
    Assert.isNotNull(productionContext);
    _productionContext = productionContext;
    _platformTask = platformTask;
  }

  /**
   * instantiate a Task
   * 
   * @param monitor_p
   * @return the instantiated object or null
   */
  protected IProductionTask createProductionTaskInstance() throws CoreException {
    IProductionTask productionTask = null;
    // Nothing to do
    if (_platformTask == null) {
      return null;
    }
    // Locate Bundle
    Bundle bundle = null;
    if (_platformTask.getPlatformBundle().isTarget()) {
      bundle = _platformTask.getPlatformBundle().getBundle();
    } else {
      bundle = _productionContext.getProjectBundleSession().getBundle(_platformTask.getPlatformBundle().getProject());
    }
    if (bundle == null) {
      return null;
    }
    // Load Class and instantiate
    try {
      productionTask = (IProductionTask) bundle.loadClass(_platformTask.getClazz()).newInstance();
    } catch (ClassNotFoundException cnfe) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _platformTask.getId()), cnfe));
    } catch (InstantiationException ie) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _platformTask.getId()), ie));
    } catch (IllegalAccessException iae) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _platformTask.getId()), iae));
    }
    return productionTask;
  }

  /**
   * Execute this task.
   * 
   * @param monitor
   * @return true if the execution was successful, false otherwise.
   */
  public void invoke(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InvocationException, OperationCanceledException {
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, _productionContext.getName()), 1000);
    try {
      // Instantiate an ITask object
      IProductionTask task = createProductionTaskInstance();
      if (task == null) {
        return;
      }
      subMonitor.worked(100);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
      // PreExecute
      task.preExecute(_productionContext, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
      subMonitor.worked(100);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
      // DoExecute
      task.doExecute(_productionContext, subMonitor.newChild(700, SubMonitor.SUPPRESS_NONE));
      subMonitor.worked(700);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
      // PostExecute
      task.postExecute(_productionContext, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
      subMonitor.worked(100);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    } finally {
      subMonitor.done();
    }
  }

  /**
   * @return the task
   */
  public IPlatformTask getPlatformTask() {
    return _platformTask;
  }

}
