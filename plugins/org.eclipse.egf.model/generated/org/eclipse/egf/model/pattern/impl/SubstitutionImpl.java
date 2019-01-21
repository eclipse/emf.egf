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
package org.eclipse.egf.model.pattern.impl;

import java.util.Collection;

import org.eclipse.egf.model.fcore.impl.NamedModelElementImpl;
import org.eclipse.egf.model.fcore.impl.ModelElementImpl;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.model.pattern.adapter.SubstitutionAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.SubstitutionImpl#getReplacedElement <em>Replaced Element</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.SubstitutionImpl#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubstitutionImpl extends NamedModelElementImpl implements Substitution {

    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected int flags = 0;

    /**
     * The cached value of the '{@link #getReplacedElement() <em>Replaced Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplacedElement()
     * @generated
     * @ordered
     */
    protected Pattern replacedElement;

    /**
     * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplacement()
     * @generated
     * @ordered
     */
    protected EList<Pattern> replacement;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected SubstitutionImpl() {
        super();
        new SubstitutionAdapter(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.SUBSTITUTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getReplacedElement() {
        if (replacedElement != null && replacedElement.eIsProxy()) {
            InternalEObject oldReplacedElement = (InternalEObject) replacedElement;
            replacedElement = (Pattern) eResolveProxy(oldReplacedElement);
            if (replacedElement != oldReplacedElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.SUBSTITUTION__REPLACED_ELEMENT, oldReplacedElement, replacedElement));
            }
        }
        return replacedElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern basicGetReplacedElement() {
        return replacedElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReplacedElement(Pattern newReplacedElement) {
        Pattern oldReplacedElement = replacedElement;
        replacedElement = newReplacedElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.SUBSTITUTION__REPLACED_ELEMENT, oldReplacedElement, replacedElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Pattern> getReplacement() {
        if (replacement == null) {
            replacement = new EObjectResolvingEList<Pattern>(Pattern.class, this, PatternPackage.SUBSTITUTION__REPLACEMENT);
        }
        return replacement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.SUBSTITUTION__REPLACED_ELEMENT:
            if (resolve)
                return getReplacedElement();
            return basicGetReplacedElement();
        case PatternPackage.SUBSTITUTION__REPLACEMENT:
            return getReplacement();
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
        case PatternPackage.SUBSTITUTION__REPLACED_ELEMENT:
            setReplacedElement((Pattern) newValue);
            return;
        case PatternPackage.SUBSTITUTION__REPLACEMENT:
            getReplacement().clear();
            getReplacement().addAll((Collection<? extends Pattern>) newValue);
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
        case PatternPackage.SUBSTITUTION__REPLACED_ELEMENT:
            setReplacedElement((Pattern) null);
            return;
        case PatternPackage.SUBSTITUTION__REPLACEMENT:
            getReplacement().clear();
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
        case PatternPackage.SUBSTITUTION__REPLACED_ELEMENT:
            return replacedElement != null;
        case PatternPackage.SUBSTITUTION__REPLACEMENT:
            return replacement != null && !replacement.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // SubstitutionImpl
