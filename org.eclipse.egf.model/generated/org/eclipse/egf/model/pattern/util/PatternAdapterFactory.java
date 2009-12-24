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
package org.eclipse.egf.model.pattern.util;

import java.util.Map;

import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.pattern.AbstractPatternCall;
import org.eclipse.egf.model.pattern.BasicQuery;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.CustomQuery;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternEngine;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.model.pattern.StringQuery;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.pattern.PatternPackage
 * @generated
 */
public class PatternAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected static PatternPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public PatternAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = PatternPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the
   * model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * 
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
   * 
   * @generated
   */
  protected PatternSwitch<Adapter> modelSwitch = new PatternSwitch<Adapter>() {
    @Override
    public Adapter casePattern(Pattern object) {
      return createPatternAdapter();
    }

    @Override
    public Adapter casePatternMethod(PatternMethod object) {
      return createPatternMethodAdapter();
    }

    @Override
    public Adapter casePatternParameter(PatternParameter object) {
      return createPatternParameterAdapter();
    }

    @Override
    public Adapter casePatternEngine(PatternEngine object) {
      return createPatternEngineAdapter();
    }

    @Override
    public Adapter casePatternLibrary(PatternLibrary object) {
      return createPatternLibraryAdapter();
    }

    @Override
    public Adapter casePatternElement(PatternElement object) {
      return createPatternElementAdapter();
    }

    @Override
    public Adapter casePatternViewpoint(PatternViewpoint object) {
      return createPatternViewpointAdapter();
    }

    @Override
    public Adapter casePatternNature(PatternNature object) {
      return createPatternNatureAdapter();
    }

    @Override
    public Adapter casePatternCall(PatternCall object) {
      return createPatternCallAdapter();
    }

    @Override
    public Adapter caseParamerter2ParameterMap(Map.Entry<PatternParameter, PatternParameter> object) {
      return createParamerter2ParameterMapAdapter();
    }

    @Override
    public Adapter caseCall(Call object) {
      return createCallAdapter();
    }

    @Override
    public Adapter caseMethodCall(MethodCall object) {
      return createMethodCallAdapter();
    }

    @Override
    public Adapter casePatternVariable(PatternVariable object) {
      return createPatternVariableAdapter();
    }

    @Override
    public Adapter caseAbstractPatternCall(AbstractPatternCall object) {
      return createAbstractPatternCallAdapter();
    }

    @Override
    public Adapter casePatternInjectedCall(PatternInjectedCall object) {
      return createPatternInjectedCallAdapter();
    }

    @Override
    public Adapter caseQuery(Query object) {
      return createQueryAdapter();
    }

    @Override
    public Adapter caseBasicQuery(BasicQuery object) {
      return createBasicQueryAdapter();
    }

    @Override
    public Adapter caseStringQuery(StringQuery object) {
      return createStringQueryAdapter();
    }

    @Override
    public Adapter caseCustomQuery(CustomQuery object) {
      return createCustomQueryAdapter();
    }

    @Override
    public Adapter caseModelElement(ModelElement object) {
      return createModelElementAdapter();
    }

    @Override
    public Adapter caseViewpoint(Viewpoint object) {
      return createViewpointAdapter();
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
   * 
   * @param target
   *          the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.Pattern
   * @generated
   */
  public Adapter createPatternAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternMethod
   * @generated
   */
  public Adapter createPatternMethodAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternParameter
   * @generated
   */
  public Adapter createPatternParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternEngine <em>Engine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternEngine
   * @generated
   */
  public Adapter createPatternEngineAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternLibrary
   * @generated
   */
  public Adapter createPatternLibraryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternElement
   * @generated
   */
  public Adapter createPatternElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternViewpoint <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternViewpoint
   * @generated
   */
  public Adapter createPatternViewpointAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternNature <em>Nature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternNature
   * @generated
   */
  public Adapter createPatternNatureAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternCall
   * @generated
   */
  public Adapter createPatternCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link java.util.Map.Entry
   * <em>Paramerter2 Parameter Map</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see java.util.Map.Entry
   * @generated
   */
  public Adapter createParamerter2ParameterMapAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.Call <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.Call
   * @generated
   */
  public Adapter createCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.MethodCall <em>Method Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.MethodCall
   * @generated
   */
  public Adapter createMethodCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternVariable
   * @generated
   */
  public Adapter createPatternVariableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.AbstractPatternCall
   * <em>Abstract Pattern Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.AbstractPatternCall
   * @generated
   */
  public Adapter createAbstractPatternCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.PatternInjectedCall
   * <em>Injected Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.PatternInjectedCall
   * @generated
   */
  public Adapter createPatternInjectedCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.Query <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.Query
   * @generated
   */
  public Adapter createQueryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.BasicQuery <em>Basic Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.BasicQuery
   * @generated
   */
  public Adapter createBasicQueryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.StringQuery <em>String Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.StringQuery
   * @generated
   */
  public Adapter createStringQueryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.pattern.CustomQuery <em>Custom Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.pattern.CustomQuery
   * @generated
   */
  public Adapter createCustomQueryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.ModelElement
   * @generated
   */
  public Adapter createModelElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.egf.model.fcore.Viewpoint <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore
   * cases;
   * it's useful to ignore a case when inheritance will catch all the cases
   * anyway.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.egf.model.fcore.Viewpoint
   * @generated
   */
  public Adapter createViewpointAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // PatternAdapterFactory
