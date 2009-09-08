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
package org.eclipse.egf.pattern.relations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.pattern.relations.RelationsFactory
 * @model kind="package"
 * @generated
 */
public interface RelationsPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "relations"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "egf.pattern.relations"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "egf.pattern.relations"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  RelationsPackage eINSTANCE = org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.pattern.relations.impl.PatternRelationImpl <em>Pattern Relation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.pattern.relations.impl.PatternRelationImpl
   * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getPatternRelation()
   * @generated
   */
  int PATTERN_RELATION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_RELATION__NAME = 0;

  /**
   * The number of structural features of the '<em>Pattern Relation</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_RELATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.pattern.relations.impl.ParameterRelationImpl <em>Parameter Relation</em>}' class.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see org.eclipse.egf.pattern.relations.impl.ParameterRelationImpl
   * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getParameterRelation()
   * @generated
   */
  int PARAMETER_RELATION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RELATION__NAME = PATTERN_RELATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RELATION__TYPE = PATTERN_RELATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parameter Relation</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RELATION_FEATURE_COUNT = PATTERN_RELATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.pattern.relations.impl.ReferenceRelationImpl <em>Reference Relation</em>}' class.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see org.eclipse.egf.pattern.relations.impl.ReferenceRelationImpl
   * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getReferenceRelation()
   * @generated
   */
  int REFERENCE_RELATION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_RELATION__NAME = PATTERN_RELATION__NAME;

  /**
   * The feature id for the '<em><b>Referenced Pattern</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_RELATION__REFERENCED_PATTERN = PATTERN_RELATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference Relation</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_RELATION_FEATURE_COUNT = PATTERN_RELATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.pattern.relations.impl.CallParameterImpl <em>Call Parameter</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.pattern.relations.impl.CallParameterImpl
   * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getCallParameter()
   * @generated
   */
  int CALL_PARAMETER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_PARAMETER__NAME = PATTERN_RELATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_PARAMETER__TYPE = PATTERN_RELATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Call Parameter</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_PARAMETER_FEATURE_COUNT = PATTERN_RELATION_FEATURE_COUNT + 1;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.pattern.relations.PatternRelation <em>Pattern Relation</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for class '<em>Pattern Relation</em>'.
   * @see org.eclipse.egf.pattern.relations.PatternRelation
   * @generated
   */
  EClass getPatternRelation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.pattern.relations.PatternRelation#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.egf.pattern.relations.PatternRelation#getName()
   * @see #getPatternRelation()
   * @generated
   */
  EAttribute getPatternRelation_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.pattern.relations.ParameterRelation <em>Parameter Relation</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for class '<em>Parameter Relation</em>'.
   * @see org.eclipse.egf.pattern.relations.ParameterRelation
   * @generated
   */
  EClass getParameterRelation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.pattern.relations.ParameterRelation#getType <em>Type</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.egf.pattern.relations.ParameterRelation#getType()
   * @see #getParameterRelation()
   * @generated
   */
  EReference getParameterRelation_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.pattern.relations.ReferenceRelation <em>Reference Relation</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for class '<em>Reference Relation</em>'.
   * @see org.eclipse.egf.pattern.relations.ReferenceRelation
   * @generated
   */
  EClass getReferenceRelation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.pattern.relations.ReferenceRelation#getReferencedPattern <em>Referenced Pattern</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced Pattern</em>'.
   * @see org.eclipse.egf.pattern.relations.ReferenceRelation#getReferencedPattern()
   * @see #getReferenceRelation()
   * @generated
   */
  EReference getReferenceRelation_ReferencedPattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.pattern.relations.CallParameter <em>Call Parameter</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for class '<em>Call Parameter</em>'.
   * @see org.eclipse.egf.pattern.relations.CallParameter
   * @generated
   */
  EClass getCallParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.pattern.relations.CallParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.egf.pattern.relations.CallParameter#getType()
   * @see #getCallParameter()
   * @generated
   */
  EAttribute getCallParameter_Type();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RelationsFactory getRelationsFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.pattern.relations.impl.PatternRelationImpl <em>Pattern Relation</em>}' class.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see org.eclipse.egf.pattern.relations.impl.PatternRelationImpl
     * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getPatternRelation()
     * @generated
     */
    EClass PATTERN_RELATION = eINSTANCE.getPatternRelation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_RELATION__NAME = eINSTANCE.getPatternRelation_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.pattern.relations.impl.ParameterRelationImpl <em>Parameter Relation</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.pattern.relations.impl.ParameterRelationImpl
     * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getParameterRelation()
     * @generated
     */
    EClass PARAMETER_RELATION = eINSTANCE.getParameterRelation();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_RELATION__TYPE = eINSTANCE.getParameterRelation_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.pattern.relations.impl.ReferenceRelationImpl <em>Reference Relation</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.pattern.relations.impl.ReferenceRelationImpl
     * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getReferenceRelation()
     * @generated
     */
    EClass REFERENCE_RELATION = eINSTANCE.getReferenceRelation();

    /**
     * The meta object literal for the '<em><b>Referenced Pattern</b></em>' reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_RELATION__REFERENCED_PATTERN = eINSTANCE.getReferenceRelation_ReferencedPattern();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.pattern.relations.impl.CallParameterImpl <em>Call Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.pattern.relations.impl.CallParameterImpl
     * @see org.eclipse.egf.pattern.relations.impl.RelationsPackageImpl#getCallParameter()
     * @generated
     */
    EClass CALL_PARAMETER = eINSTANCE.getCallParameter();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CALL_PARAMETER__TYPE = eINSTANCE.getCallParameter_Type();

  }

} // RelationsPackage
