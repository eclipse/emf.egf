/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
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
