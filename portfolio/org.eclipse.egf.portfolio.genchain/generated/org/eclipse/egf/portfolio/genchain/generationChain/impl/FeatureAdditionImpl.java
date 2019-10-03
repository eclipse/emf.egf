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

import org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Addition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.FeatureAdditionImpl#getAdditions <em>Additions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureAdditionImpl extends GenerationElementImpl implements FeatureAddition {
    /**
     * The cached value of the '{@link #getAdditions() <em>Additions</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdditions()
     * @generated
     * @ordered
     */
    protected EList<String> additions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FeatureAdditionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return GenerationChainPackage.Literals.FEATURE_ADDITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getAdditions() {
        if (additions == null) {
            additions = new EDataTypeUniqueEList<String>(String.class, this, GenerationChainPackage.FEATURE_ADDITION__ADDITIONS);
        }
        return additions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case GenerationChainPackage.FEATURE_ADDITION__ADDITIONS:
            return getAdditions();
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
        case GenerationChainPackage.FEATURE_ADDITION__ADDITIONS:
            getAdditions().clear();
            getAdditions().addAll((Collection<? extends String>) newValue);
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
        case GenerationChainPackage.FEATURE_ADDITION__ADDITIONS:
            getAdditions().clear();
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
        case GenerationChainPackage.FEATURE_ADDITION__ADDITIONS:
            return additions != null && !additions.isEmpty();
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
        result.append(" (additions: ");
        result.append(additions);
        result.append(')');
        return result.toString();
    }

} //FeatureAdditionImpl
