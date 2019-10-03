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

package org.eclipse.egf.portfolio.eclipse.build.buildstep.impl;

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Install Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getResultSteps <em>Result Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getUpdateSiteUrls <em>Update Site Urls</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getProductNames <em>Product Names</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#isInstallResultStepsSourceFeatures <em>Install Result Steps Source Features</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getP2_os <em>P2 os</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getP2_ws <em>P2 ws</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getP2_arch <em>P2 arch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstallStepImpl extends StepImpl implements InstallStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;


    /**
     * The default value of the '{@link #getProfile() <em>Profile</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfile()
     * @generated
     * @ordered
     */
    protected static final String PROFILE_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getProfile() <em>Profile</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfile()
     * @generated
     * @ordered
     */
    protected String profile = PROFILE_EDEFAULT;


    /**
     * The cached value of the '{@link #getResultSteps() <em>Result Steps</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResultSteps()
     * @generated
     * @ordered
     */
    protected EList<ResultStep> resultSteps;




    /**
     * The cached value of the '{@link #getUpdateSiteUrls() <em>Update Site Urls</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpdateSiteUrls()
     * @generated
     * @ordered
     */
    protected EList<String> updateSiteUrls;


    /**
     * The cached value of the '{@link #getFeatureNames() <em>Feature Names</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatureNames()
     * @generated
     * @ordered
     */
    protected EList<String> featureNames;


    /**
     * The cached value of the '{@link #getProductNames() <em>Product Names</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProductNames()
     * @generated
     * @ordered
     */
    protected EList<String> productNames;


    /**
     * The default value of the '{@link #isInstallResultStepsSourceFeatures() <em>Install Result Steps Source Features</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInstallResultStepsSourceFeatures()
     * @generated
     * @ordered
     */
    protected static final boolean INSTALL_RESULT_STEPS_SOURCE_FEATURES_EDEFAULT = false;


    /**
     * The cached value of the '{@link #isInstallResultStepsSourceFeatures() <em>Install Result Steps Source Features</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInstallResultStepsSourceFeatures()
     * @generated
     * @ordered
     */
    protected boolean installResultStepsSourceFeatures = INSTALL_RESULT_STEPS_SOURCE_FEATURES_EDEFAULT;


    /**
     * The default value of the '{@link #getP2_os() <em>P2 os</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getP2_os()
     * @generated
     * @ordered
     */
    protected static final String P2_OS_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getP2_os() <em>P2 os</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getP2_os()
     * @generated
     * @ordered
     */
    protected String p2_os = P2_OS_EDEFAULT;


    /**
     * The default value of the '{@link #getP2_ws() <em>P2 ws</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getP2_ws()
     * @generated
     * @ordered
     */
    protected static final String P2_WS_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getP2_ws() <em>P2 ws</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getP2_ws()
     * @generated
     * @ordered
     */
    protected String p2_ws = P2_WS_EDEFAULT;


    /**
     * The default value of the '{@link #getP2_arch() <em>P2 arch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getP2_arch()
     * @generated
     * @ordered
     */
    protected static final String P2_ARCH_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getP2_arch() <em>P2 arch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getP2_arch()
     * @generated
     * @ordered
     */
    protected String p2_arch = P2_ARCH_EDEFAULT;


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InstallStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.INSTALL_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getId() {

        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setId(String newId) {

        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.INSTALL_STEP__ID, oldId, id));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getProfile() {

        return profile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setProfile(String newProfile) {

        String oldProfile = profile;
        profile = newProfile;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.INSTALL_STEP__PROFILE, oldProfile, profile));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<ResultStep> getResultSteps() {

        if (resultSteps == null) {
            resultSteps = new EObjectResolvingEList<ResultStep>(ResultStep.class, this, BuildstepPackage.INSTALL_STEP__RESULT_STEPS);
        }
        return resultSteps;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getUpdateSiteUrls() {

        if (updateSiteUrls == null) {
            updateSiteUrls = new EDataTypeUniqueEList<String>(String.class, this, BuildstepPackage.INSTALL_STEP__UPDATE_SITE_URLS);
        }
        return updateSiteUrls;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getFeatureNames() {

        if (featureNames == null) {
            featureNames = new EDataTypeUniqueEList<String>(String.class, this, BuildstepPackage.INSTALL_STEP__FEATURE_NAMES);
        }
        return featureNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getProductNames() {

        if (productNames == null) {
            productNames = new EDataTypeUniqueEList<String>(String.class, this, BuildstepPackage.INSTALL_STEP__PRODUCT_NAMES);
        }
        return productNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isInstallResultStepsSourceFeatures() {

        return installResultStepsSourceFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setInstallResultStepsSourceFeatures(boolean newInstallResultStepsSourceFeatures) {

        boolean oldInstallResultStepsSourceFeatures = installResultStepsSourceFeatures;
        installResultStepsSourceFeatures = newInstallResultStepsSourceFeatures;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES, oldInstallResultStepsSourceFeatures, installResultStepsSourceFeatures));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getP2_os() {

        return p2_os;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setP2_os(String newP2_os) {

        String oldP2_os = p2_os;
        p2_os = newP2_os;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.INSTALL_STEP__P2_OS, oldP2_os, p2_os));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getP2_ws() {

        return p2_ws;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setP2_ws(String newP2_ws) {

        String oldP2_ws = p2_ws;
        p2_ws = newP2_ws;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.INSTALL_STEP__P2_WS, oldP2_ws, p2_ws));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getP2_arch() {

        return p2_arch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setP2_arch(String newP2_arch) {

        String oldP2_arch = p2_arch;
        p2_arch = newP2_arch;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.INSTALL_STEP__P2_ARCH, oldP2_arch, p2_arch));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.INSTALL_STEP__ID:
                return getId();
            case BuildstepPackage.INSTALL_STEP__PROFILE:
                return getProfile();
            case BuildstepPackage.INSTALL_STEP__RESULT_STEPS:
                return getResultSteps();
            case BuildstepPackage.INSTALL_STEP__UPDATE_SITE_URLS:
                return getUpdateSiteUrls();
            case BuildstepPackage.INSTALL_STEP__FEATURE_NAMES:
                return getFeatureNames();
            case BuildstepPackage.INSTALL_STEP__PRODUCT_NAMES:
                return getProductNames();
            case BuildstepPackage.INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES:
                return isInstallResultStepsSourceFeatures();
            case BuildstepPackage.INSTALL_STEP__P2_OS:
                return getP2_os();
            case BuildstepPackage.INSTALL_STEP__P2_WS:
                return getP2_ws();
            case BuildstepPackage.INSTALL_STEP__P2_ARCH:
                return getP2_arch();
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
            case BuildstepPackage.INSTALL_STEP__ID:
                setId((String)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__PROFILE:
                setProfile((String)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__RESULT_STEPS:
                getResultSteps().clear();
                getResultSteps().addAll((Collection<? extends ResultStep>)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__UPDATE_SITE_URLS:
                getUpdateSiteUrls().clear();
                getUpdateSiteUrls().addAll((Collection<? extends String>)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__FEATURE_NAMES:
                getFeatureNames().clear();
                getFeatureNames().addAll((Collection<? extends String>)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__PRODUCT_NAMES:
                getProductNames().clear();
                getProductNames().addAll((Collection<? extends String>)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES:
                setInstallResultStepsSourceFeatures((Boolean)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__P2_OS:
                setP2_os((String)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__P2_WS:
                setP2_ws((String)newValue);
                return;
            case BuildstepPackage.INSTALL_STEP__P2_ARCH:
                setP2_arch((String)newValue);
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
            case BuildstepPackage.INSTALL_STEP__ID:
                setId(ID_EDEFAULT);
                return;
            case BuildstepPackage.INSTALL_STEP__PROFILE:
                setProfile(PROFILE_EDEFAULT);
                return;
            case BuildstepPackage.INSTALL_STEP__RESULT_STEPS:
                getResultSteps().clear();
                return;
            case BuildstepPackage.INSTALL_STEP__UPDATE_SITE_URLS:
                getUpdateSiteUrls().clear();
                return;
            case BuildstepPackage.INSTALL_STEP__FEATURE_NAMES:
                getFeatureNames().clear();
                return;
            case BuildstepPackage.INSTALL_STEP__PRODUCT_NAMES:
                getProductNames().clear();
                return;
            case BuildstepPackage.INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES:
                setInstallResultStepsSourceFeatures(INSTALL_RESULT_STEPS_SOURCE_FEATURES_EDEFAULT);
                return;
            case BuildstepPackage.INSTALL_STEP__P2_OS:
                setP2_os(P2_OS_EDEFAULT);
                return;
            case BuildstepPackage.INSTALL_STEP__P2_WS:
                setP2_ws(P2_WS_EDEFAULT);
                return;
            case BuildstepPackage.INSTALL_STEP__P2_ARCH:
                setP2_arch(P2_ARCH_EDEFAULT);
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
            case BuildstepPackage.INSTALL_STEP__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case BuildstepPackage.INSTALL_STEP__PROFILE:
                return PROFILE_EDEFAULT == null ? profile != null : !PROFILE_EDEFAULT.equals(profile);
            case BuildstepPackage.INSTALL_STEP__RESULT_STEPS:
                return resultSteps != null && !resultSteps.isEmpty();
            case BuildstepPackage.INSTALL_STEP__UPDATE_SITE_URLS:
                return updateSiteUrls != null && !updateSiteUrls.isEmpty();
            case BuildstepPackage.INSTALL_STEP__FEATURE_NAMES:
                return featureNames != null && !featureNames.isEmpty();
            case BuildstepPackage.INSTALL_STEP__PRODUCT_NAMES:
                return productNames != null && !productNames.isEmpty();
            case BuildstepPackage.INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES:
                return installResultStepsSourceFeatures != INSTALL_RESULT_STEPS_SOURCE_FEATURES_EDEFAULT;
            case BuildstepPackage.INSTALL_STEP__P2_OS:
                return P2_OS_EDEFAULT == null ? p2_os != null : !P2_OS_EDEFAULT.equals(p2_os);
            case BuildstepPackage.INSTALL_STEP__P2_WS:
                return P2_WS_EDEFAULT == null ? p2_ws != null : !P2_WS_EDEFAULT.equals(p2_ws);
            case BuildstepPackage.INSTALL_STEP__P2_ARCH:
                return P2_ARCH_EDEFAULT == null ? p2_arch != null : !P2_ARCH_EDEFAULT.equals(p2_arch);
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
        result.append(" (id: ");
        result.append(id);
        result.append(", profile: ");
        result.append(profile);
        result.append(", updateSiteUrls: ");
        result.append(updateSiteUrls);
        result.append(", featureNames: ");
        result.append(featureNames);
        result.append(", productNames: ");
        result.append(productNames);
        result.append(", installResultStepsSourceFeatures: ");
        result.append(installResultStepsSourceFeatures);
        result.append(", p2_os: ");
        result.append(p2_os);
        result.append(", p2_ws: ");
        result.append(p2_ws);
        result.append(", p2_arch: ");
        result.append(p2_arch);
        result.append(')');
        return result.toString();
    }


} //InstallStepImpl
