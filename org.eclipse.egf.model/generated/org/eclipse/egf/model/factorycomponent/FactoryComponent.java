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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.FactoryComponent#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.FactoryComponent#getOrchestration <em>Orchestration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getFactoryComponent()
 * @model
 * @generated
 */
public interface FactoryComponent extends Activity {
  /**
   * Returns the value of the '<em><b>Viewpoints</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.factorycomponent.Viewpoint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Viewpoints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Viewpoints</em>' containment reference list.
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getFactoryComponent_Viewpoints()
   * @model containment="true"
   * @generated
   */
  EList<Viewpoint> getViewpoints();

  /**
   * Returns the value of the '<em><b>Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration</em>' containment reference.
   * @see #setOrchestration(Orchestration)
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage#getFactoryComponent_Orchestration()
   * @model containment="true"
   * @generated
   */
  Orchestration getOrchestration();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.factorycomponent.FactoryComponent#getOrchestration <em>Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orchestration</em>' containment reference.
   * @see #getOrchestration()
   * @generated
   */
  void setOrchestration(Orchestration value);

} // FactoryComponent
