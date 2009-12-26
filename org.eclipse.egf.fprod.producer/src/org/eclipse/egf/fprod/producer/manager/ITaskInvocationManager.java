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
package org.eclipse.egf.fprod.producer.manager;

import org.eclipse.egf.fprod.producer.context.ITaskInvocationProductionContext;
import org.eclipse.egf.model.fprod.TaskInvocation;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface ITaskInvocationManager extends IProductionPlanInvocationManager {

  public TaskInvocation getElement();

  public ITaskInvocationProductionContext getProductionContext();

}
