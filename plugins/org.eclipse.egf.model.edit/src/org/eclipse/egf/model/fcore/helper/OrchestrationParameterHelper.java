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

import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OrchestrationParameterHelper {

  private OrchestrationParameterHelper() {
    // Prevent Instantiation
  }

  public static Collection<InvocationContract> getAvailableInvocationContracts(OrchestrationParameter orchestrationParameter) {
    Collection<InvocationContract> result = new UniqueEList<InvocationContract>();
    if (orchestrationParameter.getType() == null) {
      return result;
    }
    // Retrieve all the InvocationContracts based on their types and mode
    result.addAll(orchestrationParameter.getOrchestration().getInvocationContracts(orchestrationParameter.getType()));
    if (result.isEmpty()) {
      return result;
    }
    // Filter
    for (Iterator<InvocationContract> it = result.iterator(); it.hasNext();) {
      InvocationContract invocationContract = it.next();
      if (invocationContract.getInvokedMode() == ContractMode.OUT) {
        // Only In or In_Out mode are assignable to an OrchestrationParameter
        // They have an In semantic in this area
        it.remove();
      } else {
        if (invocationContract.getFactoryComponentContract() != null) {
          if (invocationContract.getInvokedMode() == ContractMode.IN) {
            // Filter InvocationContract with In mode already assigned to a FactoryComponentContract
            it.remove();
          } else if (invocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
            // Filter InvocationContract with In_Out mode already assigned to an In or In_Out FactoryComponentContract
            it.remove();
          }
        }
        if (invocationContract.getSourceInvocationContract() != null) {
          if (invocationContract.getInvokedMode() == ContractMode.IN) {
            // Filter InvocationContract with In mode already assigned to a SourceInvocationContract
            it.remove();
          }
        }
      }
    }
    // Filter InvocationContract already assigned to an OrchestrationParameter
    for (OrchestrationParameter innerOrchestrationParameter : orchestrationParameter.getOrchestrationParameterContainer().getOrchestrationParameters()) {
      if (orchestrationParameter == innerOrchestrationParameter) {
        continue;
      }
      for (InvocationContract invocationContract : innerOrchestrationParameter.getInvocationContracts()) {
        result.remove(invocationContract);
      }
    }
    return result;
  }

}
