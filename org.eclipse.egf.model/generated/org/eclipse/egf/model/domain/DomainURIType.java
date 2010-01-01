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

import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URI Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.DomainURIType#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.egf.model.domain.DomainURIType#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getDomainURIType()
 * @model superTypes="org.eclipse.egf.model.fcore.Type<org.eclipse.egf.model.fcore.URI>"
 * @generated
 */
public interface DomainURIType extends Type<URI> {
  /**
   * Returns the value of the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' reference.
   * @see #setDomain(DomainURI)
   * @see org.eclipse.egf.model.domain.DomainPackage#getDomainURIType_Domain()
   * @model resolveProxies="false"
   * @generated
   */
  DomainURI getDomain();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.domain.DomainURIType#getDomain <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(DomainURI value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see org.eclipse.egf.model.domain.DomainPackage#getDomainURIType_Value()
   * @model dataType="org.eclipse.egf.model.fcore.URI" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  URI getValue();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.emf.common.util.URI.class;'"
   * @generated
   */
  Class<URI> getType();

} // DomainURIType
