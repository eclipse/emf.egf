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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Factory</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.Factory#getProductionPlan <em>Production Plan</em>}</li>
 *   <li>{@link org.eclipse.egf.model.Factory#getProductionPlanId <em>Production Plan Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getFactory()
 * @model
 * @generated
 */
public interface Factory extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Production Plan</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Production Plan</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Production Plan</em>' containment reference.
   * @see #setProductionPlan(ProductionPlan)
   * @see org.eclipse.egf.model.ModelPackage#getFactory_ProductionPlan()
   * @model containment="true" required="true"
   * @generated
   */
  ProductionPlan getProductionPlan();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.Factory#getProductionPlan <em>Production Plan</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Production Plan</em>' containment reference.
   * @see #getProductionPlan()
   * @generated
   */
  void setProductionPlan(ProductionPlan value);

  /**
   * Returns the value of the '<em><b>Production Plan Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Production Plan Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Production Plan Id</em>' attribute.
   * @see #setProductionPlanId(String)
   * @see org.eclipse.egf.model.ModelPackage#getFactory_ProductionPlanId()
   * @model required="true"
   * @generated
   */
  String getProductionPlanId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.Factory#getProductionPlanId <em>Production Plan Id</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Production Plan Id</em>' attribute.
   * @see #getProductionPlanId()
   * @generated
   */
  void setProductionPlanId(String value);

} // Factory
