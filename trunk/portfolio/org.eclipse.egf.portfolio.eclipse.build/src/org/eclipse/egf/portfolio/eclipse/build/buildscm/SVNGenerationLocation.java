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

package org.eclipse.egf.portfolio.eclipse.build.buildscm;

import org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SVN Generation Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNGenerationLocation#getSvnLocation <em>Svn Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getSVNGenerationLocation()
 * @model
 * @generated
 */
public interface SVNGenerationLocation extends GenerationLocation {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Svn Location</b></em>' reference.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Svn Location</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Svn Location</em>' reference.
     * @see #setSvnLocation(SVNLocation)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getSVNGenerationLocation_SvnLocation()
     * @model required="true"
     * @generated
     */

    SVNLocation getSvnLocation();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNGenerationLocation#getSvnLocation <em>Svn Location</em>}' reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Svn Location</em>' reference.
     * @see #getSvnLocation()
     * @generated
     */

    void setSvnLocation(SVNLocation value);





} // SVNGenerationLocation
