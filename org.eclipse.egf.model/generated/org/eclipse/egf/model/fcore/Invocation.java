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
 * A representation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.egf.model.fcore.Invocation#getContext <em>Context
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation()
 * @model abstract="true"
 * @generated
 */
public interface Invocation extends ModelElement {
  /**
   * Returns the value of the '<em><b>Context</b></em>' containment reference.
   * It is bidirectional and its opposite is '
   * {@link org.eclipse.egf.model.fcore.Context#getInvocation
   * <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Context</em>' containment reference.
   * @see #setContext(Context)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getInvocation_Context()
   * @see org.eclipse.egf.model.fcore.Context#getInvocation
   * @model opposite="invocation" containment="true"
   * @generated
   */
  Context getContext();

  /**
   * Sets the value of the '
   * {@link org.eclipse.egf.model.fcore.Invocation#getContext <em>Context</em>}'
   * containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Context</em>' containment reference.
   * @see #getContext()
   * @generated
   */
  void setContext(Context value);

} // Invocation
