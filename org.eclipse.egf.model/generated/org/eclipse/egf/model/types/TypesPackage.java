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
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeObjectImpl <em>Type Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.TypeObjectImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeObject()
   * @generated
   */
  int TYPE_OBJECT = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT__ID = FcorePackage.TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT__NAME = FcorePackage.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT__DESCRIPTION = FcorePackage.TYPE__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Type Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT_FEATURE_COUNT = FcorePackage.TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeClassImpl <em>Type Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.TypeClassImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeClass()
   * @generated
   */
  int TYPE_CLASS = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__ID = FcorePackage.TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__NAME = FcorePackage.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__DESCRIPTION = FcorePackage.TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__VALUE = FcorePackage.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS_FEATURE_COUNT = FcorePackage.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeCollectionImpl <em>Type Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.TypeCollectionImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeCollection()
   * @generated
   */
  int TYPE_COLLECTION = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_COLLECTION__ID = TYPE_CLASS__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_COLLECTION__NAME = TYPE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_COLLECTION__DESCRIPTION = TYPE_CLASS__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_COLLECTION__VALUE = TYPE_CLASS__VALUE;

  /**
   * The number of structural features of the '<em>Type Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_COLLECTION_FEATURE_COUNT = TYPE_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeListImpl <em>Type List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.TypeListImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeList()
   * @generated
   */
  int TYPE_LIST = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LIST__ID = TYPE_CLASS__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LIST__NAME = TYPE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LIST__DESCRIPTION = TYPE_CLASS__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LIST__VALUE = TYPE_CLASS__VALUE;

  /**
   * The number of structural features of the '<em>Type List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LIST_FEATURE_COUNT = TYPE_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeSetImpl <em>Type Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.TypeSetImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeSet()
   * @generated
   */
  int TYPE_SET = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SET__ID = TYPE_CLASS__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SET__NAME = TYPE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SET__DESCRIPTION = TYPE_CLASS__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SET__VALUE = TYPE_CLASS__VALUE;

  /**
   * The number of structural features of the '<em>Type Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SET_FEATURE_COUNT = TYPE_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeMapImpl <em>Type Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.TypeMapImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeMap()
   * @generated
   */
  int TYPE_MAP = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MAP__ID = TYPE_CLASS__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MAP__NAME = TYPE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MAP__DESCRIPTION = TYPE_CLASS__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MAP__VALUE = TYPE_CLASS__VALUE;

  /**
   * The number of structural features of the '<em>Type Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MAP_FEATURE_COUNT = TYPE_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BigDecimalTypeImpl <em>Big Decimal Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BigDecimalTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBigDecimalType()
   * @generated
   */
  int BIG_DECIMAL_TYPE = 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Big Decimal Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_DECIMAL_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BigIntegerTypeImpl <em>Big Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BigIntegerTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBigIntegerType()
   * @generated
   */
  int BIG_INTEGER_TYPE = 7;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Big Integer Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_INTEGER_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BooleanTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 8;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.ByteTypeImpl <em>Byte Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.ByteTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getByteType()
   * @generated
   */
  int BYTE_TYPE = 9;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Byte Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BYTE_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.CharacterTypeImpl <em>Character Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.CharacterTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getCharacterType()
   * @generated
   */
  int CHARACTER_TYPE = 10;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Character Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.DateTypeImpl <em>Date Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.DateTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getDateType()
   * @generated
   */
  int DATE_TYPE = 11;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Date Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.DoubleTypeImpl <em>Double Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.DoubleTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getDoubleType()
   * @generated
   */
  int DOUBLE_TYPE = 12;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.FloatTypeImpl <em>Float Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.FloatTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getFloatType()
   * @generated
   */
  int FLOAT_TYPE = 13;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Float Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.StringTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 17;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.IntegerTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getIntegerType()
   * @generated
   */
  int INTEGER_TYPE = 14;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.LongTypeImpl <em>Long Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.LongTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getLongType()
   * @generated
   */
  int LONG_TYPE = 15;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Long Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.ShortTypeImpl <em>Short Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.ShortTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getShortType()
   * @generated
   */
  int SHORT_TYPE = 16;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Short Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORT_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__ID = TYPE_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__NAME = TYPE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl <em>Generator Adapter Factory Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getGeneratorAdapterFactoryType()
   * @generated
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE = 18;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__ID = TYPE_CLASS__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__NAME = TYPE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__DESCRIPTION = TYPE_CLASS__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__VALUE = TYPE_CLASS__VALUE;

  /**
   * The number of structural features of the '<em>Generator Adapter Factory Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE_FEATURE_COUNT = TYPE_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '<em>EGenerator Adapter Factory</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getEGeneratorAdapterFactory()
   * @generated
   */
  int EGENERATOR_ADAPTER_FACTORY = 19;

  /**
   * The meta object id for the '<em>Collection</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.Collection
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getCollection()
   * @generated
   */
  int COLLECTION = 20;

  /**
   * The meta object id for the '<em>List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getList()
   * @generated
   */
  int LIST = 21;

  /**
   * The meta object id for the '<em>Set</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.Set
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getSet()
   * @generated
   */
  int SET = 22;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeObject <em>Type Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Object</em>'.
   * @see org.eclipse.egf.model.types.TypeObject
   * @generated
   */
  EClass getTypeObject();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeClass <em>Type Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Class</em>'.
   * @see org.eclipse.egf.model.types.TypeClass
   * @generated
   */
  EClass getTypeClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeClass#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.types.TypeClass#getValue()
   * @see #getTypeClass()
   * @generated
   */
  EAttribute getTypeClass_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeCollection <em>Type Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Collection</em>'.
   * @see org.eclipse.egf.model.types.TypeCollection
   * @generated
   */
  EClass getTypeCollection();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeList <em>Type List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type List</em>'.
   * @see org.eclipse.egf.model.types.TypeList
   * @generated
   */
  EClass getTypeList();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeSet <em>Type Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Set</em>'.
   * @see org.eclipse.egf.model.types.TypeSet
   * @generated
   */
  EClass getTypeSet();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeMap <em>Type Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Map</em>'.
   * @see org.eclipse.egf.model.types.TypeMap
   * @generated
   */
  EClass getTypeMap();

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
   * Returns the meta object for data type '{@link java.util.Collection <em>Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Collection</em>'.
   * @see java.util.Collection
   * @model instanceClass="java.util.Collection" typeParameters="E"
   * @generated
   */
  EDataType getCollection();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List" typeParameters="E"
   * @generated
   */
  EDataType getList();

  /**
   * Returns the meta object for data type '{@link java.util.Set <em>Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Set</em>'.
   * @see java.util.Set
   * @model instanceClass="java.util.Set" typeParameters="E"
   * @generated
   */
  EDataType getSet();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeObjectImpl <em>Type Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeObjectImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeObject()
     * @generated
     */
    EClass TYPE_OBJECT = eINSTANCE.getTypeObject();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeClassImpl <em>Type Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeClassImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeClass()
     * @generated
     */
    EClass TYPE_CLASS = eINSTANCE.getTypeClass();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CLASS__VALUE = eINSTANCE.getTypeClass_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeCollectionImpl <em>Type Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeCollectionImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeCollection()
     * @generated
     */
    EClass TYPE_COLLECTION = eINSTANCE.getTypeCollection();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeListImpl <em>Type List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeListImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeList()
     * @generated
     */
    EClass TYPE_LIST = eINSTANCE.getTypeList();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeSetImpl <em>Type Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeSetImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeSet()
     * @generated
     */
    EClass TYPE_SET = eINSTANCE.getTypeSet();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeMapImpl <em>Type Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeMapImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeMap()
     * @generated
     */
    EClass TYPE_MAP = eINSTANCE.getTypeMap();

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

    /**
     * The meta object literal for the '<em>Collection</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Collection
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getCollection()
     * @generated
     */
    EDataType COLLECTION = eINSTANCE.getCollection();

    /**
     * The meta object literal for the '<em>List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getList()
     * @generated
     */
    EDataType LIST = eINSTANCE.getList();

    /**
     * The meta object literal for the '<em>Set</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Set
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getSet()
     * @generated
     */
    EDataType SET = eINSTANCE.getSet();

  }

} // TypesPackage
