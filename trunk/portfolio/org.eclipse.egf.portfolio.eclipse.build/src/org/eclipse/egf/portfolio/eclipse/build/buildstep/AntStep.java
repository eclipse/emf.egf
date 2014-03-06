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

package org.eclipse.egf.portfolio.eclipse.build.buildstep;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ant Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getXml <em>Xml</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#isRunInEclipse <em>Run In Eclipse</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAntStep()
 * @model
 * @generated
 */
public interface AntStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Target Name</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Name</em>' attribute.
     * @see #setTargetName(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAntStep_TargetName()
     * @model required="true"
     * @generated
     */

    String getTargetName();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getTargetName <em>Target Name</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Name</em>' attribute.
     * @see #getTargetName()
     * @generated
     */

    void setTargetName(String value);







    /**
     * Returns the value of the '<em><b>Xml</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xml</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xml</em>' attribute.
     * @see #setXml(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAntStep_Xml()
     * @model required="true"
     * @generated
     */

    String getXml();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#getXml <em>Xml</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xml</em>' attribute.
     * @see #getXml()
     * @generated
     */

    void setXml(String value);







    /**
     * Returns the value of the '<em><b>Run In Eclipse</b></em>' attribute.
     * The default value is <code>"false"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Run In Eclipse</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Run In Eclipse</em>' attribute.
     * @see #setRunInEclipse(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAntStep_RunInEclipse()
     * @model default="false"
     * @generated
     */

    boolean isRunInEclipse();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep#isRunInEclipse <em>Run In Eclipse</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Run In Eclipse</em>' attribute.
     * @see #isRunInEclipse()
     * @generated
     */

    void setRunInEclipse(boolean value);





} // AntStep
