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

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.DeploymentImpl;

import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.Trigger;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.User;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hudson Deployment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getAssignedNode <em>Assigned Node</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getJdkName <em>Jdk Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getAntName <em>Ant Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getUserDeployServerUrl <em>User Deploy Server Url</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getUserDeployJobName <em>User Deploy Job Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.HudsonDeploymentImpl#getGenerationLocation <em>Generation Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HudsonDeploymentImpl extends DeploymentImpl implements HudsonDeployment {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getAssignedNode() <em>Assigned Node</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAssignedNode()
     * @generated
     * @ordered
     */
    protected static final String ASSIGNED_NODE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAssignedNode() <em>Assigned Node</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAssignedNode()
     * @generated
     * @ordered
     */
    protected String assignedNode = ASSIGNED_NODE_EDEFAULT;




    /**
     * The default value of the '{@link #getJdkName() <em>Jdk Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJdkName()
     * @generated
     * @ordered
     */
    protected static final String JDK_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getJdkName() <em>Jdk Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJdkName()
     * @generated
     * @ordered
     */
    protected String jdkName = JDK_NAME_EDEFAULT;




    /**
     * The default value of the '{@link #getAntName() <em>Ant Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAntName()
     * @generated
     * @ordered
     */
    protected static final String ANT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAntName() <em>Ant Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAntName()
     * @generated
     * @ordered
     */
    protected String antName = ANT_NAME_EDEFAULT;




    /**
     * The default value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuildId()
     * @generated
     * @ordered
     */
    protected static final String BUILD_ID_EDEFAULT = "yyyyMMdd-HHmm";


    /**
     * The cached value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuildId()
     * @generated
     * @ordered
     */
    protected String buildId = BUILD_ID_EDEFAULT;


    /**
     * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLED_EDEFAULT = true;


    /**
     * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected boolean enabled = ENABLED_EDEFAULT;


    /**
     * The default value of the '{@link #getUserDeployServerUrl() <em>User Deploy Server Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUserDeployServerUrl()
     * @generated
     * @ordered
     */
    protected static final String USER_DEPLOY_SERVER_URL_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getUserDeployServerUrl() <em>User Deploy Server Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUserDeployServerUrl()
     * @generated
     * @ordered
     */
    protected String userDeployServerUrl = USER_DEPLOY_SERVER_URL_EDEFAULT;


    /**
     * The default value of the '{@link #getUserDeployJobName() <em>User Deploy Job Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUserDeployJobName()
     * @generated
     * @ordered
     */
    protected static final String USER_DEPLOY_JOB_NAME_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getUserDeployJobName() <em>User Deploy Job Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUserDeployJobName()
     * @generated
     * @ordered
     */
    protected String userDeployJobName = USER_DEPLOY_JOB_NAME_EDEFAULT;


    /**
     * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsers()
     * @generated
     * @ordered
     */
    protected EList<User> users;




    /**
     * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTriggers()
     * @generated
     * @ordered
     */
    protected EList<Trigger> triggers;




    /**
     * The cached value of the '{@link #getGenerationLocation() <em>Generation Location</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenerationLocation()
     * @generated
     * @ordered
     */
    protected GenerationLocation generationLocation;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HudsonDeploymentImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuilddeployPackage.Literals.HUDSON_DEPLOYMENT;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getAssignedNode() {

        return assignedNode;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setAssignedNode(String newAssignedNode) {

        String oldAssignedNode = assignedNode;
        assignedNode = newAssignedNode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__ASSIGNED_NODE, oldAssignedNode, assignedNode));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getJdkName() {

        return jdkName;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setJdkName(String newJdkName) {

        String oldJdkName = jdkName;
        jdkName = newJdkName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__JDK_NAME, oldJdkName, jdkName));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getAntName() {

        return antName;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setAntName(String newAntName) {

        String oldAntName = antName;
        antName = newAntName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__ANT_NAME, oldAntName, antName));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getBuildId() {

        return buildId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setBuildId(String newBuildId) {

        String oldBuildId = buildId;
        buildId = newBuildId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__BUILD_ID, oldBuildId, buildId));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isEnabled() {

        return enabled;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setEnabled(boolean newEnabled) {

        boolean oldEnabled = enabled;
        enabled = newEnabled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__ENABLED, oldEnabled, enabled));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getUserDeployServerUrl() {

        return userDeployServerUrl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setUserDeployServerUrl(String newUserDeployServerUrl) {

        String oldUserDeployServerUrl = userDeployServerUrl;
        userDeployServerUrl = newUserDeployServerUrl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL, oldUserDeployServerUrl, userDeployServerUrl));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getUserDeployJobName() {

        return userDeployJobName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setUserDeployJobName(String newUserDeployJobName) {

        String oldUserDeployJobName = userDeployJobName;
        userDeployJobName = newUserDeployJobName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME, oldUserDeployJobName, userDeployJobName));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<User> getUsers() {

        if (users == null) {
            users = new EObjectContainmentEList.Resolving<User>(User.class, this, BuilddeployPackage.HUDSON_DEPLOYMENT__USERS);
        }
        return users;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<Trigger> getTriggers() {

        if (triggers == null) {
            triggers = new EObjectContainmentEList.Resolving<Trigger>(Trigger.class, this, BuilddeployPackage.HUDSON_DEPLOYMENT__TRIGGERS);
        }
        return triggers;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public GenerationLocation getGenerationLocation() {

        if (generationLocation != null && generationLocation.eIsProxy()) {
            InternalEObject oldGenerationLocation = (InternalEObject)generationLocation;
            generationLocation = (GenerationLocation)eResolveProxy(oldGenerationLocation);
            if (generationLocation != oldGenerationLocation) {
                InternalEObject newGenerationLocation = (InternalEObject)generationLocation;
                NotificationChain msgs = oldGenerationLocation.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION, null, null);
                if (newGenerationLocation.eInternalContainer() == null) {
                    msgs = newGenerationLocation.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION, oldGenerationLocation, generationLocation));
            }
        }
        return generationLocation;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public GenerationLocation basicGetGenerationLocation() {

        return generationLocation;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public NotificationChain basicSetGenerationLocation(GenerationLocation newGenerationLocation, NotificationChain msgs) {

        GenerationLocation oldGenerationLocation = generationLocation;
        generationLocation = newGenerationLocation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION, oldGenerationLocation, newGenerationLocation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }

        return msgs;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setGenerationLocation(GenerationLocation newGenerationLocation) {

        if (newGenerationLocation != generationLocation) {
            NotificationChain msgs = null;
            if (generationLocation != null)
                msgs = ((InternalEObject)generationLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION, null, msgs);
            if (newGenerationLocation != null)
                msgs = ((InternalEObject)newGenerationLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION, null, msgs);
            msgs = basicSetGenerationLocation(newGenerationLocation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION, newGenerationLocation, newGenerationLocation));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USERS:
                return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__TRIGGERS:
                return ((InternalEList<?>)getTriggers()).basicRemove(otherEnd, msgs);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION:
                return basicSetGenerationLocation(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ASSIGNED_NODE:
                return getAssignedNode();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__JDK_NAME:
                return getJdkName();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ANT_NAME:
                return getAntName();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__BUILD_ID:
                return getBuildId();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ENABLED:
                return isEnabled();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL:
                return getUserDeployServerUrl();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME:
                return getUserDeployJobName();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USERS:
                return getUsers();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__TRIGGERS:
                return getTriggers();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION:
                if (resolve) return getGenerationLocation();
                return basicGetGenerationLocation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ASSIGNED_NODE:
                setAssignedNode((String)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__JDK_NAME:
                setJdkName((String)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ANT_NAME:
                setAntName((String)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__BUILD_ID:
                setBuildId((String)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ENABLED:
                setEnabled((Boolean)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL:
                setUserDeployServerUrl((String)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME:
                setUserDeployJobName((String)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USERS:
                getUsers().clear();
                getUsers().addAll((Collection<? extends User>)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__TRIGGERS:
                getTriggers().clear();
                getTriggers().addAll((Collection<? extends Trigger>)newValue);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION:
                setGenerationLocation((GenerationLocation)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ASSIGNED_NODE:
                setAssignedNode(ASSIGNED_NODE_EDEFAULT);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__JDK_NAME:
                setJdkName(JDK_NAME_EDEFAULT);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ANT_NAME:
                setAntName(ANT_NAME_EDEFAULT);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__BUILD_ID:
                setBuildId(BUILD_ID_EDEFAULT);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ENABLED:
                setEnabled(ENABLED_EDEFAULT);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL:
                setUserDeployServerUrl(USER_DEPLOY_SERVER_URL_EDEFAULT);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME:
                setUserDeployJobName(USER_DEPLOY_JOB_NAME_EDEFAULT);
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USERS:
                getUsers().clear();
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__TRIGGERS:
                getTriggers().clear();
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION:
                setGenerationLocation((GenerationLocation)null);
                return;
        }
        super.eUnset(featureID);
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ASSIGNED_NODE:
                return ASSIGNED_NODE_EDEFAULT == null ? assignedNode != null : !ASSIGNED_NODE_EDEFAULT.equals(assignedNode);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__JDK_NAME:
                return JDK_NAME_EDEFAULT == null ? jdkName != null : !JDK_NAME_EDEFAULT.equals(jdkName);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ANT_NAME:
                return ANT_NAME_EDEFAULT == null ? antName != null : !ANT_NAME_EDEFAULT.equals(antName);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__BUILD_ID:
                return BUILD_ID_EDEFAULT == null ? buildId != null : !BUILD_ID_EDEFAULT.equals(buildId);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ENABLED:
                return enabled != ENABLED_EDEFAULT;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL:
                return USER_DEPLOY_SERVER_URL_EDEFAULT == null ? userDeployServerUrl != null : !USER_DEPLOY_SERVER_URL_EDEFAULT.equals(userDeployServerUrl);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME:
                return USER_DEPLOY_JOB_NAME_EDEFAULT == null ? userDeployJobName != null : !USER_DEPLOY_JOB_NAME_EDEFAULT.equals(userDeployJobName);
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USERS:
                return users != null && !users.isEmpty();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__TRIGGERS:
                return triggers != null && !triggers.isEmpty();
            case BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION:
                return generationLocation != null;
        }
        return super.eIsSet(featureID);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (assignedNode: ");
        result.append(assignedNode);
        result.append(", jdkName: ");
        result.append(jdkName);
        result.append(", antName: ");
        result.append(antName);
        result.append(", buildId: ");
        result.append(buildId);
        result.append(", enabled: ");
        result.append(enabled);
        result.append(", userDeployServerUrl: ");
        result.append(userDeployServerUrl);
        result.append(", userDeployJobName: ");
        result.append(userDeployJobName);
        result.append(')');
        return result.toString();
    }


} //HudsonDeploymentImpl
