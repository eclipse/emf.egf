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

package org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

import org.eclipse.egf.portfolio.eclipse.build.buildtrigger.BuildtriggerFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildtrigger.BuildtriggerPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger;
import org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildtriggerPackageImpl extends EPackageImpl implements BuildtriggerPackage {
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
    private EClass cronTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scmTriggerEClass = null;

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
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.BuildtriggerPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BuildtriggerPackageImpl() {
        super(eNS_URI, BuildtriggerFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link BuildtriggerPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BuildtriggerPackage init() {
        if (isInited) return (BuildtriggerPackage)EPackage.Registry.INSTANCE.getEPackage(BuildtriggerPackage.eNS_URI);

        // Obtain or create and register package
        BuildtriggerPackageImpl theBuildtriggerPackage = (BuildtriggerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuildtriggerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuildtriggerPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        BuildcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theBuildtriggerPackage.createPackageContents();

        // Initialize created meta-data
        theBuildtriggerPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theBuildtriggerPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(BuildtriggerPackage.eNS_URI, theBuildtriggerPackage);
        return theBuildtriggerPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCronTrigger() {
        return cronTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronTrigger_Planning() {
        return (EAttribute)cronTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSCMTrigger() {
        return scmTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSCMTrigger_Planning() {
        return (EAttribute)scmTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildtriggerFactory getBuildtriggerFactory() {
        return (BuildtriggerFactory)getEFactoryInstance();
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
        cronTriggerEClass = createEClass(CRON_TRIGGER);
        createEAttribute(cronTriggerEClass, CRON_TRIGGER__PLANNING);

        scmTriggerEClass = createEClass(SCM_TRIGGER);
        createEAttribute(scmTriggerEClass, SCM_TRIGGER__PLANNING);
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

        // Obtain other dependent packages
        BuildcorePackage theBuildcorePackage = (BuildcorePackage)EPackage.Registry.INSTANCE.getEPackage(BuildcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        cronTriggerEClass.getESuperTypes().add(theBuildcorePackage.getTrigger());
        scmTriggerEClass.getESuperTypes().add(theBuildcorePackage.getTrigger());

        // Initialize classes and features; add operations and parameters
        initEClass(cronTriggerEClass, CronTrigger.class, "CronTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCronTrigger_Planning(), ecorePackage.getEString(), "planning", "00 06 * * *", 0, 1, CronTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(scmTriggerEClass, SCMTrigger.class, "SCMTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSCMTrigger_Planning(), ecorePackage.getEString(), "planning", "00 * * * *", 0, 1, SCMTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //BuildtriggerPackageImpl
