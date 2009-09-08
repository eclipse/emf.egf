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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Contract Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.ContractElement#getContractElementReferences <em>Contract Element References</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContractElement#getFactoryComponentId <em>Factory Component Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContractElement#getContractReferenceIds <em>Contract Reference Ids</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContractElement#getContractType <em>Contract Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContractElement#isMandatory <em>Mandatory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getContractElement()
 * @model
 * @generated
 */
public interface ContractElement extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Contract Element References</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.ContractElementReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Element References</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Element References</em>' containment reference list.
   * @see org.eclipse.egf.model.ModelPackage#getContractElement_ContractElementReferences()
   * @model containment="true"
   * @generated
   */
  EList<ContractElementReference> getContractElementReferences();

  /**
   * Returns the value of the '<em><b>Factory Component Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>FactoryComponent Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Component Id</em>' attribute.
   * @see #setFactoryComponentId(String)
   * @see org.eclipse.egf.model.ModelPackage#getContractElement_FactoryComponentId()
   * @model required="true"
   * @generated
   */
  String getFactoryComponentId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContractElement#getFactoryComponentId <em>Factory Component Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Factory Component Id</em>' attribute.
   * @see #getFactoryComponentId()
   * @generated
   */
  void setFactoryComponentId(String value);

  /**
   * Returns the value of the '<em><b>Contract Reference Ids</b></em>' attribute list. The list contents are of type {@link java.lang.String}. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Reference Ids</em>' attribute list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Reference Ids</em>' attribute list.
   * @see org.eclipse.egf.model.ModelPackage#getContractElement_ContractReferenceIds()
   * @model
   * @generated
   */
  EList<String> getContractReferenceIds();

  /**
   * Returns the value of the '<em><b>Contract Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Type</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Type</em>' containment reference.
   * @see #setContractType(Type)
   * @see org.eclipse.egf.model.ModelPackage#getContractElement_ContractType()
   * @model containment="true" required="true"
   * @generated
   */
  Type getContractType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContractElement#getContractType <em>Contract Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract Type</em>' containment reference.
   * @see #getContractType()
   * @generated
   */
  void setContractType(Type value);

  /**
   * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mandatory</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mandatory</em>' attribute.
   * @see #setMandatory(boolean)
   * @see org.eclipse.egf.model.ModelPackage#getContractElement_Mandatory()
   * @model default="true" required="true"
   * @generated
   */
  boolean isMandatory();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContractElement#isMandatory <em>Mandatory</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @param value the new value of the '<em>Mandatory</em>' attribute.
   * @see #isMandatory()
   * @generated
   */
  void setMandatory(boolean value);

} // ContractElement
