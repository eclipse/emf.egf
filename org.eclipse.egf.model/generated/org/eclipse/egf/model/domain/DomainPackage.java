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
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.egf.model.domain.DomainFactory
 * @model kind="package"
 * @generated
 */
public interface DomainPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "domain"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/domain"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "domain"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DomainPackage eINSTANCE = org.eclipse.egf.model.domain.impl.DomainPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainViewpointImpl <em>Viewpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainViewpointImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainViewpoint()
   * @generated
   */
  int DOMAIN_VIEWPOINT = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__ID = FcorePackage.VIEWPOINT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__NAME = FcorePackage.VIEWPOINT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__DESCRIPTION = FcorePackage.VIEWPOINT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Viewerpoint Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__VIEWERPOINT_CONTAINER = FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER;

  /**
   * The feature id for the '<em><b>Domains</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__DOMAINS = FcorePackage.VIEWPOINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Viewpoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT_FEATURE_COUNT = FcorePackage.VIEWPOINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__ID = FcorePackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__NAME = FcorePackage.MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__DESCRIPTION = FcorePackage.MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainEPackageImpl <em>EPackage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainEPackageImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainEPackage()
   * @generated
   */
  int DOMAIN_EPACKAGE = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE__ID = DOMAIN__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE__NAME = DOMAIN__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE__DESCRIPTION = DOMAIN__DESCRIPTION;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE__EPACKAGE = DOMAIN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EPackage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainEPackageTypeImpl <em>EPackage Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainEPackageTypeImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainEPackageType()
   * @generated
   */
  int DOMAIN_EPACKAGE_TYPE = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE_TYPE__ID = FcorePackage.TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE_TYPE__NAME = FcorePackage.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE_TYPE__DESCRIPTION = FcorePackage.TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE_TYPE__VALUE = FcorePackage.TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE_TYPE__EPACKAGE = FcorePackage.TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>EPackage Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EPACKAGE_TYPE_FEATURE_COUNT = FcorePackage.TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainURIImpl <em>URI</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainURIImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainURI()
   * @generated
   */
  int DOMAIN_URI = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI__ID = DOMAIN__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI__NAME = DOMAIN__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI__DESCRIPTION = DOMAIN__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI__URI = DOMAIN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>URI</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainURITypeImpl <em>URI Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainURITypeImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainURIType()
   * @generated
   */
  int DOMAIN_URI_TYPE = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI_TYPE__ID = FcorePackage.TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI_TYPE__NAME = FcorePackage.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI_TYPE__DESCRIPTION = FcorePackage.TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI_TYPE__VALUE = FcorePackage.TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI_TYPE__URI = FcorePackage.TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>URI Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_URI_TYPE_FEATURE_COUNT = FcorePackage.TYPE_FEATURE_COUNT + 2;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainViewpoint <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Viewpoint</em>'.
   * @see org.eclipse.egf.model.domain.DomainViewpoint
   * @generated
   */
  EClass getDomainViewpoint();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.domain.DomainViewpoint#getDomains <em>Domains</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Domains</em>'.
   * @see org.eclipse.egf.model.domain.DomainViewpoint#getDomains()
   * @see #getDomainViewpoint()
   * @generated
   */
  EReference getDomainViewpoint_Domains();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see org.eclipse.egf.model.domain.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EPackage</em>'.
   * @see org.eclipse.egf.model.domain.DomainEPackage
   * @generated
   */
  EClass getDomainEPackage();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.DomainEPackage#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.egf.model.domain.DomainEPackage#getEPackage()
   * @see #getDomainEPackage()
   * @generated
   */
  EReference getDomainEPackage_EPackage();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainEPackageType <em>EPackage Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EPackage Type</em>'.
   * @see org.eclipse.egf.model.domain.DomainEPackageType
   * @generated
   */
  EClass getDomainEPackageType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.DomainEPackageType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.eclipse.egf.model.domain.DomainEPackageType#getValue()
   * @see #getDomainEPackageType()
   * @generated
   */
  EReference getDomainEPackageType_Value();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.DomainEPackageType#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.egf.model.domain.DomainEPackageType#getEPackage()
   * @see #getDomainEPackageType()
   * @generated
   */
  EReference getDomainEPackageType_EPackage();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainURI <em>URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>URI</em>'.
   * @see org.eclipse.egf.model.domain.DomainURI
   * @generated
   */
  EClass getDomainURI();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.DomainURI#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.eclipse.egf.model.domain.DomainURI#getUri()
   * @see #getDomainURI()
   * @generated
   */
  EAttribute getDomainURI_Uri();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainURIType <em>URI Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>URI Type</em>'.
   * @see org.eclipse.egf.model.domain.DomainURIType
   * @generated
   */
  EClass getDomainURIType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.DomainURIType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.eclipse.egf.model.domain.DomainURIType#getValue()
   * @see #getDomainURIType()
   * @generated
   */
  EReference getDomainURIType_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.DomainURIType#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.eclipse.egf.model.domain.DomainURIType#getUri()
   * @see #getDomainURIType()
   * @generated
   */
  EAttribute getDomainURIType_Uri();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DomainFactory getDomainFactory();

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
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainViewpointImpl <em>Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainViewpointImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainViewpoint()
     * @generated
     */
    EClass DOMAIN_VIEWPOINT = eINSTANCE.getDomainViewpoint();

    /**
     * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_VIEWPOINT__DOMAINS = eINSTANCE.getDomainViewpoint_Domains();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = eINSTANCE.getDomain();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainEPackageImpl <em>EPackage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainEPackageImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainEPackage()
     * @generated
     */
    EClass DOMAIN_EPACKAGE = eINSTANCE.getDomainEPackage();

    /**
     * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_EPACKAGE__EPACKAGE = eINSTANCE.getDomainEPackage_EPackage();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainEPackageTypeImpl <em>EPackage Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainEPackageTypeImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainEPackageType()
     * @generated
     */
    EClass DOMAIN_EPACKAGE_TYPE = eINSTANCE.getDomainEPackageType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_EPACKAGE_TYPE__VALUE = eINSTANCE.getDomainEPackageType_Value();

    /**
     * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_EPACKAGE_TYPE__EPACKAGE = eINSTANCE.getDomainEPackageType_EPackage();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainURIImpl <em>URI</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainURIImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainURI()
     * @generated
     */
    EClass DOMAIN_URI = eINSTANCE.getDomainURI();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN_URI__URI = eINSTANCE.getDomainURI_Uri();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainURITypeImpl <em>URI Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainURITypeImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainURIType()
     * @generated
     */
    EClass DOMAIN_URI_TYPE = eINSTANCE.getDomainURIType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_URI_TYPE__VALUE = eINSTANCE.getDomainURIType_Value();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN_URI_TYPE__URI = eINSTANCE.getDomainURIType_Uri();

  }

} // DomainPackage
