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

package org.eclipse.egf.portfolio.eclipse.build.buildfile.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Download Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DownloadStepImpl#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DownloadStepImpl#getDestinationFilePath <em>Destination File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DownloadStepImpl extends FileStepImpl implements DownloadStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


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
     * The default value of the '{@link #getDestinationFilePath() <em>Destination File Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDestinationFilePath()
     * @generated
     * @ordered
     */
    protected static final String DESTINATION_FILE_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDestinationFilePath() <em>Destination File Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDestinationFilePath()
     * @generated
     * @ordered
     */
    protected String destinationFilePath = DESTINATION_FILE_PATH_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DownloadStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildfilePackage.Literals.DOWNLOAD_STEP;
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
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.DOWNLOAD_STEP__SOURCE_FILE_PATH, oldSourceFilePath, sourceFilePath));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getDestinationFilePath() {

        return destinationFilePath;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setDestinationFilePath(String newDestinationFilePath) {

        String oldDestinationFilePath = destinationFilePath;
        destinationFilePath = newDestinationFilePath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.DOWNLOAD_STEP__DESTINATION_FILE_PATH, oldDestinationFilePath, destinationFilePath));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildfilePackage.DOWNLOAD_STEP__SOURCE_FILE_PATH:
                return getSourceFilePath();
            case BuildfilePackage.DOWNLOAD_STEP__DESTINATION_FILE_PATH:
                return getDestinationFilePath();
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
            case BuildfilePackage.DOWNLOAD_STEP__SOURCE_FILE_PATH:
                setSourceFilePath((String)newValue);
                return;
            case BuildfilePackage.DOWNLOAD_STEP__DESTINATION_FILE_PATH:
                setDestinationFilePath((String)newValue);
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
            case BuildfilePackage.DOWNLOAD_STEP__SOURCE_FILE_PATH:
                setSourceFilePath(SOURCE_FILE_PATH_EDEFAULT);
                return;
            case BuildfilePackage.DOWNLOAD_STEP__DESTINATION_FILE_PATH:
                setDestinationFilePath(DESTINATION_FILE_PATH_EDEFAULT);
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
            case BuildfilePackage.DOWNLOAD_STEP__SOURCE_FILE_PATH:
                return SOURCE_FILE_PATH_EDEFAULT == null ? sourceFilePath != null : !SOURCE_FILE_PATH_EDEFAULT.equals(sourceFilePath);
            case BuildfilePackage.DOWNLOAD_STEP__DESTINATION_FILE_PATH:
                return DESTINATION_FILE_PATH_EDEFAULT == null ? destinationFilePath != null : !DESTINATION_FILE_PATH_EDEFAULT.equals(destinationFilePath);
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
        result.append(", destinationFilePath: ");
        result.append(destinationFilePath);
        result.append(')');
        return result.toString();
    }


} //DownloadStepImpl
