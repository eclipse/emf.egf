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

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
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
   * Returns a new object of class '<em>Big Decimal Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Big Decimal Type</em>'.
   * @generated
   */
  BigDecimalType createBigDecimalType();

  /**
   * Returns a new object of class '<em>Big Integer Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Big Integer Type</em>'.
   * @generated
   */
  BigIntegerType createBigIntegerType();

  /**
   * Returns a new object of class '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Type</em>'.
   * @generated
   */
  BooleanType createBooleanType();

  /**
   * Returns a new object of class '<em>Byte Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Byte Type</em>'.
   * @generated
   */
  ByteType createByteType();

  /**
   * Returns a new object of class '<em>Character Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Character Type</em>'.
   * @generated
   */
  CharacterType createCharacterType();

  /**
   * Returns a new object of class '<em>Date Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date Type</em>'.
   * @generated
   */
  DateType createDateType();

  /**
   * Returns a new object of class '<em>Double Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Double Type</em>'.
   * @generated
   */
  DoubleType createDoubleType();

  /**
   * Returns a new object of class '<em>Float Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Float Type</em>'.
   * @generated
   */
  FloatType createFloatType();

  /**
   * Returns a new object of class '<em>String Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Type</em>'.
   * @generated
   */
  StringType createStringType();

  /**
   * Returns a new object of class '<em>Integer Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Type</em>'.
   * @generated
   */
  IntegerType createIntegerType();

  /**
   * Returns a new object of class '<em>Long Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Long Type</em>'.
   * @generated
   */
  LongType createLongType();

  /**
   * Returns a new object of class '<em>Short Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Short Type</em>'.
   * @generated
   */
  ShortType createShortType();

  /**
   * Returns a new object of class '<em>Generator Adapter Factory Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Generator Adapter Factory Type</em>'.
   * @generated
   */
  GeneratorAdapterFactoryType createGeneratorAdapterFactoryType();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TypesPackage getTypesPackage();

} // TypesFactory
