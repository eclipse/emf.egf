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

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Invocation#getOrchestration <em>Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContextContainer <em>Invocation Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Invocation#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation()
 * @model abstract="true"
 * @generated
 */
public interface Invocation<T extends Activity> extends ModelElement {
  /**
   * Returns the value of the '<em><b>Orchestration</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Orchestration#getInvocations <em>Invocations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration</em>' container reference.
   * @see #setOrchestration(Orchestration)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation_Orchestration()
   * @see org.eclipse.egf.model.fcore.Orchestration#getInvocations
   * @model opposite="invocations" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  Orchestration getOrchestration();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Invocation#getOrchestration <em>Orchestration</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orchestration</em>' container reference.
   * @see #getOrchestration()
   * @generated
   */
  void setOrchestration(Orchestration value);

  /**
   * Returns the value of the '<em><b>Invocation Context Container</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Context Container</em>' containment reference isn't
   * clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Context Container</em>' containment reference.
   * @see #setInvocationContextContainer(InvocationContextContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation_InvocationContextContainer()
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocation
   * @model opposite="invocation" containment="true"
   * @generated
   */
  InvocationContextContainer getInvocationContextContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContextContainer <em>Invocation Context Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invocation Context Container</em>' containment reference.
   * @see #getInvocationContextContainer()
   * @generated
   */
  void setInvocationContextContainer(InvocationContextContainer value);

  /**
   * Returns the value of the '<em><b>Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity</em>' reference.
   * @see #setActivity(Activity)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation_Activity()
   * @model required="true"
   * @generated
   */
  T getActivity();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.Invocation#getActivity <em>Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity</em>' reference.
   * @see #getActivity()
   * @generated
   */
  void setActivity(T value);

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
   * @model kind="operation"
   * @generated
   */
  EList<ActivityContract> getInvocationActivityContracts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<ActivityContract> getInvocationActivityContracts(Type type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<ActivityContract> getInvocationActivityContracts(ContractMode mode);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<ActivityContract> getInvocationActivityContracts(Type type, ContractMode mode);

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
  EList<InvocationContext> getInvocationContexts(Type type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<InvocationContext> getInvocationContexts(ContractMode mode);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<InvocationContext> getInvocationContexts(Type type, ContractMode mode);

} // Invocation
