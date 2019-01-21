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

package org.eclipse.egf.portfolio.eclipse.build.buildfile;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fileset Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getFilePaths <em>File Paths</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getDirPaths <em>Dir Paths</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getResultSteps <em>Result Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getInstallSteps <em>Install Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getFilesetProvider()
 * @model abstract="true"
 * @generated
 */
public interface FilesetProvider extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>File Paths</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Paths</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Paths</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getFilesetProvider_FilePaths()
     * @model
     * @generated
     */

    EList<String> getFilePaths();







    /**
     * Returns the value of the '<em><b>Dir Paths</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dir Paths</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dir Paths</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getFilesetProvider_DirPaths()
     * @model
     * @generated
     */

    EList<String> getDirPaths();







    /**
     * Returns the value of the '<em><b>Result Steps</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Result Steps</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Result Steps</em>' reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getFilesetProvider_ResultSteps()
     * @model
     * @generated
     */

    EList<ResultStep> getResultSteps();







    /**
     * Returns the value of the '<em><b>Install Steps</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Install Steps</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Install Steps</em>' reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getFilesetProvider_InstallSteps()
     * @model
     * @generated
     */

    EList<InstallStep> getInstallSteps();





} // FilesetProvider
