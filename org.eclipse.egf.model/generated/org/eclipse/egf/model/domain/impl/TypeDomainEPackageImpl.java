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

import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.TypeDomainEPackage;
import org.eclipse.egf.model.domain.adapter.TypeDomainEPackageAdapter;
import org.eclipse.egf.model.types.impl.TypeObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Domain EPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.impl.TypeDomainEPackageImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.egf.model.domain.impl.TypeDomainEPackageImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeDomainEPackageImpl extends TypeObjectImpl implements TypeDomainEPackage {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected DomainEPackage domain;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected TypeDomainEPackageImpl() {
    super();
    new TypeDomainEPackageAdapter(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DomainPackage.Literals.TYPE_DOMAIN_EPACKAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainEPackage getDomain() {
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDomain(DomainEPackage newDomain) {
    DomainEPackage oldDomain = domain;
    domain = newDomain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.TYPE_DOMAIN_EPACKAGE__DOMAIN, oldDomain, domain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EPackage getValue() {
    EPackage value = basicGetValue();
    return value != null && value.eIsProxy() ? (EPackage) eResolveProxy((InternalEObject) value) : value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EPackage basicGetValue() {
    if (getDomain() != null) {
      return getDomain().getEPackage();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case DomainPackage.TYPE_DOMAIN_EPACKAGE__DOMAIN:
      return getDomain();
    case DomainPackage.TYPE_DOMAIN_EPACKAGE__VALUE:
      if (resolve)
        return getValue();
      return basicGetValue();
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
    case DomainPackage.TYPE_DOMAIN_EPACKAGE__DOMAIN:
      setDomain((DomainEPackage) newValue);
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
    case DomainPackage.TYPE_DOMAIN_EPACKAGE__DOMAIN:
      setDomain((DomainEPackage) null);
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
    case DomainPackage.TYPE_DOMAIN_EPACKAGE__DOMAIN:
      return domain != null;
    case DomainPackage.TYPE_DOMAIN_EPACKAGE__VALUE:
      return basicGetValue() != null;
    }
    return super.eIsSet(featureID);
  }

} // TypeDomainEPackageImpl
