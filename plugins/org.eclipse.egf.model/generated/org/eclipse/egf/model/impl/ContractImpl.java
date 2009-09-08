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

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Contract</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.ContractImpl#getContractElements <em>Contract Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContractImpl extends AbstractViewpointImpl implements Contract {
  /**
   * The cached value of the '{@link #getContractElements() <em>Contract Elements</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @see #getContractElements()
   * @generated
   * @ordered
   */
  protected EList<ContractElement> contractElements;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ContractImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.CONTRACT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<ContractElement> getContractElements() {
    if (contractElements == null) {
      contractElements = new EObjectContainmentEList<ContractElement>(ContractElement.class, this, ModelPackage.CONTRACT__CONTRACT_ELEMENTS);
      // Get the fc container.
      FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(this);
      // Read contract elements.
      List<ContractElement> readContractElements = getFactoryComponentLoadingHelper().loadContract(getId(), fcContainer.getId());
      // If any, add them.
      if (!readContractElements.isEmpty()) {
        contractElements.addAll(readContractElements);
      }
    }
    return contractElements;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.CONTRACT__CONTRACT_ELEMENTS:
        return ((InternalEList<?>)getContractElements()).basicRemove(otherEnd, msgs);
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
      case ModelPackage.CONTRACT__CONTRACT_ELEMENTS:
        return getContractElements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.CONTRACT__CONTRACT_ELEMENTS:
        getContractElements().clear();
        getContractElements().addAll((Collection<? extends ContractElement>)newValue);
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
      case ModelPackage.CONTRACT__CONTRACT_ELEMENTS:
        getContractElements().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ModelPackage.CONTRACT__CONTRACT_ELEMENTS:
        return contractElements != null && !contractElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // ContractImpl
