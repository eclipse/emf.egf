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

import org.eclipse.egf.model.fprod.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FprodFactoryImpl extends EFactoryImpl implements FprodFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FprodFactory init() {
    try {
      FprodFactory theFprodFactory = (FprodFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/fprod"); //$NON-NLS-1$ 
      if (theFprodFactory != null) {
        return theFprodFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FprodFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FprodFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case FprodPackage.PRODUCTION_PLAN:
      return createProductionPlan();
    case FprodPackage.FACTORY_COMPONENT_INVOCATION:
      return createFactoryComponentInvocation();
    case FprodPackage.TASK_INVOCATION:
      return createTaskInvocation();
    case FprodPackage.TASK:
      return createTask();
    case FprodPackage.TASK_CONTRACT:
      return createTaskContract();
    case FprodPackage.TASK_CONTRACT_CONTAINER:
      return createTaskContractContainer();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductionPlan createProductionPlan() {
    ProductionPlanImpl productionPlan = new ProductionPlanImpl();
    return productionPlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentInvocation createFactoryComponentInvocation() {
    FactoryComponentInvocationImpl factoryComponentInvocation = new FactoryComponentInvocationImpl();
    return factoryComponentInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskInvocation createTaskInvocation() {
    TaskInvocationImpl taskInvocation = new TaskInvocationImpl();
    return taskInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task createTask() {
    TaskImpl task = new TaskImpl();
    return task;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskContract createTaskContract() {
    TaskContractImpl taskContract = new TaskContractImpl();
    return taskContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskContractContainer createTaskContractContainer() {
    TaskContractContainerImpl taskContractContainer = new TaskContractContainerImpl();
    return taskContractContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FprodPackage getFprodPackage() {
    return (FprodPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FprodPackage getPackage() {
    return FprodPackage.eINSTANCE;
  }

} //FprodFactoryImpl
