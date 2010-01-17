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
import org.eclipse.egf.fprod.producer.context.IProductionPlanProductionContext;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.context.OrchestrationProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanProductionContext extends OrchestrationProductionContext implements IProductionPlanProductionContext {

  public ProductionPlanProductionContext(ProductionPlan element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public ProductionPlanProductionContext(IFactoryComponentProductionContext parent, ProductionPlan element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public ProductionPlan getElement() {
    return (ProductionPlan) super.getElement();
  }

}
