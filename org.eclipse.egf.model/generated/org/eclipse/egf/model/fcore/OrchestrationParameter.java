/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
 * A representation of the model object '<em><b>Orchestration Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getInvocationContracts <em>Invocation Contracts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationParameter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UselessOrchestrationParameter'"
 * @generated
 */
public interface OrchestrationParameter extends NamedModelElement {
  /**
   * Returns the value of the '<em><b>Orchestration Parameter Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestrationParameters <em>Orchestration Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration Parameter Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration Parameter Container</em>' container reference.
   * @see #setOrchestrationParameterContainer(OrchestrationParameterContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationParameter_OrchestrationParameterContainer()
   * @see org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestrationParameters
   * @model opposite="orchestrationParameters" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  OrchestrationParameterContainer getOrchestrationParameterContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orchestration Parameter Container</em>' container reference.
   * @see #getOrchestrationParameterContainer()
   * @generated
   */
  void setOrchestrationParameterContainer(OrchestrationParameterContainer value);

  /**
   * Returns the value of the '<em><b>Invocation Contracts</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContract}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContract#getOrchestrationParameter <em>Orchestration Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Contracts</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Contracts</em>' reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationParameter_InvocationContracts()
   * @see org.eclipse.egf.model.fcore.InvocationContract#getOrchestrationParameter
   * @model opposite="orchestrationParameter" resolveProxies="false"
   * @generated
   */
  EList<InvocationContract> getInvocationContracts();

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
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationParameter_Type()
   * @model containment="true" required="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

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
  Orchestration getOrchestration();

} // OrchestrationParameter
