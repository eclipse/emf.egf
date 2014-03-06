/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class FcoreFactoryImpl extends EFactoryImpl implements FcoreFactory {

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FcoreFactory init() {
        try {
            FcoreFactory theFcoreFactory = (FcoreFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/fcore"); //$NON-NLS-1$ 
            if (theFcoreFactory != null) {
                return theFcoreFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FcoreFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FcoreFactoryImpl() {
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
            case FcorePackage.CONTRACT:
                return createContract();
            case FcorePackage.FACTORY_COMPONENT:
                return createFactoryComponent();
            case FcorePackage.CONTRACT_CONTAINER:
                return createContractContainer();
            case FcorePackage.FACTORY_COMPONENT_CONTRACT:
                return createFactoryComponentContract();
            case FcorePackage.VIEWPOINT_CONTAINER:
                return createViewpointContainer();
            case FcorePackage.ORCHESTRATION_PARAMETER_CONTAINER:
                return createOrchestrationParameterContainer();
            case FcorePackage.ORCHESTRATION_PARAMETER:
                return createOrchestrationParameter();
            case FcorePackage.INVOCATION_CONTRACT_CONTAINER:
                return createInvocationContractContainer();
            case FcorePackage.INVOCATION_CONTRACT:
                return createInvocationContract();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case FcorePackage.CONTRACT_MODE:
                return createContractModeFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case FcorePackage.CONTRACT_MODE:
                return convertContractModeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Contract createContract() {
        ContractImpl contract = new ContractImpl();
        return contract;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FactoryComponent createFactoryComponent() {
        FactoryComponentImpl factoryComponent = new FactoryComponentImpl();
        return factoryComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContractContainer createContractContainer() {
        ContractContainerImpl contractContainer = new ContractContainerImpl();
        return contractContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FactoryComponentContract createFactoryComponentContract() {
        FactoryComponentContractImpl factoryComponentContract = new FactoryComponentContractImpl();
        return factoryComponentContract;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ViewpointContainer createViewpointContainer() {
        ViewpointContainerImpl viewpointContainer = new ViewpointContainerImpl();
        return viewpointContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OrchestrationParameterContainer createOrchestrationParameterContainer() {
        OrchestrationParameterContainerImpl orchestrationParameterContainer = new OrchestrationParameterContainerImpl();
        return orchestrationParameterContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OrchestrationParameter createOrchestrationParameter() {
        OrchestrationParameterImpl orchestrationParameter = new OrchestrationParameterImpl();
        return orchestrationParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InvocationContractContainer createInvocationContractContainer() {
        InvocationContractContainerImpl invocationContractContainer = new InvocationContractContainerImpl();
        return invocationContractContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InvocationContract createInvocationContract() {
        InvocationContractImpl invocationContract = new InvocationContractImpl();
        return invocationContract;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContractMode createContractMode(String literal) {
        ContractMode result = ContractMode.get(literal);
        if (result == null)
            throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + FcorePackage.Literals.CONTRACT_MODE.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContractMode createContractModeFromString(EDataType eDataType, String initialValue) {
        return createContractMode(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertContractMode(ContractMode instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertContractModeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Class<?> createClazzFromString(EDataType eDataType, String initialValue) {
        return (Class<?>) super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FcorePackage getFcorePackage() {
        return (FcorePackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static FcorePackage getPackage() {
        return FcorePackage.eINSTANCE;
    }

} // FcoreFactoryImpl
