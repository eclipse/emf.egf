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
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BooleanTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 0;

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
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.StringTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.IntegerTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getIntegerType()
   * @generated
   */
  int INTEGER_TYPE = 1;

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
  int GENERATOR_ADAPTER_FACTORY_TYPE = 3;

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
  int EGENERATOR_ADAPTER_FACTORY = 4;

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
