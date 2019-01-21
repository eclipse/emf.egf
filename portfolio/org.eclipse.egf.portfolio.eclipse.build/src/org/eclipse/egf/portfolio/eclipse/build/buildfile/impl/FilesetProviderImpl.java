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

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fileset Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl#getFilePaths <em>File Paths</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl#getDirPaths <em>Dir Paths</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl#getResultSteps <em>Result Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl#getInstallSteps <em>Install Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FilesetProviderImpl extends EObjectImpl implements FilesetProvider {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The cached value of the '{@link #getFilePaths() <em>File Paths</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilePaths()
     * @generated
     * @ordered
     */
    protected EList<String> filePaths;




    /**
     * The cached value of the '{@link #getDirPaths() <em>Dir Paths</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDirPaths()
     * @generated
     * @ordered
     */
    protected EList<String> dirPaths;


    /**
     * The cached value of the '{@link #getResultSteps() <em>Result Steps</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResultSteps()
     * @generated
     * @ordered
     */
    protected EList<ResultStep> resultSteps;




    /**
     * The cached value of the '{@link #getInstallSteps() <em>Install Steps</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstallSteps()
     * @generated
     * @ordered
     */
    protected EList<InstallStep> installSteps;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FilesetProviderImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildfilePackage.Literals.FILESET_PROVIDER;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getFilePaths() {

        if (filePaths == null) {
            filePaths = new EDataTypeUniqueEList<String>(String.class, this, BuildfilePackage.FILESET_PROVIDER__FILE_PATHS);
        }
        return filePaths;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getDirPaths() {

        if (dirPaths == null) {
            dirPaths = new EDataTypeUniqueEList<String>(String.class, this, BuildfilePackage.FILESET_PROVIDER__DIR_PATHS);
        }
        return dirPaths;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<ResultStep> getResultSteps() {

        if (resultSteps == null) {
            resultSteps = new EObjectResolvingEList<ResultStep>(ResultStep.class, this, BuildfilePackage.FILESET_PROVIDER__RESULT_STEPS);
        }
        return resultSteps;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<InstallStep> getInstallSteps() {

        if (installSteps == null) {
            installSteps = new EObjectResolvingEList<InstallStep>(InstallStep.class, this, BuildfilePackage.FILESET_PROVIDER__INSTALL_STEPS);
        }
        return installSteps;
    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildfilePackage.FILESET_PROVIDER__FILE_PATHS:
                return getFilePaths();
            case BuildfilePackage.FILESET_PROVIDER__DIR_PATHS:
                return getDirPaths();
            case BuildfilePackage.FILESET_PROVIDER__RESULT_STEPS:
                return getResultSteps();
            case BuildfilePackage.FILESET_PROVIDER__INSTALL_STEPS:
                return getInstallSteps();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BuildfilePackage.FILESET_PROVIDER__FILE_PATHS:
                getFilePaths().clear();
                getFilePaths().addAll((Collection<? extends String>)newValue);
                return;
            case BuildfilePackage.FILESET_PROVIDER__DIR_PATHS:
                getDirPaths().clear();
                getDirPaths().addAll((Collection<? extends String>)newValue);
                return;
            case BuildfilePackage.FILESET_PROVIDER__RESULT_STEPS:
                getResultSteps().clear();
                getResultSteps().addAll((Collection<? extends ResultStep>)newValue);
                return;
            case BuildfilePackage.FILESET_PROVIDER__INSTALL_STEPS:
                getInstallSteps().clear();
                getInstallSteps().addAll((Collection<? extends InstallStep>)newValue);
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
            case BuildfilePackage.FILESET_PROVIDER__FILE_PATHS:
                getFilePaths().clear();
                return;
            case BuildfilePackage.FILESET_PROVIDER__DIR_PATHS:
                getDirPaths().clear();
                return;
            case BuildfilePackage.FILESET_PROVIDER__RESULT_STEPS:
                getResultSteps().clear();
                return;
            case BuildfilePackage.FILESET_PROVIDER__INSTALL_STEPS:
                getInstallSteps().clear();
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
            case BuildfilePackage.FILESET_PROVIDER__FILE_PATHS:
                return filePaths != null && !filePaths.isEmpty();
            case BuildfilePackage.FILESET_PROVIDER__DIR_PATHS:
                return dirPaths != null && !dirPaths.isEmpty();
            case BuildfilePackage.FILESET_PROVIDER__RESULT_STEPS:
                return resultSteps != null && !resultSteps.isEmpty();
            case BuildfilePackage.FILESET_PROVIDER__INSTALL_STEPS:
                return installSteps != null && !installSteps.isEmpty();
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
        result.append(" (filePaths: ");
        result.append(filePaths);
        result.append(", dirPaths: ");
        result.append(dirPaths);
        result.append(')');
        return result.toString();
    }


} //FilesetProviderImpl
