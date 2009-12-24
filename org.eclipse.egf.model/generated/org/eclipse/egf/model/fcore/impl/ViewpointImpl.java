/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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
 * <li>
 * {@link org.eclipse.egf.model.fcore.impl.ViewpointImpl#getViewerpointContainer
 * <em>Viewerpoint Container</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ViewpointImpl extends ModelElementImpl implements Viewpoint {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ViewpointImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.VIEWPOINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public ViewpointContainer getViewerpointContainer() {
    if (eContainerFeatureID() != FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER)
      return null;
    return (ViewpointContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetViewerpointContainer(ViewpointContainer newViewerpointContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newViewerpointContainer, FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setViewerpointContainer(ViewpointContainer newViewerpointContainer) {
    if (newViewerpointContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER && newViewerpointContainer != null)) {
      if (EcoreUtil.isAncestor(this, newViewerpointContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newViewerpointContainer != null)
        msgs = ((InternalEObject) newViewerpointContainer).eInverseAdd(this, FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS, ViewpointContainer.class, msgs);
      msgs = basicSetViewerpointContainer(newViewerpointContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER, newViewerpointContainer, newViewerpointContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetViewerpointContainer((ViewpointContainer) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER:
      return basicSetViewerpointContainer(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.VIEWPOINT_CONTAINER__VIEWPOINTS, ViewpointContainer.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER:
      return getViewerpointContainer();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER:
      setViewerpointContainer((ViewpointContainer) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER:
      setViewerpointContainer((ViewpointContainer) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER:
      return getViewerpointContainer() != null;
    }
    return super.eIsSet(featureID);
  }

} // ViewpointImpl
