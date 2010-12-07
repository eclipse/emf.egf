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

import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.LoadableDomain;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loadable Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.impl.LoadableDomainImpl#isLoaded <em>Loaded</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LoadableDomainImpl extends DomainImpl implements LoadableDomain {
    /**
     * The default value of the '{@link #isLoaded() <em>Loaded</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLoaded()
     * @generated
     * @ordered
     */
    protected static final boolean LOADED_EDEFAULT = false;

    /**
     * The flag representing the value of the '{@link #isLoaded() <em>Loaded</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLoaded()
     * @generated
     * @ordered
     */
    protected static final int LOADED_EFLAG = 1 << 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected LoadableDomainImpl() {
        super();
        setLoaded(false);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DomainPackage.Literals.LOADABLE_DOMAIN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLoaded() {
        return (flags & LOADED_EFLAG) != 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoaded(boolean newLoaded) {
        boolean oldLoaded = (flags & LOADED_EFLAG) != 0;
        if (newLoaded)
            flags |= LOADED_EFLAG;
        else
            flags &= ~LOADED_EFLAG;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.LOADABLE_DOMAIN__LOADED, oldLoaded, newLoaded));
    }

    @Override
    public EList<Object> getContent() {
        if (!isLoaded())
            throw new IllegalStateException(EGFModelPlugin.INSTANCE.getString("_DomainLoad_error"));
        return super.getContent();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case DomainPackage.LOADABLE_DOMAIN__LOADED:
            return isLoaded();
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
        case DomainPackage.LOADABLE_DOMAIN__LOADED:
            setLoaded((Boolean) newValue);
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
        case DomainPackage.LOADABLE_DOMAIN__LOADED:
            setLoaded(LOADED_EDEFAULT);
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
        case DomainPackage.LOADABLE_DOMAIN__LOADED:
            return ((flags & LOADED_EFLAG) != 0) != LOADED_EDEFAULT;
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
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (loaded: "); //$NON-NLS-1$
        result.append((flags & LOADED_EFLAG) != 0);
        result.append(')');
        return result.toString();
    }

} // LoadableDomainImpl
