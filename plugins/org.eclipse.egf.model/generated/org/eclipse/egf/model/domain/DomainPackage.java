/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_VIEWPOINT__DESCRIPTION = FcorePackage.VIEWPOINT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Viewpoint Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_VIEWPOINT__VIEWPOINT_CONTAINER = FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER;

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
    int DOMAIN__ID = FcorePackage.NAMED_MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN__DESCRIPTION = FcorePackage.NAMED_MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN__NAME = FcorePackage.NAMED_MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN__CONTENT = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN__HELPER_IMPLEMENTATION = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_FEATURE_COUNT = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 2;

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
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainGenPackageImpl <em>Gen Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainGenPackageImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainGenPackage()
     * @generated
     */
    int DOMAIN_GEN_PACKAGE = 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_GEN_PACKAGE__ID = DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_GEN_PACKAGE__DESCRIPTION = DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_GEN_PACKAGE__NAME = DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_GEN_PACKAGE__CONTENT = DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_GEN_PACKAGE__HELPER_IMPLEMENTATION = DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Gen Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_GEN_PACKAGE__GEN_PACKAGE = DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Gen Package</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_GEN_PACKAGE_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainGenPackagesImpl <em>Type Domain Gen Packages</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.TypeDomainGenPackagesImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomainGenPackages()
     * @generated
     */
    int TYPE_DOMAIN_GEN_PACKAGES = 3;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_GEN_PACKAGES__ID = TypesPackage.TYPE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_GEN_PACKAGES__DESCRIPTION = TypesPackage.TYPE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Elements</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_GEN_PACKAGES__ELEMENTS = TypesPackage.TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Domain Gen Packages</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_GEN_PACKAGES_FEATURE_COUNT = TypesPackage.TYPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_URI__ID = DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_URI__DESCRIPTION = DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_URI__NAME = DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_URI__CONTENT = DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOMAIN_URI__HELPER_IMPLEMENTATION = DOMAIN__HELPER_IMPLEMENTATION;

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
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_URI__ID = TypesPackage.TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_URI__DESCRIPTION = TypesPackage.TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Domain</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_URI__DOMAIN = TypesPackage.TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_URI__VALUE = TypesPackage.TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Type Domain URI</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_URI_FEATURE_COUNT = TypesPackage.TYPE_OBJECT_FEATURE_COUNT + 2;

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
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.EMFDomainImpl <em>EMF Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.EMFDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getEMFDomain()
     * @generated
     */
    int EMF_DOMAIN = 6;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__ID = DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__DESCRIPTION = DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__NAME = DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__CONTENT = DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__HELPER_IMPLEMENTATION = DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__URI = DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>EMF Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainImpl <em>Type Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.TypeDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomain()
     * @generated
     */
    int TYPE_DOMAIN = 7;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN__ID = TypesPackage.TYPE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN__DESCRIPTION = TypesPackage.TYPE_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Domain</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN__DOMAIN = TypesPackage.TYPE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN__VALUE = TypesPackage.TYPE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Type Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_DOMAIN_FEATURE_COUNT = TypesPackage.TYPE_OBJECT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.FilesystemDomainImpl <em>Filesystem Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.FilesystemDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getFilesystemDomain()
     * @generated
     */
    int FILESYSTEM_DOMAIN = 8;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__ID = DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__DESCRIPTION = DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__NAME = DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__CONTENT = DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__HELPER_IMPLEMENTATION = DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__PATH = DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Filesystem Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl <em>Workspace Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getWorkspaceDomain()
     * @generated
     */
    int WORKSPACE_DOMAIN = 9;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__ID = DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__DESCRIPTION = DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__NAME = DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__CONTENT = DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__HELPER_IMPLEMENTATION = DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__PATH = DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Workspace Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

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
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.model.domain.Domain#getContent <em>Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Content</em>'.
     * @see org.eclipse.egf.model.domain.Domain#getContent()
     * @see #getDomain()
     * @generated
     */
    EAttribute getDomain_Content();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.Domain#getHelperImplementation <em>Helper Implementation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Helper Implementation</em>'.
     * @see org.eclipse.egf.model.domain.Domain#getHelperImplementation()
     * @see #getDomain()
     * @generated
     */
    EAttribute getDomain_HelperImplementation();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainGenPackage <em>Gen Package</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Gen Package</em>'.
     * @see org.eclipse.egf.model.domain.DomainGenPackage
     * @generated
     */
    EClass getDomainGenPackage();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.DomainGenPackage#getGenPackage <em>Gen Package</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Gen Package</em>'.
     * @see org.eclipse.egf.model.domain.DomainGenPackage#getGenPackage()
     * @see #getDomainGenPackage()
     * @generated
     */
    EReference getDomainGenPackage_GenPackage();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.TypeDomainGenPackages <em>Type Domain Gen Packages</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Domain Gen Packages</em>'.
     * @see org.eclipse.egf.model.domain.TypeDomainGenPackages
     * @generated
     */
    EClass getTypeDomainGenPackages();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.model.domain.TypeDomainGenPackages#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Elements</em>'.
     * @see org.eclipse.egf.model.domain.TypeDomainGenPackages#getElements()
     * @see #getTypeDomainGenPackages()
     * @generated
     */
    EReference getTypeDomainGenPackages_Elements();

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
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.TypeDomainURI#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value</em>'.
     * @see org.eclipse.egf.model.domain.TypeDomainURI#getValue()
     * @see #getTypeDomainURI()
     * @generated
     */
    EReference getTypeDomainURI_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.EMFDomain <em>EMF Domain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EMF Domain</em>'.
     * @see org.eclipse.egf.model.domain.EMFDomain
     * @generated
     */
    EClass getEMFDomain();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.EMFDomain#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.eclipse.egf.model.domain.EMFDomain#getUri()
     * @see #getEMFDomain()
     * @generated
     */
    EAttribute getEMFDomain_Uri();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.TypeDomain <em>Type Domain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Domain</em>'.
     * @see org.eclipse.egf.model.domain.TypeDomain
     * @generated
     */
    EClass getTypeDomain();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.TypeDomain#getDomain <em>Domain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Domain</em>'.
     * @see org.eclipse.egf.model.domain.TypeDomain#getDomain()
     * @see #getTypeDomain()
     * @generated
     */
    EReference getTypeDomain_Domain();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.TypeDomain#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value</em>'.
     * @see org.eclipse.egf.model.domain.TypeDomain#getValue()
     * @see #getTypeDomain()
     * @generated
     */
    EReference getTypeDomain_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.FilesystemDomain <em>Filesystem Domain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Filesystem Domain</em>'.
     * @see org.eclipse.egf.model.domain.FilesystemDomain
     * @generated
     */
    EClass getFilesystemDomain();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.FilesystemDomain#getPath <em>Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Path</em>'.
     * @see org.eclipse.egf.model.domain.FilesystemDomain#getPath()
     * @see #getFilesystemDomain()
     * @generated
     */
    EAttribute getFilesystemDomain_Path();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.WorkspaceDomain <em>Workspace Domain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Workspace Domain</em>'.
     * @see org.eclipse.egf.model.domain.WorkspaceDomain
     * @generated
     */
    EClass getWorkspaceDomain();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.WorkspaceDomain#getPath <em>Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Path</em>'.
     * @see org.eclipse.egf.model.domain.WorkspaceDomain#getPath()
     * @see #getWorkspaceDomain()
     * @generated
     */
    EAttribute getWorkspaceDomain_Path();

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
        @SuppressWarnings("hiding")
        EClass DOMAIN_VIEWPOINT = eINSTANCE.getDomainViewpoint();

        /**
         * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference DOMAIN_VIEWPOINT__DOMAINS = eINSTANCE.getDomainViewpoint_Domains();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainImpl <em>Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.DomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomain()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass DOMAIN = eINSTANCE.getDomain();

        /**
         * The meta object literal for the '<em><b>Content</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOMAIN__CONTENT = eINSTANCE.getDomain_Content();

        /**
         * The meta object literal for the '<em><b>Helper Implementation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOMAIN__HELPER_IMPLEMENTATION = eINSTANCE.getDomain_HelperImplementation();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainURIImpl <em>URI</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.DomainURIImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainURI()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass DOMAIN_URI = eINSTANCE.getDomainURI();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute DOMAIN_URI__URI = eINSTANCE.getDomainURI_Uri();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainURIImpl <em>Type Domain URI</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.TypeDomainURIImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomainURI()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_DOMAIN_URI = eINSTANCE.getTypeDomainURI();

        /**
         * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference TYPE_DOMAIN_URI__DOMAIN = eINSTANCE.getTypeDomainURI_Domain();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainGenPackageImpl <em>Gen Package</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.DomainGenPackageImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainGenPackage()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass DOMAIN_GEN_PACKAGE = eINSTANCE.getDomainGenPackage();

        /**
         * The meta object literal for the '<em><b>Gen Package</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference DOMAIN_GEN_PACKAGE__GEN_PACKAGE = eINSTANCE.getDomainGenPackage_GenPackage();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainGenPackagesImpl <em>Type Domain Gen Packages</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.TypeDomainGenPackagesImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomainGenPackages()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_DOMAIN_GEN_PACKAGES = eINSTANCE.getTypeDomainGenPackages();

        /**
         * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference TYPE_DOMAIN_GEN_PACKAGES__ELEMENTS = eINSTANCE.getTypeDomainGenPackages_Elements();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference TYPE_DOMAIN_URI__VALUE = eINSTANCE.getTypeDomainURI_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.EMFDomainImpl <em>EMF Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.EMFDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getEMFDomain()
         * @generated
         */
        EClass EMF_DOMAIN = eINSTANCE.getEMFDomain();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_DOMAIN__URI = eINSTANCE.getEMFDomain_Uri();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainImpl <em>Type Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.TypeDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomain()
         * @generated
         */
        EClass TYPE_DOMAIN = eINSTANCE.getTypeDomain();

        /**
         * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_DOMAIN__DOMAIN = eINSTANCE.getTypeDomain_Domain();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_DOMAIN__VALUE = eINSTANCE.getTypeDomain_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.FilesystemDomainImpl <em>Filesystem Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.FilesystemDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getFilesystemDomain()
         * @generated
         */
        EClass FILESYSTEM_DOMAIN = eINSTANCE.getFilesystemDomain();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILESYSTEM_DOMAIN__PATH = eINSTANCE.getFilesystemDomain_Path();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl <em>Workspace Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getWorkspaceDomain()
         * @generated
         */
        EClass WORKSPACE_DOMAIN = eINSTANCE.getWorkspaceDomain();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WORKSPACE_DOMAIN__PATH = eINSTANCE.getWorkspaceDomain_Path();

    }

} // DomainPackage
