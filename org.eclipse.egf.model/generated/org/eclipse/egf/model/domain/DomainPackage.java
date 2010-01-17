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
import org.eclipse.egf.model.types.TypesPackage;
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
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainEPackageImpl <em>Type Domain EPackage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.TypeDomainEPackageImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomainEPackage()
   * @generated
   */
  int TYPE_DOMAIN_EPACKAGE = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_EPACKAGE__ID = TypesPackage.TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_EPACKAGE__NAME = TypesPackage.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_EPACKAGE__DESCRIPTION = TypesPackage.TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_EPACKAGE__DOMAIN = TypesPackage.TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_EPACKAGE__VALUE = TypesPackage.TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Domain EPackage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_EPACKAGE_FEATURE_COUNT = TypesPackage.TYPE_FEATURE_COUNT + 2;

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
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainURIImpl <em>Type Domain URI</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.TypeDomainURIImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomainURI()
   * @generated
   */
  int TYPE_DOMAIN_URI = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_URI__ID = TypesPackage.TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_URI__NAME = TypesPackage.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_URI__DESCRIPTION = TypesPackage.TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_URI__DOMAIN = TypesPackage.TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_URI__VALUE = TypesPackage.TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Domain URI</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DOMAIN_URI_FEATURE_COUNT = TypesPackage.TYPE_FEATURE_COUNT + 2;

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.TypeDomainEPackage <em>Type Domain EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Domain EPackage</em>'.
   * @see org.eclipse.egf.model.domain.TypeDomainEPackage
   * @generated
   */
  EClass getTypeDomainEPackage();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.TypeDomainEPackage#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Domain</em>'.
   * @see org.eclipse.egf.model.domain.TypeDomainEPackage#getDomain()
   * @see #getTypeDomainEPackage()
   * @generated
   */
  EReference getTypeDomainEPackage_Domain();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.TypeDomainEPackage#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.eclipse.egf.model.domain.TypeDomainEPackage#getValue()
   * @see #getTypeDomainEPackage()
   * @generated
   */
  EReference getTypeDomainEPackage_Value();

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.TypeDomainURI <em>Type Domain URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Domain URI</em>'.
   * @see org.eclipse.egf.model.domain.TypeDomainURI
   * @generated
   */
  EClass getTypeDomainURI();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.TypeDomainURI#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Domain</em>'.
   * @see org.eclipse.egf.model.domain.TypeDomainURI#getDomain()
   * @see #getTypeDomainURI()
   * @generated
   */
  EReference getTypeDomainURI_Domain();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.TypeDomainURI#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.domain.TypeDomainURI#getValue()
   * @see #getTypeDomainURI()
   * @generated
   */
  EAttribute getTypeDomainURI_Value();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainEPackageImpl <em>Type Domain EPackage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.TypeDomainEPackageImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomainEPackage()
     * @generated
     */
    EClass TYPE_DOMAIN_EPACKAGE = eINSTANCE.getTypeDomainEPackage();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DOMAIN_EPACKAGE__DOMAIN = eINSTANCE.getTypeDomainEPackage_Domain();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DOMAIN_EPACKAGE__VALUE = eINSTANCE.getTypeDomainEPackage_Value();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainURIImpl <em>Type Domain URI</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.TypeDomainURIImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomainURI()
     * @generated
     */
    EClass TYPE_DOMAIN_URI = eINSTANCE.getTypeDomainURI();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DOMAIN_URI__DOMAIN = eINSTANCE.getTypeDomainURI_Domain();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DOMAIN_URI__VALUE = eINSTANCE.getTypeDomainURI_Value();

  }

} // DomainPackage
