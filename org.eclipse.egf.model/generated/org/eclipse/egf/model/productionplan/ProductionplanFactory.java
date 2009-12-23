/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.productionplan;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.productionplan.ProductionplanPackage
 * @generated
 */
public interface ProductionplanFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ProductionplanFactory eINSTANCE = org.eclipse.egf.model.productionplan.impl.ProductionplanFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Production Plan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Production Plan</em>'.
   * @generated
   */
  ProductionPlan createProductionPlan();

  /**
   * Returns a new object of class '<em>Factory Component Invocation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Factory Component Invocation</em>'.
   * @generated
   */
  FactoryComponentInvocation createFactoryComponentInvocation();

  /**
   * Returns a new object of class '<em>Task Invocation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Invocation</em>'.
   * @generated
   */
  TaskInvocation createTaskInvocation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ProductionplanPackage getProductionplanPackage();

} //ProductionplanFactory
