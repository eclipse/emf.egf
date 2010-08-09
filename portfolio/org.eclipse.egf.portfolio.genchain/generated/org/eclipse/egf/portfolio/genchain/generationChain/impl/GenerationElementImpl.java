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
package org.eclipse.egf.portfolio.genchain.generationChain.impl;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generation Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationElementImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GenerationElementImpl extends EObjectImpl implements GenerationElement {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenerationElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return GenerationChainPackage.Literals.GENERATION_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.GENERATION_ELEMENT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenerationChain getContainer() {
        if (eContainerFeatureID() != GenerationChainPackage.GENERATION_ELEMENT__CONTAINER)
            return null;
        return (GenerationChain) eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContainer(GenerationChain newContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newContainer, GenerationChainPackage.GENERATION_ELEMENT__CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainer(GenerationChain newContainer) {
        if (newContainer != eInternalContainer() || (eContainerFeatureID() != GenerationChainPackage.GENERATION_ELEMENT__CONTAINER && newContainer != null)) {
            if (EcoreUtil.isAncestor(this, newContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContainer != null)
                msgs = ((InternalEObject) newContainer).eInverseAdd(this, GenerationChainPackage.GENERATION_CHAIN__ELEMENTS, GenerationChain.class, msgs);
            msgs = basicSetContainer(newContainer, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.GENERATION_ELEMENT__CONTAINER, newContainer, newContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case GenerationChainPackage.GENERATION_ELEMENT__CONTAINER:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetContainer((GenerationChain) otherEnd, msgs);
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
        case GenerationChainPackage.GENERATION_ELEMENT__CONTAINER:
            return basicSetContainer(null, msgs);
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
        case GenerationChainPackage.GENERATION_ELEMENT__CONTAINER:
            return eInternalContainer().eInverseRemove(this, GenerationChainPackage.GENERATION_CHAIN__ELEMENTS, GenerationChain.class, msgs);
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
        case GenerationChainPackage.GENERATION_ELEMENT__NAME:
            return getName();
        case GenerationChainPackage.GENERATION_ELEMENT__CONTAINER:
            return getContainer();
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
        case GenerationChainPackage.GENERATION_ELEMENT__NAME:
            setName((String) newValue);
            return;
        case GenerationChainPackage.GENERATION_ELEMENT__CONTAINER:
            setContainer((GenerationChain) newValue);
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
        case GenerationChainPackage.GENERATION_ELEMENT__NAME:
            setName(NAME_EDEFAULT);
            return;
        case GenerationChainPackage.GENERATION_ELEMENT__CONTAINER:
            setContainer((GenerationChain) null);
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
        case GenerationChainPackage.GENERATION_ELEMENT__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case GenerationChainPackage.GENERATION_ELEMENT__CONTAINER:
            return getContainer() != null;
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //GenerationElementImpl
