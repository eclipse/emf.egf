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

import java.beans.PropertyChangeListener;

import org.eclipse.egf.pattern.relations.CallParameter;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pattern.relations.ReferenceRelation;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pattern</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.pattern.Pattern#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.Pattern#getShortId <em>Short Id</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.Pattern#getLogicalName <em>Logical Name</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.Pattern#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.Pattern#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.Pattern#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.Pattern#getCallParameters <em>Call Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.pattern.PatternPackage#getPattern()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='overall'"
 * @generated
 */
public interface Pattern extends EClass, Generator {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.egf.pattern.PatternPackage#getPattern_Id()
   * @model required="true"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.pattern.Pattern#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Short Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Short Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Short Id</em>' attribute.
   * @see org.eclipse.egf.pattern.PatternPackage#getPattern_ShortId()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  String getShortId();

  /**
   * Returns the value of the '<em><b>Logical Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Logical Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logical Name</em>' attribute.
   * @see #setLogicalName(String)
   * @see org.eclipse.egf.pattern.PatternPackage#getPattern_LogicalName()
   * @model
   * @generated
   */
  String getLogicalName();

  /**
   * Sets the value of the '{@link org.eclipse.egf.pattern.Pattern#getLogicalName <em>Logical Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logical Name</em>' attribute.
   * @see #getLogicalName()
   * @generated
   */
  void setLogicalName(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.eclipse.egf.pattern.PatternPackage#getPattern_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.eclipse.egf.pattern.Pattern#getDescription <em>Description</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.pattern.relations.ReferenceRelation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relations</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relations</em>' containment reference list.
   * @see org.eclipse.egf.pattern.PatternPackage#getPattern_Relations()
   * @model containment="true"
   * @generated
   */
  EList<ReferenceRelation> getRelations();

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.pattern.relations.ParameterRelation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.egf.pattern.PatternPackage#getPattern_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<ParameterRelation> getParameters();

  /**
   * Returns the value of the '<em><b>Call Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.pattern.relations.CallParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call Parameters</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call Parameters</em>' containment reference list.
   * @see org.eclipse.egf.pattern.PatternPackage#getPattern_CallParameters()
   * @model containment="true"
   * @generated
   */
  EList<CallParameter> getCallParameters();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder stringBuilder = new StringBuilder(generateHeader());\r\nstringBuilder.append(generate(classLoader_p));\r\nstringBuilder.append(generateFooter());\r\nreturn stringBuilder.toString();'"
   * @generated
   */
  String produce(Object classLoader_p);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder stringBuilder = new StringBuilder(generatePreMatching());\r\nstringBuilder.append(generateBody(classLoader_p));\r\nstringBuilder.append(generatePostMatching());\r\nreturn stringBuilder.toString();'"
   * @generated
   */
  String generate(Object classLoader_p);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model listener_pDataType="org.eclipse.egf.pattern.PPropertyChangeListener"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='// Avoid the JFace data-binding not very nice error message.'"
   * @generated
   */
  void addPropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model listener_pDataType="org.eclipse.egf.pattern.PPropertyChangeListener"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='// Avoid the JFace data-binding not very nice error message.'"
   * @generated
   */
  void removePropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p);

} // Pattern
