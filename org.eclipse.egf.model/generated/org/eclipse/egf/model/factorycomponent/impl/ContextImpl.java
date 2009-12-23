/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent.impl;

import java.util.Collection;

import org.eclipse.egf.model.factorycomponent.Context;
import org.eclipse.egf.model.factorycomponent.ContextValue;
import org.eclipse.egf.model.factorycomponent.ContractConnector;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;
import org.eclipse.egf.model.factorycomponent.Invocation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContextImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContextImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContextImpl#getConnectors <em>Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextImpl extends ModelElementImpl implements Context {
  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<ContextValue> values;

  /**
   * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectors()
   * @generated
   * @ordered
   */
  protected EList<ContractConnector> connectors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FactoryComponentPackage.Literals.CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invocation getInvocation() {
    if (eContainerFeatureID() != FactoryComponentPackage.CONTEXT__INVOCATION)
      return null;
    return (Invocation) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocation(Invocation newInvocation, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newInvocation, FactoryComponentPackage.CONTEXT__INVOCATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvocation(Invocation newInvocation) {
    if (newInvocation != eInternalContainer() || (eContainerFeatureID() != FactoryComponentPackage.CONTEXT__INVOCATION && newInvocation != null)) {
      if (EcoreUtil.isAncestor(this, newInvocation))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInvocation != null)
        msgs = ((InternalEObject) newInvocation).eInverseAdd(this, FactoryComponentPackage.INVOCATION__CONTEXT, Invocation.class, msgs);
      msgs = basicSetInvocation(newInvocation, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTEXT__INVOCATION, newInvocation, newInvocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContextValue> getValues() {
    if (values == null) {
      values = new EObjectContainmentEList<ContextValue>(ContextValue.class, this, FactoryComponentPackage.CONTEXT__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContractConnector> getConnectors() {
    if (connectors == null) {
      connectors = new EObjectContainmentWithInverseEList<ContractConnector>(ContractConnector.class, this, FactoryComponentPackage.CONTEXT__CONNECTORS, FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT);
    }
    return connectors;
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
    case FactoryComponentPackage.CONTEXT__INVOCATION:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetInvocation((Invocation) otherEnd, msgs);
    case FactoryComponentPackage.CONTEXT__CONNECTORS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getConnectors()).basicAdd(otherEnd, msgs);
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
    case FactoryComponentPackage.CONTEXT__INVOCATION:
      return basicSetInvocation(null, msgs);
    case FactoryComponentPackage.CONTEXT__VALUES:
      return ((InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
    case FactoryComponentPackage.CONTEXT__CONNECTORS:
      return ((InternalEList<?>) getConnectors()).basicRemove(otherEnd, msgs);
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
    case FactoryComponentPackage.CONTEXT__INVOCATION:
      return eInternalContainer().eInverseRemove(this, FactoryComponentPackage.INVOCATION__CONTEXT, Invocation.class, msgs);
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
    case FactoryComponentPackage.CONTEXT__INVOCATION:
      return getInvocation();
    case FactoryComponentPackage.CONTEXT__VALUES:
      return getValues();
    case FactoryComponentPackage.CONTEXT__CONNECTORS:
      return getConnectors();
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
    case FactoryComponentPackage.CONTEXT__INVOCATION:
      setInvocation((Invocation) newValue);
      return;
    case FactoryComponentPackage.CONTEXT__VALUES:
      getValues().clear();
      getValues().addAll((Collection<? extends ContextValue>) newValue);
      return;
    case FactoryComponentPackage.CONTEXT__CONNECTORS:
      getConnectors().clear();
      getConnectors().addAll((Collection<? extends ContractConnector>) newValue);
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
    case FactoryComponentPackage.CONTEXT__INVOCATION:
      setInvocation((Invocation) null);
      return;
    case FactoryComponentPackage.CONTEXT__VALUES:
      getValues().clear();
      return;
    case FactoryComponentPackage.CONTEXT__CONNECTORS:
      getConnectors().clear();
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
    case FactoryComponentPackage.CONTEXT__INVOCATION:
      return getInvocation() != null;
    case FactoryComponentPackage.CONTEXT__VALUES:
      return values != null && !values.isEmpty();
    case FactoryComponentPackage.CONTEXT__CONNECTORS:
      return connectors != null && !connectors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ContextImpl
