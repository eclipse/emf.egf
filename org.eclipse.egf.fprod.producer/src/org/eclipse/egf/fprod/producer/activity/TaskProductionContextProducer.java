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
package org.eclipse.egf.fprod.producer.activity;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.fprod.producer.internal.context.TaskInvocationProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.TaskProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.producer.activity.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IModelElementProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProductionContextProducer extends ActivityProductionContextProducer<TaskProductionContext> {

  private static final Task __task = FprodFactory.eINSTANCE.createTask();

  @Override
  public Task getActivity() {
    return __task;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<TaskInvocationProductionContext> getParentProductionContext() {
    return TaskInvocationProductionContext.class;
  }

  @Override
  protected TaskProductionContext doCreateActivityProductionContext(IModelElementProductionContext<?> parent, Activity activity, ProjectBundleSession projectBundleSession) throws InvocationException {
    return FprodProducerContextFactory.createContext(parent, (Task) activity, projectBundleSession);
  }
}
