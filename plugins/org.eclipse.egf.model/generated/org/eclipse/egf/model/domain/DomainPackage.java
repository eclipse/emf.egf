/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
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
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.TypeGenPackagesImpl <em>Type Gen Packages</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.TypeGenPackagesImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeGenPackages()
     * @generated
     */
    int TYPE_GEN_PACKAGES = 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_GEN_PACKAGES__ID = TypesPackage.TYPE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_GEN_PACKAGES__DESCRIPTION = TypesPackage.TYPE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Elements</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_GEN_PACKAGES__ELEMENTS = TypesPackage.TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Gen Packages</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_GEN_PACKAGES_FEATURE_COUNT = TypesPackage.TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.EMFDomainImpl <em>EMF Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.EMFDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getEMFDomain()
     * @generated
     */
    int EMF_DOMAIN = 3;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainImpl <em>Type Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.TypeDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomain()
     * @generated
     */
    int TYPE_DOMAIN = 4;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.FilesystemDomainImpl <em>Filesystem Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.FilesystemDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getFilesystemDomain()
     * @generated
     */
    int FILESYSTEM_DOMAIN = 5;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl <em>Workspace Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getWorkspaceDomain()
     * @generated
     */
    int WORKSPACE_DOMAIN = 6;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.LoadableDomainImpl <em>Loadable Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.LoadableDomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getLoadableDomain()
     * @generated
     */
    int LOADABLE_DOMAIN = 7;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADABLE_DOMAIN__ID = DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADABLE_DOMAIN__DESCRIPTION = DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADABLE_DOMAIN__NAME = DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADABLE_DOMAIN__CONTENT = DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADABLE_DOMAIN__HELPER_IMPLEMENTATION = DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Loaded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADABLE_DOMAIN__LOADED = DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Loadable Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADABLE_DOMAIN_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__ID = LOADABLE_DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__DESCRIPTION = LOADABLE_DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__NAME = LOADABLE_DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__CONTENT = LOADABLE_DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__HELPER_IMPLEMENTATION = LOADABLE_DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Loaded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__LOADED = LOADABLE_DOMAIN__LOADED;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN__URI = LOADABLE_DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>EMF Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_DOMAIN_FEATURE_COUNT = LOADABLE_DOMAIN_FEATURE_COUNT + 1;

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
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__ID = LOADABLE_DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__DESCRIPTION = LOADABLE_DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__NAME = LOADABLE_DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__CONTENT = LOADABLE_DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__HELPER_IMPLEMENTATION = LOADABLE_DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Loaded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__LOADED = LOADABLE_DOMAIN__LOADED;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN__PATH = LOADABLE_DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Filesystem Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESYSTEM_DOMAIN_FEATURE_COUNT = LOADABLE_DOMAIN_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__ID = LOADABLE_DOMAIN__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__DESCRIPTION = LOADABLE_DOMAIN__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__NAME = LOADABLE_DOMAIN__NAME;

    /**
     * The feature id for the '<em><b>Content</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__CONTENT = LOADABLE_DOMAIN__CONTENT;

    /**
     * The feature id for the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__HELPER_IMPLEMENTATION = LOADABLE_DOMAIN__HELPER_IMPLEMENTATION;

    /**
     * The feature id for the '<em><b>Loaded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__LOADED = LOADABLE_DOMAIN__LOADED;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN__PATH = LOADABLE_DOMAIN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Workspace Domain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_DOMAIN_FEATURE_COUNT = LOADABLE_DOMAIN_FEATURE_COUNT + 1;

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
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.TypeGenPackages <em>Type Gen Packages</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Gen Packages</em>'.
     * @see org.eclipse.egf.model.domain.TypeGenPackages
     * @generated
     */
    EClass getTypeGenPackages();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.model.domain.TypeGenPackages#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Elements</em>'.
     * @see org.eclipse.egf.model.domain.TypeGenPackages#getElements()
     * @see #getTypeGenPackages()
     * @generated
     */
    EReference getTypeGenPackages_Elements();

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
     * Returns the meta object for class '{@link org.eclipse.egf.model.domain.LoadableDomain <em>Loadable Domain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Loadable Domain</em>'.
     * @see org.eclipse.egf.model.domain.LoadableDomain
     * @generated
     */
    EClass getLoadableDomain();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.domain.LoadableDomain#isLoaded <em>Loaded</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Loaded</em>'.
     * @see org.eclipse.egf.model.domain.LoadableDomain#isLoaded()
     * @see #getLoadableDomain()
     * @generated
     */
    EAttribute getLoadableDomain_Loaded();

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
        @SuppressWarnings("hiding")
        EAttribute DOMAIN__CONTENT = eINSTANCE.getDomain_Content();

        /**
         * The meta object literal for the '<em><b>Helper Implementation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute DOMAIN__HELPER_IMPLEMENTATION = eINSTANCE.getDomain_HelperImplementation();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.TypeGenPackagesImpl <em>Type Gen Packages</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.TypeGenPackagesImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeGenPackages()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_GEN_PACKAGES = eINSTANCE.getTypeGenPackages();

        /**
         * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference TYPE_GEN_PACKAGES__ELEMENTS = eINSTANCE.getTypeGenPackages_Elements();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.EMFDomainImpl <em>EMF Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.EMFDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getEMFDomain()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass EMF_DOMAIN = eINSTANCE.getEMFDomain();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute EMF_DOMAIN__URI = eINSTANCE.getEMFDomain_Uri();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.TypeDomainImpl <em>Type Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.TypeDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getTypeDomain()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_DOMAIN = eINSTANCE.getTypeDomain();

        /**
         * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference TYPE_DOMAIN__DOMAIN = eINSTANCE.getTypeDomain_Domain();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference TYPE_DOMAIN__VALUE = eINSTANCE.getTypeDomain_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.FilesystemDomainImpl <em>Filesystem Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.FilesystemDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getFilesystemDomain()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass FILESYSTEM_DOMAIN = eINSTANCE.getFilesystemDomain();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute FILESYSTEM_DOMAIN__PATH = eINSTANCE.getFilesystemDomain_Path();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl <em>Workspace Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.WorkspaceDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getWorkspaceDomain()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass WORKSPACE_DOMAIN = eINSTANCE.getWorkspaceDomain();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute WORKSPACE_DOMAIN__PATH = eINSTANCE.getWorkspaceDomain_Path();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.LoadableDomainImpl <em>Loadable Domain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.domain.impl.LoadableDomainImpl
         * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getLoadableDomain()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass LOADABLE_DOMAIN = eINSTANCE.getLoadableDomain();

        /**
         * The meta object literal for the '<em><b>Loaded</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute LOADABLE_DOMAIN__LOADED = eINSTANCE.getLoadableDomain_Loaded();

    }

} // DomainPackage
