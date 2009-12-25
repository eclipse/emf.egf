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
package org.eclipse.egf.productionplan.internal.manager;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.manager.IProductionPlanManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ProductionPlanInvocationManager implements IProductionPlanManager {

  private ProductionPlanInvocation _productionPlanInvocation;

  private IProductionContext _parentProductionContext;

  public ProductionPlanInvocationManager(ProductionPlanInvocation productionPlanInvocation) {
    Assert.isNotNull(productionPlanInvocation);
    _productionPlanInvocation = productionPlanInvocation;
  }

  public ProductionPlanInvocationManager(IProductionContext parentProductionContext, ProductionPlanInvocation productionPlanInvocation) {
    this(productionPlanInvocation);
    _parentProductionContext = parentProductionContext;
  }

  public ProductionPlanInvocation getProductionPlanInvocation() {
    return _productionPlanInvocation;
  }

  public IProductionContext getProductionContext() {
    return EGFProductionPlanPlugin.getProductionPlanContextFactory().createProductionPlanContext(_parentProductionContext, _productionPlanInvocation);
  }

  public abstract void invoke(IProgressMonitor monitor) throws InvocationException;

}
