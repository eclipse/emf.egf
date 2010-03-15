/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.impl.DomainEPackageImpl#getEPackage <em>EPackage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainEPackageImpl extends DomainImpl implements DomainEPackage {
  /**
   * The cached value of the '{@link #getEPackage() <em>EPackage</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEPackage()
   * @generated
   * @ordered
   */
  protected EPackage ePackage;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DomainEPackageImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DomainPackage.Literals.DOMAIN_EPACKAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage getEPackage() {
    if (ePackage != null && ePackage.eIsProxy()) {
      InternalEObject oldEPackage = (InternalEObject) ePackage;
      ePackage = (EPackage) eResolveProxy(oldEPackage);
      if (ePackage != oldEPackage) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomainPackage.DOMAIN_EPACKAGE__EPACKAGE, oldEPackage, ePackage));
      }
    }
    return ePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage basicGetEPackage() {
    return ePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEPackage(EPackage newEPackage) {
    EPackage oldEPackage = ePackage;
    ePackage = newEPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_EPACKAGE__EPACKAGE, oldEPackage, ePackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case DomainPackage.DOMAIN_EPACKAGE__EPACKAGE:
      if (resolve)
        return getEPackage();
      return basicGetEPackage();
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
    case DomainPackage.DOMAIN_EPACKAGE__EPACKAGE:
      setEPackage((EPackage) newValue);
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
    case DomainPackage.DOMAIN_EPACKAGE__EPACKAGE:
      setEPackage((EPackage) null);
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
    case DomainPackage.DOMAIN_EPACKAGE__EPACKAGE:
      return ePackage != null;
    }
    return super.eIsSet(featureID);
  }

} //DomainEPackageImpl
