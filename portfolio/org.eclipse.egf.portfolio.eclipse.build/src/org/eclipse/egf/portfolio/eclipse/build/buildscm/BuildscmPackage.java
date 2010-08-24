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

package org.eclipse.egf.portfolio.eclipse.build.buildscm;

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
 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmFactory
 * @model kind="package"
 * @generated
 */
public interface BuildscmPackage extends EPackage {
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
    String eNAME = "buildscm";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/buildscm";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "buildscm";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuildscmPackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNImpl <em>SVN</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmPackageImpl#getSVN()
     * @generated
     */
    int SVN = 0;

    /**
     * The feature id for the '<em><b>Locations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN__LOCATIONS = BuildcorePackage.SCM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>SVN</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN_FEATURE_COUNT = BuildcorePackage.SCM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl <em>SVN Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmPackageImpl#getSVNLocation()
     * @generated
     */
    int SVN_LOCATION = 1;

    /**
     * The feature id for the '<em><b>Protocol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN_LOCATION__PROTOCOL = BuildcorePackage.SCM_LOCATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN_LOCATION__URL = BuildcorePackage.SCM_LOCATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Local Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN_LOCATION__LOCAL_PATH = BuildcorePackage.SCM_LOCATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN_LOCATION__USERNAME = BuildcorePackage.SCM_LOCATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN_LOCATION__PASSWORD = BuildcorePackage.SCM_LOCATION_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>SVN Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SVN_LOCATION_FEATURE_COUNT = BuildcorePackage.SCM_LOCATION_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol <em>SVN Protocol</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmPackageImpl#getSVNProtocol()
     * @generated
     */
    int SVN_PROTOCOL = 2;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN <em>SVN</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SVN</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN
     * @generated
     */
    EClass getSVN();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN#getLocations <em>Locations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Locations</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN#getLocations()
     * @see #getSVN()
     * @generated
     */
    EReference getSVN_Locations();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation <em>SVN Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SVN Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation
     * @generated
     */
    EClass getSVNLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Protocol</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getProtocol()
     * @see #getSVNLocation()
     * @generated
     */
    EAttribute getSVNLocation_Protocol();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getUrl()
     * @see #getSVNLocation()
     * @generated
     */
    EAttribute getSVNLocation_Url();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getLocalPath <em>Local Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getLocalPath()
     * @see #getSVNLocation()
     * @generated
     */
    EAttribute getSVNLocation_LocalPath();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getUsername <em>Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Username</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getUsername()
     * @see #getSVNLocation()
     * @generated
     */
    EAttribute getSVNLocation_Username();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation#getPassword()
     * @see #getSVNLocation()
     * @generated
     */
    EAttribute getSVNLocation_Password();

    /**
     * Returns the meta object for enum '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol <em>SVN Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>SVN Protocol</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol
     * @generated
     */
    EEnum getSVNProtocol();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuildscmFactory getBuildscmFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNImpl <em>SVN</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmPackageImpl#getSVN()
         * @generated
         */
        EClass SVN = eINSTANCE.getSVN();

        /**
         * The meta object literal for the '<em><b>Locations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SVN__LOCATIONS = eINSTANCE.getSVN_Locations();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl <em>SVN Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmPackageImpl#getSVNLocation()
         * @generated
         */
        EClass SVN_LOCATION = eINSTANCE.getSVNLocation();

        /**
         * The meta object literal for the '<em><b>Protocol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SVN_LOCATION__PROTOCOL = eINSTANCE.getSVNLocation_Protocol();

        /**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SVN_LOCATION__URL = eINSTANCE.getSVNLocation_Url();

        /**
         * The meta object literal for the '<em><b>Local Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SVN_LOCATION__LOCAL_PATH = eINSTANCE.getSVNLocation_LocalPath();

        /**
         * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SVN_LOCATION__USERNAME = eINSTANCE.getSVNLocation_Username();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SVN_LOCATION__PASSWORD = eINSTANCE.getSVNLocation_Password();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol <em>SVN Protocol</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol
         * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmPackageImpl#getSVNProtocol()
         * @generated
         */
        EEnum SVN_PROTOCOL = eINSTANCE.getSVNProtocol();

    }

} //BuildscmPackage
