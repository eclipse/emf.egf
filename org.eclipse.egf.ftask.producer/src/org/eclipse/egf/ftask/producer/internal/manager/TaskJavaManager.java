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
package org.eclipse.egf.ftask.producer.internal.manager;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.EGFFtaskProducerPlugin;
import org.eclipse.egf.ftask.producer.internal.context.TaskJavaProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.TaskJava;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.internal.manager.ActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskJavaManager extends ActivityManager<TaskJava> {

  public TaskJavaManager(TaskJava taskJava) throws InvocationException {
    super(taskJava);
  }

  public TaskJavaManager(Bundle bundle, TaskJava taskJava) throws InvocationException {
    super(bundle, taskJava);
  }

  public <T extends Invocation> TaskJavaManager(IModelElementManager<T, InvocationContract> parent, TaskJava task) throws InvocationException {
    super(parent, task);
  }

  @Override
  @SuppressWarnings("unchecked")
  public TaskJavaProductionContext getInternalProductionContext() throws InvocationException {
    if (_productionContext == null) {
      ActivityProductionContextProducer producer = null;
      try {
        producer = EGFProducerPlugin.getActivityProductionContextProducer(getElement());
      } catch (Throwable t) {
        throw new InvocationException(t);
      }
      if (getParent() != null) {
        _productionContext = producer.createActivityProductionContext(getParent().getProductionContext(), getProjectBundleSession(), getElement());
      } else {
        _productionContext = producer.createActivityProductionContext(getProjectBundleSession(), getElement());
      }
    }
    return (TaskJavaProductionContext) _productionContext;
  }

  @Override
  public void dispose() throws InvocationException {
    super.dispose();
  }

  @Override
  protected BasicDiagnostic canInvokeElement(boolean runtime) throws InvocationException {
    BasicDiagnostic diagnostic = super.canInvokeElement(runtime);
    if (getElement().getValue() == null) {
      diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, EGFProducerPlugin.getDefault().getPluginID(), 0, NLS.bind("Task Java Implementation is mandatory for ''{0}''", EMFHelper.getText(getElement())), //$NON-NLS-1$
          new Object[] { getElement() }));
    }
    return diagnostic;
  }

  @Override
  public void initializeContext() throws InvocationException {
    super.initializeContext();
  }

  public int getSteps() throws InvocationException {
    if (getElement().getValue() != null) {
      return 1;
    }
    return 0;
  }

  public List<Activity> getActivities() throws InvocationException {
    List<Activity> activities = new UniqueEList<Activity>();
    activities.add(getElement());
    return activities;
  }

  public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException {
    BasicDiagnostic diagnostic = canInvokeElement(true);
    if (diagnostic.getSeverity() != Diagnostic.ERROR) {
      EGFFtaskProducerPlugin.getTaskProductionInvocationFactory().createInvocation(getBundle(), getInternalProductionContext(), getElement()).invoke(monitor);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    }
    return diagnostic;
  }

}
