/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.pattern_1233239232789_12.impl;

import org.eclipse.egf.pattern.pattern_1233239232789_12.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pattern_1233239232789_12FactoryImpl extends EFactoryImpl implements Pattern_1233239232789_12Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pattern_1233239232789_12Factory init() {
		try {
			Pattern_1233239232789_12Factory thePattern_1233239232789_12Factory = (Pattern_1233239232789_12Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1233239232789.12"); //$NON-NLS-1$ 
			if (thePattern_1233239232789_12Factory != null) {
				return thePattern_1233239232789_12Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1233239232789_12FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1233239232789_12FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Pattern_1233239232789_12Package.PATTERN_1233239232789_12: return createPattern_1233239232789_12();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1233239232789_12 createPattern_1233239232789_12() {
		Pattern_1233239232789_12Impl pattern_1233239232789_12 = new Pattern_1233239232789_12Impl();
		return pattern_1233239232789_12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1233239232789_12Package getPattern_1233239232789_12Package() {
		return (Pattern_1233239232789_12Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1233239232789_12Package getPackage() {
		return Pattern_1233239232789_12Package.eINSTANCE;
	}

} //Pattern_1233239232789_12FactoryImpl
