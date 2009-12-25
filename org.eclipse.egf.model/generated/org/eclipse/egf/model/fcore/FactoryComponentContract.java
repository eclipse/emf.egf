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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory Component Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContexts <em>Invocation Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getActivityContractContainer <em>Activity Contract Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContract()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OutModeIsRestricted'"
 * @generated
 */
public interface FactoryComponentContract extends ActivityContract {
  /**
   * Returns the value of the '<em><b>Invocation Contexts</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContext}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContext#getFactoryComponentExposedContract <em>Factory Component Exposed Contract</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Contexts</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Contexts</em>' reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContract_InvocationContexts()
   * @see org.eclipse.egf.model.fcore.InvocationContext#getFactoryComponentExposedContract
   * @model opposite="factoryComponentExposedContract" resolveProxies="false" required="true"
   * @generated
   */
  EList<InvocationContext> getInvocationContexts();

  /**
   * Returns the value of the '<em><b>Activity Contract Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivityContracts <em>Activity Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Contract Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Contract Container</em>' container reference.
   * @see #setActivityContractContainer(FactoryComponentContractContainer)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContract_ActivityContractContainer()
   * @see org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivityContracts
   * @model opposite="activityContracts" required="true" transient="false"
   * @generated
   */
  FactoryComponentContractContainer getActivityContractContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getActivityContractContainer <em>Activity Contract Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Contract Container</em>' container reference.
   * @see #getActivityContractContainer()
   * @generated
   */
  void setActivityContractContainer(FactoryComponentContractContainer value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @model kind="operation" required="true"
   * @generated NOT
   */
  FactoryComponent getActivity();

} // FactoryComponentContract
