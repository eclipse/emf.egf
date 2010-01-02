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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Query</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.Query#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Query#getExtensionId <em>Extension Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getQuery()
 * @model abstract="true"
 * @generated
 */
public interface Query extends EObject {
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.pattern.PatternParameter#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' container reference.
   * @see #setParameter(PatternParameter)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getQuery_Parameter()
   * @see org.eclipse.egf.model.pattern.PatternParameter#getQuery
   * @model opposite="query" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  PatternParameter getParameter();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.pattern.Query#getParameter <em>Parameter</em>}' container reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' container reference.
   * @see #getParameter()
   * @generated
   */
  void setParameter(PatternParameter value);

  /**
   * Returns the value of the '<em><b>Extension Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension Id</em>' attribute isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension Id</em>' attribute.
   * @see #setExtensionId(String)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getQuery_ExtensionId()
   * @model required="true"
   * @generated
   */
  String getExtensionId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.pattern.Query#getExtensionId <em>Extension Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension Id</em>' attribute.
   * @see #getExtensionId()
   * @generated
   */
  void setExtensionId(String value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  Map<String, String> getQueryContext();

} // Query
