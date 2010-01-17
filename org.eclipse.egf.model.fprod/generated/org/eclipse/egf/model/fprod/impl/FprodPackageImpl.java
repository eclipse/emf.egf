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

import org.eclipse.egf.model.fcore.FcorePackage;

import org.eclipse.egf.model.fprod.FactoryComponentInvocation;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskContract;
import org.eclipse.egf.model.fprod.TaskContractContainer;
import org.eclipse.egf.model.fprod.TaskInvocation;

import org.eclipse.egf.model.fprod.util.FprodValidator;

import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class FprodPackageImpl extends EPackageImpl implements FprodPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass productionPlanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass productionPlanInvocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factoryComponentInvocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taskInvocationEClass = null;

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
  private EClass taskContractEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taskContractContainerEClass = null;

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
   * @see org.eclipse.egf.model.fprod.FprodPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FprodPackageImpl() {
    super(eNS_URI, FprodFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FprodPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FprodPackage init() {
    if (isInited)
      return (FprodPackage) EPackage.Registry.INSTANCE.getEPackage(FprodPackage.eNS_URI);

    // Obtain or create and register package
    FprodPackageImpl theFprodPackage = (FprodPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FprodPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FprodPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    FcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theFprodPackage.createPackageContents();

    // Initialize created meta-data
    theFprodPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put(theFprodPackage, new EValidator.Descriptor() {
      public EValidator getEValidator() {
        return FprodValidator.INSTANCE;
      }
    });

    // Mark meta-data to indicate it can't be changed
    theFprodPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FprodPackage.eNS_URI, theFprodPackage);
    return theFprodPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProductionPlan() {
    return productionPlanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProductionPlanInvocation() {
    return productionPlanInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactoryComponentInvocation() {
    return factoryComponentInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTaskInvocation() {
    return taskInvocationEClass;
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
  public EReference getTask_ActivityContractContainer() {
    return (EReference) taskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTask_Value() {
    return (EAttribute) taskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTaskContract() {
    return taskContractEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTaskContract_ActivityContractContainer() {
    return (EReference) taskContractEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTaskContractContainer() {
    return taskContractContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTaskContractContainer_Activity() {
    return (EReference) taskContractContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTaskContractContainer_ActivityContracts() {
    return (EReference) taskContractContainerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FprodFactory getFprodFactory() {
    return (FprodFactory) getEFactoryInstance();
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
    productionPlanEClass = createEClass(PRODUCTION_PLAN);

    productionPlanInvocationEClass = createEClass(PRODUCTION_PLAN_INVOCATION);

    factoryComponentInvocationEClass = createEClass(FACTORY_COMPONENT_INVOCATION);

    taskInvocationEClass = createEClass(TASK_INVOCATION);

    taskEClass = createEClass(TASK);
    createEReference(taskEClass, TASK__ACTIVITY_CONTRACT_CONTAINER);
    createEAttribute(taskEClass, TASK__VALUE);

    taskContractEClass = createEClass(TASK_CONTRACT);
    createEReference(taskContractEClass, TASK_CONTRACT__ACTIVITY_CONTRACT_CONTAINER);

    taskContractContainerEClass = createEClass(TASK_CONTRACT_CONTAINER);
    createEReference(taskContractContainerEClass, TASK_CONTRACT_CONTAINER__ACTIVITY);
    createEReference(taskContractContainerEClass, TASK_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS);
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
    FcorePackage theFcorePackage = (FcorePackage) EPackage.Registry.INSTANCE.getEPackage(FcorePackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters
    ETypeParameter productionPlanInvocationEClass_T = addETypeParameter(productionPlanInvocationEClass, "T"); //$NON-NLS-1$

    // Set bounds for type parameters
    EGenericType g1 = createEGenericType(theFcorePackage.getActivity());
    productionPlanInvocationEClass_T.getEBounds().add(g1);

    // Add supertypes to classes
    productionPlanEClass.getESuperTypes().add(theFcorePackage.getOrchestration());
    g1 = createEGenericType(theFcorePackage.getInvocation());
    EGenericType g2 = createEGenericType(productionPlanInvocationEClass_T);
    g1.getETypeArguments().add(g2);
    productionPlanInvocationEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getProductionPlanInvocation());
    g2 = createEGenericType(theFcorePackage.getFactoryComponent());
    g1.getETypeArguments().add(g2);
    factoryComponentInvocationEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getProductionPlanInvocation());
    g2 = createEGenericType(this.getTask());
    g1.getETypeArguments().add(g2);
    taskInvocationEClass.getEGenericSuperTypes().add(g1);
    taskEClass.getESuperTypes().add(theFcorePackage.getActivity());
    taskContractEClass.getESuperTypes().add(theFcorePackage.getActivityContract());
    taskContractContainerEClass.getESuperTypes().add(theFcorePackage.getActivityContractContainer());

    // Initialize classes and features; add operations and parameters
    initEClass(productionPlanEClass, ProductionPlan.class, "ProductionPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(productionPlanInvocationEClass, ProductionPlanInvocation.class, "ProductionPlanInvocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(factoryComponentInvocationEClass, FactoryComponentInvocation.class, "FactoryComponentInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(taskInvocationEClass, TaskInvocation.class, "TaskInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getTask_ActivityContractContainer(), this.getTaskContractContainer(), this.getTaskContractContainer_Activity(), "activityContractContainer", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getTask_Value(), theEcorePackage.getEString(), "value", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(taskEClass, this.getTaskContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    EOperation op = addEOperation(taskEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theFcorePackage.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theFcorePackage.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(taskContractEClass, TaskContract.class, "TaskContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getTaskContract_ActivityContractContainer(), this.getTaskContractContainer(), this.getTaskContractContainer_ActivityContracts(), "activityContractContainer", null, 1, 1, TaskContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(taskContractEClass, this.getTaskContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskContractEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskContractEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theFcorePackage.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskContractEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theFcorePackage.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(taskContractContainerEClass, TaskContractContainer.class, "TaskContractContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getTaskContractContainer_Activity(), this.getTask(), this.getTask_ActivityContractContainer(), "activity", null, 1, 1, TaskContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getTaskContractContainer_ActivityContracts(), this.getTaskContract(), this.getTaskContract_ActivityContractContainer(), "activityContracts", null, 1, -1, TaskContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskContractContainerEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskContractContainerEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theFcorePackage.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(taskContractContainerEClass, theFcorePackage.getActivityContract(), "getActivityContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    addEParameter(op, theFcorePackage.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

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
    addAnnotation(taskEClass, source, new String[] { "constraints", "LoadableValue ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} //FprodPackageImpl
