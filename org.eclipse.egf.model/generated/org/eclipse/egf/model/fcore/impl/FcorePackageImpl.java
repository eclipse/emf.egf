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
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FactoryComponentContractContainer;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextConnector;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;
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
  private EClass activityContractEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activityContractContainerEClass = null;

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
  private EClass factoryComponentContractEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factoryComponentContractContainerEClass = null;

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
  private EClass orchestrationContextEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orchestrationContextContainerEClass = null;

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
  private EClass invocationContextEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invocationContextConnectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invocationContextContainerEClass = null;

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
  public EClass getActivityContract() {
    return activityContractEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActivityContract_Mandatory() {
    return (EAttribute) activityContractEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActivityContract_Mode() {
    return (EAttribute) activityContractEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityContract_Type() {
    return (EReference) activityContractEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActivityContractContainer() {
    return activityContractContainerEClass;
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
    return (EReference) factoryComponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_Orchestration() {
    return (EReference) factoryComponentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_ActivityContractContainer() {
    return (EReference) factoryComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactoryComponentContract() {
    return factoryComponentContractEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponentContract_InvocationContexts() {
    return (EReference) factoryComponentContractEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponentContract_ActivityContractContainer() {
    return (EReference) factoryComponentContractEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactoryComponentContractContainer() {
    return factoryComponentContractContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponentContractContainer_Activity() {
    return (EReference) factoryComponentContractContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponentContractContainer_ActivityContracts() {
    return (EReference) factoryComponentContractContainerEClass.getEStructuralFeatures().get(1);
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
    return (EReference) orchestrationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrchestration_OrchestrationContextContainer() {
    return (EReference) orchestrationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrchestrationContext() {
    return orchestrationContextEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrchestrationContext_OrchestrationContextContainer() {
    return (EReference) orchestrationContextEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrchestrationContext_InvocationContexts() {
    return (EReference) orchestrationContextEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrchestrationContext_Type() {
    return (EReference) orchestrationContextEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrchestrationContextContainer() {
    return orchestrationContextContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrchestrationContextContainer_Orchestration() {
    return (EReference) orchestrationContextContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrchestrationContextContainer_OrchestrationContexts() {
    return (EReference) orchestrationContextContainerEClass.getEStructuralFeatures().get(1);
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
  public EReference getInvocation_InvocationContextContainer() {
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
  public EClass getInvocationContext() {
    return invocationContextEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContext_InvocationContextContainer() {
    return (EReference) invocationContextEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContext_FactoryComponentExposedContract() {
    return (EReference) invocationContextEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContext_OrchestrationContext() {
    return (EReference) invocationContextEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContext_ActivityContract() {
    return (EReference) invocationContextEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContext_Type() {
    return (EReference) invocationContextEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInvocationContext_Mode() {
    return (EAttribute) invocationContextEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvocationContextConnector() {
    return invocationContextConnectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContextConnector_InvocationContextContainer() {
    return (EReference) invocationContextConnectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContextConnector_SourceInvocationContext() {
    return (EReference) invocationContextConnectorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContextConnector_TargetInvocationContext() {
    return (EReference) invocationContextConnectorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvocationContextContainer() {
    return invocationContextContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContextContainer_Invocation() {
    return (EReference) invocationContextContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContextContainer_InvocationContexts() {
    return (EReference) invocationContextContainerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationContextContainer_InvocationContextConnectors() {
    return (EReference) invocationContextContainerEClass.getEStructuralFeatures().get(2);
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

    activityContractEClass = createEClass(ACTIVITY_CONTRACT);
    createEAttribute(activityContractEClass, ACTIVITY_CONTRACT__MANDATORY);
    createEAttribute(activityContractEClass, ACTIVITY_CONTRACT__MODE);
    createEReference(activityContractEClass, ACTIVITY_CONTRACT__TYPE);

    activityContractContainerEClass = createEClass(ACTIVITY_CONTRACT_CONTAINER);

    factoryComponentEClass = createEClass(FACTORY_COMPONENT);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__ACTIVITY_CONTRACT_CONTAINER);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__VIEWPOINT_CONTAINER);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__ORCHESTRATION);

    factoryComponentContractEClass = createEClass(FACTORY_COMPONENT_CONTRACT);
    createEReference(factoryComponentContractEClass, FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS);
    createEReference(factoryComponentContractEClass, FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER);

    factoryComponentContractContainerEClass = createEClass(FACTORY_COMPONENT_CONTRACT_CONTAINER);
    createEReference(factoryComponentContractContainerEClass, FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY);
    createEReference(factoryComponentContractContainerEClass, FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS);

    viewpointContainerEClass = createEClass(VIEWPOINT_CONTAINER);
    createEReference(viewpointContainerEClass, VIEWPOINT_CONTAINER__FACTORY_COMPONENT);
    createEReference(viewpointContainerEClass, VIEWPOINT_CONTAINER__VIEWPOINTS);

    viewpointEClass = createEClass(VIEWPOINT);
    createEReference(viewpointEClass, VIEWPOINT__VIEWERPOINT_CONTAINER);

    orchestrationEClass = createEClass(ORCHESTRATION);
    createEReference(orchestrationEClass, ORCHESTRATION__FACTORY_COMPONENT);
    createEReference(orchestrationEClass, ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER);
    createEReference(orchestrationEClass, ORCHESTRATION__INVOCATIONS);

    orchestrationContextEClass = createEClass(ORCHESTRATION_CONTEXT);
    createEReference(orchestrationContextEClass, ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER);
    createEReference(orchestrationContextEClass, ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS);
    createEReference(orchestrationContextEClass, ORCHESTRATION_CONTEXT__TYPE);

    orchestrationContextContainerEClass = createEClass(ORCHESTRATION_CONTEXT_CONTAINER);
    createEReference(orchestrationContextContainerEClass, ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION);
    createEReference(orchestrationContextContainerEClass, ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS);

    invocationEClass = createEClass(INVOCATION);
    createEReference(invocationEClass, INVOCATION__ORCHESTRATION);
    createEReference(invocationEClass, INVOCATION__INVOCATION_CONTEXT_CONTAINER);
    createEReference(invocationEClass, INVOCATION__ACTIVITY);

    invocationContextEClass = createEClass(INVOCATION_CONTEXT);
    createEReference(invocationContextEClass, INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER);
    createEReference(invocationContextEClass, INVOCATION_CONTEXT__FACTORY_COMPONENT_EXPOSED_CONTRACT);
    createEReference(invocationContextEClass, INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT);
    createEReference(invocationContextEClass, INVOCATION_CONTEXT__ACTIVITY_CONTRACT);
    createEReference(invocationContextEClass, INVOCATION_CONTEXT__TYPE);
    createEAttribute(invocationContextEClass, INVOCATION_CONTEXT__MODE);

    invocationContextConnectorEClass = createEClass(INVOCATION_CONTEXT_CONNECTOR);
    createEReference(invocationContextConnectorEClass, INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER);
    createEReference(invocationContextConnectorEClass, INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT);
    createEReference(invocationContextConnectorEClass, INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT);

    invocationContextContainerEClass = createEClass(INVOCATION_CONTEXT_CONTAINER);
    createEReference(invocationContextContainerEClass, INVOCATION_CONTEXT_CONTAINER__INVOCATION);
    createEReference(invocationContextContainerEClass, INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS);
    createEReference(invocationContextContainerEClass, INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS);

    typeEClass = createEClass(TYPE);

    typeObjectEClass = createEClass(TYPE_OBJECT);

    typeClassEClass = createEClass(TYPE_CLASS);
    createEAttribute(typeClassEClass, TYPE_CLASS__VALUE);

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
    activityContractEClass.getESuperTypes().add(this.getModelElement());
    activityContractContainerEClass.getESuperTypes().add(this.getModelElement());
    factoryComponentEClass.getESuperTypes().add(this.getActivity());
    factoryComponentContractEClass.getESuperTypes().add(this.getActivityContract());
    factoryComponentContractContainerEClass.getESuperTypes().add(this.getActivityContractContainer());
    viewpointContainerEClass.getESuperTypes().add(this.getModelElement());
    viewpointEClass.getESuperTypes().add(this.getModelElement());
    orchestrationEClass.getESuperTypes().add(this.getModelElement());
    orchestrationContextEClass.getESuperTypes().add(this.getModelElement());
    orchestrationContextContainerEClass.getESuperTypes().add(this.getModelElement());
    invocationEClass.getESuperTypes().add(this.getModelElement());
    invocationContextEClass.getESuperTypes().add(this.getModelElement());
    invocationContextConnectorEClass.getESuperTypes().add(this.getModelElement());
    invocationContextContainerEClass.getESuperTypes().add(this.getModelElement());
    typeEClass.getESuperTypes().add(this.getModelElement());
    g1 = createEGenericType(this.getType());
    EGenericType g2 = createEGenericType(typeObjectEClass_T);
    g1.getETypeArguments().add(g2);
    typeObjectEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType(typeClassEClass_T);
    g1.getETypeArguments().add(g2);
    typeClassEClass.getEGenericSuperTypes().add(g1);

    // Initialize classes and features; add operations and parameters
    initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getModelElement_ID(), theEcorePackage.getEString(), "iD", null, 0, 1, ModelElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getModelElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getModelElement_Description(), theEcorePackage.getEString(), "description", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(activityEClass, Activity.class, "Activity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    EOperation op = addEOperation(activityEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    ETypeParameter t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
    g1 = createEGenericType(this.getActivityContract());
    t1.getEBounds().add(g1);

    op = addEOperation(activityEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(activityContractEClass, ActivityContract.class, "ActivityContract", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getActivityContract_Mandatory(), theEcorePackage.getEBoolean(), "mandatory", null, 0, 1, ActivityContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getActivityContract_Mode(), this.getContractMode(), "mode", null, 0, 1, ActivityContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getActivityContract_Type(), g1, null, "type", null, 1, 1, ActivityContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(activityContractEClass, this.getActivity(), "getActivity", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    addEOperation(activityContractEClass, this.getActivityContractContainer(), "getActivityContractContainer", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityContractEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
    g1 = createEGenericType(this.getActivityContract());
    t1.getEBounds().add(g1);

    op = addEOperation(activityContractEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityContractEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityContractEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(activityContractContainerEClass, ActivityContractContainer.class, "ActivityContractContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    addEOperation(activityContractContainerEClass, this.getActivity(), "getActivity", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityContractContainerEClass, null, "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
    g1 = createEGenericType(this.getActivityContract());
    t1.getEBounds().add(g1);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    op = addEOperation(activityContractContainerEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityContractContainerEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(activityContractContainerEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentEClass, FactoryComponent.class, "FactoryComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getFactoryComponent_ActivityContractContainer(), this.getFactoryComponentContractContainer(), this.getFactoryComponentContractContainer_Activity(), "activityContractContainer", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponent_ViewpointContainer(), this.getViewpointContainer(), this.getViewpointContainer_FactoryComponent(), "viewpointContainer", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponent_Orchestration(), this.getOrchestration(), this.getOrchestration_FactoryComponent(), "orchestration", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(factoryComponentEClass, this.getFactoryComponentContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    addEOperation(factoryComponentEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentContractEClass, FactoryComponentContract.class, "FactoryComponentContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getFactoryComponentContract_InvocationContexts(), this.getInvocationContext(), this.getInvocationContext_FactoryComponentExposedContract(), "invocationContexts", null, 1, -1, FactoryComponentContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponentContract_ActivityContractContainer(), this.getFactoryComponentContractContainer(), this.getFactoryComponentContractContainer_ActivityContracts(), "activityContractContainer", null, 1, 1, FactoryComponentContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(factoryComponentContractEClass, this.getFactoryComponentContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentContractEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentContractEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentContractEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentContractContainerEClass, FactoryComponentContractContainer.class, "FactoryComponentContractContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getFactoryComponentContractContainer_Activity(), this.getFactoryComponent(), this.getFactoryComponent_ActivityContractContainer(), "activity", null, 1, 1, FactoryComponentContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponentContractContainer_ActivityContracts(), this.getFactoryComponentContract(), this.getFactoryComponentContract_ActivityContractContainer(), "activityContracts", null, 1, -1, FactoryComponentContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentContractContainerEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentContractContainerEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(factoryComponentContractContainerEClass, this.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(viewpointContainerEClass, ViewpointContainer.class, "ViewpointContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getViewpointContainer_FactoryComponent(), this.getFactoryComponent(), this.getFactoryComponent_ViewpointContainer(), "factoryComponent", null, 1, 1, ViewpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getViewpointContainer_Viewpoints(), this.getViewpoint(), this.getViewpoint_ViewerpointContainer(), "viewpoints", null, 0, -1, ViewpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(viewpointContainerEClass, this.getViewpoint(), "getViewpoint", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "clazz", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(viewpointEClass, Viewpoint.class, "Viewpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getViewpoint_ViewerpointContainer(), this.getViewpointContainer(), this.getViewpointContainer_Viewpoints(), "viewerpointContainer", null, 1, 1, Viewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(orchestrationEClass, Orchestration.class, "Orchestration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getOrchestration_FactoryComponent(), this.getFactoryComponent(), this.getFactoryComponent_Orchestration(), "factoryComponent", null, 1, 1, Orchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getOrchestration_OrchestrationContextContainer(), this.getOrchestrationContextContainer(), this.getOrchestrationContextContainer_Orchestration(), "orchestrationContextContainer", null, 0, 1, Orchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getInvocation());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getOrchestration_Invocations(), g1, this.getInvocation_Orchestration(), "invocations", null, 1, -1, Orchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(orchestrationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(orchestrationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(orchestrationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(orchestrationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    addEOperation(orchestrationEClass, this.getOrchestrationContext(), "getOrchestrationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(orchestrationEClass, this.getOrchestrationContext(), "getOrchestrationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(orchestrationContextEClass, OrchestrationContext.class, "OrchestrationContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getOrchestrationContext_OrchestrationContextContainer(), this.getOrchestrationContextContainer(), this.getOrchestrationContextContainer_OrchestrationContexts(), "orchestrationContextContainer", null, 1, 1, OrchestrationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getOrchestrationContext_InvocationContexts(), this.getInvocationContext(), this.getInvocationContext_OrchestrationContext(), "invocationContexts", null, 2, -1, OrchestrationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getOrchestrationContext_Type(), g1, null, "type", null, 1, 1, OrchestrationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(orchestrationContextEClass, this.getOrchestration(), "getOrchestration", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(orchestrationContextContainerEClass, OrchestrationContextContainer.class, "OrchestrationContextContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getOrchestrationContextContainer_Orchestration(), this.getOrchestration(), this.getOrchestration_OrchestrationContextContainer(), "orchestration", null, 1, 1, OrchestrationContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getOrchestrationContextContainer_OrchestrationContexts(), this.getOrchestrationContext(), this.getOrchestrationContext_OrchestrationContextContainer(), "orchestrationContexts", null, 1, -1, OrchestrationContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(invocationEClass, Invocation.class, "Invocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getInvocation_Orchestration(), this.getOrchestration(), this.getOrchestration_Invocations(), "orchestration", null, 1, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocation_InvocationContextContainer(), this.getInvocationContextContainer(), this.getInvocationContextContainer_Invocation(), "invocationContextContainer", null, 0, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(invocationEClass_T);
    initEReference(getInvocation_Activity(), g1, null, "activity", null, 1, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(invocationEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    addEOperation(invocationEClass, this.getActivityContract(), "getInvocationActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(invocationEClass, this.getActivityContract(), "getInvocationActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(invocationEClass, this.getActivityContract(), "getInvocationActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(invocationEClass, this.getActivityContract(), "getInvocationActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    addEOperation(invocationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(invocationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(invocationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(invocationEClass, this.getInvocationContext(), "getInvocationContexts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(invocationContextEClass, InvocationContext.class, "InvocationContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getInvocationContext_InvocationContextContainer(), this.getInvocationContextContainer(), this.getInvocationContextContainer_InvocationContexts(), "invocationContextContainer", null, 1, 1, InvocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocationContext_FactoryComponentExposedContract(), this.getFactoryComponentContract(), this.getFactoryComponentContract_InvocationContexts(), "factoryComponentExposedContract", null, 0, 1, InvocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocationContext_OrchestrationContext(), this.getOrchestrationContext(), this.getOrchestrationContext_InvocationContexts(), "orchestrationContext", null, 0, 1, InvocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocationContext_ActivityContract(), this.getActivityContract(), null, "activityContract", null, 1, 1, InvocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getInvocationContext_Type(), g1, null, "type", null, 0, 1, InvocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getInvocationContext_Mode(), this.getContractMode(), "mode", null, 0, 1, InvocationContext.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(invocationContextEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(invocationContextEClass, null, "getInvocation", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(this.getInvocation());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(invocationContextConnectorEClass, InvocationContextConnector.class, "InvocationContextConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getInvocationContextConnector_InvocationContextContainer(), this.getInvocationContextContainer(), this.getInvocationContextContainer_InvocationContextConnectors(), "invocationContextContainer", null, 1, 1, InvocationContextConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocationContextConnector_SourceInvocationContext(), this.getInvocationContext(), null, "sourceInvocationContext", null, 1, 1, InvocationContextConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocationContextConnector_TargetInvocationContext(), this.getInvocationContext(), null, "targetInvocationContext", null, 1, 1, InvocationContextConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(invocationContextContainerEClass, InvocationContextContainer.class, "InvocationContextContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    g1 = createEGenericType(this.getInvocation());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEReference(getInvocationContextContainer_Invocation(), g1, this.getInvocation_InvocationContextContainer(), "invocation", null, 1, 1, InvocationContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocationContextContainer_InvocationContexts(), this.getInvocationContext(), this.getInvocationContext_InvocationContextContainer(), "invocationContexts", null, 0, -1, InvocationContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getInvocationContextContainer_InvocationContextConnectors(), this.getInvocationContextConnector(), this.getInvocationContextConnector_InvocationContextContainer(), "invocationContextConnectors", null, 0, -1, InvocationContextContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(invocationContextContainerEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

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

    // Initialize enums and add enum literals
    initEEnum(contractModeEEnum, ContractMode.class, "ContractMode"); //$NON-NLS-1$
    addEEnumLiteral(contractModeEEnum, ContractMode.IN);
    addEEnumLiteral(contractModeEEnum, ContractMode.OUT);
    addEEnumLiteral(contractModeEEnum, ContractMode.IN_OUT);

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
    addAnnotation(activityContractEClass, source, new String[] { "constraints", "MandatoryName UniqueName" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(factoryComponentContractEClass, source, new String[] { "constraints", "OutModeIsRestricted" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(invocationContextEClass, source, new String[] { "constraints", "MandatoryName UniqueName ValidActivityContract ValidActivityContractType ValidContext ValidExposedContract ValidExposedContractType MandatoryTypeValue UselessType" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(typeObjectEClass, source, new String[] { "constraints", "LoadableValue ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(typeClassEClass, source, new String[] { "constraints", "LoadableValue ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} // FcorePackageImpl
