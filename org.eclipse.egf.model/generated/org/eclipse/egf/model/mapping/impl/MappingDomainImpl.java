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
package org.eclipse.egf.model.mapping.impl;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.mapping.MappingDomain;
import org.eclipse.egf.model.mapping.MappingPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.mapping.impl.MappingDomainImpl#getSource
 * <em>Source</em>}</li>
 * <li>{@link org.eclipse.egf.model.mapping.impl.MappingDomainImpl#getTarget
 * <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MappingDomainImpl extends MappingImpl implements MappingDomain {
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected Domain source;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Domain target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected MappingDomainImpl() {
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
    return MappingPackage.Literals.MAPPING_DOMAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Domain getSource() {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setSource(Domain newSource) {
    Domain oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_DOMAIN__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Domain getTarget() {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setTarget(Domain newTarget) {
    Domain oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_DOMAIN__TARGET, oldTarget, target));
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
    case MappingPackage.MAPPING_DOMAIN__SOURCE:
      return getSource();
    case MappingPackage.MAPPING_DOMAIN__TARGET:
      return getTarget();
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
    case MappingPackage.MAPPING_DOMAIN__SOURCE:
      setSource((Domain) newValue);
      return;
    case MappingPackage.MAPPING_DOMAIN__TARGET:
      setTarget((Domain) newValue);
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
    case MappingPackage.MAPPING_DOMAIN__SOURCE:
      setSource((Domain) null);
      return;
    case MappingPackage.MAPPING_DOMAIN__TARGET:
      setTarget((Domain) null);
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
    case MappingPackage.MAPPING_DOMAIN__SOURCE:
      return source != null;
    case MappingPackage.MAPPING_DOMAIN__TARGET:
      return target != null;
    }
    return super.eIsSet(featureID);
  }

} // MappingDomainImpl
