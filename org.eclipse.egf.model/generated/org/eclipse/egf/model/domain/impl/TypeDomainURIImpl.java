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

import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.domain.adapter.TypeDomainURIAdapter;
import org.eclipse.egf.model.types.impl.TypeObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Domain URI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.domain.impl.TypeDomainURIImpl#getDomain <em>Domain</em>}</li>
 * <li>{@link org.eclipse.egf.model.domain.impl.TypeDomainURIImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TypeDomainURIImpl extends TypeObjectImpl implements TypeDomainURI {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  protected int flags = 0;

  /**
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected DomainURI domain;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final URI VALUE_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected TypeDomainURIImpl() {
    super();
    new TypeDomainURIAdapter(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DomainPackage.Literals.TYPE_DOMAIN_URI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public DomainURI getDomain() {
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setDomain(DomainURI newDomain) {
    DomainURI oldDomain = domain;
    domain = newDomain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.TYPE_DOMAIN_URI__DOMAIN, oldDomain, domain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public URI getValue() {
    if (getDomain() != null) {
      return getDomain().getUri();
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
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case DomainPackage.TYPE_DOMAIN_URI__DOMAIN:
      return getDomain();
    case DomainPackage.TYPE_DOMAIN_URI__VALUE:
      return getValue();
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
    case DomainPackage.TYPE_DOMAIN_URI__DOMAIN:
      setDomain((DomainURI) newValue);
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
    case DomainPackage.TYPE_DOMAIN_URI__DOMAIN:
      setDomain((DomainURI) null);
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
    case DomainPackage.TYPE_DOMAIN_URI__DOMAIN:
      return domain != null;
    case DomainPackage.TYPE_DOMAIN_URI__VALUE:
      return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
    }
    return super.eIsSet(featureID);
  }

} // TypeDomainURIImpl
