/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.portfolio.genchain.generationChain.impl;

import org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;

import org.eclipse.egf.portfolio.genchain.generationChain.PluginAddition;
import org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenerationChainPackageImpl extends EPackageImpl implements GenerationChainPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass generationElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass generationChainEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass emfGenerationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentationGenerationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass ecoreElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pluginProviderEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pluginAdditionEClass = null;

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
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private GenerationChainPackageImpl() {
        super(eNS_URI, GenerationChainFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link GenerationChainPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static GenerationChainPackage init() {
        if (isInited)
            return (GenerationChainPackage) EPackage.Registry.INSTANCE.getEPackage(GenerationChainPackage.eNS_URI);

        // Obtain or create and register package
        GenerationChainPackageImpl theGenerationChainPackage = (GenerationChainPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GenerationChainPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GenerationChainPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theGenerationChainPackage.createPackageContents();

        // Initialize created meta-data
        theGenerationChainPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theGenerationChainPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(GenerationChainPackage.eNS_URI, theGenerationChainPackage);
        return theGenerationChainPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenerationElement() {
        return generationElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenerationElement_Name() {
        return (EAttribute) generationElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenerationElement_Container() {
        return (EReference) generationElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenerationChain() {
        return generationChainEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenerationChain_FactoryComponentName() {
        return (EAttribute) generationChainEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenerationChain_Elements() {
        return (EReference) generationChainEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEmfGeneration() {
        return emfGenerationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEmfGeneration_GenerateModel() {
        return (EAttribute) emfGenerationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEmfGeneration_GenerateEdit() {
        return (EAttribute) emfGenerationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEmfGeneration_GenerateEditor() {
        return (EAttribute) emfGenerationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEmfGeneration_PluginName() {
        return (EAttribute) emfGenerationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEmfGeneration_BasePackage() {
        return (EAttribute) emfGenerationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocumentationGeneration() {
        return documentationGenerationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentationGeneration_PluginName() {
        return (EAttribute) documentationGenerationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentationGeneration_OutputDirectoryPath() {
        return (EAttribute) documentationGenerationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEcoreElement() {
        return ecoreElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEcoreElement_ModelPath() {
        return (EAttribute) ecoreElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPluginProvider() {
        return pluginProviderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPluginAddition() {
        return pluginAdditionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPluginAddition_Additions() {
        return (EAttribute) pluginAdditionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenerationChainFactory getGenerationChainFactory() {
        return (GenerationChainFactory) getEFactoryInstance();
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
        generationElementEClass = createEClass(GENERATION_ELEMENT);
        createEAttribute(generationElementEClass, GENERATION_ELEMENT__NAME);
        createEReference(generationElementEClass, GENERATION_ELEMENT__CONTAINER);

        generationChainEClass = createEClass(GENERATION_CHAIN);
        createEAttribute(generationChainEClass, GENERATION_CHAIN__FACTORY_COMPONENT_NAME);
        createEReference(generationChainEClass, GENERATION_CHAIN__ELEMENTS);

        emfGenerationEClass = createEClass(EMF_GENERATION);
        createEAttribute(emfGenerationEClass, EMF_GENERATION__GENERATE_MODEL);
        createEAttribute(emfGenerationEClass, EMF_GENERATION__GENERATE_EDIT);
        createEAttribute(emfGenerationEClass, EMF_GENERATION__GENERATE_EDITOR);
        createEAttribute(emfGenerationEClass, EMF_GENERATION__PLUGIN_NAME);
        createEAttribute(emfGenerationEClass, EMF_GENERATION__BASE_PACKAGE);

        documentationGenerationEClass = createEClass(DOCUMENTATION_GENERATION);
        createEAttribute(documentationGenerationEClass, DOCUMENTATION_GENERATION__PLUGIN_NAME);
        createEAttribute(documentationGenerationEClass, DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH);

        ecoreElementEClass = createEClass(ECORE_ELEMENT);
        createEAttribute(ecoreElementEClass, ECORE_ELEMENT__MODEL_PATH);

        pluginProviderEClass = createEClass(PLUGIN_PROVIDER);

        pluginAdditionEClass = createEClass(PLUGIN_ADDITION);
        createEAttribute(pluginAdditionEClass, PLUGIN_ADDITION__ADDITIONS);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        generationChainEClass.getESuperTypes().add(this.getGenerationElement());
        emfGenerationEClass.getESuperTypes().add(this.getEcoreElement());
        emfGenerationEClass.getESuperTypes().add(this.getPluginProvider());
        documentationGenerationEClass.getESuperTypes().add(this.getEcoreElement());
        documentationGenerationEClass.getESuperTypes().add(this.getPluginProvider());
        ecoreElementEClass.getESuperTypes().add(this.getGenerationElement());
        pluginAdditionEClass.getESuperTypes().add(this.getGenerationElement());
        pluginAdditionEClass.getESuperTypes().add(this.getPluginProvider());

        // Initialize classes and features; add operations and parameters
        initEClass(generationElementEClass, GenerationElement.class, "GenerationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenerationElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, GenerationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGenerationElement_Container(), this.getGenerationChain(), this.getGenerationChain_Elements(), "container", null, 0, 1, GenerationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(generationChainEClass, GenerationChain.class, "GenerationChain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenerationChain_FactoryComponentName(), ecorePackage.getEString(), "factoryComponentName", null, 0, 1, GenerationChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGenerationChain_Elements(), this.getGenerationElement(), this.getGenerationElement_Container(), "elements", null, 0, -1, GenerationChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(emfGenerationEClass, EmfGeneration.class, "EmfGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEmfGeneration_GenerateModel(), ecorePackage.getEBoolean(), "generateModel", null, 0, 1, EmfGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEmfGeneration_GenerateEdit(), ecorePackage.getEBoolean(), "generateEdit", null, 0, 1, EmfGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEmfGeneration_GenerateEditor(), ecorePackage.getEBoolean(), "generateEditor", null, 0, 1, EmfGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEmfGeneration_PluginName(), ecorePackage.getEString(), "pluginName", null, 1, 1, EmfGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEmfGeneration_BasePackage(), ecorePackage.getEString(), "basePackage", null, 1, 1, EmfGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(documentationGenerationEClass, DocumentationGeneration.class, "DocumentationGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentationGeneration_PluginName(), ecorePackage.getEString(), "pluginName", null, 1, 1, DocumentationGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentationGeneration_OutputDirectoryPath(), ecorePackage.getEString(), "outputDirectoryPath", null, 1, 1, DocumentationGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(ecoreElementEClass, EcoreElement.class, "EcoreElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEcoreElement_ModelPath(), ecorePackage.getEString(), "modelPath", null, 1, 1, EcoreElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pluginProviderEClass, PluginProvider.class, "PluginProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(pluginProviderEClass, ecorePackage.getEString(), "getPluginNames", 0, -1, IS_UNIQUE, IS_ORDERED);

        initEClass(pluginAdditionEClass, PluginAddition.class, "PluginAddition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPluginAddition_Additions(), ecorePackage.getEString(), "additions", null, 0, -1, PluginAddition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //GenerationChainPackageImpl
