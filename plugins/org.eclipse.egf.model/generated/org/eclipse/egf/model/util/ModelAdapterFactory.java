/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model.util;

import org.eclipse.egf.model.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * @see org.eclipse.egf.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static ModelPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ModelPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc --> This implementation returns <code>true</code> if the object
   * is either the model's package or is an instance object of the model. <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ModelSwitch<Adapter> modelSwitch = new ModelSwitch<Adapter>() {
      @Override
      public Adapter caseNamedModelElementWithId(NamedModelElementWithId object) {
        return createNamedModelElementWithIdAdapter();
      }
      @Override
      public Adapter caseFactoryComponent(FactoryComponent object) {
        return createFactoryComponentAdapter();
      }
      @Override
      public Adapter caseProductionPlan(ProductionPlan object) {
        return createProductionPlanAdapter();
      }
      @Override
      public Adapter caseFactoryComponentInvocation(FactoryComponentInvocation object) {
        return createFactoryComponentInvocationAdapter();
      }
      @Override
      public Adapter caseDomain(Domain object) {
        return createDomainAdapter();
      }
      @Override
      public Adapter caseSpecification(Specification object) {
        return createSpecificationAdapter();
      }
      @Override
      public Adapter caseAbstractViewpoint(AbstractViewpoint object) {
        return createAbstractViewpointAdapter();
      }
      @Override
      public Adapter caseContract(Contract object) {
        return createContractAdapter();
      }
      @Override
      public Adapter caseContractElement(ContractElement object) {
        return createContractElementAdapter();
      }
      @Override
      public Adapter caseContractElementReference(ContractElementReference object) {
        return createContractElementReferenceAdapter();
      }
      @Override
      public Adapter caseType(Type object) {
        return createTypeAdapter();
      }
      @Override
      public Adapter casePatternViewpoint(PatternViewpoint object) {
        return createPatternViewpointAdapter();
      }
      @Override
      public Adapter caseAbstractPatternElement(AbstractPatternElement object) {
        return createAbstractPatternElementAdapter();
      }
      @Override
      public Adapter casePatternLibrary(PatternLibrary object) {
        return createPatternLibraryAdapter();
      }
      @Override
      public Adapter casePatternModel(PatternModel object) {
        return createPatternModelAdapter();
      }
      @Override
      public Adapter caseFactory(Factory object) {
        return createFactoryAdapter();
      }
      @Override
      public Adapter caseAbstractFactoryComponentFactory(AbstractFactoryComponentFactory object) {
        return createAbstractFactoryComponentFactoryAdapter();
      }
      @Override
      public Adapter caseContext(Context object) {
        return createContextAdapter();
      }
      @Override
      public Adapter caseContextElement(ContextElement object) {
        return createContextElementAdapter();
      }
      @Override
      public Adapter caseTaskFactoryHolder(TaskFactoryHolder object) {
        return createTaskFactoryHolderAdapter();
      }
      @Override
      public Adapter caseMappingViewpoint(MappingViewpoint object) {
        return createMappingViewpointAdapter();
      }
      @Override
      public Adapter caseMappingModel(MappingModel object) {
        return createMappingModelAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.NamedModelElementWithId <em>Named Model Element With Id</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
   * all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.NamedModelElementWithId
   * @generated
   */
  public Adapter createNamedModelElementWithIdAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.FactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc --> This default implementation
   * returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.FactoryComponent
   * @generated
   */
  public Adapter createFactoryComponentAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc --> This default implementation
   * returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.Domain
   * @generated
   */
  public Adapter createDomainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.Specification
   * @generated
   */
  public Adapter createSpecificationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.AbstractViewpoint <em>Abstract Viewpoint</em>}'.
   * <!-- begin-user-doc --> This
   * default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.AbstractViewpoint
   * @generated
   */
  public Adapter createAbstractViewpointAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.Contract <em>Contract</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.Contract
   * @generated
   */
  public Adapter createContractAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.ContractElement <em>Contract Element</em>}'.
   * <!-- begin-user-doc --> This
   * default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.ContractElement
   * @generated
   */
  public Adapter createContractElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.ContractElementReference <em>Contract Element Reference</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
   * all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.ContractElementReference
   * @generated
   */
  public Adapter createContractElementReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.Type <em>Type</em>}'.
   * <!-- begin-user-doc --> This default implementation
   * returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.Type
   * @generated
   */
  public Adapter createTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.PatternViewpoint <em>Pattern Viewpoint</em>}'.
   * <!-- begin-user-doc --> This
   * default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.PatternViewpoint
   * @generated
   */
  public Adapter createPatternViewpointAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.AbstractPatternElement <em>Abstract Pattern Element</em>}'.
   * <!-- begin-user-doc
   * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
   * anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.AbstractPatternElement
   * @generated
   */
  public Adapter createAbstractPatternElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.PatternLibrary <em>Pattern Library</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.PatternLibrary
   * @generated
   */
  public Adapter createPatternLibraryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.PatternModel
   * @generated
   */
  public Adapter createPatternModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.Factory <em>Factory</em>}'.
   * <!-- begin-user-doc --> This default implementation
   * returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.Factory
   * @generated
   */
  public Adapter createFactoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.AbstractFactoryComponentFactory <em>Abstract Factory Component Factory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.AbstractFactoryComponentFactory
   * @generated
   */
  public Adapter createAbstractFactoryComponentFactoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.ProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.ProductionPlan
   * @generated
   */
  public Adapter createProductionPlanAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.Context <em>Context</em>}'.
   * <!-- begin-user-doc --> This default implementation
   * returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.Context
   * @generated
   */
  public Adapter createContextAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.ContextElement <em>Context Element</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.ContextElement
   * @generated
   */
  public Adapter createContextElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.FactoryComponentInvocation <em>Factory Component Invocation</em>}'.
   * <!-- begin-user-doc --> This
   * default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.FactoryComponentInvocation
   * @generated
   */
  public Adapter createFactoryComponentInvocationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.TaskFactoryHolder <em>Task Factory Holder</em>}'.
   * <!-- begin-user-doc --> This
   * default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.TaskFactoryHolder
   * @generated
   */
  public Adapter createTaskFactoryHolderAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.MappingViewpoint <em>Mapping Viewpoint</em>}'.
   * <!-- begin-user-doc --> This
   * default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.MappingViewpoint
   * @generated
   */
  public Adapter createMappingViewpointAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.MappingModel <em>Mapping Model</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.MappingModel
   * @generated
   */
  public Adapter createMappingModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc --> This default implementation returns null. <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // ModelAdapterFactory
