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
package org.eclipse.egf.model.fprod.util;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;

import org.eclipse.egf.model.fprod.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.fprod.FprodPackage
 * @generated
 */
public class FprodAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FprodPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FprodAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = FprodPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FprodSwitch<Adapter> modelSwitch = new FprodSwitch<Adapter>() {
    @Override
    public Adapter caseProductionPlan(ProductionPlan object) {
      return createProductionPlanAdapter();
    }

    @Override
    public <T extends Activity> Adapter caseProductionPlanInvocation(ProductionPlanInvocation<T> object) {
      return createProductionPlanInvocationAdapter();
    }

    @Override
    public Adapter caseFactoryComponentInvocation(FactoryComponentInvocation object) {
      return createFactoryComponentInvocationAdapter();
    }

    @Override
    public Adapter caseTaskInvocation(TaskInvocation object) {
      return createTaskInvocationAdapter();
    }

    @Override
    public Adapter caseTask(Task object) {
      return createTaskAdapter();
    }

    @Override
    public Adapter caseTaskContract(TaskContract object) {
      return createTaskContractAdapter();
    }

    @Override
    public Adapter caseTaskContractContainer(TaskContractContainer object) {
      return createTaskContractContainerAdapter();
    }

    @Override
    public Adapter caseModelElement(ModelElement object) {
      return createModelElementAdapter();
    }

    @Override
    public Adapter caseOrchestration(Orchestration object) {
      return createOrchestrationAdapter();
    }

    @Override
    public <T extends Activity> Adapter caseInvocation(Invocation<T> object) {
      return createInvocationAdapter();
    }

    @Override
    public Adapter caseActivity(Activity object) {
      return createActivityAdapter();
    }

    @Override
    public Adapter caseActivityContract(ActivityContract object) {
      return createActivityContractAdapter();
    }

    @Override
    public Adapter caseActivityContractContainer(ActivityContractContainer object) {
      return createActivityContractContainerAdapter();
    }

    @Override
    public Adapter defaultCase(EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fprod.ProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fprod.ProductionPlan
   * @generated
   */
  public Adapter createProductionPlanAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fprod.ProductionPlanInvocation <em>Production Plan Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fprod.ProductionPlanInvocation
   * @generated
   */
  public Adapter createProductionPlanInvocationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fprod.FactoryComponentInvocation <em>Factory Component Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fprod.FactoryComponentInvocation
   * @generated
   */
  public Adapter createFactoryComponentInvocationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fprod.TaskInvocation <em>Task Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fprod.TaskInvocation
   * @generated
   */
  public Adapter createTaskInvocationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fprod.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fprod.Task
   * @generated
   */
  public Adapter createTaskAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fprod.TaskContract <em>Task Contract</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fprod.TaskContract
   * @generated
   */
  public Adapter createTaskContractAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fprod.TaskContractContainer <em>Task Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fprod.TaskContractContainer
   * @generated
   */
  public Adapter createTaskContractContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ModelElement
   * @generated
   */
  public Adapter createModelElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Orchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Orchestration
   * @generated
   */
  public Adapter createOrchestrationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Invocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Invocation
   * @generated
   */
  public Adapter createInvocationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Activity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Activity
   * @generated
   */
  public Adapter createActivityAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.ActivityContract <em>Activity Contract</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ActivityContract
   * @generated
   */
  public Adapter createActivityContractAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.ActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ActivityContractContainer
   * @generated
   */
  public Adapter createActivityContractContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //FprodAdapterFactory
