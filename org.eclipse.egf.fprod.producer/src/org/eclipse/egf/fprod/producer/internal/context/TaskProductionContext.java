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
package org.eclipse.egf.fprod.producer.internal.context;

import java.util.Collection;

import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.ITaskInvocationProductionContext;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.producer.internal.context.ActivityProductionContext;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProductionContext extends ActivityProductionContext implements ITaskProductionContext {

  public TaskProductionContext(Task element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public TaskProductionContext(ITaskInvocationProductionContext parent, Task element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public Task getElement() {
    return (Task) super.getElement();
  }

  @Override
  public ITaskInvocationProductionContext getParent() {
    return (ITaskInvocationProductionContext) _parent;
  }

  @Override
  public Class<?> getInputValueType(Object key) throws InvocationException {
    // Looking for an ActivityContract
    ActivityContract activityContract = getActivityContract(key, getInputValueKeys());
    // Unknown ActivityContract
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_name, ((String) key).trim(), getName()));
    }
    // Looking for an Input ActivityContract type
    return super.getInputValueType(activityContract);
  }

  @Override
  public <R extends Object> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
    // Looking for an ActivityContract
    ActivityContract activityContract = getActivityContract(key, getInputValueKeys());
    // Unknown ActivityContract
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_name, ((String) key).trim(), getName()));
    }
    // Looking for an Input ActivityContract value
    return super.getInputValue(activityContract, clazz);
  }

  @Override
  public Class<?> getOutputValueType(Object key) throws InvocationException {
    // Looking for an ActivityContract
    ActivityContract activityContract = getActivityContract(key, getOutputValueKeys());
    // Unknown ActivityContract
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_name, ((String) key).trim(), getName()));
    }
    // Looking for an Output ActivityContract type
    return super.getOutputValueType(activityContract);
  }

  @Override
  public <R extends Object> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
    // Looking for an ActivityContract
    ActivityContract activityContract = getActivityContract(key, getOutputValueKeys());
    // Unknown ActivityContract
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_name, ((String) key).trim(), getName()));
    }
    // Looking for an Output ActivityContract value
    return super.getOutputValue(activityContract, clazz);
  }

  @Override
  public void setOutputValue(Object key, Object value) throws InvocationException {
    // Looking for an ActivityContract
    ActivityContract activityContract = getActivityContract(key, getOutputValueKeys());
    // Unknown ActivityContract
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_name, ((String) key).trim(), getName()));
    }
    // Set ActivityContract Value
    super.setOutputValue(activityContract, value);
  }

  private ActivityContract getActivityContract(Object key, Collection<ActivityContract> keys) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_name, getName()));
    }
    if (key instanceof String == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { String.class.getName(), EObjectHelper.getText(key), key.getClass().getName(), getName() }));
    }
    String innerName = ((String) key).trim();
    if (innerName.length() == 0) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_emtpy_name, getName()));
    }
    // Looking for an ActivityContract
    ActivityContract activityContract = null;
    for (ActivityContract innerActivityContract : keys) {
      if (innerName.equals(innerActivityContract.getName())) {
        activityContract = innerActivityContract;
        break;
      }
    }
    // Unknown ActivityContract
    if (activityContract == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_name, innerName, getName()));
    }
    // Return
    return activityContract;
  }

}
