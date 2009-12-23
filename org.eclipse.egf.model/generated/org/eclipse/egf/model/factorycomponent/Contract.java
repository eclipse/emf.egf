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
package org.eclipse.egf.model.factorycomponent;

import org.eclipse.egf.model.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.Contract#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.Contract#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.Contract#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getContract()
 * @model
 * @generated
 */
public interface Contract extends ModelElement {
  /**
   * Returns the value of the '<em><b>Mode</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.egf.model.factorycomponent.ContractMode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' attribute.
   * @see org.eclipse.egf.model.factorycomponent.ContractMode
   * @see #setMode(ContractMode)
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getContract_Mode()
   * @model
   * @generated
   */
  ContractMode getMode();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.factorycomponent.Contract#getMode <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mode</em>' attribute.
   * @see org.eclipse.egf.model.factorycomponent.ContractMode
   * @see #getMode()
   * @generated
   */
  void setMode(ContractMode value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Type)
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getContract_Type()
   * @model required="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.factorycomponent.Contract#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Value</em>' containment reference.
   * @see #setDefaultValue(ContractValue)
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getContract_DefaultValue()
   * @model containment="true"
   * @generated
   */
  ContractValue getDefaultValue();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.factorycomponent.Contract#getDefaultValue <em>Default Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Value</em>' containment reference.
   * @see #getDefaultValue()
   * @generated
   */
  void setDefaultValue(ContractValue value);

} // Contract
