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

package org.eclipse.egf.portfolio.eclipse.build.buildcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getItem()
 * @model
 * @generated
 */
public interface Item extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getItem_Name()
     * @model
     * @generated
     */

    String getName();






    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getName <em>Name</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */

    void setName(String value);






    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getItem_Description()
     * @model
     * @generated
     */

    String getDescription();






    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getDescription <em>Description</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */

    void setDescription(String value);






    /**
     * Returns the value of the '<em><b>Enabled</b></em>' attribute.
     * The default value is <code>"true"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enabled</em>' attribute.
     * @see #setEnabled(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getItem_Enabled()
     * @model default="true"
     * @generated
     */

    boolean isEnabled();






    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#isEnabled <em>Enabled</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enabled</em>' attribute.
     * @see #isEnabled()
     * @generated
     */

    void setEnabled(boolean value);





} // Item
