/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.pattern.AbstractPatternCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Pattern Call</b></em>
 * '.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.AbstractPatternCallImpl#getCalled <em>Called</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractPatternCallImpl extends CallImpl implements AbstractPatternCall {
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
    protected AbstractPatternCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.ABSTRACT_PATTERN_CALL;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.ABSTRACT_PATTERN_CALL__CALLED, oldCalled, called));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.ABSTRACT_PATTERN_CALL__CALLED, oldCalled, called));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.ABSTRACT_PATTERN_CALL__CALLED:
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
        case PatternPackage.ABSTRACT_PATTERN_CALL__CALLED:
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
        case PatternPackage.ABSTRACT_PATTERN_CALL__CALLED:
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
        case PatternPackage.ABSTRACT_PATTERN_CALL__CALLED:
            return called != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractPatternCallImpl
