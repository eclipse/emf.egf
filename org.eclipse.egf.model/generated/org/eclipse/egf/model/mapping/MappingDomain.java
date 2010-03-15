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
package org.eclipse.egf.model.mapping;

import org.eclipse.egf.model.domain.Domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.mapping.MappingDomain#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.egf.model.mapping.MappingDomain#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.mapping.MappingPackage#getMappingDomain()
 * @model
 * @generated
 */
public interface MappingDomain extends Mapping {
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(Domain)
   * @see org.eclipse.egf.model.mapping.MappingPackage#getMappingDomain_Source()
   * @model resolveProxies="false" required="true"
   * @generated
   */
  Domain getSource();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.mapping.MappingDomain#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(Domain value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Domain)
   * @see org.eclipse.egf.model.mapping.MappingPackage#getMappingDomain_Target()
   * @model resolveProxies="false" required="true"
   * @generated
   */
  Domain getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.mapping.MappingDomain#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Domain value);

} // MappingDomain
