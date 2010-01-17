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
package org.eclipse.egf.model.pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternLibrary#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternLibrary#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternLibrary()
 * @model
 * @generated
 */
public interface PatternLibrary extends PatternElement {
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.pattern.PatternElement}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.pattern.PatternElement#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternLibrary_Elements()
   * @see org.eclipse.egf.model.pattern.PatternElement#getContainer
   * @model opposite="container" containment="true"
   * @generated
   */
  EList<PatternElement> getElements();

  /**
   * Returns the value of the '<em><b>Filters</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type list of {@link org.eclipse.egf.model.pattern.PatternElement},
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filters</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filters</em>' map.
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternLibrary_Filters()
   * @model mapType="org.eclipse.egf.model.pattern.String2PatternList<org.eclipse.emf.ecore.EString, org.eclipse.egf.model.pattern.PatternElement>"
   * @generated
   */
  EMap<String, EList<PatternElement>> getFilters();

} // PatternLibrary
