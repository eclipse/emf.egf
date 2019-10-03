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

package org.eclipse.egf.portfolio.eclipse.build.buildstep;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clean Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getCleanStep()
 * @model
 * @generated
 */
public interface CleanStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The default value is <code>"Workspace"</code>.
     * The literals are from the enumeration {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE
     * @see #setType(CLEAN_TYPE)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getCleanStep_Type()
     * @model default="Workspace" required="true"
     * @generated
     */

    CLEAN_TYPE getType();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep#getType <em>Type</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE
     * @see #getType()
     * @generated
     */

    void setType(CLEAN_TYPE value);





} // CleanStep
