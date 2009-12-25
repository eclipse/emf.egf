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
   * The feature id for the '<em><b>Orchestration Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__ORCHESTRATION_CONTEXT_CONTAINER = FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER;

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
   * The feature id for the '<em><b>Invocation Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__INVOCATION_CONTEXT_CONTAINER = FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER;

  /**
   * The feature id for the '<em><b>Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__ACTIVITY = FcorePackage.INVOCATION__ACTIVITY;

  /**
   * The number of structural features of the '<em>Production Plan Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT = FcorePackage.INVOCATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fprod.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fprod.impl.FactoryComponentInvocationImpl
   * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getFactoryComponentInvocation()
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
   * The feature id for the '<em><b>Invocation Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__INVOCATION_CONTEXT_CONTAINER = PRODUCTION_PLAN_INVOCATION__INVOCATION_CONTEXT_CONTAINER;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fprod.impl.TaskInvocationImpl <em>Task Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fprod.impl.TaskInvocationImpl
   * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTaskInvocation()
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
   * The feature id for the '<em><b>Invocation Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__INVOCATION_CONTEXT_CONTAINER = PRODUCTION_PLAN_INVOCATION__INVOCATION_CONTEXT_CONTAINER;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fprod.impl.TaskImpl <em>Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fprod.impl.TaskImpl
   * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTask()
   * @generated
   */
  int TASK = 4;

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
   * The feature id for the '<em><b>Activity Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__ACTIVITY_CONTRACT_CONTAINER = FcorePackage.ACTIVITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__VALUE = FcorePackage.ACTIVITY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FEATURE_COUNT = FcorePackage.ACTIVITY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fprod.impl.TaskContractImpl <em>Task Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fprod.impl.TaskContractImpl
   * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTaskContract()
   * @generated
   */
  int TASK_CONTRACT = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT__ID = FcorePackage.ACTIVITY_CONTRACT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT__NAME = FcorePackage.ACTIVITY_CONTRACT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT__DESCRIPTION = FcorePackage.ACTIVITY_CONTRACT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT__MANDATORY = FcorePackage.ACTIVITY_CONTRACT__MANDATORY;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT__MODE = FcorePackage.ACTIVITY_CONTRACT__MODE;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT__TYPE = FcorePackage.ACTIVITY_CONTRACT__TYPE;

  /**
   * The feature id for the '<em><b>Activity Contract Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER = FcorePackage.ACTIVITY_CONTRACT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Task Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT_FEATURE_COUNT = FcorePackage.ACTIVITY_CONTRACT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fprod.impl.TaskContractContainerImpl <em>Task Contract Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fprod.impl.TaskContractContainerImpl
   * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTaskContractContainer()
   * @generated
   */
  int TASK_CONTRACT_CONTAINER = 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT_CONTAINER__ID = FcorePackage.ACTIVITY_CONTRACT_CONTAINER__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT_CONTAINER__NAME = FcorePackage.ACTIVITY_CONTRACT_CONTAINER__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT_CONTAINER__DESCRIPTION = FcorePackage.ACTIVITY_CONTRACT_CONTAINER__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Activity</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT_CONTAINER__ACTIVITY = FcorePackage.ACTIVITY_CONTRACT_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Activity Contracts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS = FcorePackage.ACTIVITY_CONTRACT_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Task Contract Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_CONTRACT_CONTAINER_FEATURE_COUNT = FcorePackage.ACTIVITY_CONTRACT_CONTAINER_FEATURE_COUNT + 2;

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.ProductionPlanInvocation <em>Production Plan Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Plan Invocation</em>'.
   * @see org.eclipse.egf.model.fprod.ProductionPlanInvocation
   * @generated
   */
  EClass getProductionPlanInvocation();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.FactoryComponentInvocation <em>Factory Component Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component Invocation</em>'.
   * @see org.eclipse.egf.model.fprod.FactoryComponentInvocation
   * @generated
   */
  EClass getFactoryComponentInvocation();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.TaskInvocation <em>Task Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task Invocation</em>'.
   * @see org.eclipse.egf.model.fprod.TaskInvocation
   * @generated
   */
  EClass getTaskInvocation();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task</em>'.
   * @see org.eclipse.egf.model.fprod.Task
   * @generated
   */
  EClass getTask();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fprod.Task#getActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Activity Contract Container</em>'.
   * @see org.eclipse.egf.model.fprod.Task#getActivityContractContainer()
   * @see #getTask()
   * @generated
   */
  EReference getTask_ActivityContractContainer();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fprod.Task#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.fprod.Task#getValue()
   * @see #getTask()
   * @generated
   */
  EAttribute getTask_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.TaskContract <em>Task Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task Contract</em>'.
   * @see org.eclipse.egf.model.fprod.TaskContract
   * @generated
   */
  EClass getTaskContract();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fprod.TaskContract#getActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Activity Contract Container</em>'.
   * @see org.eclipse.egf.model.fprod.TaskContract#getActivityContractContainer()
   * @see #getTaskContract()
   * @generated
   */
  EReference getTaskContract_ActivityContractContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fprod.TaskContractContainer <em>Task Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task Contract Container</em>'.
   * @see org.eclipse.egf.model.fprod.TaskContractContainer
   * @generated
   */
  EClass getTaskContractContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fprod.TaskContractContainer#getActivity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Activity</em>'.
   * @see org.eclipse.egf.model.fprod.TaskContractContainer#getActivity()
   * @see #getTaskContractContainer()
   * @generated
   */
  EReference getTaskContractContainer_Activity();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fprod.TaskContractContainer#getActivityContracts <em>Activity Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Activity Contracts</em>'.
   * @see org.eclipse.egf.model.fprod.TaskContractContainer#getActivityContracts()
   * @see #getTaskContractContainer()
   * @generated
   */
  EReference getTaskContractContainer_ActivityContracts();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.ProductionPlanImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getProductionPlan()
     * @generated
     */
    EClass PRODUCTION_PLAN = eINSTANCE.getProductionPlan();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.ProductionPlanInvocationImpl <em>Production Plan Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.ProductionPlanInvocationImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getProductionPlanInvocation()
     * @generated
     */
    EClass PRODUCTION_PLAN_INVOCATION = eINSTANCE.getProductionPlanInvocation();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.FactoryComponentInvocationImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getFactoryComponentInvocation()
     * @generated
     */
    EClass FACTORY_COMPONENT_INVOCATION = eINSTANCE.getFactoryComponentInvocation();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.TaskInvocationImpl <em>Task Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.TaskInvocationImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTaskInvocation()
     * @generated
     */
    EClass TASK_INVOCATION = eINSTANCE.getTaskInvocation();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.TaskImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTask()
     * @generated
     */
    EClass TASK = eINSTANCE.getTask();

    /**
     * The meta object literal for the '<em><b>Activity Contract Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK__ACTIVITY_CONTRACT_CONTAINER = eINSTANCE.getTask_ActivityContractContainer();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK__VALUE = eINSTANCE.getTask_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.TaskContractImpl <em>Task Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.TaskContractImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTaskContract()
     * @generated
     */
    EClass TASK_CONTRACT = eINSTANCE.getTaskContract();

    /**
     * The meta object literal for the '<em><b>Activity Contract Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER = eINSTANCE.getTaskContract_ActivityContractContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fprod.impl.TaskContractContainerImpl <em>Task Contract Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fprod.impl.TaskContractContainerImpl
     * @see org.eclipse.egf.model.fprod.impl.FprodPackageImpl#getTaskContractContainer()
     * @generated
     */
    EClass TASK_CONTRACT_CONTAINER = eINSTANCE.getTaskContractContainer();

    /**
     * The meta object literal for the '<em><b>Activity</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK_CONTRACT_CONTAINER__ACTIVITY = eINSTANCE.getTaskContractContainer_Activity();

    /**
     * The meta object literal for the '<em><b>Activity Contracts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS = eINSTANCE.getTaskContractContainer_ActivityContracts();

  }

} //FprodPackage
