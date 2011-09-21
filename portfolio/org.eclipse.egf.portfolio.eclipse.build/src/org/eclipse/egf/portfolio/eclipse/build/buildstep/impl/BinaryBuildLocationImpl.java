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

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Build Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BinaryBuildLocationImpl#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BinaryBuildLocationImpl extends BuildLocationImpl implements BinaryBuildLocation {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSuffix()
     * @generated
     * @ordered
     */
    protected static final String SUFFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSuffix()
     * @generated
     * @ordered
     */
    protected String suffix = SUFFIX_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BinaryBuildLocationImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.BINARY_BUILD_LOCATION;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getSuffix() {

        return suffix;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setSuffix(String newSuffix) {

        String oldSuffix = suffix;
        suffix = newSuffix;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.BINARY_BUILD_LOCATION__SUFFIX, oldSuffix, suffix));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.BINARY_BUILD_LOCATION__SUFFIX:
                return getSuffix();
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
            case BuildstepPackage.BINARY_BUILD_LOCATION__SUFFIX:
                setSuffix((String)newValue);
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
            case BuildstepPackage.BINARY_BUILD_LOCATION__SUFFIX:
                setSuffix(SUFFIX_EDEFAULT);
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
            case BuildstepPackage.BINARY_BUILD_LOCATION__SUFFIX:
                return SUFFIX_EDEFAULT == null ? suffix != null : !SUFFIX_EDEFAULT.equals(suffix);
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
        result.append(" (suffix: ");
        result.append(suffix);
        result.append(')');
        return result.toString();
    }


} //BinaryBuildLocationImpl
