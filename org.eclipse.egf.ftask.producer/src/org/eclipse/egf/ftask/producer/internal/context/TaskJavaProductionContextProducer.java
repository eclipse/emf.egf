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
package org.eclipse.egf.ftask.producer.internal.context;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.TaskJava;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskJavaProductionContextProducer extends ActivityProductionContextProducer<TaskJava> {

  @Override
  public EClass getActivity() {
    return FtaskPackage.Literals.TASK_JAVA;
  }

  @Override
  protected ITaskProductionContext doCreateActivityProductionContext(ProjectBundleSession projectBundleSession, Activity activity) throws InvocationException {
    return FtaskProducerContextFactory.createContext(projectBundleSession, (TaskJava) activity);
  }

  @Override
  protected ITaskProductionContext doCreateActivityProductionContext(IProductionContext<Invocation, InvocationContract> parent, ProjectBundleSession projectBundleSession, Activity activity) throws InvocationException {
    return FtaskProducerContextFactory.createContext(parent, projectBundleSession, (TaskJava) activity);
  }

}
