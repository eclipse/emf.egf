/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.pattern.impl;

import java.util.Collection;

import org.eclipse.egf.model.pattern.Library;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.LibraryImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.LibraryImpl#getRuntimeOrchestration <em>Runtime Orchestration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends PatternElementImpl implements Library {
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
	 * The cached value of the '{@link #getRuntimeOrchestration() <em>Runtime Orchestration</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeOrchestration()
	 * @generated
	 * @ordered
	 */
	protected EList<Library> runtimeOrchestration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PatternElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<PatternElement>(PatternElement.class, this, PatternPackage.LIBRARY__ELEMENTS, PatternPackage.PATTERN_ELEMENT__CONTAINER);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Library> getRuntimeOrchestration() {
		if (runtimeOrchestration == null) {
			runtimeOrchestration = new EObjectEList<Library>(Library.class, this, PatternPackage.LIBRARY__RUNTIME_ORCHESTRATION);
		}
		return runtimeOrchestration;
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
		case PatternPackage.LIBRARY__ELEMENTS:
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
		case PatternPackage.LIBRARY__ELEMENTS:
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
		case PatternPackage.LIBRARY__ELEMENTS:
			return getElements();
		case PatternPackage.LIBRARY__RUNTIME_ORCHESTRATION:
			return getRuntimeOrchestration();
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
		case PatternPackage.LIBRARY__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends PatternElement>) newValue);
			return;
		case PatternPackage.LIBRARY__RUNTIME_ORCHESTRATION:
			getRuntimeOrchestration().clear();
			getRuntimeOrchestration().addAll((Collection<? extends Library>) newValue);
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
		case PatternPackage.LIBRARY__ELEMENTS:
			getElements().clear();
			return;
		case PatternPackage.LIBRARY__RUNTIME_ORCHESTRATION:
			getRuntimeOrchestration().clear();
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
		case PatternPackage.LIBRARY__ELEMENTS:
			return elements != null && !elements.isEmpty();
		case PatternPackage.LIBRARY__RUNTIME_ORCHESTRATION:
			return runtimeOrchestration != null && !runtimeOrchestration.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LibraryImpl
