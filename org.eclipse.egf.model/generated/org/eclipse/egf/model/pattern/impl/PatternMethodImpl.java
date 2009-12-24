/**
 * <copyright>
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
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.factorycomponent.impl.ModelElementImpl;
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
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl#getPattern
 * <em>Pattern</em>}</li>
 * <li>
 * {@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl#getPatternFilePath
 * <em>Pattern File Path</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PatternMethodImpl extends ModelElementImpl implements PatternMethod {
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
   * The default value of the '{@link #getPatternFilePath()
   * <em>Pattern File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getPatternFilePath()
   * @generated
   * @ordered
   */
  protected static final URI PATTERN_FILE_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPatternFilePath()
   * <em>Pattern File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getPatternFilePath()
   * @generated
   * @ordered
   */
  protected URI patternFilePath = PATTERN_FILE_PATH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected PatternMethodImpl() {
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
    return PatternPackage.Literals.PATTERN_METHOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Pattern getPattern() {
    if (eContainerFeatureID() != PatternPackage.PATTERN_METHOD__PATTERN)
      return null;
    return (Pattern) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetPattern(Pattern newPattern, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newPattern, PatternPackage.PATTERN_METHOD__PATTERN, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setPattern(Pattern newPattern) {
    if (newPattern != eInternalContainer() || (eContainerFeatureID() != PatternPackage.PATTERN_METHOD__PATTERN && newPattern != null)) {
      if (EcoreUtil.isAncestor(this, newPattern))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newPattern != null)
        msgs = ((InternalEObject) newPattern).eInverseAdd(this, PatternPackage.PATTERN__METHODS, Pattern.class, msgs);
      msgs = basicSetPattern(newPattern, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_METHOD__PATTERN, newPattern, newPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public URI getPatternFilePath() {
    return patternFilePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setPatternFilePath(URI newPatternFilePath) {
    URI oldPatternFilePath = patternFilePath;
    patternFilePath = newPatternFilePath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH, oldPatternFilePath, patternFilePath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case PatternPackage.PATTERN_METHOD__PATTERN:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetPattern((Pattern) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
    case PatternPackage.PATTERN_METHOD__PATTERN:
      return basicSetPattern(null, msgs);
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
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case PatternPackage.PATTERN_METHOD__PATTERN:
      return eInternalContainer().eInverseRemove(this, PatternPackage.PATTERN__METHODS, Pattern.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
    case PatternPackage.PATTERN_METHOD__PATTERN:
      return getPattern();
    case PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH:
      return getPatternFilePath();
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
   * 
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
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case PatternPackage.PATTERN_METHOD__PATTERN:
      return getPattern() != null;
    case PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH:
      return PATTERN_FILE_PATH_EDEFAULT == null ? patternFilePath != null : !PATTERN_FILE_PATH_EDEFAULT.equals(patternFilePath);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
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

} // PatternMethodImpl
