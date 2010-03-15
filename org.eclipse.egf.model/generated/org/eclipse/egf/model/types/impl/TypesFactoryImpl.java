/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeGeneratorAdapterFactory;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.common.util.URI;
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
 * 
 * @generated
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
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
   * 
   * @generated
   */
  public TypesFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case TypesPackage.TYPE_COLLECTION:
      return createTypeCollection();
    case TypesPackage.TYPE_LIST:
      return createTypeList();
    case TypesPackage.TYPE_SET:
      return createTypeSet();
    case TypesPackage.TYPE_GENERATOR_ADAPTER_FACTORY:
      return createTypeGeneratorAdapterFactory();
    case TypesPackage.TYPE_MAP:
      return createTypeMap();
    case TypesPackage.TYPE_BIG_DECIMAL:
      return createTypeBigDecimal();
    case TypesPackage.TYPE_BIG_INTEGER:
      return createTypeBigInteger();
    case TypesPackage.TYPE_BOOLEAN:
      return createTypeBoolean();
    case TypesPackage.TYPE_BYTE:
      return createTypeByte();
    case TypesPackage.TYPE_CHARACTER:
      return createTypeCharacter();
    case TypesPackage.TYPE_DATE:
      return createTypeDate();
    case TypesPackage.TYPE_DOUBLE:
      return createTypeDouble();
    case TypesPackage.TYPE_FLOAT:
      return createTypeFloat();
    case TypesPackage.TYPE_INTEGER:
      return createTypeInteger();
    case TypesPackage.TYPE_LONG:
      return createTypeLong();
    case TypesPackage.TYPE_SHORT:
      return createTypeShort();
    case TypesPackage.TYPE_STRING:
      return createTypeString();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    case TypesPackage.SET:
      return createSetFromString(eDataType, initialValue);
    case TypesPackage.LIST:
      return createListFromString(eDataType, initialValue);
    case TypesPackage.COLLECTION:
      return createCollectionFromString(eDataType, initialValue);
    case TypesPackage.URI:
      return createURIFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case TypesPackage.SET:
      return convertSetToString(eDataType, instanceValue);
    case TypesPackage.LIST:
      return convertListToString(eDataType, instanceValue);
    case TypesPackage.COLLECTION:
      return convertCollectionToString(eDataType, instanceValue);
    case TypesPackage.URI:
      return convertURIToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeCollection createTypeCollection() {
    TypeCollectionImpl typeCollection = new TypeCollectionImpl();
    return typeCollection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeList createTypeList() {
    TypeListImpl typeList = new TypeListImpl();
    return typeList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeSet createTypeSet() {
    TypeSetImpl typeSet = new TypeSetImpl();
    return typeSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeGeneratorAdapterFactory createTypeGeneratorAdapterFactory() {
    TypeGeneratorAdapterFactoryImpl typeGeneratorAdapterFactory = new TypeGeneratorAdapterFactoryImpl();
    return typeGeneratorAdapterFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeMap createTypeMap() {
    TypeMapImpl typeMap = new TypeMapImpl();
    return typeMap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeBigDecimal createTypeBigDecimal() {
    TypeBigDecimalImpl typeBigDecimal = new TypeBigDecimalImpl();
    return typeBigDecimal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeBigInteger createTypeBigInteger() {
    TypeBigIntegerImpl typeBigInteger = new TypeBigIntegerImpl();
    return typeBigInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeBoolean createTypeBoolean() {
    TypeBooleanImpl typeBoolean = new TypeBooleanImpl();
    return typeBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeByte createTypeByte() {
    TypeByteImpl typeByte = new TypeByteImpl();
    return typeByte;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeCharacter createTypeCharacter() {
    TypeCharacterImpl typeCharacter = new TypeCharacterImpl();
    return typeCharacter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeDate createTypeDate() {
    TypeDateImpl typeDate = new TypeDateImpl();
    return typeDate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeDouble createTypeDouble() {
    TypeDoubleImpl typeDouble = new TypeDoubleImpl();
    return typeDouble;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeFloat createTypeFloat() {
    TypeFloatImpl typeFloat = new TypeFloatImpl();
    return typeFloat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeInteger createTypeInteger() {
    TypeIntegerImpl typeInteger = new TypeIntegerImpl();
    return typeInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeLong createTypeLong() {
    TypeLongImpl typeLong = new TypeLongImpl();
    return typeLong;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeShort createTypeShort() {
    TypeShortImpl typeShort = new TypeShortImpl();
    return typeShort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypeString createTypeString() {
    TypeStringImpl typeString = new TypeStringImpl();
    return typeString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Set<?> createSet(String literal) {
    return (Set<?>) super.createFromString(literal);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Collection<?> createCollectionFromString(EDataType eDataType, String initialValue) {
    return (Collection<?>) super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertCollection(Collection<?> instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertCollectionToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public URI createURI(String literal) {
    return (URI) super.createFromString(TypesPackage.Literals.URI, literal);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public List<?> createListFromString(EDataType eDataType, String initialValue) {
    return (List<?>) super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertList(List<?> instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertListToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Collection<?> createCollection(String literal) {
    return (Collection<?>) super.createFromString(literal);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Set<?> createSetFromString(EDataType eDataType, String initialValue) {
    return (Set<?>) super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertSet(Set<?> instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertSetToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public List<?> createList(String literal) {
    return (List<?>) super.createFromString(literal);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public URI createURIFromString(EDataType eDataType, String initialValue) {
    return URI.createURI(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertURI(URI instanceValue) {
    return super.convertToString(TypesPackage.Literals.URI, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertURIToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public TypesPackage getTypesPackage() {
    return (TypesPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TypesPackage getPackage() {
    return TypesPackage.eINSTANCE;
  }

} // TypesFactoryImpl
