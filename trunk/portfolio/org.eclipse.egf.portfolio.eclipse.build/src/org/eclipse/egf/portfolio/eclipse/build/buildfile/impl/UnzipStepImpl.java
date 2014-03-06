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

package org.eclipse.egf.portfolio.eclipse.build.buildfile.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unzip Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.UnzipStepImpl#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.UnzipStepImpl#getDestinationFolderPath <em>Destination Folder Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnzipStepImpl extends FileStepImpl implements UnzipStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getSourceFilePath() <em>Source File Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceFilePath()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_FILE_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourceFilePath() <em>Source File Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceFilePath()
     * @generated
     * @ordered
     */
    protected String sourceFilePath = SOURCE_FILE_PATH_EDEFAULT;




    /**
     * The default value of the '{@link #getDestinationFolderPath() <em>Destination Folder Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDestinationFolderPath()
     * @generated
     * @ordered
     */
    protected static final String DESTINATION_FOLDER_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDestinationFolderPath() <em>Destination Folder Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDestinationFolderPath()
     * @generated
     * @ordered
     */
    protected String destinationFolderPath = DESTINATION_FOLDER_PATH_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UnzipStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildfilePackage.Literals.UNZIP_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getSourceFilePath() {

        return sourceFilePath;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setSourceFilePath(String newSourceFilePath) {

        String oldSourceFilePath = sourceFilePath;
        sourceFilePath = newSourceFilePath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.UNZIP_STEP__SOURCE_FILE_PATH, oldSourceFilePath, sourceFilePath));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getDestinationFolderPath() {

        return destinationFolderPath;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setDestinationFolderPath(String newDestinationFolderPath) {

        String oldDestinationFolderPath = destinationFolderPath;
        destinationFolderPath = newDestinationFolderPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.UNZIP_STEP__DESTINATION_FOLDER_PATH, oldDestinationFolderPath, destinationFolderPath));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildfilePackage.UNZIP_STEP__SOURCE_FILE_PATH:
                return getSourceFilePath();
            case BuildfilePackage.UNZIP_STEP__DESTINATION_FOLDER_PATH:
                return getDestinationFolderPath();
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
            case BuildfilePackage.UNZIP_STEP__SOURCE_FILE_PATH:
                setSourceFilePath((String)newValue);
                return;
            case BuildfilePackage.UNZIP_STEP__DESTINATION_FOLDER_PATH:
                setDestinationFolderPath((String)newValue);
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
            case BuildfilePackage.UNZIP_STEP__SOURCE_FILE_PATH:
                setSourceFilePath(SOURCE_FILE_PATH_EDEFAULT);
                return;
            case BuildfilePackage.UNZIP_STEP__DESTINATION_FOLDER_PATH:
                setDestinationFolderPath(DESTINATION_FOLDER_PATH_EDEFAULT);
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
            case BuildfilePackage.UNZIP_STEP__SOURCE_FILE_PATH:
                return SOURCE_FILE_PATH_EDEFAULT == null ? sourceFilePath != null : !SOURCE_FILE_PATH_EDEFAULT.equals(sourceFilePath);
            case BuildfilePackage.UNZIP_STEP__DESTINATION_FOLDER_PATH:
                return DESTINATION_FOLDER_PATH_EDEFAULT == null ? destinationFolderPath != null : !DESTINATION_FOLDER_PATH_EDEFAULT.equals(destinationFolderPath);
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
        result.append(" (sourceFilePath: ");
        result.append(sourceFilePath);
        result.append(", destinationFolderPath: ");
        result.append(destinationFolderPath);
        result.append(')');
        return result.toString();
    }


} //UnzipStepImpl
