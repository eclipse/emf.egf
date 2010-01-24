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

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Activity#getContractContainer <em>Contract Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getActivity()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ActivityCycle'"
 * @generated
 */
public interface Activity extends NamedModelElement {

  /**
   * Returns the value of the '<em><b>Contract Container</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.ContractContainer#getActivity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Container</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Container</em>' containment reference.
   * @see #setContractContainer(ContractContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getActivity_ContractContainer()
   * @see org.eclipse.egf.model.fcore.ContractContainer#getActivity
   * @model opposite="activity" containment="true"
   * @generated
   */
  ContractContainer getContractContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Activity#getContractContainer <em>Contract Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract Container</em>' containment reference.
   * @see #getContractContainer()
   * @generated
   */
  void setContractContainer(ContractContainer value);

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
  EList<Contract> getContracts(Type type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<Contract> getContracts(ContractMode mode);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<Contract> getContracts(Type type, ContractMode mode);

} // Activity
