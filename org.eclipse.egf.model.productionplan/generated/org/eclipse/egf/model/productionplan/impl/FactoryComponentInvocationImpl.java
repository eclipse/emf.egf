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
package org.eclipse.egf.model.productionplan.impl;

import org.eclipse.egf.model.fcore.FactoryComponent;

import org.eclipse.egf.model.productionplan.FactoryComponentInvocation;
import org.eclipse.egf.model.productionplan.ProductionPlanPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factory Component Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl#getFactoryComponent <em>Factory Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryComponentInvocationImpl extends ProductionPlanInvocationImpl implements FactoryComponentInvocation {
  /**
   * The cached value of the '{@link #getFactoryComponent() <em>Factory Component</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryComponent()
   * @generated
   * @ordered
   */
  protected FactoryComponent factoryComponent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FactoryComponentInvocationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ProductionPlanPackage.Literals.FACTORY_COMPONENT_INVOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponent getFactoryComponent() {
    if (factoryComponent != null && factoryComponent.eIsProxy()) {
      InternalEObject oldFactoryComponent = (InternalEObject) factoryComponent;
      factoryComponent = (FactoryComponent) eResolveProxy(oldFactoryComponent);
      if (factoryComponent != oldFactoryComponent) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPlanPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT, oldFactoryComponent, factoryComponent));
      }
    }
    return factoryComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponent basicGetFactoryComponent() {
    return factoryComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFactoryComponent(FactoryComponent newFactoryComponent) {
    FactoryComponent oldFactoryComponent = factoryComponent;
    factoryComponent = newFactoryComponent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductionPlanPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT, oldFactoryComponent, factoryComponent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ProductionPlanPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT:
      if (resolve)
        return getFactoryComponent();
      return basicGetFactoryComponent();
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
    case ProductionPlanPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT:
      setFactoryComponent((FactoryComponent) newValue);
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
    case ProductionPlanPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT:
      setFactoryComponent((FactoryComponent) null);
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
    case ProductionPlanPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT:
      return factoryComponent != null;
    }
    return super.eIsSet(featureID);
  }

} //FactoryComponentInvocationImpl
