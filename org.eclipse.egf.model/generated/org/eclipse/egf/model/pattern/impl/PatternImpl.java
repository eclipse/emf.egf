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

import org.eclipse.egf.model.pattern.Parameter;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternUnit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getHeaderMethod <em>Header Method</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getAllMethods <em>All Methods</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getSuperPattern <em>Super Pattern</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getFooterMethod <em>Footer Method</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getOrchestration <em>Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getNature <em>Nature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternImpl extends PatternElementImpl implements Pattern {
	/**
	 * The cached value of the '{@link #getHeaderMethod() <em>Header Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderMethod()
	 * @generated
	 * @ordered
	 */
	protected PatternMethod headerMethod;

	/**
	 * The cached value of the '{@link #getAllMethods() <em>All Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<PatternMethod> allMethods;

	/**
	 * The cached value of the '{@link #getSuperPattern() <em>Super Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern superPattern;

	/**
	 * The cached value of the '{@link #getFooterMethod() <em>Footer Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFooterMethod()
	 * @generated
	 * @ordered
	 */
	protected PatternMethod footerMethod;

	/**
	 * The cached value of the '{@link #getOrchestration() <em>Orchestration</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrchestration()
	 * @generated
	 * @ordered
	 */
	protected EList<PatternUnit> orchestration;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getNature() <em>Nature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected PatternNature nature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternPackage.Literals.PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMethod getHeaderMethod() {
		return headerMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderMethod(PatternMethod newHeaderMethod) {
		PatternMethod oldHeaderMethod = headerMethod;
		headerMethod = newHeaderMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__HEADER_METHOD, oldHeaderMethod, headerMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PatternMethod> getAllMethods() {
		if (allMethods == null) {
			allMethods = new EObjectContainmentWithInverseEList<PatternMethod>(PatternMethod.class, this, PatternPackage.PATTERN__ALL_METHODS, PatternPackage.PATTERN_METHOD__PATTERN);
		}
		return allMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getSuperPattern() {
		return superPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperPattern(Pattern newSuperPattern) {
		Pattern oldSuperPattern = superPattern;
		superPattern = newSuperPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__SUPER_PATTERN, oldSuperPattern, superPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMethod getFooterMethod() {
		return footerMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFooterMethod(PatternMethod newFooterMethod) {
		PatternMethod oldFooterMethod = footerMethod;
		footerMethod = newFooterMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__FOOTER_METHOD, oldFooterMethod, footerMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PatternUnit> getOrchestration() {
		if (orchestration == null) {
			orchestration = new EObjectResolvingEList<PatternUnit>(PatternUnit.class, this, PatternPackage.PATTERN__ORCHESTRATION);
		}
		return orchestration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, PatternPackage.PATTERN__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternNature getNature() {
		return nature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNature(PatternNature newNature, NotificationChain msgs) {
		PatternNature oldNature = nature;
		nature = newNature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__NATURE, oldNature, newNature);
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
	public void setNature(PatternNature newNature) {
		if (newNature != nature) {
			NotificationChain msgs = null;
			if (nature != null)
				msgs = ((InternalEObject) nature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN__NATURE, null, msgs);
			if (newNature != null)
				msgs = ((InternalEObject) newNature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN__NATURE, null, msgs);
			msgs = basicSetNature(newNature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__NATURE, newNature, newNature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PatternMethod getMethod(String name) {
		for (PatternMethod method : getAllMethods()) {
			if (method.getName().equals(name))
				return method;
		}
		if (getSuperPattern() == null)
			return null;
		return getSuperPattern().getMethod(name);
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
		case PatternPackage.PATTERN__ALL_METHODS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAllMethods()).basicAdd(otherEnd, msgs);
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
		case PatternPackage.PATTERN__ALL_METHODS:
			return ((InternalEList<?>) getAllMethods()).basicRemove(otherEnd, msgs);
		case PatternPackage.PATTERN__PARAMETERS:
			return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
		case PatternPackage.PATTERN__NATURE:
			return basicSetNature(null, msgs);
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
		case PatternPackage.PATTERN__HEADER_METHOD:
			return getHeaderMethod();
		case PatternPackage.PATTERN__ALL_METHODS:
			return getAllMethods();
		case PatternPackage.PATTERN__SUPER_PATTERN:
			return getSuperPattern();
		case PatternPackage.PATTERN__FOOTER_METHOD:
			return getFooterMethod();
		case PatternPackage.PATTERN__ORCHESTRATION:
			return getOrchestration();
		case PatternPackage.PATTERN__PARAMETERS:
			return getParameters();
		case PatternPackage.PATTERN__NATURE:
			return getNature();
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
		case PatternPackage.PATTERN__HEADER_METHOD:
			setHeaderMethod((PatternMethod) newValue);
			return;
		case PatternPackage.PATTERN__ALL_METHODS:
			getAllMethods().clear();
			getAllMethods().addAll((Collection<? extends PatternMethod>) newValue);
			return;
		case PatternPackage.PATTERN__SUPER_PATTERN:
			setSuperPattern((Pattern) newValue);
			return;
		case PatternPackage.PATTERN__FOOTER_METHOD:
			setFooterMethod((PatternMethod) newValue);
			return;
		case PatternPackage.PATTERN__ORCHESTRATION:
			getOrchestration().clear();
			getOrchestration().addAll((Collection<? extends PatternUnit>) newValue);
			return;
		case PatternPackage.PATTERN__PARAMETERS:
			getParameters().clear();
			getParameters().addAll((Collection<? extends Parameter>) newValue);
			return;
		case PatternPackage.PATTERN__NATURE:
			setNature((PatternNature) newValue);
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
		case PatternPackage.PATTERN__HEADER_METHOD:
			setHeaderMethod((PatternMethod) null);
			return;
		case PatternPackage.PATTERN__ALL_METHODS:
			getAllMethods().clear();
			return;
		case PatternPackage.PATTERN__SUPER_PATTERN:
			setSuperPattern((Pattern) null);
			return;
		case PatternPackage.PATTERN__FOOTER_METHOD:
			setFooterMethod((PatternMethod) null);
			return;
		case PatternPackage.PATTERN__ORCHESTRATION:
			getOrchestration().clear();
			return;
		case PatternPackage.PATTERN__PARAMETERS:
			getParameters().clear();
			return;
		case PatternPackage.PATTERN__NATURE:
			setNature((PatternNature) null);
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
		case PatternPackage.PATTERN__HEADER_METHOD:
			return headerMethod != null;
		case PatternPackage.PATTERN__ALL_METHODS:
			return allMethods != null && !allMethods.isEmpty();
		case PatternPackage.PATTERN__SUPER_PATTERN:
			return superPattern != null;
		case PatternPackage.PATTERN__FOOTER_METHOD:
			return footerMethod != null;
		case PatternPackage.PATTERN__ORCHESTRATION:
			return orchestration != null && !orchestration.isEmpty();
		case PatternPackage.PATTERN__PARAMETERS:
			return parameters != null && !parameters.isEmpty();
		case PatternPackage.PATTERN__NATURE:
			return nature != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternImpl
