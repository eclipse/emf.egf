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
package org.eclipse.egf.model.domain.util;

import java.util.List;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainGenPackage;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.FilesystemDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.domain.TypeDomainGenPackages;
import org.eclipse.egf.model.domain.WorkspaceDomain;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeElement;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.domain.DomainPackage
 * @generated
 */
public class DomainSwitch<T> {

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DomainPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainSwitch() {
        if (modelPackage == null) {
            modelPackage = DomainPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @SuppressWarnings("all")
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case DomainPackage.DOMAIN_VIEWPOINT: {
                DomainViewpoint domainViewpoint = (DomainViewpoint) theEObject;
                T result = caseDomainViewpoint(domainViewpoint);
                if (result == null)
                    result = caseViewpoint(domainViewpoint);
                if (result == null)
                    result = caseModelElement(domainViewpoint);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DomainPackage.DOMAIN: {
                Domain domain = (Domain) theEObject;
                T result = caseDomain(domain);
                if (result == null)
                    result = caseNamedModelElement(domain);
                if (result == null)
                    result = caseModelElement(domain);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DomainPackage.DOMAIN_GEN_PACKAGE: {
                DomainGenPackage domainGenPackage = (DomainGenPackage) theEObject;
                T result = caseDomainGenPackage(domainGenPackage);
                if (result == null)
                    result = caseDomain(domainGenPackage);
                if (result == null)
                    result = caseNamedModelElement(domainGenPackage);
                if (result == null)
                    result = caseModelElement(domainGenPackage);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DomainPackage.TYPE_DOMAIN_GEN_PACKAGES: {
                TypeDomainGenPackages typeDomainGenPackages = (TypeDomainGenPackages) theEObject;
                T result = caseTypeDomainGenPackages(typeDomainGenPackages);
                if (result == null)
                    result = caseType(typeDomainGenPackages);
                if (result == null)
                    result = caseTypeElement(typeDomainGenPackages);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DomainPackage.EMF_DOMAIN: {
                EMFDomain emfDomain = (EMFDomain) theEObject;
                T result = caseEMFDomain(emfDomain);
                if (result == null)
                    result = caseDomain(emfDomain);
                if (result == null)
                    result = caseNamedModelElement(emfDomain);
                if (result == null)
                    result = caseModelElement(emfDomain);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DomainPackage.TYPE_DOMAIN: {
                TypeDomain typeDomain = (TypeDomain) theEObject;
                T result = caseTypeDomain(typeDomain);
                if (result == null)
                    result = caseTypeObject(typeDomain);
                if (result == null)
                    result = caseType(typeDomain);
                if (result == null)
                    result = caseTypeElement(typeDomain);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DomainPackage.FILESYSTEM_DOMAIN: {
                FilesystemDomain filesystemDomain = (FilesystemDomain) theEObject;
                T result = caseFilesystemDomain(filesystemDomain);
                if (result == null)
                    result = caseDomain(filesystemDomain);
                if (result == null)
                    result = caseNamedModelElement(filesystemDomain);
                if (result == null)
                    result = caseModelElement(filesystemDomain);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DomainPackage.WORKSPACE_DOMAIN: {
                WorkspaceDomain workspaceDomain = (WorkspaceDomain) theEObject;
                T result = caseWorkspaceDomain(workspaceDomain);
                if (result == null)
                    result = caseDomain(workspaceDomain);
                if (result == null)
                    result = caseNamedModelElement(workspaceDomain);
                if (result == null)
                    result = caseModelElement(workspaceDomain);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDomainViewpoint(DomainViewpoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDomain(Domain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Gen Package</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Gen Package</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDomainGenPackage(DomainGenPackage object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Domain Gen Packages</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Domain Gen Packages</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeDomainGenPackages(TypeDomainGenPackages object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EMF Domain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EMF Domain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEMFDomain(EMFDomain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Domain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Domain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeDomain(TypeDomain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Filesystem Domain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Filesystem Domain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFilesystemDomain(FilesystemDomain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Workspace Domain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Workspace Domain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorkspaceDomain(WorkspaceDomain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModelElement(ModelElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseViewpoint(Viewpoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Model Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedModelElement(NamedModelElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeElement(TypeElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType(Type object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeObject(TypeObject object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last
     * case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} // DomainSwitch
