/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties#getPropertyPackages <em>Property Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getItemProperties()
 * @model abstract="true"
 * @generated
 */
public interface ItemProperties extends Item {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Property}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getItemProperties_Properties()
     * @model containment="true"
     * @generated
     */

    EList<Property> getProperties();






    /**
     * Returns the value of the '<em><b>Property Packages</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyPackage}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property Packages</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property Packages</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getItemProperties_PropertyPackages()
     * @model containment="true"
     * @generated
     */

    EList<PropertyPackage> getPropertyPackages();





} // ItemProperties
