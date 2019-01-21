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

package org.eclipse.egf.portfolio.eclipse.build.buildfile;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage
 * @generated
 */
public interface BuildfileFactory extends EFactory {
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
    BuildfileFactory eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfileFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Ant Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ant Parameter</em>'.
     * @generated
     */
    AntParameter createAntParameter();

    /**
     * Returns a new object of class '<em>Zip Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Zip Step</em>'.
     * @generated
     */
    ZipStep createZipStep();

    /**
     * Returns a new object of class '<em>Unzip Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Unzip Step</em>'.
     * @generated
     */
    UnzipStep createUnzipStep();

    /**
     * Returns a new object of class '<em>Move Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Move Step</em>'.
     * @generated
     */
    MoveStep createMoveStep();

    /**
     * Returns a new object of class '<em>Rename Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Rename Step</em>'.
     * @generated
     */
    RenameStep createRenameStep();

    /**
     * Returns a new object of class '<em>Delete Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Delete Step</em>'.
     * @generated
     */
    DeleteStep createDeleteStep();

    /**
     * Returns a new object of class '<em>Copy Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Copy Step</em>'.
     * @generated
     */
    CopyStep createCopyStep();

    /**
     * Returns a new object of class '<em>Download Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Download Step</em>'.
     * @generated
     */
    DownloadStep createDownloadStep();

    /**
     * Returns a new object of class '<em>Create Folder Step</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Create Folder Step</em>'.
     * @generated
     */
    CreateFolderStep createCreateFolderStep();

    /**
     * Returns a new object of class '<em>Tar Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tar Step</em>'.
     * @generated
     */
	TarStep createTarStep();

				/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    BuildfilePackage getBuildfilePackage();

} //BuildfileFactory
