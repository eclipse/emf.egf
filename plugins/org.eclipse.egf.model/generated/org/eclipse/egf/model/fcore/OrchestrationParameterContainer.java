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
 * A representation of the model object '<em><b>Orchestration Parameter Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestration <em>Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestrationParameters <em>Orchestration Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationParameterContainer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UselessOrchestrationParameterContainer'"
 * @generated
 */
public interface OrchestrationParameterContainer extends ModelElement {
  /**
   * Returns the value of the '<em><b>Orchestration</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Orchestration#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration</em>' container reference.
   * @see #setOrchestration(Orchestration)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationParameterContainer_Orchestration()
   * @see org.eclipse.egf.model.fcore.Orchestration#getOrchestrationParameterContainer
   * @model opposite="orchestrationParameterContainer" required="true" transient="false"
   * @generated
   */
  Orchestration getOrchestration();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestration <em>Orchestration</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orchestration</em>' container reference.
   * @see #getOrchestration()
   * @generated
   */
  void setOrchestration(Orchestration value);

  /**
   * Returns the value of the '<em><b>Orchestration Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.OrchestrationParameter}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration Parameters</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestrationParameterContainer_OrchestrationParameters()
   * @see org.eclipse.egf.model.fcore.OrchestrationParameter#getOrchestrationParameterContainer
   * @model opposite="orchestrationParameterContainer" containment="true"
   * @generated
   */
  EList<OrchestrationParameter> getOrchestrationParameters();

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
   * @model
   * @generated
   */
  EList<OrchestrationParameter> getOrchestrationParameters(Type type);

} // OrchestrationParameterContainer
