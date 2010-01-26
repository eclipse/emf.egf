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
package org.eclipse.egf.model.fprod;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.fprod.FprodFactory
 * @model kind="package"
 * @generated
 */
public interface FprodPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fprod"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/fprod"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fprod"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FprodPackage eINSTANCE = org.eclipse.egf.model.fprod.impl.FprodPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fprod.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fprod.impl.ProductionPlanImpl
   * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getProductionPlan()
   * @generated
   */
  int PRODUCTION_PLAN = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__ID = FcorePackage.ORCHESTRATION__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__DESCRIPTION = FcorePackage.ORCHESTRATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Factory Component</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__FACTORY_COMPONENT = FcorePackage.ORCHESTRATION__FACTORY_COMPONENT;

  /**
   * The feature id for the '<em><b>Orchestration Parameter Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__ORCHESTRATION_PARAMETER_CONTAINER = FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER;

  /**
   * The feature id for the '<em><b>Invocations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__INVOCATIONS = FcorePackage.ORCHESTRATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Production Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_FEATURE_COUNT = FcorePackage.ORCHESTRATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fprod.impl.ProductionPlanInvocationImpl <em>Production Plan Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fprod.impl.ProductionPlanInvocationImpl
   * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getProductionPlanInvocation()
   * @generated
   */
  int PRODUCTION_PLAN_INVOCATION = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__ID = FcorePackage.INVOCATION__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__DESCRIPTION = FcorePackage.INVOCATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__NAME = FcorePackage.INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Invocation Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__INVOCATION_CONTRACT_CONTAINER = FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER;

  /**
   * The feature id for the '<em><b>Invoked Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__INVOKED_ACTIVITY = FcorePackage.INVOCATION__INVOKED_ACTIVITY;

  /**
   * The feature id for the '<em><b>Production Plan</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN = FcorePackage.INVOCATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Production Plan Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT = FcorePackage.INVOCATION_FEATURE_COUNT + 1;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.ProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Plan</em>'.
   * @see org.eclipse.egf.model.fprod.ProductionPlan
   * @generated
   */
  EClass getProductionPlan();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fprod.ProductionPlan#getInvocations <em>Invocations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invocations</em>'.
   * @see org.eclipse.egf.model.fprod.ProductionPlan#getInvocations()
   * @see #getProductionPlan()
   * @generated
   */
  EReference getProductionPlan_Invocations();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.ProductionPlanInvocation <em>Production Plan Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Plan Invocation</em>'.
   * @see org.eclipse.egf.model.fprod.ProductionPlanInvocation
   * @generated
   */
  EClass getProductionPlanInvocation();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fprod.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Production Plan</em>'.
   * @see org.eclipse.egf.model.fprod.ProductionPlanInvocation#getProductionPlan()
   * @see #getProductionPlanInvocation()
   * @generated
   */
  EReference getProductionPlanInvocation_ProductionPlan();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FprodFactory getFprodFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.ProductionPlanImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getProductionPlan()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass PRODUCTION_PLAN = eINSTANCE.getProductionPlan();

    /**
     * The meta object literal for the '<em><b>Invocations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference PRODUCTION_PLAN__INVOCATIONS = eINSTANCE.getProductionPlan_Invocations();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.ProductionPlanInvocationImpl <em>Production Plan Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.ProductionPlanInvocationImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getProductionPlanInvocation()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass PRODUCTION_PLAN_INVOCATION = eINSTANCE.getProductionPlanInvocation();

    /**
     * The meta object literal for the '<em><b>Production Plan</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN = eINSTANCE.getProductionPlanInvocation_ProductionPlan();

  }

} // FprodPackage
