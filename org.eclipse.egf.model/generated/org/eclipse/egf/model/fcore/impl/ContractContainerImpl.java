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
package org.eclipse.egf.model.fcore.impl;

import java.util.Collection;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.FcorePackage;
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
 * An implementation of the model object '<em><b>Contract Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContractContainerImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContractContainerImpl#getContracts <em>Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContractContainerImpl extends ModelElementImpl implements ContractContainer {
  /**
   * The cached value of the '{@link #getContracts() <em>Contracts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContracts()
   * @generated
   * @ordered
   */
  protected EList<Contract> contracts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContractContainerImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.CONTRACT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity getActivity() {
    if (eContainerFeatureID() != FcorePackage.CONTRACT_CONTAINER__ACTIVITY)
      return null;
    return (Activity) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActivity(Activity newActivity, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newActivity, FcorePackage.CONTRACT_CONTAINER__ACTIVITY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivity(Activity newActivity) {
    if (newActivity != eInternalContainer() || (eContainerFeatureID() != FcorePackage.CONTRACT_CONTAINER__ACTIVITY && newActivity != null)) {
      if (EcoreUtil.isAncestor(this, newActivity))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newActivity != null)
        msgs = ((InternalEObject) newActivity).eInverseAdd(this, FcorePackage.ACTIVITY__CONTRACT_CONTAINER, Activity.class, msgs);
      msgs = basicSetActivity(newActivity, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTRACT_CONTAINER__ACTIVITY, newActivity, newActivity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Contract> getContracts() {
    if (contracts == null) {
      contracts = new EObjectContainmentWithInverseEList<Contract>(Contract.class, this, FcorePackage.CONTRACT_CONTAINER__CONTRACTS, FcorePackage.CONTRACT__CONTRACT_CONTAINER);
    }
    return contracts;
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
    case FcorePackage.CONTRACT_CONTAINER__ACTIVITY:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetActivity((Activity) otherEnd, msgs);
    case FcorePackage.CONTRACT_CONTAINER__CONTRACTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getContracts()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.CONTRACT_CONTAINER__ACTIVITY:
      return basicSetActivity(null, msgs);
    case FcorePackage.CONTRACT_CONTAINER__CONTRACTS:
      return ((InternalEList<?>) getContracts()).basicRemove(otherEnd, msgs);
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
    case FcorePackage.CONTRACT_CONTAINER__ACTIVITY:
      return eInternalContainer().eInverseRemove(this, FcorePackage.ACTIVITY__CONTRACT_CONTAINER, Activity.class, msgs);
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
    case FcorePackage.CONTRACT_CONTAINER__ACTIVITY:
      return getActivity();
    case FcorePackage.CONTRACT_CONTAINER__CONTRACTS:
      return getContracts();
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
    case FcorePackage.CONTRACT_CONTAINER__ACTIVITY:
      setActivity((Activity) newValue);
      return;
    case FcorePackage.CONTRACT_CONTAINER__CONTRACTS:
      getContracts().clear();
      getContracts().addAll((Collection<? extends Contract>) newValue);
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
    case FcorePackage.CONTRACT_CONTAINER__ACTIVITY:
      setActivity((Activity) null);
      return;
    case FcorePackage.CONTRACT_CONTAINER__CONTRACTS:
      getContracts().clear();
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
    case FcorePackage.CONTRACT_CONTAINER__ACTIVITY:
      return getActivity() != null;
    case FcorePackage.CONTRACT_CONTAINER__CONTRACTS:
      return contracts != null && !contracts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // ContractContainerImpl
