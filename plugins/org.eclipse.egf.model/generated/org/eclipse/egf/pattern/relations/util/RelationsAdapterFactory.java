/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.relations.util;

import org.eclipse.egf.pattern.relations.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * @see org.eclipse.egf.pattern.relations.RelationsPackage
 * @generated
 */
public class RelationsAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static RelationsPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public RelationsAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = RelationsPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc --> This implementation returns <code>true</code> if the object
   * is either the model's package or is an instance object of the model. <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected RelationsSwitch<Adapter> modelSwitch = new RelationsSwitch<Adapter>() {
      @Override
      public Adapter casePatternRelation(PatternRelation object) {
        return createPatternRelationAdapter();
      }
      @Override
      public Adapter caseParameterRelation(ParameterRelation object) {
        return createParameterRelationAdapter();
      }
      @Override
      public Adapter caseReferenceRelation(ReferenceRelation object) {
        return createReferenceRelationAdapter();
      }
      @Override
      public Adapter caseCallParameter(CallParameter object) {
        return createCallParameterAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.pattern.relations.PatternRelation <em>Pattern Relation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.pattern.relations.PatternRelation
   * @generated
   */
  public Adapter createPatternRelationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.pattern.relations.ParameterRelation <em>Parameter Relation</em>}'.
   * <!-- begin-user-doc
   * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
   * anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.pattern.relations.ParameterRelation
   * @generated
   */
  public Adapter createParameterRelationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.pattern.relations.ReferenceRelation <em>Reference Relation</em>}'.
   * <!-- begin-user-doc
   * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
   * anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.pattern.relations.ReferenceRelation
   * @generated
   */
  public Adapter createReferenceRelationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.egf.pattern.relations.CallParameter <em>Call Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.egf.pattern.relations.CallParameter
   * @generated
   */
  public Adapter createCallParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc --> This default implementation returns null. <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // RelationsAdapterFactory
