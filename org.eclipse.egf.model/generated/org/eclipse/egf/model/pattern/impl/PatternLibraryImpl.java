/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern.impl;

import java.util.Collection;

import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl#getSchedulingRules <em>Scheduling Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternLibraryImpl extends PatternElementImpl implements PatternLibrary {
    /**
     * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getElements()
     * @generated
     * @ordered
     */
    protected EList<PatternElement> elements;

    /**
     * The cached value of the '{@link #getSchedulingRules() <em>Scheduling Rules</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSchedulingRules()
     * @generated
     * @ordered
     */
    protected EMap<String, EList<PatternElement>> schedulingRules;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PatternLibraryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.PATTERN_LIBRARY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PatternElement> getElements() {
        if (elements == null) {
            elements = new EObjectContainmentWithInverseEList<PatternElement>(PatternElement.class, this, PatternPackage.PATTERN_LIBRARY__ELEMENTS, PatternPackage.PATTERN_ELEMENT__CONTAINER);
        }
        return elements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, EList<PatternElement>> getSchedulingRules() {
        if (schedulingRules == null) {
            schedulingRules = new EcoreEMap<String, EList<PatternElement>>(PatternPackage.Literals.STRING2_PATTERN_LIST, String2PatternListImpl.class, this, PatternPackage.PATTERN_LIBRARY__SCHEDULING_RULES);
        }
        return schedulingRules;
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
        case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
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
        case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
            return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
        case PatternPackage.PATTERN_LIBRARY__SCHEDULING_RULES:
            return ((InternalEList<?>) getSchedulingRules()).basicRemove(otherEnd, msgs);
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
        case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
            return getElements();
        case PatternPackage.PATTERN_LIBRARY__SCHEDULING_RULES:
            if (coreType)
                return getSchedulingRules();
            else
                return getSchedulingRules().map();
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
        case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
            getElements().clear();
            getElements().addAll((Collection<? extends PatternElement>) newValue);
            return;
        case PatternPackage.PATTERN_LIBRARY__SCHEDULING_RULES:
            ((EStructuralFeature.Setting) getSchedulingRules()).set(newValue);
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
        case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
            getElements().clear();
            return;
        case PatternPackage.PATTERN_LIBRARY__SCHEDULING_RULES:
            getSchedulingRules().clear();
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
        case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
            return elements != null && !elements.isEmpty();
        case PatternPackage.PATTERN_LIBRARY__SCHEDULING_RULES:
            return schedulingRules != null && !schedulingRules.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PatternLibraryImpl
