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
package org.eclipse.egf.fprod.producer.internal.context;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.context.ITaskInvocationProductionContext;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProductionContextProducer extends ActivityProductionContextProducer {

  @Override
  public EClass getActivity() {
    return FprodPackage.Literals.TASK;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<TaskInvocationProductionContext> getParentProductionContext() {
    return TaskInvocationProductionContext.class;
  }

  @Override
  protected ITaskProductionContext doCreateActivityProductionContext(IInvocationProductionContext parent, Activity activity, ProjectBundleSession projectBundleSession) throws InvocationException {
    return FprodProducerContextFactory.createContext((ITaskInvocationProductionContext) parent, (Task) activity, projectBundleSession);
  }
}
