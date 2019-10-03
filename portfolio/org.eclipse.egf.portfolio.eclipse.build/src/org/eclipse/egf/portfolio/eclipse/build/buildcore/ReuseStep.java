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

package org.eclipse.egf.portfolio.eclipse.build.buildcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reuse Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep#getReusedStep <em>Reused Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getReuseStep()
 * @model
 * @generated
 */
public interface ReuseStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Reused Step</b></em>' reference.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reused Step</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reused Step</em>' reference.
     * @see #setReusedStep(Step)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getReuseStep_ReusedStep()
     * @model required="true"
     * @generated
     */

    Step getReusedStep();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep#getReusedStep <em>Reused Step</em>}' reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reused Step</em>' reference.
     * @see #getReusedStep()
     * @generated
     */

    void setReusedStep(Step value);





} // ReuseStep
