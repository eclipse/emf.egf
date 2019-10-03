/**
 * 
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
 * 
 */
package org.eclipse.egf.model.fcore.impl;

import java.util.Collection;

import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factory Component Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl#getInvocationContracts <em>Invocation Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryComponentContractImpl extends ContractImpl implements FactoryComponentContract {

    /**
     * The cached value of the '{@link #getInvocationContracts() <em>Invocation Contracts</em>}' reference list.
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
    protected FactoryComponentContractImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FcorePackage.Literals.FACTORY_COMPONENT_CONTRACT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InvocationContract> getInvocationContracts() {
        if (invocationContracts == null) {
            invocationContracts = new EObjectWithInverseEList<InvocationContract>(InvocationContract.class, this, FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS, FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT);
        }
        return invocationContracts;
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
            case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS:
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
            case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS:
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
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS:
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
            case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS:
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
            case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS:
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
            case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS:
                return invocationContracts != null && !invocationContracts.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // FactoryComponentContractImpl
