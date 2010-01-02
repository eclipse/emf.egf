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

import org.eclipse.egf.model.types.Type;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Domain EPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.TypeDomainEPackage#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.egf.model.domain.TypeDomainEPackage#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomainEPackage()
 * @model
 * @generated
 */
public interface TypeDomainEPackage extends Type<EPackage> {
  /**
   * Returns the value of the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' reference.
   * @see #setDomain(DomainEPackage)
   * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomainEPackage_Domain()
   * @model resolveProxies="false"
   * @generated
   */
  DomainEPackage getDomain();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.domain.TypeDomainEPackage#getDomain <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(DomainEPackage value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomainEPackage_Value()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  EPackage getValue();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.emf.ecore.EPackage.class;'"
   * @generated
   */
  Class<EPackage> getType();

} // TypeDomainEPackage
