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
package org.eclipse.egf.fprod.producer.internal.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanManagerProducer extends OrchestrationManagerProducer<ProductionPlan> {

  @Override
  public EClass getOrchestration() {
    return FprodPackage.Literals.PRODUCTION_PLAN;
  }

  @Override
  protected IModelElementManager<ProductionPlan, OrchestrationParameter> doCreateOrchestrationManager(IActivityManager<FactoryComponent> parent, ProductionPlan productionPlan) throws InvocationException {
    return ProductionPlanManagerFactory.createProductionManager(parent, productionPlan);
  }
}
