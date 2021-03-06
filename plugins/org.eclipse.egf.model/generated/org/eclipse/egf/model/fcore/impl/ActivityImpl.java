/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ActivityImpl#getContractContainer <em>Contract Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActivityImpl extends NamedModelElementImpl implements Activity {

    /**
     * The cached value of the '{@link #getContractContainer() <em>Contract Container</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContractContainer()
     * @generated
     * @ordered
     */
    protected ContractContainer contractContainer;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ActivityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FcorePackage.Literals.ACTIVITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContractContainer getContractContainer() {
        return contractContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContractContainer(ContractContainer newContractContainer, NotificationChain msgs) {
        ContractContainer oldContractContainer = contractContainer;
        contractContainer = newContractContainer;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.ACTIVITY__CONTRACT_CONTAINER, oldContractContainer, newContractContainer);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContractContainer(ContractContainer newContractContainer) {
        if (newContractContainer != contractContainer) {
            NotificationChain msgs = null;
            if (contractContainer != null)
                msgs = ((InternalEObject) contractContainer).eInverseRemove(this, FcorePackage.CONTRACT_CONTAINER__ACTIVITY, ContractContainer.class, msgs);
            if (newContractContainer != null)
                msgs = ((InternalEObject) newContractContainer).eInverseAdd(this, FcorePackage.CONTRACT_CONTAINER__ACTIVITY, ContractContainer.class, msgs);
            msgs = basicSetContractContainer(newContractContainer, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ACTIVITY__CONTRACT_CONTAINER, newContractContainer, newContractContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<Contract> getContracts() {
        if (getContractContainer() != null) {
            return getContractContainer().getContracts();
        }
        return new UniqueEList<Contract>();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<Contract> getContracts(Type innerType) {
        if (getContractContainer() != null) {
            return getContractContainer().getContracts(innerType);
        }
        return new UniqueEList<Contract>();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<Contract> getContracts(ContractMode mode) {
        if (getContractContainer() != null) {
            return getContractContainer().getContracts(mode);
        }
        return new UniqueEList<Contract>();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<Contract> getContracts(Type innerType, ContractMode mode) {
        if (getContractContainer() != null) {
            return getContractContainer().getContracts(innerType, mode);
        }
        return new UniqueEList<Contract>();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Contract getContract(String innerName) {
        if (getContractContainer() == null || innerName == null) {
            return null;
        }
        final ContractContainer container = getContractContainer();
        for (Contract contract : container.getContracts()) {
            if (innerName.equals(contract.getName())) {
                return contract;
            }
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public EList<Activity> getActivities() {
        EList<Activity> activities = super.getActivities();
        activities.add(this);
        return activities;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FcorePackage.ACTIVITY__CONTRACT_CONTAINER:
                if (contractContainer != null)
                    msgs = ((InternalEObject) contractContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.ACTIVITY__CONTRACT_CONTAINER, null, msgs);
                return basicSetContractContainer((ContractContainer) otherEnd, msgs);
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
            case FcorePackage.ACTIVITY__CONTRACT_CONTAINER:
                return basicSetContractContainer(null, msgs);
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
            case FcorePackage.ACTIVITY__CONTRACT_CONTAINER:
                return getContractContainer();
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
            case FcorePackage.ACTIVITY__CONTRACT_CONTAINER:
                setContractContainer((ContractContainer) newValue);
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
            case FcorePackage.ACTIVITY__CONTRACT_CONTAINER:
                setContractContainer((ContractContainer) null);
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
            case FcorePackage.ACTIVITY__CONTRACT_CONTAINER:
                return contractContainer != null;
        }
        return super.eIsSet(featureID);
    }

} // ActivityImpl
