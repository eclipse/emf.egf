/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.pattern_1202377454428_65.impl;

import org.eclipse.egf.pattern.pattern_1202377454428_65.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class Pattern_1202377454428_65FactoryImpl extends EFactoryImpl implements
		Pattern_1202377454428_65Factory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static Pattern_1202377454428_65Factory init() {
		try {
			Pattern_1202377454428_65Factory thePattern_1202377454428_65Factory = (Pattern_1202377454428_65Factory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1202377454428.65"); //$NON-NLS-1$ 
			if (thePattern_1202377454428_65Factory != null) {
				return thePattern_1202377454428_65Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1202377454428_65FactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1202377454428_65FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Pattern_1202377454428_65Package.PATTERN_1202377454428_65:
			return createPattern_1202377454428_65();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1202377454428_65 createPattern_1202377454428_65() {
		Pattern_1202377454428_65Impl pattern_1202377454428_65 = new Pattern_1202377454428_65Impl();
		return pattern_1202377454428_65;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1202377454428_65Package getPattern_1202377454428_65Package() {
		return (Pattern_1202377454428_65Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1202377454428_65Package getPackage() {
		return Pattern_1202377454428_65Package.eINSTANCE;
	}

} // Pattern_1202377454428_65FactoryImpl
