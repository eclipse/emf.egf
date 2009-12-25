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
package org.eclipse.egf.productionplan.internal.task;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.invocation.IPlatformInvocation;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.productionplan.internal.invocation.ProductionInvocationTask;
import org.eclipse.egf.productionplan.invocation.IProductionInvocationTask;
import org.eclipse.egf.productionplan.task.IProductionPlanTaskInvocationFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanTaskInvocationFactory implements IProductionPlanTaskInvocationFactory {

  public IProductionInvocationTask createInvocation(ProjectBundleSession projectBundleSession, IProductionContext<Task> context, IPlatformInvocation platformInvocation) {
    return new ProductionInvocationTask(projectBundleSession, context, platformInvocation);
  }

  public IProductionInvocationTask createInvocation(ProjectBundleSession projectBundleSession, IProductionContext<Task> context, String invocationId) {
    return new ProductionInvocationTask(projectBundleSession, context, EGFCorePlugin.getPlatformInvocation(invocationId));
  }

}
