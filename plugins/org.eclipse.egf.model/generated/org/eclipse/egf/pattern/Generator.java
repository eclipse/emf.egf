/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Generator</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.pattern.PatternPackage#getGenerator()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Generator extends EObject {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.egf.common.constant.ICommonConstants.EMPTY_STRING;'"
   * @generated
   */
  String generateBody(Object classLoader_p);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  String generateHeader();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  String generateFooter();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  String generatePreMatching();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  String generatePostMatching();

} // Generator
