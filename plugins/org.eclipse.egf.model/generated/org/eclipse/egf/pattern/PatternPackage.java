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
package org.eclipse.egf.pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.pattern.PatternFactory
 * @model kind="package"
 * @generated
 */
public interface PatternPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "pattern"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/Pattern"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "egf.pattern"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  PatternPackage eINSTANCE = org.eclipse.egf.pattern.impl.PatternPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.pattern.Generator <em>Generator</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.pattern.Generator
   * @see org.eclipse.egf.pattern.impl.PatternPackageImpl#getGenerator()
   * @generated
   */
  int GENERATOR = 0;

  /**
   * The number of structural features of the '<em>Generator</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.pattern.impl.PatternImpl <em>Pattern</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.pattern.impl.PatternImpl
   * @see org.eclipse.egf.pattern.impl.PatternPackageImpl#getPattern()
   * @generated
   */
  int PATTERN = 1;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__NAME = EcorePackage.ECLASS__NAME;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Instance Class</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

  /**
   * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__INSTANCE_TYPE_NAME = EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

  /**
   * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__ETYPE_PARAMETERS = EcorePackage.ECLASS__ETYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__INTERFACE = EcorePackage.ECLASS__INTERFACE;

  /**
   * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

  /**
   * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

  /**
   * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

  /**
   * The feature id for the '<em><b>EAll References</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

  /**
   * The feature id for the '<em><b>EReferences</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

  /**
   * The feature id for the '<em><b>EAttributes</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

  /**
   * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

  /**
   * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

  /**
   * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

  /**
   * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

  /**
   * The feature id for the '<em><b>EID Attribute</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

  /**
   * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EGENERIC_SUPER_TYPES = EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

  /**
   * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__EALL_GENERIC_SUPER_TYPES = EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__ID = EcorePackage.ECLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Short Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__SHORT_ID = EcorePackage.ECLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Logical Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__LOGICAL_NAME = EcorePackage.ECLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__DESCRIPTION = EcorePackage.ECLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__RELATIONS = EcorePackage.ECLASS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__PARAMETERS = EcorePackage.ECLASS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Call Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__CALL_PARAMETERS = EcorePackage.ECLASS_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '<em>PProperty Change Listener</em>' data type.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see java.beans.PropertyChangeListener
   * @see org.eclipse.egf.pattern.impl.PatternPackageImpl#getPPropertyChangeListener()
   * @generated
   */
  int PPROPERTY_CHANGE_LISTENER = 2;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.pattern.Generator <em>Generator</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Generator</em>'.
   * @see org.eclipse.egf.pattern.Generator
   * @generated
   */
  EClass getGenerator();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.pattern.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see org.eclipse.egf.pattern.Pattern
   * @generated
   */
  EClass getPattern();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.pattern.Pattern#getId <em>Id</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.egf.pattern.Pattern#getId()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.pattern.Pattern#getShortId <em>Short Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Short Id</em>'.
   * @see org.eclipse.egf.pattern.Pattern#getShortId()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_ShortId();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.pattern.Pattern#getLogicalName <em>Logical Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Logical Name</em>'.
   * @see org.eclipse.egf.pattern.Pattern#getLogicalName()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_LogicalName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.pattern.Pattern#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.eclipse.egf.pattern.Pattern#getDescription()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_Description();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.pattern.Pattern#getRelations <em>Relations</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relations</em>'.
   * @see org.eclipse.egf.pattern.Pattern#getRelations()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Relations();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.pattern.Pattern#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.egf.pattern.Pattern#getParameters()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.pattern.Pattern#getCallParameters <em>Call Parameters</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Call Parameters</em>'.
   * @see org.eclipse.egf.pattern.Pattern#getCallParameters()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_CallParameters();

  /**
   * Returns the meta object for data type '{@link java.beans.PropertyChangeListener <em>PProperty Change Listener</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for data type '<em>PProperty Change Listener</em>'.
   * @see java.beans.PropertyChangeListener
   * @model instanceClass="java.beans.PropertyChangeListener" serializeable="false"
   * @generated
   */
  EDataType getPPropertyChangeListener();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PatternFactory getPatternFactory();

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
     * The meta object literal for the '{@link org.eclipse.egf.pattern.Generator <em>Generator</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.pattern.Generator
     * @see org.eclipse.egf.pattern.impl.PatternPackageImpl#getGenerator()
     * @generated
     */
    EClass GENERATOR = eINSTANCE.getGenerator();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.pattern.impl.PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.pattern.impl.PatternImpl
     * @see org.eclipse.egf.pattern.impl.PatternPackageImpl#getPattern()
     * @generated
     */
    EClass PATTERN = eINSTANCE.getPattern();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__ID = eINSTANCE.getPattern_Id();

    /**
     * The meta object literal for the '<em><b>Short Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__SHORT_ID = eINSTANCE.getPattern_ShortId();

    /**
     * The meta object literal for the '<em><b>Logical Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__LOGICAL_NAME = eINSTANCE.getPattern_LogicalName();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__DESCRIPTION = eINSTANCE.getPattern_Description();

    /**
     * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__RELATIONS = eINSTANCE.getPattern_Relations();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__PARAMETERS = eINSTANCE.getPattern_Parameters();

    /**
     * The meta object literal for the '<em><b>Call Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__CALL_PARAMETERS = eINSTANCE.getPattern_CallParameters();

    /**
     * The meta object literal for the '<em>PProperty Change Listener</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see java.beans.PropertyChangeListener
     * @see org.eclipse.egf.pattern.impl.PatternPackageImpl#getPPropertyChangeListener()
     * @generated
     */
    EDataType PPROPERTY_CHANGE_LISTENER = eINSTANCE.getPPropertyChangeListener();

  }

} // PatternPackage
