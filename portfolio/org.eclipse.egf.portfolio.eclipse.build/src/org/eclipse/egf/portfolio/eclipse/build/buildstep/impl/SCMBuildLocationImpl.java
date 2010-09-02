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

package org.eclipse.egf.portfolio.eclipse.build.buildstep.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.SCMLocation;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.SCMBuildLocation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCM Build Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.SCMBuildLocationImpl#getScmLocation <em>Scm Location</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.SCMBuildLocationImpl#getFolderName <em>Folder Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCMBuildLocationImpl extends SourceBuildLocationImpl implements SCMBuildLocation {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The cached value of the '{@link #getScmLocation() <em>Scm Location</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScmLocation()
     * @generated
     * @ordered
     */
    protected SCMLocation scmLocation;




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
    protected SCMBuildLocationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.SCM_BUILD_LOCATION;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public SCMLocation getScmLocation() {

        if (scmLocation != null && scmLocation.eIsProxy()) {
            InternalEObject oldScmLocation = (InternalEObject)scmLocation;
            scmLocation = (SCMLocation)eResolveProxy(oldScmLocation);
            if (scmLocation != oldScmLocation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuildstepPackage.SCM_BUILD_LOCATION__SCM_LOCATION, oldScmLocation, scmLocation));
            }
        }
        return scmLocation;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public SCMLocation basicGetScmLocation() {

        return scmLocation;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setScmLocation(SCMLocation newScmLocation) {

        SCMLocation oldScmLocation = scmLocation;
        scmLocation = newScmLocation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.SCM_BUILD_LOCATION__SCM_LOCATION, oldScmLocation, scmLocation));

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
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.SCM_BUILD_LOCATION__FOLDER_NAME, oldFolderName, folderName));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.SCM_BUILD_LOCATION__SCM_LOCATION:
                if (resolve) return getScmLocation();
                return basicGetScmLocation();
            case BuildstepPackage.SCM_BUILD_LOCATION__FOLDER_NAME:
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
            case BuildstepPackage.SCM_BUILD_LOCATION__SCM_LOCATION:
                setScmLocation((SCMLocation)newValue);
                return;
            case BuildstepPackage.SCM_BUILD_LOCATION__FOLDER_NAME:
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
            case BuildstepPackage.SCM_BUILD_LOCATION__SCM_LOCATION:
                setScmLocation((SCMLocation)null);
                return;
            case BuildstepPackage.SCM_BUILD_LOCATION__FOLDER_NAME:
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
            case BuildstepPackage.SCM_BUILD_LOCATION__SCM_LOCATION:
                return scmLocation != null;
            case BuildstepPackage.SCM_BUILD_LOCATION__FOLDER_NAME:
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


} //SCMBuildLocationImpl
