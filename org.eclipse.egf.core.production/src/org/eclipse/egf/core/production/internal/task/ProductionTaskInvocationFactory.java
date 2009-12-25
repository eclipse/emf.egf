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

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.production.EGFCoreProductionPlugin;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.task.IProductionTaskInvocation;
import org.eclipse.egf.core.production.task.IProductionTaskInvocationFactory;
import org.eclipse.egf.core.task.IPlatformTask;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionTaskInvocationFactory implements IProductionTaskInvocationFactory {

  public IProductionTaskInvocation createProductionTaskInvocation(IProductionContext context, IPlatformTask platformTask) {
    return new ProductionTaskInvocation(context, platformTask);
  }

  public IProductionTaskInvocation createProductionTaskInvocation(IProductionContext context, String taskId) {
    return createProductionTaskInvocation(context, EGFCorePlugin.getPlatformTask(taskId));
  }

  public IProductionTaskInvocation createProductionTaskInvocation(IPlatformTask platformTask, String name) {
    return createProductionTaskInvocation(EGFCoreProductionPlugin.getProductionContextFactory().createProductionContext(name), platformTask);
  }

  public IProductionTaskInvocation createProductionTaskInvocation(String taskId, String name) {
    return createProductionTaskInvocation(EGFCorePlugin.getPlatformTask(taskId), name);
  }

}
