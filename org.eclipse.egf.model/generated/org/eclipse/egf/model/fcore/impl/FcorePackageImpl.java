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
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Context;
import org.eclipse.egf.model.fcore.ContextContainer;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractConnector;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fcore.util.FcoreValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FcorePackageImpl extends EPackageImpl implements FcorePackage {
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
  private EClass factoryComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass viewpointContainerEClass = null;

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
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextContainerEClass = null;

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
  private EDataType uriEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
   * package
   * package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory
   * method {@link #init init()}, which also performs initialization of the
   * package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.egf.model.fcore.FcorePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FcorePackageImpl() {
    super(eNS_URI, FcoreFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FcorePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FcorePackage init() {
    if (isInited)
      return (FcorePackage) EPackage.Registry.INSTANCE.getEPackage(FcorePackage.eNS_URI);

    // Obtain or create and register package
    FcorePackageImpl theFcorePackage = (FcorePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FcorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FcorePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theFcorePackage.createPackageContents();

    // Initialize created meta-data
    theFcorePackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put(theFcorePackage, new EValidator.Descriptor() {
      public EValidator getEValidator() {
        return FcoreValidator.INSTANCE;
      }
    });

    // Mark meta-data to indicate it can't be changed
    theFcorePackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FcorePackage.eNS_URI, theFcorePackage);
    return theFcorePackage;
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
  public EClass getFactoryComponent() {
    return factoryComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_ViewpointContainer() {
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
  public EClass getViewpointContainer() {
    return viewpointContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getViewpointContainer_FactoryComponent() {
    return (EReference) viewpointContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getViewpointContainer_Viewpoints() {
    return (EReference) viewpointContainerEClass.getEStructuralFeatures().get(1);
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
  public EReference getViewpoint_ViewerpointContainer() {
    return (EReference) viewpointEClass.getEStructuralFeatures().get(0);
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
  public EReference getOrchestration_FactoryComponent() {
    return (EReference) orchestrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrchestration_Invocations() {
    return (EReference) orchestrationEClass.getEStructuralFeatures().get(1);
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
  public EReference getInvocation_Orchestration() {
    return (EReference) invocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocation_ContextContainer() {
    return (EReference) invocationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocation_Activity() {
    return (EReference) invocationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType() {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeObject() {
    return typeObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeClass() {
    return typeClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeClass_Value() {
    return (EAttribute) typeClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContextContainer() {
    return contextContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextContainer_Invocation() {
    return (EReference) contextContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextContainer_Contexts() {
    return (EReference) contextContainerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextContainer_Connectors() {
    return (EReference) contextContainerEClass.getEStructuralFeatures().get(2);
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
  public EReference getContext_ContextContainer() {
    return (EReference) contextEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContext_Contract() {
    return (EReference) contextEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContext_Type() {
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
  public EReference getContractContainer_Activity() {
    return (EReference) contractContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractContainer_Contracts() {
    return (EReference) contractContainerEClass.getEStructuralFeatures().get(1);
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
  public EReference getContract_ContractContainer() {
    return (EReference) contractEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContract_Mandatory() {
    return (EAttribute) contractEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContract_Mode() {
    return (EAttribute) contractEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContract_Type() {
    return (EReference) contractEClass.getEStructuralFeatures().get(3);
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
  public EDataType getURI() {
    return uriEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FcoreFactory getFcoreFactory() {
    return (FcoreFactory) getEFactoryInstance();
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

    factoryComponentEClass = createEClass(FACTORY_COMPONENT);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__VIEWPOINT_CONTAINER);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__ORCHESTRATION);

    viewpointContainerEClass = createEClass(VIEWPOINT_CONTAINER);
    createEReference(viewpointContainerEClass, VIEWPOINT_CONTAINER__FACTORY_COMPONENT);
    createEReference(viewpointContainerEClass, VIEWPOINT_CONTAINER__VIEWPOINTS);

    viewpointEClass = createEClass(VIEWPOINT);
    createEReference(viewpointEClass, VIEWPOINT__VIEWERPOINT_CONTAINER);

    orchestrationEClass = createEClass(ORCHESTRATION);
    createEReference(orchestrationEClass, ORCHESTRATION__FACTORY_COMPONENT);
    createEReference(orchestrationEClass, ORCHESTRATION__INVOCATIONS);

    invocationEClass = createEClass(INVOCATION);
    createEReference(invocationEClass, INVOCATION__ORCHESTRATION);
    createEReference(invocationEClass, INVOCATION__CONTEXT_CONTAINER);
    createEReference(invocationEClass, INVOCATION__ACTIVITY);

    typeEClass = createEClass(TYPE);

    typeObjectEClass = createEClass(TYPE_OBJECT);

    typeClassEClass = createEClass(TYPE_CLASS);
    createEAttribute(typeClassEClass, TYPE_CLASS__VALUE);

    contractContainerEClass = createEClass(CONTRACT_CONTAINER);
    createEReference(contractContainerEClass, CONTRACT_CONTAINER__ACTIVITY);
    createEReference(contractContainerEClass, CONTRACT_CONTAINER__CONTRACTS);

    contractEClass = createEClass(CONTRACT);
    createEReference(contractEClass, CONTRACT__CONTRACT_CONTAINER);
    createEAttribute(contractEClass, CONTRACT__MANDATORY);
    createEAttribute(contractEClass, CONTRACT__MODE);
    createEReference(contractEClass, CONTRACT__TYPE);

    contractConnectorEClass = createEClass(CONTRACT_CONNECTOR);
    createEReference(contractConnectorEClass, CONTRACT_CONNECTOR__CONTEXT);
    createEReference(contractConnectorEClass, CONTRACT_CONNECTOR__SOURCE);
    createEReference(contractConnectorEClass, CONTRACT_CONNECTOR__TARGET);

    contextContainerEClass = createEClass(CONTEXT_CONTAINER);
    createEReference(contextContainerEClass, CONTEXT_CONTAINER__INVOCATION);
    createEReference(contextContainerEClass, CONTEXT_CONTAINER__CONTEXTS);
    createEReference(contextContainerEClass, CONTEXT_CONTAINER__CONNECTORS);

    contextEClass = createEClass(CONTEXT);
    createEReference(contextEClass, CONTEXT__CONTEXT_CONTAINER);
    createEReference(contextEClass, CONTEXT__CONTRACT);
    createEReference(contextEClass, CONTEXT__TYPE);

    // Create enums
    contractModeEEnum = createEEnum(CONTRACT_MODE);

    // Create data types
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

    // Create type parameters
    ETypeParameter invocationEClass_T = addETypeParameter(invocationEClass, "T"); //$NON-NLS-1$
    ETypeParameter typeEClass_T = addETypeParameter(typeEClass, "T"); //$NON-NLS-1$
    ETypeParameter typeObjectEClass_T = addETypeParameter(typeObjectEClass, "T"); //$NON-NLS-1$
    ETypeParameter typeClassEClass_T = addETypeParameter(typeClassEClass, "T"); //$NON-NLS-1$

    // Set bounds for type parameters
    EGenericType g1 = createEGenericType(this.getActivity());
    invocationEClass_T.getEBounds().add(g1);
    g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeEClass_T.getEBounds().add(g1);
    g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeObjectEClass_T.getEBounds().add(g1);
    g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeClassEClass_T.getEBounds().add(g1);

    // Add supertypes to classes
    activityEClass.getESuperTypes().add(this.getModelElement());
    factoryComponentEClass.getESuperTypes().add(this.getActivity());
    viewpointContainerEClass.getESuperTypes().add(this.getModelElement());
    viewpointEClass.getESuperTypes().add(this.getModelElement());
    orchestrationEClass.getESuperTypes().add(this.getModelElement());
    invocationEClass.getESuperTypes().add(this.getModelElement());
    typeEClass.getESuperTypes().add(this.getModelElement());
    g1 = createEGenericType(this.getType());
    EGenericType g2 = createEGenericType(typeObjectEClass_T);
    g1.getETypeArguments().add(g2);
    typeObjectEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType(typeClassEClass_T);
    g1.getETypeArguments().add(g2);
    typeClassEClass.getEGenericSuperTypes().add(g1);
    contractContainerEClass.getESuperTypes().add(this.getModelElement());
    contractEClass.getESuperTypes().add(this.getModelElement());
    contractConnectorEClass.getESuperTypes().add(this.getModelElement());
    contextContainerEClass.getESuperTypes().add(this.getModelElement());
    contextEClass.getESuperTypes().add(this.getModelElement());

    // Initialize classes and features; add operations and parameters
    initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getModelElement_ID(), theEcorePackage.getEString(), "iD", null, 0, 1, ModelElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getModelElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getModelElement_Description(), theEcorePackage.getEString(), "description", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(modelElementEClass, theEcorePackage.getEString(), "getExternalName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(activityEClass, Activity.class, "Activity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getActivity_ContractContainer(), this.getContractContainer(), this.getContractContainer_Activity(), "contractContainer", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentEClass, FactoryComponent.class, "FactoryComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getFactoryComponent_ViewpointContainer(), this.getViewpointContainer(), this.getViewpointContainer_FactoryComponent(), "viewpointContainer", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponent_Orchestration(), this.getOrchestration(), this.getOrchestration_FactoryComponent(), "orchestration", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(viewpointContainerEClass, ViewpointContainer.class, "ViewpointContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getViewpointContainer_FactoryComponent(), this.getFactoryComponent(), this.getFactoryComponent_ViewpointContainer(), "factoryComponent", null, 1, 1, ViewpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getViewpointContainer_Viewpoints(), this.getViewpoint(), this.getViewpoint_ViewerpointContainer(), "viewpoints", null, 0, -1, ViewpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    EOperation op = addEOperation(viewpointContainerEClass, this.getViewpoint(), "getViewpoint", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "clazz", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(viewpointEClass, Viewpoint.class, "Viewpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getViewpoint_ViewerpointContainer(), this.getViewpointContainer(), this.getViewpointContainer_Viewpoints(), "viewerpointContainer", null, 1, 1, Viewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(orchestrationEClass, Orchestration.class, "Orchestration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getOrchestration_FactoryComponent(), this.getFactoryComponent(), this.getFactoryComponent_Orchestration(), "factoryComponent", null, 1, 1, Orchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getInvocation());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getOrchestration_Invocations(), g1, this.getInvocation_Orchestration(), "invocations", null, 0, -1, Orchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(invocationEClass, Invocation.class, "Invocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getInvocation_Orchestration(), this.getOrchestration(), this.getOrchestration_Invocations(), "orchestration", null, 1, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocation_ContextContainer(), this.getContextContainer(), this.getContextContainer_Invocation(), "contextContainer", null, 0, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(invocationEClass_T);
    initEReference(getInvocation_Activity(), g1, null, "activity", null, 1, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(typeEClass_T);
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    addEOperation(typeEClass, theEcorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeObjectEClass, TypeObject.class, "TypeObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(typeClassEClass, TypeClass.class, "TypeClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeClass_Value(), theEcorePackage.getEString(), "value", null, 0, 1, TypeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contractContainerEClass, ContractContainer.class, "ContractContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContractContainer_Activity(), this.getActivity(), this.getActivity_ContractContainer(), "activity", null, 1, 1, ContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContractContainer_Contracts(), this.getContract(), this.getContract_ContractContainer(), "contracts", null, 0, -1, ContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contractEClass, Contract.class, "Contract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContract_ContractContainer(), this.getContractContainer(), this.getContractContainer_Contracts(), "contractContainer", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContract_Mandatory(), theEcorePackage.getEBoolean(), "mandatory", null, 0, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContract_Mode(), this.getContractMode(), "mode", null, 0, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getContract_Type(), g1, null, "type", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contractConnectorEClass, ContractConnector.class, "ContractConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContractConnector_Context(), this.getContextContainer(), this.getContextContainer_Connectors(), "context", null, 0, 1, ContractConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContractConnector_Source(), this.getContract(), null, "source", null, 1, 1, ContractConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContractConnector_Target(), this.getContract(), null, "target", null, 1, 1, ContractConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contextContainerEClass, ContextContainer.class, "ContextContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    g1 = createEGenericType(this.getInvocation());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getContextContainer_Invocation(), g1, this.getInvocation_ContextContainer(), "invocation", null, 0, 1, ContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContextContainer_Contexts(), this.getContext(), this.getContext_ContextContainer(), "contexts", null, 0, -1, ContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContextContainer_Connectors(), this.getContractConnector(), this.getContractConnector_Context(), "connectors", null, 0, -1, ContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContext_ContextContainer(), this.getContextContainer(), this.getContextContainer_Contexts(), "contextContainer", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContext_Contract(), this.getContract(), null, "contract", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getContext_Type(), g1, null, "type", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    // Initialize enums and add enum literals
    initEEnum(contractModeEEnum, ContractMode.class, "ContractMode"); //$NON-NLS-1$
    addEEnumLiteral(contractModeEEnum, ContractMode.IN);
    addEEnumLiteral(contractModeEEnum, ContractMode.OUT);

    // Initialize data types
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
    addAnnotation(contractEClass, source, new String[] { "constraints", "UniqueContractName" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(contextEClass, source, new String[] { "constraints", "UniqueContextName ValidContract" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} // FcorePackageImpl
