/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pattern Library</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.PatternLibrary#getPatternElements <em>Pattern Elements</em>}</li>
 *   <li>{@link org.eclipse.egf.model.PatternLibrary#getProductionOrchestration <em>Production Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.PatternLibrary#getRuntimeOrchestration <em>Runtime Orchestration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getPatternLibrary()
 * @model
 * @generated
 */
public interface PatternLibrary extends AbstractPatternElement {
  /**
   * Returns the value of the '<em><b>Pattern Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.AbstractPatternElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern Elements</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern Elements</em>' containment reference list.
   * @see org.eclipse.egf.model.ModelPackage#getPatternLibrary_PatternElements()
   * @model containment="true"
   * @generated
   */
  EList<AbstractPatternElement> getPatternElements();

  /**
   * Returns the value of the '<em><b>Production Orchestration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Production Orchestration</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Production Orchestration</em>' attribute.
   * @see #setProductionOrchestration(String)
   * @see org.eclipse.egf.model.ModelPackage#getPatternLibrary_ProductionOrchestration()
   * @model
   * @generated
   */
  String getProductionOrchestration();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.PatternLibrary#getProductionOrchestration <em>Production Orchestration</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Production Orchestration</em>' attribute.
   * @see #getProductionOrchestration()
   * @generated
   */
  void setProductionOrchestration(String value);

  /**
   * Returns the value of the '<em><b>Runtime Orchestration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Runtime Orchestration</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Runtime Orchestration</em>' attribute.
   * @see #setRuntimeOrchestration(String)
   * @see org.eclipse.egf.model.ModelPackage#getPatternLibrary_RuntimeOrchestration()
   * @model
   * @generated
   */
  String getRuntimeOrchestration();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.PatternLibrary#getRuntimeOrchestration <em>Runtime Orchestration</em>}' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Runtime Orchestration</em>' attribute.
   * @see #getRuntimeOrchestration()
   * @generated
   */
  void setRuntimeOrchestration(String value);

} // PatternLibrary
