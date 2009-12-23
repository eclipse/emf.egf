/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent.impl;

import org.eclipse.egf.model.factorycomponent.Activity;
import org.eclipse.egf.model.factorycomponent.Context;
import org.eclipse.egf.model.factorycomponent.ContextValue;
import org.eclipse.egf.model.factorycomponent.Contract;
import org.eclipse.egf.model.factorycomponent.ContractConnector;
import org.eclipse.egf.model.factorycomponent.ContractContainer;
import org.eclipse.egf.model.factorycomponent.ContractMode;
import org.eclipse.egf.model.factorycomponent.ContractValue;
import org.eclipse.egf.model.factorycomponent.FactoryComponent;
import org.eclipse.egf.model.factorycomponent.FactoryComponentFactory;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;
import org.eclipse.egf.model.factorycomponent.Invocation;
import org.eclipse.egf.model.factorycomponent.ModelElement;
import org.eclipse.egf.model.factorycomponent.Orchestration;
import org.eclipse.egf.model.factorycomponent.Task;
import org.eclipse.egf.model.factorycomponent.Viewpoint;

import org.eclipse.egf.model.factorycomponent.util.FactoryComponentValidator;

import org.eclipse.egf.model.types.TypesPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FactoryComponentPackageImpl extends EPackageImpl implements FactoryComponentPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factoryComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass viewpointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orchestrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contractContainerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contractEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contractValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contractConnectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum contractModeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType invocationExceptionEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType uriEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FactoryComponentPackageImpl() {
    super(eNS_URI, FactoryComponentFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link FactoryComponentPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FactoryComponentPackage init() {
    if (isInited)
      return (FactoryComponentPackage) EPackage.Registry.INSTANCE.getEPackage(FactoryComponentPackage.eNS_URI);

    // Obtain or create and register package
    FactoryComponentPackageImpl theFactoryComponentPackage = (FactoryComponentPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FactoryComponentPackageImpl ? EPackage.Registry.INSTANCE
        .get(eNS_URI)
        : new FactoryComponentPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    TypesPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theFactoryComponentPackage.createPackageContents();

    // Initialize created meta-data
    theFactoryComponentPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put(theFactoryComponentPackage, new EValidator.Descriptor() {
      public EValidator getEValidator() {
        return FactoryComponentValidator.INSTANCE;
      }
    });

    // Mark meta-data to indicate it can't be changed
    theFactoryComponentPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FactoryComponentPackage.eNS_URI, theFactoryComponentPackage);
    return theFactoryComponentPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelElement() {
    return modelElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelElement_ID() {
    return (EAttribute) modelElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelElement_Name() {
    return (EAttribute) modelElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelElement_Description() {
    return (EAttribute) modelElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActivity() {
    return activityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivity_ContractContainer() {
    return (EReference) activityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTask() {
    return taskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTask_TaskId() {
    return (EAttribute) taskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactoryComponent() {
    return factoryComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_Viewpoints() {
    return (EReference) factoryComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_Orchestration() {
    return (EReference) factoryComponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getViewpoint() {
    return viewpointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrchestration() {
    return orchestrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvocation() {
    return invocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocation_Context() {
    return (EReference) invocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContext() {
    return contextEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContext_Invocation() {
    return (EReference) contextEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContext_Values() {
    return (EReference) contextEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContext_Connectors() {
    return (EReference) contextEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContractContainer() {
    return contractContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractContainer_Contracts() {
    return (EReference) contractContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContract() {
    return contractEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContract_Mode() {
    return (EAttribute) contractEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContract_Type() {
    return (EReference) contractEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContract_DefaultValue() {
    return (EReference) contractEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContextValue() {
    return contextValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContractValue() {
    return contractValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractValue_Contract() {
    return (EReference) contractValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractValue_Value() {
    return (EAttribute) contractValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractValue_PluginId() {
    return (EAttribute) contractValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContractConnector() {
    return contractConnectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractConnector_Context() {
    return (EReference) contractConnectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractConnector_Source() {
    return (EReference) contractConnectorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractConnector_Target() {
    return (EReference) contractConnectorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getContractMode() {
    return contractModeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getInvocationException() {
    return invocationExceptionEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getURI() {
    return uriEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentFactory getFactoryComponentFactory() {
    return (FactoryComponentFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    modelElementEClass = createEClass(MODEL_ELEMENT);
    createEAttribute(modelElementEClass, MODEL_ELEMENT__ID);
    createEAttribute(modelElementEClass, MODEL_ELEMENT__NAME);
    createEAttribute(modelElementEClass, MODEL_ELEMENT__DESCRIPTION);

    activityEClass = createEClass(ACTIVITY);
    createEReference(activityEClass, ACTIVITY__CONTRACT_CONTAINER);

    taskEClass = createEClass(TASK);
    createEAttribute(taskEClass, TASK__TASK_ID);

    factoryComponentEClass = createEClass(FACTORY_COMPONENT);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__VIEWPOINTS);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__ORCHESTRATION);

    viewpointEClass = createEClass(VIEWPOINT);

    orchestrationEClass = createEClass(ORCHESTRATION);

    invocationEClass = createEClass(INVOCATION);
    createEReference(invocationEClass, INVOCATION__CONTEXT);

    contextEClass = createEClass(CONTEXT);
    createEReference(contextEClass, CONTEXT__INVOCATION);
    createEReference(contextEClass, CONTEXT__VALUES);
    createEReference(contextEClass, CONTEXT__CONNECTORS);

    contractContainerEClass = createEClass(CONTRACT_CONTAINER);
    createEReference(contractContainerEClass, CONTRACT_CONTAINER__CONTRACTS);

    contractEClass = createEClass(CONTRACT);
    createEAttribute(contractEClass, CONTRACT__MODE);
    createEReference(contractEClass, CONTRACT__TYPE);
    createEReference(contractEClass, CONTRACT__DEFAULT_VALUE);

    contextValueEClass = createEClass(CONTEXT_VALUE);

    contractValueEClass = createEClass(CONTRACT_VALUE);
    createEReference(contractValueEClass, CONTRACT_VALUE__CONTRACT);
    createEAttribute(contractValueEClass, CONTRACT_VALUE__VALUE);
    createEAttribute(contractValueEClass, CONTRACT_VALUE__PLUGIN_ID);

    contractConnectorEClass = createEClass(CONTRACT_CONNECTOR);
    createEReference(contractConnectorEClass, CONTRACT_CONNECTOR__CONTEXT);
    createEReference(contractConnectorEClass, CONTRACT_CONNECTOR__SOURCE);
    createEReference(contractConnectorEClass, CONTRACT_CONNECTOR__TARGET);

    // Create enums
    contractModeEEnum = createEEnum(CONTRACT_MODE);

    // Create data types
    invocationExceptionEDataType = createEDataType(INVOCATION_EXCEPTION);
    uriEDataType = createEDataType(URI);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    activityEClass.getESuperTypes().add(this.getModelElement());
    taskEClass.getESuperTypes().add(this.getActivity());
    factoryComponentEClass.getESuperTypes().add(this.getActivity());
    viewpointEClass.getESuperTypes().add(this.getModelElement());
    orchestrationEClass.getESuperTypes().add(this.getModelElement());
    invocationEClass.getESuperTypes().add(this.getModelElement());
    contextEClass.getESuperTypes().add(this.getModelElement());
    contractContainerEClass.getESuperTypes().add(this.getModelElement());
    contractEClass.getESuperTypes().add(this.getModelElement());
    contextValueEClass.getESuperTypes().add(this.getModelElement());
    contractValueEClass.getESuperTypes().add(this.getContextValue());
    contractConnectorEClass.getESuperTypes().add(this.getModelElement());

    // Initialize classes and features; add operations and parameters
    initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(
        getModelElement_ID(),
        theEcorePackage.getEString(),
        "iD", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getModelElement_Name(),
        theEcorePackage.getEString(),
        "name", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getModelElement_Description(),
        theEcorePackage.getEString(),
        "description", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(activityEClass, Activity.class, "Activity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getActivity_ContractContainer(),
        this.getContractContainer(),
        null,
        "contractContainer", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    EOperation op = addEOperation(activityEClass, null, "invoke", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContext(), "invocationContext", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEException(op, this.getInvocationException());

    initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(
        getTask_TaskId(),
        theEcorePackage.getEString(),
        "taskId", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentEClass, FactoryComponent.class, "FactoryComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getFactoryComponent_Viewpoints(),
        this.getViewpoint(),
        null,
        "viewpoints", null, 0, -1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getFactoryComponent_Orchestration(),
        this.getOrchestration(),
        null,
        "orchestration", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(viewpointEClass, Viewpoint.class, "Viewpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(orchestrationEClass, Orchestration.class, "Orchestration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(invocationEClass, Invocation.class, "Invocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getInvocation_Context(),
        this.getContext(),
        this.getContext_Invocation(),
        "context", null, 0, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getContext_Invocation(),
        this.getInvocation(),
        this.getInvocation_Context(),
        "invocation", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getContext_Values(),
        this.getContextValue(),
        null,
        "values", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getContext_Connectors(),
        this.getContractConnector(),
        this.getContractConnector_Context(),
        "connectors", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contractContainerEClass, ContractContainer.class,
        "ContractContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getContractContainer_Contracts(),
        this.getContract(),
        null,
        "contracts", null, 0, -1, ContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contractEClass, Contract.class, "Contract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(
        getContract_Mode(),
        this.getContractMode(),
        "mode", null, 0, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getContract_Type(),
        theTypesPackage.getType(),
        null,
        "type", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getContract_DefaultValue(),
        this.getContractValue(),
        null,
        "defaultValue", null, 0, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contextValueEClass, ContextValue.class, "ContextValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(contractValueEClass, ContractValue.class, "ContractValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getContractValue_Contract(),
        this.getContract(),
        null,
        "contract", null, 1, 1, ContractValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getContractValue_Value(),
        theEcorePackage.getEString(),
        "value", null, 1, 1, ContractValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getContractValue_PluginId(),
        theEcorePackage.getEString(),
        "pluginId", null, 0, 1, ContractValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contractConnectorEClass, ContractConnector.class,
        "ContractConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getContractConnector_Context(),
        this.getContext(),
        this.getContext_Connectors(),
        "context", null, 0, 1, ContractConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getContractConnector_Source(),
        this.getContract(),
        null,
        "source", null, 1, 1, ContractConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getContractConnector_Target(),
        this.getContract(),
        null,
        "target", null, 1, 1, ContractConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    // Initialize enums and add enum literals
    initEEnum(contractModeEEnum, ContractMode.class, "ContractMode"); //$NON-NLS-1$
    addEEnumLiteral(contractModeEEnum, ContractMode.IN);
    addEEnumLiteral(contractModeEEnum, ContractMode.OUT);

    // Initialize data types
    initEDataType(invocationExceptionEDataType, RuntimeException.class,
        "InvocationException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations() {
    String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
    addAnnotation(modelElementEClass, source, new String[] { "constraints", "overall" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} //FactoryComponentPackageImpl
