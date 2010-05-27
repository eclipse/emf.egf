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
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.types.TypeObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Domain EPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.TypeDomainEPackage#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomainEPackage()
 * @model
 * @generated
 */
public interface TypeDomainEPackage extends TypeObject {
  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(DomainEPackage)
   * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomainEPackage_Value()
   * @model resolveProxies="false"
   * @generated
   */
  DomainEPackage getValue();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.domain.TypeDomainEPackage#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(DomainEPackage value);

} // TypeDomainEPackage
