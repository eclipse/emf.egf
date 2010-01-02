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
import java.util.Iterator;

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FactoryComponentContractContainer;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factory Component Contract Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractContainerImpl#getActivity
 * <em>Activity</em>}</li>
 * <li>
 * {@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractContainerImpl#getActivityContracts
 * <em>Activity Contracts</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FactoryComponentContractContainerImpl extends ActivityContractContainerImpl implements FactoryComponentContractContainer {
  /**
   * The cached value of the '{@link #getActivityContracts() <em>Activity Contracts</em>}'
   * containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getActivityContracts()
   * @generated
   * @ordered
   */
  protected EList<FactoryComponentContract> activityContracts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected FactoryComponentContractContainerImpl() {
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
    return FcorePackage.Literals.FACTORY_COMPONENT_CONTRACT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public FactoryComponent getActivity() {
    if (eContainerFeatureID() != FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY)
      return null;
    return (FactoryComponent) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetActivity(FactoryComponent newActivity, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newActivity, FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setActivity(FactoryComponent newActivity) {
    if (newActivity != eInternalContainer() || (eContainerFeatureID() != FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY && newActivity != null)) {
      if (EcoreUtil.isAncestor(this, newActivity))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newActivity != null)
        msgs = ((InternalEObject) newActivity).eInverseAdd(this, FcorePackage.FACTORY_COMPONENT__ACTIVITY_CONTRACT_CONTAINER, FactoryComponent.class, msgs);
      msgs = basicSetActivity(newActivity, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY, newActivity, newActivity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public EList<FactoryComponentContract> getActivityContracts() {
    if (activityContracts == null) {
      activityContracts = new EObjectContainmentWithInverseEList<FactoryComponentContract>(FactoryComponentContract.class, this, FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS, FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER);
    }
    return activityContracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public EList<ActivityContract> getActivityContracts(Type<?> type) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (type != null) {
      for (Iterator<FactoryComponentContract> it = getActivityContracts().iterator(); it.hasNext();) {
        FactoryComponentContract contract = it.next();
        if (contract.getType() != null && ClassHelper.asSubClass(type.getType(), contract.getType().getType())) {
          contracts.add(contract);
        }
      }
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
    if (mode != null) {
      for (Iterator<FactoryComponentContract> it = getActivityContracts().iterator(); it.hasNext();) {
        FactoryComponentContract contract = it.next();
        if (mode == ContractMode.IN && (contract.getMode() == ContractMode.IN || contract.getMode() == ContractMode.IN_OUT)) {
          contracts.add(contract);
        } else if (mode == ContractMode.OUT && (contract.getMode() == ContractMode.OUT || contract.getMode() == ContractMode.IN_OUT)) {
          contracts.add(contract);
        } else if (mode == ContractMode.IN_OUT) {
          contracts.add(contract);
        }
      }
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
  public EList<ActivityContract> getActivityContracts(Type<?> type, ContractMode mode) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    for (Iterator<ActivityContract> it = getActivityContracts(type).iterator(); it.hasNext();) {
      ActivityContract contract = it.next();
      if (mode == ContractMode.IN && (contract.getMode() == ContractMode.IN || contract.getMode() == ContractMode.IN_OUT)) {
        contracts.add(contract);
      } else if (mode == ContractMode.OUT && (contract.getMode() == ContractMode.OUT || contract.getMode() == ContractMode.IN_OUT)) {
        contracts.add(contract);
      } else if (mode == ContractMode.IN_OUT) {
        contracts.add(contract);
      }
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetActivity((FactoryComponent) otherEnd, msgs);
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getActivityContracts()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY:
      return basicSetActivity(null, msgs);
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return ((InternalEList<?>) getActivityContracts()).basicRemove(otherEnd, msgs);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY:
      return eInternalContainer().eInverseRemove(this, FcorePackage.FACTORY_COMPONENT__ACTIVITY_CONTRACT_CONTAINER, FactoryComponent.class, msgs);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY:
      return getActivity();
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return getActivityContracts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY:
      setActivity((FactoryComponent) newValue);
      return;
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      getActivityContracts().clear();
      getActivityContracts().addAll((Collection<? extends FactoryComponentContract>) newValue);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY:
      setActivity((FactoryComponent) null);
      return;
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      getActivityContracts().clear();
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY:
      return getActivity() != null;
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS:
      return activityContracts != null && !activityContracts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // FactoryComponentContractContainerImpl
