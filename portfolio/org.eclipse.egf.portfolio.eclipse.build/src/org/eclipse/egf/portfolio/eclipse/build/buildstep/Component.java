/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildstep;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getBuildStep <em>Build Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getComponent_Id()
     * @model required="true"
     * @generated
     */

    String getId();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getId <em>Id</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */

    void setId(String value);




    /**
     * Returns the value of the '<em><b>Build Step</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getComponents <em>Components</em>}'.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Build Step</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Build Step</em>' container reference.
     * @see #setBuildStep(BuildStep)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getComponent_BuildStep()
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getComponents
     * @model opposite="components" required="true" transient="false"
     * @generated
     */

    BuildStep getBuildStep();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getBuildStep <em>Build Step</em>}' container reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Build Step</em>' container reference.
     * @see #getBuildStep()
     * @generated
     */

    void setBuildStep(BuildStep value);





} // Component
