/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.portfolio.genchain.generationChain.impl;

import java.util.Collection;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generation Chain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainImpl#getFactoryComponentName <em>Factory Component Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenerationChainImpl extends GenerationElementImpl implements GenerationChain {
    /**
     * The default value of the '{@link #getFactoryComponentName() <em>Factory Component Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFactoryComponentName()
     * @generated
     * @ordered
     */
    protected static final String FACTORY_COMPONENT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFactoryComponentName() <em>Factory Component Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFactoryComponentName()
     * @generated
     * @ordered
     */
    protected String factoryComponentName = FACTORY_COMPONENT_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getElements()
     * @generated
     * @ordered
     */
    protected EList<GenerationElement> elements;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenerationChainImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return GenerationChainPackage.Literals.GENERATION_CHAIN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFactoryComponentName() {
        return factoryComponentName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFactoryComponentName(String newFactoryComponentName) {
        String oldFactoryComponentName = factoryComponentName;
        factoryComponentName = newFactoryComponentName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.GENERATION_CHAIN__FACTORY_COMPONENT_NAME, oldFactoryComponentName, factoryComponentName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<GenerationElement> getElements() {
        if (elements == null) {
            elements = new EObjectContainmentWithInverseEList<GenerationElement>(GenerationElement.class, this, GenerationChainPackage.GENERATION_CHAIN__ELEMENTS, GenerationChainPackage.GENERATION_ELEMENT__CONTAINER);
        }
        return elements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case GenerationChainPackage.GENERATION_CHAIN__ELEMENTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getElements()).basicAdd(otherEnd, msgs);
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
        case GenerationChainPackage.GENERATION_CHAIN__ELEMENTS:
            return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
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
        case GenerationChainPackage.GENERATION_CHAIN__FACTORY_COMPONENT_NAME:
            return getFactoryComponentName();
        case GenerationChainPackage.GENERATION_CHAIN__ELEMENTS:
            return getElements();
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
        case GenerationChainPackage.GENERATION_CHAIN__FACTORY_COMPONENT_NAME:
            setFactoryComponentName((String) newValue);
            return;
        case GenerationChainPackage.GENERATION_CHAIN__ELEMENTS:
            getElements().clear();
            getElements().addAll((Collection<? extends GenerationElement>) newValue);
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
        case GenerationChainPackage.GENERATION_CHAIN__FACTORY_COMPONENT_NAME:
            setFactoryComponentName(FACTORY_COMPONENT_NAME_EDEFAULT);
            return;
        case GenerationChainPackage.GENERATION_CHAIN__ELEMENTS:
            getElements().clear();
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
        case GenerationChainPackage.GENERATION_CHAIN__FACTORY_COMPONENT_NAME:
            return FACTORY_COMPONENT_NAME_EDEFAULT == null ? factoryComponentName != null : !FACTORY_COMPONENT_NAME_EDEFAULT.equals(factoryComponentName);
        case GenerationChainPackage.GENERATION_CHAIN__ELEMENTS:
            return elements != null && !elements.isEmpty();
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
        result.append(" (factoryComponentName: ");
        result.append(factoryComponentName);
        result.append(')');
        return result.toString();
    }

} //GenerationChainImpl
