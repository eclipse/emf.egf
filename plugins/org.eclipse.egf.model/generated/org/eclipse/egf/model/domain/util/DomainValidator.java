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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainGenPackage;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.FilesystemDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.domain.TypeDomainGenPackages;
import org.eclipse.egf.model.domain.WorkspaceDomain;
import org.eclipse.egf.model.domain.helper.TypeDomainGenPackageHelper;
import org.eclipse.egf.model.types.util.TypesValidator;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ITraversalStrategy.Recursive;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.domain.DomainPackage
 * @generated
 */
public class DomainValidator extends EObjectValidator {

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("hiding")
    public static final DomainValidator INSTANCE = new DomainValidator();

    /**
     * A constant for the
     * {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
     * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes}
     * from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    @SuppressWarnings("hiding")
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.domain"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for
     * additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for
     * additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Model Validation Service interface for batch validation of EMF elements.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private final IBatchValidator batchValidator;

    /**
     * The cached base package validator.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypesValidator typesValidator;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public DomainValidator() {
        super();
        typesValidator = TypesValidator.INSTANCE;
        batchValidator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
        batchValidator.setTraversalStrategy(new Recursive());
        batchValidator.setIncludeLiveConstraints(true);
        batchValidator.setReportSuccesses(false);
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
        return DomainPackage.eINSTANCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        IStatus status = Status.OK_STATUS;
        // do whatever the basic EcoreValidator does
        super.validate(eClass, eObject, diagnostics, context);
        // no point in validating if we can't report results
        if (diagnostics != null) {
            // if EMF Mode Validation Service already covered the sub-tree,
            // which it does for efficient computation and error reporting,
            // then don't repeat (the Diagnostician does the recursion
            // externally). If there is no context map, then we can't
            // help it
            if (hasProcessed(eObject, context) == false) {
                status = batchValidator.validate(eObject, new NullProgressMonitor());
                processed(eObject, context, status);
                appendDiagnostics(status, diagnostics);
            }
        }
        return status.isOK();
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the
     * model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
        case DomainPackage.DOMAIN_VIEWPOINT:
            return validateDomainViewpoint((DomainViewpoint) value, diagnostics, context);
        case DomainPackage.DOMAIN:
            return validateDomain((Domain) value, diagnostics, context);
        case DomainPackage.DOMAIN_GEN_PACKAGE:
            return validateDomainGenPackage((DomainGenPackage) value, diagnostics, context);
        case DomainPackage.TYPE_DOMAIN_GEN_PACKAGES:
            return validateTypeDomainGenPackages((TypeDomainGenPackages) value, diagnostics, context);
        case DomainPackage.EMF_DOMAIN:
            return validateEMFDomain((EMFDomain) value, diagnostics, context);
        case DomainPackage.TYPE_DOMAIN:
            return validateTypeDomain((TypeDomain) value, diagnostics, context);
        case DomainPackage.FILESYSTEM_DOMAIN:
            return validateFilesystemDomain((FilesystemDomain) value, diagnostics, context);
        case DomainPackage.WORKSPACE_DOMAIN:
            return validateWorkspaceDomain((WorkspaceDomain) value, diagnostics, context);
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateDomainViewpoint(DomainViewpoint domainViewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(domainViewpoint, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateDomain(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(domain, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateDomainGenPackage(DomainGenPackage domainGenPackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(domainGenPackage, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(domainGenPackage, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(domainGenPackage, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(domainGenPackage, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(domainGenPackage, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(domainGenPackage, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(domainGenPackage, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(domainGenPackage, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateDomainGenPackage_ValidGenPackage(domainGenPackage, diagnostics, context);
        return result;
    }

    /**
     * Validates the ValidPackage constraint of '<em>Gen Package</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateDomainGenPackage_ValidGenPackage(DomainGenPackage domainGenPackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (domainGenPackage.getGenPackage() == null) {
            return true;
        }
        URI uri = EcoreUtil.getURI(domainGenPackage.getGenPackage());
        Resource resource = null;
        // Try to load this uri
        if (domainGenPackage.eResource() != null && domainGenPackage.eResource() instanceof IPlatformFcoreProvider) {
            IPlatformFcore fcore = ((IPlatformFcoreProvider) domainGenPackage.eResource()).getIPlatformFcore();
            if (fcore.isRuntime()) {
                ResourceSet resourceSet = new RuntimePlatformResourceSet();
                resource = resourceSet.getResource(uri, true);
            } else {
                ResourceSet resourceSet = new TargetPlatformResourceSet();
                resource = resourceSet.getResource(uri, true);
            }
        } else {
            ResourceSet resourceSet = new TargetPlatformResourceSet();
            resource = resourceSet.getResource(uri, true);
        }
        // Check
        if (resource == null) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] { "ValidGenPackage", getObjectLabel(domainGenPackage, context), NLS.bind("Unable to load URI ''{0}''", uri) }, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] { domainGenPackage }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateTypeDomainGenPackages(TypeDomainGenPackages typeDomainGenPackages, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(typeDomainGenPackages, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(typeDomainGenPackages, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(typeDomainGenPackages, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(typeDomainGenPackages, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(typeDomainGenPackages, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(typeDomainGenPackages, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(typeDomainGenPackages, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(typeDomainGenPackages, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateTypeDomainGenPackages_ValidDomainGenPackages(typeDomainGenPackages, diagnostics, context);
        return result;
    }

    /**
     * Validates the ValidDomainGenPackages constraint of '
     * <em>Type Domain Gen Packages</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateTypeDomainGenPackages_ValidDomainGenPackages(TypeDomainGenPackages typeDomainGenPackages, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (typeDomainGenPackages.getElements() == null || typeDomainGenPackages.getElements().isEmpty()) {
            return true;
        }
        boolean valid = false;
        Collection<DomainGenPackage> domainGenPackages = TypeDomainGenPackageHelper.getAvailableDomainGenPackage(typeDomainGenPackages);
        for (DomainGenPackage domainGenPackage : typeDomainGenPackages.getElements()) {
            if (domainGenPackages.contains(domainGenPackage) == false) {
                valid = false;
                if (diagnostics != null) {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                            new Object[] { "ValidDomainGenPackages", getObjectLabel(typeDomainGenPackages, context), NLS.bind("Invalid DomainGenPackage ''{0}''", EcoreUtil.getURI(domainGenPackage)) }, //$NON-NLS-1$ //$NON-NLS-2$
                            new Object[] { typeDomainGenPackages }, context));
                }
            }
        }
        return valid;
    }

    /**
     * Validates the ValidURI constraint of '<em>URI</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateEMFDomain_ValidURI(EMFDomain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (domain.getUri() == null) {
            return true;
        }
        URI uri = domain.getUri();
        boolean valid = true;
        InputStream inputStream = null;
        // Try to open an InputStream
        try {
            if (domain.eResource() != null && domain.eResource() instanceof IPlatformFcoreProvider) {
                IPlatformFcore fcore = ((IPlatformFcoreProvider) domain.eResource()).getIPlatformFcore();
                if (fcore.isRuntime()) {
                    inputStream = EGFCorePlugin.getRuntimePlatformURIConverter().createInputStream(uri);
                } else {
                    inputStream = EGFCorePlugin.getTargetPlatformURIConverter().createInputStream(uri);
                }
            } else {
                inputStream = EGFCorePlugin.getTargetPlatformURIConverter().createInputStream(uri);
            }
        } catch (IOException exception) {
            valid = false;
        }
        // Safe Close
        FileHelper.safeClose(inputStream);
        // Check
        if (valid == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] { "ValidURI", getObjectLabel(domain, context), NLS.bind("Unable to load URI ''{0}''", uri) }, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] { domain }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateEMFDomain(EMFDomain emfDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(emfDomain, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(emfDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(emfDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(emfDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(emfDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(emfDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(emfDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(emfDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateEMFDomain_ValidURI(emfDomain, diagnostics, context);
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateTypeDomain(TypeDomain typeDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(typeDomain, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(typeDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(typeDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(typeDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(typeDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(typeDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(typeDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(typeDomain, diagnostics, context);
        if (result || diagnostics != null)
            result &= typesValidator.validateTypeObject_ValidValue(typeDomain, diagnostics, context);
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateFilesystemDomain(FilesystemDomain filesystemDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(filesystemDomain, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateWorkspaceDomain(WorkspaceDomain workspaceDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(workspaceDomain, diagnostics, context);
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this
     * validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return EGFModelPlugin.INSTANCE;
    }

    /**
     * If we have a context map, record this object's <code>status</code> in it
     * so that we will know later that we have processed it and its sub-tree.
     * 
     * @param eObject
     *            an element that we have validated
     * @param context
     *            the context (may be <code>null</code>)
     * @param status
     *            the element's validation status
     *            <!-- begin-user-doc -->
     *            <!-- end-user-doc -->
     * @generated
     */
    private void processed(EObject eObject, Map<Object, Object> context, IStatus status) {
        if (context != null) {
            context.put(eObject, status);
        }
    }

    /**
     * Determines whether we have processed this <code>eObject</code> before,
     * by automatic recursion of the EMF Model Validation Service. This is
     * only possible if we do, indeed, have a context.
     * 
     * @param eObject
     *            an element to be validated (we hope not)
     * @param context
     *            the context (may be <code>null</code>)
     * @return <code>true</code> if the context is not <code>null</code> and
     *         the <code>eObject</code> or one of its containers has already
     *         been
     *         validated; <code>false</code>, otherwise
     *         <!-- begin-user-doc -->
     *         <!-- end-user-doc -->
     * @generated
     */
    private boolean hasProcessed(EObject eObject, Map<Object, Object> context) {
        boolean result = false;
        if (context != null) {
            // this is O(NlogN) but there's no helping it
            while (eObject != null) {
                if (context.containsKey(eObject)) {
                    result = true;
                    eObject = null;
                } else {
                    eObject = eObject.eContainer();
                }
            }
        }
        return result;
    }

    /**
     * Converts a status result from the EMF validation service to diagnostics.
     * 
     * @param status
     *            the EMF validation service's status result
     * @param diagnostics
     *            a diagnostic chain to accumulate results on
     *            <!-- begin-user-doc -->
     *            <!-- end-user-doc -->
     * @generated
     */
    private void appendDiagnostics(IStatus status, DiagnosticChain diagnostics) {
        if (status.isMultiStatus()) {
            IStatus[] children = status.getChildren();
            for (int i = 0; i < children.length; i++) {
                appendDiagnostics(children[i], diagnostics);
            }
        } else if (status instanceof IConstraintStatus) {
            diagnostics.add(new BasicDiagnostic(status.getSeverity(), status.getPlugin(), status.getCode(), status.getMessage(), ((IConstraintStatus) status).getResultLocus().toArray()));
        }
    }
} // DomainValidator
