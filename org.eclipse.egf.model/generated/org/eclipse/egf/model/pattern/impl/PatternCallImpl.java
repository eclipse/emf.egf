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

import org.eclipse.egf.model.pattern.Pattern;
import java.util.Collection;
import java.util.Map;

import java.util.Map.Entry;

import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.egf.model.pattern.PatternParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternCallImpl#getParameterMatching <em>Parameter Matching</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternCallImpl#getCalled <em>Called</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternCallImpl extends CallImpl implements PatternCall {
    /**
     * The cached value of the '{@link #getParameterMatching() <em>Parameter Matching</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameterMatching()
     * @generated
     * @ordered
     */
    protected EMap<PatternParameter, PatternParameter> parameterMatching;

    /**
     * The cached value of the '{@link #getCalled() <em>Called</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCalled()
     * @generated
     * @ordered
     */
    protected Pattern called;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PatternCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.PATTERN_CALL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<PatternParameter, PatternParameter> getParameterMatching() {
        if (parameterMatching == null) {
            parameterMatching = new EcoreEMap<PatternParameter, PatternParameter>(PatternPackage.Literals.PARAMERTER2_PARAMETER_MAP, Paramerter2ParameterMapImpl.class, this, PatternPackage.PATTERN_CALL__PARAMETER_MATCHING);
        }
        return parameterMatching;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getCalled() {
        if (called != null && called.eIsProxy()) {
            InternalEObject oldCalled = (InternalEObject) called;
            called = (Pattern) eResolveProxy(oldCalled);
            if (called != oldCalled) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.PATTERN_CALL__CALLED, oldCalled, called));
            }
        }
        return called;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern basicGetCalled() {
        return called;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCalled(Pattern newCalled) {
        Pattern oldCalled = called;
        called = newCalled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_CALL__CALLED, oldCalled, called));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case PatternPackage.PATTERN_CALL__PARAMETER_MATCHING:
            return ((InternalEList<?>) getParameterMatching()).basicRemove(otherEnd, msgs);
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
        case PatternPackage.PATTERN_CALL__PARAMETER_MATCHING:
            if (coreType)
                return getParameterMatching();
            else
                return getParameterMatching().map();
        case PatternPackage.PATTERN_CALL__CALLED:
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
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case PatternPackage.PATTERN_CALL__PARAMETER_MATCHING:
            ((EStructuralFeature.Setting) getParameterMatching()).set(newValue);
            return;
        case PatternPackage.PATTERN_CALL__CALLED:
            setCalled((Pattern) newValue);
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
        case PatternPackage.PATTERN_CALL__PARAMETER_MATCHING:
            getParameterMatching().clear();
            return;
        case PatternPackage.PATTERN_CALL__CALLED:
            setCalled((Pattern) null);
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
        case PatternPackage.PATTERN_CALL__PARAMETER_MATCHING:
            return parameterMatching != null && !parameterMatching.isEmpty();
        case PatternPackage.PATTERN_CALL__CALLED:
            return called != null;
        }
        return super.eIsSet(featureID);
    }

} //PatternCallImpl
