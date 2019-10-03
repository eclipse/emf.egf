/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildscm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage
 * @generated
 */
public interface BuildscmFactory extends EFactory {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    BuildscmFactory eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.BuildscmFactoryImpl.init();

    /**
	 * Returns a new object of class '<em>SVN</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>SVN</em>'.
	 * @generated
	 */
    SVN createSVN();

    /**
	 * Returns a new object of class '<em>SVN Location</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>SVN Location</em>'.
	 * @generated
	 */
    SVNLocation createSVNLocation();

    /**
	 * Returns a new object of class '<em>SVN Build Location</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>SVN Build Location</em>'.
	 * @generated
	 */
    SVNBuildLocation createSVNBuildLocation();

    /**
	 * Returns a new object of class '<em>SVN Generation Location</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>SVN Generation Location</em>'.
	 * @generated
	 */
    SVNGenerationLocation createSVNGenerationLocation();

    /**
	 * Returns a new object of class '<em>GIT</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>GIT</em>'.
	 * @generated
	 */
    GIT createGIT();

    /**
	 * Returns a new object of class '<em>GIT Location</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>GIT Location</em>'.
	 * @generated
	 */
    GITLocation createGITLocation();

    /**
	 * Returns a new object of class '<em>GIT Build Location</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>GIT Build Location</em>'.
	 * @generated
	 */
    GITBuildLocation createGITBuildLocation();

    /**
	 * Returns a new object of class '<em>GIT Generation Location</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>GIT Generation Location</em>'.
	 * @generated
	 */
    GITGenerationLocation createGITGenerationLocation();

    /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    BuildscmPackage getBuildscmPackage();

} //BuildscmFactory
