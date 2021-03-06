/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.MethodCall#getCalled <em>Called</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getMethodCall()
 * @model
 * @generated
 */
public interface MethodCall extends Call {

    /**
     * Returns the value of the '<em><b>Called</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Called</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Called</em>' reference.
     * @see #setCalled(PatternMethod)
     * @see org.eclipse.egf.model.pattern.PatternPackage#getMethodCall_Called()
     * @model required="true"
     * @generated
     */
    PatternMethod getCalled();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.pattern.MethodCall#getCalled <em>Called</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Called</em>' reference.
     * @see #getCalled()
     * @generated
     */
    void setCalled(PatternMethod value);

} // MethodCall
