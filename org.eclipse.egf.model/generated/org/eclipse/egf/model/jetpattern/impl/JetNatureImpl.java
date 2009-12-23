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
package org.eclipse.egf.model.jetpattern.impl;

import org.eclipse.egf.model.jetpattern.JetNature;
import org.eclipse.egf.model.jetpattern.JetpatternPackage;

import org.eclipse.egf.model.pattern.impl.PatternNatureImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jet Nature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.jetpattern.impl.JetNatureImpl#getTemplateClassName <em>Template Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JetNatureImpl extends PatternNatureImpl implements JetNature {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getTemplateClassName() <em>Template Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateClassName()
	 * @generated
	 * @ordered
	 */
	protected static final URI TEMPLATE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemplateClassName() <em>Template Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateClassName()
	 * @generated
	 * @ordered
	 */
	protected URI templateClassName = TEMPLATE_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JetNatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JetpatternPackage.Literals.JET_NATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTemplateClassName() {
		return templateClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateClassName(URI newTemplateClassName) {
		URI oldTemplateClassName = templateClassName;
		templateClassName = newTemplateClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JetpatternPackage.JET_NATURE__TEMPLATE_CLASS_NAME, oldTemplateClassName, templateClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case JetpatternPackage.JET_NATURE__TEMPLATE_CLASS_NAME:
			return getTemplateClassName();
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
		case JetpatternPackage.JET_NATURE__TEMPLATE_CLASS_NAME:
			setTemplateClassName((URI) newValue);
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
		case JetpatternPackage.JET_NATURE__TEMPLATE_CLASS_NAME:
			setTemplateClassName(TEMPLATE_CLASS_NAME_EDEFAULT);
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
		case JetpatternPackage.JET_NATURE__TEMPLATE_CLASS_NAME:
			return TEMPLATE_CLASS_NAME_EDEFAULT == null ? templateClassName != null : !TEMPLATE_CLASS_NAME_EDEFAULT.equals(templateClassName);
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
		result.append(" (templateClassName: "); //$NON-NLS-1$
		result.append(templateClassName);
		result.append(')');
		return result.toString();
	}

} //JetNatureImpl
