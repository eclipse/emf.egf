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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>FactoryComponent Configuration</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactoryId <em>Task Factory Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.FactoryComponentInvocation#getFactoryComponentId <em>Factory Component Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactory <em>Task Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getFactoryComponentInvocation()
 * @model
 * @generated
 */
public interface FactoryComponentInvocation extends AbstractFactoryComponentFactory {
  /**
   * Returns the value of the '<em><b>Task Factory Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Task Factory Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Task Factory Id</em>' attribute.
   * @see #setTaskFactoryId(String)
   * @see org.eclipse.egf.model.ModelPackage#getFactoryComponentInvocation_TaskFactoryId()
   * @model
   * @generated
   */
  String getTaskFactoryId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactoryId <em>Task Factory Id</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Task Factory Id</em>' attribute.
   * @see #getTaskFactoryId()
   * @generated
   */
  void setTaskFactoryId(String value);

  /**
   * Returns the value of the '<em><b>Factory Component Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>FactoryComponent Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Component Id</em>' attribute.
   * @see #setFactoryComponentId(String)
   * @see org.eclipse.egf.model.ModelPackage#getFactoryComponentInvocation_FactoryComponentId()
   * @model required="true"
   * @generated
   */
  String getFactoryComponentId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.FactoryComponentInvocation#getFactoryComponentId <em>FactoryComponent Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @param value the new value of the '<em>FactoryComponent Id</em>' attribute.
   * @see #getFactoryComponentId()
   * @generated
   */
  void setFactoryComponentId(String value);

  /**
   * Returns the value of the '<em><b>Task Factory</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Task Factory</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Task Factory</em>' containment reference.
   * @see #setTaskFactory(TaskFactoryHolder)
   * @see org.eclipse.egf.model.ModelPackage#getFactoryComponentInvocation_TaskFactory()
   * @model containment="true"
   * @generated
   */
  TaskFactoryHolder getTaskFactory();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactory <em>Task Factory</em>}' containment reference.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Factory</em>' containment reference.
   * @see #getTaskFactory()
   * @generated
   */
  void setTaskFactory(TaskFactoryHolder value);

} // FactoryComponentInvocation
