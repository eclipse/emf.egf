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
import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentProductionContext extends ActivityProductionContext implements IFactoryComponentProductionContext {

  public FactoryComponentProductionContext(FactoryComponent element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public FactoryComponentProductionContext(IInvocationProductionContext parent, FactoryComponent element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public FactoryComponent getElement() {
    return (FactoryComponent) super.getElement();
  }

  @Override
  public Class<?> getInputValueType(Object key) throws InvocationException {
    // It could be a String in this context
    if (key != null && key instanceof String) {
      return super.getInputValueType(key);
    }
    // Locate an ActivityContract
    ActivityContract activityContract = getFactoryComponentContract(key, getElement().getActivityContracts(ContractMode.IN));
    // ActivityContract should be known at this stage
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EObjectHelper.getText(key), getName()));
    }
    Class<?> valueType = null;
    // Looking for Parent Value Type if available
    if (getParent() != null) {
      valueType = getParent().getInputValueType(activityContract);
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data data = _inputDatas.get(activityContract);
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
    // Locate an FactoryComponentContract
    ActivityContract activityContract = getFactoryComponentContract(key, getElement().getActivityContracts(ContractMode.IN));
    // ActivityContract should be known at this stage
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EObjectHelper.getText(key), getName()));
    }
    R value = null;
    // Looking for Parent Value if available
    if (getParent() != null) {
      value = getParent().getInputValue(activityContract, clazz);
    }
    // Looking for a local value if necessary
    if (value == null) {
      Data data = _inputDatas.get(activityContract);
      if (data != null) {
        value = getValue(activityContract, clazz, data);
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
    // Locate an ActivityContract
    ActivityContract activityContract = getFactoryComponentContract(key, getElement().getActivityContracts(ContractMode.OUT));
    // ActivityContract should be known at this stage
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EObjectHelper.getText(key), getName()));
    }
    Class<?> valueType = null;
    // Looking for Parent Value Type if available
    if (getParent() != null) {
      valueType = getParent().getOutputValueType(activityContract);
    }
    // Looking for a local Value Type if necessary
    if (valueType == null) {
      Data data = _outputDatas.get(activityContract);
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
    // Locate an ActivityContract
    ActivityContract activityContract = getFactoryComponentContract(key, getElement().getActivityContracts(ContractMode.OUT));
    // ActivityContract should be known at this stage
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EObjectHelper.getText(key), getName()));
    }
    R value = null;
    // Looking for Parent Value if available
    if (getParent() != null) {
      value = getParent().getOutputValue(activityContract, clazz);
    }
    // Looking for a local value if necessary
    if (value == null) {
      Data data = _outputDatas.get(activityContract);
      if (data != null) {
        value = getValue(activityContract, clazz, data);
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
    // Locate an ActivityContract
    ActivityContract activityContract = getFactoryComponentContract(key, getElement().getActivityContracts(ContractMode.OUT));
    // ActivityContract should be known at this stage
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EObjectHelper.getText(key), getName()));
    }
    // Propagate Value to parent if necessary
    if (getParent() != null) {
      getParent().setOutputValue(activityContract, value);
    }
    // Fetch available data
    Data data = _outputDatas.get(activityContract);
    if (data == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EObjectHelper.getText(key), getName()));
    }
    // null value is a valid value
    if (value != null && (ClassHelper.asSubClass(value.getClass(), data.getType()) == false || data.getType().isInstance(value) == false)) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { data.getType().getName(), EObjectHelper.getText(key), value.getClass().getName(), getName() }));
    }
    // Set local value
    data.setValue(value);
  }

  private FactoryComponentContract getFactoryComponentContract(Object key, Collection<ActivityContract> keys) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    if (key instanceof InvocationContext == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { InvocationContext.class.getName(), EObjectHelper.getText(key), key.getClass().getName(), getName() }));
    }
    // Locate FactoryComponentContract
    FactoryComponentContract factoryComponentContract = null;
    for (ActivityContract activityContract : keys) {
      // Shouldn't happen
      if (activityContract instanceof FactoryComponentContract == false) {
        continue;
      }
      FactoryComponentContract innerFactoryComponentContract = (FactoryComponentContract) activityContract;
      if (innerFactoryComponentContract.getInvocationContexts().contains(key)) {
        factoryComponentContract = innerFactoryComponentContract;
        break;
      }
    }
    // Return
    return factoryComponentContract;
  }

}
