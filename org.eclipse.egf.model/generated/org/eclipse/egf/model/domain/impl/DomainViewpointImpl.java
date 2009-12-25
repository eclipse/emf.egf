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

import java.util.Collection;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.fcore.impl.ViewpointImpl;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Viewpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.domain.impl.DomainViewpointImpl#getDomains
 * <em>Domains</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DomainViewpointImpl extends ViewpointImpl implements DomainViewpoint {
  /**
   * A set of bit flags representing the values of boolean attributes and
   * whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * The cached value of the '{@link #getDomains() <em>Domains</em>}'
   * containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getDomains()
   * @generated
   * @ordered
   */
  protected EList<Domain> domains;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected DomainViewpointImpl() {
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
    return DomainPackage.Literals.DOMAIN_VIEWPOINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<Domain> getDomains() {
    if (domains == null) {
      domains = new EObjectContainmentEList<Domain>(Domain.class, this, DomainPackage.DOMAIN_VIEWPOINT__DOMAINS);
    }
    return domains;
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
    case DomainPackage.DOMAIN_VIEWPOINT__DOMAINS:
      return ((InternalEList<?>) getDomains()).basicRemove(otherEnd, msgs);
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
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case DomainPackage.DOMAIN_VIEWPOINT__DOMAINS:
      return getDomains();
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
    case DomainPackage.DOMAIN_VIEWPOINT__DOMAINS:
      getDomains().clear();
      getDomains().addAll((Collection<? extends Domain>) newValue);
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
    case DomainPackage.DOMAIN_VIEWPOINT__DOMAINS:
      getDomains().clear();
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
    case DomainPackage.DOMAIN_VIEWPOINT__DOMAINS:
      return domains != null && !domains.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // DomainViewpointImpl
