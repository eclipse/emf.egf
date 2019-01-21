/**
 * 
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
 * 
 */
package org.eclipse.egf.model.fcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation Contract Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocationContracts <em>Invocation Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContractContainer()
 * @model
 * @generated
 */
public interface InvocationContractContainer extends ModelElement {

    /**
     * Returns the value of the '<em><b>Invocation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContractContainer <em>Invocation Contract Container</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invocation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invocation</em>' container reference.
     * @see #setInvocation(Invocation)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContractContainer_Invocation()
     * @see org.eclipse.egf.model.fcore.Invocation#getInvocationContractContainer
     * @model opposite="invocationContractContainer" resolveProxies="false" required="true" transient="false"
     * @generated
     */
    Invocation getInvocation();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocation <em>Invocation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Invocation</em>' container reference.
     * @see #getInvocation()
     * @generated
     */
    void setInvocation(Invocation value);

    /**
     * Returns the value of the '<em><b>Invocation Contracts</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContract}.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContract#getInvocationContractContainer <em>Invocation Contract Container</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invocation Contracts</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invocation Contracts</em>' containment reference list.
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContractContainer_InvocationContracts()
     * @see org.eclipse.egf.model.fcore.InvocationContract#getInvocationContractContainer
     * @model opposite="invocationContractContainer" containment="true"
     * @generated
     */
    EList<InvocationContract> getInvocationContracts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
    FactoryComponent getFactoryComponent();

} // InvocationContractContainer
