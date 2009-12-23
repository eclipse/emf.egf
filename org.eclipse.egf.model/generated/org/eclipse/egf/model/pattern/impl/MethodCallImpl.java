/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.MethodCallImpl#getCalled <em>Called</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodCallImpl extends CallImpl implements MethodCall {
    /**
     * The cached value of the '{@link #getCalled() <em>Called</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCalled()
     * @generated
     * @ordered
     */
    protected PatternMethod called;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MethodCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.METHOD_CALL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PatternMethod getCalled() {
        if (called != null && called.eIsProxy()) {
            InternalEObject oldCalled = (InternalEObject) called;
            called = (PatternMethod) eResolveProxy(oldCalled);
            if (called != oldCalled) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.METHOD_CALL__CALLED, oldCalled, called));
            }
        }
        return called;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PatternMethod basicGetCalled() {
        return called;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCalled(PatternMethod newCalled) {
        PatternMethod oldCalled = called;
        called = newCalled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.METHOD_CALL__CALLED, oldCalled, called));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.METHOD_CALL__CALLED:
            if (resolve)
                return getCalled();
            return basicGetCalled();
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
        case PatternPackage.METHOD_CALL__CALLED:
            setCalled((PatternMethod) newValue);
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
        case PatternPackage.METHOD_CALL__CALLED:
            setCalled((PatternMethod) null);
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
        case PatternPackage.METHOD_CALL__CALLED:
            return called != null;
        }
        return super.eIsSet(featureID);
    }

} //MethodCallImpl
