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
package org.eclipse.egf.model.fcore.util;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FactoryComponentContractContainer;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextConnector;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.fcore.FcorePackage
 * @generated
 */
public class FcoreAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected static FcorePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public FcoreAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = FcorePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the
   * model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * 
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
   * 
   * @generated
   */
  protected FcoreSwitch<Adapter> modelSwitch = new FcoreSwitch<Adapter>() {
    @Override
    public Adapter caseModelElement(ModelElement object) {
      return createModelElementAdapter();
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
    public Adapter caseFactoryComponent(FactoryComponent object) {
      return createFactoryComponentAdapter();
    }

    @Override
    public Adapter caseFactoryComponentContract(FactoryComponentContract object) {
      return createFactoryComponentContractAdapter();
    }

    @Override
    public Adapter caseFactoryComponentContractContainer(FactoryComponentContractContainer object) {
      return createFactoryComponentContractContainerAdapter();
    }

    @Override
    public Adapter caseViewpointContainer(ViewpointContainer object) {
      return createViewpointContainerAdapter();
    }

    @Override
    public Adapter caseViewpoint(Viewpoint object) {
      return createViewpointAdapter();
    }

    @Override
    public Adapter caseOrchestration(Orchestration object) {
      return createOrchestrationAdapter();
    }

    @Override
    public Adapter caseOrchestrationContext(OrchestrationContext object) {
      return createOrchestrationContextAdapter();
    }

    @Override
    public Adapter caseOrchestrationContextContainer(OrchestrationContextContainer object) {
      return createOrchestrationContextContainerAdapter();
    }

    @Override
    public <T extends Activity> Adapter caseInvocation(Invocation<T> object) {
      return createInvocationAdapter();
    }

    @Override
    public Adapter caseInvocationContext(InvocationContext object) {
      return createInvocationContextAdapter();
    }

    @Override
    public Adapter caseInvocationContextConnector(InvocationContextConnector object) {
      return createInvocationContextConnectorAdapter();
    }

    @Override
    public Adapter caseInvocationContextContainer(InvocationContextContainer object) {
      return createInvocationContextContainerAdapter();
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
   * 
   * @param target
   *          the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.ModelElement
   * <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ModelElement
   * @generated
   */
  public Adapter createModelElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Activity
   * <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Activity
   * @generated
   */
  public Adapter createActivityAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.ActivityContract <em>Activity Contract</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ActivityContract
   * @generated
   */
  public Adapter createActivityContractAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.ActivityContractContainer <em>Activity Contract
   * Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ActivityContractContainer
   * @generated
   */
  public Adapter createActivityContractContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.FactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.FactoryComponent
   * @generated
   */
  public Adapter createFactoryComponentAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.FactoryComponentContract <em>Factory Component
   * Contract</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContract
   * @generated
   */
  public Adapter createFactoryComponentContractAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer <em>Factory Component
   * Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContractContainer
   * @generated
   */
  public Adapter createFactoryComponentContractContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.ViewpointContainer <em>Viewpoint Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ViewpointContainer
   * @generated
   */
  public Adapter createViewpointContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Viewpoint
   * <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Viewpoint
   * @generated
   */
  public Adapter createViewpointAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Orchestration
   * <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Orchestration
   * @generated
   */
  public Adapter createOrchestrationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.OrchestrationContext <em>Orchestration Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.OrchestrationContext
   * @generated
   */
  public Adapter createOrchestrationContextAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.OrchestrationContextContainer <em>Orchestration Context
   * Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.OrchestrationContextContainer
   * @generated
   */
  public Adapter createOrchestrationContextContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Invocation
   * <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Invocation
   * @generated
   */
  public Adapter createInvocationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.InvocationContext <em>Invocation Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.InvocationContext
   * @generated
   */
  public Adapter createInvocationContextAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.InvocationContextConnector <em>Invocation Context
   * Connector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.InvocationContextConnector
   * @generated
   */
  public Adapter createInvocationContextConnectorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.InvocationContextContainer <em>Invocation Context
   * Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer
   * @generated
   */
  public Adapter createInvocationContextContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // FcoreAdapterFactory
