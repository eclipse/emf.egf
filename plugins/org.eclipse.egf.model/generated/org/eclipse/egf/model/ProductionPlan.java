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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Production Plan</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.ProductionPlan#getFactoryComponentInvocations <em>Factory Component Invocations</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ProductionPlan#getFactoryComponentInvocationIds <em>Factory Component Invocation Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getProductionPlan()
 * @model
 * @generated
 */
public interface ProductionPlan extends AbstractFactoryComponentFactory {
  /**
   * Returns the value of the '<em><b>Factory Component Invocations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.FactoryComponentInvocation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>FactoryComponent Configurations</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Component Invocations</em>' containment reference list.
   * @see org.eclipse.egf.model.ModelPackage#getProductionPlan_FactoryComponentInvocations()
   * @model containment="true"
   * @generated
   */
  EList<FactoryComponentInvocation> getFactoryComponentInvocations();

  /**
   * Returns the value of the '<em><b>FactoryComponent Configuration Ids</b></em>' attribute list. The list contents are of type {@link java.lang.String}. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>FactoryComponent Configuration Ids</em>' attribute list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>FactoryComponent Configuration Ids</em>' attribute list.
   * @see org.eclipse.egf.model.ModelPackage#getProductionPlan_FactoryComponentInvocationIds()
   * @model
   * @generated
   */
  EList<String> getFactoryComponentInvocationIds();

} // ProductionPlan
