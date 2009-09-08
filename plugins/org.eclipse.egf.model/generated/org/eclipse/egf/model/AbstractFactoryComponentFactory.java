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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract FactoryComponent Factory</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.AbstractFactoryComponentFactory#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.AbstractFactoryComponentFactory#getContextId <em>Context Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getAbstractFactoryComponentFactory()
 * @model abstract="true"
 * @generated
 */
public interface AbstractFactoryComponentFactory extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context</em>' containment reference.
   * @see #setContext(Context)
   * @see org.eclipse.egf.model.ModelPackage#getAbstractFactoryComponentFactory_Context()
   * @model containment="true"
   * @generated
   */
  Context getContext();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.AbstractFactoryComponentFactory#getContext <em>Context</em>}' containment reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Context</em>' containment reference.
   * @see #getContext()
   * @generated
   */
  void setContext(Context value);

  /**
   * Returns the value of the '<em><b>Context Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Id</em>' attribute.
   * @see #setContextId(String)
   * @see org.eclipse.egf.model.ModelPackage#getAbstractFactoryComponentFactory_ContextId()
   * @model
   * @generated
   */
  String getContextId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.AbstractFactoryComponentFactory#getContextId <em>Context Id</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Context Id</em>' attribute.
   * @see #getContextId()
   * @generated
   */
  void setContextId(String value);

} // AbstractFactoryComponentFactory
