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

package org.eclipse.egf.portfolio.eclipse.build.buildscm;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GIT Build Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation#getGitLocation <em>Git Location</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation#getFolderName <em>Folder Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITBuildLocation()
 * @model
 * @generated
 */
public interface GITBuildLocation extends SourceBuildLocation {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
	 * Returns the value of the '<em><b>Git Location</b></em>' reference.

	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Git Location</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Git Location</em>' reference.
	 * @see #setGitLocation(GITLocation)
	 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITBuildLocation_GitLocation()
	 * @model required="true"
	 * @generated
	 */

    GITLocation getGitLocation();




    /**
	 * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation#getGitLocation <em>Git Location</em>}' reference.

	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Git Location</em>' reference.
	 * @see #getGitLocation()
	 * @generated
	 */

    void setGitLocation(GITLocation value);







    /**
	 * Returns the value of the '<em><b>Folder Name</b></em>' attribute.
	 * The default value is <code>""</code>.

	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Folder Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Folder Name</em>' attribute.
	 * @see #setFolderName(String)
	 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITBuildLocation_FolderName()
	 * @model default="" required="true"
	 * @generated
	 */

    String getFolderName();




    /**
	 * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation#getFolderName <em>Folder Name</em>}' attribute.

	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder Name</em>' attribute.
	 * @see #getFolderName()
	 * @generated
	 */

    void setFolderName(String value);





} // GITBuildLocation
