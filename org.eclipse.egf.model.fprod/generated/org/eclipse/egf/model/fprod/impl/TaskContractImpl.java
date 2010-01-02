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
import org.eclipse.egf.model.fcore.impl.ActivityContractImpl;
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
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.fprod.impl.TaskContractImpl#getActivityContractContainer
 * <em>Activity Contract Container</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TaskContractImpl extends ActivityContractImpl implements TaskContract {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable
   * features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected TaskContractImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FprodPackage.Literals.TASK_CONTRACT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public Task getActivity() {
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivity();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public TaskContractContainer getActivityContractContainer() {
    if (eContainerFeatureID() != FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER)
      return null;
    return (TaskContractContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetActivityContractContainer(TaskContractContainer newActivityContractContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newActivityContractContainer, FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setActivityContractContainer(TaskContractContainer newActivityContractContainer) {
    if (newActivityContractContainer != eInternalContainer() || (eContainerFeatureID() != FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER && newActivityContractContainer != null)) {
      if (EcoreUtil.isAncestor(this, newActivityContractContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newActivityContractContainer != null)
        msgs = ((InternalEObject) newActivityContractContainer).eInverseAdd(this, FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS, TaskContractContainer.class, msgs);
      msgs = basicSetActivityContractContainer(newActivityContractContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER, newActivityContractContainer, newActivityContractContainer));
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
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetActivityContractContainer((TaskContractContainer) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return basicSetActivityContractContainer(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FprodPackage.TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS, TaskContractContainer.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return getActivityContractContainer();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      setActivityContractContainer((TaskContractContainer) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      setActivityContractContainer((TaskContractContainer) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FprodPackage.TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return getActivityContractContainer() != null;
    }
    return super.eIsSet(featureID);
  }

} // TaskContractImpl
