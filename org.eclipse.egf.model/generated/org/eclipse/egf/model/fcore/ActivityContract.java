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
 * A representation of the model object '<em><b>Activity Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.ActivityContract#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ActivityContract#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ActivityContract#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getActivityContract()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MandatoryName UniqueName'"
 * @generated
 */
public interface ActivityContract extends ModelElement {
  /**
   * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mandatory</em>' attribute.
   * @see #setMandatory(boolean)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getActivityContract_Mandatory()
   * @model
   * @generated
   */
  boolean isMandatory();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ActivityContract#isMandatory <em>Mandatory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mandatory</em>' attribute.
   * @see #isMandatory()
   * @generated
   */
  void setMandatory(boolean value);

  /**
   * Returns the value of the '<em><b>Mode</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.egf.model.fcore.ContractMode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' attribute.
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @see #setMode(ContractMode)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getActivityContract_Mode()
   * @model
   * @generated
   */
  ContractMode getMode();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ActivityContract#getMode <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mode</em>' attribute.
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @see #getMode()
   * @generated
   */
  void setMode(ContractMode value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getActivityContract_Type()
   * @model containment="true" required="true"
   * @generated
   */
  Type<?> getType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ActivityContract#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type<?> value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  Activity getActivity();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  ActivityContractContainer getActivityContractContainer();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  <T extends ActivityContract> EList<ActivityContract> getActivityContracts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  EList<ActivityContract> getActivityContracts(Type<?> type);

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
  EList<ActivityContract> getActivityContracts(Type<?> type, ContractMode mode);

} // ActivityContract
