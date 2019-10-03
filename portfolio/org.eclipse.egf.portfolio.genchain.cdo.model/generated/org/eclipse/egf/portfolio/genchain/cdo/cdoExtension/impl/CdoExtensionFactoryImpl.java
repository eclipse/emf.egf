/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl;

import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.*;
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
public class CdoExtensionFactoryImpl extends EFactoryImpl implements CdoExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CdoExtensionFactory init() {
		try {
			CdoExtensionFactory theCdoExtensionFactory = (CdoExtensionFactory)EPackage.Registry.INSTANCE.getEFactory(CdoExtensionPackage.eNS_URI);
			if (theCdoExtensionFactory != null) {
				return theCdoExtensionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CdoExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CdoExtensionFactoryImpl() {
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
			case CdoExtensionPackage.CDO_GENERATION: return createCdoGeneration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CdoGeneration createCdoGeneration() {
		CdoGenerationImpl cdoGeneration = new CdoGenerationImpl();
		return cdoGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CdoExtensionPackage getCdoExtensionPackage() {
		return (CdoExtensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CdoExtensionPackage getPackage() {
		return CdoExtensionPackage.eINSTANCE;
	}

} //CdoExtensionFactoryImpl
