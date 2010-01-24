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
package org.eclipse.egf.model.fcore.helper;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 * 
 */
public class InvocationContractHelper {

  private InvocationContractHelper() {
    // Prevent Instantiation
  }

  public static Collection<Contract> getAvailableFactoryComponentContract(InvocationContract invocationContract) {
    Collection<Contract> result = new UniqueEList<Contract>();
    if (result.contains(null) == false) {
      result.add(null);
    }
    // Nothing to retrieve
    if (invocationContract.getFactoryComponent() == null || invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
      return result;
    }
    // If an orchestration parameter is already assigned, InvocationParameter in In mode are not
    // assignable
    if (invocationContract.getOrchestrationParameter() != null && invocationContract.getInvokedMode() == ContractMode.IN) {
      return result;
    }
    // Retrieve all the typed contracts if available
    if (invocationContract.getInvokedMode() == ContractMode.IN) {
      result.addAll(invocationContract.getFactoryComponent().getContracts(invocationContract.getInvokedContract().getType(), ContractMode.IN));
    } else {
      // In or In_Out Contract should have only one assigned InvocationContract.
      for (Contract contract : invocationContract.getFactoryComponent().getContracts(invocationContract.getInvokedContract().getType(), invocationContract.getInvokedMode())) {
        if (((FactoryComponentContract) contract).getInvocationContracts().size() == 0) {
          result.add(contract);
        }
      }
    }
    // If an orchestration parameter is already assigned, InvocationContract in In_Out mode are
    // only assignable to Out Mode Contract
    if (invocationContract.getOrchestrationParameter() != null && invocationContract.getInvokedMode() == ContractMode.IN_OUT) {
      for (Iterator<Contract> it = result.iterator(); it.hasNext();) {
        Contract contract = it.next();
        if (contract.getMode() != ContractMode.OUT) {
          it.remove();
        }
      }
      return result;
    }
    return result;
  }

  public static Collection<OrchestrationParameter> getAvailableOrchestrationParameter(InvocationContract invocationContract) {
    Collection<OrchestrationParameter> result = new UniqueEList<OrchestrationParameter>();
    if (result.contains(null) == false) {
      result.add(null);
    }
    // Nothing to retrieve
    if (invocationContract.getFactoryComponent() == null || invocationContract.getFactoryComponent().getOrchestration() == null || invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
      return result;
    }
    // InvocationContract in Out mode are not assignable
    if (invocationContract.getInvokedMode() == ContractMode.OUT) {
      return result;
    }
    // InvocationContract already assigned to an exposed contract should in be In_Out mode
    if (invocationContract.getFactoryComponentContract() != null && invocationContract.getInvokedMode() != ContractMode.IN_OUT) {
      return result;
    }
    // Retrieve all compatible typed OrchestrationParameter
    result.addAll(invocationContract.getFactoryComponent().getOrchestration().getOrchestrationParameters(invocationContract.getInvokedContract().getType()));
    return result;
  }

  public static Collection<Contract> getAvailableInvokedContract(InvocationContract invocationContract) {
    Collection<Contract> result = new UniqueEList<Contract>();
    // Retrieve all the typed contracts if available
    if (invocationContract.getInvocation() != null && invocationContract.getInvocation().getInvokedActivity() != null) {
      // Type filtering
      if (invocationContract.getType() != null) {
        if (invocationContract.getFactoryComponentContract() != null) {
          result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts(invocationContract.getType(), invocationContract.getFactoryComponentContract().getMode()));
        } else {
          result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts(invocationContract.getType()));
        }
        // Filter all assigned contracts if necessary
        if (result.size() > 0) {
          for (Contract innerContract : invocationContract.getInvocation().getInvokedContracts(invocationContract.getType())) {
            result.remove(innerContract);
          }
        }
      } else {
        if (invocationContract.getFactoryComponentContract() != null) {
          result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts(invocationContract.getFactoryComponentContract().getMode()));
        } else {
          result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts());
        }
        // Filter all assigned contracts if necessary
        if (result.size() > 0) {
          for (Contract innerContract : invocationContract.getInvocation().getInvokedContracts()) {
            result.remove(innerContract);
          }
        }
      }
    }
    if (result.contains(null) == false) {
      result.add(null);
    }
    return result;
  }

  public static Collection<InvocationContract> getAvailableSourceInvocationContract(InvocationContract invocationContract) {
    Collection<InvocationContract> result = new UniqueEList<InvocationContract>();
    return result;
  }

  public static Collection<InvocationContract> getAvailableTargetInvocationContract(InvocationContract invocationContract) {
    Collection<InvocationContract> result = new UniqueEList<InvocationContract>();
    return result;
  }

}
