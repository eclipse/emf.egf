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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.Type#getTypeHolderClassName <em>Type Holder Class Name</em>}</li>
 *   <li>{@link org.eclipse.egf.model.Type#getTypeHolder <em>Type Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getType()
 * @model
 * @generated
 */
public interface Type extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Type Holder Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Holder Class Name</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Holder Class Name</em>' attribute.
   * @see #setTypeHolderClassName(String)
   * @see org.eclipse.egf.model.ModelPackage#getType_TypeHolderClassName()
   * @model required="true"
   * @generated
   */
  String getTypeHolderClassName();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.Type#getTypeHolderClassName <em>Type Holder Class Name</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Type Holder Class Name</em>' attribute.
   * @see #getTypeHolderClassName()
   * @generated
   */
  void setTypeHolderClassName(String value);

  /**
   * Returns the value of the '<em><b>Type Holder</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Holder</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Holder</em>' attribute.
   * @see #setTypeHolder(Object)
   * @see org.eclipse.egf.model.ModelPackage#getType_TypeHolder()
   * @model
   * @generated
   */
  Object getTypeHolder();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.Type#getTypeHolder <em>Type Holder</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Holder</em>' attribute.
   * @see #getTypeHolder()
   * @generated
   */
  void setTypeHolder(Object value);

} // Type
