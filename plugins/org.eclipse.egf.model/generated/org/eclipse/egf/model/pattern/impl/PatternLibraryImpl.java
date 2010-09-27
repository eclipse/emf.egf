/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern.impl;

import java.util.Collection;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl#getPatternViewpoint <em>Pattern Viewpoint</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl#getFilters <em>Filters</em>}</li>
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
    protected EList<Pattern> elements;

    /**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilters()
     * @generated
     * @ordered
     */
    protected EMap<String, EList<PatternElement>> filters;

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
    public PatternViewpoint getPatternViewpoint() {
        if (eContainerFeatureID() != PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT)
            return null;
        return (PatternViewpoint) eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPatternViewpoint(PatternViewpoint newPatternViewpoint, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPatternViewpoint, PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPatternViewpoint(PatternViewpoint newPatternViewpoint) {
        if (newPatternViewpoint != eInternalContainer() || (eContainerFeatureID() != PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT && newPatternViewpoint != null)) {
            if (EcoreUtil.isAncestor(this, newPatternViewpoint))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPatternViewpoint != null)
                msgs = ((InternalEObject) newPatternViewpoint).eInverseAdd(this, PatternPackage.PATTERN_VIEWPOINT__LIBRARIES, PatternViewpoint.class, msgs);
            msgs = basicSetPatternViewpoint(newPatternViewpoint, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT, newPatternViewpoint, newPatternViewpoint));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Pattern> getElements() {
        if (elements == null) {
            elements = new EObjectContainmentWithInverseEList<Pattern>(Pattern.class, this, PatternPackage.PATTERN_LIBRARY__ELEMENTS, PatternPackage.PATTERN__CONTAINER);
        }
        return elements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, EList<PatternElement>> getFilters() {
        if (filters == null) {
            filters = new EcoreEMap<String, EList<PatternElement>>(PatternPackage.Literals.STRING2_PATTERN_LIST, String2PatternListImpl.class, this, PatternPackage.PATTERN_LIBRARY__FILTERS);
        }
        return filters;
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
            case PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetPatternViewpoint((PatternViewpoint) otherEnd, msgs);
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
            case PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT:
                return basicSetPatternViewpoint(null, msgs);
            case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
                return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
            case PatternPackage.PATTERN_LIBRARY__FILTERS:
                return ((InternalEList<?>) getFilters()).basicRemove(otherEnd, msgs);
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
            case PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT:
                return eInternalContainer().eInverseRemove(this, PatternPackage.PATTERN_VIEWPOINT__LIBRARIES, PatternViewpoint.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("all")
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT:
                return getPatternViewpoint();
            case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
                return getElements();
            case PatternPackage.PATTERN_LIBRARY__FILTERS:
                if (coreType)
                    return getFilters();
                else
                    return getFilters().map();
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
            case PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT:
                setPatternViewpoint((PatternViewpoint) newValue);
                return;
            case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
                getElements().clear();
                getElements().addAll((Collection<? extends Pattern>) newValue);
                return;
            case PatternPackage.PATTERN_LIBRARY__FILTERS:
                ((EStructuralFeature.Setting) getFilters()).set(newValue);
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
            case PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT:
                setPatternViewpoint((PatternViewpoint) null);
                return;
            case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
                getElements().clear();
                return;
            case PatternPackage.PATTERN_LIBRARY__FILTERS:
                getFilters().clear();
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
            case PatternPackage.PATTERN_LIBRARY__PATTERN_VIEWPOINT:
                return getPatternViewpoint() != null;
            case PatternPackage.PATTERN_LIBRARY__ELEMENTS:
                return elements != null && !elements.isEmpty();
            case PatternPackage.PATTERN_LIBRARY__FILTERS:
                return filters != null && !filters.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PatternLibraryImpl
