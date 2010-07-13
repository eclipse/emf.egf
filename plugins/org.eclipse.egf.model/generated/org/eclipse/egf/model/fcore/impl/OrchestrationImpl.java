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
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orchestration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl#getFactoryComponent <em>Factory Component</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OrchestrationImpl extends ModelElementImpl implements Orchestration {
    /**
     * The cached value of the '{@link #getOrchestrationParameterContainer() <em>Orchestration Parameter Container</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrchestrationParameterContainer()
     * @generated
     * @ordered
     */
    protected OrchestrationParameterContainer orchestrationParameterContainer;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OrchestrationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FcorePackage.Literals.ORCHESTRATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FactoryComponent getFactoryComponent() {
        if (eContainerFeatureID() != FcorePackage.ORCHESTRATION__FACTORY_COMPONENT)
            return null;
        return (FactoryComponent) eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFactoryComponent(FactoryComponent newFactoryComponent, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newFactoryComponent, FcorePackage.ORCHESTRATION__FACTORY_COMPONENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFactoryComponent(FactoryComponent newFactoryComponent) {
        if (newFactoryComponent != eInternalContainer() || (eContainerFeatureID() != FcorePackage.ORCHESTRATION__FACTORY_COMPONENT && newFactoryComponent != null)) {
            if (EcoreUtil.isAncestor(this, newFactoryComponent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFactoryComponent != null)
                msgs = ((InternalEObject) newFactoryComponent).eInverseAdd(this, FcorePackage.FACTORY_COMPONENT__ORCHESTRATION, FactoryComponent.class, msgs);
            msgs = basicSetFactoryComponent(newFactoryComponent, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION__FACTORY_COMPONENT, newFactoryComponent, newFactoryComponent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OrchestrationParameterContainer getOrchestrationParameterContainer() {
        return orchestrationParameterContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOrchestrationParameterContainer(OrchestrationParameterContainer newOrchestrationParameterContainer, NotificationChain msgs) {
        OrchestrationParameterContainer oldOrchestrationParameterContainer = orchestrationParameterContainer;
        orchestrationParameterContainer = newOrchestrationParameterContainer;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER, oldOrchestrationParameterContainer, newOrchestrationParameterContainer);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOrchestrationParameterContainer(OrchestrationParameterContainer newOrchestrationParameterContainer) {
        if (newOrchestrationParameterContainer != orchestrationParameterContainer) {
            NotificationChain msgs = null;
            if (orchestrationParameterContainer != null)
                msgs = ((InternalEObject) orchestrationParameterContainer).eInverseRemove(this, FcorePackage.ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION, OrchestrationParameterContainer.class, msgs);
            if (newOrchestrationParameterContainer != null)
                msgs = ((InternalEObject) newOrchestrationParameterContainer).eInverseAdd(this, FcorePackage.ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION, OrchestrationParameterContainer.class, msgs);
            msgs = basicSetOrchestrationParameterContainer(newOrchestrationParameterContainer, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER, newOrchestrationParameterContainer, newOrchestrationParameterContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public <T extends Invocation> EList<T> getInvocations() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<InvocationContract> getInvocationContracts() {
        EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
        if (getInvocations() != null) {
            for (Invocation invocation : getInvocations()) {
                invocationContracts.addAll(invocation.getInvocationContracts());
            }
        }
        return invocationContracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<InvocationContract> getInvocationContracts(Type type) {
        EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
        if (type != null) {
            for (Invocation invocation : getInvocations()) {
                invocationContracts.addAll(invocation.getInvocationContracts(type));
            }
        }
        return invocationContracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<InvocationContract> getInvocationContracts(ContractMode mode) {
        EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
        if (mode != null) {
            for (Invocation invocation : getInvocations()) {
                invocationContracts.addAll(invocation.getInvocationContracts(mode));
            }
        }
        return invocationContracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<InvocationContract> getInvocationContracts(Type type, ContractMode mode) {
        EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
        for (Invocation invocation : getInvocations()) {
            invocationContracts.addAll(invocation.getInvocationContracts(type, mode));
        }
        return invocationContracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<OrchestrationParameter> getOrchestrationParameters() {
        EList<OrchestrationParameter> orchestrationParameters = new UniqueEList<OrchestrationParameter>();
        if (getOrchestrationParameterContainer() != null) {
            return getOrchestrationParameterContainer().getOrchestrationParameters();
        }
        return orchestrationParameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<OrchestrationParameter> getOrchestrationParameters(Type type) {
        EList<OrchestrationParameter> orchestrationParameters = new UniqueEList<OrchestrationParameter>();
        if (getOrchestrationParameterContainer() != null) {
            return getOrchestrationParameterContainer().getOrchestrationParameters(type);
        }
        return orchestrationParameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetFactoryComponent((FactoryComponent) otherEnd, msgs);
        case FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER:
            if (orchestrationParameterContainer != null)
                msgs = ((InternalEObject) orchestrationParameterContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER, null, msgs);
            return basicSetOrchestrationParameterContainer((OrchestrationParameterContainer) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
            return basicSetFactoryComponent(null, msgs);
        case FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER:
            return basicSetOrchestrationParameterContainer(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
            return eInternalContainer().eInverseRemove(this, FcorePackage.FACTORY_COMPONENT__ORCHESTRATION, FactoryComponent.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
            return getFactoryComponent();
        case FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER:
            return getOrchestrationParameterContainer();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
            setFactoryComponent((FactoryComponent) newValue);
            return;
        case FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER:
            setOrchestrationParameterContainer((OrchestrationParameterContainer) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
            setFactoryComponent((FactoryComponent) null);
            return;
        case FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER:
            setOrchestrationParameterContainer((OrchestrationParameterContainer) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
            return getFactoryComponent() != null;
        case FcorePackage.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER:
            return orchestrationParameterContainer != null;
        }
        return super.eIsSet(featureID);
    }

} // OrchestrationImpl
