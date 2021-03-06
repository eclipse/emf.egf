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
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Viewpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ViewpointImpl#getViewpointContainer <em>Viewpoint Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ViewpointImpl extends ModelElementImpl implements Viewpoint {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ViewpointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FcorePackage.Literals.VIEWPOINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ViewpointContainer getViewpointContainer() {
        if (eContainerFeatureID() != FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER)
            return null;
        return (ViewpointContainer) eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetViewpointContainer(ViewpointContainer newViewpointContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newViewpointContainer, FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setViewpointContainer(ViewpointContainer newViewpointContainer) {
        if (newViewpointContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER && newViewpointContainer != null)) {
            if (EcoreUtil.isAncestor(this, newViewpointContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newViewpointContainer != null)
                msgs = ((InternalEObject) newViewpointContainer).eInverseAdd(this, FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS, ViewpointContainer.class, msgs);
            msgs = basicSetViewpointContainer(newViewpointContainer, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER, newViewpointContainer, newViewpointContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetViewpointContainer((ViewpointContainer) otherEnd, msgs);
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
            case FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER:
                return basicSetViewpointContainer(null, msgs);
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
            case FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER:
                return eInternalContainer().eInverseRemove(this, FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS, ViewpointContainer.class, msgs);
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
            case FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER:
                return getViewpointContainer();
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
            case FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER:
                setViewpointContainer((ViewpointContainer) newValue);
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
            case FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER:
                setViewpointContainer((ViewpointContainer) null);
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
            case FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER:
                return getViewpointContainer() != null;
        }
        return super.eIsSet(featureID);
    }

} // ViewpointImpl
