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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pattern Model</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.PatternModel#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getPatternModel()
 * @model
 * @generated
 */
public interface PatternModel extends AbstractPatternElement {
  /**
   * Returns the value of the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' attribute.
   * @see #setPath(String)
   * @see org.eclipse.egf.model.ModelPackage#getPatternModel_Path()
   * @model required="true"
   * @generated
   */
  String getPath();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.PatternModel#getPath <em>Path</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' attribute.
   * @see #getPath()
   * @generated
   */
  void setPath(String value);

} // PatternModel
