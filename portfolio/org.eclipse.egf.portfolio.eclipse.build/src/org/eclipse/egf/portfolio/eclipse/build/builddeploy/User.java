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

package org.eclipse.egf.portfolio.eclipse.build.builddeploy;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getLogin <em>Login</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getPermission <em>Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Login</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Login</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Login</em>' attribute.
     * @see #setLogin(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getUser_Login()
     * @model required="true"
     * @generated
     */

    String getLogin();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getLogin <em>Login</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Login</em>' attribute.
     * @see #getLogin()
     * @generated
     */

    void setLogin(String value);







    /**
     * Returns the value of the '<em><b>Permission</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Permission</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Permission</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType
     * @see #setPermission(PermissionType)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getUser_Permission()
     * @model required="true"
     * @generated
     */

    PermissionType getPermission();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User#getPermission <em>Permission</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Permission</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType
     * @see #getPermission()
     * @generated
     */

    void setPermission(PermissionType value);





} // User
