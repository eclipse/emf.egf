/**
 * <copyright>
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
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent.impl;

import org.eclipse.egf.model.factorycomponent.FactoryComponent;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;
import org.eclipse.egf.model.factorycomponent.Orchestration;
import org.eclipse.egf.model.factorycomponent.ViewpointContainer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factory Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl#getViewpointContainer <em>Viewpoint Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl#getOrchestration <em>Orchestration</em>}</li>
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
    return FactoryComponentPackage.Literals.FACTORY_COMPONENT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, oldViewpointContainer, newViewpointContainer);
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
        msgs = ((InternalEObject) viewpointContainer).eInverseRemove(this, FactoryComponentPackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT, ViewpointContainer.class, msgs);
      if (newViewpointContainer != null)
        msgs = ((InternalEObject) newViewpointContainer).eInverseAdd(this, FactoryComponentPackage.VIEWPOINT_CONTAINER__FACTORY_COMPONENT, ViewpointContainer.class, msgs);
      msgs = basicSetViewpointContainer(newViewpointContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, newViewpointContainer, newViewpointContainer));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION, oldOrchestration, newOrchestration);
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
        msgs = ((InternalEObject) orchestration).eInverseRemove(this, FactoryComponentPackage.ORCHESTRATION__FACTORY_COMPONENT, Orchestration.class, msgs);
      if (newOrchestration != null)
        msgs = ((InternalEObject) newOrchestration).eInverseAdd(this, FactoryComponentPackage.ORCHESTRATION__FACTORY_COMPONENT, Orchestration.class, msgs);
      msgs = basicSetOrchestration(newOrchestration, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION, newOrchestration, newOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
      if (viewpointContainer != null)
        msgs = ((InternalEObject) viewpointContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, null, msgs);
      return basicSetViewpointContainer((ViewpointContainer) otherEnd, msgs);
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
      if (orchestration != null)
        msgs = ((InternalEObject) orchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION, null, msgs);
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
      return basicSetViewpointContainer(null, msgs);
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
      return getViewpointContainer();
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
      setViewpointContainer((ViewpointContainer) newValue);
      return;
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
      setViewpointContainer((ViewpointContainer) null);
      return;
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINT_CONTAINER:
      return viewpointContainer != null;
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
      return orchestration != null;
    }
    return super.eIsSet(featureID);
  }

} //FactoryComponentImpl
