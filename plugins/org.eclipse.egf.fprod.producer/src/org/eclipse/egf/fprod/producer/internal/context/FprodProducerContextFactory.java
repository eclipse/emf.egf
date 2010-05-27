/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.fprod.producer.internal.context;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.context.FactoryComponentProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FprodProducerContextFactory {

  private FprodProducerContextFactory() {
    // Prevent Instantiation
  }

  // FactoryComponent

  public static IFactoryComponentProductionContext createContext(ProjectBundleSession projectBundleSession, FactoryComponent element) {
    return new FactoryComponentProductionContext(projectBundleSession, element, EMFHelper.getText(element));
  }

  public static IFactoryComponentProductionContext createContext(IProductionContext<Invocation, InvocationContract> parent, ProjectBundleSession projectBundleSession, FactoryComponent element) {
    return new FactoryComponentProductionContext(parent, projectBundleSession, element, EMFHelper.getText(element));
  }

  // ProductionPlan

  public static IProductionContext<ProductionPlan, OrchestrationParameter> createContext(IProductionContext<FactoryComponent, Contract> parent, ProjectBundleSession projectBundleSession, ProductionPlan element) {
    return new ProductionPlanProductionContext(parent, projectBundleSession, element, EMFHelper.getText(element));
  }

  // ProductionPlanInvocation

  public static IProductionContext<ProductionPlanInvocation, InvocationContract> createContext(IProductionContext<ProductionPlan, OrchestrationParameter> parent, ProjectBundleSession projectBundleSession, ProductionPlanInvocation element) {
    return new ProductionPlanInvocationProductionContext(parent, projectBundleSession, element, EMFHelper.getText(element));
  }

}
