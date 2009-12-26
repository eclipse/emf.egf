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

import org.eclipse.egf.model.fcore.Type;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.DomainType#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.egf.model.domain.DomainType#getEPackage <em>EPackage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getDomainType()
 * @model
 * @generated
 */
public interface DomainType extends Type<Domain> {
  /**
   * Returns the value of the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' reference.
   * @see #setDomain(Domain)
   * @see org.eclipse.egf.model.domain.DomainPackage#getDomainType_Domain()
   * @model resolveProxies="false"
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.domain.DomainType#getDomain <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

  /**
   * Returns the value of the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EPackage</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EPackage</em>' reference.
   * @see #isSetEPackage()
   * @see org.eclipse.egf.model.domain.DomainPackage#getDomainType_EPackage()
   * @model resolveProxies="false" unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  EPackage getEPackage();

  /**
   * Returns whether the value of the '{@link org.eclipse.egf.model.domain.DomainType#getEPackage <em>EPackage</em>}' reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>EPackage</em>' reference is set.
   * @see #getEPackage()
   * @generated
   */
  boolean isSetEPackage();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.egf.model.domain.Domain.class;'"
   * @generated
   */
  Class<Domain> getType();

} // DomainType
