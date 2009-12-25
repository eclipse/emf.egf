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

import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.model.types.*;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.StringType;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.types.TypesPackage
 * @generated
 */
public class TypesAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TypesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = TypesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the
   * model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypesSwitch<Adapter> modelSwitch = new TypesSwitch<Adapter>() {
    @Override
    public Adapter caseBooleanType(BooleanType object) {
      return createBooleanTypeAdapter();
    }

    @Override
    public Adapter caseIntegerType(IntegerType object) {
      return createIntegerTypeAdapter();
    }

    @Override
    public Adapter caseStringType(StringType object) {
      return createStringTypeAdapter();
    }

    @Override
    public Adapter caseGeneratorAdapterFactoryType(GeneratorAdapterFactoryType object) {
      return createGeneratorAdapterFactoryTypeAdapter();
    }

    @Override
    public Adapter caseModelElement(ModelElement object) {
      return createModelElementAdapter();
    }

    @Override
    public <T extends Object> Adapter caseType(Type<T> object) {
      return createTypeAdapter();
    }

    @Override
    public <T extends Object> Adapter caseTypeObject(TypeObject<T> object) {
      return createTypeObjectAdapter();
    }

    @Override
    public <T extends Object> Adapter caseTypeClass(TypeClass<T> object) {
      return createTypeClassAdapter();
    }

    @Override
    public Adapter defaultCase(EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.types.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.types.BooleanType
   * @generated
   */
  public Adapter createBooleanTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.types.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.types.StringType
   * @generated
   */
  public Adapter createStringTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.types.IntegerType <em>Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.types.IntegerType
   * @generated
   */
  public Adapter createIntegerTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.types.GeneratorAdapterFactoryType <em>Generator Adapter Factory Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.types.GeneratorAdapterFactoryType
   * @generated
   */
  public Adapter createGeneratorAdapterFactoryTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ModelElement
   * @generated
   */
  public Adapter createModelElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Type
   * @generated
   */
  public Adapter createTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.TypeObject <em>Type Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.TypeObject
   * @generated
   */
  public Adapter createTypeObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.TypeClass <em>Type Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.TypeClass
   * @generated
   */
  public Adapter createTypeClassAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // TypesAdapterFactory
