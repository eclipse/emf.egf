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

import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainURIType;
import org.eclipse.egf.model.fcore.impl.TypeImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.model.domain.adapter.DomainURITypeAdapter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URI Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.domain.impl.DomainURITypeImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.egf.model.domain.impl.DomainURITypeImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DomainURITypeImpl extends TypeImpl<DomainURI> implements DomainURIType {
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
  protected DomainURI value;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final URI URI_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected DomainURITypeImpl() {
    super();
    new DomainURITypeAdapter(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DomainPackage.Literals.DOMAIN_URI_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public DomainURI getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setValue(DomainURI newValue) {
    DomainURI oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_URI_TYPE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public URI getUri() {
    if (getValue() != null) {
      return getValue().getUri();
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
  public Class<DomainURI> getType() {
    return org.eclipse.egf.model.domain.DomainURI.class;
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
    case DomainPackage.DOMAIN_URI_TYPE__VALUE:
      return getValue();
    case DomainPackage.DOMAIN_URI_TYPE__URI:
      return getUri();
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
    case DomainPackage.DOMAIN_URI_TYPE__VALUE:
      setValue((DomainURI) newValue);
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
    case DomainPackage.DOMAIN_URI_TYPE__VALUE:
      setValue((DomainURI) null);
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
    case DomainPackage.DOMAIN_URI_TYPE__VALUE:
      return value != null;
    case DomainPackage.DOMAIN_URI_TYPE__URI:
      return URI_EDEFAULT == null ? getUri() != null : !URI_EDEFAULT.equals(getUri());
    }
    return super.eIsSet(featureID);
  }

} // DomainURITypeImpl
