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
package org.eclipse.egf.model.types.util;

import java.util.List;

import org.eclipse.egf.model.types.*;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeElement;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeGeneratorAdapterFactory;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the
 * <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.types.TypesPackage
 * @generated
 */
public class TypesSwitch<T1> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TypesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesSwitch() {
    if (modelPackage == null) {
      modelPackage = TypesPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T1 doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T1 doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage) {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    } else {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T1 doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case TypesPackage.TYPE_ELEMENT: {
      TypeElement typeElement = (TypeElement) theEObject;
      T1 result = caseTypeElement(typeElement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE: {
      Type<?> type = (Type<?>) theEObject;
      T1 result = caseType(type);
      if (result == null)
        result = caseTypeElement(type);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_OBJECT: {
      TypeObject<?> typeObject = (TypeObject<?>) theEObject;
      T1 result = caseTypeObject(typeObject);
      if (result == null)
        result = caseType(typeObject);
      if (result == null)
        result = caseTypeElement(typeObject);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_ABSTRACT_CLASS: {
      TypeAbstractClass<?> typeAbstractClass = (TypeAbstractClass<?>) theEObject;
      T1 result = caseTypeAbstractClass(typeAbstractClass);
      if (result == null)
        result = caseType(typeAbstractClass);
      if (result == null)
        result = caseTypeElement(typeAbstractClass);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_CLASS: {
      TypeClass typeClass = (TypeClass) theEObject;
      T1 result = caseTypeClass(typeClass);
      if (result == null)
        result = caseTypeAbstractClass(typeClass);
      if (result == null)
        result = caseType(typeClass);
      if (result == null)
        result = caseTypeElement(typeClass);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_COLLECTION: {
      TypeCollection typeCollection = (TypeCollection) theEObject;
      T1 result = caseTypeCollection(typeCollection);
      if (result == null)
        result = caseTypeAbstractClass(typeCollection);
      if (result == null)
        result = caseType(typeCollection);
      if (result == null)
        result = caseTypeElement(typeCollection);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_LIST: {
      TypeList typeList = (TypeList) theEObject;
      T1 result = caseTypeList(typeList);
      if (result == null)
        result = caseTypeAbstractClass(typeList);
      if (result == null)
        result = caseType(typeList);
      if (result == null)
        result = caseTypeElement(typeList);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_SET: {
      TypeSet typeSet = (TypeSet) theEObject;
      T1 result = caseTypeSet(typeSet);
      if (result == null)
        result = caseTypeAbstractClass(typeSet);
      if (result == null)
        result = caseType(typeSet);
      if (result == null)
        result = caseTypeElement(typeSet);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_GENERATOR_ADAPTER_FACTORY: {
      TypeGeneratorAdapterFactory typeGeneratorAdapterFactory = (TypeGeneratorAdapterFactory) theEObject;
      T1 result = caseTypeGeneratorAdapterFactory(typeGeneratorAdapterFactory);
      if (result == null)
        result = caseTypeAbstractClass(typeGeneratorAdapterFactory);
      if (result == null)
        result = caseType(typeGeneratorAdapterFactory);
      if (result == null)
        result = caseTypeElement(typeGeneratorAdapterFactory);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_MAP: {
      TypeMap typeMap = (TypeMap) theEObject;
      T1 result = caseTypeMap(typeMap);
      if (result == null)
        result = caseTypeAbstractClass(typeMap);
      if (result == null)
        result = caseType(typeMap);
      if (result == null)
        result = caseTypeElement(typeMap);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_BIG_DECIMAL: {
      TypeBigDecimal typeBigDecimal = (TypeBigDecimal) theEObject;
      T1 result = caseTypeBigDecimal(typeBigDecimal);
      if (result == null)
        result = caseTypeObject(typeBigDecimal);
      if (result == null)
        result = caseType(typeBigDecimal);
      if (result == null)
        result = caseTypeElement(typeBigDecimal);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_BIG_INTEGER: {
      TypeBigInteger typeBigInteger = (TypeBigInteger) theEObject;
      T1 result = caseTypeBigInteger(typeBigInteger);
      if (result == null)
        result = caseTypeObject(typeBigInteger);
      if (result == null)
        result = caseType(typeBigInteger);
      if (result == null)
        result = caseTypeElement(typeBigInteger);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_BOOLEAN: {
      TypeBoolean typeBoolean = (TypeBoolean) theEObject;
      T1 result = caseTypeBoolean(typeBoolean);
      if (result == null)
        result = caseTypeObject(typeBoolean);
      if (result == null)
        result = caseType(typeBoolean);
      if (result == null)
        result = caseTypeElement(typeBoolean);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_BYTE: {
      TypeByte typeByte = (TypeByte) theEObject;
      T1 result = caseTypeByte(typeByte);
      if (result == null)
        result = caseTypeObject(typeByte);
      if (result == null)
        result = caseType(typeByte);
      if (result == null)
        result = caseTypeElement(typeByte);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_CHARACTER: {
      TypeCharacter typeCharacter = (TypeCharacter) theEObject;
      T1 result = caseTypeCharacter(typeCharacter);
      if (result == null)
        result = caseTypeObject(typeCharacter);
      if (result == null)
        result = caseType(typeCharacter);
      if (result == null)
        result = caseTypeElement(typeCharacter);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_DATE: {
      TypeDate typeDate = (TypeDate) theEObject;
      T1 result = caseTypeDate(typeDate);
      if (result == null)
        result = caseTypeObject(typeDate);
      if (result == null)
        result = caseType(typeDate);
      if (result == null)
        result = caseTypeElement(typeDate);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_DOUBLE: {
      TypeDouble typeDouble = (TypeDouble) theEObject;
      T1 result = caseTypeDouble(typeDouble);
      if (result == null)
        result = caseTypeObject(typeDouble);
      if (result == null)
        result = caseType(typeDouble);
      if (result == null)
        result = caseTypeElement(typeDouble);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_FLOAT: {
      TypeFloat typeFloat = (TypeFloat) theEObject;
      T1 result = caseTypeFloat(typeFloat);
      if (result == null)
        result = caseTypeObject(typeFloat);
      if (result == null)
        result = caseType(typeFloat);
      if (result == null)
        result = caseTypeElement(typeFloat);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_INTEGER: {
      TypeInteger typeInteger = (TypeInteger) theEObject;
      T1 result = caseTypeInteger(typeInteger);
      if (result == null)
        result = caseTypeObject(typeInteger);
      if (result == null)
        result = caseType(typeInteger);
      if (result == null)
        result = caseTypeElement(typeInteger);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_LONG: {
      TypeLong typeLong = (TypeLong) theEObject;
      T1 result = caseTypeLong(typeLong);
      if (result == null)
        result = caseTypeObject(typeLong);
      if (result == null)
        result = caseType(typeLong);
      if (result == null)
        result = caseTypeElement(typeLong);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_SHORT: {
      TypeShort typeShort = (TypeShort) theEObject;
      T1 result = caseTypeShort(typeShort);
      if (result == null)
        result = caseTypeObject(typeShort);
      if (result == null)
        result = caseType(typeShort);
      if (result == null)
        result = caseTypeElement(typeShort);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE_STRING: {
      TypeString typeString = (TypeString) theEObject;
      T1 result = caseTypeString(typeString);
      if (result == null)
        result = caseTypeObject(typeString);
      if (result == null)
        result = caseType(typeString);
      if (result == null)
        result = caseTypeElement(typeString);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeElement(TypeElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public <T extends Object> T1 caseType(Type<T> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public <T extends Object> T1 caseTypeObject(TypeObject<T> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Abstract Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Abstract Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public <T extends Object> T1 caseTypeAbstractClass(TypeAbstractClass<T> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeClass(TypeClass object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Collection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Collection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeCollection(TypeCollection object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeList(TypeList object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeSet(TypeSet object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Generator Adapter Factory</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Generator Adapter Factory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeGeneratorAdapterFactory(TypeGeneratorAdapterFactory object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Map</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Map</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeMap(TypeMap object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Big Decimal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Big Decimal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeBigDecimal(TypeBigDecimal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Big Integer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Big Integer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeBigInteger(TypeBigInteger object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Boolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Boolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeBoolean(TypeBoolean object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Byte</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Byte</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeByte(TypeByte object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Character</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Character</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeCharacter(TypeCharacter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Date</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Date</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeDate(TypeDate object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Double</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Double</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeDouble(TypeDouble object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Float</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Float</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeFloat(TypeFloat object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Integer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Integer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeInteger(TypeInteger object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Long</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Long</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeLong(TypeLong object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Short</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Short</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeShort(TypeShort object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTypeString(TypeString object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T1 defaultCase(EObject object) {
    return null;
  }

} // TypesSwitch
