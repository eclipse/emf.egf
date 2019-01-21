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
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.SourceBuildLocationImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SVN Build Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNBuildLocationImpl#getSvnLocation <em>Svn Location</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNBuildLocationImpl#getFolderName <em>Folder Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SVNBuildLocationImpl extends SourceBuildLocationImpl implements SVNBuildLocation {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
	 * The cached value of the '{@link #getSvnLocation() <em>Svn Location</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSvnLocation()
	 * @generated
	 * @ordered
	 */
    protected SVNLocation svnLocation;




    /**
	 * The default value of the '{@link #getFolderName() <em>Folder Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFolderName()
	 * @generated
	 * @ordered
	 */
    protected static final String FOLDER_NAME_EDEFAULT = "";

    /**
	 * The cached value of the '{@link #getFolderName() <em>Folder Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFolderName()
	 * @generated
	 * @ordered
	 */
    protected String folderName = FOLDER_NAME_EDEFAULT;



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SVNBuildLocationImpl() {

		super();

	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return BuildscmPackage.Literals.SVN_BUILD_LOCATION;
	}





    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public SVNLocation getSvnLocation() {

		if (svnLocation != null && svnLocation.eIsProxy()) {
			InternalEObject oldSvnLocation = (InternalEObject)svnLocation;
			svnLocation = (SVNLocation)eResolveProxy(oldSvnLocation);
			if (svnLocation != oldSvnLocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuildscmPackage.SVN_BUILD_LOCATION__SVN_LOCATION, oldSvnLocation, svnLocation));
			}
		}
		return svnLocation;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public SVNLocation basicGetSvnLocation() {

		return svnLocation;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setSvnLocation(SVNLocation newSvnLocation) {

		SVNLocation oldSvnLocation = svnLocation;
		svnLocation = newSvnLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_BUILD_LOCATION__SVN_LOCATION, oldSvnLocation, svnLocation));

	}






    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public String getFolderName() {

		return folderName;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setFolderName(String newFolderName) {

		String oldFolderName = folderName;
		folderName = newFolderName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_BUILD_LOCATION__FOLDER_NAME, oldFolderName, folderName));

	}




    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuildscmPackage.SVN_BUILD_LOCATION__SVN_LOCATION:
				if (resolve) return getSvnLocation();
				return basicGetSvnLocation();
			case BuildscmPackage.SVN_BUILD_LOCATION__FOLDER_NAME:
				return getFolderName();
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
			case BuildscmPackage.SVN_BUILD_LOCATION__SVN_LOCATION:
				setSvnLocation((SVNLocation)newValue);
				return;
			case BuildscmPackage.SVN_BUILD_LOCATION__FOLDER_NAME:
				setFolderName((String)newValue);
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
			case BuildscmPackage.SVN_BUILD_LOCATION__SVN_LOCATION:
				setSvnLocation((SVNLocation)null);
				return;
			case BuildscmPackage.SVN_BUILD_LOCATION__FOLDER_NAME:
				setFolderName(FOLDER_NAME_EDEFAULT);
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
			case BuildscmPackage.SVN_BUILD_LOCATION__SVN_LOCATION:
				return svnLocation != null;
			case BuildscmPackage.SVN_BUILD_LOCATION__FOLDER_NAME:
				return FOLDER_NAME_EDEFAULT == null ? folderName != null : !FOLDER_NAME_EDEFAULT.equals(folderName);
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
		result.append(" (folderName: ");
		result.append(folderName);
		result.append(')');
		return result.toString();
	}


} //SVNBuildLocationImpl
