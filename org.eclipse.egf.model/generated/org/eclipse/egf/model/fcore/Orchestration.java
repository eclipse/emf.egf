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
 * A representation of the model object '<em><b>Orchestration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent <em>Factory Component</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Orchestration#getOrchestrationContextContainer <em>Orchestration Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Orchestration#getInvocations <em>Invocations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestration()
 * @model abstract="true"
 * @generated
 */
public interface Orchestration extends ModelElement {
  /**
   * Returns the value of the '<em><b>Factory Component</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory Component</em>' container reference
   * isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Component</em>' container reference.
   * @see #setFactoryComponent(FactoryComponent)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestration_FactoryComponent()
   * @see org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration
   * @model opposite="orchestration" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  FactoryComponent getFactoryComponent();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent <em>Factory Component</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Factory Component</em>' container reference.
   * @see #getFactoryComponent()
   * @generated
   */
  void setFactoryComponent(FactoryComponent value);

  /**
   * Returns the value of the '<em><b>Invocations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.Invocation}&lt;?>.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Invocation#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocations</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestration_Invocations()
   * @see org.eclipse.egf.model.fcore.Invocation#getOrchestration
   * @model opposite="orchestration" containment="true" required="true"
   * @generated
   */
  EList<Invocation<?>> getInvocations();

  /**
   * Returns the value of the '<em><b>Orchestration Context Container</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration Context Container</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration Context Container</em>' containment reference.
   * @see #setOrchestrationContextContainer(OrchestrationContextContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestration_OrchestrationContextContainer()
   * @see org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestration
   * @model opposite="orchestration" containment="true"
   * @generated
   */
  OrchestrationContextContainer getOrchestrationContextContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Orchestration#getOrchestrationContextContainer <em>Orchestration Context Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orchestration Context Container</em>' containment reference.
   * @see #getOrchestrationContextContainer()
   * @generated
   */
  void setOrchestrationContextContainer(OrchestrationContextContainer value);

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

} // Orchestration
