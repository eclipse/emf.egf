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
package org.eclipse.egf.model.domain.impl;

import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainEPackage;
import org.eclipse.egf.model.domain.TypeDomainURI;
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
            case DomainPackage.DOMAIN_EPACKAGE:
                return createDomainEPackage();
            case DomainPackage.TYPE_DOMAIN_EPACKAGE:
                return createTypeDomainEPackage();
            case DomainPackage.DOMAIN_URI:
                return createDomainURI();
            case DomainPackage.TYPE_DOMAIN_URI:
                return createTypeDomainURI();
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
    public DomainEPackage createDomainEPackage() {
        DomainEPackageImpl domainEPackage = new DomainEPackageImpl();
        return domainEPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDomainEPackage createTypeDomainEPackage() {
        TypeDomainEPackageImpl typeDomainEPackage = new TypeDomainEPackageImpl();
        return typeDomainEPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainURI createDomainURI() {
        DomainURIImpl domainURI = new DomainURIImpl();
        return domainURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDomainURI createTypeDomainURI() {
        TypeDomainURIImpl typeDomainURI = new TypeDomainURIImpl();
        return typeDomainURI;
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
