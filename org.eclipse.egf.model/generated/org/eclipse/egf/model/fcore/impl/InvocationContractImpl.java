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

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.adapter.InvocationContractAdapter;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getInvocationContractContainer <em>Invocation Contract Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getFactoryComponentContract <em>Factory Component Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getOrchestrationParameter <em>Orchestration Parameter</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getSourceInvocationContract <em>Source Invocation Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getTargetInvocationContract <em>Target Invocation Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getInvokedContract <em>Invoked Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getInvokedMode <em>Invoked Mode</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationContractImpl extends ModelElementImpl implements InvocationContract {
  /**
   * The cached value of the '{@link #getFactoryComponentContract() <em>Factory Component Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryComponentContract()
   * @generated
   * @ordered
   */
  protected FactoryComponentContract factoryComponentContract;

  /**
   * The cached value of the '{@link #getOrchestrationParameter() <em>Orchestration Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrchestrationParameter()
   * @generated
   * @ordered
   */
  protected OrchestrationParameter orchestrationParameter;

  /**
   * The cached value of the '{@link #getSourceInvocationContract() <em>Source Invocation Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceInvocationContract()
   * @generated
   * @ordered
   */
  protected InvocationContract sourceInvocationContract;

  /**
   * The cached value of the '{@link #getTargetInvocationContract() <em>Target Invocation Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetInvocationContract()
   * @generated
   * @ordered
   */
  protected InvocationContract targetInvocationContract;

  /**
   * The cached value of the '{@link #getInvokedContract() <em>Invoked Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvokedContract()
   * @generated
   * @ordered
   */
  protected Contract invokedContract;

  /**
   * The default value of the '{@link #getInvokedMode() <em>Invoked Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvokedMode()
   * @generated
   * @ordered
   */
  protected static final ContractMode INVOKED_MODE_EDEFAULT = ContractMode.IN;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected InvocationContractImpl() {
    super();
    new InvocationContractAdapter(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.INVOCATION_CONTRACT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContractContainer getInvocationContractContainer() {
    if (eContainerFeatureID() != FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER)
      return null;
    return (InvocationContractContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocationContractContainer(InvocationContractContainer newInvocationContractContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newInvocationContractContainer, FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvocationContractContainer(InvocationContractContainer newInvocationContractContainer) {
    if (newInvocationContractContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER && newInvocationContractContainer != null)) {
      if (EcoreUtil.isAncestor(this, newInvocationContractContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInvocationContractContainer != null)
        msgs = ((InternalEObject) newInvocationContractContainer).eInverseAdd(this, FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS, InvocationContractContainer.class, msgs);
      msgs = basicSetInvocationContractContainer(newInvocationContractContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER, newInvocationContractContainer, newInvocationContractContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentContract getFactoryComponentContract() {
    return factoryComponentContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFactoryComponentContract(FactoryComponentContract newFactoryComponentContract, NotificationChain msgs) {
    FactoryComponentContract oldFactoryComponentContract = factoryComponentContract;
    factoryComponentContract = newFactoryComponentContract;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT, oldFactoryComponentContract, newFactoryComponentContract);
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
  public void setFactoryComponentContract(FactoryComponentContract newFactoryComponentContract) {
    if (newFactoryComponentContract != factoryComponentContract) {
      NotificationChain msgs = null;
      if (factoryComponentContract != null)
        msgs = ((InternalEObject) factoryComponentContract).eInverseRemove(this, FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS, FactoryComponentContract.class, msgs);
      if (newFactoryComponentContract != null)
        msgs = ((InternalEObject) newFactoryComponentContract).eInverseAdd(this, FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS, FactoryComponentContract.class, msgs);
      msgs = basicSetFactoryComponentContract(newFactoryComponentContract, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT, newFactoryComponentContract, newFactoryComponentContract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrchestrationParameter getOrchestrationParameter() {
    return orchestrationParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestrationParameter(OrchestrationParameter newOrchestrationParameter, NotificationChain msgs) {
    OrchestrationParameter oldOrchestrationParameter = orchestrationParameter;
    orchestrationParameter = newOrchestrationParameter;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER, oldOrchestrationParameter, newOrchestrationParameter);
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
  public void setOrchestrationParameter(OrchestrationParameter newOrchestrationParameter) {
    if (newOrchestrationParameter != orchestrationParameter) {
      NotificationChain msgs = null;
      if (orchestrationParameter != null)
        msgs = ((InternalEObject) orchestrationParameter).eInverseRemove(this, FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS, OrchestrationParameter.class, msgs);
      if (newOrchestrationParameter != null)
        msgs = ((InternalEObject) newOrchestrationParameter).eInverseAdd(this, FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS, OrchestrationParameter.class, msgs);
      msgs = basicSetOrchestrationParameter(newOrchestrationParameter, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER, newOrchestrationParameter, newOrchestrationParameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContract getSourceInvocationContract() {
    return sourceInvocationContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceInvocationContract(InvocationContract newSourceInvocationContract) {
    InvocationContract oldSourceInvocationContract = sourceInvocationContract;
    sourceInvocationContract = newSourceInvocationContract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, oldSourceInvocationContract, sourceInvocationContract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContract getTargetInvocationContract() {
    return targetInvocationContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetInvocationContract(InvocationContract newTargetInvocationContract) {
    InvocationContract oldTargetInvocationContract = targetInvocationContract;
    targetInvocationContract = newTargetInvocationContract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT, oldTargetInvocationContract, targetInvocationContract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract getInvokedContract() {
    if (invokedContract != null && invokedContract.eIsProxy()) {
      InternalEObject oldInvokedContract = (InternalEObject) invokedContract;
      invokedContract = (Contract) eResolveProxy(oldInvokedContract);
      if (invokedContract != oldInvokedContract) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT, oldInvokedContract, invokedContract));
      }
    }
    return invokedContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract basicGetInvokedContract() {
    return invokedContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvokedContract(Contract newInvokedContract) {
    Contract oldInvokedContract = invokedContract;
    invokedContract = newInvokedContract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT, oldInvokedContract, invokedContract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public ContractMode getInvokedMode() {
    if (getInvokedContract() != null) {
      return getInvokedContract().getMode();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean isSetInvokedMode() {
    if (getInvokedContract() != null && getInvokedContract().getMode() != null) {
      return true;
    }
    return false;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__TYPE, oldType, newType);
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
  public void setType(Type newType) {
    if (newType != type) {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.INVOCATION_CONTRACT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FcorePackage.INVOCATION_CONTRACT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTRACT__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public FactoryComponent getFactoryComponent() {
    if (getInvocationContractContainer() != null) {
      return getInvocationContractContainer().getFactoryComponent();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Invocation getInvocation() {
    if (getInvocationContractContainer() != null) {
      return getInvocationContractContainer().getInvocation();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetInvocationContractContainer((InvocationContractContainer) otherEnd, msgs);
    case FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT:
      if (factoryComponentContract != null)
        msgs = ((InternalEObject) factoryComponentContract).eInverseRemove(this, FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS, FactoryComponentContract.class, msgs);
      return basicSetFactoryComponentContract((FactoryComponentContract) otherEnd, msgs);
    case FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER:
      if (orchestrationParameter != null)
        msgs = ((InternalEObject) orchestrationParameter).eInverseRemove(this, FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS, OrchestrationParameter.class, msgs);
      return basicSetOrchestrationParameter((OrchestrationParameter) otherEnd, msgs);
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
    case FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER:
      return basicSetInvocationContractContainer(null, msgs);
    case FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT:
      return basicSetFactoryComponentContract(null, msgs);
    case FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER:
      return basicSetOrchestrationParameter(null, msgs);
    case FcorePackage.INVOCATION_CONTRACT__TYPE:
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
    case FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS, InvocationContractContainer.class, msgs);
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
    case FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER:
      return getInvocationContractContainer();
    case FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT:
      return getFactoryComponentContract();
    case FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER:
      return getOrchestrationParameter();
    case FcorePackage.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT:
      return getSourceInvocationContract();
    case FcorePackage.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT:
      return getTargetInvocationContract();
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT:
      if (resolve)
        return getInvokedContract();
      return basicGetInvokedContract();
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_MODE:
      return getInvokedMode();
    case FcorePackage.INVOCATION_CONTRACT__TYPE:
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
    case FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER:
      setInvocationContractContainer((InvocationContractContainer) newValue);
      return;
    case FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT:
      setFactoryComponentContract((FactoryComponentContract) newValue);
      return;
    case FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER:
      setOrchestrationParameter((OrchestrationParameter) newValue);
      return;
    case FcorePackage.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT:
      setSourceInvocationContract((InvocationContract) newValue);
      return;
    case FcorePackage.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT:
      setTargetInvocationContract((InvocationContract) newValue);
      return;
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT:
      setInvokedContract((Contract) newValue);
      return;
    case FcorePackage.INVOCATION_CONTRACT__TYPE:
      setType((Type) newValue);
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
    case FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER:
      setInvocationContractContainer((InvocationContractContainer) null);
      return;
    case FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT:
      setFactoryComponentContract((FactoryComponentContract) null);
      return;
    case FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER:
      setOrchestrationParameter((OrchestrationParameter) null);
      return;
    case FcorePackage.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT:
      setSourceInvocationContract((InvocationContract) null);
      return;
    case FcorePackage.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT:
      setTargetInvocationContract((InvocationContract) null);
      return;
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT:
      setInvokedContract((Contract) null);
      return;
    case FcorePackage.INVOCATION_CONTRACT__TYPE:
      setType((Type) null);
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
    case FcorePackage.INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER:
      return getInvocationContractContainer() != null;
    case FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT:
      return factoryComponentContract != null;
    case FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER:
      return orchestrationParameter != null;
    case FcorePackage.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT:
      return sourceInvocationContract != null;
    case FcorePackage.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT:
      return targetInvocationContract != null;
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT:
      return invokedContract != null;
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_MODE:
      return isSetInvokedMode();
    case FcorePackage.INVOCATION_CONTRACT__TYPE:
      return type != null;
    }
    return super.eIsSet(featureID);
  }

} // InvocationContractImpl
