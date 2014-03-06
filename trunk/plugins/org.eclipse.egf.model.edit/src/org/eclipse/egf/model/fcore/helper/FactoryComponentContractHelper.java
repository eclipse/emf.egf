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
package org.eclipse.egf.model.fcore.helper;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentContractHelper {

    private FactoryComponentContractHelper() {
        // Prevent Instantiation
    }

    public static Collection<InvocationContract> getAvailableInvocationContracts(FactoryComponentContract factoryComponentContract) {
        Collection<InvocationContract> result = new UniqueEList<InvocationContract>();
        // Nothing to retrieve
        if (factoryComponentContract.getType() == null || factoryComponentContract.getActivity() == null) {
            return result;
        }
        FactoryComponent factoryComponent = (FactoryComponent) factoryComponentContract.getActivity();
        // Out or In_Out should have only one assigned InvocationContext
        if (factoryComponentContract.getMode() != ContractMode.IN && factoryComponentContract.getInvocationContracts().size() != 0) {
            return result;
        }
        // Retrieve all the InvocationContracts based on their types and mode
        result.addAll(factoryComponent.getInvocationContracts(factoryComponentContract.getType(), factoryComponentContract.getMode()));
        if (result.size() > 0) {
            // Filter InvocationContract already assigned to an OrchestrationParameter
            for (Iterator<InvocationContract> it = result.iterator(); it.hasNext();) {
                InvocationContract invocationContract = it.next();
                // an In_Out could either be in an OrchestrationParameter with an In semantic and
                // in a FactoryComponentContract with an Out semantic but not both
                if (invocationContract.getOrchestrationParameter() != null && factoryComponentContract.getMode() != ContractMode.OUT) {
                    it.remove();
                }
                // an In_Out could either be in a SourceInvocationContract with an In semantic and
                // in a FactoryComponentContract with an Out semantic but not both
                if (invocationContract.getSourceInvocationContract() != null && factoryComponentContract.getMode() != ContractMode.OUT) {
                    it.remove();
                }
            }
            // Filter InvocationContract already assigned to a FactoryComponentContract
            for (Contract innerContract : factoryComponent.getContracts(factoryComponentContract.getType(), factoryComponentContract.getMode())) {
                if (factoryComponentContract == innerContract) {
                    continue;
                }
                for (InvocationContract invocationContract : ((FactoryComponentContract) innerContract).getInvocationContracts()) {
                    result.remove(invocationContract);
                }
            }
        }
        return result;
    }

}
