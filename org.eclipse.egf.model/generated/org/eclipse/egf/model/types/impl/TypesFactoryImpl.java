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
package org.eclipse.egf.model.types.impl;

import org.eclipse.egf.model.types.*;
import org.eclipse.egf.model.types.BigDecimalType;
import org.eclipse.egf.model.types.BigIntegerType;
import org.eclipse.egf.model.types.BooleanType;
import org.eclipse.egf.model.types.ByteType;
import org.eclipse.egf.model.types.CharacterType;
import org.eclipse.egf.model.types.DateType;
import org.eclipse.egf.model.types.DoubleType;
import org.eclipse.egf.model.types.FloatType;
import org.eclipse.egf.model.types.GeneratorAdapterFactoryType;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.LongType;
import org.eclipse.egf.model.types.ShortType;
import org.eclipse.egf.model.types.StringType;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TypesFactory init() {
    try {
      TypesFactory theTypesFactory = (TypesFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/types"); //$NON-NLS-1$ 
      if (theTypesFactory != null) {
        return theTypesFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TypesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case TypesPackage.BIG_DECIMAL_TYPE:
      return createBigDecimalType();
    case TypesPackage.BIG_INTEGER_TYPE:
      return createBigIntegerType();
    case TypesPackage.BOOLEAN_TYPE:
      return createBooleanType();
    case TypesPackage.BYTE_TYPE:
      return createByteType();
    case TypesPackage.CHARACTER_TYPE:
      return createCharacterType();
    case TypesPackage.DATE_TYPE:
      return createDateType();
    case TypesPackage.DOUBLE_TYPE:
      return createDoubleType();
    case TypesPackage.FLOAT_TYPE:
      return createFloatType();
    case TypesPackage.INTEGER_TYPE:
      return createIntegerType();
    case TypesPackage.LONG_TYPE:
      return createLongType();
    case TypesPackage.SHORT_TYPE:
      return createShortType();
    case TypesPackage.STRING_TYPE:
      return createStringType();
    case TypesPackage.GENERATOR_ADAPTER_FACTORY_TYPE:
      return createGeneratorAdapterFactoryType();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimalType createBigDecimalType() {
    BigDecimalTypeImpl bigDecimalType = new BigDecimalTypeImpl();
    return bigDecimalType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigIntegerType createBigIntegerType() {
    BigIntegerTypeImpl bigIntegerType = new BigIntegerTypeImpl();
    return bigIntegerType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanType createBooleanType() {
    BooleanTypeImpl booleanType = new BooleanTypeImpl();
    return booleanType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ByteType createByteType() {
    ByteTypeImpl byteType = new ByteTypeImpl();
    return byteType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CharacterType createCharacterType() {
    CharacterTypeImpl characterType = new CharacterTypeImpl();
    return characterType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DateType createDateType() {
    DateTypeImpl dateType = new DateTypeImpl();
    return dateType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleType createDoubleType() {
    DoubleTypeImpl doubleType = new DoubleTypeImpl();
    return doubleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FloatType createFloatType() {
    FloatTypeImpl floatType = new FloatTypeImpl();
    return floatType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringType createStringType() {
    StringTypeImpl stringType = new StringTypeImpl();
    return stringType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerType createIntegerType() {
    IntegerTypeImpl integerType = new IntegerTypeImpl();
    return integerType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongType createLongType() {
    LongTypeImpl longType = new LongTypeImpl();
    return longType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShortType createShortType() {
    ShortTypeImpl shortType = new ShortTypeImpl();
    return shortType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneratorAdapterFactoryType createGeneratorAdapterFactoryType() {
    GeneratorAdapterFactoryTypeImpl generatorAdapterFactoryType = new GeneratorAdapterFactoryTypeImpl();
    return generatorAdapterFactoryType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesPackage getTypesPackage() {
    return (TypesPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TypesPackage getPackage() {
    return TypesPackage.eINSTANCE;
  }

} // TypesFactoryImpl
