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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.fcore.FcorePackage
 * @generated
 */
public interface FcoreFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FcoreFactory eINSTANCE = org.eclipse.egf.model.fcore.impl.FcoreFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Contract</em>'.
     * @generated
     */
    Contract createContract();

    /**
     * Returns a new object of class '<em>Factory Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Factory Component</em>'.
     * @generated
     */
    FactoryComponent createFactoryComponent();

    /**
     * Returns a new object of class '<em>Contract Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Contract Container</em>'.
     * @generated
     */
    ContractContainer createContractContainer();

    /**
     * Returns a new object of class '<em>Factory Component Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Factory Component Contract</em>'.
     * @generated
     */
    FactoryComponentContract createFactoryComponentContract();

    /**
     * Returns a new object of class '<em>Viewpoint Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Viewpoint Container</em>'.
     * @generated
     */
    ViewpointContainer createViewpointContainer();

    /**
     * Returns a new object of class '<em>Orchestration Parameter Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Orchestration Parameter Container</em>'.
     * @generated
     */
    OrchestrationParameterContainer createOrchestrationParameterContainer();

    /**
     * Returns a new object of class '<em>Orchestration Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Orchestration Parameter</em>'.
     * @generated
     */
    OrchestrationParameter createOrchestrationParameter();

    /**
     * Returns a new object of class '<em>Invocation Contract Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Invocation Contract Container</em>'.
     * @generated
     */
    InvocationContractContainer createInvocationContractContainer();

    /**
     * Returns a new object of class '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Invocation Contract</em>'.
     * @generated
     */
    InvocationContract createInvocationContract();

    /**
     * Returns an instance of data type '<em>Contract Mode</em>' corresponding the given literal.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal a literal of the data type.
     * @return a new instance value of the data type.
     * @generated
     */
    ContractMode createContractMode(String literal);

    /**
     * Returns a literal representation of an instance of data type '<em>Contract Mode</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param instanceValue an instance value of the data type.
     * @return a literal representation of the instance value.
     * @generated
     */
    String convertContractMode(ContractMode instanceValue);

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    FcorePackage getFcorePackage();

} // FcoreFactory
