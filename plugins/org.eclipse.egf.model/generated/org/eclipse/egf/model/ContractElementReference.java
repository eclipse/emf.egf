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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Contract Element Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElementId <em>Referenced Contract Element Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElementName <em>Referenced Contract Element Name</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContractElementReference#getReferencedFactoryComponentId <em>Referenced Factory Component Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElement <em>Referenced Contract Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getContractElementReference()
 * @model
 * @generated
 */
public interface ContractElementReference extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Referenced Contract Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced Contract Element Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Contract Element Id</em>' attribute.
   * @see #setReferencedContractElementId(String)
   * @see org.eclipse.egf.model.ModelPackage#getContractElementReference_ReferencedContractElementId()
   * @model required="true"
   * @generated
   */
  String getReferencedContractElementId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElementId <em>Referenced Contract Element Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Contract Element Id</em>' attribute.
   * @see #getReferencedContractElementId()
   * @generated
   */
  void setReferencedContractElementId(String value);

  /**
   * Returns the value of the '<em><b>Referenced Contract Element Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc
   * -->
   * @deprecated Use referencedContractElementId instead of. <!-- end-model-doc -->
   * @return the value of the '<em>Referenced Contract Element Name</em>' attribute.
   * @see #setReferencedContractElementName(String)
   * @see org.eclipse.egf.model.ModelPackage#getContractElementReference_ReferencedContractElementName()
   * @model
   * @generated
   */
  String getReferencedContractElementName();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElementName <em>Referenced Contract Element Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Contract Element Name</em>' attribute.
   * @see #getReferencedContractElementName()
   * @generated
   */
  void setReferencedContractElementName(String value);

  /**
   * Returns the value of the '<em><b>Referenced Factory Component Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced FactoryComponent Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Factory Component Id</em>' attribute.
   * @see #setReferencedFactoryComponentId(String)
   * @see org.eclipse.egf.model.ModelPackage#getContractElementReference_ReferencedFactoryComponentId()
   * @model required="true"
   * @generated
   */
  String getReferencedFactoryComponentId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContractElementReference#getReferencedFactoryComponentId <em>Referenced FactoryComponent Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced FactoryComponent Id</em>' attribute.
   * @see #getReferencedFactoryComponentId()
   * @generated
   */
  void setReferencedFactoryComponentId(String value);

  /**
   * Returns the value of the '<em><b>Referenced Contract Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced Contract Element</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Contract Element</em>' reference.
   * @see #setReferencedContractElement(ContractElement)
   * @see org.eclipse.egf.model.ModelPackage#getContractElementReference_ReferencedContractElement()
   * @model
   * @generated
   */
  ContractElement getReferencedContractElement();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElement <em>Referenced Contract Element</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Contract Element</em>' reference.
   * @see #getReferencedContractElement()
   * @generated
   */
  void setReferencedContractElement(ContractElement value);

} // ContractElementReference
