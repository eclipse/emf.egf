/**
 * 
O * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.domain.util;

import org.eclipse.egf.model.domain.*;
import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.FilesystemDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.domain.WorkspaceDomain;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeElement;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.domain.DomainPackage
 * @generated
 */
public class DomainAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DomainPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = DomainPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DomainSwitch<Adapter> modelSwitch = new DomainSwitch<Adapter>() {
        @Override
        public Adapter caseDomainViewpoint(DomainViewpoint object) {
            return createDomainViewpointAdapter();
        }

        @Override
        public Adapter caseDomain(Domain object) {
            return createDomainAdapter();
        }

        @Override
        public Adapter caseDomainGenPackage(DomainGenPackage object) {
            return createDomainGenPackageAdapter();
        }

        @Override
        public Adapter caseTypeDomainGenPackages(TypeDomainGenPackages object) {
            return createTypeDomainGenPackagesAdapter();
        }

        @Override
        public Adapter caseEMFDomain(EMFDomain object) {
            return createEMFDomainAdapter();
        }

        @Override
        public Adapter caseTypeDomain(TypeDomain object) {
            return createTypeDomainAdapter();
        }

        @Override
        public Adapter caseFilesystemDomain(FilesystemDomain object) {
            return createFilesystemDomainAdapter();
        }

        @Override
        public Adapter caseWorkspaceDomain(WorkspaceDomain object) {
            return createWorkspaceDomainAdapter();
        }

        @Override
        public Adapter caseModelElement(ModelElement object) {
            return createModelElementAdapter();
        }

        @Override
        public Adapter caseViewpoint(Viewpoint object) {
            return createViewpointAdapter();
        }

        @Override
        public Adapter caseNamedModelElement(NamedModelElement object) {
            return createNamedModelElementAdapter();
        }

        @Override
        public Adapter caseTypeElement(TypeElement object) {
            return createTypeElementAdapter();
        }

        @Override
        public Adapter caseType(Type object) {
            return createTypeAdapter();
        }

        @Override
        public Adapter caseTypeObject(TypeObject object) {
            return createTypeObjectAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.DomainViewpoint <em>Viewpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.DomainViewpoint
     * @generated
     */
    public Adapter createDomainViewpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.Domain <em>Domain</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.Domain
     * @generated
     */
    public Adapter createDomainAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.EMFDomain <em>EMF Domain</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.EMFDomain
     * @generated
     */
    public Adapter createEMFDomainAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.TypeDomain <em>Type Domain</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.TypeDomain
     * @generated
     */
    public Adapter createTypeDomainAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.DomainGenPackage <em>Gen Package</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.DomainGenPackage
     * @generated
     */
    public Adapter createDomainGenPackageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.TypeDomainGenPackages <em>Type Domain Gen Packages</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.TypeDomainGenPackages
     * @generated
     */
    public Adapter createTypeDomainGenPackagesAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.FilesystemDomain <em>Filesystem Domain</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.FilesystemDomain
     * @generated
     */
    public Adapter createFilesystemDomainAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.domain.WorkspaceDomain <em>Workspace Domain</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.domain.WorkspaceDomain
     * @generated
     */
    public Adapter createWorkspaceDomainAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.ModelElement <em>Model Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.fcore.ModelElement
     * @generated
     */
    public Adapter createModelElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.Viewpoint <em>Viewpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.fcore.Viewpoint
     * @generated
     */
    public Adapter createViewpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.fcore.NamedModelElement <em>Named Model Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.fcore.NamedModelElement
     * @generated
     */
    public Adapter createNamedModelElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.types.TypeElement <em>Type Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.types.TypeElement
     * @generated
     */
    public Adapter createTypeElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.types.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.types.Type
     * @generated
     */
    public Adapter createTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.model.types.TypeObject <em>Type Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.model.types.TypeObject
     * @generated
     */
    public Adapter createTypeObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // DomainAdapterFactory
