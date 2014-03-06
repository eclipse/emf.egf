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

package org.eclipse.egf.portfolio.eclipse.build.buildfile;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rename Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getSourcePath <em>Source Path</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getDestinationPath <em>Destination Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getRenameStep()
 * @model
 * @generated
 */
public interface RenameStep extends FileStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Source Path</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Path</em>' attribute.
     * @see #setSourcePath(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getRenameStep_SourcePath()
     * @model required="true"
     * @generated
     */

    String getSourcePath();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getSourcePath <em>Source Path</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Path</em>' attribute.
     * @see #getSourcePath()
     * @generated
     */

    void setSourcePath(String value);







    /**
     * Returns the value of the '<em><b>Destination Path</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Destination Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Destination Path</em>' attribute.
     * @see #setDestinationPath(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getRenameStep_DestinationPath()
     * @model required="true"
     * @generated
     */

    String getDestinationPath();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getDestinationPath <em>Destination Path</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Destination Path</em>' attribute.
     * @see #getDestinationPath()
     * @generated
     */

    void setDestinationPath(String value);





} // RenameStep
