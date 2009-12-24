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
package org.eclipse.egf.model.types.util;

import java.util.List;

import org.eclipse.egf.model.types.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.types.TypesPackage
 * @generated
 */
public class TypesSwitch<T> {
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
  public T doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
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
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case TypesPackage.TYPE_ELEMENT: {
      TypeElement typeElement = (TypeElement) theEObject;
      T result = caseTypeElement(typeElement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.TYPE: {
      Type type = (Type) theEObject;
      T result = caseType(type);
      if (result == null)
        result = caseTypeElement(type);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.PRIMITIVE_OBJECT_TYPE: {
      PrimitiveObjectType primitiveObjectType = (PrimitiveObjectType) theEObject;
      T result = casePrimitiveObjectType(primitiveObjectType);
      if (result == null)
        result = caseType(primitiveObjectType);
      if (result == null)
        result = caseTypeElement(primitiveObjectType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.BOOLEAN_TYPE: {
      BooleanType booleanType = (BooleanType) theEObject;
      T result = caseBooleanType(booleanType);
      if (result == null)
        result = casePrimitiveObjectType(booleanType);
      if (result == null)
        result = caseType(booleanType);
      if (result == null)
        result = caseTypeElement(booleanType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.STRING_TYPE: {
      StringType stringType = (StringType) theEObject;
      T result = caseStringType(stringType);
      if (result == null)
        result = casePrimitiveObjectType(stringType);
      if (result == null)
        result = caseType(stringType);
      if (result == null)
        result = caseTypeElement(stringType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.CLASS_TYPE: {
      ClassType classType = (ClassType) theEObject;
      T result = caseClassType(classType);
      if (result == null)
        result = caseType(classType);
      if (result == null)
        result = caseTypeElement(classType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.PATTERN_EXECUTION_REPORTER_TYPE: {
      PatternExecutionReporterType patternExecutionReporterType = (PatternExecutionReporterType) theEObject;
      T result = casePatternExecutionReporterType(patternExecutionReporterType);
      if (result == null)
        result = caseClassType(patternExecutionReporterType);
      if (result == null)
        result = caseType(patternExecutionReporterType);
      if (result == null)
        result = caseTypeElement(patternExecutionReporterType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case TypesPackage.GENERATOR_ADAPTER_FACTORY_TYPE: {
      GeneratorAdapterFactoryType generatorAdapterFactoryType = (GeneratorAdapterFactoryType) theEObject;
      T result = caseGeneratorAdapterFactoryType(generatorAdapterFactoryType);
      if (result == null)
        result = caseClassType(generatorAdapterFactoryType);
      if (result == null)
        result = caseType(generatorAdapterFactoryType);
      if (result == null)
        result = caseTypeElement(generatorAdapterFactoryType);
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
  public T caseTypeElement(TypeElement object) {
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
  public T caseType(Type object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Object Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Object Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveObjectType(PrimitiveObjectType object) {
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
  public T caseBooleanType(BooleanType object) {
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
  public T caseStringType(StringType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassType(ClassType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Execution Reporter Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Execution Reporter Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternExecutionReporterType(PatternExecutionReporterType object) {
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
  public T caseGeneratorAdapterFactoryType(GeneratorAdapterFactoryType object) {
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
  public T defaultCase(EObject object) {
    return null;
  }

} //TypesSwitch
