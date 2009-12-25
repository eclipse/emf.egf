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
 * A representation of the model object '<em><b>Orchestration Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationContext#getOrchestrationContextContainer <em>Orchestration Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationContext#getContract <em>Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationContext#getInvocationContexts <em>Invocation Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationContext#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationContext()
 * @model
 * @generated
 */
public interface OrchestrationContext extends ModelElement {
  /**
   * Returns the value of the '<em><b>Orchestration Context Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestrationContexts <em>Orchestration Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration Context Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration Context Container</em>' container reference.
   * @see #setOrchestrationContextContainer(OrchestrationContextContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationContext_OrchestrationContextContainer()
   * @see org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestrationContexts
   * @model opposite="orchestrationContexts" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  OrchestrationContextContainer getOrchestrationContextContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.OrchestrationContext#getOrchestrationContextContainer <em>Orchestration Context Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orchestration Context Container</em>' container reference.
   * @see #getOrchestrationContextContainer()
   * @generated
   */
  void setOrchestrationContextContainer(OrchestrationContextContainer value);

  /**
   * Returns the value of the '<em><b>Contract</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Contract#getOrchestrationContexts <em>Orchestration Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract</em>' reference.
   * @see #setContract(Contract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationContext_Contract()
   * @see org.eclipse.egf.model.fcore.Contract#getOrchestrationContexts
   * @model opposite="orchestrationContexts" resolveProxies="false"
   * @generated
   */
  Contract getContract();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.OrchestrationContext#getContract <em>Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract</em>' reference.
   * @see #getContract()
   * @generated
   */
  void setContract(Contract value);

  /**
   * Returns the value of the '<em><b>Invocation Contexts</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContext}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContext#getOrchestrationContext <em>Orchestration Context</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Contexts</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Contexts</em>' reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationContext_InvocationContexts()
   * @see org.eclipse.egf.model.fcore.InvocationContext#getOrchestrationContext
   * @model opposite="orchestrationContext" resolveProxies="false" required="true"
   * @generated
   */
  EList<InvocationContext> getInvocationContexts();

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
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationContext_Type()
   * @model containment="true" required="true"
   * @generated
   */
  Type<?> getType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.OrchestrationContext#getType <em>Type</em>}' containment reference.
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
  Orchestration getOrchestration();

} // OrchestrationContext
