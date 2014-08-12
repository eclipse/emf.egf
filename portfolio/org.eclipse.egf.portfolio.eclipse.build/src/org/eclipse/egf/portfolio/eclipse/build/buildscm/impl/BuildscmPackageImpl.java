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

package org.eclipse.egf.portfolio.eclipse.build.buildscm.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.GITGenerationLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.GITProtocol;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNGenerationLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
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
public class BuildscmPackageImpl extends EPackageImpl implements BuildscmPackage {
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
    private EClass svnEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass svnLocationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass svnBuildLocationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass svnGenerationLocationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass gitEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass gitLocationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass gitBuildLocationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass gitGenerationLocationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum svnProtocolEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum gitProtocolEEnum = null;

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
	 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
    private BuildscmPackageImpl() {
		super(eNS_URI, BuildscmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BuildscmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
    public static BuildscmPackage init() {
		if (isInited) return (BuildscmPackage)EPackage.Registry.INSTANCE.getEPackage(BuildscmPackage.eNS_URI);

		// Obtain or create and register package
		BuildscmPackageImpl theBuildscmPackage = (BuildscmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuildscmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuildscmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BuilddeployPackage.eINSTANCE.eClass();
		BuildstepPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBuildscmPackage.createPackageContents();

		// Initialize created meta-data
		theBuildscmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBuildscmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BuildscmPackage.eNS_URI, theBuildscmPackage);
		return theBuildscmPackage;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSVN() {
		return svnEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSVN_Locations() {
		return (EReference)svnEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSVNLocation() {
		return svnLocationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSVNLocation_Protocol() {
		return (EAttribute)svnLocationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSVNLocation_Url() {
		return (EAttribute)svnLocationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSVNLocation_LocalPath() {
		return (EAttribute)svnLocationEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSVNLocation_Username() {
		return (EAttribute)svnLocationEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSVNLocation_Password() {
		return (EAttribute)svnLocationEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSVNBuildLocation() {
		return svnBuildLocationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSVNBuildLocation_SvnLocation() {
		return (EReference)svnBuildLocationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSVNBuildLocation_FolderName() {
		return (EAttribute)svnBuildLocationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSVNGenerationLocation() {
		return svnGenerationLocationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSVNGenerationLocation_SvnLocation() {
		return (EReference)svnGenerationLocationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getGIT() {
		return gitEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getGIT_Locations() {
		return (EReference)gitEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getGITLocation() {
		return gitLocationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getGITLocation_Protocol() {
		return (EAttribute)gitLocationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getGITLocation_Url() {
		return (EAttribute)gitLocationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGITLocation_LocalPath() {
		return (EAttribute)gitLocationEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGITLocation_Branch() {
		return (EAttribute)gitLocationEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getGITLocation_Username() {
		return (EAttribute)gitLocationEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getGITLocation_Password() {
		return (EAttribute)gitLocationEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getGITBuildLocation() {
		return gitBuildLocationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getGITBuildLocation_GitLocation() {
		return (EReference)gitBuildLocationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getGITBuildLocation_FolderName() {
		return (EAttribute)gitBuildLocationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getGITGenerationLocation() {
		return gitGenerationLocationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getGITGenerationLocation_GitLocation() {
		return (EReference)gitGenerationLocationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getSVNProtocol() {
		return svnProtocolEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getGITProtocol() {
		return gitProtocolEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public BuildscmFactory getBuildscmFactory() {
		return (BuildscmFactory)getEFactoryInstance();
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
		svnEClass = createEClass(SVN);
		createEReference(svnEClass, SVN__LOCATIONS);

		svnLocationEClass = createEClass(SVN_LOCATION);
		createEAttribute(svnLocationEClass, SVN_LOCATION__PROTOCOL);
		createEAttribute(svnLocationEClass, SVN_LOCATION__URL);
		createEAttribute(svnLocationEClass, SVN_LOCATION__LOCAL_PATH);
		createEAttribute(svnLocationEClass, SVN_LOCATION__USERNAME);
		createEAttribute(svnLocationEClass, SVN_LOCATION__PASSWORD);

		svnBuildLocationEClass = createEClass(SVN_BUILD_LOCATION);
		createEReference(svnBuildLocationEClass, SVN_BUILD_LOCATION__SVN_LOCATION);
		createEAttribute(svnBuildLocationEClass, SVN_BUILD_LOCATION__FOLDER_NAME);

		svnGenerationLocationEClass = createEClass(SVN_GENERATION_LOCATION);
		createEReference(svnGenerationLocationEClass, SVN_GENERATION_LOCATION__SVN_LOCATION);

		gitEClass = createEClass(GIT);
		createEReference(gitEClass, GIT__LOCATIONS);

		gitLocationEClass = createEClass(GIT_LOCATION);
		createEAttribute(gitLocationEClass, GIT_LOCATION__PROTOCOL);
		createEAttribute(gitLocationEClass, GIT_LOCATION__URL);
		createEAttribute(gitLocationEClass, GIT_LOCATION__LOCAL_PATH);
		createEAttribute(gitLocationEClass, GIT_LOCATION__BRANCH);
		createEAttribute(gitLocationEClass, GIT_LOCATION__USERNAME);
		createEAttribute(gitLocationEClass, GIT_LOCATION__PASSWORD);

		gitBuildLocationEClass = createEClass(GIT_BUILD_LOCATION);
		createEReference(gitBuildLocationEClass, GIT_BUILD_LOCATION__GIT_LOCATION);
		createEAttribute(gitBuildLocationEClass, GIT_BUILD_LOCATION__FOLDER_NAME);

		gitGenerationLocationEClass = createEClass(GIT_GENERATION_LOCATION);
		createEReference(gitGenerationLocationEClass, GIT_GENERATION_LOCATION__GIT_LOCATION);

		// Create enums
		svnProtocolEEnum = createEEnum(SVN_PROTOCOL);
		gitProtocolEEnum = createEEnum(GIT_PROTOCOL);
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
		BuildstepPackage theBuildstepPackage = (BuildstepPackage)EPackage.Registry.INSTANCE.getEPackage(BuildstepPackage.eNS_URI);
		BuilddeployPackage theBuilddeployPackage = (BuilddeployPackage)EPackage.Registry.INSTANCE.getEPackage(BuilddeployPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		svnEClass.getESuperTypes().add(theBuildcorePackage.getSCM());
		svnBuildLocationEClass.getESuperTypes().add(theBuildstepPackage.getSourceBuildLocation());
		svnGenerationLocationEClass.getESuperTypes().add(theBuilddeployPackage.getGenerationLocation());
		gitEClass.getESuperTypes().add(theBuildcorePackage.getSCM());
		gitBuildLocationEClass.getESuperTypes().add(theBuildstepPackage.getSourceBuildLocation());
		gitGenerationLocationEClass.getESuperTypes().add(theBuilddeployPackage.getGenerationLocation());

		// Initialize classes and features; add operations and parameters
		initEClass(svnEClass, org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN.class, "SVN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSVN_Locations(), this.getSVNLocation(), null, "locations", null, 1, -1, org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svnLocationEClass, SVNLocation.class, "SVNLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSVNLocation_Protocol(), this.getSVNProtocol(), "protocol", null, 1, 1, SVNLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSVNLocation_Url(), ecorePackage.getEString(), "url", null, 1, 1, SVNLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSVNLocation_LocalPath(), ecorePackage.getEString(), "localPath", null, 1, 1, SVNLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSVNLocation_Username(), ecorePackage.getEString(), "username", null, 0, 1, SVNLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSVNLocation_Password(), ecorePackage.getEString(), "password", null, 0, 1, SVNLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svnBuildLocationEClass, SVNBuildLocation.class, "SVNBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSVNBuildLocation_SvnLocation(), this.getSVNLocation(), null, "svnLocation", null, 1, 1, SVNBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSVNBuildLocation_FolderName(), ecorePackage.getEString(), "folderName", "", 1, 1, SVNBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svnGenerationLocationEClass, SVNGenerationLocation.class, "SVNGenerationLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSVNGenerationLocation_SvnLocation(), this.getSVNLocation(), null, "svnLocation", null, 1, 1, SVNGenerationLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gitEClass, org.eclipse.egf.portfolio.eclipse.build.buildscm.GIT.class, "GIT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGIT_Locations(), this.getGITLocation(), null, "locations", null, 1, 1, org.eclipse.egf.portfolio.eclipse.build.buildscm.GIT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gitLocationEClass, GITLocation.class, "GITLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGITLocation_Protocol(), this.getGITProtocol(), "protocol", null, 1, 1, GITLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGITLocation_Url(), ecorePackage.getEString(), "url", null, 1, 1, GITLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGITLocation_LocalPath(), ecorePackage.getEString(), "localPath", null, 1, 1, GITLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGITLocation_Branch(), ecorePackage.getEString(), "branch", "master", 1, 1, GITLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGITLocation_Username(), ecorePackage.getEString(), "username", null, 0, 1, GITLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGITLocation_Password(), ecorePackage.getEString(), "password", null, 0, 1, GITLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gitBuildLocationEClass, GITBuildLocation.class, "GITBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGITBuildLocation_GitLocation(), this.getGITLocation(), null, "gitLocation", null, 1, 1, GITBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGITBuildLocation_FolderName(), ecorePackage.getEString(), "folderName", "", 1, 1, GITBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gitGenerationLocationEClass, GITGenerationLocation.class, "GITGenerationLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGITGenerationLocation_GitLocation(), this.getGITLocation(), null, "gitLocation", null, 1, 1, GITGenerationLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(svnProtocolEEnum, SVNProtocol.class, "SVNProtocol");
		addEEnumLiteral(svnProtocolEEnum, SVNProtocol.HTTP);
		addEEnumLiteral(svnProtocolEEnum, SVNProtocol.HTTPS);
		addEEnumLiteral(svnProtocolEEnum, SVNProtocol.SVN);
		addEEnumLiteral(svnProtocolEEnum, SVNProtocol.SVNSSH);

		initEEnum(gitProtocolEEnum, GITProtocol.class, "GITProtocol");
		addEEnumLiteral(gitProtocolEEnum, GITProtocol.HTTP);
		addEEnumLiteral(gitProtocolEEnum, GITProtocol.HTTPS);
		addEEnumLiteral(gitProtocolEEnum, GITProtocol.GIT);
		addEEnumLiteral(gitProtocolEEnum, GITProtocol.SSH);

		// Create resource
		createResource(eNS_URI);
	}

} //BuildscmPackageImpl
