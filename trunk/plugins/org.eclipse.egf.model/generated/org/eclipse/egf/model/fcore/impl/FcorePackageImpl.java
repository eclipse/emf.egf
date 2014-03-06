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
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fcore.util.FcoreValidator;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
    private EClass namedModelElementEClass = null;

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
    private EClass contractEClass = null;

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
    private EClass contractContainerEClass = null;

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
    private EClass orchestrationParameterContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass orchestrationParameterEClass = null;

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
    private EClass invocationContractContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass invocationContractEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum contractModeEEnum = null;

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
        TypesPackage.eINSTANCE.eClass();

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
    public EAttribute getModelElement_Description() {
        return (EAttribute) modelElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNamedModelElement() {
        return namedModelElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamedModelElement_Name() {
        return (EAttribute) namedModelElementEClass.getEStructuralFeatures().get(0);
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
    public EClass getFactoryComponentContract() {
        return factoryComponentContractEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFactoryComponentContract_InvocationContracts() {
        return (EReference) factoryComponentContractEClass.getEStructuralFeatures().get(0);
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
    public EReference getViewpoint_ViewpointContainer() {
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
    public EReference getOrchestration_OrchestrationParameterContainer() {
        return (EReference) orchestrationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOrchestrationParameterContainer() {
        return orchestrationParameterContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOrchestrationParameterContainer_Orchestration() {
        return (EReference) orchestrationParameterContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOrchestrationParameterContainer_OrchestrationParameters() {
        return (EReference) orchestrationParameterContainerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOrchestrationParameter() {
        return orchestrationParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOrchestrationParameter_OrchestrationParameterContainer() {
        return (EReference) orchestrationParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOrchestrationParameter_InvocationContracts() {
        return (EReference) orchestrationParameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOrchestrationParameter_Type() {
        return (EReference) orchestrationParameterEClass.getEStructuralFeatures().get(2);
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
    public EReference getInvocation_InvocationContractContainer() {
        return (EReference) invocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocation_InvokedActivity() {
        return (EReference) invocationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInvocationContractContainer() {
        return invocationContractContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContractContainer_Invocation() {
        return (EReference) invocationContractContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContractContainer_InvocationContracts() {
        return (EReference) invocationContractContainerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInvocationContract() {
        return invocationContractEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContract_InvocationContractContainer() {
        return (EReference) invocationContractEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContract_FactoryComponentContract() {
        return (EReference) invocationContractEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContract_OrchestrationParameter() {
        return (EReference) invocationContractEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContract_SourceInvocationContract() {
        return (EReference) invocationContractEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContract_TargetInvocationContract() {
        return (EReference) invocationContractEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContract_InvokedContract() {
        return (EReference) invocationContractEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInvocationContract_Type() {
        return (EReference) invocationContractEClass.getEStructuralFeatures().get(6);
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
        createEAttribute(modelElementEClass, MODEL_ELEMENT__DESCRIPTION);

        namedModelElementEClass = createEClass(NAMED_MODEL_ELEMENT);
        createEAttribute(namedModelElementEClass, NAMED_MODEL_ELEMENT__NAME);

        activityEClass = createEClass(ACTIVITY);
        createEReference(activityEClass, ACTIVITY__CONTRACT_CONTAINER);

        contractEClass = createEClass(CONTRACT);
        createEReference(contractEClass, CONTRACT__CONTRACT_CONTAINER);
        createEAttribute(contractEClass, CONTRACT__MANDATORY);
        createEAttribute(contractEClass, CONTRACT__MODE);
        createEReference(contractEClass, CONTRACT__TYPE);

        factoryComponentEClass = createEClass(FACTORY_COMPONENT);
        createEReference(factoryComponentEClass, FACTORY_COMPONENT__VIEWPOINT_CONTAINER);
        createEReference(factoryComponentEClass, FACTORY_COMPONENT__ORCHESTRATION);

        contractContainerEClass = createEClass(CONTRACT_CONTAINER);
        createEReference(contractContainerEClass, CONTRACT_CONTAINER__ACTIVITY);
        createEReference(contractContainerEClass, CONTRACT_CONTAINER__CONTRACTS);

        factoryComponentContractEClass = createEClass(FACTORY_COMPONENT_CONTRACT);
        createEReference(factoryComponentContractEClass, FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS);

        viewpointContainerEClass = createEClass(VIEWPOINT_CONTAINER);
        createEReference(viewpointContainerEClass, VIEWPOINT_CONTAINER__FACTORY_COMPONENT);
        createEReference(viewpointContainerEClass, VIEWPOINT_CONTAINER__VIEWPOINTS);

        viewpointEClass = createEClass(VIEWPOINT);
        createEReference(viewpointEClass, VIEWPOINT__VIEWPOINT_CONTAINER);

        orchestrationEClass = createEClass(ORCHESTRATION);
        createEReference(orchestrationEClass, ORCHESTRATION__FACTORY_COMPONENT);
        createEReference(orchestrationEClass, ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER);

        orchestrationParameterContainerEClass = createEClass(ORCHESTRATION_PARAMETER_CONTAINER);
        createEReference(orchestrationParameterContainerEClass, ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION);
        createEReference(orchestrationParameterContainerEClass, ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION_PARAMETERS);

        orchestrationParameterEClass = createEClass(ORCHESTRATION_PARAMETER);
        createEReference(orchestrationParameterEClass, ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER);
        createEReference(orchestrationParameterEClass, ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS);
        createEReference(orchestrationParameterEClass, ORCHESTRATION_PARAMETER__TYPE);

        invocationEClass = createEClass(INVOCATION);
        createEReference(invocationEClass, INVOCATION__INVOCATION_CONTRACT_CONTAINER);
        createEReference(invocationEClass, INVOCATION__INVOKED_ACTIVITY);

        invocationContractContainerEClass = createEClass(INVOCATION_CONTRACT_CONTAINER);
        createEReference(invocationContractContainerEClass, INVOCATION_CONTRACT_CONTAINER__INVOCATION);
        createEReference(invocationContractContainerEClass, INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS);

        invocationContractEClass = createEClass(INVOCATION_CONTRACT);
        createEReference(invocationContractEClass, INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER);
        createEReference(invocationContractEClass, INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT);
        createEReference(invocationContractEClass, INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER);
        createEReference(invocationContractEClass, INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT);
        createEReference(invocationContractEClass, INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT);
        createEReference(invocationContractEClass, INVOCATION_CONTRACT__INVOKED_CONTRACT);
        createEReference(invocationContractEClass, INVOCATION_CONTRACT__TYPE);

        // Create enums
        contractModeEEnum = createEEnum(CONTRACT_MODE);
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
        namedModelElementEClass.getESuperTypes().add(this.getModelElement());
        activityEClass.getESuperTypes().add(this.getNamedModelElement());
        contractEClass.getESuperTypes().add(this.getNamedModelElement());
        factoryComponentEClass.getESuperTypes().add(this.getActivity());
        contractContainerEClass.getESuperTypes().add(this.getModelElement());
        factoryComponentContractEClass.getESuperTypes().add(this.getContract());
        viewpointContainerEClass.getESuperTypes().add(this.getModelElement());
        viewpointEClass.getESuperTypes().add(this.getModelElement());
        orchestrationEClass.getESuperTypes().add(this.getModelElement());
        orchestrationParameterContainerEClass.getESuperTypes().add(this.getModelElement());
        orchestrationParameterEClass.getESuperTypes().add(this.getNamedModelElement());
        invocationEClass.getESuperTypes().add(this.getNamedModelElement());
        invocationContractContainerEClass.getESuperTypes().add(this.getModelElement());
        invocationContractEClass.getESuperTypes().add(this.getModelElement());

        // Initialize classes and features; add operations and parameters
        initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getModelElement_ID(), theEcorePackage.getEString(), "iD", null, 0, 1, ModelElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getModelElement_Description(), theEcorePackage.getEString(), "description", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        EOperation op = addEOperation(modelElementEClass, null, "getActivities", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        EGenericType g1 = createEGenericType(theEcorePackage.getEEList());
        EGenericType g2 = createEGenericType(this.getActivity());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        op = addEOperation(modelElementEClass, null, "getResources", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEEList());
        g2 = createEGenericType(theEcorePackage.getEResource());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(namedModelElementEClass, NamedModelElement.class, "NamedModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getNamedModelElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(activityEClass, Activity.class, "Activity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getActivity_ContractContainer(), this.getContractContainer(), this.getContractContainer_Activity(),
                "contractContainer", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(activityEClass, null, "getActivities", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEEList());
        g2 = createEGenericType(this.getActivity());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        addEOperation(activityEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(activityEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(activityEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(activityEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(activityEClass, this.getContract(), "getContract", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(contractEClass, Contract.class, "Contract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getContract_ContractContainer(), this.getContractContainer(), this.getContractContainer_Contracts(),
                "contractContainer", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getContract_Mandatory(), theEcorePackage.getEBoolean(), "mandatory", null, 0, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getContract_Mode(), this.getContractMode(), "mode", null, 0, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getContract_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(contractEClass, this.getActivity(), "getActivity", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(contractEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(contractEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(contractEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(contractEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(factoryComponentEClass, FactoryComponent.class, "FactoryComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getFactoryComponent_ViewpointContainer(), this.getViewpointContainer(), this.getViewpointContainer_FactoryComponent(),
                "viewpointContainer", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getFactoryComponent_Orchestration(), this.getOrchestration(), this.getOrchestration_FactoryComponent(),
                "orchestration", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(factoryComponentEClass, null, "getActivities", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEEList());
        g2 = createEGenericType(this.getActivity());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        op = addEOperation(factoryComponentEClass, null, "getResources", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEEList());
        g2 = createEGenericType(theEcorePackage.getEResource());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        addEOperation(factoryComponentEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(factoryComponentEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(factoryComponentEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(factoryComponentEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(contractContainerEClass, ContractContainer.class, "ContractContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getContractContainer_Activity(), this.getActivity(), this.getActivity_ContractContainer(), "activity", null, 1, 1, ContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getContractContainer_Contracts(), this.getContract(), this.getContract_ContractContainer(), "contracts", null, 1, -1, ContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(contractContainerEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(contractContainerEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(contractContainerEClass, this.getContract(), "getContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(factoryComponentContractEClass, FactoryComponentContract.class, "FactoryComponentContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getFactoryComponentContract_InvocationContracts(), this.getInvocationContract(), this.getInvocationContract_FactoryComponentContract(),
                "invocationContracts", null, 0, -1, FactoryComponentContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(viewpointContainerEClass, ViewpointContainer.class, "ViewpointContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getViewpointContainer_FactoryComponent(), this.getFactoryComponent(), this.getFactoryComponent_ViewpointContainer(),
                "factoryComponent", null, 1, 1, ViewpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getViewpointContainer_Viewpoints(), this.getViewpoint(), this.getViewpoint_ViewpointContainer(),
                "viewpoints", null, 0, -1, ViewpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(viewpointContainerEClass, this.getViewpoint(), "getViewpoint", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "clazz", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(viewpointEClass, Viewpoint.class, "Viewpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getViewpoint_ViewpointContainer(), this.getViewpointContainer(), this.getViewpointContainer_Viewpoints(),
                "viewpointContainer", null, 1, 1, Viewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(orchestrationEClass, Orchestration.class, "Orchestration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getOrchestration_FactoryComponent(), this.getFactoryComponent(), this.getFactoryComponent_Orchestration(),
                "factoryComponent", null, 1, 1, Orchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOrchestration_OrchestrationParameterContainer(), this.getOrchestrationParameterContainer(), this.getOrchestrationParameterContainer_Orchestration(),
                "orchestrationParameterContainer", null, 0, 1, Orchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(orchestrationEClass, null, "getInvocations", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        ETypeParameter t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(this.getInvocation());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(t1);
        initEOperation(op, g1);

        addEOperation(orchestrationEClass, this.getOrchestrationParameter(), "getOrchestrationParameters", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(orchestrationEClass, this.getOrchestrationParameter(), "getOrchestrationParameters", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(orchestrationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(orchestrationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(orchestrationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(orchestrationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(orchestrationParameterContainerEClass, OrchestrationParameterContainer.class, "OrchestrationParameterContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getOrchestrationParameterContainer_Orchestration(), this.getOrchestration(), this.getOrchestration_OrchestrationParameterContainer(),
                "orchestration", null, 1, 1, OrchestrationParameterContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOrchestrationParameterContainer_OrchestrationParameters(), this.getOrchestrationParameter(), this.getOrchestrationParameter_OrchestrationParameterContainer(),
                "orchestrationParameters", null, 0, -1, OrchestrationParameterContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(orchestrationParameterContainerEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(orchestrationParameterContainerEClass, this.getOrchestrationParameter(), "getOrchestrationParameters", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(orchestrationParameterEClass, OrchestrationParameter.class, "OrchestrationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getOrchestrationParameter_OrchestrationParameterContainer(), this.getOrchestrationParameterContainer(), this.getOrchestrationParameterContainer_OrchestrationParameters(),
                "orchestrationParameterContainer", null, 1, 1, OrchestrationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOrchestrationParameter_InvocationContracts(), this.getInvocationContract(), this.getInvocationContract_OrchestrationParameter(),
                "invocationContracts", null, 0, -1, OrchestrationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOrchestrationParameter_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, OrchestrationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(orchestrationParameterEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(orchestrationParameterEClass, this.getOrchestration(), "getOrchestration", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(invocationEClass, Invocation.class, "Invocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInvocation_InvocationContractContainer(), this.getInvocationContractContainer(), this.getInvocationContractContainer_Invocation(),
                "invocationContractContainer", null, 0, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocation_InvokedActivity(), this.getActivity(), null, "invokedActivity", null, 1, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(invocationEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(invocationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(invocationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(invocationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(invocationEClass, this.getInvocationContract(), "getInvocationContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(invocationEClass, this.getContract(), "getInvokedContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(invocationEClass, this.getContract(), "getInvokedContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(invocationEClass, this.getContract(), "getInvokedContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(invocationEClass, this.getContract(), "getInvokedContracts", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theTypesPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getContractMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(invocationContractContainerEClass, InvocationContractContainer.class, "InvocationContractContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInvocationContractContainer_Invocation(), this.getInvocation(), this.getInvocation_InvocationContractContainer(),
                "invocation", null, 1, 1, InvocationContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocationContractContainer_InvocationContracts(), this.getInvocationContract(), this.getInvocationContract_InvocationContractContainer(),
                "invocationContracts", null, 0, -1, InvocationContractContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(invocationContractContainerEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(invocationContractEClass, InvocationContract.class, "InvocationContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInvocationContract_InvocationContractContainer(), this.getInvocationContractContainer(), this.getInvocationContractContainer_InvocationContracts(),
                "invocationContractContainer", null, 1, 1, InvocationContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocationContract_FactoryComponentContract(), this.getFactoryComponentContract(), this.getFactoryComponentContract_InvocationContracts(),
                "factoryComponentContract", null, 0, 1, InvocationContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocationContract_OrchestrationParameter(), this.getOrchestrationParameter(), this.getOrchestrationParameter_InvocationContracts(),
                "orchestrationParameter", null, 0, 1, InvocationContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocationContract_SourceInvocationContract(), this.getInvocationContract(), this.getInvocationContract_TargetInvocationContract(),
                "sourceInvocationContract", null, 0, 1, InvocationContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocationContract_TargetInvocationContract(), this.getInvocationContract(), this.getInvocationContract_SourceInvocationContract(),
                "targetInvocationContract", null, 0, -1, InvocationContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocationContract_InvokedContract(), this.getContract(), null, "invokedContract", null, 1, 1, InvocationContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvocationContract_Type(), theTypesPackage.getType(), null, "type", null, 0, 1, InvocationContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(invocationContractEClass, this.getFactoryComponent(), "getFactoryComponent", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(invocationContractEClass, this.getInvocation(), "getInvocation", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(invocationContractEClass, this.getContractMode(), "getInvokedMode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(contractModeEEnum, ContractMode.class, "ContractMode"); //$NON-NLS-1$
        addEEnumLiteral(contractModeEEnum, ContractMode.IN);
        addEEnumLiteral(contractModeEEnum, ContractMode.OUT);
        addEEnumLiteral(contractModeEEnum, ContractMode.IN_OUT);

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
        addAnnotation(activityEClass, source, new String[] {
                "constraints", "PlatformFcore MandatoryName ActivityCycle" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(contractEClass, source, new String[] {
                "constraints", "UniqueName UselessMandatoryMode" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(contractContainerEClass, source, new String[] {
                "constraints", "FactoryComponentContract" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(factoryComponentContractEClass, source, new String[] {
                "constraints", "UselessFactoryComponentContract OutModeIsRestricted" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(orchestrationParameterContainerEClass, source, new String[] {
                "constraints", "UselessOrchestrationParameterContainer" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(orchestrationParameterEClass, source, new String[] {
                "constraints", "UselessOrchestrationParameter" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(invocationEClass, source, new String[] {
                "constraints", "MandatoryInvokedContract" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(
                invocationContractEClass,
                source,
                new String[] {
                        "constraints", "ValidInvokedContract ValidInvokedContractType ValidFactoryComponentContract ValidFactoryComponentContractType ValidOrchestrationParameter ValidOrchestrationParameterType ValidSourceInvocationContract ValidSourceInvocationContractType UselessTypeValue UselessInvocationContract" //$NON-NLS-1$ //$NON-NLS-2$
                });
    }

} // FcorePackageImpl
