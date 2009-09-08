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
package org.eclipse.egf.pattern.pattern_1240229598054_121.impl;

import org.eclipse.egf.pattern.pattern_1240229598054_121.*;

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
public class Pattern_1240229598054_121FactoryImpl extends EFactoryImpl
		implements Pattern_1240229598054_121Factory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static Pattern_1240229598054_121Factory init() {
		try {
			Pattern_1240229598054_121Factory thePattern_1240229598054_121Factory = (Pattern_1240229598054_121Factory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1240229598054.121"); //$NON-NLS-1$ 
			if (thePattern_1240229598054_121Factory != null) {
				return thePattern_1240229598054_121Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1240229598054_121FactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1240229598054_121FactoryImpl() {
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
		case Pattern_1240229598054_121Package.PATTERN_1240229598054_121:
			return createPattern_1240229598054_121();
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
	public Pattern_1240229598054_121 createPattern_1240229598054_121() {
		Pattern_1240229598054_121Impl pattern_1240229598054_121 = new Pattern_1240229598054_121Impl();
		return pattern_1240229598054_121;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1240229598054_121Package getPattern_1240229598054_121Package() {
		return (Pattern_1240229598054_121Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1240229598054_121Package getPackage() {
		return Pattern_1240229598054_121Package.eINSTANCE;
	}

} // Pattern_1240229598054_121FactoryImpl
