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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.egf.model.pattern.Call#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.egf.model.pattern.PatternPackage#getCall()
 * @model abstract="true"
 * @generated
 */
public interface Call extends EObject {
  /**
   * Returns the value of the '<em><b>Pattern</b></em>' container reference.
   * It is bidirectional and its opposite is '
   * {@link org.eclipse.egf.model.pattern.Pattern#getOrchestration
   * <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Pattern</em>' container reference.
   * @see #setPattern(Pattern)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getCall_Pattern()
   * @see org.eclipse.egf.model.pattern.Pattern#getOrchestration
   * @model opposite="orchestration" required="true" transient="false"
   * @generated
   */
  Pattern getPattern();

  /**
   * Sets the value of the '
   * {@link org.eclipse.egf.model.pattern.Call#getPattern <em>Pattern</em>}'
   * container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Pattern</em>' container reference.
   * @see #getPattern()
   * @generated
   */
  void setPattern(Pattern value);

} // Call
