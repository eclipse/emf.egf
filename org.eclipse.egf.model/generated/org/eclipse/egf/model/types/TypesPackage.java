/**
 * <copyright>
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
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.egf.model.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ELEMENT__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ELEMENT__DESCRIPTION = 2;

  /**
   * The number of structural features of the '<em>Type Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ELEMENT_FEATURE_COUNT = 3;

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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = TYPE_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__DESCRIPTION = TYPE_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TYPE_ID = TYPE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = TYPE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.PrimitiveObjectTypeImpl <em>Primitive Object Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.PrimitiveObjectTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getPrimitiveObjectType()
   * @generated
   */
  int PRIMITIVE_OBJECT_TYPE = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_OBJECT_TYPE__ID = TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_OBJECT_TYPE__NAME = TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_OBJECT_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_OBJECT_TYPE__TYPE_ID = TYPE__TYPE_ID;

  /**
   * The number of structural features of the '<em>Primitive Object Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_OBJECT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.BooleanTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__ID = PRIMITIVE_OBJECT_TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__NAME = PRIMITIVE_OBJECT_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__DESCRIPTION = PRIMITIVE_OBJECT_TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE__TYPE_ID = PRIMITIVE_OBJECT_TYPE__TYPE_ID;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_OBJECT_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.StringTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__ID = PRIMITIVE_OBJECT_TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__NAME = PRIMITIVE_OBJECT_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__DESCRIPTION = PRIMITIVE_OBJECT_TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__TYPE_ID = PRIMITIVE_OBJECT_TYPE__TYPE_ID;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = PRIMITIVE_OBJECT_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.ClassTypeImpl <em>Class Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.ClassTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getClassType()
   * @generated
   */
  int CLASS_TYPE = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE__ID = TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE__NAME = TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE__TYPE_ID = TYPE__TYPE_ID;

  /**
   * The number of structural features of the '<em>Class Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.PatternExecutionReporterTypeImpl <em>Pattern Execution Reporter Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.PatternExecutionReporterTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getPatternExecutionReporterType()
   * @generated
   */
  int PATTERN_EXECUTION_REPORTER_TYPE = 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_EXECUTION_REPORTER_TYPE__ID = CLASS_TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_EXECUTION_REPORTER_TYPE__NAME = CLASS_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_EXECUTION_REPORTER_TYPE__DESCRIPTION = CLASS_TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_EXECUTION_REPORTER_TYPE__TYPE_ID = CLASS_TYPE__TYPE_ID;

  /**
   * The number of structural features of the '<em>Pattern Execution Reporter Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_EXECUTION_REPORTER_TYPE_FEATURE_COUNT = CLASS_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl <em>Generator Adapter Factory Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl
   * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getGeneratorAdapterFactoryType()
   * @generated
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE = 7;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__ID = CLASS_TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__NAME = CLASS_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__DESCRIPTION = CLASS_TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE__TYPE_ID = CLASS_TYPE__TYPE_ID;

  /**
   * The number of structural features of the '<em>Generator Adapter Factory Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_ADAPTER_FACTORY_TYPE_FEATURE_COUNT = CLASS_TYPE_FEATURE_COUNT + 0;

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
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.TypeElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.egf.model.types.TypeElement#getName()
   * @see #getTypeElement()
   * @generated
   */
  EAttribute getTypeElement_Name();

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
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.types.Type#getTypeId <em>Type Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Id</em>'.
   * @see org.eclipse.egf.model.types.Type#getTypeId()
   * @see #getType()
   * @generated
   */
  EAttribute getType_TypeId();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.PrimitiveObjectType <em>Primitive Object Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Object Type</em>'.
   * @see org.eclipse.egf.model.types.PrimitiveObjectType
   * @generated
   */
  EClass getPrimitiveObjectType();

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type</em>'.
   * @see org.eclipse.egf.model.types.StringType
   * @generated
   */
  EClass getStringType();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.ClassType <em>Class Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Type</em>'.
   * @see org.eclipse.egf.model.types.ClassType
   * @generated
   */
  EClass getClassType();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.types.PatternExecutionReporterType <em>Pattern Execution Reporter Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Execution Reporter Type</em>'.
   * @see org.eclipse.egf.model.types.PatternExecutionReporterType
   * @generated
   */
  EClass getPatternExecutionReporterType();

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
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
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
    EClass TYPE_ELEMENT = eINSTANCE.getTypeElement();

    /**
     * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_ELEMENT__ID = eINSTANCE.getTypeElement_ID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_ELEMENT__NAME = eINSTANCE.getTypeElement_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_ELEMENT__DESCRIPTION = eINSTANCE.getTypeElement_Description();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.TypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__TYPE_ID = eINSTANCE.getType_TypeId();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.PrimitiveObjectTypeImpl <em>Primitive Object Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.PrimitiveObjectTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getPrimitiveObjectType()
     * @generated
     */
    EClass PRIMITIVE_OBJECT_TYPE = eINSTANCE.getPrimitiveObjectType();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.StringTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getStringType()
     * @generated
     */
    EClass STRING_TYPE = eINSTANCE.getStringType();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.ClassTypeImpl <em>Class Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.ClassTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getClassType()
     * @generated
     */
    EClass CLASS_TYPE = eINSTANCE.getClassType();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.PatternExecutionReporterTypeImpl <em>Pattern Execution Reporter Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.PatternExecutionReporterTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getPatternExecutionReporterType()
     * @generated
     */
    EClass PATTERN_EXECUTION_REPORTER_TYPE = eINSTANCE.getPatternExecutionReporterType();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl <em>Generator Adapter Factory Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.types.impl.GeneratorAdapterFactoryTypeImpl
     * @see org.eclipse.egf.model.types.impl.TypesPackageImpl#getGeneratorAdapterFactoryType()
     * @generated
     */
    EClass GENERATOR_ADAPTER_FACTORY_TYPE = eINSTANCE.getGeneratorAdapterFactoryType();

  }

} //TypesPackage
