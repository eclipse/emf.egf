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
 * A representation of the model object '<em><b>Context Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.ContextContainer#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ContextContainer#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ContextContainer#getConnectors <em>Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getContextContainer()
 * @model
 * @generated
 */
public interface ContextContainer extends ModelElement {
  /**
   * Returns the value of the '<em><b>Invocation</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Invocation#getContextContainer <em>Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation</em>' container reference.
   * @see #setInvocation(Invocation)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContextContainer_Invocation()
   * @see org.eclipse.egf.model.fcore.Invocation#getContextContainer
   * @model opposite="contextContainer" resolveProxies="false" transient="false"
   * @generated
   */
  Invocation<?> getInvocation();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ContextContainer#getInvocation <em>Invocation</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invocation</em>' container reference.
   * @see #getInvocation()
   * @generated
   */
  void setInvocation(Invocation<?> value);

  /**
   * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.Context}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Context#getContextContainer <em>Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contexts</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContextContainer_Contexts()
   * @see org.eclipse.egf.model.fcore.Context#getContextContainer
   * @model opposite="contextContainer" containment="true"
   * @generated
   */
  EList<Context> getContexts();

  /**
   * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.ContractConnector}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.ContractConnector#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connectors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connectors</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContextContainer_Connectors()
   * @see org.eclipse.egf.model.fcore.ContractConnector#getContext
   * @model opposite="context" containment="true"
   * @generated
   */
  EList<ContractConnector> getConnectors();

} // ContextContainer
