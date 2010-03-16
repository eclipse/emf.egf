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

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.types.Type;
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
    // If an OrchestrationParameter is already assigned, InvocationContract in In mode are not assignable
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
    // If an OrchestrationParameter or a SourceInvocationContract is already assigned, InvocationContract in In_Out mode are only assignable to an Out Mode Contract
    if ((invocationContract.getOrchestrationParameter() != null || invocationContract.getSourceInvocationContract() != null) && invocationContract.getInvokedMode() == ContractMode.IN_OUT) {
      for (Iterator<Contract> it = result.iterator(); it.hasNext();) {
        Contract contract = it.next();
        if (contract.getMode() != ContractMode.OUT) {
          it.remove();
        }
      }
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
    // InvocationContract already assigned to a FactoryComponentContract should be in In_Out mode
    if (invocationContract.getFactoryComponentContract() != null && invocationContract.getInvokedMode() != ContractMode.IN_OUT) {
      return result;
    }
    // InvocationContract already assigned to a SourceInvocationContract are not assignable
    if (invocationContract.getSourceInvocationContract() != null) {
      return result;
    }
    // Retrieve all compatible typed OrchestrationParameter
    return invocationContract.getFactoryComponent().getOrchestration().getOrchestrationParameters(invocationContract.getInvokedContract().getType());
  }

  public static Collection<Contract> getAvailableInvokedContract(InvocationContract invocationContract) {
    Collection<Contract> result = new UniqueEList<Contract>();
    // Nothing to retrieve
    if (invocationContract.getInvocation() == null || invocationContract.getInvocation().getInvokedActivity() == null) {
      return result;
    }
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
    if (result.contains(null) == false) {
      result.add(null);
    }
    return result;
  }

  public static Collection<InvocationContract> getAvailableSourceInvocationContract(InvocationContract invocationContract) {
    Collection<InvocationContract> result = new UniqueEList<InvocationContract>();
    // Nothing to retrieve
    if (invocationContract.getInvocation() == null || invocationContract.getFactoryComponent() == null || invocationContract.getFactoryComponent().getOrchestration() == null) {
      return result;
    }
    // To get an assignable source InvocationContract the current invocationContract should have an In or an In_Out Contract Mode.
    if (invocationContract.getInvokedContract() == null || invocationContract.getInvokedMode() == ContractMode.OUT || invocationContract.getInvokedContract().getType() == null) {
      return result;
    }
    // Store the current type
    Type type = invocationContract.getType();
    if (type == null) {
      type = invocationContract.getInvokedContract().getType();
    }
    // InvocationContract already assigned to an OrchestrationParameter are not assignable
    if (invocationContract.getOrchestrationParameter() != null) {
      return result;
    }
    // Assigned FactoryComponentContract should be in Out mode.
    if (invocationContract.getFactoryComponentContract() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
      return result;
    }
    // Source should be an In_Out or an Out mode contract
    for (Invocation invocation : invocationContract.getFactoryComponent().getOrchestration().getInvocations()) {
      // First we check our current Invocation, all retrieved Invocation should be above
      if (invocation == invocationContract.getInvocation()) {
        break;
      }
      // InvocationContract analysis
      for (InvocationContract innerInvocationContract : invocation.getInvocationContracts()) {
        // InvokedContract and its according type should be assigned
        if (innerInvocationContract.getInvokedContract() == null || innerInvocationContract.getInvokedContract().getType() == null) {
          continue;
        }
        // Then we check In_Out or Out mode contract
        if (innerInvocationContract.getInvokedMode() != ContractMode.IN_OUT && innerInvocationContract.getInvokedMode() != ContractMode.OUT) {
          continue;
        }
        // Finally we check if their respective types are compatible
        Type innerType = innerInvocationContract.getType();
        if (innerType == null) {
          innerType = innerInvocationContract.getInvokedContract().getType();
        }
        if (ClassHelper.asSubClass(type.getType(), innerType.getType())) {
          result.add(innerInvocationContract);
        }
      }
    }
    if (result.contains(null) == false) {
      result.add(null);
    }
    return result;
  }

  public static Collection<InvocationContract> getAvailableTargetInvocationContract(InvocationContract invocationContract) {
    Collection<InvocationContract> result = new UniqueEList<InvocationContract>();
    // Nothing to retrieve
    if (invocationContract.getInvocation() == null || invocationContract.getFactoryComponent() == null || invocationContract.getFactoryComponent().getOrchestration() == null) {
      return result;
    }
    // To assign a target InvocationContract the current invocationContract should have an Out or an In_Out Contract Mode.
    if (invocationContract.getInvokedContract() == null || invocationContract.getInvokedMode() == ContractMode.IN || invocationContract.getInvokedContract().getType() == null) {
      return result;
    }
    // Store the current type
    Type type = invocationContract.getType();
    if (type == null) {
      type = invocationContract.getInvokedContract().getType();
    }
    // Target should be an In_Out or an In mode contract
    boolean analyse = false;
    for (Invocation invocation : invocationContract.getFactoryComponent().getOrchestration().getInvocations()) {
      // First we check our current Invocation, all retrieved InvocationContract should be below, ignore current
      if (invocation == invocationContract.getInvocation()) {
        analyse = true;
        continue;
      }
      if (analyse == false) {
        continue;
      }
      for (InvocationContract innerInvocationContract : invocation.getInvocationContracts()) {
        // InvokedContract and its according type should be assigned
        if (innerInvocationContract.getInvokedContract() == null || innerInvocationContract.getInvokedContract().getType() == null) {
          continue;
        }
        // InvocationContract already assigned to an OrchestrationParameter are not assignable
        if (innerInvocationContract.getOrchestrationParameter() != null) {
          continue;
        }
        // Assigned FactoryComponentContract should be in Out mode.
        if (innerInvocationContract.getFactoryComponentContract() != null && innerInvocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
          continue;
        }
        // Then we check In_Out or Out mode contract
        if (innerInvocationContract.getInvokedMode() != ContractMode.IN_OUT && innerInvocationContract.getInvokedMode() != ContractMode.IN) {
          continue;
        }
        // Finally we check if their respective types are compatible
        Type innerType = innerInvocationContract.getType();
        if (innerType == null) {
          innerType = innerInvocationContract.getInvokedContract().getType();
        }
        if (ClassHelper.asSubClass(type.getType(), innerType.getType())) {
          result.add(innerInvocationContract);
        }
      }
    }
    return result;
  }

}
