/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.domain;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.domain.DomainPackage
 * @generated
 */
public interface DomainFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DomainFactory eINSTANCE = org.eclipse.egf.model.domain.impl.DomainFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Viewpoint</em>'.
     * @generated
     */
    DomainViewpoint createDomainViewpoint();

    /**
     * Returns a new object of class '<em>Type Gen Packages</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Gen Packages</em>'.
     * @generated
     */
    TypeGenPackages createTypeGenPackages();

    /**
     * Returns a new object of class '<em>EMF Domain</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>EMF Domain</em>'.
     * @generated
     */
    EMFDomain createEMFDomain();

    /**
     * Returns a new object of class '<em>Type Domain</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Domain</em>'.
     * @generated
     */
    TypeDomain createTypeDomain();

    /**
     * Returns a new object of class '<em>Filesystem Domain</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Filesystem Domain</em>'.
     * @generated
     */
    FilesystemDomain createFilesystemDomain();

    /**
     * Returns a new object of class '<em>Workspace Domain</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Workspace Domain</em>'.
     * @generated
     */
    WorkspaceDomain createWorkspaceDomain();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    DomainPackage getDomainPackage();

} // DomainFactory
