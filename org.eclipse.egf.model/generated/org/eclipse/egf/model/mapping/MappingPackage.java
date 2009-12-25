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
package org.eclipse.egf.model.mapping;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.mapping.MappingFactory
 * @model kind="package"
 * @generated
 */
public interface MappingPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNAME = "mapping"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/mapping"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNS_PREFIX = "mapping"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  MappingPackage eINSTANCE = org.eclipse.egf.model.mapping.impl.MappingPackageImpl.init();

  /**
   * The meta object id for the '
   * {@link org.eclipse.egf.model.mapping.impl.MappingViewpointImpl
   * <em>Viewpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see org.eclipse.egf.model.mapping.impl.MappingViewpointImpl
   * @see org.eclipse.egf.model.mapping.impl.MappingPackageImpl#getMappingViewpoint()
   * @generated
   */
  int MAPPING_VIEWPOINT = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__ID = FcorePackage.VIEWPOINT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__NAME = FcorePackage.VIEWPOINT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__DESCRIPTION = FcorePackage.VIEWPOINT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Viewerpoint Container</b></em>' container
   * reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__VIEWERPOINT_CONTAINER = FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__MAPPINGS = FcorePackage.VIEWPOINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Viewpoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT_FEATURE_COUNT = FcorePackage.VIEWPOINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '
   * {@link org.eclipse.egf.model.mapping.impl.MappingImpl <em>Mapping</em>}'
   * class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see org.eclipse.egf.model.mapping.impl.MappingImpl
   * @see org.eclipse.egf.model.mapping.impl.MappingPackageImpl#getMapping()
   * @generated
   */
  int MAPPING = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING__ID = FcorePackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING__NAME = FcorePackage.MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING__DESCRIPTION = FcorePackage.MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_FEATURE_COUNT = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '
   * {@link org.eclipse.egf.model.mapping.impl.MappingDomainImpl
   * <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see org.eclipse.egf.model.mapping.impl.MappingDomainImpl
   * @see org.eclipse.egf.model.mapping.impl.MappingPackageImpl#getMappingDomain()
   * @generated
   */
  int MAPPING_DOMAIN = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_DOMAIN__ID = MAPPING__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_DOMAIN__NAME = MAPPING__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_DOMAIN__DESCRIPTION = MAPPING__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_DOMAIN__SOURCE = MAPPING_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_DOMAIN__TARGET = MAPPING_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int MAPPING_DOMAIN_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

  /**
   * Returns the meta object for class '
   * {@link org.eclipse.egf.model.mapping.MappingViewpoint <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Viewpoint</em>'.
   * @see org.eclipse.egf.model.mapping.MappingViewpoint
   * @generated
   */
  EClass getMappingViewpoint();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.egf.model.mapping.MappingViewpoint#getMappings
   * <em>Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '
   *         <em>Mappings</em>'.
   * @see org.eclipse.egf.model.mapping.MappingViewpoint#getMappings()
   * @see #getMappingViewpoint()
   * @generated
   */
  EReference getMappingViewpoint_Mappings();

  /**
   * Returns the meta object for class '
   * {@link org.eclipse.egf.model.mapping.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Mapping</em>'.
   * @see org.eclipse.egf.model.mapping.Mapping
   * @generated
   */
  EClass getMapping();

  /**
   * Returns the meta object for class '
   * {@link org.eclipse.egf.model.mapping.MappingDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Domain</em>'.
   * @see org.eclipse.egf.model.mapping.MappingDomain
   * @generated
   */
  EClass getMappingDomain();

  /**
   * Returns the meta object for the reference '
   * {@link org.eclipse.egf.model.mapping.MappingDomain#getSource
   * <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.eclipse.egf.model.mapping.MappingDomain#getSource()
   * @see #getMappingDomain()
   * @generated
   */
  EReference getMappingDomain_Source();

  /**
   * Returns the meta object for the reference '
   * {@link org.eclipse.egf.model.mapping.MappingDomain#getTarget
   * <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.eclipse.egf.model.mapping.MappingDomain#getTarget()
   * @see #getMappingDomain()
   * @generated
   */
  EReference getMappingDomain_Target();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MappingFactory getMappingFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '
     * {@link org.eclipse.egf.model.mapping.impl.MappingViewpointImpl
     * <em>Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.egf.model.mapping.impl.MappingViewpointImpl
     * @see org.eclipse.egf.model.mapping.impl.MappingPackageImpl#getMappingViewpoint()
     * @generated
     */
    EClass MAPPING_VIEWPOINT = eINSTANCE.getMappingViewpoint();

    /**
     * The meta object literal for the '<em><b>Mappings</b></em>' containment
     * reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference MAPPING_VIEWPOINT__MAPPINGS = eINSTANCE.getMappingViewpoint_Mappings();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.egf.model.mapping.impl.MappingImpl <em>Mapping</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.egf.model.mapping.impl.MappingImpl
     * @see org.eclipse.egf.model.mapping.impl.MappingPackageImpl#getMapping()
     * @generated
     */
    EClass MAPPING = eINSTANCE.getMapping();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.egf.model.mapping.impl.MappingDomainImpl
     * <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.egf.model.mapping.impl.MappingDomainImpl
     * @see org.eclipse.egf.model.mapping.impl.MappingPackageImpl#getMappingDomain()
     * @generated
     */
    EClass MAPPING_DOMAIN = eINSTANCE.getMappingDomain();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference MAPPING_DOMAIN__SOURCE = eINSTANCE.getMappingDomain_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference MAPPING_DOMAIN__TARGET = eINSTANCE.getMappingDomain_Target();

  }

} // MappingPackage
