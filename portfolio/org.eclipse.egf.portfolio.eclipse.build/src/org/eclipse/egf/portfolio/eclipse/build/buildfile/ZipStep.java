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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Zip Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getBaseDir <em>Base Dir</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getDestinationFilePath <em>Destination File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getZipStep()
 * @model
 * @generated
 */
public interface ZipStep extends FileStep, FilesetProvider {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Base Dir</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Dir</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Base Dir</em>' attribute.
     * @see #setBaseDir(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getZipStep_BaseDir()
     * @model required="true"
     * @generated
     */

    String getBaseDir();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getBaseDir <em>Base Dir</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Dir</em>' attribute.
     * @see #getBaseDir()
     * @generated
     */

    void setBaseDir(String value);




    /**
     * Returns the value of the '<em><b>Destination File Path</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Destination File Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Destination File Path</em>' attribute.
     * @see #setDestinationFilePath(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getZipStep_DestinationFilePath()
     * @model required="true"
     * @generated
     */

    String getDestinationFilePath();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getDestinationFilePath <em>Destination File Path</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Destination File Path</em>' attribute.
     * @see #getDestinationFilePath()
     * @generated
     */

    void setDestinationFilePath(String value);





} // ZipStep
