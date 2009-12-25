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
package org.eclipse.egf.model.fprod.impl;

import org.eclipse.egf.model.fcore.Activity;

import org.eclipse.egf.model.fcore.impl.InvocationImpl;

import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Production Plan Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ProductionPlanInvocationImpl<T extends Activity> extends InvocationImpl<T> implements ProductionPlanInvocation<T> {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductionPlanInvocationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FprodPackage.Literals.PRODUCTION_PLAN_INVOCATION;
  }

} //ProductionPlanInvocationImpl
