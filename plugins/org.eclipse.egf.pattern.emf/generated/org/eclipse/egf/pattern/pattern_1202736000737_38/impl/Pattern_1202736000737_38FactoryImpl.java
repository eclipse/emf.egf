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
package org.eclipse.egf.pattern.pattern_1202736000737_38.impl;

import org.eclipse.egf.pattern.pattern_1202736000737_38.*;

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
public class Pattern_1202736000737_38FactoryImpl extends EFactoryImpl implements
		Pattern_1202736000737_38Factory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static Pattern_1202736000737_38Factory init() {
		try {
			Pattern_1202736000737_38Factory thePattern_1202736000737_38Factory = (Pattern_1202736000737_38Factory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1202736000737.38"); //$NON-NLS-1$ 
			if (thePattern_1202736000737_38Factory != null) {
				return thePattern_1202736000737_38Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1202736000737_38FactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1202736000737_38FactoryImpl() {
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
		case Pattern_1202736000737_38Package.PATTERN_1202736000737_38:
			return createPattern_1202736000737_38();
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
	public Pattern_1202736000737_38 createPattern_1202736000737_38() {
		Pattern_1202736000737_38Impl pattern_1202736000737_38 = new Pattern_1202736000737_38Impl();
		return pattern_1202736000737_38;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1202736000737_38Package getPattern_1202736000737_38Package() {
		return (Pattern_1202736000737_38Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1202736000737_38Package getPackage() {
		return Pattern_1202736000737_38Package.eINSTANCE;
	}

} // Pattern_1202736000737_38FactoryImpl
