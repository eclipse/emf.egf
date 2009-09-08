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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Contract</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.Contract#getContractElements <em>Contract Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getContract()
 * @model
 * @generated
 */
public interface Contract extends AbstractViewpoint {
  /**
   * Returns the value of the '<em><b>Contract Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.ContractElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Elements</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Elements</em>' containment reference list.
   * @see org.eclipse.egf.model.ModelPackage#getContract_ContractElements()
   * @model containment="true"
   * @generated
   */
  EList<ContractElement> getContractElements();

} // Contract
