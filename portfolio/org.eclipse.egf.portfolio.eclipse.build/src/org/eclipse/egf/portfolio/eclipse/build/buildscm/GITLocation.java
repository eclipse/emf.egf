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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GIT Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getUsername <em>Username</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITLocation()
 * @model
 * @generated
 */
public interface GITLocation extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Protocol</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITProtocol}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.GITProtocol
     * @see #setProtocol(GITProtocol)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITLocation_Protocol()
     * @model required="true"
     * @generated
     */

    GITProtocol getProtocol();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getProtocol <em>Protocol</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.GITProtocol
     * @see #getProtocol()
     * @generated
     */

    void setProtocol(GITProtocol value);







    /**
     * Returns the value of the '<em><b>Url</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITLocation_Url()
     * @model required="true"
     * @generated
     */

    String getUrl();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getUrl <em>Url</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */

    void setUrl(String value);







    /**
     * Returns the value of the '<em><b>Username</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Username</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Username</em>' attribute.
     * @see #setUsername(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITLocation_Username()
     * @model
     * @generated
     */

    String getUsername();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getUsername <em>Username</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Username</em>' attribute.
     * @see #getUsername()
     * @generated
     */

    void setUsername(String value);







    /**
     * Returns the value of the '<em><b>Password</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password</em>' attribute.
     * @see #setPassword(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage#getGITLocation_Password()
     * @model
     * @generated
     */

    String getPassword();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation#getPassword <em>Password</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' attribute.
     * @see #getPassword()
     * @generated
     */

    void setPassword(String value);





} // GITLocation
