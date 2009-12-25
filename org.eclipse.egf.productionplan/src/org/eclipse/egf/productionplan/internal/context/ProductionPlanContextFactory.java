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
package org.eclipse.egf.productionplan.internal.context;

import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.internal.context.ProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.eclipse.egf.productionplan.context.IProductionPlanContextFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanContextFactory implements IProductionPlanContextFactory {

  public IProductionContext createProductionPlanContext(IProductionContext parent, Activity activity) {
    return new ProductionContext(parent, activity.getExternalName());
  }

  public IProductionContext createProductionPlanContext(Activity activity) {
    return new ProductionContext(activity.getExternalName());
  }

  public IProductionContext createProductionPlanContext(IProductionContext parent, ProductionPlan productionPlan) {
    return new ProductionContext(parent, productionPlan.getExternalName());
  }

  public IProductionContext createProductionPlanContext(ProductionPlan productionPlan) {
    return new ProductionContext(productionPlan.getExternalName());
  }

  public IProductionContext createProductionPlanContext(IProductionContext parent, ProductionPlanInvocation invocation) {
    return new ProductionContext(parent, invocation.getExternalName());
  }

  public IProductionContext createProductionPlanContext(ProductionPlanInvocation invocation) {
    return new ProductionContext(invocation.getExternalName());
  }

}
