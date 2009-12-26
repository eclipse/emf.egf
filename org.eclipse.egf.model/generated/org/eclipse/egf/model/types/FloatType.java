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
package org.eclipse.egf.model.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.egf.model.types.FloatType#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.egf.model.types.TypesPackage#getFloatType()
 * @model superTypes="org.eclipse.egf.model.types.TypeObject<org.eclipse.emf.ecore.EFloatObject>"
 * @generated
 */
public interface FloatType extends TypeObject<Float> {
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(Float)
   * @see org.eclipse.egf.model.types.TypesPackage#getFloatType_Value()
   * @model
   * @generated
   */
  Float getValue();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.types.FloatType#getValue <em>Value</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(Float value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @model kind="operation" required="true"
   *        
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return java.lang.Float.class;'"
   * @generated
   */
  Class<Float> getType();

} // FloatType
