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
package org.eclipse.egf.model.fcore;

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory Component Contract Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivityContracts <em>Activity Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContractContainer()
 * @model
 * @generated
 */
public interface FactoryComponentContractContainer extends ActivityContractContainer {

  /**
   * Returns the value of the '<em><b>Activity</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponent#getActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity</em>' container reference.
   * @see #setActivity(FactoryComponent)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContractContainer_Activity()
   * @see org.eclipse.egf.model.fcore.FactoryComponent#getActivityContractContainer
   * @model opposite="activityContractContainer" required="true" transient="false"
   * @generated
   */
  FactoryComponent getActivity();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivity <em>Activity</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity</em>' container reference.
   * @see #getActivity()
   * @generated
   */
  void setActivity(FactoryComponent value);

  /**
   * Returns the value of the '<em><b>Activity Contracts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.FactoryComponentContract}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Contracts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Contracts</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContractContainer_ActivityContracts()
   * @see org.eclipse.egf.model.fcore.FactoryComponentContract#getActivityContractContainer
   * @model opposite="activityContractContainer" containment="true" required="true"
   * @generated
   */
  @SuppressWarnings("unchecked")
  EList<FactoryComponentContract> getActivityContracts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<ActivityContract> getActivityContracts(Type type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<ActivityContract> getActivityContracts(ContractMode mode);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<ActivityContract> getActivityContracts(Type type, ContractMode mode);
} // FactoryComponentContractContainer
