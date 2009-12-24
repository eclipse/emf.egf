/**
 * <copyright>
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
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.ContractContainer#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.ContractContainer#getContracts <em>Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getContractContainer()
 * @model
 * @generated
 */
public interface ContractContainer extends ModelElement {
  /**
   * Returns the value of the '<em><b>Activity</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.factorycomponent.Activity#getContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity</em>' container reference.
   * @see #setActivity(Activity)
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getContractContainer_Activity()
   * @see org.eclipse.egf.model.factorycomponent.Activity#getContractContainer
   * @model opposite="contractContainer" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  Activity getActivity();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.factorycomponent.ContractContainer#getActivity <em>Activity</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity</em>' container reference.
   * @see #getActivity()
   * @generated
   */
  void setActivity(Activity value);

  /**
   * Returns the value of the '<em><b>Contracts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.factorycomponent.Contract}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.factorycomponent.Contract#getContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contracts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contracts</em>' containment reference list.
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getContractContainer_Contracts()
   * @see org.eclipse.egf.model.factorycomponent.Contract#getContractContainer
   * @model opposite="contractContainer" containment="true"
   * @generated
   */
  EList<Contract> getContracts();

} // ContractContainer
