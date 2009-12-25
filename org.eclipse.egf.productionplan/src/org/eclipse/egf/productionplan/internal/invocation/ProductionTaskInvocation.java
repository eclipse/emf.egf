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
package org.eclipse.egf.productionplan.internal.invocation;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.helper.BundleSessionHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.model.productionplan.invocation.IPlatformTaskInvocation;
import org.eclipse.egf.model.productionplan.invocation.IProductionTask;
import org.eclipse.egf.productionplan.invocation.IProductionTaskInvocation;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * This class is responsible to process user defined
 * {@link org.eclipse.egf.productionplan.invocation.IProductionTask}.
 * 
 * @author Xavier Maysonnave
 */
public class ProductionTaskInvocation implements IProductionTaskInvocation {

  /**
   * ProjectBundleSession
   */
  private ProjectBundleSession _projectBundleSession;

  /**
   * IProductionContext
   */
  private IProductionContext<Task> _productionContext;

  /**
   * IPlatformTask
   */
  private IPlatformTaskInvocation _platformInvocation;

  public ProductionTaskInvocation(ProjectBundleSession projectBundleSession, IProductionContext<Task> productionContext, IPlatformTaskInvocation platformInvocation) {
    Assert.isNotNull(projectBundleSession);
    Assert.isNotNull(productionContext);
    _projectBundleSession = projectBundleSession;
    _productionContext = productionContext;
    _platformInvocation = platformInvocation;
  }

  /**
   * instantiate a Invocation
   * 
   * @param monitor_p
   * @return the instantiated object or null
   */
  protected IProductionTask createProductionInvocationInstance() throws CoreException {
    IProductionTask productionTask = null;
    // Nothing to do
    if (_platformInvocation == null) {
      return null;
    }
    // Locate Bundle
    Bundle bundle = BundleSessionHelper.getBundle(_projectBundleSession, _platformInvocation);
    if (bundle == null) {
      return null;
    }
    // Load Class and instantiate
    try {
      productionTask = (IProductionTask) bundle.loadClass(_platformInvocation.getClazz()).newInstance();
    } catch (ClassNotFoundException cnfe) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _platformInvocation.getId()), cnfe));
    } catch (InstantiationException ie) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _platformInvocation.getId()), ie));
    } catch (IllegalAccessException iae) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.AbstractTask_errorTaskInstance, _platformInvocation.getId()), iae));
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
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, _productionContext.getName()), 1000);
    try {
      // Instantiate an IProductionTask object
      IProductionTask task = null;
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
   * @return the invocation
   */
  public IPlatformTaskInvocation getPlatformInvocation() {
    return _platformInvocation;
  }

}
