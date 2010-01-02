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

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.IProductionPlanInvocationProductionContext;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.manager.IInvocationManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionPlanInvocationManager extends IInvocationManager {

  public ProductionPlanInvocation<?> getElement();

  public IProductionPlanManager getParent();

  public IProductionPlanInvocationProductionContext getProductionContext() throws InvocationException;

}
