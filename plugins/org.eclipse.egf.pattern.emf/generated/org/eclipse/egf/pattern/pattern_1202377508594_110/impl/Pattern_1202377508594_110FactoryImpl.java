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
package org.eclipse.egf.pattern.pattern_1202377508594_110.impl;

import org.eclipse.egf.pattern.pattern_1202377508594_110.*;

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
public class Pattern_1202377508594_110FactoryImpl extends EFactoryImpl
		implements Pattern_1202377508594_110Factory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static Pattern_1202377508594_110Factory init() {
		try {
			Pattern_1202377508594_110Factory thePattern_1202377508594_110Factory = (Pattern_1202377508594_110Factory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1202377508594.110"); //$NON-NLS-1$ 
			if (thePattern_1202377508594_110Factory != null) {
				return thePattern_1202377508594_110Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1202377508594_110FactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1202377508594_110FactoryImpl() {
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
		case Pattern_1202377508594_110Package.PATTERN_1202377508594_110:
			return createPattern_1202377508594_110();
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
	public Pattern_1202377508594_110 createPattern_1202377508594_110() {
		Pattern_1202377508594_110Impl pattern_1202377508594_110 = new Pattern_1202377508594_110Impl();
		return pattern_1202377508594_110;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1202377508594_110Package getPattern_1202377508594_110Package() {
		return (Pattern_1202377508594_110Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1202377508594_110Package getPackage() {
		return Pattern_1202377508594_110Package.eINSTANCE;
	}

} // Pattern_1202377508594_110FactoryImpl
