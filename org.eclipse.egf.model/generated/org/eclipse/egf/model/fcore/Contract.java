/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Contract#getContractContainer <em>Contract Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Contract#getInvocationContexts <em>Invocation Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Contract#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Contract#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Contract#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getContract()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MandatoryName UniqueName ContractShouldBeBound OutModeIsRestricted'"
 * @generated
 */
public interface Contract extends ModelElement {
  /**
   * Returns the value of the '<em><b>Contract Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.ContractContainer#getContracts <em>Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Container</em>' container reference
   * isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Container</em>' container reference.
   * @see #setContractContainer(ContractContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContract_ContractContainer()
   * @see org.eclipse.egf.model.fcore.ContractContainer#getContracts
   * @model opposite="contracts" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  ContractContainer getContractContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Contract#getContractContainer <em>Contract Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract Container</em>' container reference.
   * @see #getContractContainer()
   * @generated
   */
  void setContractContainer(ContractContainer value);

  /**
   * Returns the value of the '<em><b>Invocation Contexts</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContext}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContext#getExposedContract <em>Exposed Contract</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Contexts</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Contexts</em>' reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContract_InvocationContexts()
   * @see org.eclipse.egf.model.fcore.InvocationContext#getExposedContract
   * @model opposite="exposedContract" resolveProxies="false"
   * @generated
   */
  EList<InvocationContext> getInvocationContexts();

  /**
   * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mandatory</em>' attribute.
   * @see #setMandatory(boolean)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContract_Mandatory()
   * @model
   * @generated
   */
  boolean isMandatory();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Contract#isMandatory <em>Mandatory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mandatory</em>' attribute.
   * @see #isMandatory()
   * @generated
   */
  void setMandatory(boolean value);

  /**
   * Returns the value of the '<em><b>Mode</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.egf.model.fcore.ContractMode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' attribute.
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @see #setMode(ContractMode)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContract_Mode()
   * @model
   * @generated
   */
  ContractMode getMode();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Contract#getMode <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mode</em>' attribute.
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @see #getMode()
   * @generated
   */
  void setMode(ContractMode value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContract_Type()
   * @model containment="true" required="true"
   * @generated
   */
  Type<?> getType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Contract#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type<?> value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  Activity getActivity();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<Contract> getContracts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<Contract> getContracts(Type<?> type);

} // Contract
