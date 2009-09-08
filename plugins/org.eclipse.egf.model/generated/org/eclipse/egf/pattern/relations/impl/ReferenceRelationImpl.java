/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.relations.impl;

import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.relations.ReferenceRelation;
import org.eclipse.egf.pattern.relations.RelationsPackage;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference Relation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.pattern.relations.impl.ReferenceRelationImpl#getReferencedPattern <em>Referenced Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceRelationImpl extends PatternRelationImpl implements ReferenceRelation {
  /**
   * The cached value of the '{@link #getReferencedPattern() <em>Referenced Pattern</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getReferencedPattern()
   * @generated
   * @ordered
   */
  protected Pattern referencedPattern;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceRelationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return RelationsPackage.Literals.REFERENCE_RELATION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Pattern getReferencedPattern() {
    if (referencedPattern != null && referencedPattern.eIsProxy()) {
      InternalEObject oldReferencedPattern = (InternalEObject)referencedPattern;
      referencedPattern = (Pattern)eResolveProxy(oldReferencedPattern);
      if (referencedPattern != oldReferencedPattern) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsPackage.REFERENCE_RELATION__REFERENCED_PATTERN, oldReferencedPattern, referencedPattern));
      }
    }
    return referencedPattern;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Pattern basicGetReferencedPattern() {
    return referencedPattern;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedPattern(Pattern newReferencedPattern) {
    Pattern oldReferencedPattern = referencedPattern;
    referencedPattern = newReferencedPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RelationsPackage.REFERENCE_RELATION__REFERENCED_PATTERN, oldReferencedPattern, referencedPattern));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case RelationsPackage.REFERENCE_RELATION__REFERENCED_PATTERN:
        if (resolve) return getReferencedPattern();
        return basicGetReferencedPattern();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case RelationsPackage.REFERENCE_RELATION__REFERENCED_PATTERN:
        setReferencedPattern((Pattern)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case RelationsPackage.REFERENCE_RELATION__REFERENCED_PATTERN:
        setReferencedPattern((Pattern)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case RelationsPackage.REFERENCE_RELATION__REFERENCED_PATTERN:
        return referencedPattern != null;
    }
    return super.eIsSet(featureID);
  }

} // ReferenceRelationImpl
