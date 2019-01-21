/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployFactory;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.CronTrigger;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.SCMTrigger;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.Trigger;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.User;

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
public class BuilddeployPackageImpl extends EPackageImpl implements BuilddeployPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass hudsonDeploymentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userEClass = null;

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
    private EClass cronTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scmTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass generationLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum permissionTypeEEnum = null;

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
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BuilddeployPackageImpl() {
        super(eNS_URI, BuilddeployFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link BuilddeployPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BuilddeployPackage init() {
        if (isInited) return (BuilddeployPackage)EPackage.Registry.INSTANCE.getEPackage(BuilddeployPackage.eNS_URI);

        // Obtain or create and register package
        BuilddeployPackageImpl theBuilddeployPackage = (BuilddeployPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuilddeployPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuilddeployPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        BuildcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theBuilddeployPackage.createPackageContents();

        // Initialize created meta-data
        theBuilddeployPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theBuilddeployPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(BuilddeployPackage.eNS_URI, theBuilddeployPackage);
        return theBuilddeployPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHudsonDeployment() {
        return hudsonDeploymentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHudsonDeployment_AssignedNode() {
        return (EAttribute)hudsonDeploymentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHudsonDeployment_JdkName() {
        return (EAttribute)hudsonDeploymentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHudsonDeployment_AntName() {
        return (EAttribute)hudsonDeploymentEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHudsonDeployment_BuildId() {
        return (EAttribute)hudsonDeploymentEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHudsonDeployment_Enabled() {
        return (EAttribute)hudsonDeploymentEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHudsonDeployment_UserDeployServerUrl() {
        return (EAttribute)hudsonDeploymentEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHudsonDeployment_UserDeployJobName() {
        return (EAttribute)hudsonDeploymentEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHudsonDeployment_Users() {
        return (EReference)hudsonDeploymentEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHudsonDeployment_Triggers() {
        return (EReference)hudsonDeploymentEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHudsonDeployment_GenerationLocation() {
        return (EReference)hudsonDeploymentEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUser() {
        return userEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Login() {
        return (EAttribute)userEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Permission() {
        return (EAttribute)userEClass.getEStructuralFeatures().get(1);
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
    public EClass getGenerationLocation() {
        return generationLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenerationLocation_FolderName() {
        return (EAttribute)generationLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPermissionType() {
        return permissionTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuilddeployFactory getBuilddeployFactory() {
        return (BuilddeployFactory)getEFactoryInstance();
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
        hudsonDeploymentEClass = createEClass(HUDSON_DEPLOYMENT);
        createEAttribute(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__ASSIGNED_NODE);
        createEAttribute(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__JDK_NAME);
        createEAttribute(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__ANT_NAME);
        createEAttribute(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__BUILD_ID);
        createEAttribute(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__ENABLED);
        createEAttribute(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL);
        createEAttribute(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME);
        createEReference(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__USERS);
        createEReference(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__TRIGGERS);
        createEReference(hudsonDeploymentEClass, HUDSON_DEPLOYMENT__GENERATION_LOCATION);

        userEClass = createEClass(USER);
        createEAttribute(userEClass, USER__LOGIN);
        createEAttribute(userEClass, USER__PERMISSION);

        triggerEClass = createEClass(TRIGGER);

        cronTriggerEClass = createEClass(CRON_TRIGGER);
        createEAttribute(cronTriggerEClass, CRON_TRIGGER__PLANNING);

        scmTriggerEClass = createEClass(SCM_TRIGGER);
        createEAttribute(scmTriggerEClass, SCM_TRIGGER__PLANNING);

        generationLocationEClass = createEClass(GENERATION_LOCATION);
        createEAttribute(generationLocationEClass, GENERATION_LOCATION__FOLDER_NAME);

        // Create enums
        permissionTypeEEnum = createEEnum(PERMISSION_TYPE);
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
        hudsonDeploymentEClass.getESuperTypes().add(theBuildcorePackage.getDeployment());
        cronTriggerEClass.getESuperTypes().add(this.getTrigger());
        scmTriggerEClass.getESuperTypes().add(this.getTrigger());

        // Initialize classes and features; add operations and parameters
        initEClass(hudsonDeploymentEClass, HudsonDeployment.class, "HudsonDeployment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHudsonDeployment_AssignedNode(), ecorePackage.getEString(), "assignedNode", null, 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHudsonDeployment_JdkName(), ecorePackage.getEString(), "jdkName", null, 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHudsonDeployment_AntName(), ecorePackage.getEString(), "antName", null, 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHudsonDeployment_BuildId(), ecorePackage.getEString(), "buildId", "yyyyMMdd-HHmm", 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHudsonDeployment_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHudsonDeployment_UserDeployServerUrl(), ecorePackage.getEString(), "userDeployServerUrl", null, 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHudsonDeployment_UserDeployJobName(), ecorePackage.getEString(), "userDeployJobName", null, 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHudsonDeployment_Users(), this.getUser(), null, "users", null, 0, -1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHudsonDeployment_Triggers(), this.getTrigger(), null, "triggers", null, 0, -1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHudsonDeployment_GenerationLocation(), this.getGenerationLocation(), null, "generationLocation", null, 0, 1, HudsonDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getUser_Login(), ecorePackage.getEString(), "login", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_Permission(), this.getPermissionType(), "permission", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(triggerEClass, Trigger.class, "Trigger", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(cronTriggerEClass, CronTrigger.class, "CronTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCronTrigger_Planning(), ecorePackage.getEString(), "planning", "00 06 * * *", 0, 1, CronTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(scmTriggerEClass, SCMTrigger.class, "SCMTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSCMTrigger_Planning(), ecorePackage.getEString(), "planning", "00 * * * *", 0, 1, SCMTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(generationLocationEClass, GenerationLocation.class, "GenerationLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenerationLocation_FolderName(), ecorePackage.getEString(), "folderName", "", 1, 1, GenerationLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(permissionTypeEEnum, PermissionType.class, "PermissionType");
        addEEnumLiteral(permissionTypeEEnum, PermissionType.READ);
        addEEnumLiteral(permissionTypeEEnum, PermissionType.EXECUTE);
        addEEnumLiteral(permissionTypeEEnum, PermissionType.WRITE);

        // Create resource
        createResource(eNS_URI);
    }

} //BuilddeployPackageImpl
