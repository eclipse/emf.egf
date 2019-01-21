/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeElementImpl <em>Type Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeElementImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeElement()
     * @generated
     */
    int TYPE_ELEMENT = 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ELEMENT__ID = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ELEMENT__DESCRIPTION = 1;

    /**
     * The number of structural features of the '<em>Type Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ELEMENT_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getType()
     * @generated
     */
    int TYPE = 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__ID = TYPE_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__DESCRIPTION = TYPE_ELEMENT__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_FEATURE_COUNT = TYPE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeObjectImpl <em>Type Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeObjectImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeObject()
     * @generated
     */
    int TYPE_OBJECT = 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_OBJECT__ID = TYPE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_OBJECT__DESCRIPTION = TYPE__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Type Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_OBJECT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeAbstractClassImpl <em>Type Abstract Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeAbstractClassImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeAbstractClass()
     * @generated
     */
    int TYPE_ABSTRACT_CLASS = 3;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ABSTRACT_CLASS__ID = TYPE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ABSTRACT_CLASS__DESCRIPTION = TYPE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ABSTRACT_CLASS__INSTANCE = TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ABSTRACT_CLASS__VALUE = TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Type Abstract Class</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ABSTRACT_CLASS_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeCollectionImpl <em>Type Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeCollectionImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeCollection()
     * @generated
     */
    int TYPE_COLLECTION = 5;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeListImpl <em>Type List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeListImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeList()
     * @generated
     */
    int TYPE_LIST = 6;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeSetImpl <em>Type Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeSetImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeSet()
     * @generated
     */
    int TYPE_SET = 7;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeClassImpl <em>Type Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeClassImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeClass()
     * @generated
     */
    int TYPE_CLASS = 4;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CLASS__ID = TYPE_ABSTRACT_CLASS__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CLASS__DESCRIPTION = TYPE_ABSTRACT_CLASS__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CLASS__INSTANCE = TYPE_ABSTRACT_CLASS__INSTANCE;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CLASS__VALUE = TYPE_ABSTRACT_CLASS__VALUE;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CLASS__TYPE = TYPE_ABSTRACT_CLASS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Class</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CLASS_FEATURE_COUNT = TYPE_ABSTRACT_CLASS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_COLLECTION__ID = TYPE_ABSTRACT_CLASS__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_COLLECTION__DESCRIPTION = TYPE_ABSTRACT_CLASS__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_COLLECTION__INSTANCE = TYPE_ABSTRACT_CLASS__INSTANCE;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_COLLECTION__VALUE = TYPE_ABSTRACT_CLASS__VALUE;

    /**
     * The number of structural features of the '<em>Type Collection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_COLLECTION_FEATURE_COUNT = TYPE_ABSTRACT_CLASS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LIST__ID = TYPE_ABSTRACT_CLASS__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LIST__DESCRIPTION = TYPE_ABSTRACT_CLASS__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LIST__INSTANCE = TYPE_ABSTRACT_CLASS__INSTANCE;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LIST__VALUE = TYPE_ABSTRACT_CLASS__VALUE;

    /**
     * The number of structural features of the '<em>Type List</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LIST_FEATURE_COUNT = TYPE_ABSTRACT_CLASS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SET__ID = TYPE_ABSTRACT_CLASS__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SET__DESCRIPTION = TYPE_ABSTRACT_CLASS__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SET__INSTANCE = TYPE_ABSTRACT_CLASS__INSTANCE;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SET__VALUE = TYPE_ABSTRACT_CLASS__VALUE;

    /**
     * The number of structural features of the '<em>Type Set</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SET_FEATURE_COUNT = TYPE_ABSTRACT_CLASS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeMapImpl <em>Type Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeMapImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeMap()
     * @generated
     */
    int TYPE_MAP = 8;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_MAP__ID = TYPE_ABSTRACT_CLASS__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_MAP__DESCRIPTION = TYPE_ABSTRACT_CLASS__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_MAP__INSTANCE = TYPE_ABSTRACT_CLASS__INSTANCE;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_MAP__VALUE = TYPE_ABSTRACT_CLASS__VALUE;

    /**
     * The number of structural features of the '<em>Type Map</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_MAP_FEATURE_COUNT = TYPE_ABSTRACT_CLASS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeBigDecimalImpl <em>Type Big Decimal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeBigDecimalImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeBigDecimal()
     * @generated
     */
    int TYPE_BIG_DECIMAL = 9;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_DECIMAL__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_DECIMAL__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_DECIMAL__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Big Decimal</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_DECIMAL_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeBigIntegerImpl <em>Type Big Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeBigIntegerImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeBigInteger()
     * @generated
     */
    int TYPE_BIG_INTEGER = 10;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_INTEGER__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_INTEGER__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_INTEGER__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Big Integer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BIG_INTEGER_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeBooleanImpl <em>Type Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeBooleanImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeBoolean()
     * @generated
     */
    int TYPE_BOOLEAN = 11;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BOOLEAN__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BOOLEAN__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BOOLEAN__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Boolean</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BOOLEAN_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeByteImpl <em>Type Byte</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeByteImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeByte()
     * @generated
     */
    int TYPE_BYTE = 12;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BYTE__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BYTE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BYTE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Byte</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_BYTE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeCharacterImpl <em>Type Character</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeCharacterImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeCharacter()
     * @generated
     */
    int TYPE_CHARACTER = 13;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CHARACTER__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CHARACTER__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CHARACTER__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Character</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_CHARACTER_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeDateImpl <em>Type Date</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeDateImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeDate()
     * @generated
     */
    int TYPE_DATE = 14;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DATE__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DATE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DATE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Date</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DATE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeDoubleImpl <em>Type Double</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeDoubleImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeDouble()
     * @generated
     */
    int TYPE_DOUBLE = 15;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOUBLE__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOUBLE__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOUBLE__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Double</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOUBLE_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeFloatImpl <em>Type Float</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeFloatImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeFloat()
     * @generated
     */
    int TYPE_FLOAT = 16;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_FLOAT__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_FLOAT__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_FLOAT__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Float</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_FLOAT_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeIntegerImpl <em>Type Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeIntegerImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeInteger()
     * @generated
     */
    int TYPE_INTEGER = 17;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_INTEGER__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_INTEGER__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_INTEGER__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Integer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_INTEGER_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeLongImpl <em>Type Long</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeLongImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeLong()
     * @generated
     */
    int TYPE_LONG = 18;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LONG__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LONG__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LONG__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Long</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LONG_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeShortImpl <em>Type Short</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeShortImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeShort()
     * @generated
     */
    int TYPE_SHORT = 19;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SHORT__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SHORT__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SHORT__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Short</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_SHORT_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeStringImpl <em>Type String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeStringImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeString()
     * @generated
     */
    int TYPE_STRING = 20;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_STRING__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_STRING__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_STRING__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type String</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_STRING_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.types.impl.TypeURIImpl <em>Type URI</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeURIImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeURI()
     * @generated
     */
    int TYPE_URI = 21;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_URI__ID = TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_URI__DESCRIPTION = TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_URI__VALUE = TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type URI</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_URI_FEATURE_COUNT = TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '<em>URI</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.URI
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getURI()
     * @generated
     */
    int URI = 25;

    /**
     * The meta object id for the '<em>Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.TypesException
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypesException()
     * @generated
     */
    int TYPES_EXCEPTION = 26;

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeElement <em>Type Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Element</em>'.
     * @see org.eclipse.egf.model.types.TypeElement
     * @generated
     */
    EClass getTypeElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeElement#getID <em>ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>ID</em>'.
     * @see org.eclipse.egf.model.types.TypeElement#getID()
     * @see #getTypeElement()
     * @generated
     */
    EAttribute getTypeElement_ID();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeElement#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.egf.model.types.TypeElement#getDescription()
     * @see #getTypeElement()
     * @generated
     */
    EAttribute getTypeElement_Description();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type</em>'.
     * @see org.eclipse.egf.model.types.Type
     * @generated
     */
    EClass getType();

    /**
     * The meta object id for the '<em>Collection</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Collection
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getCollection()
     * @generated
     */
    int COLLECTION = 24;

    /**
     * The meta object id for the '<em>List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getList()
     * @generated
     */
    int LIST = 23;

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
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeAbstractClass <em>Type Abstract Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Abstract Class</em>'.
     * @see org.eclipse.egf.model.types.TypeAbstractClass
     * @generated
     */
    EClass getTypeAbstractClass();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeAbstractClass#getInstance <em>Instance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance</em>'.
     * @see org.eclipse.egf.model.types.TypeAbstractClass#getInstance()
     * @see #getTypeAbstractClass()
     * @generated
     */
    EAttribute getTypeAbstractClass_Instance();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeAbstractClass#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeAbstractClass#getValue()
     * @see #getTypeAbstractClass()
     * @generated
     */
    EAttribute getTypeAbstractClass_Value();

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
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeClass <em>Type Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Class</em>'.
     * @see org.eclipse.egf.model.types.TypeClass
     * @generated
     */
    EClass getTypeClass();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeClass#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.egf.model.types.TypeClass#getType()
     * @see #getTypeClass()
     * @generated
     */
    EAttribute getTypeClass_Type();

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
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeBigDecimal <em>Type Big Decimal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Big Decimal</em>'.
     * @see org.eclipse.egf.model.types.TypeBigDecimal
     * @generated
     */
    EClass getTypeBigDecimal();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeBigDecimal#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeBigDecimal#getValue()
     * @see #getTypeBigDecimal()
     * @generated
     */
    EAttribute getTypeBigDecimal_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeBigInteger <em>Type Big Integer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Big Integer</em>'.
     * @see org.eclipse.egf.model.types.TypeBigInteger
     * @generated
     */
    EClass getTypeBigInteger();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeBigInteger#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeBigInteger#getValue()
     * @see #getTypeBigInteger()
     * @generated
     */
    EAttribute getTypeBigInteger_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeBoolean <em>Type Boolean</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Boolean</em>'.
     * @see org.eclipse.egf.model.types.TypeBoolean
     * @generated
     */
    EClass getTypeBoolean();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeBoolean#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeBoolean#getValue()
     * @see #getTypeBoolean()
     * @generated
     */
    EAttribute getTypeBoolean_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeByte <em>Type Byte</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Byte</em>'.
     * @see org.eclipse.egf.model.types.TypeByte
     * @generated
     */
    EClass getTypeByte();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeByte#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeByte#getValue()
     * @see #getTypeByte()
     * @generated
     */
    EAttribute getTypeByte_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeCharacter <em>Type Character</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Character</em>'.
     * @see org.eclipse.egf.model.types.TypeCharacter
     * @generated
     */
    EClass getTypeCharacter();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeCharacter#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeCharacter#getValue()
     * @see #getTypeCharacter()
     * @generated
     */
    EAttribute getTypeCharacter_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeDate <em>Type Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Date</em>'.
     * @see org.eclipse.egf.model.types.TypeDate
     * @generated
     */
    EClass getTypeDate();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeDate#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeDate#getValue()
     * @see #getTypeDate()
     * @generated
     */
    EAttribute getTypeDate_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeDouble <em>Type Double</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Double</em>'.
     * @see org.eclipse.egf.model.types.TypeDouble
     * @generated
     */
    EClass getTypeDouble();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeDouble#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeDouble#getValue()
     * @see #getTypeDouble()
     * @generated
     */
    EAttribute getTypeDouble_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeFloat <em>Type Float</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Float</em>'.
     * @see org.eclipse.egf.model.types.TypeFloat
     * @generated
     */
    EClass getTypeFloat();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeFloat#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeFloat#getValue()
     * @see #getTypeFloat()
     * @generated
     */
    EAttribute getTypeFloat_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeInteger <em>Type Integer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Integer</em>'.
     * @see org.eclipse.egf.model.types.TypeInteger
     * @generated
     */
    EClass getTypeInteger();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeInteger#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeInteger#getValue()
     * @see #getTypeInteger()
     * @generated
     */
    EAttribute getTypeInteger_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeLong <em>Type Long</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Long</em>'.
     * @see org.eclipse.egf.model.types.TypeLong
     * @generated
     */
    EClass getTypeLong();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeLong#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeLong#getValue()
     * @see #getTypeLong()
     * @generated
     */
    EAttribute getTypeLong_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeShort <em>Type Short</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Short</em>'.
     * @see org.eclipse.egf.model.types.TypeShort
     * @generated
     */
    EClass getTypeShort();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeShort#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeShort#getValue()
     * @see #getTypeShort()
     * @generated
     */
    EAttribute getTypeShort_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeString <em>Type String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type String</em>'.
     * @see org.eclipse.egf.model.types.TypeString
     * @generated
     */
    EClass getTypeString();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeString#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeString#getValue()
     * @see #getTypeString()
     * @generated
     */
    EAttribute getTypeString_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.types.TypeURI <em>Type URI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type URI</em>'.
     * @see org.eclipse.egf.model.types.TypeURI
     * @generated
     */
    EClass getTypeURI();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeURI#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.model.types.TypeURI#getValue()
     * @see #getTypeURI()
     * @generated
     */
    EAttribute getTypeURI_Value();

    /**
     * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>URI</em>'.
     * @see org.eclipse.emf.common.util.URI
     * @model instanceClass="org.eclipse.emf.common.util.URI"
     * @generated
     */
    EDataType getURI();

    /**
     * Returns the meta object for data type '{@link org.eclipse.egf.model.types.TypesException <em>Exception</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Exception</em>'.
     * @see org.eclipse.egf.model.types.TypesException
     * @model instanceClass="org.eclipse.egf.model.types.TypesException"
     * @generated
     */
    EDataType getTypesException();

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
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeElementImpl <em>Type Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeElementImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeElement()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_ELEMENT = eINSTANCE.getTypeElement();

        /**
         * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_ELEMENT__ID = eINSTANCE.getTypeElement_ID();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_ELEMENT__DESCRIPTION = eINSTANCE.getTypeElement_Description();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeImpl <em>Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getType()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE = eINSTANCE.getType();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeObjectImpl <em>Type Object</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeObjectImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeObject()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_OBJECT = eINSTANCE.getTypeObject();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeAbstractClassImpl <em>Type Abstract Class</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeAbstractClassImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeAbstractClass()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_ABSTRACT_CLASS = eINSTANCE.getTypeAbstractClass();

        /**
         * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_ABSTRACT_CLASS__INSTANCE = eINSTANCE.getTypeAbstractClass_Instance();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_ABSTRACT_CLASS__VALUE = eINSTANCE.getTypeAbstractClass_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeCollectionImpl <em>Type Collection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeCollectionImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeCollection()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_COLLECTION = eINSTANCE.getTypeCollection();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeListImpl <em>Type List</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeListImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeList()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_LIST = eINSTANCE.getTypeList();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeSetImpl <em>Type Set</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeSetImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeSet()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_SET = eINSTANCE.getTypeSet();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeClassImpl <em>Type Class</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeClassImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeClass()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_CLASS = eINSTANCE.getTypeClass();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_CLASS__TYPE = eINSTANCE.getTypeClass_Type();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeMapImpl <em>Type Map</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeMapImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeMap()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_MAP = eINSTANCE.getTypeMap();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeBigDecimalImpl <em>Type Big Decimal</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeBigDecimalImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeBigDecimal()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_BIG_DECIMAL = eINSTANCE.getTypeBigDecimal();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_BIG_DECIMAL__VALUE = eINSTANCE.getTypeBigDecimal_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeBigIntegerImpl <em>Type Big Integer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeBigIntegerImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeBigInteger()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_BIG_INTEGER = eINSTANCE.getTypeBigInteger();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_BIG_INTEGER__VALUE = eINSTANCE.getTypeBigInteger_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeBooleanImpl <em>Type Boolean</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeBooleanImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeBoolean()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_BOOLEAN = eINSTANCE.getTypeBoolean();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_BOOLEAN__VALUE = eINSTANCE.getTypeBoolean_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeByteImpl <em>Type Byte</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeByteImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeByte()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_BYTE = eINSTANCE.getTypeByte();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_BYTE__VALUE = eINSTANCE.getTypeByte_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeCharacterImpl <em>Type Character</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeCharacterImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeCharacter()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_CHARACTER = eINSTANCE.getTypeCharacter();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_CHARACTER__VALUE = eINSTANCE.getTypeCharacter_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeDateImpl <em>Type Date</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeDateImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeDate()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_DATE = eINSTANCE.getTypeDate();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_DATE__VALUE = eINSTANCE.getTypeDate_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeDoubleImpl <em>Type Double</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeDoubleImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeDouble()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_DOUBLE = eINSTANCE.getTypeDouble();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_DOUBLE__VALUE = eINSTANCE.getTypeDouble_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeFloatImpl <em>Type Float</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeFloatImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeFloat()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_FLOAT = eINSTANCE.getTypeFloat();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_FLOAT__VALUE = eINSTANCE.getTypeFloat_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeIntegerImpl <em>Type Integer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeIntegerImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeInteger()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_INTEGER = eINSTANCE.getTypeInteger();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_INTEGER__VALUE = eINSTANCE.getTypeInteger_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeLongImpl <em>Type Long</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeLongImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeLong()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_LONG = eINSTANCE.getTypeLong();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_LONG__VALUE = eINSTANCE.getTypeLong_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeShortImpl <em>Type Short</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeShortImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeShort()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_SHORT = eINSTANCE.getTypeShort();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_SHORT__VALUE = eINSTANCE.getTypeShort_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeStringImpl <em>Type String</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeStringImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeString()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_STRING = eINSTANCE.getTypeString();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_STRING__VALUE = eINSTANCE.getTypeString_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeURIImpl <em>Type URI</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.impl.TypeURIImpl
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypeURI()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_URI = eINSTANCE.getTypeURI();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute TYPE_URI__VALUE = eINSTANCE.getTypeURI_Value();

        /**
         * The meta object literal for the '<em>URI</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.emf.common.util.URI
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getURI()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType URI = eINSTANCE.getURI();

        /**
         * The meta object literal for the '<em>Exception</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.types.TypesException
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getTypesException()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType TYPES_EXCEPTION = eINSTANCE.getTypesException();

        /**
         * The meta object literal for the '<em>Collection</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.Collection
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getCollection()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType COLLECTION = eINSTANCE.getCollection();

        /**
         * The meta object literal for the '<em>List</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.List
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getList()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType LIST = eINSTANCE.getList();

        /**
         * The meta object literal for the '<em>Set</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.Set
         * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getSet()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType SET = eINSTANCE.getSet();

    }

} // TypesPackage
