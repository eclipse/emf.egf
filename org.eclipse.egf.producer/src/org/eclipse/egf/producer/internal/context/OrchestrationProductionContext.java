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

import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.producer.context.IActivityProductionContext;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.context.IOrchestrationProductionContext;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OrchestrationProductionContext extends ModelElementProductionContext<OrchestrationContext> implements IOrchestrationProductionContext {

  public OrchestrationProductionContext(Orchestration element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public OrchestrationProductionContext(IActivityProductionContext parent, Orchestration element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public Orchestration getElement() {
    return (Orchestration) super.getElement();
  }

  @Override
  public IFactoryComponentProductionContext getParent() {
    return (IFactoryComponentProductionContext) super.getParent();
  }

  @Override
  public Class<?> getInputValueType(Object key) throws InvocationException {
    // Locate an OrchestrationContext, it could be null, just do it for type checking
    OrchestrationContext orchestrationContext = getOrchestrationContext(key, getElement().getOrchestrationContexts());
    InvocationContext invocationContext = (InvocationContext) key;
    Class<?> valueType = null;
    // Always propagate, An InvocationContext shouldn't be in an OrchestrationContext
    // and in an FactoryComponent Contract
    if (invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        valueType = getParent().getInputValueType(invocationContext);
      }
    } else {
      // Shouldn't be null at this stage
      if (orchestrationContext == null) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
      }
      // Looking for local Value Type
      Data data = _inputDatas.get(orchestrationContext);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  @Override
  public <R extends Object> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an OrchestrationContext, it could be null, just do it for type checking
    OrchestrationContext orchestrationContext = getOrchestrationContext(key, getElement().getOrchestrationContexts());
    InvocationContext invocationContext = (InvocationContext) key;
    R value = null;
    // Always propagate, An InvocationContext shouldn't be in an OrchestrationContext
    // and in an FactoryComponent Contract
    if (invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        value = getParent().getInputValue(invocationContext, clazz);
      }
    } else {
      // Shouldn't be null at this stage
      if (orchestrationContext == null) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
      }
      // Looking for local value
      Data data = _inputDatas.get(orchestrationContext);
      if (data != null) {
        value = getValue(orchestrationContext, clazz, data);
      }
    }
    return value;
  }

  @Override
  public Class<?> getOutputValueType(Object key) throws InvocationException {
    // Locate an OrchestrationContext, it should be null, just do it for type checking
    getOrchestrationContext(key, getElement().getOrchestrationContexts());
    InvocationContext invocationContext = (InvocationContext) key;
    Class<?> valueType = null;
    // Always propagate, OrchestrationContext doesn't hold Output Values
    if (invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        valueType = getParent().getOutputValueType(invocationContext);
      }
    }
    return valueType;
  }

  @Override
  public <R extends Object> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
    // Locate an OrchestrationContext, it should be null, just do it for type checking
    getOrchestrationContext(key, getElement().getOrchestrationContexts());
    InvocationContext invocationContext = (InvocationContext) key;
    R value = null;
    // Always propagate, OrchestrationContext doesn't hold Output Values
    if (invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        value = getParent().getOutputValue(invocationContext, clazz);
      }
    }
    return value;
  }

  @Override
  public void setOutputValue(Object key, Object value) throws InvocationException {
    // Locate an OrchestrationContext, it should be null, just do it for type checking
    getOrchestrationContext(key, getElement().getOrchestrationContexts());
    InvocationContext invocationContext = (InvocationContext) key;
    // Always propagate, OrchestrationContext doesn't hold Output Values
    if (invocationContext.getFactoryComponentExposedContract() != null) {
      if (getParent() != null) {
        getParent().setOutputValue(invocationContext, value);
      }
    }
  }

  private OrchestrationContext getOrchestrationContext(Object key, Collection<OrchestrationContext> keys) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    if (key instanceof InvocationContext == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { InvocationContext.class.getName(), EObjectHelper.getText(key), key.getClass().getName(), getName() }));
    }
    // Locate OrchestrationContext
    OrchestrationContext orchestrationContext = null;
    for (OrchestrationContext innerOrchestrationContext : keys) {
      if (innerOrchestrationContext.getInvocationContexts().contains(key)) {
        orchestrationContext = innerOrchestrationContext;
        break;
      }
    }
    // Return
    return orchestrationContext;
  }

}
