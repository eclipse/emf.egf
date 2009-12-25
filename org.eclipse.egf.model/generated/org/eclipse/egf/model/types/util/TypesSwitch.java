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

import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.model.types.*;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.StringType;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
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
    case TypesPackage.BIG_DECIMAL_TYPE: {
      BigDecimalType bigDecimalType = (BigDecimalType) theEObject;
      T1 result = caseBigDecimalType(bigDecimalType);
      if (result == null)
        result = caseTypeObject(bigDecimalType);
      if (result == null)
        result = caseType(bigDecimalType);
      if (result == null)
        result = caseModelElement(bigDecimalType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.BIG_INTEGER_TYPE: {
      BigIntegerType bigIntegerType = (BigIntegerType) theEObject;
      T1 result = caseBigIntegerType(bigIntegerType);
      if (result == null)
        result = caseTypeObject(bigIntegerType);
      if (result == null)
        result = caseType(bigIntegerType);
      if (result == null)
        result = caseModelElement(bigIntegerType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.BOOLEAN_TYPE: {
      BooleanType booleanType = (BooleanType) theEObject;
      T1 result = caseBooleanType(booleanType);
      if (result == null)
        result = caseTypeObject(booleanType);
      if (result == null)
        result = caseType(booleanType);
      if (result == null)
        result = caseModelElement(booleanType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.BYTE_TYPE: {
      ByteType byteType = (ByteType) theEObject;
      T1 result = caseByteType(byteType);
      if (result == null)
        result = caseTypeObject(byteType);
      if (result == null)
        result = caseType(byteType);
      if (result == null)
        result = caseModelElement(byteType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.CHARACTER_TYPE: {
      CharacterType characterType = (CharacterType) theEObject;
      T1 result = caseCharacterType(characterType);
      if (result == null)
        result = caseTypeObject(characterType);
      if (result == null)
        result = caseType(characterType);
      if (result == null)
        result = caseModelElement(characterType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.DATE_TYPE: {
      DateType dateType = (DateType) theEObject;
      T1 result = caseDateType(dateType);
      if (result == null)
        result = caseTypeObject(dateType);
      if (result == null)
        result = caseType(dateType);
      if (result == null)
        result = caseModelElement(dateType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.DOUBLE_TYPE: {
      DoubleType doubleType = (DoubleType) theEObject;
      T1 result = caseDoubleType(doubleType);
      if (result == null)
        result = caseTypeObject(doubleType);
      if (result == null)
        result = caseType(doubleType);
      if (result == null)
        result = caseModelElement(doubleType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.FLOAT_TYPE: {
      FloatType floatType = (FloatType) theEObject;
      T1 result = caseFloatType(floatType);
      if (result == null)
        result = caseTypeObject(floatType);
      if (result == null)
        result = caseType(floatType);
      if (result == null)
        result = caseModelElement(floatType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.INTEGER_TYPE: {
      IntegerType integerType = (IntegerType) theEObject;
      T1 result = caseIntegerType(integerType);
      if (result == null)
        result = caseTypeObject(integerType);
      if (result == null)
        result = caseType(integerType);
      if (result == null)
        result = caseModelElement(integerType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.LONG_TYPE: {
      LongType longType = (LongType) theEObject;
      T1 result = caseLongType(longType);
      if (result == null)
        result = caseTypeObject(longType);
      if (result == null)
        result = caseType(longType);
      if (result == null)
        result = caseModelElement(longType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.SHORT_TYPE: {
      ShortType shortType = (ShortType) theEObject;
      T1 result = caseShortType(shortType);
      if (result == null)
        result = caseTypeObject(shortType);
      if (result == null)
        result = caseType(shortType);
      if (result == null)
        result = caseModelElement(shortType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.STRING_TYPE: {
      StringType stringType = (StringType) theEObject;
      T1 result = caseStringType(stringType);
      if (result == null)
        result = caseTypeObject(stringType);
      if (result == null)
        result = caseType(stringType);
      if (result == null)
        result = caseModelElement(stringType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.GENERATOR_ADAPTER_FACTORY_TYPE: {
      GeneratorAdapterFactoryType generatorAdapterFactoryType = (GeneratorAdapterFactoryType) theEObject;
      T1 result = caseGeneratorAdapterFactoryType(generatorAdapterFactoryType);
      if (result == null)
        result = caseTypeClass(generatorAdapterFactoryType);
      if (result == null)
        result = caseType(generatorAdapterFactoryType);
      if (result == null)
        result = caseModelElement(generatorAdapterFactoryType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Big Decimal Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Big Decimal Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseBigDecimalType(BigDecimalType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Big Integer Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Big Integer Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseBigIntegerType(BigIntegerType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseBooleanType(BooleanType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Byte Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Byte Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseByteType(ByteType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Character Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Character Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseCharacterType(CharacterType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Date Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Date Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseDateType(DateType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Double Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseDoubleType(DoubleType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Float Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Float Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseFloatType(FloatType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseStringType(StringType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseIntegerType(IntegerType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Long Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Long Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseLongType(LongType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Short Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Short Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseShortType(ShortType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Generator Adapter Factory Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Generator Adapter Factory Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseGeneratorAdapterFactoryType(GeneratorAdapterFactoryType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseModelElement(ModelElement object) {
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
  public <T extends Object> T1 caseTypeClass(TypeClass<T> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last
   * case anyway.
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
