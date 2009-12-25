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

import org.eclipse.emf.ecore.EAttribute;
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
   * The feature id for the '<em><b>Invocations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__INVOCATIONS = FcorePackage.ORCHESTRATION__INVOCATIONS;

  /**
   * The number of structural features of the '<em>Production Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_FEATURE_COUNT = FcorePackage.ORCHESTRATION_FEATURE_COUNT + 0;

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
   * The feature id for the '<em><b>Orchestration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__ORCHESTRATION = FcorePackage.INVOCATION__ORCHESTRATION;

  /**
   * The feature id for the '<em><b>Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__CONTEXT_CONTAINER = FcorePackage.INVOCATION__CONTEXT_CONTAINER;

  /**
   * The feature id for the '<em><b>Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__ACTIVITY = FcorePackage.INVOCATION__ACTIVITY;

  /**
   * The number of structural features of the '<em>Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT = FcorePackage.INVOCATION_FEATURE_COUNT + 0;

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
   * The feature id for the '<em><b>Orchestration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__ORCHESTRATION = PRODUCTION_PLAN_INVOCATION__ORCHESTRATION;

  /**
   * The feature id for the '<em><b>Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__CONTEXT_CONTAINER = PRODUCTION_PLAN_INVOCATION__CONTEXT_CONTAINER;

  /**
   * The feature id for the '<em><b>Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__ACTIVITY = PRODUCTION_PLAN_INVOCATION__ACTIVITY;

  /**
   * The number of structural features of the '<em>Factory Component Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION_FEATURE_COUNT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.TaskImpl <em>Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.TaskImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getTask()
   * @generated
   */
  int TASK = 4;

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
   * The feature id for the '<em><b>Orchestration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__ORCHESTRATION = PRODUCTION_PLAN_INVOCATION__ORCHESTRATION;

  /**
   * The feature id for the '<em><b>Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__CONTEXT_CONTAINER = PRODUCTION_PLAN_INVOCATION__CONTEXT_CONTAINER;

  /**
   * The feature id for the '<em><b>Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__ACTIVITY = PRODUCTION_PLAN_INVOCATION__ACTIVITY;

  /**
   * The number of structural features of the '<em>Task Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION_FEATURE_COUNT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__ID = FcorePackage.ACTIVITY__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__NAME = FcorePackage.ACTIVITY__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__DESCRIPTION = FcorePackage.ACTIVITY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__CONTRACT_CONTAINER = FcorePackage.ACTIVITY__CONTRACT_CONTAINER;

  /**
   * The feature id for the '<em><b>Task Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__TASK_ID = FcorePackage.ACTIVITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FEATURE_COUNT = FcorePackage.ACTIVITY_FEATURE_COUNT + 1;

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlanInvocation
   * @generated
   */
  EClass getProductionPlanInvocation();

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task</em>'.
   * @see org.eclipse.egf.model.productionplan.Task
   * @generated
   */
  EClass getTask();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.productionplan.Task#getTaskId <em>Task Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Task Id</em>'.
   * @see org.eclipse.egf.model.productionplan.Task#getTaskId()
   * @see #getTask()
   * @generated
   */
  EAttribute getTask_TaskId();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl <em>Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getProductionPlanInvocation()
     * @generated
     */
    EClass PRODUCTION_PLAN_INVOCATION = eINSTANCE.getProductionPlanInvocation();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.TaskImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getTask()
     * @generated
     */
    EClass TASK = eINSTANCE.getTask();

    /**
     * The meta object literal for the '<em><b>Task Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK__TASK_ID = eINSTANCE.getTask_TaskId();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl <em>Task Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanPackageImpl#getTaskInvocation()
     * @generated
     */
    EClass TASK_INVOCATION = eINSTANCE.getTaskInvocation();

  }

} //ProductionPlanPackage
