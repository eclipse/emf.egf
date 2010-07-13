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

import java.util.Collection;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Viewpoint Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl#getFactoryComponent <em>Factory Component</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl#getViewpoints <em>Viewpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewpointContainerImpl extends ModelElementImpl implements ViewpointContainer {
    /**
     * The cached value of the '{@link #getViewpoints() <em>Viewpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getViewpoints()
     * @generated
     * @ordered
     */
    protected EList<Viewpoint> viewpoints;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ViewpointContainerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FcorePackage.Literals.VIEWPOINT_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FactoryComponent getFactoryComponent() {
        if (eContainerFeatureID() != FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT)
            return null;
        return (FactoryComponent) eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFactoryComponent(FactoryComponent newFactoryComponent, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newFactoryComponent, FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFactoryComponent(FactoryComponent newFactoryComponent) {
        if (newFactoryComponent != eInternalContainer() || (eContainerFeatureID() != FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT && newFactoryComponent != null)) {
            if (EcoreUtil.isAncestor(this, newFactoryComponent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFactoryComponent != null)
                msgs = ((InternalEObject) newFactoryComponent).eInverseAdd(this, FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, FactoryComponent.class, msgs);
            msgs = basicSetFactoryComponent(newFactoryComponent, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT, newFactoryComponent, newFactoryComponent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Viewpoint> getViewpoints() {
        if (viewpoints == null) {
            viewpoints = new EObjectContainmentWithInverseEList<Viewpoint>(Viewpoint.class, this, FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS, FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER);
        }
        return viewpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Viewpoint getViewpoint(Class<?> clazz) {
        for (Viewpoint viewpoint : getViewpoints()) {
            if (clazz.isInstance(viewpoint)) {
                return viewpoint;
            }
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetFactoryComponent((FactoryComponent) otherEnd, msgs);
        case FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getViewpoints()).basicAdd(otherEnd, msgs);
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
        case FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT:
            return basicSetFactoryComponent(null, msgs);
        case FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS:
            return ((InternalEList<?>) getViewpoints()).basicRemove(otherEnd, msgs);
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
        case FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT:
            return eInternalContainer().eInverseRemove(this, FcorePackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, FactoryComponent.class, msgs);
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
        case FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT:
            return getFactoryComponent();
        case FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS:
            return getViewpoints();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT:
            setFactoryComponent((FactoryComponent) newValue);
            return;
        case FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS:
            getViewpoints().clear();
            getViewpoints().addAll((Collection<? extends Viewpoint>) newValue);
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
        case FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT:
            setFactoryComponent((FactoryComponent) null);
            return;
        case FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS:
            getViewpoints().clear();
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
        case FcorePackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT:
            return getFactoryComponent() != null;
        case FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS:
            return viewpoints != null && !viewpoints.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ViewpointContainerImpl
