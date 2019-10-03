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

package org.eclipse.egf.portfolio.eclipse.build.buildscm.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNProtocol;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SVN Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNLocationImpl#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SVNLocationImpl extends EObjectImpl implements SVNLocation {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
    protected static final SVNProtocol PROTOCOL_EDEFAULT = SVNProtocol.HTTP;

    /**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
    protected SVNProtocol protocol = PROTOCOL_EDEFAULT;




    /**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
    protected static final String URL_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
    protected String url = URL_EDEFAULT;




    /**
	 * The default value of the '{@link #getLocalPath() <em>Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLocalPath()
	 * @generated
	 * @ordered
	 */
    protected static final String LOCAL_PATH_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getLocalPath() <em>Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLocalPath()
	 * @generated
	 * @ordered
	 */
    protected String localPath = LOCAL_PATH_EDEFAULT;




    /**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
    protected static final String USERNAME_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
    protected String username = USERNAME_EDEFAULT;




    /**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
    protected static final String PASSWORD_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
    protected String password = PASSWORD_EDEFAULT;



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SVNLocationImpl() {

		super();

	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return BuildscmPackage.Literals.SVN_LOCATION;
	}





    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public SVNProtocol getProtocol() {

		return protocol;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setProtocol(SVNProtocol newProtocol) {

		SVNProtocol oldProtocol = protocol;
		protocol = newProtocol == null ? PROTOCOL_EDEFAULT : newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_LOCATION__PROTOCOL, oldProtocol, protocol));

	}






    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public String getUrl() {

		return url;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setUrl(String newUrl) {

		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_LOCATION__URL, oldUrl, url));

	}






    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public String getLocalPath() {

		return localPath;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setLocalPath(String newLocalPath) {

		String oldLocalPath = localPath;
		localPath = newLocalPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_LOCATION__LOCAL_PATH, oldLocalPath, localPath));

	}






    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public String getUsername() {

		return username;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setUsername(String newUsername) {

		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_LOCATION__USERNAME, oldUsername, username));

	}






    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public String getPassword() {

		return password;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setPassword(String newPassword) {

		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_LOCATION__PASSWORD, oldPassword, password));

	}




    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuildscmPackage.SVN_LOCATION__PROTOCOL:
				return getProtocol();
			case BuildscmPackage.SVN_LOCATION__URL:
				return getUrl();
			case BuildscmPackage.SVN_LOCATION__LOCAL_PATH:
				return getLocalPath();
			case BuildscmPackage.SVN_LOCATION__USERNAME:
				return getUsername();
			case BuildscmPackage.SVN_LOCATION__PASSWORD:
				return getPassword();
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
			case BuildscmPackage.SVN_LOCATION__PROTOCOL:
				setProtocol((SVNProtocol)newValue);
				return;
			case BuildscmPackage.SVN_LOCATION__URL:
				setUrl((String)newValue);
				return;
			case BuildscmPackage.SVN_LOCATION__LOCAL_PATH:
				setLocalPath((String)newValue);
				return;
			case BuildscmPackage.SVN_LOCATION__USERNAME:
				setUsername((String)newValue);
				return;
			case BuildscmPackage.SVN_LOCATION__PASSWORD:
				setPassword((String)newValue);
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
			case BuildscmPackage.SVN_LOCATION__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
				return;
			case BuildscmPackage.SVN_LOCATION__URL:
				setUrl(URL_EDEFAULT);
				return;
			case BuildscmPackage.SVN_LOCATION__LOCAL_PATH:
				setLocalPath(LOCAL_PATH_EDEFAULT);
				return;
			case BuildscmPackage.SVN_LOCATION__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case BuildscmPackage.SVN_LOCATION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
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
			case BuildscmPackage.SVN_LOCATION__PROTOCOL:
				return protocol != PROTOCOL_EDEFAULT;
			case BuildscmPackage.SVN_LOCATION__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case BuildscmPackage.SVN_LOCATION__LOCAL_PATH:
				return LOCAL_PATH_EDEFAULT == null ? localPath != null : !LOCAL_PATH_EDEFAULT.equals(localPath);
			case BuildscmPackage.SVN_LOCATION__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case BuildscmPackage.SVN_LOCATION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
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
		result.append(" (protocol: ");
		result.append(protocol);
		result.append(", url: ");
		result.append(url);
		result.append(", localPath: ");
		result.append(localPath);
		result.append(", username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(')');
		return result.toString();
	}


} //SVNLocationImpl
