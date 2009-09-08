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
package org.eclipse.egf.pattern.pattern_1212569887715_48.impl;

import org.eclipse.egf.pattern.pattern_1212569887715_48.*;

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
public class Pattern_1212569887715_48FactoryImpl extends EFactoryImpl implements Pattern_1212569887715_48Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pattern_1212569887715_48Factory init() {
		try {
			Pattern_1212569887715_48Factory thePattern_1212569887715_48Factory = (Pattern_1212569887715_48Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1212569887715.48"); //$NON-NLS-1$ 
			if (thePattern_1212569887715_48Factory != null) {
				return thePattern_1212569887715_48Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pattern_1212569887715_48FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1212569887715_48FactoryImpl() {
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
			case Pattern_1212569887715_48Package.HTML_FC_DOC: return createHtmlFcDoc();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HtmlFcDoc createHtmlFcDoc() {
		HtmlFcDocImpl htmlFcDoc = new HtmlFcDocImpl();
		return htmlFcDoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1212569887715_48Package getPattern_1212569887715_48Package() {
		return (Pattern_1212569887715_48Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pattern_1212569887715_48Package getPackage() {
		return Pattern_1212569887715_48Package.eINSTANCE;
	}

} //Pattern_1212569887715_48FactoryImpl
