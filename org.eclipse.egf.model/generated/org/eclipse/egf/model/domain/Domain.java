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
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.egf.model.domain.Domain#getEpackage <em>Epackage</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.egf.model.domain.DomainPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends ModelElement {
  /**
   * Returns the value of the '<em><b>Epackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Epackage</em>' reference isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Epackage</em>' reference.
   * @see #setEpackage(EPackage)
   * @see org.eclipse.egf.model.domain.DomainPackage#getDomain_Epackage()
   * @model required="true"
   * @generated
   */
  EPackage getEpackage();

  /**
   * Sets the value of the '
   * {@link org.eclipse.egf.model.domain.Domain#getEpackage <em>Epackage</em>}'
   * reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Epackage</em>' reference.
   * @see #getEpackage()
   * @generated
   */
  void setEpackage(EPackage value);

} // Domain
