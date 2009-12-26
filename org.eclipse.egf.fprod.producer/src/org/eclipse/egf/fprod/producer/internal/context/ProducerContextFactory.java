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
import org.eclipse.egf.fprod.producer.IFactoryComponentInvocationProductionContext;
import org.eclipse.egf.fprod.producer.IProductionPlanProductionContext;
import org.eclipse.egf.fprod.producer.ITaskInvocationProductionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.FactoryComponentInvocation;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskInvocation;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.context.FactoryComponentProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProducerContextFactory {

  private ProducerContextFactory() {
    // Prevent Instantiation
  }

  // FactoryComponent

  public static FactoryComponentProductionContext createContext(FactoryComponent element, ProjectBundleSession projectBundleSession) {
    return new FactoryComponentProductionContext(element, projectBundleSession);
  }

  public static FactoryComponentProductionContext createContext(IFactoryComponentInvocationProductionContext parent, FactoryComponent element, ProjectBundleSession projectBundleSession) {
    return new FactoryComponentProductionContext(parent, element, projectBundleSession);
  }

  // Task

  public static TaskProductionContext createContext(Task element, ProjectBundleSession projectBundleSession) {
    return new TaskProductionContext(element, projectBundleSession);
  }

  public static TaskProductionContext createContext(ITaskInvocationProductionContext parent, Task element, ProjectBundleSession projectBundleSession) {
    return new TaskProductionContext(parent, element, projectBundleSession);
  }

  // ProductionPlan

  public static ProductionPlanProductionContext createContext(IFactoryComponentProductionContext parent, ProductionPlan element, ProjectBundleSession projectBundleSession) {
    return new ProductionPlanProductionContext(parent, element, projectBundleSession);
  }

  // FactoryComponentInvocation

  public static FactoryComponentInvocationProductionContext createContext(IProductionPlanProductionContext parent, FactoryComponentInvocation element, ProjectBundleSession projectBundleSession) {
    return new FactoryComponentInvocationProductionContext(parent, element, projectBundleSession);
  }

  // TaskInvocation

  public static TaskInvocationProductionContext createContext(IProductionPlanProductionContext parent, TaskInvocation element, ProjectBundleSession projectBundleSession) {
    return new TaskInvocationProductionContext(parent, element, projectBundleSession);
  }

}
