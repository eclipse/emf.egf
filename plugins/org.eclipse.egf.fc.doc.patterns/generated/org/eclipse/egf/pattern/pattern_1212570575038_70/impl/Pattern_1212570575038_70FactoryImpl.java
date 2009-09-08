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
package org.eclipse.egf.pattern.pattern_1212570575038_70.impl;

import org.eclipse.egf.pattern.pattern_1212570575038_70.*;

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
public class Pattern_1212570575038_70FactoryImpl extends EFactoryImpl implements Pattern_1212570575038_70Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pattern_1212570575038_70Factory init() {
		try {
			Pattern_1212570575038_70Factory thePattern_1212570575038_70Factory = (Pattern_1212570575038_70Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1212570575038.70"); //$NON-NLS-1$ 
			if (thePattern_1212570575038_70Factory != null) {
				return thePattern_1212570575038_70Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1212570575038_70FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1212570575038_70FactoryImpl() {
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
			case Pattern_1212570575038_70Package.TOC: return createToc();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Toc createToc() {
		TocImpl toc = new TocImpl();
		return toc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1212570575038_70Package getPattern_1212570575038_70Package() {
		return (Pattern_1212570575038_70Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1212570575038_70Package getPackage() {
		return Pattern_1212570575038_70Package.eINSTANCE;
	}

} //Pattern_1212570575038_70FactoryImpl
