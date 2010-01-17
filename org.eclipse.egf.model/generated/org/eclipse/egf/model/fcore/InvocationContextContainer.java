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
 * A representation of the model object '<em><b>Invocation Context Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContexts <em>Invocation Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContextConnectors <em>Invocation Context Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextContainer()
 * @model
 * @generated
 */
public interface InvocationContextContainer extends ModelElement {
  /**
   * Returns the value of the '<em><b>Invocation</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContextContainer <em>Invocation Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation</em>' container reference.
   * @see #setInvocation(Invocation)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextContainer_Invocation()
   * @see org.eclipse.egf.model.fcore.Invocation#getInvocationContextContainer
   * @model opposite="invocationContextContainer" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  Invocation<?> getInvocation();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocation <em>Invocation</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invocation</em>' container reference.
   * @see #getInvocation()
   * @generated
   */
  void setInvocation(Invocation<?> value);

  /**
   * Returns the value of the '<em><b>Invocation Contexts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContext}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContext#getInvocationContextContainer <em>Invocation Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Contexts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Contexts</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextContainer_InvocationContexts()
   * @see org.eclipse.egf.model.fcore.InvocationContext#getInvocationContextContainer
   * @model opposite="invocationContextContainer" containment="true"
   * @generated
   */
  EList<InvocationContext> getInvocationContexts();

  /**
   * Returns the value of the '<em><b>Invocation Context Connectors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContextConnector}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getInvocationContextContainer <em>Invocation Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Context Connectors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Context Connectors</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextContainer_InvocationContextConnectors()
   * @see org.eclipse.egf.model.fcore.InvocationContextConnector#getInvocationContextContainer
   * @model opposite="invocationContextContainer" containment="true"
   * @generated
   */
  EList<InvocationContextConnector> getInvocationContextConnectors();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  FactoryComponent getFactoryComponent();

} // InvocationContextContainer
