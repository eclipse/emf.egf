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
package org.eclipse.egf.producer.internal.context;

import java.util.Collection;

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentProductionContext extends ActivityProductionContext<FactoryComponent> implements IFactoryComponentProductionContext {

  public FactoryComponentProductionContext(ProjectBundleSession projectBundleSession, FactoryComponent element, String name) {
    super(projectBundleSession, element, name);
  }

  public FactoryComponentProductionContext(IProductionContext<Invocation, InvocationContract> parent, ProjectBundleSession projectBundleSession, FactoryComponent element, String name) {
    super(parent, projectBundleSession, element, name);
  }

  @Override
  public boolean isSetAtRuntime(Object key) throws InvocationException {
    // It could be a String in this context
    if (key != null && key instanceof String) {
      return super.isSetAtRuntime(key);
    }
    // Locate a Contract
    Contract contract = getContract(key, getInputValueKeys());
    // Contract should be known at this stage
    if (contract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EMFHelper.getText(key), getName()));
    }
    // Looking for a Parent Input Contract set at runtime
    if (getParent() != null) {
      return getParent().isSetAtRuntime(contract);
    }
    return false;
  }

  @Override
  public Class<?> getInputValueType(Object key) throws InvocationException {
    // It could be a String in this context
    if (key != null && key instanceof String) {
      return super.getInputValueType(key);
    }
    // Locate a Contract
    Contract contract = getContract(key, getInputValueKeys());
    // Contract should be known at this stage
    if (contract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EMFHelper.getText(key), getName()));
    }
    Class<?> valueType = null;
    // Looking for Parent Value Type if available
    if (getParent() != null) {
      valueType = getParent().getInputValueType(contract);
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data data = _inputDatas.get(contract);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
    // It could be a String in this context
    if (key != null && key instanceof String) {
      return super.getInputValue(key, clazz);
    }
    // Locate an Contract
    Contract contract = getContract(key, getInputValueKeys());
    // Contract should be known at this stage
    if (contract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EMFHelper.getText(key), getName()));
    }
    R value = null;
    // Looking for Parent Value if available
    if (getParent() != null) {
      value = getParent().getInputValue(contract, clazz);
    }
    // Looking for a local value if necessary
    if (value == null) {
      Data data = _inputDatas.get(contract);
      if (data != null) {
        value = getValue(contract, clazz, data);
      }
    }
    return value;
  }

  @Override
  public Class<?> getOutputValueType(Object key) throws InvocationException {
    // It could be a String in this context
    if (key != null && key instanceof String) {
      return super.getOutputValueType(key);
    }
    // Locate an Contract
    Contract contract = getContract(key, getOutputValueKeys());
    // Contract should be known at this stage
    if (contract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EMFHelper.getText(key), getName()));
    }
    Class<?> valueType = null;
    // Looking for Parent Value Type if available
    if (getParent() != null) {
      valueType = getParent().getOutputValueType(contract);
    }
    // Looking for a local Value Type if necessary
    if (valueType == null) {
      Data data = _outputDatas.get(contract);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
    // It could be a String in this context
    if (key != null && key instanceof String) {
      return super.getOutputValue(key, clazz);
    }
    // Locate an Contract
    Contract contract = getContract(key, getOutputValueKeys());
    // Contract should be known at this stage
    if (contract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EMFHelper.getText(key), getName()));
    }
    R value = null;
    // Looking for Parent Value if available
    if (getParent() != null) {
      value = getParent().getOutputValue(contract, clazz);
    }
    // Looking for a local value if necessary
    if (value == null) {
      Data data = _outputDatas.get(contract);
      if (data != null) {
        value = getValue(contract, clazz, data);
      }
    }
    return value;
  }

  @Override
  public void setOutputValue(Object key, Object value) throws InvocationException {
    // It could be a String in this context
    if (key != null && key instanceof String) {
      super.setOutputValue(key, value);
    }
    // Locate an Contract
    Contract contract = getContract(key, getOutputValueKeys());
    // Contract should be known at this stage
    if (contract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EMFHelper.getText(key), getName()));
    }
    // Propagate Value to parent if necessary
    if (getParent() != null) {
      getParent().setOutputValue(contract, value);
    }
    // Fetch available data
    Data data = _outputDatas.get(contract);
    if (data == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EMFHelper.getText(key), getName()));
    }
    // null value is a valid value
    if (value != null && (ClassHelper.asSubClass(value.getClass(), data.getType()) == false || data.getType().isInstance(value) == false)) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { data.getType().getName(), EMFHelper.getText(key), value.getClass().getName(), getName() }));
    }
    // Set local value
    data.setValue(value);
  }

  private Contract getContract(Object key, Collection<Contract> keys) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    if (key instanceof InvocationContract == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { InvocationContract.class.getName(), EMFHelper.getText(key), key.getClass().getName(), getName() }));
    }
    // Locate Contract
    Contract contract = null;
    for (Contract innerContract : keys) {
      if (innerContract instanceof FactoryComponentContract == false) {
        continue;
      }
      if (((FactoryComponentContract) innerContract).getInvocationContracts().contains(key)) {
        contract = innerContract;
        break;
      }
    }
    // Return
    return contract;
  }

}
