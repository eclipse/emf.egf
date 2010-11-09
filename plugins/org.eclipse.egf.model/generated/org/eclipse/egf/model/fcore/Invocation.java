/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore;

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContractContainer <em>Invocation Contract Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Invocation#getInvokedActivity <em>Invoked Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MandatoryInvokedContract'"
 * @generated
 */
public interface Invocation extends NamedModelElement {

    /**
     * Returns the value of the '<em><b>Invocation Contract Container</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocation <em>Invocation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invocation Contract Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invocation Contract Container</em>' containment reference.
     * @see #setInvocationContractContainer(InvocationContractContainer)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation_InvocationContractContainer()
     * @see org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocation
     * @model opposite="invocation" containment="true"
     * @generated
     */
    InvocationContractContainer getInvocationContractContainer();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContractContainer <em>Invocation Contract Container</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Invocation Contract Container</em>' containment reference.
     * @see #getInvocationContractContainer()
     * @generated
     */
    void setInvocationContractContainer(InvocationContractContainer value);

    /**
     * Returns the value of the '<em><b>Invoked Activity</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invoked Activity</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invoked Activity</em>' reference.
     * @see #setInvokedActivity(Activity)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation_InvokedActivity()
     * @model required="true"
     * @generated
     */
    Activity getInvokedActivity();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.Invocation#getInvokedActivity <em>Invoked Activity</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Invoked Activity</em>' reference.
     * @see #getInvokedActivity()
     * @generated
     */
    void setInvokedActivity(Activity value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
    FactoryComponent getFactoryComponent();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    EList<InvocationContract> getInvocationContracts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<InvocationContract> getInvocationContracts(Type type);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<InvocationContract> getInvocationContracts(ContractMode mode);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<InvocationContract> getInvocationContracts(Type type, ContractMode mode);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    EList<Contract> getInvokedContracts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<Contract> getInvokedContracts(Type type);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<Contract> getInvokedContracts(ContractMode mode);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<Contract> getInvokedContracts(Type type, ContractMode mode);

} // Invocation
