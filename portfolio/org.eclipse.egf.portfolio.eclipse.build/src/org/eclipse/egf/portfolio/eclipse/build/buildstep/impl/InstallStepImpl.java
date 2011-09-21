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
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getResultSteps <em>Result Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getUpdateSiteUrls <em>Update Site Urls</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.InstallStepImpl#getProductNames <em>Product Names</em>}</li>
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
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;


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

    public String getName() {

        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setName(String newName) {

        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.INSTALL_STEP__NAME, oldName, name));

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
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.INSTALL_STEP__NAME:
                return getName();
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
            case BuildstepPackage.INSTALL_STEP__NAME:
                setName((String)newValue);
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
            case BuildstepPackage.INSTALL_STEP__NAME:
                setName(NAME_EDEFAULT);
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
            case BuildstepPackage.INSTALL_STEP__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
        result.append(" (name: ");
        result.append(name);
        result.append(", profile: ");
        result.append(profile);
        result.append(", updateSiteUrls: ");
        result.append(updateSiteUrls);
        result.append(", featureNames: ");
        result.append(featureNames);
        result.append(", productNames: ");
        result.append(productNames);
        result.append(')');
        return result.toString();
    }


} //InstallStepImpl
