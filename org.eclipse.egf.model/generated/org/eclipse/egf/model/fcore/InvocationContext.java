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
 * A representation of the model object '<em><b>Invocation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getInvocationContextContainer <em>Invocation Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getExposedContract <em>Exposed Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getOrchestrationContext <em>Orchestration Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getActivityContract <em>Activity Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidContext UniqueContextName ValidSourceContract ValidExposedContract'"
 * @generated
 */
public interface InvocationContext extends ModelElement {
  /**
   * Returns the value of the '<em><b>Invocation Context Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContexts <em>Invocation Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Context Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Context Container</em>' container reference.
   * @see #setInvocationContextContainer(InvocationContextContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_InvocationContextContainer()
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContexts
   * @model opposite="invocationContexts" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  InvocationContextContainer getInvocationContextContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getInvocationContextContainer <em>Invocation Context Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invocation Context Container</em>' container reference.
   * @see #getInvocationContextContainer()
   * @generated
   */
  void setInvocationContextContainer(InvocationContextContainer value);

  /**
   * Returns the value of the '<em><b>Exposed Contract</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Contract#getInvocationContexts <em>Invocation Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exposed Contract</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exposed Contract</em>' reference.
   * @see #setExposedContract(Contract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_ExposedContract()
   * @see org.eclipse.egf.model.fcore.Contract#getInvocationContexts
   * @model opposite="invocationContexts" resolveProxies="false"
   * @generated
   */
  Contract getExposedContract();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getExposedContract <em>Exposed Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exposed Contract</em>' reference.
   * @see #getExposedContract()
   * @generated
   */
  void setExposedContract(Contract value);

  /**
   * Returns the value of the '<em><b>Orchestration Context</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.OrchestrationContext#getInvocationContexts <em>Invocation Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration Context</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration Context</em>' reference.
   * @see #setOrchestrationContext(OrchestrationContext)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_OrchestrationContext()
   * @see org.eclipse.egf.model.fcore.OrchestrationContext#getInvocationContexts
   * @model opposite="invocationContexts" resolveProxies="false"
   * @generated
   */
  OrchestrationContext getOrchestrationContext();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getOrchestrationContext <em>Orchestration Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orchestration Context</em>' reference.
   * @see #getOrchestrationContext()
   * @generated
   */
  void setOrchestrationContext(OrchestrationContext value);

  /**
   * Returns the value of the '<em><b>Activity Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Contract</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Contract</em>' reference.
   * @see #setActivityContract(Contract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_ActivityContract()
   * @model required="true"
   * @generated
   */
  Contract getActivityContract();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getActivityContract <em>Activity Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Contract</em>' reference.
   * @see #getActivityContract()
   * @generated
   */
  void setActivityContract(Contract value);

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
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_Type()
   * @model containment="true" required="true"
   * @generated
   */
  Type<?> getType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getType <em>Type</em>}' containment reference.
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
  FactoryComponent getFactoryComponent();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  Invocation<?> getInvocation();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<InvocationContext> getInvocationContexts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<InvocationContext> getInvocationContexts(Type<?> type);

} // InvocationContext
