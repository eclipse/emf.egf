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

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
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
    case TypesPackage.BOOLEAN_TYPE:
      return createBooleanType();
    case TypesPackage.INTEGER_TYPE:
      return createIntegerType();
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
  public BooleanType createBooleanType() {
    BooleanTypeImpl booleanType = new BooleanTypeImpl();
    return booleanType;
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

} //TypesFactoryImpl
