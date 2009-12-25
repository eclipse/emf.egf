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
 * A representation of the model object '<em><b>Contract Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.ContractConnector#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ContractConnector#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ContractConnector#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getContractConnector()
 * @model
 * @generated
 */
public interface ContractConnector extends ModelElement {
  /**
   * Returns the value of the '<em><b>Context</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.ContextContainer#getConnectors <em>Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context</em>' container reference.
   * @see #setContext(ContextContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContractConnector_Context()
   * @see org.eclipse.egf.model.fcore.ContextContainer#getConnectors
   * @model opposite="connectors" resolveProxies="false" transient="false"
   * @generated
   */
  ContextContainer getContext();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ContractConnector#getContext <em>Context</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context</em>' container reference.
   * @see #getContext()
   * @generated
   */
  void setContext(ContextContainer value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(Contract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContractConnector_Source()
   * @model required="true"
   * @generated
   */
  Contract getSource();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ContractConnector#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(Contract value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Contract)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getContractConnector_Target()
   * @model required="true"
   * @generated
   */
  Contract getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ContractConnector#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Contract value);

} // ContractConnector
