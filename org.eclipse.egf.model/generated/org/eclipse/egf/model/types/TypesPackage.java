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

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "types"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/types"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "types"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TypesPackage eINSTANCE = org.eclipse.egf.model.types.impl.TypesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BigDecimalTypeImpl <em>Big Decimal Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BigDecimalTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBigDecimalType()
   * @generated
   */
  int BIG_DECIMAL_TYPE = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Big Decimal Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BigIntegerTypeImpl <em>Big Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BigIntegerTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBigIntegerType()
   * @generated
   */
  int BIG_INTEGER_TYPE = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Big Integer Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BooleanTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.ByteTypeImpl <em>Byte Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.ByteTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getByteType()
   * @generated
   */
  int BYTE_TYPE = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Byte Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.CharacterTypeImpl <em>Character Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.CharacterTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getCharacterType()
   * @generated
   */
  int CHARACTER_TYPE = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Character Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.DateTypeImpl <em>Date Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.DateTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getDateType()
   * @generated
   */
  int DATE_TYPE = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Date Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.DoubleTypeImpl <em>Double Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.DoubleTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getDoubleType()
   * @generated
   */
  int DOUBLE_TYPE = 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.FloatTypeImpl <em>Float Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.FloatTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getFloatType()
   * @generated
   */
  int FLOAT_TYPE = 7;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Float Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.StringTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 11;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.IntegerTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getIntegerType()
   * @generated
   */
  int INTEGER_TYPE = 8;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.LongTypeImpl <em>Long Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.LongTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getLongType()
   * @generated
   */
  int LONG_TYPE = 9;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Long Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.ShortTypeImpl <em>Short Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.ShortTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getShortType()
   * @generated
   */
  int SHORT_TYPE = 10;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Short Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__ID = FcorePackage.TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__NAME = FcorePackage.TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__DESCRIPTION = FcorePackage.TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__VALUE = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = FcorePackage.TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl <em>Generator Adapter Factory Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getGeneratorAdapterFactoryType()
   * @generated
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE = 12;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__ID = FcorePackage.TYPE_CLASS__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__NAME = FcorePackage.TYPE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__DESCRIPTION = FcorePackage.TYPE_CLASS__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__VALUE = FcorePackage.TYPE_CLASS__VALUE;

  /**
   * The number of structural features of the '<em>Generator Adapter Factory Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE_FEATURE_COUNT = FcorePackage.TYPE_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '<em>EGenerator Adapter Factory</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getEGeneratorAdapterFactory()
   * @generated
   */
  int EGENERATOR_ADAPTER_FACTORY = 13;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.BigDecimalType <em>Big Decimal Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Big Decimal Type</em>'.
   * @see org.eclipse.egf.model.types.BigDecimalType
   * @generated
   */
  EClass getBigDecimalType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.BigDecimalType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.BigDecimalType#getValue()
   * @see #getBigDecimalType()
   * @generated
   */
  EAttribute getBigDecimalType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.BigIntegerType <em>Big Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Big Integer Type</em>'.
   * @see org.eclipse.egf.model.types.BigIntegerType
   * @generated
   */
  EClass getBigIntegerType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.BigIntegerType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.BigIntegerType#getValue()
   * @see #getBigIntegerType()
   * @generated
   */
  EAttribute getBigIntegerType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Type</em>'.
   * @see org.eclipse.egf.model.types.BooleanType
   * @generated
   */
  EClass getBooleanType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.BooleanType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.BooleanType#getValue()
   * @see #getBooleanType()
   * @generated
   */
  EAttribute getBooleanType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.ByteType <em>Byte Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Byte Type</em>'.
   * @see org.eclipse.egf.model.types.ByteType
   * @generated
   */
  EClass getByteType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.ByteType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.ByteType#getValue()
   * @see #getByteType()
   * @generated
   */
  EAttribute getByteType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.CharacterType <em>Character Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Character Type</em>'.
   * @see org.eclipse.egf.model.types.CharacterType
   * @generated
   */
  EClass getCharacterType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.CharacterType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.CharacterType#getValue()
   * @see #getCharacterType()
   * @generated
   */
  EAttribute getCharacterType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.DateType <em>Date Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Date Type</em>'.
   * @see org.eclipse.egf.model.types.DateType
   * @generated
   */
  EClass getDateType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.DateType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.DateType#getValue()
   * @see #getDateType()
   * @generated
   */
  EAttribute getDateType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.DoubleType <em>Double Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Type</em>'.
   * @see org.eclipse.egf.model.types.DoubleType
   * @generated
   */
  EClass getDoubleType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.DoubleType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.DoubleType#getValue()
   * @see #getDoubleType()
   * @generated
   */
  EAttribute getDoubleType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.FloatType <em>Float Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Float Type</em>'.
   * @see org.eclipse.egf.model.types.FloatType
   * @generated
   */
  EClass getFloatType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.FloatType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.FloatType#getValue()
   * @see #getFloatType()
   * @generated
   */
  EAttribute getFloatType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type</em>'.
   * @see org.eclipse.egf.model.types.StringType
   * @generated
   */
  EClass getStringType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.StringType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.StringType#getValue()
   * @see #getStringType()
   * @generated
   */
  EAttribute getStringType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.IntegerType <em>Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Type</em>'.
   * @see org.eclipse.egf.model.types.IntegerType
   * @generated
   */
  EClass getIntegerType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.IntegerType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.IntegerType#getValue()
   * @see #getIntegerType()
   * @generated
   */
  EAttribute getIntegerType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.LongType <em>Long Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Long Type</em>'.
   * @see org.eclipse.egf.model.types.LongType
   * @generated
   */
  EClass getLongType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.LongType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.LongType#getValue()
   * @see #getLongType()
   * @generated
   */
  EAttribute getLongType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.ShortType <em>Short Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Short Type</em>'.
   * @see org.eclipse.egf.model.types.ShortType
   * @generated
   */
  EClass getShortType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.ShortType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.ShortType#getValue()
   * @see #getShortType()
   * @generated
   */
  EAttribute getShortType_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.GeneratorAdapterFactoryType <em>Generator Adapter Factory Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generator Adapter Factory Type</em>'.
   * @see org.eclipse.egf.model.types.GeneratorAdapterFactoryType
   * @generated
   */
  EClass getGeneratorAdapterFactoryType();

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory <em>EGenerator Adapter Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>EGenerator Adapter Factory</em>'.
   * @see org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory
   * @model instanceClass="org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory" serializeable="false"
   * @generated
   */
  EDataType getEGeneratorAdapterFactory();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TypesFactory getTypesFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.BigDecimalTypeImpl <em>Big Decimal Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.BigDecimalTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBigDecimalType()
     * @generated
     */
    EClass BIG_DECIMAL_TYPE = eINSTANCE.getBigDecimalType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIG_DECIMAL_TYPE__VALUE = eINSTANCE.getBigDecimalType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.BigIntegerTypeImpl <em>Big Integer Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.BigIntegerTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBigIntegerType()
     * @generated
     */
    EClass BIG_INTEGER_TYPE = eINSTANCE.getBigIntegerType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIG_INTEGER_TYPE__VALUE = eINSTANCE.getBigIntegerType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.BooleanTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBooleanType()
     * @generated
     */
    EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_TYPE__VALUE = eINSTANCE.getBooleanType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.ByteTypeImpl <em>Byte Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.ByteTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getByteType()
     * @generated
     */
    EClass BYTE_TYPE = eINSTANCE.getByteType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BYTE_TYPE__VALUE = eINSTANCE.getByteType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.CharacterTypeImpl <em>Character Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.CharacterTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getCharacterType()
     * @generated
     */
    EClass CHARACTER_TYPE = eINSTANCE.getCharacterType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHARACTER_TYPE__VALUE = eINSTANCE.getCharacterType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.DateTypeImpl <em>Date Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.DateTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getDateType()
     * @generated
     */
    EClass DATE_TYPE = eINSTANCE.getDateType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATE_TYPE__VALUE = eINSTANCE.getDateType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.DoubleTypeImpl <em>Double Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.DoubleTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getDoubleType()
     * @generated
     */
    EClass DOUBLE_TYPE = eINSTANCE.getDoubleType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_TYPE__VALUE = eINSTANCE.getDoubleType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.FloatTypeImpl <em>Float Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.FloatTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getFloatType()
     * @generated
     */
    EClass FLOAT_TYPE = eINSTANCE.getFloatType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOAT_TYPE__VALUE = eINSTANCE.getFloatType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.StringTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getStringType()
     * @generated
     */
    EClass STRING_TYPE = eINSTANCE.getStringType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_TYPE__VALUE = eINSTANCE.getStringType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.IntegerTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getIntegerType()
     * @generated
     */
    EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_TYPE__VALUE = eINSTANCE.getIntegerType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.LongTypeImpl <em>Long Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.LongTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getLongType()
     * @generated
     */
    EClass LONG_TYPE = eINSTANCE.getLongType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LONG_TYPE__VALUE = eINSTANCE.getLongType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.ShortTypeImpl <em>Short Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.ShortTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getShortType()
     * @generated
     */
    EClass SHORT_TYPE = eINSTANCE.getShortType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHORT_TYPE__VALUE = eINSTANCE.getShortType_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl <em>Generator Adapter Factory Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getGeneratorAdapterFactoryType()
     * @generated
     */
    EClass GENERATOR_ADAPTER_FACTORY_TYPE = eINSTANCE.getGeneratorAdapterFactoryType();

    /**
     * The meta object literal for the '<em>EGenerator Adapter Factory</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getEGeneratorAdapterFactory()
     * @generated
     */
    EDataType EGENERATOR_ADAPTER_FACTORY = eINSTANCE.getEGeneratorAdapterFactory();

  }

} // TypesPackage
