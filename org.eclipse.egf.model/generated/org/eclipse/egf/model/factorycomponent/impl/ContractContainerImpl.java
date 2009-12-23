/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent.impl;

import java.util.Collection;

import org.eclipse.egf.model.factorycomponent.Contract;
import org.eclipse.egf.model.factorycomponent.ContractContainer;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContractContainerImpl#getContracts <em>Contracts</em>}</li>
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
    return FactoryComponentPackage.Literals.CONTRACT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Contract> getContracts() {
    if (contracts == null) {
      contracts = new EObjectContainmentEList<Contract>(Contract.class, this, FactoryComponentPackage.CONTRACT_CONTAINER__CONTRACTS);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONTAINER__CONTRACTS:
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
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONTAINER__CONTRACTS:
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
    case FactoryComponentPackage.CONTRACT_CONTAINER__CONTRACTS:
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
    case FactoryComponentPackage.CONTRACT_CONTAINER__CONTRACTS:
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
    case FactoryComponentPackage.CONTRACT_CONTAINER__CONTRACTS:
      return contracts != null && !contracts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ContractContainerImpl
