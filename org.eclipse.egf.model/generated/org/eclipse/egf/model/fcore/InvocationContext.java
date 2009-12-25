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
 * A representation of the model object '<em><b>Invocation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getInvocationContextContainer <em>Invocation Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getFactoryComponentExposedContract <em>Factory Component Exposed Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getOrchestrationContext <em>Orchestration Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getActivityContract <em>Activity Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.InvocationContext#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MandatoryName UniqueName ValidActivityContract ValidActivityContractType ValidContext ValidExposedContract ValidExposedContractType MandatoryTypeValue UselessType'"
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
   * Returns the value of the '<em><b>Factory Component Exposed Contract</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContexts <em>Invocation Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory Component Exposed Contract</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Component Exposed Contract</em>' reference.
   * @see #setFactoryComponentExposedContract(FactoryComponentContract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_FactoryComponentExposedContract()
   * @see org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContexts
   * @model opposite="invocationContexts" resolveProxies="false"
   * @generated
   */
  FactoryComponentContract getFactoryComponentExposedContract();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getFactoryComponentExposedContract <em>Factory Component Exposed Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Factory Component Exposed Contract</em>' reference.
   * @see #getFactoryComponentExposedContract()
   * @generated
   */
  void setFactoryComponentExposedContract(FactoryComponentContract value);

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
   * @see #setActivityContract(ActivityContract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_ActivityContract()
   * @model required="true"
   * @generated
   */
  ActivityContract getActivityContract();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getActivityContract <em>Activity Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Contract</em>' reference.
   * @see #getActivityContract()
   * @generated
   */
  void setActivityContract(ActivityContract value);

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
   * @model containment="true"
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
   * Returns the value of the '<em><b>Mode</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.egf.model.fcore.ContractMode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' attribute.
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @see #isSetMode()
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocationContext_Mode()
   * @model unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  ContractMode getMode();

  /**
   * Returns whether the value of the '{@link org.eclipse.egf.model.fcore.InvocationContext#getMode <em>Mode</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Mode</em>' attribute is set.
   * @see #getMode()
   * @generated
   */
  boolean isSetMode();

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

} // InvocationContext
