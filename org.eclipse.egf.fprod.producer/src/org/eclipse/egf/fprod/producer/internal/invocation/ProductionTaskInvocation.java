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
package org.eclipse.egf.fprod.producer.internal.invocation;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;
import org.eclipse.egf.fprod.producer.invocation.ITaskProductionInvocation;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * This class is responsible to process user defined
 * {@link org.eclipse.egf.ITaskProductionInvocation.invocation.IProductionTaskInvocation}.
 * 
 * @author Xavier Maysonnave
 */
public class ProductionTaskInvocation implements ITaskProductionInvocation {

  /**
   * Bundle
   */
  private Bundle _bundle;

  /**
   * ITaskProductionContext
   */
  private ITaskProductionContext _taskProductionContext;

  /**
   * IProductionTask
   */
  private String _value;

  public ProductionTaskInvocation(Bundle bundle, ITaskProductionContext taskProductionContext, String value) {
    Assert.isNotNull(bundle);
    Assert.isNotNull(taskProductionContext);
    _bundle = bundle;
    _taskProductionContext = taskProductionContext;
    _value = value;
  }

  /**
   * instantiate a Invocation
   * 
   * @param monitor_p
   * @return the instantiated object or null
   */
  protected ITaskProduction createProductionInvocationInstance() throws CoreException {
    ITaskProduction productionTask = null;
    // Nothing to do
    if (_value == null) {
      return null;
    }
    // Load Class and instantiate
    try {
      productionTask = (ITaskProduction) BundleHelper.instantiate(_value.trim(), _bundle);
    } catch (ClassNotFoundException cnfe) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _value), cnfe));
    } catch (InstantiationException ie) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _value), ie));
    } catch (IllegalAccessException iae) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _value), iae));
    }
    return productionTask;
  }

  /**
   * Execute this task.
   * 
   * @param monitor
   * @return true if the execution was successful, false otherwise.
   */
  public void invoke(final IProgressMonitor monitor) throws InvocationException {
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, _taskProductionContext.getName()), 1000);
    try {
      // Instantiate an IProductionTask object
      ITaskProduction task = null;
      try {
        task = createProductionInvocationInstance();
      } catch (CoreException ce) {
        throw new InvocationException(ce);
      }
      if (task == null) {
        return;
      }
      subMonitor.worked(100);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
      // PreExecute
      task.preExecute(_taskProductionContext, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
      subMonitor.worked(100);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
      // DoExecute
      task.doExecute(_taskProductionContext, subMonitor.newChild(700, SubMonitor.SUPPRESS_NONE));
      subMonitor.worked(700);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
      // PostExecute
      task.postExecute(_taskProductionContext, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
      subMonitor.worked(100);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    } finally {
      subMonitor.done();
    }
  }

}
