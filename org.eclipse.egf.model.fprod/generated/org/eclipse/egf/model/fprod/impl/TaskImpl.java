/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fprod.impl;

import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.impl.ActivityImpl;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskContract;
import org.eclipse.egf.model.fprod.TaskContractContainer;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fprod.impl.TaskImpl#getActivityContractContainer <em>Activity Contract Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fprod.impl.TaskImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends ActivityImpl implements Task {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * The cached value of the '{@link #getActivityContractContainer() <em>Activity Contract Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivityContractContainer()
   * @generated
   * @ordered
   */
  protected TaskContractContainer activityContractContainer;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TaskImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FprodPackage.Literals.TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskContractContainer getActivityContractContainer() {
    return activityContractContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActivityContractContainer(TaskContractContainer newActivityContractContainer, NotificationChain msgs) {
    TaskContractContainer oldActivityContractContainer = activityContractContainer;
    activityContractContainer = newActivityContractContainer;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER, oldActivityContractContainer, newActivityContractContainer);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivityContractContainer(TaskContractContainer newActivityContractContainer) {
    if (newActivityContractContainer != activityContractContainer) {
      NotificationChain msgs = null;
      if (activityContractContainer != null)
        msgs = ((InternalEObject) activityContractContainer).eInverseRemove(this, FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY, TaskContractContainer.class, msgs);
      if (newActivityContractContainer != null)
        msgs = ((InternalEObject) newActivityContractContainer).eInverseAdd(this, FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY, TaskContractContainer.class, msgs);
      msgs = basicSetActivityContractContainer(newActivityContractContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER, newActivityContractContainer, newActivityContractContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue) {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FprodPackage.TASK__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @SuppressWarnings("unchecked")
  @Override
  public EList<TaskContract> getActivityContracts() {
    EList<TaskContract> contracts = new UniqueEList<TaskContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts();
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public EList<ActivityContract> getActivityContracts(Type<?> innerType) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts(innerType);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public EList<ActivityContract> getActivityContracts(ContractMode mode) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts(mode);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public EList<ActivityContract> getActivityContracts(Type<?> innerType, ContractMode mode) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts(innerType, mode);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER:
      if (activityContractContainer != null)
        msgs = ((InternalEObject) activityContractContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER, null, msgs);
      return basicSetActivityContractContainer((TaskContractContainer) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER:
      return basicSetActivityContractContainer(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER:
      return getActivityContractContainer();
    case FprodPackage.TASK__VALUE:
      return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER:
      setActivityContractContainer((TaskContractContainer) newValue);
      return;
    case FprodPackage.TASK__VALUE:
      setValue((String) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER:
      setActivityContractContainer((TaskContractContainer) null);
      return;
    case FprodPackage.TASK__VALUE:
      setValue(VALUE_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER:
      return activityContractContainer != null;
    case FprodPackage.TASK__VALUE:
      return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (value: "); //$NON-NLS-1$
    result.append(value);
    result.append(')');
    return result.toString();
  }

} // TaskImpl
