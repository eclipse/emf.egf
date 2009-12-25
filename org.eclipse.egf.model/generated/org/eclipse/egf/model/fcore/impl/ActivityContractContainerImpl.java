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

import java.util.Iterator;

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Contract Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ActivityContractContainerImpl extends ModelElementImpl implements ActivityContractContainer {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActivityContractContainerImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.ACTIVITY_CONTRACT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity getActivity() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public <T extends ActivityContract> EList<T> getActivityContracts() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @SuppressWarnings("unchecked")
  public <T extends ActivityContract> EList<T> getActivityContracts(Type<?> type) {
    EList<T> contracts = new UniqueEList<T>();
    if (type != null) {
      for (Iterator<ActivityContract> it = getActivityContracts().iterator(); it.hasNext();) {
        T contract = (T) it.next();
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
  @SuppressWarnings("unchecked")
  public <T extends ActivityContract> EList<T> getActivityContracts(ContractMode mode) {
    EList<T> contracts = new UniqueEList<T>();
    if (mode != null) {
      for (Iterator<ActivityContract> it = getActivityContracts().iterator(); it.hasNext();) {
        T contract = (T) it.next();
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
  @SuppressWarnings("unchecked")
  public <T extends ActivityContract> EList<T> getActivityContracts(Type<?> type, ContractMode mode) {
    EList<T> contracts = new UniqueEList<T>();
    for (Iterator<ActivityContract> it = getActivityContracts(type).iterator(); it.hasNext();) {
      T contract = (T) it.next();
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

} // ActivityContractContainerImpl
