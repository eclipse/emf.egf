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
package org.eclipse.egf.model.productionplan;

import org.eclipse.egf.model.fcore.FcorePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.productionplan.ProductionPlanFactory
 * @model kind="package"
 * @generated
 */
public interface ProductionPlanPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "productionplan"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/productionplan"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "productionplan"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ProductionPlanPackage eINSTANCE = org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getProductionPlan()
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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__NAME = FcorePackage.ORCHESTRATION__NAME;

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
   * The feature id for the '<em><b>Production Plan Invocations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS = FcorePackage.ORCHESTRATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Production Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_FEATURE_COUNT = FcorePackage.ORCHESTRATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl <em>Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getProductionPlanInvocation()
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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__NAME = FcorePackage.INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__DESCRIPTION = FcorePackage.INVOCATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__CONTEXT = FcorePackage.INVOCATION__CONTEXT;

  /**
   * The feature id for the '<em><b>Production Plan</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN = FcorePackage.INVOCATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT = FcorePackage.INVOCATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getFactoryComponentInvocation()
   * @generated
   */
  int FACTORY_COMPONENT_INVOCATION = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__ID = PRODUCTION_PLAN_INVOCATION__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__NAME = PRODUCTION_PLAN_INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__DESCRIPTION = PRODUCTION_PLAN_INVOCATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__CONTEXT = PRODUCTION_PLAN_INVOCATION__CONTEXT;

  /**
   * The feature id for the '<em><b>Production Plan</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__PRODUCTION_PLAN = PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN;

  /**
   * The feature id for the '<em><b>Factory Component</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Factory Component Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION_FEATURE_COUNT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl <em>Task Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getTaskInvocation()
   * @generated
   */
  int TASK_INVOCATION = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__ID = PRODUCTION_PLAN_INVOCATION__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__NAME = PRODUCTION_PLAN_INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__DESCRIPTION = PRODUCTION_PLAN_INVOCATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__CONTEXT = PRODUCTION_PLAN_INVOCATION__CONTEXT;

  /**
   * The feature id for the '<em><b>Production Plan</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__PRODUCTION_PLAN = PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN;

  /**
   * The feature id for the '<em><b>Task</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__TASK = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Task Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION_FEATURE_COUNT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 1;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.ProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Plan</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlan
   * @generated
   */
  EClass getProductionPlan();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.productionplan.ProductionPlan#getProductionPlanInvocations <em>Production Plan Invocations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Production Plan Invocations</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlan#getProductionPlanInvocations()
   * @see #getProductionPlan()
   * @generated
   */
  EReference getProductionPlan_ProductionPlanInvocations();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlanInvocation
   * @generated
   */
  EClass getProductionPlanInvocation();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Production Plan</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlanInvocation#getProductionPlan()
   * @see #getProductionPlanInvocation()
   * @generated
   */
  EReference getProductionPlanInvocation_ProductionPlan();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.FactoryComponentInvocation <em>Factory Component Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component Invocation</em>'.
   * @see org.eclipse.egf.model.productionplan.FactoryComponentInvocation
   * @generated
   */
  EClass getFactoryComponentInvocation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.productionplan.FactoryComponentInvocation#getFactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Factory Component</em>'.
   * @see org.eclipse.egf.model.productionplan.FactoryComponentInvocation#getFactoryComponent()
   * @see #getFactoryComponentInvocation()
   * @generated
   */
  EReference getFactoryComponentInvocation_FactoryComponent();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.TaskInvocation <em>Task Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task Invocation</em>'.
   * @see org.eclipse.egf.model.productionplan.TaskInvocation
   * @generated
   */
  EClass getTaskInvocation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.productionplan.TaskInvocation#getTask <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Task</em>'.
   * @see org.eclipse.egf.model.productionplan.TaskInvocation#getTask()
   * @see #getTaskInvocation()
   * @generated
   */
  EReference getTaskInvocation_Task();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ProductionPlanFactory getProductionPlanFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getProductionPlan()
     * @generated
     */
    EClass PRODUCTION_PLAN = eINSTANCE.getProductionPlan();

    /**
     * The meta object literal for the '<em><b>Production Plan Invocations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS = eINSTANCE.getProductionPlan_ProductionPlanInvocations();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl <em>Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getProductionPlanInvocation()
     * @generated
     */
    EClass PRODUCTION_PLAN_INVOCATION = eINSTANCE.getProductionPlanInvocation();

    /**
     * The meta object literal for the '<em><b>Production Plan</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN = eINSTANCE.getProductionPlanInvocation_ProductionPlan();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getFactoryComponentInvocation()
     * @generated
     */
    EClass FACTORY_COMPONENT_INVOCATION = eINSTANCE.getFactoryComponentInvocation();

    /**
     * The meta object literal for the '<em><b>Factory Component</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT = eINSTANCE.getFactoryComponentInvocation_FactoryComponent();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl <em>Task Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getTaskInvocation()
     * @generated
     */
    EClass TASK_INVOCATION = eINSTANCE.getTaskInvocation();

    /**
     * The meta object literal for the '<em><b>Task</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK_INVOCATION__TASK = eINSTANCE.getTaskInvocation_Task();

  }

} //ProductionPlanPackage
