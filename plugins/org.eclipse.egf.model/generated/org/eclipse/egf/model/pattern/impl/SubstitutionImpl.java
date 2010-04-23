/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern.impl;

import java.util.Collection;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.Substitution;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.SubstitutionImpl#getOutcoming <em>Outcoming</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.SubstitutionImpl#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubstitutionImpl extends Container implements Substitution {
    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected int flags = 0;

    /**
     * The cached value of the '{@link #getOutcoming() <em>Outcoming</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutcoming()
     * @generated
     * @ordered
     */
    protected Pattern outcoming;

    /**
     * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncoming()
     * @generated
     * @ordered
     */
    protected EList<Pattern> incoming;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SubstitutionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.SUBSTITUTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getOutcoming() {
        if (outcoming != null && outcoming.eIsProxy()) {
            InternalEObject oldOutcoming = (InternalEObject) outcoming;
            outcoming = (Pattern) eResolveProxy(oldOutcoming);
            if (outcoming != oldOutcoming) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.SUBSTITUTION__OUTCOMING, oldOutcoming, outcoming));
            }
        }
        return outcoming;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern basicGetOutcoming() {
        return outcoming;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutcoming(Pattern newOutcoming) {
        Pattern oldOutcoming = outcoming;
        outcoming = newOutcoming;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.SUBSTITUTION__OUTCOMING, oldOutcoming, outcoming));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Pattern> getIncoming() {
        if (incoming == null) {
            incoming = new EObjectResolvingEList<Pattern>(Pattern.class, this, PatternPackage.SUBSTITUTION__INCOMING);
        }
        return incoming;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.SUBSTITUTION__OUTCOMING:
            if (resolve)
                return getOutcoming();
            return basicGetOutcoming();
        case PatternPackage.SUBSTITUTION__INCOMING:
            return getIncoming();
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
        case PatternPackage.SUBSTITUTION__OUTCOMING:
            setOutcoming((Pattern) newValue);
            return;
        case PatternPackage.SUBSTITUTION__INCOMING:
            getIncoming().clear();
            getIncoming().addAll((Collection<? extends Pattern>) newValue);
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
        case PatternPackage.SUBSTITUTION__OUTCOMING:
            setOutcoming((Pattern) null);
            return;
        case PatternPackage.SUBSTITUTION__INCOMING:
            getIncoming().clear();
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
        case PatternPackage.SUBSTITUTION__OUTCOMING:
            return outcoming != null;
        case PatternPackage.SUBSTITUTION__INCOMING:
            return incoming != null && !incoming.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SubstitutionImpl
