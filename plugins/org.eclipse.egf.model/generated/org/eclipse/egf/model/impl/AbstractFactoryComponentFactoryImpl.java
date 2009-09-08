/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model.impl;

import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract FactoryComponent Factory</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.AbstractFactoryComponentFactoryImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.AbstractFactoryComponentFactoryImpl#getContextId <em>Context Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractFactoryComponentFactoryImpl extends NamedModelElementWithIdImpl implements AbstractFactoryComponentFactory {
  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected Context context;

  /**
   * The default value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContextId()
   * @generated
   * @ordered
   */
  protected static final String CONTEXT_ID_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContextId()
   * @generated
   * @ordered
   */
  protected String contextId = CONTEXT_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected AbstractFactoryComponentFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.ABSTRACT_FACTORY_COMPONENT_FACTORY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public Context getContext() {
    // If null, try loading the contract from the extension registry.
    if (null == context) {
      // If the context id is not null, try loading related context.
      if (null != contextId) {
        FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(this);
        setContext(getFactoryComponentLoadingHelper().loadContext(contextId, fcContainer.getId()));
      }
    }
    return context;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContext(Context newContext, NotificationChain msgs) {
    Context oldContext = context;
    context = newContext;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT, oldContext, newContext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setContext(Context newContext) {
    if (newContext != context) {
      NotificationChain msgs = null;
      if (context != null)
        msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT, null, msgs);
      if (newContext != null)
        msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT, null, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getContextId() {
    return contextId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setContextId(String newContextId) {
    String oldContextId = contextId;
    contextId = newContextId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID, oldContextId, contextId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
        return basicSetContext(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
        return getContext();
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID:
        return getContextId();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
        setContext((Context)newValue);
        return;
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID:
        setContextId((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
        setContext((Context)null);
        return;
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID:
        setContextId(CONTEXT_ID_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      // Due to our own persistence mechanism, eIsSet for ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT feature is based on
      // ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID.
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID:
        return CONTEXT_ID_EDEFAULT == null ? contextId != null : !CONTEXT_ID_EDEFAULT.equals(contextId);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (contextId: "); //$NON-NLS-1$
    result.append(contextId);
    result.append(')');
    return result.toString();
  }

} // AbstractFactoryComponentFactoryImpl
