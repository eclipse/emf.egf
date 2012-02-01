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
import org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rename Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.RenameStepImpl#getSourcePath <em>Source Path</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.RenameStepImpl#getDestinationPath <em>Destination Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RenameStepImpl extends FileStepImpl implements RenameStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getSourcePath() <em>Source Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourcePath()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourcePath() <em>Source Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourcePath()
     * @generated
     * @ordered
     */
    protected String sourcePath = SOURCE_PATH_EDEFAULT;




    /**
     * The default value of the '{@link #getDestinationPath() <em>Destination Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDestinationPath()
     * @generated
     * @ordered
     */
    protected static final String DESTINATION_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDestinationPath() <em>Destination Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDestinationPath()
     * @generated
     * @ordered
     */
    protected String destinationPath = DESTINATION_PATH_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RenameStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildfilePackage.Literals.RENAME_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getSourcePath() {

        return sourcePath;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setSourcePath(String newSourcePath) {

        String oldSourcePath = sourcePath;
        sourcePath = newSourcePath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.RENAME_STEP__SOURCE_PATH, oldSourcePath, sourcePath));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getDestinationPath() {

        return destinationPath;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setDestinationPath(String newDestinationPath) {

        String oldDestinationPath = destinationPath;
        destinationPath = newDestinationPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.RENAME_STEP__DESTINATION_PATH, oldDestinationPath, destinationPath));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildfilePackage.RENAME_STEP__SOURCE_PATH:
                return getSourcePath();
            case BuildfilePackage.RENAME_STEP__DESTINATION_PATH:
                return getDestinationPath();
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
            case BuildfilePackage.RENAME_STEP__SOURCE_PATH:
                setSourcePath((String)newValue);
                return;
            case BuildfilePackage.RENAME_STEP__DESTINATION_PATH:
                setDestinationPath((String)newValue);
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
            case BuildfilePackage.RENAME_STEP__SOURCE_PATH:
                setSourcePath(SOURCE_PATH_EDEFAULT);
                return;
            case BuildfilePackage.RENAME_STEP__DESTINATION_PATH:
                setDestinationPath(DESTINATION_PATH_EDEFAULT);
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
            case BuildfilePackage.RENAME_STEP__SOURCE_PATH:
                return SOURCE_PATH_EDEFAULT == null ? sourcePath != null : !SOURCE_PATH_EDEFAULT.equals(sourcePath);
            case BuildfilePackage.RENAME_STEP__DESTINATION_PATH:
                return DESTINATION_PATH_EDEFAULT == null ? destinationPath != null : !DESTINATION_PATH_EDEFAULT.equals(destinationPath);
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
        result.append(" (sourcePath: ");
        result.append(sourcePath);
        result.append(", destinationPath: ");
        result.append(destinationPath);
        result.append(')');
        return result.toString();
    }


} //RenameStepImpl
