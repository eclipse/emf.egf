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

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Build Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildLocationImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildLocationImpl#getBuildStep <em>Build Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BuildLocationImpl extends EObjectImpl implements BuildLocation {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected static final String PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected String pattern = PATTERN_EDEFAULT;






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildLocationImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.BUILD_LOCATION;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getPattern() {

        return pattern;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setPattern(String newPattern) {

        String oldPattern = pattern;
        pattern = newPattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.BUILD_LOCATION__PATTERN, oldPattern, pattern));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public BuildStep getBuildStep() {

        if (eContainerFeatureID() != BuildstepPackage.BUILD_LOCATION__BUILD_STEP) return null;
        return (BuildStep)eContainer();
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public NotificationChain basicSetBuildStep(BuildStep newBuildStep, NotificationChain msgs) {

        msgs = eBasicSetContainer((InternalEObject)newBuildStep, BuildstepPackage.BUILD_LOCATION__BUILD_STEP, msgs);

        return msgs;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setBuildStep(BuildStep newBuildStep) {

        if (newBuildStep != eInternalContainer() || (eContainerFeatureID() != BuildstepPackage.BUILD_LOCATION__BUILD_STEP && newBuildStep != null)) {
            if (EcoreUtil.isAncestor(this, newBuildStep))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newBuildStep != null)
                msgs = ((InternalEObject)newBuildStep).eInverseAdd(this, BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS, BuildStep.class, msgs);
            msgs = basicSetBuildStep(newBuildStep, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.BUILD_LOCATION__BUILD_STEP, newBuildStep, newBuildStep));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildstepPackage.BUILD_LOCATION__BUILD_STEP:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetBuildStep((BuildStep)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildstepPackage.BUILD_LOCATION__BUILD_STEP:
                return basicSetBuildStep(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case BuildstepPackage.BUILD_LOCATION__BUILD_STEP:
                return eInternalContainer().eInverseRemove(this, BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS, BuildStep.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.BUILD_LOCATION__PATTERN:
                return getPattern();
            case BuildstepPackage.BUILD_LOCATION__BUILD_STEP:
                return getBuildStep();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BuildstepPackage.BUILD_LOCATION__PATTERN:
                setPattern((String)newValue);
                return;
            case BuildstepPackage.BUILD_LOCATION__BUILD_STEP:
                setBuildStep((BuildStep)newValue);
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
            case BuildstepPackage.BUILD_LOCATION__PATTERN:
                setPattern(PATTERN_EDEFAULT);
                return;
            case BuildstepPackage.BUILD_LOCATION__BUILD_STEP:
                setBuildStep((BuildStep)null);
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
            case BuildstepPackage.BUILD_LOCATION__PATTERN:
                return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
            case BuildstepPackage.BUILD_LOCATION__BUILD_STEP:
                return getBuildStep() != null;
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
        result.append(" (pattern: ");
        result.append(pattern);
        result.append(')');
        return result.toString();
    }


} //BuildLocationImpl
