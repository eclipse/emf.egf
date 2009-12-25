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

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.Type;
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
 * An implementation of the model object '<em><b>Invocation Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextImpl#getInvocationContextContainer <em>Invocation Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextImpl#getExposedContract <em>Exposed Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextImpl#getOrchestrationContext <em>Orchestration Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextImpl#getActivityContract <em>Activity Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationContextImpl extends ModelElementImpl implements InvocationContext {
  /**
   * The cached value of the '{@link #getExposedContract() <em>Exposed Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExposedContract()
   * @generated
   * @ordered
   */
  protected Contract exposedContract;

  /**
   * The cached value of the '{@link #getOrchestrationContext() <em>Orchestration Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrchestrationContext()
   * @generated
   * @ordered
   */
  protected OrchestrationContext orchestrationContext;

  /**
   * The cached value of the '{@link #getActivityContract() <em>Activity Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivityContract()
   * @generated
   * @ordered
   */
  protected Contract activityContract;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type<?> type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvocationContextImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.INVOCATION_CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContextContainer getInvocationContextContainer() {
    if (eContainerFeatureID() != FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER)
      return null;
    return (InvocationContextContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocationContextContainer(InvocationContextContainer newInvocationContextContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newInvocationContextContainer, FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvocationContextContainer(InvocationContextContainer newInvocationContextContainer) {
    if (newInvocationContextContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER && newInvocationContextContainer != null)) {
      if (EcoreUtil.isAncestor(this, newInvocationContextContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInvocationContextContainer != null)
        msgs = ((InternalEObject) newInvocationContextContainer).eInverseAdd(this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS, InvocationContextContainer.class, msgs);
      msgs = basicSetInvocationContextContainer(newInvocationContextContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER, newInvocationContextContainer, newInvocationContextContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract getExposedContract() {
    return exposedContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExposedContract(Contract newExposedContract, NotificationChain msgs) {
    Contract oldExposedContract = exposedContract;
    exposedContract = newExposedContract;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT, oldExposedContract, newExposedContract);
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
  public void setExposedContract(Contract newExposedContract) {
    if (newExposedContract != exposedContract) {
      NotificationChain msgs = null;
      if (exposedContract != null)
        msgs = ((InternalEObject) exposedContract).eInverseRemove(this, FcorePackage.CONTRACT__INVOCATION_CONTEXTS, Contract.class, msgs);
      if (newExposedContract != null)
        msgs = ((InternalEObject) newExposedContract).eInverseAdd(this, FcorePackage.CONTRACT__INVOCATION_CONTEXTS, Contract.class, msgs);
      msgs = basicSetExposedContract(newExposedContract, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT, newExposedContract, newExposedContract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrchestrationContext getOrchestrationContext() {
    return orchestrationContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestrationContext(OrchestrationContext newOrchestrationContext, NotificationChain msgs) {
    OrchestrationContext oldOrchestrationContext = orchestrationContext;
    orchestrationContext = newOrchestrationContext;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT, oldOrchestrationContext, newOrchestrationContext);
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
  public void setOrchestrationContext(OrchestrationContext newOrchestrationContext) {
    if (newOrchestrationContext != orchestrationContext) {
      NotificationChain msgs = null;
      if (orchestrationContext != null)
        msgs = ((InternalEObject) orchestrationContext).eInverseRemove(this, FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS, OrchestrationContext.class, msgs);
      if (newOrchestrationContext != null)
        msgs = ((InternalEObject) newOrchestrationContext).eInverseAdd(this, FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS, OrchestrationContext.class, msgs);
      msgs = basicSetOrchestrationContext(newOrchestrationContext, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT, newOrchestrationContext, newOrchestrationContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract getActivityContract() {
    if (activityContract != null && activityContract.eIsProxy()) {
      InternalEObject oldActivityContract = (InternalEObject) activityContract;
      activityContract = (Contract) eResolveProxy(oldActivityContract);
      if (activityContract != oldActivityContract) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.INVOCATION_CONTEXT__ACTIVITY_CONTRACT, oldActivityContract, activityContract));
      }
    }
    return activityContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract basicGetActivityContract() {
    return activityContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivityContract(Contract newActivityContract) {
    Contract oldActivityContract = activityContract;
    activityContract = newActivityContract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__ACTIVITY_CONTRACT, oldActivityContract, activityContract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type<?> getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(Type<?> newType, NotificationChain msgs) {
    Type<?> oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__TYPE, oldType, newType);
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
  public void setType(Type<?> newType) {
    if (newType != type) {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.INVOCATION_CONTEXT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FcorePackage.INVOCATION_CONTEXT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public FactoryComponent getFactoryComponent() {
    if (getInvocation() != null) {
      return getInvocation().getFactoryComponent();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Invocation<?> getInvocation() {
    if (getInvocationContextContainer() != null) {
      return getInvocationContextContainer().getInvocation();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContext> getInvocationContexts() {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (getInvocationContextContainer() != null && getInvocationContextContainer().getInvocationContexts() != null) {
      invocationContexts.addAll(getInvocationContextContainer().getInvocationContexts());
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContext> getInvocationContexts(Type<?> innerType) {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (innerType != null) {
      for (InvocationContext innerInvocationContext : getInvocationContexts()) {
        if (innerInvocationContext.getType() != null && ClassHelper.asSubClass(innerType.getType(), innerInvocationContext.getType().getType())) {
          invocationContexts.add(innerInvocationContext);
        }
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
    case FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetInvocationContextContainer((InvocationContextContainer) otherEnd, msgs);
    case FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT:
      if (exposedContract != null)
        msgs = ((InternalEObject) exposedContract).eInverseRemove(this, FcorePackage.CONTRACT__INVOCATION_CONTEXTS, Contract.class, msgs);
      return basicSetExposedContract((Contract) otherEnd, msgs);
    case FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT:
      if (orchestrationContext != null)
        msgs = ((InternalEObject) orchestrationContext).eInverseRemove(this, FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS, OrchestrationContext.class, msgs);
      return basicSetOrchestrationContext((OrchestrationContext) otherEnd, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER:
      return basicSetInvocationContextContainer(null, msgs);
    case FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT:
      return basicSetExposedContract(null, msgs);
    case FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT:
      return basicSetOrchestrationContext(null, msgs);
    case FcorePackage.INVOCATION_CONTEXT__TYPE:
      return basicSetType(null, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS, InvocationContextContainer.class, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER:
      return getInvocationContextContainer();
    case FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT:
      return getExposedContract();
    case FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT:
      return getOrchestrationContext();
    case FcorePackage.INVOCATION_CONTEXT__ACTIVITY_CONTRACT:
      if (resolve)
        return getActivityContract();
      return basicGetActivityContract();
    case FcorePackage.INVOCATION_CONTEXT__TYPE:
      return getType();
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
    case FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER:
      setInvocationContextContainer((InvocationContextContainer) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT:
      setExposedContract((Contract) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT:
      setOrchestrationContext((OrchestrationContext) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT__ACTIVITY_CONTRACT:
      setActivityContract((Contract) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT__TYPE:
      setType((Type<?>) newValue);
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
    case FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER:
      setInvocationContextContainer((InvocationContextContainer) null);
      return;
    case FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT:
      setExposedContract((Contract) null);
      return;
    case FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT:
      setOrchestrationContext((OrchestrationContext) null);
      return;
    case FcorePackage.INVOCATION_CONTEXT__ACTIVITY_CONTRACT:
      setActivityContract((Contract) null);
      return;
    case FcorePackage.INVOCATION_CONTEXT__TYPE:
      setType((Type<?>) null);
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
    case FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER:
      return getInvocationContextContainer() != null;
    case FcorePackage.INVOCATION_CONTEXT__EXPOSED_CONTRACT:
      return exposedContract != null;
    case FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT:
      return orchestrationContext != null;
    case FcorePackage.INVOCATION_CONTEXT__ACTIVITY_CONTRACT:
      return activityContract != null;
    case FcorePackage.INVOCATION_CONTEXT__TYPE:
      return type != null;
    }
    return super.eIsSet(featureID);
  }

} // InvocationContextImpl
