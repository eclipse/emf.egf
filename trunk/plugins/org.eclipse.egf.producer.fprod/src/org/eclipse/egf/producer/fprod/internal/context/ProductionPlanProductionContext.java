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
package org.eclipse.egf.producer.fprod.internal.context;

import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.producer.fprod.context.IProductionPlanProductionContext;
import org.eclipse.egf.producer.internal.context.OrchestrationProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanProductionContext extends OrchestrationProductionContext<ProductionPlan> implements IProductionPlanProductionContext<ProductionPlan> {

    public ProductionPlanProductionContext(ProjectBundleSession projectBundleSession, ProductionPlan element, String name) {
        super(projectBundleSession, element, name);
    }

    public ProductionPlanProductionContext(IProductionContext<FactoryComponent, Contract> parent, ProjectBundleSession projectBundleSession, ProductionPlan element, String name) {
        super(parent, projectBundleSession, element, name);
    }

}
