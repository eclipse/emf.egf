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
package org.eclipse.egf.fprod.producer.orchestration;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.internal.manager.ProductionPlanManagerFactory;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.producer.manager.IModelProducerManager;
import org.eclipse.egf.producer.manager.IOrchestrationManagerFactory;
import org.eclipse.egf.producer.orchestration.OrchestrationProducer;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanProducer extends OrchestrationProducer<ProductionPlan> {

  private static final ProductionPlan __productionPlan = FprodFactory.eINSTANCE.createProductionPlan();

  private final IOrchestrationManagerFactory<ProductionPlan> _manager = new ProductionPlanManagerFactory();

  @Override
  public ProductionPlan getOrchestration() {
    return __productionPlan;
  }

  @Override
  protected IModelProducerManager<ProductionPlan> doCreateManager(IModelProducerManager<?> parent, ProductionPlan productionPlan) throws InvocationException {
    return _manager.createProductionManager(parent, productionPlan);
  }

}
