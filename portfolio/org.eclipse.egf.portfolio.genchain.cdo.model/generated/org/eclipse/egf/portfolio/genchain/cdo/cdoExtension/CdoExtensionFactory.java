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
package org.eclipse.egf.portfolio.genchain.cdo.cdoExtension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage
 * @generated
 */
public interface CdoExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CdoExtensionFactory eINSTANCE = org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Cdo Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cdo Generation</em>'.
	 * @generated
	 */
	CdoGeneration createCdoGeneration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CdoExtensionPackage getCdoExtensionPackage();

} //CdoExtensionFactory
