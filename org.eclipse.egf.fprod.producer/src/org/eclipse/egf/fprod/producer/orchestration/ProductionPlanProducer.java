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
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.eclipse.egf.producer.orchestration.OrchestrationProducer;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanProducer extends OrchestrationProducer {

  private static final ProductionPlan __productionPlan = FprodFactory.eINSTANCE.createProductionPlan();

  private final ProductionPlanManagerFactory _manager = new ProductionPlanManagerFactory();

  @Override
  public ProductionPlan getOrchestration() {
    return __productionPlan;
  }

  @Override
  protected IModelElementProducerManager doCreateManager(IModelElementProducerManager parent, Orchestration orchestration) throws InvocationException {
    return _manager.createProductionManager(parent, (ProductionPlan) orchestration);
  }
}
