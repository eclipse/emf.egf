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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Context</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.Context#getContextElements <em>Context Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Context Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.ContextElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Elements</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Elements</em>' containment reference list.
   * @see org.eclipse.egf.model.ModelPackage#getContext_ContextElements()
   * @model containment="true" required="true"
   * @generated
   */
  EList<ContextElement> getContextElements();

} // Context
