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

package org.eclipse.egf.portfolio.eclipse.build.buildstep;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage
 * @generated
 */
public interface BuildstepFactory extends EFactory {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BuildstepFactory eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Clean Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Clean Step</em>'.
     * @generated
     */
    CleanStep createCleanStep();

    /**
     * Returns a new object of class '<em>Update Site Build Location</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Update Site Build Location</em>'.
     * @generated
     */
	UpdateSiteBuildLocation createUpdateSiteBuildLocation();

	/**
     * Returns a new object of class '<em>Result Step Build Location</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Result Step Build Location</em>'.
     * @generated
     */
    ResultStepBuildLocation createResultStepBuildLocation();

    /**
     * Returns a new object of class '<em>Install Step Build Location</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Install Step Build Location</em>'.
     * @generated
     */
    InstallStepBuildLocation createInstallStepBuildLocation();

    /**
     * Returns a new object of class '<em>Running Platform Build Location</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Running Platform Build Location</em>'.
     * @generated
     */
    RunningPlatformBuildLocation createRunningPlatformBuildLocation();

    /**
     * Returns a new object of class '<em>Target Platform Build Location</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Target Platform Build Location</em>'.
     * @generated
     */
	TargetPlatformBuildLocation createTargetPlatformBuildLocation();

	/**
     * Returns a new object of class '<em>Local Build Location</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Local Build Location</em>'.
     * @generated
     */
	LocalBuildLocation createLocalBuildLocation();

	/**
     * Returns a new object of class '<em>Plugin</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Plugin</em>'.
     * @generated
     */
	Plugin createPlugin();

	/**
     * Returns a new object of class '<em>Feature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Feature</em>'.
     * @generated
     */
	Feature createFeature();

	/**
     * Returns a new object of class '<em>Javadoc Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Javadoc Step</em>'.
     * @generated
     */
	JavadocStep createJavadocStep();

	/**
     * Returns a new object of class '<em>EGF System Property</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>EGF System Property</em>'.
     * @generated
     */
    EGFSystemProperty createEGFSystemProperty();

    /**
     * Returns a new object of class '<em>Egf Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Egf Step</em>'.
     * @generated
     */
    EgfStep createEgfStep();

    /**
     * Returns a new object of class '<em>Egf Activity</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Egf Activity</em>'.
     * @generated
     */
    EgfActivity createEgfActivity();

    /**
     * Returns a new object of class '<em>Aggregate Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Aggregate Step</em>'.
     * @generated
     */
    AggregateStep createAggregateStep();

    /**
     * Returns a new object of class '<em>Install Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Install Step</em>'.
     * @generated
     */
    InstallStep createInstallStep();

    /**
     * Returns a new object of class '<em>Build Location Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Build Location Container</em>'.
     * @generated
     */
    BuildLocationContainer createBuildLocationContainer();

    /**
	 * Returns a new object of class '<em>Javadoc Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Javadoc Step</em>'.
	 * @generated NOT
	 */
	JavadocStep createJavadocStepFilled();

	/**
     * Returns a new object of class '<em>Build Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Build Step</em>'.
     * @generated
     */
	BuildStep createBuildStep();

	/**
     * Returns a new object of class '<em>Publish Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Publish Step</em>'.
     * @generated
     */
	PublishStep createPublishStep();

	/**
     * Returns a new object of class '<em>Test Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Test Step</em>'.
     * @generated
     */
	TestStep createTestStep();

	/**
     * Returns a new object of class '<em>Ant Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Ant Step</em>'.
     * @generated
     */
	AntStep createAntStep();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	BuildstepPackage getBuildstepPackage();

} //BuildstepFactory
