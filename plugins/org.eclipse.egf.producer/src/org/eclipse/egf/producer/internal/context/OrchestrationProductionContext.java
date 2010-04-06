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
package org.eclipse.egf.producer.internal.context;

import java.util.Collection;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OrchestrationProductionContext<P extends Orchestration> extends ProductionContext<P, OrchestrationParameter> {

  public OrchestrationProductionContext(ProjectBundleSession projectBundleSession, P element, String name) {
    super(projectBundleSession, element, name);
  }

  public OrchestrationProductionContext(IProductionContext<FactoryComponent, Contract> parent, ProjectBundleSession projectBundleSession, P element, String name) {
    super(parent, projectBundleSession, element, name);
  }

  @Override
  public boolean isSetAtRuntime(Object key) throws InvocationException {
    // Locate an OrchestrationParameter, just do it for key type checking
    getOrchestrationParameter(key, getInputValueKeys(), getName(), __inputMode);
    InvocationContract invocationContract = (InvocationContract) key;
    // Always propagate, An InvocationContract shouldn't be in an OrchestrationParameter
    // and in an FactoryComponentContract
    if (invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
        return getParent().isSetAtRuntime(invocationContract);
      }
    }
    return false;
  }

  @Override
  public Class<?> getInputValueType(Object key) throws InvocationException {
    // Locate an OrchestrationParameter, it could be null, just do it for key type checking
    OrchestrationParameter orchestrationParameter = getOrchestrationParameter(key, getInputValueKeys(), getName(), __inputMode);
    InvocationContract invocationContract = (InvocationContract) key;
    Class<?> valueType = null;
    // Always propagate, An InvocationContract shouldn't be in an OrchestrationParameter
    // and in an FactoryComponent Contract
    if (invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
        valueType = getParent().getInputValueType(invocationContract);
      }
    } else {
      // Shouldn't be null at this stage
      if (orchestrationParameter == null) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __inputMode, getName()));
      }
      // Looking for a local Value Type
      Data data = _inputDatas.get(orchestrationParameter);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an OrchestrationParameter, it could be null, just do it for key type checking
    OrchestrationParameter orchestrationParameter = getOrchestrationParameter(key, getInputValueKeys(), getName(), __inputMode);
    InvocationContract invocationContract = (InvocationContract) key;
    R value = null;
    // Always propagate, An InvocationContract shouldn't be in an OrchestrationParameter
    // and in an FactoryComponent Contract
    if (invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
        value = getParent().getInputValue(invocationContract, clazz);
      }
    } else {
      // Shouldn't be null at this stage
      if (orchestrationParameter == null) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __inputMode, getName()));
      }
      // Looking for a local value
      Data inputData = _inputDatas.get(orchestrationParameter);
      if (inputData != null) {
        value = getValue(orchestrationParameter, clazz, inputData, __inputMode);
      }
    }
    return value;
  }

  @Override
  public Class<?> getOutputValueType(Object key) throws InvocationException {
    // Locate an OrchestrationParameter, it should be null, just do it for key type checking
    getOrchestrationParameter(key, getOutputValueKeys(), getName(), __outputMode);
    InvocationContract invocationContract = (InvocationContract) key;
    Class<?> valueType = null;
    // Always propagate, OrchestrationParameter doesn't hold Output Values
    if (invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.IN) {
        valueType = getParent().getOutputValueType(invocationContract);
      }
    }
    return valueType;
  }

  @Override
  public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an OrchestrationParameter, it should be null, just do it for key type checking
    getOrchestrationParameter(key, getOutputValueKeys(), getName(), __outputMode);
    InvocationContract invocationContract = (InvocationContract) key;
    R value = null;
    // Always propagate, OrchestrationParameter doesn't hold Output Values
    if (invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.IN) {
        value = getParent().getOutputValue(invocationContract, clazz);
      }
    }
    return value;
  }

  @Override
  public void setOutputValue(Object key, Object value) throws InvocationException {
    // Locate an OrchestrationParameter, it should be null, just do it for key type checking
    getOrchestrationParameter(key, getOutputValueKeys(), getName(), __outputMode);
    InvocationContract invocationContract = (InvocationContract) key;
    // Always propagate, OrchestrationParameter doesn't hold Output Values
    if (invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.IN) {
        getParent().setOutputValue(invocationContract, value);
      }
    }
  }

  private static OrchestrationParameter getOrchestrationParameter(Object key, Collection<OrchestrationParameter> keys, String name, String mode) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, mode, name));
    }
    if (key instanceof InvocationContract == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { InvocationContract.class.getName(), mode, EMFHelper.getText(key), key.getClass().getName(), name }));
    }
    // Locate OrchestrationParameter
    OrchestrationParameter orchestrationParameter = null;
    for (OrchestrationParameter innerOrchestrationParameter : keys) {
      if (innerOrchestrationParameter.getInvocationContracts().contains(key)) {
        orchestrationParameter = innerOrchestrationParameter;
        break;
      }
    }
    // Return
    return orchestrationParameter;
  }

}
