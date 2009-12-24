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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Injected Call</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.egf.model.pattern.PatternInjectedCall#getContext <em>
 * Context</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternInjectedCall()
 * @model
 * @generated
 */
public interface PatternInjectedCall extends AbstractPatternCall {
  /**
   * Returns the value of the '<em><b>Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' reference isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Context</em>' reference.
   * @see #setContext(PatternVariable)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternInjectedCall_Context()
   * @model resolveProxies="false" required="true"
   * @generated
   */
  PatternVariable getContext();

  /**
   * Sets the value of the '
   * {@link org.eclipse.egf.model.pattern.PatternInjectedCall#getContext
   * <em>Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Context</em>' reference.
   * @see #getContext()
   * @generated
   */
  void setContext(PatternVariable value);

} // PatternInjectedCall
