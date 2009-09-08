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
package org.eclipse.egf.model.impl;

import java.util.Collection;

import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pattern Library</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.PatternLibraryImpl#getPatternElements <em>Pattern Elements</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.PatternLibraryImpl#getProductionOrchestration <em>Production Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.PatternLibraryImpl#getRuntimeOrchestration <em>Runtime Orchestration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternLibraryImpl extends AbstractPatternElementImpl implements PatternLibrary {
  /**
   * The cached value of the '{@link #getPatternElements() <em>Pattern Elements</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getPatternElements()
   * @generated
   * @ordered
   */
  protected EList<AbstractPatternElement> patternElements;

  /**
   * The default value of the '{@link #getProductionOrchestration() <em>Production Orchestration</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getProductionOrchestration()
   * @generated
   * @ordered
   */
  protected static final String PRODUCTION_ORCHESTRATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProductionOrchestration() <em>Production Orchestration</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getProductionOrchestration()
   * @generated
   * @ordered
   */
  protected String productionOrchestration = PRODUCTION_ORCHESTRATION_EDEFAULT;

  /**
   * The default value of the '{@link #getRuntimeOrchestration() <em>Runtime Orchestration</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getRuntimeOrchestration()
   * @generated
   * @ordered
   */
  protected static final String RUNTIME_ORCHESTRATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRuntimeOrchestration() <em>Runtime Orchestration</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getRuntimeOrchestration()
   * @generated
   * @ordered
   */
  protected String runtimeOrchestration = RUNTIME_ORCHESTRATION_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PatternLibraryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.PATTERN_LIBRARY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractPatternElement> getPatternElements() {
    if (patternElements == null) {
      patternElements = new EObjectContainmentEList<AbstractPatternElement>(AbstractPatternElement.class, this, ModelPackage.PATTERN_LIBRARY__PATTERN_ELEMENTS);
    }
    return patternElements;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getProductionOrchestration() {
    return productionOrchestration;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setProductionOrchestration(String newProductionOrchestration) {
    String oldProductionOrchestration = productionOrchestration;
    productionOrchestration = newProductionOrchestration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION, oldProductionOrchestration, productionOrchestration));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getRuntimeOrchestration() {
    return runtimeOrchestration;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setRuntimeOrchestration(String newRuntimeOrchestration) {
    String oldRuntimeOrchestration = runtimeOrchestration;
    runtimeOrchestration = newRuntimeOrchestration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION, oldRuntimeOrchestration, runtimeOrchestration));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.PATTERN_LIBRARY__PATTERN_ELEMENTS:
        return ((InternalEList<?>)getPatternElements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.PATTERN_LIBRARY__PATTERN_ELEMENTS:
        return getPatternElements();
      case ModelPackage.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION:
        return getProductionOrchestration();
      case ModelPackage.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION:
        return getRuntimeOrchestration();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.PATTERN_LIBRARY__PATTERN_ELEMENTS:
        getPatternElements().clear();
        getPatternElements().addAll((Collection<? extends AbstractPatternElement>)newValue);
        return;
      case ModelPackage.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION:
        setProductionOrchestration((String)newValue);
        return;
      case ModelPackage.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION:
        setRuntimeOrchestration((String)newValue);
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
      case ModelPackage.PATTERN_LIBRARY__PATTERN_ELEMENTS:
        getPatternElements().clear();
        return;
      case ModelPackage.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION:
        setProductionOrchestration(PRODUCTION_ORCHESTRATION_EDEFAULT);
        return;
      case ModelPackage.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION:
        setRuntimeOrchestration(RUNTIME_ORCHESTRATION_EDEFAULT);
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
      case ModelPackage.PATTERN_LIBRARY__PATTERN_ELEMENTS:
        return patternElements != null && !patternElements.isEmpty();
      case ModelPackage.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION:
        return PRODUCTION_ORCHESTRATION_EDEFAULT == null ? productionOrchestration != null : !PRODUCTION_ORCHESTRATION_EDEFAULT.equals(productionOrchestration);
      case ModelPackage.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION:
        return RUNTIME_ORCHESTRATION_EDEFAULT == null ? runtimeOrchestration != null : !RUNTIME_ORCHESTRATION_EDEFAULT.equals(runtimeOrchestration);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (productionOrchestration: "); //$NON-NLS-1$
    result.append(productionOrchestration);
    result.append(", runtimeOrchestration: "); //$NON-NLS-1$
    result.append(runtimeOrchestration);
    result.append(')');
    return result.toString();
  }

} // PatternLibraryImpl
