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

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class InvocationProductionContext<P extends Invocation, T extends Orchestration> extends ProductionContext<P, InvocationContract> {

  public InvocationProductionContext(ProjectBundleSession projectBundleSession, P element, String name) {
    super(projectBundleSession, element, name);
  }

  public InvocationProductionContext(IProductionContext<T, OrchestrationParameter> parent, ProjectBundleSession projectBundleSession, P element, String name) {
    super(parent, projectBundleSession, element, name);
  }

  @Override
  public boolean isSetAtRuntime(Object key) throws InvocationException {
    // Locate an InvocationContract
    InvocationContract invocationContract = getInvocationContract(key, getInputValueKeys(), getName(), __inputMode);
    // Unknown InvocationContract
    if (invocationContract == null) {
      return false;
    }
    // Input Contract is set at runtime
    if (invocationContract.getSourceInvocationContract() != null) {
      return true;
    }
    // Is it necessary to propagate ?
    if (invocationContract.getOrchestrationParameter() != null || invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null) {
        return getParent().isSetAtRuntime(invocationContract);
      }
    }
    return false;
  }

  @Override
  public Class<?> getInputValueType(Object key) throws InvocationException {
    // Locate an InvocationContract
    InvocationContract invocationContract = getInvocationContract(key, getInputValueKeys(), getName(), __inputMode);
    // Unknown InvocationContract
    if (invocationContract == null) {
      return null;
    }
    // Parent or local value
    Class<?> valueType = null;
    // Is it necessary to propagate ?
    if (invocationContract.getOrchestrationParameter() != null || invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null) {
        valueType = getParent().getInputValueType(invocationContract);
      }
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data inputData = _inputDatas.get(invocationContract);
      if (inputData != null) {
        valueType = inputData.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an InvocationContract
    InvocationContract invocationContract = getInvocationContract(key, getInputValueKeys(), getName(), __inputMode);
    // Unknown InvocationContract
    if (invocationContract == null) {
      return null;
    }
    R value = null;
    // Is it necessary to propagate ?
    if (invocationContract.getOrchestrationParameter() != null || invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null) {
        value = getParent().getInputValue(invocationContract, clazz);
      }
    }
    // Looking for local value if necessary
    if (value == null) {
      Data inputData = _inputDatas.get(invocationContract);
      if (inputData != null) {
        value = getValue(invocationContract, clazz, inputData, __inputMode);
      }
    }
    return value;
  }

  @Override
  public Class<?> getOutputValueType(Object key) throws InvocationException {
    // Locate an InvocationContract
    InvocationContract invocationContract = getInvocationContract(key, getOutputValueKeys(), getName(), __outputMode);
    // Unknown InvocationContract
    if (invocationContract == null) {
      return null;
    }
    Class<?> valueType = null;
    // Is it necessary to propagate ?
    if (invocationContract.getOrchestrationParameter() != null || invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null) {
        valueType = getParent().getOutputValueType(invocationContract);
      }
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data outputData = _outputDatas.get(invocationContract);
      if (outputData != null) {
        valueType = outputData.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an InvocationContract
    InvocationContract invocationContract = getInvocationContract(key, getOutputValueKeys(), getName(), __outputMode);
    // Unknown InvocationContract
    if (invocationContract == null) {
      return null;
    }
    R value = null;
    // Is it necessary to propagate ?
    if (invocationContract.getOrchestrationParameter() != null || invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null) {
        value = getParent().getOutputValue(invocationContract, clazz);
      }
    }
    // Looking for local value if necessary
    if (value == null) {
      Data outputData = _outputDatas.get(invocationContract);
      if (outputData != null) {
        value = getValue(invocationContract, clazz, outputData, __outputMode);
      }
    }
    return value;
  }

  @Override
  public void setOutputValue(Object key, Object value) throws InvocationException {
    // Locate an InvocationContract
    InvocationContract invocationContract = getInvocationContract(key, getOutputValueKeys(), getName(), __outputMode);
    // Unknown InvocationContract
    if (invocationContract == null) {
      return;
    }
    // Propagate Value to parent if necessary
    if (invocationContract.getOrchestrationParameter() != null || invocationContract.getFactoryComponentContract() != null) {
      if (getParent() != null) {
        getParent().setOutputValue(invocationContract, value);
      }
    }
    // Fetch available output data
    Data outputData = _outputDatas.get(invocationContract);
    // It could be null at this step.
    if (outputData == null) {
      return;
    }
    // null value is a valid value
    if (value != null && (ClassHelper.asSubClass(value.getClass(), outputData.getType()) == false || outputData.getType().isInstance(value) == false)) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { outputData.getType().getName(), __outputMode, EMFHelper.getText(key), value.getClass().getName(), getName() }));
    }
    // Set output value
    outputData.setValue(value);
    // Set input value if it exists
    Data inputData = _inputDatas.get(key);
    if (inputData != null) {
      inputData.setValue(value);
    }
  }

  private static InvocationContract getInvocationContract(Object key, Collection<InvocationContract> keys, String name, String mode) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, mode, name));
    }
    if (key instanceof Contract == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { Contract.class.getName(), mode, EMFHelper.getText(key), key.getClass().getName(), name }));
    }
    // Locate InvocationContract
    InvocationContract invocationContract = null;
    for (InvocationContract innerInvocationContract : keys) {
      if (key == innerInvocationContract.getInvokedContract()) {
        invocationContract = innerInvocationContract;
        break;
      }
    }
    // Return
    return invocationContract;
  }

}
