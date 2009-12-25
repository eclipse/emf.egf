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

import java.util.Collection;

import org.eclipse.egf.model.fcore.impl.ActivityContractContainerImpl;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskContract;
import org.eclipse.egf.model.fprod.TaskContractContainer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Contract Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fprod.impl.TaskContractContainerImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fprod.impl.TaskContractContainerImpl#getActivityContracts <em>Activity Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskContractContainerImpl extends ActivityContractContainerImpl implements TaskContractContainer {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * The cached value of the '{@link #getActivityContracts() <em>Activity Contracts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivityContracts()
   * @generated
   * @ordered
   */
  protected EList<TaskContract> activityContracts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TaskContractContainerImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FprodPackage.Literals.TASK_CONTRACT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Task getActivity() {
    if (eContainerFeatureID() != FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY)
      return null;
    return (Task) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActivity(Task newActivity, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newActivity, FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivity(Task newActivity) {
    if (newActivity != eInternalContainer() || (eContainerFeatureID() != FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY && newActivity != null)) {
      if (EcoreUtil.isAncestor(this, newActivity))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newActivity != null)
        msgs = ((InternalEObject) newActivity).eInverseAdd(this, FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER, Task.class, msgs);
      msgs = basicSetActivity(newActivity, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY, newActivity, newActivity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public EList<TaskContract> getActivityContracts() {
    if (activityContracts == null) {
      activityContracts = new EObjectContainmentWithInverseEList<TaskContract>(TaskContract.class, this, FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS, FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER);
    }
    return activityContracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetActivity((Task) otherEnd, msgs);
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getActivityContracts()).basicAdd(otherEnd, msgs);
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
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY:
      return basicSetActivity(null, msgs);
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return ((InternalEList<?>) getActivityContracts()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY:
      return eInternalContainer().eInverseRemove(this, FprodPackage.TASK__ACTIVITY_CONTRACT_CONTAINER, Task.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY:
      return getActivity();
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return getActivityContracts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY:
      setActivity((Task) newValue);
      return;
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      getActivityContracts().clear();
      getActivityContracts().addAll((Collection<? extends TaskContract>) newValue);
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
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY:
      setActivity((Task) null);
      return;
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      getActivityContracts().clear();
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
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY:
      return getActivity() != null;
    case FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return activityContracts != null && !activityContracts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // TaskContractContainerImpl
