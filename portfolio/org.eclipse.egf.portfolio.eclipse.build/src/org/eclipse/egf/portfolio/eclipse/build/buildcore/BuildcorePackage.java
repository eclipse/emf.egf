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

package org.eclipse.egf.portfolio.eclipse.build.buildcore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcoreFactory
 * @model kind="package"
 * @generated
 */
public interface BuildcorePackage extends EPackage {
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
    String eNAME = "buildcore";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/buildcore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "buildcore";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuildcorePackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItem()
     * @generated
     */
    int ITEM = 0;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__PROPERTIES = 0;

    /**
     * The number of structural features of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl <em>Chain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getChain()
     * @generated
     */
    int CHAIN = 1;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__PROPERTIES = ITEM__PROPERTIES;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__NAME = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__JOBS = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Chain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl <em>Job</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getJob()
     * @generated
     */
    int JOB = 2;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__PROPERTIES = ITEM__PROPERTIES;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__NAME = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__DESCRIPTION = ITEM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__STEPS = ITEM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Scms</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__SCMS = ITEM_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__TRIGGERS = ITEM_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__ENABLED = ITEM_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Job</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB_FEATURE_COUNT = ITEM_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl <em>Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStep()
     * @generated
     */
    int STEP = 3;

    /**
     * The feature id for the '<em><b>Job</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP__JOB = 0;

    /**
     * The number of structural features of the '<em>Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl <em>SCM</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCM()
     * @generated
     */
    int SCM = 4;

    /**
     * The number of structural features of the '<em>SCM</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMLocationImpl <em>SCM Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCMLocation()
     * @generated
     */
    int SCM_LOCATION = 5;

    /**
     * The number of structural features of the '<em>SCM Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_LOCATION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getProperty()
     * @generated
     */
    int PROPERTY = 6;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__VALUE = 1;

    /**
     * The number of structural features of the '<em>Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getTrigger()
     * @generated
     */
    int TRIGGER = 7;

    /**
     * The number of structural features of the '<em>Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_FEATURE_COUNT = 0;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item
     * @generated
     */
    EClass getItem();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getProperties()
     * @see #getItem()
     * @generated
     */
    EReference getItem_Properties();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain <em>Chain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Chain</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain
     * @generated
     */
    EClass getChain();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getName()
     * @see #getChain()
     * @generated
     */
    EAttribute getChain_Name();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getJobs <em>Jobs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jobs</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getJobs()
     * @see #getChain()
     * @generated
     */
    EReference getChain_Jobs();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job <em>Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Job</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job
     * @generated
     */
    EClass getJob();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getName()
     * @see #getJob()
     * @generated
     */
    EAttribute getJob_Name();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getDescription()
     * @see #getJob()
     * @generated
     */
    EAttribute getJob_Description();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getSteps <em>Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Steps</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getSteps()
     * @see #getJob()
     * @generated
     */
    EReference getJob_Steps();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms <em>Scms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Scms</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms()
     * @see #getJob()
     * @generated
     */
    EReference getJob_Scms();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getTriggers <em>Triggers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Triggers</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getTriggers()
     * @see #getJob()
     * @generated
     */
    EReference getJob_Triggers();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#isEnabled <em>Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enabled</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#isEnabled()
     * @see #getJob()
     * @generated
     */
    EAttribute getJob_Enabled();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step <em>Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Step
     * @generated
     */
    EClass getStep();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getJob <em>Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Job</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getJob()
     * @see #getStep()
     * @generated
     */
    EReference getStep_Job();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM <em>SCM</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SCM</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM
     * @generated
     */
    EClass getSCM();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.SCMLocation <em>SCM Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SCM Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.SCMLocation
     * @generated
     */
    EClass getSCMLocation();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Property
     * @generated
     */
    EClass getProperty();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Property#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Property#getKey()
     * @see #getProperty()
     * @generated
     */
    EAttribute getProperty_Key();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Property#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Property#getValue()
     * @see #getProperty()
     * @generated
     */
    EAttribute getProperty_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger
     * @generated
     */
    EClass getTrigger();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuildcoreFactory getBuildcoreFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl <em>Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItem()
         * @generated
         */
        EClass ITEM = eINSTANCE.getItem();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM__PROPERTIES = eINSTANCE.getItem_Properties();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl <em>Chain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getChain()
         * @generated
         */
        EClass CHAIN = eINSTANCE.getChain();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHAIN__NAME = eINSTANCE.getChain_Name();

        /**
         * The meta object literal for the '<em><b>Jobs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHAIN__JOBS = eINSTANCE.getChain_Jobs();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl <em>Job</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getJob()
         * @generated
         */
        EClass JOB = eINSTANCE.getJob();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JOB__NAME = eINSTANCE.getJob_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JOB__DESCRIPTION = eINSTANCE.getJob_Description();

        /**
         * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOB__STEPS = eINSTANCE.getJob_Steps();

        /**
         * The meta object literal for the '<em><b>Scms</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOB__SCMS = eINSTANCE.getJob_Scms();

        /**
         * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOB__TRIGGERS = eINSTANCE.getJob_Triggers();

        /**
         * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JOB__ENABLED = eINSTANCE.getJob_Enabled();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl <em>Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStep()
         * @generated
         */
        EClass STEP = eINSTANCE.getStep();

        /**
         * The meta object literal for the '<em><b>Job</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STEP__JOB = eINSTANCE.getStep_Job();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl <em>SCM</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCM()
         * @generated
         */
        EClass SCM = eINSTANCE.getSCM();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMLocationImpl <em>SCM Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCMLocation()
         * @generated
         */
        EClass SCM_LOCATION = eINSTANCE.getSCMLocation();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl <em>Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getProperty()
         * @generated
         */
        EClass PROPERTY = eINSTANCE.getProperty();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY__KEY = eINSTANCE.getProperty_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl <em>Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getTrigger()
         * @generated
         */
        EClass TRIGGER = eINSTANCE.getTrigger();

    }

} //BuildcorePackage
