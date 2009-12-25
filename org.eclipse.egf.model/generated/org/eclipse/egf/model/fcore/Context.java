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
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Context#getContextContainer <em>Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Context#getContract <em>Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Context#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getContext()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueContextName ValidContract'"
 * @generated
 */
public interface Context extends ModelElement {
  /**
   * Returns the value of the '<em><b>Context Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.ContextContainer#getContexts <em>Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Container</em>' container reference.
   * @see #setContextContainer(ContextContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContext_ContextContainer()
   * @see org.eclipse.egf.model.fcore.ContextContainer#getContexts
   * @model opposite="contexts" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  ContextContainer getContextContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Context#getContextContainer <em>Context Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context Container</em>' container reference.
   * @see #getContextContainer()
   * @generated
   */
  void setContextContainer(ContextContainer value);

  /**
   * Returns the value of the '<em><b>Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract</em>' reference.
   * @see #setContract(Contract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContext_Contract()
   * @model required="true"
   * @generated
   */
  Contract getContract();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Context#getContract <em>Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract</em>' reference.
   * @see #getContract()
   * @generated
   */
  void setContract(Contract value);

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
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContext_Type()
   * @model containment="true" required="true"
   * @generated
   */
  Type<?> getType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Context#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type<?> value);

} // Context
