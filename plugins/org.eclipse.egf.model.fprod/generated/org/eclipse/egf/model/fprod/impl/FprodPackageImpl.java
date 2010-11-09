/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
    public EReference getProductionPlan_Invocations() {
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
        createEReference(productionPlanEClass, PRODUCTION_PLAN__INVOCATIONS);

        productionPlanInvocationEClass = createEClass(PRODUCTION_PLAN_INVOCATION);
        createEReference(productionPlanInvocationEClass, PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN);
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

        // Initialize classes and features; add operations and parameters
        initEClass(productionPlanEClass, ProductionPlan.class, "ProductionPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getProductionPlan_Invocations(), this.getProductionPlanInvocation(), this.getProductionPlanInvocation_ProductionPlan(),
                "invocations", null, 1, -1, ProductionPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        EOperation op = addEOperation(productionPlanEClass, null, "getResources", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        EGenericType g1 = createEGenericType(theEcorePackage.getEEList());
        EGenericType g2 = createEGenericType(theEcorePackage.getEResource());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(productionPlanInvocationEClass, ProductionPlanInvocation.class, "ProductionPlanInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getProductionPlanInvocation_ProductionPlan(), this.getProductionPlan(), this.getProductionPlan_Invocations(),
                "productionPlan", null, 1, 1, ProductionPlanInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(productionPlanInvocationEClass, null, "getResources", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEEList());
        g2 = createEGenericType(theEcorePackage.getEResource());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        addEOperation(productionPlanInvocationEClass, theFcorePackage.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);
    }

} // FprodPackageImpl
