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
package org.eclipse.egf.model.mapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.mapping.MappingPackage
 * @generated
 */
public interface MappingFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MappingFactory eINSTANCE = org.eclipse.egf.model.mapping.impl.MappingFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Viewpoint</em>'.
     * @generated
     */
    MappingViewpoint createMappingViewpoint();

    /**
     * Returns a new object of class '<em>Domain</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Domain</em>'.
     * @generated
     */
    MappingDomain createMappingDomain();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MappingPackage getMappingPackage();

} // MappingFactory
