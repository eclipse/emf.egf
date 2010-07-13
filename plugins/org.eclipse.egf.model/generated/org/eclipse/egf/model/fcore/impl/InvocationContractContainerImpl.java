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
package org.eclipse.egf.model.fcore.impl;

import java.util.Collection;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Contract Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractContainerImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractContainerImpl#getInvocationContracts <em>Invocation Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationContractContainerImpl extends ModelElementImpl implements InvocationContractContainer {
    /**
     * The cached value of the '{@link #getInvocationContracts() <em>Invocation Contracts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInvocationContracts()
     * @generated
     * @ordered
     */
    protected EList<InvocationContract> invocationContracts;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InvocationContractContainerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FcorePackage.Literals.INVOCATION_CONTRACT_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Invocation getInvocation() {
        if (eContainerFeatureID() != FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION)
            return null;
        return (Invocation) eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInvocation(Invocation newInvocation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newInvocation, FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInvocation(Invocation newInvocation) {
        if (newInvocation != eInternalContainer() || (eContainerFeatureID() != FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION && newInvocation != null)) {
            if (EcoreUtil.isAncestor(this, newInvocation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInvocation != null)
                msgs = ((InternalEObject) newInvocation).eInverseAdd(this, FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER, Invocation.class, msgs);
            msgs = basicSetInvocation(newInvocation, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION, newInvocation, newInvocation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InvocationContract> getInvocationContracts() {
        if (invocationContracts == null) {
            invocationContracts = new EObjectContainmentWithInverseEList<InvocationContract>(InvocationContract.class, this, FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS, FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER);
        }
        return invocationContracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public FactoryComponent getFactoryComponent() {
        if (getInvocation() != null) {
            return getInvocation().getFactoryComponent();
        }
        return null;
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
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetInvocation((Invocation) otherEnd, msgs);
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocationContracts()).basicAdd(otherEnd, msgs);
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
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION:
            return basicSetInvocation(null, msgs);
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS:
            return ((InternalEList<?>) getInvocationContracts()).basicRemove(otherEnd, msgs);
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
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION:
            return eInternalContainer().eInverseRemove(this, FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER, Invocation.class, msgs);
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
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION:
            return getInvocation();
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS:
            return getInvocationContracts();
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
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION:
            setInvocation((Invocation) newValue);
            return;
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS:
            getInvocationContracts().clear();
            getInvocationContracts().addAll((Collection<? extends InvocationContract>) newValue);
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
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION:
            setInvocation((Invocation) null);
            return;
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS:
            getInvocationContracts().clear();
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
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION:
            return getInvocation() != null;
        case FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS:
            return invocationContracts != null && !invocationContracts.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // InvocationContractContainerImpl
