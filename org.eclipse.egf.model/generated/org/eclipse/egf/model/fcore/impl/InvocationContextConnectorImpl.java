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
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextConnector;
import org.eclipse.egf.model.fcore.InvocationContextContainer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Context Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextConnectorImpl#getInvocationContextContainer <em>Invocation Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextConnectorImpl#getSourceInvocationContext <em>Source Invocation Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextConnectorImpl#getTargetInvocationContext <em>Target Invocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationContextConnectorImpl extends ModelElementImpl implements InvocationContextConnector {
  /**
   * The cached value of the '{@link #getSourceInvocationContext() <em>Source Invocation Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceInvocationContext()
   * @generated
   * @ordered
   */
  protected InvocationContext sourceInvocationContext;

  /**
   * The cached value of the '{@link #getTargetInvocationContext() <em>Target Invocation Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetInvocationContext()
   * @generated
   * @ordered
   */
  protected InvocationContext targetInvocationContext;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvocationContextConnectorImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.INVOCATION_CONTEXT_CONNECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContextContainer getInvocationContextContainer() {
    if (eContainerFeatureID() != FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER)
      return null;
    return (InvocationContextContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocationContextContainer(InvocationContextContainer newInvocationContextContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newInvocationContextContainer, FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvocationContextContainer(InvocationContextContainer newInvocationContextContainer) {
    if (newInvocationContextContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER && newInvocationContextContainer != null)) {
      if (EcoreUtil.isAncestor(this, newInvocationContextContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInvocationContextContainer != null)
        msgs = ((InternalEObject) newInvocationContextContainer).eInverseAdd(this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS, InvocationContextContainer.class, msgs);
      msgs = basicSetInvocationContextContainer(newInvocationContextContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER, newInvocationContextContainer, newInvocationContextContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContext getSourceInvocationContext() {
    if (sourceInvocationContext != null && sourceInvocationContext.eIsProxy()) {
      InternalEObject oldSourceInvocationContext = (InternalEObject) sourceInvocationContext;
      sourceInvocationContext = (InvocationContext) eResolveProxy(oldSourceInvocationContext);
      if (sourceInvocationContext != oldSourceInvocationContext) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT, oldSourceInvocationContext, sourceInvocationContext));
      }
    }
    return sourceInvocationContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContext basicGetSourceInvocationContext() {
    return sourceInvocationContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceInvocationContext(InvocationContext newSourceInvocationContext) {
    InvocationContext oldSourceInvocationContext = sourceInvocationContext;
    sourceInvocationContext = newSourceInvocationContext;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT, oldSourceInvocationContext, sourceInvocationContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContext getTargetInvocationContext() {
    if (targetInvocationContext != null && targetInvocationContext.eIsProxy()) {
      InternalEObject oldTargetInvocationContext = (InternalEObject) targetInvocationContext;
      targetInvocationContext = (InvocationContext) eResolveProxy(oldTargetInvocationContext);
      if (targetInvocationContext != oldTargetInvocationContext) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT, oldTargetInvocationContext, targetInvocationContext));
      }
    }
    return targetInvocationContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContext basicGetTargetInvocationContext() {
    return targetInvocationContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetInvocationContext(InvocationContext newTargetInvocationContext) {
    InvocationContext oldTargetInvocationContext = targetInvocationContext;
    targetInvocationContext = newTargetInvocationContext;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT, oldTargetInvocationContext, targetInvocationContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetInvocationContextContainer((InvocationContextContainer) otherEnd, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER:
      return basicSetInvocationContextContainer(null, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS, InvocationContextContainer.class, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER:
      return getInvocationContextContainer();
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT:
      if (resolve)
        return getSourceInvocationContext();
      return basicGetSourceInvocationContext();
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT:
      if (resolve)
        return getTargetInvocationContext();
      return basicGetTargetInvocationContext();
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
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER:
      setInvocationContextContainer((InvocationContextContainer) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT:
      setSourceInvocationContext((InvocationContext) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT:
      setTargetInvocationContext((InvocationContext) newValue);
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
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER:
      setInvocationContextContainer((InvocationContextContainer) null);
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT:
      setSourceInvocationContext((InvocationContext) null);
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT:
      setTargetInvocationContext((InvocationContext) null);
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
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER:
      return getInvocationContextContainer() != null;
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT:
      return sourceInvocationContext != null;
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT:
      return targetInvocationContext != null;
    }
    return super.eIsSet(featureID);
  }

} //InvocationContextConnectorImpl
