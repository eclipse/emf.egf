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

package org.eclipse.egf.portfolio.eclipse.build.buildtrigger;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.BuildtriggerFactory
 * @model kind="package"
 * @generated
 */
public interface BuildtriggerPackage extends EPackage {
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
    String eNAME = "buildtrigger";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/buildtrigger";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "buildtrigger";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuildtriggerPackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.BuildtriggerPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.CronTriggerImpl <em>Cron Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.CronTriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.BuildtriggerPackageImpl#getCronTrigger()
     * @generated
     */
    int CRON_TRIGGER = 0;

    /**
     * The feature id for the '<em><b>Planning</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TRIGGER__PLANNING = BuildcorePackage.TRIGGER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Cron Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TRIGGER_FEATURE_COUNT = BuildcorePackage.TRIGGER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.SCMTriggerImpl <em>SCM Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.SCMTriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.BuildtriggerPackageImpl#getSCMTrigger()
     * @generated
     */
    int SCM_TRIGGER = 1;

    /**
     * The feature id for the '<em><b>Planning</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_TRIGGER__PLANNING = BuildcorePackage.TRIGGER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>SCM Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_TRIGGER_FEATURE_COUNT = BuildcorePackage.TRIGGER_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger <em>Cron Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cron Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger
     * @generated
     */
    EClass getCronTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger#getPlanning <em>Planning</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Planning</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger#getPlanning()
     * @see #getCronTrigger()
     * @generated
     */
    EAttribute getCronTrigger_Planning();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger <em>SCM Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SCM Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger
     * @generated
     */
    EClass getSCMTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger#getPlanning <em>Planning</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Planning</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger#getPlanning()
     * @see #getSCMTrigger()
     * @generated
     */
    EAttribute getSCMTrigger_Planning();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuildtriggerFactory getBuildtriggerFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.CronTriggerImpl <em>Cron Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.CronTriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.BuildtriggerPackageImpl#getCronTrigger()
         * @generated
         */
        EClass CRON_TRIGGER = eINSTANCE.getCronTrigger();

        /**
         * The meta object literal for the '<em><b>Planning</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_TRIGGER__PLANNING = eINSTANCE.getCronTrigger_Planning();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.SCMTriggerImpl <em>SCM Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.SCMTriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.BuildtriggerPackageImpl#getSCMTrigger()
         * @generated
         */
        EClass SCM_TRIGGER = eINSTANCE.getSCMTrigger();

        /**
         * The meta object literal for the '<em><b>Planning</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCM_TRIGGER__PLANNING = eINSTANCE.getSCMTrigger_Planning();

    }

} //BuildtriggerPackage
