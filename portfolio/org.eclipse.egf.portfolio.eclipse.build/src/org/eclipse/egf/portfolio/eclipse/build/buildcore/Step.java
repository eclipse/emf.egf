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

package org.eclipse.egf.portfolio.eclipse.build.buildcore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getJob <em>Job</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getStep()
 * @model abstract="true"
 * @generated
 */
public interface Step extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Job</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getSteps <em>Steps</em>}'.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Job</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Job</em>' container reference.
     * @see #setJob(Job)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getStep_Job()
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getSteps
     * @model opposite="steps" required="true" transient="false"
     * @generated
     */

    Job getJob();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getJob <em>Job</em>}' container reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Job</em>' container reference.
     * @see #getJob()
     * @generated
     */

    void setJob(Job value);





} // Step