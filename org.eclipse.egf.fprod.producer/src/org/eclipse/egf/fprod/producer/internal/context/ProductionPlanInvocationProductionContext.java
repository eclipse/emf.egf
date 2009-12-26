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

import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.IProductionPlanInvocationProductionContext;
import org.eclipse.egf.fprod.producer.IProductionPlanProductionContext;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.internal.context.InvocationProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ProductionPlanInvocationProductionContext extends InvocationProductionContext implements IProductionPlanInvocationProductionContext {

  public ProductionPlanInvocationProductionContext(ProductionPlanInvocation<?> element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public ProductionPlanInvocationProductionContext(IProductionPlanProductionContext parent, ProductionPlanInvocation<?> element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public ProductionPlanInvocation<?> getElement() {
    return (ProductionPlanInvocation<?>) super.getElement();
  }

  @Override
  public IProductionPlanProductionContext getParent() {
    return (IProductionPlanProductionContext) _parent;
  }

}
