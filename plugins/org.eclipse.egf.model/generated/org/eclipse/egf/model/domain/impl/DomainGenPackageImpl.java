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
package org.eclipse.egf.model.domain.impl;

import org.eclipse.egf.model.domain.DomainGenPackage;
import org.eclipse.egf.model.domain.DomainPackage;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.impl.DomainGenPackageImpl#getGenPackage <em>Gen Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainGenPackageImpl extends DomainImpl implements DomainGenPackage {

    /**
     * The cached value of the '{@link #getGenPackage() <em>Gen Package</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenPackage()
     * @generated
     * @ordered
     */
    protected GenPackage genPackage;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DomainGenPackageImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DomainPackage.Literals.DOMAIN_GEN_PACKAGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenPackage getGenPackage() {
        if (genPackage != null && genPackage.eIsProxy()) {
            InternalEObject oldGenPackage = (InternalEObject) genPackage;
            genPackage = (GenPackage) eResolveProxy(oldGenPackage);
            if (genPackage != oldGenPackage) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomainPackage.DOMAIN_GEN_PACKAGE__GEN_PACKAGE, oldGenPackage, genPackage));
            }
        }
        return genPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenPackage basicGetGenPackage() {
        return genPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGenPackage(GenPackage newGenPackage) {
        GenPackage oldGenPackage = genPackage;
        genPackage = newGenPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_GEN_PACKAGE__GEN_PACKAGE, oldGenPackage, genPackage));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DomainPackage.DOMAIN_GEN_PACKAGE__GEN_PACKAGE:
                if (resolve)
                    return getGenPackage();
                return basicGetGenPackage();
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
            case DomainPackage.DOMAIN_GEN_PACKAGE__GEN_PACKAGE:
                setGenPackage((GenPackage) newValue);
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
            case DomainPackage.DOMAIN_GEN_PACKAGE__GEN_PACKAGE:
                setGenPackage((GenPackage) null);
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
            case DomainPackage.DOMAIN_GEN_PACKAGE__GEN_PACKAGE:
                return genPackage != null;
        }
        return super.eIsSet(featureID);
    }

} //DomainGenPackageImpl
