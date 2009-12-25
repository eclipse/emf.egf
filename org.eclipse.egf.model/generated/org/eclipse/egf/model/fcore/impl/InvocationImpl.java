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

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ContextContainer;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getOrchestration <em>Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getContextContainer <em>Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InvocationImpl<T extends Activity> extends ModelElementImpl implements Invocation<T> {
  /**
   * The cached value of the '{@link #getContextContainer() <em>Context Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContextContainer()
   * @generated
   * @ordered
   */
  protected ContextContainer contextContainer;

  /**
   * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivity()
   * @generated
   * @ordered
   */
  protected T activity;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvocationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.INVOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Orchestration getOrchestration() {
    if (eContainerFeatureID() != FcorePackage.INVOCATION__ORCHESTRATION)
      return null;
    return (Orchestration) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestration(Orchestration newOrchestration, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newOrchestration, FcorePackage.INVOCATION__ORCHESTRATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrchestration(Orchestration newOrchestration) {
    if (newOrchestration != eInternalContainer() || (eContainerFeatureID() != FcorePackage.INVOCATION__ORCHESTRATION && newOrchestration != null)) {
      if (EcoreUtil.isAncestor(this, newOrchestration))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOrchestration != null)
        msgs = ((InternalEObject) newOrchestration).eInverseAdd(this, FcorePackage.ORCHESTRATION__INVOCATIONS, Orchestration.class, msgs);
      msgs = basicSetOrchestration(newOrchestration, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__ORCHESTRATION, newOrchestration, newOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextContainer getContextContainer() {
    return contextContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContextContainer(ContextContainer newContextContainer, NotificationChain msgs) {
    ContextContainer oldContextContainer = contextContainer;
    contextContainer = newContextContainer;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__CONTEXT_CONTAINER, oldContextContainer, newContextContainer);
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
  public void setContextContainer(ContextContainer newContextContainer) {
    if (newContextContainer != contextContainer) {
      NotificationChain msgs = null;
      if (contextContainer != null)
        msgs = ((InternalEObject) contextContainer).eInverseRemove(this, FcorePackage.CONTEXT_CONTAINER__INVOCATION, ContextContainer.class, msgs);
      if (newContextContainer != null)
        msgs = ((InternalEObject) newContextContainer).eInverseAdd(this, FcorePackage.CONTEXT_CONTAINER__INVOCATION, ContextContainer.class, msgs);
      msgs = basicSetContextContainer(newContextContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__CONTEXT_CONTAINER, newContextContainer, newContextContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public T getActivity() {
    if (activity != null && activity.eIsProxy()) {
      InternalEObject oldActivity = (InternalEObject) activity;
      activity = (T) eResolveProxy(oldActivity);
      if (activity != oldActivity) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.INVOCATION__ACTIVITY, oldActivity, activity));
      }
    }
    return activity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public T basicGetActivity() {
    return activity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivity(T newActivity) {
    T oldActivity = activity;
    activity = newActivity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__ACTIVITY, oldActivity, activity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.INVOCATION__ORCHESTRATION:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetOrchestration((Orchestration) otherEnd, msgs);
    case FcorePackage.INVOCATION__CONTEXT_CONTAINER:
      if (contextContainer != null)
        msgs = ((InternalEObject) contextContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.INVOCATION__CONTEXT_CONTAINER, null, msgs);
      return basicSetContextContainer((ContextContainer) otherEnd, msgs);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return basicSetOrchestration(null, msgs);
    case FcorePackage.INVOCATION__CONTEXT_CONTAINER:
      return basicSetContextContainer(null, msgs);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return eInternalContainer().eInverseRemove(this, FcorePackage.ORCHESTRATION__INVOCATIONS, Orchestration.class, msgs);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return getOrchestration();
    case FcorePackage.INVOCATION__CONTEXT_CONTAINER:
      return getContextContainer();
    case FcorePackage.INVOCATION__ACTIVITY:
      if (resolve)
        return getActivity();
      return basicGetActivity();
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      setOrchestration((Orchestration) newValue);
      return;
    case FcorePackage.INVOCATION__CONTEXT_CONTAINER:
      setContextContainer((ContextContainer) newValue);
      return;
    case FcorePackage.INVOCATION__ACTIVITY:
      setActivity((T) newValue);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      setOrchestration((Orchestration) null);
      return;
    case FcorePackage.INVOCATION__CONTEXT_CONTAINER:
      setContextContainer((ContextContainer) null);
      return;
    case FcorePackage.INVOCATION__ACTIVITY:
      setActivity((T) null);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return getOrchestration() != null;
    case FcorePackage.INVOCATION__CONTEXT_CONTAINER:
      return contextContainer != null;
    case FcorePackage.INVOCATION__ACTIVITY:
      return activity != null;
    }
    return super.eIsSet(featureID);
  }

} // InvocationImpl
