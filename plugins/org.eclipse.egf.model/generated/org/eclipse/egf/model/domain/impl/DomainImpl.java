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
package org.eclipse.egf.model.domain.impl;

import java.util.Collection;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.fcore.impl.NamedModelElementImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.impl.DomainImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.egf.model.domain.impl.DomainImpl#getHelperImplementation <em>Helper Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DomainImpl extends NamedModelElementImpl implements Domain {

    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected int flags = 0;

    /**
     * The cached value of the '{@link #getContent() <em>Content</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContent()
     * @generated
     * @ordered
     */
    protected EList<Object> content;

    /**
     * The default value of the '{@link #getHelperImplementation() <em>Helper Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHelperImplementation()
     * @generated
     * @ordered
     */
    protected static final String HELPER_IMPLEMENTATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHelperImplementation() <em>Helper Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHelperImplementation()
     * @generated
     * @ordered
     */
    protected String helperImplementation = HELPER_IMPLEMENTATION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DomainImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DomainPackage.Literals.DOMAIN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Object> getContent() {
        if (content == null) {
            content = new EDataTypeUniqueEList<Object>(Object.class, this, DomainPackage.DOMAIN__CONTENT);
        }
        return content;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHelperImplementation() {
        return helperImplementation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHelperImplementation(String newHelperImplementation) {
        String oldHelperImplementation = helperImplementation;
        helperImplementation = newHelperImplementation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN__HELPER_IMPLEMENTATION, oldHelperImplementation, helperImplementation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DomainPackage.DOMAIN__CONTENT:
                return getContent();
            case DomainPackage.DOMAIN__HELPER_IMPLEMENTATION:
                return getHelperImplementation();
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
            case DomainPackage.DOMAIN__CONTENT:
                getContent().clear();
                getContent().addAll((Collection<? extends Object>) newValue);
                return;
            case DomainPackage.DOMAIN__HELPER_IMPLEMENTATION:
                setHelperImplementation((String) newValue);
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
            case DomainPackage.DOMAIN__CONTENT:
                getContent().clear();
                return;
            case DomainPackage.DOMAIN__HELPER_IMPLEMENTATION:
                setHelperImplementation(HELPER_IMPLEMENTATION_EDEFAULT);
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
            case DomainPackage.DOMAIN__CONTENT:
                return content != null && !content.isEmpty();
            case DomainPackage.DOMAIN__HELPER_IMPLEMENTATION:
                return HELPER_IMPLEMENTATION_EDEFAULT == null ? helperImplementation != null : !HELPER_IMPLEMENTATION_EDEFAULT.equals(helperImplementation);
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
        result.append(" (content: "); //$NON-NLS-1$
        result.append(content);
        result.append(", helperImplementation: "); //$NON-NLS-1$
        result.append(helperImplementation);
        result.append(')');
        return result.toString();
    }

} // DomainImpl
