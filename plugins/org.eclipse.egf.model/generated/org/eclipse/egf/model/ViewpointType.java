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
package org.eclipse.egf.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Viewpoint Type</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 * @see org.eclipse.egf.model.ModelPackage#getViewpointType()
 * @model
 * @generated
 */
public enum ViewpointType implements Enumerator {
  /**
   * The '<em><b>CONTRACT</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #CONTRACT_VALUE
   * @generated
   * @ordered
   */
  CONTRACT(0, "CONTRACT", "CONTRACT"), //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>PATTERN</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #PATTERN_VALUE
   * @generated
   * @ordered
   */
  PATTERN(1, "PATTERN", "PATTERN"), //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>MAPPING</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #MAPPING_VALUE
   * @generated
   * @ordered
   */
  MAPPING(2, "MAPPING", "MAPPING"); //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>CONTRACT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONTRACT</b></em>' literal object isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONTRACT
   * @model
   * @generated
   * @ordered
   */
  public static final int CONTRACT_VALUE = 0;

  /**
   * The '<em><b>PATTERN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PATTERN</b></em>' literal object isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PATTERN
   * @model
   * @generated
   * @ordered
   */
  public static final int PATTERN_VALUE = 1;

  /**
   * The '<em><b>MAPPING</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MAPPING</b></em>' literal object isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MAPPING
   * @model
   * @generated
   * @ordered
   */
  public static final int MAPPING_VALUE = 2;

  /**
   * An array of all the '<em><b>Viewpoint Type</b></em>' enumerators.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static final ViewpointType[] VALUES_ARRAY = new ViewpointType[] {
      CONTRACT,
      PATTERN,
      MAPPING,
    };

  /**
   * A public read-only list of all the '<em><b>Viewpoint Type</b></em>' enumerators.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static final List<ViewpointType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Viewpoint Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ViewpointType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ViewpointType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Viewpoint Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ViewpointType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ViewpointType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Viewpoint Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ViewpointType get(int value) {
    switch (value) {
      case CONTRACT_VALUE: return CONTRACT;
      case PATTERN_VALUE: return PATTERN;
      case MAPPING_VALUE: return MAPPING;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private ViewpointType(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // ViewpointType
