/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildstep;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregate Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getPublishSteps <em>Publish Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getUpdateSiteUrls <em>Update Site Urls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAggregateStep()
 * @model
 * @generated
 */
public interface AggregateStep extends ResultStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






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
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAggregateStep_Id()
     * @model required="true"
     * @generated
     */

    String getId();






    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep#getId <em>Id</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */

    void setId(String value);






    /**
     * Returns the value of the '<em><b>Publish Steps</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Publish Steps</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Publish Steps</em>' reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAggregateStep_PublishSteps()
     * @model
     * @generated
     */

    EList<PublishStep> getPublishSteps();






    /**
     * Returns the value of the '<em><b>Update Site Urls</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Update Site Urls</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Update Site Urls</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getAggregateStep_UpdateSiteUrls()
     * @model
     * @generated
     */

    EList<String> getUpdateSiteUrls();





} // AggregateStep
