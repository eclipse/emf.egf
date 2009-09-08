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
package org.eclipse.egf.pattern.pattern_1211201620024_9.impl;

import org.eclipse.egf.pattern.pattern_1211201620024_9.*;

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
public class Pattern_1211201620024_9FactoryImpl extends EFactoryImpl implements
		Pattern_1211201620024_9Factory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static Pattern_1211201620024_9Factory init() {
		try {
			Pattern_1211201620024_9Factory thePattern_1211201620024_9Factory = (Pattern_1211201620024_9Factory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1211201620024.9"); //$NON-NLS-1$ 
			if (thePattern_1211201620024_9Factory != null) {
				return thePattern_1211201620024_9Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1211201620024_9FactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1211201620024_9FactoryImpl() {
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
		case Pattern_1211201620024_9Package.PATTERN_1211201620024_9:
			return createPattern_1211201620024_9();
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
	public Pattern_1211201620024_9 createPattern_1211201620024_9() {
		Pattern_1211201620024_9Impl pattern_1211201620024_9 = new Pattern_1211201620024_9Impl();
		return pattern_1211201620024_9;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1211201620024_9Package getPattern_1211201620024_9Package() {
		return (Pattern_1211201620024_9Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1211201620024_9Package getPackage() {
		return Pattern_1211201620024_9Package.eINSTANCE;
	}

} // Pattern_1211201620024_9FactoryImpl
