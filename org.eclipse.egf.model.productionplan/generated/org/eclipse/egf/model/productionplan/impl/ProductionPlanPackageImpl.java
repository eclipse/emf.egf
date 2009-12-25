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
package org.eclipse.egf.model.productionplan.impl;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.productionplan.FactoryComponentInvocation;
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.ProductionPlanFactory;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.eclipse.egf.model.productionplan.ProductionPlanPackage;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.model.productionplan.TaskInvocation;
import org.eclipse.egf.model.productionplan.util.ProductionPlanValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class ProductionPlanPackageImpl extends EPackageImpl implements ProductionPlanPackage {
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
  private EClass taskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taskInvocationEClass = null;

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
   * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ProductionPlanPackageImpl() {
    super(eNS_URI, ProductionPlanFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and
   * for any others upon which it depends.
   * 
   * <p>
   * This method is used to initialize {@link ProductionPlanPackage#eINSTANCE}
   * when that field is accessed. Clients should not invoke it directly.
   * Instead, they should simply access that field to obtain the package. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ProductionPlanPackage init() {
    if (isInited)
      return (ProductionPlanPackage) EPackage.Registry.INSTANCE.getEPackage(ProductionPlanPackage.eNS_URI);

    // Obtain or create and register package
    ProductionPlanPackageImpl theProductionPlanPackage = (ProductionPlanPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProductionPlanPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProductionPlanPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    FcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theProductionPlanPackage.createPackageContents();

    // Initialize created meta-data
    theProductionPlanPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put(theProductionPlanPackage, new EValidator.Descriptor() {
      public EValidator getEValidator() {
        return ProductionPlanValidator.INSTANCE;
      }
    });

    // Mark meta-data to indicate it can't be changed
    theProductionPlanPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ProductionPlanPackage.eNS_URI, theProductionPlanPackage);
    return theProductionPlanPackage;
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
  public EReference getProductionPlan_ProductionPlanInvocations() {
    return (EReference) productionPlanEClass.getEStructuralFeatures().get(0);
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
  public EReference getProductionPlanInvocation_ProductionPlan() {
    return (EReference) productionPlanInvocationEClass.getEStructuralFeatures().get(0);
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
  public EReference getFactoryComponentInvocation_FactoryComponent() {
    return (EReference) factoryComponentInvocationEClass.getEStructuralFeatures().get(0);
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
  public EClass getTaskInvocation() {
    return taskInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTaskInvocation_Task() {
    return (EReference) taskInvocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductionPlanFactory getProductionPlanFactory() {
    return (ProductionPlanFactory) getEFactoryInstance();
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
    createEReference(productionPlanEClass, PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS);

    productionPlanInvocationEClass = createEClass(PRODUCTION_PLAN_INVOCATION);
    createEReference(productionPlanInvocationEClass, PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN);

    factoryComponentInvocationEClass = createEClass(FACTORY_COMPONENT_INVOCATION);
    createEReference(factoryComponentInvocationEClass, FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT);

    taskEClass = createEClass(TASK);
    createEAttribute(taskEClass, TASK__TASK_ID);

    taskInvocationEClass = createEClass(TASK_INVOCATION);
    createEReference(taskInvocationEClass, TASK_INVOCATION__TASK);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    productionPlanEClass.getESuperTypes().add(theFcorePackage.getOrchestration());
    productionPlanInvocationEClass.getESuperTypes().add(theFcorePackage.getInvocation());
    factoryComponentInvocationEClass.getESuperTypes().add(this.getProductionPlanInvocation());
    taskEClass.getESuperTypes().add(theFcorePackage.getActivity());
    taskInvocationEClass.getESuperTypes().add(this.getProductionPlanInvocation());

    // Initialize classes and features; add operations and parameters
    initEClass(productionPlanEClass, ProductionPlan.class, "ProductionPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getProductionPlan_ProductionPlanInvocations(), this.getProductionPlanInvocation(), this.getProductionPlanInvocation_ProductionPlan(), "productionPlanInvocations", null, 0, -1, ProductionPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(productionPlanInvocationEClass, ProductionPlanInvocation.class, "ProductionPlanInvocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getProductionPlanInvocation_ProductionPlan(), this.getProductionPlan(), this.getProductionPlan_ProductionPlanInvocations(), "productionPlan", null, 1, 1, ProductionPlanInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentInvocationEClass, FactoryComponentInvocation.class, "FactoryComponentInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getFactoryComponentInvocation_FactoryComponent(), theFcorePackage.getFactoryComponent(), null, "factoryComponent", null, 1, 1, FactoryComponentInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTask_TaskId(), theEcorePackage.getEString(), "taskId", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(taskInvocationEClass, TaskInvocation.class, "TaskInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getTaskInvocation_Task(), this.getTask(), null, "task", null, 1, 1, TaskInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

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
    addAnnotation(taskEClass, source, new String[] { "constraints", "task" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} // ProductionPlanPackageImpl
