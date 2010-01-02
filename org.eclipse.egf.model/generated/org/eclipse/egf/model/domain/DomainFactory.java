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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.domain.DomainPackage
 * @generated
 */
public interface DomainFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DomainFactory eINSTANCE = org.eclipse.egf.model.domain.impl.DomainFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Viewpoint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Viewpoint</em>'.
   * @generated
   */
  DomainViewpoint createDomainViewpoint();

  /**
   * Returns a new object of class '<em>EPackage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EPackage</em>'.
   * @generated
   */
  DomainEPackage createDomainEPackage();

  /**
   * Returns a new object of class '<em>Type Domain EPackage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Domain EPackage</em>'.
   * @generated
   */
  TypeDomainEPackage createTypeDomainEPackage();

  /**
   * Returns a new object of class '<em>URI</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>URI</em>'.
   * @generated
   */
  DomainURI createDomainURI();

  /**
   * Returns a new object of class '<em>Type Domain URI</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Domain URI</em>'.
   * @generated
   */
  TypeDomainURI createTypeDomainURI();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DomainPackage getDomainPackage();

} // DomainFactory
