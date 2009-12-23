/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.jetpattern;

import org.eclipse.egf.model.pattern.PatternNature;

import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jet Nature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.jetpattern.JetNature#isCompileTemplate <em>Compile Template</em>}</li>
 *   <li>{@link org.eclipse.egf.model.jetpattern.JetNature#getTemplateFilePath <em>Template File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.jetpattern.JetpatternPackage#getJetNature()
 * @model
 * @generated
 */
public interface JetNature extends PatternNature {
  /**
   * Returns the value of the '<em><b>Compile Template</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compile Template</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compile Template</em>' attribute.
   * @see #setCompileTemplate(boolean)
   * @see org.eclipse.egf.model.jetpattern.JetpatternPackage#getJetNature_CompileTemplate()
   * @model default="false" required="true"
   * @generated
   */
  boolean isCompileTemplate();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.jetpattern.JetNature#isCompileTemplate <em>Compile Template</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compile Template</em>' attribute.
   * @see #isCompileTemplate()
   * @generated
   */
  void setCompileTemplate(boolean value);

  /**
   * Returns the value of the '<em><b>Template File Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template File Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template File Path</em>' attribute.
   * @see #setTemplateFilePath(URI)
   * @see org.eclipse.egf.model.jetpattern.JetpatternPackage#getJetNature_TemplateFilePath()
   * @model dataType="org.eclipse.egf.model.factorycomponent.URI"
   * @generated
   */
  URI getTemplateFilePath();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.jetpattern.JetNature#getTemplateFilePath <em>Template File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Template File Path</em>' attribute.
   * @see #getTemplateFilePath()
   * @generated
   */
  void setTemplateFilePath(URI value);

} // JetNature
