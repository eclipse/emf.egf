/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcoreFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Item;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Property;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildcorePackageImpl extends EPackageImpl implements BuildcorePackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemPropertiesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass keyValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass chainEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractStepContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jobEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stepContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scmEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass propertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass propertyPackageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass reuseStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum propertyTypeEEnum = null;

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
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BuildcorePackageImpl() {
        super(eNS_URI, BuildcoreFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link BuildcorePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BuildcorePackage init() {
        if (isInited) return (BuildcorePackage)EPackage.Registry.INSTANCE.getEPackage(BuildcorePackage.eNS_URI);

        // Obtain or create and register package
        BuildcorePackageImpl theBuildcorePackage = (BuildcorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuildcorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuildcorePackageImpl());

        isInited = true;

        // Create package meta-data objects
        theBuildcorePackage.createPackageContents();

        // Initialize created meta-data
        theBuildcorePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theBuildcorePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(BuildcorePackage.eNS_URI, theBuildcorePackage);
        return theBuildcorePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItem() {
        return itemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItem_Name() {
        return (EAttribute)itemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItem_Description() {
        return (EAttribute)itemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItem_Enabled() {
        return (EAttribute)itemEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemProperties() {
        return itemPropertiesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getItemProperties_Properties() {
        return (EReference)itemPropertiesEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getItemProperties_PropertyPackages() {
        return (EReference)itemPropertiesEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKeyValue() {
        return keyValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKeyValue_Key() {
        return (EAttribute)keyValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKeyValue_Value() {
        return (EAttribute)keyValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getChain() {
        return chainEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChain_Jobs() {
        return (EReference)chainEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractStepContainer() {
        return abstractStepContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractStepContainer_Steps() {
        return (EReference)abstractStepContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJob() {
        return jobEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getJob_Scms() {
        return (EReference)jobEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getJob_Triggers() {
        return (EReference)jobEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStep() {
        return stepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStepContainer() {
        return stepContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSCM() {
        return scmEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProperty() {
        return propertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProperty_Type() {
        return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPropertyPackage() {
        return propertyPackageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPropertyPackage_Name() {
        return (EAttribute)propertyPackageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPropertyPackage_Description() {
        return (EAttribute)propertyPackageEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPropertyPackage_Properties() {
        return (EReference)propertyPackageEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTrigger() {
        return triggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReuseStep() {
        return reuseStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReuseStep_ReusedStep() {
        return (EReference)reuseStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPropertyType() {
        return propertyTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildcoreFactory getBuildcoreFactory() {
        return (BuildcoreFactory)getEFactoryInstance();
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
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        itemEClass = createEClass(ITEM);
        createEAttribute(itemEClass, ITEM__NAME);
        createEAttribute(itemEClass, ITEM__DESCRIPTION);
        createEAttribute(itemEClass, ITEM__ENABLED);

        itemPropertiesEClass = createEClass(ITEM_PROPERTIES);
        createEReference(itemPropertiesEClass, ITEM_PROPERTIES__PROPERTIES);
        createEReference(itemPropertiesEClass, ITEM_PROPERTIES__PROPERTY_PACKAGES);

        keyValueEClass = createEClass(KEY_VALUE);
        createEAttribute(keyValueEClass, KEY_VALUE__KEY);
        createEAttribute(keyValueEClass, KEY_VALUE__VALUE);

        propertyEClass = createEClass(PROPERTY);
        createEAttribute(propertyEClass, PROPERTY__TYPE);

        propertyPackageEClass = createEClass(PROPERTY_PACKAGE);
        createEAttribute(propertyPackageEClass, PROPERTY_PACKAGE__NAME);
        createEAttribute(propertyPackageEClass, PROPERTY_PACKAGE__DESCRIPTION);
        createEReference(propertyPackageEClass, PROPERTY_PACKAGE__PROPERTIES);

        chainEClass = createEClass(CHAIN);
        createEReference(chainEClass, CHAIN__JOBS);

        abstractStepContainerEClass = createEClass(ABSTRACT_STEP_CONTAINER);
        createEReference(abstractStepContainerEClass, ABSTRACT_STEP_CONTAINER__STEPS);

        stepEClass = createEClass(STEP);

        jobEClass = createEClass(JOB);
        createEReference(jobEClass, JOB__SCMS);
        createEReference(jobEClass, JOB__TRIGGERS);

        stepContainerEClass = createEClass(STEP_CONTAINER);

        scmEClass = createEClass(SCM);

        triggerEClass = createEClass(TRIGGER);

        reuseStepEClass = createEClass(REUSE_STEP);
        createEReference(reuseStepEClass, REUSE_STEP__REUSED_STEP);

        // Create enums
        propertyTypeEEnum = createEEnum(PROPERTY_TYPE);
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
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        itemPropertiesEClass.getESuperTypes().add(this.getItem());
        propertyEClass.getESuperTypes().add(this.getKeyValue());
        chainEClass.getESuperTypes().add(this.getItemProperties());
        abstractStepContainerEClass.getESuperTypes().add(this.getItemProperties());
        stepEClass.getESuperTypes().add(this.getItem());
        jobEClass.getESuperTypes().add(this.getAbstractStepContainer());
        stepContainerEClass.getESuperTypes().add(this.getAbstractStepContainer());
        stepContainerEClass.getESuperTypes().add(this.getStep());
        reuseStepEClass.getESuperTypes().add(this.getStep());

        // Initialize classes and features; add operations and parameters
        initEClass(itemEClass, Item.class, "Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getItem_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(itemPropertiesEClass, ItemProperties.class, "ItemProperties", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getItemProperties_Properties(), this.getProperty(), null, "properties", null, 0, -1, ItemProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getItemProperties_PropertyPackages(), this.getPropertyPackage(), null, "propertyPackages", null, 0, -1, ItemProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(keyValueEClass, KeyValue.class, "KeyValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKeyValue_Key(), ecorePackage.getEString(), "key", null, 1, 1, KeyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKeyValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, KeyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProperty_Type(), this.getPropertyType(), "type", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyPackageEClass, PropertyPackage.class, "PropertyPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPropertyPackage_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropertyPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyPackage_Description(), ecorePackage.getEString(), "description", null, 0, 1, PropertyPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyPackage_Properties(), this.getProperty(), null, "properties", null, 0, -1, PropertyPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(chainEClass, Chain.class, "Chain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getChain_Jobs(), this.getJob(), null, "jobs", null, 1, -1, Chain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abstractStepContainerEClass, AbstractStepContainer.class, "AbstractStepContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAbstractStepContainer_Steps(), this.getStep(), null, "steps", null, 0, -1, AbstractStepContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stepEClass, Step.class, "Step", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(jobEClass, Job.class, "Job", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getJob_Scms(), this.getSCM(), null, "scms", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getJob_Triggers(), this.getTrigger(), null, "triggers", null, 0, -1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stepContainerEClass, StepContainer.class, "StepContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(scmEClass, org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM.class, "SCM", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(triggerEClass, Trigger.class, "Trigger", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(reuseStepEClass, ReuseStep.class, "ReuseStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReuseStep_ReusedStep(), this.getStep(), null, "reusedStep", null, 1, 1, ReuseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(propertyTypeEEnum, PropertyType.class, "PropertyType");
        addEEnumLiteral(propertyTypeEEnum, PropertyType.RUNTIME);
        addEEnumLiteral(propertyTypeEEnum, PropertyType.INLINED);

        // Create resource
        createResource(eNS_URI);
    }

} //BuildcorePackageImpl
