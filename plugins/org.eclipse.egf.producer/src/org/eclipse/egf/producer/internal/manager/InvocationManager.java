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
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.producer.manager.IModelElementManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class InvocationManager<P extends Orchestration, T extends Invocation> extends ModelElementManager<T, InvocationContract> {

    public InvocationManager(IModelElementManager<P, OrchestrationParameter> parent, T invocation) throws InvocationException {
        super(parent, invocation);
    }

    @Override
    public void initializeContext() throws InvocationException {
        // Get Context
        ProductionContext<T, InvocationContract> context = getInternalProductionContext();
        // Clear Context
        context.clear();
        // Set Context
        for (InvocationContract invocationContract : getElement().getInvocationContracts()) {
            // Nothing to process
            if (invocationContract.getInvokedContract() == null) {
                continue;
            }
            // Fetch Type and Value
            Type type = invocationContract.getType() != null ? invocationContract.getType() : invocationContract.getInvokedContract().getType();
            Object value = invocationContract.getType() != null ? invocationContract.getType().getValue() : null;
            // Nothing to process
            if (type == null) {
                continue;
            }
            // Populate
            ModelElementManager.populateContext(context, getBundle(), invocationContract, invocationContract.getInvokedMode(), type, value);
        }
    }

}
