/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Orchestration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.Orchestration#getFactoryComponent <em>Factory Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getOrchestration()
 * @model abstract="true"
 * @generated
 */
public interface Orchestration extends ModelElement {

  /**
   * Returns the value of the '<em><b>Factory Component</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.factorycomponent.FactoryComponent#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory Component</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Component</em>' container reference.
   * @see #setFactoryComponent(FactoryComponent)
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getOrchestration_FactoryComponent()
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponent#getOrchestration
   * @model opposite="orchestration" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  FactoryComponent getFactoryComponent();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.factorycomponent.Orchestration#getFactoryComponent <em>Factory Component</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Factory Component</em>' container reference.
   * @see #getFactoryComponent()
   * @generated
   */
  void setFactoryComponent(FactoryComponent value);
} // Orchestration
