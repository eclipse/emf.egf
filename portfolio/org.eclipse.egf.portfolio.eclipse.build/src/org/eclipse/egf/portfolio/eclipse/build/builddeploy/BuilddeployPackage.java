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

package org.eclipse.egf.portfolio.eclipse.build.builddeploy;

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
 * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployFactory
 * @model kind="package"
 * @generated
 */
public interface BuilddeployPackage extends EPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "builddeploy";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/builddeploy";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "builddeploy";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuilddeployPackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl <em>Hudson Deployment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getHudsonDeployment()
     * @generated
     */
    int HUDSON_DEPLOYMENT = 0;

    /**
     * The feature id for the '<em><b>Assigned Node</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__ASSIGNED_NODE = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Jdk Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__JDK_NAME = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Ant Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__ANT_NAME = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Build Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__BUILD_ID = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__ENABLED = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>User Deploy Server Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>User Deploy Job Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Users</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__USERS = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__TRIGGERS = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Generation Location</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT__GENERATION_LOCATION = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 9;

    /**
     * The number of structural features of the '<em>Hudson Deployment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUDSON_DEPLOYMENT_FEATURE_COUNT = BuildcorePackage.DEPLOYMENT_FEATURE_COUNT + 10;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.UserImpl <em>User</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.UserImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getUser()
     * @generated
     */
    int USER = 1;

    /**
     * The feature id for the '<em><b>Login</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LOGIN = 0;

    /**
     * The feature id for the '<em><b>Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__PERMISSION = 1;

    /**
     * The number of structural features of the '<em>User</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.TriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getTrigger()
     * @generated
     */
    int TRIGGER = 2;

    /**
     * The number of structural features of the '<em>Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.CronTriggerImpl <em>Cron Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.CronTriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getCronTrigger()
     * @generated
     */
    int CRON_TRIGGER = 3;

    /**
     * The feature id for the '<em><b>Planning</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TRIGGER__PLANNING = TRIGGER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Cron Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TRIGGER_FEATURE_COUNT = TRIGGER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.SCMTriggerImpl <em>SCM Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.SCMTriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getSCMTrigger()
     * @generated
     */
    int SCM_TRIGGER = 4;

    /**
     * The feature id for the '<em><b>Planning</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_TRIGGER__PLANNING = TRIGGER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>SCM Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_TRIGGER_FEATURE_COUNT = TRIGGER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.GenerationLocationImpl <em>Generation Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.GenerationLocationImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getGenerationLocation()
     * @generated
     */
    int GENERATION_LOCATION = 5;

    /**
     * The feature id for the '<em><b>Folder Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_LOCATION__FOLDER_NAME = 0;

    /**
     * The number of structural features of the '<em>Generation Location</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_LOCATION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType <em>Permission Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getPermissionType()
     * @generated
     */
    int PERMISSION_TYPE = 6;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment <em>Hudson Deployment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hudson Deployment</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment
     * @generated
     */
    EClass getHudsonDeployment();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAssignedNode <em>Assigned Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Assigned Node</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAssignedNode()
     * @see #getHudsonDeployment()
     * @generated
     */
    EAttribute getHudsonDeployment_AssignedNode();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getJdkName <em>Jdk Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jdk Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getJdkName()
     * @see #getHudsonDeployment()
     * @generated
     */
    EAttribute getHudsonDeployment_JdkName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAntName <em>Ant Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ant Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAntName()
     * @see #getHudsonDeployment()
     * @generated
     */
    EAttribute getHudsonDeployment_AntName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getBuildId <em>Build Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Build Id</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getBuildId()
     * @see #getHudsonDeployment()
     * @generated
     */
    EAttribute getHudsonDeployment_BuildId();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#isEnabled <em>Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enabled</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#isEnabled()
     * @see #getHudsonDeployment()
     * @generated
     */
    EAttribute getHudsonDeployment_Enabled();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployServerUrl <em>User Deploy Server Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>User Deploy Server Url</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployServerUrl()
     * @see #getHudsonDeployment()
     * @generated
     */
    EAttribute getHudsonDeployment_UserDeployServerUrl();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployJobName <em>User Deploy Job Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>User Deploy Job Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployJobName()
     * @see #getHudsonDeployment()
     * @generated
     */
    EAttribute getHudsonDeployment_UserDeployJobName();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUsers <em>Users</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Users</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUsers()
     * @see #getHudsonDeployment()
     * @generated
     */
    EReference getHudsonDeployment_Users();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getTriggers <em>Triggers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Triggers</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getTriggers()
     * @see #getHudsonDeployment()
     * @generated
     */
    EReference getHudsonDeployment_Triggers();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getGenerationLocation <em>Generation Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Generation Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getGenerationLocation()
     * @see #getHudsonDeployment()
     * @generated
     */
    EReference getHudsonDeployment_GenerationLocation();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User <em>User</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>User</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.User
     * @generated
     */
    EClass getUser();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getLogin <em>Login</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Login</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getLogin()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Login();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getPermission <em>Permission</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Permission</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getPermission()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Permission();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.Trigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.Trigger
     * @generated
     */
    EClass getTrigger();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.CronTrigger <em>Cron Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cron Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.CronTrigger
     * @generated
     */
    EClass getCronTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.CronTrigger#getPlanning <em>Planning</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Planning</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.CronTrigger#getPlanning()
     * @see #getCronTrigger()
     * @generated
     */
    EAttribute getCronTrigger_Planning();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.SCMTrigger <em>SCM Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SCM Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.SCMTrigger
     * @generated
     */
    EClass getSCMTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.SCMTrigger#getPlanning <em>Planning</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Planning</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.SCMTrigger#getPlanning()
     * @see #getSCMTrigger()
     * @generated
     */
    EAttribute getSCMTrigger_Planning();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation <em>Generation Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generation Location</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation
     * @generated
     */
    EClass getGenerationLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation#getFolderName <em>Folder Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Folder Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation#getFolderName()
     * @see #getGenerationLocation()
     * @generated
     */
    EAttribute getGenerationLocation_FolderName();

    /**
     * Returns the meta object for enum '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType <em>Permission Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Permission Type</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType
     * @generated
     */
    EEnum getPermissionType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuilddeployFactory getBuilddeployFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl <em>Hudson Deployment</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getHudsonDeployment()
         * @generated
         */
        EClass HUDSON_DEPLOYMENT = eINSTANCE.getHudsonDeployment();

        /**
         * The meta object literal for the '<em><b>Assigned Node</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUDSON_DEPLOYMENT__ASSIGNED_NODE = eINSTANCE.getHudsonDeployment_AssignedNode();

        /**
         * The meta object literal for the '<em><b>Jdk Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUDSON_DEPLOYMENT__JDK_NAME = eINSTANCE.getHudsonDeployment_JdkName();

        /**
         * The meta object literal for the '<em><b>Ant Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUDSON_DEPLOYMENT__ANT_NAME = eINSTANCE.getHudsonDeployment_AntName();

        /**
         * The meta object literal for the '<em><b>Build Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUDSON_DEPLOYMENT__BUILD_ID = eINSTANCE.getHudsonDeployment_BuildId();

        /**
         * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUDSON_DEPLOYMENT__ENABLED = eINSTANCE.getHudsonDeployment_Enabled();

        /**
         * The meta object literal for the '<em><b>User Deploy Server Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL = eINSTANCE.getHudsonDeployment_UserDeployServerUrl();

        /**
         * The meta object literal for the '<em><b>User Deploy Job Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME = eINSTANCE.getHudsonDeployment_UserDeployJobName();

        /**
         * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUDSON_DEPLOYMENT__USERS = eINSTANCE.getHudsonDeployment_Users();

        /**
         * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUDSON_DEPLOYMENT__TRIGGERS = eINSTANCE.getHudsonDeployment_Triggers();

        /**
         * The meta object literal for the '<em><b>Generation Location</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUDSON_DEPLOYMENT__GENERATION_LOCATION = eINSTANCE.getHudsonDeployment_GenerationLocation();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.UserImpl <em>User</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.UserImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getUser()
         * @generated
         */
        EClass USER = eINSTANCE.getUser();

        /**
         * The meta object literal for the '<em><b>Login</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LOGIN = eINSTANCE.getUser_Login();

        /**
         * The meta object literal for the '<em><b>Permission</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__PERMISSION = eINSTANCE.getUser_Permission();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.TriggerImpl <em>Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.TriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getTrigger()
         * @generated
         */
        EClass TRIGGER = eINSTANCE.getTrigger();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.CronTriggerImpl <em>Cron Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.CronTriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getCronTrigger()
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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.SCMTriggerImpl <em>SCM Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.SCMTriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getSCMTrigger()
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

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.GenerationLocationImpl <em>Generation Location</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.GenerationLocationImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getGenerationLocation()
         * @generated
         */
        EClass GENERATION_LOCATION = eINSTANCE.getGenerationLocation();

        /**
         * The meta object literal for the '<em><b>Folder Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERATION_LOCATION__FOLDER_NAME = eINSTANCE.getGenerationLocation_FolderName();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType <em>Permission Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType
         * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.BuilddeployPackageImpl#getPermissionType()
         * @generated
         */
        EEnum PERMISSION_TYPE = eINSTANCE.getPermissionType();

    }

} //BuilddeployPackage
