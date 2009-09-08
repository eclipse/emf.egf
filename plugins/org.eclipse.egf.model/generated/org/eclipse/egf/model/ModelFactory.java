/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.eclipse.egf.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  ModelFactory eINSTANCE = org.eclipse.egf.model.impl.ModelFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Factory Component</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Factory Component</em>'.
   * @generated
   */
  FactoryComponent createFactoryComponent();

  /**
   * Returns a new object of class '<em>Domain</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Domain</em>'.
   * @generated
   */
  Domain createDomain();

  /**
   * Returns a new object of class '<em>Specification</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Specification</em>'.
   * @generated
   */
  Specification createSpecification();

  /**
   * Returns a new object of class '<em>Contract</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Contract</em>'.
   * @generated
   */
  Contract createContract();

  /**
   * Returns a new object of class '<em>Contract Element</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Contract Element</em>'.
   * @generated
   */
  ContractElement createContractElement();

  /**
   * Returns a new object of class '<em>Contract Element Reference</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Contract Element Reference</em>'.
   * @generated
   */
  ContractElementReference createContractElementReference();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Pattern Viewpoint</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Viewpoint</em>'.
   * @generated
   */
  PatternViewpoint createPatternViewpoint();

  /**
   * Returns a new object of class '<em>Pattern Library</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Library</em>'.
   * @generated
   */
  PatternLibrary createPatternLibrary();

  /**
   * Returns a new object of class '<em>Pattern Model</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Model</em>'.
   * @generated
   */
  PatternModel createPatternModel();

  /**
   * Returns a new object of class '<em>Factory</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Factory</em>'.
   * @generated
   */
  Factory createFactory();

  /**
   * Returns a new object of class '<em>Production Plan</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Production Plan</em>'.
   * @generated
   */
  ProductionPlan createProductionPlan();

  /**
   * Returns a new object of class '<em>Context</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Context</em>'.
   * @generated
   */
  Context createContext();

  /**
   * Returns a new object of class '<em>Context Element</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Context Element</em>'.
   * @generated
   */
  ContextElement createContextElement();

  /**
   * Returns a new object of class '<em>Factory Component Invocation</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Factory Component Invocation</em>'.
   * @generated
   */
  FactoryComponentInvocation createFactoryComponentInvocation();

  /**
   * Returns a new object of class '<em>Task Factory Holder</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Task Factory Holder</em>'.
   * @generated
   */
  TaskFactoryHolder createTaskFactoryHolder();

  /**
   * Returns a new object of class '<em>Mapping Viewpoint</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Viewpoint</em>'.
   * @generated
   */
  MappingViewpoint createMappingViewpoint();

  /**
   * Returns a new object of class '<em>Mapping Model</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Model</em>'.
   * @generated
   */
  MappingModel createMappingModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ModelPackage getModelPackage();

} // ModelFactory
