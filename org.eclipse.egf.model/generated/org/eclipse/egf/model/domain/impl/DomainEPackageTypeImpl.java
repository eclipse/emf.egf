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
package org.eclipse.egf.model.domain.impl;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainEPackageType;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.fcore.impl.TypeImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.model.domain.adapter.DomainEPackageTypeAdapter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPackage Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.domain.impl.DomainEPackageTypeImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.egf.model.domain.impl.DomainEPackageTypeImpl#getEPackage
 * <em>EPackage</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DomainEPackageTypeImpl extends TypeImpl<Domain> implements DomainEPackageType {
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
   * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected DomainEPackage value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected DomainEPackageTypeImpl() {
    super();
    new DomainEPackageTypeAdapter(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DomainPackage.Literals.DOMAIN_EPACKAGE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public DomainEPackage getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setValue(DomainEPackage newValue) {
    DomainEPackage oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_EPACKAGE_TYPE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EPackage getEPackage() {
    if (getValue() != null) {
      return getValue().getEPackage();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public EPackage basicGetEPackage() {
    // TODO: implement this method to return the 'EPackage' reference
    // -> do not perform proxy resolution
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean isSetEPackage() {
    if (getValue() != null) {
      return getValue().getEPackage() != null;
    }
    return false;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Class<Domain> getType() {
    return org.eclipse.egf.model.domain.Domain.class;
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
    case DomainPackage.DOMAIN_EPACKAGE_TYPE__VALUE:
      return getValue();
    case DomainPackage.DOMAIN_EPACKAGE_TYPE__EPACKAGE:
      if (resolve)
        return getEPackage();
      return basicGetEPackage();
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
    case DomainPackage.DOMAIN_EPACKAGE_TYPE__VALUE:
      setValue((DomainEPackage) newValue);
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
    case DomainPackage.DOMAIN_EPACKAGE_TYPE__VALUE:
      setValue((DomainEPackage) null);
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
    case DomainPackage.DOMAIN_EPACKAGE_TYPE__VALUE:
      return value != null;
    case DomainPackage.DOMAIN_EPACKAGE_TYPE__EPACKAGE:
      return isSetEPackage();
    }
    return super.eIsSet(featureID);
  }

} // DomainEPackageTypeImpl
