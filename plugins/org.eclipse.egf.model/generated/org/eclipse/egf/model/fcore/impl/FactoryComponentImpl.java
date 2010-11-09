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
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factory Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.FactoryComponentImpl#getViewpointContainer <em>Viewpoint Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.FactoryComponentImpl#getOrchestration <em>Orchestration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryComponentImpl extends ActivityImpl implements FactoryComponent {

    /**
     * The cached value of the '{@link #getViewpointContainer() <em>Viewpoint Container</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getViewpointContainer()
     * @generated
     * @ordered
     */
    protected ViewpointContainer viewpointContainer;

    /**
     * The cached value of the '{@link #getOrchestration() <em>Orchestration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrchestration()
     * @generated
     * @ordered
     */
    protected Orchestration orchestration;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FactoryComponentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FcorePackage.Literals.FACTORY_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ViewpointContainer getViewpointContainer() {
        return viewpointContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetViewpointContainer(ViewpointContainer newViewpointContainer, NotificationChain msgs) {
        ViewpointContainer oldViewpointContainer = viewpointContainer;
        viewpointContainer = newViewpointContainer;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, oldViewpointContainer, newViewpointContainer);
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
    public void setViewpointContainer(ViewpointContainer newViewpointContainer) {
        if (newViewpointContainer != viewpointContainer) {
            NotificationChain msgs = null;
            if (viewpointContainer != null)
                msgs = ((InternalEObject) viewpointContainer).eInverseRemove(this, FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT, ViewpointContainer.class, msgs);
            if (newViewpointContainer != null)
                msgs = ((InternalEObject) newViewpointContainer).eInverseAdd(this, FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT, ViewpointContainer.class, msgs);
            msgs = basicSetViewpointContainer(newViewpointContainer, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, newViewpointContainer, newViewpointContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Orchestration getOrchestration() {
        return orchestration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOrchestration(Orchestration newOrchestration, NotificationChain msgs) {
        Orchestration oldOrchestration = orchestration;
        orchestration = newOrchestration;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.FACTORY_COMPONENT__ORCHESTRATION, oldOrchestration, newOrchestration);
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
    public void setOrchestration(Orchestration newOrchestration) {
        if (newOrchestration != orchestration) {
            NotificationChain msgs = null;
            if (orchestration != null)
                msgs = ((InternalEObject) orchestration).eInverseRemove(this, FcorePackage.ORCHESTRATION__FACTORY_COMPONENT, Orchestration.class, msgs);
            if (newOrchestration != null)
                msgs = ((InternalEObject) newOrchestration).eInverseAdd(this, FcorePackage.ORCHESTRATION__FACTORY_COMPONENT, Orchestration.class, msgs);
            msgs = basicSetOrchestration(newOrchestration, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.FACTORY_COMPONENT__ORCHESTRATION, newOrchestration, newOrchestration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public EList<Resource> getResources() {
        UniqueEList<Resource> resources = new UniqueEList<Resource>();
        if (eResource() != null) {
            resources.add(eResource());
        }
        if (getOrchestration() != null) {
            resources.addAll(getOrchestration().getResources());
        }
        return resources;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<InvocationContract> getInvocationContracts() {
        EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
        if (getOrchestration() != null) {
            return getOrchestration().getInvocationContracts();
        }
        return invocationContracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<InvocationContract> getInvocationContracts(Type innerType) {
        EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
        if (innerType != null && getOrchestration() != null) {
            return getOrchestration().getInvocationContracts(innerType);
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
            for (InvocationContract innerInvocationContract : getInvocationContracts()) {
                if (mode == ContractMode.IN && (innerInvocationContract.getInvokedMode() == ContractMode.IN || innerInvocationContract.getInvokedMode() == ContractMode.IN_OUT)) {
                    invocationContracts.add(innerInvocationContract);
                } else if (mode == ContractMode.OUT && (innerInvocationContract.getInvokedMode() == ContractMode.OUT || innerInvocationContract.getInvokedMode() == ContractMode.IN_OUT)) {
                    invocationContracts.add(innerInvocationContract);
                } else if (mode == ContractMode.IN_OUT) {
                    invocationContracts.add(innerInvocationContract);
                }
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
        EList<InvocationContract> invocationContexts = new UniqueEList<InvocationContract>();
        for (InvocationContract innerInvocationContext : getInvocationContracts(type)) {
            if (mode == ContractMode.IN && (innerInvocationContext.getInvokedMode() == ContractMode.IN || innerInvocationContext.getInvokedMode() == ContractMode.IN_OUT)) {
                invocationContexts.add(innerInvocationContext);
            } else if (mode == ContractMode.OUT && (innerInvocationContext.getInvokedMode() == ContractMode.OUT || innerInvocationContext.getInvokedMode() == ContractMode.IN_OUT)) {
                invocationContexts.add(innerInvocationContext);
            } else if (mode == ContractMode.IN_OUT) {
                invocationContexts.add(innerInvocationContext);
            }
        }
        return invocationContexts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
                if (viewpointContainer != null)
                    msgs = ((InternalEObject) viewpointContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, null, msgs);
                return basicSetViewpointContainer((ViewpointContainer) otherEnd, msgs);
            case FcorePackage.FACTORY_COMPONENT__ORCHESTRATION:
                if (orchestration != null)
                    msgs = ((InternalEObject) orchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.FACTORY_COMPONENT__ORCHESTRATION, null, msgs);
                return basicSetOrchestration((Orchestration) otherEnd, msgs);
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
            case FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
                return basicSetViewpointContainer(null, msgs);
            case FcorePackage.FACTORY_COMPONENT__ORCHESTRATION:
                return basicSetOrchestration(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
                return getViewpointContainer();
            case FcorePackage.FACTORY_COMPONENT__ORCHESTRATION:
                return getOrchestration();
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
            case FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
                setViewpointContainer((ViewpointContainer) newValue);
                return;
            case FcorePackage.FACTORY_COMPONENT__ORCHESTRATION:
                setOrchestration((Orchestration) newValue);
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
            case FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
                setViewpointContainer((ViewpointContainer) null);
                return;
            case FcorePackage.FACTORY_COMPONENT__ORCHESTRATION:
                setOrchestration((Orchestration) null);
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
            case FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
                return viewpointContainer != null;
            case FcorePackage.FACTORY_COMPONENT__ORCHESTRATION:
                return orchestration != null;
        }
        return super.eIsSet(featureID);
    }

} // FactoryComponentImpl
