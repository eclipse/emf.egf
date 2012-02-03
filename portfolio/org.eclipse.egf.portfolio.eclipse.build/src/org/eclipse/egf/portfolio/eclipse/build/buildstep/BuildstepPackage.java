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

package org.eclipse.egf.portfolio.eclipse.build.buildstep;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepFactory
 * @model kind="package"
 * @generated
 */
public interface BuildstepPackage extends EPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "buildstep";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.1/buildstep";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "buildstep";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuildstepPackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepImpl <em>Result Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getResultStep()
     * @generated
     */
    int RESULT_STEP = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Result Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.CleanStepImpl <em>Clean Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.CleanStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getCleanStep()
     * @generated
     */
    int CLEAN_STEP = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLEAN_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLEAN_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLEAN_STEP__TYPE = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Clean Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLEAN_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl <em>Build Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getBuildStep()
     * @generated
     */
    int BUILD_STEP = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Build Locations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP__BUILD_LOCATIONS = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Components</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP__COMPONENTS = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>All Platforms</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP__ALL_PLATFORMS = BuildcorePackage.STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>No Builders Invocation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP__NO_BUILDERS_INVOCATION = BuildcorePackage.STEP_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Skip Components Regex</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP__SKIP_COMPONENTS_REGEX = BuildcorePackage.STEP_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Build Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl <em>Publish Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getPublishStep()
     * @generated
     */
    int PUBLISH_STEP = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PUBLISH_STEP__ID = RESULT_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PUBLISH_STEP__DESCRIPTION = RESULT_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Component</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PUBLISH_STEP__COMPONENT = RESULT_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Signing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PUBLISH_STEP__SIGNING = RESULT_STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Generate Sources</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PUBLISH_STEP__GENERATE_SOURCES = RESULT_STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Generate Dropins</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PUBLISH_STEP__GENERATE_DROPINS = RESULT_STEP_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Publish Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PUBLISH_STEP_FEATURE_COUNT = RESULT_STEP_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TestStepImpl <em>Test Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TestStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getTestStep()
     * @generated
     */
    int TEST_STEP = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEST_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEST_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Launch Configuration Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEST_STEP__LAUNCH_CONFIGURATION_PATH = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Code Coverage</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEST_STEP__CODE_COVERAGE = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Test Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEST_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AntStepImpl <em>Ant Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AntStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getAntStep()
     * @generated
     */
    int ANT_STEP = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Target Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_STEP__TARGET_NAME = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Xml</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_STEP__XML = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Run In Eclipse</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_STEP__RUN_IN_ECLIPSE = BuildcorePackage.STEP_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Ant Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl <em>Javadoc Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getJavadocStep()
     * @generated
     */
    int JAVADOC_STEP = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVADOC_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVADOC_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVADOC_STEP__SOURCES = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Includes</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVADOC_STEP__INCLUDES = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Excludes</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVADOC_STEP__EXCLUDES = BuildcorePackage.STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Links</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVADOC_STEP__LINKS = BuildcorePackage.STEP_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Javadoc Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVADOC_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EGFSystemPropertyImpl <em>EGF System Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EGFSystemPropertyImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getEGFSystemProperty()
     * @generated
     */
    int EGF_SYSTEM_PROPERTY = 7;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_SYSTEM_PROPERTY__KEY = BuildcorePackage.KEY_VALUE__KEY;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_SYSTEM_PROPERTY__VALUE = BuildcorePackage.KEY_VALUE__VALUE;

    /**
     * The number of structural features of the '<em>EGF System Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_SYSTEM_PROPERTY_FEATURE_COUNT = BuildcorePackage.KEY_VALUE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfStepImpl <em>Egf Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getEgfStep()
     * @generated
     */
    int EGF_STEP = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_STEP__PROPERTIES = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Egf Activities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_STEP__EGF_ACTIVITIES = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Egf Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfActivityImpl <em>Egf Activity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfActivityImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getEgfActivity()
     * @generated
     */
    int EGF_ACTIVITY = 9;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_ACTIVITY__URI = 0;

    /**
     * The number of structural features of the '<em>Egf Activity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_ACTIVITY_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AggregateStepImpl <em>Aggregate Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AggregateStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getAggregateStep()
     * @generated
     */
    int AGGREGATE_STEP = 10;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AGGREGATE_STEP__ID = RESULT_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AGGREGATE_STEP__DESCRIPTION = RESULT_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AGGREGATE_STEP__NAME = RESULT_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Publish Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AGGREGATE_STEP__PUBLISH_STEPS = RESULT_STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Update Site Urls</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AGGREGATE_STEP__UPDATE_SITE_URLS = RESULT_STEP_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Aggregate Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AGGREGATE_STEP_FEATURE_COUNT = RESULT_STEP_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl <em>Install Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getInstallStep()
     * @generated
     */
    int INSTALL_STEP = 11;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__NAME = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Profile</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__PROFILE = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Result Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__RESULT_STEPS = BuildcorePackage.STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Update Site Urls</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__UPDATE_SITE_URLS = BuildcorePackage.STEP_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__FEATURE_NAMES = BuildcorePackage.STEP_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Product Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__PRODUCT_NAMES = BuildcorePackage.STEP_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Install Result Steps Source Features</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES = BuildcorePackage.STEP_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Install Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 7;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildLocationImpl <em>Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getBuildLocation()
     * @generated
     */
    int BUILD_LOCATION = 12;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_LOCATION__PATTERN = 0;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_LOCATION__BUILD_STEP = 1;

    /**
     * The number of structural features of the '<em>Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUILD_LOCATION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.SourceBuildLocationImpl <em>Source Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.SourceBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getSourceBuildLocation()
     * @generated
     */
    int SOURCE_BUILD_LOCATION = 13;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_BUILD_LOCATION__PATTERN = BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_BUILD_LOCATION__BUILD_STEP = BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_BUILD_LOCATION__SUFFIX = BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Source Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_BUILD_LOCATION_FEATURE_COUNT = BUILD_LOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BinaryBuildLocationImpl <em>Binary Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BinaryBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getBinaryBuildLocation()
     * @generated
     */
    int BINARY_BUILD_LOCATION = 14;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BINARY_BUILD_LOCATION__PATTERN = BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BINARY_BUILD_LOCATION__BUILD_STEP = BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BINARY_BUILD_LOCATION__SUFFIX = BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Binary Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BINARY_BUILD_LOCATION_FEATURE_COUNT = BUILD_LOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.LocalBuildLocationImpl <em>Local Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.LocalBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getLocalBuildLocation()
     * @generated
     */
    int LOCAL_BUILD_LOCATION = 15;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_BUILD_LOCATION__PATTERN = SOURCE_BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_BUILD_LOCATION__BUILD_STEP = SOURCE_BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_BUILD_LOCATION__SUFFIX = SOURCE_BUILD_LOCATION__SUFFIX;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_BUILD_LOCATION__PATH = SOURCE_BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Local Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_BUILD_LOCATION_FEATURE_COUNT = SOURCE_BUILD_LOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TargetPlatformBuildLocationImpl <em>Target Platform Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TargetPlatformBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getTargetPlatformBuildLocation()
     * @generated
     */
    int TARGET_PLATFORM_BUILD_LOCATION = 16;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_PLATFORM_BUILD_LOCATION__PATTERN = BINARY_BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_PLATFORM_BUILD_LOCATION__BUILD_STEP = BINARY_BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_PLATFORM_BUILD_LOCATION__SUFFIX = BINARY_BUILD_LOCATION__SUFFIX;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_PLATFORM_BUILD_LOCATION__PATH = BINARY_BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Target Platform Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_PLATFORM_BUILD_LOCATION_FEATURE_COUNT = BINARY_BUILD_LOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.UpdateSiteBuildLocationImpl <em>Update Site Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.UpdateSiteBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getUpdateSiteBuildLocation()
     * @generated
     */
    int UPDATE_SITE_BUILD_LOCATION = 17;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_SITE_BUILD_LOCATION__PATTERN = BINARY_BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_SITE_BUILD_LOCATION__BUILD_STEP = BINARY_BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_SITE_BUILD_LOCATION__SUFFIX = BINARY_BUILD_LOCATION__SUFFIX;

    /**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_SITE_BUILD_LOCATION__URL = BINARY_BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Update Site Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_SITE_BUILD_LOCATION_FEATURE_COUNT = BINARY_BUILD_LOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepBuildLocationImpl <em>Result Step Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getResultStepBuildLocation()
     * @generated
     */
    int RESULT_STEP_BUILD_LOCATION = 18;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP_BUILD_LOCATION__PATTERN = BINARY_BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP_BUILD_LOCATION__BUILD_STEP = BINARY_BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP_BUILD_LOCATION__SUFFIX = BINARY_BUILD_LOCATION__SUFFIX;

    /**
     * The feature id for the '<em><b>Result Step</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP_BUILD_LOCATION__RESULT_STEP = BINARY_BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Result Step Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_STEP_BUILD_LOCATION_FEATURE_COUNT = BINARY_BUILD_LOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepBuildLocationImpl <em>Install Step Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getInstallStepBuildLocation()
     * @generated
     */
    int INSTALL_STEP_BUILD_LOCATION = 19;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP_BUILD_LOCATION__PATTERN = BINARY_BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP_BUILD_LOCATION__BUILD_STEP = BINARY_BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP_BUILD_LOCATION__SUFFIX = BINARY_BUILD_LOCATION__SUFFIX;

    /**
     * The feature id for the '<em><b>Install Step</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP_BUILD_LOCATION__INSTALL_STEP = BINARY_BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Install Step Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALL_STEP_BUILD_LOCATION_FEATURE_COUNT = BINARY_BUILD_LOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.RunningPlatformBuildLocationImpl <em>Running Platform Build Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.RunningPlatformBuildLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getRunningPlatformBuildLocation()
     * @generated
     */
    int RUNNING_PLATFORM_BUILD_LOCATION = 20;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RUNNING_PLATFORM_BUILD_LOCATION__PATTERN = BINARY_BUILD_LOCATION__PATTERN;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RUNNING_PLATFORM_BUILD_LOCATION__BUILD_STEP = BINARY_BUILD_LOCATION__BUILD_STEP;

    /**
     * The feature id for the '<em><b>Suffix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RUNNING_PLATFORM_BUILD_LOCATION__SUFFIX = BINARY_BUILD_LOCATION__SUFFIX;

    /**
     * The number of structural features of the '<em>Running Platform Build Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RUNNING_PLATFORM_BUILD_LOCATION_FEATURE_COUNT = BINARY_BUILD_LOCATION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ComponentImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getComponent()
     * @generated
     */
    int COMPONENT = 21;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__NAME = 0;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__BUILD_STEP = 1;

    /**
     * The number of structural features of the '<em>Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PluginImpl <em>Plugin</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PluginImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getPlugin()
     * @generated
     */
    int PLUGIN = 22;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN__NAME = COMPONENT__NAME;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN__BUILD_STEP = COMPONENT__BUILD_STEP;

    /**
     * The number of structural features of the '<em>Plugin</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.FeatureImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getFeature()
     * @generated
     */
    int FEATURE = 23;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__NAME = COMPONENT__NAME;

    /**
     * The feature id for the '<em><b>Build Step</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__BUILD_STEP = COMPONENT__BUILD_STEP;

    /**
     * The number of structural features of the '<em>Feature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE <em>CLEAN TYPE</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getCLEAN_TYPE()
     * @generated
     */
    int CLEAN_TYPE = 24;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep <em>Result Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Result Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep
     * @generated
     */
    EClass getResultStep();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep <em>Clean Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Clean Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep
     * @generated
     */
    EClass getCleanStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep#getType()
     * @see #getCleanStep()
     * @generated
     */
    EAttribute getCleanStep_Type();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep <em>Build Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Build Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep
     * @generated
     */
    EClass getBuildStep();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getBuildLocations <em>Build Locations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Build Locations</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getBuildLocations()
     * @see #getBuildStep()
     * @generated
     */
    EReference getBuildStep_BuildLocations();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Components</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getComponents()
     * @see #getBuildStep()
     * @generated
     */
    EReference getBuildStep_Components();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isAllPlatforms <em>All Platforms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>All Platforms</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isAllPlatforms()
     * @see #getBuildStep()
     * @generated
     */
    EAttribute getBuildStep_AllPlatforms();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isNoBuildersInvocation <em>No Builders Invocation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>No Builders Invocation</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isNoBuildersInvocation()
     * @see #getBuildStep()
     * @generated
     */
    EAttribute getBuildStep_NoBuildersInvocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getSkipComponentsRegex <em>Skip Components Regex</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Skip Components Regex</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getSkipComponentsRegex()
     * @see #getBuildStep()
     * @generated
     */
    EAttribute getBuildStep_SkipComponentsRegex();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep <em>Publish Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Publish Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep
     * @generated
     */
    EClass getPublishStep();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#getComponent <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Component</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#getComponent()
     * @see #getPublishStep()
     * @generated
     */
    EReference getPublishStep_Component();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isSigning <em>Signing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Signing</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isSigning()
     * @see #getPublishStep()
     * @generated
     */
    EAttribute getPublishStep_Signing();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isGenerateSources <em>Generate Sources</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generate Sources</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isGenerateSources()
     * @see #getPublishStep()
     * @generated
     */
    EAttribute getPublishStep_GenerateSources();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isGenerateDropins <em>Generate Dropins</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generate Dropins</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isGenerateDropins()
     * @see #getPublishStep()
     * @generated
     */
    EAttribute getPublishStep_GenerateDropins();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep <em>Test Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Test Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep
     * @generated
     */
    EClass getTestStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#getLaunchConfigurationPath <em>Launch Configuration Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Launch Configuration Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#getLaunchConfigurationPath()
     * @see #getTestStep()
     * @generated
     */
    EAttribute getTestStep_LaunchConfigurationPath();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#isCodeCoverage <em>Code Coverage</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Code Coverage</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#isCodeCoverage()
     * @see #getTestStep()
     * @generated
     */
    EAttribute getTestStep_CodeCoverage();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep <em>Ant Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ant Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep
     * @generated
     */
    EClass getAntStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getTargetName <em>Target Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getTargetName()
     * @see #getAntStep()
     * @generated
     */
    EAttribute getAntStep_TargetName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getXml <em>Xml</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xml</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getXml()
     * @see #getAntStep()
     * @generated
     */
    EAttribute getAntStep_Xml();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#isRunInEclipse <em>Run In Eclipse</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Run In Eclipse</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#isRunInEclipse()
     * @see #getAntStep()
     * @generated
     */
    EAttribute getAntStep_RunInEclipse();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep <em>Javadoc Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Javadoc Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep
     * @generated
     */
    EClass getJavadocStep();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getSources <em>Sources</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sources</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getSources()
     * @see #getJavadocStep()
     * @generated
     */
    EReference getJavadocStep_Sources();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getIncludes <em>Includes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Includes</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getIncludes()
     * @see #getJavadocStep()
     * @generated
     */
    EAttribute getJavadocStep_Includes();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getExcludes <em>Excludes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Excludes</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getExcludes()
     * @see #getJavadocStep()
     * @generated
     */
    EAttribute getJavadocStep_Excludes();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getLinks <em>Links</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Links</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getLinks()
     * @see #getJavadocStep()
     * @generated
     */
    EAttribute getJavadocStep_Links();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EGFSystemProperty <em>EGF System Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EGF System Property</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EGFSystemProperty
     * @generated
     */
    EClass getEGFSystemProperty();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep <em>Egf Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Egf Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep
     * @generated
     */
    EClass getEgfStep();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep#getEgfActivities <em>Egf Activities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Egf Activities</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep#getEgfActivities()
     * @see #getEgfStep()
     * @generated
     */
    EReference getEgfStep_EgfActivities();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep#getProperties()
     * @see #getEgfStep()
     * @generated
     */
    EReference getEgfStep_Properties();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity <em>Egf Activity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Egf Activity</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity
     * @generated
     */
    EClass getEgfActivity();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity#getUri()
     * @see #getEgfActivity()
     * @generated
     */
    EAttribute getEgfActivity_Uri();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep <em>Aggregate Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Aggregate Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep
     * @generated
     */
    EClass getAggregateStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getName()
     * @see #getAggregateStep()
     * @generated
     */
    EAttribute getAggregateStep_Name();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getPublishSteps <em>Publish Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Publish Steps</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getPublishSteps()
     * @see #getAggregateStep()
     * @generated
     */
    EReference getAggregateStep_PublishSteps();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getUpdateSiteUrls <em>Update Site Urls</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Update Site Urls</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getUpdateSiteUrls()
     * @see #getAggregateStep()
     * @generated
     */
    EAttribute getAggregateStep_UpdateSiteUrls();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep <em>Install Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Install Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep
     * @generated
     */
    EClass getInstallStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getName()
     * @see #getInstallStep()
     * @generated
     */
    EAttribute getInstallStep_Name();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProfile <em>Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Profile</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProfile()
     * @see #getInstallStep()
     * @generated
     */
    EAttribute getInstallStep_Profile();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getResultSteps <em>Result Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Result Steps</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getResultSteps()
     * @see #getInstallStep()
     * @generated
     */
    EReference getInstallStep_ResultSteps();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getUpdateSiteUrls <em>Update Site Urls</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Update Site Urls</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getUpdateSiteUrls()
     * @see #getInstallStep()
     * @generated
     */
    EAttribute getInstallStep_UpdateSiteUrls();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getFeatureNames <em>Feature Names</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Feature Names</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getFeatureNames()
     * @see #getInstallStep()
     * @generated
     */
    EAttribute getInstallStep_FeatureNames();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProductNames <em>Product Names</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Product Names</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProductNames()
     * @see #getInstallStep()
     * @generated
     */
    EAttribute getInstallStep_ProductNames();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#isInstallResultStepsSourceFeatures <em>Install Result Steps Source Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Install Result Steps Source Features</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#isInstallResultStepsSourceFeatures()
     * @see #getInstallStep()
     * @generated
     */
    EAttribute getInstallStep_InstallResultStepsSourceFeatures();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation <em>Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation
     * @generated
     */
    EClass getBuildLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getPattern()
     * @see #getBuildLocation()
     * @generated
     */
    EAttribute getBuildLocation_Pattern();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getBuildStep <em>Build Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Build Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getBuildStep()
     * @see #getBuildLocation()
     * @generated
     */
    EReference getBuildLocation_BuildStep();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation <em>Source Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Source Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation
     * @generated
     */
    EClass getSourceBuildLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation#getSuffix <em>Suffix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Suffix</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation#getSuffix()
     * @see #getSourceBuildLocation()
     * @generated
     */
    EAttribute getSourceBuildLocation_Suffix();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation <em>Binary Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Binary Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation
     * @generated
     */
    EClass getBinaryBuildLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation#getSuffix <em>Suffix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Suffix</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation#getSuffix()
     * @see #getBinaryBuildLocation()
     * @generated
     */
    EAttribute getBinaryBuildLocation_Suffix();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation <em>Local Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Local Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation
     * @generated
     */
    EClass getLocalBuildLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation#getPath <em>Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation#getPath()
     * @see #getLocalBuildLocation()
     * @generated
     */
    EAttribute getLocalBuildLocation_Path();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation <em>Target Platform Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Target Platform Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation
     * @generated
     */
    EClass getTargetPlatformBuildLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation#getPath <em>Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation#getPath()
     * @see #getTargetPlatformBuildLocation()
     * @generated
     */
    EAttribute getTargetPlatformBuildLocation_Path();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation <em>Update Site Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Update Site Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation
     * @generated
     */
    EClass getUpdateSiteBuildLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation#getUrl()
     * @see #getUpdateSiteBuildLocation()
     * @generated
     */
    EAttribute getUpdateSiteBuildLocation_Url();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation <em>Result Step Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Result Step Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation
     * @generated
     */
    EClass getResultStepBuildLocation();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation#getResultStep <em>Result Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Result Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation#getResultStep()
     * @see #getResultStepBuildLocation()
     * @generated
     */
    EReference getResultStepBuildLocation_ResultStep();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation <em>Install Step Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Install Step Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation
     * @generated
     */
    EClass getInstallStepBuildLocation();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation#getInstallStep <em>Install Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Install Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation#getInstallStep()
     * @see #getInstallStepBuildLocation()
     * @generated
     */
    EReference getInstallStepBuildLocation_InstallStep();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation <em>Running Platform Build Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Running Platform Build Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation
     * @generated
     */
    EClass getRunningPlatformBuildLocation();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Component</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Component
     * @generated
     */
    EClass getComponent();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getName()
     * @see #getComponent()
     * @generated
     */
    EAttribute getComponent_Name();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getBuildStep <em>Build Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Build Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getBuildStep()
     * @see #getComponent()
     * @generated
     */
    EReference getComponent_BuildStep();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin <em>Plugin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Plugin</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin
     * @generated
     */
    EClass getPlugin();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature
     * @generated
     */
    EClass getFeature();

    /**
     * Returns the meta object for enum '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE <em>CLEAN TYPE</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>CLEAN TYPE</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE
     * @generated
     */
    EEnum getCLEAN_TYPE();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuildstepFactory getBuildstepFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepImpl <em>Result Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getResultStep()
         * @generated
         */
        EClass RESULT_STEP = eINSTANCE.getResultStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.CleanStepImpl <em>Clean Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.CleanStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getCleanStep()
         * @generated
         */
        EClass CLEAN_STEP = eINSTANCE.getCleanStep();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLEAN_STEP__TYPE = eINSTANCE.getCleanStep_Type();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl <em>Build Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getBuildStep()
         * @generated
         */
        EClass BUILD_STEP = eINSTANCE.getBuildStep();

        /**
         * The meta object literal for the '<em><b>Build Locations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BUILD_STEP__BUILD_LOCATIONS = eINSTANCE.getBuildStep_BuildLocations();

        /**
         * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BUILD_STEP__COMPONENTS = eINSTANCE.getBuildStep_Components();

        /**
         * The meta object literal for the '<em><b>All Platforms</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUILD_STEP__ALL_PLATFORMS = eINSTANCE.getBuildStep_AllPlatforms();

        /**
         * The meta object literal for the '<em><b>No Builders Invocation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUILD_STEP__NO_BUILDERS_INVOCATION = eINSTANCE.getBuildStep_NoBuildersInvocation();

        /**
         * The meta object literal for the '<em><b>Skip Components Regex</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUILD_STEP__SKIP_COMPONENTS_REGEX = eINSTANCE.getBuildStep_SkipComponentsRegex();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl <em>Publish Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getPublishStep()
         * @generated
         */
        EClass PUBLISH_STEP = eINSTANCE.getPublishStep();

        /**
         * The meta object literal for the '<em><b>Component</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PUBLISH_STEP__COMPONENT = eINSTANCE.getPublishStep_Component();

        /**
         * The meta object literal for the '<em><b>Signing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PUBLISH_STEP__SIGNING = eINSTANCE.getPublishStep_Signing();

        /**
         * The meta object literal for the '<em><b>Generate Sources</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PUBLISH_STEP__GENERATE_SOURCES = eINSTANCE.getPublishStep_GenerateSources();

        /**
         * The meta object literal for the '<em><b>Generate Dropins</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PUBLISH_STEP__GENERATE_DROPINS = eINSTANCE.getPublishStep_GenerateDropins();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TestStepImpl <em>Test Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TestStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getTestStep()
         * @generated
         */
        EClass TEST_STEP = eINSTANCE.getTestStep();

        /**
         * The meta object literal for the '<em><b>Launch Configuration Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEST_STEP__LAUNCH_CONFIGURATION_PATH = eINSTANCE.getTestStep_LaunchConfigurationPath();

        /**
         * The meta object literal for the '<em><b>Code Coverage</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEST_STEP__CODE_COVERAGE = eINSTANCE.getTestStep_CodeCoverage();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AntStepImpl <em>Ant Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AntStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getAntStep()
         * @generated
         */
        EClass ANT_STEP = eINSTANCE.getAntStep();

        /**
         * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ANT_STEP__TARGET_NAME = eINSTANCE.getAntStep_TargetName();

        /**
         * The meta object literal for the '<em><b>Xml</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ANT_STEP__XML = eINSTANCE.getAntStep_Xml();

        /**
         * The meta object literal for the '<em><b>Run In Eclipse</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ANT_STEP__RUN_IN_ECLIPSE = eINSTANCE.getAntStep_RunInEclipse();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl <em>Javadoc Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getJavadocStep()
         * @generated
         */
        EClass JAVADOC_STEP = eINSTANCE.getJavadocStep();

        /**
         * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JAVADOC_STEP__SOURCES = eINSTANCE.getJavadocStep_Sources();

        /**
         * The meta object literal for the '<em><b>Includes</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JAVADOC_STEP__INCLUDES = eINSTANCE.getJavadocStep_Includes();

        /**
         * The meta object literal for the '<em><b>Excludes</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JAVADOC_STEP__EXCLUDES = eINSTANCE.getJavadocStep_Excludes();

        /**
         * The meta object literal for the '<em><b>Links</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JAVADOC_STEP__LINKS = eINSTANCE.getJavadocStep_Links();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EGFSystemPropertyImpl <em>EGF System Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EGFSystemPropertyImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getEGFSystemProperty()
         * @generated
         */
        EClass EGF_SYSTEM_PROPERTY = eINSTANCE.getEGFSystemProperty();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfStepImpl <em>Egf Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getEgfStep()
         * @generated
         */
        EClass EGF_STEP = eINSTANCE.getEgfStep();

        /**
         * The meta object literal for the '<em><b>Egf Activities</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EGF_STEP__EGF_ACTIVITIES = eINSTANCE.getEgfStep_EgfActivities();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EGF_STEP__PROPERTIES = eINSTANCE.getEgfStep_Properties();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfActivityImpl <em>Egf Activity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.EgfActivityImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getEgfActivity()
         * @generated
         */
        EClass EGF_ACTIVITY = eINSTANCE.getEgfActivity();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EGF_ACTIVITY__URI = eINSTANCE.getEgfActivity_Uri();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AggregateStepImpl <em>Aggregate Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AggregateStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getAggregateStep()
         * @generated
         */
        EClass AGGREGATE_STEP = eINSTANCE.getAggregateStep();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AGGREGATE_STEP__NAME = eINSTANCE.getAggregateStep_Name();

        /**
         * The meta object literal for the '<em><b>Publish Steps</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AGGREGATE_STEP__PUBLISH_STEPS = eINSTANCE.getAggregateStep_PublishSteps();

        /**
         * The meta object literal for the '<em><b>Update Site Urls</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AGGREGATE_STEP__UPDATE_SITE_URLS = eINSTANCE.getAggregateStep_UpdateSiteUrls();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl <em>Install Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getInstallStep()
         * @generated
         */
        EClass INSTALL_STEP = eINSTANCE.getInstallStep();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALL_STEP__NAME = eINSTANCE.getInstallStep_Name();

        /**
         * The meta object literal for the '<em><b>Profile</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALL_STEP__PROFILE = eINSTANCE.getInstallStep_Profile();

        /**
         * The meta object literal for the '<em><b>Result Steps</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INSTALL_STEP__RESULT_STEPS = eINSTANCE.getInstallStep_ResultSteps();

        /**
         * The meta object literal for the '<em><b>Update Site Urls</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALL_STEP__UPDATE_SITE_URLS = eINSTANCE.getInstallStep_UpdateSiteUrls();

        /**
         * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALL_STEP__FEATURE_NAMES = eINSTANCE.getInstallStep_FeatureNames();

        /**
         * The meta object literal for the '<em><b>Product Names</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALL_STEP__PRODUCT_NAMES = eINSTANCE.getInstallStep_ProductNames();

        /**
         * The meta object literal for the '<em><b>Install Result Steps Source Features</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES = eINSTANCE.getInstallStep_InstallResultStepsSourceFeatures();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildLocationImpl <em>Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getBuildLocation()
         * @generated
         */
        EClass BUILD_LOCATION = eINSTANCE.getBuildLocation();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUILD_LOCATION__PATTERN = eINSTANCE.getBuildLocation_Pattern();

        /**
         * The meta object literal for the '<em><b>Build Step</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BUILD_LOCATION__BUILD_STEP = eINSTANCE.getBuildLocation_BuildStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.SourceBuildLocationImpl <em>Source Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.SourceBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getSourceBuildLocation()
         * @generated
         */
        EClass SOURCE_BUILD_LOCATION = eINSTANCE.getSourceBuildLocation();

        /**
         * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOURCE_BUILD_LOCATION__SUFFIX = eINSTANCE.getSourceBuildLocation_Suffix();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BinaryBuildLocationImpl <em>Binary Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BinaryBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getBinaryBuildLocation()
         * @generated
         */
        EClass BINARY_BUILD_LOCATION = eINSTANCE.getBinaryBuildLocation();

        /**
         * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BINARY_BUILD_LOCATION__SUFFIX = eINSTANCE.getBinaryBuildLocation_Suffix();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.LocalBuildLocationImpl <em>Local Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.LocalBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getLocalBuildLocation()
         * @generated
         */
        EClass LOCAL_BUILD_LOCATION = eINSTANCE.getLocalBuildLocation();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LOCAL_BUILD_LOCATION__PATH = eINSTANCE.getLocalBuildLocation_Path();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TargetPlatformBuildLocationImpl <em>Target Platform Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TargetPlatformBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getTargetPlatformBuildLocation()
         * @generated
         */
        EClass TARGET_PLATFORM_BUILD_LOCATION = eINSTANCE.getTargetPlatformBuildLocation();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TARGET_PLATFORM_BUILD_LOCATION__PATH = eINSTANCE.getTargetPlatformBuildLocation_Path();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.UpdateSiteBuildLocationImpl <em>Update Site Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.UpdateSiteBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getUpdateSiteBuildLocation()
         * @generated
         */
        EClass UPDATE_SITE_BUILD_LOCATION = eINSTANCE.getUpdateSiteBuildLocation();

        /**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_SITE_BUILD_LOCATION__URL = eINSTANCE.getUpdateSiteBuildLocation_Url();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepBuildLocationImpl <em>Result Step Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ResultStepBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getResultStepBuildLocation()
         * @generated
         */
        EClass RESULT_STEP_BUILD_LOCATION = eINSTANCE.getResultStepBuildLocation();

        /**
         * The meta object literal for the '<em><b>Result Step</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESULT_STEP_BUILD_LOCATION__RESULT_STEP = eINSTANCE.getResultStepBuildLocation_ResultStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepBuildLocationImpl <em>Install Step Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getInstallStepBuildLocation()
         * @generated
         */
        EClass INSTALL_STEP_BUILD_LOCATION = eINSTANCE.getInstallStepBuildLocation();

        /**
         * The meta object literal for the '<em><b>Install Step</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INSTALL_STEP_BUILD_LOCATION__INSTALL_STEP = eINSTANCE.getInstallStepBuildLocation_InstallStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.RunningPlatformBuildLocationImpl <em>Running Platform Build Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.RunningPlatformBuildLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getRunningPlatformBuildLocation()
         * @generated
         */
        EClass RUNNING_PLATFORM_BUILD_LOCATION = eINSTANCE.getRunningPlatformBuildLocation();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ComponentImpl <em>Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.ComponentImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getComponent()
         * @generated
         */
        EClass COMPONENT = eINSTANCE.getComponent();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

        /**
         * The meta object literal for the '<em><b>Build Step</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT__BUILD_STEP = eINSTANCE.getComponent_BuildStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PluginImpl <em>Plugin</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PluginImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getPlugin()
         * @generated
         */
        EClass PLUGIN = eINSTANCE.getPlugin();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.FeatureImpl <em>Feature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.FeatureImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getFeature()
         * @generated
         */
        EClass FEATURE = eINSTANCE.getFeature();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE <em>CLEAN TYPE</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE
         * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildstepPackageImpl#getCLEAN_TYPE()
         * @generated
         */
        EEnum CLEAN_TYPE = eINSTANCE.getCLEAN_TYPE();

    }

} //BuildstepPackage
