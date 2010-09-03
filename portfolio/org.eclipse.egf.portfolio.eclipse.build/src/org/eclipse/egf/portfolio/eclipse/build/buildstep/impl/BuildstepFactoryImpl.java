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

import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.SCMBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildstepFactoryImpl extends EFactoryImpl implements BuildstepFactory {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static BuildstepFactory init() {
        try {
            BuildstepFactory theBuildstepFactory = (BuildstepFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/buildstep"); 
            if (theBuildstepFactory != null) {
                return theBuildstepFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BuildstepFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BuildstepFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case BuildstepPackage.CLEAN_STEP: return createCleanStep();
            case BuildstepPackage.BUILD_STEP: return createBuildStep();
            case BuildstepPackage.PUBLISH_STEP: return createPublishStep();
            case BuildstepPackage.TEST_STEP: return createTestStep();
            case BuildstepPackage.ANT_STEP: return createAntStep();
            case BuildstepPackage.JAVADOC_STEP: return createJavadocStep();
            case BuildstepPackage.EGF_STEP: return createEgfStep();
            case BuildstepPackage.AGGREGATE_STEP: return createAggregateStep();
            case BuildstepPackage.LOCAL_BUILD_LOCATION: return createLocalBuildLocation();
            case BuildstepPackage.SCM_BUILD_LOCATION: return createSCMBuildLocation();
            case BuildstepPackage.TARGET_PLATFORM_BUILD_LOCATION: return createTargetPlatformBuildLocation();
            case BuildstepPackage.UPDATE_SITE_BUILD_LOCATION: return createUpdateSiteBuildLocation();
            case BuildstepPackage.RESULT_STEP_BUILD_LOCATION: return createResultStepBuildLocation();
            case BuildstepPackage.PLUGIN: return createPlugin();
            case BuildstepPackage.FEATURE: return createFeature();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case BuildstepPackage.CLEAN_TYPE:
                return createCLEAN_TYPEFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case BuildstepPackage.CLEAN_TYPE:
                return convertCLEAN_TYPEToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CleanStep createCleanStep() {
        CleanStepImpl cleanStep = new CleanStepImpl();
        return cleanStep;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SCMBuildLocation createSCMBuildLocation() {
        SCMBuildLocationImpl scmBuildLocation = new SCMBuildLocationImpl();
        return scmBuildLocation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UpdateSiteBuildLocation createUpdateSiteBuildLocation() {
        UpdateSiteBuildLocationImpl updateSiteBuildLocation = new UpdateSiteBuildLocationImpl();
        return updateSiteBuildLocation;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResultStepBuildLocation createResultStepBuildLocation() {
        ResultStepBuildLocationImpl resultStepBuildLocation = new ResultStepBuildLocationImpl();
        return resultStepBuildLocation;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TargetPlatformBuildLocation createTargetPlatformBuildLocation() {
        TargetPlatformBuildLocationImpl targetPlatformBuildLocation = new TargetPlatformBuildLocationImpl();
        return targetPlatformBuildLocation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LocalBuildLocation createLocalBuildLocation() {
        LocalBuildLocationImpl localBuildLocation = new LocalBuildLocationImpl();
        return localBuildLocation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Plugin createPlugin() {
        PluginImpl plugin = new PluginImpl();
        return plugin;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Feature createFeature() {
        FeatureImpl feature = new FeatureImpl();
        return feature;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CLEAN_TYPE createCLEAN_TYPEFromString(EDataType eDataType, String initialValue) {
        CLEAN_TYPE result = CLEAN_TYPE.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertCLEAN_TYPEToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public JavadocStep createJavadocStep() {
        JavadocStepImpl javadocStep = new JavadocStepImpl();
        return javadocStep;
    }
	
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EgfStep createEgfStep() {
        EgfStepImpl egfStep = new EgfStepImpl();
        return egfStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AggregateStep createAggregateStep() {
        AggregateStepImpl aggregateStep = new AggregateStepImpl();
        return aggregateStep;
    }

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JavadocStep createJavadocStepFilled() {
		JavadocStepImpl javadocStep = new JavadocStepImpl();
		javadocStep.getLinks().add("http://download.oracle.com/javase/1.5.0/docs/api/"); //$NON-NLS-1$
        javadocStep.getLinks().add("http://www.osgi.org/javadoc/r4v42/"); //$NON-NLS-1$
        javadocStep.getLinks().add("http://download.eclipse.org/modeling/emf/emf/javadoc/2.5.0/"); //$NON-NLS-1$
        javadocStep.getLinks().add("http://help.eclipse.org/galileo/index.jsp?topic=/org.eclipse.platform.doc.isv/reference/api/"); //$NON-NLS-1$
		javadocStep.getIncludes().add("**/*.java"); //$NON-NLS-1$
		return javadocStep;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BuildStep createBuildStep() {
        BuildStepImpl buildStep = new BuildStepImpl();
        return buildStep;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PublishStep createPublishStep() {
        PublishStepImpl publishStep = new PublishStepImpl();
        return publishStep;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TestStep createTestStep() {
        TestStepImpl testStep = new TestStepImpl();
        return testStep;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AntStep createAntStep() {
        AntStepImpl antStep = new AntStepImpl();
        return antStep;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BuildstepPackage getBuildstepPackage() {
        return (BuildstepPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static BuildstepPackage getPackage() {
        return BuildstepPackage.eINSTANCE;
    }

} //BuildstepFactoryImpl
