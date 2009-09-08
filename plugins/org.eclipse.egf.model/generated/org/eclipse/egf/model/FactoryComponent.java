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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>FactoryComponent</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.FactoryComponent#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.egf.model.FactoryComponent#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.egf.model.FactoryComponent#getFactory <em>Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getFactoryComponent()
 * @model
 * @generated
 */
public interface FactoryComponent extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(Domain)
   * @see org.eclipse.egf.model.ModelPackage#getFactoryComponent_Domain()
   * @model containment="true"
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.FactoryComponent#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

  /**
   * Returns the value of the '<em><b>Specification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specification</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specification</em>' containment reference.
   * @see #setSpecification(Specification)
   * @see org.eclipse.egf.model.ModelPackage#getFactoryComponent_Specification()
   * @model containment="true" required="true"
   * @generated
   */
  Specification getSpecification();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.FactoryComponent#getSpecification <em>Specification</em>}' containment reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Specification</em>' containment reference.
   * @see #getSpecification()
   * @generated
   */
  void setSpecification(Specification value);

  /**
   * Returns the value of the '<em><b>Factory</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory</em>' containment reference.
   * @see #setFactory(Factory)
   * @see org.eclipse.egf.model.ModelPackage#getFactoryComponent_Factory()
   * @model containment="true" required="true"
   * @generated
   */
  Factory getFactory();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.FactoryComponent#getFactory <em>Factory</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @param value the new value of the '<em>Factory</em>' containment reference.
   * @see #getFactory()
   * @generated
   */
  void setFactory(Factory value);

} // FactoryComponent
