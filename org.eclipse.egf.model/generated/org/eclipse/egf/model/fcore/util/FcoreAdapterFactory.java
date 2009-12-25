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
import org.eclipse.egf.model.fcore.Context;
import org.eclipse.egf.model.fcore.ContextContainer;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractConnector;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
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
    public Adapter caseFactoryComponent(FactoryComponent object) {
      return createFactoryComponentAdapter();
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
    public <T extends Activity> Adapter caseInvocation(Invocation<T> object) {
      return createInvocationAdapter();
    }

    @Override
    public <T extends Object> Adapter caseType(Type<T> object) {
      return createTypeAdapter();
    }

    @Override
    public <T extends Object> Adapter caseTypeObject(TypeObject<T> object) {
      return createTypeObjectAdapter();
    }

    @Override
    public <T extends Object> Adapter caseTypeClass(TypeClass<T> object) {
      return createTypeClassAdapter();
    }

    @Override
    public Adapter caseContractContainer(ContractContainer object) {
      return createContractContainerAdapter();
    }

    @Override
    public Adapter caseContract(Contract object) {
      return createContractAdapter();
    }

    @Override
    public Adapter caseContractConnector(ContractConnector object) {
      return createContractConnectorAdapter();
    }

    @Override
    public Adapter caseContextContainer(ContextContainer object) {
      return createContextContainerAdapter();
    }

    @Override
    public Adapter caseContext(Context object) {
      return createContextAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Type
   * <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Type
   * @generated
   */
  public Adapter createTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.TypeObject
   * <em>Type Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.TypeObject
   * @generated
   */
  public Adapter createTypeObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.TypeClass
   * <em>Type Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.TypeClass
   * @generated
   */
  public Adapter createTypeClassAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.ContextContainer <em>Context Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ContextContainer
   * @generated
   */
  public Adapter createContextContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Context
   * <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Context
   * @generated
   */
  public Adapter createContextAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.ContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ContractContainer
   * @generated
   */
  public Adapter createContractContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Contract
   * <em>Contract</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Contract
   * @generated
   */
  public Adapter createContractAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.ContractConnector <em>Contract Connector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ContractConnector
   * @generated
   */
  public Adapter createContractConnectorAdapter() {
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
