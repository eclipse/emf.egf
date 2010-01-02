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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.types.TypesPackage
 * @generated
 */
public interface TypesFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TypesFactory eINSTANCE = org.eclipse.egf.model.types.impl.TypesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Type Collection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Collection</em>'.
   * @generated
   */
  TypeCollection createTypeCollection();

  /**
   * Returns a new object of class '<em>Type List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type List</em>'.
   * @generated
   */
  TypeList createTypeList();

  /**
   * Returns a new object of class '<em>Type Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Set</em>'.
   * @generated
   */
  TypeSet createTypeSet();

  /**
   * Returns a new object of class '<em>Type Generator Adapter Factory</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Generator Adapter Factory</em>'.
   * @generated
   */
  TypeGeneratorAdapterFactory createTypeGeneratorAdapterFactory();

  /**
   * Returns a new object of class '<em>Type Map</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Map</em>'.
   * @generated
   */
  TypeMap createTypeMap();

  /**
   * Returns a new object of class '<em>Type Big Decimal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Big Decimal</em>'.
   * @generated
   */
  TypeBigDecimal createTypeBigDecimal();

  /**
   * Returns a new object of class '<em>Type Big Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Big Integer</em>'.
   * @generated
   */
  TypeBigInteger createTypeBigInteger();

  /**
   * Returns a new object of class '<em>Type Boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Boolean</em>'.
   * @generated
   */
  TypeBoolean createTypeBoolean();

  /**
   * Returns a new object of class '<em>Type Byte</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Byte</em>'.
   * @generated
   */
  TypeByte createTypeByte();

  /**
   * Returns a new object of class '<em>Type Character</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Character</em>'.
   * @generated
   */
  TypeCharacter createTypeCharacter();

  /**
   * Returns a new object of class '<em>Type Date</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Date</em>'.
   * @generated
   */
  TypeDate createTypeDate();

  /**
   * Returns a new object of class '<em>Type Double</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Double</em>'.
   * @generated
   */
  TypeDouble createTypeDouble();

  /**
   * Returns a new object of class '<em>Type Float</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Float</em>'.
   * @generated
   */
  TypeFloat createTypeFloat();

  /**
   * Returns a new object of class '<em>Type Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Integer</em>'.
   * @generated
   */
  TypeInteger createTypeInteger();

  /**
   * Returns a new object of class '<em>Type Long</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Long</em>'.
   * @generated
   */
  TypeLong createTypeLong();

  /**
   * Returns a new object of class '<em>Type Short</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Short</em>'.
   * @generated
   */
  TypeShort createTypeShort();

  /**
   * Returns a new object of class '<em>Type String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type String</em>'.
   * @generated
   */
  TypeString createTypeString();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TypesPackage getTypesPackage();

} // TypesFactory
