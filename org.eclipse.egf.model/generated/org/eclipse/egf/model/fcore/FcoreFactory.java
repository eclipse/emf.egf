/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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
   * Returns a new object of class '<em>Factory Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Factory Component</em>'.
   * @generated
   */
  FactoryComponent createFactoryComponent();

  /**
   * Returns a new object of class '<em>Factory Component Contract</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Factory Component Contract</em>'.
   * @generated
   */
  FactoryComponentContract createFactoryComponentContract();

  /**
   * Returns a new object of class '<em>Factory Component Contract Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Factory Component Contract Container</em>'.
   * @generated
   */
  FactoryComponentContractContainer createFactoryComponentContractContainer();

  /**
   * Returns a new object of class '<em>Viewpoint Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Viewpoint Container</em>'.
   * @generated
   */
  ViewpointContainer createViewpointContainer();

  /**
   * Returns a new object of class '<em>Orchestration Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Orchestration Context</em>'.
   * @generated
   */
  OrchestrationContext createOrchestrationContext();

  /**
   * Returns a new object of class '<em>Orchestration Context Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Orchestration Context Container</em>'.
   * @generated
   */
  OrchestrationContextContainer createOrchestrationContextContainer();

  /**
   * Returns a new object of class '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invocation Context</em>'.
   * @generated
   */
  InvocationContext createInvocationContext();

  /**
   * Returns a new object of class '<em>Invocation Context Connector</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invocation Context Connector</em>'.
   * @generated
   */
  InvocationContextConnector createInvocationContextConnector();

  /**
   * Returns a new object of class '<em>Invocation Context Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invocation Context Container</em>'.
   * @generated
   */
  InvocationContextContainer createInvocationContextContainer();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FcorePackage getFcorePackage();

} // FcoreFactory
