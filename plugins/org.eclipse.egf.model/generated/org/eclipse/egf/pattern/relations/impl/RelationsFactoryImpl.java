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
package org.eclipse.egf.pattern.relations.impl;

import org.eclipse.egf.pattern.relations.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class RelationsFactoryImpl extends EFactoryImpl implements RelationsFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static RelationsFactory init() {
    try {
      RelationsFactory theRelationsFactory = (RelationsFactory)EPackage.Registry.INSTANCE.getEFactory("egf.pattern.relations"); //$NON-NLS-1$ 
      if (theRelationsFactory != null) {
        return theRelationsFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RelationsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public RelationsFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case RelationsPackage.PARAMETER_RELATION: return createParameterRelation();
      case RelationsPackage.REFERENCE_RELATION: return createReferenceRelation();
      case RelationsPackage.CALL_PARAMETER: return createCallParameter();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ParameterRelation createParameterRelation() {
    ParameterRelationImpl parameterRelation = new ParameterRelationImpl();
    return parameterRelation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ReferenceRelation createReferenceRelation() {
    ReferenceRelationImpl referenceRelation = new ReferenceRelationImpl();
    return referenceRelation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public CallParameter createCallParameter() {
    CallParameterImpl callParameter = new CallParameterImpl();
    return callParameter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public RelationsPackage getRelationsPackage() {
    return (RelationsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RelationsPackage getPackage() {
    return RelationsPackage.eINSTANCE;
  }

} // RelationsFactoryImpl
