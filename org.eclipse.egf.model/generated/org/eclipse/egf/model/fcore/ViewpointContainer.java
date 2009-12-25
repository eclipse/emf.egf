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
 * A representation of the model object '<em><b>Viewpoint Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.ViewpointContainer#getFactoryComponent <em>Factory Component</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ViewpointContainer#getViewpoints <em>Viewpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getViewpointContainer()
 * @model
 * @generated
 */
public interface ViewpointContainer extends ModelElement {
  /**
   * Returns the value of the '<em><b>Factory Component</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponent#getViewpointContainer <em>Viewpoint Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory Component</em>' container reference
   * isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Component</em>' container reference.
   * @see #setFactoryComponent(FactoryComponent)
   * @see org.eclipse.egf.model.fcore.FcorePackage#getViewpointContainer_FactoryComponent()
   * @see org.eclipse.egf.model.fcore.FactoryComponent#getViewpointContainer
   * @model opposite="viewpointContainer" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  FactoryComponent getFactoryComponent();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fcore.ViewpointContainer#getFactoryComponent <em>Factory Component</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Factory Component</em>' container reference.
   * @see #getFactoryComponent()
   * @generated
   */
  void setFactoryComponent(FactoryComponent value);

  /**
   * Returns the value of the '<em><b>Viewpoints</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fcore.Viewpoint}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Viewpoint#getViewerpointContainer <em>Viewerpoint Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Viewpoints</em>' containment reference list
   * isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Viewpoints</em>' containment reference list.
   * @see org.eclipse.egf.model.fcore.FcorePackage#getViewpointContainer_Viewpoints()
   * @see org.eclipse.egf.model.fcore.Viewpoint#getViewerpointContainer
   * @model opposite="viewerpointContainer" containment="true"
   * @generated
   */
  EList<Viewpoint> getViewpoints();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Viewpoint getViewpoint(Class<?> clazz);

} // ViewpointContainer
