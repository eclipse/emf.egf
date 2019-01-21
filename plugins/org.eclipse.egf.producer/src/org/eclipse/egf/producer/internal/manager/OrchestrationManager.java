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
package org.eclipse.egf.producer.internal.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.producer.manager.IActivityManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OrchestrationManager<P extends Orchestration> extends ModelElementManager<P, OrchestrationParameter> {

    public OrchestrationManager(IActivityManager<FactoryComponent> parent, P orchestration) throws InvocationException {
        super(parent, orchestration);
    }

    @Override
    public void initializeContext() throws InvocationException {
        // Get Context
        ProductionContext<P, OrchestrationParameter> context = getInternalProductionContext();
        // Clear Context
        context.clear();
        // Set Context
        for (OrchestrationParameter orchestrationParameter : getElement().getOrchestrationParameters()) {
            // Nothing to process
            if (orchestrationParameter.getType() == null) {
                continue;
            }
            // Populate
            ModelElementManager.populateContext(context, getBundle(), orchestrationParameter, ContractMode.IN, orchestrationParameter.getType(), orchestrationParameter.getType().getValue());
        }
    }

}
