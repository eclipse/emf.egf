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

import java.util.Collection;

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orchestration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl#getFactoryComponent <em>Factory Component</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl#getOrchestrationContextContainer <em>Orchestration Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl#getInvocations <em>Invocations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OrchestrationImpl extends ModelElementImpl implements Orchestration {
  /**
   * The cached value of the '{@link #getOrchestrationContextContainer() <em>Orchestration Context Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrchestrationContextContainer()
   * @generated
   * @ordered
   */
  protected OrchestrationContextContainer orchestrationContextContainer;

  /**
   * The cached value of the '{@link #getInvocations() <em>Invocations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocations()
   * @generated
   * @ordered
   */
  protected EList<Invocation<?>> invocations;

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
  public EList<Invocation<?>> getInvocations() {
    if (invocations == null) {
      invocations = new EObjectContainmentWithInverseEList<Invocation<?>>(Invocation.class, this, FcorePackage.ORCHESTRATION__INVOCATIONS, FcorePackage.INVOCATION__ORCHESTRATION);
    }
    return invocations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrchestrationContextContainer getOrchestrationContextContainer() {
    return orchestrationContextContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestrationContextContainer(OrchestrationContextContainer newOrchestrationContextContainer, NotificationChain msgs) {
    OrchestrationContextContainer oldOrchestrationContextContainer = orchestrationContextContainer;
    orchestrationContextContainer = newOrchestrationContextContainer;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER, oldOrchestrationContextContainer, newOrchestrationContextContainer);
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
  public void setOrchestrationContextContainer(OrchestrationContextContainer newOrchestrationContextContainer) {
    if (newOrchestrationContextContainer != orchestrationContextContainer) {
      NotificationChain msgs = null;
      if (orchestrationContextContainer != null)
        msgs = ((InternalEObject) orchestrationContextContainer).eInverseRemove(this, FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION, OrchestrationContextContainer.class, msgs);
      if (newOrchestrationContextContainer != null)
        msgs = ((InternalEObject) newOrchestrationContextContainer).eInverseAdd(this, FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION, OrchestrationContextContainer.class, msgs);
      msgs = basicSetOrchestrationContextContainer(newOrchestrationContextContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER, newOrchestrationContextContainer, newOrchestrationContextContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContext> getInvocationContexts() {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (getInvocations() != null) {
      for (Invocation<?> invocation : getInvocations()) {
        invocationContexts.addAll(invocation.getInvocationContexts());
      }
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @SuppressWarnings("unchecked")
  public EList<InvocationContext> getInvocationContexts(Type type) {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (type != null) {
      for (InvocationContext innerInvocationContext : getInvocationContexts()) {
        if (innerInvocationContext.getActivityContract() != null && innerInvocationContext.getActivityContract().getType() != null && ClassHelper.asSubClass(type.getType(), innerInvocationContext.getActivityContract().getType().getType())) {
          invocationContexts.add(innerInvocationContext);
        }
      }
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContext> getInvocationContexts(ContractMode mode) {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (mode != null) {
      for (InvocationContext innerInvocationContext : getInvocationContexts()) {
        if (mode == ContractMode.IN && (innerInvocationContext.getMode() == ContractMode.IN || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
          invocationContexts.add(innerInvocationContext);
        } else if (mode == ContractMode.OUT && (innerInvocationContext.getMode() == ContractMode.OUT || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
          invocationContexts.add(innerInvocationContext);
        } else if (mode == ContractMode.IN_OUT) {
          invocationContexts.add(innerInvocationContext);
        }
      }
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @SuppressWarnings("unchecked")
  public EList<InvocationContext> getInvocationContexts(Type type, ContractMode mode) {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    for (InvocationContext innerInvocationContext : getInvocationContexts(type)) {
      if (mode == ContractMode.IN && (innerInvocationContext.getMode() == ContractMode.IN || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
        invocationContexts.add(innerInvocationContext);
      } else if (mode == ContractMode.OUT && (innerInvocationContext.getMode() == ContractMode.OUT || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
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
   * 
   * @generated NOT
   */
  public EList<OrchestrationContext> getOrchestrationContexts() {
    EList<OrchestrationContext> orchestrationContexts = new UniqueEList<OrchestrationContext>();
    if (getOrchestrationContextContainer() != null) {
      return getOrchestrationContextContainer().getOrchestrationContexts();
    }
    return orchestrationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<OrchestrationContext> getOrchestrationContexts(Type<?> type) {
    EList<OrchestrationContext> invocationContexts = new UniqueEList<OrchestrationContext>();
    for (OrchestrationContext innerOrchestrationContext : getOrchestrationContexts()) {
      if (innerOrchestrationContext.getType() != null && ClassHelper.asSubClass(type.getType(), innerOrchestrationContext.getType().getType())) {
        invocationContexts.add(innerOrchestrationContext);
      }
    }
    return invocationContexts;
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetFactoryComponent((FactoryComponent) otherEnd, msgs);
    case FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER:
      if (orchestrationContextContainer != null)
        msgs = ((InternalEObject) orchestrationContextContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER, null, msgs);
      return basicSetOrchestrationContextContainer((OrchestrationContextContainer) otherEnd, msgs);
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocations()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER:
      return basicSetOrchestrationContextContainer(null, msgs);
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return ((InternalEList<?>) getInvocations()).basicRemove(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER:
      return getOrchestrationContextContainer();
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return getInvocations();
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      setFactoryComponent((FactoryComponent) newValue);
      return;
    case FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER:
      setOrchestrationContextContainer((OrchestrationContextContainer) newValue);
      return;
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      getInvocations().clear();
      getInvocations().addAll((Collection<? extends Invocation<?>>) newValue);
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
    case FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER:
      setOrchestrationContextContainer((OrchestrationContextContainer) null);
      return;
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      getInvocations().clear();
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
    case FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER:
      return orchestrationContextContainer != null;
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return invocations != null && !invocations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // OrchestrationImpl
