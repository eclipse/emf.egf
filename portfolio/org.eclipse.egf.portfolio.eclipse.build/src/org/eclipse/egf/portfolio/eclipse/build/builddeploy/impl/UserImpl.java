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

package org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl;

import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.PermissionType;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.User;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.UserImpl#getLogin <em>Login</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.UserImpl#getPermission <em>Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends EObjectImpl implements User {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected static final String LOGIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected String login = LOGIN_EDEFAULT;




    /**
     * The default value of the '{@link #getPermission() <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPermission()
     * @generated
     * @ordered
     */
    protected static final PermissionType PERMISSION_EDEFAULT = PermissionType.READ;

    /**
     * The cached value of the '{@link #getPermission() <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPermission()
     * @generated
     * @ordered
     */
    protected PermissionType permission = PERMISSION_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UserImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuilddeployPackage.Literals.USER;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getLogin() {

        return login;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setLogin(String newLogin) {

        String oldLogin = login;
        login = newLogin;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.USER__LOGIN, oldLogin, login));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public PermissionType getPermission() {

        return permission;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setPermission(PermissionType newPermission) {

        PermissionType oldPermission = permission;
        permission = newPermission == null ? PERMISSION_EDEFAULT : newPermission;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuilddeployPackage.USER__PERMISSION, oldPermission, permission));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuilddeployPackage.USER__LOGIN:
                return getLogin();
            case BuilddeployPackage.USER__PERMISSION:
                return getPermission();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BuilddeployPackage.USER__LOGIN:
                setLogin((String)newValue);
                return;
            case BuilddeployPackage.USER__PERMISSION:
                setPermission((PermissionType)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case BuilddeployPackage.USER__LOGIN:
                setLogin(LOGIN_EDEFAULT);
                return;
            case BuilddeployPackage.USER__PERMISSION:
                setPermission(PERMISSION_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case BuilddeployPackage.USER__LOGIN:
                return LOGIN_EDEFAULT == null ? login != null : !LOGIN_EDEFAULT.equals(login);
            case BuilddeployPackage.USER__PERMISSION:
                return permission != PERMISSION_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (login: ");
        result.append(login);
        result.append(", permission: ");
        result.append(permission);
        result.append(')');
        return result.toString();
    }


} //UserImpl
