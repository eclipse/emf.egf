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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Task Factory Holder</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.TaskFactoryHolder#getFactoryClass <em>Factory Class</em>}</li>
 *   <li>{@link org.eclipse.egf.model.TaskFactoryHolder#getFactory <em>Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getTaskFactoryHolder()
 * @model
 * @generated
 */
public interface TaskFactoryHolder extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Factory Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory Class</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Class</em>' attribute.
   * @see #setFactoryClass(String)
   * @see org.eclipse.egf.model.ModelPackage#getTaskFactoryHolder_FactoryClass()
   * @model required="true"
   * @generated
   */
  String getFactoryClass();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.TaskFactoryHolder#getFactoryClass <em>Factory Class</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Factory Class</em>' attribute.
   * @see #getFactoryClass()
   * @generated
   */
  void setFactoryClass(String value);

  /**
   * Returns the value of the '<em><b>Factory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory</em>' attribute.
   * @see #setFactory(Object)
   * @see org.eclipse.egf.model.ModelPackage#getTaskFactoryHolder_Factory()
   * @model
   * @generated
   */
  Object getFactory();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.TaskFactoryHolder#getFactory <em>Factory</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @param value the new value of the '<em>Factory</em>' attribute.
   * @see #getFactory()
   * @generated
   */
  void setFactory(Object value);

} // TaskFactoryHolder
