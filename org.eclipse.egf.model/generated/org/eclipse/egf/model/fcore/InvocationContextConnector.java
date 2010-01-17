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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation Context Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getInvocationContextContainer <em>Invocation Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getSourceInvocationContext <em>Source Invocation Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getTargetInvocationContext <em>Target Invocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextConnector()
 * @model
 * @generated
 */
public interface InvocationContextConnector extends ModelElement {
  /**
   * Returns the value of the '<em><b>Invocation Context Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContextConnectors <em>Invocation Context Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Context Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Context Container</em>' container reference.
   * @see #setInvocationContextContainer(InvocationContextContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextConnector_InvocationContextContainer()
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContextConnectors
   * @model opposite="invocationContextConnectors" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  InvocationContextContainer getInvocationContextContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getInvocationContextContainer <em>Invocation Context Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invocation Context Container</em>' container reference.
   * @see #getInvocationContextContainer()
   * @generated
   */
  void setInvocationContextContainer(InvocationContextContainer value);

  /**
   * Returns the value of the '<em><b>Source Invocation Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Invocation Context</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Invocation Context</em>' reference.
   * @see #setSourceInvocationContext(InvocationContext)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextConnector_SourceInvocationContext()
   * @model required="true"
   * @generated
   */
  InvocationContext getSourceInvocationContext();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getSourceInvocationContext <em>Source Invocation Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Invocation Context</em>' reference.
   * @see #getSourceInvocationContext()
   * @generated
   */
  void setSourceInvocationContext(InvocationContext value);

  /**
   * Returns the value of the '<em><b>Target Invocation Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Invocation Context</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Invocation Context</em>' reference.
   * @see #setTargetInvocationContext(InvocationContext)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContextConnector_TargetInvocationContext()
   * @model required="true"
   * @generated
   */
  InvocationContext getTargetInvocationContext();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getTargetInvocationContext <em>Target Invocation Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Invocation Context</em>' reference.
   * @see #getTargetInvocationContext()
   * @generated
   */
  void setTargetInvocationContext(InvocationContext value);

} // InvocationContextConnector
