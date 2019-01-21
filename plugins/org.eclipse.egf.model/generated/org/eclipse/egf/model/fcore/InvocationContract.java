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

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContract#getInvocationContractContainer <em>Invocation Contract Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContract#getFactoryComponentContract <em>Factory Component Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContract#getOrchestrationParameter <em>Orchestration Parameter</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContract#getSourceInvocationContract <em>Source Invocation Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContract#getTargetInvocationContract <em>Target Invocation Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContract#getInvokedContract <em>Invoked Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContract#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidInvokedContract ValidInvokedContractType ValidFactoryComponentContract ValidFactoryComponentContractType ValidOrchestrationParameter ValidOrchestrationParameterType ValidSourceInvocationContract ValidSourceInvocationContractType UselessTypeValue UselessInvocationContract'"
 * @generated
 */
public interface InvocationContract extends ModelElement {

    /**
     * Returns the value of the '<em><b>Invocation Contract Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocationContracts <em>Invocation Contracts</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invocation Contract Container</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invocation Contract Container</em>' container reference.
     * @see #setInvocationContractContainer(InvocationContractContainer)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract_InvocationContractContainer()
     * @see org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocationContracts
     * @model opposite="invocationContracts" resolveProxies="false" required="true" transient="false"
     * @generated
     */
    InvocationContractContainer getInvocationContractContainer();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContract#getInvocationContractContainer <em>Invocation Contract Container</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Invocation Contract Container</em>' container reference.
     * @see #getInvocationContractContainer()
     * @generated
     */
    void setInvocationContractContainer(InvocationContractContainer value);

    /**
     * Returns the value of the '<em><b>Factory Component Contract</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContracts <em>Invocation Contracts</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Factory Component Contract</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Factory Component Contract</em>' reference.
     * @see #setFactoryComponentContract(FactoryComponentContract)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract_FactoryComponentContract()
     * @see org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContracts
     * @model opposite="invocationContracts" resolveProxies="false"
     * @generated
     */
    FactoryComponentContract getFactoryComponentContract();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContract#getFactoryComponentContract <em>Factory Component Contract</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Factory Component Contract</em>' reference.
     * @see #getFactoryComponentContract()
     * @generated
     */
    void setFactoryComponentContract(FactoryComponentContract value);

    /**
     * Returns the value of the '<em><b>Orchestration Parameter</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getInvocationContracts <em>Invocation Contracts</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Orchestration Parameter</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Orchestration Parameter</em>' reference.
     * @see #setOrchestrationParameter(OrchestrationParameter)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract_OrchestrationParameter()
     * @see org.eclipse.egf.model.fcore.OrchestrationParameter#getInvocationContracts
     * @model opposite="invocationContracts" resolveProxies="false"
     * @generated
     */
    OrchestrationParameter getOrchestrationParameter();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContract#getOrchestrationParameter <em>Orchestration Parameter</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Orchestration Parameter</em>' reference.
     * @see #getOrchestrationParameter()
     * @generated
     */
    void setOrchestrationParameter(OrchestrationParameter value);

    /**
     * Returns the value of the '<em><b>Source Invocation Contract</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContract#getTargetInvocationContract <em>Target Invocation Contract</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Invocation Contract</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Invocation Contract</em>' reference.
     * @see #setSourceInvocationContract(InvocationContract)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract_SourceInvocationContract()
     * @see org.eclipse.egf.model.fcore.InvocationContract#getTargetInvocationContract
     * @model opposite="targetInvocationContract" resolveProxies="false"
     * @generated
     */
    InvocationContract getSourceInvocationContract();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContract#getSourceInvocationContract <em>Source Invocation Contract</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Invocation Contract</em>' reference.
     * @see #getSourceInvocationContract()
     * @generated
     */
    void setSourceInvocationContract(InvocationContract value);

    /**
     * Returns the value of the '<em><b>Target Invocation Contract</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContract}.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContract#getSourceInvocationContract <em>Source Invocation Contract</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Invocation Contract</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Invocation Contract</em>' reference list.
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract_TargetInvocationContract()
     * @see org.eclipse.egf.model.fcore.InvocationContract#getSourceInvocationContract
     * @model opposite="sourceInvocationContract" resolveProxies="false"
     * @generated
     */
    EList<InvocationContract> getTargetInvocationContract();

    /**
     * Returns the value of the '<em><b>Invoked Contract</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invoked Contract</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invoked Contract</em>' reference.
     * @see #setInvokedContract(Contract)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract_InvokedContract()
     * @model required="true"
     * @generated
     */
    Contract getInvokedContract();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContract#getInvokedContract <em>Invoked Contract</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Invoked Contract</em>' reference.
     * @see #getInvokedContract()
     * @generated
     */
    void setInvokedContract(Contract value);

    /**
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invoked Mode</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    ContractMode getInvokedMode();

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(Type)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContract_Type()
     * @model containment="true"
     * @generated
     */
    Type getType();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContract#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(Type value);

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
     * @model kind="operation" required="true"
     * @generated
     */
    Invocation getInvocation();

} // InvocationContract
