/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl#getPatternFilePath <em>Pattern File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternMethodImpl extends PatternUnitImpl implements PatternMethod {
  /**
   * The cached value of the '{@link #getPattern() <em>Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected Pattern pattern;

  /**
   * The default value of the '{@link #getPatternFilePath() <em>Pattern File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPatternFilePath()
   * @generated
   * @ordered
   */
  protected static final URI PATTERN_FILE_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPatternFilePath() <em>Pattern File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPatternFilePath()
   * @generated
   * @ordered
   */
  protected URI patternFilePath = PATTERN_FILE_PATH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternMethodImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PatternPackage.Literals.PATTERN_METHOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern getPattern() {
    if (pattern != null && pattern.eIsProxy()) {
      InternalEObject oldPattern = (InternalEObject) pattern;
      pattern = (Pattern) eResolveProxy(oldPattern);
      if (pattern != oldPattern) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.PATTERN_METHOD__PATTERN, oldPattern, pattern));
      }
    }
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern basicGetPattern() {
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPattern(Pattern newPattern) {
    Pattern oldPattern = pattern;
    pattern = newPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_METHOD__PATTERN, oldPattern, pattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URI getPatternFilePath() {
    return patternFilePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPatternFilePath(URI newPatternFilePath) {
    URI oldPatternFilePath = patternFilePath;
    patternFilePath = newPatternFilePath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH, oldPatternFilePath,
          patternFilePath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case PatternPackage.PATTERN_METHOD__PATTERN:
      if (resolve)
        return getPattern();
      return basicGetPattern();
    case PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH:
      return getPatternFilePath();
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
    case PatternPackage.PATTERN_METHOD__PATTERN:
      setPattern((Pattern) newValue);
      return;
    case PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH:
      setPatternFilePath((URI) newValue);
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
    case PatternPackage.PATTERN_METHOD__PATTERN:
      setPattern((Pattern) null);
      return;
    case PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH:
      setPatternFilePath(PATTERN_FILE_PATH_EDEFAULT);
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
    case PatternPackage.PATTERN_METHOD__PATTERN:
      return pattern != null;
    case PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH:
      return PATTERN_FILE_PATH_EDEFAULT == null ? patternFilePath != null : !PATTERN_FILE_PATH_EDEFAULT.equals(patternFilePath);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (patternFilePath: "); //$NON-NLS-1$
    result.append(patternFilePath);
    result.append(')');
    return result.toString();
  }

} //PatternMethodImpl
