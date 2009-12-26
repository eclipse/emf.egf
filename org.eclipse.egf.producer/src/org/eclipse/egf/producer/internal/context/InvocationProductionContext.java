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
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.egf.producer.context.IOrchestrationProductionContext;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class InvocationProductionContext extends ModelElementProductionContext<InvocationContext> implements IInvocationProductionContext {

  public InvocationProductionContext(Invocation<?> element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public InvocationProductionContext(IOrchestrationProductionContext parent, Invocation<?> element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public Invocation<?> getElement() {
    return (Invocation<?>) super.getElement();
  }

  @Override
  public IOrchestrationProductionContext getParent() {
    return (IOrchestrationProductionContext) super.getParent();
  }

  @Override
  public Class<?> getInputValueType(Object key) throws InvocationException {
    // Locate an InvocationContext
    InvocationContext invocationContext = getInvocationContext(key, getElement().getInvocationContexts(ContractMode.IN));
    // Unknown ActivityContract
    if (invocationContext == null) {
      return null;
    }
    Class<?> valueType = null;
    // Is it necessary to propagate ?
    if (invocationContext.getOrchestrationContext() != null || invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        valueType = getParent().getInputValueType(invocationContext);
      }
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data data = _inputDatas.get(invocationContext);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an InvocationContext
    InvocationContext invocationContext = getInvocationContext(key, getElement().getInvocationContexts(ContractMode.IN));
    // Unknown ActivityContract
    if (invocationContext == null) {
      return null;
    }
    R value = null;
    // Is it necessary to propagate ?
    if (invocationContext.getOrchestrationContext() != null || invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        value = getParent().getInputValue(invocationContext, clazz);
      }
    }
    // Looking for local value if necessary
    if (value == null) {
      Data data = _inputDatas.get(invocationContext);
      if (data != null) {
        value = getValue(invocationContext, clazz, data);
      }
    }
    return value;
  }

  @Override
  public Class<?> getOutputValueType(Object key) throws InvocationException {
    // Locate an InvocationContext
    InvocationContext invocationContext = getInvocationContext(key, getElement().getInvocationContexts(ContractMode.OUT));
    // Unknown ActivityContract
    if (invocationContext == null) {
      return null;
    }
    Class<?> valueType = null;
    // Is it necessary to propagate ?
    if (invocationContext.getOrchestrationContext() != null || invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        valueType = getParent().getOutputValueType(invocationContext);
      }
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data data = _outputDatas.get(invocationContext);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an InvocationContext
    InvocationContext invocationContext = getInvocationContext(key, getElement().getInvocationContexts(ContractMode.OUT));
    // Unknown ActivityContract
    if (invocationContext == null) {
      return null;
    }
    R value = null;
    // Is it necessary to propagate ?
    if (invocationContext.getOrchestrationContext() != null || invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        value = getParent().getOutputValue(invocationContext, clazz);
      }
    }
    // Looking for local value if necessary
    if (value == null) {
      Data data = _outputDatas.get(invocationContext);
      if (data != null) {
        value = getValue(invocationContext, clazz, data);
      }
    }
    return value;
  }

  @Override
  public void setOutputValue(Object key, Object value) throws InvocationException {
    // Locate an InvocationContext
    InvocationContext invocationContext = getInvocationContext(key, getElement().getInvocationContexts(ContractMode.OUT));
    // Unknown ActivityContract
    if (invocationContext == null) {
      return;
    }
    // Propagate Value to parent if necessary
    if (invocationContext.getOrchestrationContext() != null || invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        getParent().setOutputValue(invocationContext, value);
      }
    }
    // Fetch available data
    Data data = _outputDatas.get(invocationContext);
    // It could be null at this step.
    if (data == null) {
      return;
    }
    // null value is a valid value
    if (value != null && (ClassHelper.asSubClass(value.getClass(), data.getType()) == false || data.getType().isInstance(value) == false)) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { data.getType().getName(), EMFHelper.getText(key), value.getClass().getName(), getName() }));
    }
    // Set local value
    data.setValue(value);
  }

  private InvocationContext getInvocationContext(Object key, Collection<InvocationContext> keys) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    if (key instanceof ActivityContract == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { ActivityContract.class.getName(), EMFHelper.getText(key), key.getClass().getName(), getName() }));
    }
    // Locate InvocationContext
    InvocationContext invocationContext = null;
    for (InvocationContext innerInvocationContext : keys) {
      if (key == innerInvocationContext.getActivityContract()) {
        invocationContext = innerInvocationContext;
        break;
      }
    }
    // Return
    return invocationContext;
  }

}
