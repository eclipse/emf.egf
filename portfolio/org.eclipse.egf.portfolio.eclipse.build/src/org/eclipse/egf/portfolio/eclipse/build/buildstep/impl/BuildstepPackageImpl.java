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

package org.eclipse.egf.portfolio.eclipse.build.buildstep.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Component;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation;

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
public class BuildstepPackageImpl extends EPackageImpl implements BuildstepPackage {
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
    private EClass resultStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cleanStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass buildStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass publishStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass testStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass antStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javadocStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass egfStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass egfActivityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass aggregateStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass installStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass buildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sourceBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass binaryBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass localBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass targetPlatformBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass updateSiteBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resultStepBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass installStepBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass runningPlatformBuildLocationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pluginEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass featureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum cleaN_TYPEEEnum = null;

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
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BuildstepPackageImpl() {
        super(eNS_URI, BuildstepFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link BuildstepPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BuildstepPackage init() {
        if (isInited) return (BuildstepPackage)EPackage.Registry.INSTANCE.getEPackage(BuildstepPackage.eNS_URI);

        // Obtain or create and register package
        BuildstepPackageImpl theBuildstepPackage = (BuildstepPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuildstepPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuildstepPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        BuildcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theBuildstepPackage.createPackageContents();

        // Initialize created meta-data
        theBuildstepPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theBuildstepPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(BuildstepPackage.eNS_URI, theBuildstepPackage);
        return theBuildstepPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResultStep() {
        return resultStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCleanStep() {
        return cleanStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCleanStep_Type() {
        return (EAttribute)cleanStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBuildStep() {
        return buildStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBuildStep_BuildLocations() {
        return (EReference)buildStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBuildStep_Components() {
        return (EReference)buildStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBuildStep_AllPlatforms() {
        return (EAttribute)buildStepEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBuildStep_NoBuildersInvocation() {
        return (EAttribute)buildStepEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPublishStep() {
        return publishStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPublishStep_Component() {
        return (EReference)publishStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPublishStep_Signing() {
        return (EAttribute)publishStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPublishStep_GenerateSources() {
        return (EAttribute)publishStepEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTestStep() {
        return testStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTestStep_LaunchConfigurationPath() {
        return (EAttribute)testStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTestStep_CodeCoverage() {
        return (EAttribute)testStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAntStep() {
        return antStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAntStep_TargetName() {
        return (EAttribute)antStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAntStep_Xml() {
        return (EAttribute)antStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAntStep_RunInEclipse() {
        return (EAttribute)antStepEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavadocStep() {
        return javadocStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getJavadocStep_Sources() {
        return (EReference)javadocStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getJavadocStep_Includes() {
        return (EAttribute)javadocStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getJavadocStep_Excludes() {
        return (EAttribute)javadocStepEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getJavadocStep_Links() {
        return (EAttribute)javadocStepEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEgfStep() {
        return egfStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEgfStep_EgfActivities() {
        return (EReference)egfStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEgfActivity() {
        return egfActivityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEgfActivity_Uri() {
        return (EAttribute)egfActivityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAggregateStep() {
        return aggregateStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAggregateStep_Name() {
        return (EAttribute)aggregateStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAggregateStep_PublishSteps() {
        return (EReference)aggregateStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAggregateStep_UpdateSiteUrls() {
        return (EAttribute)aggregateStepEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInstallStep() {
        return installStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInstallStep_Name() {
        return (EAttribute)installStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInstallStep_Profile() {
        return (EAttribute)installStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInstallStep_ResultSteps() {
        return (EReference)installStepEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInstallStep_UpdateSiteUrls() {
        return (EAttribute)installStepEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInstallStep_FeatureNames() {
        return (EAttribute)installStepEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInstallStep_ProductNames() {
        return (EAttribute)installStepEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBuildLocation() {
        return buildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBuildLocation_Pattern() {
        return (EAttribute)buildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBuildLocation_BuildStep() {
        return (EReference)buildLocationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSourceBuildLocation() {
        return sourceBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSourceBuildLocation_Suffix() {
        return (EAttribute)sourceBuildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBinaryBuildLocation() {
        return binaryBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBinaryBuildLocation_Suffix() {
        return (EAttribute)binaryBuildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLocalBuildLocation() {
        return localBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLocalBuildLocation_Path() {
        return (EAttribute)localBuildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTargetPlatformBuildLocation() {
        return targetPlatformBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTargetPlatformBuildLocation_Path() {
        return (EAttribute)targetPlatformBuildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUpdateSiteBuildLocation() {
        return updateSiteBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateSiteBuildLocation_Url() {
        return (EAttribute)updateSiteBuildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResultStepBuildLocation() {
        return resultStepBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResultStepBuildLocation_ResultStep() {
        return (EReference)resultStepBuildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInstallStepBuildLocation() {
        return installStepBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInstallStepBuildLocation_InstallStep() {
        return (EReference)installStepBuildLocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRunningPlatformBuildLocation() {
        return runningPlatformBuildLocationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponent() {
        return componentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getComponent_Name() {
        return (EAttribute)componentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponent_BuildStep() {
        return (EReference)componentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPlugin() {
        return pluginEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFeature() {
        return featureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getCLEAN_TYPE() {
        return cleaN_TYPEEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildstepFactory getBuildstepFactory() {
        return (BuildstepFactory)getEFactoryInstance();
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
        resultStepEClass = createEClass(RESULT_STEP);

        cleanStepEClass = createEClass(CLEAN_STEP);
        createEAttribute(cleanStepEClass, CLEAN_STEP__TYPE);

        buildStepEClass = createEClass(BUILD_STEP);
        createEReference(buildStepEClass, BUILD_STEP__BUILD_LOCATIONS);
        createEReference(buildStepEClass, BUILD_STEP__COMPONENTS);
        createEAttribute(buildStepEClass, BUILD_STEP__ALL_PLATFORMS);
        createEAttribute(buildStepEClass, BUILD_STEP__NO_BUILDERS_INVOCATION);

        publishStepEClass = createEClass(PUBLISH_STEP);
        createEReference(publishStepEClass, PUBLISH_STEP__COMPONENT);
        createEAttribute(publishStepEClass, PUBLISH_STEP__SIGNING);
        createEAttribute(publishStepEClass, PUBLISH_STEP__GENERATE_SOURCES);

        testStepEClass = createEClass(TEST_STEP);
        createEAttribute(testStepEClass, TEST_STEP__LAUNCH_CONFIGURATION_PATH);
        createEAttribute(testStepEClass, TEST_STEP__CODE_COVERAGE);

        antStepEClass = createEClass(ANT_STEP);
        createEAttribute(antStepEClass, ANT_STEP__TARGET_NAME);
        createEAttribute(antStepEClass, ANT_STEP__XML);
        createEAttribute(antStepEClass, ANT_STEP__RUN_IN_ECLIPSE);

        javadocStepEClass = createEClass(JAVADOC_STEP);
        createEReference(javadocStepEClass, JAVADOC_STEP__SOURCES);
        createEAttribute(javadocStepEClass, JAVADOC_STEP__INCLUDES);
        createEAttribute(javadocStepEClass, JAVADOC_STEP__EXCLUDES);
        createEAttribute(javadocStepEClass, JAVADOC_STEP__LINKS);

        egfStepEClass = createEClass(EGF_STEP);
        createEReference(egfStepEClass, EGF_STEP__EGF_ACTIVITIES);

        egfActivityEClass = createEClass(EGF_ACTIVITY);
        createEAttribute(egfActivityEClass, EGF_ACTIVITY__URI);

        aggregateStepEClass = createEClass(AGGREGATE_STEP);
        createEAttribute(aggregateStepEClass, AGGREGATE_STEP__NAME);
        createEReference(aggregateStepEClass, AGGREGATE_STEP__PUBLISH_STEPS);
        createEAttribute(aggregateStepEClass, AGGREGATE_STEP__UPDATE_SITE_URLS);

        installStepEClass = createEClass(INSTALL_STEP);
        createEAttribute(installStepEClass, INSTALL_STEP__NAME);
        createEAttribute(installStepEClass, INSTALL_STEP__PROFILE);
        createEReference(installStepEClass, INSTALL_STEP__RESULT_STEPS);
        createEAttribute(installStepEClass, INSTALL_STEP__UPDATE_SITE_URLS);
        createEAttribute(installStepEClass, INSTALL_STEP__FEATURE_NAMES);
        createEAttribute(installStepEClass, INSTALL_STEP__PRODUCT_NAMES);

        buildLocationEClass = createEClass(BUILD_LOCATION);
        createEAttribute(buildLocationEClass, BUILD_LOCATION__PATTERN);
        createEReference(buildLocationEClass, BUILD_LOCATION__BUILD_STEP);

        sourceBuildLocationEClass = createEClass(SOURCE_BUILD_LOCATION);
        createEAttribute(sourceBuildLocationEClass, SOURCE_BUILD_LOCATION__SUFFIX);

        binaryBuildLocationEClass = createEClass(BINARY_BUILD_LOCATION);
        createEAttribute(binaryBuildLocationEClass, BINARY_BUILD_LOCATION__SUFFIX);

        localBuildLocationEClass = createEClass(LOCAL_BUILD_LOCATION);
        createEAttribute(localBuildLocationEClass, LOCAL_BUILD_LOCATION__PATH);

        targetPlatformBuildLocationEClass = createEClass(TARGET_PLATFORM_BUILD_LOCATION);
        createEAttribute(targetPlatformBuildLocationEClass, TARGET_PLATFORM_BUILD_LOCATION__PATH);

        updateSiteBuildLocationEClass = createEClass(UPDATE_SITE_BUILD_LOCATION);
        createEAttribute(updateSiteBuildLocationEClass, UPDATE_SITE_BUILD_LOCATION__URL);

        resultStepBuildLocationEClass = createEClass(RESULT_STEP_BUILD_LOCATION);
        createEReference(resultStepBuildLocationEClass, RESULT_STEP_BUILD_LOCATION__RESULT_STEP);

        installStepBuildLocationEClass = createEClass(INSTALL_STEP_BUILD_LOCATION);
        createEReference(installStepBuildLocationEClass, INSTALL_STEP_BUILD_LOCATION__INSTALL_STEP);

        runningPlatformBuildLocationEClass = createEClass(RUNNING_PLATFORM_BUILD_LOCATION);

        componentEClass = createEClass(COMPONENT);
        createEAttribute(componentEClass, COMPONENT__NAME);
        createEReference(componentEClass, COMPONENT__BUILD_STEP);

        pluginEClass = createEClass(PLUGIN);

        featureEClass = createEClass(FEATURE);

        // Create enums
        cleaN_TYPEEEnum = createEEnum(CLEAN_TYPE);
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
        resultStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        cleanStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        buildStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        publishStepEClass.getESuperTypes().add(this.getResultStep());
        testStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        antStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        javadocStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        egfStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        egfStepEClass.getESuperTypes().add(theBuildcorePackage.getItem());
        aggregateStepEClass.getESuperTypes().add(this.getResultStep());
        installStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        sourceBuildLocationEClass.getESuperTypes().add(this.getBuildLocation());
        binaryBuildLocationEClass.getESuperTypes().add(this.getBuildLocation());
        localBuildLocationEClass.getESuperTypes().add(this.getSourceBuildLocation());
        targetPlatformBuildLocationEClass.getESuperTypes().add(this.getBinaryBuildLocation());
        updateSiteBuildLocationEClass.getESuperTypes().add(this.getBinaryBuildLocation());
        resultStepBuildLocationEClass.getESuperTypes().add(this.getBinaryBuildLocation());
        installStepBuildLocationEClass.getESuperTypes().add(this.getBinaryBuildLocation());
        runningPlatformBuildLocationEClass.getESuperTypes().add(this.getBinaryBuildLocation());
        pluginEClass.getESuperTypes().add(this.getComponent());
        featureEClass.getESuperTypes().add(this.getComponent());

        // Initialize classes and features; add operations and parameters
        initEClass(resultStepEClass, ResultStep.class, "ResultStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(cleanStepEClass, CleanStep.class, "CleanStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCleanStep_Type(), this.getCLEAN_TYPE(), "type", "Workspace", 1, 1, CleanStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(buildStepEClass, BuildStep.class, "BuildStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBuildStep_BuildLocations(), this.getBuildLocation(), this.getBuildLocation_BuildStep(), "buildLocations", null, 0, -1, BuildStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBuildStep_Components(), this.getComponent(), this.getComponent_BuildStep(), "components", null, 0, -1, BuildStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getBuildStep_AllPlatforms(), ecorePackage.getEBoolean(), "allPlatforms", "false", 0, 1, BuildStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getBuildStep_NoBuildersInvocation(), ecorePackage.getEBoolean(), "noBuildersInvocation", "false", 0, 1, BuildStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(publishStepEClass, PublishStep.class, "PublishStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPublishStep_Component(), this.getComponent(), null, "component", null, 1, 1, PublishStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPublishStep_Signing(), ecorePackage.getEBoolean(), "signing", "false", 0, 1, PublishStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPublishStep_GenerateSources(), ecorePackage.getEBoolean(), "generateSources", "true", 0, 1, PublishStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(testStepEClass, TestStep.class, "TestStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTestStep_LaunchConfigurationPath(), ecorePackage.getEString(), "launchConfigurationPath", null, 1, 1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestStep_CodeCoverage(), ecorePackage.getEBoolean(), "codeCoverage", "false", 0, 1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(antStepEClass, AntStep.class, "AntStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAntStep_TargetName(), ecorePackage.getEString(), "targetName", null, 1, 1, AntStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAntStep_Xml(), ecorePackage.getEString(), "xml", null, 1, 1, AntStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAntStep_RunInEclipse(), ecorePackage.getEBoolean(), "runInEclipse", "false", 0, 1, AntStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(javadocStepEClass, JavadocStep.class, "JavadocStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getJavadocStep_Sources(), this.getSourceBuildLocation(), null, "sources", null, 1, -1, JavadocStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getJavadocStep_Includes(), ecorePackage.getEString(), "includes", null, 0, -1, JavadocStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getJavadocStep_Excludes(), ecorePackage.getEString(), "excludes", null, 0, -1, JavadocStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getJavadocStep_Links(), ecorePackage.getEString(), "links", null, 0, -1, JavadocStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(egfStepEClass, EgfStep.class, "EgfStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEgfStep_EgfActivities(), this.getEgfActivity(), null, "egfActivities", null, 1, -1, EgfStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(egfActivityEClass, EgfActivity.class, "EgfActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEgfActivity_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, EgfActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(aggregateStepEClass, AggregateStep.class, "AggregateStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAggregateStep_Name(), ecorePackage.getEString(), "name", null, 1, 1, AggregateStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAggregateStep_PublishSteps(), this.getPublishStep(), null, "publishSteps", null, 0, -1, AggregateStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAggregateStep_UpdateSiteUrls(), ecorePackage.getEString(), "updateSiteUrls", null, 0, -1, AggregateStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(installStepEClass, InstallStep.class, "InstallStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getInstallStep_Name(), ecorePackage.getEString(), "name", null, 1, 1, InstallStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInstallStep_Profile(), ecorePackage.getEString(), "profile", null, 1, 1, InstallStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInstallStep_ResultSteps(), this.getResultStep(), null, "resultSteps", null, 0, -1, InstallStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInstallStep_UpdateSiteUrls(), ecorePackage.getEString(), "updateSiteUrls", null, 0, -1, InstallStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInstallStep_FeatureNames(), ecorePackage.getEString(), "featureNames", null, 0, -1, InstallStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInstallStep_ProductNames(), ecorePackage.getEString(), "productNames", null, 0, -1, InstallStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(buildLocationEClass, BuildLocation.class, "BuildLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getBuildLocation_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, BuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBuildLocation_BuildStep(), this.getBuildStep(), this.getBuildStep_BuildLocations(), "buildStep", null, 1, 1, BuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(sourceBuildLocationEClass, SourceBuildLocation.class, "SourceBuildLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSourceBuildLocation_Suffix(), ecorePackage.getEString(), "suffix", null, 0, 1, SourceBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(binaryBuildLocationEClass, BinaryBuildLocation.class, "BinaryBuildLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getBinaryBuildLocation_Suffix(), ecorePackage.getEString(), "suffix", null, 0, 1, BinaryBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(localBuildLocationEClass, LocalBuildLocation.class, "LocalBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLocalBuildLocation_Path(), ecorePackage.getEString(), "path", null, 1, 1, LocalBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(targetPlatformBuildLocationEClass, TargetPlatformBuildLocation.class, "TargetPlatformBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTargetPlatformBuildLocation_Path(), ecorePackage.getEString(), "path", null, 1, 1, TargetPlatformBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(updateSiteBuildLocationEClass, UpdateSiteBuildLocation.class, "UpdateSiteBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getUpdateSiteBuildLocation_Url(), ecorePackage.getEString(), "url", null, 1, 1, UpdateSiteBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resultStepBuildLocationEClass, ResultStepBuildLocation.class, "ResultStepBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResultStepBuildLocation_ResultStep(), this.getResultStep(), null, "resultStep", null, 1, 1, ResultStepBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(installStepBuildLocationEClass, InstallStepBuildLocation.class, "InstallStepBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInstallStepBuildLocation_InstallStep(), this.getInstallStep(), null, "installStep", null, 1, 1, InstallStepBuildLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(runningPlatformBuildLocationEClass, RunningPlatformBuildLocation.class, "RunningPlatformBuildLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getComponent_Name(), ecorePackage.getEString(), "name", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponent_BuildStep(), this.getBuildStep(), this.getBuildStep_Components(), "buildStep", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pluginEClass, Plugin.class, "Plugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(cleaN_TYPEEEnum, org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE.class, "CLEAN_TYPE");
        addEEnumLiteral(cleaN_TYPEEEnum, org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE.RESULT);
        addEEnumLiteral(cleaN_TYPEEEnum, org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE.WORKSPACE);
        addEEnumLiteral(cleaN_TYPEEEnum, org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE.NOTHING);
        addEEnumLiteral(cleaN_TYPEEEnum, org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE.TOOLS);
        addEEnumLiteral(cleaN_TYPEEEnum, org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE.ALL);

        // Create resource
        createResource(eNS_URI);
    }

} //BuildstepPackageImpl
