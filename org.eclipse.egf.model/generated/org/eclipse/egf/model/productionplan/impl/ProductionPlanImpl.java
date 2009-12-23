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
package org.eclipse.egf.model.productionplan.impl;

import java.util.Collection;

import org.eclipse.egf.model.factorycomponent.impl.OrchestrationImpl;

import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.eclipse.egf.model.productionplan.ProductionplanPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Production Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl#getProductionPlanInvocations <em>Production Plan Invocations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProductionPlanImpl extends OrchestrationImpl implements ProductionPlan {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * The cached value of the '{@link #getProductionPlanInvocations() <em>Production Plan Invocations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductionPlanInvocations()
   * @generated
   * @ordered
   */
  protected EList<ProductionPlanInvocation> productionPlanInvocations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductionPlanImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ProductionplanPackage.Literals.PRODUCTION_PLAN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProductionPlanInvocation> getProductionPlanInvocations() {
    if (productionPlanInvocations == null) {
      productionPlanInvocations = new EObjectContainmentEList<ProductionPlanInvocation>(ProductionPlanInvocation.class, this,
          ProductionplanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS);
    }
    return productionPlanInvocations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case ProductionplanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS:
      return ((InternalEList<?>) getProductionPlanInvocations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ProductionplanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS:
      return getProductionPlanInvocations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ProductionplanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS:
      getProductionPlanInvocations().clear();
      getProductionPlanInvocations().addAll((Collection<? extends ProductionPlanInvocation>) newValue);
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
    case ProductionplanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS:
      getProductionPlanInvocations().clear();
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
    case ProductionplanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS:
      return productionPlanInvocations != null && !productionPlanInvocations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ProductionPlanImpl
