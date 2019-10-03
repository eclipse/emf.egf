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
package org.eclipse.egf.model.domain.impl;

import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.FilesystemDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.domain.TypeGenPackages;
import org.eclipse.egf.model.domain.WorkspaceDomain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainFactoryImpl extends EFactoryImpl implements DomainFactory {

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DomainFactory init() {
        try {
            DomainFactory theDomainFactory = (DomainFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/domain"); //$NON-NLS-1$ 
            if (theDomainFactory != null) {
                return theDomainFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DomainFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case DomainPackage.DOMAIN_VIEWPOINT:
                return createDomainViewpoint();
            case DomainPackage.TYPE_GEN_PACKAGES:
                return createTypeGenPackages();
            case DomainPackage.EMF_DOMAIN:
                return createEMFDomain();
            case DomainPackage.TYPE_DOMAIN:
                return createTypeDomain();
            case DomainPackage.FILESYSTEM_DOMAIN:
                return createFilesystemDomain();
            case DomainPackage.WORKSPACE_DOMAIN:
                return createWorkspaceDomain();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainViewpoint createDomainViewpoint() {
        DomainViewpointImpl domainViewpoint = new DomainViewpointImpl();
        return domainViewpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeGenPackages createTypeGenPackages() {
        TypeGenPackagesImpl typeGenPackages = new TypeGenPackagesImpl();
        return typeGenPackages;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMFDomain createEMFDomain() {
        EMFDomainImpl emfDomain = new EMFDomainImpl();
        return emfDomain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDomain createTypeDomain() {
        TypeDomainImpl typeDomain = new TypeDomainImpl();
        return typeDomain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FilesystemDomain createFilesystemDomain() {
        FilesystemDomainImpl filesystemDomain = new FilesystemDomainImpl();
        return filesystemDomain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorkspaceDomain createWorkspaceDomain() {
        WorkspaceDomainImpl workspaceDomain = new WorkspaceDomainImpl();
        return workspaceDomain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainPackage getDomainPackage() {
        return (DomainPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DomainPackage getPackage() {
        return DomainPackage.eINSTANCE;
    }

} // DomainFactoryImpl
