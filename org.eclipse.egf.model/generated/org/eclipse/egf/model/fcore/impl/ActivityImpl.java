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

import java.util.List;

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
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ActivityImpl extends ModelElementImpl implements Activity {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActivityImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.ACTIVITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityContractContainer getActivityContractContainer() {
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
  public <T extends ActivityContract> EList<T> getActivityContracts() {
    EList<T> contracts = new UniqueEList<T>();
    if (getActivityContractContainer() != null) {
      contracts.addAll((List<T>) getActivityContractContainer().getActivityContracts());
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
  public <T extends ActivityContract> EList<T> getActivityContracts(Type<?> type) {
    EList<T> contracts = new UniqueEList<T>();
    if (getActivityContractContainer() != null) {
      contracts.addAll((List<T>) getActivityContractContainer().getActivityContracts(type));
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
    if (getActivityContractContainer() != null) {
      contracts.addAll((List<T>) getActivityContractContainer().getActivityContracts(mode));
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
    if (getActivityContractContainer() != null) {
      contracts.addAll((List<T>) getActivityContractContainer().getActivityContracts(type, mode));
    }
    return contracts;
  }

} // ActivityImpl
