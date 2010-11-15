/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.util;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.helper.ActivityCycleFinder;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
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
 * @see org.eclipse.egf.model.fcore.FcorePackage
 * @generated
 */
public class FcoreValidator extends EObjectValidator {

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    public static final FcoreValidator INSTANCE = new FcoreValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    @SuppressWarnings("hiding")
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.fcore"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Model Validation Service interface for batch validation of EMF elements.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final IBatchValidator batchValidator;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FcoreValidator() {
        super();
        batchValidator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
        batchValidator.setTraversalStrategy(new Recursive());
        batchValidator.setIncludeLiveConstraints(true);
        batchValidator.setReportSuccesses(false);
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
        return FcorePackage.eINSTANCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
            //    which it does for efficient computation and error reporting,
            //    then don't repeat (the Diagnostician does the recursion
            //    externally).  If there is no context map, then we can't
            //    help it
            if (hasProcessed(eObject, context) == false) {
                status = batchValidator.validate(eObject, new NullProgressMonitor());
                processed(eObject, context, status);
                appendDiagnostics(status, diagnostics);
            }
        }
        return status.isOK();
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case FcorePackage.MODEL_ELEMENT:
                return validateModelElement((ModelElement) value, diagnostics, context);
            case FcorePackage.NAMED_MODEL_ELEMENT:
                return validateNamedModelElement((NamedModelElement) value, diagnostics, context);
            case FcorePackage.ACTIVITY:
                return validateActivity((Activity) value, diagnostics, context);
            case FcorePackage.CONTRACT:
                return validateContract((Contract) value, diagnostics, context);
            case FcorePackage.FACTORY_COMPONENT:
                return validateFactoryComponent((FactoryComponent) value, diagnostics, context);
            case FcorePackage.CONTRACT_CONTAINER:
                return validateContractContainer((ContractContainer) value, diagnostics, context);
            case FcorePackage.FACTORY_COMPONENT_CONTRACT:
                return validateFactoryComponentContract((FactoryComponentContract) value, diagnostics, context);
            case FcorePackage.VIEWPOINT_CONTAINER:
                return validateViewpointContainer((ViewpointContainer) value, diagnostics, context);
            case FcorePackage.VIEWPOINT:
                return validateViewpoint((Viewpoint) value, diagnostics, context);
            case FcorePackage.ORCHESTRATION:
                return validateOrchestration((Orchestration) value, diagnostics, context);
            case FcorePackage.ORCHESTRATION_PARAMETER_CONTAINER:
                return validateOrchestrationParameterContainer((OrchestrationParameterContainer) value, diagnostics, context);
            case FcorePackage.ORCHESTRATION_PARAMETER:
                return validateOrchestrationParameter((OrchestrationParameter) value, diagnostics, context);
            case FcorePackage.INVOCATION:
                return validateInvocation((Invocation) value, diagnostics, context);
            case FcorePackage.INVOCATION_CONTRACT_CONTAINER:
                return validateInvocationContractContainer((InvocationContractContainer) value, diagnostics, context);
            case FcorePackage.INVOCATION_CONTRACT:
                return validateInvocationContract((InvocationContract) value, diagnostics, context);
            case FcorePackage.CONTRACT_MODE:
                return validateContractMode((ContractMode) value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateModelElement(ModelElement modelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(modelElement, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNamedModelElement(NamedModelElement namedModelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(namedModelElement, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateActivity(Activity activity, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(activity, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateActivity_PlatformFcore(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateActivity_MandatoryName(activity, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateActivity_ActivityCycle(activity, diagnostics, context);
        return result;
    }

    /**
     * Validates the PlatformFcore constraint of '<em>Activity</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean validateActivity_PlatformFcore(Activity activity, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (activity.eResource() == null || activity.eResource() instanceof IPlatformFcoreProvider == false) {
            return true;
        }
        if (((IPlatformFcoreProvider) activity.eResource()).getIPlatformFcore() == null) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "PlatformFcore", getObjectLabel(activity, context), "There is no 'org.eclipse.egf.core.fcore' extension-point associated with this activity fcore resource"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            activity
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the MandatoryName constraint of '<em>Activity</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateActivity_MandatoryName(Activity activity, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (activity.getName() == null || activity.getName().trim().length() == 0) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "MandatoryName", getObjectLabel(activity, context), "The attribute name is mandatory"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            activity
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ActivityCycle constraint of '<em>Activity</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateActivity_ActivityCycle(Activity activity, DiagnosticChain diagnostics, Map<Object, Object> context) {
        ActivityCycleFinder finder = new ActivityCycleFinder(activity);
        ModelElement element = finder.getFirstRepetition();
        if (element != null) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ActivityCycle", getObjectLabel(element, context)}, //$NON-NLS-1$
                        new Object[] {
                            element
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateContract(Contract contract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(contract, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateContract_UniqueName(contract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateContract_UselessMandatoryMode(contract, diagnostics, context);
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFactoryComponent(FactoryComponent factoryComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(factoryComponent, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateActivity_PlatformFcore(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateActivity_MandatoryName(factoryComponent, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateActivity_ActivityCycle(factoryComponent, diagnostics, context);
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateContractContainer(ContractContainer contractContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(contractContainer, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(contractContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(contractContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(contractContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(contractContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(contractContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(contractContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(contractContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateContractContainer_FactoryComponentContract(contractContainer, diagnostics, context);
        return result;
    }

    /**
     * Validates the FactoryComponentContract constraint of '<em>Contract Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateContractContainer_FactoryComponentContract(ContractContainer contractContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (contractContainer.getActivity() == null || contractContainer.getActivity() instanceof FactoryComponent == false) {
            return true;
        }
        boolean valid = true;
        for (Contract contract : contractContainer.getContracts()) {
            if (contract instanceof FactoryComponentContract == false) {
                valid = false;
                break;
            }
        }
        if (valid == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "FactoryComponentContract", getObjectLabel(contractContainer, context), "This ContractContainer should only hold FactoryComponentContract"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            contractContainer
                        }, context));
            }
        }
        return valid;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFactoryComponentContract(FactoryComponentContract factoryComponentContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(factoryComponentContract, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateContract_UniqueName(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateContract_UselessMandatoryMode(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateFactoryComponentContract_UselessFactoryComponentContract(factoryComponentContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateFactoryComponentContract_OutModeIsRestricted(factoryComponentContract, diagnostics, context);
        return result;
    }

    /**
     * Validates the UselessFactoryComponentContract constraint of '<em>Factory Component Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateFactoryComponentContract_UselessFactoryComponentContract(FactoryComponentContract factoryComponentContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (factoryComponentContract.getInvocationContracts() == null || factoryComponentContract.getInvocationContracts().size() == 0) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "UselessFactoryComponentContract", getObjectLabel(factoryComponentContract, context), "This FactoryComponentContract is not used"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            factoryComponentContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateViewpointContainer(ViewpointContainer viewpointContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(viewpointContainer, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateViewpoint(Viewpoint viewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(viewpoint, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOrchestration(Orchestration orchestration, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(orchestration, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOrchestrationParameterContainer(OrchestrationParameterContainer orchestrationParameterContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(orchestrationParameterContainer, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(orchestrationParameterContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(orchestrationParameterContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(orchestrationParameterContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(orchestrationParameterContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(orchestrationParameterContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(orchestrationParameterContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(orchestrationParameterContainer, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateOrchestrationParameterContainer_UselessOrchestrationParameterContainer(orchestrationParameterContainer, diagnostics, context);
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOrchestrationParameter(OrchestrationParameter orchestrationParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(orchestrationParameter, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(orchestrationParameter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(orchestrationParameter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(orchestrationParameter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(orchestrationParameter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(orchestrationParameter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(orchestrationParameter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(orchestrationParameter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateOrchestrationParameter_UselessOrchestrationParameter(orchestrationParameter, diagnostics, context);
        return result;
    }

    /**
     * Validates the UselessOrchestrationParameter constraint of '<em>Orchestration Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateOrchestrationParameter_UselessOrchestrationParameter(OrchestrationParameter orchestrationParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (orchestrationParameter.getInvocationContracts() == null || orchestrationParameter.getInvocationContracts().size() == 0) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "UselessOrchestrationParameter", getObjectLabel(orchestrationParameter, context), "This OrchestrationParameter is unused"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            orchestrationParameter
                        }, context));
                return false;
            }
        }
        if (orchestrationParameter.getType() != null && orchestrationParameter.getType().getValue() == null) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "UselessOrchestrationParameter", getObjectLabel(orchestrationParameter.getType(), context), "This OrchestrationParameter Type has no defined value"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            orchestrationParameter.getType()
                        }, context));
                return false;
            }
        }
        if (orchestrationParameter.getInvocationContracts().size() > 0 && orchestrationParameter.getInvocationContracts().size() == 1) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "UselessOrchestrationParameter", getObjectLabel(orchestrationParameter, context), NLS.bind("This OrchestrationParameter could be defined in ''{0}''", getObjectLabel(orchestrationParameter.getInvocationContracts().get(0), context))}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            orchestrationParameter
                        }, context));
                return false;
            }
        }
        return true;
    }

    /**
     * Validates the UselessOrchestrationParameterContainer constraint of '<em>Orchestration Parameter
     * Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateOrchestrationParameterContainer_UselessOrchestrationParameterContainer(OrchestrationParameterContainer orchestrationParameterContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (orchestrationParameterContainer.getOrchestrationParameters() == null || orchestrationParameterContainer.getOrchestrationParameters().size() == 0) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "UselessOrchestrationParameterContainer", getObjectLabel(orchestrationParameterContainer, context), "OrchestrationParameterContainer should contain at least one InvocationParameter"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            orchestrationParameterContainer
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateInvocation(Invocation invocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(invocation, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(invocation, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(invocation, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(invocation, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(invocation, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(invocation, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(invocation, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(invocation, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocation_MandatoryInvokedContract(invocation, diagnostics, context);
        return result;
    }

    /**
     * Validates the MandatoryInvokedContract constraint of '<em>Invocation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocation_MandatoryInvokedContract(Invocation invocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocation.getInvokedActivity() == null || invocation.getInvokedActivity().getContracts() == null || invocation.getInvokedActivity().getContracts().size() == 0) {
            return true;
        }
        for (Contract contract : invocation.getInvokedActivity().getContracts()) {
            // Mandatory contract with a default value raise a warning
            // see validateContract_UselessMandatoryMode
            // as such this doesn't prevent any execution
            // only mandatory contract with no default value should be declared at invocation level
            if (contract.isMandatory() == false || contract.getType() == null || contract.getType().getValue() != null) {
                continue;
            }
            boolean found = false;
            if (invocation.getInvocationContracts() != null) {
                for (InvocationContract invocationContract : invocation.getInvocationContracts()) {
                    if (contract.equals(invocationContract.getInvokedContract())) {
                        found = true;
                        break;
                    }
                }
            }
            if (found == false) {
                if (diagnostics != null) {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                            new Object[] {
                                    "MandatoryInvokedContract", getObjectLabel(invocation, context), NLS.bind("Mandatory Contract ''{0}'' should be invoked", getObjectLabel(contract, context))}, //$NON-NLS-1$ //$NON-NLS-2$
                            new Object[] {
                                invocation
                            }, context));
                }
                return false;
            }
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateInvocationContractContainer(InvocationContractContainer invocationContractContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(invocationContractContainer, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateInvocationContract(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(invocationContract, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidInvokedContract(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidInvokedContractType(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidFactoryComponentContract(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidFactoryComponentContractType(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidOrchestrationParameter(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidOrchestrationParameterType(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidSourceInvocationContract(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_ValidSourceInvocationContractType(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_UselessTypeValue(invocationContract, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInvocationContract_UselessInvocationContract(invocationContract, diagnostics, context);
        return result;
    }

    /**
     * Validates the ValidInvokedContract constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidInvokedContract(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getInvokedContract() == null || invocationContract.getInvocation() == null || invocationContract.getInvocation().getInvokedActivity() == null) {
            return true;
        }
        // Activity contract analysis
        boolean found = false;
        for (Contract contract : invocationContract.getInvocation().getInvokedActivity().getContracts()) {
            if (contract == invocationContract.getInvokedContract()) {
                found = true;
                break;
            }
        }
        if (found == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidInvokedContract", getObjectLabel(invocationContract, context), "InvokedContract doesn't match any InvokedActivity Contract"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidInvokedContractType constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidInvokedContractType(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null || invocationContract.getType() == null) {
            return true;
        }
        if (invocationContract.getType().isCompatible(invocationContract.getInvokedContract().getType()) == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidInvokedContractType", getObjectLabel(invocationContract, context), "InvocationContract Type and InvokedContract Type are incompatible"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidFactoryComponentContract constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidFactoryComponentContract(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getFactoryComponentContract() == null || invocationContract.getInvokedMode() == null) {
            return true;
        }
        if (invocationContract.getInvokedMode() == ContractMode.OUT && invocationContract.getFactoryComponentContract().getMode() == ContractMode.IN) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidFactoryComponentContract", getObjectLabel(invocationContract, context), "InvocationContract in Out Mode couldn't be assigned to a FactoryComponentContract in In Mode"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        } else if (invocationContract.getInvokedMode() == ContractMode.IN && invocationContract.getFactoryComponentContract().getMode() == ContractMode.OUT) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidFactoryComponentContract", getObjectLabel(invocationContract, context), "InvocationContract in In Mode couldn't be assigned to a FactoryComponentContract in Out Mode"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidFactoryComponentContractType constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidFactoryComponentContractType(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getFactoryComponentContract() == null || invocationContract.getFactoryComponentContract().getType() == null) {
            return true;
        }
        if (invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
            return true;
        }
        Type type = invocationContract.getType();
        if (type == null) {
            type = invocationContract.getInvokedContract().getType();
        }
        if (type.isCompatible(invocationContract.getFactoryComponentContract().getType()) == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidFactoryComponentContractType", getObjectLabel(invocationContract, context), "FactoryComponentContract Type and InvocationContract Type are incompatible"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidOrchestrationParameter constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidOrchestrationParameter(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getOrchestrationParameter() == null || invocationContract.getInvokedContract() == null) {
            return true;
        }
        if (invocationContract.getInvokedContract().getMode() == ContractMode.OUT) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidOrchestrationParameter", getObjectLabel(invocationContract, context), "InvocationContract in Out Mode couldn't be assigned to an OrchestrationParameter"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        if (invocationContract.getSourceInvocationContract() != null) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidOrchestrationParameter", getObjectLabel(invocationContract, context), "InvocationContract assigned to a SourceInvocationContract couldn't be assigned to an OrchestrationParameter"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        if (invocationContract.getFactoryComponentContract() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidOrchestrationParameter", getObjectLabel(invocationContract, context), "FactoryComponentContract should be in Out Mode when an InvocationContract is assigned to an OrchestrationParameter and a FactoryComponentContract"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidOrchestrationParameterType constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidOrchestrationParameterType(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getOrchestrationParameter() == null || invocationContract.getOrchestrationParameter().getType() == null || invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
            return true;
        }
        Type type = invocationContract.getType();
        if (type == null) {
            type = invocationContract.getInvokedContract().getType();
        }
        if (type.isCompatible(invocationContract.getOrchestrationParameter().getType()) == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidOrchestrationParameterType", getObjectLabel(invocationContract, context), "OrchestrationParameter Type and InvocationContract Type are incompatible"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidSourceInvocationContract constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidSourceInvocationContract(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getSourceInvocationContract() == null || invocationContract.getInvokedContract() == null) {
            return true;
        }
        if (invocationContract.getInvokedContract().getMode() == ContractMode.OUT) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidSourceInvocationContract", getObjectLabel(invocationContract, context), "InvocationContract in Out Mode couldn't be assigned to a SourceInvocationContract"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        if (invocationContract.getFactoryComponentContract() != null && invocationContract.getFactoryComponentContract().getMode() != ContractMode.OUT) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidSourceInvocationContract", getObjectLabel(invocationContract, context), "InvocationContract with a SourceInvocationContract couldn't be assigned to a FactoryComponentContract in In or In_Out Mode"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidSourceInvocationContractType constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_ValidSourceInvocationContractType(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getSourceInvocationContract() == null || invocationContract.getSourceInvocationContract().getInvokedContract() == null || invocationContract.getSourceInvocationContract().getInvokedContract().getType() == null) {
            return true;
        }
        Type sourceType = invocationContract.getSourceInvocationContract().getType();
        if (sourceType == null) {
            sourceType = invocationContract.getSourceInvocationContract().getInvokedContract().getType();
        }
        if (invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
            return true;
        }
        Type type = invocationContract.getType();
        if (type == null) {
            type = invocationContract.getInvokedContract().getType();
        }
        if (type.isCompatible(sourceType) == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "ValidSourceInvocationContractType", getObjectLabel(invocationContract, context), "SourceInvocationContract Type and InvocationContract Type are incompatible"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the UselessTypeValue constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_UselessTypeValue(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getType() == null || invocationContract.getType().getValue() == null) {
            return true;
        }
        if ((invocationContract.getInvokedMode() == ContractMode.IN || invocationContract.getInvokedMode() == ContractMode.IN_OUT)) {
            if (invocationContract.getOrchestrationParameter() != null && invocationContract.getOrchestrationParameter().getType() != null && invocationContract.getOrchestrationParameter().getType().getValue() != null) {
                if (diagnostics != null) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                            new Object[] {
                                    "UselessTypeValue", getObjectLabel(invocationContract, context), "InvocationContract is used in an OrchestrationParameter. Default OrchestrationParameter Type Value will supersede InvocationContract Type Value"}, //$NON-NLS-1$ //$NON-NLS-2$
                            new Object[] {
                                invocationContract
                            }, context));
                    return false;
                }
            }
            if (invocationContract.getFactoryComponentContract() != null && (invocationContract.getFactoryComponentContract().getMode() == ContractMode.IN || invocationContract.getFactoryComponentContract().getMode() == ContractMode.IN_OUT)) {
                if (invocationContract.getFactoryComponentContract().isMandatory()) {
                    if (diagnostics != null) {
                        diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                                new Object[] {
                                        "UselessTypeValue", getObjectLabel(invocationContract, context), "InvocationContract is used in a mandatory FactoryComponentContract. FactoryComponentContract Type Value will supersede InvocationContract Type Value"}, //$NON-NLS-1$ //$NON-NLS-2$
                                new Object[] {
                                    invocationContract
                                }, context));
                        return false;
                    }
                } else if (invocationContract.getFactoryComponentContract().getType() != null && invocationContract.getFactoryComponentContract().getType().getValue() != null) {
                    if (diagnostics != null) {
                        diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                                new Object[] {
                                        "UselessTypeValue", getObjectLabel(invocationContract, context), "InvocationContract is used in a FactoryComponentContract. Default FactoryComponentContract Type Value will supersede InvocationContract Type Value"}, //$NON-NLS-1$ //$NON-NLS-2$
                                new Object[] {
                                    invocationContract
                                }, context));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Validates the UselessInvocationContract constraint of '<em>Invocation Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateInvocationContract_UselessInvocationContract(InvocationContract invocationContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (invocationContract.getInvokedMode() == ContractMode.OUT || (invocationContract.getType() != null && invocationContract.getType().getValue() != null)) {
            return true;
        }
        if (invocationContract.getOrchestrationParameter() == null && invocationContract.getFactoryComponentContract() == null && invocationContract.getSourceInvocationContract() == null) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "UselessInvocationContract", getObjectLabel(invocationContract, context), "InvocationContract has no input"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            invocationContract
                        }, context));
                return false;
            }
        }
        return true;
    }

    /**
     * Validates the UniqueName constraint of '<em>Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateContract_UniqueName(Contract contract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (contract.getName() == null) {
            return true;
        }
        // Verify if name is unique in its contract container
        boolean collapse = false;
        for (Contract innerContract : contract.getContracts()) {
            // Ignore ourself
            if (innerContract == contract) {
                continue;
            }
            // Ignore mutually exclusive conditions
            if ((contract.getMode() == ContractMode.IN && innerContract.getMode() == ContractMode.OUT) || (contract.getMode() == ContractMode.OUT && innerContract.getMode() == ContractMode.IN)) {
                continue;
            }
            // Collapse
            if (contract.getName().equals(innerContract.getName())) {
                collapse = true;
                break;
            }
        }
        if (collapse) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "UniqueName", getObjectLabel(contract, context), "Contract Name should be unique in its ContractContainer"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            contract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the UselessMandatoryMode constraint of '<em>Contract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateContract_UselessMandatoryMode(Contract contract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (contract.isMandatory() == false || contract.getType() == null || contract.getType().getValue() == null) {
            return true;
        }
        if (diagnostics != null) {
            diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                    new Object[] {
                            "UselessMandatoryMode", getObjectLabel(contract, context), "A Mandatory Contract with a default value is always true"}, //$NON-NLS-1$ //$NON-NLS-2$
                    new Object[] {
                        contract
                    }, context));
        }
        return false;
    }

    /**
     * Validates the OutModeIsRestricted constraint of '<em>FactoryComponentContract</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateFactoryComponentContract_OutModeIsRestricted(FactoryComponentContract factoryComponentContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (factoryComponentContract.getMode() == ContractMode.IN || factoryComponentContract.getInvocationContracts() == null) {
            return true;
        }
        if (factoryComponentContract.getInvocationContracts().size() > 1) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] {
                                "OutModeIsRestricted", getObjectLabel(factoryComponentContract, context), "FactoryComponentContract in Out or In_Out Mode should only have one assigned InvocationContract"}, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] {
                            factoryComponentContract
                        }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateContractMode(ContractMode contractMode, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * @param eObject an element that we have validated
     * @param context the context (may be <code>null</code>)
     * @param status the element's validation status
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
     * by automatic recursion of the EMF Model Validation Service.  This is
     * only possible if we do, indeed, have a context.
     * 
     * @param eObject an element to be validated (we hope not)
     * @param context the context (may be <code>null</code>)
     * @return <code>true</code> if the context is not <code>null</code> and
     *     the <code>eObject</code> or one of its containers has already been
     *     validated;  <code>false</code>, otherwise
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
     * @param status the EMF validation service's status result
     * @param diagnostics a diagnostic chain to accumulate results on
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
} // FcoreValidator
